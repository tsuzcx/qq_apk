package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class v
  implements t
{
  public boolean krh;
  public boolean wgN;
  public boolean wgO;
  public boolean wgP;
  final e wgS;
  public WeImageView wgX;
  private d wgr;
  
  public v(WeImageView paramWeImageView, d paramd, e parame)
  {
    AppMethodBeat.i(182849);
    this.wgX = paramWeImageView;
    this.wgr = paramd;
    this.wgS = parame;
    this.krh = true;
    this.wgP = true;
    this.wgX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(182844);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.BRq.krh)
        {
          paramAnonymousView = this.BRq;
          if (!this.BRq.wgO) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.wgO = bool;
            this.BRq.setEnable(this.BRq.wgO);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182844);
            return;
          }
        }
        paramAnonymousView = this.BRq;
        if (!this.BRq.wgP) {}
        for (;;)
        {
          paramAnonymousView.wgP = bool;
          this.BRq.setEnable(this.BRq.wgP);
          break;
          bool = false;
        }
      }
    });
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      this.wgX.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182845);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
          paramAnonymousView = new android.support.design.widget.a(this.BRq.wgX.getContext());
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.BRq.wgX.getContext();
          p.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.BRq.wgS);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(182845);
          return true;
        }
      });
    }
    AppMethodBeat.o(182849);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(182847);
    this.krh = paramBoolean;
    if (this.wgN) {
      if (!this.krh) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.wgO;; paramBoolean = this.wgP)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(182847);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237303);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237303);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182848);
    Object localObject = c.BXI;
    c.x("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
    localObject = this.wgX;
    Context localContext;
    if (paramBoolean)
    {
      localContext = this.wgX.getContext();
      p.g(localContext, "view.context");
    }
    for (int i = localContext.getResources().getColor(2131100919);; i = -1)
    {
      ((WeImageView)localObject).setIconColor(i);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.wgr.a(d.c.BUF, (Bundle)localObject);
      AppMethodBeat.o(182848);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182846);
    if (this.wgN) {
      this.wgX.setVisibility(paramInt);
    }
    AppMethodBeat.o(182846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */