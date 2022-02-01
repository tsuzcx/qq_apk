package io.flutter.embedding.engine.c;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.f;
import java.util.Map;

public final class b
{
  public final io.flutter.plugin.a.b<Object> NaX;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10233);
    this.NaX = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/keyevent", f.NcZ);
    AppMethodBeat.o(10233);
  }
  
  public static void a(a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(parama.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(parama.Nbc));
    paramMap.put("codePoint", Integer.valueOf(parama.Nbd));
    paramMap.put("keyCode", Integer.valueOf(parama.jDN));
    paramMap.put("scanCode", Integer.valueOf(parama.Nbf));
    paramMap.put("metaState", Integer.valueOf(parama.Nbg));
    if (parama.Nbe != null) {
      paramMap.put("character", parama.Nbe.toString());
    }
    paramMap.put("source", Integer.valueOf(parama.doj));
    paramMap.put("vendorId", Integer.valueOf(parama.Nbh));
    paramMap.put("productId", Integer.valueOf(parama.Nbi));
    paramMap.put("deviceId", Integer.valueOf(parama.Nbb));
    paramMap.put("repeatCount", Integer.valueOf(parama.repeatCount));
    AppMethodBeat.o(10234);
  }
  
  public static final class a
  {
    public final int Nbb;
    public final int Nbc;
    public final int Nbd;
    public final Character Nbe;
    public final int Nbf;
    public final int Nbg;
    public final int Nbh;
    public final int Nbi;
    public final int doj;
    public final int flags;
    public final int jDN;
    public final int repeatCount;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(197847);
      this.Nbb = paramInt1;
      this.flags = paramInt2;
      this.Nbc = paramInt3;
      this.Nbd = paramInt4;
      this.jDN = paramInt5;
      this.Nbe = paramCharacter;
      this.Nbf = paramInt6;
      this.Nbg = paramInt7;
      this.doj = paramInt8;
      this.repeatCount = paramInt9;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.Nbh = paramCharacter.getVendorId();
          this.Nbi = paramCharacter.getProductId();
          AppMethodBeat.o(197847);
          return;
        }
        this.Nbh = 0;
        this.Nbi = 0;
        AppMethodBeat.o(197847);
        return;
      }
      this.Nbh = 0;
      this.Nbi = 0;
      AppMethodBeat.o(197847);
    }
    
    public a(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource(), paramKeyEvent.getRepeatCount());
      AppMethodBeat.i(10254);
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.b
 * JD-Core Version:    0.7.0.1
 */