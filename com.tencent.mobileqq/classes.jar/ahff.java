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

public class ahff
  extends ahfc
{
  public ahff(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private String a(long paramLong)
  {
    int i = (int)Math.ceil(paramLong * 1.0D / 86400L);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692181), new Object[] { Integer.valueOf(i) });
  }
  
  private void a(ahfg paramahfg)
  {
    if (this.jdField_a_of_type_Atcc.c() == 3)
    {
      i = this.jdField_a_of_type_Atcc.e();
      paramahfg.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      paramahfg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if ((paramahfg.e >= 0) && (i - paramahfg.e > 1))
      {
        paramahfg.e = i;
        QQAppInterface.f(this.jdField_a_of_type_AndroidContentContext.getString(2131692188) + i);
      }
      paramahfg.jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692188) + i);
      i = afur.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (this.jdField_a_of_type_Atcc.a())
      {
        paramahfg.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
        return;
      }
      paramahfg.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
      return;
    }
    paramahfg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    int i = afur.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (this.jdField_a_of_type_Atcc.a())
    {
      paramahfg.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
      return;
    }
    paramahfg.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
  }
  
  private void a(ahfg paramahfg, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout = this.jdField_a_of_type_Atcc.a();
    atvo.a(paramahfg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramBaseChatItemLayout);
    paramahfg.b.setText(paramBaseChatItemLayout);
    long l = this.jdField_a_of_type_Atcc.a();
    paramahfg.c.setText(atwl.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    a(paramahfg);
    b(paramahfg);
  }
  
  private void b(ahfg paramahfg)
  {
    String str2 = "";
    int i = this.jdField_a_of_type_Atcc.c();
    String str1;
    if (i == 1) {
      str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692145);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramahfg.d.setVisibility(0);
      paramahfg.d.setText(str1);
      return;
      if (i == 6)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692144);
      }
      else if (i == 2)
      {
        i = this.jdField_a_of_type_Atcc.d();
        if (i == 3)
        {
          str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692149);
        }
        else
        {
          str1 = str2;
          if (i == 6) {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692148);
          }
        }
      }
      else if (i == 4)
      {
        str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692147);
      }
      else
      {
        long l;
        if (i == 2)
        {
          l = this.jdField_a_of_type_Atcc.b();
          if (l == -1L)
          {
            str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692145);
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
          i = this.jdField_a_of_type_Atcc.d();
          str1 = str2;
          if (i != 1) {
            if (i == 2)
            {
              str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692150);
            }
            else
            {
              str1 = str2;
              if (i != 4) {
                if (i == 5)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692142);
                }
                else if (i == 6)
                {
                  str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692142);
                }
                else
                {
                  l = this.jdField_a_of_type_Atcc.b();
                  if (l == -1L)
                  {
                    str1 = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692144);
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
    paramahfg.d.setVisibility(8);
  }
  
  protected View a(afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    ahfg localahfg = (ahfg)paramafwr;
    paramafwr = paramView;
    if (paramView == null)
    {
      int i = afur.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramafwr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramafwr.setId(2131364379);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramafwr.setPadding(((Resources)localObject1).getDimensionPixelSize(2131296328), ((Resources)localObject1).getDimensionPixelSize(2131296330), ((Resources)localObject1).getDimensionPixelSize(2131296327), ((Resources)localObject1).getDimensionPixelSize(2131296329));
      Object localObject2 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int k = ((Resources)localObject1).getDimensionPixelSize(2131298898);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131368138);
      paramafwr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localahfg.jdField_a_of_type_AndroidViewView = paramView;
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView.setMinimumHeight(afur.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364379);
      paramafwr.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131366578);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setPadding(i, i, i, 0);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localahfg.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
      k = afur.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject2).setWidth(k);
      ((AsyncImageView)localObject2).setHeight(k);
      ((AsyncImageView)localObject2).setId(2131364348);
      ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahfg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
      localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject2).setId(2131364350);
      ((TextView)localObject2).setGravity(48);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject2).setTextSize(1, 17.0F);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject2).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364348);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahfg.b = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364347);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364350);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahfg.c = ((TextView)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject2).setId(2131364352);
      ((TextView)localObject2).setSingleLine();
      if (VersionUtils.isHoneycomb()) {
        ((TextView)localObject2).setAlpha(0.75F);
      }
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setTextColor(Color.parseColor("#878B99"));
      ((TextView)localObject2).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364347);
      localLayoutParams.addRule(8, 2131364347);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localahfg.d = ((TextView)localObject2);
      localObject1 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject1).setId(2131364351);
      ((ProgressBar)localObject1).setMax(100);
      ((ProgressBar)localObject1).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844337));
      localObject2 = new LinearLayout.LayoutParams(-1, afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject2).setMargins(i, j, i, j);
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localahfg.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      localahfg.jdField_a_of_type_AndroidViewView = paramafwr;
    }
    paramafwr.setOnClickListener(this);
    super.a(paramafwr, paramafzq);
    localahfg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    a(localahfg, paramBaseChatItemLayout);
    return paramafwr;
  }
  
  protected List<Integer> a(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.a(1);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atcc.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371380: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, afwr paramafwr)
  {
    if (paramChatMessage.isSend())
    {
      paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849995);
      return;
    }
    paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130849819);
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "4", "", "", "");
  }
  
  protected afwr b()
  {
    return new ahfg(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692185);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692182);
  }
  
  protected List<Integer> b(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.b(1);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364379) {
      this.jdField_a_of_type_Atcc.a(1, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahff
 * JD-Core Version:    0.7.0.1
 */