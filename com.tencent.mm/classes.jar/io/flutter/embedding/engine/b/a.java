package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b.a;
import io.flutter.plugin.a.b.c;
import io.flutter.plugin.a.b.d;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.n;
import io.flutter.view.a.b;
import java.util.HashMap;

public final class a
{
  public final FlutterJNI aapT;
  public final io.flutter.plugin.a.b<Object> aasl;
  a aasm;
  private final b.c<Object> aasn;
  
  public a(DartExecutor paramDartExecutor, FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10262);
    this.aasn = new b.c()
    {
      public final void a(Object paramAnonymousObject, b.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(254788);
        if (a.this.aasm == null)
        {
          AppMethodBeat.o(254788);
          return;
        }
        paramAnonymousObject = (HashMap)paramAnonymousObject;
        String str = (String)paramAnonymousObject.get("type");
        HashMap localHashMap = (HashMap)paramAnonymousObject.get("data");
        new StringBuilder("Received ").append(str).append(" message.");
        io.flutter.b.iAd();
        int i;
        switch (str.hashCode())
        {
        default: 
          i = -1;
          label122:
          switch (i)
          {
          }
          break;
        }
        for (;;)
        {
          paramAnonymousd.eT(null);
          AppMethodBeat.o(254788);
          return;
          if (!str.equals("announce")) {
            break;
          }
          i = 0;
          break label122;
          if (!str.equals("tap")) {
            break;
          }
          i = 1;
          break label122;
          if (!str.equals("longPress")) {
            break;
          }
          i = 2;
          break label122;
          if (!str.equals("tooltip")) {
            break;
          }
          i = 3;
          break label122;
          paramAnonymousObject = (String)localHashMap.get("message");
          if (paramAnonymousObject != null)
          {
            a.this.aasm.bGg(paramAnonymousObject);
            continue;
            paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
            if (paramAnonymousObject != null)
            {
              a.this.aasm.aDl(paramAnonymousObject.intValue());
              continue;
              paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
              if (paramAnonymousObject != null)
              {
                a.this.aasm.aDm(paramAnonymousObject.intValue());
                continue;
                paramAnonymousObject = (String)localHashMap.get("message");
                if (paramAnonymousObject != null) {
                  a.this.aasm.bGh(paramAnonymousObject);
                }
              }
            }
          }
        }
      }
    };
    this.aasl = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/accessibility", n.aauQ);
    paramDartExecutor = this.aasl;
    b.c localc1 = this.aasn;
    c localc = paramDartExecutor.aauy;
    String str = paramDartExecutor.name;
    if (localc1 == null) {}
    for (paramDartExecutor = null;; paramDartExecutor = new b.a(paramDartExecutor, localc1, (byte)0))
    {
      localc.a(str, paramDartExecutor);
      this.aapT = paramFlutterJNI;
      AppMethodBeat.o(10262);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10265);
    this.aasm = parama;
    this.aapT.setAccessibilityDelegate(parama);
    AppMethodBeat.o(10265);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(10263);
    this.aapT.dispatchSemanticsAction(paramInt, paramb);
    AppMethodBeat.o(10263);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(10264);
    this.aapT.dispatchSemanticsAction(paramInt, paramb, paramObject);
    AppMethodBeat.o(10264);
  }
  
  public static abstract interface a
    extends FlutterJNI.AccessibilityDelegate
  {
    public abstract void aDl(int paramInt);
    
    public abstract void aDm(int paramInt);
    
    public abstract void bGg(String paramString);
    
    public abstract void bGh(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.a
 * JD-Core Version:    0.7.0.1
 */