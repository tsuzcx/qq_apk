package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tenpay.ndk.Encrypt;

public class BankCardReg
{
  private static final String TAG = "MyTag";
  
  public static String getBankCardSegmentNumber(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    LogUtil.d("MyTag", new Object[] { "getBankCardSegmentNumber" });
    LogUtil.d("MyTag", new Object[] { "cardNum=" + paramString });
    Encrypt localEncrypt = new Encrypt();
    paramString = localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey());
    LogUtil.d("MyTag", new Object[] { "cardNum=" + paramString });
    paramString = BankCardRecog.getBankCardSegmentNumber(paramString, paramInt, paramArrayOfInt);
    LogUtil.d("MyTag", new Object[] { paramString });
    return localEncrypt.desedeEncode(paramString, localEncrypt.getRandomKey());
  }
  
  public static int recognizeBankCardGetVersion()
  {
    return BankCardRecog.recognizeBankCardGetVersion();
  }
  
  public static int recognizeBankCardInit(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return BankCardRecog.recognizeBankCardInit(paramInt1, paramInt2, paramBoolean);
  }
  
  public static int recognizeBankCardProcess(byte[] paramArrayOfByte, BankCardInfo paramBankCardInfo, boolean[] paramArrayOfBoolean)
  {
    return BankCardRecog.recognizeBankCardProcess(paramArrayOfByte, paramBankCardInfo, paramArrayOfBoolean);
  }
  
  public static int recognizeBankCardRelease()
  {
    return BankCardRecog.recognizeBankCardRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tenpay.bankcard.BankCardReg
 * JD-Core Version:    0.7.0.1
 */