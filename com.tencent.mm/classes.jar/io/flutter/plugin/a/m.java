package io.flutter.plugin.a;

import android.content.Intent;
import io.flutter.view.FlutterNativeView;

public abstract interface m
{
  @Deprecated
  public abstract boolean bFX(String paramString);
  
  @Deprecated
  public abstract c bFY(String paramString);
  
  public static abstract interface a
  {
    public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  public static abstract interface b
  {
    public abstract boolean onNewIntent(Intent paramIntent);
  }
  
  @Deprecated
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  public static abstract interface e
  {
    public abstract void onUserLeaveHint();
  }
  
  @Deprecated
  public static abstract interface f
  {
    public abstract boolean a(FlutterNativeView paramFlutterNativeView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.m
 * JD-Core Version:    0.7.0.1
 */