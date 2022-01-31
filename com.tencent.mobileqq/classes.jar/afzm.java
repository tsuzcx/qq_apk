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
import java.net.URL;

public class afzm
  extends BaseBubbleBuilder
  implements aenl, View.OnClickListener
{
  protected static SparseArray<afzn> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new afzn(40000, alpo.a(2131715685), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new afzn(40001, alpo.a(2131715683), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new afzn(40002, alpo.a(2131715684), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new afzn(40003, alpo.a(2131715681), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new afzn(40004, alpo.a(2131715678), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new afzn(40005, alpo.a(2131715677), Color.parseColor("#F2FF6EA2")));
  }
  
  public afzm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afzo();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    afzo localafzo = (afzo)paramaelt;
    if (paramView == null)
    {
      paramaelt = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562735, null);
      localafzo.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramaelt);
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramaelt.findViewById(2131378311));
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localafzo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaelt.findViewById(2131376846));
      localafzo.b = ((TextView)paramaelt.findViewById(2131378425));
      localafzo.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramaelt.findViewById(2131378310));
      localafzo.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramaeov);
      localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      paramaelt.setOnLongClickListener(paramaeov);
    }
    for (;;)
    {
      paramView = localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int i = baul.a(false);
      int j = baul.b(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (e) {
        paramView.setContentDescription(alpo.a(2131715676));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramaeov = baul.a(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localafzo.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localafzo.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramaeov)))
        {
          if (localafzo.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localafzo.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramaeov);
          }
          paramBaseChatItemLayout = afsf.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
          localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
          localafzo.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramaeov);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localafzo.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (afzn)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label775;
        }
        localafzo.b.setVisibility(0);
        localafzo.b.setText(paramView.jdField_a_of_type_JavaLangString);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.b);
        localafzo.b.setBackgroundDrawable(paramBaseChatItemLayout);
        label594:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label788;
        }
        localafzo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(bcuq.b(190, 270, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
        paramView.setDecodeHandler(bcuq.i);
        localafzo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      for (;;)
      {
        localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
        localafzo.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
        return paramaelt;
        paramView = localafzo.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localafzo.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label775:
        localafzo.b.setVisibility(8);
        break label594;
        label788:
        localafzo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramaelt = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131715682);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2) {}
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = ((aemk)aekt.a(paramView)).a;
    a(paramView, localbdkz);
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbdkz);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131378311: 
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if (!((TroopChatPie)localObject).a().a())
          {
            bcfr localbcfr = (bcfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            paramView = (MessageForTroopEffectPic)paramView.getTag();
            localbcfr.a(paramView.frienduin);
            localbcfr.g();
            localbcfr.a(paramView, false);
            localbcfr.a((BaseChatPie)localObject);
            localbcfr.f();
          }
        }
      }
      for (;;)
      {
        bcsl.a("obj_msg", "clk_play");
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
    if (bdiv.r(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    for (;;)
    {
      bcsl.a("obj_msg", "clk_tail    ");
      return;
      bdiv.z(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
      paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzm
 * JD-Core Version:    0.7.0.1
 */