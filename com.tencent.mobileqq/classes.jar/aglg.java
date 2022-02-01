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

public class aglg
  extends aglb
{
  private Drawable a;
  
  public aglg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(aglh paramaglh)
  {
    String str = this.jdField_a_of_type_Asgh.b();
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      int i = this.jdField_a_of_type_Asgh.a();
      int j = this.jdField_a_of_type_Asgh.b();
      if ((i == 0) || (j == 0)) {
        a(paramaglh, str);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramaglh.e;
      localURLDrawableOptions.mRequestHeight = paramaglh.f;
      localURLDrawableOptions.mLoadingDrawable = new aqww(Color.rgb(214, 214, 214), paramaglh.e, paramaglh.f);
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.getFailedDrawable();
      localURLDrawableOptions.mGifRoundCorner = 12.0F;
      localURLDrawableOptions.mPlayGifImage = false;
      paramaglh = URLDrawable.getDrawable(new File(str), localURLDrawableOptions);
      paramaglh.setAutoDownload(true);
      return paramaglh;
    }
    this.jdField_a_of_type_Asgh.a();
    return a();
  }
  
  private void a(aglh paramaglh)
  {
    if (paramaglh.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    if (Build.VERSION.SDK_INT >= 16) {
      localRelativeLayout.setBackground(a());
    }
    for (;;)
    {
      Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(amtj.a(2131714396));
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130849681, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramaglh.e, paramaglh.f);
      ((RelativeLayout)paramaglh.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.getFileSize(this.jdField_a_of_type_Asgh.a());
      a(this.jdField_a_of_type_Asgh.a(), (String)localObject, paramaglh, localRelativeLayout, true);
      paramaglh.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(aglh paramaglh, BaseChatItemLayout paramBaseChatItemLayout)
  {
    b(paramaglh);
    Object localObject = FileUtils.getFileSize(this.jdField_a_of_type_Asgh.a());
    a(this.jdField_a_of_type_Asgh.a(), (String)localObject, paramaglh, (RelativeLayout)paramaglh.jdField_a_of_type_AndroidViewView, false);
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    if (paramaglh.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramaglh.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramaglh.jdField_a_of_type_AndroidViewView).removeView(paramaglh.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    localObject = a(paramaglh);
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130844224);
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    b(paramaglh, paramBaseChatItemLayout);
  }
  
  private void a(aglh paramaglh, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = aszt.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramaglh.e = i;
      paramaglh.f = j;
      this.jdField_a_of_type_Asgh.a(i, j);
    }
    b(paramaglh);
  }
  
  private void a(String paramString1, String paramString2, aglh paramaglh, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramaglh.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramaglh.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramaglh.jdField_a_of_type_AndroidViewView).removeView(paramaglh.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131364409);
    ((RelativeLayout)localObject1).setBackgroundResource(2130839156);
    paramaglh.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372596);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131372596);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372596);
      if (paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = ataw.a(paramaglh.e, paramaglh.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364409);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131364412);
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
        localLayoutParams.addRule(2, 2131364409);
        label417:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = ataw.a(this.jdField_a_of_type_AndroidContentContext, i, paramaglh.e, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
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
  
  private void b(aglh paramaglh)
  {
    int i = this.jdField_a_of_type_Asgh.a();
    int j = this.jdField_a_of_type_Asgh.b();
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
      localObject = paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label134;
      }
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      label75:
      localObject = paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label176;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramaglh.e = i;
      paramaglh.f = j;
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
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label75;
      label176:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void b(aglh paramaglh, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Asgh.c();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Asgh.b()))
      {
        b(paramaglh);
        a(paramaglh);
      }
      return;
    }
    if (i == 3)
    {
      i = this.jdField_a_of_type_Asgh.e();
      if (i < 100)
      {
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(i, paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      paramBaseChatItemLayout = amtj.a(2131714379);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849680);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      return;
    }
    if (i == 4)
    {
      paramBaseChatItemLayout = amtj.a(2131714388);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramBaseChatItemLayout);
      if (paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130849680);
        paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      }
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849680);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
      return;
    }
    if (paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaglh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramaglh.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
  }
  
  public aeze a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.getHolder(paramView);
      if ((paramView != null) && (aglh.class.isInstance(paramView)))
      {
        paramView = (aglh)paramView;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afui(Color.argb(255, 242, 242, 242), 255, 0.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  protected View a(aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Object localObject;
    if ((paramaezf instanceof aglh))
    {
      localObject = (aglh)paramaezf;
      paramaezf = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = paramaezf;
      if (paramaezf == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaezf = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramaezf.setId(2131372596);
        paramaezf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaezf.setRadius(15.0F);
        paramaezf.d(true);
        paramaezf.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramaezf);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364485);
        localMessageProgressView.setRadius(15.0F, true);
        localMessageProgressView.setShowCorner(true);
        localMessageProgressView.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramaezf.setOnClickListener(this);
        super.a(paramaezf, paramafce);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaezf;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      paramaezf = this.jdField_a_of_type_Asgh.a();
      boolean bool = paramaezf.isSend();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramafce);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaezf.frienduin + paramaezf.uniseq);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramView, paramBaseChatItemLayout);
      return localObject;
      paramView = new aglh(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaezf.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaezf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaezf.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Apee = paramaezf.jdField_a_of_type_Apee;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaezf.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaezf.jdField_b_of_type_Int;
      paramView.c = paramaezf.c;
      paramView.d = paramaezf.d;
      paramView.jdField_a_of_type_JavaLangString = paramaezf.jdField_a_of_type_JavaLangString;
      paramaezf = null;
    }
  }
  
  protected List<Integer> a(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.a(3);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Asgh.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371455: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aezf b()
  {
    return new aglh(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bfwr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692240);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692237);
  }
  
  protected List<Integer> b(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.b(3);
  }
  
  protected void e(View paramView)
  {
    if ((paramView.getId() != 2131372596) && (paramView.getId() != 2131364485)) {
      return;
    }
    this.jdField_a_of_type_Asgh.a(3, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglg
 * JD-Core Version:    0.7.0.1
 */