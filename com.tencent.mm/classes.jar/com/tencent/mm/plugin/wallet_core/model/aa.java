package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.model.bx.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class aa
{
  static ArrayList<j> jOT = null;
  private static aa qyF = null;
  bx.a iGD = new aa.1(this);
  
  public static boolean a(j paramj)
  {
    if (paramj == null)
    {
      y.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
      return false;
    }
    if (jOT == null) {
      jOT = new ArrayList();
    }
    jOT.add(paramj);
    return true;
  }
  
  public static boolean b(j paramj)
  {
    if (jOT == null)
    {
      y.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      return false;
    }
    jOT.remove(paramj);
    return true;
  }
  
  public static aa bVC()
  {
    if (qyF == null) {
      qyF = new aa();
    }
    return qyF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa
 * JD-Core Version:    0.7.0.1
 */