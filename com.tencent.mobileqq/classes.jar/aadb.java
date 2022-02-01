import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.richframework.part.list.base.PublicListFragment;
import java.util.List;

public class aadb
  extends FragmentPagerAdapter
{
  private aadb(PublicListFragment paramPublicListFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < this.a.a.size()) {
      return (Fragment)this.a.a.get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadb
 * JD-Core Version:    0.7.0.1
 */