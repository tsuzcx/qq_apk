package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
{
  public boolean AHW;
  private int ARe;
  public int AUH;
  public int AUI;
  private int AUJ;
  public int AUK;
  public int AUL;
  public int AUM;
  public int AUN;
  public int AUO;
  private int AUP;
  private int AUQ;
  public int AUR;
  private int AUS;
  private int AUT;
  public int AUU;
  private int AUV;
  private int AUW;
  private int AUX;
  private int AUY;
  public String AUZ;
  public int AVa;
  public boolean AVb;
  public boolean AVc;
  public boolean AVd;
  public boolean AVe;
  public boolean AVf;
  public boolean AVg;
  public boolean AVh;
  public boolean AVi;
  public boolean AVj;
  public int[] AVk;
  public boolean AVl;
  public boolean AVm;
  public ArrayList<com.tencent.mm.view.c.a> AVn;
  private HashMap<String, Integer> AVo;
  public List<s> AVp;
  public com.tencent.mm.sdk.b.c AVq;
  public volatile boolean AVr;
  private int AoR;
  private final String TAG;
  public int jqe;
  public int jqf;
  public int lrK;
  private int mCN;
  private int mOrientation;
  public int mScene;
  public String vVU;
  public Context zF;
  
  public a()
  {
    AppMethodBeat.i(63078);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
    this.AoR = 0;
    this.AUQ = 0;
    this.mOrientation = 0;
    this.mCN = 0;
    this.AUZ = "";
    this.AVa = 0;
    this.AVd = true;
    this.AVi = false;
    this.AVj = false;
    this.AVn = new ArrayList();
    this.AVo = new HashMap();
    this.AVp = new ArrayList();
    this.AVr = false;
    this.zF = ah.getContext();
    this.AUH = this.zF.getResources().getDimensionPixelSize(2131428385);
    this.lrK = this.zF.getResources().getDimensionPixelSize(2131428389);
    this.AUI = this.zF.getResources().getDimensionPixelSize(2131428388);
    this.AUN = com.tencent.mm.cb.a.fromDPToPix(this.zF, 48);
    this.AUO = com.tencent.mm.cb.a.fromDPToPix(this.zF, 43);
    this.AUK = com.tencent.mm.cb.a.fromDPToPix(this.zF, 86);
    this.AUL = com.tencent.mm.cb.a.fromDPToPix(this.zF, 90);
    this.AUM = com.tencent.mm.cb.a.fromDPToPix(this.zF, 65);
    this.AUJ = com.tencent.mm.cb.a.ao(this.zF, 2131427496);
    this.AUS = com.tencent.mm.cb.a.fromDPToPix(this.zF, 6);
    this.AUZ = "TAG_DEFAULT_TAB";
    this.AVa = 0;
    this.ARe = com.tencent.mm.cb.a.ao(this.zF, 2131428685);
    this.AUP = com.tencent.mm.cb.a.ao(this.zF, 2131427496);
    this.AUT = com.tencent.mm.cb.a.ao(this.zF, 2131428687);
    this.AUU = com.tencent.mm.cb.a.ao(this.zF, 2131428688);
    this.AUV = com.tencent.mm.cb.a.fromDPToPix(this.zF, 12);
    this.AUW = this.AUT;
    this.AUX = com.tencent.mm.cb.a.fromDPToPix(this.zF, 8);
    this.AUY = com.tencent.mm.cb.a.fromDPToPix(this.zF, 16);
    dRD();
    dRu();
    dRG();
    AppMethodBeat.o(63078);
  }
  
  public static int RQ(int paramInt)
  {
    if (paramInt == ChatFooterPanel.vQm) {}
    do
    {
      return 2;
      if (paramInt == ChatFooterPanel.vQr) {
        return 3;
      }
      if (paramInt == ChatFooterPanel.vQs) {
        return 4;
      }
    } while (paramInt != ChatFooterPanel.vQt);
    return 5;
  }
  
  public static boolean RR(int paramInt)
  {
    AppMethodBeat.i(63114);
    if ((((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().OR()) && ((paramInt == ChatFooterPanel.vQm) || (paramInt == ChatFooterPanel.vQr) || (paramInt == ChatFooterPanel.vQs) || (paramInt == ChatFooterPanel.vQt)))
    {
      AppMethodBeat.o(63114);
      return true;
    }
    AppMethodBeat.o(63114);
    return false;
  }
  
  public static boolean RS(int paramInt)
  {
    return paramInt == ChatFooterPanel.vQm;
  }
  
  private com.tencent.mm.view.c.a a(EmojiGroupInfo paramEmojiGroupInfo, com.tencent.mm.view.e.a parama, boolean paramBoolean, com.tencent.mm.view.c.a parama1, int paramInt)
  {
    AppMethodBeat.i(63101);
    if (parama1 == null) {}
    for (int i = 0;; i = parama1.jpL + parama1.dRf())
    {
      paramEmojiGroupInfo = new com.tencent.mm.view.c.a(paramEmojiGroupInfo, i, paramInt, this, parama, paramBoolean);
      AppMethodBeat.o(63101);
      return paramEmojiGroupInfo;
    }
  }
  
  private int[] aMu()
  {
    AppMethodBeat.i(63106);
    int[] arrayOfInt = new int[2];
    Object localObject;
    if ((this.zF instanceof Activity))
    {
      localObject = new DisplayMetrics();
      ((Activity)this.zF).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      arrayOfInt[0] = ((DisplayMetrics)localObject).widthPixels;
      arrayOfInt[1] = ((DisplayMetrics)localObject).heightPixels;
    }
    for (;;)
    {
      AppMethodBeat.o(63106);
      return arrayOfInt;
      localObject = ((WindowManager)this.zF.getSystemService("window")).getDefaultDisplay();
      arrayOfInt[0] = ((Display)localObject).getWidth();
      arrayOfInt[1] = ((Display)localObject).getHeight();
    }
  }
  
  public static int avR(String paramString)
  {
    AppMethodBeat.i(63080);
    if (paramString.equals("TAG_DEFAULT_TAB"))
    {
      AppMethodBeat.o(63080);
      return 20;
    }
    if (paramString.equals(String.valueOf(EmojiGroupInfo.yPe)))
    {
      AppMethodBeat.o(63080);
      return 25;
    }
    if (paramString.equals("capture"))
    {
      AppMethodBeat.o(63080);
      return 26;
    }
    AppMethodBeat.o(63080);
    return 23;
  }
  
  private com.tencent.mm.view.c.a b(EmojiGroupInfo paramEmojiGroupInfo, com.tencent.mm.view.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63100);
    int i = this.AVn.size();
    if (i <= 0) {}
    for (com.tencent.mm.view.c.a locala = null;; locala = (com.tencent.mm.view.c.a)this.AVn.get(i - 1))
    {
      paramEmojiGroupInfo = a(paramEmojiGroupInfo, parama, paramBoolean, locala, bo.a((Integer)this.AVo.get(paramEmojiGroupInfo.field_productID), 0));
      AppMethodBeat.o(63100);
      return paramEmojiGroupInfo;
    }
  }
  
  public static boolean dRq()
  {
    AppMethodBeat.i(63081);
    for (;;)
    {
      try
      {
        a.b localb;
        if (((h)g.RI().Rj()).SD())
        {
          com.tencent.mm.ca.a.dqM();
          localb = com.tencent.mm.ca.a.yiH;
          bool1 = a.b.MV(208913);
        }
        boolean bool1 = false;
      }
      catch (Exception localException1)
      {
        try
        {
          com.tencent.mm.ca.a.dqM();
          localb = com.tencent.mm.ca.a.yiH;
          bool2 = a.b.MV(208899);
          if ((!bool2) && (!bool1)) {
            continue;
          }
          AppMethodBeat.o(63081);
          return true;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool1 = false;
        ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[] { localException1.toString() });
        bool2 = false;
        continue;
        AppMethodBeat.o(63081);
        return false;
      }
      boolean bool2 = false;
    }
  }
  
  public static boolean dRr()
  {
    AppMethodBeat.i(63082);
    for (;;)
    {
      try
      {
        if (((h)g.RI().Rj()).SD()) {
          bool1 = com.tencent.mm.x.c.PJ().cc(262147, 266244);
        }
        boolean bool3;
        boolean bool1 = false;
      }
      catch (Exception localException1)
      {
        try
        {
          bool3 = com.tencent.mm.x.c.PJ().cc(262149, 266244);
          bool2 = bool1;
          bool1 = bool3;
          if ((!bool2) && (!bool1)) {
            continue;
          }
          AppMethodBeat.o(63082);
          return true;
        }
        catch (Exception localException2)
        {
          bool2 = bool1;
          continue;
        }
        localException1 = localException1;
        bool2 = false;
        ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[] { localException1.toString() });
        bool1 = false;
        continue;
        AppMethodBeat.o(63082);
        return false;
      }
      boolean bool2 = false;
    }
  }
  
  public static EmojiGroupInfo dRw()
  {
    AppMethodBeat.i(63092);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
    AppMethodBeat.o(63092);
    return localEmojiGroupInfo;
  }
  
  public static EmojiGroupInfo dRx()
  {
    AppMethodBeat.i(63093);
    EmojiGroupInfo localEmojiGroupInfo = new EmojiGroupInfo();
    localEmojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.yPe);
    AppMethodBeat.o(63093);
    return localEmojiGroupInfo;
  }
  
  public static boolean e(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(63094);
    if ((paramEmojiGroupInfo != null) && ((!com.tencent.mm.plugin.emoji.h.b.Lk(paramEmojiGroupInfo.field_productID)) || (paramEmojiGroupInfo.field_packStatus == 1)))
    {
      AppMethodBeat.o(63094);
      return true;
    }
    AppMethodBeat.o(63094);
    return false;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(63105);
    if (((h)g.RI().Rj()).SD())
    {
      g.RM();
      boolean bool = g.RL().isSDCardAvailable();
      AppMethodBeat.o(63105);
      return bool;
    }
    AppMethodBeat.o(63105);
    return true;
  }
  
  public final void RN(int paramInt)
  {
    AppMethodBeat.i(63084);
    this.jqe = paramInt;
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jqe) });
    AppMethodBeat.o(63084);
  }
  
  public final com.tencent.mm.view.c.a RO(int paramInt)
  {
    AppMethodBeat.i(63097);
    if (this.AVn == null)
    {
      AppMethodBeat.o(63097);
      return null;
    }
    com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)this.AVn.get(RP(paramInt));
    AppMethodBeat.o(63097);
    return locala;
  }
  
  public final int RP(int paramInt)
  {
    if ((this.AVk == null) || (paramInt >= this.AVk.length) || (paramInt <= 0)) {
      return 0;
    }
    return this.AVk[paramInt];
  }
  
  public final void a(EmojiGroupInfo paramEmojiGroupInfo, com.tencent.mm.view.e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(63099);
    if (this.AVn == null) {
      this.AVn = new ArrayList();
    }
    paramEmojiGroupInfo = b(paramEmojiGroupInfo, parama, paramBoolean);
    this.AVn.add(paramEmojiGroupInfo);
    AppMethodBeat.o(63099);
  }
  
  public final void a(com.tencent.mm.view.c.a parama)
  {
    AppMethodBeat.i(63104);
    String str = parama.liu;
    int j;
    if (str.equals("TAG_DEFAULT_TAB")) {
      j = this.AUT;
    }
    int k;
    int m;
    for (int i = this.AUU;; i = this.AUV)
    {
      k = parama.uEJ;
      m = this.jqe - j * 2 - avS(str) * k;
      if (m < this.AUY) {
        break label130;
      }
      i = (m - this.AUY) / (k + 1);
      parama.ATV = (j + i);
      if (k != 1) {
        break;
      }
      parama.ATU = 0;
      AppMethodBeat.o(63104);
      return;
      j = this.AUV;
    }
    parama.ATU = i;
    AppMethodBeat.o(63104);
    return;
    label130:
    if (m >= this.AUX)
    {
      parama.ATV = j;
      parama.ATU = 0;
      AppMethodBeat.o(63104);
      return;
    }
    if (x.gN(this.zF))
    {
      k = (m - this.AUX) / (k + 1);
      j += k;
      if (j >= i) {
        break label220;
      }
    }
    label220:
    for (parama.ATV = i;; parama.ATV = j)
    {
      parama.ATU = k;
      AppMethodBeat.o(63104);
      return;
      k = m / (k + 1);
      break;
    }
  }
  
  public final int aRI()
  {
    AppMethodBeat.i(63085);
    if (this.jqf <= 1) {
      this.jqf = aMu()[0];
    }
    int i = this.jqf;
    AppMethodBeat.o(63085);
    return i;
  }
  
  public final int avS(String paramString)
  {
    AppMethodBeat.i(63083);
    if ("TAG_DEFAULT_TAB".equals(paramString))
    {
      i = this.AUN;
      AppMethodBeat.o(63083);
      return i;
    }
    int i = this.AUK;
    AppMethodBeat.o(63083);
    return i;
  }
  
  public final boolean avT(String paramString)
  {
    AppMethodBeat.i(63088);
    if (this.AUZ.equals(paramString))
    {
      AppMethodBeat.o(63088);
      return true;
    }
    AppMethodBeat.o(63088);
    return false;
  }
  
  public final com.tencent.mm.view.c.a avU(String paramString)
  {
    AppMethodBeat.i(63096);
    if ((this.AVn == null) || (paramString == null))
    {
      ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
      AppMethodBeat.o(63096);
      return null;
    }
    Iterator localIterator = this.AVn.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)localIterator.next();
      if (locala == null)
      {
        ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
      }
      else if (locala.liu == null)
      {
        ab.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
      }
      else if (locala.liu.equals(paramString))
      {
        AppMethodBeat.o(63096);
        return locala;
      }
    }
    AppMethodBeat.o(63096);
    return null;
  }
  
  public final int dRA()
  {
    AppMethodBeat.i(63102);
    if (this.AVb)
    {
      i = avU("TAG_DEFAULT_TAB").dRf();
      AppMethodBeat.o(63102);
      return i;
    }
    int i = this.mCN;
    AppMethodBeat.o(63102);
    return i;
  }
  
  public final void dRB()
  {
    AppMethodBeat.i(63103);
    this.mCN = 0;
    if (this.AVn == null)
    {
      AppMethodBeat.o(63103);
      return;
    }
    Object localObject = this.AVn.iterator();
    int i;
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.view.c.a locala = (com.tencent.mm.view.c.a)((Iterator)localObject).next();
      i = this.mCN;
      this.mCN = (locala.dRf() + i);
    }
    if (this.AVn != null) {}
    for (;;)
    {
      try
      {
        this.AVk = new int[this.mCN];
        i = 0;
        j = 0;
        if (i < this.AVn.size())
        {
          localObject = (com.tencent.mm.view.c.a)this.AVn.get(i);
          k = 0;
          if (k >= ((com.tencent.mm.view.c.a)localObject).dRf()) {
            continue;
          }
          int m = this.mCN;
          if (j < m) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        int k;
        ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", localException, "", new Object[0]);
        continue;
      }
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[] { Integer.valueOf(this.mCN) });
      AppMethodBeat.o(63103);
      return;
      this.AVk[j] = i;
      k += 1;
      j += 1;
      continue;
      i += 1;
    }
  }
  
  public final void dRC()
  {
    AppMethodBeat.i(63107);
    if (this.AVq != null)
    {
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
      com.tencent.mm.sdk.b.a.ymk.d(this.AVq);
      this.AVq = null;
    }
    AppMethodBeat.o(63107);
  }
  
  public final void dRD()
  {
    AppMethodBeat.i(63109);
    long l = System.currentTimeMillis();
    if (this.AVo == null) {
      this.AVo = new HashMap();
    }
    this.AVo.clear();
    Object localObject = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().blb();
    if ((localObject != null) && (((cda)localObject).xND != null) && (!((cda)localObject).xND.isEmpty()))
    {
      localObject = ((cda)localObject).xND.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cdb localcdb = (cdb)((Iterator)localObject).next();
        this.AVo.put(localcdb.ProductID, Integer.valueOf(localcdb.wux));
      }
    }
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(63109);
  }
  
  public final void dRE()
  {
    AppMethodBeat.i(63110);
    long l = System.currentTimeMillis();
    cda localcda = new cda();
    if ((this.AVo != null) && (!this.AVo.isEmpty()))
    {
      Iterator localIterator = this.AVo.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        cdb localcdb = new cdb();
        localcdb.ProductID = str;
        localcdb.wux = ((Integer)this.AVo.get(str)).intValue();
        localcda.xND.add(localcdb);
      }
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(localcda);
    }
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(63110);
  }
  
  public final boolean dRF()
  {
    AppMethodBeat.i(63111);
    if ((this.AVp != null) && (this.AVp.size() >= 3))
    {
      AppMethodBeat.o(63111);
      return true;
    }
    AppMethodBeat.o(63111);
    return false;
  }
  
  public final void dRG()
  {
    AppMethodBeat.i(63112);
    this.AVp = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().blf();
    com.tencent.mm.emoji.c.b.Pa().exo = dRF();
    AppMethodBeat.o(63112);
  }
  
  public final boolean dRH()
  {
    AppMethodBeat.i(156835);
    boolean bool = RR(this.mScene);
    AppMethodBeat.o(156835);
    return bool;
  }
  
  public final int dRs()
  {
    return this.AUK;
  }
  
  public final void dRt()
  {
    AppMethodBeat.i(63089);
    if (bo.isNullOrNil(this.AUZ))
    {
      AppMethodBeat.o(63089);
      return;
    }
    if (this.AVb)
    {
      AppMethodBeat.o(63089);
      return;
    }
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[] { this.AUZ, Integer.valueOf(this.AVa) });
    com.tencent.mm.ca.a.dqM();
    a.b localb = com.tencent.mm.ca.a.yiH;
    a.b.aoG(this.AUZ);
    AppMethodBeat.o(63089);
  }
  
  public final void dRu()
  {
    AppMethodBeat.i(63090);
    if (this.AVb)
    {
      if (!this.AUZ.equals("TAG_DEFAULT_TAB"))
      {
        this.AUZ = "TAG_DEFAULT_TAB";
        this.AVa = bo.a((Integer)this.AVo.get(this.AUZ), 0);
      }
      AppMethodBeat.o(63090);
      return;
    }
    com.tencent.mm.ca.a.dqM();
    a.b localb = com.tencent.mm.ca.a.yiH;
    this.AUZ = a.b.bI(-29414086, "TAG_DEFAULT_TAB");
    this.AVa = bo.a((Integer)this.AVo.get(this.AUZ), 0);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[] { this.AUZ, Integer.valueOf(this.AVa) });
    AppMethodBeat.o(63090);
  }
  
  public final int dRv()
  {
    int j = 0;
    AppMethodBeat.i(63091);
    if (ChatFooterPanel.vQp == this.mScene) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = com.tencent.mm.emoji.a.d.Oz().ch(bool);
      if ((!bo.isNullOrNil(this.vVU)) && ((ad.arf(this.vVU)) || (t.nK(this.vVU))))
      {
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
          if ((localEmojiInfo != null) && (localEmojiInfo.field_catalog == EmojiGroupInfo.yPf)) {
            j += 1;
          }
        }
      }
      int i = ((ArrayList)localObject).size();
      j = i;
      if (RS(this.mScene)) {
        j = i + 1;
      }
      AppMethodBeat.o(63091);
      return j;
    }
  }
  
  public final boolean dRy()
  {
    AppMethodBeat.i(63095);
    com.tencent.mm.ca.a.dqM();
    a.b localb = com.tencent.mm.ca.a.yiH;
    if ((a.b.MV(66832)) && (!this.AVh))
    {
      AppMethodBeat.o(63095);
      return true;
    }
    AppMethodBeat.o(63095);
    return false;
  }
  
  public final com.tencent.mm.view.c.a dRz()
  {
    AppMethodBeat.i(63098);
    com.tencent.mm.view.c.a locala = avU(this.AUZ);
    AppMethodBeat.o(63098);
    return locala;
  }
  
  public final void eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(63087);
    this.AVo.put(paramString, Integer.valueOf(paramInt));
    AppMethodBeat.o(63087);
  }
  
  public final int getColumnWidth()
  {
    int j = 4;
    AppMethodBeat.i(63108);
    int i;
    if (this.AoR == 0)
    {
      i = aRI() / this.AUL;
      if (!x.gN(this.zF)) {
        break label76;
      }
      if (i <= 4) {
        break label73;
      }
      i = j;
    }
    label73:
    label76:
    for (;;)
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      this.AoR = (aRI() / j);
      i = this.AoR;
      AppMethodBeat.o(63108);
      return i;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(63079);
    this.AHW = false;
    dRt();
    dRE();
    dRC();
    ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().blg();
    AppMethodBeat.o(63079);
  }
  
  public final void setShowProductId(String paramString)
  {
    AppMethodBeat.i(63086);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(63086);
      return;
    }
    this.AUZ = paramString;
    AppMethodBeat.o(63086);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(63077);
      AVt = new a("RECOMMEND", 0);
      AVu = new a("DEFAULT", 1);
      AVv = new a("CUSTOM", 2);
      AVw = new a("CAPTURE", 3);
      AVx = new a("STORE", 4);
      AVy = new a[] { AVt, AVu, AVv, AVw, AVx };
      AppMethodBeat.o(63077);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.f.a
 * JD-Core Version:    0.7.0.1
 */