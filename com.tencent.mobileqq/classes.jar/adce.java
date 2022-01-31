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

public class adce
  extends BaseBubbleBuilder
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final Drawable b;
  private static final int c = bajq.b(180.0F);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adcf(this);
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-1);
    b = new ColorDrawable(-1);
    b.setBounds(0, 0, bajq.a(), c);
  }
  
  public adce(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    localURLDrawableOptions.mGifRoundCorner = bajq.b(2.0F);
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
  
  public acju a()
  {
    return new adcg();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramacmv = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    adcg localadcg = (adcg)paramacmv.getTag();
    localadcg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setHeadIconVisible(false);
    if ((localadcg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a != null) && (localadcg.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a.getVisibility() == 0)) {}
    for (paramInt2 = bajq.b(33.0F);; paramInt2 = 0)
    {
      paramView = (ViewGroup.MarginLayoutParams)adcg.a(localadcg).getLayoutParams();
      if (paramView.leftMargin != paramInt2)
      {
        paramView.leftMargin = paramInt2;
        adcg.a(localadcg).setLayoutParams(paramView);
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
          wet.a().b(localadcg, paramInt1);
          paramacmv.setVisibility(8);
          return paramacmv;
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
        paramacmv.setVisibility(0);
        if (localVideoItem == null) {
          break label387;
        }
      }
      localadcg.e = localVideoItem.width;
      localadcg.f = localVideoItem.height;
      localadcg.b = localVideoItem.videoUrl;
      if (localadcg.f != 0) {}
      for (paramInt2 = c * localadcg.e / localadcg.f;; paramInt2 = 0)
      {
        paramView = (RelativeLayout.LayoutParams)localadcg.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramView.width = paramInt2;
        localadcg.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramView);
        adcg.a(localadcg).setVisibility(8);
        localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        adcg.a(localadcg).setText(localVideoItem.title);
        adcg.a(localadcg, localVideoItem.schema);
        a(localadcg.jdField_a_of_type_ComTencentImageURLImageView, localVideoItem.coverUrl, b);
        wet.a().a(localadcg, paramInt1);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
          nfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramacmv);
        }
        return paramacmv;
        label387:
        localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        adcg.a(localadcg).setText(paramView.title);
        adcg.a(localadcg, paramView.schema);
        if (TextUtils.isEmpty(paramView.imageUrl)) {
          adcg.a(localadcg).setVisibility(8);
        }
        for (;;)
        {
          wet.a().b(localadcg, paramInt1);
          break;
          adcg.a(localadcg).setVisibility(0);
          a(adcg.a(localadcg), paramView.imageUrl, jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramBaseChatItemLayout = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramChatMessage = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramChatMessage.setId(2131298552);
      paramChatMessage.setClickable(true);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      int i = paramBaseChatItemLayout.getDimensionPixelSize(2131167688);
      paramView.setMargins(i, 0, i, 0);
      paramView.addRule(1, 2131302061);
      paramView.addRule(1, 2131298578);
      paramChatMessage.setLayoutParams(paramView);
      Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setId(2131298584);
      paramChatMessage.addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      i = bajq.b(2.0F);
      paramView = new RoundRectUrlImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setScaleType(ImageView.ScaleType.MATRIX);
      paramView.setId(2131298585);
      paramView.setAllRadius(i);
      Object localObject1 = new RelativeLayout.LayoutParams(aciy.a(133.0F, paramBaseChatItemLayout), aciy.a(74.5F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject1).setMargins(aciy.a(9.0F, paramBaseChatItemLayout), 0, 0, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setTextColor(-16777216);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setText(ajjy.a(2131635066));
      ((TextView)localObject1).setId(2131298586);
      ((TextView)localObject1).setMinLines(1);
      ((TextView)localObject1).setMaxLines(3);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(0, paramView.getId());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RoundRectRelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, c);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131298584);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, aciy.a(10.0F, paramBaseChatItemLayout), 0, 0);
      ((RoundRectRelativeLayout)localObject2).setBgColor(-16777216);
      ((RoundRectRelativeLayout)localObject2).setAllRadius(i);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      ((URLImageView)localObject3).setId(2131298593);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject4).addRule(14);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setBackgroundResource(2130837671);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setTextSize(12.0F);
      ((TextView)localObject4).setText("13:25");
      ((TextView)localObject4).setGravity(17);
      Object localObject5 = new RelativeLayout.LayoutParams(aciy.a(43.0F, paramBaseChatItemLayout), aciy.a(21.0F, paramBaseChatItemLayout));
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      i = aciy.a(5.0F, paramBaseChatItemLayout);
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, i, i);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject5).setBackgroundResource(2130837670);
      ((ImageView)localObject5).setImageResource(2130846596);
      i = aciy.a(17.0F, paramBaseChatItemLayout);
      ((ImageView)localObject5).setPadding(i, i, i, i);
      ((ImageView)localObject5).setScaleType(ImageView.ScaleType.FIT_CENTER);
      i = aciy.a(50.0F, paramBaseChatItemLayout);
      paramBaseChatItemLayout = new RelativeLayout.LayoutParams(i, i);
      paramBaseChatItemLayout.addRule(13);
      ((RoundRectRelativeLayout)localObject2).addView((View)localObject5, paramBaseChatItemLayout);
      paramChatMessage.setTag(paramacju);
      paramChatMessage.setOnTouchListener(paramacmv);
      paramChatMessage.setOnLongClickListener(paramacmv);
      paramChatMessage.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramacju = (adcg)paramacju;
      adcg.a(paramacju, paramChatMessage);
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramacju.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramacju.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject5);
      paramacju.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      adcg.a(paramacju, paramView);
      adcg.a(paramacju, (TextView)localObject1);
    }
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (bado.a(paramChatMessage.issend)) {
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
    if (paramInt == 2131304871) {
      super.d(paramChatMessage);
    }
    while (paramInt != 2131299417) {
      return;
    }
    aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    super.a(paramInt, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    paramChatMessage = paramContext.getResources();
    paramacju.a.setBackgroundResource(2130837669);
    paramInt1 = aciy.a(10.0F, paramChatMessage);
    paramInt2 = aciy.a(14.0F, paramChatMessage);
    paramacju.a.setPadding(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.d(paramView, this.jdField_a_of_type_AndroidContentContext);
    a(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adce
 * JD-Core Version:    0.7.0.1
 */