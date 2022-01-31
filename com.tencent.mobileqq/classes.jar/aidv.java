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

public class aidv
  implements View.OnClickListener
{
  public int a;
  public aidf a;
  private aidx jdField_a_of_type_Aidx;
  private aidy jdField_a_of_type_Aidy;
  public alod a;
  private altm jdField_a_of_type_Altm = new aidw(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private bcpg jdField_a_of_type_Bcpg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  public final ArrayList<String> a;
  private List<aidf> jdField_a_of_type_JavaUtilList;
  public boolean a;
  
  public aidv(Context paramContext, aidx paramaidx, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<aidf> paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    this.jdField_a_of_type_Alod = ((alto)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bcpg = ((bcpg)paramQQAppInterface.getManager(203));
    this.jdField_a_of_type_Aidx = paramaidx;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aidf != null)
    {
      a(this.jdField_a_of_type_Aidf);
      a(1, this.jdField_a_of_type_Aidf.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aidf = null;
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
      } while (this.jdField_a_of_type_Aidx == null);
      this.jdField_a_of_type_Aidx.a();
    }
  }
  
  public void a(aidf paramaidf)
  {
    alod localalod = this.jdField_a_of_type_Alod;
    if (paramaidf == null) {
      return;
    }
    if (!a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo))
    {
      paramaidf.jdField_m_of_type_Int = 0;
      return;
    }
    if (localalod != null)
    {
      if (this.jdField_a_of_type_Bcpg.b(paramaidf.jdField_a_of_type_JavaLangString))
      {
        paramaidf.jdField_m_of_type_Int = 0;
        return;
      }
      paramaidf.jdField_m_of_type_Int = localalod.a(paramaidf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    paramaidf.jdField_m_of_type_Int = 0;
  }
  
  public void a(aidm paramaidm, aidf paramaidf)
  {
    if (paramaidm == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramaidm.f == null);
        localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (paramaidf == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
          }
          paramaidm.f.setVisibility(0);
          localButton = (Button)paramaidm.f.findViewById(2131362095);
          paramaidm = (TextView)paramaidm.f.findViewById(2131362097);
          if (paramaidf.jdField_m_of_type_Int != 2) {
            break;
          }
          localButton.setVisibility(8);
          paramaidm.setVisibility(0);
          return;
          if ((paramaidf.jdField_m_of_type_Int == 3) || (paramaidf.jdField_m_of_type_Int == 2)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramaidf.jdField_m_of_type_Int != 3) {
          break;
        }
        localButton.setTag(paramaidf);
        localButton.setOnClickListener(this);
        localButton.setText(alud.a(2131716040));
        localButton.setVisibility(0);
        paramaidm.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
    } while (localTroopInfo == null);
    paramaidm = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramaidm.setVisibility(8);
    return;
    label197:
    paramaidm.f.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Aidy == null) {
        d();
      }
    } while ((!this.jdField_a_of_type_Aidy.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Aidy.jdField_a_of_type_Int));
    return true;
  }
  
  public void b()
  {
    aidf localaidf;
    if (this.jdField_a_of_type_Int == 1) {
      try
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext())
        {
          localaidf = (aidf)localIterator1.next();
          if ((localaidf != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(localaidf.jdField_a_of_type_JavaLangString))) {
            a(localaidf);
          }
        }
        this.jdField_a_of_type_Int = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_a_of_type_Aidx != null) {
          this.jdField_a_of_type_Aidx.b();
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
            localaidf = (aidf)localIterator2.next();
            if (localaidf == null) {
              continue;
            }
            a(localaidf);
            continue;
          }
          if (this.jdField_a_of_type_Aidx == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_a_of_type_Aidx.b();
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_Alod = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Aidy == null) {
      this.jdField_a_of_type_Aidy = new aidy(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((paramView instanceof aidf)))
    {
      paramView = (aidf)paramView;
      this.jdField_a_of_type_Aidf = paramView;
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
 * Qualified Name:     aidv
 * JD-Core Version:    0.7.0.1
 */