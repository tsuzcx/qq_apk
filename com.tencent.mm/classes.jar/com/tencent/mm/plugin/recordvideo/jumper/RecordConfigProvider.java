package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.modelcontrol.VideoTransPara;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public int eZQ;
  public String qbA;
  public String qbB;
  public String qbC;
  public String qbD;
  public VideoCaptureReportInfo qbE;
  public int qbm;
  public Boolean qbn;
  public int qbo;
  public int qbp;
  public VideoTransPara qbq;
  public UICustomParam qbr;
  public int qbs;
  public Boolean qbt;
  public Boolean qbu;
  public Boolean qbv;
  public Boolean qbw;
  public int qbx;
  public boolean qby;
  public boolean qbz;
  public int scene;
  public String thumbPath;
  
  static
  {
    AppMethodBeat.i(141875);
    CREATOR = new RecordConfigProvider.1();
    AppMethodBeat.o(141875);
  }
  
  private RecordConfigProvider()
  {
    this.qbm = 1;
    this.qbn = Boolean.FALSE;
    this.eZQ = 1080;
    this.qbo = 2;
    this.qbp = 1;
    this.qbs = 1;
    this.qbt = Boolean.TRUE;
    this.qbu = Boolean.TRUE;
    this.qbv = Boolean.TRUE;
    this.qbw = Boolean.TRUE;
    this.qbx = 10000;
    this.qby = false;
    this.qbz = true;
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(141874);
    this.qbm = 1;
    this.qbn = Boolean.FALSE;
    this.eZQ = 1080;
    this.qbo = 2;
    this.qbp = 1;
    this.qbs = 1;
    this.qbt = Boolean.TRUE;
    this.qbu = Boolean.TRUE;
    this.qbv = Boolean.TRUE;
    this.qbw = Boolean.TRUE;
    this.qbx = 10000;
    this.qby = false;
    this.qbz = true;
    this.qbm = paramParcel.readInt();
    this.qbn = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.eZQ = paramParcel.readInt();
    this.qbo = paramParcel.readInt();
    this.qbp = paramParcel.readInt();
    this.qbq = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.qbr = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    this.qbs = paramParcel.readInt();
    this.qbt = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.qbu = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.qbv = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.qbw = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.qbx = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.qby = bool1;
      if (paramParcel.readByte() == 0) {
        break label353;
      }
    }
    label353:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qbz = bool1;
      this.qbA = paramParcel.readString();
      this.qbB = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.qbC = paramParcel.readString();
      this.qbD = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.qbE = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      AppMethodBeat.o(141874);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141872);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.qbq = paramVideoTransPara;
    localRecordConfigProvider.qbt = Boolean.TRUE;
    localRecordConfigProvider.qbv = Boolean.TRUE;
    localRecordConfigProvider.qbw = Boolean.FALSE;
    localRecordConfigProvider.qbx = paramInt1;
    localRecordConfigProvider.qbB = paramString1;
    localRecordConfigProvider.thumbPath = paramString2;
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(141872);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider aa(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(141870);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.qbA = paramString1;
    localRecordConfigProvider.qbB = paramString2;
    localRecordConfigProvider.thumbPath = paramString3;
    localRecordConfigProvider.qby = true;
    localRecordConfigProvider.qbs = 4;
    AppMethodBeat.o(141870);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider cgp()
  {
    AppMethodBeat.i(141871);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.qbt = Boolean.TRUE;
    localRecordConfigProvider.qbv = Boolean.TRUE;
    localRecordConfigProvider.qbw = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(141871);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141869);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.qbC = paramString1;
    localRecordConfigProvider.qbD = paramString2;
    localRecordConfigProvider.qby = true;
    localRecordConfigProvider.qbs = 3;
    AppMethodBeat.o(141869);
    return localRecordConfigProvider;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(141868);
    String str = "RecordConfigProvider{remuxType=" + this.qbm + ", useCPUCrop=" + this.qbn + ", resolutionLimit=" + this.eZQ + ", recordType=" + this.qbo + ", recordLevel=" + this.qbp + ", videoParam=" + this.qbq + ", uiParam=" + this.qbr + ", outputType=" + this.qbs + ", enablePicture=" + this.qbt + ", enableVideo=" + this.qbu + ", forceForegroundMix=" + this.qbv + ", enableAlbum=" + this.qbw + ", maxRecordTimeMs=" + this.qbx + ", saveSourceMedia=" + this.qby + ", savaToSysAlbumIfMediaEdited=" + this.qbz + ", inputVideoPath='" + this.qbA + '\'' + ", outputVideoPath='" + this.qbB + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.qbC + '\'' + ", outputPhotoPath='" + this.qbD + '\'' + ", scene=" + this.scene + ", info=" + this.qbE + '}';
    AppMethodBeat.o(141868);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(141873);
    paramParcel.writeInt(this.qbm);
    paramParcel.writeValue(this.qbn);
    paramParcel.writeInt(this.eZQ);
    paramParcel.writeInt(this.qbo);
    paramParcel.writeInt(this.qbp);
    paramParcel.writeParcelable(this.qbq, paramInt);
    paramParcel.writeParcelable(this.qbr, paramInt);
    paramParcel.writeInt(this.qbs);
    paramParcel.writeValue(this.qbt);
    paramParcel.writeValue(this.qbu);
    paramParcel.writeValue(this.qbv);
    paramParcel.writeValue(this.qbw);
    paramParcel.writeInt(this.qbx);
    if (this.qby)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.qbz) {
        break label211;
      }
    }
    label211:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.qbA);
      paramParcel.writeString(this.qbB);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.qbC);
      paramParcel.writeString(this.qbD);
      paramParcel.writeInt(this.scene);
      paramParcel.writeParcelable(this.qbE, paramInt);
      AppMethodBeat.o(141873);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */