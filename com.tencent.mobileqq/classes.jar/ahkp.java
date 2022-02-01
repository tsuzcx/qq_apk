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
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;

public class ahkp
  extends BaseBubbleBuilder
  implements afsn, View.OnClickListener
{
  protected static SparseArray<ahkq> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new ahkq(40000, anvx.a(2131714666), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new ahkq(40001, anvx.a(2131714664), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new ahkq(40002, anvx.a(2131714665), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new ahkq(40003, anvx.a(2131714662), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new ahkq(40004, anvx.a(2131714659), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new ahkq(40005, anvx.a(2131714658), Color.parseColor("#F2FF6EA2")));
  }
  
  public ahkp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new ahkr();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    ahkr localahkr = (ahkr)paramafqr;
    if (paramView == null)
    {
      paramafqr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562981, null);
      localahkr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramafqr);
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramafqr.findViewById(2131379447));
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localahkr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramafqr.findViewById(2131377906));
      localahkr.b = ((TextView)paramafqr.findViewById(2131379586));
      localahkr.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramafqr.findViewById(2131379446));
      localahkr.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramaftk);
      localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramaftk);
      paramafqr.setOnTouchListener(paramaftk);
      paramafqr.setOnLongClickListener(paramaftk);
    }
    for (;;)
    {
      paramView = localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int i = CommonImgThumbHelper.getImgThumbMaxPx(false);
      int j = CommonImgThumbHelper.getImgThumbMinPx(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (e) {
        paramView.setContentDescription(anvx.a(2131714657));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramaftk = URLDrawableHelper.getURL(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localahkr.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localahkr.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramaftk)))
        {
          if (localahkr.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localahkr.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramaftk);
          }
          paramBaseChatItemLayout = ahcj.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
          localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
          localahkr.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramaftk);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localahkr.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (ahkq)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label776;
        }
        localahkr.b.setVisibility(0);
        localahkr.b.setText(paramView.a);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.b);
        localahkr.b.setBackgroundDrawable(paramBaseChatItemLayout);
        label595:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label789;
        }
        localahkr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(bgxc.b(190, 270, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
        paramView.setDecodeHandler(bgxc.j);
        localahkr.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      for (;;)
      {
        localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
        localahkr.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
        return paramafqr;
        paramView = localahkr.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localahkr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label776:
        localahkr.b.setVisibility(8);
        break label595;
        label789:
        localahkr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramafqr = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131714663);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = ((afrk)AIOUtils.getHolder(paramView)).a;
    a(paramView, localbhjq);
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    b(paramView, localbhjq);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379447: 
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if (!((TroopChatPie)localObject).a().a())
          {
            bggl localbggl = (bggl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
            MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramView.getTag();
            localbggl.a(localMessageForTroopEffectPic.frienduin);
            localbggl.g();
            localbggl.a(localMessageForTroopEffectPic, false);
            localbggl.a((BaseChatPie)localObject);
            localbggl.f();
          }
        }
      }
      for (;;)
      {
        bgtj.a("obj_msg", "clk_play");
        break;
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
    if (bhhr.q(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
    }
    for (;;)
    {
      bgtj.a("obj_msg", "clk_tail    ");
      break;
      bhhr.z(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
      ((Intent)localObject).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkp
 * JD-Core Version:    0.7.0.1
 */