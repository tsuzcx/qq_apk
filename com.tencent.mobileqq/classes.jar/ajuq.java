import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pb.unite.search.DynamicAssociationWord.AssociationItem;
import pb.unite.search.DynamicAssociationWord.ReqBody;
import pb.unite.search.DynamicAssociationWord.RspBody;
import pb.unite.search.DynamicAssociationWord.SuggestUrlItem;
import pb.unite.search.DynamicBusinessHotWord.ClueWordItem;
import pb.unite.search.DynamicBusinessHotWord.GroupID;
import pb.unite.search.DynamicBusinessHotWord.GroupWord;
import pb.unite.search.DynamicBusinessHotWord.HotWordItem;
import pb.unite.search.DynamicBusinessHotWord.ReqBody;
import pb.unite.search.DynamicBusinessHotWord.RspBody;
import pb.unite.search.DynamicDiscovery.ReqBody;
import pb.unite.search.DynamicDiscovery.RspBody;
import pb.unite.search.DynamicKdReport.ReqBody;
import pb.unite.search.DynamicSearch.ExtensionRequestInfo;
import pb.unite.search.DynamicSearch.RootSearcherRequest;
import pb.unite.search.DynamicTabSearch.ReqBody;
import pb.unite.search.DynamicTabSearch.RspBody;
import pb.unite.search.RequestSearchWord.ReqBody;
import pb.unite.search.RequestSearchWord.RspBody;
import pb.unite.search.RequestSearchWord.SearchKeywords;
import pb.unite.search.UniteSearch.ReqBody;
import pb.unite.search.UniteSearch.RspBody;
import pb.unite.search.UniteSearch.TabItemGroup;

