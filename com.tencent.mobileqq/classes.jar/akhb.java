import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.BatchAddFriendData.1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;>;
import java.util.Locale;
import java.util.Random;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;
import tencent.im.oidb.cmd0x777.cmd0x777.ReqBody;
import tencent.im.oidb.cmd0x777.cmd0x777.RspBody;

public class akhb
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = null;
  private final ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final long[] jdField_a_of_type_ArrayOfLong = new long[30];
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private final ArrayList<cmd0x777.AddFrdInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = null;
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramContext == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BatchAddFriendData", 2, String.format("onBAFTipClick troopUin_type_recUin %s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3 }));
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        Intent localIntent = new Intent(paramContext, SelectMemberActivity.class);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("group_uin", paramString1);
        localIntent.putExtra("param_groupcode", paramString2);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("param_subtype", 4);
        localIntent.putExtra("param_entrance", 30);
        localIntent.putExtra("param_max", 30);
        localIntent.putExtra("param_exit_animation", 3);
        localIntent.putExtra("batch_addfrd_scene_type", paramInt);
        if (!TextUtils.isEmpty(paramString3)) {
          localIntent.putExtra("batch_addfrd_recommand_uin", paramString3);
        }
        paramContext.startActivity(localIntent);
        ((Activity)paramContext).overridePendingTransition(2130771997, 0);
      }
      ThreadManager.post(new BatchAddFriendData.1(paramInt, paramQQAppInterface, paramString1), 8, null, true);
    } while (!QLog.isDevelopLevel());
    QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "onBAFTipClick troopUin: %s", new Object[] { paramString1 }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, List<cmd0x777.AddFrdInfo> paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "showResult not in ui thread !");
      }
    }
    do
    {
      return;
      if ((paramActivity != null) && (paramList != null) && (paramList.size() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    if (paramActivity == null) {}
    for (paramQQAppInterface = "showResult context is null !";; paramQQAppInterface = "showResult list is null or size is zero !")
    {
      QLog.d("BatchAddFriendData", 4, paramQQAppInterface);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject1 = paramList.iterator();
    int j = 0;
    int i = 0;
    label103:
    Object localObject2;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cmd0x777.AddFrdInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 1) {
            if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get() == 0) {
              k += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label103;
      m += 1;
      continue;
      if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 2)
      {
        j += 1;
        if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 1) {
          i += 1;
        } else if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 2) {
          localArrayList.add(localObject2);
        }
      }
      else
      {
        n += 1;
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "showResult total: %s, sendOk: %s, sendFail: %s, notSend: %s, clientFail: %s, refuseAdd: %s, answerQuestion: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(localArrayList.size()) }));
        }
        label353:
        label374:
        cmd0x777.AddFrdInfo localAddFrdInfo;
        if (k > 0)
        {
          bbmy.a(BaseApplication.getContext(), 0, ajjy.a(2131635271), 0).a();
          if (localArrayList.size() <= 0) {
            break label465;
          }
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = localArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label515;
          }
          localAddFrdInfo = (cmd0x777.AddFrdInfo)localIterator.next();
          if ((localObject1 != null) && (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject1).uint32_send_req_result.get())) {
            break label467;
          }
          localObject3 = localAddFrdInfo;
          paramList = (List<cmd0x777.AddFrdInfo>)localObject1;
        }
        for (;;)
        {
          localObject2 = paramList;
          localObject1 = localObject3;
          break label374;
          if ((m <= 0) && (n <= 0)) {
            break label353;
          }
          bbmy.a(BaseApplication.getContext(), 0, ajjy.a(2131635274), 0).a();
          break label353;
          label465:
          break;
          label467:
          paramList = localAddFrdInfo;
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            paramList = localAddFrdInfo;
            localObject3 = localObject1;
            if (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get())
            {
              paramList = (List<cmd0x777.AddFrdInfo>)localObject2;
              localObject3 = localObject1;
            }
          }
        }
        label515:
        Object localObject3 = null;
        if ((localArrayList.size() == 1) && (localObject1 != null)) {
          paramList = ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get();
        }
        for (;;)
        {
          paramList = babr.a(paramActivity, String.format(Locale.getDefault(), ajjy.a(2131635278), new Object[] { paramList }), 0, 0, null, null);
          paramList.setPositiveButton(2131629116, new akhc());
          if ((paramActivity != null) && (!paramActivity.isFinishing())) {
            paramList.show();
          }
          awqx.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", "notAdd_exp", 0, 0, paramString, String.valueOf(j), "", "");
          return;
          if ((localArrayList.size() == 2) && (localObject1 != null) && (localObject2 != null))
          {
            paramList = String.format(Locale.getDefault(), "%s、%s", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get() });
          }
          else
          {
            paramList = (List<cmd0x777.AddFrdInfo>)localObject3;
            if (localObject1 != null)
            {
              paramList = (List<cmd0x777.AddFrdInfo>)localObject3;
              if (localObject2 != null) {
                paramList = String.format(Locale.getDefault(), "%s、%s等%s位好友", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get(), Integer.valueOf(localArrayList.size()) });
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "doAddBAFGrayTip invalidate params!");
      }
    }
    Object localObject2;
    TroopInfo localTroopInfo;
    do
    {
      return;
      localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
      localTroopInfo = ((TroopManager)localObject2).b(paramString1);
    } while (localTroopInfo == null);
    azpj.a(paramQQAppInterface, true, localTroopInfo);
    Object localObject1 = paramQQAppInterface.a().a(paramString1, 1);
    long l1;
    label108:
    long l2;
    int j;
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
      l2 = awao.a();
      j = 0;
      if (TextUtils.isEmpty(paramString3)) {
        break label618;
      }
      i = 1;
      localObject1 = String.format(Locale.getDefault(), ajjy.a(2131635272), new Object[] { paramString3, Integer.valueOf(paramInt2) });
      if (paramInt2 != 1) {
        break label745;
      }
      paramString3 = String.format(Locale.getDefault(), ajjy.a(2131635275), new Object[] { paramString3 });
      paramInt2 = 1;
    }
    for (;;)
    {
      label187:
      label217:
      Object localObject3;
      if (paramInt1 == 0)
      {
        paramString3 = paramString3 + ajjy.a(2131635279);
        localObject1 = ajjy.a(2131635276);
        i = paramString3.indexOf((String)localObject1);
        j = ((String)localObject1).length();
        localObject1 = new aqax(paramString1, paramString1, paramString3, 1, -5020, 135178, l2);
        ((aqax)localObject1).jdField_c_of_type_JavaLangString = paramString3;
        paramString3 = new Bundle();
        paramString3.putInt("key_action", 24);
        paramString3.putString("key_action_DATA", paramString1);
        paramString3.putString("key_a_action_DATA", localTroopInfo.troopcode);
        ((aqax)localObject1).a(i, i + j, paramString3);
        localObject3 = new StringBuilder().append("newJoin-");
        if (paramInt2 == 0) {
          break label729;
        }
        paramString3 = paramString2;
        label348:
        ((aqax)localObject1).d = paramString3;
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (aqax)localObject1);
        ((MessageForUniteGrayTip)localObject3).isread = true;
        ((MessageForUniteGrayTip)localObject3).shmsgseq = l1;
        ((MessageForUniteGrayTip)localObject3).mNeedTimeStamp = true;
        ((MessageForUniteGrayTip)localObject3).updateUniteGrayTipMsgData(paramQQAppInterface);
        paramQQAppInterface.a().a((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
        localTroopInfo.dwLastInsertBAFTipTime = NetConnInfoCenter.getServerTime();
        localTroopInfo.wInsertBAFTipCount += 1;
        localTroopInfo.dwLastBAFTipMsgUniSeq = ((MessageForUniteGrayTip)localObject3).uniseq;
        ((TroopManager)localObject2).b(localTroopInfo);
        paramString3 = "1";
        if (paramInt1 > 0) {
          paramString3 = "0";
        }
        localObject2 = azpj.a(true, 1);
        if (localTroopInfo.wInsertBAFTipCount != 1) {
          break label737;
        }
      }
      label729:
      label737:
      for (localObject1 = "0";; localObject1 = "1")
      {
        awqx.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", (String)localObject2, 0, 0, paramString1, (String)localObject1, "", paramString3);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, String.format("doAddBAFGrayTip time: %s count: %s uniseq: %s, msgSeq: %s, shmsgseq: %s, recmmendUin=%s", new Object[] { Long.valueOf(localTroopInfo.dwLastInsertBAFTipTime), Integer.valueOf(localTroopInfo.wInsertBAFTipCount), Long.valueOf(localTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(l1), Long.valueOf(((MessageForUniteGrayTip)localObject3).shmsgseq), paramString2 }));
        return;
        l1 = Math.abs(new Random().nextInt());
        break label108;
        label618:
        paramString3 = String.format(Locale.getDefault(), ajjy.a(2131635277), new Object[] { Integer.valueOf(paramInt2) });
        i = j;
        localObject1 = paramString3;
        if (paramInt2 != 1) {
          break label745;
        }
        i = j;
        localObject1 = paramString3;
        if (TextUtils.isEmpty(paramString2)) {
          break label745;
        }
        paramString3 = String.format(Locale.getDefault(), ajjy.a(2131635273), new Object[] { paramString2 });
        paramInt2 = 0;
        break label187;
        paramString3 = paramString3 + ajjy.a(2131635270);
        break label217;
        paramString3 = "";
        break label348;
      }
      label745:
      paramInt2 = i;
      paramString3 = (String)localObject1;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2 * 1000L);
    int i = localCalendar.get(6);
    int j = localCalendar.get(1);
    localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong1);
    int k = localCalendar.get(6);
    int m = localCalendar.get(1);
    return ((j == m) && (i > k)) || (j > m);
  }
  
  private void b(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "sendResult friendListHandler is null ");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramFriendListHandler.app.getManager(52);
    ajjj localajjj = (ajjj)paramFriendListHandler.app.getManager(51);
    ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
    boolean bool1 = false;
    int i = 0;
    cmd0x777.AddFrdInfo localAddFrdInfo;
    label90:
    TroopMemberInfo localTroopMemberInfo;
    label160:
    int j;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localAddFrdInfo = (cmd0x777.AddFrdInfo)localArrayList.get(i);
        if (localAddFrdInfo == null)
        {
          i += 1;
        }
        else if (localAddFrdInfo.uint32_send_req_flag.get() == 2)
        {
          localTroopMemberInfo = localTroopManager.c(this.jdField_a_of_type_JavaLangString, String.valueOf(localAddFrdInfo.uint64_uin.get()));
          if (localTroopMemberInfo == null) {
            break label317;
          }
          if (!TextUtils.isEmpty(localTroopMemberInfo.troopremark))
          {
            localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopremark);
            PBUInt32Field localPBUInt32Field = localAddFrdInfo.uint32_send_req_result;
            if (localTroopMemberInfo.commonFrdCnt != -2147483648) {
              break label308;
            }
            j = 0;
            label180:
            localPBUInt32Field.set(j);
          }
        }
        else
        {
          label186:
          if (localAddFrdInfo.uint32_send_req_flag.get() == -2147483648) {
            break label473;
          }
        }
      }
    }
    label308:
    label317:
    label473:
    for (boolean bool2 = true;; bool2 = bool1)
    {
      if (localAddFrdInfo.uint32_send_req_flag.get() == 1)
      {
        bool1 = bool2;
        if (localAddFrdInfo.uint32_send_req_result.get() == 0) {
          break label90;
        }
        localajjj.a(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
        bool1 = bool2;
        break label90;
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))
        {
          localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopnick);
          break label160;
        }
        if (TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
          break label160;
        }
        localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.friendnick);
        break label160;
        j = localTroopMemberInfo.commonFrdCnt;
        break label180;
        if (!QLog.isDevelopLevel()) {
          break label186;
        }
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult TroopMemberInfo is null [troopUin: %s, memberUin: %s] ", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(localAddFrdInfo.uint64_uin.get()) }));
        break label186;
      }
      localajjj.a(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
      bool1 = bool2;
      break label90;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      paramFriendListHandler.notifyUI(112, bool1, new Object[] { this.jdField_a_of_type_JavaLangString, localArrayList });
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult isSuc: %s, troop: %s, size: %s", new Object[] { Boolean.valueOf(bool1), this.jdField_a_of_type_JavaLangString, Integer.valueOf(localArrayList.size()) }));
      return;
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, "doSendBatchAddFriendForTroopMember friendListHandler is null ");
        }
        return;
      }
      finally {}
      Object localObject = (ajjj)paramFriendListHandler.app.getManager(51);
      this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_ArrayOfLong.length);
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.jdField_b_of_type_JavaLangString);
          l1 = l2;
        }
        catch (Throwable localThrowable)
        {
          cmd0x777.ReqBody localReqBody;
          localThrowable.printStackTrace();
          continue;
        }
        localReqBody = new cmd0x777.ReqBody();
        localReqBody.uint64_group_uin.set(l1);
        localReqBody.bytes_msg.set(this.jdField_c_of_type_JavaLangString);
        localReqBody.uint32_source_id.set(this.jdField_b_of_type_Int);
        localReqBody.uint32_sub_source_id.set(this.jdField_c_of_type_Int);
        i = this.jdField_a_of_type_Int - 1;
        if (i >= 0)
        {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.remove(i)).longValue();
          this.jdField_a_of_type_ArrayOfLong[i] = l1;
          localReqBody.rpt_uint64_uin.add(Long.valueOf(l1));
          ((ajjj)localObject).a(Long.toString(l1), true);
          i -= 1;
        }
        else
        {
          localObject = paramFriendListHandler.makeOIDBPkg("OidbSvc.0x777", 1911, 1, localThrowable.toByteArray());
          ((ToServiceMsg)localObject).extraData.putLongArray("send_uin_array", this.jdField_a_of_type_ArrayOfLong);
          paramFriendListHandler.sendPbReq((ToServiceMsg)localObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "doSendBatchAddFriendForTroopMember sending: %s pending: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
          }
        }
      }
      else
      {
        b(paramFriendListHandler);
      }
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers friendListHandler is null ");
      }
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("send_uin_array");
    int i;
    if (this.jdField_a_of_type_Int <= 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers is not cur sending resp!");
        return;
        if ((paramToServiceMsg == null) || (paramToServiceMsg.length < this.jdField_a_of_type_Int))
        {
          i = 0;
          continue;
        }
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Int) {
            break label376;
          }
          if (paramToServiceMsg[i] != this.jdField_a_of_type_ArrayOfLong[i])
          {
            i = 0;
            break;
          }
          i += 1;
        }
      }
      int k = this.jdField_a_of_type_Int;
      paramToServiceMsg = new cmd0x777.RspBody();
      int m = FriendListHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (m == 0)
      {
        paramToServiceMsg = paramToServiceMsg.rpt_add_frd_info.get();
        this.jdField_a_of_type_Int = 0;
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          this.jdField_b_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = Locale.getDefault();
          if (paramToServiceMsg != null) {
            break label359;
          }
        }
      }
      label359:
      for (i = j;; i = paramToServiceMsg.size())
      {
        QLog.d("BatchAddFriendData", 4, String.format(paramFromServiceMsg, "handleAddBatchTroopMembers result: %s sending: %s, cur:%s  total: %s pending: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label370;
        }
        a(paramFriendListHandler);
        return;
        paramFromServiceMsg = new ArrayList();
        i = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i >= k) {
            break;
          }
          paramToServiceMsg = new cmd0x777.AddFrdInfo();
          paramToServiceMsg.uint64_uin.set(this.jdField_a_of_type_ArrayOfLong[i]);
          paramToServiceMsg.uint32_send_req_flag.set(-2147483648);
          paramFromServiceMsg.add(paramToServiceMsg);
          i += 1;
        }
      }
      label370:
      b(paramFriendListHandler);
      return;
      label376:
      i = 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "init uinList is null or empty!");
      }
      return false;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_a_of_type_Int > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init isSending pending: %s result: %s curSending: ", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        try
        {
          long l = Long.parseLong(paramString2);
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init pending: %s, troopuin: %s, troopcode: %s, sourceId: %s, subSourceId: %s, msg: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhb
 * JD-Core Version:    0.7.0.1
 */