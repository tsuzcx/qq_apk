import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class agig
{
  public static int a(int paramInt)
  {
    int i = 5;
    QLog.i("ViewHolderFactory", 2, "CFT-debug messageType = " + paramInt);
    if (paramInt == 6) {
      i = 1;
    }
    while (paramInt == 14) {
      return i;
    }
    if ((paramInt == 13) || (paramInt == 15)) {
      return 2;
    }
    if ((paramInt == 4) || (paramInt == 5)) {
      return 3;
    }
    if (paramInt == 2001) {
      return 4;
    }
    if ((paramInt == 7) || (paramInt == 8) || (paramInt == 11) || (paramInt == 12)) {
      return 6;
    }
    if (paramInt == 2002) {
      return 7;
    }
    if (paramInt == 18) {
      return 8;
    }
    if (paramInt == 19) {
      return 9;
    }
    if ((paramInt == 21) || (paramInt == 24)) {
      return 10;
    }
    if (paramInt == 22) {
      return 11;
    }
    if (paramInt == 23) {
      return 12;
    }
    return 0;
  }
  
  public static aghn a(QQAppInterface paramQQAppInterface, agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aemp paramaemp)
  {
    switch (paramInt)
    {
    default: 
      return new aghi(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 1: 
      return new aghp(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 5: 
      return new aghq(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 2: 
      return new agii(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 3: 
      return new agif(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 4: 
      return new agih(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 6: 
      return new agid(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 7: 
      return new aghl(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 8: 
      return new agho(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 9: 
      return new aghk(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 10: 
      return new agic(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    case 11: 
      return new aghj(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    }
    return new aghm(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agig
 * JD-Core Version:    0.7.0.1
 */