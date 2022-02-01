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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.util.VersionUtils;
import java.util.List;

public class agle
  extends aglb
{
  public agle(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692234), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(aglf paramaglf)
  {
    if (this.jdField_a_of_type_Asgh.c() == 3)
    {
      i = this.jdField_a_of_type_Asgh.e();
      paramaglf.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramaglf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramaglf.e >= 0) && (i - paramaglf.e > 1))
      {
        paramaglf.e = i;
        QQAppInterface.speak(this.jdField_a_of_type_AndroidContentContext.getString(2131692241) + i);
      }
      paramaglf.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692241) + i);
      i = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Asgh.a())
      {
        paramaglf.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramaglf.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramaglf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Asgh.a())
    {
      paramaglf.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramaglf.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(aglf paramaglf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Asgh.a();
    aszt.a(paramaglf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramaglf.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Asgh.a();
    paramaglf.c.setText(FileUtil.filesizeToString(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramaglf);
    b(paramaglf);
  }
  
  private void b(aglf paramaglf)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Asgh.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692198);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramaglf.d.setVisibility(0);
      paramaglf.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692197);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Asgh.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692202);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692201);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692200);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Asgh.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692198);
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
          i = this.jdField_a_of_type_Asgh.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692203);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692195);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692195);
                }
                else
                {
                  l = this.jdField_a_of_type_Asgh.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692197);
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
    paramaglf.d.setVisibility(8);
  }
  
  protected View a(aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    aglf localaglf = (aglf)paramaezf;
    paramaezf = paramView;
    if (paramView == null)
    {
      int i = AIOUtils.dp2px(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramaezf = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaezf.setId(2131364441);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaezf.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296385), ((Resources)localObject1).getDimensionPixelSize(2131296387), ((Resources)localObject1).getDimensionPixelSize(2131296384), ((Resources)localObject1).getDimensionPixelSize(2131296386));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131298976);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131368236);
      paramaezf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localaglf.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(AIOUtils.dp2px(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364441);
      paramaezf.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366655);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localaglf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = AIOUtils.dp2px(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364410);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localaglf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364412);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364410);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localaglf.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364409);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364412);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localaglf.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364414);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364409);
      localLayoutParams.addRule(8, 2131364409);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localaglf.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364413);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844236));
      localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localaglf.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localaglf.jdField_a_of_type_AndroidViewView = paramaezf;
    }
    paramaezf.setOnClickListener(this);
    super.a(paramaezf, paramafce);
    localaglf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localaglf, paramBaseChatItemLayout);
    return paramaezf;
  }
  
  protected List<Integer> a(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Asgh.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371455: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, aezf paramaezf)
  {
    if (paramChatMessage.isSend())
    {
      paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849923);
      return;
    }
    paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849747);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected aezf b()
  {
    return new aglf(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bfwr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692238);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692235);
  }
  
  protected List<Integer> b(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.b(1);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364441) {
      this.jdField_a_of_type_Asgh.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agle
 * JD-Core Version:    0.7.0.1
 */