import android.graphics.Point;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.Tag;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import java.util.Comparator;
import java.util.Random;

public class agpe
  implements Comparator
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public agpe(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    if ((paramTag1.b.y > this.jdField_a_of_type_Int) || (paramTag2.b.y > this.jdField_a_of_type_Int)) {
      return -(paramTag1.b.y - paramTag2.b.y);
    }
    if ((paramTag1.b.x > this.b) || (paramTag2.b.x > this.b)) {
      return -(paramTag1.b.x - paramTag2.b.x);
    }
    return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpe
 * JD-Core Version:    0.7.0.1
 */