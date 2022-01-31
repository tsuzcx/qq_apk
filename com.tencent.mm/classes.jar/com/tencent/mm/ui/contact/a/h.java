package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class h
  extends a
{
  private CharSequence kDy;
  private h.b vOJ = new h.b(this);
  a.a vOK = new a();
  
  public h(int paramInt)
  {
    super(6, paramInt);
  }
  
  protected final a.a VA()
  {
    return this.vOK;
  }
  
  public final a.b Vz()
  {
    return this.vOJ;
  }
  
  public final void bW(Context paramContext)
  {
    this.kDy = f.a(paramContext.getString(a.h.search_contact_no_result_pre), paramContext.getString(a.h.search_contact_no_result_post), d.b(this.bVk, this.bVk)).kwz;
  }
  
  public final class a
    extends a.a
  {
    public TextView kDb;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h
 * JD-Core Version:    0.7.0.1
 */