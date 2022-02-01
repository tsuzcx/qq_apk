package com.tencent.mm.plugin.sns.ad.widget.living;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class c
  implements LivingDescBarLayout.b, b.a
{
  String PNx;
  LivingStatusLayout Qhb;
  LivingDescBarLayout Qhc;
  i Qhd;
  ay Qhe;
  int Qhf;
  
  public c(ViewGroup paramViewGroup, LivingDescBarLayout paramLivingDescBarLayout, ay paramay)
  {
    AppMethodBeat.i(310366);
    this.Qhf = 0;
    try
    {
      this.Qhb = ((LivingStatusLayout)paramViewGroup);
      this.Qhc = paramLivingDescBarLayout;
      this.Qhe = paramay;
      return;
    }
    finally
    {
      AppMethodBeat.o(310366);
    }
  }
  
  private void ajX(int paramInt)
  {
    AppMethodBeat.i(310376);
    LivingStatusLayout localLivingStatusLayout = this.Qhb;
    if (localLivingStatusLayout != null)
    {
      localLivingStatusLayout.setVisibility(0);
      localLivingStatusLayout.setLiveStatus(paramInt);
    }
    AppMethodBeat.o(310376);
  }
  
  /* Error */
  private void ajY(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc 56
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 42	com/tencent/mm/plugin/sns/ad/widget/living/c:Qhe	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +73 -> 89
    //   19: ldc 58
    //   21: astore 5
    //   23: iload_1
    //   24: bipush 127
    //   26: iand
    //   27: istore_2
    //   28: ldc 59
    //   30: iload_1
    //   31: iand
    //   32: bipush 8
    //   34: ishr
    //   35: istore_1
    //   36: iload_2
    //   37: iconst_1
    //   38: if_icmpne +72 -> 110
    //   41: iload_1
    //   42: iconst_2
    //   43: if_icmpne +52 -> 95
    //   46: aload_0
    //   47: getstatic 64	com/tencent/mm/plugin/sns/b$j:sns_ad_finder_living_notice_subscribed	I
    //   50: invokespecial 68	com/tencent/mm/plugin/sns/ad/widget/living/c:getString	(I)Ljava/lang/String;
    //   53: astore 5
    //   55: iconst_0
    //   56: istore_3
    //   57: aload 5
    //   59: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifne +27 -> 89
    //   65: aload 6
    //   67: getfield 80	com/tencent/mm/plugin/sns/ui/ay:Rkc	Landroid/widget/Button;
    //   70: ifnull +13 -> 83
    //   73: aload 6
    //   75: getfield 80	com/tencent/mm/plugin/sns/ui/ay:Rkc	Landroid/widget/Button;
    //   78: aload 5
    //   80: invokevirtual 86	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   83: aload 6
    //   85: iload_3
    //   86: invokevirtual 90	com/tencent/mm/plugin/sns/ui/ay:Ed	(Z)V
    //   89: ldc 56
    //   91: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_0
    //   96: getstatic 93	com/tencent/mm/plugin/sns/b$j:sns_ad_living_subscription	I
    //   99: invokespecial 68	com/tencent/mm/plugin/sns/ad/widget/living/c:getString	(I)Ljava/lang/String;
    //   102: astore 5
    //   104: iload 4
    //   106: istore_3
    //   107: goto -50 -> 57
    //   110: iload_2
    //   111: iconst_2
    //   112: if_icmpne +18 -> 130
    //   115: aload_0
    //   116: getstatic 96	com/tencent/mm/plugin/sns/b$j:sns_ad_living_enter	I
    //   119: invokespecial 68	com/tencent/mm/plugin/sns/ad/widget/living/c:getString	(I)Ljava/lang/String;
    //   122: astore 5
    //   124: iload 4
    //   126: istore_3
    //   127: goto -70 -> 57
    //   130: iload 4
    //   132: istore_3
    //   133: iload_2
    //   134: iconst_3
    //   135: if_icmpne -78 -> 57
    //   138: iload_1
    //   139: iconst_3
    //   140: if_icmpne +18 -> 158
    //   143: aload_0
    //   144: getstatic 99	com/tencent/mm/plugin/sns/b$j:sns_ad_living_over	I
    //   147: invokespecial 68	com/tencent/mm/plugin/sns/ad/widget/living/c:getString	(I)Ljava/lang/String;
    //   150: astore 5
    //   152: iload 4
    //   154: istore_3
    //   155: goto -98 -> 57
    //   158: aload_0
    //   159: getstatic 102	com/tencent/mm/plugin/sns/b$j:sns_ad_living_review	I
    //   162: invokespecial 68	com/tencent/mm/plugin/sns/ad/widget/living/c:getString	(I)Ljava/lang/String;
    //   165: astore 5
    //   167: iload 4
    //   169: istore_3
    //   170: goto -113 -> 57
    //   173: astore 5
    //   175: goto -92 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	c
    //   0	178	1	paramInt	int
    //   27	109	2	i	int
    //   56	114	3	bool1	boolean
    //   1	167	4	bool2	boolean
    //   21	145	5	str	String
    //   173	1	5	localObject	Object
    //   12	72	6	localay	ay
    // Exception table:
    //   from	to	target	type
    //   65	83	173	finally
  }
  
  public static boolean ajZ(int paramInt)
  {
    return (paramInt & 0x7F) == 2;
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(310424);
    Object localObject = this.Qhc;
    if (localObject != null)
    {
      localObject = ((LivingDescBarLayout)localObject).getContext();
      AppMethodBeat.o(310424);
      return localObject;
    }
    AppMethodBeat.o(310424);
    return null;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(310432);
    Object localObject = getContext();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getString(paramInt);
      AppMethodBeat.o(310432);
      return localObject;
    }
    AppMethodBeat.o(310432);
    return "";
  }
  
  private void hdc()
  {
    AppMethodBeat.i(310383);
    LivingDescBarLayout localLivingDescBarLayout = this.Qhc;
    if (localLivingDescBarLayout == null)
    {
      AppMethodBeat.o(310383);
      return;
    }
    if (getCount() == 0)
    {
      localLivingDescBarLayout.setVisibility(4);
      localLivingDescBarLayout.hcZ();
      AppMethodBeat.o(310383);
      return;
    }
    localLivingDescBarLayout.setVisibility(0);
    localLivingDescBarLayout.setSlideAdapter(this);
    if (m.jP(getContext())) {
      localLivingDescBarLayout.setVisibility(8);
    }
    AppMethodBeat.o(310383);
  }
  
  private void hdd()
  {
    AppMethodBeat.i(310405);
    Object localObject = this.Qhc;
    if (localObject != null)
    {
      ((LivingDescBarLayout)localObject).setVisibility(8);
      ((LivingDescBarLayout)localObject).hcZ();
    }
    localObject = this.Qhb;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    AppMethodBeat.o(310405);
  }
  
  private List<String> hde()
  {
    int i = this.Qhf;
    i locali = this.Qhd;
    if (locali != null) {}
    switch (i & 0x7F)
    {
    default: 
      return null;
    case 1: 
      return locali.PMM;
    case 2: 
      return locali.PMN;
    }
    return locali.PMO;
  }
  
  public final void a(String paramString, i parami)
  {
    this.PNx = paramString;
    this.Qhd = parami;
  }
  
  public final String ajB(int paramInt)
  {
    AppMethodBeat.i(310470);
    Object localObject = hde();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (String)((List)localObject).get(paramInt);
      AppMethodBeat.o(310470);
      return localObject;
    }
    AppMethodBeat.o(310470);
    return "";
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(310483);
    super.finalize();
    Log.d("SnsAd.LivingStatusController", "the SnsAdLivingStatusController is going to be gc:  ".concat(String.valueOf(this)));
    AppMethodBeat.o(310483);
  }
  
  public final void gS(String paramString, int paramInt)
  {
    AppMethodBeat.i(310478);
    if ((this.PNx.equals(paramString)) && (this.Qhf != paramInt)) {
      setLiveStatus(paramInt);
    }
    AppMethodBeat.o(310478);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(310462);
    List localList = hde();
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(310462);
      return i;
    }
    AppMethodBeat.o(310462);
    return 0;
  }
  
  public final void setLiveStatus(int paramInt)
  {
    AppMethodBeat.i(310452);
    if (paramInt == this.Qhf)
    {
      if (paramInt == 0)
      {
        hdd();
        AppMethodBeat.o(310452);
        return;
      }
      ajX(paramInt);
      ajY(paramInt);
      LivingDescBarLayout localLivingDescBarLayout = this.Qhc;
      if (localLivingDescBarLayout != null)
      {
        if (localLivingDescBarLayout.hcX())
        {
          hdc();
          AppMethodBeat.o(310452);
          return;
        }
        localLivingDescBarLayout.hcY();
      }
      AppMethodBeat.o(310452);
      return;
    }
    this.Qhf = paramInt;
    if (paramInt == 0)
    {
      hdd();
      AppMethodBeat.o(310452);
      return;
    }
    ajX(paramInt);
    ajY(paramInt);
    hdc();
    AppMethodBeat.o(310452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.living.c
 * JD-Core Version:    0.7.0.1
 */