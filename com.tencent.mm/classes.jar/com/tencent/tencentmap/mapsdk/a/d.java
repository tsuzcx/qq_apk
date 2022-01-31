package com.tencent.tencentmap.mapsdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public final class d
  extends BroadcastReceiver
{
  private boolean a = false;
  private Context b;
  private Runnable c = new d.1();
  
  public final void a(Context paramContext)
  {
    if (paramContext == null) {
      cy.c(" Context is null!", new Object[0]);
    }
    while (this.a) {
      return;
    }
    this.a = true;
    paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null) {}
    try
    {
      cy.c(" onReceive context is null!", new Object[0]);
      return;
    }
    catch (Exception paramContext)
    {
      cy.a(paramContext);
      return;
    }
    if (this.b == null) {
      this.b = paramContext;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null)
    {
      cy.c(" onReceive ConnectivityManager is null!", new Object[0]);
      return;
    }
    paramIntent = ((ConnectivityManager)localObject).getNetworkInfo(1);
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(0);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getState();
      if (localObject != null)
      {
        localObject = ((NetworkInfo)localObject).getState();
        break label167;
        label88:
        break label166;
        label89:
        paramContext = ck.a(paramContext);
        if ((paramContext.a()) || (dq.d().h() == 0) || (paramContext.j() == 2)) {
          break label178;
        }
        b.a().a(paramContext.d());
        break label178;
      }
    }
    for (;;)
    {
      if ((NetworkInfo.State.CONNECTED == localObject) || (NetworkInfo.State.CONNECTED == paramIntent))
      {
        b.a().a(this.c);
        return;
        localObject = null;
        break label167;
        paramIntent = null;
        break;
      }
      label166:
      return;
      label167:
      if ((paramIntent != null) || (localObject != null)) {
        break label89;
      }
      label178:
      if (paramIntent == null) {
        if (localObject == null) {
          break label88;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.d
 * JD-Core Version:    0.7.0.1
 */