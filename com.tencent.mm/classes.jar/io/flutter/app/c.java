package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.m;
import io.flutter.plugin.a.m.a;
import io.flutter.plugin.a.m.b;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.d;
import io.flutter.plugin.a.m.e;
import io.flutter.plugin.a.m.f;
import io.flutter.plugin.platform.h;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class c
  implements m, m.a, m.b, m.d, m.e, m.f
{
  private Context IR;
  private FlutterNativeView MXT;
  public FlutterView MXU;
  public final h MXV;
  private final Map<String, Object> MXW;
  private final List<m.d> MXX;
  private final List<m.a> MXY;
  private final List<m.b> MXZ;
  private final List<m.e> MYa;
  private final List<m.f> MYb;
  public Activity mActivity;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(9596);
    this.MXW = new LinkedHashMap(0);
    this.MXX = new ArrayList(0);
    this.MXY = new ArrayList(0);
    this.MXZ = new ArrayList(0);
    this.MYa = new ArrayList(0);
    this.MYb = new ArrayList(0);
    this.IR = paramContext;
    this.MXV = new h();
    AppMethodBeat.o(9596);
  }
  
  public c(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    AppMethodBeat.i(9595);
    this.MXW = new LinkedHashMap(0);
    this.MXX = new ArrayList(0);
    this.MXY = new ArrayList(0);
    this.MXZ = new ArrayList(0);
    this.MYa = new ArrayList(0);
    this.MYb = new ArrayList(0);
    this.MXT = paramFlutterNativeView;
    this.IR = paramContext;
    this.MXV = new h();
    AppMethodBeat.o(9595);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9599);
    Iterator localIterator = this.MXX.iterator();
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
    Iterator localIterator = this.MYb.iterator();
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
  
  public final boolean bdl(String paramString)
  {
    AppMethodBeat.i(9597);
    boolean bool = this.MXW.containsKey(paramString);
    AppMethodBeat.o(9597);
    return bool;
  }
  
  public m.c er(String paramString)
  {
    AppMethodBeat.i(9598);
    if (this.MXW.containsKey(paramString))
    {
      paramString = new IllegalStateException("Plugin key " + paramString + " is already in use");
      AppMethodBeat.o(9598);
      throw paramString;
    }
    this.MXW.put(paramString, null);
    paramString = new a(paramString);
    AppMethodBeat.o(9598);
    return paramString;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9600);
    Iterator localIterator = this.MXY.iterator();
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
    Iterator localIterator = this.MXZ.iterator();
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
    Iterator localIterator = this.MYa.iterator();
    while (localIterator.hasNext()) {
      ((m.e)localIterator.next()).onUserLeaveHint();
    }
    AppMethodBeat.o(9602);
  }
  
  final class a
    implements m.c
  {
    private final String MYc;
    
    a(String paramString)
    {
      this.MYc = paramString;
    }
    
    public final Activity JY()
    {
      AppMethodBeat.i(9624);
      Activity localActivity = c.a(c.this);
      AppMethodBeat.o(9624);
      return localActivity;
    }
    
    public final Context JZ()
    {
      AppMethodBeat.i(9625);
      Context localContext = c.b(c.this);
      AppMethodBeat.o(9625);
      return localContext;
    }
    
    public final io.flutter.plugin.a.c Ka()
    {
      AppMethodBeat.i(9626);
      FlutterNativeView localFlutterNativeView = c.c(c.this);
      AppMethodBeat.o(9626);
      return localFlutterNativeView;
    }
    
    public final io.flutter.view.c Kb()
    {
      AppMethodBeat.i(9627);
      FlutterView localFlutterView = c.d(c.this);
      AppMethodBeat.o(9627);
      return localFlutterView;
    }
    
    public final String L(String paramString1, String paramString2)
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
    
    public final String es(String paramString)
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