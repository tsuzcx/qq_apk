import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import java.util.List;

public class afeo
  extends FragmentPagerAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public afeo(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, FragmentManager paramFragmentManager, List paramList)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public Fragment a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    return 2;
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afeo
 * JD-Core Version:    0.7.0.1
 */