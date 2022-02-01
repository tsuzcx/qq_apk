package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoDescPreference
  extends Preference
{
  private LinearLayout fyb;
  private MMActivity imP;
  private MMNeat7extView nkd;
  private boolean paC;
  private ne uFd;
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27495);
  }
  
  public NewBizInfoDescPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.imP = ((MMActivity)paramContext);
    this.paC = false;
    AppMethodBeat.o(27496);
  }
  
  private String oc(boolean paramBoolean)
  {
    AppMethodBeat.i(27498);
    Object localObject = new StringBuilder();
    if (this.uFd.CKS != null)
    {
      String str1 = this.uFd.CKS.CIz;
      String str2 = this.uFd.CKS.CIA;
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
    this.fyb = ((LinearLayout)paramView.findViewById(2131297415));
    this.nkd = ((MMNeat7extView)paramView.findViewById(2131297414));
    this.paC = true;
    if (!this.paC)
    {
      ad.w("MicroMsg.NewBizInfoDescPreference", "bindView:%b or profileInfo is null, return", new Object[] { Boolean.valueOf(this.paC) });
      AppMethodBeat.o(27497);
      return;
    }
    if (this.uFd == null)
    {
      this.fyb.setVisibility(4);
      AppMethodBeat.o(27497);
      return;
    }
    paramView = oc(false);
    if (!bt.isNullOrNil(paramView))
    {
      this.fyb.setVisibility(0);
      this.nkd.aq(paramView);
      int i = this.uFd.CKS.CIw;
      int j = this.uFd.CKS.CIx;
      if ((i > 0) && (j > 0))
      {
        i = com.tencent.mm.cd.a.hV(this.imP);
        j = (int)(com.tencent.mm.cd.a.getDensity(this.imP) * 24.0F);
        paramView = this.nkd.ki(i - j, 2147483647);
        if (paramView == null) {
          break label223;
        }
      }
      label223:
      for (i = paramView.fkV();; i = 0)
      {
        if (i > 1)
        {
          paramView = oc(true);
          this.nkd.aq(paramView);
        }
        AppMethodBeat.o(27497);
        return;
      }
    }
    this.fyb.setVisibility(8);
    AppMethodBeat.o(27497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoDescPreference
 * JD-Core Version:    0.7.0.1
 */