import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.util.ArrayList;

public class abaw
  implements antx
{
  public abaw(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    paramInt -= this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!bbfj.d(this.a))
    {
      localObject = new bcql(this.a);
      ((bcql)localObject).a(2130839277);
      ((bcql)localObject).d(1500);
      ((bcql)localObject).a(ajya.a(2131704043));
      ((bcql)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_Bcqf.a(this.a.getString(2131692049));
    this.a.jdField_a_of_type_Bcqf.show();
    ((ajvn)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.a.b == 1)
    {
      axqy.b(this.a.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    axqy.b(this.a.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abaw
 * JD-Core Version:    0.7.0.1
 */