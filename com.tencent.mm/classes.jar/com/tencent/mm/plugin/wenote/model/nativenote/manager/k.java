package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.f.a.hi.a;
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
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k QHR = null;
  private static DisplayMetrics cCm;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int utT = -1;
  private static int utV = -1;
  public boolean QHP;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a QHQ;
  public long QHS;
  public String QHT;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b QHU;
  private boolean QHV;
  public int QHW;
  public String QHX;
  public long QHY;
  public int QHZ;
  public boolean QIa;
  public final MTimerHandler QIb;
  public long fyE;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  public long msgId;
  private transient ArrayList<WXRTEditText> utQ;
  private int utU;
  private View.OnKeyListener utY;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.msgId = -1L;
    this.QHS = -1L;
    this.QHT = "";
    this.fyE = -1L;
    this.QHU = null;
    this.QHV = false;
    this.QHW = -1;
    this.QHX = null;
    this.QHY = -1L;
    this.QHZ = 0;
    this.QIa = false;
    this.utY = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.hdz().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          localObject = k.this.hdE();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.hdz().aph(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.hdz().aph(paramAnonymousInt - 1);
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
              if (i == ((WXRTEditText)localObject).getParagraphsInSelection().tH)
              {
                ((WXRTEditText)localObject).utw = true;
                k.this.b(u.QIB, Boolean.FALSE);
                k.this.b(u.QIC, Boolean.FALSE);
                k.this.b(u.QIA, Boolean.FALSE);
                k.a(k.this).mu(false);
                k.a(k.this).mv(false);
                k.a(k.this).mw(false);
                ((WXRTEditText)localObject).utw = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(i.QHO);
              c.hdz().cRW();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.hdz().ae(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.QHd.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.urI = i;
              paramAnonymousKeyEvent.urG = true;
              paramAnonymousKeyEvent.urM = false;
              label585:
              if (!bool) {
                break label651;
              }
              k.b(k.this).hdV().IY(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.hdz().ae(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.QHc.setSelection(0);
          paramAnonymousKeyEvent.urG = true;
          paramAnonymousKeyEvent.urM = false;
          break label585;
          label651:
          k.b(k.this).hdV().fR(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.hdz().cRW();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.QHb.setSelection(0);
              paramAnonymousView.urG = true;
              paramAnonymousView.urM = true;
              c.hdz().ae(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.urI = -1;
            paramAnonymousKeyEvent.urG = true;
            paramAnonymousKeyEvent.urM = false;
          }
          for (;;)
          {
            k.b(k.this).hdV().fR(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.QHc.setSelection(0);
            paramAnonymousKeyEvent.urG = true;
            paramAnonymousKeyEvent.urM = false;
          }
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).usd.booleanValue()))
          {
            Log.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.urN) && (paramAnonymousView.getType() != -1))
          {
            c.hdz().af(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return true;
          }
          c.hdz().cRW();
          c.hdz().ae(paramAnonymousInt, false);
          k.b(k.this).hdV().Ja(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.urG = true;
          paramAnonymousView.urM = false;
          paramAnonymousView.content = "";
          paramAnonymousView.urI = 0;
          c.hdz().a(paramAnonymousInt, paramAnonymousView);
          c.hdz().fU(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).cRn();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousKeyEvent.aFh(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.QIb = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.hdH();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.utQ = new ArrayList();
    this.QHQ = parama;
    QHR = this;
    this.mActionBarHeight = h.ew(parama.cRo());
    this.mStatusBarHeight = ar.kI(parama.cRo());
    int[] arrayOfInt = com.tencent.mm.compatible.util.i.getScreenWH(parama.cRo());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    cCm = parama.cRo().getResources().getDisplayMetrics();
    this.utU = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)bd(8.0F));
    this.QHT = c.hdz().cSb();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.uvo = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float bd(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, cCm);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void dg(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        hi localhi = new hi();
        localhi.fEb.type = 19;
        localhi.fEb.fyK = c.hdz().atO(paramString);
        if (localhi.fEb.fyK == null)
        {
          Log.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localhi.fEb.title = paramString;
        localhi.fEb.fyE = this.fyE;
        paramString = localhi.fEb;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.fEi = i;
          localhi.fEb.desc = "fav_update_note_storage";
          EventCenter.instance.publish(localhi);
          if (paramBoolean)
          {
            this.QHW = localhi.fEb.fEe.getIntExtra("fav_note_item_status", -1);
            this.QHX = localhi.fEb.fEe.getStringExtra("fav_note_xml");
            this.QHY = localhi.fEb.fEe.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k hdF()
  {
    return QHR;
  }
  
  private void hdG()
  {
    AppMethodBeat.i(30539);
    if ((this.QHS < 0L) && (this.fyE > 0L))
    {
      this.QIb.startTimer(60000L);
      this.QHS = Util.currentTicks();
      this.QHT = c.hdz().cSb();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void hdJ()
  {
    AppMethodBeat.i(30543);
    if (QHR != null) {
      QHR.QHQ.hdV().DC(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void Jc(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.QHQ.hdV().Q(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.QHZ != 2) || (!this.QIa))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.QHQ.hdV().fS(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.uvS.iterator();
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
      this.QHU.mt(bool5);
      this.QHU.mu(bool6);
      this.QHU.mv(bool7);
      this.QHU.mw(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.QHO);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.hdz().aph(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.d.c.atD(paramSpannable2.toString()))
        {
          if (!c.hdz().fT(j - i, 0)) {
            break label140;
          }
          this.QHQ.hdV().cRc();
          this.QHQ.hdV().IY(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(30534);
          return;
          i = com.tencent.mm.plugin.wenote.d.c.atD(paramSpannable1.toString());
          break;
        }
        label140:
        c.hdz().cRW();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).urI = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).urG = true;
        localc.urM = false;
        paramWXRTEditText = c.hdz();
        paramWXRTEditText.usy = (j - i + paramWXRTEditText.usy);
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
      paramInt = c.hdz().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.hdz().fU(paramInt - 1, paramInt + 1);
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
      hdG();
      this.QHQ.hdV().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.QHQ.hdV().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = hdE();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().tH;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.cSm();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.cSn();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.utx = true;
      localWXRTEditText.urQ = paramt.cSW();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void e(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.QHQ.hdV().e(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final WXRTEditText hdE()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.hdz();
    ArrayList localArrayList = this.utQ;
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
          if (this.utQ != null) {
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
        if (localc.QHd != null)
        {
          localArrayList.add(localc.QHd);
          continue;
        }
        if (localc.QHb == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.QHc != null)
      {
        localObject2.add(localc.QHb);
        localObject2.add(localc.QHc);
      }
    }
    localObject1 = this.utQ.iterator();
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
  
  public final void hdH()
  {
    AppMethodBeat.i(30540);
    if ((this.fyE > 0L) && (this.QHS > 0L))
    {
      String str = c.hdz().cSb();
      if (!str.equals(this.QHT))
      {
        this.QHT = str;
        if (!this.QHV)
        {
          this.QHV = true;
          dg(this.QHT, true);
          AppMethodBeat.o(30540);
          return;
        }
        dg(this.QHT, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText hdI()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = hdE();
    if ((localWXRTEditText == null) && (this.utQ.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.utQ.get(this.utQ.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void hdx()
  {
    AppMethodBeat.i(30530);
    this.QHQ.hdV().hdx();
    hdG();
    AppMethodBeat.o(30530);
  }
  
  public final void hdy()
  {
    AppMethodBeat.i(30535);
    this.QHQ.hdV().cRa();
    AppMethodBeat.o(30535);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.QIb.stopTimer();
    this.QHS = -1L;
    if (QHR == this) {
      QHR = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.utl == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.ci.a.aY(paramWXRTEditText.getContext(), R.f.NormalTextSize));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.QHH = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.utY);
    AppMethodBeat.o(30527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */