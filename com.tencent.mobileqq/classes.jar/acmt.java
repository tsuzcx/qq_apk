import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class acmt
  extends ReportDialog
{
  public static boolean a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public acmt(@NonNull Context paramContext)
  {
    super(paramContext, 2131755254);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559546, null);
    setContentView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(paramContext, 2131362830));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(paramContext, 2131362842));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(paramContext, 2131363067));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(paramContext, 2131380274));
    this.c = ((TextView)a(paramContext, 2131380302));
    this.d = ((TextView)a(paramContext, 2131363057));
    this.d.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.e = ((TextView)a(paramContext, 2131369833));
    this.f = ((TextView)a(paramContext, 2131376433));
    setCanceledOnTouchOutside(false);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setGravity(80);
    }
  }
  
  public <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public void a()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    setOnCancelListener(new acmw(this, paramOnCancelListener));
    setOnKeyListener(new acmx(this, paramOnCancelListener));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(new acmu(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (HttpUtil.isValidUrl(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramString.setTag(bfol.b(localLayoutParams.width, localLayoutParams.height, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
      paramString.setDecodeHandler(bfol.j);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(new acmv(this, paramOnClickListener));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void d(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void e(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void f(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmt
 * JD-Core Version:    0.7.0.1
 */