import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class aajr
  extends LinearLayout
  implements aajj
{
  private int jdField_a_of_type_Int = -2147483648;
  private aajg jdField_a_of_type_Aajg;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int = -2147483648;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public aajr(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      aanp.d("GdtBannerViewForCreativeSize194", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Aajg = new aajg(paramContext, paramString1);
    this.jdField_a_of_type_Aajg.setId(2131367072);
    addView(this.jdField_a_of_type_Aajg);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367075);
    this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367071);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#666666"));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Aajg == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      aanp.d("GdtBannerViewForCreativeSize194", "setSize error");
      return;
    }
    aajo localaajo = new aajo(getContext(), paramInt1, paramInt2);
    paramInt1 = Double.valueOf(1.0D * (paramInt2 - localaajo.jdField_b_of_type_Int * 2) / this.jdField_b_of_type_Int * this.jdField_a_of_type_Int + localaajo.jdField_b_of_type_Int * 2).intValue();
    this.jdField_a_of_type_Aajg.setPadding(localaajo.jdField_b_of_type_Int, localaajo.jdField_b_of_type_Int, localaajo.jdField_b_of_type_Int, localaajo.jdField_b_of_type_Int);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.jdField_a_of_type_Aajg.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localaajo.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localaajo.d);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = localaajo.c;
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, localaajo.d);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajr
 * JD-Core Version:    0.7.0.1
 */