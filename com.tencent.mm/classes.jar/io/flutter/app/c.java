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
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c
  implements m, m.a, m.b, m.d, m.e, m.f
{
  private FlutterNativeView SMd;
  public FlutterView SMe;
  public final PlatformViewsController SMf;
  private final Map<String, Object> SMg;
  private final List<m.d> SMh;
  private final List<m.a> SMi;
  private final List<m.b> SMj;
  private final List<m.e> SMk;
  private final List<m.f> SMl;
  public Activity mActivity;
  private Context mAppContext;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(9596);
    this.SMg = new LinkedHashMap(0);
    this.SMh = new ArrayList(0);
    this.SMi = new ArrayList(0);
    this.SMj = new ArrayList(0);
    this.SMk = new ArrayList(0);
    this.SMl = new ArrayList(0);
    this.mAppContext = paramContext;
    this.SMf = new PlatformViewsController();
    AppMethodBeat.o(9596);
  }
  
  public c(FlutterNativeView paramFlutterNativeView, Context paramContext)
  {
    AppMethodBeat.i(9595);
    this.SMg = new LinkedHashMap(0);
    this.SMh = new ArrayList(0);
    this.SMi = new ArrayList(0);
    this.SMj = new ArrayList(0);
    this.SMk = new ArrayList(0);
    this.SMl = new ArrayList(0);
    this.SMd = paramFlutterNativeView;
    this.mAppContext = paramContext;
    this.SMf = new PlatformViewsController();
    AppMethodBeat.o(9595);
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9599);
    Iterator localIterator = this.SMh.iterator();
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
    Iterator localIterator = this.SMl.iterator();
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
  
  public final boolean bsW(String paramString)
  {
    AppMethodBeat.i(9597);
    boolean bool = this.SMg.containsKey(paramString);
    AppMethodBeat.o(9597);
    return bool;
  }
  
  public final m.c bsX(String paramString)
  {
    AppMethodBeat.i(9598);
    if (this.SMg.containsKey(paramString))
    {
      paramString = new IllegalStateException("Plugin key " + paramString + " is already in use");
      AppMethodBeat.o(9598);
      throw paramString;
    }
    this.SMg.put(paramString, null);
    paramString = new a(paramString);
    AppMethodBeat.o(9598);
    return paramString;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9600);
    Iterator localIterator = this.SMi.iterator();
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
    Iterator localIterator = this.SMj.iterator();
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
    Iterator localIterator = this.SMk.iterator();
    while (localIterator.hasNext()) {
      ((m.e)localIterator.next()).onUserLeaveHint();
    }
    AppMethodBeat.o(9602);
  }
  
  final class a
    implements m.c
  {
    private final String SMm;
    
    a(String paramString)
    {
      this.SMm = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.app.c
 * JD-Core Version:    0.7.0.1
 */