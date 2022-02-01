package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c
  implements LivingDescBarLayout.b, b.a
{
  LivingStatusLayout DAL;
  LivingDescBarLayout DAM;
  g DAN;
  av DAO;
  int DAP;
  String Dsr;
  
  public c(ViewGroup paramViewGroup, LivingDescBarLayout paramLivingDescBarLayout, av paramav)
  {
    AppMethodBeat.i(202433);
    this.DAP = 0;
    try
    {
      this.DAL = ((LivingStatusLayout)paramViewGroup);
      this.DAM = paramLivingDescBarLayout;
      this.DAO = paramav;
      AppMethodBeat.o(202433);
      return;
    }
    catch (Throwable paramViewGroup)
    {
      AppMethodBeat.o(202433);
    }
  }
  
  private void XX(int paramInt)
  {
    AppMethodBeat.i(202434);
    LivingStatusLayout localLivingStatusLayout = this.DAL;
    if (localLivingStatusLayout != null)
    {
      localLivingStatusLayout.setVisibility(0);
      localLivingStatusLayout.setLiveStatus(paramInt);
    }
    AppMethodBeat.o(202434);
  }
  
  private void XY(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(202436);
    av localav = this.DAO;
    String str;
    int i;
    boolean bool1;
    if (localav != null)
    {
      str = "";
      i = paramInt & 0x7F;
      paramInt = (0xFF00 & paramInt) >> 8;
      if (i == 1) {
        if (paramInt == 2)
        {
          str = getString(2131765957);
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        if (localav.EwI != null) {
          localav.EwI.setText(str);
        }
        try
        {
          label82:
          if (localav.EwI != null)
          {
            localav.EwI.setEnabled(bool1);
            if (bool1)
            {
              localav.EwI.setTextColor(localav.mContext.getResources().getColor(2131100053));
              AppMethodBeat.o(202436);
              return;
              str = getString(2131765969);
              bool1 = bool2;
              continue;
              if (i == 2)
              {
                str = getString(2131765965);
                bool1 = bool2;
                continue;
              }
              bool1 = bool2;
              if (i != 3) {
                continue;
              }
              if (paramInt == 3)
              {
                str = getString(2131765966);
                bool1 = bool2;
                continue;
              }
              str = getString(2131765968);
              bool1 = bool2;
              continue;
            }
            localav.EwI.setTextColor(-7829368);
          }
          AppMethodBeat.o(202436);
          return;
        }
        catch (Throwable localThrowable1) {}
        AppMethodBeat.o(202436);
        return;
      }
      catch (Throwable localThrowable2)
      {
        break label82;
      }
    }
  }
  
  private void eYw()
  {
    AppMethodBeat.i(202435);
    LivingDescBarLayout localLivingDescBarLayout = this.DAM;
    if (localLivingDescBarLayout == null)
    {
      AppMethodBeat.o(202435);
      return;
    }
    if (getCount() == 0)
    {
      localLivingDescBarLayout.setVisibility(4);
      localLivingDescBarLayout.eYt();
      AppMethodBeat.o(202435);
      return;
    }
    localLivingDescBarLayout.setVisibility(0);
    localLivingDescBarLayout.setSlideAdapter(this);
    AppMethodBeat.o(202435);
  }
  
  private void eYx()
  {
    AppMethodBeat.i(202438);
    Object localObject = this.DAM;
    if (localObject != null)
    {
      ((LivingDescBarLayout)localObject).setVisibility(8);
      ((LivingDescBarLayout)localObject).eYt();
    }
    localObject = this.DAL;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    AppMethodBeat.o(202438);
  }
  
  private List<String> eYy()
  {
    int i = this.DAP;
    g localg = this.DAN;
    if (localg != null) {}
    switch (i & 0x7F)
    {
    default: 
      return null;
    case 1: 
      return localg.DrZ;
    case 2: 
      return localg.Dsa;
    }
    return localg.Dsb;
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(202441);
    Object localObject = this.DAM;
    if (localObject != null)
    {
      localObject = ((LivingDescBarLayout)localObject).getContext();
      AppMethodBeat.o(202441);
      return localObject;
    }
    AppMethodBeat.o(202441);
    return null;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(202442);
    Object localObject = getContext();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getString(paramInt);
      AppMethodBeat.o(202442);
      return localObject;
    }
    AppMethodBeat.o(202442);
    return "";
  }
  
  public final String XW(int paramInt)
  {
    AppMethodBeat.i(202440);
    Object localObject = eYy();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (String)((List)localObject).get(paramInt);
      AppMethodBeat.o(202440);
      return localObject;
    }
    AppMethodBeat.o(202440);
    return "";
  }
  
  public final void a(String paramString, g paramg)
  {
    this.Dsr = paramString;
    this.DAN = paramg;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(202444);
    super.finalize();
    Log.d("SnsAd.LivingStatusController", "the SnsAdLivingStatusController is going to be gc:  ".concat(String.valueOf(this)));
    AppMethodBeat.o(202444);
  }
  
  public final void fw(String paramString, int paramInt)
  {
    AppMethodBeat.i(202443);
    if ((this.Dsr.equals(paramString)) && (this.DAP != paramInt)) {
      setLiveStatus(paramInt);
    }
    AppMethodBeat.o(202443);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(202439);
    List localList = eYy();
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(202439);
      return i;
    }
    AppMethodBeat.o(202439);
    return 0;
  }
  
  public final void setLiveStatus(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(202437);
    if (paramInt == this.DAP)
    {
      if (paramInt == 0)
      {
        eYx();
        AppMethodBeat.o(202437);
        return;
      }
      XX(paramInt);
      XY(paramInt);
      Object localObject = this.DAM;
      if (localObject != null)
      {
        localObject = ((LivingDescBarLayout)localObject).DAz;
        paramInt = i;
        if (localObject != null) {
          if (((LivingDescBarLayout.a)localObject).DAD != null)
          {
            paramInt = i;
            if (((LivingDescBarLayout.a)localObject).DAD.getCount() > 0) {}
          }
          else
          {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          eYw();
        }
      }
      AppMethodBeat.o(202437);
      return;
    }
    this.DAP = paramInt;
    if (paramInt == 0)
    {
      eYx();
      AppMethodBeat.o(202437);
      return;
    }
    XX(paramInt);
    XY(paramInt);
    eYw();
    AppMethodBeat.o(202437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.c
 * JD-Core Version:    0.7.0.1
 */