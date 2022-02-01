package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private LinearLayout fBI;
  private MMActivity iMV;
  private MMNeat7extView nMW;
  private boolean pDN;
  private nl vNU;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.iMV = ((MMActivity)paramContext);
    this.pDN = false;
    AppMethodBeat.o(27496);
  }
  
  private String oW(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.vNU.Edu != null)
    {
      String str1 = this.vNU.Edu.Ebb;
      String str2 = this.vNU.Edu.Ebc;
      if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2)))
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
      if (!bs.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(27498);
        return localObject;
      }
      if (!bs.isNullOrNil(str2))
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
    this.fBI = ((LinearLayout)paramView.findViewById(2131297415));
    this.nMW = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.pDN = true;
    if (!this.pDN)
    {
      ac.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.pDN) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.vNU == null)
    {
      this.fBI.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = oW(false);
    if (!bs.isNullOrNil(paramView))
    {
      this.fBI.setVisibility(0);
      this.nMW.ar(paramView);
      int i = this.vNU.Edu.EaY;
      int j = this.vNU.Edu.EaZ;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cc.a.ig(this.iMV);
        j = (int)(com.tencent.mm.cc.a.getDensity(this.iMV) * 24.0F);
        paramView = this.nMW.kv(i - j, 2147483647);
        if (paramView == null) {
          break label223;
        }
      }
      label223:
      for (i = paramView.fBm();; i = 0)
      {
        if (i > 1)
        {
          paramView = oW(true);
          this.nMW.ar(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.fBI.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */