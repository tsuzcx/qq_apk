import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;

public class alaf
  extends aepg
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
    paramLayoutInflater = new alaf();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376577));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379673));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131364530));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368236));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379664));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131379739));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371615));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131365619);
    return paramViewGroup;
  }
  
  public static void a(alif paramalif, alaf paramalaf, PhoneContact paramPhoneContact)
  {
    paramalaf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramalaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramalaf.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramalaf.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramalaf.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842104);
      paramalaf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramalaf.jdField_c_of_type_AndroidWidgetTextView.setText(ContactUtils.getHeaderText(paramPhoneContact.name));
      paramalaf.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramalaf.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramalaf.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramalif.a(paramalaf.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramalaf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramalaf.jdField_a_of_type_Boolean = false;
      return;
    }
    paramalaf.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramalaf.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramalif.a(paramalaf.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramalaf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramalaf.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaf
 * JD-Core Version:    0.7.0.1
 */