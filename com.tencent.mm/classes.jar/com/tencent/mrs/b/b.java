package com.tencent.mrs.b;

import android.content.Context;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class b
  extends com.tencent.matrix.d.a
{
  final ConcurrentHashMap<String, ArrayList<com.tencent.matrix.e.b>> Bbe = new ConcurrentHashMap();
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(com.tencent.matrix.e.b paramb)
  {
    super.a(paramb);
    Object localObject2;
    Object localObject1;
    if (!MatrixReport.isInstalled())
    {
      localObject2 = (ArrayList)this.Bbe.get(paramb.tag);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      ((ArrayList)localObject1).add(paramb);
      com.tencent.matrix.g.c.i("Matrix.PluginListener", "matrix report is not init, wait to report plugin:%s, content:%s", new Object[] { paramb.tag, paramb.bOx });
      return;
    }
    if ("memory".equals(paramb.tag))
    {
      Object localObject3 = paramb.bOx;
      if (localObject3 != null)
      {
        localObject1 = ((JSONObject)localObject3).optString("resultZipPath");
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          MatrixReport.with().report(paramb.tag, paramb.key, paramb.bOx);
          return;
        }
        localObject2 = new Properties();
        ((Properties)localObject2).put("Uin", com.tencent.mm.loader.j.c.eQB.Y("last_login_uin", "0"));
        ((Properties)localObject2).put("ClientVersion", String.valueOf(MatrixReport.with().getClientVersion()));
        ((Properties)localObject2).put("Revision", MatrixReport.with().getRevision());
        ((Properties)localObject2).put("ReportTime", String.valueOf(System.currentTimeMillis()));
        ((Properties)localObject2).put("process", ((JSONObject)localObject3).optString("process"));
        localObject3 = MatrixReport.with().getPhoneInfo();
        ((Properties)localObject2).put("DeviceModel", ((MrsLogic.PhoneInfo)localObject3).deviceModel);
        ((Properties)localObject2).put("OSName", ((MrsLogic.PhoneInfo)localObject3).osName);
        ((Properties)localObject2).put("OSVersion", ((MrsLogic.PhoneInfo)localObject3).osVersion);
        if (com.tencent.matrix.resource.c.a.a(new File((String)localObject1), (Properties)localObject2))
        {
          MatrixReport.with().report(paramb, new File((String)localObject1));
          return;
        }
        com.tencent.matrix.g.c.e("Matrix.PluginListener", "HprofBufferShrinker.addExtraInfo fail, tag:memory", new Object[0]);
        return;
      }
      com.tencent.matrix.g.c.e("Matrix.PluginListener", "issue content is null, tag:memory", new Object[0]);
      return;
    }
    MatrixReport.with().report(paramb.tag, paramb.key, paramb.bOx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.b.b
 * JD-Core Version:    0.7.0.1
 */