package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k ESL = null;
  private static DisplayMetrics aJt;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int pCv = -1;
  private static int pCx = -1;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a ESK;
  public long ESM;
  public String ESN;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b ESO;
  private boolean ESP;
  public int ESQ;
  public String ESR;
  public long ESS;
  public int EST;
  public boolean ESU;
  public final aw ESV;
  public int ahF;
  public long doH;
  public int mKJ;
  private View.OnKeyListener pCA;
  private transient ArrayList<WXRTEditText> pCs;
  private int pCw;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.ESM = -1L;
    this.ESN = "";
    this.doH = -1L;
    this.ESO = null;
    this.ESP = false;
    this.ESQ = -1;
    this.ESR = null;
    this.ESS = -1L;
    this.EST = 0;
    this.ESU = false;
    this.pCA = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.faG().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          localObject = k.this.faL();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          ae.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.faG().YE(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ae.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.faG().YE(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ae.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          switch (((WXRTEditText)localObject).getEditTextType())
          {
          default: 
          case 0: 
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
              ae.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
              int i = ((WXRTEditText)localObject).getSelectionStart();
              if (i != ((WXRTEditText)localObject).getSelectionEnd())
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              if (i == ((WXRTEditText)localObject).getParagraphsInSelection().avj)
              {
                ((WXRTEditText)localObject).pBY = true;
                k.this.b(u.ETv, Boolean.FALSE);
                k.this.b(u.ETw, Boolean.FALSE);
                k.this.b(u.ETu, Boolean.FALSE);
                k.a(k.this).kf(false);
                k.a(k.this).kg(false);
                k.a(k.this).kh(false);
                ((WXRTEditText)localObject).pBY = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(i.ESJ);
              c.faG().cfB();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.faG().Y(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.ERY.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.pAl = i;
              paramAnonymousKeyEvent.pAj = true;
              paramAnonymousKeyEvent.pAp = false;
              label585:
              if (!bool) {
                break label651;
              }
              k.b(k.this).fba().BH(paramAnonymousInt - 1);
            }
            if (!bu.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.faG().Y(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.ERX.setSelection(0);
          paramAnonymousKeyEvent.pAj = true;
          paramAnonymousKeyEvent.pAp = false;
          break label585;
          label651:
          k.b(k.this).fba().fe(paramAnonymousInt - 1, 2);
          break;
          ae.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.faG().cfB();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (bu.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.ERW.setSelection(0);
              paramAnonymousView.pAj = true;
              paramAnonymousView.pAp = true;
              c.faG().Y(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.pAl = -1;
            paramAnonymousKeyEvent.pAj = true;
            paramAnonymousKeyEvent.pAp = false;
          }
          for (;;)
          {
            k.b(k.this).fba().fe(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.ERX.setSelection(0);
            paramAnonymousKeyEvent.pAj = true;
            paramAnonymousKeyEvent.pAp = false;
          }
          ae.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).pAG.booleanValue()))
          {
            ae.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.pAq) && (paramAnonymousView.getType() != -1))
          {
            c.faG().Z(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return true;
          }
          c.faG().cfB();
          c.faG().Y(paramAnonymousInt, false);
          k.b(k.this).fba().BJ(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.pAj = true;
          paramAnonymousView.pAp = false;
          paramAnonymousView.content = "";
          paramAnonymousView.pAl = 0;
          c.faG().a(paramAnonymousInt, paramAnonymousView);
          c.faG().fh(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).ceS();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.ahE(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.ESV = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.faO();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.pCs = new ArrayList();
    this.ESK = parama;
    ESL = this;
    this.ahF = h.dX(parama.ceT());
    this.mKJ = al.jO(parama.ceT());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.eF(parama.ceT());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJt = parama.ceT().getResources().getDisplayMetrics();
    this.pCw = (mScreenHeight - this.ahF - this.mKJ - (int)aX(8.0F));
    this.ESN = c.faG().cfG();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.pDR = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float aX(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJt);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void cx(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        gx localgx = new gx();
        localgx.dub.type = 19;
        localgx.dub.doN = c.faG().abO(paramString);
        if (localgx.dub.doN == null)
        {
          ae.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localgx.dub.title = paramString;
        localgx.dub.doH = this.doH;
        paramString = localgx.dub;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.dui = i;
          localgx.dub.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.IvT.l(localgx);
          if (paramBoolean)
          {
            this.ESQ = localgx.dub.due.getIntExtra("fav_note_item_status", -1);
            this.ESR = localgx.dub.due.getStringExtra("fav_note_xml");
            this.ESS = localgx.dub.due.getLongExtra("fav_note_item_updatetime", -1L);
          }
          AppMethodBeat.o(30538);
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public static k faM()
  {
    return ESL;
  }
  
  private void faN()
  {
    AppMethodBeat.i(30539);
    if ((this.ESM < 0L) && (this.doH > 0L))
    {
      this.ESV.ay(60000L, 60000L);
      this.ESM = bu.HQ();
      this.ESN = c.faG().cfG();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void faQ()
  {
    AppMethodBeat.i(30543);
    if (ESL != null) {
      ESL.ESK.fba().vH(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void BL(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.ESK.fba().N(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.EST != 2) || (!this.ESU))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.ESK.fba().ff(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.pEv.iterator();
      boolean bool1 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2 = false;
      t localt;
      for (;;)
      {
        bool8 = bool1;
        bool7 = bool4;
        bool6 = bool3;
        bool5 = bool2;
        if (!localIterator.hasNext()) {
          break label186;
        }
        localt = (t)localIterator.next();
        if (!localt.s(paramWXRTEditText)) {
          break label237;
        }
        if ((localt instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b))
        {
          bool2 = true;
        }
        else if ((localt instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c))
        {
          bool3 = true;
        }
        else
        {
          if (!(localt instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.l)) {
            break;
          }
          bool4 = true;
        }
      }
      if (!(localt instanceof j)) {
        break label237;
      }
      bool1 = true;
    }
    label186:
    label237:
    for (;;)
    {
      break;
      bool8 = false;
      bool7 = false;
      bool6 = false;
      bool5 = false;
      this.ESO.ke(bool5);
      this.ESO.kf(bool6);
      this.ESO.kg(bool7);
      this.ESO.kh(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.ESJ);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.faG().YE(paramWXRTEditText.getRecyclerItemPosition());
      if ((localc != null) && (localc.getType() == 1))
      {
        int i;
        if (paramSpannable1 == null)
        {
          i = 0;
          if (paramSpannable2 != null) {
            break label128;
          }
        }
        label128:
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.c.c.abE(paramSpannable2.toString()))
        {
          if (!c.faG().fg(j - i, 0)) {
            break label140;
          }
          this.ESK.fba().ceH();
          this.ESK.fba().BH(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.c.c.abE(paramSpannable1.toString());
          break;
        }
        label140:
        c.faG().cfB();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).pAl = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).pAj = true;
        localc.pAp = false;
        paramWXRTEditText = c.faG();
        paramWXRTEditText.pBb = (j - i + paramWXRTEditText.pBb);
      }
      AppMethodBeat.o(30534);
      return;
    }
    paramWXRTEditText.setText("");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(30534);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.faG().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.faG().fh(paramInt - 1, paramInt + 1);
      AppMethodBeat.o(30534);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30532);
    if (paramBoolean) {}
    try
    {
      faN();
      this.ESK.fba().a(paramWXRTEditText, paramBoolean, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(30532);
    }
  }
  
  public final void b(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30536);
    this.ESK.fba().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = faL();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avj;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cfR();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cfS();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.pBZ = true;
      localWXRTEditText.pAt = paramt.cgC();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.ESK.fba().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void faE()
  {
    AppMethodBeat.i(30530);
    this.ESK.fba().faE();
    faN();
    AppMethodBeat.o(30530);
  }
  
  public final void faF()
  {
    AppMethodBeat.i(30535);
    this.ESK.fba().ceF();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText faL()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.faG();
    ArrayList localArrayList = this.pCs;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    label148:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc;
      try
      {
        if (((c)localObject1).mDataList == null)
        {
          if (this.pCs != null) {
            break;
          }
          AppMethodBeat.o(30528);
          return null;
        }
        Iterator localIterator = ((c)localObject1).mDataList.iterator();
        if (!localIterator.hasNext()) {
          break label148;
        }
        localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc.ERY != null)
        {
          localArrayList.add(localc.ERY);
          continue;
        }
        if (localc.ERW == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.ERX != null)
      {
        localObject2.add(localc.ERW);
        localObject2.add(localc.ERX);
      }
    }
    localObject1 = this.pCs.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      WXRTEditText localWXRTEditText = (WXRTEditText)((Iterator)localObject1).next();
      if (localWXRTEditText.hasFocus())
      {
        AppMethodBeat.o(30528);
        return localWXRTEditText;
      }
    }
    AppMethodBeat.o(30528);
    return null;
  }
  
  public final void faO()
  {
    AppMethodBeat.i(30540);
    if ((this.doH > 0L) && (this.ESM > 0L))
    {
      String str = c.faG().cfG();
      if (!str.equals(this.ESN))
      {
        this.ESN = str;
        if (!this.ESP)
        {
          this.ESP = true;
          cx(this.ESN, true);
          AppMethodBeat.o(30540);
          return;
        }
        cx(this.ESN, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText faP()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = faL();
    if ((localWXRTEditText == null) && (this.pCs.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.pCs.get(this.pCs.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.ESV.stopTimer();
    this.ESM = -1L;
    if (ESL == this) {
      ESL = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.pBN == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cb.a.ax(paramWXRTEditText.getContext(), 2131165517));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.ESC = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.pCA);
    AppMethodBeat.o(30527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */