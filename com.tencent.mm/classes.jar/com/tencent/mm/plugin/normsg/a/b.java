package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public enum b
  implements a
{
  private static a uft;
  
  static
  {
    AppMethodBeat.i(155541);
    ufs = new b("INSTANCE");
    ufu = new b[] { ufs };
    uft = new a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private b() {}
  
  public static void a(a parama)
  {
    if (parama != null) {
      uft = parama;
    }
  }
  
  public final byte[] Iw(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = uft.Iw(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String Ix(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = uft.Ix(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void Iy(int paramInt)
  {
    AppMethodBeat.i(155522);
    uft.Iy(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] Iz(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = uft.Iz(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(155521);
    uft.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    uft.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = uft.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = uft.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final String ajp(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = uft.ajp(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void ajr(String paramString)
  {
    AppMethodBeat.i(155525);
    uft.ajr(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void ajs(String paramString)
  {
    AppMethodBeat.i(155526);
    uft.ajs(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void ajt(String paramString)
  {
    AppMethodBeat.i(155527);
    uft.ajt(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean aju(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = uft.aju(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] ajv(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = uft.ajv(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void ajw(String paramString)
  {
    AppMethodBeat.i(155532);
    uft.ajw(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean ajx(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = uft.ajx(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] ajy(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = uft.ajy(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final void am(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    uft.am(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final String cWO()
  {
    AppMethodBeat.i(155515);
    String str = uft.cWO();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean cWP()
  {
    AppMethodBeat.i(155516);
    boolean bool = uft.cWP();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean cWQ()
  {
    AppMethodBeat.i(155517);
    boolean bool = uft.cWQ();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] cWU()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = uft.cWU();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] cWV()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = uft.cWV();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean cWW()
  {
    AppMethodBeat.i(155538);
    boolean bool = uft.cWW();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] cWX()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = uft.cWX();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean cWY()
  {
    AppMethodBeat.i(195145);
    boolean bool = uft.cWY();
    AppMethodBeat.o(195145);
    return bool;
  }
  
  public final boolean dt(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = uft.dt(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final boolean e(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = uft.e(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final String getOAID()
  {
    AppMethodBeat.i(155540);
    String str = uft.getOAID();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void hK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    uft.hK(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String nP(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = uft.nP(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final boolean z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = uft.z(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  static final class a
    implements a
  {
    public final byte[] Iw(int paramInt)
    {
      AppMethodBeat.i(155477);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155477);
      return new byte[0];
    }
    
    public final String Ix(int paramInt)
    {
      AppMethodBeat.i(155480);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155480);
      return "";
    }
    
    public final void Iy(int paramInt)
    {
      AppMethodBeat.i(155489);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155489);
    }
    
    public final byte[] Iz(int paramInt)
    {
      AppMethodBeat.i(155503);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155503);
      return new byte[0];
    }
    
    public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
    {
      AppMethodBeat.i(155488);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155488);
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(155498);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155498);
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155491);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155491);
      return false;
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155490);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155490);
      return false;
    }
    
    public final String ajp(String paramString)
    {
      AppMethodBeat.i(155479);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155479);
      return paramString;
    }
    
    public final void ajr(String paramString)
    {
      AppMethodBeat.i(155492);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155492);
    }
    
    public final void ajs(String paramString)
    {
      AppMethodBeat.i(155493);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155493);
    }
    
    public final void ajt(String paramString)
    {
      AppMethodBeat.i(155494);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155494);
    }
    
    public final boolean aju(String paramString)
    {
      AppMethodBeat.i(155495);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155495);
      return false;
    }
    
    public final byte[] ajv(String paramString)
    {
      AppMethodBeat.i(155496);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155496);
      return new byte[0];
    }
    
    public final void ajw(String paramString)
    {
      AppMethodBeat.i(155499);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155499);
    }
    
    public final boolean ajx(String paramString)
    {
      AppMethodBeat.i(155500);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155500);
      return false;
    }
    
    public final byte[] ajy(String paramString)
    {
      AppMethodBeat.i(155501);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155501);
      return new byte[0];
    }
    
    public final void am(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(155478);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155478);
    }
    
    public final String cWO()
    {
      AppMethodBeat.i(155482);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155482);
      return "";
    }
    
    public final boolean cWP()
    {
      AppMethodBeat.i(155483);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155483);
      return false;
    }
    
    public final boolean cWQ()
    {
      AppMethodBeat.i(155484);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155484);
      return false;
    }
    
    public final byte[] cWU()
    {
      AppMethodBeat.i(155486);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155486);
      return new byte[0];
    }
    
    public final byte[] cWV()
    {
      AppMethodBeat.i(155502);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155502);
      return new byte[0];
    }
    
    public final boolean cWW()
    {
      AppMethodBeat.i(155505);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155505);
      return false;
    }
    
    public final byte[] cWX()
    {
      AppMethodBeat.i(155506);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155506);
      return new byte[0];
    }
    
    public final boolean cWY()
    {
      AppMethodBeat.i(195144);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(195144);
      return false;
    }
    
    public final boolean dt(Object paramObject)
    {
      AppMethodBeat.i(155487);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155487);
      return false;
    }
    
    public final boolean e(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(155485);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155485);
      return false;
    }
    
    public final String getOAID()
    {
      AppMethodBeat.i(155507);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155507);
      return "";
    }
    
    public final void hK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155497);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155497);
    }
    
    public final String nP(boolean paramBoolean)
    {
      AppMethodBeat.i(155481);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155481);
      return "";
    }
    
    public final boolean z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(155504);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155504);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.b
 * JD-Core Version:    0.7.0.1
 */