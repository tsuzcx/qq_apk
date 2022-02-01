package com.tencent.mm.storage;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ap;
import com.tencent.mm.plugin.biz.b.b;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class ab
  extends ap
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public long acFA = 0L;
  public boolean acFB = false;
  public boolean acFC = false;
  public flj acFD = null;
  x acFE = null;
  private String acFF = "";
  public JSONObject acFG = null;
  private String acFH = "";
  private String acFI = null;
  public ene acFJ = null;
  public boolean acFv = false;
  public boolean acFw = false;
  public boolean acFx = false;
  public boolean acFy = false;
  public int acFz = -1;
  public String aid = "";
  public int hAN = 0;
  private String id = null;
  private String qTb = "";
  public boolean vKr = false;
  public int vMB = -1;
  
  static
  {
    AppMethodBeat.i(124608);
    info = ap.aJm();
    AppMethodBeat.o(124608);
  }
  
  private static byte[] c(flj paramflj)
  {
    AppMethodBeat.i(124607);
    if (paramflj == null)
    {
      AppMethodBeat.o(124607);
      return null;
    }
    try
    {
      paramflj = paramflj.toByteArray();
      AppMethodBeat.o(124607);
      return paramflj;
    }
    catch (IOException paramflj)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getTLRecCardBytes toByteArray ex %s", new Object[] { paramflj.getMessage() });
      AppMethodBeat.o(124607);
    }
    return null;
  }
  
  public final void b(flj paramflj)
  {
    AppMethodBeat.i(124606);
    this.acFD = paramflj;
    paramflj = c(paramflj);
    if (paramflj == null)
    {
      AppMethodBeat.o(124606);
      return;
    }
    this.field_content = Base64.encodeToString(paramflj, 0);
    aJr();
    AppMethodBeat.o(124606);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(248533);
    String str;
    if (this.id != null)
    {
      str = this.id;
      AppMethodBeat.o(248533);
      return str;
    }
    if (iYd()) {
      this.id = ("recFeed:" + this.field_orderFlag);
    }
    for (;;)
    {
      str = this.id;
      AppMethodBeat.o(248533);
      return str;
      if (iYc()) {
        this.id = "newMsgLine";
      } else {
        this.id = ("msg:" + this.field_orderFlag);
      }
    }
  }
  
  public final String getTraceId()
  {
    AppMethodBeat.i(248628);
    if (!Util.isNullOrNil(this.qTb))
    {
      str = this.qTb;
      AppMethodBeat.o(248628);
      return str;
    }
    iYu();
    String str = this.qTb;
    AppMethodBeat.o(248628);
    return str;
  }
  
  public final long iYa()
  {
    return (this.field_orderFlag & 0x0) >> 32;
  }
  
  public final long iYb()
  {
    return (this.field_orderFlag & 0xFF000000) >> 24;
  }
  
  public final boolean iYc()
  {
    return this.hAN == 1;
  }
  
  public final boolean iYd()
  {
    return this.hAN == 2;
  }
  
  public final boolean iYe()
  {
    return this.field_type == 285212721;
  }
  
  public final boolean iYf()
  {
    return this.field_type == 620757041;
  }
  
  public final boolean iYg()
  {
    return this.field_type == 637534257;
  }
  
  public final boolean iYh()
  {
    return this.field_type == 10100;
  }
  
  public final boolean iYi()
  {
    return this.field_type == 318767153;
  }
  
  public final boolean iYj()
  {
    return this.field_type == 34;
  }
  
  public final boolean iYk()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean iYl()
  {
    switch (this.field_type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean iYm()
  {
    AppMethodBeat.i(124603);
    if (iYa() == 1L)
    {
      AppMethodBeat.o(124603);
      return true;
    }
    AppMethodBeat.o(124603);
    return false;
  }
  
  public final x iYn()
  {
    AppMethodBeat.i(248585);
    if (this.acFE != null)
    {
      localObject = this.acFE;
      AppMethodBeat.o(248585);
      return localObject;
    }
    Object localObject = b.vto;
    this.acFE = b.aij(this.field_content);
    localObject = this.acFE;
    AppMethodBeat.o(248585);
    return localObject;
  }
  
  public final fle iYo()
  {
    AppMethodBeat.i(124604);
    Object localObject = iYp();
    if (localObject == null)
    {
      AppMethodBeat.o(124604);
      return null;
    }
    localObject = ((flj)localObject).abLK;
    AppMethodBeat.o(124604);
    return localObject;
  }
  
  /* Error */
  public final flj iYp()
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 243	com/tencent/mm/storage/ab:aJq	()[B
    //   9: invokestatic 246	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   12: ifeq +20 -> 32
    //   15: aload_0
    //   16: getfield 142	com/tencent/mm/storage/ab:field_content	Ljava/lang/String;
    //   19: invokestatic 184	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   22: ifeq +10 -> 32
    //   25: ldc 240
    //   27: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: aload_0
    //   33: getfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   36: ifnull +15 -> 51
    //   39: aload_0
    //   40: getfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   43: astore_2
    //   44: ldc 240
    //   46: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_2
    //   50: areturn
    //   51: aload_0
    //   52: new 108	com/tencent/mm/protocal/protobuf/flj
    //   55: dup
    //   56: invokespecial 247	com/tencent/mm/protocal/protobuf/flj:<init>	()V
    //   59: putfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   62: aload_0
    //   63: getfield 142	com/tencent/mm/storage/ab:field_content	Ljava/lang/String;
    //   66: invokestatic 184	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   69: ifne +71 -> 140
    //   72: aload_0
    //   73: getfield 142	com/tencent/mm/storage/ab:field_content	Ljava/lang/String;
    //   76: iconst_0
    //   77: invokestatic 251	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   85: aload_2
    //   86: invokevirtual 255	com/tencent/mm/protocal/protobuf/flj:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   89: pop
    //   90: iconst_1
    //   91: istore_1
    //   92: iload_1
    //   93: ifne +15 -> 108
    //   96: aload_0
    //   97: getfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   100: aload_0
    //   101: invokevirtual 243	com/tencent/mm/storage/ab:aJq	()[B
    //   104: invokevirtual 255	com/tencent/mm/protocal/protobuf/flj:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   107: pop
    //   108: aload_0
    //   109: getfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   112: astore_2
    //   113: ldc 240
    //   115: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: areturn
    //   120: astore_2
    //   121: ldc 114
    //   123: ldc_w 257
    //   126: iconst_1
    //   127: anewarray 118	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_2
    //   133: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: iconst_0
    //   141: istore_1
    //   142: goto -50 -> 92
    //   145: astore_2
    //   146: ldc 114
    //   148: ldc_w 262
    //   151: iconst_1
    //   152: anewarray 118	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_2
    //   158: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 260	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield 81	com/tencent/mm/storage/ab:acFD	Lcom/tencent/mm/protocal/protobuf/flj;
    //   170: goto -62 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ab
    //   91	51	1	i	int
    //   43	76	2	localObject	Object
    //   120	13	2	localException1	Exception
    //   145	13	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   72	90	120	java/lang/Exception
    //   96	108	145	java/lang/Exception
  }
  
  public final String iYq()
  {
    AppMethodBeat.i(248605);
    if (!iYg())
    {
      AppMethodBeat.o(248605);
      return null;
    }
    if (!Util.isNullOrNil(this.acFF))
    {
      localObject = this.acFF;
      AppMethodBeat.o(248605);
      return localObject;
    }
    Object localObject = iYr();
    if (localObject != null) {
      this.acFF = ((JSONObject)localObject).toString();
    }
    localObject = this.acFF;
    AppMethodBeat.o(248605);
    return localObject;
  }
  
  public final JSONObject iYr()
  {
    AppMethodBeat.i(248614);
    if (!iYg())
    {
      AppMethodBeat.o(248614);
      return null;
    }
    if (this.acFG != null)
    {
      localObject = this.acFG;
      AppMethodBeat.o(248614);
      return localObject;
    }
    Object localObject = r.acDM;
    this.acFG = r.bvj(this.field_content);
    localObject = this.acFG;
    AppMethodBeat.o(248614);
    return localObject;
  }
  
  public final String iYs()
  {
    AppMethodBeat.i(248620);
    if (!Util.isNullOrNil(this.aid))
    {
      str = this.aid;
      AppMethodBeat.o(248620);
      return str;
    }
    iYu();
    String str = this.aid;
    AppMethodBeat.o(248620);
    return str;
  }
  
  public final String iYt()
  {
    AppMethodBeat.i(248626);
    if (!Util.isNullOrNil(this.acFH))
    {
      str = this.acFH;
      AppMethodBeat.o(248626);
      return str;
    }
    iYu();
    String str = this.acFH;
    AppMethodBeat.o(248626);
    return str;
  }
  
  public final void iYu()
  {
    AppMethodBeat.i(248633);
    JSONObject localJSONObject = iYr();
    if ((localJSONObject == null) || (!Util.isNullOrNil(this.aid)))
    {
      AppMethodBeat.o(248633);
      return;
    }
    try
    {
      this.aid = localJSONObject.optString("aid");
      this.qTb = localJSONObject.optString("traceid");
      this.acFH = localJSONObject.optString("path_type", "ad");
      AppMethodBeat.o(248633);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getAId ex %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(248633);
    }
  }
  
  public final String iYv()
  {
    AppMethodBeat.i(248635);
    if ((!iYd()) || (this.acFJ == null))
    {
      AppMethodBeat.o(248635);
      return "";
    }
    String str;
    if (this.acFI != null)
    {
      str = this.acFI;
      AppMethodBeat.o(248635);
      return str;
    }
    try
    {
      this.acFI = new String(Base64.encode(this.acFJ.toByteArray(), 2), StandardCharsets.UTF_8);
      str = this.acFI;
      AppMethodBeat.o(248635);
      return str;
    }
    catch (IOException localIOException)
    {
      Log.w("MicroMsg.BizTimeLineInfo", "getRecFeedData ex %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(248635);
    }
    return "";
  }
  
  public final boolean nG(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  public final void nH(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */