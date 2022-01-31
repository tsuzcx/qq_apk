import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;

public class agpd
  implements Comparator
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public agpd(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    paramRect1 = new Point((int)(paramRect1.width() * 0.5F + paramRect1.left), (int)(paramRect1.height() * 0.5F + paramRect1.top));
    paramRect2 = new Point((int)(paramRect2.width() * 0.5F + paramRect2.left), (int)(paramRect2.height() * 0.5F + paramRect2.top));
    return TagCloudView.a(paramRect1, this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramRect2, this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpd
 * JD-Core Version:    0.7.0.1
 */