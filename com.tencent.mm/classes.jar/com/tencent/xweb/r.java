package com.tencent.xweb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class r
{
  static boolean IMO;
  static List<a> IMP;
  
  static
  {
    AppMethodBeat.i(185174);
    IMO = false;
    IMP = new ArrayList();
    AppMethodBeat.o(185174);
  }
  
  public static void a(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(185168);
        init();
        if (parama == null)
        {
          AppMethodBeat.o(185168);
          return;
        }
        if (IMP.contains(parama))
        {
          AppMethodBeat.o(185168);
          continue;
        }
        IMP.add(parama);
      }
      finally {}
      AppMethodBeat.o(185168);
    }
  }
  
  static void adc(int paramInt)
  {
    try
    {
      AppMethodBeat.i(185171);
      Iterator localIterator = IMP.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).vG(paramInt);
      }
      AppMethodBeat.o(185171);
    }
    finally {}
  }
  
  static void fqH()
  {
    try
    {
      AppMethodBeat.i(185169);
      Iterator localIterator = IMP.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(185169);
    }
    finally {}
  }
  
  static void fqI()
  {
    try
    {
      AppMethodBeat.i(185170);
      Iterator localIterator = IMP.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(185170);
    }
    finally {}
  }
  
  static void fqJ()
  {
    try
    {
      AppMethodBeat.i(185172);
      Iterator localIterator = IMP.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bvj();
      }
      AppMethodBeat.o(185172);
    }
    finally {}
  }
  
  static void fqK()
  {
    try
    {
      AppMethodBeat.i(185173);
      Iterator localIterator = IMP.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bvk();
      }
      AppMethodBeat.o(185173);
    }
    finally {}
  }
  
  public static void init()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(185167);
        if (IMO)
        {
          AppMethodBeat.o(185167);
          return;
        }
        if (XWalkEnvironment.getApplicationContext() == null) {
          AppMethodBeat.o(185167);
        } else {
          try
          {
            XWalkEnvironment.getApplicationContext().registerReceiver(new b((byte)0), new IntentFilter("com.tencent.xweb.update"));
            IMO = true;
            AppMethodBeat.o(185167);
          }
          catch (Exception localException)
          {
            Log.e("UpdateListener", "registerReceiver failed exception is " + localException.getMessage());
            AppMethodBeat.o(185167);
          }
        }
      }
      finally {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void bvj();
    
    public abstract void bvk();
    
    public abstract void vG(int paramInt);
  }
  
  static final class b
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(185166);
      if (!"com.tencent.xweb.update".equals(paramIntent.getAction()))
      {
        AppMethodBeat.o(185166);
        return;
      }
      paramContext = paramIntent.getStringExtra("stage");
      if ("start".equals(paramContext))
      {
        Log.i("updateReicever", "start update");
        r.fqH();
        AppMethodBeat.o(185166);
        return;
      }
      if ("updating".equals(paramContext))
      {
        Log.i("updateReicever", "update progress = ".concat(String.valueOf(paramIntent.getIntExtra("extra_data", 0))));
        r.fqI();
        AppMethodBeat.o(185166);
        return;
      }
      if ("finished".equals(paramContext))
      {
        int i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("updateReicever", "update finished code = ".concat(String.valueOf(i)));
        r.adc(i);
        AppMethodBeat.o(185166);
        return;
      }
      if ("cfg_update".equals(paramContext))
      {
        Log.i("updateReicever", "cfg_update");
        r.fqJ();
        AppMethodBeat.o(185166);
        return;
      }
      if ("plugin_update".equals(paramContext))
      {
        Log.i("updateReicever", "plugin_update");
        r.fqK();
      }
      AppMethodBeat.o(185166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.r
 * JD-Core Version:    0.7.0.1
 */