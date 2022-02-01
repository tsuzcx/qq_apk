package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;

public abstract class a
{
  public static final int wZV = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165535);
  public static final TextPaint wZW;
  public static final int wZX = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), 2131165482);
  public static final TextPaint wZY;
  public boolean PWh;
  public boolean PWi;
  public boolean PZZ;
  public boolean Qaa;
  public boolean Qab = false;
  public boolean Qac = false;
  public boolean Qad;
  public as contact;
  public String dFl;
  public boolean hkH;
  public boolean poB;
  public final int position;
  public final int qcr;
  public String query;
  public int scene;
  public h wWd;
  public int wXL;
  public int wXQ;
  public int wXR;
  
  static
  {
    wZW = new TextPaint();
    wZY = new TextPaint();
    wZW.setTextSize(wZV);
    wZY.setTextSize(wZX);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.qcr = paramInt1;
    this.position = paramInt2;
    Log.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public abstract b bmx();
  
  public boolean dOL()
  {
    return false;
  }
  
  public final void gE(int paramInt1, int paramInt2)
  {
    this.wXQ = paramInt1;
    this.wXR = paramInt2;
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
    
    public abstract boolean bmy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */