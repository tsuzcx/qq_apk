import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agbh
  implements View.OnClickListener
{
  public int a;
  public agau a;
  private agbj jdField_a_of_type_Agbj;
  private agbk jdField_a_of_type_Agbk;
  public ajsd a;
  private ajxl jdField_a_of_type_Ajxl = new agbi(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private balw jdField_a_of_type_Balw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<agau> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public agbh(Context paramContext, agbj paramagbj, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<agau> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Ajsd = ((ajxn)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Balw = ((balw)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Agbj = paramagbj;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agau != null)
    {
      a(this.jdField_a_of_type_Agau);
      a(1, this.jdField_a_of_type_Agau.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Agau = null;
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
      } while (this.jdField_a_of_type_Agbj == null);
      this.jdField_a_of_type_Agbj.a();
    }
  }
  
  public void a(agau paramagau)
  {
    ajsd localajsd = this.jdField_a_of_type_Ajsd;
    if (paramagau == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramagau.jdField_m_of_type_Int = 0;
      return;
    }
    if (localajsd != null)
    {
      if (this.jdField_a_of_type_Balw.b(paramagau.jdField_a_of_type_JavaLangString))
      {
        paramagau.jdField_m_of_type_Int = 0;
        return;
      }
      paramagau.jdField_m_of_type_Int = localajsd.a(paramagau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramagau.jdField_m_of_type_Int = 0;
  }
  
  public void a(agbb paramagbb, agau paramagau)
  {
    if (paramagbb == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramagbb.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramagau == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramagbb.f.setVisibility(0);
          localButton = (Button)paramagbb.f.findViewById(2131362092);
          paramagbb = (TextView)paramagbb.f.findViewById(2131362094);
          if (paramagau.jdField_m_of_type_Int != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramagbb.setVisibility(0);
          return;
          if ((paramagau.jdField_m_of_type_Int == 3) || (paramagau.jdField_m_of_type_Int == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramagau.jdField_m_of_type_Int != 3) {
          break;
        }
        localButton.setTag(paramagau);
        localButton.setOnClickListener(this);
        localButton.setText(ajyc.a(2131715645));
        localButton.setVisibility(0);
        paramagbb.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramagbb = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramagbb.setVisibility(8);
    return;
    label197:
    paramagbb.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Agbk == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Agbk.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Agbk.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    agau localagau;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localagau = (agau)localIterator1.next();
          if ((localagau != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localagau.jdField_a_of_type_JavaLangString))) {
            a(localagau);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Agbj != null) {
          this.jdField_a_of_type_Agbj.b();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        try
        {
          Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator2.hasNext())
          {
            localagau = (agau)localIterator2.next();
            if (localagau == null) {
              continue;
            }
            a(localagau);
            continue;
          }
          if (this.jdField_a_of_type_Agbj == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Agbj.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_Ajsd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Agbk == null) {
      this.jdField_a_of_type_Agbk = new agbk(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((paramView instanceof agau)))
    {
      paramView = (agau)paramView;
      this.jdField_a_of_type_Agau = paramView;
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.jdField_a_of_type_JavaLangString, str, 3004, 13, paramView.jdField_m_of_type_JavaLangString, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbh
 * JD-Core Version:    0.7.0.1
 */