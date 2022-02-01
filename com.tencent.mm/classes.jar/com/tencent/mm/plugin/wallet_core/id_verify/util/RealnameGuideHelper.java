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
  private SetPwdInfo AaT;
  private boolean AaU;
  private int mEntryScene;
  private String tfF;
  private String tfG;
  private String tfH;
  private String tfI;
  private String tfJ;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.tfH = "";
    this.tfI = "";
    this.tfJ = "";
    this.AaU = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.tfH = "";
    this.tfI = "";
    this.tfJ = "";
    this.AaU = false;
    this.AaT = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.tfF = paramParcel.readString();
    this.tfG = paramParcel.readString();
    this.tfH = paramParcel.readString();
    this.tfI = paramParcel.readString();
    this.tfJ = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.AaU = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.AaT = paramSetPwdInfo;
    this.tfF = paramString1;
    this.tfG = paramString2;
    this.tfH = paramString3;
    this.tfI = paramString4;
    this.tfJ = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    ad.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.AaT, Integer.valueOf(this.mEntryScene), this.tfG, this.tfJ, this.tfH, this.tfI, Boolean.valueOf(this.AaU), this.tfF });
    if (this.AaU)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.AaT != null) && (this.AaT.Abe == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.AaT.tfG, this.AaT.tfH, this.AaT.tfI, paramOnClickListener);
      if ((bool) && (!this.AaU)) {
        this.AaU = true;
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
    if (this.AaU)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.tfF))
    {
      if (!this.AaU) {
        this.AaU = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.tfF)) && (!bt.isNullOrNil(this.tfJ)))
    {
      if (!this.AaU) {
        this.AaU = true;
      }
      paramBoolean = a.a(paramMMActivity, this.tfG, this.tfJ, this.tfH, this.tfI, paramBoolean, paramOnClickListener);
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
    paramParcel.writeParcelable(this.AaT, paramInt);
    paramParcel.writeString(this.tfF);
    paramParcel.writeString(this.tfG);
    paramParcel.writeString(this.tfH);
    paramParcel.writeString(this.tfI);
    paramParcel.writeString(this.tfJ);
    if (this.AaU) {}
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