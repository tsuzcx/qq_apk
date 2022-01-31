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

public class ajsa
  implements View.OnClickListener
{
  public int a;
  public acky a;
  private ajsc jdField_a_of_type_Ajsc;
  public ajsd a;
  private ajxl jdField_a_of_type_Ajxl = new ajsb(this);
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public ajsa(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Ajsd = ((ajxn)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Ajxl);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Acky != null)
    {
      a(this.jdField_a_of_type_Acky);
      a(1, this.jdField_a_of_type_Acky.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acky = null;
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
  
  public void a(acky paramacky)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    ajsd localajsd = this.jdField_a_of_type_Ajsd;
    if ((paramacky == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramacky.jdField_m_of_type_Int = 0;
      return;
    }
    if (localajsd != null)
    {
      if (((balw)localTroopMemberListActivity.app.getManager(203)).b(paramacky.jdField_a_of_type_JavaLangString))
      {
        paramacky.jdField_m_of_type_Int = 0;
        return;
      }
      paramacky.jdField_m_of_type_Int = localajsd.a(paramacky.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramacky.jdField_m_of_type_Int = 0;
  }
  
  public void a(aclf paramaclf, acky paramacky)
  {
    if (paramaclf == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramaclf.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramacky == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramaclf.f.setVisibility(0);
        localButton = (Button)paramaclf.f.findViewById(2131362092);
        paramaclf = (TextView)paramaclf.f.findViewById(2131362094);
        if (paramacky.jdField_m_of_type_Int != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramaclf.setVisibility(0);
        return;
        if ((paramacky.jdField_m_of_type_Int == 3) || (paramacky.jdField_m_of_type_Int == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramacky.jdField_m_of_type_Int != 3) {
        break;
      }
      localButton.setTag(paramacky);
      localButton.setOnClickListener(this);
      localButton.setText(ajyc.a(2131699825));
      localButton.setVisibility(0);
      paramaclf.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramacky = "";
    paramaclf = "";
    if (localTroopInfo != null)
    {
      paramaclf = localTroopInfo.troopuin;
      paramacky = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new axra((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramaclf, paramacky }).a();
    return;
    localButton.setVisibility(8);
    paramaclf.setVisibility(8);
    return;
    label266:
    paramaclf.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ajsc == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ajsc.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ajsc.jdField_a_of_type_Int));
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
    acky localacky;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localacky = (acky)localIterator1.next();
          if ((localacky != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localacky.jdField_a_of_type_JavaLangString))) {
            a(localacky);
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
          localacky = (acky)localIterator2.next();
          if (localacky != null) {
            a(localacky);
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
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajxl);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Ajsd = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ajsc == null)
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
      this.jdField_a_of_type_Ajsc = new ajsc((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    paramView = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((paramView instanceof acky)))
    {
      acky localacky = (acky)paramView;
      this.jdField_a_of_type_Acky = localacky;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      paramView = str;
      if (str == null)
      {
        paramView = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          paramView = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localacky.jdField_a_of_type_JavaLangString, paramView, 3004, 13, localacky.jdField_m_of_type_JavaLangString, null, null, null, null));
      paramView = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        paramView = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
      }
      new axra(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", paramView }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajsa
 * JD-Core Version:    0.7.0.1
 */