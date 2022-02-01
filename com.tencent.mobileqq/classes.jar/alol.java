import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper.1;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class alol
{
  public static CopyOnWriteArrayList<aloq> a;
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bjbs jdField_a_of_type_Bjbs;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RecentPubAccHelper.1(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public alol(MqqHandler paramMqqHandler, Activity paramActivity)
  {
    this.jdField_a_of_type_Int = 1008;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011);
  }
  
  private void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).show();
  }
  
  private void a(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    bhnx.a(null, " pubAcc_follow_cancel", paramRecentBaseData.getRecentUserUin());
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "unfollow->UIN: " + paramRecentBaseData.getRecentUserUin());
    }
    a(true);
    Object localObject = (aody)paramQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((aody)localObject).a(paramRecentBaseData.getRecentUserUin());; localObject = null)
    {
      if ((localObject != null) && (tzq.a(((AccountDetail)localObject).accountFlag) == -4))
      {
        localObject = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, ocj.class);
        ((NewIntent)localObject).putExtra("cmd", "unfollow");
        mobileqq_mp.UnFollowRequest localUnFollowRequest = new mobileqq_mp.UnFollowRequest();
        localUnFollowRequest.uin.set((int)Long.parseLong(paramRecentBaseData.getRecentUserUin()));
        localUnFollowRequest.account_type.set(b());
        ((NewIntent)localObject).putExtra("data", localUnFollowRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new alom(this, paramRecentBaseData, paramQQAppInterface));
        paramQQAppInterface.startServlet((NewIntent)localObject);
      }
      for (;;)
      {
        tzq.a(paramQQAppInterface, paramRecentBaseData.getRecentUserUin());
        if (QLog.isColorLevel()) {
          QLog.d("RecentPubAccHelper", 2, "unfollow exit");
        }
        return;
        localObject = new aped(new alon(this, paramRecentBaseData, paramQQAppInterface), paramQQAppInterface);
        paramQQAppInterface.removeObserver((anui)localObject);
        paramQQAppInterface.addObserver((anui)localObject);
        apei.a(paramQQAppInterface, false, paramRecentBaseData.getRecentUserUin(), 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, new Object[] { "reportUserClickPubAccEnterAIO --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2, ", unReadFlag: " + i + ", from: " + paramInt3 });
      }
      bdll.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A31", "0X8009A31", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --pUin: " + paramString1 + ", pName: " + paramString2 + ", time: " + paramLong);
    }
    bdll.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A32", "0X8009A32", 0, 0, String.valueOf(paramLong), "", paramString2, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserUnfollowPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2);
    }
    bdll.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A34", "0X8009A34", 0, 0, "", "", paramString2, "");
  }
  
  private void a(AccountDetail paramAccountDetail, QQAppInterface paramQQAppInterface)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "deleteAccount");
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.remove(paramAccountDetail);
    paramQQAppInterface.close();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    AccountDetail localAccountDetail;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return false;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          } while (localObject == null);
          localObject = (aody)((QQAppInterface)localObject).getManager(56);
        } while (localObject == null);
        localAccountDetail = ((aody)localObject).b(paramString);
      } while (((localAccountDetail != null) && (!localAccountDetail.isShowFollowButton)) || ((localAccountDetail == null) && ("1770946116".equals(paramString))) || ((localAccountDetail != null) && ("2173223560".equals(paramString))));
      if (((aody)localObject).c(paramString) != null) {
        return true;
      }
    } while (localAccountDetail == null);
    if (localAccountDetail.followType == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int b()
  {
    return 1;
  }
  
  private void b() {}
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "showNetworkErrorToast");
    }
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).show();
  }
  
  private void b(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RecentPubAccHelper.4(this, paramQQAppInterface, paramRecentBaseData), 10L);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --mPubAccEnterList.size: " + jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        aloq localaloq = (aloq)localIterator.next();
        long l = System.currentTimeMillis() - localaloq.jdField_a_of_type_Long;
        if (l <= 3600000L) {
          a(paramQQAppInterface, localaloq.jdField_a_of_type_JavaLangString, l, localaloq.b);
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    int i = 4;
    if (paramInt2 > 0) {
      switch (paramInt1)
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "reportUserDelPublicAcc --pUin: " + paramString1 + ", pName: " + paramString2 + ", unReadNum: " + paramInt2 + ", unReadFlag: " + i + ", from: " + paramInt3);
      }
      bdll.b(paramQQAppInterface, "dc00898", "", paramString1, "0X8009A33", "0X8009A33", 0, 0, String.valueOf(i), String.valueOf(paramInt3), paramString2, "");
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    RecentUser localRecentUser = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      localRecentUser = (RecentUser)localRecentUserBaseData.getRecentUser();
      i = localRecentUserBaseData.mPosition;
    }
    if (localRecentUser != null)
    {
      aloy.a(paramQQAppInterface, paramRecentBaseData, localRecentUser);
      alpb.a(paramQQAppInterface, localRecentUser, i);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    this.jdField_a_of_type_Bjbs = null;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(Activity paramActivity, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface)
  {
    blir localblir = blir.a(paramActivity);
    localblir.a(String.format(paramActivity.getResources().getString(2131694704), new Object[] { paramRecentBaseData.mTitleName }));
    localblir.a(2131695784, 3);
    localblir.c(2131690580);
    localblir.setOnDismissListener(new aloo(this));
    localblir.a(new alop(this, paramQQAppInterface, paramRecentBaseData, localblir));
    if (!localblir.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      localblir.show();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidAppActivity, a());
      this.jdField_a_of_type_Bjbs.c(2131694703);
      this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(true);
    }
    if (this.jdField_a_of_type_Bjbs != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bjbs.isShowing())) {
        break label120;
      }
      this.jdField_a_of_type_Bjbs.show();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentPubAccHelper", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label120:
      if ((!paramBoolean) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alol
 * JD-Core Version:    0.7.0.1
 */