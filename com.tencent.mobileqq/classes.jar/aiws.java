import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aiws
  implements aiwf
{
  aiwh jdField_a_of_type_Aiwh;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  
  public aiws(QQAppInterface paramQQAppInterface, aiwh paramaiwh, Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aiwh = paramaiwh;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 36;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558758, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131364123);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131364124);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131364122);
    localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694427));
    localImageView1.setImageResource(2130844850);
    paramVarArgs.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694427));
    paramVarArgs.setOnClickListener(new aiwt(this));
    localImageView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiws
 * JD-Core Version:    0.7.0.1
 */