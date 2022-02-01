import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;

public class aigp
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
  
  public static aifu a(QQAppInterface paramQQAppInterface, aigj paramaigj, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, aghj paramaghj)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return new aifp(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 1: 
      return new aifx(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 5: 
      return new aify(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 2: 
      return new aigr(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 3: 
      return new aigo(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 4: 
      return new aigq(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 6: 
      return new aigm(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 7: 
      return new aifs(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 8: 
      return new aifv(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 9: 
      return new aifr(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 10: 
      return new aigl(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 11: 
      return new aifq(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    case 12: 
      return new aift(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    }
    return new aifw(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigp
 * JD-Core Version:    0.7.0.1
 */