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

public class ajdy
  implements View.OnClickListener
{
  public int a;
  public acam a;
  private ajea jdField_a_of_type_Ajea;
  public ajeb a;
  private ajjh jdField_a_of_type_Ajjh = new ajdz(this);
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public ajdy(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Ajeb = ((ajjj)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Acam != null)
    {
      a(this.jdField_a_of_type_Acam);
      a(1, this.jdField_a_of_type_Acam.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acam = null;
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
  
  public void a(acam paramacam)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    ajeb localajeb = this.jdField_a_of_type_Ajeb;
    if ((paramacam == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramacam.jdField_m_of_type_Int = 0;
      return;
    }
    if (localajeb != null)
    {
      if (((azks)localTroopMemberListActivity.app.getManager(203)).b(paramacam.jdField_a_of_type_JavaLangString))
      {
        paramacam.jdField_m_of_type_Int = 0;
        return;
      }
      paramacam.jdField_m_of_type_Int = localajeb.a(paramacam.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramacam.jdField_m_of_type_Int = 0;
  }
  
  public void a(acat paramacat, acam paramacam)
  {
    if (paramacat == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramacat.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramacam == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramacat.f.setVisibility(0);
        localButton = (Button)paramacat.f.findViewById(2131296551);
        paramacat = (TextView)paramacat.f.findViewById(2131296553);
        if (paramacam.jdField_m_of_type_Int != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramacat.setVisibility(0);
        return;
        if ((paramacam.jdField_m_of_type_Int == 3) || (paramacam.jdField_m_of_type_Int == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramacam.jdField_m_of_type_Int != 3) {
        break;
      }
      localButton.setTag(paramacam);
      localButton.setOnClickListener(this);
      localButton.setText(ajjy.a(2131634037));
      localButton.setVisibility(0);
      paramacat.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramacam = "";
    paramacat = "";
    if (localTroopInfo != null)
    {
      paramacat = localTroopInfo.troopuin;
      paramacam = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new awrb((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramacat, paramacam }).a();
    return;
    localButton.setVisibility(8);
    paramacat.setVisibility(8);
    return;
    label266:
    paramacat.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ajea == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ajea.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ajea.jdField_a_of_type_Int));
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
    acam localacam;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localacam = (acam)localIterator1.next();
          if ((localacam != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localacam.jdField_a_of_type_JavaLangString))) {
            a(localacam);
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
          localacam = (acam)localIterator2.next();
          if (localacam != null) {
            a(localacam);
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
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajjh);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Ajeb = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ajea == null)
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
      this.jdField_a_of_type_Ajea = new ajea((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    paramView = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((paramView instanceof acam)))
    {
      acam localacam = (acam)paramView;
      this.jdField_a_of_type_Acam = localacam;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      paramView = str;
      if (str == null)
      {
        paramView = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          paramView = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localacam.jdField_a_of_type_JavaLangString, paramView, 3004, 13, localacam.jdField_m_of_type_JavaLangString, null, null, null, null));
      paramView = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        paramView = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
      }
      new awrb(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", paramView }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajdy
 * JD-Core Version:    0.7.0.1
 */