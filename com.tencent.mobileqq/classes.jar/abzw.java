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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class abzw
  extends Dialog
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
  
  public abzw(@NonNull Context paramContext)
  {
    super(paramContext, 2131755247);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2131559409, null);
    setContentView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(paramContext, 2131362695));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(paramContext, 2131362707));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(paramContext, 2131362916));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(paramContext, 2131379439));
    this.c = ((TextView)a(paramContext, 2131379467));
    this.d = ((TextView)a(paramContext, 2131362906));
    this.d.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.e = ((TextView)a(paramContext, 2131369356));
    this.f = ((TextView)a(paramContext, 2131375805));
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
    setOnCancelListener(new abzz(this, paramOnCancelListener));
    setOnKeyListener(new acaa(this, paramOnCancelListener));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(new abzx(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (ndd.a(paramString))
    {
      paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramString.setTag(bcyz.b(localLayoutParams.width, localLayoutParams.height, xsm.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
      paramString.setDecodeHandler(bcyz.i);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(new abzy(this, paramOnClickListener));
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
 * Qualified Name:     abzw
 * JD-Core Version:    0.7.0.1
 */