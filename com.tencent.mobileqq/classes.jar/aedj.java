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

public abstract class aedj
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
  
  public aedj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new aedk(this);
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
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    aedq localaedq = (aedq)paramacuj;
    View localView = paramView;
    int i;
    int j;
    if (paramView == null)
    {
      localView = a(paramBaseChatItemLayout);
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView);
      localaedq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377790));
      localaedq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377789));
      localaedq.jdField_a_of_type_AndroidWidgetButton = ((Button)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377787));
      localaedq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367082));
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363157));
      localaedq.jdField_c_of_type_AndroidViewView = localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131368344);
      localaedq.jdField_d_of_type_AndroidViewView = localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377788);
      localaedq.jdField_c_of_type_AndroidWidgetButton = ((Button)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367073));
      localaedq.jdField_d_of_type_AndroidWidgetButton = ((Button)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367072));
      localaedq.e = ((Button)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367068));
      localaedq.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367074));
      localaedq.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367069));
      localaedq.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367071));
      localaedq.jdField_b_of_type_AndroidWidgetButton = ((Button)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367070));
      i = (int)(220.0F * this.jdField_a_of_type_Float);
      j = (int)(i - 10.0F * this.jdField_a_of_type_Float);
      paramacuj = (RelativeLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367074).getLayoutParams();
      paramacuj.width = j;
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367074).setLayoutParams(paramacuj);
      paramacuj = (LinearLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367073).getLayoutParams();
      paramacuj.width = ((int)(j / 2 - 1.0F * this.jdField_a_of_type_Float));
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367073).setLayoutParams(paramacuj);
      paramacuj = (LinearLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367072).getLayoutParams();
      paramacuj.width = (j / 2);
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367072).setLayoutParams(paramacuj);
      paramacuj = (RelativeLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367069).getLayoutParams();
      paramacuj.width = j;
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367069).setLayoutParams(paramacuj);
      paramacuj = (LinearLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367068).getLayoutParams();
      paramacuj.width = j;
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131367068).setLayoutParams(paramacuj);
      paramacuj = (RelativeLayout.LayoutParams)localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363157).getLayoutParams();
      paramacuj.width = i;
      localaedq.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363157).setLayoutParams(paramacuj);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(true);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
    }
    localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = a(paramChatMessage);
    MessageForTroopGift localMessageForTroopGift = (MessageForTroopGift)paramChatMessage;
    boolean bool = myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localMessageForTroopGift.senderUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
    {
      if (localMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
        break label2044;
      }
      localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      localaedq.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((localMessageForTroopGift.btFlag == 0) || (bool))
      {
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (localMessageForTroopGift.btFlag == 1) {
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (localMessageForTroopGift.btFlag == 2) {
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (((localMessageForTroopGift.receiverUin != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || (localMessageForTroopGift.senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) || ((localMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (localMessageForTroopGift.btFlag == 0))) && (localMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(localMessageForTroopGift.activity_url)))
      {
        localaedq.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_b_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.activity_text);
        localaedq.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor(localMessageForTroopGift.activity_text_color));
      }
      if (localaedq.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)
      {
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
      }
      if (localaedq.jdField_b_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0).a(new String[] { localMessageForTroopGift.frienduin + "", "" }).a();
      }
      if (((localaedq.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8) || (localaedq.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 8) || (localaedq.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) && (!this.jdField_b_of_type_Boolean)) {
        break label2076;
      }
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(100.0F * this.jdField_a_of_type_Float));
      label1258:
      if (this.jdField_b_of_type_Boolean)
      {
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      localaedq.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = localMessageForTroopGift;
      if (localMessageForTroopGift.isInteract()) {
        break label2099;
      }
      paramChatMessage = new ayjw(localMessageForTroopGift.title + localMessageForTroopGift.subtitle, 16).a();
      localaedq.jdField_a_of_type_AndroidWidgetTextView.setText(paramChatMessage);
      localaedq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localaedq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      label1377:
      if (!TextUtils.isEmpty(localMessageForTroopGift.charmHeroism)) {
        break label2148;
      }
      label1388:
      localaedq.jdField_a_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.comefrom);
      localaedq.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localMessageForTroopGift.comefrom);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(2131372729, localMessageForTroopGift.giftPicId + "");
      if (localMessageForTroopGift.isInteract()) {
        break label2513;
      }
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
      localaedq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      label1486:
      paramBaseChatItemLayout = null;
      paramView = null;
      paramChatMessage = paramView;
      paramacuj = paramBaseChatItemLayout;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      paramChatMessage = paramView;
      paramacuj = paramBaseChatItemLayout;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849586);
      paramChatMessage = paramView;
      paramacuj = paramBaseChatItemLayout;
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849586);
      paramChatMessage = paramView;
      paramacuj = paramBaseChatItemLayout;
      paramView = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), localURLDrawableOptions);
      paramChatMessage = paramView;
      paramacuj = paramView;
      paramView.setDownloadListener(new aedl(this, paramView, localMessageForTroopGift, localaedq));
      paramChatMessage = paramView;
    }
    catch (OutOfMemoryError paramacuj)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, paramacuj.getMessage());
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
          paramChatMessage = paramacuj;
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
      localaedq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramChatMessage);
      paramChatMessage = new aedo(this, localMessageForTroopGift, localaedq);
      localaedq.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localaedq.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localaedq.e.setOnClickListener(paramChatMessage);
      localaedq.jdField_c_of_type_AndroidViewViewGroup.setOnClickListener(paramChatMessage);
      localaedq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(paramChatMessage);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramacxj);
      localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(new aedm(this, paramacxj));
      localaedq.jdField_c_of_type_AndroidViewView.setOnClickListener(paramChatMessage);
      localaedq.jdField_c_of_type_AndroidViewView.setOnLongClickListener(paramacxj);
      localaedq.jdField_c_of_type_AndroidViewView.setOnTouchListener(new aedn(this, paramacxj));
      paramChatMessage = (bahf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if ((localMessageForTroopGift.isLoading) && (paramChatMessage.b(balu.b(localMessageForTroopGift))))
      {
        paramChatMessage.a(localaedq);
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + localMessageForTroopGift.uniseq);
        }
        localaedq.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
        }
        label1919:
        if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopGift.title)))
        {
          paramacuj = localMessageForTroopGift.title;
          paramChatMessage = paramacuj;
          if (localaedq.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            paramChatMessage = paramacuj;
            if (!TextUtils.isEmpty(localaedq.jdField_b_of_type_AndroidWidgetTextView.getText())) {
              paramChatMessage = paramacuj + localaedq.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
            }
          }
          localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramChatMessage);
        }
        return localView;
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
        break;
        label2044:
        localaedq.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
        localaedq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        localaedq.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
        break;
        localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams().height = ((int)(142.0F * this.jdField_a_of_type_Float));
        break label1258;
        localaedq.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.title);
        localaedq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localaedq.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.subtitle);
        localaedq.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
        break label1377;
        label2148:
        localaedq.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramChatMessage = localMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
        if ((paramChatMessage == null) || (paramChatMessage.length != 2)) {
          break label1388;
        }
        paramacuj = paramChatMessage[0].split("\\#");
        if ((paramacuj == null) || (paramacuj.length != 3)) {
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
          paramChatMessage = ajya.a(2131715419) + paramacuj[0] + paramChatMessage + localMessageForTroopGift.sendScore + "" + paramView[0];
          if (localMessageForTroopGift.sendScore == 0) {
            paramChatMessage = "";
          }
        }
        for (;;)
        {
          localaedq.jdField_b_of_type_AndroidWidgetTextView.setText(paramChatMessage);
          break;
          if (localMessageForTroopGift.receiverUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
          {
            if (localMessageForTroopGift.recvScore >= 0) {
              paramChatMessage = "+";
            }
            paramChatMessage = ajya.a(2131715403) + paramacuj[1] + paramChatMessage + localMessageForTroopGift.recvScore + "" + paramView[1];
            if (localMessageForTroopGift.recvScore == 0) {
              paramChatMessage = "";
            }
          }
          else
          {
            if (localMessageForTroopGift.recvScore >= 0) {
              paramChatMessage = "+";
            }
            paramChatMessage = ajya.a(2131715418) + paramacuj[2] + paramChatMessage + localMessageForTroopGift.recvScore + "" + paramView[2];
            if (localMessageForTroopGift.recvScore == 0) {
              paramChatMessage = "";
            }
          }
        }
        localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130849587);
        localaedq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
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
        a(((RegionDrawable)paramChatMessage.getCurrDrawable()).getBitmap(), i, localaedq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, localMessageForTroopGift.giftPicId + "");
        break;
        label2672:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (paramChatMessage.getCurrDrawable() instanceof RegionDrawable));
        break;
        localaedq.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramChatMessage.b(localaedq);
        break label1829;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(Long.valueOf(localMessageForTroopGift.receiverUin)))
        {
          i = 1;
          break label1875;
          if (localMessageForTroopGift.istroop == 3000)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
            break label1919;
          }
          if ((localMessageForTroopGift.istroop == 1000) || (localMessageForTroopGift.istroop == 1004))
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
            break label1919;
          }
          if (localMessageForTroopGift.isFromNearby)
          {
            akbj.a("gift_aio", "exp_obj", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
            if (!balu.a(localMessageForTroopGift)) {
              break label1919;
            }
            akbj.a("gift_aio", "exp_play", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", "", "");
            break label1919;
          }
          if (myb.a(localMessageForTroopGift)) {}
          for (j = 2;; j = 1)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
            if (!balu.a(localMessageForTroopGift)) {
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
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
    return bbvj.a(ajsd.aW + ".gift/" + "troopGift_" + paramString + "_" + paramInt + ".png");
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
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = actj.a(paramView);
    a(paramView, localbbmf);
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    b(paramView, localbbmf);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aedj
 * JD-Core Version:    0.7.0.1
 */