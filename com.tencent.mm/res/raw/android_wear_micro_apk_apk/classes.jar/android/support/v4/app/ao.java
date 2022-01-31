package android.support.v4.app;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class ao
{
  static final bb ev = new az();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      ev = new ay();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      ev = new ax();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      ev = new aw();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      ev = new av();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      ev = new au();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      ev = new at();
      return;
    }
  }
  
  public static Bundle a(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramNotification.extras;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return bo.a(paramNotification);
    }
    return null;
  }
  
  static void a(am paramam, ArrayList<ap> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramam.a((ap)paramArrayList.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.ao
 * JD-Core Version:    0.7.0.1
 */