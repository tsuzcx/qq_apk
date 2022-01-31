import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;

public class aarh
  implements andk
{
  public aarh(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!badq.d(this.a))
    {
      localObject = new bbmy(this.a);
      ((bbmy)localObject).a(2130839253);
      ((bbmy)localObject).d(1500);
      ((bbmy)localObject).a(ajjy.a(2131638247));
      ((bbmy)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_Bbms.a(this.a.getString(2131626463));
    this.a.jdField_a_of_type_Bbms.show();
    ((ajhm)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarh
 * JD-Core Version:    0.7.0.1
 */