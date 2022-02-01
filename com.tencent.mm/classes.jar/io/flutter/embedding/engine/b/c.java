package io.flutter.embedding.engine.b;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.b.d;
import io.flutter.plugin.a.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public final io.flutter.plugin.a.b<Object> aasl;
  public a aass;
  
  public c(io.flutter.plugin.a.c paramc)
  {
    AppMethodBeat.i(256015);
    this.aasl = new io.flutter.plugin.a.b(paramc, "flutter/keyevent", f.aauL);
    AppMethodBeat.o(256015);
  }
  
  public static void a(b paramb, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(10234);
    paramMap.put("flags", Integer.valueOf(paramb.aasv.getFlags()));
    paramMap.put("plainCodePoint", Integer.valueOf(paramb.aasv.getUnicodeChar(0)));
    paramMap.put("codePoint", Integer.valueOf(paramb.aasv.getUnicodeChar()));
    paramMap.put("keyCode", Integer.valueOf(paramb.aasv.getKeyCode()));
    paramMap.put("scanCode", Integer.valueOf(paramb.aasv.getScanCode()));
    paramMap.put("metaState", Integer.valueOf(paramb.aasv.getMetaState()));
    if (paramb.aasw != null) {
      paramMap.put("character", paramb.aasw.toString());
    }
    paramMap.put("source", Integer.valueOf(paramb.aasv.getSource()));
    InputDevice localInputDevice = InputDevice.getDevice(paramb.aasv.getDeviceId());
    int j;
    int i;
    if ((localInputDevice != null) && (Build.VERSION.SDK_INT >= 19))
    {
      j = localInputDevice.getVendorId();
      i = localInputDevice.getProductId();
    }
    for (;;)
    {
      paramMap.put("vendorId", Integer.valueOf(j));
      paramMap.put("productId", Integer.valueOf(i));
      paramMap.put("deviceId", Integer.valueOf(paramb.aasv.getDeviceId()));
      paramMap.put("repeatCount", Integer.valueOf(paramb.aasv.getRepeatCount()));
      AppMethodBeat.o(10234);
      return;
      i = 0;
      j = 0;
    }
  }
  
  public final b.d<Object> p(final KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(256016);
    paramKeyEvent = new b.d()
    {
      public final void eT(Object paramAnonymousObject)
      {
        AppMethodBeat.i(253368);
        if (c.this.aass == null)
        {
          AppMethodBeat.o(253368);
          return;
        }
        if (paramAnonymousObject == null) {}
        try
        {
          c.this.aass.o(paramKeyEvent);
          AppMethodBeat.o(253368);
          return;
        }
        catch (JSONException paramAnonymousObject)
        {
          "Unable to unpack JSON message: ".concat(String.valueOf(paramAnonymousObject));
          io.flutter.b.iAh();
          c.this.aass.o(paramKeyEvent);
          AppMethodBeat.o(253368);
          return;
        }
        if (((JSONObject)paramAnonymousObject).getBoolean("handled"))
        {
          c.this.aass.n(paramKeyEvent);
          AppMethodBeat.o(253368);
          return;
        }
        c.this.aass.o(paramKeyEvent);
        AppMethodBeat.o(253368);
      }
    };
    AppMethodBeat.o(256016);
    return paramKeyEvent;
  }
  
  public static abstract interface a
  {
    public abstract void n(KeyEvent paramKeyEvent);
    
    public abstract void o(KeyEvent paramKeyEvent);
  }
  
  public static final class b
  {
    public final KeyEvent aasv;
    public final Character aasw;
    
    public b(KeyEvent paramKeyEvent, Character paramCharacter)
    {
      AppMethodBeat.i(10254);
      this.aasv = paramKeyEvent;
      this.aasw = paramCharacter;
      AppMethodBeat.o(10254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.c
 * JD-Core Version:    0.7.0.1
 */