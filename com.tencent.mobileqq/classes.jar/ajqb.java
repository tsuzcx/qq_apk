import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;

public class ajqb
  extends ReportDialog
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public ajqb(Context paramContext)
  {
    super(paramContext, 2131755829);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    setContentView(2131559041);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365648));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365644));
    this.c = ((TextView)findViewById(2131365633));
    this.d = ((TextView)findViewById(2131365639));
    this.e = ((TextView)findViewById(2131365605));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367272));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131377332));
    this.f = ((TextView)findViewById(2131373247));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131366139));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365651));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365677));
  }
  
  public ajqb a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691087));
    this.c.setVisibility(0);
    this.c.setOnClickListener(new ajqc(this, paramOnClickListener));
    return this;
  }
  
  public ajqb a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public ajqb a(List<String> paramList, View.OnClickListener paramOnClickListener)
  {
    if ((paramList == null) || (paramOnClickListener == null)) {
      return this;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(new ajqh(paramList));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(new DefaultItemAnimator());
    paramList = new asfu(paramOnClickListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramList);
    return this;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (paramInt > 0)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.f == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.setVisibility(0);
        this.f.setText(paramString);
      }
    } while ((paramInt < 0) || (paramInt > 100));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt, true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
  }
  
  public ajqb b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691087));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new ajqd(this, paramOnClickListener));
    return this;
  }
  
  public ajqb b(String paramString)
  {
    if ((this.f == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return this;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.f.setVisibility(0);
      this.f.setText(paramString);
      return this;
    }
    this.f.setVisibility(4);
    return this;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ajqf.a(this.jdField_a_of_type_AndroidWidgetProgressBar, paramInt);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public ajqb c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691087));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ajqe(this, paramOnClickListener));
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}finally
    {
      acxo.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqb
 * JD-Core Version:    0.7.0.1
 */