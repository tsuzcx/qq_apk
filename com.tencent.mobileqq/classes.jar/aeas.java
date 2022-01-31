import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class aeas
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
  
  public static adzz a(QQAppInterface paramQQAppInterface, aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, ackq paramackq)
  {
    switch (paramInt)
    {
    default: 
      return new adzu(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 1: 
      return new aeab(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 5: 
      return new aeac(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 2: 
      return new aeau(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 3: 
      return new aear(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 4: 
      return new aeat(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 6: 
      return new aeap(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 7: 
      return new adzx(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 8: 
      return new aeaa(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 9: 
      return new adzw(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 10: 
      return new aeao(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    case 11: 
      return new adzv(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    }
    return new adzy(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeas
 * JD-Core Version:    0.7.0.1
 */