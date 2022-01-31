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

public class adwz
  extends adww
{
  public adwz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692515), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(adxa paramadxa)
  {
    if (this.jdField_a_of_type_Aoyq.c() == 3)
    {
      i = this.jdField_a_of_type_Aoyq.e();
      paramadxa.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramadxa.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramadxa.e >= 0) && (i - paramadxa.e > 1))
      {
        paramadxa.e = i;
        QQAppInterface.f(this.jdField_a_of_type_AndroidContentContext.getString(2131692522) + i);
      }
      paramadxa.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692522) + i);
      i = actj.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = actj.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Aoyq.a())
      {
        paramadxa.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramadxa.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramadxa.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = actj.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = actj.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Aoyq.a())
    {
      paramadxa.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramadxa.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(adxa paramadxa, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Aoyq.a();
    apug.a(paramadxa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramadxa.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Aoyq.a();
    paramadxa.c.setText(apvd.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramadxa);
    b(paramadxa);
  }
  
  private void b(adxa paramadxa)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Aoyq.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692482);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramadxa.d.setVisibility(0);
      paramadxa.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692481);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Aoyq.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692486);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692485);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692484);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Aoyq.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692482);
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
          i = this.jdField_a_of_type_Aoyq.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692487);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692479);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692479);
                }
                else
                {
                  l = this.jdField_a_of_type_Aoyq.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692481);
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
    paramadxa.d.setVisibility(8);
  }
  
  protected View a(acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    adxa localadxa = (adxa)paramacuj;
    paramacuj = paramView;
    if (paramView == null)
    {
      int i = actj.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramacuj = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramacuj.setId(2131364109);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramacuj.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296288), ((Resources)localObject1).getDimensionPixelSize(2131296290), ((Resources)localObject1).getDimensionPixelSize(2131296287), ((Resources)localObject1).getDimensionPixelSize(2131296289));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.y, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131298787);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131367679);
      paramacuj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localadxa.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(actj.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364109);
      paramacuj.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366236);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localadxa.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = actj.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364078);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadxa.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364080);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364078);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadxa.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364077);
      ((TextView)localObject2).setSingleLine();
      if (bfnz.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364080);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadxa.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364082);
      ((TextView)localObject2).setSingleLine();
      if (bfnz.e()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364077);
      localLayoutParams.addRule(8, 2131364077);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localadxa.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364081);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843515));
      localObject2 = new LinearLayout.LayoutParams(-1, actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localadxa.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localadxa.jdField_a_of_type_AndroidViewView = paramacuj;
    }
    paramacuj.setOnClickListener(this);
    super.a(paramacuj, paramacxj);
    localadxa.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localadxa, paramBaseChatItemLayout);
    return paramacuj;
  }
  
  protected List<Integer> a(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoyq.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370493: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, acuj paramacuj)
  {
    if (paramChatMessage.isSend())
    {
      paramacuj.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848940);
      return;
    }
    paramacuj.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848764);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected acuj b()
  {
    return new adxa(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bbfh.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692519);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692516);
  }
  
  protected List<Integer> b(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.b(1);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364109) {
      this.jdField_a_of_type_Aoyq.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwz
 * JD-Core Version:    0.7.0.1
 */