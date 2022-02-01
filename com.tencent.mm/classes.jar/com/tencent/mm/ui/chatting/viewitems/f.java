package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.c;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;

public final class f
{
  static void a(f.a parama, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254952);
    RelativeLayout.LayoutParams localLayoutParams2;
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)parama.aePa.getLayoutParams();
      localLayoutParams1 = (RelativeLayout.LayoutParams)parama.clickArea.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)parama.aeOZ.getLayoutParams();
      localLayoutParams2.topMargin = 0;
      RelativeLayout.LayoutParams localLayoutParams3;
      int j;
      if ((parama.userTV != null) && (parama.userTV.getVisibility() == 0) && (!Util.isNullOrNil(parama.userTV.getText().toString())))
      {
        localLayoutParams3 = (RelativeLayout.LayoutParams)parama.userTV.getLayoutParams();
        localLayoutParams1.addRule(3, R.h.fAr);
        localLayoutParams1.topMargin = 0;
        if (paramInt != 0)
        {
          paramInt -= parama.userTV.getHeight();
          if ((paramInt != 0) && (paramInt != -1) && (paramInt != 1))
          {
            if (paramInt > 0)
            {
              localLayoutParams.topMargin = paramInt;
              localLayoutParams3.topMargin = paramInt;
              localLayoutParams1.topMargin = 0;
            }
          }
          else
          {
            parama.userTV.setLayoutParams(localLayoutParams3);
            int i = parama.aePf;
            if ((parama.userTV != null) && (parama.userTV.getVisibility() == 0) && (!Util.isNullOrNil(parama.userTV.getText().toString())))
            {
              j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 7);
              if (!jxq()) {
                break label392;
              }
              parama.userTV.setIncludeFontPadding(false);
              paramInt = 0;
              label238:
              if ((parama.aeOZ == null) || (parama.aeOZ.getVisibility() != 0)) {
                break label411;
              }
              localLayoutParams3 = (RelativeLayout.LayoutParams)parama.userTV.getLayoutParams();
              if (i != 0) {
                localLayoutParams3.width = i;
              }
              parama.userTV.setLayoutParams(localLayoutParams3);
              parama.userTV.setEllipsize(TextUtils.TruncateAt.END);
              parama.userTV.setPadding(j, 0, 0, paramInt);
            }
          }
        }
      }
      for (;;)
      {
        parama.aePa.setLayoutParams(localLayoutParams);
        parama.clickArea.setLayoutParams(localLayoutParams1);
        parama.aeOZ.setLayoutParams(localLayoutParams2);
        AppMethodBeat.o(254952);
        return;
        localLayoutParams.topMargin = 0;
        localLayoutParams3.topMargin = 0;
        localLayoutParams1.topMargin = 0;
        localLayoutParams2.topMargin = Math.abs(paramInt);
        break;
        localLayoutParams.topMargin = 0;
        localLayoutParams3.topMargin = 0;
        localLayoutParams1.topMargin = 0;
        break;
        label392:
        paramInt = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
        parama.userTV.setIncludeFontPadding(true);
        break label238;
        label411:
        localLayoutParams3 = (RelativeLayout.LayoutParams)parama.userTV.getLayoutParams();
        localLayoutParams3.width = -2;
        parama.userTV.setLayoutParams(localLayoutParams3);
        parama.userTV.setPadding(j, 0, j, paramInt);
        continue;
        localLayoutParams.topMargin = paramInt;
        localLayoutParams1.removeRule(3);
        localLayoutParams1.topMargin = paramInt;
      }
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)parama.aePa.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)parama.clickArea.getLayoutParams();
    if (paramInt != 0)
    {
      localLayoutParams.topMargin = (paramInt - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6));
      localLayoutParams1.topMargin = paramInt;
      if (parama.EpV != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)parama.EpV.getLayoutParams();
        localLayoutParams2.topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        localLayoutParams2.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
        parama.EpV.setLayoutParams(localLayoutParams2);
      }
    }
    for (;;)
    {
      parama.aePa.setLayoutParams(localLayoutParams);
      parama.clickArea.setLayoutParams(localLayoutParams1);
      AppMethodBeat.o(254952);
      return;
      localLayoutParams.topMargin = paramInt;
      localLayoutParams1.topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      if (parama.EpV != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)parama.EpV.getLayoutParams();
        localLayoutParams2.topMargin = 0;
        localLayoutParams2.bottomMargin = 0;
        parama.EpV.setLayoutParams(localLayoutParams2);
      }
    }
  }
  
  static boolean jxq()
  {
    AppMethodBeat.i(254954);
    float f = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
    if ((aw.bc(f, com.tencent.mm.cd.a.mi(MMApplicationContext.getContext()))) || (aw.bc(f, com.tencent.mm.cd.a.mj(MMApplicationContext.getContext()))))
    {
      AppMethodBeat.o(254954);
      return true;
    }
    AppMethodBeat.o(254954);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f
 * JD-Core Version:    0.7.0.1
 */