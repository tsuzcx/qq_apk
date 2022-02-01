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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajwh
  implements View.OnClickListener
{
  public int a;
  public ajvr a;
  private ajwj jdField_a_of_type_Ajwj;
  private ajwk jdField_a_of_type_Ajwk;
  private Context jdField_a_of_type_AndroidContentContext;
  private anvi jdField_a_of_type_Anvi = new ajwi(this);
  public bbcj a;
  private bgls jdField_a_of_type_Bgls;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<ajvr> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public ajwh(Context paramContext, ajwj paramajwj, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ajvr> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Bbcj = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bgls = ((bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER));
    this.jdField_a_of_type_Ajwj = paramajwj;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajvr != null)
    {
      a(this.jdField_a_of_type_Ajvr);
      a(1, this.jdField_a_of_type_Ajvr.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajvr = null;
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
      } while (this.jdField_a_of_type_Ajwj == null);
      this.jdField_a_of_type_Ajwj.a();
    }
  }
  
  public void a(ajvr paramajvr)
  {
    bbcj localbbcj = this.jdField_a_of_type_Bbcj;
    if (paramajvr == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo))
    {
      paramajvr.o = 0;
      return;
    }
    if (localbbcj != null)
    {
      if (this.jdField_a_of_type_Bgls.b(paramajvr.jdField_a_of_type_JavaLangString))
      {
        paramajvr.o = 0;
        return;
      }
      paramajvr.o = localbbcj.a(paramajvr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramajvr.o = 0;
  }
  
  public void a(ajvy paramajvy, ajvr paramajvr)
  {
    if (paramajvy == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramajvy.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        int i;
        if (paramajvr == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramajvy.f.setVisibility(0);
          localButton = (Button)paramajvy.f.findViewById(2131362166);
          paramajvy = (TextView)paramajvy.f.findViewById(2131362168);
          if (paramajvr.o != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramajvy.setVisibility(0);
          return;
          if ((paramajvr.o == 3) || (paramajvr.o == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramajvr.o != 3) {
          break;
        }
        localButton.setTag(paramajvr);
        localButton.setOnClickListener(this);
        localButton.setText(anvx.a(2131715009));
        localButton.setVisibility(0);
        paramajvy.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramajvy = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramajvy.setVisibility(8);
    return;
    label197:
    paramajvy.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ajwk == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ajwk.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ajwk.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    ajvr localajvr;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localajvr = (ajvr)localIterator1.next();
          if ((localajvr != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localajvr.jdField_a_of_type_JavaLangString))) {
            a(localajvr);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Ajwj != null) {
          this.jdField_a_of_type_Ajwj.b();
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
            localajvr = (ajvr)localIterator2.next();
            if (localajvr == null) {
              continue;
            }
            a(localajvr);
            continue;
          }
          if (this.jdField_a_of_type_Ajwj == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Ajwj.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Bbcj = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ajwk == null) {
      this.jdField_a_of_type_Ajwk = new ajwk(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((localObject instanceof ajvr)))
    {
      localObject = (ajvr)localObject;
      this.jdField_a_of_type_Ajvr = ((ajvr)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ajvr)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((ajvr)localObject).m, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwh
 * JD-Core Version:    0.7.0.1
 */