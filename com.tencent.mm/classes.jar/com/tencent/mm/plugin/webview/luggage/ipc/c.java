package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.MMActivity;

public final class c
{
  public static <T extends d> void a(Context paramContext, Bundle paramBundle, Class<T> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("task_class_name", paramClass.getName());
    localIntent.putExtra("input_data", paramBundle);
    localIntent.putExtra("orientation", -1);
    com.tencent.mm.br.d.b(paramContext, "webview", ".luggage.ipc.IpcProxyUI", localIntent);
  }
  
  public static <T extends d> void a(MMActivity paramMMActivity, Bundle paramBundle, Class<T> paramClass, b paramb)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("task_class_name", paramClass.getName());
    localIntent.putExtra("input_data", paramBundle);
    localIntent.putExtra("orientation", -1);
    paramMMActivity.gJb = new c.1(paramb);
    com.tencent.mm.br.d.b(paramMMActivity, "webview", ".luggage.ipc.IpcProxyUI", localIntent, 3456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.c
 * JD-Core Version:    0.7.0.1
 */