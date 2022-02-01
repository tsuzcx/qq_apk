package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public HashMap gJk;
  public int hrX;
  public Bundle ioY;
  public int remuxType;
  public ArrayList<String> sNQ;
  public int scene;
  public String thumbPath;
  public boolean xOA;
  public boolean xOB;
  public XEffectConfig xOC;
  public Boolean xOb;
  public int xOc;
  public int xOd;
  public Boolean xOe;
  public Boolean xOf;
  public VideoTransPara xOg;
  public UICustomParam xOh;
  public i.e xOi;
  public int xOj;
  public Boolean xOk;
  public Boolean xOl;
  public Boolean xOm;
  public Boolean xOn;
  public Boolean xOo;
  public int xOp;
  public boolean xOq;
  public boolean xOr;
  public String xOs;
  public String xOt;
  public String xOu;
  public String xOv;
  public ArrayList<String> xOw;
  public VideoCaptureReportInfo xOx;
  public long xOy;
  public boolean xOz;
  
  static
  {
    AppMethodBeat.i(101506);
    CREATOR = new RecordConfigProvider.1();
    AppMethodBeat.o(101506);
  }
  
  private RecordConfigProvider()
  {
    AppMethodBeat.i(101502);
    this.remuxType = 1;
    this.xOb = Boolean.FALSE;
    this.hrX = 1080;
    this.xOc = 2;
    this.xOd = 1;
    this.xOe = Boolean.FALSE;
    this.xOf = Boolean.FALSE;
    new UICustomParam.a();
    this.xOh = UICustomParam.a.abC().ggq;
    this.xOi = i.e.Flh;
    this.xOj = 1;
    this.xOk = Boolean.FALSE;
    this.xOl = Boolean.TRUE;
    this.xOm = Boolean.TRUE;
    this.xOn = Boolean.TRUE;
    this.xOo = Boolean.TRUE;
    this.xOp = 10000;
    this.xOq = false;
    this.xOr = true;
    this.xOy = 259200000L;
    this.xOz = true;
    this.xOA = false;
    this.xOB = false;
    this.gJk = new HashMap();
    this.xOC = new XEffectConfig();
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.xOb = Boolean.FALSE;
    this.hrX = 1080;
    this.xOc = 2;
    this.xOd = 1;
    this.xOe = Boolean.FALSE;
    this.xOf = Boolean.FALSE;
    new UICustomParam.a();
    this.xOh = UICustomParam.a.abC().ggq;
    this.xOi = i.e.Flh;
    this.xOj = 1;
    this.xOk = Boolean.FALSE;
    this.xOl = Boolean.TRUE;
    this.xOm = Boolean.TRUE;
    this.xOn = Boolean.TRUE;
    this.xOo = Boolean.TRUE;
    this.xOp = 10000;
    this.xOq = false;
    this.xOr = true;
    this.xOy = 259200000L;
    this.xOz = true;
    this.xOA = false;
    this.xOB = false;
    this.gJk = new HashMap();
    this.xOC = new XEffectConfig();
    this.remuxType = paramParcel.readInt();
    this.xOb = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.hrX = paramParcel.readInt();
    this.xOc = paramParcel.readInt();
    this.xOd = paramParcel.readInt();
    this.xOe = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.xOf = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.xOg = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.xOh = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    i.e locale;
    if (i == -1)
    {
      locale = null;
      this.xOi = locale;
      this.xOj = paramParcel.readInt();
      this.xOk = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xOl = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xOm = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xOn = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xOo = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xOp = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label618;
      }
      bool1 = true;
      label417:
      this.xOq = bool1;
      if (paramParcel.readByte() == 0) {
        break label623;
      }
      bool1 = true;
      label431:
      this.xOr = bool1;
      this.xOs = paramParcel.readString();
      this.xOt = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.xOu = paramParcel.readString();
      this.xOv = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.sNQ = paramParcel.createStringArrayList();
      this.xOw = paramParcel.createStringArrayList();
      this.xOx = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.xOy = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label628;
      }
      bool1 = true;
      label533:
      this.xOz = bool1;
      if (paramParcel.readByte() == 0) {
        break label633;
      }
      bool1 = true;
      label547:
      this.xOA = bool1;
      this.ioY = paramParcel.readBundle();
      if (paramParcel.readByte() == 0) {
        break label638;
      }
    }
    label618:
    label623:
    label628:
    label633:
    label638:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.xOB = bool1;
      this.gJk = ((HashMap)paramParcel.readSerializable());
      this.xOC = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
      AppMethodBeat.o(101505);
      return;
      locale = i.e.values()[i];
      break;
      bool1 = false;
      break label417;
      bool1 = false;
      break label431;
      bool1 = false;
      break label533;
      bool1 = false;
      break label547;
    }
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101501);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xOg = paramVideoTransPara;
    localRecordConfigProvider.xOl = Boolean.TRUE;
    localRecordConfigProvider.xOn = Boolean.TRUE;
    localRecordConfigProvider.xOo = Boolean.FALSE;
    localRecordConfigProvider.xOp = paramInt1;
    localRecordConfigProvider.xOt = o.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = o.k(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider as(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xOs = o.k(paramString1, false);
    localRecordConfigProvider.xOt = o.k(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = o.k(paramString3, true);
    }
    localRecordConfigProvider.xOq = true;
    localRecordConfigProvider.xOj = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider dIZ()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xOl = Boolean.TRUE;
    localRecordConfigProvider.xOn = Boolean.TRUE;
    localRecordConfigProvider.xOo = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xOu = o.k(paramString1, false);
    localRecordConfigProvider.xOv = o.k(paramString2, true);
    localRecordConfigProvider.xOq = true;
    localRecordConfigProvider.xOj = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xOt = o.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = o.k(paramString2, true);
    }
    localRecordConfigProvider.xOq = true;
    localRecordConfigProvider.xOj = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.gJk.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.xOb + ", resolutionLimit=" + this.hrX + ", recordType=" + this.xOc + ", recordLevel=" + this.xOd + ", useCameraApi2=" + this.xOe + ", useImageStream=" + this.xOf + ", videoParam=" + this.xOg + ", uiParam=" + this.xOh + ", outputType=" + this.xOj + ", previewForceFullScreen=" + this.xOk + ", enablePicture=" + this.xOl + ", enableVideo=" + this.xOm + ", forceForegroundMix=" + this.xOn + ", enableAlbum=" + this.xOo + ", maxRecordTimeMs=" + this.xOp + ", saveSourceMedia=" + this.xOq + ", savaToSysAlbumIfMediaEdited=" + this.xOr + ", inputVideoPath='" + this.xOs + '\'' + ", outputVideoPath='" + this.xOt + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.xOu + '\'' + ", outputPhotoPath='" + this.xOv + '\'' + ", scene=" + this.scene + ", images=" + this.sNQ + ", videos=" + this.xOw + ", reportInfo=" + this.xOx + ", expiredTimeMsIfMixInBackground=" + this.xOy + ", supportCaptureLandscape=" + this.xOz + ", forcePortrait=" + this.xOA + ", autoAdjustFoldingScreen=" + this.xOB + ", router=" + this.gJk + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.xOb);
    paramParcel.writeInt(this.hrX);
    paramParcel.writeInt(this.xOc);
    paramParcel.writeInt(this.xOd);
    paramParcel.writeValue(this.xOe);
    paramParcel.writeValue(this.xOf);
    paramParcel.writeParcelable(this.xOg, paramInt);
    paramParcel.writeParcelable(this.xOh, paramInt);
    int i;
    if (this.xOi == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.xOj);
      paramParcel.writeValue(this.xOk);
      paramParcel.writeValue(this.xOl);
      paramParcel.writeValue(this.xOm);
      paramParcel.writeValue(this.xOn);
      paramParcel.writeValue(this.xOo);
      paramParcel.writeInt(this.xOp);
      if (!this.xOq) {
        break label351;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.xOr) {
        break label356;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.xOs);
      paramParcel.writeString(this.xOt);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.xOu);
      paramParcel.writeString(this.xOv);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.sNQ);
      paramParcel.writeStringList(this.xOw);
      paramParcel.writeParcelable(this.xOx, paramInt);
      paramParcel.writeLong(this.xOy);
      if (!this.xOz) {
        break label361;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.xOA) {
        break label366;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.ioY);
      if (!this.xOB) {
        break label371;
      }
    }
    label351:
    label356:
    label361:
    label366:
    label371:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeSerializable(this.gJk);
      paramParcel.writeParcelable(this.xOC, paramInt);
      AppMethodBeat.o(101504);
      return;
      i = this.xOi.ordinal();
      break;
      b1 = 0;
      break label164;
      b1 = 0;
      break label178;
      b1 = 0;
      break label273;
      b1 = 0;
      break label287;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */