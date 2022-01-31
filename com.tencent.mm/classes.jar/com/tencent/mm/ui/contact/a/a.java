package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;

public abstract class a
{
  public static final int mVV = com.tencent.mm.cb.a.ao(ah.getContext(), 2131427809);
  public static final TextPaint mVW;
  public static final int mVX = com.tencent.mm.cb.a.ao(ah.getContext(), 2131427758);
  public static final TextPaint mVY;
  public boolean Adl;
  public boolean Adm;
  public boolean AfQ;
  boolean AfR;
  public boolean AfS;
  public ad contact;
  public String cpf;
  public boolean eBr;
  public boolean jTN;
  public final int kwo;
  public g mRX;
  public int mTI;
  public int mTN;
  public int mTO;
  public final int position;
  public String query;
  public int scene;
  
  static
  {
    mVW = new TextPaint();
    mVY = new TextPaint();
    mVW.setTextSize(mVV);
    mVY.setTextSize(mVX);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.kwo = paramInt1;
    this.position = paramInt2;
    ab.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a.a parama);
  
  public abstract a.b aoY();
  
  public boolean bCi()
  {
    return false;
  }
  
  public final void es(int paramInt1, int paramInt2)
  {
    this.mTN = paramInt1;
    this.mTO = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */