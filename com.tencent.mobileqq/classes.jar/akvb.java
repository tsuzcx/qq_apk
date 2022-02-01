import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import java.util.List;

public class akvb
  extends FragmentPagerAdapter
{
  public akvb(SendHbMainFragment paramSendHbMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SendHbMainFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return ((akvc)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((akvc)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvb
 * JD-Core Version:    0.7.0.1
 */