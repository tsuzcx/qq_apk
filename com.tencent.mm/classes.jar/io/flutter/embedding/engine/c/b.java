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
  public final io.flutter.plugin.a.b<Object> MDR;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10233);
    this.MDR = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/keyevent", f.MFT);
    AppMethodBeat.o(10233);
  }
  
  public static void a(a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(parama.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(parama.MDW));
    paramMap.put("codePoint", Integer.valueOf(parama.MDX));
    paramMap.put("keyCode", Integer.valueOf(parama.jBc));
    paramMap.put("scanCode", Integer.valueOf(parama.MDZ));
    paramMap.put("metaState", Integer.valueOf(parama.MEa));
    if (parama.MDY != null) {
      paramMap.put("character", parama.MDY.toString());
    }
    paramMap.put("source", Integer.valueOf(parama.dnh));
    paramMap.put("vendorId", Integer.valueOf(parama.MEb));
    paramMap.put("productId", Integer.valueOf(parama.MEc));
    paramMap.put("deviceId", Integer.valueOf(parama.MDV));
    paramMap.put("repeatCount", Integer.valueOf(parama.repeatCount));
    AppMethodBeat.o(10234);
  }
  
  public static final class a
  {
    public final int MDV;
    public final int MDW;
    public final int MDX;
    public final Character MDY;
    public final int MDZ;
    public final int MEa;
    public final int MEb;
    public final int MEc;
    public final int dnh;
    public final int flags;
    public final int jBc;
    public final int repeatCount;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(213265);
      this.MDV = paramInt1;
      this.flags = paramInt2;
      this.MDW = paramInt3;
      this.MDX = paramInt4;
      this.jBc = paramInt5;
      this.MDY = paramCharacter;
      this.MDZ = paramInt6;
      this.MEa = paramInt7;
      this.dnh = paramInt8;
      this.repeatCount = paramInt9;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.MEb = paramCharacter.getVendorId();
          this.MEc = paramCharacter.getProductId();
          AppMethodBeat.o(213265);
          return;
        }
        this.MEb = 0;
        this.MEc = 0;
        AppMethodBeat.o(213265);
        return;
      }
      this.MEb = 0;
      this.MEc = 0;
      AppMethodBeat.o(213265);
    }
    
    public a(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource(), paramKeyEvent.getRepeatCount());
      AppMethodBeat.i(10254);
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.b
 * JD-Core Version:    0.7.0.1
 */