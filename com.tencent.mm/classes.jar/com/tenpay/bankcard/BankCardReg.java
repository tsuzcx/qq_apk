package com.tenpay.bankcard;

import com.tencent.bankcardrecog.BankCardInfo;
import com.tencent.bankcardrecog.BankCardRecog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardReg
{
  private static final String TAG = "MyTag";
  
  public static String getBankCardSegmentNumber(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(73264);
    LogUtil.d("MyTag", new Object[] { "getBankCardSegmentNumber" });
    LogUtil.d("MyTag", new Object[] { "cardNum=".concat(String.valueOf(paramString)) });
    Encrypt localEncrypt = new Encrypt();
    paramString = localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey());
    LogUtil.d("MyTag", new Object[] { "cardNum=".concat(String.valueOf(paramString)) });
    paramString = BankCardRecog.getBankCardSegmentNumber(paramString, paramInt, paramArrayOfInt);
    LogUtil.d("MyTag", new Object[] { paramString });
    paramString = localEncrypt.desedeEncode(paramString, localEncrypt.getRandomKey());
    AppMethodBeat.o(73264);
    return paramString;
  }
  
  public static int recognizeBankCardGetVersion()
  {
    AppMethodBeat.i(73266);
    int i = BankCardRecog.recognizeBankCardGetVersion();
    AppMethodBeat.o(73266);
    return i;
  }
  
  public static int recognizeBankCardInit(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(73262);
    paramInt1 = BankCardRecog.recognizeBankCardInit(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(73262);
    return paramInt1;
  }
  
  public static int recognizeBankCardProcess(byte[] paramArrayOfByte, BankCardInfo paramBankCardInfo, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(73263);
    int i = BankCardRecog.recognizeBankCardProcess(paramArrayOfByte, paramBankCardInfo, paramArrayOfBoolean);
    AppMethodBeat.o(73263);
    return i;
  }
  
  public static int recognizeBankCardRelease()
  {
    AppMethodBeat.i(73265);
    int i = BankCardRecog.recognizeBankCardRelease();
    AppMethodBeat.o(73265);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.bankcard.BankCardReg
 * JD-Core Version:    0.7.0.1
 */