import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;
import com.tencent.mobileqq.troop.widget.FollowImageTextView.OnTextLineChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajed
{
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private FollowImageTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ajed(FollowImageTextView paramFollowImageTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = paramFollowImageTextView;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_Int - this.f - this.d;
  }
  
  private int a(CharSequence paramCharSequence)
  {
    return (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int n = a();
    if (n <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FollowImageTextView", 2, "lineWidth=" + n);
      }
      return;
    }
    int i1 = this.jdField_a_of_type_JavaLangCharSequence.length();
    int j = 0;
    int k = 0;
    int i = 0;
    label70:
    ajec localajec;
    if (j < i1) {
      if (this.jdField_a_of_type_JavaLangCharSequence.charAt(j) == '\n')
      {
        localajec = new ajec(null);
        localajec.jdField_a_of_type_Int = i;
        localajec.b = (j - 1);
        localajec.c = k;
        localajec.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(i, j);
        this.jdField_a_of_type_JavaUtilList.add(localajec);
        i = j + 1;
        k = 0;
      }
    }
    for (;;)
    {
      j += 1;
      break label70;
      int m = a(this.jdField_a_of_type_JavaLangCharSequence.subSequence(i, j + 1));
      if (m > n)
      {
        localajec = new ajec(null);
        localajec.jdField_a_of_type_Int = i;
        localajec.b = (j - 1);
        localajec.c = k;
        localajec.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(i, j);
        this.jdField_a_of_type_JavaUtilList.add(localajec);
        if (this.jdField_a_of_type_JavaUtilList.size() >= i1)
        {
          if (FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView) == null) {
            break;
          }
          FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView).a(this.jdField_a_of_type_JavaUtilList.size());
          return;
        }
        i = j;
        j -= 1;
        k = 0;
        continue;
      }
      if (j == i1 - 1)
      {
        localajec = new ajec(null);
        localajec.jdField_a_of_type_Int = i;
        localajec.b = (j - 1);
        localajec.c = m;
        localajec.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(i, i1);
        this.jdField_a_of_type_JavaUtilList.add(localajec);
      }
      else
      {
        k = m;
      }
    }
  }
  
  public void a(int paramInt)
  {
    ajeb localajeb = FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView);
    this.jdField_a_of_type_JavaLangCharSequence = localajeb.getText();
    this.jdField_a_of_type_AndroidTextTextPaint = localajeb.getPaint();
    this.jdField_a_of_type_Int = localajeb.getMeasuredWidth();
    this.b = localajeb.getLineHeight();
    this.d = localajeb.getPaddingLeft();
    this.e = localajeb.getPaddingTop();
    this.f = localajeb.getPaddingRight();
    this.g = localajeb.getPaddingBottom();
    this.c = paramInt;
    a();
  }
  
  public void a(Canvas paramCanvas)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i;
    if ((this.c > 0) && (this.c < j))
    {
      i = 1;
      if (i == 0) {
        break label260;
      }
      j = this.c;
    }
    label260:
    for (;;)
    {
      int k = 0;
      for (;;)
      {
        if (k < j)
        {
          CharSequence localCharSequence = ((ajec)this.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaLangCharSequence;
          float f1 = this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
          int m = localCharSequence.length();
          float f2 = this.d + 0;
          float f3 = this.b * k;
          paramCanvas.drawText(localCharSequence, 0, m, f2, this.e + (f1 + f3), this.jdField_a_of_type_AndroidTextTextPaint);
          k += 1;
          continue;
          i = 0;
          break;
        }
      }
      if ((i != 0) && (j < this.jdField_a_of_type_JavaUtilList.size()))
      {
        paramCanvas = (ajec)this.jdField_a_of_type_JavaUtilList.get(j);
        i = this.jdField_a_of_type_JavaLangCharSequence.length();
        if ((paramCanvas.jdField_a_of_type_Int > -1) && (paramCanvas.jdField_a_of_type_Int < i))
        {
          paramCanvas = this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramCanvas.jdField_a_of_type_Int, i);
          FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView).setText(paramCanvas);
          FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, true);
          return;
        }
        FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, false);
        return;
      }
      FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajed
 * JD-Core Version:    0.7.0.1
 */