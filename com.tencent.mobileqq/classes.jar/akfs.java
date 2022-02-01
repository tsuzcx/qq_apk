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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akfs
  implements View.OnClickListener
{
  public int a;
  public akfc a;
  private akfu jdField_a_of_type_Akfu;
  private akfv jdField_a_of_type_Akfv;
  private Context jdField_a_of_type_AndroidContentContext;
  private anyu jdField_a_of_type_Anyu = new akft(this);
  public bbbq a;
  private bgty jdField_a_of_type_Bgty;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<akfc> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public akfs(Context paramContext, akfu paramakfu, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<akfc> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Bbbq = ((anyw)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bgty = ((bgty)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Akfu = paramakfu;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akfc != null)
    {
      a(this.jdField_a_of_type_Akfc);
      a(1, this.jdField_a_of_type_Akfc.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Akfc = null;
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
      } while (this.jdField_a_of_type_Akfu == null);
      this.jdField_a_of_type_Akfu.a();
    }
  }
  
  public void a(akfc paramakfc)
  {
    bbbq localbbbq = this.jdField_a_of_type_Bbbq;
    if (paramakfc == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramakfc.n = 0;
      return;
    }
    if (localbbbq != null)
    {
      if (this.jdField_a_of_type_Bgty.b(paramakfc.jdField_a_of_type_JavaLangString))
      {
        paramakfc.n = 0;
        return;
      }
      paramakfc.n = localbbbq.a(paramakfc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramakfc.n = 0;
  }
  
  public void a(akfj paramakfj, akfc paramakfc)
  {
    if (paramakfj == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramakfj.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramakfc == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramakfj.f.setVisibility(0);
          localButton = (Button)paramakfj.f.findViewById(2131362162);
          paramakfj = (TextView)paramakfj.f.findViewById(2131362164);
          if (paramakfc.n != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramakfj.setVisibility(0);
          return;
          if ((paramakfc.n == 3) || (paramakfc.n == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramakfc.n != 3) {
          break;
        }
        localButton.setTag(paramakfc);
        localButton.setOnClickListener(this);
        localButton.setText(anzj.a(2131714430));
        localButton.setVisibility(0);
        paramakfj.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramakfj = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramakfj.setVisibility(8);
    return;
    label197:
    paramakfj.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Akfv == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Akfv.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Akfv.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    akfc localakfc;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localakfc = (akfc)localIterator1.next();
          if ((localakfc != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localakfc.jdField_a_of_type_JavaLangString))) {
            a(localakfc);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Akfu != null) {
          this.jdField_a_of_type_Akfu.b();
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
            localakfc = (akfc)localIterator2.next();
            if (localakfc == null) {
              continue;
            }
            a(localakfc);
            continue;
          }
          if (this.jdField_a_of_type_Akfu == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Akfu.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Bbbq = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Akfv == null) {
      this.jdField_a_of_type_Akfv = new akfv(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((localObject instanceof akfc)))
    {
      localObject = (akfc)localObject;
      this.jdField_a_of_type_Akfc = ((akfc)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((akfc)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((akfc)localObject).m, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfs
 * JD-Core Version:    0.7.0.1
 */