import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class agmv
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
  
  public static agmc a(QQAppInterface paramQQAppInterface, agmp paramagmp, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aere paramaere)
  {
    switch (paramInt)
    {
    default: 
      return new aglx(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 1: 
      return new agme(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 5: 
      return new agmf(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 2: 
      return new agmx(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 3: 
      return new agmu(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 4: 
      return new agmw(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 6: 
      return new agms(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 7: 
      return new agma(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 8: 
      return new agmd(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 9: 
      return new aglz(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 10: 
      return new agmr(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    case 11: 
      return new agly(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    }
    return new agmb(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmv
 * JD-Core Version:    0.7.0.1
 */