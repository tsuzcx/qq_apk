import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp.3;
import com.tencent.mobileqq.app.RecommendTroopManagerImp.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.NotificationRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.qun.group_activity.group_activity.GroupAct;>;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.Color;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.oidb.cmd0x935.oidb_0x935.Label;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RecommendInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.ReqBody;
import tencent.im.oidb.cmd0x935.oidb_0x935.RgroupInfo;
import tencent.im.oidb.cmd0x935.oidb_0x935.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.AddFeedbackHateGroupCmd;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb.Label;
import tencent.im.oidb.oidb_0xc26.RgoupLabel;
import tencent.im.oidb.oidb_0xc26.RgroupColor;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.qun.group_activity.group_activity.GroupAct;

public class alws
  implements Manager
{
  public int a;
  protected alzf a;
  private amle jdField_a_of_type_Amle = new alwu(this, 3, true, true, 60000L, false, false, "TroopNotifyAndRecommendView");
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  protected SparseArray<Boolean> a;
  protected awbw a;
  protected QQAppInterface a;
  protected Object a;
  protected final String a;
  private ArrayList<oidb_0x935.NotifyInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  protected List<SearchGroup.GroupInfo> a;
  public boolean a;
  public int b;
  protected SparseArray<Long> b;
  protected final String b;
  public List<RecommendTroopItem> b;
  public int c;
  protected int d = -1;
  
  public alws(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangString = "recommendtroop_notification";
    this.jdField_b_of_type_JavaLangString = "recommendtroop_notification_status";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommend_troop_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Alzf = ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(aljq.Y, 4001);
    int j;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0))
    {
      j = 0;
      return j;
    }
    paramQQAppInterface = paramQQAppInterface.iterator();
    int i = 0;
    label40:
    if (paramQQAppInterface.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      String str = localMessageRecord.msg;
      if ((str == null) || (str.length() <= 0) || ((localMessageRecord.msgtype != -1039) && (localMessageRecord.msgtype != -1040)) || (localMessageRecord.extStr == null) || (localMessageRecord.extStr.length() <= 0) || (localMessageRecord.isread)) {
        break label164;
      }
      i += 1;
    }
    label164:
    for (;;)
    {
      break label40;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RecommendTroopManagerImp", 2, "getRecommendUnreadCount" + i);
      return i;
    }
  }
  
  public static List<oidb_0x9fb.Label> a(List<oidb_0x935.Label> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0x935.Label localLabel = (oidb_0x935.Label)paramList.next();
      oidb_0x9fb.Label localLabel1 = new oidb_0x9fb.Label();
      localLabel1.bytes_name.set(localLabel.bytes_name.get());
      localLabel1.edging_color.set(a((oidb_0x935.Color)localLabel.edging_color.get()));
      localLabel1.text_color.set(a((oidb_0x935.Color)localLabel.text_color.get()));
      localLabel1.enum_type.set(localLabel.enum_type.get());
      localLabel1.uint32_label_attr.set(localLabel.uint32_label_attr.get());
      localLabel1.uint32_label_type.set(localLabel.uint32_label_type.get());
      localArrayList.add(localLabel1);
    }
    return localArrayList;
  }
  
  private static oidb_0x9fb.Color a(oidb_0x935.Color paramColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramColor.uint32_b.get());
    localColor.uint32_g.set(paramColor.uint32_g.get());
    localColor.uint32_r.set(paramColor.uint32_r.get());
    return localColor;
  }
  
  private static oidb_0x9fb.Color a(oidb_0xc26.RgroupColor paramRgroupColor)
  {
    oidb_0x9fb.Color localColor = new oidb_0x9fb.Color();
    localColor.uint32_b.set(paramRgroupColor.uint32_b.get());
    localColor.uint32_g.set(paramRgroupColor.uint32_g.get());
    localColor.uint32_r.set(paramRgroupColor.uint32_r.get());
    return localColor;
  }
  
  private void a(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
        if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          if (!localOIDBSSOPkg.uint32_result.has()) {
            break label214;
          }
          paramInt = localOIDBSSOPkg.uint32_result.get();
          if (!localOIDBSSOPkg.str_error_msg.has()) {
            break label221;
          }
          paramArrayOfByte = localOIDBSSOPkg.str_error_msg.get();
          QLog.e("RecommendTroopManagerImp", 1, String.format("parseRecommendTroop, errcode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramArrayOfByte }));
          return;
        }
        paramArrayOfByte = new oidb_0x935.RspBody();
        paramArrayOfByte.mergeFrom(localOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if ((paramInt != 1) && (paramInt == 2))
        {
          ThreadManager.post(new RecommendTroopManagerImp.3(this, paramLong, paramArrayOfByte), 8, null, true);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "parseRecommendTroop sso error");
        }
      }
      return;
      label214:
      paramInt = -8888;
      continue;
      label221:
      paramArrayOfByte = "";
    }
  }
  
  private void a(long paramLong, oidb_0x935.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop, lastuin = " + paramLong);
    }
    this.jdField_a_of_type_Int = paramRspBody.is_end.get();
    int i = this.jdField_b_of_type_JavaUtilList.size();
    if (paramRspBody.cur_pos.get() == 1)
    {
      c();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendTroopManagerImp", 2, "get first page clear the db");
      }
    }
    Object localObject = paramRspBody.recommend_info.get();
    awby localawby = this.jdField_a_of_type_Awbw.a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = ((List)localObject).iterator();
    int j = 50 - i;
    if (localIterator1.hasNext())
    {
      localObject = (oidb_0x935.RecommendInfo)localIterator1.next();
      if (j >= 0) {
        break label324;
      }
      this.jdField_a_of_type_Int = 1;
    }
    try
    {
      localawby.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Iterator localIterator2;
        oidb_0x935.RgroupInfo localRgroupInfo;
        NotificationRecommendTroopItem localNotificationRecommendTroopItem;
        if (QLog.isColorLevel()) {
          QLog.e("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop commit error");
        }
        localawby.b();
      }
    }
    finally
    {
      localawby.b();
    }
    if (localArrayList.size() > 0) {
      a(0);
    }
    if ((this.jdField_b_of_type_Int == paramRspBody.cur_pos.get() - 1) || (paramRspBody.cur_pos.get() == 1))
    {
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
      this.jdField_b_of_type_Int = paramRspBody.cur_pos.get();
      if (QLog.isColorLevel())
      {
        QLog.d("RecommendTroopManagerImp", 2, "getNotificationRecommendTroopList add page" + localArrayList.size());
        paramRspBody = localArrayList.iterator();
        while (paramRspBody.hasNext())
        {
          localObject = (RecommendTroopItem)paramRspBody.next();
          QLog.d("RecommendTroopManagerImp", 2, "RecommendTroop from network = " + localObject);
        }
        label324:
        localObject = ((oidb_0x935.RecommendInfo)localObject).msg_groups.get();
        if (localObject == null) {
          return;
        }
        localawby.a();
        localIterator2 = ((List)localObject).iterator();
        i = j;
        do
        {
          j = i;
          if (!localIterator2.hasNext()) {
            break;
          }
          localRgroupInfo = (oidb_0x935.RgroupInfo)localIterator2.next();
          if (i < 0)
          {
            this.jdField_a_of_type_Int = 1;
            j = i;
            break;
          }
          localNotificationRecommendTroopItem = new NotificationRecommendTroopItem();
        } while (!localRgroupInfo.uint64_group_code.has());
        localNotificationRecommendTroopItem.uin = String.valueOf(localRgroupInfo.uint64_group_code.get());
        if (localRgroupInfo.bytes_group_name.has()) {
          localNotificationRecommendTroopItem.name = new String(localRgroupInfo.bytes_group_name.get().toByteArray());
        }
        if (localRgroupInfo.bytes_group_memo.has()) {
          localNotificationRecommendTroopItem.intro = new String(localRgroupInfo.bytes_group_memo.get().toByteArray());
        }
        localNotificationRecommendTroopItem.labelList = a(localRgroupInfo.rpt_group_label.get());
        localNotificationRecommendTroopItem.memberNum = localRgroupInfo.uint32_member_num.get();
        localNotificationRecommendTroopItem.x935RgroupInfo = localRgroupInfo.toByteArray();
        if (localRgroupInfo.bytes_algorithm.has())
        {
          localObject = localRgroupInfo.bytes_algorithm.get().toStringUtf8();
          label568:
          localNotificationRecommendTroopItem.recomAlgol = ((String)localObject);
          if (!localRgroupInfo.bytes_join_group_auth.has()) {
            break label729;
          }
          localObject = localRgroupInfo.bytes_join_group_auth.get().toStringUtf8();
          label599:
          localNotificationRecommendTroopItem.authSig = ((String)localObject);
          if (!localRgroupInfo.uint32_activity.has()) {
            break label737;
          }
          j = localRgroupInfo.uint32_activity.get();
          label627:
          localNotificationRecommendTroopItem.activity = j;
          if (!localRgroupInfo.int32_uin_privilege.has()) {
            break label743;
          }
        }
        label729:
        label737:
        label743:
        for (j = localRgroupInfo.int32_uin_privilege.get();; j = -1)
        {
          localNotificationRecommendTroopItem.privilege = j;
          this.jdField_a_of_type_Awbw.b(localNotificationRecommendTroopItem);
          localArrayList.add(localNotificationRecommendTroopItem);
          if (QLog.isColorLevel()) {
            QLog.d("RecommendTroopManagerImp", 2, "saveNotificationRecommendTroop into db, recommend troop = " + localNotificationRecommendTroopItem);
          }
          i -= 1;
          break;
          localObject = "";
          break label568;
          localObject = "";
          break label599;
          j = 0;
          break label627;
        }
      }
    }
    this.jdField_a_of_type_Alzf.notifyUI(29, true, this.jdField_b_of_type_JavaUtilList);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.post(new RecommendTroopManagerImp.4(paramAppInterface, paramInt, paramString), 5, null, true);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      Object localObject1 = new oidb_0x9fa.ReqBody();
      ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
      ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(paramInt);
      Object localObject2 = new oidb_0x9fa.AddFeedbackHateGroupCmd();
      ((oidb_0x9fa.AddFeedbackHateGroupCmd)localObject2).uint64_group_code.add(Long.valueOf(l));
      ((oidb_0x9fa.ReqBody)localObject1).msg_add_hate_group.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(paramAppInterface.getApplication(), mzx.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x9fa_0");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(paramBusinessObserver);
      paramAppInterface.startServlet((NewIntent)localObject1);
      a(paramAppInterface, paramInt, paramString);
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("recommend_troop_info" + paramQQAppInterface.getAccount(), 0);
    if (paramQQAppInterface != null) {
      i = paramQQAppInterface.getInt("unread_recommend_troop_count", 0);
    }
    return i;
  }
  
  public static List<oidb_0x9fb.Label> b(List<oidb_0xc26.RgoupLabel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_0xc26.RgoupLabel localRgoupLabel = (oidb_0xc26.RgoupLabel)paramList.next();
      oidb_0x9fb.Label localLabel = new oidb_0x9fb.Label();
      localLabel.bytes_name.set(localRgoupLabel.bytes_name.get());
      localLabel.edging_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.edging_color.get()));
      localLabel.text_color.set(a((oidb_0xc26.RgroupColor)localRgoupLabel.text_color.get()));
      localLabel.enum_type.set(localRgoupLabel.enum_type.get());
      localLabel.uint32_label_attr.set(localRgoupLabel.uint32_label_attr.get());
      localLabel.uint32_label_type.set(localRgoupLabel.uint32_label_type.get());
      localArrayList.add(localLabel);
    }
    return localArrayList;
  }
  
  private void e()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    try
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", i).commit();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(aljq.W, 9000, b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      Object localObject = (alwr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
      MessageRecord localMessageRecord = a();
      if ((localMessageRecord != null) && (!((alwr)localObject).a(aljq.W, 9000, localMessageRecord.time))) {
        ((alwr)localObject).a(aljq.W, 9000, alpo.a(2131691141), localMessageRecord.time, localMessageRecord.time);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(105));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendTroopManagerImp", 2, "update troopRecommendUnreadCount failed! + msg = " + localException.getMessage());
        }
      }
    }
  }
  
  private void f()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(1);
      localMqqHandler.sendEmptyMessageDelayed(1, 100L);
    }
  }
  
  public MessageRecord a()
  {
    try
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.Y, 4001);
      if ((localList != null) && (localList.size() > 0))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null))
          {
            int j = localMessageRecord.msg.length();
            if (j > 0) {
              return localMessageRecord;
            }
          }
          i -= 1;
        }
      }
      return null;
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public String a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.Y, 4001);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(i);
          if (((localMessageRecord.msgtype == -1039) || (localMessageRecord.msgtype == -1040)) && (localMessageRecord.msg != null) && (localMessageRecord.msg.length() > 0))
          {
            localObject = localMessageRecord.msg;
            return localObject;
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (NullPointerException localNullPointerException) {}
  }
  
  public List<RecommendTroopItem> a()
  {
    List localList = null;
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    Message localMessage = localMqqHandler.obtainMessage();
    localMessage.what = 1015;
    if (this.jdField_a_of_type_Awbw != null)
    {
      localList = this.jdField_a_of_type_Awbw.a(NotificationRecommendTroopItem.class, false, null, new String[0], null, null, null, null);
      this.jdField_a_of_type_Awbw.a();
      localMessage.obj = localList;
      if ((QLog.isColorLevel()) && (localList != null))
      {
        QLog.d("RecommendTroopManagerImp", 2, "getNotificationRecommendTroopList from db, sz = " + localList.size());
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
          QLog.d("RecommendTroopManagerImp", 2, "RecommendTroop from db = " + localRecommendTroopItem);
        }
      }
      localMqqHandler.sendMessage(localMessage);
    }
    return localList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "updateDBStatsus:" + paramInt);
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("recommendtroop_notification", 0).edit();
    localEditor.putInt("recommendtroop_notification_status", paramInt);
    localEditor.commit();
    this.d = paramInt;
  }
  
  public void a(int paramInt, oidb_0x935.GPS paramGPS, BusinessObserver paramBusinessObserver)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommend0x935TroopFromServer() start getRecommend0x935TroopFromServer");
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start getRecommendTroopFromServer");
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) && (((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).booleanValue())) {
      return;
    }
    if (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null) {}
    for (long l1 = ((Long)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt)).longValue();; l1 = 0L)
    {
      long l2 = System.currentTimeMillis() / 1000L;
      if ((l1 > 0L) && (l2 - l1 < 60L)) {}
      this.jdField_b_of_type_AndroidUtilSparseArray.append(paramInt, Long.valueOf(l2));
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, Boolean.valueOf(true));
      if (QLog.isDevelopLevel()) {
        QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() start");
      }
      Object localObject = new oidb_0x935.ReqBody();
      ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
      ((oidb_0x935.ReqBody)localObject).uint32_pos.set(this.jdField_b_of_type_Int);
      if (paramGPS != null) {
        ((oidb_0x935.ReqBody)localObject).msg_gps.set(paramGPS);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        if (QLog.isDevelopLevel())
        {
          paramGPS = new StringBuilder();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            oidb_0x935.NotifyInfo localNotifyInfo = (oidb_0x935.NotifyInfo)localIterator.next();
            paramGPS.append(localNotifyInfo.uint64_notify_gc.get() + "," + localNotifyInfo.uint32_notify_type.get() + " ");
          }
          QLog.d("RecommendTroopManagerImp", 4, "getRecommendTroopFromServer() report " + paramGPS.toString());
        }
        ((oidb_0x935.ReqBody)localObject).msg_notify_info.set(this.jdField_a_of_type_JavaUtilArrayList);
      }
      paramGPS = new oidb_sso.OIDBSSOPkg();
      paramGPS.uint32_command.set(2357);
      paramGPS.uint32_result.set(0);
      paramGPS.uint32_service_type.set(4);
      paramGPS.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), mzx.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x935_4");
      ((NewIntent)localObject).putExtra("data", paramGPS.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void a(long paramLong, oidb_0x935.GPS paramGPS)
  {
    a(2, paramGPS, new alwt(this, paramLong));
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.Y, 4001);
    if ((localList != null) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
        if ((localMessageRecord.msgtype == -1039) && (!TextUtils.isEmpty(localMessageRecord.extStr)) && (localMessageRecord.extStr.equals(paramString)))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          localList.remove(i);
        }
        i -= 1;
      }
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", i).commit();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "updateTroopRecommend content:" + paramString + ",\n uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + ", version:" + paramInt);
    }
    try
    {
      if (new JSONObject(paramString).getInt("showNewTroopRecommend") == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_Boolean = bool;
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        paramString.edit().putBoolean("show_new_troop_recommend", bool);
        paramString.edit().commit();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("RecommendTroopManagerImp", 1, "updateLebaConfig e:" + paramString.toString());
    }
  }
  
  public void a(String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new oidb_0x935.ReqBody();
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l == 0L) {
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecommendTroopManagerImp", 2, "setRecommendTroopDeleted NumberFormatException + " + paramString);
        }
        l = 0L;
      }
      ((oidb_0x935.ReqBody)localObject).uint32_appid.set(1);
      ((oidb_0x935.ReqBody)localObject).uint64_black_gc.set(l);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(2357);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(7);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x935.ReqBody)localObject).toByteArray()));
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), mzx.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x935_7");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(paramBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    }
  }
  
  public void a(ArrayList<oidb_0x935.NotifyInfo> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveGroupSysNotifyReportData ");
      if (paramArrayList != null) {
        break label70;
      }
    }
    label70:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("RecommendTroopManagerImp", 2, localObject);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramArrayList != null))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      }
      return;
    }
  }
  
  public void a(List<group_activity.GroupAct> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    long l = NetConnInfoCenter.getServerTime();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramList != null)
    {
      localObject1 = localObject3;
      if (paramList.size() != 0)
      {
        paramList = (group_activity.GroupAct)paramList.get(0);
        localObject1 = localObject3;
        if (paramList != null)
        {
          localObject1 = new RecTroopBusinessItem();
          ((RecTroopBusinessItem)localObject1).id = String.valueOf(paramList.uint32_act_id.get());
          ((RecTroopBusinessItem)localObject1).title = paramList.string_title.get();
          ((RecTroopBusinessItem)localObject1).des = paramList.string_des.get();
          ((RecTroopBusinessItem)localObject1).jumpType = paramList.uint32_jumptype.get();
          ((RecTroopBusinessItem)localObject1).jumpUrl = paramList.string_url.get();
          ((RecTroopBusinessItem)localObject1).jumpParam = paramList.string_jumpparam.get();
          ((RecTroopBusinessItem)localObject1).iconUrl = paramList.string_iconurl.get();
          ((RecTroopBusinessItem)localObject1).btnText = paramList.string_btntext.get();
          ((RecTroopBusinessItem)localObject1).startTime = paramList.uint32_start_time.get();
          ((RecTroopBusinessItem)localObject1).endTime = paramList.uint32_end_time.get();
          ((RecTroopBusinessItem)localObject1).timeStamp = l;
          this.jdField_a_of_type_Awbw.b((awbv)localObject1);
        }
      }
    }
    int i;
    awby localawby;
    if (localObject1 == null)
    {
      localObject3 = this.jdField_a_of_type_Awbw.a(RecTroopBusinessItem.class, false, null, null, null, null, "timeStamp desc", null);
      if ((localObject3 != null) && (((List)localObject3).size() != 0))
      {
        paramList = (RecTroopBusinessItem)((List)localObject3).get(0);
        if (((List)localObject3).size() > 60)
        {
          i = ((List)localObject3).size() - 1;
          while (i >= 60)
          {
            localObject1 = (RecTroopBusinessItem)((List)localObject3).get(i);
            this.jdField_a_of_type_Awbw.b((awbv)localObject1);
            i -= 1;
          }
        }
        if (paramList != null)
        {
          localObject1 = ayvw.a(-1040);
          ((MessageRecord)localObject1).extStr = paramList.id;
          ((MessageRecord)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), aljq.Y, "0", paramList.title, l, -1040, 4001, 0L);
          localArrayList.add(localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
        }
        localObject3 = new HashMap();
        localawby = this.jdField_a_of_type_Awbw.a();
      }
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        localawby.a();
        i = localArrayList.size();
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject4 = (SearchGroup.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject4 == null) || ((localObject4 != null) && (((SearchGroup.GroupInfo)localObject4).dwGroupUin.get() == 0) && (((SearchGroup.GroupInfo)localObject4).dwGroupCode.get() == 0))) {
            break label1347;
          }
          localObject1 = (RecommendTroopInfo)this.jdField_a_of_type_Awbw.a(RecommendTroopInfo.class, String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get()));
          if (localObject1 != null) {
            break label1335;
          }
          localObject1 = new RecommendTroopInfo();
          k = 0;
          ((RecommendTroopInfo)localObject1).code = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupUin.get());
          ((RecommendTroopInfo)localObject1).uin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupCode.get());
          ((RecommendTroopInfo)localObject1).ownerUin = String.valueOf(((SearchGroup.GroupInfo)localObject4).dwGroupOwnerId.get());
          ((RecommendTroopInfo)localObject1).curMemberNum = ((SearchGroup.GroupInfo)localObject4).dwCurMemberNum.get();
          ((RecommendTroopInfo)localObject1).maxMemberNum = ((SearchGroup.GroupInfo)localObject4).dwMaxMemberNum.get();
          ((RecommendTroopInfo)localObject1).name = ((SearchGroup.GroupInfo)localObject4).sGroupName.get();
          ((RecommendTroopInfo)localObject1).fingerMemo = ((SearchGroup.GroupInfo)localObject4).sGroupFingerMem.get();
          ((RecommendTroopInfo)localObject1).faceId = ((SearchGroup.GroupInfo)localObject4).dwGroupFaceId.get();
          ((RecommendTroopInfo)localObject1).faceUrl = ((SearchGroup.GroupInfo)localObject4).sGroupFaceUrl.get();
          ((RecommendTroopInfo)localObject1).tag = ((SearchGroup.GroupInfo)localObject4).sGroupTag.get();
          ((RecommendTroopInfo)localObject1).classId = ((SearchGroup.GroupInfo)localObject4).dwGroupClass.get();
          ((RecommendTroopInfo)localObject1).classText = ((SearchGroup.GroupInfo)localObject4).sGroupClassText.get();
          ((RecommendTroopInfo)localObject1).level = ((SearchGroup.GroupInfo)localObject4).dwGroupLevel.get();
          ((RecommendTroopInfo)localObject1).isSameCity = ((SearchGroup.GroupInfo)localObject4).bSameCity.get();
          ((RecommendTroopInfo)localObject1).isTroopFull = ((SearchGroup.GroupInfo)localObject4).bGroupFull.get();
          ((RecommendTroopInfo)localObject1).isTroopAllow = ((SearchGroup.GroupInfo)localObject4).bGroupAllow.get();
          ((RecommendTroopInfo)localObject1).isTroopIn = ((SearchGroup.GroupInfo)localObject4).bGroupIn.get();
          ((RecommendTroopInfo)localObject1).hotDegree = ((SearchGroup.GroupInfo)localObject4).dwGroupHotDegree.get();
          ((RecommendTroopInfo)localObject1).flagExt = ((SearchGroup.GroupInfo)localObject4).dwGroupFlagExt.get();
          ((RecommendTroopInfo)localObject1).authType = ((SearchGroup.GroupInfo)localObject4).dwAuthGroupType.get();
          ((RecommendTroopInfo)localObject1).location = ((SearchGroup.GroupInfo)localObject4).sGroupLocation.get();
          ((RecommendTroopInfo)localObject1).option = ((short)((SearchGroup.GroupInfo)localObject4).dwGroupOption.get());
          if (k != 0) {
            continue;
          }
          this.jdField_a_of_type_Awbw.b((awbv)localObject1);
          localObject4 = ayvw.a(-1039);
          String str = ((RecommendTroopInfo)localObject1).name;
          ((MessageRecord)localObject4).extStr = ((RecommendTroopInfo)localObject1).uin;
          ((MessageRecord)localObject4).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), aljq.Y, "0", str, l, -1039, 4001, 0L);
          localArrayList.add(localObject4);
          ((HashMap)localObject3).put(((RecommendTroopInfo)localObject1).uin, Integer.valueOf(1));
          k = i + 1;
          i = k;
          if (k < 60) {
            break label1347;
          }
        }
        localawby.c();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localawby.b();
        continue;
      }
      finally
      {
        localawby.b();
      }
      if ((localArrayList.size() >= 1) || ((localArrayList.size() == 1) && (paramList == null)))
      {
        m = 60 - localArrayList.size();
        if (m <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        f();
        e();
        return;
        this.jdField_a_of_type_Awbw.a((awbv)localObject1);
        continue;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.Y, 4001);
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = paramList.size() - 1;
        Object localObject2;
        while (i >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(i);
          if ((((MessageRecord)localObject2).msgtype == -1039) && (((HashMap)localObject3).containsKey(((MessageRecord)localObject2).extStr)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
            paramList.remove(i);
          }
          i -= 1;
        }
        j = 0;
        k = paramList.size() - 1;
        while (k >= 0)
        {
          localObject2 = (MessageRecord)paramList.get(k);
          i = j;
          if (((MessageRecord)localObject2).msgtype == -1039)
          {
            j += 1;
            i = j;
            if (j > m)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq);
              localObject2 = (RecommendTroopInfo)this.jdField_a_of_type_Awbw.a(RecommendTroopInfo.class, ((MessageRecord)localObject2).extStr);
              i = j;
              if (localObject2 != null)
              {
                this.jdField_a_of_type_Awbw.b((awbv)localObject2);
                i = j;
              }
            }
          }
          k -= 1;
          j = i;
        }
        continue;
        label1335:
        k = 1;
        continue;
        paramList = (List<group_activity.GroupAct>)localObject2;
        break;
        label1347:
        j += 1;
      }
    }
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      SosoInterface.a(this.jdField_a_of_type_Amle);
      return true;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(-1040);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void b(List<group_activity.GroupAct> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    a(paramList);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Awbw != null) {
      this.jdField_a_of_type_Awbw.a(NotificationRecommendTroopItem.class);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1039);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1040);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("unread_recommend_troop_count", 0).commit();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alws
 * JD-Core Version:    0.7.0.1
 */