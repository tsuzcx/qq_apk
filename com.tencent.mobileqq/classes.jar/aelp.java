import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class aelp
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
    if (paramInt == 21) {
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
  
  public static aekw a(QQAppInterface paramQQAppInterface, aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvf paramacvf)
  {
    switch (paramInt)
    {
    default: 
      return new aekr(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 1: 
      return new aeky(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 5: 
      return new aekz(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 2: 
      return new aelr(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 3: 
      return new aelo(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 4: 
      return new aelq(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 6: 
      return new aelm(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 7: 
      return new aeku(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 8: 
      return new aekx(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 9: 
      return new aekt(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 10: 
      return new aell(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    case 11: 
      return new aeks(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    }
    return new aekv(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelp
 * JD-Core Version:    0.7.0.1
 */