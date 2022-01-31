package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private MMActivity cmc;
  private LinearLayout elj;
  private MMNeat7extView kgI;
  private boolean lJS;
  private lj pDf;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23845);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23845);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23846);
    this.cmc = ((MMActivity)paramContext);
    this.lJS = false;
    AppMethodBeat.o(23846);
  }
  
  private String kg(boolean paramBoolean)
  {
    AppMethodBeat.i(23848);
    Object localObject = new StringBuilder();
    if (this.pDf.wzI != null)
    {
      int i = this.pDf.wzI.wxQ;
      int j = this.pDf.wzI.wxR;
      if ((i > 0) && (j > 0))
      {
        ((StringBuilder)localObject).append(String.format(this.cmc.getResources().getString(2131298558), new Object[] { String.valueOf(i) }));
        if (paramBoolean) {
          ((StringBuilder)localObject).append("\n");
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(String.format(this.cmc.getResources().getString(2131298540), new Object[] { String.valueOf(j) }));
          localObject = ((StringBuilder)localObject).toString();
          AppMethodBeat.o(23848);
          return localObject;
          ((StringBuilder)localObject).append("  ");
        }
      }
      if (i > 0)
      {
        ((StringBuilder)localObject).append(String.format(this.cmc.getResources().getString(2131298558), new Object[] { String.valueOf(i) }));
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(23848);
        return localObject;
      }
      if (j > 0)
      {
        ((StringBuilder)localObject).append(String.format(this.cmc.getResources().getString(2131298540), new Object[] { String.valueOf(j) }));
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(23848);
        return localObject;
      }
    }
    AppMethodBeat.o(23848);
    return "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23847);
    this.elj = ((LinearLayout)paramView.findViewById(2131823102));
    this.kgI = ((MMNeat7extView)paramView.findViewById(2131823103));
    this.lJS = true;
    if (!this.lJS)
    {
      ab.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.lJS) });
      AppMethodBeat.o(23847);
      return;
    }
    if (this.pDf == null)
    {
      this.elj.setVisibility(4);
      AppMethodBeat.o(23847);
      return;
    }
    paramView = kg(false);
    if (!bo.isNullOrNil(paramView))
    {
      this.elj.setVisibility(0);
      this.kgI.af(paramView);
      int i = this.pDf.wzI.wxQ;
      int j = this.pDf.wzI.wxR;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cb.a.gw(this.cmc);
        j = (int)(com.tencent.mm.cb.a.getDensity(this.cmc) * 24.0F);
        paramView = this.kgI.Sa(i - j);
        if (paramView == null) {
          break label221;
        }
      }
      label221:
      for (i = paramView.dTo();; i = 0)
      {
        if (i > 1)
        {
          paramView = kg(true);
          this.kgI.af(paramView);
        }
        AppMethodBeat.o(23847);
        return;
      }
    }
    this.elj.setVisibility(8);
    AppMethodBeat.o(23847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */