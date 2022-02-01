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
  private SetPwdInfo HUB;
  private boolean HUC;
  private String lHA;
  private String lHB;
  private int mEntryScene;
  private String yXI;
  private String yXJ;
  private String yXK;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new RealnameGuideHelper.1();
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.lHA = "";
    this.lHB = "";
    this.yXK = "";
    this.HUC = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.lHA = "";
    this.lHB = "";
    this.yXK = "";
    this.HUC = false;
    this.HUB = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.yXI = paramParcel.readString();
    this.yXJ = paramParcel.readString();
    this.lHA = paramParcel.readString();
    this.lHB = paramParcel.readString();
    this.yXK = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.HUC = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.HUB = paramSetPwdInfo;
    this.yXI = paramString1;
    this.yXJ = paramString2;
    this.lHA = paramString3;
    this.lHB = paramString4;
    this.yXK = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    Log.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.HUB, Integer.valueOf(this.mEntryScene), this.yXJ, this.yXK, this.lHA, this.lHB, Boolean.valueOf(this.HUC), this.yXI });
    if (this.HUC)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.HUB != null) && (this.HUB.HUM == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.HUB.yXJ, this.HUB.lHA, this.HUB.lHB, paramOnClickListener);
      if ((bool) && (!this.HUC)) {
        this.HUC = true;
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
    if (this.HUC)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.yXI))
    {
      if (!this.HUC) {
        this.HUC = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.yXI)) && (!Util.isNullOrNil(this.yXK)))
    {
      if (!this.HUC) {
        this.HUC = true;
      }
      paramBoolean = a.a(paramMMActivity, this.yXJ, this.yXK, this.lHA, this.lHB, paramBoolean, paramOnClickListener);
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
    paramParcel.writeParcelable(this.HUB, paramInt);
    paramParcel.writeString(this.yXI);
    paramParcel.writeString(this.yXJ);
    paramParcel.writeString(this.lHA);
    paramParcel.writeString(this.lHB);
    paramParcel.writeString(this.yXK);
    if (this.HUC) {}
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