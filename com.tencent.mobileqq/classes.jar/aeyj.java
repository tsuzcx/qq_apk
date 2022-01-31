import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class aeyj
  implements aeyt
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  
  public aeyj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return 66;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558588, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362400));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362399));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846424);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aeyk(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof String))) {
      paramVarArgs = new String(Base64.decode((String)paramVarArgs[0], 0));
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs);
      String str = paramVarArgs.getString("content");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_JavaLangString = paramVarArgs.getString("url");
      label150:
      return this.jdField_a_of_type_AndroidViewView;
    }
    catch (JSONException paramVarArgs)
    {
      break label150;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyj
 * JD-Core Version:    0.7.0.1
 */