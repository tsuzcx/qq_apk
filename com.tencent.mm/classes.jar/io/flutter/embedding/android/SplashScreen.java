package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract interface SplashScreen
{
  public abstract View createSplashView(Context paramContext, Bundle paramBundle);
  
  public abstract boolean doesSplashViewRememberItsTransition();
  
  public abstract Bundle saveSplashScreenState();
  
  public abstract void transitionToFlutter(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.SplashScreen
 * JD-Core Version:    0.7.0.1
 */