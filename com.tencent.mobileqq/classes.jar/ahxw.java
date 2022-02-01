import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;

public class ahxw
  extends ahwx
{
  akyy a;
  int l = 0;
  int m = 0;
  
  public ahxw(QQAppInterface paramQQAppInterface, ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afrr paramafrr)
  {
    super(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    this.jdField_a_of_type_Akyy = null;
    this.h = 0;
    this.m = paramQQWalletBaseMsgElem.themeId;
  }
  
  public void a()
  {
    super.a();
    String str;
    int i;
    if ((this.m > 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo == null))
    {
      this.jdField_a_of_type_Akyy = ((RedPacketManager)RedPacketManager.getInstance()).getThemeRedPkgConfById(this.m);
      if ((this.jdField_a_of_type_Akyy != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Akyy.c)))
      {
        str = this.jdField_a_of_type_Akyy.c;
        CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
        localRedPacketInfo.a = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        if (this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.resourceType != 1) {
          break label171;
        }
        i = 4;
        label93:
        localRedPacketInfo.type = i;
        localRedPacketInfo.templateId = str;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRedPacketInfo, this.jdField_a_of_type_Afrr);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.animInfo == null) {
        break label176;
      }
      this.l = 2;
    }
    label171:
    label176:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.background == null)
    {
      return;
      str = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_" + this.m;
      break;
      i = 1;
      break label93;
    }
    this.l = 1;
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Ahxr.b.setVisibility(0);
    this.jdField_a_of_type_Ahxr.b.setTextColor(-8947849);
    if ((this.jdField_a_of_type_Akyy != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Akyy.e)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Akyy.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Akyy.f))) {}
    try
    {
      int i = Color.parseColor(this.jdField_a_of_type_Akyy.e);
      this.jdField_a_of_type_Ahxr.b.setTextColor(i);
      label91:
      this.jdField_a_of_type_Ahxr.b.setText(this.jdField_a_of_type_Akyy.d);
      this.jdField_a_of_type_Ahxr.b.setTag(this.jdField_a_of_type_Akyy.f);
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Ahxr.b.setText(ahxc.h);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label91;
    }
  }
  
  public void e()
  {
    if (this.l == 1)
    {
      d();
      return;
    }
    super.e();
  }
  
  public void f()
  {
    if (this.l > 0)
    {
      this.jdField_a_of_type_Ahxr.a.setVisibility(8);
      return;
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxw
 * JD-Core Version:    0.7.0.1
 */