import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class abia
  extends ReportDialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public abia(Context paramContext)
  {
    super(paramContext, 2131755824);
    super.setContentView(2131560425);
    super.getWindow().setWindowAnimations(2131755130);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365508));
    this.b = ((TextView)super.findViewById(2131365514));
    this.c = ((TextView)super.findViewById(2131378945));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131378946));
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (aeam.R)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131690558, new Object[] { localResources.getString(2131717998) }));
    }
    this.b.setOnClickListener(new abic(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (aeam.R)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131690558, new Object[] { str }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abib(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abia
 * JD-Core Version:    0.7.0.1
 */