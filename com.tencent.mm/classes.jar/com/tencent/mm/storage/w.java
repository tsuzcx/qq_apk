package com.tencent.mm.storage;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.am;
import com.tencent.mm.plugin.biz.b.a;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public final class w
  extends am
{
  protected static c.a info;
  public boolean Ion = false;
  public boolean Ioo = false;
  public boolean Iop = false;
  public dlt Ioq = null;
  v Ior = null;
  private String Ios = "";
  private String jSR = "";
  public int ofe = -1;
  private String pathType = "";
  private String zuP = "";
  
  static
  {
    AppMethodBeat.i(124608);
    c.a locala = new c.a();
    locala.IhA = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IhC.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.IhC.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "imgPath";
    locala.IhC.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "lvbuffer";
    locala.IhC.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[9] = "talkerId";
    locala.IhC.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "isExpand";
    locala.IhC.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "orderFlag";
    locala.IhC.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "hasShow";
    locala.IhC.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "placeTop";
    locala.IhC.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "appMsgStatInfoProto";
    locala.IhC.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "isRead";
    locala.IhC.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bitFlag";
    locala.IhC.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizClientMsgId";
    locala.IhC.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "rankSessionId";
    locala.IhC.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(124608);
  }
  
  private static byte[] c(dlt paramdlt)
  {
    AppMethodBeat.i(124607);
    if (paramdlt == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramdlt = paramdlt.toByteArray();
      AppMethodBeat.o(124607);
      return paramdlt;
    }
    catch (IOException paramdlt)
    {
      ad.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramdlt.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  private void fpp()
  {
    AppMethodBeat.i(207272);
    Object localObject = fpn();
    if ((localObject == null) || (!bt.isNullOrNil(this.zuP)))
    {
      AppMethodBeat.o(207272);
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.zuP = ((JSONObject)localObject).optString("aid");
      this.jSR = ((JSONObject)localObject).optString("traceid");
      this.pathType = ((JSONObject)localObject).optString("path_type", "ad");
      AppMethodBeat.o(207272);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(207272);
    }
  }
  
  public final void b(dlt paramdlt)
  {
    AppMethodBeat.i(124606);
    this.Ioq = paramdlt;
    paramdlt = c(paramdlt);
    if (paramdlt == null)
    {
      AppMethodBeat.o(124606);
      return;
    }
    this.field_content = Base64.encodeToString(paramdlt, 0);
    Vz();
    AppMethodBeat.o(124606);
  }
  
  public final long fpb()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long fpc()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean fpd()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean fpe()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean fpf()
  {
    return this.field_type == 637534257;
  }
  
  public final boolean fpg()
  {
    return this.field_type == 10100;
  }
  
  public final boolean fph()
  {
    return this.field_type == 34;
  }
  
  public final boolean fpi()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean fpj()
  {
    AppMethodBeat.i(124603);
    if (fpb() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final v fpk()
  {
    AppMethodBeat.i(207267);
    if (this.Ior != null)
    {
      localObject = this.Ior;
      AppMethodBeat.o(207267);
      return localObject;
    }
    Object localObject = a.nOO;
    this.Ior = a.Wz(this.field_content);
    localObject = this.Ior;
    AppMethodBeat.o(207267);
    return localObject;
  }
  
  public final dlo fpl()
  {
    AppMethodBeat.i(124604);
    Object localObject = fpm();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((dlt)localObject).HAd;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  /* Error */
  public final dlt fpm()
  {
    // Byte code:
    //   0: ldc_w 333
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 337	com/tencent/mm/g/c/am:eLt	[B
    //   10: invokestatic 341	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   13: ifeq +21 -> 34
    //   16: aload_0
    //   17: getfield 277	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   20: invokestatic 240	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +11 -> 34
    //   26: ldc_w 333
    //   29: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: getfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   38: ifnull +16 -> 54
    //   41: aload_0
    //   42: getfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   45: astore_2
    //   46: ldc_w 333
    //   49: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_2
    //   53: areturn
    //   54: aload_0
    //   55: new 208	com/tencent/mm/protocal/protobuf/dlt
    //   58: dup
    //   59: invokespecial 342	com/tencent/mm/protocal/protobuf/dlt:<init>	()V
    //   62: putfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   65: aload_0
    //   66: getfield 277	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   69: invokestatic 240	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifne +72 -> 144
    //   75: aload_0
    //   76: getfield 277	com/tencent/mm/storage/w:field_content	Ljava/lang/String;
    //   79: iconst_0
    //   80: invokestatic 346	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   88: aload_2
    //   89: invokevirtual 350	com/tencent/mm/protocal/protobuf/dlt:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   92: pop
    //   93: iconst_1
    //   94: istore_1
    //   95: iload_1
    //   96: ifne +15 -> 111
    //   99: aload_0
    //   100: getfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   103: aload_0
    //   104: getfield 337	com/tencent/mm/g/c/am:eLt	[B
    //   107: invokevirtual 350	com/tencent/mm/protocal/protobuf/dlt:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   110: pop
    //   111: aload_0
    //   112: getfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
    //   115: astore_2
    //   116: ldc_w 333
    //   119: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_2
    //   125: ldc 214
    //   127: ldc_w 352
    //   130: iconst_1
    //   131: anewarray 218	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 354	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_1
    //   146: goto -51 -> 95
    //   149: astore_2
    //   150: ldc 214
    //   152: ldc_w 356
    //   155: iconst_1
    //   156: anewarray 218	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_2
    //   162: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 354	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 189	com/tencent/mm/storage/w:Ioq	Lcom/tencent/mm/protocal/protobuf/dlt;
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
  
  public final String fpn()
  {
    AppMethodBeat.i(207268);
    if (!fpf())
    {
      AppMethodBeat.o(207268);
      return null;
    }
    if (!bt.isNullOrNil(this.Ios))
    {
      localObject = this.Ios;
      AppMethodBeat.o(207268);
      return localObject;
    }
    Object localObject = p.InU;
    this.Ios = p.aSp(this.field_content);
    localObject = this.Ios;
    AppMethodBeat.o(207268);
    return localObject;
  }
  
  public final String fpo()
  {
    AppMethodBeat.i(207269);
    if (!bt.isNullOrNil(this.zuP))
    {
      str = this.zuP;
      AppMethodBeat.o(207269);
      return str;
    }
    fpp();
    String str = this.zuP;
    AppMethodBeat.o(207269);
    return str;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getPathType()
  {
    AppMethodBeat.i(207270);
    if (!bt.isNullOrNil(this.pathType))
    {
      str = this.pathType;
      AppMethodBeat.o(207270);
      return str;
    }
    fpp();
    String str = this.pathType;
    AppMethodBeat.o(207270);
    return str;
  }
  
  public final String getTraceId()
  {
    AppMethodBeat.i(207271);
    if (!bt.isNullOrNil(this.jSR))
    {
      str = this.jSR;
      AppMethodBeat.o(207271);
      return str;
    }
    fpp();
    String str = this.jSR;
    AppMethodBeat.o(207271);
    return str;
  }
  
  public final boolean hj(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void hk(int paramInt)
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