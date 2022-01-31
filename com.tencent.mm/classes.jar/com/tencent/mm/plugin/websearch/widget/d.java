package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  private static final d uMu;
  
  static
  {
    AppMethodBeat.i(91443);
    uMu = new d();
    AppMethodBeat.o(91443);
  }
  
  public static boolean a(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91437);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 1);
    localBundle.putParcelable("data", paramWidgetData);
    boolean bool = ((Bundle)f.a("com.tencent.mm", localBundle, d.a.class)).getBoolean("result");
    AppMethodBeat.o(91437);
    return bool;
  }
  
  public static void b(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91440);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 4);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(91440);
  }
  
  public static void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(91438);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 3);
    localBundle.putParcelable("data", paramWidgetData);
    localBundle.putString("err", paramString);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(91438);
  }
  
  public static void c(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91441);
    if (paramWidgetData == null)
    {
      AppMethodBeat.o(91441);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 5);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(91441);
  }
  
  public static void c(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(91439);
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 7);
    localBundle.putParcelable("data", paramWidgetData);
    localBundle.putString("err", paramString);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(91439);
  }
  
  public static void d(WidgetData paramWidgetData)
  {
    AppMethodBeat.i(91442);
    ab.i("WidgetSafeModeIpcImpl", "onDisplaySucc");
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 6);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
    AppMethodBeat.o(91442);
  }
  
  public static d dab()
  {
    return uMu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.d
 * JD-Core Version:    0.7.0.1
 */