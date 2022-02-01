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
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k CWt = null;
  private static DisplayMetrics aHC;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int oSh = -1;
  private static int oSj = -1;
  public long CWA;
  public int CWB;
  public boolean CWC;
  public final au CWD;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a CWs;
  public long CWu;
  public String CWv;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b CWw;
  private boolean CWx;
  public int CWy;
  public String CWz;
  public int afO;
  public long dcg;
  public int mfe;
  private transient ArrayList<WXRTEditText> oSe;
  private int oSi;
  private View.OnKeyListener oSm;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.CWu = -1L;
    this.CWv = "";
    this.dcg = -1L;
    this.CWw = null;
    this.CWx = false;
    this.CWy = -1;
    this.CWz = null;
    this.CWA = -1L;
    this.CWB = 0;
    this.CWC = false;
    this.oSm = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.eIb().size() == 0)
          {
            AppMethodBeat.o(30524);
            return false;
          }
          WXRTEditText localWXRTEditText = k.this.eIg();
          if (localWXRTEditText == null)
          {
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = localWXRTEditText.getRecyclerItemPosition();
          ac.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.eIb().Wh(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ac.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.eIb().Wh(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ac.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ac.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
              int i = localWXRTEditText.getSelectionStart();
              if (i != localWXRTEditText.getSelectionEnd())
              {
                AppMethodBeat.o(30524);
                return false;
              }
              if (i == localWXRTEditText.getParagraphsInSelection().atr)
              {
                localWXRTEditText.oRK = true;
                k.this.b(u.CXd, Boolean.FALSE);
                k.this.b(u.CXe, Boolean.FALSE);
                k.this.b(u.CXc, Boolean.FALSE);
                k.a(k.this).jV(false);
                k.a(k.this).jW(false);
                k.a(k.this).jX(false);
                localWXRTEditText.oRK = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = localWXRTEditText.a(i.CWr);
              c.eIb().bZI();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.eIb().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.CVF.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.oPX = i;
              paramAnonymousKeyEvent.oPV = true;
              paramAnonymousKeyEvent.oQb = false;
              label450:
              if (!bool) {
                break label516;
              }
              k.b(k.this).eIv().AN(paramAnonymousInt - 1);
            }
            if (!bs.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.eIb().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.CVE.setSelection(0);
          paramAnonymousKeyEvent.oPV = true;
          paramAnonymousKeyEvent.oQb = false;
          break label450;
          label516:
          k.b(k.this).eIv().eZ(paramAnonymousInt - 1, 2);
          break;
          ac.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.eIb().bZI();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (bs.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.CVD.setSelection(0);
              paramAnonymousView.oPV = true;
              paramAnonymousView.oQb = true;
              c.eIb().W(paramAnonymousInt - 1, true);
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.oPX = -1;
            paramAnonymousKeyEvent.oPV = true;
            paramAnonymousKeyEvent.oQb = false;
          }
          for (;;)
          {
            k.b(k.this).eIv().eZ(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.CVE.setSelection(0);
            paramAnonymousKeyEvent.oPV = true;
            paramAnonymousKeyEvent.oQb = false;
          }
          ac.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).oQs.booleanValue()))
          {
            ac.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.oQc) && (paramAnonymousView.getType() != -1))
          {
            c.eIb().X(paramAnonymousInt, true);
            AppMethodBeat.o(30524);
            return true;
          }
          c.eIb().bZI();
          c.eIb().W(paramAnonymousInt, false);
          k.b(k.this).eIv().AP(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.oPV = true;
          paramAnonymousView.oQb = false;
          paramAnonymousView.content = "";
          paramAnonymousView.oPX = 0;
          c.eIb().a(paramAnonymousInt, paramAnonymousView);
          c.eIb().fc(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).bYZ();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.aeD(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.lR(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.CWD = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.eIj();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.oSe = new ArrayList();
    this.CWs = parama;
    CWt = this;
    this.afO = com.tencent.mm.pluginsdk.g.dT(parama.bZa());
    this.mfe = aj.jw(parama.bZa());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.eB(parama.bZa());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aHC = parama.bZa().getResources().getDisplayMetrics();
    this.oSi = (mScreenHeight - this.afO - this.mfe - (int)aU(8.0F));
    this.CWv = c.eIb().bZN();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.oTD = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float aU(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aHC);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void cn(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        gt localgt = new gt();
        localgt.dhx.type = 19;
        localgt.dhx.dcm = c.eIb().Xq(paramString);
        if (localgt.dhx.dcm == null)
        {
          ac.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localgt.dhx.title = paramString;
        localgt.dhx.dcg = this.dcg;
        paramString = localgt.dhx;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.dhE = i;
          localgt.dhx.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.GpY.l(localgt);
          if (paramBoolean)
          {
            this.CWy = localgt.dhx.dhA.getIntExtra("fav_note_item_status", -1);
            this.CWz = localgt.dhx.dhA.getStringExtra("fav_note_xml");
            this.CWA = localgt.dhx.dhA.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k eIh()
  {
    return CWt;
  }
  
  private void eIi()
  {
    AppMethodBeat.i(30539);
    if ((this.CWu < 0L) && (this.dcg > 0L))
    {
      this.CWD.au(60000L, 60000L);
      this.CWu = bs.Gn();
      this.CWv = c.eIb().bZN();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void eIl()
  {
    AppMethodBeat.i(30543);
    if (CWt != null) {
      CWt.CWs.eIv().uN(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void AR(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.CWs.eIv().M(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.CWB != 2) || (!this.CWC))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.CWs.eIv().fa(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.oUh.iterator();
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
      this.CWw.jU(bool5);
      this.CWw.jV(bool6);
      this.CWw.jW(bool7);
      this.CWw.jX(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.CWr);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.eIb().Wh(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.c.c.Xg(paramSpannable2.toString()))
        {
          if (!c.eIb().fb(j - i, 0)) {
            break label140;
          }
          this.CWs.eIv().bYO();
          this.CWs.eIv().AN(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.c.c.Xg(paramSpannable1.toString());
          break;
        }
        label140:
        c.eIb().bZI();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).oPX = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).oPV = true;
        localc.oQb = false;
        paramWXRTEditText = c.eIb();
        paramWXRTEditText.oQN = (j - i + paramWXRTEditText.oQN);
      }
      AppMethodBeat.o(30534);
      return;
    }
    paramWXRTEditText.setText("");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(30534);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.eIb().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.eIb().fc(paramInt - 1, paramInt + 1);
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
      eIi();
      this.CWs.eIv().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.CWs.eIv().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = eIg();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().atr;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.bZY();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.bZZ();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.oRL = true;
      localWXRTEditText.oQf = paramt.caI();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.CWs.eIv().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void eHZ()
  {
    AppMethodBeat.i(30530);
    this.CWs.eIv().eHZ();
    eIi();
    AppMethodBeat.o(30530);
  }
  
  public final void eIa()
  {
    AppMethodBeat.i(30535);
    this.CWs.eIv().bYM();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText eIg()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.eIb();
    ArrayList localArrayList = this.oSe;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    label148:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc;
      try
      {
        if (((c)localObject1).ijj == null)
        {
          if (this.oSe != null) {
            break;
          }
          AppMethodBeat.o(30528);
          return null;
        }
        Iterator localIterator = ((c)localObject1).ijj.iterator();
        if (!localIterator.hasNext()) {
          break label148;
        }
        localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc.CVF != null)
        {
          localArrayList.add(localc.CVF);
          continue;
        }
        if (localc.CVD == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.CVE != null)
      {
        localObject2.add(localc.CVD);
        localObject2.add(localc.CVE);
      }
    }
    localObject1 = this.oSe.iterator();
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
  
  public final void eIj()
  {
    AppMethodBeat.i(30540);
    if ((this.dcg > 0L) && (this.CWu > 0L))
    {
      String str = c.eIb().bZN();
      if (!str.equals(this.CWv))
      {
        this.CWv = str;
        if (!this.CWx)
        {
          this.CWx = true;
          cn(this.CWv, true);
          AppMethodBeat.o(30540);
          return;
        }
        cn(this.CWv, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText eIk()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = eIg();
    if ((localWXRTEditText == null) && (this.oSe.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.oSe.get(this.oSe.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.CWD.stopTimer();
    this.CWu = -1L;
    if (CWt == this) {
      CWt = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.oRz == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cc.a.au(paramWXRTEditText.getContext(), 2131165517));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.CWk = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.oSm);
    AppMethodBeat.o(30527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */