import android.content.Context;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactFindTroopRTLW.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class aesq
  extends aesj
{
  static int c = 50;
  public int a;
  public aess a;
  String jdField_a_of_type_JavaLangString;
  ArrayList<RecommendTroopItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  int b;
  boolean d;
  
  public aesq(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, aesm paramaesm, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Aesm = paramaesm;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  protected aese a()
  {
    return new aevd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = false;
    ajtg localajtg = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList ,itemType = " + this.jdField_a_of_type_Int + ",keyWord = " + this.jdField_a_of_type_JavaLangString + ",loadMore = " + paramBoolean + ",this = " + this);
    }
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Int = -1;
      this.d = false;
    }
    f();
    boolean bool1;
    if (this.jdField_a_of_type_Int == 1)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label288;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1)
      {
        if (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1) {
          break label283;
        }
        bool1 = bool2;
      }
      bool2 = bool1;
      if (QLog.isColorLevel()) {
        QLog.w("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList  >= M, canRequestLocation = " + bool1);
      }
    }
    label283:
    label288:
    for (bool2 = bool1;; bool2 = true)
    {
      if (bool2)
      {
        SosoInterface.SosoLbsInfo localSosoLbsInfo = akfu.a("recommend_troop");
        if (QLog.isColorLevel()) {
          QLog.i("ac_ft.AddContactFindTroopRTLW", 2, "getRecommendTroopList  >= M, info = " + localSosoLbsInfo);
        }
        if (localSosoLbsInfo == null) {
          akfu.a(new aesr(this, "recommend_troop", localajtg, paramBoolean));
        }
      }
      else
      {
        return;
      }
      localajtg.a(1, this.jdField_b_of_type_Int, 25, paramBoolean, a());
      return;
      localajtg.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, 25, paramBoolean);
      return;
      bool1 = true;
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopNearbyTroopList isSuccess = " + paramBoolean1 + ",itemType = " + paramInt1 + ",this.itemType = " + this.jdField_a_of_type_Int + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j);
    }
    if (paramInt1 == this.jdField_a_of_type_Int)
    {
      this.d = paramBoolean2;
      if (paramBoolean1)
      {
        if (!paramBoolean3) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i + j < c) {
          break label353;
        }
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, c - i));
        this.d = true;
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      c();
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopNearbyTroopList do update Data,itemType = " + paramInt1 + ",this.itemType = " + this.jdField_a_of_type_Int + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.d) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
        }
      }
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_Aess != null) {
        this.jdField_a_of_type_Aess.a(paramBoolean1, i);
      }
      return;
      label353:
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    this.d = paramBoolean2;
    if ((paramInt1 == this.jdField_a_of_type_Int) && (paramString.equals(this.jdField_a_of_type_JavaLangString))) {
      if (paramBoolean1)
      {
        if (!paramBoolean3) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i + j < c) {
          break label315;
        }
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, c - i));
        this.d = true;
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList reach limit,this.dataList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
      }
    }
    for (;;)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      c();
      if (QLog.isColorLevel()) {
        QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "onGetAddContactFindTroopRecommendTroopList,do update Data ,itemType = " + paramInt1 + ",this.itemType = " + this.jdField_a_of_type_Int + ",keyWord = " + paramString + ",this.keyWord = " + this.jdField_a_of_type_JavaLangString + ",serverPageID = " + paramInt2 + ",dataListSize = " + i + ",newDataListSize = " + j + ",this = " + this);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.d) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
        }
      }
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_a_of_type_Aess != null) {
        this.jdField_a_of_type_Aess.a(paramBoolean1, i);
      }
      return;
      label315:
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  protected boolean a()
  {
    return this.d;
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Aese.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aese.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactFindTroopRTLW", 2, "refreshListView,this.dataList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new AddContactFindTroopRTLW.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesq
 * JD-Core Version:    0.7.0.1
 */