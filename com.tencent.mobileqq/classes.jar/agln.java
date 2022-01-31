import Wallet.PfaFriend;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.TopayManager.1;
import com.tencent.mobileqq.activity.qwallet.TopayManager.2;
import com.tencent.mobileqq.activity.qwallet.TopayManager.5;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class agln
{
  public static int a;
  public static PfaFriendRsp a;
  protected static ajql a;
  public static Handler a;
  public static String a;
  public static WeakReference<aglt> a;
  public static int b;
  public static String b;
  protected static WeakReference<QWalletPayProgressDialog> b;
  public static int c;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "recommend";
    jdField_b_of_type_JavaLangString = "tips";
    jdField_a_of_type_AndroidOsHandler = new aglo(Looper.myLooper());
    jdField_a_of_type_Ajql = new ajql(jdField_a_of_type_AndroidOsHandler);
  }
  
  public static ArrayList<PfaFriend> a()
  {
    QQAppInterface localQQAppInterface = agwj.a();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        return null;
        localObject1 = localQQAppInterface.a().a();
      } while (localObject1 == null);
      localObject2 = ((akeu)localObject1).a(true);
    } while (localObject2 == null);
    Object localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
      if ((localRecentUser != null) && (!azzz.a(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1006) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 1) && ((localRecentUser.getType() != 0) || (!mqb.b(localQQAppInterface, localRecentUser.uin, localRecentUser.getType()))) && (localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000))
      {
        PfaFriend localPfaFriend = new PfaFriend();
        localPfaFriend.uin = localRecentUser.uin;
        ((ArrayList)localObject1).add(localPfaFriend);
      }
    }
    return localObject1;
  }
  
  public static HashMap<String, Object> a(aglt paramaglt, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaglt);
    if ((paramInt1 != jdField_b_of_type_Int) || (paramInt2 != c))
    {
      jdField_a_of_type_WalletPfaFriendRsp = null;
      jdField_a_of_type_Int = -1;
      jdField_b_of_type_Int = paramInt1;
      c = paramInt2;
    }
    paramaglt = new HashMap();
    if (jdField_a_of_type_WalletPfaFriendRsp == null)
    {
      paramaglt.put(jdField_a_of_type_JavaLangString, a());
      if (jdField_a_of_type_Int == -1)
      {
        jdField_a_of_type_Int = 1;
        ThreadManager.getFileThreadHandler().post(new TopayManager.1(paramInt1, paramInt2, paramBoolean));
        return paramaglt;
      }
    }
    else
    {
      if (jdField_a_of_type_WalletPfaFriendRsp.use_default != 1) {
        break label142;
      }
      paramaglt.put(jdField_a_of_type_JavaLangString, a());
    }
    for (;;)
    {
      paramaglt.put(jdField_b_of_type_JavaLangString, jdField_a_of_type_WalletPfaFriendRsp.vecPfaMsg);
      if (!paramBoolean) {
        break;
      }
      a(paramInt1, paramInt2);
      return paramaglt;
      label142:
      paramaglt.put(jdField_a_of_type_JavaLangString, jdField_a_of_type_WalletPfaFriendRsp.vecRec);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = agwj.a();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.addObserver(jdField_a_of_type_Ajql);
    PfaFriendRqt localPfaFriendRqt = new PfaFriendRqt();
    localPfaFriendRqt.mqq_version = babp.a(BaseApplicationImpl.getContext());
    if (jdField_a_of_type_WalletPfaFriendRsp != null)
    {
      localPfaFriendRqt.pfa_msg_edition = jdField_a_of_type_WalletPfaFriendRsp.pfa_msg_edition;
      TicketManager localTicketManager = (TicketManager)localQQAppInterface.getManager(2);
      if (localTicketManager != null) {
        localPfaFriendRqt.skey = localTicketManager.getSkey(localQQAppInterface.getCurrentAccountUin());
      }
      localPfaFriendRqt.pfa_sub_type = 0;
      if (paramInt1 == 1)
      {
        if (paramInt2 != 1) {
          break label123;
        }
        localPfaFriendRqt.pfa_sub_type = 1;
      }
    }
    for (;;)
    {
      ((ajqk)localQQAppInterface.a(42)).a(localPfaFriendRqt);
      return;
      localPfaFriendRqt.pfa_msg_edition = "0";
      break;
      label123:
      if (paramInt2 == 2) {
        localPfaFriendRqt.pfa_sub_type = 2;
      }
    }
  }
  
  public static void a(SelectMemberActivity paramSelectMemberActivity, ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.isFinishing()) || (paramSelectMemberActivity.getIntent() == null) || (paramSelectMemberActivity.getIntent().getExtras() == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ajjy.a(2131649233);
    Object localObject1 = localObject2;
    int i;
    label57:
    ResultRecord localResultRecord;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      i = 0;
      if (i < paramArrayList.size())
      {
        localResultRecord = (ResultRecord)paramArrayList.get(i);
        localObject2 = localObject1;
        if (localResultRecord != null)
        {
          localObject2 = localObject1;
          if (localResultRecord.jdField_a_of_type_Int == 0)
          {
            localObject2 = localObject1;
            if (localResultRecord.jdField_a_of_type_JavaLangString != null)
            {
              localArrayList.add(localResultRecord);
              if (TextUtils.isEmpty(localResultRecord.jdField_b_of_type_JavaLangString)) {
                break label189;
              }
              localObject1 = (String)localObject1 + localResultRecord.jdField_b_of_type_JavaLangString;
              label147:
              if (i >= paramArrayList.size() - 1) {
                break label371;
              }
            }
          }
        }
      }
    }
    label189:
    label371:
    for (localObject2 = (String)localObject1 + "、";; localObject2 = localObject1)
    {
      i += 1;
      localObject1 = localObject2;
      break label57;
      localObject1 = (String)localObject1 + localResultRecord.jdField_a_of_type_JavaLangString;
      break label147;
      if ((localArrayList == null) || (localArrayList.size() <= 0))
      {
        bbmy.a(paramSelectMemberActivity, paramSelectMemberActivity.getString(2131654446), 0).a();
        return;
      }
      paramArrayList = new aglp(new WeakReference(paramSelectMemberActivity), localArrayList);
      localObject2 = paramSelectMemberActivity.getIntent().getExtras();
      paramSelectMemberActivity = babr.a(paramSelectMemberActivity, (String)localObject1, ((Bundle)localObject2).getString("choose_friend_content"), ((Bundle)localObject2).getString("choose_friend_subcontent"), paramSelectMemberActivity.f, null, paramArrayList, paramArrayList, 36, false);
      awqx.b(agwj.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.windowshow", 0, 0, "", "", "", "");
      paramSelectMemberActivity = paramSelectMemberActivity.getTitleTextView();
      if (paramSelectMemberActivity == null) {
        break;
      }
      paramSelectMemberActivity.setSingleLine(false);
      paramSelectMemberActivity.setMaxLines(2);
      paramSelectMemberActivity.setEllipsize(TextUtils.TruncateAt.END);
      paramSelectMemberActivity.setGravity(3);
      return;
    }
  }
  
  public static void a(SelectMemberActivity paramSelectMemberActivity, ArrayList<ResultRecord> paramArrayList, bagn parambagn)
  {
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.isFinishing()) || (paramSelectMemberActivity.getIntent() == null) || (paramSelectMemberActivity.getIntent().getExtras() == null)) {}
    ResultReceiver localResultReceiver;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    label136:
    label174:
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramArrayList == null) || (paramArrayList.size() <= 0));
        localResultReceiver = (ResultReceiver)paramSelectMemberActivity.getIntent().getParcelableExtra("aapay_result_recevier");
      } while (localResultReceiver == null);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        localArrayList1.add(localResultRecord.jdField_a_of_type_JavaLangString);
        if (localResultRecord.d == null)
        {
          paramArrayList = "";
          localArrayList2.add(paramArrayList);
          if (localResultRecord.jdField_b_of_type_JavaLangString != null) {
            break label174;
          }
        }
        for (paramArrayList = "";; paramArrayList = localResultRecord.jdField_b_of_type_JavaLangString)
        {
          localArrayList3.add(paramArrayList);
          break;
          paramArrayList = localResultRecord.d;
          break label136;
        }
      }
    } while (localArrayList1.size() <= 0);
    paramArrayList = new Bundle();
    paramArrayList.putStringArrayList("choose_friend_uins", localArrayList1);
    paramArrayList.putStringArrayList("choose_friend_phones", localArrayList2);
    paramArrayList.putStringArrayList("choose_friend_names", localArrayList3);
    if (parambagn != null) {
      paramArrayList.putString("choose_friend_feedback", parambagn.getInputValue());
    }
    parambagn = new TopayManager.5(null, new WeakReference(paramSelectMemberActivity), localResultReceiver, localArrayList1, localArrayList3);
    b(paramSelectMemberActivity, true);
    paramSelectMemberActivity = Parcel.obtain();
    parambagn.writeToParcel(paramSelectMemberActivity, 0);
    paramSelectMemberActivity.setDataPosition(0);
    parambagn = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramSelectMemberActivity);
    paramSelectMemberActivity.recycle();
    paramArrayList.putParcelable("callback", parambagn);
    localResultReceiver.send(0, paramArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_WalletPfaFriendRsp = null;
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      jdField_b_of_type_JavaLangRefWeakReference.clear();
      jdField_b_of_type_JavaLangRefWeakReference = null;
    }
    if (paramQQAppInterface != null) {
      paramQQAppInterface.removeObserver(jdField_a_of_type_Ajql);
    }
  }
  
  protected static void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aglt localaglt = (aglt)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaglt != null) {
        localaglt.b(paramBoolean);
      }
    }
  }
  
  public static void a(boolean paramBoolean1, PfaFriendRsp paramPfaFriendRsp, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && ((!paramBoolean1) || (paramPfaFriendRsp == null) || ((paramPfaFriendRsp != null) && (paramPfaFriendRsp.ret != 0)))) {
      return;
    }
    if ((!paramBoolean2) && (jdField_a_of_type_WalletPfaFriendRsp != null) && (paramPfaFriendRsp != null) && ((paramPfaFriendRsp.vecPfaMsg == null) || (paramPfaFriendRsp.vecPfaMsg.size() <= 0)))
    {
      jdField_a_of_type_WalletPfaFriendRsp.vecRec = paramPfaFriendRsp.vecRec;
      jdField_a_of_type_WalletPfaFriendRsp.use_default = paramPfaFriendRsp.use_default;
      jdField_a_of_type_WalletPfaFriendRsp.vecSpfaRec = paramPfaFriendRsp.vecSpfaRec;
      label85:
      if (paramBoolean2) {
        break label127;
      }
    }
    label127:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      a(paramBoolean1);
      if ((paramBoolean2) || (jdField_a_of_type_WalletPfaFriendRsp == null)) {
        break;
      }
      ThreadManager.getFileThreadHandler().post(new TopayManager.2());
      return;
      jdField_a_of_type_WalletPfaFriendRsp = paramPfaFriendRsp;
      break label85;
    }
  }
  
  private static void b(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.isFinishing())) {}
    do
    {
      return;
      Object localObject = null;
      if (paramBoolean)
      {
        paramBaseActivity = new QWalletPayProgressDialog(paramBaseActivity);
        jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
        paramBaseActivity.show();
        return;
      }
      paramBaseActivity = localObject;
      if (jdField_b_of_type_JavaLangRefWeakReference != null) {
        paramBaseActivity = (QWalletPayProgressDialog)jdField_b_of_type_JavaLangRefWeakReference.get();
      }
    } while ((paramBaseActivity == null) || (!paramBaseActivity.isShowing()));
    paramBaseActivity.dismiss();
  }
  
  private static void c(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    if (paramList1.size() == 1)
    {
      Intent localIntent = aciy.a(new Intent(paramActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", (String)paramList1.get(0));
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", (String)paramList2.get(0));
      localIntent.setFlags(335544320);
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
      if (paramList1.size() > 1)
      {
        paramList1 = new Intent(paramActivity, SplashActivity.class);
        paramList1.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
        paramList1.setFlags(67108864);
        paramActivity.startActivity(paramList1);
      }
    }
  }
  
  private static void d(Activity paramActivity, List<String> paramList1, List<String> paramList2)
  {
    aglr localaglr = new aglr(paramActivity);
    paramList1 = new agls(paramActivity, paramList1, paramList2);
    paramActivity = babr.a(paramActivity, 230, null, ajjy.a(2131649234), ajjy.a(2131649232), "留在QQ", paramList1, localaglr);
    paramActivity.setCancelable(false);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agln
 * JD-Core Version:    0.7.0.1
 */