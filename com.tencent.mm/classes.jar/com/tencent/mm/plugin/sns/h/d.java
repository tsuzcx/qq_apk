package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d
{
  public static d ozJ = new d();
  public int dFZ = 0;
  public com.tencent.mm.storage.y dix;
  public HashMap<String, Integer> ozK;
  public HashMap<String, String> ozL;
  public HashSet<String> ozM;
  public int ozN = 200;
  public int ozO = 86400;
  
  private d()
  {
    Object localObject1 = com.tencent.mm.model.c.c.IX().fJ("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).ctr();
      this.ozN = bk.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.ozO = bk.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.dFZ = bk.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.ozN), Integer.valueOf(this.ozO), Integer.valueOf(this.dFZ) });
    this.dix = new com.tencent.mm.storage.y(ac.dOP + "snsreport.cfg");
    localObject1 = this.dix.get(3, new HashMap());
    Object localObject2 = this.dix.get(4, new HashMap());
    Object localObject3 = this.dix.get(5, new HashSet());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)))
    {
      e.deleteFile(ac.dOP + "snsreport.cfg");
      this.ozK = new HashMap();
      this.ozL = new HashMap();
      this.ozM = new HashSet();
      return;
    }
    this.ozK = ((HashMap)localObject1);
    this.ozL = ((HashMap)localObject2);
    this.ozM = ((HashSet)localObject3);
  }
  
  public final void bc(String paramString, boolean paramBoolean)
  {
    if (this.dFZ == 0) {
      return;
    }
    HashMap localHashMap = this.ozK;
    if (this.ozK.containsKey(paramString)) {}
    for (int i = ((Integer)this.ozK.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (!paramBoolean) {
        break;
      }
      this.ozM.add(paramString);
      return;
    }
  }
  
  public final void eQ(String paramString1, String paramString2)
  {
    if ((this.dFZ == 0) || (bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return;
    }
    this.ozL.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.d
 * JD-Core Version:    0.7.0.1
 */