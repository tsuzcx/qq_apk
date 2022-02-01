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
  public final io.flutter.plugin.a.b<Object> KMU;
  
  public b(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10233);
    this.KMU = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/keyevent", f.KOW);
    AppMethodBeat.o(10233);
  }
  
  public static void a(a parama, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(parama.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(parama.KMZ));
    paramMap.put("codePoint", Integer.valueOf(parama.KNa));
    paramMap.put("keyCode", Integer.valueOf(parama.jhT));
    paramMap.put("scanCode", Integer.valueOf(parama.KNc));
    paramMap.put("metaState", Integer.valueOf(parama.KNd));
    if (parama.KNb != null) {
      paramMap.put("character", parama.KNb.toString());
    }
    paramMap.put("source", Integer.valueOf(parama.dbL));
    paramMap.put("vendorId", Integer.valueOf(parama.KNe));
    paramMap.put("productId", Integer.valueOf(parama.KNf));
    paramMap.put("deviceId", Integer.valueOf(parama.KMY));
    paramMap.put("repeatCount", Integer.valueOf(parama.repeatCount));
    AppMethodBeat.o(10234);
  }
  
  public static final class a
  {
    public final int KMY;
    public final int KMZ;
    public final int KNa;
    public final Character KNb;
    public final int KNc;
    public final int KNd;
    public final int KNe;
    public final int KNf;
    public final int dbL;
    public final int flags;
    public final int jhT;
    public final int repeatCount;
    
    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Character paramCharacter, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      AppMethodBeat.i(192816);
      this.KMY = paramInt1;
      this.flags = paramInt2;
      this.KMZ = paramInt3;
      this.KNa = paramInt4;
      this.jhT = paramInt5;
      this.KNb = paramCharacter;
      this.KNc = paramInt6;
      this.KNd = paramInt7;
      this.dbL = paramInt8;
      this.repeatCount = paramInt9;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.KNe = paramCharacter.getVendorId();
          this.KNf = paramCharacter.getProductId();
          AppMethodBeat.o(192816);
          return;
        }
        this.KNe = 0;
        this.KNf = 0;
        AppMethodBeat.o(192816);
        return;
      }
      this.KNe = 0;
      this.KNf = 0;
      AppMethodBeat.o(192816);
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