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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.io.File;
import java.util.List;

public class ahdw
  extends ahdr
{
  private Drawable a;
  
  public ahdw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(ahdx paramahdx)
  {
    String str = this.jdField_a_of_type_Atkn.b();
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      int i = this.jdField_a_of_type_Atkn.a();
      int j = this.jdField_a_of_type_Atkn.b();
      if ((i == 0) || (j == 0)) {
        a(paramahdx, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramahdx.e;
      localURLDrawableOptions.mRequestHeight = paramahdx.f;
      localURLDrawableOptions.mLoadingDrawable = new asbg(Color.rgb(214, 214, 214), paramahdx.e, paramahdx.f);
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramahdx = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramahdx.setAutoDownload(true);
      return paramahdx;
    }
    this.jdField_a_of_type_Atkn.a();
    return a();
  }
  
  private void a(ahdx paramahdx)
  {
    if (paramahdx.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(anvx.a(2131714743));
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849774, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramahdx.e, paramahdx.f);
      ((RelativeLayout)paramahdx.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.getFileSize(this.jdField_a_of_type_Atkn.a());
      a(this.jdField_a_of_type_Atkn.a(), (String)localObject, paramahdx, localRelativeLayout, true);
      paramahdx.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahdx paramahdx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramahdx);
    Object localObject = FileUtils.getFileSize(this.jdField_a_of_type_Atkn.a());
    a(this.jdField_a_of_type_Atkn.a(), (String)localObject, paramahdx, (RelativeLayout)paramahdx.jdField_a_of_type_AndroidViewView, false);
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramahdx.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahdx.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahdx.jdField_a_of_type_AndroidViewView).removeView(paramahdx.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramahdx);
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844291);
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramahdx, paramBaseChatItemLayout);
  }
  
  private void a(ahdx paramahdx, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = auea.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahdx.e = i;
      paramahdx.f = j;
      this.jdField_a_of_type_Atkn.a(i, j);
    }
    b(paramahdx);
  }
  
  private void a(String paramString1, String paramString2, ahdx paramahdx, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahdx.jdField_a_of_type_AndroidViewView).removeView(paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364490);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839176);
    paramahdx.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372790);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372790);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372790);
      if (paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = aufd.a(paramahdx.e, paramahdx.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364490);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364493);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364490);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = aufd.a(this.jdField_a_of_type_AndroidContentContext, i, paramahdx.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(ahdx paramahdx)
  {
    int i = this.jdField_a_of_type_Atkn.a();
    int j = this.jdField_a_of_type_Atkn.b();
    label24:
    Object localObject;
    if (i > 0)
    {
      if (j <= 0) {
        break label127;
      }
      localObject = ShortVideoUtils.adjustSize(i, j);
      i = localObject[0];
      j = localObject[1];
      localObject = paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramahdx.e = i;
      paramahdx.f = j;
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
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(ahdx paramahdx, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Atkn.c();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atkn.b()))
      {
        b(paramahdx);
        a(paramahdx);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Atkn.e();
      if (i < 100)
      {
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = anvx.a(2131714726);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849773);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = anvx.a(2131714735);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849773);
        paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849773);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramahdx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public afqq a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.getHolder(paramView);
      if ((paramView != null) && (ahdx.class.isInstance(paramView)))
      {
        paramView = (ahdx)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agmx(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject;
    if ((paramafqr instanceof ahdx))
    {
      localObject = (ahdx)paramafqr;
      paramafqr = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramafqr;
      if (paramafqr == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafqr = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramafqr.setId(2131372790);
        paramafqr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramafqr.setRadius(15.0F);
        paramafqr.d(true);
        paramafqr.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramafqr);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364567);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramafqr.setOnClickListener(this);
        super.a(paramafqr, paramaftk);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramafqr;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramafqr = this.jdField_a_of_type_Atkn.a();
      boolean bool = paramafqr.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramaftk);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafqr.frienduin + paramafqr.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new ahdx(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramafqr.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramafqr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramafqr.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Aqhi = paramafqr.jdField_a_of_type_Aqhi;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramafqr.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramafqr.jdField_b_of_type_Int;
      paramView.c = paramafqr.c;
      paramView.d = paramafqr.d;
      paramView.jdField_a_of_type_JavaLangString = paramafqr.jdField_a_of_type_JavaLangString;
      paramafqr = null;
    }
  }
  
  protected List<Integer> a(bhjq parambhjq, afrk paramafrk)
  {
    return this.jdField_a_of_type_Atkn.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atkn.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371641: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected afqr b()
  {
    return new ahdx(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692330);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692327);
  }
  
  protected List<Integer> b(bhjq parambhjq, afrk paramafrk)
  {
    return this.jdField_a_of_type_Atkn.b(3);
  }
  
  protected void e(View paramView)
  {
    if ((paramView.getId() != 2131372790) && (paramView.getId() != 2131364567)) {
      return;
    }
    this.jdField_a_of_type_Atkn.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdw
 * JD-Core Version:    0.7.0.1
 */