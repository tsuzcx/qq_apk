package com.tencent.mm.ui.vas.d;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "", "stepOnAnimEnd", "", "intent", "Landroid/content/Intent;", "stepOnAnimStart", "timeStamp", "", "stepOnCreate", "stepStartActivity", "context", "Landroid/content/Context;", "isStartVAS", "", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a.a afRn = a.a.afRo;
  
  public abstract void a(Intent paramIntent, long paramLong);
  
  public abstract void a(Intent paramIntent, Context paramContext, boolean paramBoolean);
  
  public abstract void bs(Intent paramIntent);
  
  public abstract void bt(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.d.a
 * JD-Core Version:    0.7.0.1
 */