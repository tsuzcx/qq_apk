package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public abstract class ds
{
  protected final int a;
  protected final int b;
  protected Context c;
  protected String d;
  
  public ds(Context paramContext, int paramInt1, int paramInt2)
  {
    this.c = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
  }
  
  public static cs a(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = e.a(paramInt, c.m(), paramArrayOfByte, 2, 3);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      cy.c("imposiable comStrategy error:%s", new Object[] { paramArrayOfByte.toString() });
      cy.a(paramArrayOfByte);
    }
    return null;
  }
  
  public abstract cs a();
  
  public void b()
  {
    cy.c("encode failed, clear db data", new Object[0]);
  }
  
  public abstract void b(boolean paramBoolean);
  
  public final int c()
  {
    return this.a;
  }
  
  public final String d()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    try
    {
      if (this.b == 0) {
        return ck.a(this.c).e().b();
      }
      String str = ck.a(this.c).e().b(this.b).b();
      return str;
    }
    catch (Throwable localThrowable)
    {
      cy.c("imposiable comStrategy error:%s", new Object[] { localThrowable.toString() });
      cy.a(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ds
 * JD-Core Version:    0.7.0.1
 */