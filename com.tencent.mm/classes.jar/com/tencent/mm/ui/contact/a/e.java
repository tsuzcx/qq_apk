package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.pluginsdk.ui.d.j;

public class e
  extends a
{
  public CharSequence eXK;
  public String username;
  private e.b vOA = new e.b(this);
  e.a vOB = new e.a(this);
  public CharSequence vOy;
  public int vOz = 0;
  
  public e(int paramInt)
  {
    super(4, paramInt);
  }
  
  protected final a.a VA()
  {
    return this.vOB;
  }
  
  public final a.b Vz()
  {
    return this.vOA;
  }
  
  public void bW(Context paramContext)
  {
    if ((this.vOz != 0) && (this.vOy != null)) {
      return;
    }
    if (this.dnp == null)
    {
      this.eXK = "";
      this.username = "";
      return;
    }
    this.eXK = j.b(paramContext, ((b)g.r(b.class)).c(this.dnp), com.tencent.mm.cb.a.aa(paramContext, a.c.NormalTextSize));
    this.username = this.dnp.field_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.e
 * JD-Core Version:    0.7.0.1
 */