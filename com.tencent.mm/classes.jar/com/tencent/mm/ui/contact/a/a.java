package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

public abstract class a
{
  public static final int kAd = com.tencent.mm.cb.a.aa(ae.getContext(), a.c.NormalTextSize);
  public static final TextPaint kAe;
  public static final int kAf = com.tencent.mm.cb.a.aa(ae.getContext(), a.c.HintTextSize);
  public static final TextPaint kAg;
  public String bHQ;
  public String bVk;
  public boolean dDQ;
  public ad dnp;
  public boolean icY;
  public final int ivk;
  public g kwi;
  public int kxV;
  public int kya;
  public int kyb;
  public final int position;
  public int scene;
  public boolean vLJ;
  public boolean vLK;
  public boolean vOi;
  boolean vOj;
  public boolean vOk;
  
  static
  {
    kAe = new TextPaint();
    kAg = new TextPaint();
    kAe.setTextSize(kAd);
    kAg.setTextSize(kAf);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.ivk = paramInt1;
    this.position = paramInt2;
    y.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract a.a VA();
  
  public abstract a.b Vz();
  
  public boolean aVG()
  {
    return false;
  }
  
  public abstract void bW(Context paramContext);
  
  public final void cU(int paramInt1, int paramInt2)
  {
    this.kya = paramInt1;
    this.kyb = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */