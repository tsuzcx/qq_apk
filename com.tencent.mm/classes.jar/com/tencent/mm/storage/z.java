package com.tencent.mm.storage;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.an;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONObject;

public class z
  extends an
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public boolean Veb = false;
  public boolean Vec = false;
  public boolean Ved = false;
  public int Vee = -1;
  public long Vef = 0L;
  public boolean Veg = false;
  public boolean Veh = false;
  public eqg Vei = null;
  x Vej = null;
  private String Vek = "";
  private JSONObject Vel = null;
  private String Vem = null;
  public dug Ven = null;
  private String aid = "";
  public int fwp = 0;
  private String id = null;
  private String nTp = "";
  private String pathType = "";
  public boolean sEJ = false;
  public int sHe = -1;
  
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
  
  private static byte[] d(eqg parameqg)
  {
    AppMethodBeat.i(124607);
    if (parameqg == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      parameqg = parameqg.toByteArray();
      AppMethodBeat.o(124607);
      return parameqg;
    }
    catch (IOException parameqg)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { parameqg.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  private void hwP()
  {
    AppMethodBeat.i(205465);
    JSONObject localJSONObject = hwM();
    if ((localJSONObject == null) || (!Util.isNullOrNil(this.aid)))
    {
      AppMethodBeat.o(205465);
      return;
    }
    try
    {
      this.aid = localJSONObject.optString("aid");
      this.nTp = localJSONObject.optString("traceid");
      this.pathType = localJSONObject.optString("path_type", "ad");
      AppMethodBeat.o(205465);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(205465);
    }
  }
  
  public final String ahl()
  {
    AppMethodBeat.i(205457);
    if (!hwC())
    {
      AppMethodBeat.o(205457);
      return null;
    }
    if (!Util.isNullOrNil(this.Vek))
    {
      localObject = this.Vek;
      AppMethodBeat.o(205457);
      return localObject;
    }
    Object localObject = hwM();
    if (localObject != null) {
      this.Vek = ((JSONObject)localObject).toString();
    }
    localObject = this.Vek;
    AppMethodBeat.o(205457);
    return localObject;
  }
  
  public final void c(eqg parameqg)
  {
    AppMethodBeat.i(124606);
    this.Vei = parameqg;
    parameqg = d(parameqg);
    if (parameqg == null)
    {
      AppMethodBeat.o(124606);
      return;
    }
    this.field_content = Base64.encodeToString(parameqg, 0);
    ape();
    AppMethodBeat.o(124606);
  }
  
  public final boolean fYu()
  {
    AppMethodBeat.i(205462);
    if (Util.isNullOrNil(hwO()))
    {
      AppMethodBeat.o(205462);
      return false;
    }
    if (this.Vel == null)
    {
      AppMethodBeat.o(205462);
      return false;
    }
    if (!Util.isNullOrNil(this.Vel.optString("video_info")))
    {
      AppMethodBeat.o(205462);
      return true;
    }
    AppMethodBeat.o(205462);
    return false;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(205454);
    String str;
    if (this.id != null)
    {
      str = this.id;
      AppMethodBeat.o(205454);
      return str;
    }
    if (hwz()) {
      this.id = ("recFeed:" + this.field_orderFlag);
    }
    for (;;)
    {
      str = this.id;
      AppMethodBeat.o(205454);
      return str;
      if (hwy()) {
        this.id = "newMsgLine";
      } else {
        this.id = ("msg:" + this.field_orderFlag);
      }
    }
  }
  
  public final String getPathType()
  {
    AppMethodBeat.i(205463);
    if (!Util.isNullOrNil(this.pathType))
    {
      str = this.pathType;
      AppMethodBeat.o(205463);
      return str;
    }
    hwP();
    String str = this.pathType;
    AppMethodBeat.o(205463);
    return str;
  }
  
  public final String getTraceId()
  {
    AppMethodBeat.i(205464);
    if (!Util.isNullOrNil(this.nTp))
    {
      str = this.nTp;
      AppMethodBeat.o(205464);
      return str;
    }
    hwP();
    String str = this.nTp;
    AppMethodBeat.o(205464);
    return str;
  }
  
  public final boolean hwA()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean hwB()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean hwC()
  {
    return this.field_type == 637534257;
  }
  
  public final boolean hwD()
  {
    return this.field_type == 10100;
  }
  
  public final boolean hwE()
  {
    return this.field_type == 318767153;
  }
  
  public final boolean hwF()
  {
    return this.field_type == 34;
  }
  
  public final boolean hwG()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean hwH()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean hwI()
  {
    AppMethodBeat.i(124603);
    if (hwv() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final x hwJ()
  {
    AppMethodBeat.i(205456);
    if (this.Vej != null)
    {
      localObject = this.Vej;
      AppMethodBeat.o(205456);
      return localObject;
    }
    Object localObject = b.shr;
    this.Vej = b.aoN(this.field_content);
    localObject = this.Vej;
    AppMethodBeat.o(205456);
    return localObject;
  }
  
  public final eqb hwK()
  {
    AppMethodBeat.i(124604);
    Object localObject = hwL();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((eqg)localObject).UsD;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  /* Error */
  public final eqg hwL()
  {
    // Byte code:
    //   0: ldc_w 404
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 407	com/tencent/mm/storage/z:apd	()[B
    //   10: invokestatic 410	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 318	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   20: invokestatic 278	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +11 -> 34
    //   26: ldc_w 404
    //   29: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: getfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   38: ifnull +16 -> 54
    //   41: aload_0
    //   42: getfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   45: astore_2
    //   46: ldc_w 404
    //   49: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: aload_0
    //   55: new 245	com/tencent/mm/protocal/protobuf/eqg
    //   58: dup
    //   59: invokespecial 411	com/tencent/mm/protocal/protobuf/eqg:<init>	()V
    //   62: putfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   65: aload_0
    //   66: getfield 318	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   69: invokestatic 278	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifne +72 -> 144
    //   75: aload_0
    //   76: getfield 318	com/tencent/mm/storage/z:field_content	Ljava/lang/String;
    //   79: iconst_0
    //   80: invokestatic 415	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   88: aload_2
    //   89: invokevirtual 419	com/tencent/mm/protocal/protobuf/eqg:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   92: pop
    //   93: iconst_1
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +15 -> 111
    //   99: aload_0
    //   100: getfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   103: aload_0
    //   104: invokevirtual 407	com/tencent/mm/storage/z:apd	()[B
    //   107: invokevirtual 419	com/tencent/mm/protocal/protobuf/eqg:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   110: pop
    //   111: aload_0
    //   112: getfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
    //   115: astore_2
    //   116: ldc_w 404
    //   119: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_2
    //   125: ldc 251
    //   127: ldc_w 421
    //   130: iconst_1
    //   131: anewarray 255	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: invokevirtual 297	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 423	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_1
    //   146: goto -51 -> 95
    //   149: astore_2
    //   150: ldc 251
    //   152: ldc_w 425
    //   155: iconst_1
    //   156: anewarray 255	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokevirtual 297	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 423	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 218	com/tencent/mm/storage/z:Vei	Lcom/tencent/mm/protocal/protobuf/eqg;
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
    //   75	93	124	java/lang/Exception
    //   99	111	149	java/lang/Exception
  }
  
  public final JSONObject hwM()
  {
    AppMethodBeat.i(205458);
    if (!hwC())
    {
      AppMethodBeat.o(205458);
      return null;
    }
    if (this.Vel != null)
    {
      localObject = this.Vel;
      AppMethodBeat.o(205458);
      return localObject;
    }
    Object localObject = r.VcW;
    this.Vel = r.bvb(this.field_content);
    localObject = this.Vel;
    AppMethodBeat.o(205458);
    return localObject;
  }
  
  public final void hwN()
  {
    AppMethodBeat.i(205460);
    this.Vel = null;
    this.aid = "";
    hwP();
    AppMethodBeat.o(205460);
  }
  
  public final String hwO()
  {
    AppMethodBeat.i(205461);
    if (!Util.isNullOrNil(this.aid))
    {
      str = this.aid;
      AppMethodBeat.o(205461);
      return str;
    }
    hwP();
    String str = this.aid;
    AppMethodBeat.o(205461);
    return str;
  }
  
  public final int hwQ()
  {
    AppMethodBeat.i(205466);
    if ((!hwz()) || (this.Ven == null))
    {
      AppMethodBeat.o(205466);
      return -1;
    }
    int i = this.Ven.RVf;
    AppMethodBeat.o(205466);
    return i;
  }
  
  public final String hwR()
  {
    AppMethodBeat.i(205468);
    if ((!hwz()) || (this.Ven == null))
    {
      AppMethodBeat.o(205468);
      return "";
    }
    String str;
    if (this.Vem != null)
    {
      str = this.Vem;
      AppMethodBeat.o(205468);
      return str;
    }
    try
    {
      this.Vem = new String(Base64.encode(this.Ven.toByteArray(), 2), StandardCharsets.UTF_8);
      str = this.Vem;
      AppMethodBeat.o(205468);
      return str;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getRecFeedData ex %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(205468);
    }
    return "";
  }
  
  public final void hwS()
  {
    this.field_bitFlag &= 0xFFFFFFFE;
  }
  
  public final long hwv()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long hww()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean hwx()
  {
    return this.fwp == 0;
  }
  
  public final boolean hwy()
  {
    return this.fwp == 1;
  }
  
  public final boolean hwz()
  {
    return this.fwp == 2;
  }
  
  public final boolean jQ(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void jR(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.z
 * JD-Core Version:    0.7.0.1
 */