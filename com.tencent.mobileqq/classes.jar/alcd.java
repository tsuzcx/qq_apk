import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class alcd
{
  private static alcd jdField_a_of_type_Alcd = new alcd();
  private static List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  ajuc jdField_a_of_type_Ajuc = new alcf(this);
  String jdField_a_of_type_JavaLangString = null;
  
  public static alcd a()
  {
    return jdField_a_of_type_Alcd;
  }
  
  private void a(String paramString, TroopInfoData paramTroopInfoData)
  {
    QQAppInterface localQQAppInterface = a();
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", localQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("troop_uin", paramString);
    localIntent.putExtra("forward_location", paramTroopInfoData.troopLocation);
    localIntent.putExtra("forward_latitude", paramTroopInfoData.troopLat);
    localIntent.putExtra("forward_longitude", paramTroopInfoData.troopLon);
    localIntent.putExtra("forward_cityid", paramTroopInfoData.cityId);
    localIntent.putExtra("key_qidian_private_troop", paramTroopInfoData.isQidianPrivateTroop);
    paramString = TroopBaseProxyActivity.a(BaseActivity.sTopActivity);
    paramTroopInfoData = new bgno(localQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramTroopInfoData);
    }
    TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, BaseActivity.sTopActivity, localIntent, paramString, "com.tencent.mobileqq.activity.TroopManageActivity", localQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  /* Error */
  protected void a(KQQ.BatchResponse paramBatchResponse, TroopInfoData paramTroopInfoData, TroopInfo paramTroopInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 153	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 155	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 156	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: aload_1
    //   24: getfield 160	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 161	[B
    //   30: invokevirtual 165	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 168	KQQ/BatchResponse:seq	I
    //   38: ifne -27 -> 11
    //   41: aload 7
    //   43: ifnull -32 -> 11
    //   46: aload 7
    //   48: getfield 172	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 178	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq -43 -> 11
    //   57: aload 7
    //   59: getfield 172	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 182	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 188	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore_1
    //   69: new 190	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   72: dup
    //   73: invokespecial 191	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   76: astore 7
    //   78: aload 7
    //   80: aload_1
    //   81: invokevirtual 192	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   84: pop
    //   85: aload 7
    //   87: getfield 196	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   90: invokevirtual 201	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   93: astore 8
    //   95: aload 8
    //   97: ifnonnull +54 -> 151
    //   100: iconst_0
    //   101: istore 4
    //   103: goto +337 -> 440
    //   106: aload_1
    //   107: ifnonnull -96 -> 11
    //   110: iload 5
    //   112: iload 4
    //   114: if_icmpge -103 -> 11
    //   117: aload 8
    //   119: iload 5
    //   121: invokeinterface 206 2 0
    //   126: checkcast 208	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   129: astore 7
    //   131: aload 7
    //   133: ifnonnull +30 -> 163
    //   136: iload 5
    //   138: iconst_1
    //   139: iadd
    //   140: istore 5
    //   142: goto -36 -> 106
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 211	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   150: return
    //   151: aload 8
    //   153: invokeinterface 215 1 0
    //   158: istore 4
    //   160: goto +280 -> 440
    //   163: aload 7
    //   165: getfield 219	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   168: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   171: istore 6
    //   173: iload 6
    //   175: bipush 72
    //   177: if_icmpne +30 -> 207
    //   180: iload 5
    //   182: ifne +25 -> 207
    //   185: getstatic 99	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   188: ldc 224
    //   190: iconst_1
    //   191: invokestatic 229	bbmy:a	(Landroid/content/Context;II)Lbbmy;
    //   194: getstatic 99	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   197: invokevirtual 232	com/tencent/mobileqq/app/BaseActivity:getTitleBarHeight	()I
    //   200: invokevirtual 236	bbmy:b	(I)Landroid/widget/Toast;
    //   203: pop
    //   204: goto -68 -> 136
    //   207: iload 6
    //   209: ifne +228 -> 437
    //   212: aload 7
    //   214: getfield 240	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   217: invokevirtual 243	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   220: ifeq +217 -> 437
    //   223: aload 7
    //   225: getfield 240	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   228: invokevirtual 246	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   231: checkcast 242	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   234: astore 7
    //   236: aload 7
    //   238: astore_1
    //   239: aload 7
    //   241: ifnull -105 -> 136
    //   244: aload 7
    //   246: astore_1
    //   247: aload_2
    //   248: ifnull -112 -> 136
    //   251: aload_2
    //   252: aload 7
    //   254: invokevirtual 250	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   257: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +78 -> 338
    //   263: aload 7
    //   265: getfield 258	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   268: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   271: istore 6
    //   273: new 260	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 263
    //   283: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: astore 9
    //   288: aload_2
    //   289: ifnonnull +140 -> 429
    //   292: ldc_w 269
    //   295: astore_1
    //   296: ldc_w 271
    //   299: iconst_2
    //   300: aload 9
    //   302: aload_1
    //   303: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 273
    //   309: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: iload 6
    //   314: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: ldc_w 278
    //   320: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 6
    //   325: i2l
    //   326: invokestatic 283	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   329: invokevirtual 286	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   332: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_3
    //   339: ifnull +17 -> 356
    //   342: aload_3
    //   343: aload 7
    //   345: invokevirtual 294	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   348: aload_2
    //   349: aload_3
    //   350: invokevirtual 297	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   353: putfield 300	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   356: aload_2
    //   357: aload 7
    //   359: getfield 258	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   362: invokevirtual 223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   365: i2l
    //   366: invokestatic 283	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   369: putfield 90	com/tencent/mobileqq/troopinfo/TroopInfoData:isQidianPrivateTroop	Z
    //   372: aload 7
    //   374: astore_1
    //   375: aload_3
    //   376: ifnull -240 -> 136
    //   379: aload 7
    //   381: astore_1
    //   382: aload_2
    //   383: getfield 303	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   386: ifeq -250 -> 136
    //   389: new 305	com/tencent/mobileqq/ark/API/TroopArkHelper$3
    //   392: dup
    //   393: aload_0
    //   394: aload_3
    //   395: invokespecial 308	com/tencent/mobileqq/ark/API/TroopArkHelper$3:<init>	(Lalcd;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   398: iconst_5
    //   399: aconst_null
    //   400: iconst_0
    //   401: invokestatic 314	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   404: aload 7
    //   406: astore_1
    //   407: goto -271 -> 136
    //   410: astore_1
    //   411: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -403 -> 11
    //   417: ldc_w 316
    //   420: iconst_2
    //   421: aload_1
    //   422: invokevirtual 317	java/lang/Exception:toString	()Ljava/lang/String;
    //   425: invokestatic 320	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: return
    //   429: aload_2
    //   430: getfield 323	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   433: astore_1
    //   434: goto -138 -> 296
    //   437: goto -301 -> 136
    //   440: aconst_null
    //   441: astore_1
    //   442: iconst_0
    //   443: istore 5
    //   445: goto -339 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	alcd
    //   0	448	1	paramBatchResponse	KQQ.BatchResponse
    //   0	448	2	paramTroopInfoData	TroopInfoData
    //   0	448	3	paramTroopInfo	TroopInfo
    //   101	58	4	i	int
    //   110	334	5	j	int
    //   171	153	6	k	int
    //   19	386	7	localObject	Object
    //   93	59	8	localList	List
    //   286	15	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   21	34	145	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   69	95	410	java/lang/Exception
    //   117	131	410	java/lang/Exception
    //   151	160	410	java/lang/Exception
    //   163	173	410	java/lang/Exception
    //   185	204	410	java/lang/Exception
    //   212	236	410	java/lang/Exception
    //   251	288	410	java/lang/Exception
    //   296	338	410	java/lang/Exception
    //   342	356	410	java/lang/Exception
    //   356	372	410	java/lang/Exception
    //   382	404	410	java/lang/Exception
    //   429	434	410	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("gc");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("ark.Troop", 1, "troopUin empty!");
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ark.Troop", 1, "json error!", paramString);
      paramString = a();
      TroopPluginManager localTroopPluginManager = (TroopPluginManager)paramString.getManager(119);
      TroopInfo localTroopInfo = ((TroopManager)paramString.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
      {
        localTroopPluginManager.a("troop_manage_plugin.apk", new alce(this, paramString));
        return;
      }
      bbmy.a(BaseApplicationImpl.getContext(), 1, ajjy.a(2131649405), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alcd
 * JD-Core Version:    0.7.0.1
 */