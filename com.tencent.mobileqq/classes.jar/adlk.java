import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class adlk
{
  private int jdField_a_of_type_Int;
  adlm jdField_a_of_type_Adlm;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  private int jdField_b_of_type_Int;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  
  public adlk(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.d = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.e = (this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
    this.f = this.jdField_a_of_type_JavaUtilCalendar.get(5);
    this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    this.jdField_b_of_type_JavaUtilCalendar.add(1, -120);
    this.jdField_b_of_type_JavaUtilCalendar.add(5, 1);
    this.g = this.jdField_b_of_type_JavaUtilCalendar.get(1);
    this.h = (this.jdField_b_of_type_JavaUtilCalendar.get(2) + 1);
    this.i = this.jdField_b_of_type_JavaUtilCalendar.get(5);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)LayoutInflater.from(paramContext).inflate(2131561188, null));
    int j = this.d;
    int k = this.g;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new adln(this, j - k + 1));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(new adlo(this, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(paramContext.getResources().getColor(2131167086));
    a(paramInt);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BirthdayPickHelper", 2, String.format("BirthdayPickHelper date range: %s-%s-%s to %s-%s-%s", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f) }));
    }
  }
  
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return a((0xFFFF0000 & paramInt) >>> 16, (0xFF00 & paramInt) >>> 8, paramInt & 0xFF);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(System.currentTimeMillis());
    int k = localCalendar1.get(1);
    int j = localCalendar1.get(2);
    int m = localCalendar1.get(5);
    k -= paramInt1;
    localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, paramInt2, paramInt3);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, j + 1, m);
    j = k;
    if (localCalendar1.after(localCalendar2)) {
      j = k - 1;
    }
    k = j;
    if (j < 0) {
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BirthdayPickHelper", 2, String.format("calcuAgeByBirthday year:%d,month:%d,day:%d. age:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(k) }));
    }
    return k;
  }
  
  private void a()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.g + this.jdField_a_of_type_Int);
    localCalendar.set(2, this.jdField_b_of_type_Int);
    localCalendar.set(5, this.c + 1);
    if (localCalendar.before(this.jdField_b_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = (this.h - 1);
      this.c = (this.i - 1);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
    }
    while (!localCalendar.after(this.jdField_a_of_type_JavaUtilCalendar)) {
      return;
    }
    this.jdField_a_of_type_Int = (this.d - this.g);
    this.jdField_b_of_type_Int = (this.e - 1);
    this.c = (this.f - 1);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.c);
  }
  
  private int b(int paramInt)
  {
    return this.g + paramInt;
  }
  
  private int c(int paramInt)
  {
    return paramInt + 1;
  }
  
  private int d(int paramInt)
  {
    return paramInt + 1;
  }
  
  public IphonePickerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  }
  
  public void a(int paramInt)
  {
    int j;
    int k;
    if (paramInt <= 0)
    {
      paramInt = this.g;
      j = 0;
      k = 2000 - paramInt;
    }
    for (paramInt = 0;; paramInt = (paramInt & 0xFF) - 1)
    {
      this.jdField_a_of_type_Int = k;
      this.jdField_b_of_type_Int = j;
      this.c = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, k);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, j);
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, paramInt);
      return;
      k = ((0xFFFF0000 & paramInt) >>> 16) - this.g;
      j = ((0xFF00 & paramInt) >>> 8) - 1;
    }
  }
  
  public void a(adlm paramadlm)
  {
    this.jdField_a_of_type_Adlm = paramadlm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlk
 * JD-Core Version:    0.7.0.1
 */