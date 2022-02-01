package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  private static final d DEq;
  
  static
  {
    AppMethodBeat.i(116638);
    DEq = new d();
    AppMethodBeat.o(116638);
  }
  
  public static boolean a(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116632);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 1);
    localBundle.putParcelable("data", paramWidgetData);
    paramWidgetData = (Bundle)h.a("com.tencent.mm", localBundle, d.a.class);
    if (paramWidgetData != null)
    {
      boolean bool = paramWidgetData.getBoolean("result");
      AppMethodBeat.o(116632);
      return bool;
    }
    AppMethodBeat.o(116632);
    return false;
  }
  
  public static void b(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116635);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 4);
    localBundle.putParcelable("data", paramWidgetData);
    h.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(116635);
  }
  
  public static void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116633);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 3);
    localBundle.putParcelable("data", paramWidgetData);
    localBundle.putString("err", paramString);
    h.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(116633);
  }
  
  public static void c(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116636);
    if (paramWidgetData == null)
    {
      AppMethodBeat.o(116636);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 5);
    localBundle.putParcelable("data", paramWidgetData);
    h.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(116636);
  }
  
  public static void c(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116634);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 7);
    localBundle.putParcelable("data", paramWidgetData);
    localBundle.putString("err", paramString);
    h.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(116634);
  }
  
  public static void d(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(116637);
    ad.i("WidgetSafeModeIpcImpl", "onDisplaySucc");
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 6);
    localBundle.putParcelable("data", paramWidgetData);
    h.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(116637);
  }
  
  public static d eMK()
  {
    return DEq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.d
 * JD-Core Version:    0.7.0.1
 */