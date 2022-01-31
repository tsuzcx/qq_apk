package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public final class du
  extends ds
{
  public du(Context paramContext)
  {
    super(paramContext, 0, 100);
  }
  
  public final cs a()
  {
    Object localObject = c.m();
    byte[] arrayOfByte = "".getBytes();
    try
    {
      localObject = e.a(c(), (c)localObject, arrayOfByte, -1, -1);
      if (localObject != null) {
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      cy.a(localThrowable);
      cy.d("encode2RequestPackage failed", new Object[0]);
    }
    return null;
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.du
 * JD-Core Version:    0.7.0.1
 */