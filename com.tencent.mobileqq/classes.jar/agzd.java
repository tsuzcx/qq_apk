import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class agzd
  implements ahan
{
  private long jdField_a_of_type_Long = -1L;
  private ahap jdField_a_of_type_Ahap;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public agzd(ahap paramahap, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ahap = paramahap;
  }
  
  public int a()
  {
    return 55;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558557, null);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362396));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new agze(this));
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 1) && ((paramVarArgs[0] instanceof CharSequence)) && ((paramVarArgs[1] instanceof Long)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramVarArgs[0]);
      this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362394);
      if (localImageView != null) {
        localImageView.setImageDrawable(paramDrawable);
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzd
 * JD-Core Version:    0.7.0.1
 */