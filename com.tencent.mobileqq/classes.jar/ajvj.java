import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class ajvj
  extends aecn
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
    paramLayoutInflater = new ajvj();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375883));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378790));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364254));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367808));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378782));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131378853));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370958));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365302);
    return paramViewGroup;
  }
  
  public static void a(akdk paramakdk, ajvj paramajvj, PhoneContact paramPhoneContact)
  {
    paramajvj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramajvj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramajvj.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramajvj.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramajvj.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841731);
      paramajvj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajvj.jdField_c_of_type_AndroidWidgetTextView.setText(bdbt.a(paramPhoneContact.name));
      paramajvj.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramajvj.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramajvj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramakdk.a(paramajvj.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramajvj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramajvj.jdField_a_of_type_Boolean = false;
      return;
    }
    paramajvj.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramajvj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramakdk.a(paramajvj.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramajvj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramajvj.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvj
 * JD-Core Version:    0.7.0.1
 */