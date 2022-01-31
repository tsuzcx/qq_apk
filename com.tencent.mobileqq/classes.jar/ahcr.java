import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

public class ahcr
  extends Dialog
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  
  public ahcr(Context paramContext)
  {
    super(paramContext, 2131755389);
  }
  
  public ahcr(Context paramContext, String paramString)
  {
    super(paramContext, 2131755389);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131561374, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 48;
    localLayoutParams.y += getContext().getResources().getDimensionPixelOffset(2131298994);
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = (TextView)paramBundle.findViewById(2131370763);
      if (localObject != null) {
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_AndroidViewView = paramBundle;
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcr
 * JD-Core Version:    0.7.0.1
 */