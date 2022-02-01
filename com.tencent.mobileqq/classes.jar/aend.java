import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aend
  implements asid
{
  public aend(EmosmActivity paramEmosmActivity) {}
  
  public void a(int paramInt)
  {
    paramInt -= this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
    if (paramInt < 0) {
      return;
    }
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!bhnv.d(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130839555);
      ((QQToast)localObject).d(1500);
      ((QQToast)localObject).a(anzj.a(2131702931));
      ((QQToast)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_Bjbs.a(this.a.getString(2131691748));
    this.a.jdField_a_of_type_Bjbs.show();
    ((anwx)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
    if (this.a.b == 1)
    {
      bdll.b(this.a.app, "dc00898", "", "", "0X800AB12", "0X800AB12", 1, 0, "", "", "", "");
      return;
    }
    bdll.b(this.a.app, "dc00898", "", "", "0X800AB15", "0X800AB15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aend
 * JD-Core Version:    0.7.0.1
 */