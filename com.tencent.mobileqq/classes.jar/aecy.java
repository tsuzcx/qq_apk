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

public class aecy
  extends BaseBubbleBuilder
  implements acwb, View.OnClickListener
{
  protected static SparseArray<aecz> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new aecz(40000, ajya.a(2131715313), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new aecz(40001, ajya.a(2131715311), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new aecz(40002, ajya.a(2131715312), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new aecz(40003, ajya.a(2131715309), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new aecz(40004, ajya.a(2131715306), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new aecz(40005, ajya.a(2131715305), Color.parseColor("#F2FF6EA2")));
  }
  
  public aecy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new aeda();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    aeda localaeda = (aeda)paramacuj;
    if (paramView == null)
    {
      paramacuj = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562532, null);
      localaeda.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramacuj);
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramacuj.findViewById(2131377767));
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localaeda.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacuj.findViewById(2131376342));
      localaeda.b = ((TextView)paramacuj.findViewById(2131377880));
      localaeda.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramacuj.findViewById(2131377766));
      localaeda.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramacxj);
      localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramacxj);
      paramacuj.setOnTouchListener(paramacxj);
      paramacuj.setOnLongClickListener(paramacxj);
    }
    for (;;)
    {
      paramView = localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      int i = aywm.a(false);
      int j = aywm.b(false);
      paramView.setMaxWidth(i);
      paramView.setMaxHeight(i);
      paramView.setMinimumWidth(j);
      paramView.setMinimumHeight(j);
      if (e) {
        paramView.setContentDescription(ajya.a(2131715304));
      }
      if (!localMessageForTroopEffectPic.isSendFromLocal())
      {
        paramacxj = aywm.a(localMessageForTroopEffectPic, 65537);
        paramBaseChatItemLayout = new int[2];
        BaseChatItemLayout tmp245_243 = paramBaseChatItemLayout;
        tmp245_243[0] = 0;
        BaseChatItemLayout tmp249_245 = tmp245_243;
        tmp249_245[1] = 0;
        tmp249_245;
        if ((localaeda.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!localaeda.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramacxj)))
        {
          if (localaeda.jdField_a_of_type_ComTencentImageURLDrawable != null) {
            QLog.d("tdrawable", 2, "holder.d=" + localaeda.jdField_a_of_type_ComTencentImageURLDrawable.getURL() + "==url=" + paramacxj);
          }
          paramBaseChatItemLayout = advs.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
          localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
          localaeda.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForTroopEffectPic, 2);
          paramView = paramBaseChatItemLayout;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "show receive pic uniseq=" + localMessageForTroopEffectPic.uniseq + " url=" + paramacxj);
            paramView = paramBaseChatItemLayout;
          }
          if (paramView == null) {
            QLog.d("tdrawable", 2, "d==null");
          }
          localaeda.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
          QLog.d("tdrawable", 2, "not isDynamic tag gone");
        }
      }
      else
      {
        paramView = (aecz)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
        if (paramView == null) {
          break label775;
        }
        localaeda.b.setVisibility(0);
        localaeda.b.setText(paramView.jdField_a_of_type_JavaLangString);
        paramBaseChatItemLayout = new GradientDrawable();
        paramBaseChatItemLayout.setShape(0);
        float f = baxn.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
        paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
        paramBaseChatItemLayout.setColor(paramView.b);
        localaeda.b.setBackgroundDrawable(paramBaseChatItemLayout);
        label594:
        if ((localMessageForTroopEffectPic.effectId < 40003) || (localMessageForTroopEffectPic.effectId > 40005)) {
          break label788;
        }
        localaeda.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout = new ColorDrawable(0);
        paramView.mFailedDrawable = paramBaseChatItemLayout;
        paramView.mLoadingDrawable = paramBaseChatItemLayout;
        paramView = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_" + localMessageForTroopEffectPic.effectId + ".png", paramView);
        paramView.setTag(bavw.b(190, 270, baxn.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
        paramView.setDecodeHandler(bavw.i);
        localaeda.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
      }
      for (;;)
      {
        localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
        localaeda.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
        return paramacuj;
        paramView = localaeda.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localaeda.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
        break;
        label775:
        localaeda.b.setVisibility(8);
        break label594;
        label788:
        localaeda.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramacuj = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131715310);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2) {}
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = ((acva)actj.a(paramView)).a;
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbbmf);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      return;
    case 2131377767: 
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof TroopChatPie))
        {
          localObject = (TroopChatPie)localObject;
          if (!((TroopChatPie)localObject).a().a())
          {
            bahf localbahf = (bahf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            paramView = (MessageForTroopEffectPic)paramView.getTag();
            localbahf.a(paramView.frienduin);
            localbahf.g();
            localbahf.a(paramView, false);
            localbahf.a((BaseChatPie)localObject);
            localbahf.f();
          }
        }
      }
      for (;;)
      {
        batr.a("obj_msg", "clk_play");
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
    if (bbkb.q(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    }
    for (;;)
    {
      batr.a("obj_msg", "clk_tail    ");
      return;
      bbkb.z(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
      paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecy
 * JD-Core Version:    0.7.0.1
 */