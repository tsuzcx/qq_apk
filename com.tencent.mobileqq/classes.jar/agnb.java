import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class agnb
  implements bfrq
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public agnb(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.j) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.Y = false;
      this.jdField_a_of_type_Boolean = false;
      this.b = paramInt;
      this.jdField_a_of_type_Int = paramInt;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agnv.a(paramInt);
      if (localLocalMediaInfo.selectStatus == 2) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a(localLocalMediaInfo, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.j) {}
    int j;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("OnSelectListener", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
        }
        j = Math.min(paramInt1, paramInt2);
        k = Math.max(paramInt1, paramInt2);
        if (paramInt2 >= paramInt1) {
          break;
        }
        i = this.b;
        this.b = Math.min(paramInt2, this.b);
        if (paramInt2 >= i) {
          break label296;
        }
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.Y));
      i -= 1;
      while (i >= paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agnv.a(i), this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.Y))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
          return;
        }
        i -= 1;
      }
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = Math.max(paramInt2, this.jdField_a_of_type_Int);
      if (paramInt2 <= i) {
        break;
      }
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.Y));
    i += 1;
    while (i <= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agnv.a(i), this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.Y))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        return;
      }
      i += 1;
    }
    label296:
    int i = this.b;
    PhotoListActivity localPhotoListActivity;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (i < j)
    {
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agnv.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localPhotoListActivity.a(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.jdField_a_of_type_Int)
    {
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agnv.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localPhotoListActivity.a(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    if (paramInt2 < paramInt1)
    {
      this.b = paramInt2;
      if (this.jdField_a_of_type_Int > paramInt1) {
        this.jdField_a_of_type_Int = paramInt1;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      return;
      this.jdField_a_of_type_Int = paramInt2;
      if (this.b < paramInt1) {
        this.b = paramInt1;
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.j) {}
    do
    {
      return;
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))
      {
        if (vuc.a().a().isEmpty())
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(this.jdField_a_of_type_Int - i);
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - ((View)localObject).getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vuc.jdField_a_of_type_Int, 500);
          }
        }
        vuc.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
      }
      Object localObject = PresendPicMgr.a();
      if (localObject != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_JavaUtilHashSet.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, str) != 1) {
            ((PresendPicMgr)localObject).a(str, 1007);
          }
        }
        localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b.iterator();
        while (localIterator.hasNext()) {
          ((PresendPicMgr)localObject).b((String)localIterator.next(), 1013);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b.clear();
    } while (!QLog.isColorLevel());
    QLog.d("OnSelectListener", 2, "onSelectEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnb
 * JD-Core Version:    0.7.0.1
 */