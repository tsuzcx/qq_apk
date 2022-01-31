import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class ajzy
  extends aehc
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
    paramLayoutInflater = new ajzy();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375936));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378845));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364256));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367819));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378837));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131378910));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370977));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365304);
    return paramViewGroup;
  }
  
  public static void a(akhz paramakhz, ajzy paramajzy, PhoneContact paramPhoneContact)
  {
    paramajzy.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramajzy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramajzy.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramajzy.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramajzy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841744);
      paramajzy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajzy.jdField_c_of_type_AndroidWidgetTextView.setText(bdgc.a(paramPhoneContact.name));
      paramajzy.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramajzy.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramajzy.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramakhz.a(paramajzy.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramajzy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramajzy.jdField_a_of_type_Boolean = false;
      return;
    }
    paramajzy.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramajzy.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramakhz.a(paramajzy.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramajzy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramajzy.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzy
 * JD-Core Version:    0.7.0.1
 */