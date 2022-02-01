import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class aggf
  implements agin, View.OnClickListener
{
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected ImageView b;
  protected ImageView c;
  protected ImageView d;
  
  public aggf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.getActivity();
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.getUIHandler();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.getSessionInfo();
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364571);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    if (paramInt2 == 1) {
      ((LinearLayout.LayoutParams)localObject).setMargins(paramInt3, 0, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131700465));
      }
      localObject = new StateListDrawable();
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839404);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839405);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      if (paramBoolean1) {
        b(paramInt1, paramInt3);
      }
      if (paramBoolean3) {
        a(paramInt1, paramInt3);
      }
      ((agit)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(11)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean4, paramInt1, paramInt1, paramInt3, paramInt4);
      if (paramBoolean5) {
        d(paramInt1, paramInt3);
      }
      if (paramBoolean2) {
        c(paramInt1, paramInt3);
      }
      return;
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
    }
  }
  
  private void c()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692125, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
      return;
    }
    Object localObject3 = axio.a().a();
    if (((List)localObject3).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698181, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
      return;
    }
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < ((List)localObject3).size())
      {
        localObject1 = (ChatMessage)((List)localObject3).get(i);
        if ((!(localObject1 instanceof MessageForMarketFace)) && (!(localObject1 instanceof MessageForPic))) {}
      }
      else
      {
        if (localObject1 != null) {
          break;
        }
        QLog.e("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, no market face message or pic message selected");
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698181, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
        return;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 1, "add to custom face, selected message=" + localObject1);
    }
    if ((localObject1 instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localObject1;
      localObject2 = URLDrawableHelper.getDrawable(URLDrawableHelper.getURL((azkl)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      ahsl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131299080), null, null);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setLeftCheckBoxVisible(false, null, false);
      return;
      if ((localObject1 instanceof MessageForMarketFace))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
        localObject3 = (MessageForMarketFace)localObject1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthEmoticonDialog;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthEmoticonDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthEmoticonDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691881));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mAuthEmoticonDialog.show();
        }
        localObject2 = ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(((MessageForMarketFace)localObject3).mMarkFaceMessage);
        EmoticonPackage localEmoticonPackage = ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId);
        ahaw.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject3;
        ahaw.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = (PicEmoticonInfo)localObject2;
        if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          int j = (int)(System.currentTimeMillis() / 1000L);
          if ((j - i > 86400) || (j < i))
          {
            localObject3 = new ahbi();
            ((ahbi)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (bisl)localObject1);
            asig.a().a((asiv)localObject3);
            ((asih)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId, asih.c);
          }
          else
          {
            ahaw.a(6, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (bisl)localObject1);
          }
        }
        else
        {
          localObject3 = new ahbi();
          ((ahbi)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (PicEmoticonInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (bisl)localObject1);
          asig.a().a((asiv)localObject3);
          ((asih)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(((PicEmoticonInfo)localObject2).emoticon.epId, asih.c);
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.d = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.d.setId(2131364575);
    if (AppSetting.c) {
      this.d.setContentDescription(anvx.a(2131700490));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839366);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839366);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.d.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.d);
  }
  
  private void d()
  {
    int i = axio.a().c();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", axcx.c, axcx.c, 0, i, "", "", "", "");
    if ((admh.b != null) && (admh.b.isShowing())) {}
    do
    {
      return;
      localObject = axio.a().a();
      if (((List)localObject).size() != 0) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698181, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTitleBarHeight());
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008);
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X80064F9", "0X80064F9", 0, 0, (String)localObject, "1", "", "");
    return;
    axio.a().b((List)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "checklist.size = " + ((List)localObject).size());
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + ((List)localObject).size(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008)
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X80064F9", "0X80064F9", 0, 0, str, "0", "", "");
    }
    admh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localImageView.setId(2131364574);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.c) {
      localImageView.setContentDescription(anvx.a(2131700466));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839484);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839484);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(15);
    agjz localagjz = (agjz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(40);
    if (!localAIOLongShotHelper.a()) {
      localagjz.b();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAppShortcutBar();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.c.setId(2131364573);
    if (AppSetting.c) {
      this.c.setContentDescription(anvx.a(2131700476));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839431);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839432);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839431);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.c.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int n = 0;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getResources().getDimensionPixelSize(2131299080) - 5;
    int i2 = ViewUtils.dpToPx(28.0F);
    paramChatMessage = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getAIORootView().findViewById(2131364488);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOMultiActionHelper", 2, "createMulti");
    }
    int i4 = i3 / 37;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      localObject = new RelativeLayout.LayoutParams(-1, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidViewView.setFocusable(true);
      this.jdField_a_of_type_AndroidViewView.setContentDescription("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      }
      paramChatMessage.addView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localObject = new RelativeLayout.LayoutParams(-1, i1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).setMargins(i4, 0, i4, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramChatMessage.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362439);
    Object localObject = (agjz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(40);
    ((agjz)localObject).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, i1, paramChatMessage);
    paramChatMessage = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(15);
    if (paramChatMessage.a())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isThemeDefault) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.setTitleLeftText("");
      }
      ((agjz)localObject).a();
      paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      ((aglh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(53)).b();
      i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167146);
      if (paramChatMessage.a()) {
        i = Color.parseColor("#313546");
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      a();
      return;
    }
    boolean bool1;
    label434:
    boolean bool2;
    label450:
    boolean bool3;
    label466:
    boolean bool4;
    label482:
    boolean bool5;
    label498:
    label505:
    int j;
    label512:
    int k;
    label520:
    int m;
    if (AIOUtils.getAIOMsgMenuDpcConfig(1) == 0)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
        break label603;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
        break label609;
      }
      bool3 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
        break label615;
      }
      bool4 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008) {
        break label621;
      }
      bool5 = true;
      if (!bool1) {
        break label627;
      }
      i = 1;
      if (!bool3) {
        break label632;
      }
      j = 1;
      if (!bool2) {
        break label637;
      }
      k = 1;
      if (!bool4) {
        break label643;
      }
      m = 1;
      label528:
      if (bool5) {
        n = 1;
      }
      j = n + (m + (i + 1 + j + k));
      if (j != 1) {
        break label649;
      }
    }
    label643:
    label649:
    for (int i = (i3 - i4 * 2 - i2) / 2;; i = (i3 - i4 * 2 - i2 * j) / (j - 1))
    {
      a(i2, bool1, bool2, bool3, bool4, bool5, j, i, i1 * 3 / 20);
      break;
      bool1 = false;
      break label434;
      label603:
      bool2 = false;
      break label450;
      label609:
      bool3 = false;
      break label466;
      label615:
      bool4 = false;
      break label482;
      label621:
      bool5 = false;
      break label498;
      label627:
      i = 0;
      break label505;
      label632:
      j = 0;
      break label512;
      label637:
      k = 0;
      break label520;
      m = 0;
      break label528;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.setEnabled(paramBoolean);
    }
  }
  
  public int[] a()
  {
    return new int[0];
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    ((agjz)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(40)).a();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.resumeAppShorcutBar();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.b.setId(2131364570);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    if (AppSetting.c) {
      this.b.setContentDescription(anvx.a(2131700456));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839421);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.b.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      d();
      continue;
      c();
      continue;
      int i = axio.a().c();
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", axcx.d, axcx.d, 0, i, "", "", "", "");
      ((agiw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(1)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.listAdapter, false);
      continue;
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      if (localAIOLongShotHelper != null)
      {
        localAIOLongShotHelper.a(paramView);
        continue;
        ((agiw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(1)).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggf
 * JD-Core Version:    0.7.0.1
 */