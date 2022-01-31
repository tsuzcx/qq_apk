import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class adsm
  extends BaseBubbleBuilder
{
  public static String a;
  public static List<MessageForTroopGift> a;
  private static int c = 101;
  private static int d = 102;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public Map<String, Boolean> a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  Handler b;
  public Map<String, ArrayList<Runnable>> b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new LinkedList();
    jdField_a_of_type_JavaLangString = "TroopGiftMsgItemBuilder";
  }
  
  public adsm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new adsn(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty()) {
      ThreadManager.post(new TroopGiftMsgItemBuilder.7(paramQQAppInterface.getEntityManagerFactory().createEntityManager()), 5, null, true);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public abstract View a(BaseChatItemLayout paramBaseChatItemLayout);
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adst localadst = (adst)paramacju;
    View localView = paramView;
    int i;
    int j;
    if (paramView == null)
    {
      localView = a(paramBaseChatItemLayout);
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView);
      localadst.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311967));
      localadst.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311966));
      localadst.jdField_a_of_type_AndroidWidgetButton = ((Button)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311964));
      localadst.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301472));
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297607));
      localadst.jdField_c_of_type_AndroidViewView = localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131302722);
      localadst.jdField_d_of_type_AndroidViewView = localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131311965);
      localadst.jdField_c_of_type_AndroidWidgetButton = ((Button)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301463));
      localadst.jdField_d_of_type_AndroidWidgetButton = ((Button)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301462));
      localadst.e = ((Button)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301458));
      localadst.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301464));
      localadst.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301459));
      localadst.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301461));
      localadst.jdField_b_of_type_AndroidWidgetButton = ((Button)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301460));
      i = (int)(220.0F * this.jdField_a_of_type_Float);
      j = (int)(i - 10.0F * this.jdField_a_of_type_Float);
      paramacju = (RelativeLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301464).getLayoutParams();
      paramacju.width = j;
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301464).setLayoutParams(paramacju);
      paramacju = (LinearLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301463).getLayoutParams();
      paramacju.width = ((int)(j / 2 - 1.0F * this.jdField_a_of_type_Float));
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301463).setLayoutParams(paramacju);
      paramacju = (LinearLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301462).getLayoutParams();
      paramacju.width = (j / 2);
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301462).setLayoutParams(paramacju);
      paramacju = (RelativeLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301459).getLayoutParams();
      paramacju.width = j;
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301459).setLayoutParams(paramacju);
      paramacju = (LinearLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301458).getLayoutParams();
      paramacju.width = j;
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131301458).setLayoutParams(paramacju);
      paramacju = (RelativeLayout.LayoutParams)localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297607).getLayoutParams();
      paramacju.width = i;
      localadst.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297607).setLayoutParams(paramacju);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
    }
    localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = a(paramChatMessage);
    MessageForTroopGift localMessageForTroopGift = (MessageForTroopGift)paramChatMessage;
    boolean bool = mnf.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localMessageForTroopGift.senderUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      if (localMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label2044;
      }
      localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      localadst.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((localMessageForTroopGift.btFlag == 0) || (bool))
      {
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (localMessageForTroopGift.btFlag == 1) {
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (localMessageForTroopGift.btFlag == 2) {
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (((localMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || (localMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || ((localMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (localMessageForTroopGift.btFlag == 0))) && (localMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_url)))
      {
        localadst.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_b_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.activity_text);
        localadst.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor(localMessageForTroopGift.activity_text_color));
      }
      if (localadst.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
      {
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
      }
      if (localadst.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
      }
      if (((localadst.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8) || (localadst.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 8) || (localadst.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) && (!this.jdField_b_of_type_Boolean)) {
        break label2076;
      }
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(100.0F * this.jdField_a_of_type_Float));
      label1258:
      if (this.jdField_b_of_type_Boolean)
      {
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      localadst.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = localMessageForTroopGift;
      if (localMessageForTroopGift.isInteract()) {
        break label2099;
      }
      paramChatMessage = new axjq(localMessageForTroopGift.title + localMessageForTroopGift.subtitle, 16).a();
      localadst.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      localadst.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localadst.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      label1377:
      if (!TextUtils.isEmpty(localMessageForTroopGift.charmHeroism)) {
        break label2148;
      }
      label1388:
      localadst.jdField_a_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.comefrom);
      localadst.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localMessageForTroopGift.comefrom);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(2131307015, localMessageForTroopGift.giftPicId + "");
      if (localMessageForTroopGift.isInteract()) {
        break label2513;
      }
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
      localadst.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      label1486:
      paramBaseChatItemLayout = null;
      paramView = null;
      paramChatMessage = paramView;
      paramacju = paramBaseChatItemLayout;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      paramChatMessage = paramView;
      paramacju = paramBaseChatItemLayout;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849342);
      paramChatMessage = paramView;
      paramacju = paramBaseChatItemLayout;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849342);
      paramChatMessage = paramView;
      paramacju = paramBaseChatItemLayout;
      paramView = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), localURLDrawableOptions);
      paramChatMessage = paramView;
      paramacju = paramView;
      paramView.setDownloadListener(new adso(this, paramView, localMessageForTroopGift, localadst));
      paramChatMessage = paramView;
    }
    catch (OutOfMemoryError paramacju)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, paramacju.getMessage());
        }
      }
    }
    catch (Exception paramChatMessage)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, paramChatMessage.getMessage());
          }
          paramChatMessage = paramacju;
        }
      } while (paramChatMessage == null);
      if (!(paramChatMessage.getCurrDrawable() instanceof RegionDrawable)) {
        break label2672;
      }
    }
    if ((paramChatMessage != null) && (paramChatMessage.getStatus() == 2)) {
      paramChatMessage.restartDownload();
    }
    label1829:
    label1875:
    label3169:
    label3170:
    for (;;)
    {
      localadst.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramChatMessage);
      paramChatMessage = new adsr(this, localMessageForTroopGift, localadst);
      localadst.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localadst.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localadst.e.setOnClickListener(paramChatMessage);
      localadst.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(paramChatMessage);
      localadst.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(paramChatMessage);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramacmv);
      localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(new adsp(this, paramacmv));
      localadst.jdField_c_of_type_AndroidViewView.setOnClickListener(paramChatMessage);
      localadst.jdField_c_of_type_AndroidViewView.setOnLongClickListener(paramacmv);
      localadst.jdField_c_of_type_AndroidViewView.setOnTouchListener(new adsq(this, paramacmv));
      paramChatMessage = (azfo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if ((localMessageForTroopGift.isLoading) && (paramChatMessage.b(azkd.b(localMessageForTroopGift))))
      {
        paramChatMessage.a(localadst);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + localMessageForTroopGift.uniseq);
        }
        localadst.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!localMessageForTroopGift.isReported)
        {
          localMessageForTroopGift.isReported = true;
          jdField_a_of_type_JavaUtilList.add(localMessageForTroopGift);
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localMessageForTroopGift.senderuin)) {
            break label2732;
          }
          i = 0;
          if (localMessageForTroopGift.istroop != 0) {
            break label2759;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
        }
        label1919:
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopGift.title)))
        {
          paramacju = localMessageForTroopGift.title;
          paramChatMessage = paramacju;
          if (localadst.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            paramChatMessage = paramacju;
            if (!TextUtils.isEmpty(localadst.jdField_b_of_type_AndroidWidgetTextView.getText())) {
              paramChatMessage = paramacju + localadst.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
            }
          }
          localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramChatMessage);
        }
        return localView;
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
        break;
        label2044:
        localadst.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        localadst.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localadst.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
        break;
        localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(142.0F * this.jdField_a_of_type_Float));
        break label1258;
        localadst.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.title);
        localadst.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localadst.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.subtitle);
        localadst.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        break label1377;
        label2148:
        localadst.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramChatMessage = localMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
        if ((paramChatMessage == null) || (paramChatMessage.length != 2)) {
          break label1388;
        }
        paramacju = paramChatMessage[0].split("\\#");
        if ((paramacju == null) || (paramacju.length != 3)) {
          break label1388;
        }
        paramView = paramChatMessage[1].split("\\#");
        if ((paramView == null) || (paramView.length != 3)) {
          break label1388;
        }
        paramChatMessage = "";
        if (localMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
        {
          if (localMessageForTroopGift.sendScore >= 0) {
            paramChatMessage = "+";
          }
          paramChatMessage = ajjy.a(2131649618) + paramacju[0] + paramChatMessage + localMessageForTroopGift.sendScore + "" + paramView[0];
          if (localMessageForTroopGift.sendScore == 0) {
            paramChatMessage = "";
          }
        }
        for (;;)
        {
          localadst.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
          break;
          if (localMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
          {
            if (localMessageForTroopGift.recvScore >= 0) {
              paramChatMessage = "+";
            }
            paramChatMessage = ajjy.a(2131649602) + paramacju[1] + paramChatMessage + localMessageForTroopGift.recvScore + "" + paramView[1];
            if (localMessageForTroopGift.recvScore == 0) {
              paramChatMessage = "";
            }
          }
          else
          {
            if (localMessageForTroopGift.recvScore >= 0) {
              paramChatMessage = "+";
            }
            paramChatMessage = ajjy.a(2131649617) + paramacju[2] + paramChatMessage + localMessageForTroopGift.recvScore + "" + paramView[2];
            if (localMessageForTroopGift.recvScore == 0) {
              paramChatMessage = "";
            }
          }
        }
        localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130849343);
        localadst.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        break label1486;
        i = localMessageForTroopGift.objColor;
        if (i != 0) {
          break label3169;
        }
        i = -2138570752;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localMessageForTroopGift.interactId)) {
          break label3170;
        }
        a(((RegionDrawable)paramChatMessage.getCurrDrawable()).getBitmap(), i, localadst.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, localMessageForTroopGift.giftPicId + "");
        break;
        label2672:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (paramChatMessage.getCurrDrawable() instanceof RegionDrawable));
        break;
        localadst.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramChatMessage.b(localadst);
        break label1829;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(Long.valueOf(localMessageForTroopGift.receiverUin)))
        {
          i = 1;
          break label1875;
          if (localMessageForTroopGift.istroop == 3000)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
            break label1919;
          }
          if ((localMessageForTroopGift.istroop == 1000) || (localMessageForTroopGift.istroop == 1004))
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
            break label1919;
          }
          if (localMessageForTroopGift.isFromNearby)
          {
            ajnb.a("gift_aio", "exp_obj", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
            if (!azkd.a(localMessageForTroopGift)) {
              break label1919;
            }
            ajnb.a("gift_aio", "exp_play", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
            break label1919;
          }
          if (mnf.a(localMessageForTroopGift)) {}
          for (j = 2;; j = 1)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
            if (!azkd.a(localMessageForTroopGift)) {
              break;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
            break;
          }
        }
        i = 2;
        break label1875;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopGift)paramChatMessage).title;
  }
  
  public String a(String paramString, int paramInt)
  {
    return ajed.aU + ".gift/" + "troopGift_" + paramString + "_" + paramInt + ".png";
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
  
  public void a(Bitmap paramBitmap, int paramInt, BubbleImageView paramBubbleImageView, String paramString)
  {
    if ((paramBitmap == null) || (paramBubbleImageView == null) || (paramString == null)) {
      return;
    }
    Object localObject = new File(a(paramString, paramInt));
    String str = "troopGift_" + paramString + "_" + paramInt + ".png";
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    long l1 = localSharedPreferences.getLong(str, 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != 0L) && (l2 - l1 < 259200000L)) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_JavaUtilMap.get(str) != null) {}
      for (boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilMap.get(str)).booleanValue();; bool = false)
      {
        if ((localObject != null) && (((File)localObject).exists()) && (i != 0))
        {
          paramBitmap = URLDrawable.URLDrawableOptions.obtain();
          paramBitmap.mFailedDrawable = new ColorDrawable(paramInt);
          paramBitmap.mLoadingDrawable = new ColorDrawable(paramInt);
          paramBubbleImageView.setImageDrawable(URLDrawable.getDrawable(new File(a(paramString, paramInt)), paramBitmap));
          return;
        }
        if (bool)
        {
          localObject = (ArrayList)this.jdField_b_of_type_JavaUtilMap.get(str);
          paramBitmap = (Bitmap)localObject;
          if (localObject == null)
          {
            paramBitmap = new ArrayList();
            this.jdField_b_of_type_JavaUtilMap.put(str, paramBitmap);
          }
          paramBitmap.add(new TroopGiftMsgItemBuilder.2(this, paramBubbleImageView, paramString, paramInt));
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.put(str, Boolean.valueOf(true));
        paramBubbleImageView.setImageDrawable(new ColorDrawable(paramInt));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ThreadManager.post(new TroopGiftMsgItemBuilder.3(this, paramString, paramInt, paramBitmap, paramBubbleImageView, str, localSharedPreferences, l2), 8, null, false);
        return;
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.h);
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.isSend();
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = aciy.a(paramView);
    a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbakh);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsm
 * JD-Core Version:    0.7.0.1
 */