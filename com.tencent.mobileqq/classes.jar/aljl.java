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

public class aljl
  implements View.OnClickListener
{
  public int a;
  public aece a;
  private aljn jdField_a_of_type_Aljn;
  public aljo a;
  private alox jdField_a_of_type_Alox = new aljm(this);
  public TroopMemberListActivity a;
  public final ArrayList<String> a;
  public boolean a;
  
  public aljl(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Aljo = ((aloz)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.jdField_a_of_type_Alox);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aece != null)
    {
      a(this.jdField_a_of_type_Aece);
      a(1, this.jdField_a_of_type_Aece.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aece = null;
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
  
  public void a(aece paramaece)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    aljo localaljo = this.jdField_a_of_type_Aljo;
    if ((paramaece == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramaece.jdField_m_of_type_Int = 0;
      return;
    }
    if (localaljo != null)
    {
      if (((bckx)localTroopMemberListActivity.app.getManager(203)).b(paramaece.jdField_a_of_type_JavaLangString))
      {
        paramaece.jdField_m_of_type_Int = 0;
        return;
      }
      paramaece.jdField_m_of_type_Int = localaljo.a(paramaece.jdField_a_of_type_JavaLangString, localTroopMemberListActivity.app);
      return;
    }
    paramaece.jdField_m_of_type_Int = 0;
  }
  
  public void a(aecl paramaecl, aece paramaece)
  {
    if (paramaecl == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramaecl.f == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (paramaece == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramaecl.f.setVisibility(0);
        localButton = (Button)paramaecl.f.findViewById(2131362095);
        paramaecl = (TextView)paramaecl.f.findViewById(2131362097);
        if (paramaece.jdField_m_of_type_Int != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramaecl.setVisibility(0);
        return;
        if ((paramaece.jdField_m_of_type_Int == 3) || (paramaece.jdField_m_of_type_Int == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (paramaece.jdField_m_of_type_Int != 3) {
        break;
      }
      localButton.setTag(paramaece);
      localButton.setOnClickListener(this);
      localButton.setText(alpo.a(2131700205));
      localButton.setVisibility(0);
      paramaecl.setVisibility(8);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    paramaece = "";
    paramaecl = "";
    if (localTroopInfo != null)
    {
      paramaecl = localTroopInfo.troopuin;
      paramaece = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new azmo((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramaecl, paramaece }).a();
    return;
    localButton.setVisibility(8);
    paramaecl.setVisibility(8);
    return;
    label266:
    paramaecl.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Aljn == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Aljn.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Aljn.jdField_a_of_type_Int));
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
    aece localaece;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localaece = (aece)localIterator1.next();
          if ((localaece != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localaece.jdField_a_of_type_JavaLangString))) {
            a(localaece);
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
          localaece = (aece)localIterator2.next();
          if (localaece != null) {
            a(localaece);
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
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Alox);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Aljo = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aljn == null)
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
      this.jdField_a_of_type_Aljn = new aljn((String)localObject1);
    }
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    paramView = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((paramView instanceof aece)))
    {
      aece localaece = (aece)paramView;
      this.jdField_a_of_type_Aece = localaece;
      String str = localTroopMemberListActivity.jdField_a_of_type_JavaLangString;
      paramView = str;
      if (str == null)
      {
        paramView = str;
        if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          paramView = localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, localaece.jdField_a_of_type_JavaLangString, paramView, 3004, 13, localaece.jdField_m_of_type_JavaLangString, null, null, null, null));
      paramView = "";
      if (localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        paramView = String.valueOf(localTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
      }
      new azmo(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", paramView }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aljl
 * JD-Core Version:    0.7.0.1
 */