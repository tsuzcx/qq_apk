import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;

public final class acbq
  extends LinearLayout
  implements acbl
{
  private int jdField_a_of_type_Int = -2147483648;
  private acbn jdField_a_of_type_Acbn;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b = -2147483648;
  
  public acbq(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      acho.d("GdtBannerViewWithPictureText", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Acbn = new acbn(paramContext, paramString1);
    this.jdField_a_of_type_Acbn.setId(2131367591);
    addView(this.jdField_a_of_type_Acbn);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367594);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return null;
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
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0) || (this.jdField_a_of_type_Acbn == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      acho.d("GdtBannerViewWithPictureText", "setSize error");
      return;
    }
    acbp localacbp = new acbp(getContext(), paramInt1, paramInt2);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(Double.valueOf(1.0D * (paramInt2 - localacbp.b * 2) / this.b * this.jdField_a_of_type_Int + localacbp.b * 2).intValue(), paramInt2);
    this.jdField_a_of_type_Acbn.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Acbn.setPadding(localacbp.b, localacbp.b, localacbp.b, localacbp.b);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localacbp.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localacbp.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbq
 * JD-Core Version:    0.7.0.1
 */