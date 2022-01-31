package com.tencent.mrs.b;

import android.content.Context;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.mm.loader.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public final class a
  extends com.tencent.matrix.b.a
{
  final HashMap<String, ArrayList<com.tencent.matrix.c.b>> wDu = new HashMap();
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void b(com.tencent.matrix.c.b paramb)
  {
    super.b(paramb);
    Object localObject2;
    Object localObject1;
    if (!MatrixReport.isInstalled())
    {
      localObject2 = (ArrayList)this.wDu.get(paramb.tag);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      ((ArrayList)localObject1).add(paramb);
      com.tencent.matrix.d.b.i("Matrix.PluginListener", "matrix report is not init, wait to report plugin:%s, content:%s", new Object[] { paramb.tag, paramb.boK });
    }
    do
    {
      do
      {
        return;
        if (!"memory".equals(paramb.tag)) {
          break;
        }
        localObject3 = paramb.boK;
      } while (localObject3 == null);
      localObject1 = ((JSONObject)localObject3).optString("resultZipPath");
      if ((localObject1 == null) || (((String)localObject1).length() == 0))
      {
        MatrixReport.with().report(paramb.tag, paramb.boK);
        return;
      }
      localObject2 = new Properties();
      ((Properties)localObject2).put("Uin", c.dOS.L("last_login_uin", "0"));
      ((Properties)localObject2).put("ClientVersion", String.valueOf(MatrixReport.with().getClientVersion()));
      ((Properties)localObject2).put("Revision", MatrixReport.with().getRevision());
      ((Properties)localObject2).put("ReportTime", String.valueOf(System.currentTimeMillis()));
      ((Properties)localObject2).put("process", ((JSONObject)localObject3).optString("process"));
      Object localObject3 = MatrixReport.with().getPhoneInfo();
      ((Properties)localObject2).put("DeviceModel", ((MrsLogic.PhoneInfo)localObject3).deviceModel);
      ((Properties)localObject2).put("OSName", ((MrsLogic.PhoneInfo)localObject3).osName);
      ((Properties)localObject2).put("OSVersion", ((MrsLogic.PhoneInfo)localObject3).osVersion);
    } while (!com.tencent.matrix.resource.c.a.a(new File((String)localObject1), (Properties)localObject2));
    MatrixReport.with().report(paramb, new File((String)localObject1));
    return;
    MatrixReport.with().report(paramb.tag, paramb.boK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.b.a
 * JD-Core Version:    0.7.0.1
 */