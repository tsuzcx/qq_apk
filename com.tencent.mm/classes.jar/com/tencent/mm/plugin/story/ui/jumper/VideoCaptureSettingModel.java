package com.tencent.mm.plugin.story.ui.jumper;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoFilePath", "", "videoThumbPath", "enablePicture", "", "forceForegroundMix", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getEnablePicture", "()Z", "setEnablePicture", "(Z)V", "getForceForegroundMix", "setForceForegroundMix", "getVideoFilePath", "()Ljava/lang/String;", "setVideoFilePath", "(Ljava/lang/String;)V", "getVideoThumbPath", "setVideoThumbPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-story_release"})
public final class VideoCaptureSettingModel
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureSettingModel> CREATOR;
  public static final a sKb;
  private String hIH;
  private String iaf;
  private boolean qcQ;
  private boolean sKa;
  
  static
  {
    AppMethodBeat.i(151156);
    sKb = new a((byte)0);
    CREATOR = (Parcelable.Creator)new VideoCaptureSettingModel.b();
    AppMethodBeat.o(151156);
  }
  
  public VideoCaptureSettingModel(Parcel paramParcel) {}
  
  private VideoCaptureSettingModel(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151154);
    this.hIH = paramString1;
    this.iaf = paramString2;
    this.qcQ = paramBoolean1;
    this.sKa = paramBoolean2;
    AppMethodBeat.o(151154);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(151159);
    if (this != paramObject)
    {
      if (!(paramObject instanceof VideoCaptureSettingModel)) {
        break label101;
      }
      paramObject = (VideoCaptureSettingModel)paramObject;
      if ((!j.e(this.hIH, paramObject.hIH)) || (!j.e(this.iaf, paramObject.iaf))) {
        break label101;
      }
      if (this.qcQ != paramObject.qcQ) {
        break label91;
      }
      i = 1;
      if (i == 0) {
        break label101;
      }
      if (this.sKa != paramObject.sKa) {
        break label96;
      }
    }
    label91:
    label96:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label101;
      }
      AppMethodBeat.o(151159);
      return true;
      i = 0;
      break;
    }
    label101:
    AppMethodBeat.o(151159);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151157);
    String str = "VideoCaptureSettingModel(videoFilePath=" + this.hIH + ", videoThumbPath=" + this.iaf + ", enablePicture=" + this.qcQ + ", forceForegroundMix=" + this.sKa + ")";
    AppMethodBeat.o(151157);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(151153);
    j.q(paramParcel, "dest");
    paramParcel.writeString(this.hIH);
    paramParcel.writeString(this.iaf);
    if (this.qcQ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.sKa) {
        break label68;
      }
    }
    label68:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(151153);
      return;
      paramInt = 0;
      break;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "generateNormalModel", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel
 * JD-Core Version:    0.7.0.1
 */