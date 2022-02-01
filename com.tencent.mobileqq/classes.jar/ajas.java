import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajas
  implements View.OnClickListener
{
  public int a;
  public ajac a;
  private ajau jdField_a_of_type_Ajau;
  private ajav jdField_a_of_type_Ajav;
  private amsu jdField_a_of_type_Amsu = new ajat(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public azwd a;
  private bfdm jdField_a_of_type_Bfdm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<ajac> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public ajas(Context paramContext, ajau paramajau, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ajac> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Azwd = ((amsw)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bfdm = ((bfdm)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Ajau = paramajau;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajac != null)
    {
      a(this.jdField_a_of_type_Ajac);
      a(1, this.jdField_a_of_type_Ajac.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajac = null;
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
      } while (this.jdField_a_of_type_Ajau == null);
      this.jdField_a_of_type_Ajau.a();
    }
  }
  
  public void a(ajac paramajac)
  {
    azwd localazwd = this.jdField_a_of_type_Azwd;
    if (paramajac == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramajac.n = 0;
      return;
    }
    if (localazwd != null)
    {
      if (this.jdField_a_of_type_Bfdm.b(paramajac.jdField_a_of_type_JavaLangString))
      {
        paramajac.n = 0;
        return;
      }
      paramajac.n = localazwd.a(paramajac.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramajac.n = 0;
  }
  
  public void a(ajaj paramajaj, ajac paramajac)
  {
    if (paramajaj == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramajaj.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        int i;
        if (paramajac == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramajaj.f.setVisibility(0);
          localButton = (Button)paramajaj.f.findViewById(2131362162);
          paramajaj = (TextView)paramajaj.f.findViewById(2131362164);
          if (paramajac.n != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramajaj.setVisibility(0);
          return;
          if ((paramajac.n == 3) || (paramajac.n == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramajac.n != 3) {
          break;
        }
        localButton.setTag(paramajac);
        localButton.setOnClickListener(this);
        localButton.setText(amtj.a(2131714662));
        localButton.setVisibility(0);
        paramajaj.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramajaj = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramajaj.setVisibility(8);
    return;
    label197:
    paramajaj.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ajav == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ajav.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ajav.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    ajac localajac;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localajac = (ajac)localIterator1.next();
          if ((localajac != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localajac.jdField_a_of_type_JavaLangString))) {
            a(localajac);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Ajau != null) {
          this.jdField_a_of_type_Ajau.b();
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
            localajac = (ajac)localIterator2.next();
            if (localajac == null) {
              continue;
            }
            a(localajac);
            continue;
          }
          if (this.jdField_a_of_type_Ajau == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Ajau.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_Azwd = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ajav == null) {
      this.jdField_a_of_type_Ajav = new ajav(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((localObject instanceof ajac)))
    {
      localObject = (ajac)localObject;
      this.jdField_a_of_type_Ajac = ((ajac)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ajac)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((ajac)localObject).m, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajas
 * JD-Core Version:    0.7.0.1
 */