import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.util.ArrayList;

public class abba
  implements ants
{
  public abba(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    paramInt -= this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!bbev.d(this.a))
    {
      localObject = new bcpw(this.a);
      ((bcpw)localObject).a(2130839277);
      ((bcpw)localObject).d(1500);
      ((bcpw)localObject).a(ajyc.a(2131704032));
      ((bcpw)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_Bcpq.a(this.a.getString(2131692049));
    this.a.jdField_a_of_type_Bcpq.show();
    ((ajvp)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.a.b == 1)
    {
      axqw.b(this.a.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    axqw.b(this.a.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abba
 * JD-Core Version:    0.7.0.1
 */