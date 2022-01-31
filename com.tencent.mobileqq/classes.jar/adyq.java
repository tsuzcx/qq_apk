import android.os.Handler;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.ViewHolder;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import java.util.List;

public class adyq
  implements Runnable
{
  public adyq(NearbyFragmentEnterAdapter paramNearbyFragmentEnterAdapter) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      NearbyFragmentEnterAdapter.ViewHolder localViewHolder = this.a.a();
      if (localViewHolder != null)
      {
        Object localObject = this.a;
        ((NearbyFragmentEnterAdapter)localObject).b += 1;
        if (this.a.b >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          this.a.b = 0;
        }
        localObject = (ilive_feeds_near_anchor.NearAnchorInfo)this.a.jdField_a_of_type_JavaUtilList.get(this.a.b);
        this.a.a(localViewHolder, (ilive_feeds_near_anchor.NearAnchorInfo)localObject);
      }
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adyq
 * JD-Core Version:    0.7.0.1
 */