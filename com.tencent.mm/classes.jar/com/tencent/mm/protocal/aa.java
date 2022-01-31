package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class aa
{
  public int ver;
  public String wiZ;
  public String wja;
  
  aa(String paramString1, String paramString2, int paramInt)
  {
    this.wiZ = paramString1;
    this.wja = paramString2;
    this.ver = paramInt;
  }
  
  public static void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(58873);
    ab.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    SharedPreferences.Editor localEditor = ah.getContext().getSharedPreferences("rsa_public_key_prefs", h.Mp()).edit();
    localEditor.putString("keye", paramString1);
    localEditor.putString("keyn", paramString2);
    localEditor.putInt("version", paramInt);
    localEditor.putInt("client_version", d.whH);
    localEditor.commit();
    AppMethodBeat.o(58873);
  }
  
  public static aa dqE()
  {
    AppMethodBeat.i(58874);
    Object localObject = ah.getContext().getSharedPreferences("rsa_public_key_prefs", h.Mp());
    aa localaa = new aa(((SharedPreferences)localObject).getString("keye", ""), ((SharedPreferences)localObject).getString("keyn", ""), ((SharedPreferences)localObject).getInt("version", 0));
    int i = ((SharedPreferences)localObject).getInt("client_version", 0);
    if (!localaa.dqH())
    {
      if (i > 637665843)
      {
        AppMethodBeat.o(58874);
        return localaa;
      }
      boolean bool = ((SharedPreferences)localObject).edit().clear().commit();
      e.qrI.idkeyStat(148L, 38L, 1L, false);
      ab.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(d.whH), Boolean.valueOf(bool) });
    }
    e.qrI.idkeyStat(148L, 39L, 1L, false);
    ab.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9".substring(0, 4) + "_" + "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9".substring(507, 511), Integer.valueOf(184) });
    localObject = new aa("010001", "BB5FB9017F1CA20257A0384C7C87F568F618FA2697A7C12821FCEC3C97BA2509576944A67D4B4FA5A4B9FB4DB9DDB687FE3354B607E1FD0DE58E39F05B772F5E4976A6E83F6BE1DDD5F0D02A237B6CF5DD957B76EF9BF29B523EFA1041A87D3469590F473C9EC4B448034A3EC0C4B221B960F346FDCDA3BBF3CD984FBBDE97FAFE26FC317E4ACC653688F407E5BE93D41DE8981C113069A21329119F65578E0614957AFE0E0CF52A4A38A85CFD163424945C28CD181A3BEB198DF54303ED070C90419F1C31703C93448F1B381623EE6AED759A21865B5F612EBC9FD367AC4AD781D0E99DD4D7E68664989AF71E9A9342A38277018AA8672A465C8225CACD2CB9", 184);
    AppMethodBeat.o(58874);
    return localObject;
  }
  
  public static aa dqF()
  {
    AppMethodBeat.i(58875);
    aa localaa = new aa("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    AppMethodBeat.o(58875);
    return localaa;
  }
  
  public static aa dqG()
  {
    AppMethodBeat.i(58876);
    ab.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885".substring(0, 4) + "_" + "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885".substring(507, 511), Integer.valueOf(183) });
    aa localaa = new aa("010001", "AF64B69AA6F14D838E22F72BBAD6DCDBDC7B2262617C553968EFC0CF2E73FD1714597F9E6BDF1661113B2DC82FDB77286E35822A187380640F5C107DF86CF35FFA3811BDD7012C4C41F5803F644DEE7CF3F037F0BE239A2FBE99F4E002C636759B65BDE41ECF15E594CE28793623FEE039B0E6D3C14131B8AE7BE8C01DF4D03D31C6DCDC228A9A35F74FF4DBB51F8A4E57490965D1074871CE3DB450966A444CF1BE85005D5089752C13D074DAE0172E2BAD3717357A6B49E7A156A6A4EDCFB1BA70C6073431AD0BE0FBBC3C53DCF746663733298385EB5105CA17796A62DAF110380061B1ECF21E686F7467D4327EE6393D2F666C973EA4651AEC32FEC52885", 183);
    AppMethodBeat.o(58876);
    return localaa;
  }
  
  /* Error */
  public static boolean dqI()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 187
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 189	java/io/FileWriter
    //   10: dup
    //   11: new 154	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   18: getstatic 194	com/tencent/mm/compatible/util/e:eQz	Ljava/lang/String;
    //   21: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 196
    //   26: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 199	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ldc 201
    //   41: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: new 154	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 206
    //   53: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: getstatic 212	com/tencent/mm/sdk/platformtools/f:CLIENT_VERSION	Ljava/lang/String;
    //   59: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 214
    //   64: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   73: aload_3
    //   74: astore_2
    //   75: aload_3
    //   76: new 154	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 216
    //   82: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: new 218	java/text/SimpleDateFormat
    //   88: dup
    //   89: ldc 220
    //   91: invokespecial 221	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   94: new 223	java/util/Date
    //   97: dup
    //   98: invokespecial 224	java/util/Date:<init>	()V
    //   101: invokevirtual 228	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   104: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 230
    //   109: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: ldc 232
    //   123: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   126: aload_3
    //   127: astore_2
    //   128: aload_3
    //   129: ldc 234
    //   131: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   134: aload_3
    //   135: astore_2
    //   136: aload_3
    //   137: ldc 236
    //   139: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   142: aload_3
    //   143: astore_2
    //   144: aload_3
    //   145: ldc 238
    //   147: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: astore_2
    //   152: aload_3
    //   153: ldc 240
    //   155: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: ldc 242
    //   163: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   166: aload_3
    //   167: astore_2
    //   168: aload_3
    //   169: ldc 244
    //   171: invokevirtual 204	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   174: iconst_1
    //   175: istore_0
    //   176: aload_3
    //   177: invokevirtual 247	java/io/FileWriter:close	()V
    //   180: ldc 187
    //   182: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: iload_0
    //   186: ireturn
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: astore_2
    //   193: ldc 31
    //   195: aload 4
    //   197: ldc 106
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 251	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: iload_1
    //   207: istore_0
    //   208: aload_3
    //   209: ifnull -29 -> 180
    //   212: aload_3
    //   213: invokevirtual 247	java/io/FileWriter:close	()V
    //   216: iload_1
    //   217: istore_0
    //   218: goto -38 -> 180
    //   221: astore_2
    //   222: iload_1
    //   223: istore_0
    //   224: goto -44 -> 180
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 247	java/io/FileWriter:close	()V
    //   238: ldc 187
    //   240: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_3
    //   244: athrow
    //   245: astore_2
    //   246: goto -66 -> 180
    //   249: astore_2
    //   250: goto -12 -> 238
    //   253: astore_3
    //   254: goto -24 -> 230
    //   257: astore 4
    //   259: goto -68 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   175	49	0	bool1	boolean
    //   1	222	1	bool2	boolean
    //   37	156	2	localFileWriter1	java.io.FileWriter
    //   221	1	2	localException1	java.lang.Exception
    //   229	6	2	localObject1	Object
    //   245	1	2	localException2	java.lang.Exception
    //   249	1	2	localException3	java.lang.Exception
    //   35	178	3	localFileWriter2	java.io.FileWriter
    //   227	17	3	localObject2	Object
    //   253	1	3	localObject3	Object
    //   187	9	4	localException4	java.lang.Exception
    //   257	1	4	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	36	187	java/lang/Exception
    //   212	216	221	java/lang/Exception
    //   7	36	227	finally
    //   176	180	245	java/lang/Exception
    //   234	238	249	java/lang/Exception
    //   38	44	253	finally
    //   46	73	253	finally
    //   75	118	253	finally
    //   120	126	253	finally
    //   128	134	253	finally
    //   136	142	253	finally
    //   144	150	253	finally
    //   152	158	253	finally
    //   160	166	253	finally
    //   168	174	253	finally
    //   193	206	253	finally
    //   38	44	257	java/lang/Exception
    //   46	73	257	java/lang/Exception
    //   75	118	257	java/lang/Exception
    //   120	126	257	java/lang/Exception
    //   128	134	257	java/lang/Exception
    //   136	142	257	java/lang/Exception
    //   144	150	257	java/lang/Exception
    //   152	158	257	java/lang/Exception
    //   160	166	257	java/lang/Exception
    //   168	174	257	java/lang/Exception
  }
  
  public final boolean dqH()
  {
    AppMethodBeat.i(58877);
    if ((this.ver == 0) || (bo.isNullOrNil(this.wiZ)) || (bo.isNullOrNil(this.wja)))
    {
      AppMethodBeat.o(58877);
      return true;
    }
    AppMethodBeat.o(58877);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.aa
 * JD-Core Version:    0.7.0.1
 */