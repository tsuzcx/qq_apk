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

public class afph
  implements View.OnClickListener
{
  public int a;
  public afou a;
  private afpj jdField_a_of_type_Afpj;
  private afpk jdField_a_of_type_Afpk;
  public ajeb a;
  private ajjh jdField_a_of_type_Ajjh = new afpi(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private azks jdField_a_of_type_Azks;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<afou> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public afph(Context paramContext, afpj paramafpj, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<afou> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Ajeb = ((ajjj)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azks = ((azks)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Afpj = paramafpj;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afou != null)
    {
      a(this.jdField_a_of_type_Afou);
      a(1, this.jdField_a_of_type_Afou.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afou = null;
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
      } while (this.jdField_a_of_type_Afpj == null);
      this.jdField_a_of_type_Afpj.a();
    }
  }
  
  public void a(afou paramafou)
  {
    ajeb localajeb = this.jdField_a_of_type_Ajeb;
    if (paramafou == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramafou.jdField_m_of_type_Int = 0;
      return;
    }
    if (localajeb != null)
    {
      if (this.jdField_a_of_type_Azks.b(paramafou.jdField_a_of_type_JavaLangString))
      {
        paramafou.jdField_m_of_type_Int = 0;
        return;
      }
      paramafou.jdField_m_of_type_Int = localajeb.a(paramafou.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramafou.jdField_m_of_type_Int = 0;
  }
  
  public void a(afpb paramafpb, afou paramafou)
  {
    if (paramafpb == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramafpb.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramafou == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramafpb.f.setVisibility(0);
          localButton = (Button)paramafpb.f.findViewById(2131296551);
          paramafpb = (TextView)paramafpb.f.findViewById(2131296553);
          if (paramafou.jdField_m_of_type_Int != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramafpb.setVisibility(0);
          return;
          if ((paramafou.jdField_m_of_type_Int == 3) || (paramafou.jdField_m_of_type_Int == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramafou.jdField_m_of_type_Int != 3) {
          break;
        }
        localButton.setTag(paramafou);
        localButton.setOnClickListener(this);
        localButton.setText(ajjy.a(2131649854));
        localButton.setVisibility(0);
        paramafpb.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramafpb = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramafpb.setVisibility(8);
    return;
    label197:
    paramafpb.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Afpk == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Afpk.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Afpk.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    afou localafou;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localafou = (afou)localIterator1.next();
          if ((localafou != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localafou.jdField_a_of_type_JavaLangString))) {
            a(localafou);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Afpj != null) {
          this.jdField_a_of_type_Afpj.b();
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
            localafou = (afou)localIterator2.next();
            if (localafou == null) {
              continue;
            }
            a(localafou);
            continue;
          }
          if (this.jdField_a_of_type_Afpj == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Afpj.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_Ajeb = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Afpk == null) {
      this.jdField_a_of_type_Afpk = new afpk(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((paramView instanceof afou)))
    {
      paramView = (afou)paramView;
      this.jdField_a_of_type_Afou = paramView;
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
 * Qualified Name:     afph
 * JD-Core Version:    0.7.0.1
 */