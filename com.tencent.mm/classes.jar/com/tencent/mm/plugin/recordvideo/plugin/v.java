package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import com.tencent.mm.plugin.recordvideo.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class v
  implements t
{
  public boolean iwN;
  private d vjo;
  public boolean vkU;
  public boolean vkV;
  public boolean vkW;
  public WeImageView vkX;
  final e vkY;
  
  public v(WeImageView paramWeImageView, d paramd, e parame)
  {
    AppMethodBeat.i(182849);
    this.vkX = paramWeImageView;
    this.vjo = paramd;
    this.vkY = parame;
    this.iwN = true;
    this.vkW = true;
    this.vkX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool2 = true;
        boolean bool1 = true;
        AppMethodBeat.i(182844);
        if (this.vkZ.iwN)
        {
          paramAnonymousView = this.vkZ;
          if (!this.vkZ.vkV) {}
          for (;;)
          {
            paramAnonymousView.vkV = bool1;
            this.vkZ.setEnable(this.vkZ.vkV);
            AppMethodBeat.o(182844);
            return;
            bool1 = false;
          }
        }
        paramAnonymousView = this.vkZ;
        if (!this.vkZ.vkW) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.vkW = bool1;
          this.vkZ.setEnable(this.vkZ.vkW);
          AppMethodBeat.o(182844);
          return;
        }
      }
    });
    if ((bu.eGT()) || (h.IS_FLAVOR_PURPLE)) {
      this.vkX.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182845);
          paramAnonymousView = new a(this.vkZ.vkX.getContext());
          Object localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.vkZ.vkX.getContext();
          k.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.vkZ.vkY);
          paramAnonymousView.setContentView((View)localObject);
          paramAnonymousView.show();
          AppMethodBeat.o(182845);
          return true;
        }
      });
    }
    AppMethodBeat.o(182849);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void ot(boolean paramBoolean)
  {
    AppMethodBeat.i(182847);
    this.iwN = paramBoolean;
    if (this.vkU) {
      if (!this.iwN) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.vkV;; paramBoolean = this.vkW)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(182847);
      return;
    }
  }
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182848);
    Object localObject = b.vpp;
    b.v("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
    localObject = this.vkX;
    Context localContext;
    if (paramBoolean)
    {
      localContext = this.vkX.getContext();
      k.g(localContext, "view.context");
    }
    for (int i = localContext.getResources().getColor(2131100725);; i = -1)
    {
      ((WeImageView)localObject).setIconColor(i);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.vjo.a(d.c.vnC, (Bundle)localObject);
      AppMethodBeat.o(182848);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182846);
    if (this.vkU) {
      this.vkX.setVisibility(paramInt);
    }
    AppMethodBeat.o(182846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */