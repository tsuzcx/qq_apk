package com.tencent.mm.plugin.voip.b;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.plugin.mmsight.model.d.a;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;

public abstract interface a
  extends d.a
{
  public abstract void c(HashSet<Class<? extends UIComponent>> paramHashSet);
  
  public abstract void dealContentView(View paramView);
  
  public abstract void finish();
  
  public abstract void fixResources(Resources paramResources);
  
  public abstract int getForceOrientation();
  
  public abstract int getLayoutId();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract boolean onBackPressed();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onPause();
  
  public abstract void onPostResume();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void onTrimMemory(int paramInt);
  
  public abstract boolean onUserLeaveHint();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.a
 * JD-Core Version:    0.7.0.1
 */