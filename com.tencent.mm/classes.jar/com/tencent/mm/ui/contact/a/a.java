package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;

public abstract class a
{
  public static final int tIW = com.tencent.mm.cb.a.ax(ak.getContext(), 2131165517);
  public static final TextPaint tIX;
  public static final int tIY = com.tencent.mm.cb.a.ax(ak.getContext(), 2131165466);
  public static final TextPaint tIZ;
  public boolean KJj;
  public boolean KJk;
  public boolean KMZ;
  public boolean KNa;
  public boolean KNb = false;
  public boolean KNc = false;
  public boolean KNd;
  public an contact;
  public String dnW;
  public boolean gxU;
  public final int oOD;
  public boolean odD;
  public final int position;
  public String query;
  public int scene;
  public h tFe;
  public int tGM;
  public int tGR;
  public int tGS;
  
  static
  {
    tIX = new TextPaint();
    tIZ = new TextPaint();
    tIX.setTextSize(tIW);
    tIZ.setTextSize(tIY);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.oOD = paramInt1;
    this.position = paramInt2;
    ae.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b aRR();
  
  public boolean cVC()
  {
    return false;
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    this.tGR = paramInt1;
    this.tGS = paramInt2;
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
    
    public abstract boolean aRS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */