package com.tencent.mm.plugin.recordvideo.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recordvideo.b.a.a;
import com.tencent.mm.plugin.recordvideo.b.a.a.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordAlbumPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "enable", "", "scene", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/widget/ImageView;", "setView", "(Landroid/widget/ImageView;)V", "checkOnClickByScene", "", "initConfig", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public final class v
  implements View.OnClickListener, t
{
  public static final v.a wtB;
  public boolean enable;
  private ImageView qSI;
  private d rTT;
  public int scene;
  
  static
  {
    AppMethodBeat.i(75612);
    wtB = new v.a((byte)0);
    AppMethodBeat.o(75612);
  }
  
  public v(ImageView paramImageView, d paramd)
  {
    AppMethodBeat.i(75611);
    this.qSI = paramImageView;
    this.rTT = paramd;
    this.qSI.setOnClickListener((View.OnClickListener)this);
    this.qSI.setImageDrawable(am.k(this.qSI.getContext(), 2131690348, -1));
    this.enable = true;
    AppMethodBeat.o(75611);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    AppMethodBeat.i(75610);
    ac.i("MicroMsg.RecordAlbumPlugin", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      Bundle localBundle = new Bundle();
      if (paramIntent != null) {}
      for (ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("key_select_video_list");; localArrayList1 = null)
      {
        if (paramIntent != null) {
          localArrayList2 = paramIntent.getStringArrayListExtra("key_select_image_list");
        }
        paramIntent = com.tencent.mm.plugin.recordvideo.activity.a.b.wlE;
        localBundle.putInt("PARAM_ROUTER_INT", com.tencent.mm.plugin.recordvideo.activity.a.b.a.c(-1, (List)localArrayList2, (List)localArrayList1));
        localBundle.putStringArrayList("PARAM_VIDEO_LIST", localArrayList1);
        localBundle.putStringArrayList("PARAM_PHOTO_LIST", localArrayList2);
        this.rTT.a(d.c.wwc, localBundle);
        AppMethodBeat.o(75610);
        return;
      }
    }
    AppMethodBeat.o(75610);
  }
  
  public final void onClick(View paramView)
  {
    boolean bool1 = false;
    AppMethodBeat.i(75608);
    ac.i("MicroMsg.RecordAlbumPlugin", "click RecordAlbumPlugin");
    paramView = new Intent();
    Object localObject;
    switch (this.scene)
    {
    default: 
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.qSI.getContext();
      if (localObject == null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      break;
    case 3: 
      paramView.putExtra("key_edit_video_max_time_length", ((a.a)a.wpS.aqp()).wqc);
      paramView.putExtra("key_edit_text_color", "#0E9CE6");
      boolean bool2 = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUC, false);
      localObject = g.agR();
      k.g(localObject, "storage()");
      if ((((e)localObject).agA().getInt(ah.a.GQK, 0) == 1) || (bool2)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          bool1 = true;
        }
        paramView.putExtra("key_can_select_video_and_pic", bool1);
        if (!((a.a)a.wpS.aqp()).wpY) {
          break label295;
        }
        localObject = this.qSI.getContext();
        if (localObject != null) {
          break;
        }
        paramView = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      q.a((Activity)localObject, 1000, 9, 22, 3, paramView);
      paramView = c.wyg;
      c.dwr().iB(0L);
    }
    for (;;)
    {
      paramView = c.wyg;
      c.Mo(4);
      paramView = c.wyg;
      c.dws().RK();
      AppMethodBeat.o(75608);
      return;
      label295:
      localObject = this.qSI.getContext();
      if (localObject == null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      q.a((Activity)localObject, 1000, 1, 22, 2, paramView);
      break;
      paramView.putExtra("album_business_tag", "album_business_media");
      localObject = this.qSI.getContext();
      if (localObject == null)
      {
        paramView = new d.v("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(75608);
        throw paramView;
      }
      q.a((Activity)localObject, 1000, 9, 25, 3, paramView);
      continue;
      q.a((Activity)localObject, 1000, 1, 23, 3, paramView);
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75609);
    if (this.enable) {
      this.qSI.setVisibility(paramInt);
    }
    AppMethodBeat.o(75609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */