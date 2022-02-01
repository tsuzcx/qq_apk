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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class agkg
  implements agma, View.OnClickListener
{
  protected View a;
  protected ImageView a;
  protected LinearLayout a;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  protected ImageView b;
  protected ImageView c;
  protected ImageView d;
  
  public agkg(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.a();
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131364426);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131699772));
      }
      localObject = new StateListDrawable();
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839340);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839341);
      ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      if (paramBoolean1) {
        b(paramInt1, paramInt3);
      }
      if (paramBoolean3) {
        a(paramInt1, paramInt3);
      }
      ((agmg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(11)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean4, paramInt1, paramInt1, paramInt3, paramInt4);
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
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
    if (!bgnt.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131691985, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      return;
    }
    Object localObject3 = awwm.a().a();
    if (((List)localObject3).size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697668, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
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
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697668, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
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
      localObject2 = bdzx.a(bdzx.a((ayye)localObject1, 1), -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      ahth.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131298998), null, null);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(false, null, false);
      return;
      if ((localObject1 instanceof MessageForMarketFace))
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
        localObject3 = (MessageForMarketFace)localObject1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Biau;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Biau != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Biau.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691744));
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Biau.show();
        }
        localObject2 = ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((MessageForMarketFace)localObject3).mMarkFaceMessage);
        EmoticonPackage localEmoticonPackage = ((awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(((asbq)localObject2).a.epId);
        ahch.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject3;
        ahch.jdField_a_of_type_Asbq = (asbq)localObject2;
        if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
          int j = (int)(System.currentTimeMillis() / 1000L);
          if ((j - i > 86400) || (j < i))
          {
            localObject3 = new ahct();
            ((ahct)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (asbq)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (biau)localObject1);
            aruo.a().a((arvd)localObject3);
            ((arup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(((asbq)localObject2).a.epId, arup.c);
          }
          else
          {
            ahch.a(6, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, (asbq)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (biau)localObject1);
          }
        }
        else
        {
          localObject3 = new ahct();
          ((ahct)localObject3).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (asbq)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (biau)localObject1);
          aruo.a().a((arvd)localObject3);
          ((arup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(((asbq)localObject2).a.epId, arup.c);
        }
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.d = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.d.setId(2131364430);
    if (AppSetting.c) {
      this.d.setContentDescription(anni.a(2131699797));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.d.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839302);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839302);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.d.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.d);
  }
  
  private void d()
  {
    int i = awwm.a().c();
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", awqv.c, awqv.c, 0, i, "", "", "", "");
    if ((adrm.b != null) && (adrm.b.isShowing())) {}
    do
    {
      return;
      localObject = awwm.a().a();
      if (((List)localObject).size() != 0) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697668, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008);
    Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject, "1", "", "");
    return;
    awwm.a().b((List)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "checklist.size = " + ((List)localObject).size());
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + ((List)localObject).size(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, str, "0", "", "");
    }
    adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localImageView.setId(2131364429);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView.setOnClickListener(this);
    if (AppSetting.c) {
      localImageView.setContentDescription(anni.a(2131699773));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839420);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
    agnc localagnc = (agnc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(40);
    if (!localAIOLongShotHelper.a()) {
      localagnc.b();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aw();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.c.setId(2131364428);
    if (AppSetting.c) {
      this.c.setContentDescription(anni.a(2131699783));
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(this);
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839367);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839368);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839367);
    ((StateListDrawable)localObject).addState(new int[0], localDrawable);
    this.c.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int n = 0;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext().getResources().getDimensionPixelSize(2131298998) - 5;
    int i2 = bgtn.b(28.0F);
    paramChatMessage = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().findViewById(2131364345);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362414);
    Object localObject = (agnc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(40);
    ((agnc)localObject).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, i1, paramChatMessage);
    paramChatMessage = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
    if (paramChatMessage.a())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.H) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f("");
      }
      ((agnc)localObject).a();
      paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      ((agnw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(53)).b();
      i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167100);
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
    if (afur.a(1) == 0)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label603;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label609;
      }
      bool3 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label615;
      }
      bool4 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
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
    ((agnc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(40)).a();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.av();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.b.setId(2131364425);
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
    ((LinearLayout.LayoutParams)localObject).setMargins(paramInt2, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    if (AppSetting.c) {
      this.b.setContentDescription(anni.a(2131699763));
    }
    localObject = new StateListDrawable();
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839356);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839357);
    ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable);
    localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130839356);
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
      int i = awwm.a().c();
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", awqv.d, awqv.d, 0, i, "", "", "", "");
      ((agmj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Afwy, false);
      continue;
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      if (localAIOLongShotHelper != null)
      {
        localAIOLongShotHelper.a(paramView);
        continue;
        ((agmj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(1)).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkg
 * JD-Core Version:    0.7.0.1
 */