package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.c.a.b;

public final class g$a
{
  public c few;
  public DialogInterface.OnDismissListener hsn;
  Context mContext;
  final c.a scn;
  String sco = null;
  
  public g$a(Context paramContext)
  {
    this.mContext = paramContext;
    this.scn = new c.a(this.mContext);
    this.scn.nW(false);
    this.scn.nX(false);
    this.scn.a(new g.a.1(this));
  }
  
  public final a DY(int paramInt)
  {
    this.sco = this.mContext.getResources().getString(paramInt);
    return this;
  }
  
  public final a WF(String paramString)
  {
    int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cb.a.cJ(this.mContext)));
    if (!bk.bl(paramString))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.emoji.b.a.class)).a(paramString.toString(), i);
      this.scn.U(paramString);
    }
    return this;
  }
  
  public final a WG(String paramString)
  {
    this.scn.aeB(paramString);
    return this;
  }
  
  public final a WH(String paramString)
  {
    g.a(this.mContext, this.scn, paramString);
    this.scn.nU(false);
    return this;
  }
  
  public final a a(q.a parama)
  {
    this.few = this.scn.aoP();
    if (this.hsn != null) {
      this.few.setOnDismissListener(this.hsn);
    }
    g.a(this.mContext, this.few, this.sco, parama, parama);
    return this;
  }
  
  public final a a(c.a.b paramb)
  {
    this.scn.wmT.wlM = paramb;
    return this;
  }
  
  public final a bM(Object paramObject)
  {
    g.b(this.mContext, this.scn, paramObject);
    this.scn.nU(true);
    return this;
  }
  
  public final a cmI()
  {
    this.scn.wmT.wmk = 2;
    return this;
  }
  
  public final a cmJ()
  {
    this.scn.wmT.wmn = 8;
    return this;
  }
  
  public final a cmK()
  {
    this.scn.nU(false);
    return this;
  }
  
  public final a d(Bitmap paramBitmap, int paramInt)
  {
    this.scn.a(paramBitmap, true, paramInt);
    this.scn.nU(false);
    g.b(this.scn, paramBitmap);
    return this;
  }
  
  public final a dw(View paramView)
  {
    this.scn.ei(paramView);
    return this;
  }
  
  public final a g(Boolean paramBoolean)
  {
    this.scn.nV(paramBoolean.booleanValue());
    if (paramBoolean.booleanValue()) {
      this.scn.aeC(this.mContext.getString(R.l.confirm_dialog_edittext_hint));
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.a
 * JD-Core Version:    0.7.0.1
 */