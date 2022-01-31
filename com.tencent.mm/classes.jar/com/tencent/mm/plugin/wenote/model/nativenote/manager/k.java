package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.OnKeyListener;
import com.tencent.mm.R.f;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.l;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
  implements com.tencent.mm.plugin.wenote.model.nativenote.b.c
{
  public static int mScreenHeight;
  public static int mScreenWidth;
  public static k rIU = null;
  private static DisplayMetrics rIV;
  public static int rIW = -1;
  private static int rIY = -1;
  public int Xc;
  public long bIr = -1L;
  public int heA;
  private transient ArrayList<WXRTEditText> rIS = new ArrayList();
  public com.tencent.mm.plugin.wenote.ui.nativenote.a rIT;
  private int rIX;
  public long rIZ = -1L;
  public String rJa = "";
  public com.tencent.mm.plugin.wenote.model.nativenote.b.b rJb = null;
  private boolean rJc = false;
  public int rJd = -1;
  public String rJe = null;
  public long rJf = -1L;
  public int rJg = 0;
  public boolean rJh = false;
  private View.OnKeyListener rJi = new k.1(this);
  public final am rJj = new am(new k.2(this), true);
  
  public k(com.tencent.mm.plugin.wenote.ui.nativenote.a parama)
  {
    this.rIT = parama;
    rIU = this;
    this.Xc = com.tencent.mm.pluginsdk.e.cD(parama.cjo());
    this.heA = ak.gz(parama.cjo());
    int[] arrayOfInt = com.tencent.mm.compatible.util.j.cY(parama.cjo());
    mScreenHeight = arrayOfInt[1];
    mScreenWidth = arrayOfInt[0];
    rIV = parama.cjo().getResources().getDisplayMetrics();
    this.rIX = (mScreenHeight - this.Xc - this.heA - (int)az(8.0F));
    this.rJa = c.chX().cie();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.m.rKD = 0.0F;
  }
  
  public static float az(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, rIV);
  }
  
  private void bs(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        gf localgf = new gf();
        localgf.bNF.type = 19;
        localgf.bNF.bIy = c.chX().Uy(paramString);
        if (localgf.bNF.bIy == null)
        {
          y.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
          return;
        }
        localgf.bNF.title = paramString;
        localgf.bNF.bIr = this.bIr;
        paramString = localgf.bNF;
        int i;
        if (paramBoolean)
        {
          i = 1;
          paramString.bNM = i;
          localgf.bNF.desc = "fav_update_note_storage";
          com.tencent.mm.sdk.b.a.udP.m(localgf);
          if (paramBoolean)
          {
            this.rJd = localgf.bNF.bNI.getIntExtra("fav_note_item_status", -1);
            this.rJe = localgf.bNF.bNI.getStringExtra("fav_note_xml");
            this.rJf = localgf.bNF.bNI.getLongExtra("fav_note_item_updatetime", -1L);
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  public static k ciD()
  {
    return rIU;
  }
  
  private void ciE()
  {
    if ((this.rIZ < 0L) && (this.bIr > 0L))
    {
      this.rJj.S(60000L, 60000L);
      this.rIZ = bk.UZ();
      this.rJa = c.chX().cie();
    }
  }
  
  public static void ciH()
  {
    if (rIU != null) {
      rIU.rIT.cjp().lB(true);
    }
  }
  
  public final void Dn(int paramInt)
  {
    this.rIT.cjp().U(paramInt, 0L);
  }
  
  public final void a(WXRTEditText paramWXRTEditText, int paramInt1, int paramInt2)
  {
    if ((this.rJg != 2) || (!this.rJh)) {}
    while (paramWXRTEditText == null) {
      return;
    }
    this.rIT.cjp().eO(paramInt1, paramInt2);
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool5;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      Iterator localIterator = u.rLd.iterator();
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
          break label178;
        }
        localt = (t)localIterator.next();
        if (!localt.q(paramWXRTEditText)) {
          break label223;
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
        break label223;
      }
      bool1 = true;
    }
    label178:
    label223:
    for (;;)
    {
      break;
      bool8 = false;
      bool7 = false;
      bool6 = false;
      bool5 = false;
      this.rJb.lC(bool5);
      this.rJb.lD(bool6);
      this.rJb.lE(bool7);
      this.rJb.lF(bool8);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, Spannable paramSpannable1, Spannable paramSpannable2, int paramInt)
  {
    String str = paramWXRTEditText.a(i.rIO);
    com.tencent.mm.plugin.wenote.model.a.c localc;
    int i;
    int j;
    if (paramWXRTEditText.getEditTextType() == 0)
    {
      localc = c.chX().Dq(paramWXRTEditText.getRecyclerItemPosition());
      if ((localc != null) && (localc.getType() == 1))
      {
        if (paramSpannable1 != null) {
          break label104;
        }
        i = 0;
        if (paramSpannable2 != null) {
          break label116;
        }
        j = 0;
        label56:
        if (!c.chX().eP(j - i, 0)) {
          break label128;
        }
        this.rIT.cjp().chH();
        this.rIT.cjp().Dj(paramWXRTEditText.getRecyclerItemPosition());
      }
    }
    label104:
    label116:
    do
    {
      return;
      i = com.tencent.mm.plugin.wenote.b.c.UF(paramSpannable1.toString());
      break;
      j = com.tencent.mm.plugin.wenote.b.c.UF(paramSpannable2.toString());
      break label56;
      c.chX().cia();
      ((com.tencent.mm.plugin.wenote.model.a.i)localc).rGp = paramInt;
      ((com.tencent.mm.plugin.wenote.model.a.i)localc).content = str;
      ((com.tencent.mm.plugin.wenote.model.a.i)localc).rGn = true;
      localc.rGt = false;
      paramWXRTEditText = c.chX();
      paramWXRTEditText.rHz = (j - i + paramWXRTEditText.rHz);
      return;
      paramWXRTEditText.setText("");
    } while (bk.bl(str));
    label128:
    paramSpannable2 = new com.tencent.mm.plugin.wenote.model.a.i();
    if (str.equals("<br/>")) {}
    for (paramSpannable1 = "";; paramSpannable1 = str)
    {
      paramSpannable2.content = paramSpannable1;
      paramInt = c.chX().a(paramSpannable2, paramWXRTEditText, true, false, false);
      c.chX().eQ(paramInt - 1, paramInt + 1);
      return;
    }
  }
  
  public final void a(WXRTEditText paramWXRTEditText, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      ciE();
      this.rIT.cjp().a(paramWXRTEditText, paramBoolean, paramInt);
      return;
    }
    finally {}
  }
  
  public final void b(WXRTEditText paramWXRTEditText)
  {
    this.rIT.cjp().a(paramWXRTEditText);
  }
  
  public final <V, C extends g<V>> void b(t<V, C> paramt, V paramV)
  {
    WXRTEditText localWXRTEditText = ciC();
    if (localWXRTEditText != null)
    {
      if (localWXRTEditText.getEditTextType() == 0)
      {
        int i = localWXRTEditText.getSelection().aiH;
        int j = localWXRTEditText.getText().length();
        if (((paramV instanceof Boolean)) && (((Boolean)paramV).booleanValue()) && (i == j))
        {
          localWXRTEditText.civ();
          localWXRTEditText.getText().append("\n");
          localWXRTEditText.ciw();
          localWXRTEditText.setSelection(i);
        }
        localWXRTEditText.a(paramt, paramV);
      }
    }
    else {
      return;
    }
    localWXRTEditText.rIz = true;
    localWXRTEditText.rGx = paramt.ciY();
    localWXRTEditText.getText().append("\n");
  }
  
  public final void chR()
  {
    this.rIT.cjp().chR();
    ciE();
  }
  
  public final void chT()
  {
    this.rIT.cjp().chF();
  }
  
  public final WXRTEditText ciC()
  {
    Object localObject1 = c.chX();
    ArrayList localArrayList = this.rIS;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    label130:
    for (;;)
    {
      com.tencent.mm.plugin.wenote.model.a.c localc;
      try
      {
        if (((c)localObject1).hka == null)
        {
          if (this.rIS != null) {
            break;
          }
          return null;
        }
        Iterator localIterator = ((c)localObject1).hka.iterator();
        if (!localIterator.hasNext()) {
          break label130;
        }
        localc = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc.rGs != null)
        {
          localArrayList.add(localc.rGs);
          continue;
        }
        if (localc.rGq == null) {
          continue;
        }
      }
      finally {}
      if (localc.rGr != null)
      {
        localObject2.add(localc.rGq);
        localObject2.add(localc.rGr);
      }
    }
    localObject1 = this.rIS.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      WXRTEditText localWXRTEditText = (WXRTEditText)((Iterator)localObject1).next();
      if (localWXRTEditText.hasFocus()) {
        return localWXRTEditText;
      }
    }
    return null;
  }
  
  public final void ciF()
  {
    if ((this.bIr > 0L) && (this.rIZ > 0L))
    {
      String str = c.chX().cie();
      if (!str.equals(this.rJa))
      {
        this.rJa = str;
        if (this.rJc) {
          break label63;
        }
        this.rJc = true;
        bs(this.rJa, true);
      }
    }
    return;
    label63:
    bs(this.rJa, false);
  }
  
  public final WXRTEditText ciG()
  {
    WXRTEditText localWXRTEditText2 = ciC();
    WXRTEditText localWXRTEditText1 = localWXRTEditText2;
    if (localWXRTEditText2 == null)
    {
      localWXRTEditText1 = localWXRTEditText2;
      if (this.rIS.size() > 0) {
        localWXRTEditText1 = (WXRTEditText)this.rIS.get(this.rIS.size() - 1);
      }
    }
    return localWXRTEditText1;
  }
  
  public final void f(boolean paramBoolean, long paramLong)
  {
    this.rIT.cjp().f(paramBoolean, paramLong);
  }
  
  public final void o(WXRTEditText paramWXRTEditText)
  {
    if (paramWXRTEditText.rIn == 0) {
      paramWXRTEditText.setTextSize(0, com.tencent.mm.cb.a.aa(paramWXRTEditText.getContext(), R.f.NormalTextSize));
    }
    b.setTextSize(paramWXRTEditText.getTextSize());
    paramWXRTEditText.rId = this;
    paramWXRTEditText.setRichTextEditing(null);
    paramWXRTEditText.setOnKeyListener(this.rJi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.k
 * JD-Core Version:    0.7.0.1
 */