import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView;
import java.util.List;

public class aaqb
  extends FragmentPagerAdapter
{
  public aaqb(RelativePersonalBottomView paramRelativePersonalBottomView, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return RelativePersonalBottomView.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if (paramInt < RelativePersonalBottomView.a(this.a).size()) {
      return (Fragment)RelativePersonalBottomView.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqb
 * JD-Core Version:    0.7.0.1
 */