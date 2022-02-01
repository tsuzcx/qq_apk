package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.q;
import com.tencent.mm.normsgext.d.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;

public enum b
  implements a
{
  private static final byte[] wJu;
  private static a wJv;
  
  static
  {
    AppMethodBeat.i(155541);
    wJt = new b("INSTANCE");
    wJw = new b[] { wJt };
    wJu = new byte[0];
    wJv = new a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private b() {}
  
  public static void a(a parama)
  {
    AppMethodBeat.i(188685);
    if (!(wJv instanceof a))
    {
      ae.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
      AppMethodBeat.o(188685);
      return;
    }
    synchronized (wJu)
    {
      if ((wJv instanceof a))
      {
        if (parama != null)
        {
          c.q.c0(parama.dym());
          d.n.c0(parama.dyn());
          parama.dWk();
          wJv = parama;
        }
        AppMethodBeat.o(188685);
        return;
      }
      ae.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
    }
  }
  
  public final boolean A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = wJv.A(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  public final byte[] MC(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = wJv.MC(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String MD(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = wJv.MD(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void ME(int paramInt)
  {
    AppMethodBeat.i(155522);
    wJv.ME(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] MF(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = wJv.MF(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(155521);
    wJv.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    wJv.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = wJv.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = wJv.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final String aaL()
  {
    AppMethodBeat.i(155540);
    String str = wJv.aaL();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    wJv.ao(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final String auA(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = wJv.auA(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void auC(String paramString)
  {
    AppMethodBeat.i(155525);
    wJv.auC(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void auD(String paramString)
  {
    AppMethodBeat.i(155526);
    wJv.auD(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void auE(String paramString)
  {
    AppMethodBeat.i(155527);
    wJv.auE(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean auF(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = wJv.auF(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] auG(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = wJv.auG(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void auH(String paramString)
  {
    AppMethodBeat.i(155532);
    wJv.auH(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean auI(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = wJv.auI(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] auJ(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = wJv.auJ(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final String[] auK(String paramString)
  {
    AppMethodBeat.i(188692);
    paramString = wJv.auK(paramString);
    AppMethodBeat.o(188692);
    return paramString;
  }
  
  public final void dWk()
  {
    AppMethodBeat.i(224067);
    wJv.dWk();
    AppMethodBeat.o(224067);
  }
  
  public final String dxY()
  {
    AppMethodBeat.i(155515);
    String str = wJv.dxY();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean dxZ()
  {
    AppMethodBeat.i(155516);
    boolean bool = wJv.dxZ();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean dy(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = wJv.dy(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final boolean dya()
  {
    AppMethodBeat.i(155517);
    boolean bool = wJv.dya();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] dye()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = wJv.dye();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] dyf()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = wJv.dyf();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean dyg()
  {
    AppMethodBeat.i(155538);
    boolean bool = wJv.dyg();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] dyh()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = wJv.dyh();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean dyi()
  {
    AppMethodBeat.i(188686);
    boolean bool = wJv.dyi();
    AppMethodBeat.o(188686);
    return bool;
  }
  
  public final String dyj()
  {
    AppMethodBeat.i(188687);
    String str = wJv.dyj();
    AppMethodBeat.o(188687);
    return str;
  }
  
  public final String dyk()
  {
    AppMethodBeat.i(188688);
    String str = wJv.dyk();
    AppMethodBeat.o(188688);
    return str;
  }
  
  public final String dyl()
  {
    AppMethodBeat.i(188689);
    String str = wJv.dyl();
    AppMethodBeat.o(188689);
    return str;
  }
  
  public final com.tencent.mm.normsg.a dym()
  {
    AppMethodBeat.i(188690);
    com.tencent.mm.normsg.a locala = wJv.dym();
    AppMethodBeat.o(188690);
    return locala;
  }
  
  public final com.tencent.mm.normsgext.a dyn()
  {
    AppMethodBeat.i(188691);
    com.tencent.mm.normsgext.a locala = wJv.dyn();
    AppMethodBeat.o(188691);
    return locala;
  }
  
  public final boolean e(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = wJv.e(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final void iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    wJv.iu(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String pq(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = wJv.pq(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  static final class a
    implements a
  {
    public final boolean A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(155504);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155504);
      return false;
    }
    
    public final byte[] MC(int paramInt)
    {
      AppMethodBeat.i(155477);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155477);
      return new byte[0];
    }
    
    public final String MD(int paramInt)
    {
      AppMethodBeat.i(155480);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155480);
      return "";
    }
    
    public final void ME(int paramInt)
    {
      AppMethodBeat.i(155489);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155489);
    }
    
    public final byte[] MF(int paramInt)
    {
      AppMethodBeat.i(155503);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155503);
      return new byte[0];
    }
    
    public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
    {
      AppMethodBeat.i(155488);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155488);
    }
    
    public final void a(String paramString, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(155498);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155498);
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155491);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155491);
      return false;
    }
    
    public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
    {
      AppMethodBeat.i(155490);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155490);
      return false;
    }
    
    public final String aaL()
    {
      AppMethodBeat.i(155507);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155507);
      return "";
    }
    
    public final void ao(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(155478);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155478);
    }
    
    public final String auA(String paramString)
    {
      AppMethodBeat.i(155479);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155479);
      return paramString;
    }
    
    public final void auC(String paramString)
    {
      AppMethodBeat.i(155492);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155492);
    }
    
    public final void auD(String paramString)
    {
      AppMethodBeat.i(155493);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155493);
    }
    
    public final void auE(String paramString)
    {
      AppMethodBeat.i(155494);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155494);
    }
    
    public final boolean auF(String paramString)
    {
      AppMethodBeat.i(155495);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155495);
      return false;
    }
    
    public final byte[] auG(String paramString)
    {
      AppMethodBeat.i(155496);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155496);
      return new byte[0];
    }
    
    public final void auH(String paramString)
    {
      AppMethodBeat.i(155499);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155499);
    }
    
    public final boolean auI(String paramString)
    {
      AppMethodBeat.i(155500);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155500);
      return false;
    }
    
    public final byte[] auJ(String paramString)
    {
      AppMethodBeat.i(155501);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155501);
      return new byte[0];
    }
    
    public final String[] auK(String paramString)
    {
      AppMethodBeat.i(188684);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188684);
      return new String[0];
    }
    
    public final void dWk()
    {
      AppMethodBeat.i(224066);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(224066);
    }
    
    public final String dxY()
    {
      AppMethodBeat.i(155482);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155482);
      return "";
    }
    
    public final boolean dxZ()
    {
      AppMethodBeat.i(155483);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155483);
      return false;
    }
    
    public final boolean dy(Object paramObject)
    {
      AppMethodBeat.i(155487);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155487);
      return false;
    }
    
    public final boolean dya()
    {
      AppMethodBeat.i(155484);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155484);
      return false;
    }
    
    public final byte[] dye()
    {
      AppMethodBeat.i(155486);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155486);
      return new byte[0];
    }
    
    public final byte[] dyf()
    {
      AppMethodBeat.i(155502);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155502);
      return new byte[0];
    }
    
    public final boolean dyg()
    {
      AppMethodBeat.i(155505);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155505);
      return false;
    }
    
    public final byte[] dyh()
    {
      AppMethodBeat.i(155506);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155506);
      return new byte[0];
    }
    
    public final boolean dyi()
    {
      AppMethodBeat.i(188678);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188678);
      return false;
    }
    
    public final String dyj()
    {
      AppMethodBeat.i(188679);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188679);
      return "";
    }
    
    public final String dyk()
    {
      AppMethodBeat.i(188680);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188680);
      return "";
    }
    
    public final String dyl()
    {
      AppMethodBeat.i(188681);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188681);
      return "";
    }
    
    public final com.tencent.mm.normsg.a dym()
    {
      AppMethodBeat.i(188682);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188682);
      return null;
    }
    
    public final com.tencent.mm.normsgext.a dyn()
    {
      AppMethodBeat.i(188683);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(188683);
      return null;
    }
    
    public final boolean e(Object paramObject, Class paramClass)
    {
      AppMethodBeat.i(155485);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155485);
      return false;
    }
    
    public final void iu(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155497);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155497);
    }
    
    public final String pq(boolean paramBoolean)
    {
      AppMethodBeat.i(155481);
      ae.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155481);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.a.b
 * JD-Core Version:    0.7.0.1
 */