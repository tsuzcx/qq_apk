package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;

public enum b
  implements a
{
  private static a mGL = new a((byte)0);
  
  private b() {}
  
  public static void a(a parama)
  {
    if (parama != null) {
      mGL = parama;
    }
  }
  
  public final void JV(String paramString)
  {
    mGL.JV(paramString);
  }
  
  public final void JW(String paramString)
  {
    mGL.JW(paramString);
  }
  
  public final void JX(String paramString)
  {
    mGL.JX(paramString);
  }
  
  public final boolean JY(String paramString)
  {
    return mGL.JY(paramString);
  }
  
  public final byte[] JZ(String paramString)
  {
    return mGL.JZ(paramString);
  }
  
  public final void Ka(String paramString)
  {
    mGL.Ka(paramString);
  }
  
  public final boolean Kb(String paramString)
  {
    return mGL.Kb(paramString);
  }
  
  public final byte[] Kc(String paramString)
  {
    return mGL.Kc(paramString);
  }
  
  public final String Kd(String paramString)
  {
    return mGL.Kd(paramString);
  }
  
  public final void S(int paramInt1, int paramInt2, int paramInt3)
  {
    mGL.S(paramInt1, paramInt2, paramInt3);
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    mGL.a(paramView, paramClass);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    mGL.a(paramString, paramMotionEvent);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    return mGL.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
  }
  
  public final boolean boG()
  {
    return mGL.boG();
  }
  
  public final boolean boJ()
  {
    return mGL.boJ();
  }
  
  public final boolean boK()
  {
    return mGL.boK();
  }
  
  public final boolean boL()
  {
    return mGL.boL();
  }
  
  public final String boN()
  {
    return mGL.boN();
  }
  
  public final boolean boO()
  {
    return mGL.boO();
  }
  
  public final byte[] boP()
  {
    return mGL.boP();
  }
  
  public final boolean bu(Object paramObject)
  {
    return mGL.bu(paramObject);
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    return mGL.c(paramObject, paramClass);
  }
  
  public final void ei(String paramString1, String paramString2)
  {
    mGL.ei(paramString1, paramString2);
  }
  
  public final String hY(boolean paramBoolean)
  {
    return mGL.hY(paramBoolean);
  }
  
  public final byte[] vq(int paramInt)
  {
    return mGL.vq(paramInt);
  }
  
  public final String vr(int paramInt)
  {
    return mGL.vr(paramInt);
  }
  
  public final void vs(int paramInt)
  {
    mGL.vs(paramInt);
  }
  
  private static final class a
    implements a
  {
    public final void JV(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final void JW(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final void JX(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final boolean JY(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final byte[] JZ(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return new byte[0];
    }
    
    public final void Ka(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final boolean Kb(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final byte[] Kc(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return new byte[0];
    }
    
    public final String Kd(String paramString)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return paramString;
    }
    
    public final void S(int paramInt1, int paramInt2, int paramInt3)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final boolean boG()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final boolean boJ()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final boolean boK()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final boolean boL()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final String boN()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return "";
    }
    
    public final boolean boO()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final byte[] boP()
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return new byte[0];
    }
    
    public final boolean bu(Object paramObject)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final boolean c(Object paramObject, Class paramClass)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return false;
    }
    
    public final void ei(String paramString1, String paramString2)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
    
    public final String hY(boolean paramBoolean)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return "";
    }
    
    public final byte[] vq(int paramInt)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return new byte[0];
    }
    
    public final String vr(int paramInt)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      return "";
    }
    
    public final void vs(int paramInt)
    {
      y.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.b
 * JD-Core Version:    0.7.0.1
 */