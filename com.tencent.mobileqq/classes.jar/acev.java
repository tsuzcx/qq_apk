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
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo;

public class acev
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private acew jdField_a_of_type_Acew;
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
  
  public void a(int paramInt)
  {
    this.c.setVisibility(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (paramLong1 > 0L)
      {
        a(anvx.a(2131704693) + paramLong2 + "s", 0);
        return;
      }
      a("", 4);
      return;
    }
    if (paramLong1 > 0L)
    {
      a(String.format(anvx.a(2131692753), new Object[] { Long.valueOf(paramLong2) }), 0);
      return;
    }
    a(anvx.a(2131692752), 0);
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
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.b())
    {
      localLayoutParams.topMargin = LiuHaiUtils.b(paramActivity);
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
      paramContext = paramContext.getResources().getDrawable(2130838534);
      localDrawable = bheg.a(paramContext, -16777216);
      a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692765);
      a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692765);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130838535);
    Drawable localDrawable = bheg.a(paramContext, -16777216);
    a(this.jdField_a_of_type_AndroidWidgetImageView, paramContext, 2131692764);
    a(this.jdField_b_of_type_AndroidWidgetImageView, localDrawable, 2131692764);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367824));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367826));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367827));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367825);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381439));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381441));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381442));
    ImageView localImageView = (ImageView)paramView.findViewById(2131381440);
    localImageView.setImageDrawable(bheg.a(paramView.getContext().getResources().getDrawable(2130840303), -16777216));
    this.jdField_a_of_type_AndroidViewView = localImageView;
    paramView.findViewById(2131367833).setVisibility(8);
    paramView.findViewById(2131381443).setVisibility(8);
  }
  
  public void a(View paramView, acew paramacew, aced paramaced, aceu paramaceu)
  {
    if ((paramaced != null) && (paramaced.a() != null) && (paramaced.a().exp_info.has()) && (paramaced.a().exp_info.video_countdown_style.has())) {
      this.jdField_a_of_type_Int = paramaced.a().exp_info.video_countdown_style.get();
    }
    this.jdField_a_of_type_Acew = paramacew;
    this.c = paramView.findViewById(2131367610);
    if (this.c == null) {
      QLog.i("GdtMvTitleHelper", 1, "bar == null");
    }
    for (;;)
    {
      return;
      QLog.i("GdtMvTitleHelper", 1, "initView countDownStyle =" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 0) {
        b(paramView);
      }
      while (paramaceu != null)
      {
        paramaceu.a(this.jdField_a_of_type_AndroidWidgetImageView);
        paramaceu.a(this.jdField_a_of_type_AndroidViewView);
        return;
        a(paramView);
      }
    }
  }
  
  protected void a(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setContentDescription(anvx.a(paramInt));
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367833));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367835));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367836));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367834);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381443));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381446));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381447));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381445);
    paramView.findViewById(2131367824).setVisibility(8);
    paramView.findViewById(2131381439).setVisibility(8);
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
      if (this.jdField_a_of_type_Acew != null)
      {
        this.jdField_a_of_type_Acew.a(true);
        continue;
        if (this.jdField_a_of_type_Acew != null) {
          this.jdField_a_of_type_Acew.b(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acev
 * JD-Core Version:    0.7.0.1
 */