public class ajuq
  extends ajfb
{
  public static String a;
  public static long[] a;
  public static String b;
  public static long[] b;
  public static String c;
  public static long[] c;
  private ajur a;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[] { 1001L, 1002L, 1003L, 1005L, 2073745984L, 1006L };
    jdField_b_of_type_ArrayOfLong = new long[] { 1004L };
    jdField_c_of_type_ArrayOfLong = new long[] { 2073745984L, 1073745984L, 1001L, 1002L, 1003L, 1005L, 1006L };
    jdField_a_of_type_JavaLangString = "hot_word_for_sub_business";
    jdField_b_of_type_JavaLangString = "hot_word_for_sub_business_req_time";
    jdField_c_of_type_JavaLangString = "hot_word_for_sub_business_exprire_time";
  }
  
  public ajuq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  private List<BusinessGroupWord> a(List<DynamicBusinessHotWord.GroupWord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    avhs.a.clear();
    avhs.b.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (DynamicBusinessHotWord.GroupWord)localIterator.next();
      ArrayList localArrayList2 = new ArrayList(paramList.size());
      avmq localavmq = new avmq(((DynamicBusinessHotWord.GroupID)((DynamicBusinessHotWord.GroupWord)localObject1).group_id.get()).rpt_group_mask.get());
      Object localObject2 = ((DynamicBusinessHotWord.GroupWord)localObject1).rpt_hot_word_items.get();
      new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DynamicBusinessHotWord.HotWordItem localHotWordItem = (DynamicBusinessHotWord.HotWordItem)((Iterator)localObject2).next();
        localArrayList2.add(new avmr(localHotWordItem.word_id.get().toStringUtf8(), localHotWordItem.word.get().toStringUtf8()));
      }
      avhs.a.put(avhs.a(localavmq.a), localArrayList2);
      localObject2 = (DynamicBusinessHotWord.ClueWordItem)((DynamicBusinessHotWord.GroupWord)localObject1).clue_word_item.get();
      localObject1 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word_id.get().toStringUtf8();
      localObject2 = ((DynamicBusinessHotWord.ClueWordItem)localObject2).word.get().toStringUtf8();
      localObject1 = new avmp((String)localObject1, (String)localObject2);
      avhs.b.put(avhs.a(localavmq.a), localObject2);
      localArrayList1.add(new BusinessGroupWord(localavmq, localArrayList2, (avmp)localObject1));
    }
    return localArrayList1;
  }
  
  private void a(int paramInt, Object paramObject, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "code=" + paramInt + " fileName=" + paramString1 + " key=" + paramString2 + " data=" + paramObject);
    }
    if (paramInt == 1000)
    {
      ThreadManager.post(new UniteSearchHandler.1(this, paramString1, paramObject), 5, null, true);
      BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putString(paramString2, System.currentTimeMillis() + "").commit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "code is error，do not save the data, code=" + paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    String str = paramToServiceMsg.extraData.getString("keyword", "");
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    paramToServiceMsg[2] = "";
    if (i != 1000)
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1006, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new DynamicAssociationWord.RspBody();
    for (;;)
    {
      Object localObject;
      DynamicAssociationWord.SuggestUrlItem localSuggestUrlItem;
      ArrayList localArrayList;
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.result_code.get();
        paramObject = paramFromServiceMsg.error_msg.get();
        if ((i != 0) && (i != 1009)) {
          break;
        }
        localObject = paramFromServiceMsg.association_items.get();
        paramObject = paramFromServiceMsg.suggest_url_items.get();
        localSuggestUrlItem = (DynamicAssociationWord.SuggestUrlItem)paramFromServiceMsg.completed_url_items.get();
        localArrayList = new ArrayList();
        paramFromServiceMsg = new ArrayList();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          DynamicAssociationWord.AssociationItem localAssociationItem = (DynamicAssociationWord.AssociationItem)((Iterator)localObject).next();
          avld localavld = new avld();
          localavld.jdField_a_of_type_JavaLangString = localAssociationItem.word.get().toStringUtf8();
          localavld.jdField_b_of_type_JavaLangString = localAssociationItem.subWord.get().toStringUtf8();
          localavld.d = localAssociationItem.pic_url.get().toStringUtf8();
          localavld.jdField_c_of_type_JavaLangString = localAssociationItem.jmp_url.get().toStringUtf8();
          localavld.jdField_b_of_type_Int = localAssociationItem.type.get();
          localavld.jdField_c_of_type_Int = localAssociationItem.group_mask.get();
          localArrayList.add(localavld);
          continue;
        }
        localObject = paramObject.iterator();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1006, false, paramToServiceMsg);
        paramFromServiceMsg.printStackTrace();
        return;
      }
      while (((Iterator)localObject).hasNext()) {
        paramFromServiceMsg.add(((DynamicAssociationWord.SuggestUrlItem)((Iterator)localObject).next()).url.get().toStringUtf8());
      }
      paramFromServiceMsg = new Object[5];
      paramFromServiceMsg[0] = str;
      paramFromServiceMsg[1] = Integer.valueOf(i);
      paramFromServiceMsg[2] = localArrayList;
      paramFromServiceMsg[3] = paramObject;
      paramFromServiceMsg[4] = localSuggestUrlItem;
      paramToServiceMsg = paramFromServiceMsg;
      try
      {
        notifyUI(1006, true, paramFromServiceMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
    }
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = str;
    paramFromServiceMsg[1] = Integer.valueOf(i);
    paramFromServiceMsg[2] = paramObject;
    paramToServiceMsg = paramFromServiceMsg;
    notifyUI(1006, false, paramFromServiceMsg);
  }
  
  private void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    long l = System.currentTimeMillis();
    new awrb(this.app).a("dc00899").b("grp_search_engineer").c("search_net").d(paramString1).a(new String[] { paramLong2 + "", "" + (l - paramLong1), "" + paramString2, urp.a(null) }).a();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleCompletedUrlResult. resultCode=" + i);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getString("keyword", "");
    paramFromServiceMsg = new Object[3];
    paramFromServiceMsg[0] = paramToServiceMsg;
    paramFromServiceMsg[1] = Integer.valueOf(-1);
    paramFromServiceMsg[2] = "";
    if (i != 1000)
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    Object localObject = new DynamicAssociationWord.RspBody();
    try
    {
      ((DynamicAssociationWord.RspBody)localObject).mergeFrom((byte[])paramObject);
      i = ((DynamicAssociationWord.RspBody)localObject).result_code.get();
      str = ((DynamicAssociationWord.RspBody)localObject).error_msg.get();
      if ((i != 0) && (i != 1009)) {
        break label243;
      }
      localObject = (DynamicAssociationWord.SuggestUrlItem)((DynamicAssociationWord.RspBody)localObject).completed_url_items.get();
      paramObject = new Object[3];
      paramObject[0] = paramToServiceMsg;
      paramObject[1] = localObject;
      paramObject[2] = Integer.valueOf(i);
      paramToServiceMsg = paramObject;
      try
      {
        notifyUI(1005, true, paramObject);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      String str;
      label229:
      break label229;
    }
    notifyUI(1005, false, paramFromServiceMsg);
    paramToServiceMsg.printStackTrace();
    return;
    label243:
    paramObject = new Object[3];
    paramObject[0] = paramToServiceMsg;
    paramObject[1] = Integer.valueOf(i);
    paramObject[2] = str;
    paramToServiceMsg = paramObject;
    notifyUI(1005, false, paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleUniteSearchResult. resultCode=" + i);
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    Object localObject2 = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    paramFromServiceMsg = new Object[5];
    paramFromServiceMsg[0] = str1;
    paramFromServiceMsg[1] = Boolean.valueOf(bool2);
    paramFromServiceMsg[2] = str2;
    paramFromServiceMsg[3] = Integer.valueOf(-1);
    paramFromServiceMsg[4] = "";
    a("dynamic_unite_search.1", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
    if (i != 1000)
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1004, false, paramFromServiceMsg);
      return;
    }
    UniteSearch.RspBody localRspBody = new UniteSearch.RspBody();
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      i = localRspBody.result_code.get();
      localObject1 = localRspBody.error_msg.get();
      if ((i != 0) && (i < 1000)) {
        break label533;
      }
      localObject1 = localRspBody.cookie_topic.get().toByteArray();
      if (localRspBody.search_ver.has()) {
        avwf.a("dynamic_unite_search.1", (long[])localObject2, localRspBody.search_ver.get().toStringUtf8());
      }
      if (localRspBody.is_end_topic.get() != 1) {
        break label585;
      }
      bool1 = true;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        Object localObject1;
        continue;
        boolean bool1 = false;
      }
    }
    paramObject = localRspBody.tab_groups.get();
    localObject2 = new ArrayList(paramObject.size());
    i = 0;
    while (i < paramObject.size())
    {
      ((List)localObject2).add(new avoh((UniteSearch.TabItemGroup)paramObject.get(i)));
      i += 1;
    }
    i = localRspBody.trigger_netword_num.get();
    if (i >= 0) {
      baig.r(BaseApplicationImpl.getContext(), i);
    }
    paramObject = localRspBody.item_groups.get();
    paramToServiceMsg = new avqj().a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
    paramObject = new Object[7];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool2);
    paramObject[2] = str2;
    paramObject[3] = localObject1;
    paramObject[4] = Boolean.valueOf(bool1);
    paramObject[5] = localObject2;
    paramObject[6] = paramToServiceMsg;
    paramToServiceMsg = paramObject;
    try
    {
      notifyUI(1004, true, paramObject);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = paramObject;
    }
    notifyUI(1004, false, paramFromServiceMsg);
    paramToServiceMsg.printStackTrace();
    return;
    label533:
    paramObject = new Object[5];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool2);
    paramObject[2] = str2;
    paramObject[3] = Integer.valueOf(i);
    paramObject[4] = localObject1;
    paramToServiceMsg = paramObject;
    notifyUI(1004, false, paramObject);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleTabSearchResult. resultCode=" + i);
    }
    String str1 = paramToServiceMsg.extraData.getString("keyword", "");
    String str2 = paramToServiceMsg.extraData.getString("time", "");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("masks");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("isFirstReq");
    paramFromServiceMsg = new Object[6];
    paramFromServiceMsg[0] = str1;
    paramFromServiceMsg[1] = Boolean.valueOf(bool3);
    paramFromServiceMsg[2] = str2;
    paramFromServiceMsg[3] = Integer.valueOf(-1);
    paramFromServiceMsg[4] = "";
    paramFromServiceMsg[5] = arrayOfLong;
    a("dynamic_tab_search.1", paramToServiceMsg.extraData.getLong("send_req_time"), i, str1);
    if (i != 1000)
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    if (!(paramObject instanceof byte[]))
    {
      notifyUI(1000, false, paramFromServiceMsg);
      return;
    }
    Object localObject1 = new DynamicTabSearch.RspBody();
    for (;;)
    {
      try
      {
        ((DynamicTabSearch.RspBody)localObject1).mergeFrom((byte[])paramObject);
        i = ((DynamicTabSearch.RspBody)localObject1).result_code.get();
        localObject2 = ((DynamicTabSearch.RspBody)localObject1).error_msg.get();
        if ((i != 0) && (i < 1000)) {
          continue;
        }
        localObject2 = ((DynamicTabSearch.RspBody)localObject1).cookie.get().toByteArray();
        if (((DynamicTabSearch.RspBody)localObject1).search_ver.has()) {
          avwf.a("dynamic_tab_search.1", arrayOfLong, ((DynamicTabSearch.RspBody)localObject1).search_ver.get().toStringUtf8());
        }
        if (((DynamicTabSearch.RspBody)localObject1).is_end.get() != 1) {
          continue;
        }
        bool1 = true;
        paramObject = ((DynamicTabSearch.RspBody)localObject1).item_groups.get();
        paramToServiceMsg = new avqj().a(new Object[] { str1, paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("fromType")) });
        String str3 = ((DynamicTabSearch.RspBody)localObject1).sub_hot_top_wording.get().toStringUtf8();
        if (((DynamicTabSearch.RspBody)localObject1).dont_need_merge.get() != 1) {
          continue;
        }
        bool2 = true;
        List localList = ((DynamicTabSearch.RspBody)localObject1).hot_words.get();
        localObject1 = ((DynamicTabSearch.RspBody)localObject1).extension.get().toStringUtf8();
        paramObject = new Object[11];
        paramObject[0] = str1;
        paramObject[1] = Boolean.valueOf(bool3);
        paramObject[2] = str2;
        paramObject[3] = localObject2;
        paramObject[4] = Boolean.valueOf(bool1);
        paramObject[5] = paramToServiceMsg;
        paramObject[6] = arrayOfLong;
        paramObject[7] = str3;
        paramObject[8] = localList;
        paramObject[9] = Boolean.valueOf(bool2);
        paramObject[10] = localObject1;
        paramToServiceMsg = paramObject;
        try
        {
          notifyUI(1000, true, paramObject);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        Object localObject2;
        boolean bool1;
        boolean bool2;
        continue;
      }
      notifyUI(1000, false, paramFromServiceMsg);
      paramToServiceMsg.printStackTrace();
      return;
      bool1 = false;
      continue;
      bool2 = false;
    }
    paramObject = new Object[6];
    paramObject[0] = str1;
    paramObject[1] = Boolean.valueOf(bool3);
    paramObject[2] = str2;
    paramObject[3] = Integer.valueOf(i);
    paramObject[4] = localObject2;
    paramObject[5] = arrayOfLong;
    paramToServiceMsg = paramObject;
    notifyUI(1000, false, paramObject);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.jdField_a_of_type_Ajur != null)
    {
      paramToServiceMsg = new RequestSearchWord.RspBody();
      if (pde.a(paramFromServiceMsg, paramObject, paramToServiceMsg) != 0) {}
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      this.jdField_a_of_type_Ajur.a(paramToServiceMsg.msg_search_keywords.rcmds, paramToServiceMsg.msg_search_keywords.sessionid);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 1, " handleGetPadRightsInfo exception: " + paramToServiceMsg.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "sendBusiHotWordRequest. ");
    }
    DynamicBusinessHotWord.ReqBody localReqBody = new DynamicBusinessHotWord.ReqBody();
    localReqBody.business.set(128);
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.2.6"));
    ToServiceMsg localToServiceMsg = createToServiceMsg("dynamic_busi_hot_word.1");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "getUniteSearchDiscovery. fromType ：" + paramInt);
    }
    if (!baig.a(paramQQAppInterface.getCurrentAccountUin(), paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "SearchDiscoveryLocalDataExpired. fromType ：" + paramInt);
      }
      return;
    }
    DynamicDiscovery.ReqBody localReqBody = new DynamicDiscovery.ReqBody();
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.2.6"));
    localReqBody.business.set(128);
    localReqBody.from_type.set(paramInt);
    if (paramInt == 10) {
      paramQQAppInterface = createToServiceMsg("qb_discovery.1");
    }
    for (;;)
    {
      paramQQAppInterface.extraData.putInt("fromType", paramInt);
      try
      {
        paramQQAppInterface.putWupBuffer(localReqBody.toByteArray());
        label148:
        sendPbReq(paramQQAppInterface);
        return;
        paramQQAppInterface = createToServiceMsg("DynamicScDiscovery.1");
      }
      catch (Exception localException)
      {
        break label148;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    String str3 = yfa.b();
    paramQQAppInterface = new DynamicKdReport.ReqBody();
    paramQQAppInterface.suin.set(a(str2));
    paramQQAppInterface.sclientIp.set(a(str3));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(a("8.2.6"));
    paramQQAppInterface.ssessionId.set(a(str2 + str1));
    paramQQAppInterface.stimeStamp.set(a(str1));
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.smodule.set("hot_list");
    paramQQAppInterface.saction.set(a(paramString1));
    paramQQAppInterface.sreseverver2.set(a(paramString3));
    paramQQAppInterface.sreseverver4.set(a(paramString2));
    paramQQAppInterface.sreseverobj2.set(a(paramString4));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    long l = System.currentTimeMillis();
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = yfa.b();
    paramQQAppInterface = new DynamicKdReport.ReqBody();
    paramQQAppInterface.sopername.set("Grp_all_search");
    paramQQAppInterface.suin.set(a(str1));
    paramQQAppInterface.sreseverver2.set(a("Kdfeedsback"));
    paramQQAppInterface.splatform.set("android");
    paramQQAppInterface.sversion.set(a("8.2.6"));
    paramQQAppInterface.smodule.set("all_result");
    paramQQAppInterface.sreseverobj1.set("2049");
    paramQQAppInterface.sclientIp.set(a(str2));
    paramQQAppInterface.ssessionId.set(paramString2);
    paramQQAppInterface.sreseverver3.set(a(paramString3));
    paramQQAppInterface.sreseverver4.set(a(paramString4));
    paramQQAppInterface.sreseverver5.set(a(paramString5));
    paramQQAppInterface.sreseverver6.set(a(paramString6));
    paramQQAppInterface.stimeStamp.set(a(String.valueOf(l)));
    paramQQAppInterface.saction.set(a(paramString1));
    paramString1 = createToServiceMsg("KDSearch.1");
    paramString1.putWupBuffer(paramQQAppInterface.toByteArray());
    sendPbReq(paramString1);
  }
  
  public void a(ByteStringMicro paramByteStringMicro, ajur paramajur)
  {
    this.jdField_a_of_type_Ajur = paramajur;
    paramajur = new RequestSearchWord.ReqBody();
    paramajur.bytes_rowkey.set(paramByteStringMicro);
    paramajur.uint32_oper_type.set(1);
    paramByteStringMicro = pde.a("OidbSvc.0xd78_0", 3448, 0, paramajur.toByteArray());
    paramByteStringMicro.extraData.putBoolean("req_pb_protocol_flag", true);
    long l = System.currentTimeMillis();
    paramByteStringMicro.extraData.putLong("time_stamp", l);
    sendPbReq(paramByteStringMicro);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "<<---handleBusiHotWord. resultCode=" + paramInt);
    }
    if (paramToServiceMsg != null) {
      a("dynamic_busi_hot_word.1", paramToServiceMsg.extraData.getLong("send_req_time"), paramInt, "");
    }
    if (paramInt != 1000) {
      notifyUI(1002, false, null);
    }
    for (;;)
    {
      return;
      if (paramObject == null)
      {
        notifyUI(1002, false, null);
        return;
      }
      if (!(paramObject instanceof byte[]))
      {
        notifyUI(1002, false, null);
        return;
      }
      paramToServiceMsg = new DynamicBusinessHotWord.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramInt = paramToServiceMsg.result_code.get();
        paramObject = paramToServiceMsg.error_msg.get();
        if (paramInt == 0)
        {
          paramInt = paramToServiceMsg.expire_time.get();
          BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit().putInt(jdField_c_of_type_JavaLangString, paramInt).commit();
          paramToServiceMsg = paramToServiceMsg.rpt_item_groups.get();
          notifyUI(1002, true, new Object[] { Integer.valueOf(paramInt), a(paramToServiceMsg) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "response data: expireTime:" + paramInt + ",resultItemList :" + paramToServiceMsg.toString());
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1002, false, null);
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    notifyUI(1002, false, new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(String paramString)
  {
    a(paramString, 1, false);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "sendAssociationWordRequest. keyword=" + paramString);
    }
    DynamicAssociationWord.ReqBody localReqBody = new DynamicAssociationWord.ReqBody();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "sendAssociationWordRequest. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.2.6"));
    localReqBody.business.set(128);
    localReqBody.need_flag.set(paramInt);
    if (paramBoolean) {}
    for (ToServiceMsg localToServiceMsg = createToServiceMsg("qb_association_word.1");; localToServiceMsg = createToServiceMsg("dynamic_association_word.1"))
    {
      localToServiceMsg.extraData.putString("keyword", paramString);
      localToServiceMsg.extraData.putLong("send_req_time", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("needFlag", paramInt);
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(localToServiceMsg);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt1, paramList1, paramList2, paramInt2, paramArrayOfByte, paramDouble1, paramDouble2, paramBoolean, false, paramInt3, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, int paramInt2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send uniteSearch keyword = [" + paramString1 + "], time = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], fromAction = [" + paramInt2 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "], isMoreSearch = [" + paramBoolean1 + "], hasLocalData = [" + paramBoolean2 + "]");
    }
    UniteSearch.ReqBody localReqBody = new UniteSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send uniteSearch. keyword is empty.");
      return;
    }
    if (paramInt2 == 6) {
      paramInt2 = 1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 > 0) {
        i = paramInt2 - 1;
      }
      localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
      localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.2.6"));
      if (paramBoolean2) {
        localReqBody.client_has_people_and_qun.set(1);
      }
      String[] arrayOfString;
      if (paramInt3 == 1)
      {
        localReqBody.from_tabbar_index.set(0);
        if (!paramBoolean1)
        {
          localObject = new DynamicSearch.RootSearcherRequest();
          ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
          ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(avwf.a(jdField_a_of_type_ArrayOfLong));
          localReqBody.req_entity.set((MessageMicro)localObject);
        }
        Object localObject = new DynamicSearch.RootSearcherRequest();
        ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
        ((DynamicSearch.RootSearcherRequest)localObject).page_size.set(paramInt1);
        ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(paramList1);
        if (paramArrayOfByte != null) {
          ((DynamicSearch.RootSearcherRequest)localObject).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        localReqBody.req_topic.set((MessageMicro)localObject);
        localReqBody.from_action.set(i);
        localObject = new DynamicSearch.ExtensionRequestInfo();
        i = 2;
        arrayOfString = baig.a(this.app.getCurrentAccountUin());
        if ((arrayOfString != null) && (arrayOfString.length != 0)) {
          break label748;
        }
        paramInt1 = 0;
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "key_word_src=" + paramInt1);
        }
        if (paramBundle != null)
        {
          paramInt2 = paramBundle.getInt("matchCount", 0);
          i = paramBundle.getInt("source", 0);
          localReqBody.locate_result_count.set(paramInt2);
          localReqBody.source.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "matchCount=" + paramInt2 + " source=" + i);
          }
        }
        ((DynamicSearch.ExtensionRequestInfo)localObject).key_word_src.set(paramInt1);
        ((DynamicSearch.ExtensionRequestInfo)localObject).latitude.set((float)paramDouble1);
        ((DynamicSearch.ExtensionRequestInfo)localObject).longitude.set((float)paramDouble2);
        if (paramList2 != null) {
          ((DynamicSearch.ExtensionRequestInfo)localObject).rpt_pubacc_local_result.set(paramList2);
        }
        localReqBody.extension_request_info.set((MessageMicro)localObject);
        paramList2 = createToServiceMsg("dynamic_unite_search.1");
        paramList2.extraData.putInt("fromType", paramInt3);
        paramList2.extraData.putString("keyword", paramString1);
        paramList2.extraData.putString("time", paramString2);
        paramList2.extraData.putLongArray("masks", avjb.a(paramList1));
        paramString1 = paramList2.extraData;
        if (paramArrayOfByte != null) {
          break label792;
        }
      }
      label792:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString1.putBoolean("isFirstReq", paramBoolean1);
        paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
        paramList2.putWupBuffer(localReqBody.toByteArray());
        sendPbReq(paramList2);
        return;
        if (paramInt3 == 2)
        {
          localReqBody.from_tabbar_index.set(1);
          break;
        }
        if (paramInt3 == 21)
        {
          localReqBody.from_tabbar_index.set(2);
          break;
        }
        localReqBody.from_tabbar_index.set(0);
        break;
        label748:
        int j = arrayOfString.length;
        paramInt2 = 0;
        for (;;)
        {
          paramInt1 = i;
          if (paramInt2 >= j) {
            break;
          }
          if (arrayOfString[paramInt2].equals(paramString1))
          {
            paramInt1 = 1;
            break;
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    a(paramString1, paramString2, paramInt, paramList1, paramList2, paramArrayOfByte, 0, paramDouble1, paramDouble2, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, List<Long> paramList1, List<Long> paramList2, byte[] paramArrayOfByte, int paramInt2, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send tabSearch keyword = [" + paramString1 + "], reqTime = [" + paramString2 + "], count = [" + paramInt1 + "], businessMaskArray = [" + paramList1 + "], cookie = [" + paramArrayOfByte + "], latitude = [" + paramDouble1 + "], longitude = [" + paramDouble2 + "]");
    }
    DynamicTabSearch.ReqBody localReqBody = new DynamicTabSearch.ReqBody();
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "send tabSearch. keyword is empty.");
      return;
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.2.6"));
    Object localObject = new DynamicSearch.RootSearcherRequest();
    ((DynamicSearch.RootSearcherRequest)localObject).business.set(128);
    ((DynamicSearch.RootSearcherRequest)localObject).page_size.set(paramInt1);
    ((DynamicSearch.RootSearcherRequest)localObject).rpt_busi_mask.set(paramList1);
    if (paramArrayOfByte != null) {
      ((DynamicSearch.RootSearcherRequest)localObject).cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localReqBody.search_request.set((MessageMicro)localObject);
    localObject = new DynamicSearch.ExtensionRequestInfo();
    ((DynamicSearch.ExtensionRequestInfo)localObject).latitude.set((float)paramDouble1);
    ((DynamicSearch.ExtensionRequestInfo)localObject).longitude.set((float)paramDouble2);
    int i;
    if (avhs.a.isEmpty()) {
      i = 0;
    }
    boolean bool;
    Iterator localIterator1;
    label526:
    do
    {
      ((DynamicSearch.ExtensionRequestInfo)localObject).key_word_src.set(i);
      if (paramList2 != null) {
        ((DynamicSearch.ExtensionRequestInfo)localObject).rpt_pubacc_local_result.set(paramList2);
      }
      localReqBody.extension_request_info.set((MessageMicro)localObject);
      if (paramInt2 != 0) {
        localReqBody.from_sub_hot_word_id.set(paramInt2, true);
      }
      paramList2 = createToServiceMsg("dynamic_tab_search.1");
      paramList2.extraData.putString("keyword", paramString1);
      paramList2.extraData.putString("time", paramString2);
      paramList2.extraData.putLongArray("masks", avjb.a(paramList1));
      paramString2 = paramList2.extraData;
      if (paramArrayOfByte != null) {
        break;
      }
      bool = true;
      paramString2.putBoolean("isFirstReq", bool);
      paramList2.extraData.putLong("send_req_time", System.currentTimeMillis());
      if (paramBundle != null)
      {
        bool = paramBundle.getBoolean("isLoadMore", false);
        paramInt1 = paramBundle.getInt("fromTypeForReport", 0);
        if (!bool) {
          avwf.a("sub_result", "active_search", new String[] { paramString1, avwf.a(paramList1), "" + paramInt1, "" });
        }
        paramList2.extraData.putAll(paramBundle);
      }
      paramList2.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(paramList2);
      return;
      localIterator1 = avhs.a.values().iterator();
      paramInt1 = 2;
      i = paramInt1;
    } while (!localIterator1.hasNext());
    Iterator localIterator2 = ((List)localIterator1.next()).iterator();
    while (localIterator2.hasNext()) {
      if (paramString1.equals((avmr)localIterator2.next())) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      break label526;
      bool = false;
      break;
    }
  }
  
  public byte[] a(String paramString)
  {
    return bace.a(BaseApplication.getContext().getFileStreamPath(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "handleUniteSearchDiscovery. code ：" + paramInt);
    }
    int i = paramToServiceMsg.extraData.getInt("fromType");
    if ((paramInt != 1000) || (!(paramObject instanceof byte[])))
    {
      notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
      return;
    }
    DynamicDiscovery.RspBody localRspBody = new DynamicDiscovery.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        paramInt = localRspBody.result_code.get();
        if (localRspBody.error_msg.get() != null)
        {
          paramToServiceMsg = localRspBody.error_msg.get().toStringUtf8();
          if (paramInt != 0) {
            break;
          }
          baig.a(this.app.getCurrentAccountUin(), i, localRspBody.expire_time.get());
          paramToServiceMsg = localRspBody.result_items.get();
          paramObject = avpu.a(this.app, paramToServiceMsg, i);
          if (localRspBody.bucket_id.get() == null) {
            break label278;
          }
          paramToServiceMsg = localRspBody.bucket_id.get().toStringUtf8();
          avsv.jdField_b_of_type_JavaLangString = paramToServiceMsg;
          notifyUI(1007, true, new Object[] { paramObject, Integer.valueOf(i) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(1007, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(i) });
        return;
      }
      paramToServiceMsg = null;
      continue;
      label278:
      paramToServiceMsg = null;
    }
    notifyUI(1007, false, new Object[] { Integer.valueOf(paramInt), paramToServiceMsg, Integer.valueOf(i) });
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return ajus.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ").append(paramToServiceMsg.getRequestSsoSeq()).append(", serviceCmd: ").append(str).append(", resultCode: ").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchHandler818searchProto_old", 2, "cmd filter error=" + str);
      }
    }
    do
    {
      int i;
      do
      {
        return;
        if ((!"dynamic_association_word.1".equals(str)) && (!"qb_association_word.1".equals(str))) {
          break;
        }
        i = paramToServiceMsg.extraData.getInt("needFlag", 0);
        if ((i & 0x4) != 0) {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      } while (((i & 0x2) == 0) && ((i & 0x1) == 0));
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("dynamic_unite_search.1".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_tab_search.1".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("dynamic_busi_hot_word.1".equals(str))
      {
        i = paramFromServiceMsg.getResultCode();
        a(i, paramObject, jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString);
        a(paramToServiceMsg, i, paramObject);
        return;
      }
      if (("DynamicScDiscovery.1".equals(str)) || ("qb_discovery.1".equals(str)))
      {
        b(paramToServiceMsg, paramFromServiceMsg.getResultCode(), paramObject);
        return;
      }
    } while (!"OidbSvc.0xd78_0".equals(str));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajuq
 * JD-Core Version:    0.7.0.1
 */