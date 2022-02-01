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
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public String BOA;
  public String BOB;
  public String BOC;
  public ArrayList<String> BOD;
  public VideoCaptureReportInfo BOE;
  public long BOF;
  public boolean BOG;
  public boolean BOH;
  public boolean BOI;
  public XEffectConfig BOJ;
  public String BOK;
  public Boolean BOh;
  public int BOi;
  public int BOj;
  public Boolean BOk;
  public Boolean BOl;
  public VideoTransPara BOm;
  public UICustomParam BOn;
  public i.e BOo;
  public int BOp;
  public Boolean BOq;
  public Boolean BOr;
  public Boolean BOs;
  public Boolean BOt;
  public Boolean BOu;
  public int BOv;
  public int BOw;
  public boolean BOx;
  public boolean BOy;
  public String BOz;
  public HashMap hwc;
  public int ilT;
  public ArrayList<String> images;
  public Bundle jkf;
  public int remuxType;
  public int scene;
  public String thumbPath;
  
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
    this.BOh = Boolean.FALSE;
    this.ilT = 1080;
    this.BOi = 2;
    this.BOj = 1;
    this.BOk = Boolean.FALSE;
    this.BOl = Boolean.FALSE;
    new UICustomParam.a();
    this.BOn = UICustomParam.a.apz().gLU;
    this.BOo = i.e.KbZ;
    this.BOp = 1;
    this.BOq = Boolean.FALSE;
    this.BOr = Boolean.TRUE;
    this.BOs = Boolean.TRUE;
    this.BOt = Boolean.TRUE;
    this.BOu = Boolean.TRUE;
    this.BOv = 10000;
    this.BOw = -1;
    this.BOx = false;
    this.BOy = true;
    this.BOF = 259200000L;
    this.BOG = true;
    this.BOH = false;
    this.BOI = false;
    this.hwc = new HashMap();
    this.BOJ = new XEffectConfig();
    this.BOK = "";
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.BOh = Boolean.FALSE;
    this.ilT = 1080;
    this.BOi = 2;
    this.BOj = 1;
    this.BOk = Boolean.FALSE;
    this.BOl = Boolean.FALSE;
    new UICustomParam.a();
    this.BOn = UICustomParam.a.apz().gLU;
    this.BOo = i.e.KbZ;
    this.BOp = 1;
    this.BOq = Boolean.FALSE;
    this.BOr = Boolean.TRUE;
    this.BOs = Boolean.TRUE;
    this.BOt = Boolean.TRUE;
    this.BOu = Boolean.TRUE;
    this.BOv = 10000;
    this.BOw = -1;
    this.BOx = false;
    this.BOy = true;
    this.BOF = 259200000L;
    this.BOG = true;
    this.BOH = false;
    this.BOI = false;
    this.hwc = new HashMap();
    this.BOJ = new XEffectConfig();
    this.BOK = "";
    this.remuxType = paramParcel.readInt();
    this.BOh = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.ilT = paramParcel.readInt();
    this.BOi = paramParcel.readInt();
    this.BOj = paramParcel.readInt();
    this.BOk = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.BOl = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.BOm = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.BOn = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    i.e locale;
    if (i == -1)
    {
      locale = null;
      this.BOo = locale;
      this.BOp = paramParcel.readInt();
      this.BOq = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.BOr = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.BOs = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.BOt = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.BOu = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.BOv = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label645;
      }
      bool1 = true;
      label428:
      this.BOx = bool1;
      if (paramParcel.readByte() == 0) {
        break label650;
      }
      bool1 = true;
      label442:
      this.BOy = bool1;
      this.BOz = paramParcel.readString();
      this.BOA = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.BOB = paramParcel.readString();
      this.BOC = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.images = paramParcel.createStringArrayList();
      this.BOD = paramParcel.createStringArrayList();
      this.BOE = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.BOF = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label655;
      }
      bool1 = true;
      label544:
      this.BOG = bool1;
      if (paramParcel.readByte() == 0) {
        break label660;
      }
      bool1 = true;
      label558:
      this.BOH = bool1;
      this.jkf = paramParcel.readBundle();
      if (paramParcel.readByte() == 0) {
        break label665;
      }
    }
    label645:
    label650:
    label655:
    label660:
    label665:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BOI = bool1;
      this.hwc = ((HashMap)paramParcel.readSerializable());
      this.BOJ = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
      this.BOw = paramParcel.readInt();
      this.BOK = paramParcel.readString();
      AppMethodBeat.o(101505);
      return;
      locale = i.e.values()[i];
      break;
      bool1 = false;
      break label428;
      bool1 = false;
      break label442;
      bool1 = false;
      break label544;
      bool1 = false;
      break label558;
    }
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101501);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.BOm = paramVideoTransPara;
    localRecordConfigProvider.BOr = Boolean.TRUE;
    localRecordConfigProvider.BOt = Boolean.TRUE;
    localRecordConfigProvider.BOu = Boolean.FALSE;
    localRecordConfigProvider.BOv = paramInt1;
    localRecordConfigProvider.BOA = s.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = s.k(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.BOz = s.k(paramString1, false);
    localRecordConfigProvider.BOA = s.k(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = s.k(paramString3, true);
    }
    localRecordConfigProvider.BOx = true;
    localRecordConfigProvider.BOp = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider eJM()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.BOr = Boolean.TRUE;
    localRecordConfigProvider.BOt = Boolean.TRUE;
    localRecordConfigProvider.BOu = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.BOB = s.k(paramString1, false);
    localRecordConfigProvider.BOC = s.k(paramString2, true);
    localRecordConfigProvider.BOx = true;
    localRecordConfigProvider.BOp = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider jB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.BOA = s.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = s.k(paramString2, true);
    }
    localRecordConfigProvider.BOx = true;
    localRecordConfigProvider.BOp = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void F(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.hwc.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.BOh + ", resolutionLimit=" + this.ilT + ", recordType=" + this.BOi + ", recordLevel=" + this.BOj + ", useCameraApi2=" + this.BOk + ", useImageStream=" + this.BOl + ", videoParam=" + this.BOm + ", uiParam=" + this.BOn + ", outputType=" + this.BOp + ", previewForceFullScreen=" + this.BOq + ", enablePicture=" + this.BOr + ", enableVideo=" + this.BOs + ", forceForegroundMix=" + this.BOt + ", enableAlbum=" + this.BOu + ", maxRecordTimeMs=" + this.BOv + ", saveSourceMedia=" + this.BOx + ", savaToSysAlbumIfMediaEdited=" + this.BOy + ", inputVideoPath='" + this.BOz + '\'' + ", outputVideoPath='" + this.BOA + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.BOB + '\'' + ", outputPhotoPath='" + this.BOC + '\'' + ", scene=" + this.scene + ", images=" + this.images + ", videos=" + this.BOD + ", reportInfo=" + this.BOE + ", expiredTimeMsIfMixInBackground=" + this.BOF + ", supportCaptureLandscape=" + this.BOG + ", forcePortrait=" + this.BOH + ", autoAdjustFoldingScreen=" + this.BOI + ", router=" + this.hwc + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.BOh);
    paramParcel.writeInt(this.ilT);
    paramParcel.writeInt(this.BOi);
    paramParcel.writeInt(this.BOj);
    paramParcel.writeValue(this.BOk);
    paramParcel.writeValue(this.BOl);
    paramParcel.writeParcelable(this.BOm, paramInt);
    paramParcel.writeParcelable(this.BOn, paramInt);
    int i;
    if (this.BOo == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.BOp);
      paramParcel.writeValue(this.BOq);
      paramParcel.writeValue(this.BOr);
      paramParcel.writeValue(this.BOs);
      paramParcel.writeValue(this.BOt);
      paramParcel.writeValue(this.BOu);
      paramParcel.writeInt(this.BOv);
      if (!this.BOx) {
        break label367;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.BOy) {
        break label372;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.BOz);
      paramParcel.writeString(this.BOA);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.BOB);
      paramParcel.writeString(this.BOC);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.images);
      paramParcel.writeStringList(this.BOD);
      paramParcel.writeParcelable(this.BOE, paramInt);
      paramParcel.writeLong(this.BOF);
      if (!this.BOG) {
        break label377;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.BOH) {
        break label382;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.jkf);
      if (!this.BOI) {
        break label387;
      }
    }
    label387:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeSerializable(this.hwc);
      paramParcel.writeParcelable(this.BOJ, paramInt);
      paramParcel.writeInt(this.BOw);
      paramParcel.writeString(this.BOK);
      AppMethodBeat.o(101504);
      return;
      i = this.BOo.ordinal();
      break;
      label367:
      b1 = 0;
      break label164;
      label372:
      b1 = 0;
      break label178;
      label377:
      b1 = 0;
      break label273;
      label382:
      b1 = 0;
      break label287;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */