package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/nfc_open/logic/INfcProcessor;", "", "name", "", "getName", "()Ljava/lang/String;", "priority", "", "getPriority", "()I", "process", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public abstract boolean aD(Context paramContext, Intent paramIntent);
  
  public abstract String getName();
  
  public abstract int getPriority();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.c
 * JD-Core Version:    0.7.0.1
 */