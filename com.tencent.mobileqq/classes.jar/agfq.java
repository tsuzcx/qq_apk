import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class agfq
  implements bejw
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public agfq(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.e) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.y = false;
      this.jdField_a_of_type_Boolean = false;
      this.b = paramInt;
      this.jdField_a_of_type_Int = paramInt;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agfv.a(paramInt);
      if (localLocalMediaInfo.selectStatus == 2) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a(localLocalMediaInfo, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.e) {}
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
          break label323;
        }
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.y));
      i -= 1;
      while (i >= paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agfv.a(i), this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.y))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.d();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
          return;
        }
        i -= 1;
      }
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = Math.max(paramInt2, this.jdField_a_of_type_Int);
      if (paramInt2 <= i) {
        break;
      }
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.y));
    i += 1;
    while (i <= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agfv.a(i), this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.y))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        return;
      }
      i += 1;
    }
    label323:
    int i = this.b;
    aggh localaggh;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (i < j)
    {
      localaggh = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agfv.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localaggh.a(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.jdField_a_of_type_Int)
    {
      localaggh = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agfv.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localaggh.a(localLocalMediaInfo, bool);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      return;
      this.jdField_a_of_type_Int = paramInt2;
      if (this.b < paramInt1) {
        this.b = paramInt1;
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.e) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a.a())
      {
        if (vhg.a().a().isEmpty())
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(this.jdField_a_of_type_Int - i);
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - ((View)localObject).getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.b)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vhg.jdField_a_of_type_Int, 500);
          }
        }
        vhg.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggh.a.b);
      }
      Object localObject = PresendPicMgr.a();
      if (localObject != null)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.a.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.a(str) != 1) {
            ((PresendPicMgr)localObject).a(str, 1052);
          }
        }
        localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.b.iterator();
        while (localIterator.hasNext()) {
          ((PresendPicMgr)localObject).b((String)localIterator.next(), 1013);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Aggg.b.clear();
    } while (!QLog.isColorLevel());
    QLog.d("OnSelectListener", 2, "onSelectEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfq
 * JD-Core Version:    0.7.0.1
 */