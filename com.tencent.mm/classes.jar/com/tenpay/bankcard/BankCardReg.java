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
    AppMethodBeat.i(49516);
    LogUtil.d("MyTag", new Object[] { "getBankCardSegmentNumber" });
    LogUtil.d("MyTag", new Object[] { "cardNum=".concat(String.valueOf(paramString)) });
    Encrypt localEncrypt = new Encrypt();
    paramString = localEncrypt.desedeDecode(paramString, localEncrypt.getRandomKey());
    LogUtil.d("MyTag", new Object[] { "cardNum=".concat(String.valueOf(paramString)) });
    paramString = BankCardRecog.getBankCardSegmentNumber(paramString, paramInt, paramArrayOfInt);
    LogUtil.d("MyTag", new Object[] { paramString });
    paramString = localEncrypt.desedeEncode(paramString, localEncrypt.getRandomKey());
    AppMethodBeat.o(49516);
    return paramString;
  }
  
  public static int recognizeBankCardGetVersion()
  {
    AppMethodBeat.i(49518);
    int i = BankCardRecog.recognizeBankCardGetVersion();
    AppMethodBeat.o(49518);
    return i;
  }
  
  public static int recognizeBankCardInit(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(49514);
    paramInt1 = BankCardRecog.recognizeBankCardInit(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(49514);
    return paramInt1;
  }
  
  public static int recognizeBankCardProcess(byte[] paramArrayOfByte, BankCardInfo paramBankCardInfo, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(49515);
    int i = BankCardRecog.recognizeBankCardProcess(paramArrayOfByte, paramBankCardInfo, paramArrayOfBoolean);
    AppMethodBeat.o(49515);
    return i;
  }
  
  public static int recognizeBankCardRelease()
  {
    AppMethodBeat.i(49517);
    int i = BankCardRecog.recognizeBankCardRelease();
    AppMethodBeat.o(49517);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tenpay.bankcard.BankCardReg
 * JD-Core Version:    0.7.0.1
 */