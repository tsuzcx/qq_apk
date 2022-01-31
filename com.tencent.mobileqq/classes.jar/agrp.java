import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.HashSet;

public class agrp
  implements bfrq
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public agrp(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.c) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.k = false;
      this.jdField_a_of_type_Boolean = false;
      this.b = paramInt;
      this.jdField_a_of_type_Int = paramInt;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agru.a(paramInt);
      if (localLocalMediaInfo.selectStatus == 2) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.a(localLocalMediaInfo, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.c) {}
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
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.k));
      i -= 1;
      while (i >= paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agru.a(i), this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.k))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.d();
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
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.k));
    i += 1;
    while (i <= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agru.a(i), this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        return;
      }
      i += 1;
    }
    label323:
    int i = this.b;
    agse localagse;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (i < j)
    {
      localagse = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agru.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localagse.a(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.jdField_a_of_type_Int)
    {
      localagse = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agru.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localagse.a(localLocalMediaInfo, bool);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.d();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agse.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrp
 * JD-Core Version:    0.7.0.1
 */