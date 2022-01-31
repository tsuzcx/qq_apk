package com.tencent.mm.plugin.recordvideo.plugin.parent;

import a.l;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.plugin.j.b;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.k.b;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "editVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoEditPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "revertPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditRevertPlugin;", "sendPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditSendPlugin;", "initLogic", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onPause", "onResume", "release", "reset", "startEditView", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class EditorVideoPluginLayout
  extends BasePluginLayout
  implements d
{
  public static final a qdY;
  private a qdK;
  private final p qdU;
  private final com.tencent.mm.plugin.recordvideo.plugin.j qdV;
  private final k qdW;
  private final o qdX;
  
  static
  {
    AppMethodBeat.i(150806);
    qdY = new a((byte)0);
    AppMethodBeat.o(150806);
  }
  
  public EditorVideoPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150805);
    LayoutInflater.from(paramContext).inflate(2130971064, (ViewGroup)this, true);
    paramContext = findViewById(2131828715);
    a.f.b.j.p(paramContext, "findViewById(R.id.video_play_plugin)");
    this.qdU = new p((VideoPlayerTextureView)paramContext, (d)this);
    paramContext = findViewById(2131828716);
    a.f.b.j.p(paramContext, "findViewById(R.id.edit_btn_revert)");
    this.qdV = new com.tencent.mm.plugin.recordvideo.plugin.j(paramContext, (d)this);
    paramContext = findViewById(2131828717);
    a.f.b.j.p(paramContext, "findViewById(R.id.edit_btn_send)");
    this.qdW = new k(paramContext, (d)this);
    paramContext = findViewById(2131821750);
    a.f.b.j.p(paramContext, "findViewById(R.id.edit_photo_mask)");
    this.qdX = new o(paramContext, (d)this);
    AppMethodBeat.o(150805);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(150801);
    a.f.b.j.q(paramc, "status");
    switch (b.bLo[paramc.ordinal()])
    {
    default: 
      ab.i("MicroMsg.EditorVideoPluginLayout", "unknown status ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(150801);
      return;
    case 1: 
      paramc = this.qdK;
      if (paramc != null)
      {
        paramc.cgh();
        AppMethodBeat.o(150801);
        return;
      }
      AppMethodBeat.o(150801);
      return;
    }
    paramc = this.qdV;
    paramBundle = com.tencent.mm.plugin.mmsight.d.ex(paramc.view.getContext());
    int i = paramc.view.getResources().getDimensionPixelSize(2131428579);
    int j = paramc.view.getResources().getDimensionPixelSize(2131428581);
    paramc.view.setTranslationX(paramBundle.x / 2.0F - j - i / 2.0F);
    paramc.view.setEnabled(false);
    paramc.view.animate().translationX(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new j.b(paramc)).start();
    paramc.view.setVisibility(0);
    paramc = this.qdW;
    paramBundle = com.tencent.mm.plugin.mmsight.d.ex(paramc.view.getContext());
    i = paramc.view.getResources().getDimensionPixelSize(2131428579);
    j = paramc.view.getResources().getDimensionPixelSize(2131428581);
    paramc.view.setTranslationX(-paramBundle.x / 2.0F + j + i / 2.0F);
    paramc.view.setEnabled(false);
    paramc.view.animate().translationX(0.0F).setDuration(200L).setListener((Animator.AnimatorListener)new k.b(paramc)).start();
    paramc.view.setVisibility(0);
    AppMethodBeat.o(150801);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(150803);
    super.onPause();
    this.qdU.onPause();
    AppMethodBeat.o(150803);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(150802);
    super.onResume();
    this.qdU.onResume();
    AppMethodBeat.o(150802);
  }
  
  public final void release()
  {
    AppMethodBeat.i(150804);
    super.release();
    this.qdU.release();
    AppMethodBeat.o(150804);
  }
  
  public final void reset() {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayout
 * JD-Core Version:    0.7.0.1
 */