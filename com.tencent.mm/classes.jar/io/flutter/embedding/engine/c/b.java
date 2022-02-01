package io.flutter.embedding.engine.c;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.Map;

public final class b
{
  public final io.flutter.a.a.b<Object> IZr;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10233);
    this.IZr = new io.flutter.a.a.b(paramDartExecutor, "flutter/keyevent", f.Jbs);
    AppMethodBeat.o(10233);
  }
  
  public static void a(a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(parama.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(parama.IZw));
    paramMap.put("codePoint", Integer.valueOf(parama.IZx));
    paramMap.put("keyCode", Integer.valueOf(parama.iHR));
    paramMap.put("scanCode", Integer.valueOf(parama.IZz));
    paramMap.put("metaState", Integer.valueOf(parama.IZA));
    if (parama.IZy != null) {
      paramMap.put("character", parama.IZy.toString());
    }
    paramMap.put("source", Integer.valueOf(parama.dep));
    paramMap.put("vendorId", Integer.valueOf(parama.IZB));
    paramMap.put("productId", Integer.valueOf(parama.IZC));
    AppMethodBeat.o(10234);
  }
  
  public static final class a
  {
    public final int IZA;
    public final int IZB;
    public final int IZC;
    public final int IZv;
    public final int IZw;
    public final int IZx;
    public final Character IZy;
    public final int IZz;
    public final int dep;
    public final int flags;
    public final int iHR;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(10255);
      this.IZv = paramInt1;
      this.flags = paramInt2;
      this.IZw = paramInt3;
      this.IZx = paramInt4;
      this.iHR = paramInt5;
      this.IZy = paramCharacter;
      this.IZz = paramInt6;
      this.IZA = paramInt7;
      this.dep = paramInt8;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.IZB = paramCharacter.getVendorId();
          this.IZC = paramCharacter.getProductId();
          AppMethodBeat.o(10255);
          return;
        }
        this.IZB = 0;
        this.IZC = 0;
        AppMethodBeat.o(10255);
        return;
      }
      this.IZB = 0;
      this.IZC = 0;
      AppMethodBeat.o(10255);
    }
    
    public a(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource());
      AppMethodBeat.i(10254);
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.b
 * JD-Core Version:    0.7.0.1
 */