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

public class adxd
  extends adwy
{
  private Drawable a;
  
  public adxd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(adxe paramadxe)
  {
    String str = this.jdField_a_of_type_Aoym.b();
    if (bbdj.b(str))
    {
      int i = this.jdField_a_of_type_Aoym.a();
      int j = this.jdField_a_of_type_Aoym.b();
      if ((i == 0) || (j == 0)) {
        a(paramadxe, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramadxe.e;
      localURLDrawableOptions.mRequestHeight = paramadxe.f;
      localURLDrawableOptions.mLoadingDrawable = new anou(Color.rgb(214, 214, 214), paramadxe.e, paramadxe.f);
      localURLDrawableOptions.mFailedDrawable = aywk.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramadxe = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramadxe.setAutoDownload(true);
      return paramadxe;
    }
    this.jdField_a_of_type_Aoym.a();
    return a();
  }
  
  private void a(adxe paramadxe)
  {
    if (paramadxe.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(ajyc.a(2131715379));
      ((TextView)localObject).setCompoundDrawablePadding(actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848693, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadxe.e, paramadxe.f);
      ((RelativeLayout)paramadxe.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bbdj.a(this.jdField_a_of_type_Aoym.a());
      a(this.jdField_a_of_type_Aoym.a(), (String)localObject, paramadxe, localRelativeLayout, true);
      paramadxe.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(adxe paramadxe, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramadxe);
    Object localObject = bbdj.a(this.jdField_a_of_type_Aoym.a());
    a(this.jdField_a_of_type_Aoym.a(), (String)localObject, paramadxe, (RelativeLayout)paramadxe.jdField_a_of_type_AndroidViewView, false);
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramadxe.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadxe.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadxe.jdField_a_of_type_AndroidViewView).removeView(paramadxe.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramadxe);
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843502);
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramadxe, paramBaseChatItemLayout);
  }
  
  private void a(adxe paramadxe, String paramString)
  {
    if (!bbdj.b(paramString)) {
      return;
    }
    paramString = apue.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadxe.e = i;
      paramadxe.f = j;
      this.jdField_a_of_type_Aoym.a(i, j);
    }
    b(paramadxe);
  }
  
  private void a(String paramString1, String paramString2, adxe paramadxe, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadxe.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadxe.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadxe.jdField_a_of_type_AndroidViewView).removeView(paramadxe.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364078);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838791);
    paramadxe.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, actn.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131371608);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131371608);
      if (paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = apvk.a(paramadxe.e, paramadxe.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364078);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364081);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364078);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = apvk.a(this.jdField_a_of_type_AndroidContentContext, i, paramadxe.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(adxe paramadxe)
  {
    int i = this.jdField_a_of_type_Aoym.a();
    int j = this.jdField_a_of_type_Aoym.b();
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
      localObject = paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramadxe.e = i;
      paramadxe.f = j;
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
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(adxe paramadxe, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aoym.c();
    if (i == 1)
    {
      if (!bbdj.b(this.jdField_a_of_type_Aoym.b()))
      {
        b(paramadxe);
        a(paramadxe);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Aoym.e();
      if (i < 100)
      {
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = ajyc.a(2131715362);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848692);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = ajyc.a(2131715371);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848692);
        paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848692);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadxe.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadxe.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public acum a(View paramView)
  {
    if (paramView != null)
    {
      paramView = actn.a(paramView);
      if ((paramView != null) && (adxe.class.isInstance(paramView)))
      {
        paramView = (adxe)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new adkl(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Object localObject;
    if ((paramacun instanceof adxe))
    {
      localObject = (adxe)paramacun;
      paramacun = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramacun;
      if (paramacun == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacun = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacun.setId(2131371608);
        paramacun.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacun.setRadius(15.0F);
        paramacun.d(true);
        paramacun.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacun);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364152);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacun.setOnClickListener(this);
        super.a(paramacun, paramacxn);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacun;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramacun = this.jdField_a_of_type_Aoym.a();
      boolean bool = paramacun.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacxn);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramacun.frienduin + paramacun.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new adxe(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacun.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacun.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacun.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ambh = paramacun.jdField_a_of_type_Ambh;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacun.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacun.jdField_b_of_type_Int;
      paramView.c = paramacun.c;
      paramView.d = paramacun.d;
      paramView.jdField_a_of_type_JavaLangString = paramacun.jdField_a_of_type_JavaLangString;
      paramacun = null;
    }
  }
  
  protected List<Integer> a(bblr parambblr, acve paramacve)
  {
    return this.jdField_a_of_type_Aoym.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoym.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370494: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected acun b()
  {
    return new adxe(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692520);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692517);
  }
  
  protected List<Integer> b(bblr parambblr, acve paramacve)
  {
    return this.jdField_a_of_type_Aoym.b(3);
  }
  
  protected void d(View paramView)
  {
    if ((paramView.getId() != 2131371608) && (paramView.getId() != 2131364152)) {
      return;
    }
    this.jdField_a_of_type_Aoym.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxd
 * JD-Core Version:    0.7.0.1
 */