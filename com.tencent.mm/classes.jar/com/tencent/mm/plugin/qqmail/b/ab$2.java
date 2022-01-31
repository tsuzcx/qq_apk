package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class ab$2
  implements ab.b
{
  ab$2(ab paramab) {}
  
  public final void a(ArrayList<Long> paramArrayList, HashMap<Long, String> paramHashMap)
  {
    AppMethodBeat.i(68038);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[] { Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramHashMap.size()) });
    Object localObject1;
    if (paramArrayList.size() > 0)
    {
      localObject1 = this.pKx;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (Long)paramArrayList.next();
        localObject2 = (String)((ab)localObject1).pKe.get(String.valueOf(localObject2));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[] { localObject2 });
        if (!bo.isNullOrNil((String)localObject2))
        {
          if (((ab)localObject1).pKp == null) {
            ((ab)localObject1).pKp = new ArrayList();
          }
          ((ab)localObject1).pKp.add(new ab.g((String)localObject2, (String)localObject2));
        }
      }
    }
    if (paramHashMap.size() > 0) {
      ab.a(this.pKx, paramHashMap);
    }
    this.pKx.BX(10);
    paramArrayList = this.pKx;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[] { Integer.valueOf(paramArrayList.pKp.size()) });
    if (paramArrayList.pKp == null) {
      paramArrayList.pKp = new ArrayList();
    }
    if (paramArrayList.pKp.size() > 0)
    {
      paramHashMap = new ab.3(paramArrayList);
      localObject1 = new ab.4(paramArrayList);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[] { Integer.valueOf(paramArrayList.pKp.size()) });
      paramArrayList.pKt = paramHashMap;
      paramArrayList.pKu = ((ab.d)localObject1);
      paramArrayList.pKv = paramArrayList.pKp.size();
      if ((paramArrayList.pKp != null) && (paramArrayList.pKp.size() > 0))
      {
        paramHashMap = (ab.g)paramArrayList.pKp.remove(0);
        paramArrayList.pKq = paramHashMap.fileId;
        paramArrayList.pKr = paramHashMap.fileName;
        paramArrayList.pKs = new HashMap();
        paramArrayList = new u(paramArrayList.pKr, paramArrayList.pKq, paramArrayList.pKw);
        g.RK().eHt.a(paramArrayList, 0);
      }
      AppMethodBeat.o(68038);
      return;
    }
    paramArrayList.BX(90);
    paramArrayList.cdM();
    AppMethodBeat.o(68038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.2
 * JD-Core Version:    0.7.0.1
 */