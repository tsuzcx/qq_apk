package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IEvent;

public abstract interface a
{
  public abstract boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract byte[] TJ(int paramInt);
  
  public abstract String TK(int paramInt);
  
  public abstract void TL(int paramInt);
  
  public abstract byte[] TM(int paramInt);
  
  public abstract void a(View paramView, Class<? extends IEvent> paramClass);
  
  public abstract void a(b paramb);
  
  public abstract void a(String paramString, MotionEvent paramMotionEvent);
  
  public abstract boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray);
  
  public abstract boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray);
  
  public abstract void aA(String paramString1, String paramString2, String paramString3);
  
  public abstract String aIJ(String paramString);
  
  public abstract void aIL(String paramString);
  
  public abstract void aIM(String paramString);
  
  public abstract void aIN(String paramString);
  
  public abstract boolean aIO(String paramString);
  
  public abstract byte[] aIP(String paramString);
  
  public abstract void aIQ(String paramString);
  
  public abstract boolean aIR(String paramString);
  
  public abstract byte[] aIS(String paramString);
  
  public abstract String aIT(String paramString);
  
  public abstract String[] aIU(String paramString);
  
  public abstract String aoK();
  
  public abstract void au(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean c(Object paramObject, Class paramClass);
  
  public abstract boolean dH(Object paramObject);
  
  public abstract void eW(String paramString, int paramInt);
  
  public abstract String exG();
  
  public abstract boolean exH();
  
  public abstract boolean exI();
  
  public abstract byte[] exJ();
  
  public abstract byte[] exK();
  
  public abstract boolean exL();
  
  public abstract byte[] exM();
  
  public abstract boolean exN();
  
  public abstract String exO();
  
  public abstract String exP();
  
  public abstract String exQ();
  
  public abstract com.tencent.mm.normsg.a exR();
  
  public abstract com.tencent.mm.normsgext.a exS();
  
  public abstract void exT();
  
  public abstract void jf(String paramString1, String paramString2);
  
  public abstract String sv(boolean paramBoolean);
  
  public abstract void sw(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.a
 * JD-Core Version:    0.7.0.1
 */