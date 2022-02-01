package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  implements v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public boolean GsA;
  public boolean GsB;
  public boolean Gsz;
  public WeImageView NKT;
  private final com.tencent.mm.media.widget.camerarecordview.preview.b NKU;
  public boolean qgg;
  
  public x(WeImageView paramWeImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, com.tencent.mm.media.widget.camerarecordview.preview.b paramb)
  {
    AppMethodBeat.i(182849);
    this.NKT = paramWeImageView;
    this.GrC = parama;
    this.NKU = paramb;
    this.qgg = true;
    this.GsB = true;
    this.NKT.setOnClickListener(new x..ExternalSyntheticLambda0(this));
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      this.NKT.setOnLongClickListener(new x..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(182849);
  }
  
  private static final void a(x paramx, View paramView)
  {
    boolean bool = true;
    AppMethodBeat.i(280586);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramx);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramx, "this$0");
    if (paramx.qgg)
    {
      if (!paramx.GsA) {}
      for (bool = true;; bool = false)
      {
        paramx.GsA = bool;
        paramx.setEnable(paramx.GsA);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(280586);
        return;
      }
    }
    if (!paramx.GsB) {}
    for (;;)
    {
      paramx.GsB = bool;
      paramx.setEnable(paramx.GsB);
      break;
      bool = false;
    }
  }
  
  private static final boolean b(x paramx, View paramView)
  {
    AppMethodBeat.i(280593);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramx);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramx, "this$0");
    paramView = new com.google.android.material.bottomsheet.a(paramx.NKT.getContext());
    localObject = paramView.getWindow();
    if (localObject != null) {
      ((Window)localObject).clearFlags(2);
    }
    localObject = paramx.NKT.getContext();
    s.s(localObject, "view.context");
    localObject = new XLabEffectSettingView((Context)localObject);
    ((XLabEffectSettingView)localObject).setCameraView(paramx.NKU);
    paramx = ah.aiuX;
    paramView.setContentView((View)localObject);
    paramView.show();
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(280593);
    return true;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280632);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280632);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280658);
    s.u(this, "this");
    AppMethodBeat.o(280658);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280641);
    String str = v.a.b(this);
    AppMethodBeat.o(280641);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280649);
    s.u(this, "this");
    AppMethodBeat.o(280649);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280666);
    s.u(this, "this");
    AppMethodBeat.o(280666);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280675);
    s.u(this, "this");
    AppMethodBeat.o(280675);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280683);
    s.u(this, "this");
    AppMethodBeat.o(280683);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280690);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280690);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280695);
    s.u(this, "this");
    AppMethodBeat.o(280695);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280703);
    s.u(this, "this");
    AppMethodBeat.o(280703);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280704);
    s.u(this, "this");
    AppMethodBeat.o(280704);
  }
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182848);
    Object localObject = c.NRf;
    c.I("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
    localObject = this.NKT;
    if (paramBoolean) {}
    for (int i = this.NKT.getContext().getResources().getColor(b.b.orange_100);; i = -1)
    {
      ((WeImageView)localObject).setIconColor(i);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.GrC.a(a.c.NNW, (Bundle)localObject);
      AppMethodBeat.o(182848);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182846);
    if (this.Gsz) {
      this.NKT.setVisibility(paramInt);
    }
    AppMethodBeat.o(182846);
  }
  
  public final void uK(boolean paramBoolean)
  {
    AppMethodBeat.i(182847);
    this.qgg = paramBoolean;
    if (this.Gsz) {
      if (!this.qgg) {
        break label42;
      }
    }
    label42:
    for (paramBoolean = this.GsA;; paramBoolean = this.GsB)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(182847);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x
 * JD-Core Version:    0.7.0.1
 */