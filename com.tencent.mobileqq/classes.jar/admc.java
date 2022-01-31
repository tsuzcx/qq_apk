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

public class admc
  extends adlz
{
  public admc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static View a(Context paramContext)
  {
    return null;
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131626899), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(admd paramadmd)
  {
    if (this.jdField_a_of_type_Aohs.c() == 3)
    {
      i = this.jdField_a_of_type_Aohs.e();
      paramadmd.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramadmd.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramadmd.e >= 0) && (i - paramadmd.e > 1))
      {
        paramadmd.e = i;
        QQAppInterface.f(this.jdField_a_of_type_AndroidContentContext.getString(2131626906) + i);
      }
      paramadmd.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131626906) + i);
      i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Aohs.a())
      {
        paramadmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramadmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramadmd.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Aohs.a())
    {
      paramadmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramadmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(admd paramadmd, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Aohs.a();
    apck.a(paramadmd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramadmd.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Aohs.a();
    paramadmd.c.setText(apdh.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramadmd);
    b(paramadmd);
  }
  
  private void b(admd paramadmd)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Aohs.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626868);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramadmd.d.setVisibility(0);
      paramadmd.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626867);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Aohs.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626872);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626871);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626870);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Aohs.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626868);
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
          i = this.jdField_a_of_type_Aohs.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626873);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626865);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626865);
                }
                else
                {
                  l = this.jdField_a_of_type_Aohs.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131626867);
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
    paramadmd.d.setVisibility(8);
  }
  
  protected View a(acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    admd localadmd = (admd)paramacju;
    paramacju = paramView;
    if (paramView == null)
    {
      int i = aciy.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramacju = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramacju.setId(2131298552);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramacju.setPadding(((Resources)localObject1).getDimensionPixelSize(2131165216), ((Resources)localObject1).getDimensionPixelSize(2131165218), ((Resources)localObject1).getDimensionPixelSize(2131165215), ((Resources)localObject1).getDimensionPixelSize(2131165217));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.y, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131167688);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131302061);
      paramacju.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localadmd.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(aciy.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131298552);
      paramacju.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131300634);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localadmd.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = aciy.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131298521);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadmd.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131298523);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131298521);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadmd.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131298520);
      ((TextView)localObject2).setSingleLine();
      if (befo.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131298523);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadmd.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131298525);
      ((TextView)localObject2).setSingleLine();
      if (befo.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131298520);
      localLayoutParams.addRule(8, 2131298520);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadmd.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131298524);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843430));
      localObject2 = new LinearLayout.LayoutParams(-1, aciy.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localadmd.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localadmd.jdField_a_of_type_AndroidViewView = paramacju;
    }
    paramacju.setOnClickListener(this);
    super.a(paramacju, paramacmv);
    localadmd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localadmd, paramBaseChatItemLayout);
    return paramacju;
  }
  
  protected List<Integer> a(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aohs.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131304829: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, acju paramacju)
  {
    if (paramChatMessage.isSend())
    {
      paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848708);
      return;
    }
    paramacju.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848515);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected acju b()
  {
    return new admd(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131626903);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131626900);
  }
  
  protected List<Integer> b(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.b(1);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131298552) {
      this.jdField_a_of_type_Aohs.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admc
 * JD-Core Version:    0.7.0.1
 */