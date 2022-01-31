import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment;
import java.util.List;

public class aiua
  extends FragmentPagerAdapter
{
  public aiua(SendHbMainFragment paramSendHbMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SendHbMainFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return ((aiub)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((aiub)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiua
 * JD-Core Version:    0.7.0.1
 */