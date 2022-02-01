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

public class ahot
  extends ahoo
{
  private Drawable a;
  
  public ahot(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(ahou paramahou)
  {
    String str = this.jdField_a_of_type_Attx.b();
    if (bhmi.b(str))
    {
      int i = this.jdField_a_of_type_Attx.a();
      int j = this.jdField_a_of_type_Attx.b();
      if ((i == 0) || (j == 0)) {
        a(paramahou, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramahou.e;
      localURLDrawableOptions.mRequestHeight = paramahou.f;
      localURLDrawableOptions.mLoadingDrawable = new ascz(Color.rgb(214, 214, 214), paramahou.e, paramahou.f);
      localURLDrawableOptions.mFailedDrawable = beyq.a();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramahou = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramahou.setAutoDownload(true);
      return paramahou;
    }
    this.jdField_a_of_type_Attx.a();
    return a();
  }
  
  private void a(ahou paramahou)
  {
    if (paramahou.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(anzj.a(2131714164));
      ((TextView)localObject).setCompoundDrawablePadding(agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849764, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramahou.e, paramahou.f);
      ((RelativeLayout)paramahou.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bhmi.a(this.jdField_a_of_type_Attx.a());
      a(this.jdField_a_of_type_Attx.a(), (String)localObject, paramahou, localRelativeLayout, true);
      paramahou.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahou paramahou, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramahou);
    Object localObject = bhmi.a(this.jdField_a_of_type_Attx.a());
    a(this.jdField_a_of_type_Attx.a(), (String)localObject, paramahou, (RelativeLayout)paramahou.jdField_a_of_type_AndroidViewView, false);
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramahou.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahou.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahou.jdField_a_of_type_AndroidViewView).removeView(paramahou.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramahou);
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844339);
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramahou, paramBaseChatItemLayout);
  }
  
  private void a(ahou paramahou, String paramString)
  {
    if (!bhmi.b(paramString)) {
      return;
    }
    paramString = aunj.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahou.e = i;
      paramahou.f = j;
      this.jdField_a_of_type_Attx.a(i, j);
    }
    b(paramahou);
  }
  
  private void a(String paramString1, String paramString2, ahou paramahou, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramahou.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahou.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahou.jdField_a_of_type_AndroidViewView).removeView(paramahou.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364391);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839121);
    paramahou.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, agej.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372628);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372628);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372628);
      if (paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = auoo.a(paramahou.e, paramahou.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364391);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364394);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label599;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364391);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = auoo.a(this.jdField_a_of_type_AndroidContentContext, i, paramahou.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  private void b(ahou paramahou)
  {
    int i = this.jdField_a_of_type_Attx.a();
    int j = this.jdField_a_of_type_Attx.b();
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
      localObject = paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramahou.e = i;
      paramahou.f = j;
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
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(ahou paramahou, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Attx.c();
    if (i == 1)
    {
      if (!bhmi.b(this.jdField_a_of_type_Attx.b()))
      {
        b(paramahou);
        a(paramahou);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Attx.e();
      if (i < 100)
      {
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = anzj.a(2131714147);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849763);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = anzj.a(2131714156);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849763);
        paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849763);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahou.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramahou.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public aggk a(View paramView)
  {
    if (paramView != null)
    {
      paramView = agej.a(paramView);
      if ((paramView != null) && (ahou.class.isInstance(paramView)))
      {
        paramView = (ahou)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agxw(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Object localObject;
    if ((paramaggl instanceof ahou))
    {
      localObject = (ahou)paramaggl;
      paramaggl = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramaggl;
      if (paramaggl == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaggl = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramaggl.setId(2131372628);
        paramaggl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaggl.setRadius(15.0F);
        paramaggl.d(true);
        paramaggl.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramaggl);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364466);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramaggl.setOnClickListener(this);
        super.a(paramaggl, paramagjk);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaggl;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramaggl = this.jdField_a_of_type_Attx.a();
      boolean bool = paramaggl.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramagjk);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaggl.frienduin + paramaggl.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new ahou(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaggl.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaggl.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaggl.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Aqkt = paramaggl.jdField_a_of_type_Aqkt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaggl.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaggl.jdField_b_of_type_Int;
      paramView.c = paramaggl.c;
      paramView.d = paramaggl.d;
      paramView.jdField_a_of_type_JavaLangString = paramaggl.jdField_a_of_type_JavaLangString;
      paramaggl = null;
    }
  }
  
  protected List<Integer> a(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.a(3);
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
  
  protected aggl b()
  {
    return new ahou(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692192);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692189);
  }
  
  protected List<Integer> b(bhuk parambhuk, aghd paramaghd)
  {
    return this.jdField_a_of_type_Attx.b(3);
  }
  
  protected void e(View paramView)
  {
    if ((paramView.getId() != 2131372628) && (paramView.getId() != 2131364466)) {
      return;
    }
    this.jdField_a_of_type_Attx.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahot
 * JD-Core Version:    0.7.0.1
 */