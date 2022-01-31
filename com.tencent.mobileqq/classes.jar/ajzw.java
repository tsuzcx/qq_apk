import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;
import java.util.HashMap;
import java.util.Queue;
import mqq.os.MqqHandler;

class ajzw
  implements Runnable
{
  ajzw(ajzv paramajzv) {}
  
  public void run()
  {
    if (((this.a.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof String)) && (!((String)this.a.jdField_a_of_type_AndroidWidgetImageView.getTag()).endsWith(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      Pair localPair1 = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.a.jdField_a_of_type_ComTencentImageURLDrawable), 1);
      ThreadManager.getUIHandler().post(new ajzx(this, localPair1));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        HotChatPostItemView.jdField_a_of_type_JavaUtilQueue.clear();
        HotChatPostItemView.jdField_a_of_type_JavaUtilHashMap.clear();
        Pair localPair2 = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.a.jdField_a_of_type_ComTencentImageURLDrawable), 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzw
 * JD-Core Version:    0.7.0.1
 */