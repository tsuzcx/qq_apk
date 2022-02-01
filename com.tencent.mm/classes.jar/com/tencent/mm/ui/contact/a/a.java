package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class a
{
  public static final int sBE = com.tencent.mm.cc.a.au(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131165517);
  public static final TextPaint sBF;
  public static final int sBG = com.tencent.mm.cc.a.au(com.tencent.mm.sdk.platformtools.ai.getContext(), 2131165466);
  public static final TextPaint sBH;
  public boolean Iwh;
  public boolean Iwi;
  public boolean IzA;
  public boolean IzB = false;
  public boolean IzC = false;
  public boolean IzD;
  public boolean Izz;
  public com.tencent.mm.storage.ai contact;
  public String dby;
  public boolean gbD;
  public boolean nww;
  public final int oeH;
  public final int position;
  public String query;
  public int scene;
  public h sxM;
  public int szA;
  public int szu;
  public int szz;
  
  static
  {
    sBF = new TextPaint();
    sBH = new TextPaint();
    sBF.setTextSize(sBE);
    sBH.setTextSize(sBG);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.oeH = paramInt1;
    this.position = paramInt2;
    ac.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b aOg();
  
  public boolean cKI()
  {
    return false;
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    this.szz = paramInt1;
    this.szA = paramInt2;
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
    
    public abstract boolean aOh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */