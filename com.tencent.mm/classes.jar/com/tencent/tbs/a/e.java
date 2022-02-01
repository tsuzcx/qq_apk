package com.tencent.tbs.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.a.a.c.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static volatile Boolean a = Boolean.FALSE;
  private static e.a abTA;
  private static c abTw = c.abTx;
  private static List<d> c;
  private static boolean d;
  private static String f = "";
  
  public static String a()
  {
    return f;
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(174272);
    if (!f())
    {
      AppMethodBeat.o(174272);
      return;
    }
    abTA.a = paramString1;
    Object localObject = abTA;
    paramString1 = c.aGq(paramInt);
    localObject = ((e.a)localObject).a;
    try
    {
      boolean bool = f();
      if (!bool)
      {
        AppMethodBeat.o(174272);
        return;
      }
      paramInt = paramString1.h;
      int i = abTw.h;
      if (paramInt < i)
      {
        AppMethodBeat.o(174272);
        return;
      }
      paramString1 = new b(System.currentTimeMillis(), paramString1, (String)localObject, paramString2);
      if (d)
      {
        paramString2 = c.iterator();
        while (paramString2.hasNext()) {
          ((d)paramString2.next()).a(paramString1);
        }
      }
      AppMethodBeat.o(174272);
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(174272);
      return;
    }
  }
  
  public static void dg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174269);
    try
    {
      Object localObject;
      if (!a.booleanValue())
      {
        abTA = new e.a((byte)0);
        localObject = new ArrayList();
        c = (List)localObject;
        ((List)localObject).add(new com.tencent.tbs.a.a.b(paramContext, new a(), new com.tencent.tbs.a.a.b.b(), new com.tencent.tbs.a.a.a.b()));
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        localObject = null;
        if (bool) {
          localObject = paramContext.getExternalFilesDir(paramString);
        }
        if (localObject == null) {
          break label127;
        }
      }
      label127:
      for (f = ((File)localObject).getAbsolutePath();; f = paramContext.getFilesDir() + File.separator + paramString)
      {
        abTw = c.abTx;
        d = true;
        a = Boolean.TRUE;
        AppMethodBeat.o(174269);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(174269);
    }
  }
  
  private static boolean f()
  {
    AppMethodBeat.i(174270);
    if (!a.booleanValue()) {
      new Throwable("TBSLog has not been initialized! Please call TBSLog.initialize() first.");
    }
    boolean bool = a.booleanValue();
    AppMethodBeat.o(174270);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.a.e
 * JD-Core Version:    0.7.0.1
 */