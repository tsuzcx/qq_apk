package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;

public abstract class a
{
  public static final int HwQ = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.c.NormalTextSize);
  public static final TextPaint HwR;
  public static final int HwS = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.c.HintTextSize);
  public static final TextPaint HwT;
  public boolean Bva = false;
  public j FWt;
  public int Huq;
  public int Huv;
  public int Huw;
  public boolean JXr = false;
  public boolean afey;
  public boolean afez;
  public boolean afjA;
  public boolean afjB = false;
  public boolean afjC = false;
  public boolean afjD = false;
  public boolean afjE;
  public boolean afjz;
  public au contact;
  public String desc;
  public String hCy;
  public boolean mwk;
  public final int position;
  public String query;
  public int scene;
  public boolean vDh;
  public final int viewType;
  
  static
  {
    HwR = new TextPaint();
    HwT = new TextPaint();
    HwR.setTextSize(HwQ);
    HwT.setTextSize(HwS);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.viewType = paramInt1;
    this.position = paramInt2;
    Log.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b bVv();
  
  protected abstract a bVw();
  
  public boolean fxL()
  {
    return false;
  }
  
  public final void iW(int paramInt1, int paramInt2)
  {
    this.Huv = paramInt1;
    this.Huw = paramInt2;
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
    
    public abstract boolean a(Context paramContext, View paramView, a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */