package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.l;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  private static DisplayMetrics bTx;
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static k vzA = null;
  public static int vzB = -1;
  private static int vzD = -1;
  public int XO;
  public long cpM;
  public int iPy;
  private int vzC;
  public long vzE;
  public String vzF;
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b vzG;
  private boolean vzH;
  public int vzI;
  public String vzJ;
  public long vzK;
  public int vzL;
  public boolean vzM;
  private View.OnKeyListener vzN;
  public final ap vzO;
  private transient ArrayList<WXRTEditText> vzy;
  public com.tencent.mm.plugin.wenote.ui.nativenote.a vzz;
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    AppMethodBeat.i(26833);
    this.vzE = -1L;
    this.vzF = "";
    this.cpM = -1L;
    this.vzG = null;
    this.vzH = false;
    this.vzI = -1;
    this.vzJ = null;
    this.vzK = -1L;
    this.vzL = 0;
    this.vzM = false;
    this.vzN = new k.1(this);
    this.vzO = new ap(new k.2(this), true);
    this.vzy = new ArrayList();
    this.vzz = parama;
    vzA = this;
    this.XO = f.di(parama.djP());
    this.iPy = af.hT(parama.djP());
    int[] arrayOfInt = com.tencent.mm.compatible.util.j.dh(parama.djP());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    bTx = parama.djP().getResources().getDisplayMetrics();
    this.vzC = (mScreenHeight - this.XO - this.iPy - (int)bo(8.0F));
    this.vzF = c.din().div();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.vBh = 0.0F;
    AppMethodBeat.o(26833);
  }
  
  private void bS(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(26845);
        gi localgi = new gi();
        localgi.cuX.type = 19;
        localgi.cuX.cpT = c.din().ajN(paramString);
        if (localgi.cuX.cpT == null)
        {
          ab.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          AppMethodBeat.o(26845);
          return;
        }
        localgi.cuX.title = paramString;
        localgi.cuX.cpM = this.cpM;
        paramString = localgi.cuX;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.cve = i;
          localgi.cuX.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.ymk.l(localgi);
          if (paramBoolean)
          {
            this.vzI = localgi.cuX.cva.getIntExtra("fav_note_item_status", -1);
            this.vzJ = localgi.cuX.cva.getStringExtra("fav_note_xml");
            this.vzK = localgi.cuX.cva.getLongExtra("fav_note_item_updatetime", -1L);
          }
          AppMethodBeat.o(26845);
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public static float bo(float paramFloat)
  {
    AppMethodBeat.i(26844);
    paramFloat = TypedValue.applyDimension(1, paramFloat, bTx);
    AppMethodBeat.o(26844);
    return paramFloat;
  }
  
  public static k diU()
  {
    return vzA;
  }
  
  private void diV()
  {
    AppMethodBeat.i(26846);
    if ((this.vzE < 0L) && (this.cpM > 0L))
    {
      this.vzO.ag(60000L, 60000L);
      this.vzE = bo.yB();
      this.vzF = c.din().div();
    }
    AppMethodBeat.o(26846);
  }
  
  public static void diY()
  {
    AppMethodBeat.i(26850);
    if (vzA != null) {
      vzA.vzz.djQ().oM(true);
    }
    AppMethodBeat.o(26850);
  }
  
  public final void Lg(int paramInt)
  {
    AppMethodBeat.i(26838);
    this.vzz.djQ().aj(paramInt, 0L);
    AppMethodBeat.o(26838);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26840);
    if ((this.vzL != 2) || (!this.vzM))
    {
      AppMethodBeat.o(26840);
      return;
    }
    this.vzz.djQ().gU(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.vBH.iterator();
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
          if (!(localt instanceof l)) {
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
      this.vzG.oN(bool5);
      this.vzG.oO(bool6);
      this.vzG.oP(bool7);
      this.vzG.oQ(bool8);
      AppMethodBeat.o(26840);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    AppMethodBeat.i(26841);
    String str = paramWXRTEditText.a(i.vzu);
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc = c.din().Lj(paramWXRTEditText.getRecyclerItemPosition());
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
        for (int j = 0;; j = com.tencent.mm.plugin.wenote.b.c.ajV(paramSpannable2.toString()))
        {
          if (!c.din().gV(j - i, 0)) {
            break label140;
          }
          this.vzz.djQ().dhX();
          this.vzz.djQ().Lc(paramWXRTEditText.getRecyclerItemPosition());
          AppMethodBeat.o(26841);
          return;
          i = com.tencent.mm.plugin.wenote.b.c.ajV(paramSpannable1.toString());
          break;
        }
        label140:
        c.din().diq();
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).vwY = paramInt;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
        ((com.tencent.mm.plugin.wenote.model.a.i)localc).vwW = true;
        localc.vxc = false;
        paramWXRTEditText = c.din();
        paramWXRTEditText.vyg = (j - i + paramWXRTEditText.vyg);
      }
      AppMethodBeat.o(26841);
      return;
    }
    paramWXRTEditText.setText("");
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(26841);
      return;
    }
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.din().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.din().gW(paramInt - 1, paramInt + 1);
      AppMethodBeat.o(26841);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26839);
    if (paramBoolean) {}
    try
    {
      diV();
      this.vzz.djQ().a(paramWXRTEditText, paramBoolean, paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(26839);
    }
  }
  
  public final void b(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(26843);
    this.vzz.djQ().a(paramWXRTEditText);
    AppMethodBeat.o(26843);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(26849);
    WXRTEditText localWXRTEditText = diT();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().akX;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.diM();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.diN();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
        AppMethodBeat.o(26849);
        return;
      }
      localWXRTEditText.vzf = true;
      localWXRTEditText.vxg = paramt.djz();
      localWXRTEditText.getText().append("\n");
    }
    AppMethodBeat.o(26849);
  }
  
  public final WXRTEditText diT()
  {
    AppMethodBeat.i(26835);
    Object localObject1 = c.din();
    ArrayList localArrayList = this.vzy;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    label148:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc;
      try
      {
        if (((c)localObject1).iVH == null)
        {
          if (this.vzy != null) {
            break;
          }
          AppMethodBeat.o(26835);
          return null;
        }
        Iterator localIterator = ((c)localObject1).iVH.iterator();
        if (!localIterator.hasNext()) {
          break label148;
        }
        localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc.vxb != null)
        {
          localArrayList.add(localc.vxb);
          continue;
        }
        if (localc.vwZ == null) {
          continue;
        }
      }
      finally
      {
        AppMethodBeat.o(26835);
      }
      if (localc.vxa != null)
      {
        localObject2.add(localc.vwZ);
        localObject2.add(localc.vxa);
      }
    }
    localObject1 = this.vzy.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      WXRTEditText localWXRTEditText = (WXRTEditText)((Iterator)localObject1).next();
      if (localWXRTEditText.hasFocus())
      {
        AppMethodBeat.o(26835);
        return localWXRTEditText;
      }
    }
    AppMethodBeat.o(26835);
    return null;
  }
  
  public final void diW()
  {
    AppMethodBeat.i(26847);
    if ((this.cpM > 0L) && (this.vzE > 0L))
    {
      String str = c.din().div();
      if (!str.equals(this.vzF))
      {
        this.vzF = str;
        if (!this.vzH)
        {
          this.vzH = true;
          bS(this.vzF, true);
          AppMethodBeat.o(26847);
          return;
        }
        bS(this.vzF, false);
      }
    }
    AppMethodBeat.o(26847);
  }
  
  public final WXRTEditText diX()
  {
    AppMethodBeat.i(26848);
    WXRTEditText localWXRTEditText = diT();
    if ((localWXRTEditText == null) && (this.vzy.size() > 0))
    {
      localWXRTEditText = (WXRTEditText)this.vzy.get(this.vzy.size() - 1);
      AppMethodBeat.o(26848);
      return localWXRTEditText;
    }
    AppMethodBeat.o(26848);
    return localWXRTEditText;
  }
  
  public final void dih()
  {
    AppMethodBeat.i(26837);
    this.vzz.djQ().dih();
    diV();
    AppMethodBeat.o(26837);
  }
  
  public final void dij()
  {
    AppMethodBeat.i(26842);
    this.vzz.djQ().dhV();
    AppMethodBeat.o(26842);
  }
  
  public final void h(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(26836);
    this.vzz.djQ().h(paramBoolean, paramLong);
    AppMethodBeat.o(26836);
  }
  
  public final void q(WXRTEditText paramWXRTEditText)
  {
    AppMethodBeat.i(26834);
    if (paramWXRTEditText.vyT == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cb.a.ao(paramWXRTEditText.getContext(), 2131427809));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.vyJ = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.vzN);
    AppMethodBeat.o(26834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */