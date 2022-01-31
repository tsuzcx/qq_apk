package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.g.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixReportBroadcast
  extends BroadcastReceiver
{
  private static final ConcurrentHashMap<String, ArrayList<a>> Bbe = new ConcurrentHashMap();
  
  public static void dTn()
  {
    d.ysm.execute(new Runnable()
    {
      public final void run()
      {
        Iterator localIterator = MatrixReportBroadcast.aol().keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (String)localIterator.next();
          Object localObject2 = (ArrayList)MatrixReportBroadcast.aol().get(localObject1);
          c.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report pending issues tag:%s, size:%d", new Object[] { localObject1, Integer.valueOf(((ArrayList)localObject2).size()) });
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MatrixReportBroadcast.a)((Iterator)localObject1).next();
            MatrixReport.with().reportLocal(((MatrixReportBroadcast.a)localObject2).tag, ((MatrixReportBroadcast.a)localObject2).key, ((MatrixReportBroadcast.a)localObject2).value);
          }
        }
        MatrixReportBroadcast.aol().clear();
      }
    });
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast intent == null", new Object[0]);
      return;
    }
    paramContext = w.n(paramIntent, "tag");
    Object localObject = w.n(paramIntent, "key");
    paramIntent = w.n(paramIntent, "value");
    if (!MatrixReport.isInstalled())
    {
      c.e("Matrix.ReportBroadcast", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s, content:%s", new Object[] { paramContext, paramIntent });
      localObject = new a(paramContext, (String)localObject, paramIntent);
      paramIntent = (ArrayList)Bbe.get(paramContext);
      paramContext = paramIntent;
      if (paramIntent == null) {
        paramContext = new ArrayList();
      }
      paramContext.add(localObject);
      return;
    }
    c.i("Matrix.ReportBroadcast", "MatrixReportBroadcast, receive broadcast with tag %s, value:%s", new Object[] { paramContext, paramIntent });
    MatrixReport.with().reportLocal(paramContext, (String)localObject, paramIntent);
  }
  
  static final class a
  {
    String key;
    String tag;
    String value;
    
    a(String paramString1, String paramString2, String paramString3)
    {
      this.tag = paramString1;
      this.key = paramString2;
      this.value = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.util.MatrixReportBroadcast
 * JD-Core Version:    0.7.0.1
 */