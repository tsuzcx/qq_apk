import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.AddFrdHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aloa
  implements View.OnClickListener
{
  public int a;
  public aegt a;
  private aloc jdField_a_of_type_Aloc;
  public alod a;
  private altm jdField_a_of_type_Altm = new alob(this);
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public aloa(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Alod = ((alto)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Altm);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aegt != null)
    {
      a(this.jdField_a_of_type_Aegt);
      a(1, this.jdField_a_of_type_Aegt.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aegt = null;
      return;
      b();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Int < 2) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b();
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramString == null) || (!paramString.isResume()));
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void a(aegt paramaegt)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    alod localalod = this.jdField_a_of_type_Alod;
    if ((paramaegt == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramaegt.jdField_m_of_type_Int = 0;
      return;
    }
    if (localalod != null)
    {
      if (((bcpg)localTroopMemberListActivity.app.getManager(203)).b(paramaegt.jdField_a_of_type_JavaLangString))
      {
        paramaegt.jdField_m_of_type_Int = 0;
        return;
      }
      paramaegt.jdField_m_of_type_Int = localalod.a(paramaegt.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramaegt.jdField_m_of_type_Int = 0;
  }
  
  public void a(aeha paramaeha, aegt paramaegt)
  {
    if (paramaeha == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramaeha.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramaegt == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramaeha.f.setVisibility(0);
        localButton = (Button)paramaeha.f.findViewById(2131362095);
        paramaeha = (TextView)paramaeha.f.findViewById(2131362097);
        if (paramaegt.jdField_m_of_type_Int != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramaeha.setVisibility(0);
        return;
        if ((paramaegt.jdField_m_of_type_Int == 3) || (paramaegt.jdField_m_of_type_Int == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramaegt.jdField_m_of_type_Int != 3) {
        break;
      }
      localButton.setTag(paramaegt);
      localButton.setOnClickListener(this);
      localButton.setText(alud.a(2131700217));
      localButton.setVisibility(0);
      paramaeha.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramaegt = "";
    paramaeha = "";
    if (localTroopInfo != null)
    {
      paramaeha = localTroopInfo.troopuin;
      paramaegt = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new azqx((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramaeha, paramaegt }).a();
    return;
    localButton.setVisibility(8);
    paramaeha.setVisibility(8);
    return;
    label266:
    paramaeha.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Aloc == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Aloc.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Aloc.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((localTroopMemberListActivity == null) || (localTroopMemberListActivity.isFinishing()) || (!localTroopMemberListActivity.isResume())) {
      if (QLog.isColorLevel()) {
        QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
      }
    }
    do
    {
      return;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
    return;
    aegt localaegt;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localaegt = (aegt)localIterator1.next();
          if ((localaegt != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localaegt.jdField_a_of_type_JavaLangString))) {
            a(localaegt);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localTroopMemberListActivity.o();
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
      if (this.jdField_a_of_type_Int != 2) {
        continue;
      }
      try
      {
        Iterator localIterator2 = localThrowable1.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          localaegt = (aegt)localIterator2.next();
          if (localaegt != null) {
            a(localaegt);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        localThrowable1.o();
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Altm);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Alod = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aloc == null)
    {
      TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localTroopMemberListActivity != null)
      {
        localObject1 = localObject2;
        if (localTroopMemberListActivity.app != null) {
          localObject1 = localTroopMemberListActivity.app.getCurrentAccountUin();
        }
      }
      this.jdField_a_of_type_Aloc = new aloc((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    paramView = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((paramView instanceof aegt)))
    {
      aegt localaegt = (aegt)paramView;
      this.jdField_a_of_type_Aegt = localaegt;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      paramView = str;
      if (str == null)
      {
        paramView = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          paramView = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localaegt.jdField_a_of_type_JavaLangString, paramView, 3004, 13, localaegt.jdField_m_of_type_JavaLangString, null, null, null, null));
      paramView = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        paramView = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
      }
      new azqx(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", paramView }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aloa
 * JD-Core Version:    0.7.0.1
 */