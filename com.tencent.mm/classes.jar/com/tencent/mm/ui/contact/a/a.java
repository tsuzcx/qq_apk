package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;

public abstract class a
{
  public static final int BLU = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.c.NormalTextSize);
  public static final TextPaint BLV;
  public static final int BLW = com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.c.HintTextSize);
  public static final TextPaint BLX;
  public h BHY;
  public int BJH;
  public int BJM;
  public int BJN;
  public boolean XsX;
  public boolean XsY;
  public boolean Xxr;
  public boolean Xxs;
  public boolean Xxt = false;
  public boolean Xxu = false;
  public boolean Xxv;
  public as contact;
  public String fxT;
  public boolean jWq;
  public final int position;
  public String query;
  public int scene;
  public boolean sxA;
  public final int viewType;
  public boolean xUe = false;
  
  static
  {
    BLV = new TextPaint();
    BLX = new TextPaint();
    BLV.setTextSize(BLU);
    BLX.setTextSize(BLW);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    this.viewType = paramInt1;
    this.position = paramInt2;
    Log.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  protected static SpannableString y(Context paramContext, String paramString, int paramInt)
  {
    return l.d(paramContext, paramString, paramInt);
  }
  
  public final void GR(boolean paramBoolean)
  {
    this.XsX = paramBoolean;
  }
  
  public abstract void a(Context paramContext, a parama);
  
  public final void aF(as paramas)
  {
    this.contact = paramas;
  }
  
  public final void aIh(String paramString)
  {
    this.query = paramString;
  }
  
  public final void bAk(String paramString)
  {
    this.fxT = paramString;
  }
  
  public abstract b bwF();
  
  protected abstract a bwG();
  
  public final void c(h paramh)
  {
    this.BHY = paramh;
  }
  
  public boolean ere()
  {
    return false;
  }
  
  public final boolean fJk()
  {
    return this.XsX;
  }
  
  public final as fqR()
  {
    return this.contact;
  }
  
  public final h hVx()
  {
    return this.BHY;
  }
  
  public final String hVy()
  {
    return this.fxT;
  }
  
  public final void hx(int paramInt1, int paramInt2)
  {
    this.BJM = paramInt1;
    this.BJN = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.a
 * JD-Core Version:    0.7.0.1
 */