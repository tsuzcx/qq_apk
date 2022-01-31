import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.DataObserver;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class acec
  implements EmoticonLinearLayout.DataObserver
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public acec(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    long l = System.currentTimeMillis();
    int m = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
    int n = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b();
    int j = 0;
    int i = 0;
    int k;
    if (j < n)
    {
      k = 0;
      label41:
      if (k < m) {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size() > i) {}
      }
    }
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(i, localRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout);
      i += 1;
      k += 1;
      break label41;
      j += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.b == paramInt2) && (this.jdField_a_of_type_Boolean)) {}
    long l;
    label294:
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.removeAllViews();
      paramInt1 = 0;
      if (XPanelContainer.d > 0) {
        paramInt1 = XPanelContainer.d / 3;
      }
      paramInt2 = paramInt1;
      if (paramInt1 > 60) {
        paramInt2 = 60;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.setPadding(0, paramInt2, 0, paramInt2);
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams1.weight = 1.0F;
        localLinearLayout.setOrientation(0);
        localLinearLayout.setPadding(0, 0, 0, 0);
        int i = 0;
        if (i < this.b)
        {
          System.currentTimeMillis();
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams2.weight = 1.0F;
          RelativeLayout localRelativeLayout = null;
          if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size()) {
            localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(paramInt1);
          }
          Object localObject;
          if (localRelativeLayout == null)
          {
            localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((URLImageView)localObject).setId(2131361968);
            switch (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EmoticonLinearLayout", 2, "Should not reach here, check your code!!!");
              }
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.add(localRelativeLayout);
            }
          }
          for (;;)
          {
            localLinearLayout.addView(localRelativeLayout, localLayoutParams2);
            paramInt1 += 1;
            i += 1;
            break;
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(13, -1);
            ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject, localLayoutParams);
            break label294;
            localObject = (ViewGroup)localRelativeLayout.getParent();
            if (localObject != null) {
              ((ViewGroup)localObject).removeAllViews();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.addView(localLinearLayout, localLayoutParams1);
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acec
 * JD-Core Version:    0.7.0.1
 */