package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.b.b;
import io.flutter.plugin.a.b.c;
import io.flutter.plugin.a.n;
import io.flutter.view.a.b;
import java.util.HashMap;

public final class a
{
  public final FlutterJNI SNV;
  public final b<Object> SPQ;
  a SPR;
  private final b.b<Object> SPS;
  
  public a(DartExecutor paramDartExecutor, FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10262);
    this.SPS = new b.b()
    {
      public final void a(Object paramAnonymousObject, b.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(214983);
        if (a.this.SPR == null)
        {
          AppMethodBeat.o(214983);
          return;
        }
        paramAnonymousObject = (HashMap)paramAnonymousObject;
        paramAnonymousc = (String)paramAnonymousObject.get("type");
        HashMap localHashMap = (HashMap)paramAnonymousObject.get("data");
        new StringBuilder("Received ").append(paramAnonymousc).append(" message.");
        io.flutter.a.hwd();
        int i;
        switch (paramAnonymousc.hashCode())
        {
        default: 
          i = -1;
          label118:
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          AppMethodBeat.o(214983);
          return;
          if (!paramAnonymousc.equals("announce")) {
            break;
          }
          i = 0;
          break label118;
          if (!paramAnonymousc.equals("tap")) {
            break;
          }
          i = 1;
          break label118;
          if (!paramAnonymousc.equals("longPress")) {
            break;
          }
          i = 2;
          break label118;
          if (!paramAnonymousc.equals("tooltip")) {
            break;
          }
          i = 3;
          break label118;
          paramAnonymousObject = (String)localHashMap.get("message");
          if (paramAnonymousObject != null)
          {
            a.this.SPR.bte(paramAnonymousObject);
            AppMethodBeat.o(214983);
            return;
            paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
            if (paramAnonymousObject != null)
            {
              a.this.SPR.atq(paramAnonymousObject.intValue());
              AppMethodBeat.o(214983);
              return;
              paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
              if (paramAnonymousObject != null)
              {
                a.this.SPR.atr(paramAnonymousObject.intValue());
                AppMethodBeat.o(214983);
                return;
                paramAnonymousObject = (String)localHashMap.get("message");
                if (paramAnonymousObject != null) {
                  a.this.SPR.btf(paramAnonymousObject);
                }
              }
            }
          }
        }
      }
    };
    this.SPQ = new b(paramDartExecutor, "flutter/accessibility", n.SSp);
    this.SPQ.a(this.SPS);
    this.SNV = paramFlutterJNI;
    AppMethodBeat.o(10262);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10265);
    this.SPR = parama;
    this.SNV.setAccessibilityDelegate(parama);
    AppMethodBeat.o(10265);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(10263);
    this.SNV.dispatchSemanticsAction(paramInt, paramb);
    AppMethodBeat.o(10263);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(10264);
    this.SNV.dispatchSemanticsAction(paramInt, paramb, paramObject);
    AppMethodBeat.o(10264);
  }
  
  public static abstract interface a
    extends FlutterJNI.AccessibilityDelegate
  {
    public abstract void atq(int paramInt);
    
    public abstract void atr(int paramInt);
    
    public abstract void bte(String paramString);
    
    public abstract void btf(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.a
 * JD-Core Version:    0.7.0.1
 */