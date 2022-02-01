import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.RoundRectRelativeLayout;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;
import com.tencent.mobileqq.utils.ViewUtils;

public class agqd
  extends BaseBubbleBuilder
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final Drawable b;
  private static final int c = ViewUtils.dpToPx(180.0F);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agqe(this);
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
    b = new ColorDrawable(-1);
    b.setBounds(0, 0, ViewUtils.getScreenWidth(), c);
  }
  
  public agqd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private void a(URLImageView paramURLImageView, String paramString, Drawable paramDrawable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setImageDrawable(paramDrawable);
      paramURLImageView.setTag("");
    }
    while (paramString.equals((String)paramURLImageView.getTag())) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    localURLDrawableOptions.mGifRoundCorner = ViewUtils.dpToPx(2.0F);
    localURLDrawableOptions.mUseSharpPImage = true;
    localURLDrawableOptions.mExtraInfo = paramString;
    localURLDrawableOptions.mPlayGifImage = true;
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
    paramURLImageView.setTag(paramString);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agqf();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramaftk = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    agqf localagqf = (agqf)paramaftk.getTag();
    localagqf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setHeadIconVisible(false);
    if ((localagqf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (localagqf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() == 0)) {}
    for (paramInt2 = ViewUtils.dpToPx(33.0F);; paramInt2 = 0)
    {
      paramView = (ViewGroup.MarginLayoutParams)agqf.a(localagqf).getLayoutParams();
      if (paramView.leftMargin != paramInt2)
      {
        paramView.leftMargin = paramInt2;
        agqf.a(localagqf).setLayoutParams(paramView);
      }
      StructMsgSubImageVideo.VideoItem localVideoItem;
      try
      {
        paramView = (StructMsgSubImageVideo)((MessageForStructing)paramChatMessage).structingMsg;
        if (paramView != null)
        {
          localVideoItem = paramView.getVideoItem();
          if (localVideoItem == null)
          {
            paramViewGroup = paramView.getImageItem();
            paramView = paramViewGroup;
            if (paramViewGroup != null) {
              break label188;
            }
          }
        }
        else
        {
          zzu.a().b(localagqf, paramInt1);
          paramaftk.setVisibility(8);
          return paramaftk;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.w("AutoVideoItemBuilder", "getView: ", paramView);
          paramView = null;
        }
        paramView = null;
        label188:
        paramaftk.setVisibility(0);
        if (localVideoItem == null) {
          break label364;
        }
      }
      localagqf.e = localVideoItem.width;
      localagqf.f = localVideoItem.height;
      localagqf.b = localVideoItem.videoUrl;
      if (localagqf.f != 0) {}
      for (paramInt2 = c * localagqf.e / localagqf.f;; paramInt2 = 0)
      {
        paramView = (RelativeLayout.LayoutParams)localagqf.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramView.width = paramInt2;
        localagqf.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramView);
        agqf.a(localagqf).setVisibility(8);
        localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        agqf.a(localagqf).setText(localVideoItem.title);
        agqf.a(localagqf, localVideoItem.schema);
        a(localagqf.jdField_a_of_type_ComTencentImageURLImageView, localVideoItem.coverUrl, b);
        zzu.a().a(localagqf, paramInt1);
        onx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramaftk);
        return paramaftk;
        label364:
        localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        agqf.a(localagqf).setText(paramView.title);
        agqf.a(localagqf, paramView.schema);
        if (TextUtils.isEmpty(paramView.imageUrl)) {
          agqf.a(localagqf).setVisibility(8);
        }
        for (;;)
        {
          zzu.a().b(localagqf, paramInt1);
          break;
          agqf.a(localagqf).setVisibility(0);
          a(agqf.a(localagqf), paramView.imageUrl, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131364522);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131298980);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131368381);
      paramView.addRule(1, 2131364548);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setId(2131364554);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = ViewUtils.dpToPx(2.0F);
      paramView = new RoundRectUrlImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131364555);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(133.0F, paramBaseChatItemLayout), AIOUtils.dp2px(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(AIOUtils.dp2px(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(anvx.a(2131700360));
      ((TextView)localObject1).setId(2131364556);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, c);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131364554);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.dp2px(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject3).setId(2131364566);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setBackgroundResource(2130838013);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(43.0F, paramBaseChatItemLayout), AIOUtils.dp2px(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = AIOUtils.dp2px(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject5).setBackgroundResource(2130838012);
      ((ImageView)localObject5).setImageResource(2130847709);
      i = AIOUtils.dp2px(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = AIOUtils.dp2px(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(paramafqr);
      paramChatMessage.setOnTouchListener(paramaftk);
      paramChatMessage.setOnLongClickListener(paramaftk);
      paramChatMessage.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramafqr = (agqf)paramafqr;
      agqf.a(paramafqr, paramChatMessage);
      paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramafqr.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramafqr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      paramafqr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      agqf.a(paramafqr, paramView);
      agqf.a(paramafqr, (TextView)localObject1);
    }
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bhfj.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append("视频按钮");
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    super.a(paramInt, paramContext, paramChatMessage);
    if (paramInt == 2131371684) {
      super.d(paramChatMessage);
    }
    while (paramInt != 2131365475) {
      return;
    }
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramafqr.a.setBackgroundResource(2130838011);
    paramInt1 = AIOUtils.dp2px(10.0F, paramChatMessage);
    paramInt2 = AIOUtils.dp2px(14.0F, paramChatMessage);
    paramafqr.a.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    a(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqd
 * JD-Core Version:    0.7.0.1
 */