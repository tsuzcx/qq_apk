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
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static k XBp = null;
  private static DisplayMetrics euS;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static int xAq = -1;
  private static int xAs = -1;
  public final MTimerHandler XBA;
  public boolean XBn;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a XBo;
  public long XBq;
  public String XBr;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b XBs;
  private boolean XBt;
  public int XBu;
  public String XBv;
  public long XBw;
  public int XBx;
  public boolean XBy;
  public a XBz;
  public long hDn;
  public int mActionBarHeight;
  public int mStatusBarHeight;
  public long msgId;
  private transient ArrayList<WXRTEditText> xAn;
  private int xAr;
  private View.OnKeyListener xAv;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(30526);
    this.msgId = -1L;
    this.XBq = -1L;
    this.XBr = "";
    this.hDn = -1L;
    this.XBs = null;
    this.XBt = false;
    this.XBu = -1;
    this.XBv = null;
    this.XBw = -1L;
    this.XBx = 0;
    this.XBy = false;
    this.xAv = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(30524);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousKeyEvent.getKeyCode() == 67))
        {
          if (c.iEg().size() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          localObject = k.this.iEl();
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousInt = ((WXRTEditText)localObject).getRecyclerItemPosition();
          Log.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramAnonymousView = c.iEg().avf(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            Log.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          paramAnonymousKeyEvent = c.iEg().avf(paramAnonymousInt - 1);
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
              if (i == ((WXRTEditText)localObject).getParagraphsInSelection().uG)
              {
                ((WXRTEditText)localObject).xzT = true;
                k.this.b(u.XCa, Boolean.FALSE);
                k.this.b(u.XCb, Boolean.FALSE);
                k.this.b(u.XBZ, Boolean.FALSE);
                k.a(k.this).nQ(false);
                k.a(k.this).nR(false);
                k.a(k.this).nS(false);
                ((WXRTEditText)localObject).xzT = false;
              }
              if ((i != 0) || (paramAnonymousInt == 0))
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(30524);
                return false;
              }
              paramAnonymousView = ((WXRTEditText)localObject).a(i.XBm);
              c.iEg().dwp();
              if (paramAnonymousKeyEvent.getType() != 1) {
                break;
              }
              bool = c.iEg().av(paramAnonymousInt, true);
              paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
              i = paramAnonymousKeyEvent.XAB.getText().toString().length();
              paramAnonymousKeyEvent.content += paramAnonymousView;
              paramAnonymousKeyEvent.xyd = i;
              paramAnonymousKeyEvent.xyb = true;
              paramAnonymousKeyEvent.xyh = false;
              label585:
              if (!bool) {
                break label651;
              }
              k.b(k.this).iEC().JG(paramAnonymousInt - 1);
            }
            if (!Util.isNullOrNil(paramAnonymousView)) {
              break;
            }
          }
        }
        for (boolean bool = c.iEg().av(paramAnonymousInt, true);; bool = false)
        {
          paramAnonymousKeyEvent.XAA.setSelection(0);
          paramAnonymousKeyEvent.xyb = true;
          paramAnonymousKeyEvent.xyh = false;
          break label585;
          label651:
          k.b(k.this).iEC().gI(paramAnonymousInt - 1, 2);
          break;
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
          c.iEg().dwp();
          if (paramAnonymousKeyEvent.getType() == 1)
          {
            paramAnonymousKeyEvent = (com.tencent.mm.plugin.wenote.model.a.i)paramAnonymousKeyEvent;
            if (Util.isNullOrNil(paramAnonymousKeyEvent.content))
            {
              paramAnonymousView.XAz.setSelection(0);
              paramAnonymousView.xyb = true;
              paramAnonymousView.xyh = true;
              c.iEg().av(paramAnonymousInt - 1, true);
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
              AppMethodBeat.o(30524);
              return true;
            }
            if (paramAnonymousKeyEvent.content.endsWith("<br/>")) {
              paramAnonymousKeyEvent.content = paramAnonymousKeyEvent.content.substring(0, paramAnonymousKeyEvent.content.length() - 5);
            }
            paramAnonymousKeyEvent.xyd = -1;
            paramAnonymousKeyEvent.xyb = true;
            paramAnonymousKeyEvent.xyh = false;
          }
          for (;;)
          {
            k.b(k.this).iEC().gI(paramAnonymousInt - 1, 2);
            break;
            paramAnonymousKeyEvent.XAA.setSelection(0);
            paramAnonymousKeyEvent.xyb = true;
            paramAnonymousKeyEvent.xyh = false;
          }
          Log.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
          if ((paramAnonymousView.getType() == 4) && (((com.tencent.mm.plugin.wenote.model.a.l)paramAnonymousView).xyz.booleanValue()))
          {
            Log.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return false;
          }
          if ((!paramAnonymousView.xyi) && (paramAnonymousView.getType() != -1))
          {
            c.iEg().aw(paramAnonymousInt, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(30524);
            return true;
          }
          c.iEg().dwp();
          c.iEg().av(paramAnonymousInt, false);
          k.b(k.this).iEC().JI(paramAnonymousInt);
          paramAnonymousView = new com.tencent.mm.plugin.wenote.model.a.i();
          paramAnonymousView.xyb = true;
          paramAnonymousView.xyh = false;
          paramAnonymousView.content = "";
          paramAnonymousView.xyd = 0;
          c.iEg().a(paramAnonymousInt, paramAnonymousView);
          c.iEg().gL(paramAnonymousInt - 1, paramAnonymousInt + 1);
          paramAnonymousView = k.b(k.this).dvG();
          paramAnonymousKeyEvent = com.tencent.mm.hellhoundlib.b.c.a(paramAnonymousInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousKeyEvent.aYi(), "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          paramAnonymousView.scrollToPosition(((Integer)paramAnonymousKeyEvent.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "Undefined", "scrollToPosition", "(I)V");
          break;
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTManager$1", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(30524);
          return false;
        }
      }
    };
    this.XBA = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30525);
        if (-1L == k.c(k.this))
        {
          AppMethodBeat.o(30525);
          return false;
        }
        k.this.iEo();
        AppMethodBeat.o(30525);
        return true;
      }
    }, true);
    this.xAn = new ArrayList();
    this.XBo = parama;
    XBp = this;
    this.mActionBarHeight = h.fs(parama.dvH());
    this.mStatusBarHeight = aw.mL(parama.dvH());
    int[] arrayOfInt = com.tencent.mm.compatible.util.j.getScreenWH(parama.dvH());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    euS = parama.dvH().getResources().getDisplayMetrics();
    this.xAr = (mScreenHeight - this.mActionBarHeight - this.mStatusBarHeight - (int)cg(8.0F));
    this.XBr = c.iEg().dwu();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.xBM = 0.0F;
    AppMethodBeat.o(30526);
  }
  
  public static float cg(float paramFloat)
  {
    AppMethodBeat.i(30537);
    paramFloat = TypedValue.applyDimension(1, paramFloat, euS);
    AppMethodBeat.o(30537);
    return paramFloat;
  }
  
  private void dQ(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(30538);
        ht localht = new ht();
        localht.hIR.type = 19;
        localht.hIR.hDt = c.iEg().anD(paramString);
        if (localht.hIR.hDt == null)
        {
          Log.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(30538);
          return;
        }
        localht.hIR.title = paramString;
        localht.hIR.hDn = this.hDn;
        paramString = localht.hIR;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.hIY = i;
          localht.hIR.desc = "fav_update_note_storage";
          localht.publish();
          if (paramBoolean)
          {
            this.XBu = localht.hIR.hIU.getIntExtra("fav_note_item_status", -1);
            this.XBv = localht.hIR.hIU.getStringExtra("fav_note_xml");
            this.XBw = localht.hIR.hIU.getLongExtra("fav_note_item_updatetime", -1L);
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
  
  public static k iEm()
  {
    return XBp;
  }
  
  private void iEn()
  {
    AppMethodBeat.i(30539);
    if ((this.XBq < 0L) && (this.hDn > 0L))
    {
      this.XBA.startTimer(60000L);
      this.XBq = Util.currentTicks();
      this.XBr = c.iEg().dwu();
    }
    AppMethodBeat.o(30539);
  }
  
  public static void iEq()
  {
    AppMethodBeat.i(30543);
    if (XBp != null) {
      XBp.XBo.iEC().Jj(true);
    }
    AppMethodBeat.o(30543);
  }
  
  public final void JK(int paramInt)
  {
    AppMethodBeat.i(30531);
    this.XBo.iEC().U(paramInt, 0L);
    AppMethodBeat.o(30531);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30533);
    if ((this.XBx != 2) || (!this.XBy))
    {
      AppMethodBeat.o(30533);
      return;
    }
    this.XBo.iEC().gJ(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.xCr.iterator();
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
        if (!localt.t(paramWXRTEditText)) {
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
      if (!(localt instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.j)) {
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
      this.XBs.nP(bool5);
      this.XBs.nQ(bool6);
      this.XBs.nR(bool7);
      this.XBs.nS(bool8);
      AppMethodBeat.o(30533);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(30534);
    String str = paramWXRTEditText.a(i.XBm);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.iEg().avf(paramWXRTEditText.getRecyclerItemPosition());
      int i;
      int j;
      if ((localc != null) && (localc.getType() == 1))
      {
        if (paramSpannable1 != null) {
          break label146;
        }
        i = 0;
        if (paramSpannable2 != null) {
          break label158;
        }
        j = 0;
        label62:
        if (!c.iEg().gK(j - i, 0)) {
          break label170;
        }
        this.XBo.iEC().dvv();
        this.XBo.iEC().JG(paramWXRTEditText.getRecyclerItemPosition());
      }
      for (;;)
      {
        paramWXRTEditText.setContentDescription(com.tencent.mm.plugin.wenote.c.c.l(str, paramWXRTEditText.getContext()));
        if (this.XBz != null) {
          this.XBz.r(paramWXRTEditText);
        }
        AppMethodBeat.o(30534);
        return;
        label146:
        i = com.tencent.mm.plugin.wenote.c.c.ans(paramSpannable1.toString());
        break;
        label158:
        j = com.tencent.mm.plugin.wenote.c.c.ans(paramSpannable2.toString());
        break label62;
        label170:
        c.iEg().dwp();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).xyd = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).xyb = true;
        localc.xyh = false;
        paramSpannable1 = c.iEg();
        paramSpannable1.xyU = (j - i + paramSpannable1.xyU);
      }
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
      paramInt = c.iEg().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.iEg().gL(paramInt - 1, paramInt + 1);
      break;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30532);
    if (paramBoolean) {}
    try
    {
      iEn();
      this.XBo.iEC().a(paramWXRTEditText, paramBoolean, paramInt);
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
    this.XBo.iEC().a(paramWXRTEditText);
    AppMethodBeat.o(30536);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30542);
    WXRTEditText localWXRTEditText = iEl();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().uG;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.dwE();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.dwF();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(30542);
        return;
      }
      localWXRTEditText.xzU = true;
      localWXRTEditText.xyl = paramt.dxp();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(30542);
  }
  
  public final void g(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(30529);
    this.XBo.iEC().g(paramBoolean, paramLong);
    AppMethodBeat.o(30529);
  }
  
  public final void iEe()
  {
    AppMethodBeat.i(30530);
    this.XBo.iEC().iEe();
    iEn();
    AppMethodBeat.o(30530);
  }
  
  public final void iEf()
  {
    AppMethodBeat.i(30535);
    this.XBo.iEC().dvt();
    AppMethodBeat.o(30535);
  }
  
  public final WXRTEditText iEl()
  {
    AppMethodBeat.i(30528);
    Object localObject1 = c.iEg();
    ArrayList localArrayList = this.xAn;
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
          if (this.xAn != null) {
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
        if (localc.XAB != null)
        {
          localArrayList.add(localc.XAB);
          continue;
        }
        if (localc.XAz == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(30528);
      }
      if (localc.XAA != null)
      {
        localObject2.add(localc.XAz);
        localObject2.add(localc.XAA);
      }
    }
    localObject1 = this.xAn.iterator();
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
  
  public final void iEo()
  {
    AppMethodBeat.i(30540);
    if ((this.hDn > 0L) && (this.XBq > 0L))
    {
      String str = c.iEg().dwu();
      if (!str.equals(this.XBr))
      {
        this.XBr = str;
        if (!this.XBt)
        {
          this.XBt = true;
          dQ(this.XBr, true);
          AppMethodBeat.o(30540);
          return;
        }
        dQ(this.XBr, false);
      }
    }
    AppMethodBeat.o(30540);
  }
  
  public final WXRTEditText iEp()
  {
    AppMethodBeat.i(30541);
    WXRTEditText localWXRTEditText = iEl();
    if ((localWXRTEditText == null) && (this.xAn.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.xAn.get(this.xAn.size() - 1);
      AppMethodBeat.o(30541);
      return localWXRTEditText;
    }
    AppMethodBeat.o(30541);
    return localWXRTEditText;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(179745);
    this.XBA.stopTimer();
    this.XBq = -1L;
    if (XBp == this) {
      XBp = null;
    }
    AppMethodBeat.o(179745);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(30527);
    if (paramWXRTEditText.xzI == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cd.a.br(paramWXRTEditText.getContext(), R.f.NormalTextSize));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.XBf = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.xAv);
    AppMethodBeat.o(30527);
  }
  
  public static abstract interface a
  {
    public abstract void r(WXRTEditText paramWXRTEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */