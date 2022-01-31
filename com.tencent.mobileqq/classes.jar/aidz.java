import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class aidz
  extends acld
{
  public CheckBox a;
  public PhoneContact a;
  public boolean a;
  public View b;
  public TextView c;
  public TextView d;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("0".equals(paramString)) {
      return 11;
    }
    return 1;
  }
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new aidz();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375398));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378223));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364192));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367679));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378215));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131378276));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370647));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365217);
    return paramViewGroup;
  }
  
  public static void a(ailz paramailz, aidz paramaidz, PhoneContact paramPhoneContact)
  {
    paramaidz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramaidz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaidz.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramaidz.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramaidz.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841580);
      paramaidz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaidz.jdField_c_of_type_AndroidWidgetTextView.setText(bbcz.a(paramPhoneContact.name));
      paramaidz.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramaidz.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramaidz.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramailz.a(paramaidz.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramaidz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaidz.jdField_a_of_type_Boolean = false;
      return;
    }
    paramaidz.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramaidz.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramailz.a(paramaidz.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramaidz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaidz.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidz
 * JD-Core Version:    0.7.0.1
 */