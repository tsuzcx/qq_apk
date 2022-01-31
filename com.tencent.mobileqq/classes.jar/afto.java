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

public class afto
  extends aftj
{
  private Drawable a;
  
  public afto(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(aftp paramaftp)
  {
    String str = this.jdField_a_of_type_Aqro.b();
    if (bdcs.b(str))
    {
      int i = this.jdField_a_of_type_Aqro.a();
      int j = this.jdField_a_of_type_Aqro.b();
      if ((i == 0) || (j == 0)) {
        a(paramaftp, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramaftp.e;
      localURLDrawableOptions.mRequestHeight = paramaftp.f;
      localURLDrawableOptions.mLoadingDrawable = new apgg(Color.rgb(214, 214, 214), paramaftp.e, paramaftp.f);
      localURLDrawableOptions.mFailedDrawable = baul.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramaftp = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramaftp.setAutoDownload(true);
      return paramaftp;
    }
    this.jdField_a_of_type_Aqro.a();
    return a();
  }
  
  private void a(aftp paramaftp)
  {
    if (paramaftp.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(alpo.a(2131715762));
      ((TextView)localObject).setCompoundDrawablePadding(aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849131, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramaftp.e, paramaftp.f);
      ((RelativeLayout)paramaftp.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bdcs.a(this.jdField_a_of_type_Aqro.a());
      a(this.jdField_a_of_type_Aqro.a(), (String)localObject, paramaftp, localRelativeLayout, true);
      paramaftp.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(aftp paramaftp, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramaftp);
    Object localObject = bdcs.a(this.jdField_a_of_type_Aqro.a());
    a(this.jdField_a_of_type_Aqro.a(), (String)localObject, paramaftp, (RelativeLayout)paramaftp.jdField_a_of_type_AndroidViewView, false);
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramaftp.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramaftp.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramaftp.jdField_a_of_type_AndroidViewView).removeView(paramaftp.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramaftp);
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843862);
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramaftp, paramBaseChatItemLayout);
  }
  
  private void a(aftp paramaftp, String paramString)
  {
    if (!bdcs.b(paramString)) {
      return;
    }
    paramString = arni.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramaftp.e = i;
      paramaftp.f = j;
      this.jdField_a_of_type_Aqro.a(i, j);
    }
    b(paramaftp);
  }
  
  private void a(String paramString1, String paramString2, aftp paramaftp, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramaftp.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramaftp.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramaftp.jdField_a_of_type_AndroidViewView).removeView(paramaftp.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364139);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838946);
    paramaftp.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, aekt.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131371925);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131371925);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131371925);
      if (paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = aroo.a(paramaftp.e, paramaftp.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364139);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364142);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364139);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = aroo.a(this.jdField_a_of_type_AndroidContentContext, i, paramaftp.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(aftp paramaftp)
  {
    int i = this.jdField_a_of_type_Aqro.a();
    int j = this.jdField_a_of_type_Aqro.b();
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
      localObject = paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramaftp.e = i;
      paramaftp.f = j;
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
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(aftp paramaftp, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aqro.c();
    if (i == 1)
    {
      if (!bdcs.b(this.jdField_a_of_type_Aqro.b()))
      {
        b(paramaftp);
        a(paramaftp);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Aqro.e();
      if (i < 100)
      {
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = alpo.a(2131715745);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849130);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = alpo.a(2131715754);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849130);
        paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849130);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaftp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramaftp.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public aels a(View paramView)
  {
    if (paramView != null)
    {
      paramView = aekt.a(paramView);
      if ((paramView != null) && (aftp.class.isInstance(paramView)))
      {
        paramView = (aftp)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afct(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Object localObject;
    if ((paramaelt instanceof aftp))
    {
      localObject = (aftp)paramaelt;
      paramaelt = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramaelt;
      if (paramaelt == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaelt = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramaelt.setId(2131371925);
        paramaelt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaelt.setRadius(15.0F);
        paramaelt.d(true);
        paramaelt.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramaelt);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364213);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramaelt.setOnClickListener(this);
        super.a(paramaelt, paramaeov);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaelt;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramaelt = this.jdField_a_of_type_Aqro.a();
      boolean bool = paramaelt.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramaeov);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaelt.frienduin + paramaelt.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new aftp(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaelt.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaelt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaelt.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ansf = paramaelt.jdField_a_of_type_Ansf;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaelt.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaelt.jdField_b_of_type_Int;
      paramView.c = paramaelt.c;
      paramView.d = paramaelt.d;
      paramView.jdField_a_of_type_JavaLangString = paramaelt.jdField_a_of_type_JavaLangString;
      paramaelt = null;
    }
  }
  
  protected List<Integer> a(bdkz parambdkz, aemk paramaemk)
  {
    return this.jdField_a_of_type_Aqro.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqro.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370799: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aelt b()
  {
    return new aftp(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bdec.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692597);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692594);
  }
  
  protected List<Integer> b(bdkz parambdkz, aemk paramaemk)
  {
    return this.jdField_a_of_type_Aqro.b(3);
  }
  
  protected void d(View paramView)
  {
    if ((paramView.getId() != 2131371925) && (paramView.getId() != 2131364213)) {
      return;
    }
    this.jdField_a_of_type_Aqro.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afto
 * JD-Core Version:    0.7.0.1
 */