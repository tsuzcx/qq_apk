import android.text.TextUtils;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class adng
  extends NearbyObserver
{
  public adng(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyHybridFragment", 2, "onSetFilterList");
    }
    NearPeopleFilters localNearPeopleFilters = new NearPeopleFilters();
    localNearPeopleFilters.jdField_a_of_type_Int = NearbyHybridFragment.a(this.a, paramInt1);
    localNearPeopleFilters.jdField_b_of_type_Int = paramInt2;
    localNearPeopleFilters.jdField_c_of_type_Int = paramInt3;
    localNearPeopleFilters.jdField_d_of_type_Int = paramInt4;
    localNearPeopleFilters.e = paramInt9;
    localNearPeopleFilters.f = paramInt5;
    localNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[0] = String.valueOf(paramInt6);
    localNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[1] = String.valueOf(paramInt7);
    localNearPeopleFilters.jdField_d_of_type_ArrayOfJavaLangString[2] = String.valueOf(paramInt8);
    localNearPeopleFilters.jdField_b_of_type_JavaLangString = paramString1;
    localNearPeopleFilters.jdField_c_of_type_JavaLangString = paramString2;
    localNearPeopleFilters.jdField_d_of_type_JavaLangString = paramString3;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append("-").append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("-").append(paramString3);
    }
    paramString2 = localStringBuilder.toString();
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "不限";
    }
    localNearPeopleFilters.jdField_a_of_type_JavaLangString = paramString1;
    if (!localNearPeopleFilters.equals(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters)) {
      localNearPeopleFilters.jdField_a_of_type_Boolean = true;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters = localNearPeopleFilters;
    if ((((NearbyDataManager)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(209)).a() == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters.jdField_a_of_type_Boolean)) {
      NearPeopleFilters.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearPeopleFilters);
    }
    this.a.g();
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    QLog.e("NearbyHybridFragment", 2, "onNearbyLiveFeedAnchor isSucc:" + paramBoolean);
    if ((paramBoolean) && (paramList.size() > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.b(paramList);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adng
 * JD-Core Version:    0.7.0.1
 */