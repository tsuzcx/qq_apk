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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioImageIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "audioWaveView", "Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "beautyEffectCheck", "Landroid/widget/ImageView;", "beautyEffectIcon", "container", "Landroid/widget/RelativeLayout;", "dimen2A", "", "dimen5A", "isBeautyCheck", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "videoVisibleRect", "Landroid/graphics/RectF;", "hideBeautySwitch", "", "hideMusicIcon", "isBeautyOpened", "setVisibility", "visibility", "setVisibleRect", "rect", "showBeautySwitch", "enable", "showMusicIcon", "switchVideoEnhancement", "plugin-vlog_release"})
public final class af
  implements t
{
  public boolean BPA;
  private RectF BPs;
  private RelativeLayout BPt;
  private final int BPu;
  private final int BPv;
  private final RoundCornerAudioWaveView BPw;
  public final WeImageView BPx;
  final WeImageView BPy;
  final ImageView BPz;
  private ViewGroup gqv;
  d sQE;
  
  public af(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(196450);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    this.BPs = new RectF();
    paramViewGroup = this.gqv.findViewById(2131308372);
    p.g(paramViewGroup, "parent.findViewById(R.id…view_decorator_container)");
    this.BPt = ((RelativeLayout)paramViewGroup);
    paramViewGroup = this.gqv.getContext();
    p.g(paramViewGroup, "parent.context");
    this.BPu = paramViewGroup.getResources().getDimensionPixelSize(2131165296);
    paramViewGroup = this.gqv.getContext();
    p.g(paramViewGroup, "parent.context");
    this.BPv = paramViewGroup.getResources().getDimensionPixelSize(2131165289);
    paramViewGroup = this.gqv.getContext();
    p.g(paramViewGroup, "parent.context");
    this.BPw = new RoundCornerAudioWaveView(paramViewGroup);
    this.BPx = new WeImageView(this.gqv.getContext());
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
    paramViewGroup.addRule(13, -1);
    paramd = this.BPx;
    Context localContext = this.gqv.getContext();
    p.g(localContext, "parent.context");
    paramd.setImageDrawable(localContext.getResources().getDrawable(2131690438));
    this.BPx.setIconColor(-1);
    paramd = this.gqv.getContext();
    p.g(paramd, "parent.context");
    int i = paramd.getResources().getDimensionPixelSize(2131165303);
    paramViewGroup.setMarginEnd(i);
    paramViewGroup.setMarginStart(i);
    paramViewGroup.topMargin = i;
    paramViewGroup.bottomMargin = i;
    this.BPt.addView((View)this.BPx, (ViewGroup.LayoutParams)paramViewGroup);
    etF();
    z.jO(this.gqv.getContext()).inflate(2131496454, (ViewGroup)this.BPt, true);
    paramViewGroup = this.BPt.findViewById(2131307278);
    p.g(paramViewGroup, "container.findViewById(R.id.beauty_effect)");
    this.BPy = ((WeImageView)paramViewGroup);
    paramViewGroup = this.BPt.findViewById(2131307279);
    p.g(paramViewGroup, "container.findViewById(R.id.beauty_effect_check)");
    this.BPz = ((ImageView)paramViewGroup);
    this.BPy.setIconColor(-1);
    paramViewGroup = this.BPz.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(196450);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.addRule(11, -1);
    paramViewGroup.addRule(12, -1);
    this.BPz.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    etG();
    this.BPt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196445);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        boolean bool;
        if (this.BPB.BPy.isShown())
        {
          paramAnonymousView = this.BPB;
          if (this.BPB.BPA) {
            break label157;
          }
          bool = true;
          paramAnonymousView.BPA = bool;
          paramAnonymousView = this.BPB;
          bool = this.BPB.BPA;
          paramAnonymousView.etF();
          paramAnonymousView.BPy.setVisibility(0);
          if (!bool) {
            break label162;
          }
          paramAnonymousView.BPz.setVisibility(0);
        }
        for (;;)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("PARAM_1_BOOLEAN", bool);
          paramAnonymousView.sQE.a(d.c.xGp, (Bundle)localObject);
          paramAnonymousView.BPA = bool;
          a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/VideoPreviewDecorationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(196445);
          return;
          label157:
          bool = false;
          break;
          label162:
          paramAnonymousView.BPz.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(196450);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  final void etF()
  {
    AppMethodBeat.i(196447);
    this.BPx.setVisibility(8);
    AppMethodBeat.o(196447);
  }
  
  public final void etG()
  {
    AppMethodBeat.i(196448);
    this.BPy.setVisibility(8);
    this.BPz.setVisibility(8);
    AppMethodBeat.o(196448);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(196446);
    p.h(paramRectF, "rect");
    this.BPs.set(paramRectF);
    paramRectF = this.BPt.getLayoutParams();
    if (paramRectF == null)
    {
      paramRectF = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(196446);
      throw paramRectF;
    }
    paramRectF = (ViewGroup.MarginLayoutParams)paramRectF;
    paramRectF.topMargin = ((int)((int)this.BPs.top + this.BPs.height() - this.BPu - this.BPv));
    paramRectF.leftMargin = ((int)(this.BPs.width() + this.BPs.left - this.BPu - this.BPv));
    this.BPt.setLayoutParams((ViewGroup.LayoutParams)paramRectF);
    AppMethodBeat.o(196446);
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
    AppMethodBeat.i(196451);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196451);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196449);
    this.BPt.setVisibility(paramInt);
    AppMethodBeat.o(196449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.af
 * JD-Core Version:    0.7.0.1
 */