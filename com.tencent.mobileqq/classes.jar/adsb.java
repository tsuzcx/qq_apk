import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class adsb
  extends BaseBubbleBuilder
  implements aclm, View.OnClickListener
{
  protected static SparseArray<adsc> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new adsc(40000, ajjy.a(2131649512), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new adsc(40001, ajjy.a(2131649510), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new adsc(40002, ajjy.a(2131649511), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new adsc(40003, ajjy.a(2131649508), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new adsc(40004, ajjy.a(2131649505), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new adsc(40005, ajjy.a(2131649504), Color.parseColor("#F2FF6EA2")));
  }
  
  public adsb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adsd();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    adsd localadsd = (adsd)paramacju;
    if (paramView == null)
    {
      paramacju = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496933, null);
      localadsd.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramacju);
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramacju.findViewById(2131311946));
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localadsd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacju.findViewById(2131310548));
      localadsd.b = ((TextView)paramacju.findViewById(2131312053));
      localadsd.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramacju.findViewById(2131311945));
      localadsd.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramacmv);
      localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
      paramacju.setOnLongClickListener(paramacmv);
    }
    for (;;)
    {
      paramView = localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int i = axwd.a(false);
      int j = axwd.b(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (e) {
        paramView.setContentDescription(ajjy.a(2131649503));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramacmv = axwd.a(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localadsd.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localadsd.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramacmv)))
        {
          if (localadsd.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localadsd.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramacmv);
          }
          paramBaseChatItemLayout = adkt.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
          localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
          localadsd.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramacmv);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localadsd.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (adsc)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label775;
        }
        localadsd.b.setVisibility(0);
        localadsd.b.setText(paramView.jdField_a_of_type_JavaLangString);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = azvv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.b);
        localadsd.b.setBackgroundDrawable(paramBaseChatItemLayout);
        label594:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label788;
        }
        localadsd.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(azue.b(190, 270, azvv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
        paramView.setDecodeHandler(azue.i);
        localadsd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      for (;;)
      {
        localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
        localadsd.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
        return paramacju;
        paramView = localadsd.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localadsd.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label775:
        localadsd.b.setVisibility(8);
        break label594;
        label788:
        localadsd.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramacju = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131649509);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2) {}
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = ((ackl)aciy.a(paramView)).a;
    a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbakh);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131311946: 
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof aejb))
        {
          localObject = (aejb)localObject;
          if (!((aejb)localObject).a().a())
          {
            azfo localazfo = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            paramView = (MessageForTroopEffectPic)paramView.getTag();
            localazfo.a(paramView.frienduin);
            localazfo.g();
            localazfo.a(paramView, false);
            localazfo.a((BaseChatPie)localObject);
            localazfo.f();
          }
        }
      }
      for (;;)
      {
        azrz.a("obj_msg", "clk_play");
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "[EffectPic] curPie is null.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "[EffectPic] chatFragment is null.");
          }
        }
      }
    }
    if (baig.q(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    for (;;)
    {
      azrz.a("obj_msg", "clk_tail    ");
      return;
      baig.z(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
      paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsb
 * JD-Core Version:    0.7.0.1
 */