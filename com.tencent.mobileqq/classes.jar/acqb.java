import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.core.UniformDownloadNfn;
import com.tencent.qphone.base.util.QLog;

public class acqb
{
  float jdField_a_of_type_Float = 14.0F;
  int jdField_a_of_type_Int = 0;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  Integer jdField_a_of_type_JavaLangInteger = null;
  final String jdField_a_of_type_JavaLangString = "SearchForText";
  float jdField_b_of_type_Float = 16.0F;
  Integer jdField_b_of_type_JavaLangInteger = null;
  final String jdField_b_of_type_JavaLangString = "SearchForTitle";
  
  public acqb(UniformDownloadNfn paramUniformDownloadNfn, Context paramContext)
  {
    if (paramContext != null)
    {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      a(paramContext, false);
    }
  }
  
  private boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_b_of_type_Float = localTextView.getTextSize();
          this.jdField_b_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_a_of_type_Float = localTextView.getTextSize();
          this.jdField_a_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    }
    if ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_b_of_type_JavaLangInteger != null)) {}
    while (this.jdField_a_of_type_Int > 3) {
      return;
    }
    this.jdField_a_of_type_Int += 1;
    try
    {
      Notification localNotification = new Notification();
      localNotification.setLatestEventInfo(paramContext, "SearchForTitle", "SearchForText", null);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      paramContext = (ViewGroup)localNotification.contentView.apply(paramContext, localLinearLayout);
      if (!a(paramContext)) {
        QLog.w(UniformDownloadNfn.jdField_a_of_type_JavaLangString, 1, "[UniformDL]. recurseTitleGroup failed");
      }
      if (!b(paramContext)) {
        QLog.w(UniformDownloadNfn.jdField_a_of_type_JavaLangString, 1, "[UniformDL]. recurseTextGroup, failed");
      }
      localLinearLayout.removeAllViews();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.w(UniformDownloadNfn.jdField_a_of_type_JavaLangString, 1, "[UniformDL]. extractColors, exception");
      paramContext.printStackTrace();
      return;
    }
    catch (NoSuchFieldError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public Integer b()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqb
 * JD-Core Version:    0.7.0.1
 */