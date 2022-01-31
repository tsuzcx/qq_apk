package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.websearch.api.WidgetData;

public final class d
{
  private static final d qXf = new d();
  
  public static boolean a(WidgetData paramWidgetData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 1);
    localBundle.putParcelable("data", paramWidgetData);
    return ((Bundle)f.a("com.tencent.mm", localBundle, d.a.class)).getBoolean("result");
  }
  
  public static void b(WidgetData paramWidgetData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 4);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
  }
  
  public static void b(WidgetData paramWidgetData, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 3);
    localBundle.putParcelable("data", paramWidgetData);
    localBundle.putString("err", paramString);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
  }
  
  public static void c(WidgetData paramWidgetData)
  {
    if (paramWidgetData == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 5);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
  }
  
  public static d caf()
  {
    return qXf;
  }
  
  public static void d(WidgetData paramWidgetData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("action", 6);
    localBundle.putParcelable("data", paramWidgetData);
    f.a("com.tencent.mm", localBundle, d.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.d
 * JD-Core Version:    0.7.0.1
 */