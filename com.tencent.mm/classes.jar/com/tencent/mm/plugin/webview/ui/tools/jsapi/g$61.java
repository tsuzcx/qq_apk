package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class g$61
  extends c.c
{
  g$61(g paramg, String paramString, e parame, i parami) {}
  
  public final void TM(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (this.rzW == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bag_icon", paramString);
    try
    {
      this.rzW.b(72, localBundle);
      return;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.MsgHandler", "withExtInfo remote ex, %s", new Object[] { paramString.getMessage() });
    }
  }
  
  public final void a(c.a.a parama, String paramString, LinkedList<ccq> paramLinkedList, int paramInt1, int paramInt2)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_url", this.rzV);
    try
    {
      localObject = this.rzW.f(146, (Bundle)localObject);
      if (localObject == null)
      {
        y.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, result is null", new Object[] { this.rzV });
        g.a(this.rzi, this.rzk, "pre_verify_jsapi:fail", null);
        return;
      }
      ((Bundle)localObject).setClassLoader(g.class.getClassLoader());
      localObject = (JsapiPermissionWrapper)((Bundle)localObject).getParcelable("_permission_wrapper");
      if (localObject == null)
      {
        y.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, jsPerm is null", new Object[] { this.rzV });
        g.a(this.rzi, this.rzk, "pre_verify_jsapi:fail", null);
        return;
      }
    }
    catch (RemoteException parama)
    {
      y.e("MicroMsg.MsgHandler", "getWvPermission(%s) error, %s", new Object[] { this.rzV, Log.getStackTraceString(parama) });
      g.a(this.rzi, this.rzk, "pre_verify_jsapi:fail", null);
      return;
    }
    if ((parama == c.a.a.rxt) && (((JsapiPermissionWrapper)localObject).spq != null))
    {
      g.b(this.rzi, bk.UX());
      paramInt2 = 0;
      parama = new StringBuilder();
      paramInt1 = paramInt2;
      if (paramLinkedList != null)
      {
        paramInt1 = paramInt2;
        if (paramLinkedList.size() > 0)
        {
          parama.append("[");
          paramString = paramLinkedList.iterator();
          paramInt1 = 0;
          while (paramString.hasNext())
          {
            paramLinkedList = (ccq)paramString.next();
            c.g localg = c.Xq(bk.pm(paramLinkedList.tmz));
            if (localg == null)
            {
              y.i("MicroMsg.MsgHandler", "updateJsApi permission failed, func do not exist(%s, %d)", new Object[] { paramLinkedList.tmz, Integer.valueOf(paramLinkedList.state) });
            }
            else if (((JsapiPermissionWrapper)localObject).ED(localg.coP()) != paramLinkedList.state)
            {
              ((JsapiPermissionWrapper)localObject).a(localg.coP(), (byte)paramLinkedList.state);
              paramInt1 = 1;
              parama.append(localg.coP()).append(":").append(paramLinkedList.state).append(",");
            }
          }
          parama.append("]");
        }
      }
      if ((paramInt1 != 0) && (this.rzW != null))
      {
        y.i("MicroMsg.MsgHandler", "updateJsApis permission(%s)", new Object[] { parama });
        parama = new Bundle();
        parama.putByteArray("jsapi_control_bytes", ((JsapiPermissionWrapper)localObject).spq);
      }
      for (;;)
      {
        try
        {
          if (((JsapiPermissionWrapper)localObject).spq != null) {
            continue;
          }
          paramInt1 = 0;
          y.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s", new Object[] { Integer.valueOf(paramInt1), localObject });
          this.rzW.b(1006, parama);
        }
        catch (Exception parama)
        {
          y.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[] { parama.getMessage() });
          continue;
        }
        g.a(this.rzi, this.rzk, "pre_verify_jsapi:ok", null);
        return;
        paramInt1 = ((JsapiPermissionWrapper)localObject).spq.length;
      }
    }
    if (this.rzW != null)
    {
      parama = new Bundle();
      parama.putByteArray("jsapi_control_bytes", ((JsapiPermissionWrapper)localObject).spq);
    }
    try
    {
      y.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
      this.rzW.b(1006, parama);
      if (bk.bl(paramString))
      {
        g.a(this.rzi, this.rzk, "pre_verify_jsapi:fail", null);
        return;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        y.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[] { parama.getMessage() });
      }
      g.a(this.rzi, this.rzk, "pre_verify_jsapi:fail_" + paramString, null);
    }
  }
  
  public final boolean cfV()
  {
    return this.rxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.61
 * JD-Core Version:    0.7.0.1
 */