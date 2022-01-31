import android.view.View;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acwh
  implements aufy<List<EmoticonPackage>>
{
  public acwh(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    this.a.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.a.jdField_a_of_type_Apoy != null) {
      this.a.jdField_a_of_type_Apoy.a();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.a.b == 1)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
      if (this.a.b == 2)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.a.b == 1)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.findHeaderViewPosition(this.a.jdField_a_of_type_AndroidViewView) == -1) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(this.a.jdField_a_of_type_AndroidViewView);
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.d();
      if (this.a.b != 2) {
        break label344;
      }
      this.a.setTitle(2131692094);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Apoy != null) {
        this.a.jdField_a_of_type_Apoy.notifyDataSetChanged();
      }
      return;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.removeHeaderView(this.a.jdField_a_of_type_AndroidViewView);
      break;
      label344:
      this.a.setTitle(2131692341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwh
 * JD-Core Version:    0.7.0.1
 */