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
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public Boolean HKP;
  public int HKQ;
  public Boolean HKR;
  public Boolean HKS;
  public UICustomParam HKT;
  public i.e HKU;
  public int HKV;
  public Boolean HKW;
  public Boolean HKX;
  public Boolean HKY;
  public Boolean HKZ;
  public Boolean HLa;
  public int HLb;
  public int HLc;
  public boolean HLd;
  public boolean HLe;
  public String HLf;
  public String HLg;
  public String HLh;
  public String HLi;
  public ArrayList<String> HLj;
  public VideoCaptureReportInfo HLk;
  public long HLl;
  public boolean HLm;
  public boolean HLn;
  public boolean HLo;
  public XEffectConfig HLp;
  public String HLq;
  public ArrayList<String> images;
  public HashMap kif;
  public int laT;
  public Bundle mab;
  public VideoTransPara mfk;
  public int recordType;
  public int remuxType;
  public int scene;
  public String thumbPath;
  
  static
  {
    AppMethodBeat.i(101506);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101506);
  }
  
  private RecordConfigProvider()
  {
    AppMethodBeat.i(101502);
    this.remuxType = 1;
    this.HKP = Boolean.FALSE;
    this.laT = 1080;
    this.recordType = 2;
    this.HKQ = 1;
    this.HKR = Boolean.FALSE;
    this.HKS = Boolean.FALSE;
    new UICustomParam.a();
    this.HKT = UICustomParam.a.avS().jwj;
    this.HKU = i.e.RcE;
    this.HKV = 1;
    this.HKW = Boolean.FALSE;
    this.HKX = Boolean.TRUE;
    this.HKY = Boolean.TRUE;
    this.HKZ = Boolean.TRUE;
    this.HLa = Boolean.TRUE;
    this.HLb = 10000;
    this.HLc = -1;
    this.HLd = false;
    this.HLe = true;
    this.HLl = 259200000L;
    this.HLm = true;
    this.HLn = false;
    this.HLo = false;
    this.kif = new HashMap();
    this.HLp = new XEffectConfig();
    this.HLq = "";
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.HKP = Boolean.FALSE;
    this.laT = 1080;
    this.recordType = 2;
    this.HKQ = 1;
    this.HKR = Boolean.FALSE;
    this.HKS = Boolean.FALSE;
    new UICustomParam.a();
    this.HKT = UICustomParam.a.avS().jwj;
    this.HKU = i.e.RcE;
    this.HKV = 1;
    this.HKW = Boolean.FALSE;
    this.HKX = Boolean.TRUE;
    this.HKY = Boolean.TRUE;
    this.HKZ = Boolean.TRUE;
    this.HLa = Boolean.TRUE;
    this.HLb = 10000;
    this.HLc = -1;
    this.HLd = false;
    this.HLe = true;
    this.HLl = 259200000L;
    this.HLm = true;
    this.HLn = false;
    this.HLo = false;
    this.kif = new HashMap();
    this.HLp = new XEffectConfig();
    this.HLq = "";
    this.remuxType = paramParcel.readInt();
    this.HKP = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.laT = paramParcel.readInt();
    this.recordType = paramParcel.readInt();
    this.HKQ = paramParcel.readInt();
    this.HKR = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.HKS = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.mfk = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.HKT = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    i.e locale;
    if (i == -1)
    {
      locale = null;
      this.HKU = locale;
      this.HKV = paramParcel.readInt();
      this.HKW = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HKX = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HKY = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HKZ = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HLa = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.HLb = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label645;
      }
      bool1 = true;
      label428:
      this.HLd = bool1;
      if (paramParcel.readByte() == 0) {
        break label650;
      }
      bool1 = true;
      label442:
      this.HLe = bool1;
      this.HLf = paramParcel.readString();
      this.HLg = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.HLh = paramParcel.readString();
      this.HLi = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.images = paramParcel.createStringArrayList();
      this.HLj = paramParcel.createStringArrayList();
      this.HLk = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.HLl = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label655;
      }
      bool1 = true;
      label544:
      this.HLm = bool1;
      if (paramParcel.readByte() == 0) {
        break label660;
      }
      bool1 = true;
      label558:
      this.HLn = bool1;
      this.mab = paramParcel.readBundle();
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
      this.HLo = bool1;
      this.kif = ((HashMap)paramParcel.readSerializable());
      this.HLp = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
      this.HLc = paramParcel.readInt();
      this.HLq = paramParcel.readString();
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
    localRecordConfigProvider.mfk = paramVideoTransPara;
    localRecordConfigProvider.HKX = Boolean.TRUE;
    localRecordConfigProvider.HKZ = Boolean.TRUE;
    localRecordConfigProvider.HLa = Boolean.FALSE;
    localRecordConfigProvider.HLb = paramInt1;
    localRecordConfigProvider.HLg = u.n(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = u.n(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.HLf = u.n(paramString1, false);
    localRecordConfigProvider.HLg = u.n(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = u.n(paramString3, true);
    }
    localRecordConfigProvider.HLd = true;
    localRecordConfigProvider.HKV = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider fvX()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.HKX = Boolean.TRUE;
    localRecordConfigProvider.HKZ = Boolean.TRUE;
    localRecordConfigProvider.HLa = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider jO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.HLh = u.n(paramString1, false);
    localRecordConfigProvider.HLi = u.n(paramString2, true);
    localRecordConfigProvider.HLd = true;
    localRecordConfigProvider.HKV = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider jP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.HLg = u.n(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = u.n(paramString2, true);
    }
    localRecordConfigProvider.HLd = true;
    localRecordConfigProvider.HKV = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.kif.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.HKP + ", resolutionLimit=" + this.laT + ", recordType=" + this.recordType + ", recordLevel=" + this.HKQ + ", useCameraApi2=" + this.HKR + ", useImageStream=" + this.HKS + ", videoParam=" + this.mfk + ", uiParam=" + this.HKT + ", outputType=" + this.HKV + ", previewForceFullScreen=" + this.HKW + ", enablePicture=" + this.HKX + ", enableVideo=" + this.HKY + ", forceForegroundMix=" + this.HKZ + ", enableAlbum=" + this.HLa + ", maxRecordTimeMs=" + this.HLb + ", saveSourceMedia=" + this.HLd + ", savaToSysAlbumIfMediaEdited=" + this.HLe + ", inputVideoPath='" + this.HLf + '\'' + ", outputVideoPath='" + this.HLg + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.HLh + '\'' + ", outputPhotoPath='" + this.HLi + '\'' + ", scene=" + this.scene + ", images=" + this.images + ", videos=" + this.HLj + ", reportInfo=" + this.HLk + ", expiredTimeMsIfMixInBackground=" + this.HLl + ", supportCaptureLandscape=" + this.HLm + ", forcePortrait=" + this.HLn + ", autoAdjustFoldingScreen=" + this.HLo + ", router=" + this.kif + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.HKP);
    paramParcel.writeInt(this.laT);
    paramParcel.writeInt(this.recordType);
    paramParcel.writeInt(this.HKQ);
    paramParcel.writeValue(this.HKR);
    paramParcel.writeValue(this.HKS);
    paramParcel.writeParcelable(this.mfk, paramInt);
    paramParcel.writeParcelable(this.HKT, paramInt);
    int i;
    if (this.HKU == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.HKV);
      paramParcel.writeValue(this.HKW);
      paramParcel.writeValue(this.HKX);
      paramParcel.writeValue(this.HKY);
      paramParcel.writeValue(this.HKZ);
      paramParcel.writeValue(this.HLa);
      paramParcel.writeInt(this.HLb);
      if (!this.HLd) {
        break label367;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.HLe) {
        break label372;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.HLf);
      paramParcel.writeString(this.HLg);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.HLh);
      paramParcel.writeString(this.HLi);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.images);
      paramParcel.writeStringList(this.HLj);
      paramParcel.writeParcelable(this.HLk, paramInt);
      paramParcel.writeLong(this.HLl);
      if (!this.HLm) {
        break label377;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.HLn) {
        break label382;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.mab);
      if (!this.HLo) {
        break label387;
      }
    }
    label387:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeSerializable(this.kif);
      paramParcel.writeParcelable(this.HLp, paramInt);
      paramParcel.writeInt(this.HLc);
      paramParcel.writeString(this.HLq);
      AppMethodBeat.o(101504);
      return;
      i = this.HKU.ordinal();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */