import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;

public class ahdf
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
  
  public static ahck a(QQAppInterface paramQQAppInterface, ahcz paramahcz, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afaf paramafaf)
  {
    switch (paramInt)
    {
    case 13: 
    default: 
      return new ahcf(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 1: 
      return new ahcn(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 5: 
      return new ahco(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 2: 
      return new ahdh(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 3: 
      return new ahde(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 4: 
      return new ahdg(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 6: 
      return new ahdc(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 7: 
      return new ahci(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 8: 
      return new ahcl(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 9: 
      return new ahch(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 10: 
      return new ahdb(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 11: 
      return new ahcg(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    case 12: 
      return new ahcj(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    }
    return new ahcm(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdf
 * JD-Core Version:    0.7.0.1
 */