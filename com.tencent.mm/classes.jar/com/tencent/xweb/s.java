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
  static boolean aaax;
  static List<a> aaay;
  
  static
  {
    AppMethodBeat.i(185174);
    aaax = false;
    aaay = new ArrayList();
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
        if (aaay.contains(parama))
        {
          AppMethodBeat.o(185168);
          continue;
        }
        aaay.add(parama);
      }
      finally {}
      AppMethodBeat.o(185168);
    }
  }
  
  static void aCJ(int paramInt)
  {
    try
    {
      AppMethodBeat.i(197445);
      Iterator localIterator = aaay.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).Eu(paramInt);
      }
      AppMethodBeat.o(197445);
    }
    finally {}
  }
  
  static void aCK(int paramInt)
  {
    try
    {
      AppMethodBeat.i(185171);
      Iterator localIterator = aaay.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).Et(paramInt);
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
        AppMethodBeat.i(197443);
        init();
        if (parama == null)
        {
          AppMethodBeat.o(197443);
          return;
        }
        if (!aaay.contains(parama))
        {
          AppMethodBeat.o(197443);
          continue;
        }
        aaay.remove(parama);
      }
      finally {}
      AppMethodBeat.o(197443);
    }
  }
  
  public static void init()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(185167);
        if (aaax)
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
            aaax = true;
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
  
  static void iwe()
  {
    try
    {
      AppMethodBeat.i(185169);
      Iterator localIterator = aaay.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).cqT();
      }
      AppMethodBeat.o(185169);
    }
    finally {}
  }
  
  static void iwf()
  {
    try
    {
      AppMethodBeat.i(185172);
      Iterator localIterator = aaay.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).cqU();
      }
      AppMethodBeat.o(185172);
    }
    finally {}
  }
  
  static void iwg()
  {
    try
    {
      AppMethodBeat.i(185173);
      Iterator localIterator = aaay.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).cqV();
      }
      AppMethodBeat.o(185173);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void Et(int paramInt);
    
    public abstract void Eu(int paramInt);
    
    public abstract void cqT();
    
    public abstract void cqU();
    
    public abstract void cqV();
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
        s.iwe();
        AppMethodBeat.o(185166);
        return;
      }
      int i;
      if ("updating".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("updateReicever", "update progress = ".concat(String.valueOf(i)));
        s.aCJ(i);
        AppMethodBeat.o(185166);
        return;
      }
      if ("finished".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("updateReicever", "update finished code = ".concat(String.valueOf(i)));
        s.aCK(i);
        AppMethodBeat.o(185166);
        return;
      }
      if ("cfg_update".equals(paramContext))
      {
        Log.i("updateReicever", "cfg_update");
        s.iwf();
        AppMethodBeat.o(185166);
        return;
      }
      if ("plugin_update".equals(paramContext))
      {
        Log.i("updateReicever", "plugin_update");
        s.iwg();
      }
      AppMethodBeat.o(185166);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.s
 * JD-Core Version:    0.7.0.1
 */