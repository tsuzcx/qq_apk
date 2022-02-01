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
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k BEm = null;
  private static DisplayMetrics aGM;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int ooH = -1;
  private static int ooJ = -1;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a BEl;
  public long BEn;
  public String BEo;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b BEp;
  private boolean BEq;
  public int BEr;
  public String BEs;
  public long BEt;
  public int BEu;
  public boolean BEv;
  public final av BEw;
  public int aeU;
  public long deL;
  public int lDk;
  private transient ArrayList<WXRTEditText> ooE;
  private int ooI;
  private View.OnKeyListener ooM;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.BEn = -1L;
    this.BEo = "";
    this.deL = -1L;
    this.BEp = null;
    this.BEq = false;
    this.BEr = -1;
    this.BEs = null;
    this.BEt = -1L;
    this.BEu = 0;
    this.BEv = false;
    this.ooM = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.esI().size() == 0)
          {
            AppMethodBeat.o(30524);
            return false;
          }
          WXRTEditText localWXRTEditText = k.this.esN();
          if (localWXRTEditText == null)
          {
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = localWXRTEditText.getRecyclerItemPosition();
          ad.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.esI().TZ(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ad.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.esI().TZ(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ad.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(30524);
            return false;
          }
          switch (localWXRTEditText.getEditTextType())
          {
          default: 
          case 0: 
            for (;;)
            {
              AppMethodBeat.o(30524);
              return true;
              ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
              int i = localWXRTEditText.getSelectionStart();
              if (i != localWXRTEditText.getSelectionEnd())
              {
                AppMethodBeat.o(30524);
                return false;
              }
              if (i == localWXRTEditText.getParagraphsInSelection().asw)
              {
                localWXRTEditText.ook = true;
                k.this.b(u.BEW, Boolean.FALSE);
                k.this.b(u.BEX, Boolean.FALSE);
                k.this.b(u.BEV, Boolean.FALSE);
                k.a(k.this).js(false);
                k.a(k.this).jt(false);
                k.a(k.this).ju(false);
                localWXRTEditText.ook = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = localWXRTEditText.a(i.BEk);
              c.esI().bSt();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.esI().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.BDz.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.omx = i;
              paramAnonymousKeyEvent.omv = true;
              paramAnonymousKeyEvent.omB = false;
              label450:
              if (!bool) {
                break label516;
              }
              k.b(k.this).etc().zV(paramAnonymousInt - 1);
            }
            if (!bt.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.esI().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.BDy.setSelection(0);
          paramAnonymousKeyEvent.omv = true;
          paramAnonymousKeyEvent.omB = false;
          break label450;
          label516:
          k.b(k.this).etc().eW(paramAnonymousInt - 1, 2);
          break;
          ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.esI().bSt();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (bt.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.BDx.setSelection(0);
              paramAnonymousView.omv = true;
              paramAnonymousView.omB = true;
              c.esI().W(paramAnonymousInt - 1, true);
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.omx = -1;
            paramAnonymousKeyEvent.omv = true;
            paramAnonymousKeyEvent.omB = false;
          }
          for (;;)
          {
            k.b(k.this).etc().eW(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.BDy.setSelection(0);
            paramAnonymousKeyEvent.omv = true;
            paramAnonymousKeyEvent.omB = false;
          }
          ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).omS.booleanValue()))
          {
            ad.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.omC) && (paramAnonymousView.getType() != -1))
          {
            c.esI().X(paramAnonymousInt, true);
            AppMethodBeat.o(30524);
            return true;
          }
          c.esI().bSt();
          c.esI().W(paramAnonymousInt, false);
          k.b(k.this).etc().zX(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.omv = true;
          paramAnonymousView.omB = false;
          paramAnonymousView.content = "";
          paramAnonymousView.omx = 0;
          c.esI().a(paramAnonymousInt, paramAnonymousView);
          c.esI().eZ(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).bRK();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.adn(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.lS(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.BEw = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.esQ();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.ooE = new ArrayList();
    this.BEl = parama;
    BEm = this;
    this.aeU = com.tencent.mm.pluginsdk.g.dL(parama.bRL());
    this.lDk = ai.jl(parama.bRL());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.et(parama.bRL());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aGM = parama.bRL().getResources().getDisplayMetrics();
    this.ooI = (mScreenHeight - this.aeU - this.lDk - (int)aQ(8.0F));
    this.BEo = c.esI().bSy();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.oqd = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float aQ(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aGM);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void ch(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        gs localgs = new gs();
        localgs.dkc.type = 19;
        localgs.dkc.deS = c.esI().Te(paramString);
        if (localgs.dkc.deS == null)
        {
          ad.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localgs.dkc.title = paramString;
        localgs.dkc.deL = this.deL;
        paramString = localgs.dkc;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.dkj = i;
          localgs.dkc.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.ESL.l(localgs);
          if (paramBoolean)
          {
            this.BEr = localgs.dkc.dkf.getIntExtra("fav_note_item_status", -1);
            this.BEs = localgs.dkc.dkf.getStringExtra("fav_note_xml");
            this.BEt = localgs.dkc.dkf.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k esO()
  {
    return BEm;
  }
  
  private void esP()
  {
    AppMethodBeat.i(30539);
    if ((this.BEn < 0L) && (this.deL > 0L))
    {
      this.BEw.av(60000L, 60000L);
      this.BEn = bt.GC();
      this.BEo = c.esI().bSy();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void esS()
  {
    AppMethodBeat.i(30543);
    if (BEm != null) {
      BEm.BEl.etc().tL(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.BEu != 2) || (!this.BEv))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.BEl.etc().eX(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.oqH.iterator();
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
      this.BEp.jr(bool5);
      this.BEp.js(bool6);
      this.BEp.jt(bool7);
      this.BEp.ju(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.BEk);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.esI().TZ(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.c.c.SU(paramSpannable2.toString()))
        {
          if (!c.esI().eY(j - i, 0)) {
            break label140;
          }
          this.BEl.etc().bRz();
          this.BEl.etc().zV(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.c.c.SU(paramSpannable1.toString());
          break;
        }
        label140:
        c.esI().bSt();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).omx = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).omv = true;
        localc.omB = false;
        paramWXRTEditText = c.esI();
        paramWXRTEditText.onn = (j - i + paramWXRTEditText.onn);
      }
      AppMethodBeat.o(30534);
      return;
    }
    paramWXRTEditText.setText("");
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(30534);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.esI().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.esI().eZ(paramInt - 1, paramInt + 1);
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
      esP();
      this.BEl.etc().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.BEl.etc().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = esN();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().asw;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.bSJ();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.bSK();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.ool = true;
      localWXRTEditText.omF = paramt.bTu();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.BEl.etc().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void esG()
  {
    AppMethodBeat.i(30530);
    this.BEl.etc().esG();
    esP();
    AppMethodBeat.o(30530);
  }
  
  public final void esH()
  {
    AppMethodBeat.i(30535);
    this.BEl.etc().bRx();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText esN()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.esI();
    ArrayList localArrayList = this.ooE;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    label148:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc;
      try
      {
        if (((c)localObject1).hIH == null)
        {
          if (this.ooE != null) {
            break;
          }
          AppMethodBeat.o(30528);
          return null;
        }
        Iterator localIterator = ((c)localObject1).hIH.iterator();
        if (!localIterator.hasNext()) {
          break label148;
        }
        localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc.BDz != null)
        {
          localArrayList.add(localc.BDz);
          continue;
        }
        if (localc.BDx == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.BDy != null)
      {
        localObject2.add(localc.BDx);
        localObject2.add(localc.BDy);
      }
    }
    localObject1 = this.ooE.iterator();
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
  
  public final void esQ()
  {
    AppMethodBeat.i(30540);
    if ((this.deL > 0L) && (this.BEn > 0L))
    {
      String str = c.esI().bSy();
      if (!str.equals(this.BEo))
      {
        this.BEo = str;
        if (!this.BEq)
        {
          this.BEq = true;
          ch(this.BEo, true);
          AppMethodBeat.o(30540);
          return;
        }
        ch(this.BEo, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText esR()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = esN();
    if ((localWXRTEditText == null) && (this.ooE.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.ooE.get(this.ooE.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.BEw.stopTimer();
    this.BEn = -1L;
    if (BEm == this) {
      BEm = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.onZ == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cd.a.ao(paramWXRTEditText.getContext(), 2131165517));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.BEd = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.ooM);
    AppMethodBeat.o(30527);
  }
  
  public final void zZ(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.BEl.etc().N(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */