package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.an.b;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.h.a.cx;
import com.tencent.mm.h.a.ni;
import com.tencent.mm.plugin.l.a.h;
import com.tencent.mm.plugin.l.a.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView.d;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.SmileyPanelViewPager.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class a
  implements ViewPager.e, View.OnClickListener, MMRadioGroupView.d, SmileyPanelScrollView.b, SmileyPanelViewPager.a
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
  public Context hxz;
  private ah mHandler = new a.1(this);
  public View mView;
  public final j.a uBw = new a.8(this);
  public final com.tencent.mm.sdk.b.c uBx = new com.tencent.mm.sdk.b.c() {};
  public com.tencent.mm.view.f.a wvQ;
  private final int wyG = 100;
  private final int wyH = 1102;
  private final int wyI = 1103;
  private final int wyJ = 100;
  public SmileyPanelViewPager wyK;
  public com.tencent.mm.view.a.g wyL;
  public SmileyPanelScrollView wyM;
  public HorizontalListViewV2 wyN;
  public com.tencent.mm.view.a.h wyO;
  public View wyP;
  public ImageView wyQ;
  public ImageView wyR;
  private ImageButton wyS;
  public ImageButton wyT;
  public TextView wyU;
  public a.a wyV;
  private int wyW = -1;
  private boolean wyX = false;
  public boolean wyY = true;
  public String wyZ;
  private boolean wza = false;
  private boolean wzb = false;
  public final j.a wzc = new a.7(this);
  public final com.tencent.mm.sdk.b.c<cx> wzd = new a.10(this);
  public final j.a wze = new a.11(this);
  public AdapterView.OnItemClickListener wzf = new a.12(this);
  public ImageView xwh;
  public com.tencent.mm.view.popview.a xwi;
  public Context ze = ae.getContext();
  
  public a(Context paramContext, com.tencent.mm.view.f.a parama, a.a parama1)
  {
    this.hxz = paramContext;
    this.wvQ = parama;
    this.wyV = parama1;
    y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.wzc);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.uBw);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().l(this.wze);
    com.tencent.mm.sdk.b.a.udP.c(this.uBx);
    this.wzd.cqo();
    this.xwi = new com.tencent.mm.view.popview.a(paramContext);
  }
  
  private void IT(int paramInt)
  {
    int i = this.wvQ.jiT;
    int j = this.wyN.getWidth();
    int k = this.wyN.getFirstVisiblePosition();
    if (paramInt > this.wyN.getLastVisiblePosition()) {
      this.wyN.Gk(i * (paramInt + 1) - j);
    }
    for (;;)
    {
      b(paramInt, true, true);
      return;
      if (paramInt < k) {
        this.wyN.Gk(i * paramInt);
      }
    }
  }
  
  private void a(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    int i = 0;
    com.tencent.mm.view.f.a locala1 = this.wvQ;
    if (locala1.wzR == null) {
      locala1.wzR = new ArrayList();
    }
    int j = locala1.wzR.size();
    com.tencent.mm.view.c.a locala;
    if (j <= 0)
    {
      locala = null;
      j = bk.a((Integer)locala1.wzS.get(paramEmojiGroupInfo.field_productID), 0);
      if (locala != null) {
        break label119;
      }
    }
    for (;;)
    {
      paramEmojiGroupInfo = new com.tencent.mm.view.c.a(paramEmojiGroupInfo, i, j, locala1, this, paramBoolean);
      locala1.wzR.add(paramEmojiGroupInfo);
      return;
      locala = (com.tencent.mm.view.c.a)locala1.wzR.get(j - 1);
      break;
      label119:
      i = locala.hxB + locala.cLI();
    }
  }
  
  private void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (this.wyN != null)
    {
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Integer.valueOf(this.wyN.getChildCount()) });
      this.wyN.setSelection(paramInt);
      localObject = this.wyN.getSelectedView();
      if (localObject == null) {
        break label78;
      }
      ((View)localObject).setSelected(paramBoolean1);
    }
    label78:
    do
    {
      return;
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", new Object[] { Boolean.valueOf(paramBoolean2) });
    } while (!paramBoolean2);
    Object localObject = new Message();
    ((Message)localObject).what = 1103;
    ((Message)localObject).arg1 = paramInt;
    if (paramBoolean1) {}
    for (paramInt = i;; paramInt = 0)
    {
      ((Message)localObject).arg2 = paramInt;
      this.mHandler.sendMessageDelayed((Message)localObject, 100L);
      return;
    }
  }
  
  private void cLN()
  {
    cLM();
    this.wyL = new com.tencent.mm.view.a.g(this.wvQ, this.hxz);
  }
  
  private ImageButton cLP()
  {
    if ((this.wyS == null) && (this.hxz != null))
    {
      this.wyS = new ImageButton(this.hxz, null, a.i.MMStyleTabButton);
      this.wyS.setMaxHeight(this.wvQ.wzm);
      this.wyS.setMinimumHeight(this.wvQ.wzm);
      this.wyS.setMaxWidth(this.wvQ.jiT);
      this.wyS.setMinimumWidth(this.wvQ.jiT);
      this.wyS.setScaleType(ImageView.ScaleType.CENTER);
      this.wyS.setPadding(this.wvQ.wzo, this.wvQ.wzo, this.wvQ.wzo, this.wvQ.wzo);
      this.wyS.setClickable(false);
      this.wyS.setVisibility(8);
    }
    return this.wyS;
  }
  
  private void cVA()
  {
    com.tencent.mm.br.d.b(this.ze, "emoji", ".ui.EmojiMineUI", new Intent());
  }
  
  private void f(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt1 <= 1)
    {
      this.wyM.setVisibility(4);
      return;
    }
    this.wyM.setVisibility(0);
    SmileyPanelScrollView localSmileyPanelScrollView = this.wyM;
    y.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1) });
    localSmileyPanelScrollView.wvX = paramInt1;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localSmileyPanelScrollView.wvY = paramInt1;
      if ((localSmileyPanelScrollView.wwl == -1) || (paramBoolean1) || (localSmileyPanelScrollView.wwp == 0)) {
        localSmileyPanelScrollView.wwl = localSmileyPanelScrollView.wvY;
      }
      if ((localSmileyPanelScrollView.wwk == -1) || (paramBoolean1) || (localSmileyPanelScrollView.wwp == 0))
      {
        localSmileyPanelScrollView.wwk = localSmileyPanelScrollView.wvY;
        localSmileyPanelScrollView.wwm = 0.0F;
      }
      localSmileyPanelScrollView.wwo = paramBoolean2;
      localSmileyPanelScrollView.invalidate();
      return;
      paramInt1 = paramInt2;
      if (paramInt2 > localSmileyPanelScrollView.wvX) {
        paramInt1 = localSmileyPanelScrollView.wvX;
      }
    }
  }
  
  public final void Gr(int paramInt)
  {
    if (paramInt > 0)
    {
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
      IT(this.wvQ.cMa());
    }
  }
  
  public final void IM(int paramInt)
  {
    if (this.wyK != null)
    {
      int i = this.wyK.getCurrentItem();
      paramInt = this.wvQ.IV(i).hxB + paramInt;
      if (paramInt != i)
      {
        Math.abs(paramInt - i);
        this.wyK.setCurrentItem(paramInt);
      }
      this.wyW = paramInt;
    }
  }
  
  /* Error */
  public final void IN(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 151	com/tencent/mm/view/e/a:wvQ	Lcom/tencent/mm/view/f/a;
    //   6: invokevirtual 536	com/tencent/mm/view/f/a:cMd	()Z
    //   9: ifeq +59 -> 68
    //   12: aload_0
    //   13: getfield 151	com/tencent/mm/view/e/a:wvQ	Lcom/tencent/mm/view/f/a;
    //   16: getfield 539	com/tencent/mm/view/f/a:wzP	Z
    //   19: ifne +18 -> 37
    //   22: aload_0
    //   23: getfield 151	com/tencent/mm/view/e/a:wvQ	Lcom/tencent/mm/view/f/a;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: putfield 539	com/tencent/mm/view/f/a:wzP	Z
    //   32: aload_2
    //   33: iconst_0
    //   34: putfield 542	com/tencent/mm/view/f/a:wzQ	Z
    //   37: ldc 84
    //   39: ldc_w 544
    //   42: invokestatic 161	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iload_1
    //   46: ifle +19 -> 65
    //   49: aload_0
    //   50: getfield 546	com/tencent/mm/view/e/a:mView	Landroid/view/View;
    //   53: new 548	com/tencent/mm/view/e/a$5
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 549	com/tencent/mm/view/e/a$5:<init>	(Lcom/tencent/mm/view/e/a;)V
    //   61: invokevirtual 553	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield 151	com/tencent/mm/view/e/a:wvQ	Lcom/tencent/mm/view/f/a;
    //   72: getfield 542	com/tencent/mm/view/f/a:wzQ	Z
    //   75: ifne -38 -> 37
    //   78: aload_0
    //   79: getfield 151	com/tencent/mm/view/e/a:wvQ	Lcom/tencent/mm/view/f/a;
    //   82: astore_2
    //   83: aload_2
    //   84: iconst_1
    //   85: putfield 542	com/tencent/mm/view/f/a:wzQ	Z
    //   88: aload_2
    //   89: iconst_0
    //   90: putfield 539	com/tencent/mm/view/f/a:wzP	Z
    //   93: goto -56 -> 37
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	a
    //   0	101	1	paramInt	int
    //   26	63	2	locala	com.tencent.mm.view.f.a
    //   96	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	96	finally
    //   37	45	96	finally
    //   49	65	96	finally
    //   68	93	96	finally
  }
  
  public final void Q(int paramInt)
  {
    SmileyPanelScrollView localSmileyPanelScrollView;
    if (this.wyM != null)
    {
      localSmileyPanelScrollView = this.wyM;
      localSmileyPanelScrollView.wwp = paramInt;
      if (paramInt != 0) {
        break label79;
      }
      localSmileyPanelScrollView.wwl = localSmileyPanelScrollView.wvY;
      localSmileyPanelScrollView.wwk = localSmileyPanelScrollView.wvY;
      localSmileyPanelScrollView.wwm = 0.0F;
      localSmileyPanelScrollView.invalidate();
      if (localSmileyPanelScrollView.wwn) {
        localSmileyPanelScrollView.wwn = false;
      }
    }
    for (;;)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.wyW = this.wyK.getCurrentItem();
      }
      return;
      label79:
      if (paramInt == 1)
      {
        localSmileyPanelScrollView.wwl = localSmileyPanelScrollView.wvY;
        localSmileyPanelScrollView.wwk = localSmileyPanelScrollView.wvY;
        localSmileyPanelScrollView.wwm = 0.0F;
      }
    }
  }
  
  public final void R(int paramInt)
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.view.a.d locald;
    if (this.wyL != null)
    {
      localObject = this.wyL;
      ((com.tencent.mm.view.a.g)localObject).wwY = paramInt;
      if (((com.tencent.mm.view.a.g)localObject).wxa != null)
      {
        locald = ((com.tencent.mm.view.a.g)localObject).wxa;
        locald.wwS = paramInt;
        if (paramInt != 0) {
          break label106;
        }
        locald.aS(0.0F);
      }
      if ((paramInt != 0) && (((com.tencent.mm.view.a.g)localObject).wwZ))
      {
        ((com.tencent.mm.view.a.g)localObject).aw(((com.tencent.mm.view.a.g)localObject).wwY, false);
        ((com.tencent.mm.view.a.g)localObject).wwZ = false;
      }
    }
    if (this.wvQ == null) {}
    label106:
    while (!this.wvQ.wzV)
    {
      return;
      locald.aS(1.0F);
      break;
    }
    Object localObject = this.wvQ.IV(paramInt);
    label246:
    int i;
    boolean bool1;
    label281:
    int j;
    int k;
    if (((com.tencent.mm.view.c.a)localObject).iZD.equals("TAG_STORE_TAB"))
    {
      this.wyQ.setSelected(true);
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[] { Integer.valueOf(this.wyQ.getId()), "TAG_STORE_TAB" });
      this.wvQ.setShowProductId("TAG_STORE_TAB");
      com.tencent.mm.plugin.report.service.h.nFQ.f(11594, new Object[] { Integer.valueOf(5) });
      com.tencent.mm.y.c.BS().bd(262147, 266244);
      com.tencent.mm.y.c.BS().bd(262149, 266244);
      cLO();
      i = paramInt - ((com.tencent.mm.view.c.a)localObject).hxB;
      if ((!this.wvQ.cMh()) || (!((com.tencent.mm.view.c.a)localObject).iZD.equals("TAG_DEFAULT_TAB"))) {
        break label603;
      }
      bool1 = true;
      j = ((com.tencent.mm.view.c.a)localObject).cLI();
      k = ((com.tencent.mm.view.c.a)localObject).hxB;
      if (this.wyX) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool2 = true;; bool2 = false)
    {
      f(j, paramInt - k, bool2, bool1);
      this.wvQ.wzE = i;
      this.wvQ.setShowProductId(((com.tencent.mm.view.c.a)localObject).iZD);
      ((com.tencent.mm.view.c.a)localObject).wyF = i;
      this.wvQ.dN(((com.tencent.mm.view.c.a)localObject).iZD, ((com.tencent.mm.view.c.a)localObject).wyF);
      IT(this.wvQ.IW(paramInt));
      b(this.wvQ.IW(paramInt) - 1, false, true);
      b(this.wvQ.IW(paramInt) + 1, false, true);
      cLQ();
      if ((this.wvQ.fzn == ChatFooterPanel.rZv) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHu()) && (i == 0) && (((com.tencent.mm.view.c.a)localObject).iZD.equals(String.valueOf(EmojiGroupInfo.uCR))))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15982, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        this.wyK.post(new a.4(this));
      }
      if ((this.wvQ.fzn != ChatFooterPanel.rZv) || (!((com.tencent.mm.view.c.a)localObject).iZD.equals(String.valueOf(EmojiGroupInfo.uCR))) || (b.NC().ekI)) {
        break;
      }
      y.i("MicroMsg.FontResLogic", "check res early");
      com.tencent.mm.plugin.report.service.h.nFQ.h(933L, 11L, 1L);
      b.NE();
      return;
      this.wyQ.setSelected(false);
      break label246;
      bool1 = false;
      break label281;
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1;
    if (this.wyL != null)
    {
      localObject1 = this.wyL;
      if (((com.tencent.mm.view.a.g)localObject1).wxa != null)
      {
        localObject1 = ((com.tencent.mm.view.a.g)localObject1).wxa;
        float f = paramInt1 + paramFloat;
        ((com.tencent.mm.view.a.d)localObject1).wwS = Math.round(f);
        ((com.tencent.mm.view.a.d)localObject1).aS(f);
      }
    }
    if ((this.wyM != null) && (paramFloat != 0.0F)) {
      if (paramFloat <= 0.0F) {
        break label147;
      }
    }
    label147:
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      Object localObject2 = this.wvQ.IV(paramInt2 + paramInt1);
      localObject1 = this.wvQ.IV(paramInt1);
      if (localObject2 != localObject1) {
        break;
      }
      localObject2 = this.wyM;
      paramInt1 -= ((com.tencent.mm.view.c.a)localObject1).hxB;
      ((SmileyPanelScrollView)localObject2).wwm = paramFloat;
      if (((SmileyPanelScrollView)localObject2).wwl != paramInt1) {
        ((SmileyPanelScrollView)localObject2).wwl = paramInt1;
      }
      ((SmileyPanelScrollView)localObject2).invalidate();
      this.wyX = true;
      return;
    }
    this.wyX = false;
  }
  
  public final void cLK()
  {
    long l1;
    long l2;
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      try
      {
        if ((this.mView == null) || (!this.wvQ.wzV))
        {
          y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
          return;
        }
        l1 = System.currentTimeMillis();
        this.wvQ.wzJ = false;
        y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
        l2 = System.currentTimeMillis();
        com.tencent.mm.view.f.a locala = this.wvQ;
        if (locala.wzR == null) {
          break;
        }
        localObject3 = locala.wzR.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.view.c.a)((Iterator)localObject3).next();
        if (localObject4 != null) {
          y.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[] { ((com.tencent.mm.view.c.a)localObject4).iZD });
        } else {
          y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
        }
      }
      finally {}
    }
    if (localObject1.wzR != null) {
      localObject1.wzR.clear();
    }
    Object localObject2;
    if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().fc(true) <= 2)
    {
      com.tencent.mm.ca.a.cpp();
      localObject2 = com.tencent.mm.ca.a.uaN;
      if (!a.b.EV(208912)) {
        break label913;
      }
    }
    for (;;)
    {
      localObject3 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHn();
      com.tencent.mm.ca.a.cpp();
      localObject2 = com.tencent.mm.ca.a.uaO;
      int j;
      int k;
      int m;
      if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
      {
        j = com.tencent.mm.m.g.AA().getInt("EmotionRecommandCount", 3);
        k = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().aHo();
        m = j - k;
        y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(k) });
        localObject2 = new ArrayList();
        if (!this.wvQ.wzG)
        {
          ((ArrayList)localObject2).add(com.tencent.mm.view.f.a.cLX());
          a(com.tencent.mm.view.f.a.cLX(), true);
        }
        if (this.wvQ.wzF) {
          break label575;
        }
        if (i != 0)
        {
          ((ArrayList)localObject2).add(com.tencent.mm.view.f.a.cLY());
          a(com.tencent.mm.view.f.a.cLY(), true);
        }
        if (localObject3 != null)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          k = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label554;
          }
          localObject4 = (EmojiGroupInfo)((Iterator)localObject3).next();
          if ((localObject4 != null) && (!bk.bl(((EmojiGroupInfo)localObject4).field_productID)))
          {
            if (((EmojiGroupInfo)localObject4).field_recommand == 1)
            {
              if ((k >= m) || (k >= j)) {
                continue;
              }
              k += 1;
              a((EmojiGroupInfo)localObject4, com.tencent.mm.view.f.a.d((EmojiGroupInfo)localObject4));
              ((ArrayList)localObject2).add(localObject4);
              continue;
              j = ((a.c)localObject2).getInt("EmotionRecommandCount", 3);
              break;
            }
            if ((!((EmojiGroupInfo)localObject4).field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.uCR))) && (!((EmojiGroupInfo)localObject4).field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB")))
            {
              a((EmojiGroupInfo)localObject4, com.tencent.mm.view.f.a.d((EmojiGroupInfo)localObject4));
              ((ArrayList)localObject2).add(localObject4);
            }
          }
        }
      }
      label554:
      if (i == 0)
      {
        ((ArrayList)localObject2).add(com.tencent.mm.view.f.a.cLY());
        a(com.tencent.mm.view.f.a.cLY(), true);
      }
      label575:
      localObject3 = this.wyO;
      ((com.tencent.mm.view.a.h)localObject3).mData.clear();
      ((com.tencent.mm.view.a.h)localObject3).mData.addAll((Collection)localObject2);
      ((com.tencent.mm.view.a.h)localObject3).notifyDataSetChanged();
      y.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "update %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.view.a.h)localObject3).mData.size()), Integer.valueOf(((ArrayList)localObject2).size()) });
      cLO();
      this.wvQ.cMc();
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
      if (this.wyK == null)
      {
        y.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
        cLL();
        this.wvQ.wzJ = true;
        this.wvQ.wzM = true;
        if (this.wvQ.wzK) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(406L, 6L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(406L, 8L, System.currentTimeMillis() - l1, false);
        break;
      }
      if (this.wyL == null)
      {
        cLN();
        this.wvQ.cMb();
        this.wyK.setAdapter(this.wyL);
        this.wyK.setOffscreenPageLimit(1);
      }
      for (;;)
      {
        this.wzb = com.tencent.mm.compatible.util.j.fA(this.ze);
        break;
        boolean bool = com.tencent.mm.compatible.util.j.fA(this.ze);
        if (bool != this.wzb)
        {
          y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed " + bool);
          cLN();
          this.wyK.setAdapter(this.wyL);
        }
        this.wyL.wwX = true;
        this.wyL.cLz();
        this.wyL.notifyDataSetChanged();
        this.wyL.wwX = false;
      }
      int i = 1;
      continue;
      label913:
      i = 0;
    }
  }
  
  public final void cLL()
  {
    com.tencent.mm.view.c.a locala2 = this.wvQ.cMb();
    com.tencent.mm.view.c.a locala1 = locala2;
    if (locala2 == null)
    {
      this.wvQ.setShowProductId("TAG_DEFAULT_TAB");
      locala1 = this.wvQ.cMb();
    }
    cLQ();
    int j;
    if ((locala1 != null) && (this.wyK != null))
    {
      j = this.wvQ.wzE;
      int i;
      if (j >= 0)
      {
        i = j;
        if (j <= locala1.cLI() - 1) {}
      }
      else
      {
        i = locala1.cLI() - 1;
      }
      j = i;
      if (this.wza)
      {
        j = i + 1;
        this.wza = false;
      }
      this.wyW = (locala1.hxB + j);
      this.wyK.m(this.wyW, false);
      if ((!this.wvQ.cMh()) || (!locala1.iZD.equals("TAG_DEFAULT_TAB"))) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      if (!locala1.iZD.equals("TAG_STORE_TAB")) {
        y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
      }
      f(locala1.cLI(), j + 0, false, bool);
      if ((locala1.iZD.equals(String.valueOf(EmojiGroupInfo.uCR))) && (locala1.hxB == 0) && (this.wvQ.fzn == ChatFooterPanel.rZv) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aHu())) {
        this.wyK.post(new a.3(this));
      }
      return;
    }
  }
  
  public final void cLM()
  {
    if (this.wyL != null)
    {
      y.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
      this.wyL.mCount = 0;
    }
  }
  
  public final void cLO()
  {
    if (this.wyQ == null) {
      return;
    }
    if ((com.tencent.mm.view.f.a.cLT()) && (!this.wvQ.wzD.equalsIgnoreCase("TAG_STORE_TAB"))) {
      this.wyR.setVisibility(0);
    }
    for (;;)
    {
      this.wyQ.setContentDescription(this.ze.getString(a.h.emotion_add));
      return;
      this.wyR.setVisibility(8);
    }
  }
  
  public final void cLQ()
  {
    if (this.wvQ.wzD.equals("TAG_DEFAULT_TAB")) {}
    for (int i = 1; i != 0; i = 0)
    {
      if ((this.wyV != null) && (this.wyV.getTextOpListener() != null)) {
        this.wyV.getTextOpListener().hp(true);
      }
      if (this.wvQ.cLZ())
      {
        this.wvQ.wzL = false;
        Object localObject = cLP();
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        if ((this.wyU != null) && (this.wyU.getVisibility() != 0))
        {
          localObject = new TranslateAnimation(this.wyU.getWidth(), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setDuration(250L);
          this.wyU.startAnimation((Animation)localObject);
          this.wyU.setVisibility(0);
        }
      }
      return;
    }
    if ((this.wyV != null) && (this.wyV.getTextOpListener() != null)) {
      this.wyV.getTextOpListener().hp(false);
    }
    oe(true);
  }
  
  public final void cLR()
  {
    this.wyY = false;
    this.mHandler.removeMessages(1102);
    this.mHandler.sendEmptyMessageDelayed(1102, 100L);
  }
  
  public final View findViewById(int paramInt)
  {
    return this.mView.findViewById(paramInt);
  }
  
  public final void oe(boolean paramBoolean)
  {
    Object localObject = cLP();
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.wyU == null) {}
    while (this.wyU.getVisibility() != 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = new TranslateAnimation(0.0F, this.wyU.getWidth(), 0.0F, 0.0F);
      ((TranslateAnimation)localObject).setDuration(250L);
      this.wyU.startAnimation((Animation)localObject);
    }
    this.wyU.setVisibility(8);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView == this.wyQ)
    {
      paramView = new Intent();
      paramView.putExtra("preceding_scence", 13);
      paramView.putExtra("download_entrance_scene", 17);
      paramView.putExtra("check_clickflag", false);
      if (com.tencent.mm.view.f.a.cLS())
      {
        y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
        paramView.putExtra("emoji_stroe_must_refresh_by_net", true);
      }
      if (!bk.bl(this.wvQ.seQ)) {
        paramView.putExtra("to_talker_name", this.wvQ.seQ);
      }
      com.tencent.mm.br.d.b(this.ze, "emoji", ".ui.v2.EmojiStoreV2UI", paramView);
      com.tencent.mm.plugin.report.service.h.nFQ.f(11594, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(12065, new Object[] { Integer.valueOf(8) });
    }
    do
    {
      do
      {
        return;
        if (paramView != this.wyU) {
          break;
        }
      } while ((this.wyV == null) || (this.wyV.getTextOpListener() == null));
      this.wyV.getTextOpListener().bgv();
      return;
      if ((paramView == this.wyT) && (this.wyV.getSmileyPanelCallback() != null)) {
        this.wyV.getSmileyPanelCallback().bhE();
      }
    } while (paramView != this.xwh);
    cVA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.e.a
 * JD-Core Version:    0.7.0.1
 */