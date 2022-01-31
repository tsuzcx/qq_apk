import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajzp
{
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public ajzp(EllipsizingTextView paramEllipsizingTextView) {}
  
  private float a(int paramInt, TextUtils.TruncateAt paramTruncateAt)
  {
    int i = b() - (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("...");
    if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)
    {
      if (this.h <= 0) {
        return i / 2;
      }
      if (paramInt == 1)
      {
        if (i < this.h) {
          return i;
        }
        return this.h;
      }
      if (i < this.h) {
        return 0.0F;
      }
      return i - this.h;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      if (this.h <= 0) {
        return i;
      }
      if (i < this.h) {
        return i;
      }
      return i - this.h;
    }
    return i;
  }
  
  private int a(String paramString)
  {
    return (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString, 0, paramString.length());
  }
  
  private int a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt < 0) || (paramInt > paramString.length() - 1)) {
      return 0;
    }
    char c1 = paramString.charAt(paramInt);
    paramString = new float[1];
    this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(String.valueOf(c1), paramString);
    return (int)Math.ceil(paramString[0]);
  }
  
  private String a(int paramInt)
  {
    int k = (int)a(0, TextUtils.TruncateAt.MIDDLE);
    int m = this.jdField_a_of_type_JavaLangString.length();
    int j = 0;
    int i = paramInt;
    for (;;)
    {
      if (i < m)
      {
        j += a(this.jdField_a_of_type_JavaLangString, i);
        if (j <= k) {}
      }
      else
      {
        return this.jdField_a_of_type_JavaLangString.substring(paramInt, i);
      }
      i += 1;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int n = b();
    if (n <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EllipsizingTextView", 2, "lineWidth=" + n);
      }
      return;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    label64:
    if (i < this.jdField_a_of_type_JavaLangString.length())
    {
      if (this.jdField_a_of_type_JavaLangString.charAt(i) != '\n') {
        break label159;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(k, i));
      if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
        this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i));
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
      k = i + 1;
      j = 0;
    }
    for (;;)
    {
      i += 1;
      break label64;
      break;
      label159:
      int m = a(this.jdField_a_of_type_JavaLangString.substring(k, i + 1));
      if (m > n)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(k, i));
        if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i));
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
        if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_JavaLangString.length()) {
          break;
        }
        k = i;
        i -= 1;
        j = 0;
        continue;
      }
      if (i == this.jdField_a_of_type_JavaLangString.length() - 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(k, this.jdField_a_of_type_JavaLangString.length()));
        if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, this.jdField_a_of_type_JavaLangCharSequence.length()));
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
      }
      else
      {
        j = m;
      }
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int - this.f - this.d;
  }
  
  private String b(int paramInt)
  {
    int k = (int)a(1, TextUtils.TruncateAt.MIDDLE);
    int j = 0;
    int i = paramInt;
    for (;;)
    {
      if (i > 0)
      {
        j += a(this.jdField_a_of_type_JavaLangString, i);
        if (j <= k) {}
      }
      else
      {
        return this.jdField_a_of_type_JavaLangString.substring(i + 1, paramInt + 1);
      }
      i -= 1;
    }
  }
  
  private String c(int paramInt)
  {
    int k = this.jdField_a_of_type_JavaLangString.length();
    int m = (int)a(1, TextUtils.TruncateAt.END);
    int j = 0;
    int i = paramInt;
    for (;;)
    {
      if ((i >= k) || (j > m))
      {
        if (i - 1 >= paramInt) {
          break;
        }
        return "";
      }
      j += a(this.jdField_a_of_type_JavaLangString, i);
      i += 1;
    }
    if (i - 1 > k) {
      return this.jdField_a_of_type_JavaLangString.substring(paramInt, k);
    }
    return this.jdField_a_of_type_JavaLangString.substring(paramInt, i - 1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i <= paramInt)
    {
      j += ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).length();
      i += 1;
    }
    if (j <= 0) {
      return 0;
    }
    return j - 1;
  }
  
  public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
  {
    int j;
    int m;
    Object localObject1;
    int k;
    label39:
    String str;
    Object localObject2;
    int i;
    if ((this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int <= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      j = this.jdField_c_of_type_Int;
      m = b();
      localObject1 = null;
      k = 0;
      if (k >= j) {
        break label771;
      }
      str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      localObject2 = localObject1;
      if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView))
      {
        localObject2 = localObject1;
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > k) {
          localObject2 = (CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(k);
        }
      }
      i = ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(k)).intValue();
      if (paramTruncateAt != TextUtils.TruncateAt.END) {
        break label475;
      }
      if ((j < 2) || (k != j - 1) || (k >= this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        break label372;
      }
      i = a(j - 2);
      str = c(i + 1) + "...";
      localObject1 = str;
      if (!this.jdField_a_of_type_Boolean) {
        break label772;
      }
      i = (m - a(str)) / 2;
      localObject1 = str;
    }
    for (;;)
    {
      label219:
      if ((EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) && (localObject2 != null) && ((localObject2 instanceof SpannableString)))
      {
        localObject1 = (SpannableString)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("EllipsizingTextView", 2, "text is " + ((SpannableString)localObject1).toString() + "and i is" + k + " offset: " + i);
        }
        if (k == 0)
        {
          paramCanvas.translate(i + this.d, 0.0F);
          new StaticLayout((CharSequence)localObject1, this.jdField_a_of_type_AndroidTextTextPaint, paramCanvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
        }
      }
      for (;;)
      {
        label320:
        k += 1;
        localObject1 = localObject2;
        break label39;
        j = this.jdField_a_of_type_JavaUtilArrayList.size();
        break;
        label372:
        if ((k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
        {
          str = c(0) + "...";
          localObject1 = str;
          if (!this.jdField_a_of_type_Boolean) {
            break label772;
          }
          i = (m - a(str)) / 2;
          localObject1 = str;
          break label219;
        }
        localObject1 = str;
        if (!this.jdField_a_of_type_Boolean) {
          break label772;
        }
        i = (m - i) / 2;
        localObject1 = str;
        break label219;
        label475:
        localObject1 = str;
        if (paramTruncateAt != TextUtils.TruncateAt.MIDDLE) {
          break label772;
        }
        if ((j >= 2) && (k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
        {
          i = a(j - 2);
          str = a(i + 1) + "..." + b(this.jdField_a_of_type_JavaLangString.length() - 1);
          localObject1 = str;
          if (!this.jdField_a_of_type_Boolean) {
            break label772;
          }
          i = (m - a(str)) / 2;
          localObject1 = str;
          break label219;
        }
        if ((k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
        {
          str = a(0) + "..." + b(this.jdField_a_of_type_JavaLangString.length() - 1);
          localObject1 = str;
          if (!this.jdField_a_of_type_Boolean) {
            break label772;
          }
          i = (m - a(str)) / 2;
          localObject1 = str;
          break label219;
        }
        localObject1 = str;
        if (!this.jdField_a_of_type_Boolean) {
          break label772;
        }
        i = (m - i) / 2;
        localObject1 = str;
        break label219;
        paramCanvas.translate(0.0F, this.jdField_b_of_type_Int);
        break label320;
        paramCanvas.drawText((String)localObject1, i + this.d, this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() + this.jdField_b_of_type_Int * k + this.e, this.jdField_a_of_type_AndroidTextTextPaint);
      }
      label771:
      return;
      label772:
      i = 0;
    }
  }
  
  public void a(CharSequence paramCharSequence, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramCharSequence == null) || (paramTextView == null)) {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    EllipsizingTextView localEllipsizingTextView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView;
    if (((paramCharSequence instanceof SpannableString)) && (EllipsizingTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView))) {}
    for (boolean bool = true;; bool = false)
    {
      EllipsizingTextView.a(localEllipsizingTextView, bool);
      this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
      this.jdField_a_of_type_AndroidTextTextPaint = paramTextView.getPaint();
      this.jdField_a_of_type_Int = paramTextView.getMeasuredWidth();
      this.jdField_b_of_type_Int = paramTextView.getLineHeight();
      this.d = paramTextView.getPaddingLeft();
      this.e = paramTextView.getPaddingTop();
      this.f = paramTextView.getPaddingRight();
      this.g = paramTextView.getPaddingBottom();
      this.jdField_c_of_type_Int = paramInt1;
      this.h = paramInt2;
      this.jdField_a_of_type_Boolean = paramBoolean;
      a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzp
 * JD-Core Version:    0.7.0.1
 */