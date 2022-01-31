import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class aelr
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
  
  public static aeky a(QQAppInterface paramQQAppInterface, aell paramaell, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvj paramacvj)
  {
    switch (paramInt)
    {
    default: 
      return new aekt(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 1: 
      return new aela(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 5: 
      return new aelb(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 2: 
      return new aelt(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 3: 
      return new aelq(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 4: 
      return new aels(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 6: 
      return new aelo(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 7: 
      return new aekw(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 8: 
      return new aekz(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 9: 
      return new aekv(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 10: 
      return new aeln(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    case 11: 
      return new aeku(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    }
    return new aekx(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelr
 * JD-Core Version:    0.7.0.1
 */