import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.Tag;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class agtu
  implements Comparator
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public agtu(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    return TagCloudView.a(paramTag1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramTag2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agtu
 * JD-Core Version:    0.7.0.1
 */