import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aeej
  implements Runnable
{
  public aeej(NearbyVisitorListActivity paramNearbyVisitorListActivity) {}
  
  public void run()
  {
    if ((this.a.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()))) {
      return;
    }
    Object localObject = (ArrayList)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getEntityManagerFactory().createEntityManager().a(StrangerInfo.class);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    localObject = NearbySPUtil.a("nearby_visitor_file", this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), 0);
    this.a.b = ((SharedPreferences)localObject).getLong("sp_nearby_total_visitor", 0L);
    this.a.c = ((SharedPreferences)localObject).getLong("sp_nearby_new_visitor", 0L);
    this.a.d = ((SharedPreferences)localObject).getLong("sp_nearby_his_visitor", 0L);
    this.a.runOnUiThread(new aeek(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeej
 * JD-Core Version:    0.7.0.1
 */