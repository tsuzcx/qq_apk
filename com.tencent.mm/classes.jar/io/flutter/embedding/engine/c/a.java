package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.b.a;
import io.flutter.plugin.a.b.b;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.n;
import io.flutter.view.a.b;
import java.util.HashMap;

public final class a
{
  public final FlutterJNI MZl;
  public final b<Object> NaX;
  a NaY;
  private final b.b<Object> NaZ;
  
  public a(DartExecutor paramDartExecutor, FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10262);
    this.NaZ = new b.b()
    {
      public final void eH(Object paramAnonymousObject)
      {
        AppMethodBeat.i(10285);
        if (a.this.NaY == null)
        {
          AppMethodBeat.o(10285);
          return;
        }
        paramAnonymousObject = (HashMap)paramAnonymousObject;
        String str = (String)paramAnonymousObject.get("type");
        HashMap localHashMap = (HashMap)paramAnonymousObject.get("data");
        new StringBuilder("Received ").append(str).append(" message.");
        io.flutter.a.giD();
        int i;
        switch (str.hashCode())
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
          AppMethodBeat.o(10285);
          return;
          if (!str.equals("announce")) {
            break;
          }
          i = 0;
          break label118;
          if (!str.equals("tap")) {
            break;
          }
          i = 1;
          break label118;
          if (!str.equals("longPress")) {
            break;
          }
          i = 2;
          break label118;
          if (!str.equals("tooltip")) {
            break;
          }
          i = 3;
          break label118;
          paramAnonymousObject = (String)localHashMap.get("message");
          if (paramAnonymousObject != null)
          {
            a.this.NaY.bdq(paramAnonymousObject);
            AppMethodBeat.o(10285);
            return;
            paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
            if (paramAnonymousObject != null)
            {
              a.this.NaY.ajH(paramAnonymousObject.intValue());
              AppMethodBeat.o(10285);
              return;
              paramAnonymousObject = (Integer)paramAnonymousObject.get("nodeId");
              if (paramAnonymousObject != null)
              {
                a.this.NaY.ajI(paramAnonymousObject.intValue());
                AppMethodBeat.o(10285);
                return;
                paramAnonymousObject = (String)localHashMap.get("message");
                if (paramAnonymousObject != null) {
                  a.this.NaY.bdr(paramAnonymousObject);
                }
              }
            }
          }
        }
      }
    };
    this.NaX = new b(paramDartExecutor, "flutter/accessibility", n.Nde);
    paramDartExecutor = this.NaX;
    b.b localb = this.NaZ;
    c localc = paramDartExecutor.vOl;
    String str = paramDartExecutor.name;
    if (localb == null) {}
    for (paramDartExecutor = null;; paramDartExecutor = new b.a(paramDartExecutor, localb, (byte)0))
    {
      localc.a(str, paramDartExecutor);
      this.MZl = paramFlutterJNI;
      AppMethodBeat.o(10262);
      return;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10265);
    this.NaY = parama;
    this.MZl.setAccessibilityDelegate(parama);
    AppMethodBeat.o(10265);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(10263);
    this.MZl.dispatchSemanticsAction(paramInt, paramb);
    AppMethodBeat.o(10263);
  }
  
  public final void dispatchSemanticsAction(int paramInt, a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(10264);
    this.MZl.dispatchSemanticsAction(paramInt, paramb, paramObject);
    AppMethodBeat.o(10264);
  }
  
  public static abstract interface a
    extends FlutterJNI.AccessibilityDelegate
  {
    public abstract void ajH(int paramInt);
    
    public abstract void ajI(int paramInt);
    
    public abstract void bdq(String paramString);
    
    public abstract void bdr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.a
 * JD-Core Version:    0.7.0.1
 */