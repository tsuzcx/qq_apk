package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private MMActivity fNT;
  private LinearLayout fXb;
  private MMNeat7extView ovu;
  private boolean qnX;
  private ok xkU;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.fNT = ((MMActivity)paramContext);
    this.qnX = false;
    AppMethodBeat.o(27496);
  }
  
  private String pD(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.xkU.Gcc != null)
    {
      String str1 = this.xkU.Gcc.FZg;
      String str2 = this.xkU.Gcc.FZh;
      if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2)))
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
      if (!bu.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(27498);
        return localObject;
      }
      if (!bu.isNullOrNil(str2))
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
    this.fXb = ((LinearLayout)paramView.findViewById(2131297415));
    this.ovu = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.qnX = true;
    if (!this.qnX)
    {
      ae.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.qnX) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.xkU == null)
    {
      this.fXb.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = pD(false);
    if (!bu.isNullOrNil(paramView))
    {
      this.fXb.setVisibility(0);
      this.ovu.aq(paramView);
      int i = this.xkU.Gcc.FZd;
      int j = this.xkU.Gcc.FZe;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cb.a.iu(this.fNT);
        j = (int)(com.tencent.mm.cb.a.getDensity(this.fNT) * 24.0F);
        paramView = this.ovu.kR(i - j, 2147483647);
        if (paramView == null) {
          break label223;
        }
      }
      label223:
      for (i = paramView.fXb();; i = 0)
      {
        if (i > 1)
        {
          paramView = pD(true);
          this.ovu.aq(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.fXb.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */