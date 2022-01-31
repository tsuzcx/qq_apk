package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

final class g$71
  extends c.c
{
  g$71(g paramg, String paramString, e parame, i parami) {}
  
  public final void a(c.a.a parama, String paramString, LinkedList<cpx> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154991);
    try
    {
      g.l(this.vqm).i(253, null);
      label22:
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("_url", this.vra);
      try
      {
        localObject = this.vrb.i(146, (Bundle)localObject);
        if (localObject == null)
        {
          ab.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, result is null", new Object[] { this.vra });
          this.vqm.a(this.uZa, "pre_verify_jsapi:fail", null);
          AppMethodBeat.o(154991);
          return;
        }
        ((Bundle)localObject).setClassLoader(g.class.getClassLoader());
        localObject = (JsapiPermissionWrapper)((Bundle)localObject).getParcelable("_permission_wrapper");
        if (localObject == null)
        {
          ab.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, jsPerm is null", new Object[] { this.vra });
          this.vqm.a(this.uZa, "pre_verify_jsapi:fail", null);
          AppMethodBeat.o(154991);
          return;
        }
      }
      catch (RemoteException parama)
      {
        ab.e("MicroMsg.MsgHandler", "getWvPermission(%s) error, %s", new Object[] { this.vra, Log.getStackTraceString(parama) });
        this.vqm.a(this.uZa, "pre_verify_jsapi:fail", null);
        AppMethodBeat.o(154991);
        return;
      }
      if ((parama == c.a.a.vom) && (((JsapiPermissionWrapper)localObject).wif != null))
      {
        g.b(this.vqm, bo.aox());
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
              paramLinkedList = (cpx)paramString.next();
              c.g localg = c.anm(bo.nullAsNil(paramLinkedList.xmo));
              if (localg == null)
              {
                ab.i("MicroMsg.MsgHandler", "updateJsApi permission failed, func do not exist(%s, %d)", new Object[] { paramLinkedList.xmo, Integer.valueOf(paramLinkedList.state) });
              }
              else if (((JsapiPermissionWrapper)localObject).MB(localg.dqm()) != paramLinkedList.state)
              {
                ((JsapiPermissionWrapper)localObject).a(localg.dqm(), (byte)paramLinkedList.state);
                paramInt1 = 1;
                parama.append(localg.dqm()).append(":").append(paramLinkedList.state).append(",");
              }
            }
            parama.append("]");
          }
        }
        if ((paramInt1 != 0) && (this.vrb != null))
        {
          ab.i("MicroMsg.MsgHandler", "updateJsApis permission(%s)", new Object[] { parama });
          parama = new Bundle();
          parama.putByteArray("jsapi_control_bytes", ((JsapiPermissionWrapper)localObject).wif);
        }
        for (;;)
        {
          try
          {
            if (((JsapiPermissionWrapper)localObject).wif != null) {
              continue;
            }
            paramInt1 = 0;
            ab.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s", new Object[] { Integer.valueOf(paramInt1), localObject });
            this.vrb.e(1006, parama);
          }
          catch (Exception parama)
          {
            ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[] { parama.getMessage() });
            continue;
          }
          this.vqm.a(this.uZa, "pre_verify_jsapi:ok", null);
          AppMethodBeat.o(154991);
          return;
          paramInt1 = ((JsapiPermissionWrapper)localObject).wif.length;
        }
      }
      if (this.vrb != null)
      {
        parama = new Bundle();
        parama.putByteArray("jsapi_control_bytes", ((JsapiPermissionWrapper)localObject).wif);
      }
      try
      {
        ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
        this.vrb.e(1006, parama);
        if (bo.isNullOrNil(paramString))
        {
          this.vqm.a(this.uZa, "pre_verify_jsapi:fail", null);
          AppMethodBeat.o(154991);
          return;
        }
      }
      catch (Exception parama)
      {
        for (;;)
        {
          ab.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[] { parama.getMessage() });
        }
        this.vqm.a(this.uZa, "pre_verify_jsapi:fail_".concat(String.valueOf(paramString)), null);
        AppMethodBeat.o(154991);
        return;
      }
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  public final void aiR(String paramString)
  {
    AppMethodBeat.i(154992);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(154992);
      return;
    }
    if (this.vrb == null)
    {
      AppMethodBeat.o(154992);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_bag_icon", paramString);
    try
    {
      this.vrb.e(72, localBundle);
      AppMethodBeat.o(154992);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MsgHandler", "withExtInfo remote ex, %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(154992);
    }
  }
  
  public final boolean dgh()
  {
    return this.vor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.71
 * JD-Core Version:    0.7.0.1
 */