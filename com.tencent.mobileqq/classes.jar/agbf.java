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

public class agbf
  implements View.OnClickListener
{
  public int a;
  public agas a;
  private agbh jdField_a_of_type_Agbh;
  private agbi jdField_a_of_type_Agbi;
  public ajsb a;
  private ajxj jdField_a_of_type_Ajxj = new agbg(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private bamk jdField_a_of_type_Bamk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<agas> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public agbf(Context paramContext, agbh paramagbh, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<agas> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Ajsb = ((ajxl)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bamk = ((bamk)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Agbh = paramagbh;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agas != null)
    {
      a(this.jdField_a_of_type_Agas);
      a(1, this.jdField_a_of_type_Agas.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Agas = null;
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
      } while (this.jdField_a_of_type_Agbh == null);
      this.jdField_a_of_type_Agbh.a();
    }
  }
  
  public void a(agas paramagas)
  {
    ajsb localajsb = this.jdField_a_of_type_Ajsb;
    if (paramagas == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramagas.jdField_m_of_type_Int = 0;
      return;
    }
    if (localajsb != null)
    {
      if (this.jdField_a_of_type_Bamk.b(paramagas.jdField_a_of_type_JavaLangString))
      {
        paramagas.jdField_m_of_type_Int = 0;
        return;
      }
      paramagas.jdField_m_of_type_Int = localajsb.a(paramagas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramagas.jdField_m_of_type_Int = 0;
  }
  
  public void a(agaz paramagaz, agas paramagas)
  {
    if (paramagaz == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramagaz.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramagas == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramagaz.f.setVisibility(0);
          localButton = (Button)paramagaz.f.findViewById(2131362091);
          paramagaz = (TextView)paramagaz.f.findViewById(2131362093);
          if (paramagas.jdField_m_of_type_Int != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramagaz.setVisibility(0);
          return;
          if ((paramagas.jdField_m_of_type_Int == 3) || (paramagas.jdField_m_of_type_Int == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramagas.jdField_m_of_type_Int != 3) {
          break;
        }
        localButton.setTag(paramagas);
        localButton.setOnClickListener(this);
        localButton.setText(ajya.a(2131715656));
        localButton.setVisibility(0);
        paramagaz.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramagaz = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramagaz.setVisibility(8);
    return;
    label197:
    paramagaz.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Agbi == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Agbi.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Agbi.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    agas localagas;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localagas = (agas)localIterator1.next();
          if ((localagas != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localagas.jdField_a_of_type_JavaLangString))) {
            a(localagas);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Agbh != null) {
          this.jdField_a_of_type_Agbh.b();
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
            localagas = (agas)localIterator2.next();
            if (localagas == null) {
              continue;
            }
            a(localagas);
            continue;
          }
          if (this.jdField_a_of_type_Agbh == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Agbh.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_Ajsb = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Agbi == null) {
      this.jdField_a_of_type_Agbi = new agbi(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((paramView instanceof agas)))
    {
      paramView = (agas)paramView;
      this.jdField_a_of_type_Agas = paramView;
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
 * Qualified Name:     agbf
 * JD-Core Version:    0.7.0.1
 */