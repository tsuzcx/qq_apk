import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import org.json.JSONObject;

public class aekr
  implements aekw
{
  protected int a;
  protected long a;
  protected acvf a;
  public aelj a;
  protected Context a;
  protected CustomizeStrategyFactory.RedPacketInfo a;
  protected QQAppInterface a;
  public MessageForQQWalletMsg a;
  public QQWalletRedPacketMsg a;
  public QQWalletTransferMsgElem a;
  protected boolean a;
  protected int b;
  protected CustomizeStrategyFactory.RedPacketInfo b;
  boolean b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j = 2130846326;
  protected int k;
  
  public aekr(QQAppInterface paramQQAppInterface, aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvf paramacvf)
  {
    this.jdField_a_of_type_Long = bbdh.i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aelj = paramaelj;
    this.jdField_a_of_type_AndroidContentContext = paramaelj.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem = paramQQWalletTransferMsgElem;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)paramaelj.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
    this.k = paramInt;
    this.jdField_a_of_type_Acvf = paramacvf;
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(160.0F * f1 + 0.5F));
    this.jdField_b_of_type_Int = ((int)(240.0F * f1 + 0.5F));
    this.c = ((int)(90.0F * f1 + 0.5F));
    this.d = ((int)(17.0F * f1 + 0.5F));
    this.e = ((int)(40.0F * f1 + 0.5F));
    this.g = ((int)(f1 * 24.0F + 0.5F));
    this.f = (this.jdField_a_of_type_Int - this.d);
    this.h = paramQQWalletTransferMsgElem.skinId;
    this.i = paramQQWalletTransferMsgElem.effectsId;
    this.jdField_b_of_type_Boolean = c();
    if (this.jdField_b_of_type_Boolean) {
      this.i = 0;
    }
    this.jdField_a_of_type_Boolean = RedPacketManager.getInstance().isRiskSwitchOpen();
    if (QLog.isColorLevel()) {
      QLog.d("BaseViewHolder", 2, "isRedPacketOpened=" + this.jdField_b_of_type_Boolean + ",isRiskWritchOpen=" + this.jdField_a_of_type_Boolean + ",skinId=" + this.h + ",effectsId=" + this.i + ",elem=" + paramQQWalletTransferMsgElem + ",qqWalletMsg=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.h = 0;
      this.i = 0;
    }
    do
    {
      return;
      if (this.h > 0)
      {
        localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
        localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        localRedPacketInfo.type = 5;
        localRedPacketInfo.skinId = this.h;
        localRedPacketInfo.skinType = 1;
        localRedPacketInfo.isHideTitle = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.getIsHideTitleDefault();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_Acvf);
      }
    } while ((this.i <= 0) || (this.jdField_a_of_type_Long <= 720L));
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
    localRedPacketInfo.jdField_a_of_type_Long = System.currentTimeMillis();
    localRedPacketInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
    localRedPacketInfo.type = 5;
    localRedPacketInfo.bigAnimId = this.i;
    localRedPacketInfo.skinType = 3;
    this.jdField_b_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_Acvf);
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.icon != null))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.e, this.e);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.icon);
      this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView, localLayoutParams);
      return true;
    }
    return false;
  }
  
  protected boolean a(agvw paramagvw)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramagvw == null);
        if (paramagvw.jdField_a_of_type_Boolean) {
          return true;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop != 1);
      bool1 = bool2;
    } while (ahbc.a(2, paramagvw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) == null);
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.c == null)) {}
    Object localObject2;
    do
    {
      return;
      try
      {
        Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aelj.c.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.jdField_a_of_type_Int;
        ((RelativeLayout.LayoutParams)localObject1).height = this.jdField_b_of_type_Int;
        localObject2 = this.jdField_a_of_type_Aelj.c.getChildAt(0);
        localObject1 = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130846317);
        if (!(localObject2 instanceof RoundImageView)) {
          break label193;
        }
        localObject2 = (RoundImageView)localObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background == null)) {
          break;
        }
        ((RoundImageView)localObject2).setmRadius(0, false);
        ((RoundImageView)localObject2).setImageDrawable(QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background, (Drawable)localObject1));
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("BaseViewHolder", 1, "handleBackgroud throw exception: " + localThrowable.getLocalizedMessage());
    return;
    if (Build.VERSION.SDK_INT >= 18) {
      ((RoundImageView)localObject2).setmRadius(vzl.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), false);
    }
    ((RoundImageView)localObject2).setImageDrawable(localThrowable);
    return;
    label193:
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background != null))
    {
      Drawable localDrawable = QWalletPicHelper.getDrawableForAIO(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background, localThrowable);
      if (Build.VERSION.SDK_INT < 16)
      {
        this.jdField_a_of_type_Aelj.c.setBackgroundDrawable(localDrawable);
        return;
      }
      this.jdField_a_of_type_Aelj.c.setBackground(localDrawable);
      return;
    }
    this.jdField_a_of_type_Aelj.c.setBackgroundResource(2130846317);
  }
  
  public boolean b()
  {
    String str1 = null;
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView == null)) {
      return false;
    }
    this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
    this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setTag(null);
    String str2;
    String str3;
    if (!this.jdField_a_of_type_Boolean)
    {
      JSONObject localJSONObject = RedPacketManager.getInstance().getTail(this.h, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.messageType);
      if (localJSONObject == null) {
        break label220;
      }
      str2 = localJSONObject.optString("word", "");
      str3 = localJSONObject.optString("color", "");
      str1 = localJSONObject.optString("url", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2)) {
        if (TextUtils.isEmpty(str3)) {}
      }
      for (;;)
      {
        try
        {
          m = Color.parseColor(str3);
          this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setTag(str1);
          }
          this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
          m = 1;
          if (m != 0) {
            return true;
          }
          this.jdField_a_of_type_Aelj.jdField_b_of_type_AndroidWidgetTextView.setText("QQ红包");
          return false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          continue;
        }
        int m = 0;
      }
      label220:
      Object localObject = null;
      str2 = null;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.g == null)) {}
    while (this.jdField_a_of_type_Aelj.g.getChildCount() == 0) {
      return;
    }
    this.jdField_a_of_type_Aelj.g.removeAllViews();
  }
  
  protected boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg == null)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.isOpened) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop == 1) && (ahbc.a(2, this.jdField_a_of_type_ComTencentMobileqqDataQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg) != null))) {
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).topMargin = this.e;
    } while (this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0);
    this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public void e()
  {
    d();
    if (!a())
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.e, this.e);
      localLayoutParams.gravity = 17;
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setImageResource(this.j);
      this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localImageView, localLayoutParams);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.isHideTitle == 1) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView.setText("");
        return;
      }
      int n = bbkk.a(this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title);
      int m = 18;
      if (n <= 8)
      {
        n = this.f / 4;
        m = n;
        if (n > this.g) {
          m = this.g;
        }
        m = baxn.b(this.jdField_a_of_type_AndroidContentContext, m);
      }
      this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView.setTextSize(m);
      this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title);
      return;
    }
    this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView == null) || (this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.stop();
      this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.stop();
      if (this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_Aelj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(8);
      this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(8);
      AnimationView.Player localPlayer = this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getPlayer();
      if ((localPlayer instanceof aelk)) {
        ((aelk)localPlayer).a(this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView);
      }
      localPlayer = this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.getPlayer();
      if ((localPlayer instanceof aelk)) {
        ((aelk)localPlayer).a(this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo != null))
      {
        this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(0);
        this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationFromInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo);
        this.jdField_a_of_type_Aelj.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.play();
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo == null));
    this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.setVisibility(0);
    this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationFromInfo(this.jdField_b_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo);
    this.jdField_a_of_type_Aelj.jdField_b_of_type_ComTencentMobileqqWidgetAnimationView.play();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.f == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Aelj.f.setVisibility(8);
    } while (this.jdField_a_of_type_Aelj.f.getChildCount() <= 0);
    this.jdField_a_of_type_Aelj.f.removeAllViews();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Aelj == null) || (this.jdField_a_of_type_Aelj.d == null)) {
      return;
    }
    if (!c())
    {
      this.jdField_a_of_type_Aelj.d.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Aelj.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekr
 * JD-Core Version:    0.7.0.1
 */