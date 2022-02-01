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
  private static final byte[] AEG;
  private static a AEH;
  
  static
  {
    AppMethodBeat.i(155541);
    AEF = new d("INSTANCE");
    AEI = new d[] { AEF };
    AEG = new byte[0];
    AEH = new a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private d() {}
  
  public static void a(a parama)
  {
    AppMethodBeat.i(192300);
    if (!(AEH instanceof a))
    {
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
      AppMethodBeat.o(192300);
      return;
    }
    synchronized (AEG)
    {
      if ((AEH instanceof a))
      {
        if (parama != null)
        {
          c.q.c0(parama.exR());
          d.n.c0(parama.exS());
          parama.exT();
          AEH = parama;
        }
        AppMethodBeat.o(192300);
        return;
      }
      Log.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
    }
  }
  
  public final boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = AEH.K(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  public final byte[] TJ(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = AEH.TJ(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String TK(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = AEH.TK(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void TL(int paramInt)
  {
    AppMethodBeat.i(155522);
    AEH.TL(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] TM(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = AEH.TM(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends IEvent> paramClass)
  {
    AppMethodBeat.i(155521);
    AEH.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(192312);
    AEH.a(paramb);
    AppMethodBeat.o(192312);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    AEH.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = AEH.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = AEH.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final void aA(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(192301);
    AEH.aA(paramString1, paramString2, paramString3);
    AppMethodBeat.o(192301);
  }
  
  public final String aIJ(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = AEH.aIJ(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void aIL(String paramString)
  {
    AppMethodBeat.i(155525);
    AEH.aIL(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void aIM(String paramString)
  {
    AppMethodBeat.i(155526);
    AEH.aIM(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void aIN(String paramString)
  {
    AppMethodBeat.i(155527);
    AEH.aIN(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean aIO(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = AEH.aIO(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] aIP(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = AEH.aIP(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void aIQ(String paramString)
  {
    AppMethodBeat.i(155532);
    AEH.aIQ(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean aIR(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = AEH.aIR(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] aIS(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = AEH.aIS(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final String aIT(String paramString)
  {
    AppMethodBeat.i(192302);
    paramString = AEH.aIT(paramString);
    AppMethodBeat.o(192302);
    return paramString;
  }
  
  public final String[] aIU(String paramString)
  {
    AppMethodBeat.i(192309);
    paramString = AEH.aIU(paramString);
    AppMethodBeat.o(192309);
    return paramString;
  }
  
  public final String aoK()
  {
    AppMethodBeat.i(155540);
    String str = AEH.aoK();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void au(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    AEH.au(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final boolean c(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = AEH.c(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final boolean dH(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = AEH.dH(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final void eW(String paramString, int paramInt)
  {
    AppMethodBeat.i(192311);
    AEH.eW(paramString, paramInt);
    AppMethodBeat.o(192311);
  }
  
  public final String exG()
  {
    AppMethodBeat.i(155515);
    String str = AEH.exG();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean exH()
  {
    AppMethodBeat.i(155516);
    boolean bool = AEH.exH();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean exI()
  {
    AppMethodBeat.i(155517);
    boolean bool = AEH.exI();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] exJ()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = AEH.exJ();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] exK()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = AEH.exK();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean exL()
  {
    AppMethodBeat.i(155538);
    boolean bool = AEH.exL();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] exM()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = AEH.exM();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean exN()
  {
    AppMethodBeat.i(192303);
    boolean bool = AEH.exN();
    AppMethodBeat.o(192303);
    return bool;
  }
  
  public final String exO()
  {
    AppMethodBeat.i(192304);
    String str = AEH.exO();
    AppMethodBeat.o(192304);
    return str;
  }
  
  public final String exP()
  {
    AppMethodBeat.i(192305);
    String str = AEH.exP();
    AppMethodBeat.o(192305);
    return str;
  }
  
  public final String exQ()
  {
    AppMethodBeat.i(192306);
    String str = AEH.exQ();
    AppMethodBeat.o(192306);
    return str;
  }
  
  public final com.tencent.mm.normsg.a exR()
  {
    AppMethodBeat.i(192307);
    com.tencent.mm.normsg.a locala = AEH.exR();
    AppMethodBeat.o(192307);
    return locala;
  }
  
  public final com.tencent.mm.normsgext.a exS()
  {
    AppMethodBeat.i(192308);
    com.tencent.mm.normsgext.a locala = AEH.exS();
    AppMethodBeat.o(192308);
    return locala;
  }
  
  public final void exT()
  {
    AppMethodBeat.i(192310);
    AEH.exT();
    AppMethodBeat.o(192310);
  }
  
  public final void jf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    AEH.jf(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String sv(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = AEH.sv(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final void sw(boolean paramBoolean)
  {
    AppMethodBeat.i(192313);
    AEH.sw(paramBoolean);
    AppMethodBeat.o(192313);
  }
  
  static final class a
    implements a
  {
    public final boolean K(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(155504);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155504);
      return false;
    }
    
    public final byte[] TJ(int paramInt)
    {
      AppMethodBeat.i(155477);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155477);
      return new byte[0];
    }
    
    public final String TK(int paramInt)
    {
      AppMethodBeat.i(155480);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155480);
      return "";
    }
    
    public final void TL(int paramInt)
    {
      AppMethodBeat.i(155489);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155489);
    }
    
    public final byte[] TM(int paramInt)
    {
      AppMethodBeat.i(155503);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155503);
      return new byte[0];
    }
    
    public final void a(View paramView, Class<? extends IEvent> paramClass)
    {
      AppMethodBeat.i(155488);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155488);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(192298);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192298);
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(155498);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155498);
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155491);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155491);
      return false;
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155490);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155490);
      return false;
    }
    
    public final void aA(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(192287);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192287);
    }
    
    public final String aIJ(String paramString)
    {
      AppMethodBeat.i(155479);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155479);
      return paramString;
    }
    
    public final void aIL(String paramString)
    {
      AppMethodBeat.i(155492);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155492);
    }
    
    public final void aIM(String paramString)
    {
      AppMethodBeat.i(155493);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155493);
    }
    
    public final void aIN(String paramString)
    {
      AppMethodBeat.i(155494);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155494);
    }
    
    public final boolean aIO(String paramString)
    {
      AppMethodBeat.i(155495);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155495);
      return false;
    }
    
    public final byte[] aIP(String paramString)
    {
      AppMethodBeat.i(155496);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155496);
      return new byte[0];
    }
    
    public final void aIQ(String paramString)
    {
      AppMethodBeat.i(155499);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155499);
    }
    
    public final boolean aIR(String paramString)
    {
      AppMethodBeat.i(155500);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155500);
      return false;
    }
    
    public final byte[] aIS(String paramString)
    {
      AppMethodBeat.i(155501);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155501);
      return new byte[0];
    }
    
    public final String aIT(String paramString)
    {
      AppMethodBeat.i(192288);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192288);
      return "";
    }
    
    public final String[] aIU(String paramString)
    {
      AppMethodBeat.i(192295);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192295);
      return new String[0];
    }
    
    public final String aoK()
    {
      AppMethodBeat.i(155507);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155507);
      return "";
    }
    
    public final void au(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(155478);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155478);
    }
    
    public final boolean c(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(155485);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155485);
      return false;
    }
    
    public final boolean dH(Object paramObject)
    {
      AppMethodBeat.i(155487);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155487);
      return false;
    }
    
    public final void eW(String paramString, int paramInt)
    {
      AppMethodBeat.i(192297);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192297);
    }
    
    public final String exG()
    {
      AppMethodBeat.i(155482);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155482);
      return "";
    }
    
    public final boolean exH()
    {
      AppMethodBeat.i(155483);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155483);
      return false;
    }
    
    public final boolean exI()
    {
      AppMethodBeat.i(155484);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155484);
      return false;
    }
    
    public final byte[] exJ()
    {
      AppMethodBeat.i(155486);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155486);
      return new byte[0];
    }
    
    public final byte[] exK()
    {
      AppMethodBeat.i(155502);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155502);
      return new byte[0];
    }
    
    public final boolean exL()
    {
      AppMethodBeat.i(155505);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155505);
      return false;
    }
    
    public final byte[] exM()
    {
      AppMethodBeat.i(155506);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155506);
      return new byte[0];
    }
    
    public final boolean exN()
    {
      AppMethodBeat.i(192289);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192289);
      return false;
    }
    
    public final String exO()
    {
      AppMethodBeat.i(192290);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192290);
      return "";
    }
    
    public final String exP()
    {
      AppMethodBeat.i(192291);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192291);
      return "";
    }
    
    public final String exQ()
    {
      AppMethodBeat.i(192292);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192292);
      return "";
    }
    
    public final com.tencent.mm.normsg.a exR()
    {
      AppMethodBeat.i(192293);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192293);
      return null;
    }
    
    public final com.tencent.mm.normsgext.a exS()
    {
      AppMethodBeat.i(192294);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192294);
      return null;
    }
    
    public final void exT()
    {
      AppMethodBeat.i(192296);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192296);
    }
    
    public final void jf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155497);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155497);
    }
    
    public final String sv(boolean paramBoolean)
    {
      AppMethodBeat.i(155481);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155481);
      return "";
    }
    
    public final void sw(boolean paramBoolean)
    {
      AppMethodBeat.i(192299);
      Log.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(192299);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.d
 * JD-Core Version:    0.7.0.1
 */