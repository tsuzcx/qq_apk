package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.m;
import io.flutter.a.a.m.a;
import io.flutter.a.a.m.b;
import io.flutter.a.a.m.c;
import io.flutter.a.a.m.d;
import io.flutter.a.a.m.e;
import io.flutter.a.a.m.f;
import io.flutter.a.c.g;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class c
  implements m, m.a, m.b, m.d, m.e, m.f
{
  private Context FZ;
  private FlutterNativeView IWP;
  public FlutterView IWQ;
  public final g IWR;
  private final Map<String, Object> IWS;
  private final List<m.d> IWT;
  private final List<m.a> IWU;
  private final List<m.b> IWV;
  private final List<m.e> IWW;
  private final List<m.f> IWX;
  public Activity mActivity;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(9596);
    this.IWS = new LinkedHashMap(0);
    this.IWT = new ArrayList(0);
    this.IWU = new ArrayList(0);
    this.IWV = new ArrayList(0);
    this.IWW = new ArrayList(0);
    this.IWX = new ArrayList(0);
    this.FZ = paramContext;
    this.IWR = new g();
    AppMethodBeat.o(9596);
  }
  
  public c(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    AppMethodBeat.i(9595);
    this.IWS = new LinkedHashMap(0);
    this.IWT = new ArrayList(0);
    this.IWU = new ArrayList(0);
    this.IWV = new ArrayList(0);
    this.IWW = new ArrayList(0);
    this.IWX = new ArrayList(0);
    this.IWP = paramFlutterNativeView;
    this.FZ = paramContext;
    this.IWR = new g();
    AppMethodBeat.o(9595);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9599);
    Iterator localIterator = this.IWT.iterator();
    while (localIterator.hasNext()) {
      if (((m.d)localIterator.next()).a(paramInt, paramArrayOfString, paramArrayOfInt))
      {
        AppMethodBeat.o(9599);
        return true;
      }
    }
    AppMethodBeat.o(9599);
    return false;
  }
  
  public final boolean a(FlutterNativeView paramFlutterNativeView)
  {
    AppMethodBeat.i(9603);
    Iterator localIterator = this.IWX.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((m.f)localIterator.next()).a(paramFlutterNativeView)) {
        break label58;
      }
      bool = true;
    }
    label58:
    for (;;)
    {
      break;
      AppMethodBeat.o(9603);
      return bool;
    }
  }
  
  public final boolean aPH(String paramString)
  {
    AppMethodBeat.i(9597);
    boolean bool = this.IWS.containsKey(paramString);
    AppMethodBeat.o(9597);
    return bool;
  }
  
  public m.c dB(String paramString)
  {
    AppMethodBeat.i(9598);
    if (this.IWS.containsKey(paramString))
    {
      paramString = new IllegalStateException("Plugin key " + paramString + " is already in use");
      AppMethodBeat.o(9598);
      throw paramString;
    }
    this.IWS.put(paramString, null);
    paramString = new a(paramString);
    AppMethodBeat.o(9598);
    return paramString;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9600);
    Iterator localIterator = this.IWU.iterator();
    while (localIterator.hasNext()) {
      if (((m.a)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent))
      {
        AppMethodBeat.o(9600);
        return true;
      }
    }
    AppMethodBeat.o(9600);
    return false;
  }
  
  public final boolean onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9601);
    Iterator localIterator = this.IWV.iterator();
    while (localIterator.hasNext()) {
      if (((m.b)localIterator.next()).onNewIntent(paramIntent))
      {
        AppMethodBeat.o(9601);
        return true;
      }
    }
    AppMethodBeat.o(9601);
    return false;
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(9602);
    Iterator localIterator = this.IWW.iterator();
    while (localIterator.hasNext()) {
      ((m.e)localIterator.next()).onUserLeaveHint();
    }
    AppMethodBeat.o(9602);
  }
  
  final class a
    implements m.c
  {
    private final String IWY;
    
    a(String paramString)
    {
      this.IWY = paramString;
    }
    
    public final Activity IH()
    {
      AppMethodBeat.i(9624);
      Activity localActivity = c.a(c.this);
      AppMethodBeat.o(9624);
      return localActivity;
    }
    
    public final Context II()
    {
      AppMethodBeat.i(9625);
      Context localContext = c.b(c.this);
      AppMethodBeat.o(9625);
      return localContext;
    }
    
    public final io.flutter.a.a.c IJ()
    {
      AppMethodBeat.i(9626);
      FlutterNativeView localFlutterNativeView = c.c(c.this);
      AppMethodBeat.o(9626);
      return localFlutterNativeView;
    }
    
    public final f IK()
    {
      AppMethodBeat.i(9627);
      FlutterView localFlutterView = c.d(c.this);
      AppMethodBeat.o(9627);
      return localFlutterView;
    }
    
    public final String J(String paramString1, String paramString2)
    {
      AppMethodBeat.i(9629);
      paramString1 = FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
      AppMethodBeat.o(9629);
      return paramString1;
    }
    
    public final m.c a(m.f paramf)
    {
      AppMethodBeat.i(9630);
      c.e(c.this).add(paramf);
      AppMethodBeat.o(9630);
      return this;
    }
    
    public final String dC(String paramString)
    {
      AppMethodBeat.i(9628);
      paramString = FlutterMain.getLookupKeyForAsset(paramString);
      AppMethodBeat.o(9628);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.app.c
 * JD-Core Version:    0.7.0.1
 */