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

public final class s
{
  static boolean MpH;
  static List<a> MpI;
  
  static
  {
    AppMethodBeat.i(185174);
    MpH = false;
    MpI = new ArrayList();
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
        if (MpI.contains(parama))
        {
          AppMethodBeat.o(185168);
          continue;
        }
        MpI.add(parama);
      }
      finally {}
      AppMethodBeat.o(185168);
    }
  }
  
  static void aiA(int paramInt)
  {
    try
    {
      AppMethodBeat.i(197074);
      Iterator localIterator = MpI.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).xd(paramInt);
      }
      AppMethodBeat.o(197074);
    }
    finally {}
  }
  
  static void aiB(int paramInt)
  {
    try
    {
      AppMethodBeat.i(185171);
      Iterator localIterator = MpI.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).xc(paramInt);
      }
      AppMethodBeat.o(185171);
    }
    finally {}
  }
  
  public static void b(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(197073);
        init();
        if (parama == null)
        {
          AppMethodBeat.o(197073);
          return;
        }
        if (!MpI.contains(parama))
        {
          AppMethodBeat.o(197073);
          continue;
        }
        MpI.remove(parama);
      }
      finally {}
      AppMethodBeat.o(197073);
    }
  }
  
  static void gaD()
  {
    try
    {
      AppMethodBeat.i(185169);
      Iterator localIterator = MpI.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bGk();
      }
      AppMethodBeat.o(185169);
    }
    finally {}
  }
  
  static void gaE()
  {
    try
    {
      AppMethodBeat.i(185172);
      Iterator localIterator = MpI.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bGl();
      }
      AppMethodBeat.o(185172);
    }
    finally {}
  }
  
  static void gaF()
  {
    try
    {
      AppMethodBeat.i(185173);
      Iterator localIterator = MpI.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).bGm();
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
        if (MpH)
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
            MpH = true;
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
    public abstract void bGk();
    
    public abstract void bGl();
    
    public abstract void bGm();
    
    public abstract void xc(int paramInt);
    
    public abstract void xd(int paramInt);
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
        s.gaD();
        AppMethodBeat.o(185166);
        return;
      }
      int i;
      if ("updating".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("updateReicever", "update progress = ".concat(String.valueOf(i)));
        s.aiA(i);
        AppMethodBeat.o(185166);
        return;
      }
      if ("finished".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("updateReicever", "update finished code = ".concat(String.valueOf(i)));
        s.aiB(i);
        AppMethodBeat.o(185166);
        return;
      }
      if ("cfg_update".equals(paramContext))
      {
        Log.i("updateReicever", "cfg_update");
        s.gaE();
        AppMethodBeat.o(185166);
        return;
      }
      if ("plugin_update".equals(paramContext))
      {
        Log.i("updateReicever", "plugin_update");
        s.gaF();
      }
      AppMethodBeat.o(185166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.s
 * JD-Core Version:    0.7.0.1
 */