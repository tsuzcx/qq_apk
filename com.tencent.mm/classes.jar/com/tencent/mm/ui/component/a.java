package com.tencent.mm.ui.component;

import android.app.Activity;
import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/ActivityLifecycleDetailedCallbacks;", "", "onActivityPostCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityPostDestroyed", "onActivityPreDestroyed", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract void onActivityPostCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityPostDestroyed(Activity paramActivity);
  
  public abstract void onActivityPreDestroyed(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.component.a
 * JD-Core Version:    0.7.0.1
 */