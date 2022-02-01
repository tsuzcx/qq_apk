package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ag;
import android.support.v4.app.t;
import android.support.v4.b.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class bo
  extends Fragment
  implements az
{
  private static WeakHashMap<FragmentActivity, WeakReference<bo>> QH = new WeakHashMap();
  private Map<String, ay> QI = new a();
  private int QJ = 0;
  private Bundle QK;
  
  public static bo a(FragmentActivity paramFragmentActivity)
  {
    Object localObject = (WeakReference)QH.get(paramFragmentActivity);
    if (localObject != null)
    {
      localObject = (bo)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      bo localbo = (bo)paramFragmentActivity.ah().b("SupportLifecycleFragmentImpl");
      if (localbo != null)
      {
        localObject = localbo;
        if (!localbo.isRemoving()) {}
      }
      else
      {
        localObject = new bo();
        paramFragmentActivity.ah().ao().a((Fragment)localObject, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
      }
      QH.put(paramFragmentActivity, new WeakReference(localObject));
      return localObject;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", paramFragmentActivity);
    }
  }
  
  public final <T extends ay> T a(String paramString, Class<T> paramClass)
  {
    return (ay)paramClass.cast(this.QI.get(paramString));
  }
  
  public final void a(final String paramString, final ay paramay)
  {
    if (!this.QI.containsKey(paramString))
    {
      this.QI.put(paramString, paramay);
      if (this.QJ > 0) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            ay localay;
            if (bo.a(bo.this) > 0)
            {
              localay = paramay;
              if (bo.b(bo.this) == null) {
                break label90;
              }
            }
            label90:
            for (Bundle localBundle = bo.b(bo.this).getBundle(paramString);; localBundle = null)
            {
              localay.onCreate(localBundle);
              if (bo.a(bo.this) >= 2) {
                paramay.onStart();
              }
              if (bo.a(bo.this) >= 3) {
                paramay.onStop();
              }
              bo.a(bo.this);
              return;
            }
          }
        });
      }
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 59 + "LifecycleCallback with tag " + paramString + " already added to this fragment.");
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    Iterator localIterator = this.QI.values().iterator();
    while (localIterator.hasNext()) {
      ((ay)localIterator.next()).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Iterator localIterator = this.QI.values().iterator();
    while (localIterator.hasNext()) {
      ((ay)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.QJ = 1;
    this.QK = paramBundle;
    Iterator localIterator = this.QI.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ay localay = (ay)((Map.Entry)localObject).getValue();
      if (paramBundle != null) {}
      for (localObject = paramBundle.getBundle((String)((Map.Entry)localObject).getKey());; localObject = null)
      {
        localay.onCreate((Bundle)localObject);
        break;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this.QJ = 4;
    Iterator localIterator = this.QI.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.QI.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Bundle localBundle = new Bundle();
        ((ay)localEntry.getValue()).onSaveInstanceState(localBundle);
        paramBundle.putBundle((String)localEntry.getKey(), localBundle);
      }
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    this.QJ = 2;
    Iterator localIterator = this.QI.values().iterator();
    while (localIterator.hasNext()) {
      ((ay)localIterator.next()).onStart();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.QJ = 3;
    Iterator localIterator = this.QI.values().iterator();
    while (localIterator.hasNext()) {
      ((ay)localIterator.next()).onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bo
 * JD-Core Version:    0.7.0.1
 */