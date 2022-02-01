import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.Timer;

public class aimx
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ".", "..", "..." };
  private int jdField_a_of_type_Int;
  private aimy jdField_a_of_type_Aimy;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = ".";
  private Timer jdField_a_of_type_JavaUtilTimer;
  private String b = "";
  private String c;
  
  private SpannableString b()
  {
    SpannableString localSpannableString = new SpannableString(this.c);
    int i = 1;
    if (this.b.length() > 4) {
      i = 3;
    }
    int j = this.b.length() - i;
    i = j;
    if (j < 0) {
      i = 0;
    }
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), 0, i, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), i, this.c.length(), 33);
      return localSpannableString;
    }
    localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#03081a")), 0, i, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), i, this.c.length(), 33);
    return localSpannableString;
  }
  
  public int a()
  {
    return this.c.length();
  }
  
  public SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(anvx.a(2131716211) + this.jdField_a_of_type_JavaLangString);
    localSpannableString.setSpan(new ForegroundColorSpan(this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  public SpannableString a(String paramString)
  {
    if (paramString.length() - this.b.length() < 3) {}
    for (this.b = paramString;; this.b = paramString.substring(0, this.b.length() + 3 - 1))
    {
      this.c = (this.b + this.jdField_a_of_type_JavaLangString);
      return b();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VoiceTextShowAnimator.1(this), 0L, 100L);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ColorStateList paramColorStateList, aimy paramaimy)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_Aimy = paramaimy;
  }
  
  public boolean a(String paramString)
  {
    return paramString.length() - this.b.length() < 3;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_Int = 0;
    this.b = "";
    this.c = "";
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimx
 * JD-Core Version:    0.7.0.1
 */