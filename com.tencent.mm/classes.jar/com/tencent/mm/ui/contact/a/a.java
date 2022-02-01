package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;

public abstract class a
{
  public static final int tyf = com.tencent.mm.cc.a.ax(aj.getContext(), 2131165517);
  public static final TextPaint tyg;
  public static final int tyh = com.tencent.mm.cc.a.ax(aj.getContext(), 2131165466);
  public static final TextPaint tyi;
  public boolean KmP;
  public boolean KmQ;
  public boolean KqF;
  public boolean KqG;
  public boolean KqH = false;
  public boolean KqI = false;
  public boolean KqJ;
  public am contact;
  public String dmU;
  public boolean gvn;
  public boolean nXU;
  public final int oIb;
  public final int position;
  public String query;
  public int scene;
  public h tun;
  public int tvV;
  public int twa;
  public int twb;
  
  static
  {
    tyg = new TextPaint();
    tyi = new TextPaint();
    tyg.setTextSize(tyf);
    tyi.setTextSize(tyh);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.oIb = paramInt1;
    this.position = paramInt2;
    ad.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b aRs();
  
  public boolean cSX()
  {
    return false;
  }
  
  public final void gf(int paramInt1, int paramInt2)
  {
    this.twa = paramInt1;
    this.twb = paramInt2;
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
    
    public abstract boolean aRt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */