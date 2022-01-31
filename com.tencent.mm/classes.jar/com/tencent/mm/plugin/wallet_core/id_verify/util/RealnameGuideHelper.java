package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.wallet_core.c.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR = new RealnameGuideHelper.1();
  private int fgD;
  private String lRC;
  private String lRD;
  private String lRE = "";
  private String lRF = "";
  private String lRG = "";
  private SetPwdInfo qsv;
  private boolean qsw = false;
  
  public RealnameGuideHelper() {}
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    this.qsv = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.lRC = paramParcel.readString();
    this.lRD = paramParcel.readString();
    this.lRE = paramParcel.readString();
    this.lRF = paramParcel.readString();
    this.lRG = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.qsw = bool;
      this.fgD = paramParcel.readInt();
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.qsv = paramSetPwdInfo;
    this.lRC = paramString1;
    this.lRD = paramString2;
    this.lRE = paramString3;
    this.lRF = paramString4;
    this.lRG = paramString5;
    this.fgD = paramInt;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    a(paramString1, null, paramString2, paramString3, paramString4, paramString5, paramInt);
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    y.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.qsv, Integer.valueOf(this.fgD), this.lRD, this.lRG, this.lRE, this.lRF, Boolean.valueOf(this.qsw), this.lRC });
    boolean bool2;
    if (this.qsw)
    {
      bool2 = false;
      return bool2;
    }
    if ((this.qsv != null) && (this.qsv.qsG == 1))
    {
      int i = this.fgD;
      String str2 = this.qsv.lRD;
      Object localObject2 = this.qsv.lRE;
      String str1 = this.qsv.lRF;
      g.DQ();
      int j = ((Integer)g.DP().Dz().get(ac.a.uxL, Integer.valueOf(0))).intValue();
      y.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[] { Integer.valueOf(j) });
      if (j >= 3) {}
      for (boolean bool1 = false;; bool1 = true)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (this.qsw) {
          break;
        }
        this.qsw = true;
        return bool1;
        g.DQ();
        g.DP().Dz().c(ac.a.uxL, Integer.valueOf(j + 1));
        Object localObject1 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject1 = paramMMActivity.getString(a.i.app_cancel);
        }
        localObject2 = str1;
        if (bk.bl(str1)) {
          localObject2 = paramMMActivity.getString(a.i.app_ok);
        }
        paramBundle = h.a(paramMMActivity, str2, "", (String)localObject2, (String)localObject1, new a.3(paramBundle, i, paramMMActivity), paramOnClickListener, a.c.wechat_green);
        if (paramBundle != null)
        {
          paramBundle.setOnCancelListener(new a.4(paramMMActivity));
          paramBundle.setOnDismissListener(new a.5(paramMMActivity));
        }
      }
    }
    return false;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener, c.a parama, boolean paramBoolean)
  {
    if (this.qsw) {}
    do
    {
      return false;
      if ("1".equals(this.lRC))
      {
        if (!this.qsw) {
          this.qsw = true;
        }
        return a.a(paramMMActivity, paramBundle, parama, this.fgD);
      }
    } while ((!"2".equals(this.lRC)) || (bk.bl(this.lRG)));
    if (!this.qsw) {
      this.qsw = true;
    }
    return a.a(paramMMActivity, this.lRD, this.lRG, this.lRE, this.lRF, paramBoolean, paramOnClickListener);
  }
  
  public final boolean b(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(paramMMActivity, paramBundle, paramOnClickListener, null, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.qsv, paramInt);
    paramParcel.writeString(this.lRC);
    paramParcel.writeString(this.lRD);
    paramParcel.writeString(this.lRE);
    paramParcel.writeString(this.lRF);
    paramParcel.writeString(this.lRG);
    if (this.qsw) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.fgD);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper
 * JD-Core Version:    0.7.0.1
 */