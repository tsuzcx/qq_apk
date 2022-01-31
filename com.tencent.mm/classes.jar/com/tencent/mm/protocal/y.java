package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class y
{
  public String sqr;
  public String sqs;
  public int ver;
  
  y(String paramString1, String paramString2, int paramInt)
  {
    this.sqr = paramString1;
    this.sqs = paramString2;
    this.ver = paramInt;
  }
  
  public static void K(String paramString1, String paramString2, int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    SharedPreferences.Editor localEditor = ae.getContext().getSharedPreferences("rsa_public_key_prefs", 4).edit();
    localEditor.putString("keye", paramString1);
    localEditor.putString("keyn", paramString2);
    localEditor.putInt("version", paramInt);
    localEditor.putInt("client_version", d.spa);
    localEditor.commit();
  }
  
  public static y cph()
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("rsa_public_key_prefs", 4);
    y localy = new y(localSharedPreferences.getString("keye", ""), localSharedPreferences.getString("keyn", ""), localSharedPreferences.getInt("version", 0));
    int i = localSharedPreferences.getInt("client_version", 0);
    if (!localy.cpk())
    {
      if (i > 637665843) {
        return localy;
      }
      boolean bool = localSharedPreferences.edit().clear().commit();
      f.nEG.a(148L, 38L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(d.spa), Boolean.valueOf(bool) });
    }
    f.nEG.a(148L, 39L, 1L, false);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "A770028BA38DDB08252B6C41C201838553E75552DE0B8EC10DF3E2B6F641026644178D7C362912C51B8CE18682C8502C18B1ACB05A45C725E4EE4F4C8C4FE08D5C8D75FA305175D2595DF5632413E897AE5366ED1A63146B8B0AEE9D955999331B23988F7564FCA291E01E36CA3AE78116FCFDB7AB8A881B33DF687C59E3918A51F5D37C5C20401EE3CFDA007094C904ED4CCE96981548D04EDAD3EAD0071DD75C2C2AA07E5686781BD3723A1305FFB5EBA785B0A50B39EA5003599591ADDAF75B20B8E5048A0B1116CD8A368D54352E73E2FC884F4DE7FE451DE05CBA147BFBDC7A82D3A24C6F5D3F0698B57522E8B4075735A1D1E6D9F531B8C977B8E0619B".substring(0, 4) + "_" + "A770028BA38DDB08252B6C41C201838553E75552DE0B8EC10DF3E2B6F641026644178D7C362912C51B8CE18682C8502C18B1ACB05A45C725E4EE4F4C8C4FE08D5C8D75FA305175D2595DF5632413E897AE5366ED1A63146B8B0AEE9D955999331B23988F7564FCA291E01E36CA3AE78116FCFDB7AB8A881B33DF687C59E3918A51F5D37C5C20401EE3CFDA007094C904ED4CCE96981548D04EDAD3EAD0071DD75C2C2AA07E5686781BD3723A1305FFB5EBA785B0A50B39EA5003599591ADDAF75B20B8E5048A0B1116CD8A368D54352E73E2FC884F4DE7FE451DE05CBA147BFBDC7A82D3A24C6F5D3F0698B57522E8B4075735A1D1E6D9F531B8C977B8E0619B".substring(507, 511), Integer.valueOf(180) });
    return new y("010001", "A770028BA38DDB08252B6C41C201838553E75552DE0B8EC10DF3E2B6F641026644178D7C362912C51B8CE18682C8502C18B1ACB05A45C725E4EE4F4C8C4FE08D5C8D75FA305175D2595DF5632413E897AE5366ED1A63146B8B0AEE9D955999331B23988F7564FCA291E01E36CA3AE78116FCFDB7AB8A881B33DF687C59E3918A51F5D37C5C20401EE3CFDA007094C904ED4CCE96981548D04EDAD3EAD0071DD75C2C2AA07E5686781BD3723A1305FFB5EBA785B0A50B39EA5003599591ADDAF75B20B8E5048A0B1116CD8A368D54352E73E2FC884F4DE7FE451DE05CBA147BFBDC7A82D3A24C6F5D3F0698B57522E8B4075735A1D1E6D9F531B8C977B8E0619B", 180);
  }
  
  public static y cpi()
  {
    return new y("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
  }
  
  public static y cpj()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "A3A49624167DC4D46199771AC1B48319B57251A23A457592646E8C3E8EEE590F7205EC69668BD537D9A9BFF35694294D0841139DE3C5B9E64EB0BBF14660E6FC4C35EBD0DD291B7BE5B23AB72F84B1DE9DCB67A0E157176DC1D796D207F4E65B5FCCA8099CBCA4D1F550AA272752C0C9CC650AA32FDF4D9B46650BC7989562F9568605DC7EC49CDD3E4A498CCBDC16A1C679CE4D6CCB1871FF1D7F32D865D1F336DBFB0A09258EB42B69C09DEE45981D4B55A9C0EACB68AC22E525488202AFCF1FF6D0F18D18C29A72E6C83C5D8A55910D55B7E5E3787B6FE5BB915118817B01311130AD7F1F572FF7746E98F322AE834B0E4B68D9523BBBF6C0841ADD2309EB".substring(0, 4) + "_" + "A3A49624167DC4D46199771AC1B48319B57251A23A457592646E8C3E8EEE590F7205EC69668BD537D9A9BFF35694294D0841139DE3C5B9E64EB0BBF14660E6FC4C35EBD0DD291B7BE5B23AB72F84B1DE9DCB67A0E157176DC1D796D207F4E65B5FCCA8099CBCA4D1F550AA272752C0C9CC650AA32FDF4D9B46650BC7989562F9568605DC7EC49CDD3E4A498CCBDC16A1C679CE4D6CCB1871FF1D7F32D865D1F336DBFB0A09258EB42B69C09DEE45981D4B55A9C0EACB68AC22E525488202AFCF1FF6D0F18D18C29A72E6C83C5D8A55910D55B7E5E3787B6FE5BB915118817B01311130AD7F1F572FF7746E98F322AE834B0E4B68D9523BBBF6C0841ADD2309EB".substring(507, 511), Integer.valueOf(179) });
    return new y("010001", "A3A49624167DC4D46199771AC1B48319B57251A23A457592646E8C3E8EEE590F7205EC69668BD537D9A9BFF35694294D0841139DE3C5B9E64EB0BBF14660E6FC4C35EBD0DD291B7BE5B23AB72F84B1DE9DCB67A0E157176DC1D796D207F4E65B5FCCA8099CBCA4D1F550AA272752C0C9CC650AA32FDF4D9B46650BC7989562F9568605DC7EC49CDD3E4A498CCBDC16A1C679CE4D6CCB1871FF1D7F32D865D1F336DBFB0A09258EB42B69C09DEE45981D4B55A9C0EACB68AC22E525488202AFCF1FF6D0F18D18C29A72E6C83C5D8A55910D55B7E5E3787B6FE5BB915118817B01311130AD7F1F572FF7746E98F322AE834B0E4B68D9523BBBF6C0841ADD2309EB", 179);
  }
  
  /* Error */
  public static boolean cpl()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: new 170	java/io/FileWriter
    //   5: dup
    //   6: new 138	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 175	com/tencent/mm/compatible/util/e:bkH	Ljava/lang/String;
    //   16: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 177
    //   21: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 180	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: ldc 182
    //   36: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: new 138	java/lang/StringBuilder
    //   45: dup
    //   46: ldc 187
    //   48: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: getstatic 193	com/tencent/mm/sdk/platformtools/d:CLIENT_VERSION	Ljava/lang/String;
    //   54: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 195
    //   59: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: new 138	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 197
    //   77: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: new 199	java/text/SimpleDateFormat
    //   83: dup
    //   84: ldc 201
    //   86: invokespecial 202	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   89: new 204	java/util/Date
    //   92: dup
    //   93: invokespecial 205	java/util/Date:<init>	()V
    //   96: invokevirtual 209	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   99: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 211
    //   104: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   113: aload_2
    //   114: astore_1
    //   115: aload_2
    //   116: ldc 213
    //   118: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   121: aload_2
    //   122: astore_1
    //   123: aload_2
    //   124: ldc 215
    //   126: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: ldc 217
    //   134: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   137: aload_2
    //   138: astore_1
    //   139: aload_2
    //   140: ldc 219
    //   142: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   145: aload_2
    //   146: astore_1
    //   147: aload_2
    //   148: ldc 221
    //   150: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   153: aload_2
    //   154: astore_1
    //   155: aload_2
    //   156: ldc 223
    //   158: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   161: aload_2
    //   162: astore_1
    //   163: aload_2
    //   164: ldc 225
    //   166: invokevirtual 185	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   169: iconst_1
    //   170: istore_0
    //   171: aload_2
    //   172: invokevirtual 228	java/io/FileWriter:close	()V
    //   175: iload_0
    //   176: ireturn
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_2
    //   181: astore_1
    //   182: ldc 24
    //   184: aload_3
    //   185: ldc 89
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 232	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_2
    //   195: ifnull -20 -> 175
    //   198: aload_2
    //   199: invokevirtual 228	java/io/FileWriter:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_1
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 228	java/io/FileWriter:close	()V
    //   218: aload_2
    //   219: athrow
    //   220: astore_1
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_1
    //   224: goto -6 -> 218
    //   227: astore_2
    //   228: goto -18 -> 210
    //   231: astore_3
    //   232: goto -52 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	175	0	bool	boolean
    //   32	150	1	localFileWriter1	java.io.FileWriter
    //   204	1	1	localException1	java.lang.Exception
    //   209	6	1	localObject1	Object
    //   220	1	1	localException2	java.lang.Exception
    //   223	1	1	localException3	java.lang.Exception
    //   30	169	2	localFileWriter2	java.io.FileWriter
    //   207	12	2	localObject2	Object
    //   227	1	2	localObject3	Object
    //   177	8	3	localException4	java.lang.Exception
    //   231	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	31	177	java/lang/Exception
    //   198	202	204	java/lang/Exception
    //   2	31	207	finally
    //   171	175	220	java/lang/Exception
    //   214	218	223	java/lang/Exception
    //   33	39	227	finally
    //   41	68	227	finally
    //   70	113	227	finally
    //   115	121	227	finally
    //   123	129	227	finally
    //   131	137	227	finally
    //   139	145	227	finally
    //   147	153	227	finally
    //   155	161	227	finally
    //   163	169	227	finally
    //   182	194	227	finally
    //   33	39	231	java/lang/Exception
    //   41	68	231	java/lang/Exception
    //   70	113	231	java/lang/Exception
    //   115	121	231	java/lang/Exception
    //   123	129	231	java/lang/Exception
    //   131	137	231	java/lang/Exception
    //   139	145	231	java/lang/Exception
    //   147	153	231	java/lang/Exception
    //   155	161	231	java/lang/Exception
    //   163	169	231	java/lang/Exception
  }
  
  public final boolean cpk()
  {
    return (this.ver == 0) || (bk.bl(this.sqr)) || (bk.bl(this.sqs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.y
 * JD-Core Version:    0.7.0.1
 */