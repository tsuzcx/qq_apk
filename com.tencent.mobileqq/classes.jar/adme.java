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

public class adme
  extends adlz
{
  private Drawable a;
  
  public adme(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(admf paramadmf)
  {
    String str = this.jdField_a_of_type_Aohs.b();
    if (bace.b(str))
    {
      int i = this.jdField_a_of_type_Aohs.a();
      int j = this.jdField_a_of_type_Aohs.b();
      if ((i == 0) || (j == 0)) {
        a(paramadmf, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramadmf.e;
      localURLDrawableOptions.mRequestHeight = paramadmf.f;
      localURLDrawableOptions.mLoadingDrawable = new amym(Color.rgb(214, 214, 214), paramadmf.e, paramadmf.f);
      localURLDrawableOptions.mFailedDrawable = axwd.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramadmf = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramadmf.setAutoDownload(true);
      return paramadmf;
    }
    this.jdField_a_of_type_Aohs.a();
    return a();
  }
  
  private void a(admf paramadmf)
  {
    if (paramadmf.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(ajjy.a(2131649589));
      ((TextView)localObject).setCompoundDrawablePadding(aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848457, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadmf.e, paramadmf.f);
      ((RelativeLayout)paramadmf.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bace.a(this.jdField_a_of_type_Aohs.a());
      a(this.jdField_a_of_type_Aohs.a(), (String)localObject, paramadmf, localRelativeLayout, true);
      paramadmf.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(admf paramadmf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramadmf);
    Object localObject = bace.a(this.jdField_a_of_type_Aohs.a());
    a(this.jdField_a_of_type_Aohs.a(), (String)localObject, paramadmf, (RelativeLayout)paramadmf.jdField_a_of_type_AndroidViewView, false);
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramadmf.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadmf.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadmf.jdField_a_of_type_AndroidViewView).removeView(paramadmf.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramadmf);
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843418);
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramadmf, paramBaseChatItemLayout);
  }
  
  private void a(admf paramadmf, String paramString)
  {
    if (!bace.b(paramString)) {
      return;
    }
    paramString = apck.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramadmf.e = i;
      paramadmf.f = j;
      this.jdField_a_of_type_Aohs.a(i, j);
    }
    b(paramadmf);
  }
  
  private void a(String paramString1, String paramString2, admf paramadmf, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadmf.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadmf.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadmf.jdField_a_of_type_AndroidViewView).removeView(paramadmf.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131298520);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838764);
    paramadmf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, aciy.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131305912);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131305912);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131305912);
      if (paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = apdq.a(paramadmf.e, paramadmf.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131298520);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131298523);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131298520);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = apdq.a(this.jdField_a_of_type_AndroidContentContext, i, paramadmf.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(admf paramadmf)
  {
    int i = this.jdField_a_of_type_Aohs.a();
    int j = this.jdField_a_of_type_Aohs.b();
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
      localObject = paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramadmf.e = i;
      paramadmf.f = j;
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
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(admf paramadmf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aohs.c();
    if (i == 1)
    {
      if (!bace.b(this.jdField_a_of_type_Aohs.b()))
      {
        b(paramadmf);
        a(paramadmf);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Aohs.e();
      if (i < 100)
      {
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = ajjy.a(2131649572);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848456);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = ajjy.a(2131649581);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848456);
        paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848456);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadmf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadmf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public acjt a(View paramView)
  {
    if (paramView != null)
    {
      paramView = aciy.a(paramView);
      if ((paramView != null) && (admf.class.isInstance(paramView)))
      {
        paramView = (admf)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new aczj(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Object localObject;
    if ((paramacju instanceof admf))
    {
      localObject = (admf)paramacju;
      paramacju = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramacju;
      if (paramacju == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacju = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacju.setId(2131305912);
        paramacju.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacju.setRadius(15.0F);
        paramacju.d(true);
        paramacju.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacju);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131298594);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacju.setOnClickListener(this);
        super.a(paramacju, paramacmv);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacju;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramacju = this.jdField_a_of_type_Aohs.a();
      boolean bool = paramacju.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacmv);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramacju.frienduin + paramacju.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new admf(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramacju.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacju.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Almt = paramacju.jdField_a_of_type_Almt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramacju.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramacju.jdField_b_of_type_Int;
      paramView.c = paramacju.c;
      paramView.d = paramacju.d;
      paramView.jdField_a_of_type_JavaLangString = paramacju.jdField_a_of_type_JavaLangString;
      paramacju = null;
    }
  }
  
  protected List<Integer> a(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aohs.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131304829: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected acju b()
  {
    return new admf(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131626905);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131626902);
  }
  
  protected List<Integer> b(bakh parambakh, ackl paramackl)
  {
    return this.jdField_a_of_type_Aohs.b(3);
  }
  
  protected void d(View paramView)
  {
    if ((paramView.getId() != 2131305912) && (paramView.getId() != 2131298594)) {
      return;
    }
    this.jdField_a_of_type_Aohs.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adme
 * JD-Core Version:    0.7.0.1
 */