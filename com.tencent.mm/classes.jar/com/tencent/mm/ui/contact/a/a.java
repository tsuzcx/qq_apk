package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;

public abstract class a
{
  public static final int rsK = com.tencent.mm.cd.a.ao(aj.getContext(), 2131165517);
  public static final TextPaint rsL;
  public static final int rsM = com.tencent.mm.cd.a.ao(aj.getContext(), 2131165466);
  public static final TextPaint rsN;
  public boolean GVT;
  public boolean GVU;
  public boolean GZj;
  public boolean GZk;
  public boolean GZl;
  public af contact;
  public String dec;
  public boolean fWW;
  public boolean mUe;
  public final int nBH;
  public final int position;
  public String query;
  public h roS;
  public int rqA;
  public int rqF;
  public int rqG;
  public int scene;
  
  static
  {
    rsL = new TextPaint();
    rsN = new TextPaint();
    rsL.setTextSize(rsK);
    rsN.setTextSize(rsM);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.nBH = paramInt1;
    this.position = paramInt2;
    ad.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b aHr();
  
  public boolean cxw()
  {
    return false;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    this.rqF = paramInt1;
    this.rqG = paramInt2;
  }
  
  public class a
  {
    public a() {}
  }
  
  public abstract class b
  {
    public b() {}
    
    public abstract View a(Context paramContext, ViewGroup paramViewGroup);
    
    public abstract void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract boolean aHs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */