package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private MMActivity fLP;
  private LinearLayout fUV;
  private MMNeat7extView opC;
  private boolean qhs;
  private oi wVd;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.fLP = ((MMActivity)paramContext);
    this.qhs = false;
    AppMethodBeat.o(27496);
  }
  
  private String pv(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.wVd.FJD != null)
    {
      String str1 = this.wVd.FJD.FGK;
      String str2 = this.wVd.FJD.FGL;
      if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
      {
        ((StringBuilder)localObject).append(str1);
        if (paramBoolean) {
          ((StringBuilder)localObject).append("\n");
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(str2);
          localObject = ((StringBuilder)localObject).toString();
          AppMethodBeat.o(27498);
          return localObject;
          ((StringBuilder)localObject).append("  ");
        }
      }
      if (!bt.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(27498);
        return localObject;
      }
      if (!bt.isNullOrNil(str2))
      {
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(27498);
        return localObject;
      }
    }
    AppMethodBeat.o(27498);
    return "";
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27497);
    this.fUV = ((LinearLayout)paramView.findViewById(2131297415));
    this.opC = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.qhs = true;
    if (!this.qhs)
    {
      ad.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.qhs) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.wVd == null)
    {
      this.fUV.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = pv(false);
    if (!bt.isNullOrNil(paramView))
    {
      this.fUV.setVisibility(0);
      this.opC.ar(paramView);
      int i = this.wVd.FJD.FGH;
      int j = this.wVd.FJD.FGI;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cc.a.ip(this.fLP);
        j = (int)(com.tencent.mm.cc.a.getDensity(this.fLP) * 24.0F);
        paramView = this.opC.kK(i - j, 2147483647);
        if (paramView == null) {
          break label223;
        }
      }
      label223:
      for (i = paramView.fSB();; i = 0)
      {
        if (i > 1)
        {
          paramView = pv(true);
          this.opC.ar(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.fUV.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */