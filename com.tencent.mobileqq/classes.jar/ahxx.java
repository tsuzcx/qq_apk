import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;

public class ahxx
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
    if ((paramInt == 21) || (paramInt == 24) || (paramInt == 25) || (paramInt == 27)) {
      return 10;
    }
    if ((paramInt == 22) || (paramInt == 26)) {
      return 11;
    }
    if (paramInt == 23) {
      return 12;
    }
    if (paramInt == 28) {
      return 14;
    }
    return 0;
  }
  
  public static ahxc a(QQAppInterface paramQQAppInterface, ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afrr paramafrr)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return new ahwx(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 1: 
      return new ahxf(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 5: 
      return new ahxg(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 2: 
      return new ahxz(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 3: 
      return new ahxw(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 4: 
      return new ahxy(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 6: 
      return new ahxu(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 7: 
      return new ahxa(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 8: 
      return new ahxd(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 9: 
      return new ahwz(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 10: 
      return new ahxt(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 11: 
      return new ahwy(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    case 12: 
      return new ahxb(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    }
    return new ahxe(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxx
 * JD-Core Version:    0.7.0.1
 */