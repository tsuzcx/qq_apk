import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import java.util.List;

public class afyb
  extends afxy
{
  public afyb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692592), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(afyc paramafyc)
  {
    if (this.jdField_a_of_type_Aqvx.c() == 3)
    {
      i = this.jdField_a_of_type_Aqvx.e();
      paramafyc.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramafyc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramafyc.e >= 0) && (i - paramafyc.e > 1))
      {
        paramafyc.e = i;
        QQAppInterface.f(this.jdField_a_of_type_AndroidContentContext.getString(2131692599) + i);
      }
      paramafyc.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692599) + i);
      i = aepi.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aepi.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Aqvx.a())
      {
        paramafyc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramafyc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramafyc.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = aepi.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aepi.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Aqvx.a())
    {
      paramafyc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramafyc.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(afyc paramafyc, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Aqvx.a();
    arrr.a(paramafyc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramafyc.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Aqvx.a();
    paramafyc.c.setText(arso.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramafyc);
    b(paramafyc);
  }
  
  private void b(afyc paramafyc)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Aqvx.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692559);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramafyc.d.setVisibility(0);
      paramafyc.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692558);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Aqvx.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692563);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692562);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692561);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Aqvx.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692559);
          }
          else
          {
            str1 = str2;
            if (l != 0L) {
              str1 = a(l);
            }
          }
        }
        else
        {
          i = this.jdField_a_of_type_Aqvx.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692564);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692556);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692556);
                }
                else
                {
                  l = this.jdField_a_of_type_Aqvx.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692558);
                  }
                  else
                  {
                    str1 = str2;
                    if (l != 0L) {
                      str1 = a(l);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramafyc.d.setVisibility(8);
  }
  
  protected View a(aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    afyc localafyc = (afyc)paramaeqi;
    paramaeqi = paramView;
    if (paramView == null)
    {
      int i = aepi.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramaeqi = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaeqi.setId(2131364173);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaeqi.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296294), ((Resources)localObject1).getDimensionPixelSize(2131296296), ((Resources)localObject1).getDimensionPixelSize(2131296293), ((Resources)localObject1).getDimensionPixelSize(2131296295));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.y, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131298815);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367819);
      paramaeqi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localafyc.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(aepi.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364173);
      paramaeqi.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366326);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localafyc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = aepi.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364142);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localafyc.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364144);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364142);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localafyc.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364141);
      ((TextView)localObject2).setSingleLine();
      if (bhtb.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364144);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localafyc.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364146);
      ((TextView)localObject2).setSingleLine();
      if (bhtb.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364141);
      localLayoutParams.addRule(8, 2131364141);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localafyc.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364145);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843946));
      localObject2 = new LinearLayout.LayoutParams(-1, aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localafyc.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localafyc.jdField_a_of_type_AndroidViewView = paramaeqi;
    }
    paramaeqi.setOnClickListener(this);
    super.a(paramaeqi, paramaetk);
    localafyc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localafyc, paramBaseChatItemLayout);
    return paramaeqi;
  }
  
  protected List<Integer> a(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqvx.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370818: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, aeqi paramaeqi)
  {
    if (paramChatMessage.isSend())
    {
      paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849444);
      return;
    }
    paramaeqi.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849268);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected aeqi b()
  {
    return new afyc(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692596);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692593);
  }
  
  protected List<Integer> b(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.b(1);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364173) {
      this.jdField_a_of_type_Aqvx.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyb
 * JD-Core Version:    0.7.0.1
 */