import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.qphone.base.util.QLog;

public class aigq
  extends aifp
{
  aoan a;
  
  public aigq(QQAppInterface paramQQAppInterface, aigj paramaigj, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, aghj paramaghj)
  {
    super(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    this.jdField_a_of_type_Aoan = ((aoan)paramQQAppInterface.getManager(131));
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aigj.b.setVisibility(0);
    this.jdField_a_of_type_Aigj.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aigj.b.setText(aifu.g);
    return false;
  }
  
  public void g()
  {
    super.g();
    if (this.h > 0) {
      return;
    }
    if (this.jdField_a_of_type_Aoan != null) {}
    for (boolean bool = this.jdField_a_of_type_Aoan.c();; bool = false)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (bool) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        bdll.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006133", "0X8006133", 0, 0, (String)localObject1, "0", "", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg;
        if ((!bool) || (((QQWalletRedPacketMsg)localObject1).envelopeid == 0)) {
          break;
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend();
        localObject2 = new CustomizeStrategyFactory.RedPacketInfo();
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_Boolean = bool;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).type = 2;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).templateId = (((QQWalletRedPacketMsg)localObject1).envelopeid + "");
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_JavaLangString = ((QQWalletRedPacketMsg)localObject1).envelopeName;
        ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_Int = ((QQWalletRedPacketMsg)localObject1).conftype;
        if (QLog.isColorLevel()) {
          QLog.d("VipRedPkgViewHolder", 2, "info =" + ((CustomizeStrategyFactory.RedPacketInfo)localObject2).type + "|" + ((CustomizeStrategyFactory.RedPacketInfo)localObject2).templateId + "|" + ((CustomizeStrategyFactory.RedPacketInfo)localObject2).jdField_a_of_type_JavaLangString + "|" + System.currentTimeMillis());
        }
        localObject1 = CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (CustomizeStrategyFactory.RedPacketInfo)localObject2, this.jdField_a_of_type_Aghj);
        if (QLog.isColorLevel()) {
          QLog.d("VipRedPkgViewHolder", 2, "getHBCustomizeBackground redPacketInfo=" + localObject1);
        }
        if (localObject1 == null) {
          break;
        }
        if (!((CustomizeStrategyFactory.RedPacketInfo)localObject1).a()) {
          break label433;
        }
        this.jdField_a_of_type_Aigj.a.setVisibility(0);
        localObject2 = new AnimationDrawable();
        Drawable[] arrayOfDrawable = ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
        int j = arrayOfDrawable.length;
        int i = 0;
        while (i < j)
        {
          Drawable localDrawable = arrayOfDrawable[i];
          if (localDrawable != null) {
            ((AnimationDrawable)localObject2).addFrame(localDrawable, ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_Aghh.b);
          }
          i += 1;
        }
      }
      if (Build.VERSION.SDK_INT < 16) {
        this.jdField_a_of_type_Aigj.a.setBackgroundDrawable((Drawable)localObject2);
      }
      for (;;)
      {
        ((AnimationDrawable)localObject2).setOneShot(false);
        ((AnimationDrawable)localObject2).start();
        return;
        this.jdField_a_of_type_Aigj.a.setBackground((Drawable)localObject2);
      }
      label433:
      if (((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break;
      }
      this.jdField_a_of_type_Aigj.a.setVisibility(0);
      localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((CustomizeStrategyFactory.RedPacketInfo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap);
      if (Build.VERSION.SDK_INT < 16)
      {
        this.jdField_a_of_type_Aigj.a.setBackgroundDrawable((Drawable)localObject1);
        return;
      }
      this.jdField_a_of_type_Aigj.a.setBackground((Drawable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigq
 * JD-Core Version:    0.7.0.1
 */