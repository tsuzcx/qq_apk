package com.tencent.mm.storage;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.plugin.biz.b.a;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends am
{
  protected static c.a info;
  public boolean IID = false;
  public boolean IIE = false;
  public boolean IIF = false;
  public dmq IIG = null;
  v IIH = null;
  private String III = "";
  private String jWi = "";
  public boolean ojz = false;
  public int ole = -1;
  private String pathType = "";
  private String zMk = "";
  
  static
  {
    AppMethodBeat.i(124608);
    c.a locala = new c.a();
    locala.IBL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IBN.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.IBN.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.IBN.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "imgPath";
    locala.IBN.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "lvbuffer";
    locala.IBN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "talkerId";
    locala.IBN.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "isExpand";
    locala.IBN.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "orderFlag";
    locala.IBN.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "hasShow";
    locala.IBN.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "placeTop";
    locala.IBN.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "appMsgStatInfoProto";
    locala.IBN.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "isRead";
    locala.IBN.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bitFlag";
    locala.IBN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizClientMsgId";
    locala.IBN.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "rankSessionId";
    locala.IBN.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "recommendCardId";
    locala.IBN.put("recommendCardId", "TEXT default '' ");
    localStringBuilder.append(" recommendCardId TEXT default '' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124608);
  }
  
  private static byte[] c(dmq paramdmq)
  {
    AppMethodBeat.i(124607);
    if (paramdmq == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramdmq = paramdmq.toByteArray();
      AppMethodBeat.o(124607);
      return paramdmq;
    }
    catch (IOException paramdmq)
    {
      ae.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramdmq.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  private void ftn()
  {
    AppMethodBeat.i(188973);
    Object localObject = ftl();
    if ((localObject == null) || (!bu.isNullOrNil(this.zMk)))
    {
      AppMethodBeat.o(188973);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.zMk = ((JSONObject)localObject).optString("aid");
      this.jWi = ((JSONObject)localObject).optString("traceid");
      this.pathType = ((JSONObject)localObject).optString("path_type", "ad");
      AppMethodBeat.o(188973);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(188973);
    }
  }
  
  public final void b(dmq paramdmq)
  {
    AppMethodBeat.i(124606);
    this.IIG = paramdmq;
    paramdmq = c(paramdmq);
    if (paramdmq == null)
    {
      AppMethodBeat.o(124606);
      return;
    }
    this.field_content = Base64.encodeToString(paramdmq, 0);
    VH();
    AppMethodBeat.o(124606);
  }
  
  public final long fsY()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long fsZ()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean fta()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean ftb()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean ftc()
  {
    return this.field_type == 637534257;
  }
  
  public final boolean ftd()
  {
    return this.field_type == 10100;
  }
  
  public final boolean fte()
  {
    return this.field_type == 318767153;
  }
  
  public final boolean ftf()
  {
    return this.field_type == 34;
  }
  
  public final boolean ftg()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean fth()
  {
    AppMethodBeat.i(124603);
    if (fsY() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final v fti()
  {
    AppMethodBeat.i(188968);
    if (this.IIH != null)
    {
      localObject = this.IIH;
      AppMethodBeat.o(188968);
      return localObject;
    }
    Object localObject = a.nUu;
    this.IIH = a.Xl(this.field_content);
    localObject = this.IIH;
    AppMethodBeat.o(188968);
    return localObject;
  }
  
  public final dml ftj()
  {
    AppMethodBeat.i(124604);
    Object localObject = ftk();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((dmq)localObject).HTQ;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  /* Error */
  public final dmq ftk()
  {
    // Byte code:
    //   0: ldc_w 342
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 346	com/tencent/mm/g/c/am:eNe	[B
    //   10: invokestatic 350	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 284	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   20: invokestatic 247	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +11 -> 34
    //   26: ldc_w 342
    //   29: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: getfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   38: ifnull +16 -> 54
    //   41: aload_0
    //   42: getfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   45: astore_2
    //   46: ldc_w 342
    //   49: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: aload_0
    //   55: new 215	com/tencent/mm/protocal/protobuf/dmq
    //   58: dup
    //   59: invokespecial 351	com/tencent/mm/protocal/protobuf/dmq:<init>	()V
    //   62: putfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   65: aload_0
    //   66: getfield 284	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   69: invokestatic 247	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifne +72 -> 144
    //   75: aload_0
    //   76: getfield 284	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   79: iconst_0
    //   80: invokestatic 355	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   88: aload_2
    //   89: invokevirtual 359	com/tencent/mm/protocal/protobuf/dmq:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   92: pop
    //   93: iconst_1
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +15 -> 111
    //   99: aload_0
    //   100: getfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   103: aload_0
    //   104: getfield 346	com/tencent/mm/g/c/am:eNe	[B
    //   107: invokevirtual 359	com/tencent/mm/protocal/protobuf/dmq:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   110: pop
    //   111: aload_0
    //   112: getfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   115: astore_2
    //   116: ldc_w 342
    //   119: invokestatic 182	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_2
    //   125: ldc 221
    //   127: ldc_w 361
    //   130: iconst_1
    //   131: anewarray 225	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 363	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_1
    //   146: goto -51 -> 95
    //   149: astore_2
    //   150: ldc 221
    //   152: ldc_w 365
    //   155: iconst_1
    //   156: anewarray 225	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 363	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 196	com/tencent/mm/storage/w:IIG	Lcom/tencent/mm/protocal/protobuf/dmq;
    //   174: goto -63 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	w
    //   94	52	1	i	int
    //   45	78	2	localObject	Object
    //   124	13	2	localException1	Exception
    //   149	13	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   84	93	124	java/lang/Exception
    //   99	111	149	java/lang/Exception
  }
  
  public final String ftl()
  {
    AppMethodBeat.i(188969);
    if (!ftc())
    {
      AppMethodBeat.o(188969);
      return null;
    }
    if (!bu.isNullOrNil(this.III))
    {
      localObject = this.III;
      AppMethodBeat.o(188969);
      return localObject;
    }
    Object localObject = p.IIi;
    this.III = p.aTM(this.field_content);
    localObject = this.III;
    AppMethodBeat.o(188969);
    return localObject;
  }
  
  public final String ftm()
  {
    AppMethodBeat.i(188970);
    if (!bu.isNullOrNil(this.zMk))
    {
      str = this.zMk;
      AppMethodBeat.o(188970);
      return str;
    }
    ftn();
    String str = this.zMk;
    AppMethodBeat.o(188970);
    return str;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getPathType()
  {
    AppMethodBeat.i(188971);
    if (!bu.isNullOrNil(this.pathType))
    {
      str = this.pathType;
      AppMethodBeat.o(188971);
      return str;
    }
    ftn();
    String str = this.pathType;
    AppMethodBeat.o(188971);
    return str;
  }
  
  public final String getTraceId()
  {
    AppMethodBeat.i(188972);
    if (!bu.isNullOrNil(this.jWi))
    {
      str = this.jWi;
      AppMethodBeat.o(188972);
      return str;
    }
    ftn();
    String str = this.jWi;
    AppMethodBeat.o(188972);
    return str;
  }
  
  public final boolean hk(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void hl(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.w
 * JD-Core Version:    0.7.0.1
 */