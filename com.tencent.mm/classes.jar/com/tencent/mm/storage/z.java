package com.tencent.mm.storage;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.an;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class z
  extends an
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public boolean NQj = false;
  public boolean NQk = false;
  public boolean NQl = false;
  public int NQm = -1;
  public ege NQn = null;
  x NQo = null;
  private String NQp = "";
  private JSONObject NQq = null;
  public dkr NQr = null;
  private String aid = "";
  public int dDG = 0;
  private String id = null;
  private String kZe = "";
  private String pathType = "";
  public boolean pvs = false;
  public int pxD = -1;
  
  static
  {
    AppMethodBeat.i(124608);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "imgPath";
    localMAutoDBInfo.colsMap.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "talkerId";
    localMAutoDBInfo.colsMap.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isExpand";
    localMAutoDBInfo.colsMap.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "orderFlag";
    localMAutoDBInfo.colsMap.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "hasShow";
    localMAutoDBInfo.colsMap.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "placeTop";
    localMAutoDBInfo.colsMap.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "appMsgStatInfoProto";
    localMAutoDBInfo.colsMap.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bizClientMsgId";
    localMAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "rankSessionId";
    localMAutoDBInfo.colsMap.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "recommendCardId";
    localMAutoDBInfo.colsMap.put("recommendCardId", "TEXT default '' ");
    localStringBuilder.append(" recommendCardId TEXT default '' ");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(124608);
  }
  
  private static byte[] d(ege paramege)
  {
    AppMethodBeat.i(124607);
    if (paramege == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramege = paramege.toByteArray();
      AppMethodBeat.o(124607);
      return paramege;
    }
    catch (IOException paramege)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramege.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  private void gAI()
  {
    AppMethodBeat.i(212334);
    JSONObject localJSONObject = gAE();
    if ((localJSONObject == null) || (!Util.isNullOrNil(this.aid)))
    {
      AppMethodBeat.o(212334);
      return;
    }
    try
    {
      this.aid = localJSONObject.optString("aid");
      this.kZe = localJSONObject.optString("traceid");
      this.pathType = localJSONObject.optString("path_type", "ad");
      AppMethodBeat.o(212334);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(212334);
    }
  }
  
  public final String acx()
  {
    AppMethodBeat.i(212327);
    if (!gAv())
    {
      AppMethodBeat.o(212327);
      return null;
    }
    if (!Util.isNullOrNil(this.NQp))
    {
      localObject = this.NQp;
      AppMethodBeat.o(212327);
      return localObject;
    }
    Object localObject = gAE();
    if (localObject != null) {
      this.NQp = ((JSONObject)localObject).toString();
    }
    localObject = this.NQp;
    AppMethodBeat.o(212327);
    return localObject;
  }
  
  public final void c(ege paramege)
  {
    AppMethodBeat.i(124606);
    this.NQn = paramege;
    paramege = d(paramege);
    if (paramege == null)
    {
      AppMethodBeat.o(124606);
      return;
    }
    this.field_content = Base64.encodeToString(paramege, 0);
    this.fqL = null;
    this.fqk = true;
    AppMethodBeat.o(124606);
  }
  
  public final boolean gAA()
  {
    AppMethodBeat.i(124603);
    if (gAo() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final x gAB()
  {
    AppMethodBeat.i(212326);
    if (this.NQo != null)
    {
      localObject = this.NQo;
      AppMethodBeat.o(212326);
      return localObject;
    }
    Object localObject = b.pfn;
    this.NQo = b.ahh(this.field_content);
    localObject = this.NQo;
    AppMethodBeat.o(212326);
    return localObject;
  }
  
  public final efz gAC()
  {
    AppMethodBeat.i(124604);
    Object localObject = gAD();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((ege)localObject).NfY;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  /* Error */
  public final ege gAD()
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 309	com/tencent/mm/g/c/an:fqL	[B
    //   10: invokestatic 346	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 305	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   20: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +11 -> 34
    //   26: ldc_w 343
    //   29: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: getfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   38: ifnull +16 -> 54
    //   41: aload_0
    //   42: getfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   45: astore_2
    //   46: ldc_w 343
    //   49: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: aload_0
    //   55: new 232	com/tencent/mm/protocal/protobuf/ege
    //   58: dup
    //   59: invokespecial 347	com/tencent/mm/protocal/protobuf/ege:<init>	()V
    //   62: putfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   65: aload_0
    //   66: getfield 305	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   69: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifne +72 -> 144
    //   75: aload_0
    //   76: getfield 305	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   79: iconst_0
    //   80: invokestatic 351	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   88: aload_2
    //   89: invokevirtual 355	com/tencent/mm/protocal/protobuf/ege:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   92: pop
    //   93: iconst_1
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +15 -> 111
    //   99: aload_0
    //   100: getfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   103: aload_0
    //   104: getfield 309	com/tencent/mm/g/c/an:fqL	[B
    //   107: invokevirtual 355	com/tencent/mm/protocal/protobuf/ege:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   110: pop
    //   111: aload_0
    //   112: getfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   115: astore_2
    //   116: ldc_w 343
    //   119: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_2
    //   125: ldc 238
    //   127: ldc_w 357
    //   130: iconst_1
    //   131: anewarray 242	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_1
    //   146: goto -51 -> 95
    //   149: astore_2
    //   150: ldc 238
    //   152: ldc_w 361
    //   155: iconst_1
    //   156: anewarray 242	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 207	com/tencent/mm/storage/z:NQn	Lcom/tencent/mm/protocal/protobuf/ege;
    //   174: goto -63 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	z
    //   94	52	1	i	int
    //   45	78	2	localObject	Object
    //   124	13	2	localException1	Exception
    //   149	13	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   84	93	124	java/lang/Exception
    //   99	111	149	java/lang/Exception
  }
  
  public final JSONObject gAE()
  {
    AppMethodBeat.i(212328);
    if (!gAv())
    {
      AppMethodBeat.o(212328);
      return null;
    }
    if (this.NQq != null)
    {
      localObject = this.NQq;
      AppMethodBeat.o(212328);
      return localObject;
    }
    Object localObject = r.NPl;
    this.NQq = r.biI(this.field_content);
    localObject = this.NQq;
    AppMethodBeat.o(212328);
    return localObject;
  }
  
  public final void gAF()
  {
    AppMethodBeat.i(212329);
    this.NQq = null;
    this.aid = "";
    gAI();
    AppMethodBeat.o(212329);
  }
  
  public final String gAG()
  {
    AppMethodBeat.i(212330);
    if (!Util.isNullOrNil(this.aid))
    {
      str = this.aid;
      AppMethodBeat.o(212330);
      return str;
    }
    gAI();
    String str = this.aid;
    AppMethodBeat.o(212330);
    return str;
  }
  
  public final boolean gAH()
  {
    AppMethodBeat.i(212331);
    if (Util.isNullOrNil(gAG()))
    {
      AppMethodBeat.o(212331);
      return false;
    }
    if (this.NQq == null)
    {
      AppMethodBeat.o(212331);
      return false;
    }
    if (!Util.isNullOrNil(this.NQq.optString("video_info")))
    {
      AppMethodBeat.o(212331);
      return true;
    }
    AppMethodBeat.o(212331);
    return false;
  }
  
  public final int gAJ()
  {
    AppMethodBeat.i(212335);
    if ((!gAs()) || (this.NQr == null))
    {
      AppMethodBeat.o(212335);
      return -1;
    }
    int i = this.NQr.KUh;
    AppMethodBeat.o(212335);
    return i;
  }
  
  public final void gAK()
  {
    this.field_bitFlag &= 0xFFFFFFFE;
  }
  
  public final long gAo()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long gAp()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean gAq()
  {
    return this.dDG == 0;
  }
  
  public final boolean gAr()
  {
    return this.dDG == 1;
  }
  
  public final boolean gAs()
  {
    return this.dDG == 2;
  }
  
  public final boolean gAt()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean gAu()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean gAv()
  {
    return this.field_type == 637534257;
  }
  
  public final boolean gAw()
  {
    return this.field_type == 10100;
  }
  
  public final boolean gAx()
  {
    return this.field_type == 318767153;
  }
  
  public final boolean gAy()
  {
    return this.field_type == 34;
  }
  
  public final boolean gAz()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212325);
    String str;
    if (this.id != null)
    {
      str = this.id;
      AppMethodBeat.o(212325);
      return str;
    }
    if (gAs()) {
      this.id = ("recFeed:" + this.field_orderFlag);
    }
    for (;;)
    {
      str = this.id;
      AppMethodBeat.o(212325);
      return str;
      if (gAr()) {
        this.id = "newMsgLine";
      } else {
        this.id = ("msg:" + this.field_orderFlag);
      }
    }
  }
  
  public final String getPathType()
  {
    AppMethodBeat.i(212332);
    if (!Util.isNullOrNil(this.pathType))
    {
      str = this.pathType;
      AppMethodBeat.o(212332);
      return str;
    }
    gAI();
    String str = this.pathType;
    AppMethodBeat.o(212332);
    return str;
  }
  
  public final String getTraceId()
  {
    AppMethodBeat.i(212333);
    if (!Util.isNullOrNil(this.kZe))
    {
      str = this.kZe;
      AppMethodBeat.o(212333);
      return str;
    }
    gAI();
    String str = this.kZe;
    AppMethodBeat.o(212333);
    return str;
  }
  
  public final boolean iE(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void iF(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean isText()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */