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

public class ahzg
  implements View.OnClickListener
{
  public int a;
  public ahyq a;
  private ahzi jdField_a_of_type_Ahzi;
  private ahzj jdField_a_of_type_Ahzj;
  public aljo a;
  private alox jdField_a_of_type_Alox = new ahzh(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private bckx jdField_a_of_type_Bckx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<ahyq> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public ahzg(Context paramContext, ahzi paramahzi, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ahyq> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Aljo = ((aloz)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bckx = ((bckx)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Ahzi = paramahzi;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahyq != null)
    {
      a(this.jdField_a_of_type_Ahyq);
      a(1, this.jdField_a_of_type_Ahyq.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahyq = null;
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
      } while (this.jdField_a_of_type_Ahzi == null);
      this.jdField_a_of_type_Ahzi.a();
    }
  }
  
  public void a(ahyq paramahyq)
  {
    aljo localaljo = this.jdField_a_of_type_Aljo;
    if (paramahyq == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramahyq.jdField_m_of_type_Int = 0;
      return;
    }
    if (localaljo != null)
    {
      if (this.jdField_a_of_type_Bckx.b(paramahyq.jdField_a_of_type_JavaLangString))
      {
        paramahyq.jdField_m_of_type_Int = 0;
        return;
      }
      paramahyq.jdField_m_of_type_Int = localaljo.a(paramahyq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramahyq.jdField_m_of_type_Int = 0;
  }
  
  public void a(ahyx paramahyx, ahyq paramahyq)
  {
    if (paramahyx == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramahyx.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramahyq == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramahyx.f.setVisibility(0);
          localButton = (Button)paramahyx.f.findViewById(2131362095);
          paramahyx = (TextView)paramahyx.f.findViewById(2131362097);
          if (paramahyq.jdField_m_of_type_Int != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramahyx.setVisibility(0);
          return;
          if ((paramahyq.jdField_m_of_type_Int == 3) || (paramahyq.jdField_m_of_type_Int == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramahyq.jdField_m_of_type_Int != 3) {
          break;
        }
        localButton.setTag(paramahyq);
        localButton.setOnClickListener(this);
        localButton.setText(alpo.a(2131716028));
        localButton.setVisibility(0);
        paramahyx.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramahyx = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramahyx.setVisibility(8);
    return;
    label197:
    paramahyx.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ahzj == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ahzj.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ahzj.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    ahyq localahyq;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localahyq = (ahyq)localIterator1.next();
          if ((localahyq != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localahyq.jdField_a_of_type_JavaLangString))) {
            a(localahyq);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Ahzi != null) {
          this.jdField_a_of_type_Ahzi.b();
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
            localahyq = (ahyq)localIterator2.next();
            if (localahyq == null) {
              continue;
            }
            a(localahyq);
            continue;
          }
          if (this.jdField_a_of_type_Ahzi == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Ahzi.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_Aljo = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ahzj == null) {
      this.jdField_a_of_type_Ahzj = new ahzj(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((paramView instanceof ahyq)))
    {
      paramView = (ahyq)paramView;
      this.jdField_a_of_type_Ahyq = paramView;
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.jdField_a_of_type_JavaLangString, str, 3004, 13, paramView.jdField_m_of_type_JavaLangString, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzg
 * JD-Core Version:    0.7.0.1
 */