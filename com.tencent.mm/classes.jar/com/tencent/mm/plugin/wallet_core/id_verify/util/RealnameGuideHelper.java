package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private SetPwdInfo CTC;
  private boolean CTD;
  private String kzK;
  private String kzL;
  private int mEntryScene;
  private String vqA;
  private String vqB;
  private String vqC;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.kzK = "";
    this.kzL = "";
    this.vqC = "";
    this.CTD = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.kzK = "";
    this.kzL = "";
    this.vqC = "";
    this.CTD = false;
    this.CTC = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.vqA = paramParcel.readString();
    this.vqB = paramParcel.readString();
    this.kzK = paramParcel.readString();
    this.kzL = paramParcel.readString();
    this.vqC = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.CTD = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.CTC = paramSetPwdInfo;
    this.vqA = paramString1;
    this.vqB = paramString2;
    this.kzK = paramString3;
    this.kzL = paramString4;
    this.vqC = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    ad.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.CTC, Integer.valueOf(this.mEntryScene), this.vqB, this.vqC, this.kzK, this.kzL, Boolean.valueOf(this.CTD), this.vqA });
    if (this.CTD)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.CTC != null) && (this.CTC.CTN == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.CTC.vqB, this.CTC.kzK, this.CTC.kzL, paramOnClickListener);
      if ((bool) && (!this.CTD)) {
        this.CTD = true;
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
    if (this.CTD)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.vqA))
    {
      if (!this.CTD) {
        this.CTD = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.vqA)) && (!bt.isNullOrNil(this.vqC)))
    {
      if (!this.CTD) {
        this.CTD = true;
      }
      paramBoolean = a.a(paramMMActivity, this.vqB, this.vqC, this.kzK, this.kzL, paramBoolean, paramOnClickListener);
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
    paramParcel.writeParcelable(this.CTC, paramInt);
    paramParcel.writeString(this.vqA);
    paramParcel.writeString(this.vqB);
    paramParcel.writeString(this.kzK);
    paramParcel.writeString(this.kzL);
    paramParcel.writeString(this.vqC);
    if (this.CTD) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mEntryScene);
      AppMethodBeat.o(70170);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper
 * JD-Core Version:    0.7.0.1
 */