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
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;

public class ahvd
  extends BaseBubbleBuilder
  implements agif, View.OnClickListener
{
  protected static SparseArray<ahve> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new ahve(40000, anzj.a(2131714087), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new ahve(40001, anzj.a(2131714085), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new ahve(40002, anzj.a(2131714086), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new ahve(40003, anzj.a(2131714083), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new ahve(40004, anzj.a(2131714080), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new ahve(40005, anzj.a(2131714079), Color.parseColor("#F2FF6EA2")));
  }
  
  public ahvd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahvf();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    ahvf localahvf = (ahvf)paramaggl;
    if (paramView == null)
    {
      paramaggl = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563026, null);
      localahvf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaggl);
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramaggl.findViewById(2131379382));
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localahvf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaggl.findViewById(2131377862));
      localahvf.b = ((TextView)paramaggl.findViewById(2131379501));
      localahvf.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaggl.findViewById(2131379381));
      localahvf.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramagjk);
      localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramagjk);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
    }
    for (;;)
    {
      paramView = localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int i = besm.a(false);
      int j = besm.b(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (e) {
        paramView.setContentDescription(anzj.a(2131714078));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramagjk = beyq.a(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localahvf.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localahvf.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramagjk)))
        {
          if (localahvf.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localahvf.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramagjk);
          }
          paramBaseChatItemLayout = ahng.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
          localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
          localahvf.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramagjk);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localahvf.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (ahve)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label776;
        }
        localahvf.b.setVisibility(0);
        localahvf.b.setText(paramView.jdField_a_of_type_JavaLangString);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.b);
        localahvf.b.setBackgroundDrawable(paramBaseChatItemLayout);
        label595:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label789;
        }
        localahvf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(bhez.b(190, 270, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
        paramView.setDecodeHandler(bhez.j);
        localahvf.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      for (;;)
      {
        localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
        localahvf.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
        return paramaggl;
        paramView = localahvf.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localahvf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label776:
        localahvf.b.setVisibility(8);
        break label595;
        label789:
        localahvf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramaggl = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131714084);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2) {}
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = ((aghd)agej.a(paramView)).a;
    a(paramView, localbhuk);
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbhuk);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
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
    case 2131379382: 
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if (!((TroopChatPie)localObject).a().a())
          {
            bgot localbgot = (bgot)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramView.getTag();
            localbgot.a(localMessageForTroopEffectPic.frienduin);
            localbgot.g();
            localbgot.a(localMessageForTroopEffectPic, false);
            localbgot.a((BaseChatPie)localObject);
            localbgot.f();
          }
        }
      }
      for (;;)
      {
        bhbg.a("obj_msg", "clk_play");
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
    if (bhsi.q(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    for (;;)
    {
      bhbg.a("obj_msg", "clk_tail    ");
      break;
      bhsi.z(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
      ((Intent)localObject).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvd
 * JD-Core Version:    0.7.0.1
 */