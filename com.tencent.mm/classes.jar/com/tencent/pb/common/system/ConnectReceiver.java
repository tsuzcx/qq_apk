package com.tencent.pb.common.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.f.a.a;
import com.tencent.f.f;
import com.tencent.pb.common.b.g;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.b;

public class ConnectReceiver
  extends BroadcastReceiver
{
  private static g InW = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      try
      {
        if (paramIntent.getAction() == null) {
          return;
        }
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
          return;
        }
        if (InW == null) {
          InW = new g();
        }
        boolean bool1 = h.isNetworkConnected();
        boolean bool2 = InW.Tv();
        paramContext = (a)f.aOl("EventCenter");
        if ((!bool2) || (paramContext == null)) {
          return;
        }
        if (bool1)
        {
          paramContext.b("GLOBAL_TOPIC_NETWORK_CHANGE", 21, null);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        b.w("ConnectReceiver", new Object[] { "onReceive", paramContext });
        return;
      }
      paramContext.b("GLOBAL_TOPIC_NETWORK_CHANGE", 33, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.system.ConnectReceiver
 * JD-Core Version:    0.7.0.1
 */