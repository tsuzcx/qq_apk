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

public class ahfh
  extends ahfc
{
  private Drawable a;
  
  public ahfh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(ahfi paramahfi)
  {
    String str = this.jdField_a_of_type_Atcc.b();
    if (bgmg.b(str))
    {
      int i = this.jdField_a_of_type_Atcc.a();
      int j = this.jdField_a_of_type_Atcc.b();
      if ((i == 0) || (j == 0)) {
        a(paramahfi, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramahfi.e;
      localURLDrawableOptions.mRequestHeight = paramahfi.f;
      localURLDrawableOptions.mLoadingDrawable = new arnj(Color.rgb(214, 214, 214), paramahfi.e, paramahfi.f);
      localURLDrawableOptions.mFailedDrawable = bdzx.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramahfi = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramahfi.setAutoDownload(true);
      return paramahfi;
    }
    this.jdField_a_of_type_Atcc.a();
    return a();
  }
  
  private void a(ahfi paramahfi)
  {
    if (paramahfi.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(anni.a(2131714055));
      ((TextView)localObject).setCompoundDrawablePadding(afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849753, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramahfi.e, paramahfi.f);
      ((RelativeLayout)paramahfi.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bgmg.a(this.jdField_a_of_type_Atcc.a());
      a(this.jdField_a_of_type_Atcc.a(), (String)localObject, paramahfi, localRelativeLayout, true);
      paramahfi.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahfi paramahfi, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramahfi);
    Object localObject = bgmg.a(this.jdField_a_of_type_Atcc.a());
    a(this.jdField_a_of_type_Atcc.a(), (String)localObject, paramahfi, (RelativeLayout)paramahfi.jdField_a_of_type_AndroidViewView, false);
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramahfi.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahfi.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahfi.jdField_a_of_type_AndroidViewView).removeView(paramahfi.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramahfi);
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844325);
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramahfi, paramBaseChatItemLayout);
  }
  
  private void a(ahfi paramahfi, String paramString)
  {
    if (!bgmg.b(paramString)) {
      return;
    }
    paramString = atvo.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahfi.e = i;
      paramahfi.f = j;
      this.jdField_a_of_type_Atcc.a(i, j);
    }
    b(paramahfi);
  }
  
  private void a(String paramString1, String paramString2, ahfi paramahfi, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramahfi.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahfi.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahfi.jdField_a_of_type_AndroidViewView).removeView(paramahfi.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364347);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839113);
    paramahfi.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, afur.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372517);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372517);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372517);
      if (paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = atwt.a(paramahfi.e, paramahfi.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364347);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364350);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364347);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = atwt.a(this.jdField_a_of_type_AndroidContentContext, i, paramahfi.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(ahfi paramahfi)
  {
    int i = this.jdField_a_of_type_Atcc.a();
    int j = this.jdField_a_of_type_Atcc.b();
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
      localObject = paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramahfi.e = i;
      paramahfi.f = j;
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
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(ahfi paramahfi, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Atcc.c();
    if (i == 1)
    {
      if (!bgmg.b(this.jdField_a_of_type_Atcc.b()))
      {
        b(paramahfi);
        a(paramahfi);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Atcc.e();
      if (i < 100)
      {
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = anni.a(2131714038);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849752);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = anni.a(2131714047);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849752);
        paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849752);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramahfi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public afwq a(View paramView)
  {
    if (paramView != null)
    {
      paramView = afur.a(paramView);
      if ((paramView != null) && (ahfi.class.isInstance(paramView)))
      {
        paramView = (ahfi)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agoq(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Object localObject;
    if ((paramafwr instanceof ahfi))
    {
      localObject = (ahfi)paramafwr;
      paramafwr = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramafwr;
      if (paramafwr == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafwr = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramafwr.setId(2131372517);
        paramafwr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramafwr.setRadius(15.0F);
        paramafwr.d(true);
        paramafwr.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramafwr);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364422);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramafwr.setOnClickListener(this);
        super.a(paramafwr, paramafzq);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramafwr;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramafwr = this.jdField_a_of_type_Atcc.a();
      boolean bool = paramafwr.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramafzq);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafwr.frienduin + paramafwr.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new ahfi(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramafwr.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramafwr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramafwr.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Apwt = paramafwr.jdField_a_of_type_Apwt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramafwr.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramafwr.jdField_b_of_type_Int;
      paramView.c = paramafwr.c;
      paramView.d = paramafwr.d;
      paramView.jdField_a_of_type_JavaLangString = paramafwr.jdField_a_of_type_JavaLangString;
      paramafwr = null;
    }
  }
  
  protected List<Integer> a(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.a(3);
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
  
  protected afwr b()
  {
    return new ahfi(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692187);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692184);
  }
  
  protected List<Integer> b(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.b(3);
  }
  
  protected void e(View paramView)
  {
    if ((paramView.getId() != 2131372517) && (paramView.getId() != 2131364422)) {
      return;
    }
    this.jdField_a_of_type_Atcc.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfh
 * JD-Core Version:    0.7.0.1
 */