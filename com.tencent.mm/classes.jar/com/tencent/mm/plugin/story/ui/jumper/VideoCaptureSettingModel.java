package com.tencent.mm.plugin.story.ui.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoFilePath", "", "videoThumbPath", "enablePicture", "", "forceForegroundMix", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getEnablePicture", "()Z", "setEnablePicture", "(Z)V", "getForceForegroundMix", "setForceForegroundMix", "getVideoFilePath", "()Ljava/lang/String;", "setVideoFilePath", "(Ljava/lang/String;)V", "getVideoThumbPath", "setVideoThumbPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VideoCaptureSettingModel
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureSettingModel> CREATOR;
  public static final VideoCaptureSettingModel.a SvW;
  private boolean NKZ;
  private boolean SvX;
  private String rPL;
  private String svn;
  
  static
  {
    AppMethodBeat.i(119911);
    SvW = new VideoCaptureSettingModel.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(119911);
  }
  
  public VideoCaptureSettingModel(Parcel paramParcel) {}
  
  private VideoCaptureSettingModel(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(119909);
    this.rPL = paramString1;
    this.svn = paramString2;
    this.NKZ = paramBoolean1;
    this.SvX = paramBoolean2;
    AppMethodBeat.o(119909);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119914);
    if (this == paramObject)
    {
      AppMethodBeat.o(119914);
      return true;
    }
    if (!(paramObject instanceof VideoCaptureSettingModel))
    {
      AppMethodBeat.o(119914);
      return false;
    }
    paramObject = (VideoCaptureSettingModel)paramObject;
    if (!s.p(this.rPL, paramObject.rPL))
    {
      AppMethodBeat.o(119914);
      return false;
    }
    if (!s.p(this.svn, paramObject.svn))
    {
      AppMethodBeat.o(119914);
      return false;
    }
    if (this.NKZ != paramObject.NKZ)
    {
      AppMethodBeat.o(119914);
      return false;
    }
    if (this.SvX != paramObject.SvX)
    {
      AppMethodBeat.o(119914);
      return false;
    }
    AppMethodBeat.o(119914);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119912);
    String str = "VideoCaptureSettingModel(videoFilePath=" + this.rPL + ", videoThumbPath=" + this.svn + ", enablePicture=" + this.NKZ + ", forceForegroundMix=" + this.SvX + ')';
    AppMethodBeat.o(119912);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(119908);
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.rPL);
    paramParcel.writeString(this.svn);
    if (this.NKZ)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.SvX) {
        break label68;
      }
    }
    label68:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(119908);
      return;
      paramInt = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<VideoCaptureSettingModel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel
 * JD-Core Version:    0.7.0.1
 */