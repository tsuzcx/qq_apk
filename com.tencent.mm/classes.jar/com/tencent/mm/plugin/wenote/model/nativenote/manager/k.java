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
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k EAp = null;
  private static DisplayMetrics aJt;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int pvR = -1;
  private static int pvT = -1;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a EAo;
  public long EAq;
  public String EAr;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b EAs;
  private boolean EAt;
  public int EAu;
  public String EAv;
  public long EAw;
  public int EAx;
  public boolean EAy;
  public final av EAz;
  public int ahF;
  public long dnC;
  public int mFF;
  private transient ArrayList<WXRTEditText> pvO;
  private int pvS;
  private View.OnKeyListener pvW;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.EAq = -1L;
    this.EAr = "";
    this.dnC = -1L;
    this.EAs = null;
    this.EAt = false;
    this.EAu = -1;
    this.EAv = null;
    this.EAw = -1L;
    this.EAx = 0;
    this.EAy = false;
    this.pvW = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.eWU().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          localObject = k.this.eWZ();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          ad.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.eWU().XY(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ad.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.eWU().XY(paramAnonymousInt - 1);
          if (paramAnonymousKeyEvent == null)
          {
            ad.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
              int i = ((WXRTEditText)localObject).getSelectionStart();
              if (i != ((WXRTEditText)localObject).getSelectionEnd())
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              if (i == ((WXRTEditText)localObject).getParagraphsInSelection().avj)
              {
                ((WXRTEditText)localObject).pvu = true;
                k.this.b(u.EAZ, Boolean.FALSE);
                k.this.b(u.EBa, Boolean.FALSE);
                k.this.b(u.EAY, Boolean.FALSE);
                k.a(k.this).kg(false);
                k.a(k.this).kh(false);
                k.a(k.this).ki(false);
                ((WXRTEditText)localObject).pvu = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(i.EAn);
              c.eWU().cem();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.eWU().W(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.EzC.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.ptH = i;
              paramAnonymousKeyEvent.ptF = true;
              paramAnonymousKeyEvent.ptL = false;
              label585:
              if (!bool) {
                break label651;
              }
              k.b(k.this).eXo().Bv(paramAnonymousInt - 1);
            }
            if (!bt.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.eWU().W(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.EzB.setSelection(0);
          paramAnonymousKeyEvent.ptF = true;
          paramAnonymousKeyEvent.ptL = false;
          break label585;
          label651:
          k.b(k.this).eXo().fd(paramAnonymousInt - 1, 2);
          break;
          ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.eWU().cem();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (bt.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.EzA.setSelection(0);
              paramAnonymousView.ptF = true;
              paramAnonymousView.ptL = true;
              c.eWU().W(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.ptH = -1;
            paramAnonymousKeyEvent.ptF = true;
            paramAnonymousKeyEvent.ptL = false;
          }
          for (;;)
          {
            k.b(k.this).eXo().fd(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.EzB.setSelection(0);
            paramAnonymousKeyEvent.ptF = true;
            paramAnonymousKeyEvent.ptL = false;
          }
          ad.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).puc.booleanValue()))
          {
            ad.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.ptM) && (paramAnonymousView.getType() != -1))
          {
            c.eWU().X(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return true;
          }
          c.eWU().cem();
          c.eWU().W(paramAnonymousInt, false);
          k.b(k.this).eXo().Bx(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.ptF = true;
          paramAnonymousView.ptL = false;
          paramAnonymousView.content = "";
          paramAnonymousView.ptH = 0;
          c.eWU().a(paramAnonymousInt, paramAnonymousView);
          c.eWU().fg(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).cdD();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousKeyEvent.ahp(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.ca(((Integer)paramAnonymousKeyEvent.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.EAz = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.eXc();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.pvO = new ArrayList();
    this.EAo = parama;
    EAp = this;
    this.ahF = h.dT(parama.cdE());
    this.mFF = al.jH(parama.cdE());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.eB(parama.cdE());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    aJt = parama.cdE().getResources().getDisplayMetrics();
    this.pvS = (mScreenHeight - this.ahF - this.mFF - (int)aX(8.0F));
    this.EAr = c.eWU().cer();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.pxn = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float aX(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, aJt);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void ct(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        gw localgw = new gw();
        localgw.dsV.type = 19;
        localgw.dsV.dnI = c.eWU().aaX(paramString);
        if (localgw.dsV.dnI == null)
        {
          ad.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localgw.dsV.title = paramString;
        localgw.dsV.dnC = this.dnC;
        paramString = localgw.dsV;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.dtc = i;
          localgw.dsV.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.IbL.l(localgw);
          if (paramBoolean)
          {
            this.EAu = localgw.dsV.dsY.getIntExtra("fav_note_item_status", -1);
            this.EAv = localgw.dsV.dsY.getStringExtra("fav_note_xml");
            this.EAw = localgw.dsV.dsY.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k eXa()
  {
    return EAp;
  }
  
  private void eXb()
  {
    AppMethodBeat.i(30539);
    if ((this.EAq < 0L) && (this.dnC > 0L))
    {
      this.EAz.az(60000L, 60000L);
      this.EAq = bt.HI();
      this.EAr = c.eWU().cer();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void eXe()
  {
    AppMethodBeat.i(30543);
    if (EAp != null) {
      EAp.EAo.eXo().vy(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void Bz(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.EAo.eXo().O(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.EAx != 2) || (!this.EAy))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.EAo.eXo().fe(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.pxR.iterator();
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
      this.EAs.kf(bool5);
      this.EAs.kg(bool6);
      this.EAs.kh(bool7);
      this.EAs.ki(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.EAn);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.eWU().XY(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.c.c.aaN(paramSpannable2.toString()))
        {
          if (!c.eWU().ff(j - i, 0)) {
            break label140;
          }
          this.EAo.eXo().cds();
          this.EAo.eXo().Bv(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.c.c.aaN(paramSpannable1.toString());
          break;
        }
        label140:
        c.eWU().cem();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).ptH = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).ptF = true;
        localc.ptL = false;
        paramWXRTEditText = c.eWU();
        paramWXRTEditText.pux = (j - i + paramWXRTEditText.pux);
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
      paramInt = c.eWU().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.eWU().fg(paramInt - 1, paramInt + 1);
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
      eXb();
      this.EAo.eXo().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.EAo.eXo().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = eWZ();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().avj;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.ceC();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.ceD();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.pvv = true;
      localWXRTEditText.ptP = paramt.cfm();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.EAo.eXo().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void eWS()
  {
    AppMethodBeat.i(30530);
    this.EAo.eXo().eWS();
    eXb();
    AppMethodBeat.o(30530);
  }
  
  public final void eWT()
  {
    AppMethodBeat.i(30535);
    this.EAo.eXo().cdq();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText eWZ()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.eWU();
    ArrayList localArrayList = this.pvO;
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
          if (this.pvO != null) {
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
        if (localc.EzC != null)
        {
          localArrayList.add(localc.EzC);
          continue;
        }
        if (localc.EzA == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.EzB != null)
      {
        localObject2.add(localc.EzA);
        localObject2.add(localc.EzB);
      }
    }
    localObject1 = this.pvO.iterator();
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
  
  public final void eXc()
  {
    AppMethodBeat.i(30540);
    if ((this.dnC > 0L) && (this.EAq > 0L))
    {
      String str = c.eWU().cer();
      if (!str.equals(this.EAr))
      {
        this.EAr = str;
        if (!this.EAt)
        {
          this.EAt = true;
          ct(this.EAr, true);
          AppMethodBeat.o(30540);
          return;
        }
        ct(this.EAr, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText eXd()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = eWZ();
    if ((localWXRTEditText == null) && (this.pvO.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.pvO.get(this.pvO.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.EAz.stopTimer();
    this.EAq = -1L;
    if (EAp == this) {
      EAp = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.pvj == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cc.a.ax(paramWXRTEditText.getContext(), 2131165517));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.EAg = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.pvW);
    AppMethodBeat.o(30527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */