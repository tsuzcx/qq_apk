import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.HashSet;

public class agrn
  implements bfsh
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public agrn(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.c) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.k = false;
      this.jdField_a_of_type_Boolean = false;
      this.b = paramInt;
      this.jdField_a_of_type_Int = paramInt;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agrs.a(paramInt);
      if (localLocalMediaInfo.selectStatus == 2) {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a(localLocalMediaInfo, this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.c) {}
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
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.k));
      i -= 1;
      while (i >= paramInt2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agrs.a(i), this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.k))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.d();
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
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.k));
    i += 1;
    while (i <= paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agrs.a(i), this.jdField_a_of_type_Boolean);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        return;
      }
      i += 1;
    }
    label323:
    int i = this.b;
    agsc localagsc;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (i < j)
    {
      localagsc = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agrs.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localagsc.a(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.jdField_a_of_type_Int)
    {
      localagsc = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc;
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agrs.a(i);
      if (!this.jdField_a_of_type_Boolean) {}
      for (bool = true;; bool = false)
      {
        localagsc.a(localLocalMediaInfo, bool);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.d();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrn
 * JD-Core Version:    0.7.0.1
 */