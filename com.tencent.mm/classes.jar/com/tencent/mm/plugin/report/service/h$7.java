package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$7
  implements Runnable
{
  h$7(h paramh, Callable paramCallable, String paramString, long paramLong) {}
  
  public final void run()
  {
    Object localObject7 = null;
    Object localObject6 = null;
    int j = 0;
    AppMethodBeat.i(143870);
    int i;
    Object localObject1;
    if ((MMApplicationContext.isMMProcess()) && (com.tencent.mm.kernel.h.aHB()))
    {
      com.tencent.mm.kernel.h.aHE();
      i = b.getUin();
      if (com.tencent.mm.kernel.h.aHG().aHp() == null) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      Object localObject5 = localObject1;
      label49:
      Object localObject3 = localObject6;
      localObject1 = localObject7;
      try
      {
        Object localObject8 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
        localObject3 = localObject6;
        localObject1 = localObject7;
        Object localObject9 = com.tencent.mm.network.c.kRi;
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject9 = ((SharedPreferences)localObject8).getString((String)localObject9, (String)localObject9);
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject8 = (JSONArray)this.IzR.call();
        localObject3 = localObject6;
        localObject1 = localObject7;
        int k = ((JSONArray)localObject8).length();
        for (;;)
        {
          if (j < k)
          {
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject10 = ((JSONArray)localObject8).getJSONObject(j);
            localObject3 = localObject6;
            localObject1 = localObject7;
            ((JSONObject)localObject10).put("tag", this.lrg);
            localObject3 = localObject6;
            localObject1 = localObject7;
            ((JSONObject)localObject10).put("uin", i);
            j += 1;
            continue;
            localObject1 = z.bcZ();
            break;
            localObject5 = null;
            i = 0;
            break label49;
          }
        }
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject8 = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", d.RAB).put("os_ver", d.kQZ).put("report_time", this.IzS).put("revision", Util.nullAsNil(BuildInfo.REV))).put("items", localObject8).toString().getBytes();
        localObject3 = localObject6;
        localObject1 = localObject7;
        j = localObject8.length;
        localObject3 = localObject6;
        localObject1 = localObject7;
        Object localObject10 = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.RAD), Integer.valueOf(j) }).getBytes()).toLowerCase();
        localObject3 = localObject6;
        localObject1 = localObject7;
        byte[] arrayOfByte = s.compress((byte[])localObject8);
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject8 = new PByteArray();
        localObject3 = localObject6;
        localObject1 = localObject7;
        com.tencent.mm.b.c.a((PByteArray)localObject8, arrayOfByte, ((String)localObject10).getBytes());
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject9 = new StringBuilder(256).append("https://").append((String)localObject9).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.RAD)).append("&devicetype=").append(d.kQZ).append("&filelength=").append(j).append("&sum=").append((String)localObject10).append("&reporttype=1&NewReportType=110");
        if (localObject5 != null)
        {
          localObject3 = localObject6;
          localObject1 = localObject7;
          if (((String)localObject5).length() != 0)
          {
            localObject3 = localObject6;
            localObject1 = localObject7;
            ((StringBuilder)localObject9).append("&username=").append((String)localObject5);
          }
        }
        if (i != 0)
        {
          localObject3 = localObject6;
          localObject1 = localObject7;
          ((StringBuilder)localObject9).append("&uin=").append(i);
        }
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject9 = ((StringBuilder)localObject9).toString();
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject5 = new DefaultHttpClient();
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject9 = new HttpPost((String)localObject9);
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject8 = new ByteArrayEntity(((PByteArray)localObject8).value);
        localObject3 = localObject6;
        localObject1 = localObject7;
        ((ByteArrayEntity)localObject8).setContentType("binary/octet-stream");
        localObject3 = localObject6;
        localObject1 = localObject7;
        ((HttpPost)localObject9).setEntity((HttpEntity)localObject8);
        localObject3 = localObject6;
        localObject1 = localObject7;
        localObject5 = ((HttpClient)localObject5).execute((HttpUriRequest)localObject9).getEntity().getContent();
        localObject3 = localObject5;
        localObject1 = localObject5;
        Log.i("MicroMsg.cLog", "POST returned: ".concat(String.valueOf(Util.convertStreamToString((InputStream)localObject5))));
        if (localObject5 != null) {
          try
          {
            ((InputStream)localObject5).close();
            AppMethodBeat.o(143870);
            return;
          }
          catch (IOException localIOException1)
          {
            AppMethodBeat.o(143870);
            return;
          }
        }
        try
        {
          Object localObject2;
          localIOException2.close();
          AppMethodBeat.o(143870);
          throw localObject4;
          AppMethodBeat.o(143870);
          return;
        }
        catch (IOException localIOException3)
        {
          break label799;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        Log.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "Failed to upload cLog.", new Object[0]);
        if (localObject3 != null) {
          try
          {
            localObject3.close();
            AppMethodBeat.o(143870);
            return;
          }
          catch (IOException localIOException2)
          {
            AppMethodBeat.o(143870);
            return;
          }
        }
      }
      finally
      {
        if (localIOException2 == null) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.h.7
 * JD-Core Version:    0.7.0.1
 */