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
import com.tencent.mm.wallet_core.e.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private String KuN;
  private String KuO;
  private String KuP;
  private SetPwdInfo VCn;
  private boolean VCo;
  private int mEntryScene;
  private String rGU;
  private String right_button_wording;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.rGU = "";
    this.right_button_wording = "";
    this.KuP = "";
    this.VCo = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.rGU = "";
    this.right_button_wording = "";
    this.KuP = "";
    this.VCo = false;
    this.VCn = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.KuN = paramParcel.readString();
    this.KuO = paramParcel.readString();
    this.rGU = paramParcel.readString();
    this.right_button_wording = paramParcel.readString();
    this.KuP = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.VCo = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.VCn = paramSetPwdInfo;
    this.KuN = paramString1;
    this.KuO = paramString2;
    this.rGU = paramString3;
    this.right_button_wording = paramString4;
    this.KuP = paramString5;
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
    Log.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.VCn, Integer.valueOf(this.mEntryScene), this.KuO, this.KuP, this.rGU, this.right_button_wording, Boolean.valueOf(this.VCo), this.KuN });
    if (this.VCo)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.VCn != null) && (this.VCn.VCy == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.VCn.KuO, this.VCn.rGU, this.VCn.right_button_wording, paramOnClickListener);
      if ((bool) && (!this.VCo)) {
        this.VCo = true;
      }
      AppMethodBeat.o(70172);
      return bool;
    }
    AppMethodBeat.o(70172);
    return false;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(70174);
    if (this.VCo)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.KuN))
    {
      if (!this.VCo) {
        this.VCo = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.KuN)) && (!Util.isNullOrNil(this.KuP)))
    {
      if (!this.VCo) {
        this.VCo = true;
      }
      paramBoolean = a.a(paramMMActivity, this.KuO, this.KuP, this.rGU, this.right_button_wording, paramBoolean, paramOnClickListener);
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
    paramParcel.writeParcelable(this.VCn, paramInt);
    paramParcel.writeString(this.KuN);
    paramParcel.writeString(this.KuO);
    paramParcel.writeString(this.rGU);
    paramParcel.writeString(this.right_button_wording);
    paramParcel.writeString(this.KuP);
    if (this.VCo) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mEntryScene);
      AppMethodBeat.o(70170);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper
 * JD-Core Version:    0.7.0.1
 */