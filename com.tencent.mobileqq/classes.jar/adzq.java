import android.util.SparseArray;
import android.view.View;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.leba.LebaTitleBar;
import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.view.LebaTopBarView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class adzq
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(0);
  private boolean jdField_a_of_type_Boolean;
  
  public adzq(LebaWithFeeds paramLebaWithFeeds) {}
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_Int; j = k)
    {
      localObject = (adzr)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      k = j;
      if (localObject != null) {
        k = j + ((adzr)localObject).jdField_a_of_type_Int;
      }
      i += 1;
    }
    adzr localadzr = (adzr)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    Object localObject = localadzr;
    if (localadzr == null) {
      localObject = new adzr(this);
    }
    return j - ((adzr)localObject).b;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    LebaWithFeeds.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds).a(paramInt);
    if (ThemeUtil.isNowThemeIsAnimate())
    {
      if (paramInt != 0) {
        ApngImage.pauseByTag(4);
      }
      if (paramInt == 0) {
        ApngImage.playByTag(4);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    View localView;
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      localView = paramAbsListView.getChildAt(0);
    } while (localView == null);
    adzr localadzr = (adzr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    paramAbsListView = localadzr;
    if (localadzr == null) {
      paramAbsListView = new adzr(this);
    }
    paramAbsListView.jdField_a_of_type_Int = localView.getHeight();
    paramAbsListView.b = localView.getTop();
    this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt1, paramAbsListView);
    paramInt1 = a();
    LebaWithFeeds.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds).a(paramInt1);
    LebaWithFeeds.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds).a(LebaWithFeeds.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds), paramInt1, LebaWithFeeds.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzq
 * JD-Core Version:    0.7.0.1
 */