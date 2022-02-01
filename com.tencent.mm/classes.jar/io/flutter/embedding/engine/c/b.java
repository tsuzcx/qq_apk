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
  public final io.flutter.plugin.a.b<Object> SPQ;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10233);
    this.SPQ = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/keyevent", f.SSk);
    AppMethodBeat.o(10233);
  }
  
  public static void a(a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(parama.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(parama.SPV));
    paramMap.put("codePoint", Integer.valueOf(parama.SPW));
    paramMap.put("keyCode", Integer.valueOf(parama.kEV));
    paramMap.put("scanCode", Integer.valueOf(parama.SPY));
    paramMap.put("metaState", Integer.valueOf(parama.SPZ));
    if (parama.SPX != null) {
      paramMap.put("character", parama.SPX.toString());
    }
    paramMap.put("source", Integer.valueOf(parama.source));
    paramMap.put("vendorId", Integer.valueOf(parama.SQa));
    paramMap.put("productId", Integer.valueOf(parama.SQb));
    paramMap.put("deviceId", Integer.valueOf(parama.SPU));
    paramMap.put("repeatCount", Integer.valueOf(parama.repeatCount));
    AppMethodBeat.o(10234);
  }
  
  public static final class a
  {
    public final int SPU;
    public final int SPV;
    public final int SPW;
    public final Character SPX;
    public final int SPY;
    public final int SPZ;
    public final int SQa;
    public final int SQb;
    public final int flags;
    public final int kEV;
    public final int repeatCount;
    public final int source;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(214985);
      this.SPU = paramInt1;
      this.flags = paramInt2;
      this.SPV = paramInt3;
      this.SPW = paramInt4;
      this.kEV = paramInt5;
      this.SPX = paramCharacter;
      this.SPY = paramInt6;
      this.SPZ = paramInt7;
      this.source = paramInt8;
      this.repeatCount = paramInt9;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.SQa = paramCharacter.getVendorId();
          this.SQb = paramCharacter.getProductId();
          AppMethodBeat.o(214985);
          return;
        }
        this.SQa = 0;
        this.SQb = 0;
        AppMethodBeat.o(214985);
        return;
      }
      this.SQa = 0;
      this.SQb = 0;
      AppMethodBeat.o(214985);
    }
    
    public a(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource(), paramKeyEvent.getRepeatCount());
      AppMethodBeat.i(10254);
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.b
 * JD-Core Version:    0.7.0.1
 */