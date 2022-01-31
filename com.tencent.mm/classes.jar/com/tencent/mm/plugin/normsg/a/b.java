package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;

public enum b
  implements a
{
  private static a pgR;
  
  static
  {
    AppMethodBeat.i(115605);
    pgQ = new b("INSTANCE");
    pgS = new b[] { pgQ };
    pgR = new a((byte)0);
    AppMethodBeat.o(115605);
  }
  
  private b() {}
  
  public static void a(a parama)
  {
    if (parama != null) {
      pgR = parama;
    }
  }
  
  public final byte[] AO(int paramInt)
  {
    AppMethodBeat.i(115578);
    byte[] arrayOfByte = pgR.AO(paramInt);
    AppMethodBeat.o(115578);
    return arrayOfByte;
  }
  
  public final String AP(int paramInt)
  {
    AppMethodBeat.i(115581);
    String str = pgR.AP(paramInt);
    AppMethodBeat.o(115581);
    return str;
  }
  
  public final void AQ(int paramInt)
  {
    AppMethodBeat.i(115593);
    pgR.AQ(paramInt);
    AppMethodBeat.o(115593);
  }
  
  public final void VV(String paramString)
  {
    AppMethodBeat.i(115595);
    pgR.VV(paramString);
    AppMethodBeat.o(115595);
  }
  
  public final void VW(String paramString)
  {
    AppMethodBeat.i(115596);
    pgR.VW(paramString);
    AppMethodBeat.o(115596);
  }
  
  public final void VX(String paramString)
  {
    AppMethodBeat.i(115597);
    pgR.VX(paramString);
    AppMethodBeat.o(115597);
  }
  
  public final boolean VY(String paramString)
  {
    AppMethodBeat.i(115598);
    boolean bool = pgR.VY(paramString);
    AppMethodBeat.o(115598);
    return bool;
  }
  
  public final byte[] VZ(String paramString)
  {
    AppMethodBeat.i(115599);
    paramString = pgR.VZ(paramString);
    AppMethodBeat.o(115599);
    return paramString;
  }
  
  public final void Wa(String paramString)
  {
    AppMethodBeat.i(115602);
    pgR.Wa(paramString);
    AppMethodBeat.o(115602);
  }
  
  public final boolean Wb(String paramString)
  {
    AppMethodBeat.i(115603);
    boolean bool = pgR.Wb(paramString);
    AppMethodBeat.o(115603);
    return bool;
  }
  
  public final byte[] Wc(String paramString)
  {
    AppMethodBeat.i(115604);
    paramString = pgR.Wc(paramString);
    AppMethodBeat.o(115604);
    return paramString;
  }
  
  public final String Wd(String paramString)
  {
    AppMethodBeat.i(115580);
    paramString = pgR.Wd(paramString);
    AppMethodBeat.o(115580);
    return paramString;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(115592);
    pgR.a(paramView, paramClass);
    AppMethodBeat.o(115592);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(115601);
    pgR.a(paramString, paramMotionEvent);
    AppMethodBeat.o(115601);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(115594);
    boolean bool = pgR.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(115594);
    return bool;
  }
  
  public final void ad(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115579);
    pgR.ad(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(115579);
  }
  
  public final boolean bXh()
  {
    AppMethodBeat.i(115584);
    boolean bool = pgR.bXh();
    AppMethodBeat.o(115584);
    return bool;
  }
  
  public final boolean bXk()
  {
    AppMethodBeat.i(115586);
    boolean bool = pgR.bXk();
    AppMethodBeat.o(115586);
    return bool;
  }
  
  public final boolean bXl()
  {
    AppMethodBeat.i(115587);
    boolean bool = pgR.bXl();
    AppMethodBeat.o(115587);
    return bool;
  }
  
  public final boolean bXm()
  {
    AppMethodBeat.i(115588);
    boolean bool = pgR.bXm();
    AppMethodBeat.o(115588);
    return bool;
  }
  
  public final String bXo()
  {
    AppMethodBeat.i(115583);
    String str = pgR.bXo();
    AppMethodBeat.o(115583);
    return str;
  }
  
  public final boolean bXp()
  {
    AppMethodBeat.i(115585);
    boolean bool = pgR.bXp();
    AppMethodBeat.o(115585);
    return bool;
  }
  
  public final byte[] bXq()
  {
    AppMethodBeat.i(115590);
    byte[] arrayOfByte = pgR.bXq();
    AppMethodBeat.o(115590);
    return arrayOfByte;
  }
  
  public final boolean bY(Object paramObject)
  {
    AppMethodBeat.i(115591);
    boolean bool = pgR.bY(paramObject);
    AppMethodBeat.o(115591);
    return bool;
  }
  
  public final boolean d(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(115589);
    boolean bool = pgR.d(paramObject, paramClass);
    AppMethodBeat.o(115589);
    return bool;
  }
  
  public final void fD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115600);
    pgR.fD(paramString1, paramString2);
    AppMethodBeat.o(115600);
  }
  
  public final String jU(boolean paramBoolean)
  {
    AppMethodBeat.i(115582);
    String str = pgR.jU(paramBoolean);
    AppMethodBeat.o(115582);
    return str;
  }
  
  static final class a
    implements a
  {
    public final byte[] AO(int paramInt)
    {
      AppMethodBeat.i(115549);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115549);
      return new byte[0];
    }
    
    public final String AP(int paramInt)
    {
      AppMethodBeat.i(115552);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115552);
      return "";
    }
    
    public final void AQ(int paramInt)
    {
      AppMethodBeat.i(115564);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115564);
    }
    
    public final void VV(String paramString)
    {
      AppMethodBeat.i(115566);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115566);
    }
    
    public final void VW(String paramString)
    {
      AppMethodBeat.i(115567);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115567);
    }
    
    public final void VX(String paramString)
    {
      AppMethodBeat.i(115568);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115568);
    }
    
    public final boolean VY(String paramString)
    {
      AppMethodBeat.i(115569);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115569);
      return false;
    }
    
    public final byte[] VZ(String paramString)
    {
      AppMethodBeat.i(115570);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115570);
      return new byte[0];
    }
    
    public final void Wa(String paramString)
    {
      AppMethodBeat.i(115573);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115573);
    }
    
    public final boolean Wb(String paramString)
    {
      AppMethodBeat.i(115574);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115574);
      return false;
    }
    
    public final byte[] Wc(String paramString)
    {
      AppMethodBeat.i(115575);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115575);
      return new byte[0];
    }
    
    public final String Wd(String paramString)
    {
      AppMethodBeat.i(115551);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115551);
      return paramString;
    }
    
    public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
    {
      AppMethodBeat.i(115563);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115563);
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(115572);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115572);
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(115565);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115565);
      return false;
    }
    
    public final void ad(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(115550);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115550);
    }
    
    public final boolean bXh()
    {
      AppMethodBeat.i(115555);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115555);
      return false;
    }
    
    public final boolean bXk()
    {
      AppMethodBeat.i(115557);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115557);
      return false;
    }
    
    public final boolean bXl()
    {
      AppMethodBeat.i(115558);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115558);
      return false;
    }
    
    public final boolean bXm()
    {
      AppMethodBeat.i(115559);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115559);
      return false;
    }
    
    public final String bXo()
    {
      AppMethodBeat.i(115554);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115554);
      return "";
    }
    
    public final boolean bXp()
    {
      AppMethodBeat.i(115556);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115556);
      return false;
    }
    
    public final byte[] bXq()
    {
      AppMethodBeat.i(115561);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115561);
      return new byte[0];
    }
    
    public final boolean bY(Object paramObject)
    {
      AppMethodBeat.i(115562);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115562);
      return false;
    }
    
    public final boolean d(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(115560);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115560);
      return false;
    }
    
    public final void fD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(115571);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115571);
    }
    
    public final String jU(boolean paramBoolean)
    {
      AppMethodBeat.i(115553);
      ab.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(115553);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.b
 * JD-Core Version:    0.7.0.1
 */