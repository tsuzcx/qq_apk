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
import com.tencent.util.VersionUtils;
import java.util.List;

public class ahor
  extends ahoo
{
  public ahor(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692186), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(ahos paramahos)
  {
    if (this.jdField_a_of_type_Attx.c() == 3)
    {
      i = this.jdField_a_of_type_Attx.e();
      paramahos.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramahos.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramahos.e >= 0) && (i - paramahos.e > 1))
      {
        paramahos.e = i;
        QQAppInterface.f(this.jdField_a_of_type_AndroidContentContext.getString(2131692193) + i);
      }
      paramahos.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692193) + i);
      i = agej.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Attx.a())
      {
        paramahos.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramahos.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramahos.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = agej.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Attx.a())
    {
      paramahos.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramahos.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(ahos paramahos, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Attx.a();
    aunj.a(paramahos.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramahos.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Attx.a();
    paramahos.c.setText(auog.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramahos);
    b(paramahos);
  }
  
  private void b(ahos paramahos)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Attx.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692150);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramahos.d.setVisibility(0);
      paramahos.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692149);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Attx.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692154);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692153);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692152);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Attx.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692150);
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
          i = this.jdField_a_of_type_Attx.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692155);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692147);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692147);
                }
                else
                {
                  l = this.jdField_a_of_type_Attx.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692149);
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
    paramahos.d.setVisibility(8);
  }
  
  protected View a(aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahos localahos = (ahos)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      int i = agej.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramaggl = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaggl.setId(2131364423);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramaggl.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296332), ((Resources)localObject1).getDimensionPixelSize(2131296334), ((Resources)localObject1).getDimensionPixelSize(2131296331), ((Resources)localObject1).getDimensionPixelSize(2131296333));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131298911);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131368212);
      paramaggl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localahos.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(agej.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364423);
      paramaggl.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366628);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localahos.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = agej.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364392);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahos.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364394);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364392);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahos.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364391);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364394);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahos.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364396);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364391);
      localLayoutParams.addRule(8, 2131364391);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahos.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364395);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844351));
      localObject2 = new LinearLayout.LayoutParams(-1, agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localahos.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localahos.jdField_a_of_type_AndroidViewView = paramaggl;
    }
    paramaggl.setOnClickListener(this);
    super.a(paramaggl, paramagjk);
    localahos.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localahos, paramBaseChatItemLayout);
    return paramaggl;
  }
  
  protected List<Integer> a(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Attx.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371487: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, aggl paramaggl)
  {
    if (paramChatMessage.isSend())
    {
      paramaggl.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850006);
      return;
    }
    paramaggl.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849830);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected aggl b()
  {
    return new ahos(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692190);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692187);
  }
  
  protected List<Integer> b(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.b(1);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364423) {
      this.jdField_a_of_type_Attx.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahor
 * JD-Core Version:    0.7.0.1
 */