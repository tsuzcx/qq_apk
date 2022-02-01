package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c
  implements LivingDescBarLayout.b, b.a
{
  g JMA;
  ax JMB;
  int JMC;
  LivingStatusLayout JMy;
  LivingDescBarLayout JMz;
  String JyZ;
  
  public c(ViewGroup paramViewGroup, LivingDescBarLayout paramLivingDescBarLayout, ax paramax)
  {
    AppMethodBeat.i(270198);
    this.JMC = 0;
    try
    {
      this.JMy = ((LivingStatusLayout)paramViewGroup);
      this.JMz = paramLivingDescBarLayout;
      this.JMB = paramax;
      AppMethodBeat.o(270198);
      return;
    }
    catch (Throwable paramViewGroup)
    {
      AppMethodBeat.o(270198);
    }
  }
  
  private void afl(int paramInt)
  {
    AppMethodBeat.i(270201);
    LivingStatusLayout localLivingStatusLayout = this.JMy;
    if (localLivingStatusLayout != null)
    {
      localLivingStatusLayout.setVisibility(0);
      localLivingStatusLayout.setLiveStatus(paramInt);
    }
    AppMethodBeat.o(270201);
  }
  
  private void afm(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(270203);
    ax localax = this.JMB;
    String str;
    int i;
    boolean bool1;
    if (localax != null)
    {
      str = "";
      i = paramInt & 0x7F;
      paramInt = (0xFF00 & paramInt) >> 8;
      if (i == 1) {
        if (paramInt == 2)
        {
          str = getString(i.j.sns_ad_finder_living_notice_subscribed);
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        if (localax.KKA != null) {
          localax.KKA.setText(str);
        }
        try
        {
          label83:
          if (localax.KKA != null)
          {
            localax.KKA.setEnabled(bool1);
            if (bool1)
            {
              localax.KKA.setTextColor(localax.mContext.getResources().getColor(i.c.blue_text_color));
              AppMethodBeat.o(270203);
              return;
              str = getString(i.j.sns_ad_living_subscription);
              bool1 = bool2;
              continue;
              if (i == 2)
              {
                str = getString(i.j.sns_ad_living_enter);
                bool1 = bool2;
                continue;
              }
              bool1 = bool2;
              if (i != 3) {
                continue;
              }
              if (paramInt == 3)
              {
                str = getString(i.j.sns_ad_living_over);
                bool1 = bool2;
                continue;
              }
              str = getString(i.j.sns_ad_living_review);
              bool1 = bool2;
              continue;
            }
            localax.KKA.setTextColor(-7829368);
          }
          AppMethodBeat.o(270203);
          return;
        }
        catch (Throwable localThrowable1) {}
        AppMethodBeat.o(270203);
        return;
      }
      catch (Throwable localThrowable2)
      {
        break label83;
      }
    }
  }
  
  public static boolean afn(int paramInt)
  {
    return (paramInt & 0x7F) == 2;
  }
  
  private void fMg()
  {
    AppMethodBeat.i(270202);
    LivingDescBarLayout localLivingDescBarLayout = this.JMz;
    if (localLivingDescBarLayout == null)
    {
      AppMethodBeat.o(270202);
      return;
    }
    if (getCount() == 0)
    {
      localLivingDescBarLayout.setVisibility(4);
      localLivingDescBarLayout.fMd();
      AppMethodBeat.o(270202);
      return;
    }
    localLivingDescBarLayout.setVisibility(0);
    localLivingDescBarLayout.setSlideAdapter(this);
    AppMethodBeat.o(270202);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(270205);
    Object localObject = this.JMz;
    if (localObject != null)
    {
      ((LivingDescBarLayout)localObject).setVisibility(8);
      ((LivingDescBarLayout)localObject).fMd();
    }
    localObject = this.JMy;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    AppMethodBeat.o(270205);
  }
  
  private List<String> fMi()
  {
    int i = this.JMC;
    g localg = this.JMA;
    if (localg != null) {}
    switch (i & 0x7F)
    {
    default: 
      return null;
    case 1: 
      return localg.Jys;
    case 2: 
      return localg.Jyt;
    }
    return localg.Jyu;
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(270208);
    Object localObject = this.JMz;
    if (localObject != null)
    {
      localObject = ((LivingDescBarLayout)localObject).getContext();
      AppMethodBeat.o(270208);
      return localObject;
    }
    AppMethodBeat.o(270208);
    return null;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(270209);
    Object localObject = getContext();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getString(paramInt);
      AppMethodBeat.o(270209);
      return localObject;
    }
    AppMethodBeat.o(270209);
    return "";
  }
  
  public final void a(String paramString, g paramg)
  {
    this.JyZ = paramString;
    this.JMA = paramg;
  }
  
  public final String afk(int paramInt)
  {
    AppMethodBeat.i(270207);
    Object localObject = fMi();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (String)((List)localObject).get(paramInt);
      AppMethodBeat.o(270207);
      return localObject;
    }
    AppMethodBeat.o(270207);
    return "";
  }
  
  public final void fZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(270210);
    if ((this.JyZ.equals(paramString)) && (this.JMC != paramInt)) {
      setLiveStatus(paramInt);
    }
    AppMethodBeat.o(270210);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(270211);
    super.finalize();
    Log.d("SnsAd.LivingStatusController", "the SnsAdLivingStatusController is going to be gc:  ".concat(String.valueOf(this)));
    AppMethodBeat.o(270211);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(270206);
    List localList = fMi();
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(270206);
      return i;
    }
    AppMethodBeat.o(270206);
    return 0;
  }
  
  public final void setLiveStatus(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(270204);
    if (paramInt == this.JMC)
    {
      if (paramInt == 0)
      {
        fMh();
        AppMethodBeat.o(270204);
        return;
      }
      afl(paramInt);
      afm(paramInt);
      Object localObject = this.JMz;
      if (localObject != null)
      {
        localObject = ((LivingDescBarLayout)localObject).JMm;
        paramInt = i;
        if (localObject != null) {
          if (((LivingDescBarLayout.a)localObject).JMq != null)
          {
            paramInt = i;
            if (((LivingDescBarLayout.a)localObject).JMq.getCount() > 0) {}
          }
          else
          {
            paramInt = 1;
          }
        }
        if (paramInt != 0) {
          fMg();
        }
      }
      AppMethodBeat.o(270204);
      return;
    }
    this.JMC = paramInt;
    if (paramInt == 0)
    {
      fMh();
      AppMethodBeat.o(270204);
      return;
    }
    afl(paramInt);
    afm(paramInt);
    fMg();
    AppMethodBeat.o(270204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.c
 * JD-Core Version:    0.7.0.1
 */