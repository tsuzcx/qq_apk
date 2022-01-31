package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private int gyl;
  private String opA;
  private String opB;
  private String opC;
  private String opD;
  private String opE;
  private SetPwdInfo ueH;
  private boolean ueI;
  
  static
  {
    AppMethodBeat.i(46665);
    CREATOR = new RealnameGuideHelper.1();
    AppMethodBeat.o(46665);
  }
  
  public RealnameGuideHelper()
  {
    this.opC = "";
    this.opD = "";
    this.opE = "";
    this.ueI = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(46659);
    this.opC = "";
    this.opD = "";
    this.opE = "";
    this.ueI = false;
    this.ueH = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.opA = paramParcel.readString();
    this.opB = paramParcel.readString();
    this.opC = paramParcel.readString();
    this.opD = paramParcel.readString();
    this.opE = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ueI = bool;
      this.gyl = paramParcel.readInt();
      AppMethodBeat.o(46659);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.ueH = paramSetPwdInfo;
    this.opA = paramString1;
    this.opB = paramString2;
    this.opC = paramString3;
    this.opD = paramString4;
    this.opE = paramString5;
    this.gyl = paramInt;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(46661);
    a(paramString1, null, paramString2, paramString3, paramString4, paramString5, paramInt);
    AppMethodBeat.o(46661);
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(46662);
    ab.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.ueH, Integer.valueOf(this.gyl), this.opB, this.opE, this.opC, this.opD, Boolean.valueOf(this.ueI), this.opA });
    if (this.ueI)
    {
      AppMethodBeat.o(46662);
      return false;
    }
    if ((this.ueH != null) && (this.ueH.ueS == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.gyl, this.ueH.opB, this.ueH.opC, this.ueH.opD, paramOnClickListener);
      if ((bool) && (!this.ueI)) {
        this.ueI = true;
      }
      AppMethodBeat.o(46662);
      return bool;
    }
    AppMethodBeat.o(46662);
    return false;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener, c.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(46664);
    if (this.ueI)
    {
      AppMethodBeat.o(46664);
      return false;
    }
    if ("1".equals(this.opA))
    {
      if (!this.ueI) {
        this.ueI = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.gyl);
      AppMethodBeat.o(46664);
      return paramBoolean;
    }
    if (("2".equals(this.opA)) && (!bo.isNullOrNil(this.opE)))
    {
      if (!this.ueI) {
        this.ueI = true;
      }
      paramBoolean = a.a(paramMMActivity, this.opB, this.opE, this.opC, this.opD, paramBoolean, paramOnClickListener);
      AppMethodBeat.o(46664);
      return paramBoolean;
    }
    AppMethodBeat.o(46664);
    return false;
  }
  
  public final boolean b(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(46663);
    boolean bool = a(paramMMActivity, paramBundle, paramOnClickListener, null, false);
    AppMethodBeat.o(46663);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46660);
    paramParcel.writeParcelable(this.ueH, paramInt);
    paramParcel.writeString(this.opA);
    paramParcel.writeString(this.opB);
    paramParcel.writeString(this.opC);
    paramParcel.writeString(this.opD);
    paramParcel.writeString(this.opE);
    if (this.ueI) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.gyl);
      AppMethodBeat.o(46660);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper
 * JD-Core Version:    0.7.0.1
 */