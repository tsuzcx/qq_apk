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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aitj
  extends ReportDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  
  public aitj(Context paramContext)
  {
    super(paramContext, 2131755403);
  }
  
  public aitj(Context paramContext, String paramString)
  {
    super(paramContext, 2131755403);
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
    paramBundle = LayoutInflater.from(getContext()).inflate(2131561614, null);
    Object localObject = getWindow();
    ((Window)localObject).setContentView(paramBundle);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 48;
    localLayoutParams.y += getContext().getResources().getDimensionPixelOffset(2131299167);
    ((Window)localObject).setAttributes(localLayoutParams);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = (TextView)paramBundle.findViewById(2131371603);
      if (localObject != null) {
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_AndroidViewView = paramBundle;
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitj
 * JD-Core Version:    0.7.0.1
 */