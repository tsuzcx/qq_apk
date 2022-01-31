import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ClubContentUpdateHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajtu
  extends ajtd
{
  bbwf jdField_a_of_type_Bbwf = new ajtv(this);
  private bbwi jdField_a_of_type_Bbwi;
  public QQAppInterface a;
  
  public ajtu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramString, paramInt1, "", paramInt2, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
    }
    bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + paramString, paramInt1);
  }
  
  private void a(int paramInt, bbnu parambbnu)
  {
    if (Math.abs(paramInt - bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambbnu.d)) > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
      }
      if (this.jdField_a_of_type_Bbwi == null) {
        this.jdField_a_of_type_Bbwi = ((bbwi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47));
      }
      File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getFilesDir(), parambbnu.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("version", paramInt);
      localBundle.putString("json_name", parambbnu.d);
      parambbnu = new bbwg(parambbnu.b, localFile);
      this.jdField_a_of_type_Bbwi.a(1).a(parambbnu, this.jdField_a_of_type_Bbwf, localBundle);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localReqBody.int_protocolver.set(1);
      localReqBody.uint_clientplatid.set(109);
      localReqBody.str_clientver.set("8.2.8.4440");
      localReqBody.uint_uin.set(Long.parseLong((String)localObject1));
      ArrayList localArrayList1 = new ArrayList();
      int i = paramQQAppInterface.getApp().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
      ArrayList localArrayList2 = new ArrayList();
      Object localObject2 = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).str_name.set("signature_json");
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject2).uint_version.set(i);
      localArrayList2.add(localObject2);
      localObject2 = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).uint_appid.set(8);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject2).rpt_msg_reqiteminfo.set(localArrayList2);
      localArrayList1.add(localObject2);
      localReqBody.rpt_msg_reqappinfo.set(localArrayList1);
      localObject1 = new ToServiceMsg("mobileqq.service", (String)localObject1, "ClubContentUpdate.Req");
      ((ToServiceMsg)localObject1).putWupBuffer(localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      paramQQAppInterface.sendToService((ToServiceMsg)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if (paramString1.equals(bbnq.d.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
      }
      a(paramInt1, bbnq.d, paramBoolean);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString1.equals(bbnq.a.e)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
          }
          paramInt2 = bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.a.d);
        } while (paramInt1 <= paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        bbnq.a(MobileQQ.getContext(), bbnq.a.d, paramInt2);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
        ((ajvp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a();
        paramString1.edit().putLong("last_get_recommendemotion_time_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), System.currentTimeMillis()).commit();
        return;
        if (!paramString1.contains("_json")) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, name.contains(EmosmConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
        }
      } while (!anzm.a(paramInt2));
      ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).b(paramString1.replace("_json", "").trim(), paramInt1, paramString2, paramInt2, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, update emoji package!");
      }
      ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramString1, paramInt1, paramString2, paramInt2, 0);
      paramMap.put(paramString1, Integer.valueOf(paramInt2));
    } while (!QLog.isColorLevel());
    QLog.d("ClubContentUpdateHandler", 2, "emotion has update info.");
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("group_domain")) && (paramJSONObject.has("group_strategy"))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        String str = paramJSONObject.getString("group_domain");
        paramJSONObject = paramJSONObject.getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("ClubContentUpdateHandler", 2, "cdnCacheConfig, domain: " + str + ", strategys: " + paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        do
        {
          paramJSONObject.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.w("ClubContentUpdateHandler", 2, "", paramJSONObject);
        return;
      }
    }
    QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
  }
  
  private boolean a(int paramInt, bbnu parambbnu, boolean paramBoolean)
  {
    int i = bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambbnu.d);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + parambbnu.e + " localVersion = " + i + " version = " + paramInt);
    }
    if (paramInt > i)
    {
      bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambbnu, paramInt, paramBoolean);
      return true;
    }
    return false;
  }
  
  private void b() {}
  
  private void g(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals(bbnq.b.e)) {}
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a()
  {
    Object localObject = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag);
        }
        if ((localEmoticonPackage.jobType == 4) && (localEmoticonPackage.status == 2) && (!anzm.b(localEmoticonPackage.updateFlag)))
        {
          ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
        }
      }
    }
    localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(10);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
    ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
    return localObject;
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo a(bbnu parambbnu, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(parambbnu.e);
    localReqItemInfo.uint_version.set(bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambbnu.d));
    localArrayList.add(localReqItemInfo);
    parambbnu = new ClubContentUpdateInfoPb.ReqAppInfo();
    parambbnu.uint_appid.set(paramInt);
    parambbnu.rpt_msg_reqiteminfo.set(localArrayList);
    parambbnu.setHasFlag(true);
    return parambbnu;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    ClubContentUpdateInfoPb.ReqBody localReqBody = new ClubContentUpdateInfoPb.ReqBody();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localReqBody.int_protocolver.set(1);
    localReqBody.uint_clientplatid.set(109);
    localReqBody.str_clientver.set("8.2.8.4440");
    localReqBody.uint_uin.set(Long.parseLong((String)localObject));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b());
    localArrayList.add(a());
    localArrayList.add(c());
    localArrayList.add(b(bbnq.c, 7));
    localArrayList.add(a(bbnq.e, 105));
    localArrayList.add(b(bbnq.f, 11));
    localArrayList.add(b(bbnq.h, 113));
    localArrayList.add(b(bbnq.i, 5));
    localReqBody.rpt_msg_reqappinfo.set(localArrayList);
    localReqBody.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "ClubContentUpdate.Req");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - l) + "ms");
    }
  }
  
  public void a(Context paramContext)
  {
    int i = 0;
    Object localObject = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("data");
        if (i >= ((JSONArray)localObject).length()) {
          continue;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        String str = localJSONObject.getString("filename");
        if (!bbnq.e.a.equals(str)) {
          break label168;
        }
        localObject = localJSONObject.getString("version");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + paramContext.toString());
        return;
        i = -1;
        if (i != -1) {
          continue;
        }
      }
      if (bbnq.a(paramContext, bbnq.e.d) != i)
      {
        a(i, bbnq.e);
        return;
      }
      label167:
      return;
      label168:
      i += 1;
    }
  }
  
  /* Error */
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 44
    //   8: iconst_2
    //   9: ldc_w 601
    //   12: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: invokestatic 556	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   18: ldc_w 558
    //   21: iconst_0
    //   22: invokevirtual 216	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   25: invokeinterface 327 1 0
    //   30: ldc_w 560
    //   33: aload_2
    //   34: invokeinterface 604 3 0
    //   39: invokeinterface 347 1 0
    //   44: pop
    //   45: new 393	org/json/JSONObject
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 565	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: ldc_w 567
    //   56: invokevirtual 571	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   59: astore_2
    //   60: iconst_0
    //   61: istore_3
    //   62: aload_2
    //   63: invokevirtual 576	org/json/JSONArray:length	()I
    //   66: istore 4
    //   68: iload_3
    //   69: iload 4
    //   71: if_icmpge +1194 -> 1265
    //   74: aload_2
    //   75: iload_3
    //   76: invokevirtual 580	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   79: astore 9
    //   81: aload 9
    //   83: ldc 122
    //   85: invokevirtual 606	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   88: istore 4
    //   90: aload 9
    //   92: ldc_w 608
    //   95: invokevirtual 606	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   98: istore 5
    //   100: aload 9
    //   102: ldc_w 582
    //   105: invokevirtual 403	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 9
    //   110: aload 9
    //   112: ifnonnull +1154 -> 1266
    //   115: return
    //   116: getstatic 531	bbnq:e	Lbbnu;
    //   119: getfield 297	bbnu:e	Ljava/lang/String;
    //   122: aload 9
    //   124: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +1276 -> 1403
    //   130: aload_0
    //   131: iload 4
    //   133: getstatic 531	bbnq:e	Lbbnu;
    //   136: invokespecial 593	ajtu:a	(ILbbnu;)V
    //   139: goto +1264 -> 1403
    //   142: aload_1
    //   143: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   146: invokevirtual 60	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   149: new 62	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   156: ldc 67
    //   158: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 9
    //   163: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 89	bbnq:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   172: istore 5
    //   174: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +52 -> 229
    //   180: ldc 44
    //   182: iconst_4
    //   183: new 62	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 610
    //   193: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 9
    //   198: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 612
    //   204: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload 4
    //   209: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 614
    //   215: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iload 5
    //   231: iload 4
    //   233: if_icmpge -117 -> 116
    //   236: aload_0
    //   237: iload 4
    //   239: iconst_1
    //   240: aload 9
    //   242: invokespecial 616	ajtu:a	(IILjava/lang/String;)V
    //   245: goto -129 -> 116
    //   248: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq +12 -> 263
    //   254: ldc 44
    //   256: iconst_2
    //   257: ldc_w 618
    //   260: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_0
    //   264: aload 9
    //   266: iload 4
    //   268: ldc 33
    //   270: iconst_1
    //   271: new 620	java/util/HashMap
    //   274: dup
    //   275: invokespecial 621	java/util/HashMap:<init>	()V
    //   278: iconst_1
    //   279: invokespecial 623	ajtu:a	(Ljava/lang/String;ILjava/lang/String;ILjava/util/Map;Z)V
    //   282: goto -166 -> 116
    //   285: getstatic 527	bbnq:c	Lbbnu;
    //   288: getfield 297	bbnu:e	Ljava/lang/String;
    //   291: aload 9
    //   293: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq -180 -> 116
    //   299: aload_0
    //   300: iload 4
    //   302: getstatic 527	bbnq:c	Lbbnu;
    //   305: iconst_1
    //   306: invokespecial 307	ajtu:a	(ILbbnu;Z)Z
    //   309: pop
    //   310: goto -194 -> 116
    //   313: ldc 44
    //   315: iconst_1
    //   316: new 62	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 625
    //   326: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 9
    //   331: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 627
    //   337: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: iload 4
    //   342: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_1
    //   352: sipush 153
    //   355: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   358: checkcast 629	airz
    //   361: astore 10
    //   363: aload_1
    //   364: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   367: invokestatic 632	airz:a	(Landroid/content/Context;)Z
    //   370: ifeq +43 -> 413
    //   373: aload 10
    //   375: ifnull +38 -> 413
    //   378: iconst_1
    //   379: aload 10
    //   381: aload_1
    //   382: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   385: invokevirtual 634	airz:b	(Ljava/lang/String;)I
    //   388: if_icmpne +25 -> 413
    //   391: ldc_w 636
    //   394: aload 9
    //   396: invokestatic 639	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   399: ifeq -283 -> 116
    //   402: aload_0
    //   403: aload 9
    //   405: iload 4
    //   407: invokevirtual 641	ajtu:a	(Ljava/lang/String;I)V
    //   410: goto -294 -> 116
    //   413: ldc 44
    //   415: iconst_1
    //   416: ldc_w 643
    //   419: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: goto -306 -> 116
    //   425: ldc 44
    //   427: iconst_1
    //   428: new 62	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 645
    //   438: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 9
    //   443: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc_w 627
    //   449: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: iload 4
    //   454: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   463: aconst_null
    //   464: aload_1
    //   465: iload 4
    //   467: iconst_0
    //   468: invokestatic 650	ajjt:a	(Lajjt;Lcom/tencent/common/app/AppInterface;IZ)V
    //   471: goto -355 -> 116
    //   474: ldc 44
    //   476: iconst_1
    //   477: new 62	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 652
    //   487: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 9
    //   492: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 654
    //   498: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: iload 4
    //   503: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_1
    //   513: sipush 153
    //   516: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   519: checkcast 629	airz
    //   522: astore 10
    //   524: aload_1
    //   525: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   528: invokestatic 632	airz:a	(Landroid/content/Context;)Z
    //   531: ifeq +141 -> 672
    //   534: aload 10
    //   536: ifnull +136 -> 672
    //   539: iconst_1
    //   540: aload 10
    //   542: aload_1
    //   543: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   546: invokevirtual 634	airz:b	(Ljava/lang/String;)I
    //   549: if_icmpne +123 -> 672
    //   552: aload 9
    //   554: invokestatic 591	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   557: istore 5
    //   559: aload 10
    //   561: iconst_1
    //   562: iload 5
    //   564: invokevirtual 657	airz:a	(II)J
    //   567: ldc2_w 658
    //   570: ldiv
    //   571: lstore 6
    //   573: lload 6
    //   575: iload 4
    //   577: i2l
    //   578: lcmp
    //   579: ifeq -463 -> 116
    //   582: aload_1
    //   583: aload_1
    //   584: invokevirtual 158	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   587: aconst_null
    //   588: iload 5
    //   590: aconst_null
    //   591: iconst_m1
    //   592: iconst_m1
    //   593: iconst_1
    //   594: invokestatic 664	ajhw:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lajie;I[IIIZ)V
    //   597: ldc 44
    //   599: iconst_1
    //   600: new 62	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 666
    //   610: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 9
    //   615: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: ldc_w 668
    //   621: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: lload 6
    //   626: invokevirtual 550	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   629: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: goto -519 -> 116
    //   638: astore 10
    //   640: ldc 44
    //   642: iconst_2
    //   643: new 62	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 670
    //   653: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 9
    //   658: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: aload 10
    //   666: invokestatic 672	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   669: goto -553 -> 116
    //   672: ldc 44
    //   674: iconst_1
    //   675: ldc_w 674
    //   678: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: goto -565 -> 116
    //   684: ldc 44
    //   686: iconst_1
    //   687: new 62	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 676
    //   697: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 9
    //   702: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 654
    //   708: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: iload 4
    //   713: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: aload_1
    //   723: sipush 153
    //   726: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   729: checkcast 629	airz
    //   732: astore 10
    //   734: aload_1
    //   735: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   738: invokestatic 632	airz:a	(Landroid/content/Context;)Z
    //   741: ifeq -625 -> 116
    //   744: aload 10
    //   746: ifnull -630 -> 116
    //   749: iconst_1
    //   750: aload 10
    //   752: aload_1
    //   753: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   756: invokevirtual 634	airz:b	(Ljava/lang/String;)I
    //   759: if_icmpne -643 -> 116
    //   762: aload 9
    //   764: invokestatic 591	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   767: istore 5
    //   769: aload 10
    //   771: iconst_2
    //   772: iload 5
    //   774: invokevirtual 657	airz:a	(II)J
    //   777: ldc2_w 658
    //   780: ldiv
    //   781: lstore 6
    //   783: lload 6
    //   785: iload 4
    //   787: i2l
    //   788: lcmp
    //   789: ifeq -673 -> 116
    //   792: aload_1
    //   793: aload_1
    //   794: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   797: aconst_null
    //   798: iconst_m1
    //   799: iconst_1
    //   800: newarray int
    //   802: dup
    //   803: iconst_0
    //   804: iload 5
    //   806: iastore
    //   807: iconst_m1
    //   808: iconst_m1
    //   809: iconst_1
    //   810: invokestatic 678	ajhw:b	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Lajie;I[IIIZ)V
    //   813: ldc 44
    //   815: iconst_1
    //   816: new 62	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 680
    //   826: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: iload 5
    //   831: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc_w 668
    //   837: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: lload 6
    //   842: invokevirtual 550	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   845: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: goto -735 -> 116
    //   854: astore 10
    //   856: ldc 44
    //   858: iconst_2
    //   859: new 62	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 682
    //   869: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 9
    //   874: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: aload 10
    //   882: invokestatic 672	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   885: goto -769 -> 116
    //   888: invokestatic 686	akvj:a	()Ljava/lang/String;
    //   891: aload 9
    //   893: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   896: ifeq -780 -> 116
    //   899: aload_1
    //   900: sipush 153
    //   903: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   906: checkcast 629	airz
    //   909: astore 10
    //   911: aload_1
    //   912: invokevirtual 208	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   915: invokestatic 632	airz:a	(Landroid/content/Context;)Z
    //   918: ifeq +149 -> 1067
    //   921: aload 10
    //   923: ifnull +144 -> 1067
    //   926: iconst_1
    //   927: aload 10
    //   929: aload_1
    //   930: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   933: invokevirtual 634	airz:b	(Ljava/lang/String;)I
    //   936: if_icmpne +131 -> 1067
    //   939: aload_1
    //   940: bipush 115
    //   942: invokevirtual 319	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajtd;
    //   945: checkcast 684	akvj
    //   948: ifnull -832 -> 116
    //   951: invokestatic 688	akvj:b	()J
    //   954: lstore 6
    //   956: lload 6
    //   958: iload 4
    //   960: i2l
    //   961: lcmp
    //   962: ifeq +64 -> 1026
    //   965: new 62	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   972: getstatic 693	ajmu:av	Ljava/lang/String;
    //   975: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: ldc_w 695
    //   981: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: astore 10
    //   989: new 119	android/os/Bundle
    //   992: dup
    //   993: invokespecial 120	android/os/Bundle:<init>	()V
    //   996: astore 11
    //   998: aload 11
    //   1000: ldc 122
    //   1002: iload 4
    //   1004: i2l
    //   1005: invokevirtual 698	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1008: aload_1
    //   1009: aload 10
    //   1011: getstatic 701	ajmu:at	Ljava/lang/String;
    //   1014: aload 11
    //   1016: new 703	akvl
    //   1019: dup
    //   1020: invokespecial 704	akvl:<init>	()V
    //   1023: invokestatic 707	ajhw:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lbbwf;)V
    //   1026: ldc 44
    //   1028: iconst_1
    //   1029: new 62	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 709
    //   1039: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: iload 4
    //   1044: invokevirtual 425	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1047: ldc_w 711
    //   1050: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: lload 6
    //   1055: invokevirtual 550	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1058: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1061: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1064: goto -948 -> 116
    //   1067: ldc 44
    //   1069: iconst_1
    //   1070: ldc_w 713
    //   1073: invokestatic 100	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: goto -960 -> 116
    //   1079: getstatic 479	bbnq:b	Lbbnu;
    //   1082: getfield 297	bbnu:e	Ljava/lang/String;
    //   1085: aload 9
    //   1087: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1090: ifeq -974 -> 116
    //   1093: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1096: ifeq -980 -> 116
    //   1099: ldc 44
    //   1101: iconst_2
    //   1102: ldc_w 715
    //   1105: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1108: goto -992 -> 116
    //   1111: getstatic 539	bbnq:h	Lbbnu;
    //   1114: getfield 297	bbnu:e	Ljava/lang/String;
    //   1117: aload 9
    //   1119: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1122: ifeq -1006 -> 116
    //   1125: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1128: ifeq +12 -> 1140
    //   1131: ldc 44
    //   1133: iconst_2
    //   1134: ldc_w 717
    //   1137: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1140: aload_0
    //   1141: iload 4
    //   1143: getstatic 539	bbnq:h	Lbbnu;
    //   1146: iconst_1
    //   1147: invokespecial 307	ajtu:a	(ILbbnu;Z)Z
    //   1150: pop
    //   1151: goto -1035 -> 116
    //   1154: getstatic 541	bbnq:i	Lbbnu;
    //   1157: getfield 297	bbnu:e	Ljava/lang/String;
    //   1160: aload 9
    //   1162: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1165: ifeq -1049 -> 116
    //   1168: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1171: ifeq +12 -> 1183
    //   1174: ldc 44
    //   1176: iconst_2
    //   1177: ldc_w 719
    //   1180: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1183: aload_0
    //   1184: iload 4
    //   1186: getstatic 541	bbnq:i	Lbbnu;
    //   1189: iconst_1
    //   1190: invokespecial 307	ajtu:a	(ILbbnu;Z)Z
    //   1193: pop
    //   1194: goto -1078 -> 116
    //   1197: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1200: ifeq +30 -> 1230
    //   1203: ldc 44
    //   1205: iconst_2
    //   1206: new 62	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 721
    //   1216: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: aload 9
    //   1221: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: aload 9
    //   1232: ldc_w 723
    //   1235: invokevirtual 302	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1238: istore 8
    //   1240: iload 8
    //   1242: ifeq -1126 -> 116
    //   1245: goto -1129 -> 116
    //   1248: astore_1
    //   1249: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1252: ifeq +13 -> 1265
    //   1255: ldc 44
    //   1257: iconst_2
    //   1258: ldc_w 725
    //   1261: aload_1
    //   1262: invokestatic 727	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1265: return
    //   1266: iload 5
    //   1268: lookupswitch	default:+132->1400, 1:+-1020->248, 2:+-1152->116, 3:+-1152->116, 5:+-114->1154, 7:+-983->285, 10:+-1126->142, 18:+-1152->116, 113:+-157->1111, 201:+-955->313, 202:+-794->474, 203:+-584->684, 205:+-843->425, 206:+-380->888, 302:+-71->1197, 401:+-189->1079
    //   1401: <illegal opcode>
    //   1402: <illegal opcode>
    //   1403: iload_3
    //   1404: iconst_1
    //   1405: iadd
    //   1406: istore_3
    //   1407: goto -1345 -> 62
    //   1410: astore 9
    //   1412: goto -9 -> 1403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1415	0	this	ajtu
    //   0	1415	1	paramQQAppInterface	QQAppInterface
    //   0	1415	2	paramString	String
    //   61	1346	3	i	int
    //   66	1119	4	j	int
    //   98	1169	5	k	int
    //   571	483	6	l	long
    //   1238	3	8	bool	boolean
    //   79	1152	9	localObject1	Object
    //   1410	1	9	localException1	Exception
    //   361	199	10	localairz1	airz
    //   638	27	10	localException2	Exception
    //   732	38	10	localairz2	airz
    //   854	27	10	localException3	Exception
    //   909	101	10	localObject2	Object
    //   996	19	11	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   474	534	638	java/lang/Exception
    //   539	573	638	java/lang/Exception
    //   582	635	638	java/lang/Exception
    //   672	681	638	java/lang/Exception
    //   684	744	854	java/lang/Exception
    //   749	783	854	java/lang/Exception
    //   792	851	854	java/lang/Exception
    //   45	60	1248	java/lang/Exception
    //   62	68	1248	java/lang/Exception
    //   74	110	1410	java/lang/Exception
    //   116	139	1410	java/lang/Exception
    //   142	229	1410	java/lang/Exception
    //   236	245	1410	java/lang/Exception
    //   248	263	1410	java/lang/Exception
    //   263	282	1410	java/lang/Exception
    //   285	310	1410	java/lang/Exception
    //   313	373	1410	java/lang/Exception
    //   378	410	1410	java/lang/Exception
    //   413	422	1410	java/lang/Exception
    //   425	471	1410	java/lang/Exception
    //   640	669	1410	java/lang/Exception
    //   856	885	1410	java/lang/Exception
    //   888	921	1410	java/lang/Exception
    //   926	956	1410	java/lang/Exception
    //   965	1026	1410	java/lang/Exception
    //   1026	1064	1410	java/lang/Exception
    //   1067	1076	1410	java/lang/Exception
    //   1079	1108	1410	java/lang/Exception
    //   1111	1140	1410	java/lang/Exception
    //   1140	1151	1410	java/lang/Exception
    //   1154	1183	1410	java/lang/Exception
    //   1183	1194	1410	java/lang/Exception
    //   1197	1230	1410	java/lang/Exception
    //   1230	1240	1410	java/lang/Exception
  }
  
  protected void a(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (str1.equals(bbnq.h.e)) {
        a(i, bbnq.h, false);
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        paramToServiceMsg = new ClubContentUpdateInfoPb.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.int_result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + paramToServiceMsg.int_result.get());
          }
          b();
          return;
        }
        paramToServiceMsg = ((ArrayList)paramToServiceMsg.rpt_msg_rspappinfo.get()).iterator();
        if (!paramToServiceMsg.hasNext()) {
          break label326;
        }
        paramFromServiceMsg = (ClubContentUpdateInfoPb.RspAppInfo)paramToServiceMsg.next();
        switch (paramFromServiceMsg.uint_appid.get())
        {
        case 2: 
        case 3: 
        case 9: 
        case 18: 
        case 1: 
          e(paramFromServiceMsg);
          break;
        case 10: 
          d(paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      continue;
      c(paramFromServiceMsg);
      continue;
      b(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      g(paramFromServiceMsg);
      continue;
      a(paramFromServiceMsg);
      continue;
      f(paramFromServiceMsg);
      continue;
      c(paramFromServiceMsg);
      continue;
      label326:
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ClubContentUpdateHandler.1(this, paramInt, paramString));
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b()
  {
    Object localObject = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "BigEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        }
        if ((localEmoticonPackage.jobType == 0) && (localEmoticonPackage.status == 2) && (!anzm.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label378;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label378:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqItemInfo();
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).str_name.set(bbnq.d.e);
      ((ClubContentUpdateInfoPb.ReqItemInfo)localObject).uint_version.set(bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.d.d));
      localArrayList.add(localObject);
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo b(bbnu parambbnu, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
    localReqItemInfo.str_name.set(parambbnu.e);
    localReqItemInfo.uint_version.set(bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), parambbnu.d));
    localArrayList.add(localReqItemInfo);
    parambbnu = new ClubContentUpdateInfoPb.ReqAppInfo();
    parambbnu.uint_appid.set(paramInt);
    parambbnu.rpt_msg_reqiteminfo.set(localArrayList);
    parambbnu.setHasFlag(true);
    return parambbnu;
  }
  
  protected void b(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    Object localObject = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    paramRspAppInfo = new StringBuilder(((ArrayList)localObject).size() * 64);
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)((Iterator)localObject).next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        paramRspAppInfo.append("name=").append(str1).append(", version=").append(i).append(", updateFlag=").append(j).append(", extStr=").append(str2);
      }
      if ((str1.equals(bbnq.e.e)) && (i > bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.e.d))) {
        a(i, bbnq.e);
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramRspAppInfo.toString()))) {
      QLog.d("ClubContentUpdateHandler", 2, paramRspAppInfo.toString());
    }
  }
  
  protected ClubContentUpdateInfoPb.ReqAppInfo c()
  {
    Object localObject = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(0);
    ArrayList localArrayList = new ArrayList();
    ClubContentUpdateInfoPb.ReqItemInfo localReqItemInfo;
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + localEmoticonPackage.epId + "status=" + localEmoticonPackage.status + "jobType=" + localEmoticonPackage.jobType + "updateFlag=" + localEmoticonPackage.updateFlag + "localVersion=" + localEmoticonPackage.localVersion);
        if ((localEmoticonPackage.jobType == 3) && (localEmoticonPackage.status == 2) && (!anzm.b(localEmoticonPackage.updateFlag)))
        {
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId);
          localReqItemInfo.uint_version.set(localEmoticonPackage.localVersion);
          localArrayList.add(localReqItemInfo);
          localReqItemInfo = new ClubContentUpdateInfoPb.ReqItemInfo();
          localReqItemInfo.str_name.set(localEmoticonPackage.epId + "_json");
          i = localEmoticonPackage.jsonVersion;
          if (i != 0) {
            break label320;
          }
          i = localEmoticonPackage.localVersion;
        }
      }
    }
    label320:
    for (;;)
    {
      localReqItemInfo.uint_version.set(i);
      localArrayList.add(localReqItemInfo);
      break;
      localObject = new ClubContentUpdateInfoPb.ReqAppInfo();
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).uint_appid.set(1);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).rpt_msg_reqiteminfo.set(localArrayList);
      ((ClubContentUpdateInfoPb.ReqAppInfo)localObject).setHasFlag(true);
      return localObject;
    }
  }
  
  protected void c(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
        }
        if (str1.equals(bbnq.c.e))
        {
          if (i > bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.c.d)) {
            bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bbnq.c, i, false);
          }
        }
        else if (str1.equals(bbnq.f.e))
        {
          if (i > bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.f.d)) {
            bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bbnq.f, i, false);
          }
        }
        else if (str1.equals(bbnq.i.e))
        {
          j = bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bbnq.i.d);
          if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i + " localVersion = " + j);
          }
          if (i > j) {
            bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bbnq.i, i, false);
          }
        }
      }
    }
  }
  
  protected void d(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
    }
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      int j = localRspItemInfo.uint_update_flag.get();
      int k = bbnq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + j + ",version" + i + ",localVersion:" + k);
      }
      if (k < i) {
        a(i, j, str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
    }
  }
  
  protected void e(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
    paramRspAppInfo = (ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramRspAppInfo.iterator();
    while (localIterator.hasNext())
    {
      paramRspAppInfo = (ClubContentUpdateInfoPb.RspItemInfo)localIterator.next();
      String str1 = paramRspAppInfo.str_name.get();
      int i = paramRspAppInfo.uint_version.get();
      String str2 = paramRspAppInfo.str_extend.get();
      int j = paramRspAppInfo.uint_update_flag.get();
      String[] arrayOfString = str2.split("\\|\\|");
      paramRspAppInfo = "";
      if (arrayOfString.length > 0) {
        paramRspAppInfo = arrayOfString[0];
      }
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "name=" + str1 + ", version=" + i + ", tip=" + paramRspAppInfo + ", updateFlag=" + j + ",extStr=" + str2);
      }
      a(str1, i, paramRspAppInfo, j, localHashMap, false);
    }
  }
  
  protected void f(ClubContentUpdateInfoPb.RspAppInfo paramRspAppInfo)
  {
    paramRspAppInfo = ((ArrayList)paramRspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
    while (paramRspAppInfo.hasNext())
    {
      ClubContentUpdateInfoPb.RspItemInfo localRspItemInfo = (ClubContentUpdateInfoPb.RspItemInfo)paramRspAppInfo.next();
      String str1 = localRspItemInfo.str_name.get();
      int i = localRspItemInfo.uint_version.get();
      String str2 = localRspItemInfo.str_extend.get();
      int j = localRspItemInfo.uint_update_flag.get();
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str1 + ", version=" + i + ", updateFlag=" + j + ",extStr=" + str2);
      }
      if (!str1.equals("individuation_mainpage_config2")) {}
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("ClubContentUpdate.Req".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtu
 * JD-Core Version:    0.7.0.1
 */