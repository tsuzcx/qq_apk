import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.34.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class alih
  implements alis
{
  public alih(ApolloPanel paramApolloPanel) {}
  
  public alja a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new alhr(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 0: 
      return new alhr(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 2: 
      return new algn(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    case 100: 
      if (akji.c("gamePanelSwitch") != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "loadPanel gameSwitch is 0 return null");
        }
        return null;
      }
      return new algy(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
    return new aliv(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a()
  {
    ApolloPanel.a(this.a).post(new ApolloPanel.34.1(this));
  }
  
  public void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit();
    if (paramInt < 0) {
      localEditor.remove("sp_key_apollo_current_page_index");
    }
    for (;;)
    {
      localEditor.apply();
      return;
      localEditor.putString("sp_key_apollo_current_page_index", String.valueOf(paramInt));
    }
  }
  
  public void a(List<alja> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] mShouldShowActionFloatView=", Boolean.valueOf(ApolloPanel.c(this.a)), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = ApolloPanel.a(this.a);
    int i;
    Object localObject2;
    int m;
    int k;
    if ((localObject1 != null) && (((akoa)localObject1).jdField_a_of_type_Int > 0) && (!paramList.isEmpty()))
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject2 = (alja)paramList.get(i);
        if ((localObject2 instanceof algy))
        {
          ApolloPanel.jdField_a_of_type_Int = i;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] checkGameTab jumpGameId:", Integer.valueOf(((akoa)localObject1).jdField_a_of_type_Int), ",gameTabIndex:" + ApolloPanel.jdField_a_of_type_Int });
          }
          ((algy)localObject2).a((akoa)localObject1);
          m = ApolloPanel.a(this.a, paramList, ApolloPanel.jdField_a_of_type_Int);
          a(ApolloPanel.jdField_a_of_type_Int);
          k = 1;
        }
      }
    }
    for (;;)
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      int j = k;
      i = m;
      int n;
      if (k == 0)
      {
        j = k;
        i = m;
        if (!paramBoolean)
        {
          paramBoolean = false;
          i = 0;
          ApolloPanel.a(this.a, -1);
          if (((akji)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).o)
          {
            j = ((SharedPreferences)localObject1).getInt("key_panel_bubble_tab", -1);
            i = 0;
            n = paramList1.size();
            label343:
            if (i >= n) {
              break label1129;
            }
            localObject2 = (ApolloActionPackage)paramList1.get(i);
            if ((localObject2 == null) || (((ApolloActionPackage)localObject2).packageId != j)) {
              break label681;
            }
          }
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] bubble pakcageId:", Integer.valueOf(j) });
        }
        if ((!paramBoolean) && (ApolloPanel.c(this.a)))
        {
          j = 0;
          n = paramList1.size();
          label434:
          if (j < n)
          {
            localObject2 = (ApolloActionPackage)paramList1.get(j);
            if ((localObject2 != null) && (((ApolloActionPackage)localObject2).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject2).redStartTime)) {
              paramBoolean = true;
            }
          }
        }
        for (n = j;; n = i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] hasNewAction=", Boolean.valueOf(paramBoolean), ", tabIndex=", Integer.valueOf(n) });
          }
          j = k;
          i = m;
          if (paramBoolean)
          {
            j = k;
            i = m;
            if (n < paramList.size())
            {
              k = ApolloPanel.a(this.a, paramList, n);
              m = 1;
              ApolloPanel.a(this.a, n);
              j = m;
              i = k;
              if (QLog.isColorLevel())
              {
                QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] hasNewAction, pagerIndex=", Integer.valueOf(k) });
                i = k;
                j = m;
              }
            }
          }
          n = 0;
          k = 0;
          for (;;)
          {
            if (k < paramList.size())
            {
              n += ((alja)paramList.get(k)).a();
              k += 1;
              continue;
              i += 1;
              break;
              label681:
              i += 1;
              break label343;
              j += 1;
              break label434;
            }
          }
          m = j;
          k = i;
          if (j == 0)
          {
            if ((ApolloPanel.a(this.a) < 0) || (ApolloPanel.a(this.a) >= paramList.size())) {
              break label1119;
            }
            i = ApolloPanel.a(this.a, paramList, ApolloPanel.a(this.a));
            j = 1;
          }
          label1063:
          label1080:
          label1095:
          label1101:
          label1119:
          for (;;)
          {
            if ((j == 0) && (((SharedPreferences)localObject1).contains("sp_key_apollo_current_page_index")))
            {
              localObject1 = ((SharedPreferences)localObject1).getString("sp_key_apollo_current_page_index", null);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {}
            }
            for (;;)
            {
              try
              {
                k = Integer.parseInt((String)localObject1);
                if (k >= n) {
                  break label1101;
                }
                m = 1;
                j = m;
                i = k;
              }
              catch (Exception localException1)
              {
                k = i;
                i = j;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] from previous saved, pagerIndex=", Integer.valueOf(k) });
                  i = k;
                  j = m;
                }
                k = j;
                j = i;
                i = k;
                if (i != 0) {
                  break label1080;
                }
                k = 0;
                m = paramList1.size();
                if (k >= m) {
                  break label1095;
                }
                localObject1 = (ApolloActionPackage)paramList1.get(k);
                if ((localObject1 == null) || (((ApolloActionPackage)localObject1).packageId != 0)) {
                  break label1063;
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  i = 1;
                }
                k = i;
                i = j;
                j = k;
                continue;
                k = 0;
                continue;
              }
              if (k < paramList.size())
              {
                i = ApolloPanel.a(this.a, paramList, k);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] default single action, pagerIndex=", Integer.valueOf(i) });
                }
                j = 1;
                if (j == 0) {
                  i = 1;
                }
                if (i < n)
                {
                  ApolloPanel.jdField_a_of_type_Int = i;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[setCurrentIndex] sCurrentIndex= ", Integer.valueOf(ApolloPanel.jdField_a_of_type_Int) });
                  }
                }
                return;
                QLog.e("ApolloPanel", 1, "parse previousSavedPagerIndexStr error", localException1);
                m = i;
                i = m;
                j = k;
                continue;
                k += 1;
              }
              else
              {
                continue;
                k = i;
                i = j;
                j = k;
              }
            }
          }
        }
        label1129:
        i = 0;
      }
      k = 0;
      m = 1;
    }
  }
  
  public boolean a(int paramInt)
  {
    return !ApolloActionPackage.is3DPackage(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alih
 * JD-Core Version:    0.7.0.1
 */