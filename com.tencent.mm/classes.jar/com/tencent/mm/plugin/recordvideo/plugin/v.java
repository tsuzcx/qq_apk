package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.a.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "scene", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "checkOnClickByScene", "", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public final class v
  implements View.OnClickListener, u
{
  public static final a HOd;
  private d APl;
  public boolean enable;
  public int scene;
  private ImageView wRg;
  
  static
  {
    AppMethodBeat.i(75612);
    HOd = new a((byte)0);
    AppMethodBeat.o(75612);
  }
  
  public v(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75611);
    this.wRg = paramImageView;
    this.APl = paramd;
    this.wRg.setOnClickListener((View.OnClickListener)this);
    this.wRg.setImageDrawable(au.o(this.wRg.getContext(), b.g.icons_filled_album, -1));
    this.enable = true;
    AppMethodBeat.o(75611);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(224230);
    String str = getClass().getName();
    AppMethodBeat.o(224230);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75610);
    Log.i("MicroMsg.RecordAlbumPlugin", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 1000)
    {
      if (paramInt2 == -1)
      {
        localObject2 = new Bundle();
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
          if (paramIntent == null) {
            break label156;
          }
        }
        label156:
        for (paramIntent = paramIntent.getStringArrayListExtra("key_select_image_list");; paramIntent = null)
        {
          com.tencent.mm.plugin.recordvideo.activity.a.b.a locala = com.tencent.mm.plugin.recordvideo.activity.a.b.HFK;
          ((Bundle)localObject2).putInt("PARAM_ROUTER_INT", com.tencent.mm.plugin.recordvideo.activity.a.b.a.c(-1, (List)paramIntent, (List)localObject1));
          ((Bundle)localObject2).putStringArrayList("PARAM_VIDEO_LIST", (ArrayList)localObject1);
          ((Bundle)localObject2).putStringArrayList("PARAM_PHOTO_LIST", paramIntent);
          this.APl.a(d.c.HRp, (Bundle)localObject2);
          AppMethodBeat.o(75610);
          return;
          localObject1 = null;
          break;
        }
      }
    }
    else if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
        localObject2 = "";
        if (paramIntent == null) {
          break label302;
        }
        localObject1 = Integer.valueOf(paramIntent.size());
        label201:
        if (localObject1 == null) {
          p.iCn();
        }
        if (((Integer)localObject1).intValue() > 0) {
          if (paramIntent == null) {
            break label308;
          }
        }
      }
      label302:
      label308:
      for (paramIntent = (String)paramIntent.get(0);; paramIntent = null)
      {
        p.j(paramIntent, "photoList?.get(0)");
        localObject2 = paramIntent;
        Log.i("MicroMsg.RecordAlbumPlugin", "onActivityResult outputPhotoPath:".concat(String.valueOf(localObject2)));
        CaptureDataManager.HKJ.a(this.wRg.getContext(), new CaptureDataManager.CaptureVideoNormalModel(Boolean.TRUE, "", (String)localObject2, Long.valueOf(-1L), Boolean.TRUE, null));
        AppMethodBeat.o(75610);
        return;
        paramIntent = null;
        break;
        localObject1 = null;
        break label201;
      }
    }
    AppMethodBeat.o(75610);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    boolean bool1 = false;
    AppMethodBeat.i(75608);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    Log.i("MicroMsg.RecordAlbumPlugin", "click RecordAlbumPlugin");
    paramView = new Intent();
    switch (this.scene)
    {
    default: 
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.wRg.getContext();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      break;
    case 15: 
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.HKu.fvO());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      localObject = this.wRg.getContext();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1000, 1, 22, 3, paramView);
      paramView = c.HUw;
      c.fxq().vC(0L);
    }
    for (;;)
    {
      paramView = c.HUw;
      c.acr(4);
      paramView = c.HUw;
      c.fxr().ani();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75608);
      return;
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.HKu.fvO());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGC, false);
      localObject = h.aHG();
      p.j(localObject, "storage()");
      if ((((f)localObject).aHp().getInt(ar.a.Vut, 0) == 1) || (bool2)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          bool1 = true;
        }
        paramView.putExtra("key_can_select_video_and_pic", bool1);
        if (!((a.a)com.tencent.mm.plugin.recordvideo.b.a.a.HKu.aUb()).HKA) {
          break label461;
        }
        localObject = this.wRg.getContext();
        if (localObject != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1000, 9, 22, 3, paramView);
      for (;;)
      {
        paramView = c.HUw;
        c.fxq().vC(0L);
        break;
        label461:
        localObject = this.wRg.getContext();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75608);
          throw paramView;
        }
        com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1000, 1, 22, 2, paramView);
      }
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.wRg.getContext();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1000, 9, 25, 3, paramView);
      continue;
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.wRg.getContext();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1001, 1, 29, 1, paramView);
      continue;
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)localObject, 1000, 1, 23, 3, paramView);
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224238);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(224238);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75609);
    if (this.enable) {
      this.wRg.setVisibility(paramInt);
    }
    AppMethodBeat.o(75609);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin$Companion;", "", "()V", "MEDIA_REQUEST_CODE", "", "MEDIA_REQUEST_JUST_PIC", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */