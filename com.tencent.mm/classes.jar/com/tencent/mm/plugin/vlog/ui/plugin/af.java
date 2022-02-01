package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.vlog.ui.widget.RoundCornerAudioWaveView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioImageIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "audioWaveView", "Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "beautyEffectCheck", "Landroid/widget/ImageView;", "beautyEffectIcon", "container", "Landroid/widget/RelativeLayout;", "dimen2A", "", "dimen5A", "isBeautyCheck", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoVisibleRect", "Landroid/graphics/RectF;", "hideBeautySwitch", "", "hideMusicIcon", "isBeautyOpened", "setVisibility", "visibility", "setVisibleRect", "rect", "showBeautySwitch", "enable", "showMusicIcon", "switchVideoEnhancement", "plugin-vlog_release"})
public final class af
  implements t
{
  private RectF CgR;
  private RelativeLayout CgS;
  private final int CgT;
  private final int CgU;
  private final RoundCornerAudioWaveView CgV;
  public final WeImageView CgW;
  final WeImageView CgX;
  final ImageView CgY;
  public boolean CgZ;
  private ViewGroup gsV;
  d tbP;
  
  public af(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(191909);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    this.CgR = new RectF();
    paramViewGroup = this.gsV.findViewById(2131308372);
    p.g(paramViewGroup, "parent.findViewById(R.id…view_decorator_container)");
    this.CgS = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.gsV.getContext();
    p.g(paramViewGroup, "parent.context");
    this.CgT = paramViewGroup.getResources().getDimensionPixelSize(2131165296);
    paramViewGroup = this.gsV.getContext();
    p.g(paramViewGroup, "parent.context");
    this.CgU = paramViewGroup.getResources().getDimensionPixelSize(2131165289);
    paramViewGroup = this.gsV.getContext();
    p.g(paramViewGroup, "parent.context");
    this.CgV = new RoundCornerAudioWaveView(paramViewGroup);
    this.CgW = new WeImageView(this.gsV.getContext());
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addRule(13, -1);
    paramd = this.CgW;
    Context localContext = this.gsV.getContext();
    p.g(localContext, "parent.context");
    paramd.setImageDrawable(localContext.getResources().getDrawable(2131690438));
    this.CgW.setIconColor(-1);
    paramd = this.gsV.getContext();
    p.g(paramd, "parent.context");
    int i = paramd.getResources().getDimensionPixelSize(2131165303);
    paramViewGroup.setMarginEnd(i);
    paramViewGroup.setMarginStart(i);
    paramViewGroup.topMargin = i;
    paramViewGroup.bottomMargin = i;
    this.CgS.addView((View)this.CgW, (ViewGroup.LayoutParams)paramViewGroup);
    exm();
    z.jV(this.gsV.getContext()).inflate(2131496454, (ViewGroup)this.CgS, true);
    paramViewGroup = this.CgS.findViewById(2131307278);
    p.g(paramViewGroup, "container.findViewById(R.id.beauty_effect)");
    this.CgX = ((WeImageView)paramViewGroup);
    paramViewGroup = this.CgS.findViewById(2131307279);
    p.g(paramViewGroup, "container.findViewById(R.id.beauty_effect_check)");
    this.CgY = ((ImageView)paramViewGroup);
    this.CgX.setIconColor(-1);
    paramViewGroup = this.CgY.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(191909);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.addRule(11, -1);
    paramViewGroup.addRule(12, -1);
    this.CgY.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    exn();
    this.CgS.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191904);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        boolean bool;
        if (this.Cha.CgX.isShown())
        {
          paramAnonymousView = this.Cha;
          if (this.Cha.CgZ) {
            break label157;
          }
          bool = true;
          paramAnonymousView.CgZ = bool;
          paramAnonymousView = this.Cha;
          bool = this.Cha.CgZ;
          paramAnonymousView.exm();
          paramAnonymousView.CgX.setVisibility(0);
          if (!bool) {
            break label162;
          }
          paramAnonymousView.CgY.setVisibility(0);
        }
        for (;;)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", bool);
          paramAnonymousView.tbP.a(d.c.xWk, (Bundle)localObject);
          paramAnonymousView.CgZ = bool;
          a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(191904);
          return;
          label157:
          bool = false;
          break;
          label162:
          paramAnonymousView.CgY.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(191909);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  final void exm()
  {
    AppMethodBeat.i(191906);
    this.CgW.setVisibility(8);
    AppMethodBeat.o(191906);
  }
  
  public final void exn()
  {
    AppMethodBeat.i(191907);
    this.CgX.setVisibility(8);
    this.CgY.setVisibility(8);
    AppMethodBeat.o(191907);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(191905);
    p.h(paramRectF, "rect");
    this.CgR.set(paramRectF);
    paramRectF = this.CgS.getLayoutParams();
    if (paramRectF == null)
    {
      paramRectF = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(191905);
      throw paramRectF;
    }
    paramRectF = (ViewGroup.MarginLayoutParams)paramRectF;
    paramRectF.topMargin = ((int)((int)this.CgR.top + this.CgR.height() - this.CgT - this.CgU));
    paramRectF.leftMargin = ((int)(this.CgR.width() + this.CgR.left - this.CgT - this.CgU));
    this.CgS.setLayoutParams((ViewGroup.LayoutParams)paramRectF);
    AppMethodBeat.o(191905);
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
    AppMethodBeat.i(191910);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191910);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191908);
    this.CgS.setVisibility(paramInt);
    AppMethodBeat.o(191908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.af
 * JD-Core Version:    0.7.0.1
 */