package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.a;

public class RealnameGuideHelper
  implements Parcelable
{
  public static final Parcelable.Creator<RealnameGuideHelper> CREATOR;
  private SetPwdInfo Btn;
  private boolean Bto;
  private int mEntryScene;
  private String unU;
  private String unV;
  private String unW;
  private String unX;
  private String unY;
  
  static
  {
    AppMethodBeat.i(70175);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(70175);
  }
  
  public RealnameGuideHelper()
  {
    this.unW = "";
    this.unX = "";
    this.unY = "";
    this.Bto = false;
  }
  
  protected RealnameGuideHelper(Parcel paramParcel)
  {
    AppMethodBeat.i(70169);
    this.unW = "";
    this.unX = "";
    this.unY = "";
    this.Bto = false;
    this.Btn = ((SetPwdInfo)paramParcel.readParcelable(SetPwdInfo.class.getClassLoader()));
    this.unU = paramParcel.readString();
    this.unV = paramParcel.readString();
    this.unW = paramParcel.readString();
    this.unX = paramParcel.readString();
    this.unY = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Bto = bool;
      this.mEntryScene = paramParcel.readInt();
      AppMethodBeat.o(70169);
      return;
    }
  }
  
  public final void a(String paramString1, SetPwdInfo paramSetPwdInfo, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.Btn = paramSetPwdInfo;
    this.unU = paramString1;
    this.unV = paramString2;
    this.unW = paramString3;
    this.unX = paramString4;
    this.unY = paramString5;
    this.mEntryScene = paramInt;
  }
  
  public final boolean a(MMActivity paramMMActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(70172);
    ac.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[] { this.Btn, Integer.valueOf(this.mEntryScene), this.unV, this.unY, this.unW, this.unX, Boolean.valueOf(this.Bto), this.unU });
    if (this.Bto)
    {
      AppMethodBeat.o(70172);
      return false;
    }
    if ((this.Btn != null) && (this.Btn.Bty == 1))
    {
      boolean bool = a.a(paramMMActivity, paramBundle, this.mEntryScene, this.Btn.unV, this.Btn.unW, this.Btn.unX, paramOnClickListener);
      if ((bool) && (!this.Bto)) {
        this.Bto = true;
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
    if (this.Bto)
    {
      AppMethodBeat.o(70174);
      return false;
    }
    if ("1".equals(this.unU))
    {
      if (!this.Bto) {
        this.Bto = true;
      }
      paramBoolean = a.a(paramMMActivity, paramBundle, parama, this.mEntryScene);
      AppMethodBeat.o(70174);
      return paramBoolean;
    }
    if (("2".equals(this.unU)) && (!bs.isNullOrNil(this.unY)))
    {
      if (!this.Bto) {
        this.Bto = true;
      }
      paramBoolean = a.a(paramMMActivity, this.unV, this.unY, this.unW, this.unX, paramBoolean, paramOnClickListener);
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
    paramParcel.writeParcelable(this.Btn, paramInt);
    paramParcel.writeString(this.unU);
    paramParcel.writeString(this.unV);
    paramParcel.writeString(this.unW);
    paramParcel.writeString(this.unX);
    paramParcel.writeString(this.unY);
    if (this.Bto) {}
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