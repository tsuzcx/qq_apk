import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.io.File;
import java.util.List;

public class adxb
  extends adww
{
  private Drawable a;
  
  public adxb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(adxc paramadxc)
  {
    String str = this.jdField_a_of_type_Aoyq.b();
    if (bbdx.b(str))
    {
      int i = this.jdField_a_of_type_Aoyq.a();
      int j = this.jdField_a_of_type_Aoyq.b();
      if ((i == 0) || (j == 0)) {
        a(paramadxc, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramadxc.e;
      localURLDrawableOptions.mRequestHeight = paramadxc.f;
      localURLDrawableOptions.mLoadingDrawable = new anoz(Color.rgb(214, 214, 214), paramadxc.e, paramadxc.f);
      localURLDrawableOptions.mFailedDrawable = aywm.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramadxc = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramadxc.setAutoDownload(true);
      return paramadxc;
    }
    this.jdField_a_of_type_Aoyq.a();
    return a();
  }
  
  private void a(adxc paramadxc)
  {
    if (paramadxc.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(ajya.a(2131715390));
      ((TextView)localObject).setCompoundDrawablePadding(actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848699, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadxc.e, paramadxc.f);
      ((RelativeLayout)paramadxc.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bbdx.a(this.jdField_a_of_type_Aoyq.a());
      a(this.jdField_a_of_type_Aoyq.a(), (String)localObject, paramadxc, localRelativeLayout, true);
      paramadxc.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adxc paramadxc, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramadxc);
    Object localObject = bbdx.a(this.jdField_a_of_type_Aoyq.a());
    a(this.jdField_a_of_type_Aoyq.a(), (String)localObject, paramadxc, (RelativeLayout)paramadxc.jdField_a_of_type_AndroidViewView, false);
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramadxc.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadxc.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadxc.jdField_a_of_type_AndroidViewView).removeView(paramadxc.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramadxc);
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843503);
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramadxc, paramBaseChatItemLayout);
  }
  
  private void a(adxc paramadxc, String paramString)
  {
    if (!bbdx.b(paramString)) {
      return;
    }
    paramString = apug.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadxc.e = i;
      paramadxc.f = j;
      this.jdField_a_of_type_Aoyq.a(i, j);
    }
    b(paramadxc);
  }
  
  private void a(String paramString1, String paramString2, adxc paramadxc, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadxc.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadxc.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadxc.jdField_a_of_type_AndroidViewView).removeView(paramadxc.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364077);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838791);
    paramadxc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, actj.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131371608);
      if (paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = apvm.a(paramadxc.e, paramadxc.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364077);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364080);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364077);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = apvm.a(this.jdField_a_of_type_AndroidContentContext, i, paramadxc.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      break;
      label599:
      localLayoutParams.addRule(12);
      break label417;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  private void b(adxc paramadxc)
  {
    int i = this.jdField_a_of_type_Aoyq.a();
    int j = this.jdField_a_of_type_Aoyq.b();
    label24:
    Object localObject;
    if (i > 0)
    {
      if (j <= 0) {
        break label127;
      }
      localObject = ShortVideoUtils.a(i, j);
      i = localObject[0];
      j = localObject[1];
      localObject = paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramadxc.e = i;
      paramadxc.f = j;
      return;
      i = 640;
      break;
      label127:
      j = 480;
      break label24;
      label134:
      if ((((ViewGroup.LayoutParams)localObject).width == i) && (((ViewGroup.LayoutParams)localObject).height == j)) {
        break label75;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(adxc paramadxc, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aoyq.c();
    if (i == 1)
    {
      if (!bbdx.b(this.jdField_a_of_type_Aoyq.b()))
      {
        b(paramadxc);
        a(paramadxc);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Aoyq.e();
      if (i < 100)
      {
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = ajya.a(2131715373);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848698);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = ajya.a(2131715382);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848698);
        paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848698);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadxc.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public acui a(View paramView)
  {
    if (paramView != null)
    {
      paramView = actj.a(paramView);
      if ((paramView != null) && (adxc.class.isInstance(paramView)))
      {
        paramView = (adxc)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new adkj(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Object localObject;
    if ((paramacuj instanceof adxc))
    {
      localObject = (adxc)paramacuj;
      paramacuj = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramacuj;
      if (paramacuj == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacuj = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacuj.setId(2131371608);
        paramacuj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacuj.setRadius(15.0F);
        paramacuj.d(true);
        paramacuj.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacuj);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364151);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacuj.setOnClickListener(this);
        super.a(paramacuj, paramacxj);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacuj;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramacuj = this.jdField_a_of_type_Aoyq.a();
      boolean bool = paramacuj.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacxj);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramacuj.frienduin + paramacuj.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new adxc(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacuj.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacuj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacuj.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ambg = paramacuj.jdField_a_of_type_Ambg;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacuj.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacuj.jdField_b_of_type_Int;
      paramView.c = paramacuj.c;
      paramView.d = paramacuj.d;
      paramView.jdField_a_of_type_JavaLangString = paramacuj.jdField_a_of_type_JavaLangString;
      paramacuj = null;
    }
  }
  
  protected List<Integer> a(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.a(3);
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
  
  protected acuj b()
  {
    return new adxc(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bbfh.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692521);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692518);
  }
  
  protected List<Integer> b(bbmf parambbmf, acva paramacva)
  {
    return this.jdField_a_of_type_Aoyq.b(3);
  }
  
  protected void d(View paramView)
  {
    if ((paramView.getId() != 2131371608) && (paramView.getId() != 2131364151)) {
      return;
    }
    this.jdField_a_of_type_Aoyq.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxb
 * JD-Core Version:    0.7.0.1
 */