package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.b.a.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "scene", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "checkOnClickByScene", "", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public final class u
  implements View.OnClickListener, t
{
  public static final u.a BRp;
  public boolean enable;
  public int scene;
  private ImageView tkI;
  private d wgr;
  
  static
  {
    AppMethodBeat.i(75612);
    BRp = new u.a((byte)0);
    AppMethodBeat.o(75612);
  }
  
  public u(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75611);
    this.tkI = paramImageView;
    this.wgr = paramd;
    this.tkI.setOnClickListener((View.OnClickListener)this);
    this.tkI.setImageDrawable(ar.m(this.tkI.getContext(), 2131690479, -1));
    this.enable = true;
    AppMethodBeat.o(75611);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    AppMethodBeat.i(75610);
    Log.i("MicroMsg.RecordAlbumPlugin", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      Bundle localBundle = new Bundle();
      if (paramIntent != null) {}
      for (ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("key_select_video_list");; localArrayList1 = null)
      {
        if (paramIntent != null) {
          localArrayList2 = paramIntent.getStringArrayListExtra("key_select_image_list");
        }
        paramIntent = com.tencent.mm.plugin.recordvideo.activity.a.b.BJA;
        localBundle.putInt("PARAM_ROUTER_INT", com.tencent.mm.plugin.recordvideo.activity.a.b.a.c(-1, (List)localArrayList2, (List)localArrayList1));
        localBundle.putStringArrayList("PARAM_VIDEO_LIST", localArrayList1);
        localBundle.putStringArrayList("PARAM_PHOTO_LIST", localArrayList2);
        this.wgr.a(d.c.BUE, localBundle);
        AppMethodBeat.o(75610);
        return;
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    Log.i("MicroMsg.RecordAlbumPlugin", "click RecordAlbumPlugin");
    paramView = new Intent();
    switch (this.scene)
    {
    default: 
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.tkI.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      break;
    case 15: 
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJE());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      localObject = this.tkI.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      s.a((Activity)localObject, 1000, 1, 22, 3, paramView);
      paramView = c.BXI;
      c.eKX().rA(0L);
    }
    for (;;)
    {
      paramView = c.BXI;
      c.VI(4);
      paramView = c.BXI;
      c.eKY().ahM();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75608);
      return;
      paramView.putExtra("key_edit_video_max_time_length", com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJE());
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZC, false);
      localObject = g.aAh();
      p.g(localObject, "storage()");
      if ((((e)localObject).azQ().getInt(ar.a.Ogd, 0) == 1) || (bool2)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          bool1 = true;
        }
        paramView.putExtra("key_can_select_video_and_pic", bool1);
        if (!((a.a)com.tencent.mm.plugin.recordvideo.b.a.a.BNL.aLT()).BNR) {
          break label430;
        }
        localObject = this.tkI.getContext();
        if (localObject != null) {
          break;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      s.a((Activity)localObject, 1000, 9, 22, 3, paramView);
      for (;;)
      {
        paramView = c.BXI;
        c.eKX().rA(0L);
        break;
        label430:
        localObject = this.tkI.getContext();
        if (localObject == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75608);
          throw paramView;
        }
        s.a((Activity)localObject, 1000, 1, 22, 2, paramView);
      }
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.tkI.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      s.a((Activity)localObject, 1000, 9, 25, 3, paramView);
      continue;
      s.a((Activity)localObject, 1000, 1, 23, 3, paramView);
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237302);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237302);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75609);
    if (this.enable) {
      this.tkI.setVisibility(paramInt);
    }
    AppMethodBeat.o(75609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.u
 * JD-Core Version:    0.7.0.1
 */