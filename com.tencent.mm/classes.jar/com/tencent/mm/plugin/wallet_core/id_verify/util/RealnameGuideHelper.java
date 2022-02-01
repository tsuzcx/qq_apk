package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private String EBM;
  private String EBN;
  private String EBO;
  private SetPwdInfo OMC;
  private boolean OMD;
  private int mEntryScene;
  private String oDJ;
  private String oDK;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.oDJ = "";
    this.oDK = "";
    this.EBO = "";
    this.OMD = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.oDJ = "";
    this.oDK = "";
    this.EBO = "";
    this.OMD = false;
    this.OMC = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.EBM = paramParcel.readString();
    this.EBN = paramParcel.readString();
    this.oDJ = paramParcel.readString();
    this.oDK = paramParcel.readString();
    this.EBO = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.OMD = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.OMC = paramSetPwdInfo;
    this.EBM = paramString1;
    this.EBN = paramString2;
    this.oDJ = paramString3;
    this.oDK = paramString4;
    this.EBO = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(70171);
    a(paramString1, null, paramString2, paramString3, paramString4, paramString5, paramInt);
    AppMethodBeat.o(70171);
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    Log.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.OMC, Integer.valueOf(this.mEntryScene), this.EBN, this.EBO, this.oDJ, this.oDK, Boolean.valueOf(this.OMD), this.EBM });
    if (this.OMD)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.OMC != null) && (this.OMC.OMN == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.OMC.EBN, this.OMC.oDJ, this.OMC.oDK, paramOnClickListener);
      if ((bool) && (!this.OMD)) {
        this.OMD = true;
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
    if (this.OMD)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.EBM))
    {
      if (!this.OMD) {
        this.OMD = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.EBM)) && (!Util.isNullOrNil(this.EBO)))
    {
      if (!this.OMD) {
        this.OMD = true;
      }
      paramBoolean = a.a(paramMMActivity, this.EBN, this.EBO, this.oDJ, this.oDK, paramBoolean, paramOnClickListener);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    AppMethodBeat.o(70174);
    return false;
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
    paramParcel.writeParcelable(this.OMC, paramInt);
    paramParcel.writeString(this.EBM);
    paramParcel.writeString(this.EBN);
    paramParcel.writeString(this.oDJ);
    paramParcel.writeString(this.oDK);
    paramParcel.writeString(this.EBO);
    if (this.OMD) {}
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