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

public class ajuj
  implements View.OnClickListener
{
  public int a;
  public ajtt a;
  private ajul jdField_a_of_type_Ajul;
  private ajum jdField_a_of_type_Ajum;
  private Context jdField_a_of_type_AndroidContentContext;
  private anmu jdField_a_of_type_Anmu = new ajuk(this);
  public baix a;
  private bftx jdField_a_of_type_Bftx;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<ajtt> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public ajuj(Context paramContext, ajul paramajul, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ajtt> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Baix = ((anmw)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bftx = ((bftx)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Ajul = paramajul;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajtt != null)
    {
      a(this.jdField_a_of_type_Ajtt);
      a(1, this.jdField_a_of_type_Ajtt.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajtt = null;
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
      } while (this.jdField_a_of_type_Ajul == null);
      this.jdField_a_of_type_Ajul.a();
    }
  }
  
  public void a(ajtt paramajtt)
  {
    baix localbaix = this.jdField_a_of_type_Baix;
    if (paramajtt == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramajtt.n = 0;
      return;
    }
    if (localbaix != null)
    {
      if (this.jdField_a_of_type_Bftx.b(paramajtt.jdField_a_of_type_JavaLangString))
      {
        paramajtt.n = 0;
        return;
      }
      paramajtt.n = localbaix.a(paramajtt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramajtt.n = 0;
  }
  
  public void a(ajua paramajua, ajtt paramajtt)
  {
    if (paramajua == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramajua.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramajtt == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramajua.f.setVisibility(0);
          localButton = (Button)paramajua.f.findViewById(2131362156);
          paramajua = (TextView)paramajua.f.findViewById(2131362158);
          if (paramajtt.n != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramajua.setVisibility(0);
          return;
          if ((paramajtt.n == 3) || (paramajtt.n == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramajtt.n != 3) {
          break;
        }
        localButton.setTag(paramajtt);
        localButton.setOnClickListener(this);
        localButton.setText(anni.a(2131714321));
        localButton.setVisibility(0);
        paramajua.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramajua = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramajua.setVisibility(8);
    return;
    label197:
    paramajua.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Ajum == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Ajum.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Ajum.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    ajtt localajtt;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localajtt = (ajtt)localIterator1.next();
          if ((localajtt != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localajtt.jdField_a_of_type_JavaLangString))) {
            a(localajtt);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Ajul != null) {
          this.jdField_a_of_type_Ajul.b();
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
            localajtt = (ajtt)localIterator2.next();
            if (localajtt == null) {
              continue;
            }
            a(localajtt);
            continue;
          }
          if (this.jdField_a_of_type_Ajul == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Ajul.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_Baix = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Ajum == null) {
      this.jdField_a_of_type_Ajum = new ajum(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((localObject instanceof ajtt)))
    {
      localObject = (ajtt)localObject;
      this.jdField_a_of_type_Ajtt = ((ajtt)localObject);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((ajtt)localObject).jdField_a_of_type_JavaLangString, str, 3004, 13, ((ajtt)localObject).m, null, null, null, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        long l = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuj
 * JD-Core Version:    0.7.0.1
 */