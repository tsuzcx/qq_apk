package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private SetPwdInfo Dli;
  private boolean Dlj;
  private String kCZ;
  private String kDa;
  private int mEntryScene;
  private String vCF;
  private String vCG;
  private String vCH;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.kCZ = "";
    this.kDa = "";
    this.vCH = "";
    this.Dlj = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.kCZ = "";
    this.kDa = "";
    this.vCH = "";
    this.Dlj = false;
    this.Dli = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.vCF = paramParcel.readString();
    this.vCG = paramParcel.readString();
    this.kCZ = paramParcel.readString();
    this.kDa = paramParcel.readString();
    this.vCH = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Dlj = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.Dli = paramSetPwdInfo;
    this.vCF = paramString1;
    this.vCG = paramString2;
    this.kCZ = paramString3;
    this.kDa = paramString4;
    this.vCH = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    ae.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.Dli, Integer.valueOf(this.mEntryScene), this.vCG, this.vCH, this.kCZ, this.kDa, Boolean.valueOf(this.Dlj), this.vCF });
    if (this.Dlj)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.Dli != null) && (this.Dli.Dlt == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.Dli.vCG, this.Dli.kCZ, this.Dli.kDa, paramOnClickListener);
      if ((bool) && (!this.Dlj)) {
        this.Dlj = true;
      }
      AppMethodBeat.o(70172);
      return bool;
    }
    AppMethodBeat.o(70172);
    return false;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener, d.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(70174);
    if (this.Dlj)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.vCF))
    {
      if (!this.Dlj) {
        this.Dlj = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.vCF)) && (!bu.isNullOrNil(this.vCH)))
    {
      if (!this.Dlj) {
        this.Dlj = true;
      }
      paramBoolean = a.a(paramMMActivity, this.vCG, this.vCH, this.kCZ, this.kDa, paramBoolean, paramOnClickListener);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    AppMethodBeat.o(70174);
    return false;
  }
  
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(70171);
    a(paramString1, null, paramString2, paramString3, paramString4, paramString5, paramInt);
    AppMethodBeat.o(70171);
  }
  
  public final boolean b(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70173);
    boolean bool = a(paramMMActivity, paramBundle, paramOnClickListener, null, false);
    AppMethodBeat.o(70173);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(70170);
    paramParcel.writeParcelable(this.Dli, paramInt);
    paramParcel.writeString(this.vCF);
    paramParcel.writeString(this.vCG);
    paramParcel.writeString(this.kCZ);
    paramParcel.writeString(this.kDa);
    paramParcel.writeString(this.vCH);
    if (this.Dlj) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mEntryScene);
      AppMethodBeat.o(70170);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper
 * JD-Core Version:    0.7.0.1
 */