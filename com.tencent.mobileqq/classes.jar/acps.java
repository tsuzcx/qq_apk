import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class acps
  extends LinearLayout
  implements acpm
{
  private int jdField_a_of_type_Int = -2147483648;
  private acpo jdField_a_of_type_Acpo;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int = -2147483648;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public acps(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      acvc.d("GdtBannerViewForCreativeSize194", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Acpo = new acpo(paramContext, paramString1);
    this.jdField_a_of_type_Acpo.setId(2131367431);
    addView(this.jdField_a_of_type_Acpo);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367434);
    this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setId(2131367429);
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
  
  public void a(Context paramContext) {}
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Acpo == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      acvc.d("GdtBannerViewForCreativeSize194", "setSize error");
      return;
    }
    acpq localacpq = new acpq(getContext(), paramInt1, paramInt2);
    paramInt1 = Double.valueOf(1.0D * (paramInt2 - localacpq.jdField_b_of_type_Int * 2) / this.jdField_b_of_type_Int * this.jdField_a_of_type_Int + localacpq.jdField_b_of_type_Int * 2).intValue();
    this.jdField_a_of_type_Acpo.setPadding(localacpq.jdField_b_of_type_Int, localacpq.jdField_b_of_type_Int, localacpq.jdField_b_of_type_Int, localacpq.jdField_b_of_type_Int);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.jdField_a_of_type_Acpo.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localacpq.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localacpq.d);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = localacpq.c;
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, localacpq.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acps
 * JD-Core Version:    0.7.0.1
 */