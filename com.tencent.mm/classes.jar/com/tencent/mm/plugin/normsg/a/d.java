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
  private static final byte[] MtQ;
  private static a MtR;
  
  static
  {
    AppMethodBeat.i(155541);
    MtP = new d("INSTANCE");
    MtS = new d[] { MtP };
    MtQ = new byte[0];
    MtR = new d.a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private d() {}
  
  public static void a(a parama)
  {
    AppMethodBeat.i(261950);
    if (!(MtR instanceof d.a))
    {
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
      AppMethodBeat.o(261950);
      return;
    }
    synchronized (MtQ)
    {
      if ((MtR instanceof d.a))
      {
        if (parama != null)
        {
          c.q.c0(parama.gtM());
          d.n.c0(parama.gtN());
          parama.gtO();
          MtR = parama;
        }
        AppMethodBeat.o(261950);
        return;
      }
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
    }
  }
  
  public final String Af(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = MtR.Af(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final void Ag(boolean paramBoolean)
  {
    AppMethodBeat.i(262052);
    MtR.Ag(paramBoolean);
    AppMethodBeat.o(262052);
  }
  
  public final boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = MtR.K(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(155521);
    MtR.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(262049);
    MtR.a(paramb);
    AppMethodBeat.o(262049);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    MtR.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = MtR.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = MtR.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final void aJ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261999);
    MtR.aJ(paramString1, paramString2, paramString3);
    AppMethodBeat.o(261999);
  }
  
  public final String aPk()
  {
    AppMethodBeat.i(155540);
    String str = MtR.aPk();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final String aQf(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = MtR.aQf(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void aQh(String paramString)
  {
    AppMethodBeat.i(155525);
    MtR.aQh(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void aQi(String paramString)
  {
    AppMethodBeat.i(155526);
    MtR.aQi(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void aQj(String paramString)
  {
    AppMethodBeat.i(155527);
    MtR.aQj(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean aQk(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = MtR.aQk(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] aQl(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = MtR.aQl(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void aQm(String paramString)
  {
    AppMethodBeat.i(155532);
    MtR.aQm(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean aQn(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = MtR.aQn(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] aQo(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = MtR.aQo(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final String aQp(String paramString)
  {
    AppMethodBeat.i(262013);
    paramString = MtR.aQp(paramString);
    AppMethodBeat.o(262013);
    return paramString;
  }
  
  public final String[] aQq(String paramString)
  {
    AppMethodBeat.i(262041);
    paramString = MtR.aQq(paramString);
    AppMethodBeat.o(262041);
    return paramString;
  }
  
  public final void aW(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    MtR.aW(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final byte[] aeP(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = MtR.aeP(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String aeQ(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = MtR.aeQ(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void aeR(int paramInt)
  {
    AppMethodBeat.i(155522);
    MtR.aeR(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] aeS(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = MtR.aeS(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final boolean d(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = MtR.d(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final boolean ge(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = MtR.ge(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final void gq(String paramString, int paramInt)
  {
    AppMethodBeat.i(262047);
    MtR.gq(paramString, paramInt);
    AppMethodBeat.o(262047);
  }
  
  public final String gtB()
  {
    AppMethodBeat.i(155515);
    String str = MtR.gtB();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean gtC()
  {
    AppMethodBeat.i(155516);
    boolean bool = MtR.gtC();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean gtD()
  {
    AppMethodBeat.i(155517);
    boolean bool = MtR.gtD();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] gtE()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = MtR.gtE();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] gtF()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = MtR.gtF();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean gtG()
  {
    AppMethodBeat.i(155538);
    boolean bool = MtR.gtG();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] gtH()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = MtR.gtH();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean gtI()
  {
    AppMethodBeat.i(262025);
    boolean bool = MtR.gtI();
    AppMethodBeat.o(262025);
    return bool;
  }
  
  public final String gtJ()
  {
    AppMethodBeat.i(262027);
    String str = MtR.gtJ();
    AppMethodBeat.o(262027);
    return str;
  }
  
  public final String gtK()
  {
    AppMethodBeat.i(262030);
    String str = MtR.gtK();
    AppMethodBeat.o(262030);
    return str;
  }
  
  public final String gtL()
  {
    AppMethodBeat.i(262033);
    String str = MtR.gtL();
    AppMethodBeat.o(262033);
    return str;
  }
  
  public final com.tencent.mm.normsg.a gtM()
  {
    AppMethodBeat.i(262035);
    com.tencent.mm.normsg.a locala = MtR.gtM();
    AppMethodBeat.o(262035);
    return locala;
  }
  
  public final com.tencent.mm.normsgext.a gtN()
  {
    AppMethodBeat.i(262038);
    com.tencent.mm.normsgext.a locala = MtR.gtN();
    AppMethodBeat.o(262038);
    return locala;
  }
  
  public final void gtO()
  {
    AppMethodBeat.i(262044);
    MtR.gtO();
    AppMethodBeat.o(262044);
  }
  
  public final void kI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    MtR.kI(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final void sR(long paramLong)
  {
    AppMethodBeat.i(262054);
    MtR.sR(paramLong);
    AppMethodBeat.o(262054);
  }
  
  public final void sS(long paramLong)
  {
    AppMethodBeat.i(262056);
    MtR.sS(paramLong);
    AppMethodBeat.o(262056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.d
 * JD-Core Version:    0.7.0.1
 */