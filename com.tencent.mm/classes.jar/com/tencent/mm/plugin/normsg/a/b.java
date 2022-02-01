package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;

public enum b
  implements a
{
  private static a vos;
  
  static
  {
    AppMethodBeat.i(155541);
    vor = new b("INSTANCE");
    vot = new b[] { vor };
    vos = new a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private b() {}
  
  public static void a(a parama)
  {
    if (parama != null) {
      vos = parama;
    }
  }
  
  public final byte[] Kv(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = vos.Kv(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String Kw(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = vos.Kw(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void Kx(int paramInt)
  {
    AppMethodBeat.i(155522);
    vos.Kx(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] Ky(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = vos.Ky(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(155521);
    vos.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    vos.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = vos.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = vos.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    vos.ao(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final String aon(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = vos.aon(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void aop(String paramString)
  {
    AppMethodBeat.i(155525);
    vos.aop(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void aoq(String paramString)
  {
    AppMethodBeat.i(155526);
    vos.aoq(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void aor(String paramString)
  {
    AppMethodBeat.i(155527);
    vos.aor(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean aos(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = vos.aos(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] aot(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = vos.aot(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void aou(String paramString)
  {
    AppMethodBeat.i(155532);
    vos.aou(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean aov(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = vos.aov(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] aow(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = vos.aow(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final byte[] dkC()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = vos.dkC();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] dkD()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = vos.dkD();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean dkE()
  {
    AppMethodBeat.i(155538);
    boolean bool = vos.dkE();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] dkF()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = vos.dkF();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean dkG()
  {
    AppMethodBeat.i(189659);
    boolean bool = vos.dkG();
    AppMethodBeat.o(189659);
    return bool;
  }
  
  public final String dkw()
  {
    AppMethodBeat.i(155515);
    String str = vos.dkw();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean dkx()
  {
    AppMethodBeat.i(155516);
    boolean bool = vos.dkx();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean dky()
  {
    AppMethodBeat.i(155517);
    boolean bool = vos.dky();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final boolean du(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = vos.du(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final boolean e(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = vos.e(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final String getOAID()
  {
    AppMethodBeat.i(155540);
    String str = vos.getOAID();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    vos.id(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = vos.oJ(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final boolean y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = vos.y(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  static final class a
    implements a
  {
    public final byte[] Kv(int paramInt)
    {
      AppMethodBeat.i(155477);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155477);
      return new byte[0];
    }
    
    public final String Kw(int paramInt)
    {
      AppMethodBeat.i(155480);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155480);
      return "";
    }
    
    public final void Kx(int paramInt)
    {
      AppMethodBeat.i(155489);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155489);
    }
    
    public final byte[] Ky(int paramInt)
    {
      AppMethodBeat.i(155503);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155503);
      return new byte[0];
    }
    
    public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
    {
      AppMethodBeat.i(155488);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155488);
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(155498);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155498);
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155491);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155491);
      return false;
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155490);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155490);
      return false;
    }
    
    public final void ao(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(155478);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155478);
    }
    
    public final String aon(String paramString)
    {
      AppMethodBeat.i(155479);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155479);
      return paramString;
    }
    
    public final void aop(String paramString)
    {
      AppMethodBeat.i(155492);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155492);
    }
    
    public final void aoq(String paramString)
    {
      AppMethodBeat.i(155493);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155493);
    }
    
    public final void aor(String paramString)
    {
      AppMethodBeat.i(155494);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155494);
    }
    
    public final boolean aos(String paramString)
    {
      AppMethodBeat.i(155495);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155495);
      return false;
    }
    
    public final byte[] aot(String paramString)
    {
      AppMethodBeat.i(155496);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155496);
      return new byte[0];
    }
    
    public final void aou(String paramString)
    {
      AppMethodBeat.i(155499);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155499);
    }
    
    public final boolean aov(String paramString)
    {
      AppMethodBeat.i(155500);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155500);
      return false;
    }
    
    public final byte[] aow(String paramString)
    {
      AppMethodBeat.i(155501);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155501);
      return new byte[0];
    }
    
    public final byte[] dkC()
    {
      AppMethodBeat.i(155486);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155486);
      return new byte[0];
    }
    
    public final byte[] dkD()
    {
      AppMethodBeat.i(155502);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155502);
      return new byte[0];
    }
    
    public final boolean dkE()
    {
      AppMethodBeat.i(155505);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155505);
      return false;
    }
    
    public final byte[] dkF()
    {
      AppMethodBeat.i(155506);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155506);
      return new byte[0];
    }
    
    public final boolean dkG()
    {
      AppMethodBeat.i(189658);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(189658);
      return false;
    }
    
    public final String dkw()
    {
      AppMethodBeat.i(155482);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155482);
      return "";
    }
    
    public final boolean dkx()
    {
      AppMethodBeat.i(155483);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155483);
      return false;
    }
    
    public final boolean dky()
    {
      AppMethodBeat.i(155484);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155484);
      return false;
    }
    
    public final boolean du(Object paramObject)
    {
      AppMethodBeat.i(155487);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155487);
      return false;
    }
    
    public final boolean e(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(155485);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155485);
      return false;
    }
    
    public final String getOAID()
    {
      AppMethodBeat.i(155507);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155507);
      return "";
    }
    
    public final void id(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155497);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155497);
    }
    
    public final String oJ(boolean paramBoolean)
    {
      AppMethodBeat.i(155481);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155481);
      return "";
    }
    
    public final boolean y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(155504);
      ac.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155504);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.b
 * JD-Core Version:    0.7.0.1
 */