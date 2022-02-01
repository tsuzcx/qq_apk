package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.q;
import com.tencent.mm.normsgext.d.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;

public enum d
  implements a
{
  private static final byte[] GxK;
  private static a GxL;
  
  static
  {
    AppMethodBeat.i(155541);
    GxJ = new d("INSTANCE");
    GxM = new d[] { GxJ };
    GxK = new byte[0];
    GxL = new d.a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private d() {}
  
  public static void a(a parama)
  {
    AppMethodBeat.i(222450);
    if (!(GxL instanceof d.a))
    {
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
      AppMethodBeat.o(222450);
      return;
    }
    synchronized (GxK)
    {
      if ((GxL instanceof d.a))
      {
        if (parama != null)
        {
          c.q.c0(parama.fjv());
          d.n.c0(parama.fjw());
          parama.fjx();
          GxL = parama;
        }
        AppMethodBeat.o(222450);
        return;
      }
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
    }
  }
  
  public final boolean M(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = GxL.M(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(155521);
    GxL.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(222505);
    GxL.a(paramb);
    AppMethodBeat.o(222505);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    GxL.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = GxL.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = GxL.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final String aTf(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = GxL.aTf(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void aTh(String paramString)
  {
    AppMethodBeat.i(155525);
    GxL.aTh(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void aTi(String paramString)
  {
    AppMethodBeat.i(155526);
    GxL.aTi(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void aTj(String paramString)
  {
    AppMethodBeat.i(155527);
    GxL.aTj(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean aTk(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = GxL.aTk(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] aTl(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = GxL.aTl(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void aTm(String paramString)
  {
    AppMethodBeat.i(155532);
    GxL.aTm(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = GxL.aTn(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] aTo(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = GxL.aTo(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final String aTp(String paramString)
  {
    AppMethodBeat.i(222479);
    paramString = GxL.aTp(paramString);
    AppMethodBeat.o(222479);
    return paramString;
  }
  
  public final String[] aTq(String paramString)
  {
    AppMethodBeat.i(222500);
    paramString = GxL.aTq(paramString);
    AppMethodBeat.o(222500);
    return paramString;
  }
  
  public final byte[] aaw(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = GxL.aaw(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String aax(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = GxL.aax(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void aay(int paramInt)
  {
    AppMethodBeat.i(155522);
    GxL.aay(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] aaz(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = GxL.aaz(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final String auQ()
  {
    AppMethodBeat.i(155540);
    String str = GxL.auQ();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void av(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(222473);
    GxL.av(paramString1, paramString2, paramString3);
    AppMethodBeat.o(222473);
  }
  
  public final void ay(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    GxL.ay(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = GxL.c(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final boolean dK(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = GxL.dK(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final String fjk()
  {
    AppMethodBeat.i(155515);
    String str = GxL.fjk();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean fjl()
  {
    AppMethodBeat.i(155516);
    boolean bool = GxL.fjl();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean fjm()
  {
    AppMethodBeat.i(155517);
    boolean bool = GxL.fjm();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] fjn()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = GxL.fjn();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] fjo()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = GxL.fjo();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean fjp()
  {
    AppMethodBeat.i(155538);
    boolean bool = GxL.fjp();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] fjq()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = GxL.fjq();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean fjr()
  {
    AppMethodBeat.i(222488);
    boolean bool = GxL.fjr();
    AppMethodBeat.o(222488);
    return bool;
  }
  
  public final String fjs()
  {
    AppMethodBeat.i(222491);
    String str = GxL.fjs();
    AppMethodBeat.o(222491);
    return str;
  }
  
  public final String fjt()
  {
    AppMethodBeat.i(222493);
    String str = GxL.fjt();
    AppMethodBeat.o(222493);
    return str;
  }
  
  public final String fju()
  {
    AppMethodBeat.i(222495);
    String str = GxL.fju();
    AppMethodBeat.o(222495);
    return str;
  }
  
  public final com.tencent.mm.normsg.a fjv()
  {
    AppMethodBeat.i(222497);
    com.tencent.mm.normsg.a locala = GxL.fjv();
    AppMethodBeat.o(222497);
    return locala;
  }
  
  public final com.tencent.mm.normsgext.a fjw()
  {
    AppMethodBeat.i(222498);
    com.tencent.mm.normsgext.a locala = GxL.fjw();
    AppMethodBeat.o(222498);
    return locala;
  }
  
  public final void fjx()
  {
    AppMethodBeat.i(222502);
    GxL.fjx();
    AppMethodBeat.o(222502);
  }
  
  public final void fx(String paramString, int paramInt)
  {
    AppMethodBeat.i(222503);
    GxL.fx(paramString, paramInt);
    AppMethodBeat.o(222503);
  }
  
  public final void jr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    GxL.jr(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = GxL.vJ(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final void vK(boolean paramBoolean)
  {
    AppMethodBeat.i(222507);
    GxL.vK(paramBoolean);
    AppMethodBeat.o(222507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.d
 * JD-Core Version:    0.7.0.1
 */