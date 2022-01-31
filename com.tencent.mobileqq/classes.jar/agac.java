import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class agac
  implements View.OnClickListener
{
  private agae jdField_a_of_type_Agae;
  private MessageForTroopGift jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift;
  
  public agac(afzx paramafzx, MessageForTroopGift paramMessageForTroopGift, agae paramagae)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = paramMessageForTroopGift;
    this.jdField_a_of_type_Agae = paramagae;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    if (nav.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
    Object localObject;
    for (int j = 2; paramView.getId() == 2131367195; j = 1)
    {
      new azmo(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
      paramView = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + alpo.a(2131715797);
      localObject = bdiv.i(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, "wantWord");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramView = "@" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + (String)localObject;
      }
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373107, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.length());
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
      if ((this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agmb)) {
        ((agmb)this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bC();
      }
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new agad(this));
      return;
    }
    if (paramView.getId() == 2131367200)
    {
      paramView = alpo.a(2131715807);
      localObject = bdiv.i(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, "thxWord");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label1875;
      }
      paramView = (View)localObject;
    }
    label831:
    label1863:
    label1868:
    label1875:
    for (;;)
    {
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
      this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.length());
      if (!(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agmb)) {
        break;
      }
      ((agmb)this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).bC();
      return;
      if (paramView.getId() == 2131367199)
      {
        if ((this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agmb))
        {
          ((agmb)this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).g(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin));
          return;
        }
        new azmo(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).a();
        paramView = bdiv.i(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, "url");
        if (TextUtils.isEmpty(paramView)) {
          break label1868;
        }
      }
      for (;;)
      {
        paramView = paramView.replace("{troopUin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin).replace("{uin}", "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin).replace("{from}", "28");
        localObject = new Intent(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return;
        int i;
        if (paramView.getId() == 2131363194) {
          if (bckh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))
          {
            paramView = (bcfr)this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
            if ((paramView != null) && (paramView.b()))
            {
              localObject = ((FragmentActivity)this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext).getChatFragment();
              if ((localObject != null) && (((ChatFragment)localObject).a() != null)) {
                paramView.a(((ChatFragment)localObject).a());
              }
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading = false;
              paramView.a(this.jdField_a_of_type_Agae);
              paramView.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
              if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading) {
                paramView.b(this.jdField_a_of_type_Agae);
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) {
                paramView.f();
              }
            }
            if (!this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
              break label1035;
            }
            i = 0;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
          {
            azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
            return;
            paramView = new Intent(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
            localObject = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=" + this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "&uin=" + (String)localObject + "&name=" + bdbi.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2) + "&from=obj&_wv=1031&_bid=2204";
            paramView.putExtra("url", (String)localObject);
            paramView.putExtra("key_isReadModeEnabled", true);
            syb.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, paramView, (String)localObject);
            this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            break label831;
            if (!this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
              break label1863;
            }
            i = 1;
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
          {
            azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
          {
            azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
          {
            alsy.a("gift_aio", "clk_obj", this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", "", "");
            return;
          }
          azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", j, 0, this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "", "");
          return;
          if (paramView.getId() == 2131378331)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl))
            {
              paramView = new Intent(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
              paramView.putExtra("key_isReadModeEnabled", true);
              this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            }
            while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
            {
              azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
              return;
              paramView = ((FragmentActivity)this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext).getChatFragment();
              if ((paramView != null) && (paramView.a() != null))
              {
                paramView = paramView.a();
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isToAll())) {}
                for (i = TroopGiftPanel.f;; i = TroopGiftPanel.e)
                {
                  paramView.a(true, i);
                  break;
                }
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
            {
              azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
              return;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
            {
              azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby) {
              if (this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
                i = 0;
              }
            }
          }
          for (;;)
          {
            alsy.a("gift_aio", "clk_tail", this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", "", "");
            return;
            if (this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin)))
            {
              i = 1;
              continue;
              azmj.b(this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", j, 0, this.jdField_a_of_type_Afzx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
              return;
              if (paramView.getId() != 2131367198) {
                break;
              }
              paramView = new Intent(this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.activity_url;
              paramView.putExtra("url", (String)localObject);
              paramView.putExtra("key_isReadModeEnabled", true);
              syb.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, paramView, (String)localObject);
              this.jdField_a_of_type_Afzx.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
              azmj.b(null, "dc00899", "grp_lbs", "", "qq_gift", "popup_click", j, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftId), "", "", "");
              return;
            }
            i = 2;
          }
          i = 2;
        }
        paramView = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agac
 * JD-Core Version:    0.7.0.1
 */