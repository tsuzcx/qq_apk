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
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.hb.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k JIz = null;
  private static DisplayMetrics aJm;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int qRN = -1;
  private static int qRP = -1;
  public long JIA;
  public String JIB;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b JIC;
  private boolean JID;
  public int JIE;
  public String JIF;
  public long JIG;
  public int JIH;
  public boolean JII;
  public final MTimerHandler JIJ;
  public boolean JIx;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a JIy;
  public long dFW;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  private transient ArrayList<WXRTEditText> qRK;
  private int qRO;
  private View.OnKeyListener qRS;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.JIA = -1L;
    this.JIB = "";
    this.dFW = -1L;
    this.JIC = null;
    this.JID = false;
    this.JIE = -1;
    this.JIF = null;
    this.JIG = -1L;
    this.JIH = 0;
    this.JII = false;
    this.qRS = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.gjL().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          localObject = k.this.gjQ();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.gjL().ahp(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.gjL().ahp(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            Log.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
              int i = ((WXRTEditText)localObject).getSelectionStart();
              if (i != ((WXRTEditText)localObject).getSelectionEnd())
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              if (i == ((WXRTEditText)localObject).getParagraphsInSelection().avh)
              {
                ((WXRTEditText)localObject).qRq = true;
                k.this.b(u.JJj, Boolean.FALSE);
                k.this.b(u.JJk, Boolean.FALSE);
                k.this.b(u.JJi, Boolean.FALSE);
                k.a(k.this).li(false);
                k.a(k.this).lj(false);
                k.a(k.this).lk(false);
                ((WXRTEditText)localObject).qRq = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(i.JIw);
              c.gjL().cDr();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.gjL().ae(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.JHL.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.qPC = i;
              paramAnonymousKeyEvent.qPA = true;
              paramAnonymousKeyEvent.qPG = false;
              label585:
              if (!bool) {
                break label651;
              }
              k.b(k.this).gkf().Fr(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.gjL().ae(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.JHK.setSelection(0);
          paramAnonymousKeyEvent.qPA = true;
          paramAnonymousKeyEvent.qPG = false;
          break label585;
          label651:
          k.b(k.this).gkf().fu(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.gjL().cDr();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.JHJ.setSelection(0);
              paramAnonymousView.qPA = true;
              paramAnonymousView.qPG = true;
              c.gjL().ae(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.qPC = -1;
            paramAnonymousKeyEvent.qPA = true;
            paramAnonymousKeyEvent.qPG = false;
          }
          for (;;)
          {
            k.b(k.this).gkf().fu(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.JHK.setSelection(0);
            paramAnonymousKeyEvent.qPA = true;
            paramAnonymousKeyEvent.qPG = false;
          }
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).qPX.booleanValue()))
          {
            Log.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.qPH) && (paramAnonymousView.getType() != -1))
          {
            c.gjL().af(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return true;
          }
          c.gjL().cDr();
          c.gjL().ae(paramAnonymousInt, false);
          k.b(k.this).gkf().Ft(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.qPA = true;
          paramAnonymousView.qPG = false;
          paramAnonymousView.content = "";
          paramAnonymousView.qPC = 0;
          c.gjL().a(paramAnonymousInt, paramAnonymousView);
          c.gjL().fx(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).cCI();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.axQ(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.JIJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.gjT();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.qRK = new ArrayList();
    this.JIy = parama;
    JIz = this;
    this.mActionBarHeight = h.eu(parama.cCJ());
    this.mStatusBarHeight = ao.jJ(parama.cCJ());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.getScreenWH(parama.cCJ());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJm = parama.cCJ().getResources().getDisplayMetrics();
    this.qRO = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)be(8.0F));
    this.JIB = c.gjL().cDw();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.qTi = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float be(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJm);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void cS(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        hb localhb = new hb();
        localhb.dLm.type = 19;
        localhb.dLm.dGb = c.gjL().alU(paramString);
        if (localhb.dLm.dGb == null)
        {
          Log.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localhb.dLm.title = paramString;
        localhb.dLm.dFW = this.dFW;
        paramString = localhb.dLm;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.dLt = i;
          localhb.dLm.desc = "fav_update_note_storage";
          EventCenter.instance.publish(localhb);
          if (paramBoolean)
          {
            this.JIE = localhb.dLm.dLp.getIntExtra("fav_note_item_status", -1);
            this.JIF = localhb.dLm.dLp.getStringExtra("fav_note_xml");
            this.JIG = localhb.dLm.dLp.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k gjR()
  {
    return JIz;
  }
  
  private void gjS()
  {
    AppMethodBeat.i(30539);
    if ((this.JIA < 0L) && (this.dFW > 0L))
    {
      this.JIJ.startTimer(60000L);
      this.JIA = Util.currentTicks();
      this.JIB = c.gjL().cDw();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void gjV()
  {
    AppMethodBeat.i(30543);
    if (JIz != null) {
      JIz.JIy.gkf().zD(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void Fv(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.JIy.gkf().Q(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.JIH != 2) || (!this.JII))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.JIy.gkf().fv(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.qTM.iterator();
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
      this.JIC.lh(bool5);
      this.JIC.li(bool6);
      this.JIC.lj(bool7);
      this.JIC.lk(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.JIw);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.gjL().ahp(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.c.c.alK(paramSpannable2.toString()))
        {
          if (!c.gjL().fw(j - i, 0)) {
            break label140;
          }
          this.JIy.gkf().cCx();
          this.JIy.gkf().Fr(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.c.c.alK(paramSpannable1.toString());
          break;
        }
        label140:
        c.gjL().cDr();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).qPC = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).qPA = true;
        localc.qPG = false;
        paramWXRTEditText = c.gjL();
        paramWXRTEditText.qQs = (j - i + paramWXRTEditText.qQs);
      }
      AppMethodBeat.o(30534);
      return;
    }
    paramWXRTEditText.setText("");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(30534);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.gjL().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.gjL().fx(paramInt - 1, paramInt + 1);
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
      gjS();
      this.JIy.gkf().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.JIy.gkf().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = gjQ();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avh;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cDH();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cDI();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.qRr = true;
      localWXRTEditText.qPK = paramt.cEq();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.JIy.gkf().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void gjJ()
  {
    AppMethodBeat.i(30530);
    this.JIy.gkf().gjJ();
    gjS();
    AppMethodBeat.o(30530);
  }
  
  public final void gjK()
  {
    AppMethodBeat.i(30535);
    this.JIy.gkf().cCv();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText gjQ()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.gjL();
    ArrayList localArrayList = this.qRK;
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
          if (this.qRK != null) {
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
        if (localc.JHL != null)
        {
          localArrayList.add(localc.JHL);
          continue;
        }
        if (localc.JHJ == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.JHK != null)
      {
        localObject2.add(localc.JHJ);
        localObject2.add(localc.JHK);
      }
    }
    localObject1 = this.qRK.iterator();
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
  
  public final void gjT()
  {
    AppMethodBeat.i(30540);
    if ((this.dFW > 0L) && (this.JIA > 0L))
    {
      String str = c.gjL().cDw();
      if (!str.equals(this.JIB))
      {
        this.JIB = str;
        if (!this.JID)
        {
          this.JID = true;
          cS(this.JIB, true);
          AppMethodBeat.o(30540);
          return;
        }
        cS(this.JIB, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText gjU()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = gjQ();
    if ((localWXRTEditText == null) && (this.qRK.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.qRK.get(this.qRK.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.JIJ.stopTimer();
    this.JIA = -1L;
    if (JIz == this) {
      JIz = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.qRf == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cb.a.aG(paramWXRTEditText.getContext(), 2131165535));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.JIp = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.qRS);
    AppMethodBeat.o(30527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */