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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "backEnable", "", "frontEnable", "isBack", "pluginEnable", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setView", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "initConfig", "", "config", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setEnable", "enable", "setIsUseBackCamera", "isBackCamera", "setVisibility", "visibility", "", "plugin-recordvideo_release"})
public final class v
  implements t
{
  public boolean jpZ;
  public boolean sQA;
  private d sQE;
  final e sQF;
  public WeImageView sQK;
  public boolean sQy;
  public boolean sQz;
  
  public v(WeImageView paramWeImageView, d paramd, e parame)
  {
    AppMethodBeat.i(182849);
    this.sQK = paramWeImageView;
    this.sQE = paramd;
    this.sQF = parame;
    this.jpZ = true;
    this.sQA = true;
    this.sQK.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(182844);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.xBy.jpZ)
        {
          paramAnonymousView = this.xBy;
          if (!this.xBy.sQz) {}
          for (bool = true;; bool = false)
          {
            paramAnonymousView.sQz = bool;
            this.xBy.setEnable(this.xBy.sQz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182844);
            return;
          }
        }
        paramAnonymousView = this.xBy;
        if (!this.xBy.sQA) {}
        for (;;)
        {
          paramAnonymousView.sQA = bool;
          this.xBy.setEnable(this.xBy.sQA);
          break;
          bool = false;
        }
      }
    });
    if ((bu.flY()) || (i.IS_FLAVOR_PURPLE)) {
      this.sQK.setOnLongClickListener((View.OnLongClickListener)new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182845);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordBeautifyPlugin$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
          paramAnonymousView = new android.support.design.widget.a(this.xBy.sQK.getContext());
          localObject = paramAnonymousView.getWindow();
          if (localObject != null) {
            ((Window)localObject).clearFlags(2);
          }
          localObject = this.xBy.sQK.getContext();
          p.g(localObject, "view.context");
          localObject = new XLabEffectSettingView((Context)localObject);
          ((XLabEffectSettingView)localObject).setCameraView(this.xBy.sQF);
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
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(182847);
    this.jpZ = paramBoolean;
    if (this.sQy) {
      if (!this.jpZ) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = this.sQz;; paramBoolean = this.sQA)
    {
      setEnable(paramBoolean);
      AppMethodBeat.o(182847);
      return;
    }
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200326);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200326);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(182848);
    Object localObject = c.xHa;
    c.u("KEY_RECORD_IS_BEAUTIFY", Boolean.valueOf(paramBoolean));
    localObject = this.sQK;
    Context localContext;
    if (paramBoolean)
    {
      localContext = this.sQK.getContext();
      p.g(localContext, "view.context");
    }
    for (int i = localContext.getResources().getColor(2131100725);; i = -1)
    {
      ((WeImageView)localObject).setIconColor(i);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("PARAM_BEAUTIFY_ENABLE", paramBoolean);
      this.sQE.a(d.c.xEl, (Bundle)localObject);
      AppMethodBeat.o(182848);
      return;
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(182846);
    if (this.sQy) {
      this.sQK.setVisibility(paramInt);
    }
    AppMethodBeat.o(182846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.v
 * JD-Core Version:    0.7.0.1
 */