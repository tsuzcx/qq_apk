package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.activity.a.b.a;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.c.a.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "scene", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "checkOnClickByScene", "", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements View.OnClickListener, v
{
  public static final w.a NKS;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private ImageView cqj;
  public boolean enable;
  public int scene;
  
  static
  {
    AppMethodBeat.i(75612);
    NKS = new w.a((byte)0);
    AppMethodBeat.o(75612);
  }
  
  public w(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75611);
    this.cqj = paramImageView;
    this.GrC = parama;
    this.cqj.setOnClickListener((View.OnClickListener)this);
    this.cqj.setImageDrawable(bb.m(this.cqj.getContext(), b.g.icons_filled_album, -1));
    this.enable = true;
    AppMethodBeat.o(75611);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280623);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280623);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280640);
    s.u(this, "this");
    AppMethodBeat.o(280640);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280631);
    String str = v.a.b(this);
    AppMethodBeat.o(280631);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75610);
    s.u((v)this, "this");
    Log.i("MicroMsg.RecordAlbumPlugin", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject2;
    Object localObject1;
    label182:
    do
    {
      do
      {
        AppMethodBeat.o(75610);
        return;
      } while (paramInt2 != -1);
      localObject2 = new Bundle();
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label182;
        }
      }
      for (paramIntent = null;; paramIntent = paramIntent.getStringArrayListExtra("key_select_image_list"))
      {
        b.a locala = com.tencent.mm.plugin.recordvideo.activity.a.b.NDm;
        ((Bundle)localObject2).putInt("PARAM_ROUTER_INT", b.a.c(-1, (List)paramIntent, (List)localObject1));
        ((Bundle)localObject2).putStringArrayList("PARAM_VIDEO_LIST", (ArrayList)localObject1);
        ((Bundle)localObject2).putStringArrayList("PARAM_PHOTO_LIST", paramIntent);
        this.GrC.a(a.c.NNV, (Bundle)localObject2);
        AppMethodBeat.o(75610);
        return;
        localObject1 = paramIntent.getStringArrayListExtra("key_select_video_list");
        break;
      }
    } while (paramInt2 != -1);
    if (paramIntent == null)
    {
      paramIntent = null;
      localObject2 = "";
      if (paramIntent != null) {
        break label308;
      }
      localObject1 = null;
      label214:
      s.checkNotNull(localObject1);
      if (((Integer)localObject1).intValue() > 0) {
        if (paramIntent != null) {
          break label320;
        }
      }
    }
    label308:
    label320:
    for (paramIntent = null;; paramIntent = (String)paramIntent.get(0))
    {
      s.s(paramIntent, "photoList?.get(0)");
      localObject2 = paramIntent;
      Log.i("MicroMsg.RecordAlbumPlugin", s.X("onActivityResult outputPhotoPath:", localObject2));
      CaptureDataManager.NHH.a(this.cqj.getContext(), new CaptureDataManager.CaptureVideoNormalModel(Boolean.TRUE, "", (String)localObject2, Long.valueOf(-1L), Boolean.TRUE, null));
      AppMethodBeat.o(75610);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
      break;
      localObject1 = Integer.valueOf(paramIntent.size());
      break label214;
    }
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280648);
    s.u(this, "this");
    AppMethodBeat.o(280648);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75608);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    Log.i("MicroMsg.RecordAlbumPlugin", "click RecordAlbumPlugin");
    paramView = new Intent();
    switch (this.scene)
    {
    default: 
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.cqj.getContext();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      break;
    case 15: 
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.c.a.a.NHs.gHD());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      localObject = this.cqj.getContext();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      t.a((Activity)localObject, 1000, 1, 22, 3, false, paramView);
      paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJf().iHM = 0L;
    }
    for (;;)
    {
      paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.agH(4);
      paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.gJg().jkW = 1L;
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75608);
      return;
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.c.a.a.NHs.gHD());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWx, false);
      int i;
      if ((h.baE().ban().getInt(at.a.acWc, 0) == 1) || (bool))
      {
        i = 1;
        if (i != 0) {
          break label411;
        }
      }
      label411:
      for (bool = true;; bool = false)
      {
        paramView.putExtra("key_can_select_video_and_pic", bool);
        if (!((a.a)com.tencent.mm.plugin.recordvideo.c.a.a.NHs.boF()).NHC) {
          break label448;
        }
        localObject = this.cqj.getContext();
        if (localObject != null) {
          break label416;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
        i = 0;
        break;
      }
      label416:
      t.a((Activity)localObject, 1000, 9, 22, 3, false, paramView);
      for (;;)
      {
        paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.gJf().iHM = 0L;
        break;
        label448:
        localObject = this.cqj.getContext();
        if (localObject == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75608);
          throw paramView;
        }
        t.a((Activity)localObject, 1000, 1, 22, 2, false, paramView);
      }
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.cqj.getContext();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      t.a((Activity)localObject, 1000, 9, 25, 3, false, paramView);
      continue;
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.cqj.getContext();
      if (localObject == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      t.a((Activity)localObject, 1001, 1, 29, 1, false, paramView);
      continue;
      t.a((Activity)localObject, 1000, 1, 23, 3, false, paramView);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280657);
    s.u(this, "this");
    AppMethodBeat.o(280657);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280664);
    s.u(this, "this");
    AppMethodBeat.o(280664);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280674);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280674);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280684);
    s.u(this, "this");
    AppMethodBeat.o(280684);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280691);
    s.u(this, "this");
    AppMethodBeat.o(280691);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280697);
    s.u(this, "this");
    AppMethodBeat.o(280697);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75609);
    if (this.enable) {
      this.cqj.setVisibility(paramInt);
    }
    AppMethodBeat.o(75609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */