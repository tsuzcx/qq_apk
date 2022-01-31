import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class aieb
  extends aclh
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
    paramLayoutInflater = new aieb();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131375396));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378220));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364193));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367679));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378212));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131378273));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370647));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365218);
    return paramViewGroup;
  }
  
  public static void a(aimb paramaimb, aieb paramaieb, PhoneContact paramPhoneContact)
  {
    paramaieb.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramaieb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaieb.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramaieb.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramaieb.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841580);
      paramaieb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaieb.jdField_c_of_type_AndroidWidgetTextView.setText(bbcl.a(paramPhoneContact.name));
      paramaieb.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramaieb.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramaieb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramaimb.a(paramaieb.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramaieb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaieb.jdField_a_of_type_Boolean = false;
      return;
    }
    paramaieb.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramaieb.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramaimb.a(paramaieb.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramaieb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramaieb.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aieb
 * JD-Core Version:    0.7.0.1
 */