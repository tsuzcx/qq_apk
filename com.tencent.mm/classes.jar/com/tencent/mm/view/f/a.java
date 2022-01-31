package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
  public int adN = 0;
  public int fzn;
  public int hxU;
  public int hxV;
  public int jiT = this.ze.getResources().getDimensionPixelSize(a.c.emoji_panel_tab_width);
  public int kih = 0;
  public String seQ;
  public int vWJ = 0;
  private int wwc = com.tencent.mm.cb.a.aa(this.ze, a.c.smiley_panel_dot_height);
  private int wzA = this.wzy;
  private int wzB = com.tencent.mm.cb.a.fromDPToPix(this.ze, 8);
  private int wzC = com.tencent.mm.cb.a.fromDPToPix(this.ze, 16);
  public String wzD = "";
  public int wzE = 0;
  public boolean wzF;
  public boolean wzG;
  public boolean wzH;
  public boolean wzI;
  public boolean wzJ;
  public boolean wzK;
  public boolean wzL;
  public boolean wzM = false;
  public boolean wzN = false;
  public int[] wzO;
  public boolean wzP;
  public boolean wzQ;
  public ArrayList<com.tencent.mm.view.c.a> wzR = new ArrayList();
  public HashMap<String, Integer> wzS = new HashMap();
  public List<com.tencent.mm.storage.emotion.u> wzT = new ArrayList();
  public c wzU;
  public volatile boolean wzV = false;
  public int wzm = this.ze.getResources().getDimensionPixelSize(a.c.emoji_panel_tab_height);
  public int wzn = this.ze.getResources().getDimensionPixelSize(a.c.emoji_panel_tab_image_size);
  public int wzo = com.tencent.mm.cb.a.aa(this.ze, a.c.BasicPaddingSize);
  public int wzp = com.tencent.mm.cb.a.fromDPToPix(this.ze, 86);
  public int wzq = com.tencent.mm.cb.a.fromDPToPix(this.ze, 80);
  public int wzr = com.tencent.mm.cb.a.fromDPToPix(this.ze, 65);
  public int wzs = com.tencent.mm.cb.a.fromDPToPix(this.ze, 48);
  public int wzt = com.tencent.mm.cb.a.fromDPToPix(this.ze, 43);
  private int wzu = com.tencent.mm.cb.a.aa(this.ze, a.c.BasicPaddingSize);
  private int wzv = 0;
  public int wzw;
  private int wzx = com.tencent.mm.cb.a.fromDPToPix(this.ze, 6);
  private int wzy = com.tencent.mm.cb.a.aa(this.ze, a.c.smiley_panel_top_space);
  public int wzz = com.tencent.mm.cb.a.aa(this.ze, a.c.smiley_panel_top_space_min);
  private Context ze = ae.getContext();
  
  public a()
  {
    cMf();
    cLW();
    cMi();
  }
  
  private int[] api()
  {
    int[] arrayOfInt = new int[2];
    if ((this.ze instanceof Activity))
    {
      localObject = new DisplayMetrics();
      ((Activity)this.ze).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      arrayOfInt[0] = ((DisplayMetrics)localObject).widthPixels;
      arrayOfInt[1] = ((DisplayMetrics)localObject).heightPixels;
      return arrayOfInt;
    }
    Object localObject = ((WindowManager)this.ze.getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = ((Display)localObject).getWidth();
    arrayOfInt[1] = ((Display)localObject).getHeight();
    return arrayOfInt;
  }
  
  /* Error */
  public static boolean cLS()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 255	com/tencent/mm/kernel/g:DM	()Lcom/tencent/mm/kernel/d;
    //   5: invokevirtual 261	com/tencent/mm/kernel/d:Dr	()Lcom/tencent/mm/kernel/b/g;
    //   8: checkcast 263	com/tencent/mm/kernel/b/h
    //   11: invokevirtual 266	com/tencent/mm/kernel/b/h:Ex	()Z
    //   14: ifeq +78 -> 92
    //   17: invokestatic 272	com/tencent/mm/ca/a:cpp	()Lcom/tencent/mm/ca/a$a;
    //   20: pop
    //   21: getstatic 276	com/tencent/mm/ca/a:uaN	Lcom/tencent/mm/ca/a$b;
    //   24: astore_3
    //   25: ldc_w 277
    //   28: invokestatic 283	com/tencent/mm/ca/a$b:EV	(I)Z
    //   31: istore_0
    //   32: invokestatic 272	com/tencent/mm/ca/a:cpp	()Lcom/tencent/mm/ca/a$a;
    //   35: pop
    //   36: getstatic 276	com/tencent/mm/ca/a:uaN	Lcom/tencent/mm/ca/a$b;
    //   39: astore_3
    //   40: ldc_w 284
    //   43: invokestatic 283	com/tencent/mm/ca/a$b:EV	(I)Z
    //   46: istore_1
    //   47: iload_1
    //   48: ifne +9 -> 57
    //   51: iload_2
    //   52: istore_1
    //   53: iload_0
    //   54: ifeq +5 -> 59
    //   57: iconst_1
    //   58: istore_1
    //   59: iload_1
    //   60: ireturn
    //   61: astore_3
    //   62: iconst_0
    //   63: istore_0
    //   64: ldc 71
    //   66: ldc_w 286
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_3
    //   76: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 296	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: iconst_0
    //   84: istore_1
    //   85: goto -38 -> 47
    //   88: astore_3
    //   89: goto -25 -> 64
    //   92: iconst_0
    //   93: istore_0
    //   94: iconst_0
    //   95: istore_1
    //   96: goto -49 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	63	0	bool1	boolean
    //   46	50	1	bool2	boolean
    //   1	51	2	bool3	boolean
    //   24	16	3	localb	a.b
    //   61	15	3	localException1	Exception
    //   88	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	32	61	java/lang/Exception
    //   32	47	88	java/lang/Exception
  }
  
  /* Error */
  public static boolean cLT()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 255	com/tencent/mm/kernel/g:DM	()Lcom/tencent/mm/kernel/d;
    //   5: invokevirtual 261	com/tencent/mm/kernel/d:Dr	()Lcom/tencent/mm/kernel/b/g;
    //   8: checkcast 263	com/tencent/mm/kernel/b/h
    //   11: invokevirtual 266	com/tencent/mm/kernel/b/h:Ex	()Z
    //   14: ifeq +83 -> 97
    //   17: invokestatic 303	com/tencent/mm/y/c:BS	()Lcom/tencent/mm/y/a;
    //   20: ldc_w 304
    //   23: ldc_w 305
    //   26: invokevirtual 311	com/tencent/mm/y/a:bb	(II)Z
    //   29: istore_0
    //   30: invokestatic 303	com/tencent/mm/y/c:BS	()Lcom/tencent/mm/y/a;
    //   33: ldc_w 312
    //   36: ldc_w 305
    //   39: invokevirtual 311	com/tencent/mm/y/a:bb	(II)Z
    //   42: istore_2
    //   43: iload_0
    //   44: istore_1
    //   45: iload_2
    //   46: istore_0
    //   47: iload_1
    //   48: ifne +9 -> 57
    //   51: iload_3
    //   52: istore_1
    //   53: iload_0
    //   54: ifeq +5 -> 59
    //   57: iconst_1
    //   58: istore_1
    //   59: iload_1
    //   60: ireturn
    //   61: astore 4
    //   63: iconst_0
    //   64: istore_1
    //   65: ldc 71
    //   67: ldc_w 286
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload 4
    //   78: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 296	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: iconst_0
    //   86: istore_0
    //   87: goto -40 -> 47
    //   90: astore 4
    //   92: iload_0
    //   93: istore_1
    //   94: goto -29 -> 65
    //   97: iconst_0
    //   98: istore_0
    //   99: iconst_0
    //   100: istore_1
    //   101: goto -54 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	70	0	bool1	boolean
    //   44	57	1	bool2	boolean
    //   42	4	2	bool3	boolean
    //   1	51	3	bool4	boolean
    //   61	16	4	localException1	Exception
    //   90	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	30	61	java/lang/Exception
    //   30	43	90	java/lang/Exception
  }
  
  public static EmojiGroupInfo cLX()
  {
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
    return localEmojiGroupInfo;
  }
  
  public static EmojiGroupInfo cLY()
  {
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.uCR);
    return localEmojiGroupInfo;
  }
  
  public static boolean d(EmojiGroupInfo paramEmojiGroupInfo)
  {
    return (paramEmojiGroupInfo != null) && (paramEmojiGroupInfo.field_packStatus == 1);
  }
  
  public static boolean isSDCardAvailable()
  {
    if (((h)g.DM().Dr()).Ex())
    {
      g.DQ();
      return g.DP().isSDCardAvailable();
    }
    return true;
  }
  
  public final void IU(int paramInt)
  {
    this.hxU = paramInt;
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.hxU) });
  }
  
  public final com.tencent.mm.view.c.a IV(int paramInt)
  {
    if (this.wzR == null) {
      return null;
    }
    return (com.tencent.mm.view.c.a)this.wzR.get(IW(paramInt));
  }
  
  public final int IW(int paramInt)
  {
    if ((this.wzO == null) || (paramInt >= this.wzO.length) || (paramInt <= 0)) {
      return 0;
    }
    return this.wzO[paramInt];
  }
  
  public final void a(com.tencent.mm.view.c.a parama)
  {
    String str = parama.iZD;
    int i = parama.qPB;
    if (!str.equals("TAG_DEFAULT_TAB"))
    {
      i = (this.hxU - (this.wwc - this.wzu) - afb(str) * i) / (i + 1);
      parama.wyD = i;
      parama.wyC = i;
      return;
    }
    int j = this.hxU - this.wzy * 2 - afb(str) * i;
    if (j >= this.wzC)
    {
      parama.wyD = this.wzy;
      parama.wyC = ((j - this.wzC) / (i - 1));
      return;
    }
    if (j >= this.wzB)
    {
      parama.wyD = this.wzy;
      parama.wyC = 0;
      return;
    }
    if (com.tencent.mm.sdk.platformtools.u.fA(this.ze))
    {
      i = (j - this.wzB) / (i + 1);
      j = this.wzy + i;
      if (j >= this.wzz) {
        break label193;
      }
    }
    label193:
    for (parama.wyD = this.wzz;; parama.wyD = j)
    {
      parama.wyC = i;
      return;
      i = j / (i + 1);
      break;
    }
  }
  
  public final int afb(String paramString)
  {
    if ("TAG_DEFAULT_TAB".equals(paramString)) {
      return this.wzs;
    }
    return this.wzp;
  }
  
  public final com.tencent.mm.view.c.a afc(String paramString)
  {
    if ((this.wzR == null) || (paramString == null))
    {
      y.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
      return null;
    }
    Iterator localIterator = this.wzR.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)localIterator.next();
      if (locala == null) {
        y.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
      } else if (locala.iZD == null) {
        y.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
      } else if (locala.iZD.equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  public final int cLU()
  {
    if (this.hxV <= 1) {
      this.hxV = api()[0];
    }
    return this.hxV;
  }
  
  public final void cLV()
  {
    if (bk.bl(this.wzD)) {}
    while (this.wzF) {
      return;
    }
    y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[] { this.wzD, Integer.valueOf(this.wzE) });
    com.tencent.mm.ca.a.cpp();
    a.b localb = com.tencent.mm.ca.a.uaN;
    a.b.YJ(this.wzD);
  }
  
  public final void cLW()
  {
    if (this.wzF)
    {
      if (!this.wzD.equals("TAG_DEFAULT_TAB"))
      {
        this.wzD = "TAG_DEFAULT_TAB";
        this.wzE = bk.a((Integer)this.wzS.get(this.wzD), 0);
      }
      return;
    }
    com.tencent.mm.ca.a.cpp();
    a.b localb = com.tencent.mm.ca.a.uaN;
    this.wzD = a.b.bb(-29414086, "TAG_DEFAULT_TAB");
    this.wzE = bk.a((Integer)this.wzS.get(this.wzD), 0);
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[] { this.wzD, Integer.valueOf(this.wzE) });
  }
  
  public final boolean cLZ()
  {
    com.tencent.mm.ca.a.cpp();
    a.b localb = com.tencent.mm.ca.a.uaN;
    return (a.b.EV(66832)) && (!this.wzL);
  }
  
  public final int cMa()
  {
    String str = this.wzD;
    if (this.wzR != null)
    {
      int i = 0;
      while (i < this.wzR.size())
      {
        com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)this.wzR.get(i);
        if ((locala != null) && (locala.iZD.equals(str))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public final com.tencent.mm.view.c.a cMb()
  {
    return afc(this.wzD);
  }
  
  public final void cMc()
  {
    this.kih = 0;
    if (this.wzR == null) {
      return;
    }
    Object localObject = this.wzR.iterator();
    int i;
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)((Iterator)localObject).next();
      i = this.kih;
      this.kih = (locala.cLI() + i);
    }
    if (this.wzR != null) {}
    for (;;)
    {
      try
      {
        this.wzO = new int[this.kih];
        i = 0;
        j = 0;
        if (i < this.wzR.size())
        {
          localObject = (com.tencent.mm.view.c.a)this.wzR.get(i);
          k = 0;
          if (k >= ((com.tencent.mm.view.c.a)localObject).cLI()) {
            continue;
          }
          int m = this.kih;
          if (j < m) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        int k;
        y.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", localException, "", new Object[0]);
        continue;
      }
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[] { Integer.valueOf(this.kih) });
      return;
      this.wzO[j] = i;
      k += 1;
      j += 1;
      continue;
      i += 1;
    }
  }
  
  public final boolean cMd()
  {
    if (this.adN == 0)
    {
      int[] arrayOfInt = api();
      if (arrayOfInt[0] >= arrayOfInt[1]) {
        break label36;
      }
    }
    label36:
    for (this.adN = 1; this.adN == 1; this.adN = 2) {
      return true;
    }
    return false;
  }
  
  public final void cMe()
  {
    if (this.wzU != null)
    {
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
      com.tencent.mm.sdk.b.a.udP.d(this.wzU);
      this.wzU = null;
    }
  }
  
  public final void cMf()
  {
    long l = System.currentTimeMillis();
    if (this.wzS == null) {
      this.wzS = new HashMap();
    }
    this.wzS.clear();
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHm();
    if ((localObject != null) && (((bsl)localObject).tIZ != null) && (!((bsl)localObject).tIZ.isEmpty()))
    {
      localObject = ((bsl)localObject).tIZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bsm localbsm = (bsm)((Iterator)localObject).next();
        this.wzS.put(localbsm.syc, Integer.valueOf(localbsm.sAr));
      }
    }
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final void cMg()
  {
    long l = System.currentTimeMillis();
    bsl localbsl = new bsl();
    if ((this.wzS != null) && (!this.wzS.isEmpty()))
    {
      Iterator localIterator = this.wzS.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        bsm localbsm = new bsm();
        localbsm.syc = str;
        localbsm.sAr = ((Integer)this.wzS.get(str)).intValue();
        localbsl.tIZ.add(localbsm);
      }
      ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(localbsl);
    }
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final boolean cMh()
  {
    return (this.wzT != null) && (this.wzT.size() >= 3);
  }
  
  public final void cMi()
  {
    this.wzT = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHv();
  }
  
  public final void dN(String paramString, int paramInt)
  {
    this.wzS.put(paramString, Integer.valueOf(paramInt));
  }
  
  public final int getColumnWidth()
  {
    int j = 4;
    int i;
    if (this.vWJ == 0)
    {
      i = cLU() / this.wzq;
      if (!cMd()) {
        break label51;
      }
      if (i <= 4) {
        break label48;
      }
      i = j;
    }
    label48:
    label51:
    for (;;)
    {
      this.vWJ = (cLU() / i);
      return this.vWJ;
    }
  }
  
  public final void onPause()
  {
    this.wzK = false;
    cLV();
    cMg();
    cMe();
    ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHw();
  }
  
  public final void setShowProductId(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    this.wzD = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.f.a
 * JD-Core Version:    0.7.0.1
 */