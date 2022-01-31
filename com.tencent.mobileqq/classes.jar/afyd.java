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

public class afyd
  extends afxy
{
  private Drawable a;
  
  public afyd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(afye paramafye)
  {
    String str = this.jdField_a_of_type_Aqvx.b();
    if (bdhb.b(str))
    {
      int i = this.jdField_a_of_type_Aqvx.a();
      int j = this.jdField_a_of_type_Aqvx.b();
      if ((i == 0) || (j == 0)) {
        a(paramafye, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramafye.e;
      localURLDrawableOptions.mRequestHeight = paramafye.f;
      localURLDrawableOptions.mLoadingDrawable = new apkp(Color.rgb(214, 214, 214), paramafye.e, paramafye.f);
      localURLDrawableOptions.mFailedDrawable = bayu.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramafye = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramafye.setAutoDownload(true);
      return paramafye;
    }
    this.jdField_a_of_type_Aqvx.a();
    return a();
  }
  
  private void a(afye paramafye)
  {
    if (paramafye.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(alud.a(2131715774));
      ((TextView)localObject).setCompoundDrawablePadding(aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849204, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramafye.e, paramafye.f);
      ((RelativeLayout)paramafye.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bdhb.a(this.jdField_a_of_type_Aqvx.a());
      a(this.jdField_a_of_type_Aqvx.a(), (String)localObject, paramafye, localRelativeLayout, true);
      paramafye.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(afye paramafye, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramafye);
    Object localObject = bdhb.a(this.jdField_a_of_type_Aqvx.a());
    a(this.jdField_a_of_type_Aqvx.a(), (String)localObject, paramafye, (RelativeLayout)paramafye.jdField_a_of_type_AndroidViewView, false);
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramafye.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramafye.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramafye.jdField_a_of_type_AndroidViewView).removeView(paramafye.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramafye);
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843934);
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramafye, paramBaseChatItemLayout);
  }
  
  private void a(afye paramafye, String paramString)
  {
    if (!bdhb.b(paramString)) {
      return;
    }
    paramString = arrr.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramafye.e = i;
      paramafye.f = j;
      this.jdField_a_of_type_Aqvx.a(i, j);
    }
    b(paramafye);
  }
  
  private void a(String paramString1, String paramString2, afye paramafye, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramafye.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramafye.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramafye.jdField_a_of_type_AndroidViewView).removeView(paramafye.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364141);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838947);
    paramafye.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, aepi.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131371945);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131371945);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131371945);
      if (paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = arsx.a(paramafye.e, paramafye.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364141);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364144);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364141);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = arsx.a(this.jdField_a_of_type_AndroidContentContext, i, paramafye.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aepi.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(afye paramafye)
  {
    int i = this.jdField_a_of_type_Aqvx.a();
    int j = this.jdField_a_of_type_Aqvx.b();
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
      localObject = paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramafye.e = i;
      paramafye.f = j;
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
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(afye paramafye, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aqvx.c();
    if (i == 1)
    {
      if (!bdhb.b(this.jdField_a_of_type_Aqvx.b()))
      {
        b(paramafye);
        a(paramafye);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Aqvx.e();
      if (i < 100)
      {
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = alud.a(2131715757);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849203);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = alud.a(2131715766);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849203);
        paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849203);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafye.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramafye.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public aeqh a(View paramView)
  {
    if (paramView != null)
    {
      paramView = aepi.a(paramView);
      if ((paramView != null) && (afye.class.isInstance(paramView)))
      {
        paramView = (afye)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afhi(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Object localObject;
    if ((paramaeqi instanceof afye))
    {
      localObject = (afye)paramaeqi;
      paramaeqi = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramaeqi;
      if (paramaeqi == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaeqi = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramaeqi.setId(2131371945);
        paramaeqi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaeqi.setRadius(15.0F);
        paramaeqi.d(true);
        paramaeqi.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramaeqi);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364215);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramaeqi.setOnClickListener(this);
        super.a(paramaeqi, paramaetk);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaeqi;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramaeqi = this.jdField_a_of_type_Aqvx.a();
      boolean bool = paramaeqi.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramaetk);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaeqi.frienduin + paramaeqi.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new afye(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaeqi.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaeqi.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaeqi.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Anwo = paramaeqi.jdField_a_of_type_Anwo;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaeqi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaeqi.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaeqi.jdField_b_of_type_Int;
      paramView.c = paramaeqi.c;
      paramView.d = paramaeqi.d;
      paramView.jdField_a_of_type_JavaLangString = paramaeqi.jdField_a_of_type_JavaLangString;
      paramaeqi = null;
    }
  }
  
  protected List<Integer> a(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.a(3);
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
  
  protected aeqi b()
  {
    return new afye(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692598);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692595);
  }
  
  protected List<Integer> b(bdpi parambdpi, aeqz paramaeqz)
  {
    return this.jdField_a_of_type_Aqvx.b(3);
  }
  
  protected void d(View paramView)
  {
    if ((paramView.getId() != 2131371945) && (paramView.getId() != 2131364215)) {
      return;
    }
    this.jdField_a_of_type_Aqvx.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyd
 * JD-Core Version:    0.7.0.1
 */