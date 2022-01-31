import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;

public class ahrj
  extends acav
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
    paramLayoutInflater = new ahrj();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131309645));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312394));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131298635));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131302061));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131312386));
    paramLayoutInflater.d = ((TextView)paramViewGroup.findViewById(2131312447));
    paramLayoutInflater.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131304981));
    paramLayoutInflater.jdField_b_of_type_AndroidViewView = paramViewGroup.findViewById(2131299650);
    return paramViewGroup;
  }
  
  public static void a(ahzi paramahzi, ahrj paramahrj, PhoneContact paramPhoneContact)
  {
    paramahrj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramahrj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramahrj.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramahrj.jdField_a_of_type_JavaLangString = ("pstn" + paramPhoneContact.mobileNo);
      paramahrj.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841491);
      paramahrj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahrj.jdField_c_of_type_AndroidWidgetTextView.setText(babh.a(paramPhoneContact.name));
      paramahrj.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramahrj.jdField_a_of_type_JavaLangString = paramPhoneContact.uin;
      paramahrj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramahzi.a(paramahrj.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramahrj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahrj.jdField_a_of_type_Boolean = false;
      return;
    }
    paramahrj.jdField_a_of_type_JavaLangString = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramahrj.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramahzi.a(paramahrj.jdField_a_of_type_JavaLangString, 11, (byte)0));
    paramahrj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramahrj.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahrj
 * JD-Core Version:    0.7.0.1
 */