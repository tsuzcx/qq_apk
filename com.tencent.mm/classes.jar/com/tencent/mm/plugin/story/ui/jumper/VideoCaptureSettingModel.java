package com.tencent.mm.plugin.story.ui.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoFilePath", "", "videoThumbPath", "enablePicture", "", "forceForegroundMix", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getEnablePicture", "()Z", "setEnablePicture", "(Z)V", "getForceForegroundMix", "setForceForegroundMix", "getVideoFilePath", "()Ljava/lang/String;", "setVideoFilePath", "(Ljava/lang/String;)V", "getVideoThumbPath", "setVideoThumbPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-story_release"})
public final class VideoCaptureSettingModel
  implements Parcelable
{
  public static final Parcelable.Creator<VideoCaptureSettingModel> CREATOR;
  public static final a FzL;
  private boolean BRu;
  private boolean FzK;
  private String lPw;
  private String mss;
  
  static
  {
    AppMethodBeat.i(119911);
    FzL = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(119911);
  }
  
  public VideoCaptureSettingModel(Parcel paramParcel) {}
  
  private VideoCaptureSettingModel(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(119909);
    this.lPw = paramString1;
    this.mss = paramString2;
    this.BRu = paramBoolean1;
    this.FzK = paramBoolean2;
    AppMethodBeat.o(119909);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119914);
    if (this != paramObject)
    {
      if ((paramObject instanceof VideoCaptureSettingModel))
      {
        paramObject = (VideoCaptureSettingModel)paramObject;
        if ((!p.j(this.lPw, paramObject.lPw)) || (!p.j(this.mss, paramObject.mss)) || (this.BRu != paramObject.BRu) || (this.FzK != paramObject.FzK)) {}
      }
    }
    else
    {
      AppMethodBeat.o(119914);
      return true;
    }
    AppMethodBeat.o(119914);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119912);
    String str = "VideoCaptureSettingModel(videoFilePath=" + this.lPw + ", videoThumbPath=" + this.mss + ", enablePicture=" + this.BRu + ", forceForegroundMix=" + this.FzK + ")";
    AppMethodBeat.o(119912);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(119908);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.lPw);
    paramParcel.writeString(this.mss);
    if (this.BRu)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.FzK) {
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "generateNormalModel", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "plugin-story_release"})
  public static final class b
    implements Parcelable.Creator<VideoCaptureSettingModel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel
 * JD-Core Version:    0.7.0.1
 */