import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aezg
  implements aeyt
{
  aeyv jdField_a_of_type_Aeyv;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  
  public aezg(QQAppInterface paramQQAppInterface, aeyv paramaeyv, Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aeyv = paramaeyv;
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
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558658, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131363820);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131363821);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131363819);
    localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695274));
    localImageView1.setImageResource(2130844027);
    paramVarArgs.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695274));
    paramVarArgs.setOnClickListener(new aezh(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezg
 * JD-Core Version:    0.7.0.1
 */