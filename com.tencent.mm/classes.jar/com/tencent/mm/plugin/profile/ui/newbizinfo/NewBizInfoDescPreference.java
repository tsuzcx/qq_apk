package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private ph BiU;
  private LinearLayout gCh;
  private MMActivity gte;
  private MMNeat7extView pIP;
  private boolean rFe;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.gte = ((MMActivity)paramContext);
    this.rFe = false;
    AppMethodBeat.o(27496);
  }
  
  private String sM(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.BiU.KWf != null)
    {
      String str1 = this.BiU.KWf.KTb;
      String str2 = this.BiU.KWf.KTc;
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
    this.gCh = ((LinearLayout)paramView.findViewById(2131297633));
    this.pIP = ((MMNeat7extView)paramView.findViewById(2131297632));
    this.rFe = true;
    if (!this.rFe)
    {
      Log.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.rFe) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.BiU == null)
    {
      this.gCh.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = sM(false);
    if (!Util.isNullOrNil(paramView))
    {
      this.gCh.setVisibility(0);
      this.pIP.aw(paramView);
      int i = this.BiU.KWf.KSY;
      int j = this.BiU.KWf.KSZ;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cb.a.jn(this.gte);
        j = (int)(com.tencent.mm.cb.a.getDensity(this.gte) * 24.0F);
        paramView = this.pIP.mq(i - j, 2147483647);
        if (paramView == null) {
          break label223;
        }
      }
      label223:
      for (i = paramView.hiG();; i = 0)
      {
        if (i > 1)
        {
          paramView = sM(true);
          this.pIP.aw(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.gCh.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */