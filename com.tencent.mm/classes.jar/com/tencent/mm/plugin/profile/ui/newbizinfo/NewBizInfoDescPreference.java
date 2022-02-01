package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private MMNeat7extView HdL;
  private pd Hdu;
  private MMActivity iXq;
  private LinearLayout jmn;
  private boolean vkO;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.iXq = ((MMActivity)paramContext);
    this.vkO = false;
    AppMethodBeat.o(27496);
  }
  
  private String we(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.Hdu.RXt != null)
    {
      String str1 = this.Hdu.RXt.RTY;
      String str2 = this.Hdu.RXt.RTZ;
      if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)))
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
      if (!Util.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(27498);
        return localObject;
      }
      if (!Util.isNullOrNil(str2))
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
    this.jmn = ((LinearLayout)paramView.findViewById(R.h.dur));
    this.HdL = ((MMNeat7extView)paramView.findViewById(R.h.duq));
    this.vkO = true;
    if (!this.vkO)
    {
      Log.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.vkO) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.Hdu == null)
    {
      this.jmn.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = we(false);
    if (!Util.isNullOrNil(paramView))
    {
      this.jmn.setVisibility(0);
      this.HdL.aL(paramView);
      int i = this.Hdu.RXt.RTV;
      int j = this.Hdu.RXt.RTW;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.ci.a.kr(this.iXq);
        j = (int)(com.tencent.mm.ci.a.getDensity(this.iXq) * 24.0F);
        paramView = this.HdL.nH(i - j, 2147483647);
        if (paramView == null) {
          break label225;
        }
      }
      label225:
      for (i = paramView.ikp();; i = 0)
      {
        if (i > 1)
        {
          paramView = we(true);
          this.HdL.aL(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.jmn.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */