package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.of;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.base.MMRadioGroupView.d;
import com.tencent.mm.view.ScrollRectRecyclerView;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.SmileyPanelViewPager.a;
import com.tencent.mm.view.a.f;
import com.tencent.mm.view.a.i;
import com.tencent.mm.view.a.j.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  implements ViewPager.OnPageChangeListener, View.OnClickListener, MMRadioGroupView.d, SmileyPanelScrollView.b, SmileyPanelViewPager.a
{
  private static boolean AUu = true;
  public com.tencent.mm.view.f.a AQS;
  private final int ATZ;
  private final int AUa;
  private final int AUb;
  private final int AUc;
  public SmileyPanelViewPager AUd;
  public i AUe;
  public SmileyPanelScrollView AUf;
  public ScrollRectRecyclerView AUg;
  public com.tencent.mm.view.a.j AUh;
  public View AUi;
  public ImageView AUj;
  public ImageView AUk;
  public ImageButton AUl;
  public TextView AUm;
  public ImageView AUn;
  private a.a AUo;
  private int AUp;
  private boolean AUq;
  private boolean AUr;
  private String AUs;
  private boolean AUt;
  public final k.a AUv;
  public final com.tencent.mm.sdk.b.c<da> AUw;
  public final k.a AUx;
  public j.a AUy;
  private final String TAG;
  private int bdH;
  private int bdI;
  public Context jpJ;
  private ak mHandler;
  public View mView;
  public final k.a yNF;
  public final com.tencent.mm.sdk.b.c yNG;
  private Context zF;
  
  public a(Context paramContext, com.tencent.mm.view.f.a parama, a.a parama1)
  {
    AppMethodBeat.i(63035);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    this.ATZ = 100;
    this.AUa = 1102;
    this.AUb = 1103;
    this.AUc = 100;
    this.AUp = -1;
    this.AUq = false;
    this.AUr = true;
    this.AUt = false;
    this.mHandler = new a.1(this);
    this.AUv = new a.6(this);
    this.yNF = new a.7(this);
    this.yNG = new com.tencent.mm.sdk.b.c() {};
    this.AUw = new a.9(this);
    this.AUx = new a.10(this);
    this.AUy = new a.2(this);
    this.zF = ah.getContext();
    this.jpJ = paramContext;
    this.AQS = parama;
    this.AUo = parama1;
    ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().h(this.AUv);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().f(this.yNF);
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().j(this.AUx);
    com.tencent.mm.sdk.b.a.ymk.c(this.yNG);
    com.tencent.mm.sdk.b.a.ymk.c(this.AUw);
    if (AUu)
    {
      AUu = false;
      paramContext = com.tencent.mm.emoji.a.d.Oz().ci(true).iterator();
      while (paramContext.hasNext())
      {
        parama = (EmojiInfo)paramContext.next();
        if (EmojiInfo.a.yPC == parama.dzx())
        {
          parama.a(EmojiInfo.a.yPD);
          parama.a(EmojiInfo.b.yPU);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(parama);
          EmojiCaptureReporter.g(parama.field_captureEnterTime, 5, parama.field_captureScene);
        }
        else if (parama.dzx() == EmojiInfo.a.yPE)
        {
          parama.a(EmojiInfo.a.yPF);
          ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(parama);
          EmojiCaptureReporter.f(parama.field_captureEnterTime, 3, parama.field_captureScene);
        }
      }
    }
    AppMethodBeat.o(63035);
  }
  
  private void a(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(63041);
    this.AQS.a(paramEmojiGroupInfo, this, paramBoolean);
    AppMethodBeat.o(63041);
  }
  
  private void dRi()
  {
    AppMethodBeat.i(63040);
    dRh();
    this.AUe = new i(this.AQS, this.jpJ);
    AppMethodBeat.o(63040);
  }
  
  private void dRk()
  {
    AppMethodBeat.i(63044);
    com.tencent.mm.bq.d.b(this.zF, "emoji", ".ui.EmojiMineUI", new Intent());
    AppMethodBeat.o(63044);
  }
  
  private void dRn()
  {
    AppMethodBeat.i(63055);
    if (this.AQS.avT("TAG_DEFAULT_TAB"))
    {
      if ((this.AUo != null) && (this.AUo.getTextOpListener() != null)) {
        this.AUo.getTextOpListener().fT(true);
      }
      if (this.AQS.dRy())
      {
        dRl();
        AppMethodBeat.o(63055);
      }
    }
    else
    {
      if ((this.AUo != null) && (this.AUo.getTextOpListener() != null)) {
        this.AUo.getTextOpListener().fT(false);
      }
      rO(true);
    }
    AppMethodBeat.o(63055);
  }
  
  private void g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63038);
    if (paramInt1 <= 1)
    {
      this.AUf.setVisibility(4);
      AppMethodBeat.o(63038);
      return;
    }
    this.AUf.setVisibility(0);
    this.AUf.f(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(63038);
  }
  
  private void setTabSelected(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(63053);
    Object localObject;
    int i;
    ScrollRectRecyclerView localScrollRectRecyclerView;
    if ((this.AUg != null) && (this.AUh != null))
    {
      localObject = this.AUh;
      if (((com.tencent.mm.view.a.j)localObject).lxQ != paramInt)
      {
        ((com.tencent.mm.view.a.j)localObject).bR(((com.tencent.mm.view.a.j)localObject).lxQ);
        ((com.tencent.mm.view.a.j)localObject).lxQ = paramInt;
        ((com.tencent.mm.view.a.j)localObject).bR(((com.tencent.mm.view.a.j)localObject).lxQ);
      }
      i = this.AQS.lrK;
      localObject = new Rect();
      ((Rect)localObject).left = (i * paramInt);
      ((Rect)localObject).right = (i * (paramInt + 1));
      localScrollRectRecyclerView = this.AUg;
      if (((Rect)localObject).left >= localScrollRectRecyclerView.scrollX) {
        break label247;
      }
    }
    label247:
    for (paramInt = ((Rect)localObject).left - localScrollRectRecyclerView.scrollX;; paramInt = 0)
    {
      i = paramInt;
      if (((Rect)localObject).right > localScrollRectRecyclerView.scrollX + localScrollRectRecyclerView.getMeasuredWidth()) {
        i = ((Rect)localObject).right - (localScrollRectRecyclerView.scrollX + localScrollRectRecyclerView.getMeasuredWidth());
      }
      paramInt = j;
      if (((Rect)localObject).top < localScrollRectRecyclerView.scrollY) {
        paramInt = ((Rect)localObject).top - localScrollRectRecyclerView.scrollY;
      }
      if (((Rect)localObject).bottom > localScrollRectRecyclerView.scrollY + localScrollRectRecyclerView.getMeasuredHeight()) {
        paramInt = ((Rect)localObject).bottom - (localScrollRectRecyclerView.scrollY + localScrollRectRecyclerView.getMeasuredHeight());
      }
      localScrollRectRecyclerView.a(i, paramInt, null);
      AppMethodBeat.o(63053);
      return;
    }
  }
  
  public final void OJ(int paramInt)
  {
    AppMethodBeat.i(63057);
    if (paramInt > 0)
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
      com.tencent.mm.view.f.a locala = this.AQS;
      String str = locala.AUZ;
      if (locala.AVn == null) {
        break label97;
      }
      paramInt = 0;
      if (paramInt >= locala.AVn.size()) {
        break label97;
      }
      com.tencent.mm.view.c.a locala1 = (com.tencent.mm.view.c.a)locala.AVn.get(paramInt);
      if ((locala1 == null) || (!locala1.liu.equals(str))) {
        break label90;
      }
    }
    for (;;)
    {
      setTabSelected(paramInt);
      AppMethodBeat.o(63057);
      return;
      label90:
      paramInt += 1;
      break;
      label97:
      paramInt = 0;
    }
  }
  
  public final void RF(int paramInt)
  {
    AppMethodBeat.i(63048);
    if (this.AUd != null)
    {
      int i = this.AUd.getCurrentItem();
      paramInt = this.AQS.RO(i).jpL + paramInt;
      if (paramInt != i)
      {
        Math.abs(paramInt - i);
        this.AUd.setCurrentItem(paramInt);
      }
      this.AUp = paramInt;
    }
    AppMethodBeat.o(63048);
  }
  
  /* Error */
  public final void RG(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 540
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 157	com/tencent/mm/view/e/a:AQS	Lcom/tencent/mm/view/f/a;
    //   12: getfield 541	com/tencent/mm/view/f/a:zF	Landroid/content/Context;
    //   15: invokestatic 547	com/tencent/mm/sdk/platformtools/x:gN	(Landroid/content/Context;)Z
    //   18: ifeq +65 -> 83
    //   21: aload_0
    //   22: getfield 157	com/tencent/mm/view/e/a:AQS	Lcom/tencent/mm/view/f/a;
    //   25: getfield 550	com/tencent/mm/view/f/a:AVl	Z
    //   28: ifne +18 -> 46
    //   31: aload_0
    //   32: getfield 157	com/tencent/mm/view/e/a:AQS	Lcom/tencent/mm/view/f/a;
    //   35: astore_2
    //   36: aload_2
    //   37: iconst_1
    //   38: putfield 550	com/tencent/mm/view/f/a:AVl	Z
    //   41: aload_2
    //   42: iconst_0
    //   43: putfield 553	com/tencent/mm/view/f/a:AVm	Z
    //   46: ldc 92
    //   48: ldc_w 555
    //   51: invokestatic 166	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: iload_1
    //   55: ifle +19 -> 74
    //   58: aload_0
    //   59: getfield 557	com/tencent/mm/view/e/a:mView	Landroid/view/View;
    //   62: new 559	com/tencent/mm/view/e/a$4
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 560	com/tencent/mm/view/e/a$4:<init>	(Lcom/tencent/mm/view/e/a;)V
    //   70: invokevirtual 566	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: ldc_w 540
    //   77: invokestatic 288	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield 157	com/tencent/mm/view/e/a:AQS	Lcom/tencent/mm/view/f/a;
    //   87: getfield 553	com/tencent/mm/view/f/a:AVm	Z
    //   90: ifne -44 -> 46
    //   93: aload_0
    //   94: getfield 157	com/tencent/mm/view/e/a:AQS	Lcom/tencent/mm/view/f/a;
    //   97: astore_2
    //   98: aload_2
    //   99: iconst_1
    //   100: putfield 553	com/tencent/mm/view/f/a:AVm	Z
    //   103: aload_2
    //   104: iconst_0
    //   105: putfield 550	com/tencent/mm/view/f/a:AVl	Z
    //   108: goto -62 -> 46
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	a
    //   0	116	1	paramInt	int
    //   35	69	2	locala	com.tencent.mm.view.f.a
    //   111	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	111	finally
    //   46	54	111	finally
    //   58	74	111	finally
    //   74	80	111	finally
    //   83	108	111	finally
  }
  
  public final void aRM()
  {
    AppMethodBeat.i(63037);
    com.tencent.mm.view.c.a locala2 = this.AQS.dRz();
    com.tencent.mm.view.c.a locala1 = locala2;
    if (locala2 == null)
    {
      this.AQS.setShowProductId("TAG_DEFAULT_TAB");
      locala1 = this.AQS.dRz();
    }
    dRn();
    int j;
    if ((locala1 != null) && (this.AUd != null))
    {
      j = this.AQS.AVa;
      int i;
      if (j >= 0)
      {
        i = j;
        if (j <= locala1.dRf() - 1) {}
      }
      else
      {
        i = locala1.dRf() - 1;
      }
      j = i;
      if (this.AUt)
      {
        j = i + 1;
        this.AUt = false;
      }
      if (this.AQS.AVb) {
        j = 0;
      }
      this.AUp = (locala1.jpL + j);
      this.AUd.setCurrentItem(this.AUp, false);
      if ((!this.AQS.dRF()) || (!locala1.liu.equals("TAG_DEFAULT_TAB"))) {
        break label212;
      }
    }
    label212:
    for (boolean bool = true;; bool = false)
    {
      if (!locala1.liu.equals("TAG_STORE_TAB"))
      {
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
        g(locala1.dRf(), j, false, bool);
      }
      AppMethodBeat.o(63037);
      return;
    }
  }
  
  public final void atp(String paramString)
  {
    AppMethodBeat.i(151749);
    if ((this.AUd == null) || (this.AQS == null))
    {
      AppMethodBeat.o(151749);
      return;
    }
    if (!this.AUr)
    {
      this.AUs = paramString;
      AppMethodBeat.o(151749);
      return;
    }
    this.AUs = null;
    this.AUd.post(new a.5(this, paramString));
    AppMethodBeat.o(151749);
  }
  
  public final void dRg()
  {
    int i = 0;
    long l1;
    long l2;
    Object localObject4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63036);
        if ((this.mView == null) || (!this.AQS.AVr))
        {
          ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
          AppMethodBeat.o(63036);
          return;
        }
        l1 = System.currentTimeMillis();
        this.AQS.AVg = false;
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
        l2 = System.currentTimeMillis();
        com.tencent.mm.view.f.a locala = this.AQS;
        if (locala.AVn == null) {
          break;
        }
        localObject3 = locala.AVn.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (com.tencent.mm.view.c.a)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ab.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[] { ((com.tencent.mm.view.c.a)localObject4).liu });
        } else {
          ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
        }
      }
      finally {}
    }
    if (localObject1.AVn != null) {
      localObject1.AVn.clear();
    }
    Object localObject3 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().OB();
    com.tencent.mm.ca.a.dqM();
    Object localObject2 = com.tencent.mm.ca.a.yiI;
    int k;
    label235:
    int j;
    int n;
    int m;
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      k = com.tencent.mm.m.g.Nq().getInt("EmotionRecommandCount", 3);
      j = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().blc();
      n = k - j;
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(j) });
      localObject2 = new ArrayList();
      if (!this.AQS.AVc)
      {
        ((ArrayList)localObject2).add(com.tencent.mm.view.f.a.dRw());
        a(com.tencent.mm.view.f.a.dRw(), true);
      }
      if (this.AQS.AVb) {
        break label637;
      }
      ((ArrayList)localObject2).add(com.tencent.mm.view.f.a.dRx());
      a(com.tencent.mm.view.f.a.dRx(), true);
      if ((this.AQS.AVd) && ((com.tencent.mm.view.f.a.RR(this.AQS.mScene)) || (com.tencent.mm.emoji.a.d.Oz().ci(false).size() > 0)))
      {
        localObject4 = new EmojiGroupInfo();
        ((EmojiGroupInfo)localObject4).field_productID = "capture";
        ((ArrayList)localObject2).add(localObject4);
        a((EmojiGroupInfo)localObject4, true);
      }
      if (this.AQS.mScene != ChatFooterPanel.vQm) {
        break label1089;
      }
      m = 1;
      label440:
      if (localObject3 == null) {
        break label637;
      }
      localObject3 = ((ArrayList)localObject3).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (EmojiGroupInfo)((Iterator)localObject3).next();
        j = i;
        if (localObject4 == null) {
          break label1095;
        }
        j = i;
        if (bo.isNullOrNil(((EmojiGroupInfo)localObject4).field_productID)) {
          break label1095;
        }
        boolean bool = com.tencent.mm.view.f.a.e((EmojiGroupInfo)localObject4);
        if (((EmojiGroupInfo)localObject4).field_recommand == 1)
        {
          if ((i >= n) || (i >= k)) {
            continue;
          }
          i += 1;
          if (!bool)
          {
            j = i;
            if (m == 0) {
              break label1095;
            }
          }
          a((EmojiGroupInfo)localObject4, bool);
          ((ArrayList)localObject2).add(localObject4);
          continue;
          k = ((a.c)localObject2).getInt("EmotionRecommandCount", 3);
          break label235;
        }
        j = i;
        if (((EmojiGroupInfo)localObject4).field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.yPe))) {
          break label1095;
        }
        j = i;
        if (((EmojiGroupInfo)localObject4).field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB")) {
          break label1095;
        }
        if (!bool)
        {
          j = i;
          if (m == 0) {
            break label1095;
          }
        }
        a((EmojiGroupInfo)localObject4, bool);
        ((ArrayList)localObject2).add(localObject4);
        j = i;
        break label1095;
      }
      label637:
      localObject3 = this.AUh;
      ((com.tencent.mm.view.a.j)localObject3).mData.clear();
      ((com.tencent.mm.view.a.j)localObject3).mData.addAll((Collection)localObject2);
      ((RecyclerView.a)localObject3).ajb.notifyChanged();
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "update %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.view.a.j)localObject3).mData.size()), Integer.valueOf(((ArrayList)localObject2).size()) });
      dRj();
      this.AQS.dRB();
      localObject3 = this.AQS.avU(String.valueOf(EmojiGroupInfo.yPe));
      if (localObject3 != null)
      {
        com.tencent.mm.emoji.c.c.Pb().exm = ((com.tencent.mm.view.c.a)localObject3).aRG();
        com.tencent.mm.emoji.c.c.Pb().exn = ((com.tencent.mm.view.c.a)localObject3).uEK;
      }
      com.tencent.mm.emoji.c.c.Pb().exs = ((ArrayList)localObject2).size();
      localObject2 = this.AQS.avU("TAG_DEFAULT_TAB");
      if (localObject2 != null)
      {
        com.tencent.mm.emoji.c.b.Pa().exm = (((com.tencent.mm.view.c.a)localObject2).aRG() - 1);
        com.tencent.mm.emoji.c.b.Pa().exn = ((com.tencent.mm.view.c.a)localObject2).uEK;
      }
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
      if (this.AUd == null)
      {
        ab.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
        aRM();
        this.AQS.AVg = true;
        this.AQS.AVi = true;
        if (!this.AQS.AHW)
        {
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(406L, 6L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(406L, 8L, System.currentTimeMillis() - l1, false);
        }
        AppMethodBeat.o(63036);
        break;
      }
      i = this.AUd.getWidth();
      j = this.AUd.getHeight();
      if (this.AUe == null)
      {
        dRi();
        this.AQS.dRz();
        this.AUd.setAdapter(this.AUe);
        this.AUd.setOffscreenPageLimit(1);
      }
      for (;;)
      {
        this.bdH = i;
        this.bdI = j;
        break;
        if ((this.bdH != i) || (this.bdI != j))
        {
          ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          dRi();
          this.AUd.setAdapter(this.AUe);
        }
        this.AUe.ASf = true;
        this.AUe.refreshData();
        this.AUe.notifyDataSetChanged();
        this.AUe.ASf = false;
      }
      label1089:
      m = 0;
      break label440;
      label1095:
      i = j;
    }
  }
  
  public final void dRh()
  {
    AppMethodBeat.i(63039);
    if (this.AUe != null)
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
      this.AUe.mCount = 0;
    }
    AppMethodBeat.o(63039);
  }
  
  public final void dRj()
  {
    AppMethodBeat.i(63042);
    if (this.AUj == null)
    {
      AppMethodBeat.o(63042);
      return;
    }
    if ((com.tencent.mm.view.f.a.dRr()) && (!this.AQS.AUZ.equalsIgnoreCase("TAG_STORE_TAB"))) {
      this.AUk.setVisibility(0);
    }
    for (;;)
    {
      this.AUj.setContentDescription(this.zF.getString(2131299289));
      AppMethodBeat.o(63042);
      return;
      this.AUk.setVisibility(8);
    }
  }
  
  public final void dRl()
  {
    AppMethodBeat.i(63047);
    this.AQS.AVh = false;
    if (this.AUm == null)
    {
      AppMethodBeat.o(63047);
      return;
    }
    if (this.AUm.getVisibility() != 0)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.AUm.getWidth(), 0.0F, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(250L);
      this.AUm.startAnimation(localTranslateAnimation);
      this.AUm.setVisibility(0);
    }
    AppMethodBeat.o(63047);
  }
  
  public final ChatFooterPanel.a dRm()
  {
    AppMethodBeat.i(63049);
    if (this.AUo == null)
    {
      AppMethodBeat.o(63049);
      return null;
    }
    ChatFooterPanel.a locala = this.AUo.getTextOpListener();
    AppMethodBeat.o(63049);
    return locala;
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(63058);
    this.AUr = false;
    this.mHandler.removeMessages(1102);
    this.mHandler.sendEmptyMessageDelayed(1102, 100L);
    AppMethodBeat.o(63058);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(63045);
    View localView = this.mView.findViewById(paramInt);
    AppMethodBeat.o(63045);
    return localView;
  }
  
  public final com.tencent.mm.pluginsdk.ui.chat.j getSmileyPanelCallback()
  {
    AppMethodBeat.i(63050);
    if (this.AUo == null)
    {
      AppMethodBeat.o(63050);
      return null;
    }
    com.tencent.mm.pluginsdk.ui.chat.j localj = this.AUo.getSmileyPanelCallback();
    AppMethodBeat.o(63050);
    return localj;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63043);
    if (paramView == this.AUj)
    {
      paramView = new Intent();
      paramView.putExtra("preceding_scence", 13);
      paramView.putExtra("download_entrance_scene", 17);
      paramView.putExtra("check_clickflag", false);
      if (com.tencent.mm.view.f.a.dRq())
      {
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
        paramView.putExtra("emoji_stroe_must_refresh_by_net", true);
      }
      if (!bo.isNullOrNil(this.AQS.vVU)) {
        paramView.putExtra("to_talker_name", this.AQS.vVU);
      }
      com.tencent.mm.bq.d.b(this.zF, "emoji", ".ui.v2.EmojiStoreV2UI", paramView);
      com.tencent.mm.plugin.report.service.h.qsU.e(11594, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.plugin.report.service.h.qsU.e(12065, new Object[] { Integer.valueOf(8) });
      AppMethodBeat.o(63043);
      return;
    }
    if (paramView == this.AUm)
    {
      if ((this.AUo != null) && (this.AUo.getTextOpListener() != null)) {
        this.AUo.getTextOpListener().bag();
      }
      AppMethodBeat.o(63043);
      return;
    }
    if ((paramView == this.AUl) && (this.AUo.getSmileyPanelCallback() != null)) {
      this.AUo.getSmileyPanelCallback().bPF();
    }
    if (paramView == this.AUn) {
      dRk();
    }
    AppMethodBeat.o(63043);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(63051);
    SmileyPanelScrollView localSmileyPanelScrollView;
    if (this.AUf != null)
    {
      localSmileyPanelScrollView = this.AUf;
      localSmileyPanelScrollView.ARr = paramInt;
      if (paramInt != 0) {
        break label91;
      }
      localSmileyPanelScrollView.ARn = localSmileyPanelScrollView.ARa;
      localSmileyPanelScrollView.ARm = localSmileyPanelScrollView.ARa;
      localSmileyPanelScrollView.ARo = 0.0F;
      localSmileyPanelScrollView.invalidate();
      if (localSmileyPanelScrollView.ARp) {
        localSmileyPanelScrollView.ARp = false;
      }
    }
    for (;;)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.AUp = this.AUd.getCurrentItem();
      }
      AppMethodBeat.o(63051);
      return;
      label91:
      if (paramInt == 1)
      {
        localSmileyPanelScrollView.ARn = localSmileyPanelScrollView.ARa;
        localSmileyPanelScrollView.ARm = localSmileyPanelScrollView.ARa;
        localSmileyPanelScrollView.ARo = 0.0F;
      }
    }
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(63052);
    Object localObject1;
    if (this.AUe != null)
    {
      localObject1 = this.AUe;
      if (((i)localObject1).ASi != null)
      {
        localObject1 = ((i)localObject1).ASi;
        float f = paramInt1 + paramFloat;
        ((f)localObject1).ASa = Math.round(f);
        ((f)localObject1).bD(f);
      }
    }
    if ((this.AUf != null) && (paramFloat != 0.0F))
    {
      if (paramFloat > 0.0F) {}
      for (paramInt2 = 1;; paramInt2 = -1)
      {
        Object localObject2 = this.AQS.RO(paramInt2 + paramInt1);
        localObject1 = this.AQS.RO(paramInt1);
        if (localObject2 != localObject1) {
          break;
        }
        localObject2 = this.AUf;
        paramInt1 -= ((com.tencent.mm.view.c.a)localObject1).jpL;
        ((SmileyPanelScrollView)localObject2).ARo = paramFloat;
        if (((SmileyPanelScrollView)localObject2).ARn != paramInt1) {
          ((SmileyPanelScrollView)localObject2).ARn = paramInt1;
        }
        ((SmileyPanelScrollView)localObject2).invalidate();
        this.AUq = true;
        AppMethodBeat.o(63052);
        return;
      }
      this.AUq = false;
    }
    AppMethodBeat.o(63052);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(63054);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[] { Integer.valueOf(paramInt) });
    f localf;
    if (this.AUe != null)
    {
      localObject = this.AUe;
      ((i)localObject).ASg = paramInt;
      if (((i)localObject).ASi != null)
      {
        localf = ((i)localObject).ASi;
        localf.ASa = paramInt;
        if (paramInt != 0) {
          break label118;
        }
        localf.bD(0.0F);
      }
    }
    for (;;)
    {
      if ((paramInt != 0) && (((i)localObject).ASh))
      {
        ((i)localObject).aM(((i)localObject).ASg, false);
        ((i)localObject).ASh = false;
      }
      if (this.AQS != null) {
        break;
      }
      AppMethodBeat.o(63054);
      return;
      label118:
      localf.bD(1.0F);
    }
    if (!this.AQS.AVr)
    {
      AppMethodBeat.o(63054);
      return;
    }
    Object localObject = this.AQS.RO(paramInt);
    int i;
    boolean bool1;
    label300:
    int j;
    int k;
    if (((com.tencent.mm.view.c.a)localObject).liu.equals("TAG_STORE_TAB"))
    {
      this.AUj.setSelected(true);
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[] { Integer.valueOf(this.AUj.getId()), "TAG_STORE_TAB" });
      this.AQS.setShowProductId("TAG_STORE_TAB");
      com.tencent.mm.plugin.report.service.h.qsU.e(11594, new Object[] { Integer.valueOf(5) });
      com.tencent.mm.x.c.PJ().ce(262147, 266244);
      com.tencent.mm.x.c.PJ().ce(262149, 266244);
      dRj();
      i = paramInt - ((com.tencent.mm.view.c.a)localObject).jpL;
      if ((!this.AQS.dRF()) || (!((com.tencent.mm.view.c.a)localObject).liu.equals("TAG_DEFAULT_TAB"))) {
        break label614;
      }
      bool1 = true;
      j = ((com.tencent.mm.view.c.a)localObject).dRf();
      k = ((com.tencent.mm.view.c.a)localObject).jpL;
      if (this.AUq) {
        break label620;
      }
    }
    label614:
    label620:
    for (boolean bool2 = true;; bool2 = false)
    {
      g(j, paramInt - k, bool2, bool1);
      this.AQS.AVa = i;
      this.AQS.setShowProductId(((com.tencent.mm.view.c.a)localObject).liu);
      ((com.tencent.mm.view.c.a)localObject).ATX = i;
      this.AQS.eX(((com.tencent.mm.view.c.a)localObject).liu, ((com.tencent.mm.view.c.a)localObject).ATX);
      paramInt = this.AQS.RP(paramInt);
      com.tencent.mm.emoji.c.c.Pb().exr = paramInt;
      com.tencent.mm.emoji.c.c.Pb().exl = i;
      com.tencent.mm.emoji.c.c.Pb().ext = ((com.tencent.mm.view.c.a)localObject).dRf();
      com.tencent.mm.emoji.c.b.Pa().exl = i;
      setTabSelected(paramInt);
      dRn();
      if ((com.tencent.mm.view.f.a.RR(this.AQS.mScene)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().OR()) && (i == 0) && (((com.tencent.mm.view.c.a)localObject).liu.equals("capture")))
      {
        com.tencent.mm.cn.d.aNX();
        com.tencent.mm.plugin.report.service.h.qsU.e(15982, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      if ((this.AQS.mScene == ChatFooterPanel.vQm) && (((com.tencent.mm.view.c.a)localObject).liu.equals(String.valueOf(EmojiGroupInfo.yPe))) && (!com.tencent.mm.ao.b.agp().fAY))
      {
        ab.i("MicroMsg.FontResLogic", "check res early");
        com.tencent.mm.plugin.report.service.h.qsU.j(933L, 11L, 1L);
        com.tencent.mm.ao.b.agr();
      }
      AppMethodBeat.o(63054);
      return;
      this.AUj.setSelected(false);
      break;
      bool1 = false;
      break label300;
    }
  }
  
  public final void rO(boolean paramBoolean)
  {
    AppMethodBeat.i(63046);
    if (this.AUm == null)
    {
      AppMethodBeat.o(63046);
      return;
    }
    if (this.AUm.getVisibility() == 0)
    {
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, this.AUm.getWidth(), 0.0F, 0.0F);
        localTranslateAnimation.setDuration(250L);
        this.AUm.startAnimation(localTranslateAnimation);
      }
      this.AUm.setVisibility(8);
    }
    AppMethodBeat.o(63046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.e.a
 * JD-Core Version:    0.7.0.1
 */