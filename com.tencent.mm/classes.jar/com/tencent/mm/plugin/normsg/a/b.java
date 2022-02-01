package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.normsg.c.q;
import com.tencent.mm.normsgext.d.n;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;

public enum b
  implements a
{
  private static final byte[] wtK;
  private static a wtL;
  
  static
  {
    AppMethodBeat.i(155541);
    wtJ = new b("INSTANCE");
    wtM = new b[] { wtJ };
    wtK = new byte[0];
    wtL = new a((byte)0);
    AppMethodBeat.o(155541);
  }
  
  private b() {}
  
  public static void a(a parama)
  {
    AppMethodBeat.i(186417);
    if (!(wtL instanceof a))
    {
      ad.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
      AppMethodBeat.o(186417);
      return;
    }
    synchronized (wtK)
    {
      if ((wtL instanceof a))
      {
        if (parama != null)
        {
          c.q.c0(parama.duW());
          d.n.c0(parama.duX());
          wtL = parama;
        }
        AppMethodBeat.o(186417);
        return;
      }
      ad.w("MicroMsg.NormsgSource", "[!] Impl was already injected.");
    }
  }
  
  public final byte[] LX(int paramInt)
  {
    AppMethodBeat.i(155510);
    byte[] arrayOfByte = wtL.LX(paramInt);
    AppMethodBeat.o(155510);
    return arrayOfByte;
  }
  
  public final String LY(int paramInt)
  {
    AppMethodBeat.i(155513);
    String str = wtL.LY(paramInt);
    AppMethodBeat.o(155513);
    return str;
  }
  
  public final void LZ(int paramInt)
  {
    AppMethodBeat.i(155522);
    wtL.LZ(paramInt);
    AppMethodBeat.o(155522);
  }
  
  public final byte[] Ma(int paramInt)
  {
    AppMethodBeat.i(155536);
    byte[] arrayOfByte = wtL.Ma(paramInt);
    AppMethodBeat.o(155536);
    return arrayOfByte;
  }
  
  public final void a(View paramView, Class<? extends com.tencent.mm.sdk.b.b> paramClass)
  {
    AppMethodBeat.i(155521);
    wtL.a(paramView, paramClass);
    AppMethodBeat.o(155521);
  }
  
  public final void a(String paramString, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155531);
    wtL.a(paramString, paramMotionEvent);
    AppMethodBeat.o(155531);
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155524);
    boolean bool = wtL.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPByteArray);
    AppMethodBeat.o(155524);
    return bool;
  }
  
  public final boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, PByteArray paramPByteArray)
  {
    AppMethodBeat.i(155523);
    boolean bool = wtL.a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPByteArray);
    AppMethodBeat.o(155523);
    return bool;
  }
  
  public final String aaC()
  {
    AppMethodBeat.i(155540);
    String str = wtL.aaC();
    AppMethodBeat.o(155540);
    return str;
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(155511);
    wtL.ao(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(155511);
  }
  
  public final String atn(String paramString)
  {
    AppMethodBeat.i(155512);
    paramString = wtL.atn(paramString);
    AppMethodBeat.o(155512);
    return paramString;
  }
  
  public final void atp(String paramString)
  {
    AppMethodBeat.i(155525);
    wtL.atp(paramString);
    AppMethodBeat.o(155525);
  }
  
  public final void atq(String paramString)
  {
    AppMethodBeat.i(155526);
    wtL.atq(paramString);
    AppMethodBeat.o(155526);
  }
  
  public final void atr(String paramString)
  {
    AppMethodBeat.i(155527);
    wtL.atr(paramString);
    AppMethodBeat.o(155527);
  }
  
  public final boolean ats(String paramString)
  {
    AppMethodBeat.i(155528);
    boolean bool = wtL.ats(paramString);
    AppMethodBeat.o(155528);
    return bool;
  }
  
  public final byte[] att(String paramString)
  {
    AppMethodBeat.i(155529);
    paramString = wtL.att(paramString);
    AppMethodBeat.o(155529);
    return paramString;
  }
  
  public final void atu(String paramString)
  {
    AppMethodBeat.i(155532);
    wtL.atu(paramString);
    AppMethodBeat.o(155532);
  }
  
  public final boolean atv(String paramString)
  {
    AppMethodBeat.i(155533);
    boolean bool = wtL.atv(paramString);
    AppMethodBeat.o(155533);
    return bool;
  }
  
  public final byte[] atw(String paramString)
  {
    AppMethodBeat.i(155534);
    paramString = wtL.atw(paramString);
    AppMethodBeat.o(155534);
    return paramString;
  }
  
  public final String duI()
  {
    AppMethodBeat.i(155515);
    String str = wtL.duI();
    AppMethodBeat.o(155515);
    return str;
  }
  
  public final boolean duJ()
  {
    AppMethodBeat.i(155516);
    boolean bool = wtL.duJ();
    AppMethodBeat.o(155516);
    return bool;
  }
  
  public final boolean duK()
  {
    AppMethodBeat.i(155517);
    boolean bool = wtL.duK();
    AppMethodBeat.o(155517);
    return bool;
  }
  
  public final byte[] duO()
  {
    AppMethodBeat.i(155519);
    byte[] arrayOfByte = wtL.duO();
    AppMethodBeat.o(155519);
    return arrayOfByte;
  }
  
  public final byte[] duP()
  {
    AppMethodBeat.i(155535);
    byte[] arrayOfByte = wtL.duP();
    AppMethodBeat.o(155535);
    return arrayOfByte;
  }
  
  public final boolean duQ()
  {
    AppMethodBeat.i(155538);
    boolean bool = wtL.duQ();
    AppMethodBeat.o(155538);
    return bool;
  }
  
  public final byte[] duR()
  {
    AppMethodBeat.i(155539);
    byte[] arrayOfByte = wtL.duR();
    AppMethodBeat.o(155539);
    return arrayOfByte;
  }
  
  public final boolean duS()
  {
    AppMethodBeat.i(186418);
    boolean bool = wtL.duS();
    AppMethodBeat.o(186418);
    return bool;
  }
  
  public final String duT()
  {
    AppMethodBeat.i(186419);
    String str = wtL.duT();
    AppMethodBeat.o(186419);
    return str;
  }
  
  public final String duU()
  {
    AppMethodBeat.i(186420);
    String str = wtL.duU();
    AppMethodBeat.o(186420);
    return str;
  }
  
  public final String duV()
  {
    AppMethodBeat.i(186421);
    String str = wtL.duV();
    AppMethodBeat.o(186421);
    return str;
  }
  
  public final com.tencent.mm.normsg.a duW()
  {
    AppMethodBeat.i(186422);
    com.tencent.mm.normsg.a locala = wtL.duW();
    AppMethodBeat.o(186422);
    return locala;
  }
  
  public final com.tencent.mm.normsgext.a duX()
  {
    AppMethodBeat.i(186423);
    com.tencent.mm.normsgext.a locala = wtL.duX();
    AppMethodBeat.o(186423);
    return locala;
  }
  
  public final boolean dx(Object paramObject)
  {
    AppMethodBeat.i(155520);
    boolean bool = wtL.dx(paramObject);
    AppMethodBeat.o(155520);
    return bool;
  }
  
  public final boolean e(Object paramObject, Class paramClass)
  {
    AppMethodBeat.i(155518);
    boolean bool = wtL.e(paramObject, paramClass);
    AppMethodBeat.o(155518);
    return bool;
  }
  
  public final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155530);
    wtL.io(paramString1, paramString2);
    AppMethodBeat.o(155530);
  }
  
  public final String pi(boolean paramBoolean)
  {
    AppMethodBeat.i(155514);
    String str = wtL.pi(paramBoolean);
    AppMethodBeat.o(155514);
    return str;
  }
  
  public final boolean z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155537);
    boolean bool = wtL.z(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(155537);
    return bool;
  }
  
  static final class a
    implements a
  {
    public final byte[] LX(int paramInt)
    {
      AppMethodBeat.i(155477);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155477);
      return new byte[0];
    }
    
    public final String LY(int paramInt)
    {
      AppMethodBeat.i(155480);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155480);
      return "";
    }
    
    public final void LZ(int paramInt)
    {
      AppMethodBeat.i(155489);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155489);
    }
    
    public final byte[] Ma(int paramInt)
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
    
    public final String aaC()
    {
      AppMethodBeat.i(155507);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155507);
      return "";
    }
    
    public final void ao(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(155478);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155478);
    }
    
    public final String atn(String paramString)
    {
      AppMethodBeat.i(155479);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155479);
      return paramString;
    }
    
    public final void atp(String paramString)
    {
      AppMethodBeat.i(155492);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155492);
    }
    
    public final void atq(String paramString)
    {
      AppMethodBeat.i(155493);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155493);
    }
    
    public final void atr(String paramString)
    {
      AppMethodBeat.i(155494);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155494);
    }
    
    public final boolean ats(String paramString)
    {
      AppMethodBeat.i(155495);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155495);
      return false;
    }
    
    public final byte[] att(String paramString)
    {
      AppMethodBeat.i(155496);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155496);
      return new byte[0];
    }
    
    public final void atu(String paramString)
    {
      AppMethodBeat.i(155499);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155499);
    }
    
    public final boolean atv(String paramString)
    {
      AppMethodBeat.i(155500);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155500);
      return false;
    }
    
    public final byte[] atw(String paramString)
    {
      AppMethodBeat.i(155501);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155501);
      return new byte[0];
    }
    
    public final String duI()
    {
      AppMethodBeat.i(155482);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155482);
      return "";
    }
    
    public final boolean duJ()
    {
      AppMethodBeat.i(155483);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155483);
      return false;
    }
    
    public final boolean duK()
    {
      AppMethodBeat.i(155484);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155484);
      return false;
    }
    
    public final byte[] duO()
    {
      AppMethodBeat.i(155486);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155486);
      return new byte[0];
    }
    
    public final byte[] duP()
    {
      AppMethodBeat.i(155502);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155502);
      return new byte[0];
    }
    
    public final boolean duQ()
    {
      AppMethodBeat.i(155505);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155505);
      return false;
    }
    
    public final byte[] duR()
    {
      AppMethodBeat.i(155506);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155506);
      return new byte[0];
    }
    
    public final boolean duS()
    {
      AppMethodBeat.i(186411);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186411);
      return false;
    }
    
    public final String duT()
    {
      AppMethodBeat.i(186412);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186412);
      return "";
    }
    
    public final String duU()
    {
      AppMethodBeat.i(186413);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186413);
      return "";
    }
    
    public final String duV()
    {
      AppMethodBeat.i(186414);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186414);
      return "";
    }
    
    public final com.tencent.mm.normsg.a duW()
    {
      AppMethodBeat.i(186415);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186415);
      return null;
    }
    
    public final com.tencent.mm.normsgext.a duX()
    {
      AppMethodBeat.i(186416);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(186416);
      return null;
    }
    
    public final boolean dx(Object paramObject)
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
    
    public final void io(String paramString1, String paramString2)
    {
      AppMethodBeat.i(155497);
      ad.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
      AppMethodBeat.o(155497);
    }
    
    public final String pi(boolean paramBoolean)
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