import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout14;
import com.tencent.qphone.base.util.QLog;

public class ains
  extends LinearLayout
{
  int jdField_a_of_type_Int = 586;
  int b = 0;
  int c = 0;
  
  public ains(StructMsgItemLayout14 paramStructMsgItemLayout14, Context paramContext)
  {
    super(paramContext);
    this.b = (paramContext.getResources().getDisplayMetrics().widthPixels - 40 - 48);
    this.jdField_a_of_type_Int = (this.b * 818 / 710 - 140 - 92);
    this.c = (this.b * 400 / 666);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout14.a == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout14.a.isExpand))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout14 onMeasure. do nothing");
      }
      return;
    }
    paramInt2 = getMeasuredHeight();
    int m = getMeasuredWidth();
    paramInt1 = paramInt2;
    int n;
    int i;
    int j;
    label97:
    int k;
    View localView;
    int i1;
    if (paramInt2 > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout14.a.isShowExpandButton = true;
      n = getChildCount();
      paramInt2 = this.jdField_a_of_type_Int;
      i = n - 1;
      paramInt1 = 0;
      j = 0;
      k = i;
      if (paramInt1 < n)
      {
        localView = getChildAt(paramInt1);
        i1 = localView.getMeasuredHeight();
        if (i1 <= paramInt2) {
          break label308;
        }
        if ((localView instanceof TextView))
        {
          ((TextView)localView).setMaxHeight(paramInt2);
          k = paramInt1;
          i = paramInt2;
          paramInt2 = k;
        }
      }
    }
    for (;;)
    {
      k = j + i1;
      paramInt1 += 1;
      j = i;
      i = paramInt2;
      paramInt2 = j;
      j = k;
      break label97;
      if ((localView instanceof ImageView))
      {
        if (paramInt1 == 0) {}
        for (i = 0; paramInt2 < i + this.c; i = 26)
        {
          paramInt1 -= 1;
          k = paramInt1;
          if (QLog.isColorLevel())
          {
            QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout14 onMeasure. hide last image. remainUsableHeight " + paramInt2 + " image height:" + i1 + " lastVisibleViewIndex:" + paramInt1);
            k = paramInt1;
          }
          paramInt1 = n - 1;
          while (paramInt1 > k)
          {
            getChildAt(paramInt1).setVisibility(8);
            paramInt1 -= 1;
          }
        }
        i = paramInt1;
        k = paramInt2;
        paramInt2 = i;
        i = k;
        continue;
        label308:
        k = paramInt2 - i1;
        paramInt2 = i;
        i = k;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout14 onMeasure. totalHeight:" + j);
        }
        paramInt1 = j;
        if (paramInt1 > this.jdField_a_of_type_Int)
        {
          setMeasuredDimension(m, this.jdField_a_of_type_Int);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(".troop.troop_topic", 2, "message pid:" + this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout14.a.pid + " child count:" + getChildCount() + " height over max height. maxHeight is " + this.jdField_a_of_type_Int + " height is " + paramInt1);
          return;
        }
        setMeasuredDimension(m, paramInt1);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.troop_topic", 2, "message pid:" + this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout14.a.pid + " child count:" + getChildCount() + " height less than max height. maxHeight is " + this.jdField_a_of_type_Int + " height is " + paramInt1);
        return;
      }
      i = paramInt1;
      k = paramInt2;
      paramInt2 = i;
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ains
 * JD-Core Version:    0.7.0.1
 */