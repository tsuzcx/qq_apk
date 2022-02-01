import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class acot
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private acou jdField_a_of_type_Acou;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  
  public void a(float paramFloat)
  {
    if ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F - paramFloat);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(paramFloat);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (paramLong1 > 0L)
      {
        a(anni.a(2131704006) + paramLong2 + "s", 0);
        return;
      }
      a("", 4);
      return;
    }
    if (paramLong1 > 0L)
    {
      a(String.format(anni.a(2131692597), new Object[] { Long.valueOf(paramLong2) }), 0);
      return;
    }
    a(anni.a(2131692596), 0);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      if (this.c == null)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen bar == null");
        return;
      }
      if (!paramBoolean)
      {
        QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen !isPortait");
        return;
      }
    }
    catch (Exception paramActivity)
    {
      QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.jdField_a_of_type_Int);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    bqcd.a(paramActivity);
    if (bqcd.b())
    {
      localLayoutParams.topMargin = bqcd.b(paramActivity);
      this.c.setLayoutParams(localLayoutParams);
      QLog.i("GdtMvTitleHelper", 1, "fitSpecialScreen addHeight = " + localLayoutParams.topMargin);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null))
    {
      QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    QLog.i("GdtMvTitleHelper", 1, "refreshVoiceIconDrawableInner " + paramBoolean);
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130838474);
      localDrawable = bgmo.a(paramContext, -16777216);
      a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692607);
      a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692607);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130838475);
    Drawable localDrawable = bgmo.a(paramContext, -16777216);
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692606);
    a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692606);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367587));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367589));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367590));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367588);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381189));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381191));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381192));
    ImageView localImageView = (ImageView)paramView.findViewById(2131381190);
    localImageView.setImageDrawable(bgmo.a(paramView.getContext().getResources().getDrawable(2130840221), -16777216));
    this.jdField_a_of_type_AndroidViewView = localImageView;
    paramView.findViewById(2131367596).setVisibility(8);
    paramView.findViewById(2131381193).setVisibility(8);
  }
  
  public void a(View paramView, acou paramacou, acoe paramacoe)
  {
    if ((paramacoe != null) && (paramacoe.a() != null) && (paramacoe.a().exp_info.has()) && (paramacoe.a().exp_info.video_countdown_style.has())) {
      this.jdField_a_of_type_Int = paramacoe.a().exp_info.video_countdown_style.get();
    }
    this.jdField_a_of_type_Acou = paramacou;
    this.c = paramView.findViewById(2131367388);
    if (this.c == null)
    {
      QLog.i("GdtMvTitleHelper", 1, "bar == null");
      return;
    }
    QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      b(paramView);
      return;
    }
    a(paramView);
  }
  
  protected void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setContentDescription(anni.a(paramInt));
  }
  
  protected void a(String paramString, int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367596));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367598));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367599));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367597);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381193));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381196));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381197));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381195);
    paramView.findViewById(2131367587).setVisibility(8);
    paramView.findViewById(2131381189).setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Acou != null)
      {
        this.jdField_a_of_type_Acou.a();
        continue;
        if (this.jdField_a_of_type_Acou != null) {
          this.jdField_a_of_type_Acou.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acot
 * JD-Core Version:    0.7.0.1
 */