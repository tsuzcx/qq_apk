package com.tencent.mm.sensitive;

import android.app.Activity;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public abstract interface d
  extends a
{
  public abstract boolean checkAndShowPermissionDialog(c paramc, a parama, f paramf);
  
  public abstract boolean checkAndShowPermissionDialog(c paramc, f paramf);
  
  public abstract boolean checkBusinessPermission(c paramc, a parama);
  
  public abstract String dumpSwitchStatus();
  
  public abstract Pair<Integer, Integer> getPermissionBusinessDesc(String paramString1, String paramString2);
  
  public abstract String getPermissionBusinessTitle(String paramString1, String paramString2);
  
  public abstract MultiProcessMMKV getPermissionConfigMMkv(String paramString);
  
  public abstract Integer getPermissionDefaultDesc(String paramString);
  
  public abstract Integer getPermissionIcon(String paramString);
  
  public abstract String getPermissionWxTitle(String paramString);
  
  public abstract boolean isFrequencyLimit(String paramString1, String paramString2);
  
  public abstract d isPermissionGranted(Activity paramActivity, String paramString, int paramInt);
  
  public abstract boolean isUsingOldPermissionDialog();
  
  public abstract void markEnterBusiness(String paramString);
  
  public abstract void markExitBusiness(String paramString);
  
  public abstract void openBusinessSwitchOnPermissionGranted(c paramc);
  
  public abstract void requestPermission(Activity paramActivity, String paramString1, String paramString2, int paramInt, g paramg);
  
  public static enum a
  {
    public Boolean acts = Boolean.FALSE;
    public int qDL = -1;
    public String value = "";
    
    static
    {
      AppMethodBeat.i(240997);
      acsJ = new a("CHATTING", 0, "chatting", 1);
      acsK = new a("RADAR", 1, "radar", 2);
      acsL = new a("FACE2FACE_GROUP", 2, "face2face_group", 3);
      acsM = new a("SNS", 3, "sns", 5);
      acsN = new a("FINDER", 4, "finder", 6);
      acsO = new a("LIVE", 5, "live", 7);
      acsP = new a("SCAN", 6, "scan", 8);
      acsQ = new a("SHAKE", 7, "shake", 9);
      acsR = new a("STORY", 8, "story", 10);
      acsS = new a("SEARCH", 9, "search", 11);
      acsT = new a("NEARBY", 10, "nearby", 12);
      acsU = new a("GAME", 11, "game", 13);
      acsV = new a("NEARBY_APPBRAND", 12, "nearby_appbrand", 14);
      acsW = new a("MINE", 13, "mine", 15);
      acsX = new a("STATUS", 14, "status", 16);
      acsY = new a("FAV", 15, "fav", 17);
      acsZ = new a("CARD", 16, "card", 18);
      acta = new a("MUSICPLAYER", 17, "musicplayer", 21);
      actb = new a("NET_CHECK", 18, "net_check", -1);
      actc = new a("WIFI_INFO", 19, "wifi_info", 24);
      actd = new a("PAY", 20, "pay", 45, Boolean.FALSE);
      acte = new a("BIZ", 21, "biz", 43);
      actf = new a("WEBVIEW", 22, "webview", 41, Boolean.FALSE);
      actg = new a("CONTACT", 23, "contact", -1);
      acth = new a("EMOJI", 24, "emoji", 19);
      acti = new a("SPORT", 25, "sport", 20);
      actj = new a("MAIL", 26, "mail", 22);
      actk = new a("VOICE_PRINT", 27, "voiceprint", 23);
      actl = new a("ADD_CONTACT", 28, "add_contact", 4);
      actm = new a("CONTACT_REMARK", 29, "contact_remark", 28);
      actn = new a("WECHAT_OUT", 30, "wechatout", 26);
      acto = new a("SAVE_FILE", 31, "savefile", 25);
      actp = new a("APPBRAND", 32, "appbrand", 42, Boolean.FALSE);
      actq = new a("APPBRAND_FAKE_NATIVE_DEFAULT", 33, "appbrand_fake_native", 46);
      actr = new a("OLYMPIC", 34, "olympic", 29);
      actt = new a[] { acsJ, acsK, acsL, acsM, acsN, acsO, acsP, acsQ, acsR, acsS, acsT, acsU, acsV, acsW, acsX, acsY, acsZ, acta, actb, actc, actd, acte, actf, actg, acth, acti, actj, actk, actl, actm, actn, acto, actp, actq, actr };
      AppMethodBeat.o(240997);
    }
    
    private a(String paramString, int paramInt)
    {
      this.value = paramString;
      this.qDL = paramInt;
    }
    
    private a(String paramString, int paramInt, Boolean paramBoolean)
    {
      this.value = paramString;
      this.qDL = paramInt;
      this.acts = paramBoolean;
    }
  }
  
  public static abstract class b
    extends CameraDevice.StateCallback
  {
    public abstract void btB();
  }
  
  public static enum c
  {
    public int qDL = -1;
    public String value = "";
    
    static
    {
      AppMethodBeat.i(241004);
      actu = new c("LOCAION", 0, "location", 1);
      actv = new c("CONTRACT", 1, "contact", 3);
      actw = new c("STORAGE", 2, "storage", 22);
      actx = new c("CAMERA", 3, "camera", 11);
      acty = new c("MICRO_PHONE", 4, "microphone", 9);
      actz = new c("BLUE_TOOTH", 5, "bluetooth", -1);
      actA = new c("HEALTHY", 6, "healthy", 17);
      actB = new c("OVERLAY", 7, "overlay", 31);
      actC = new c[] { actu, actv, actw, actx, acty, actz, actA, actB };
      AppMethodBeat.o(241004);
    }
    
    private c(String paramString, int paramInt)
    {
      this.value = paramString;
      this.qDL = paramInt;
    }
  }
  
  public static enum d
  {
    public String value = "";
    
    static
    {
      AppMethodBeat.i(241002);
      actD = new d("SYSTEM_REFUSE", 0, "");
      actE = new d("BUSINESS_REFUSE", 1, "");
      actF = new d("GRANTED", 2, "");
      actG = new d("ERROR", 3, "");
      actH = new d[] { actD, actE, actF, actG };
      AppMethodBeat.o(241002);
    }
    
    private d(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public static abstract interface e
  {
    public abstract void onBusinessPermissionDenied(String paramString);
    
    public abstract void onBusinessPermissionGranted(String paramString);
  }
  
  public static abstract interface f
  {
    public abstract void onOp(Boolean paramBoolean);
  }
  
  public static abstract interface g
  {
    public abstract void onResult(d.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.d
 * JD-Core Version:    0.7.0.1
 */