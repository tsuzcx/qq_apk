package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ag.d.a;

public final class c
  extends i
  implements d.a
{
  a rZc = (a)this.nav;
  int rZd;
  
  public c(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private c(String paramString, byte paramByte)
  {
    super(new a(a.b.cmd()), paramString, (byte)0);
  }
  
  private static final class a
    implements i.a
  {
    Bitmap iez = null;
    private i.a nav;
    
    public a(i.a parama)
    {
      this.nav = parama;
    }
    
    public final void a(i parami)
    {
      if (this.nav != null) {
        this.nav.a(parami);
      }
    }
    
    public final Bitmap b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.nav != null) {
        return this.nav.b(paramString, paramInt1, paramInt2, paramInt3);
      }
      return null;
    }
    
    public final Bitmap ch(String paramString)
    {
      if (this.nav != null) {
        return this.nav.ch(paramString);
      }
      return null;
    }
    
    public final Bitmap ci(String paramString)
    {
      if (this.nav != null) {
        return this.nav.ci(paramString);
      }
      return null;
    }
    
    public final Bitmap sG()
    {
      if ((this.iez != null) && (!this.iez.isRecycled())) {
        return this.iez;
      }
      if (this.nav != null) {
        return this.nav.sG();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */