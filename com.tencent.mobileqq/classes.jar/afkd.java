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

public class afkd
  extends BaseBubbleBuilder
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final Drawable b;
  private static final int c = bdoo.b(180.0F);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afke(this);
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
    b = new ColorDrawable(-1);
    b.setBounds(0, 0, bdoo.a(), c);
  }
  
  public afkd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    localURLDrawableOptions.mGifRoundCorner = bdoo.b(2.0F);
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
  
  public aeqi a()
  {
    return new afkf();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramaetk = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    afkf localafkf = (afkf)paramaetk.getTag();
    localafkf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setHeadIconVisible(false);
    if ((localafkf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (localafkf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() == 0)) {}
    for (paramInt2 = bdoo.b(33.0F);; paramInt2 = 0)
    {
      paramView = (ViewGroup.MarginLayoutParams)afkf.a(localafkf).getLayoutParams();
      if (paramView.leftMargin != paramInt2)
      {
        paramView.leftMargin = paramInt2;
        afkf.a(localafkf).setLayoutParams(paramView);
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
          ymq.a().b(localafkf, paramInt1);
          paramaetk.setVisibility(8);
          return paramaetk;
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
        paramaetk.setVisibility(0);
        if (localVideoItem == null) {
          break label387;
        }
      }
      localafkf.e = localVideoItem.width;
      localafkf.f = localVideoItem.height;
      localafkf.b = localVideoItem.videoUrl;
      if (localafkf.f != 0) {}
      for (paramInt2 = c * localafkf.e / localafkf.f;; paramInt2 = 0)
      {
        paramView = (RelativeLayout.LayoutParams)localafkf.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramView.width = paramInt2;
        localafkf.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramView);
        afkf.a(localafkf).setVisibility(8);
        localafkf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        afkf.a(localafkf).setText(localVideoItem.title);
        afkf.a(localafkf, localVideoItem.schema);
        a(localafkf.jdField_a_of_type_ComTencentImageURLImageView, localVideoItem.coverUrl, b);
        ymq.a().a(localafkf, paramInt1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
          nud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramaetk);
        }
        return paramaetk;
        label387:
        localafkf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        afkf.a(localafkf).setText(paramView.title);
        afkf.a(localafkf, paramView.schema);
        if (TextUtils.isEmpty(paramView.imageUrl)) {
          afkf.a(localafkf).setVisibility(8);
        }
        for (;;)
        {
          ymq.a().b(localafkf, paramInt1);
          break;
          afkf.a(localafkf).setVisibility(0);
          a(afkf.a(localafkf), paramView.imageUrl, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131364173);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131298815);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131367819);
      paramView.addRule(1, 2131364199);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setId(2131364205);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = bdoo.b(2.0F);
      paramView = new RoundRectUrlImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131364206);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(aepi.a(133.0F, paramBaseChatItemLayout), aepi.a(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(aepi.a(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(alud.a(2131701242));
      ((TextView)localObject1).setId(2131364207);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, c);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131364205);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, aepi.a(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject3).setId(2131364214);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setBackgroundResource(2130837736);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(aepi.a(43.0F, paramBaseChatItemLayout), aepi.a(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = aepi.a(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject5).setBackgroundResource(2130837735);
      ((ImageView)localObject5).setImageResource(2130847230);
      i = aepi.a(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = aepi.a(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(paramaeqi);
      paramChatMessage.setOnTouchListener(paramaetk);
      paramChatMessage.setOnLongClickListener(paramaetk);
      paramChatMessage.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramaeqi = (afkf)paramaeqi;
      afkf.a(paramaeqi, paramChatMessage);
      paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramaeqi.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramaeqi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      paramaeqi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      afkf.a(paramaeqi, paramView);
      afkf.a(paramaeqi, (TextView)localObject1);
    }
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bdil.a(paramChatMessage.issend)) {
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
    if (paramInt == 2131370861) {
      super.d(paramChatMessage);
    }
    while (paramInt != 2131365071) {
      return;
    }
    acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramaeqi.a.setBackgroundResource(2130837734);
    paramInt1 = aepi.a(10.0F, paramChatMessage);
    paramInt2 = aepi.a(14.0F, paramChatMessage);
    paramaeqi.a.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = new bdpi();
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    a(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkd
 * JD-Core Version:    0.7.0.1
 */