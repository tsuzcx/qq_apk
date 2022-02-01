package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class ac
{
  public String Crl;
  public String Crm;
  public int ver;
  
  ac(String paramString1, String paramString2, int paramInt)
  {
    this.Crl = paramString1;
    this.Crm = paramString2;
    this.ver = paramInt;
  }
  
  public static void af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(133132);
    ad.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    SharedPreferences.Editor localEditor = aj.getContext().getSharedPreferences("rsa_public_key_prefs", g.XN()).edit();
    localEditor.putString("keye", paramString1);
    localEditor.putString("keyn", paramString2);
    localEditor.putInt("version", paramInt);
    localEditor.putInt("client_version", d.CpK);
    localEditor.commit();
    AppMethodBeat.o(133132);
  }
  
  public static ac eBY()
  {
    AppMethodBeat.i(133133);
    Object localObject = aj.getContext().getSharedPreferences("rsa_public_key_prefs", g.XN());
    ac localac = new ac(((SharedPreferences)localObject).getString("keye", ""), ((SharedPreferences)localObject).getString("keyn", ""), ((SharedPreferences)localObject).getInt("version", 0));
    int i = ((SharedPreferences)localObject).getInt("client_version", 0);
    if (!localac.eCb())
    {
      if (i > 637665843)
      {
        AppMethodBeat.o(133133);
        return localac;
      }
      boolean bool = ((SharedPreferences)localObject).edit().clear().commit();
      e.vIY.idkeyStat(148L, 38L, 1L, false);
      ad.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(d.CpK), Boolean.valueOf(bool) });
    }
    e.vIY.idkeyStat(148L, 39L, 1L, false);
    ad.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "A34137EBF9C9D29B41F54660D0A6C0B9C8C0BFC7F819A1B4E3FEC98978D2703FB9C73E4DBF951E72367C758901D9A9151841C7A3A7C7A80EB86B97B217DB914F6DC9CF58779AF61A2F5BD67AFC258DAF3344DAD934FC4B4AC86599EC13C4A1E264C1A763D571963428A01E344EE2D37588ACFE607880299CE1A558DCE3BDB9A63DAEA5CD661BC1EC287A5142B7DDFCACBB32B62D132EF146FFB92745050E74CB2BD24C3169B760EDED34D4BBFFF6302368DFD51BC80B87328D1C68C34F948A198409E354C230D57E8AC9A14791945280D8D25D748978797B0F0B84AB861F0AF517105527CA3D21B7897798FF1C56BB91DD2BFBC7B1ED24F457BA932A7358CA0B".substring(0, 4) + "_" + "A34137EBF9C9D29B41F54660D0A6C0B9C8C0BFC7F819A1B4E3FEC98978D2703FB9C73E4DBF951E72367C758901D9A9151841C7A3A7C7A80EB86B97B217DB914F6DC9CF58779AF61A2F5BD67AFC258DAF3344DAD934FC4B4AC86599EC13C4A1E264C1A763D571963428A01E344EE2D37588ACFE607880299CE1A558DCE3BDB9A63DAEA5CD661BC1EC287A5142B7DDFCACBB32B62D132EF146FFB92745050E74CB2BD24C3169B760EDED34D4BBFFF6302368DFD51BC80B87328D1C68C34F948A198409E354C230D57E8AC9A14791945280D8D25D748978797B0F0B84AB861F0AF517105527CA3D21B7897798FF1C56BB91DD2BFBC7B1ED24F457BA932A7358CA0B".substring(507, 511), Integer.valueOf(196) });
    localObject = new ac("010001", "A34137EBF9C9D29B41F54660D0A6C0B9C8C0BFC7F819A1B4E3FEC98978D2703FB9C73E4DBF951E72367C758901D9A9151841C7A3A7C7A80EB86B97B217DB914F6DC9CF58779AF61A2F5BD67AFC258DAF3344DAD934FC4B4AC86599EC13C4A1E264C1A763D571963428A01E344EE2D37588ACFE607880299CE1A558DCE3BDB9A63DAEA5CD661BC1EC287A5142B7DDFCACBB32B62D132EF146FFB92745050E74CB2BD24C3169B760EDED34D4BBFFF6302368DFD51BC80B87328D1C68C34F948A198409E354C230D57E8AC9A14791945280D8D25D748978797B0F0B84AB861F0AF517105527CA3D21B7897798FF1C56BB91DD2BFBC7B1ED24F457BA932A7358CA0B", 196);
    AppMethodBeat.o(133133);
    return localObject;
  }
  
  public static ac eBZ()
  {
    AppMethodBeat.i(133134);
    ac localac = new ac("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    AppMethodBeat.o(133134);
    return localac;
  }
  
  public static ac eCa()
  {
    AppMethodBeat.i(133135);
    ad.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "ADF1E9141970B0BB3393C9A7936FD2DF26935F9D74C185D4CDCE4B849CF94AD80D80FA8DD63CF6830E8618BB1AFCE9D8EDE39D946C9A8DF01085E89F398BC36859298FFEB97E271D725B880972712164FE0CD0995ED289A430511B95F16E9740DFDE308A5A7820567909ECCF9E4BD3633AA08496E5B21053BE070DD8B7A9C66B9E28B0F3540CEEC73BC8B40593E4F23F4AF0F9B5B86E1FAF64BA1ABFF83CC78E9ECBED5C8B2DBF1A6C7D9B863C5516DD7E866373F2973A41123D61986732A228F5B4BC96093AE2774CB2E26AA722CC1B9FCE38BB2CB6C9BE63ABC054BA59A451589E3BA3846A0DBE6BA1F0EA90EC960DDF15CD1BD3A73967D3E0816D48E9F159".substring(0, 4) + "_" + "ADF1E9141970B0BB3393C9A7936FD2DF26935F9D74C185D4CDCE4B849CF94AD80D80FA8DD63CF6830E8618BB1AFCE9D8EDE39D946C9A8DF01085E89F398BC36859298FFEB97E271D725B880972712164FE0CD0995ED289A430511B95F16E9740DFDE308A5A7820567909ECCF9E4BD3633AA08496E5B21053BE070DD8B7A9C66B9E28B0F3540CEEC73BC8B40593E4F23F4AF0F9B5B86E1FAF64BA1ABFF83CC78E9ECBED5C8B2DBF1A6C7D9B863C5516DD7E866373F2973A41123D61986732A228F5B4BC96093AE2774CB2E26AA722CC1B9FCE38BB2CB6C9BE63ABC054BA59A451589E3BA3846A0DBE6BA1F0EA90EC960DDF15CD1BD3A73967D3E0816D48E9F159".substring(507, 511), Integer.valueOf(195) });
    ac localac = new ac("010001", "ADF1E9141970B0BB3393C9A7936FD2DF26935F9D74C185D4CDCE4B849CF94AD80D80FA8DD63CF6830E8618BB1AFCE9D8EDE39D946C9A8DF01085E89F398BC36859298FFEB97E271D725B880972712164FE0CD0995ED289A430511B95F16E9740DFDE308A5A7820567909ECCF9E4BD3633AA08496E5B21053BE070DD8B7A9C66B9E28B0F3540CEEC73BC8B40593E4F23F4AF0F9B5B86E1FAF64BA1ABFF83CC78E9ECBED5C8B2DBF1A6C7D9B863C5516DD7E866373F2973A41123D61986732A228F5B4BC96093AE2774CB2E26AA722CC1B9FCE38BB2CB6C9BE63ABC054BA59A451589E3BA3846A0DBE6BA1F0EA90EC960DDF15CD1BD3A73967D3E0816D48E9F159", 195);
    AppMethodBeat.o(133135);
    return localac;
  }
  
  /* Error */
  public static boolean eCc()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 187
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 189	com/tencent/mm/vfs/l
    //   10: dup
    //   11: new 154	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   18: invokestatic 194	com/tencent/mm/loader/j/b:aih	()Ljava/lang/String;
    //   21: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 196
    //   26: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 199	com/tencent/mm/vfs/l:<init>	(Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ldc 201
    //   41: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   44: aload_3
    //   45: astore_2
    //   46: aload_3
    //   47: new 154	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 206
    //   53: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: getstatic 212	com/tencent/mm/sdk/platformtools/h:glW	Ljava/lang/String;
    //   59: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 214
    //   64: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
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
    //   115: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: astore_2
    //   120: aload_3
    //   121: ldc 232
    //   123: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   126: aload_3
    //   127: astore_2
    //   128: aload_3
    //   129: ldc 234
    //   131: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   134: aload_3
    //   135: astore_2
    //   136: aload_3
    //   137: ldc 236
    //   139: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   142: aload_3
    //   143: astore_2
    //   144: aload_3
    //   145: ldc 238
    //   147: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: astore_2
    //   152: aload_3
    //   153: ldc 240
    //   155: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: ldc 242
    //   163: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   166: aload_3
    //   167: astore_2
    //   168: aload_3
    //   169: ldc 244
    //   171: invokevirtual 204	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   174: iconst_1
    //   175: istore_0
    //   176: aload_3
    //   177: invokevirtual 247	com/tencent/mm/vfs/l:close	()V
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
    //   203: invokestatic 251	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: iload_1
    //   207: istore_0
    //   208: aload_3
    //   209: ifnull -29 -> 180
    //   212: aload_3
    //   213: invokevirtual 247	com/tencent/mm/vfs/l:close	()V
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
    //   235: invokevirtual 247	com/tencent/mm/vfs/l:close	()V
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
    //   37	156	2	locall1	com.tencent.mm.vfs.l
    //   221	1	2	localException1	java.lang.Exception
    //   229	6	2	localObject1	Object
    //   245	1	2	localException2	java.lang.Exception
    //   249	1	2	localException3	java.lang.Exception
    //   35	178	3	locall2	com.tencent.mm.vfs.l
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
  
  public final boolean eCb()
  {
    AppMethodBeat.i(133136);
    if ((this.ver == 0) || (bt.isNullOrNil(this.Crl)) || (bt.isNullOrNil(this.Crm)))
    {
      AppMethodBeat.o(133136);
      return true;
    }
    AppMethodBeat.o(133136);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.ac
 * JD-Core Version:    0.7.0.1
 */