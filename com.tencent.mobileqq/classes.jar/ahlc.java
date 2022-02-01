import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class ahlc
  implements View.OnClickListener
{
  private ahle jdField_a_of_type_Ahle;
  private MessageForTroopGift jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift;
  
  public ahlc(ahkx paramahkx, MessageForTroopGift paramMessageForTroopGift, ahle paramahle)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = paramMessageForTroopGift;
    this.jdField_a_of_type_Ahle = paramahle;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aiav))
    {
      ((aiav)this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin));
      return;
    }
    new bdlf(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
    String str = bhhr.i(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, "url");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      str = str.replace("{troopUin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin).replace("{uin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin).replace("{from}", "28");
      Intent localIntent = new Intent(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
    }
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.activity_url;
    localIntent.putExtra("url", str);
    localIntent.putExtra("key_isReadModeEnabled", true);
    uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, localIntent, str);
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    bdla.b(null, "dc00899", "grp_lbs", "", "qq_gift", "popup_click", paramInt, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftId), "", "", "");
  }
  
  private void b()
  {
    new bdlf(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
    String str1 = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + anvx.a(2131714778);
    String str2 = bhhr.i(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, "wantWord");
    if (!TextUtils.isEmpty(str2)) {
      str1 = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + str2;
    }
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText(str1);
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setTag(2131374018, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setSelection(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.length());
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showSendWantGiftMsg.getAndSet(true);
    if ((this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof aiav)) {
      ((aiav)this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).m();
    }
    this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.addTextChangedListener(new ahld(this));
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl))
    {
      localObject = new Intent(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
    {
      bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
      return;
      localObject = ((FragmentActivity)this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isToAll())) {}
        for (int i = TroopGiftPanel.f;; i = TroopGiftPanel.e)
        {
          ((BaseChatPie)localObject).showGiftPanel(true, i);
          break;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
    {
      bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
    {
      bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby) {
      if (this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      anzp.a("gift_aio", "clk_tail", this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt + "", "", "");
      return;
      if (this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin)))
      {
        paramInt = 1;
        continue;
        bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", paramInt, 0, this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      }
      else
      {
        paramInt = 2;
      }
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (bglb.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))
    {
      localObject1 = (bggl)this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if ((localObject1 != null) && (((bggl)localObject1).b()))
      {
        localObject2 = ((FragmentActivity)this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((localObject2 != null) && (((ChatFragment)localObject2).a() != null)) {
          ((bggl)localObject1).a(((ChatFragment)localObject2).a());
        }
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading = false;
        ((bggl)localObject1).a(this.jdField_a_of_type_Ahle);
        ((bggl)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading) {
          ((bggl)localObject1).b(this.jdField_a_of_type_Ahle);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) {
          ((bggl)localObject1).f();
        }
      }
      if (!this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
        break label334;
      }
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
      {
        bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
        return;
        localObject1 = new Intent(this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
        localObject2 = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=" + this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin + "&uin=" + (String)localObject2 + "&name=" + bhcu.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2) + "&from=obj&_wv=1031&_bid=2204";
        ((Intent)localObject1).putExtra("url", (String)localObject2);
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
        uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, (Intent)localObject1, (String)localObject2);
        this.jdField_a_of_type_Ahkx.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        break;
        label334:
        if (!this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
          break label604;
        }
        i = 1;
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
      {
        bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
      {
        bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
      {
        anzp.a("gift_aio", "clk_obj", this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i + "", "", "");
        return;
      }
      bdla.b(this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", paramInt, 0, this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, i + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "", "");
      return;
      label604:
      i = 2;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ahkx.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (nty.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
      for (int i = 2;; i = 1)
      {
        if (paramView.getId() != 2131367721) {
          break label52;
        }
        b();
        break;
      }
      label52:
      if (paramView.getId() == 2131367726) {
        ahkx.a(this.jdField_a_of_type_Ahkx);
      } else if (paramView.getId() == 2131367725) {
        a();
      } else if (paramView.getId() == 2131363503) {
        c(i);
      } else if (paramView.getId() == 2131379474) {
        b(i);
      } else if (paramView.getId() == 2131367724) {
        a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlc
 * JD-Core Version:    0.7.0.1
 */