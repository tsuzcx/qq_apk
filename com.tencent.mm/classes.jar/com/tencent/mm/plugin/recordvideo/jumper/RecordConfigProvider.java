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
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public ArrayList<String> FQY;
  public Boolean NHN;
  public int NHO;
  public Boolean NHP;
  public Boolean NHQ;
  public UICustomParam NHR;
  public i.e NHS;
  public int NHT;
  public Boolean NHU;
  public Boolean NHV;
  public Boolean NHW;
  public Boolean NHX;
  public Boolean NHY;
  public int NHZ;
  public int NIa;
  public boolean NIb;
  public boolean NIc;
  public String NId;
  public String NIe;
  public String NIf;
  public String NIg;
  public ArrayList<String> NIh;
  public VideoCaptureReportInfo NIi;
  public long NIj;
  public boolean NIk;
  public boolean NIl;
  public boolean NIm;
  public XEffectConfig NIn;
  public String NIo;
  public boolean NIp;
  public boolean NIq;
  public HashMap mIB;
  public int nFY;
  public Bundle oSS;
  public VideoTransPara oXZ;
  public int recordType;
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
    this.NHN = Boolean.FALSE;
    this.nFY = 1080;
    this.recordType = 2;
    this.NHO = 1;
    this.NHP = Boolean.FALSE;
    this.NHQ = Boolean.FALSE;
    new UICustomParam.a();
    this.NHR = UICustomParam.a.aQr().lZB;
    this.NHS = i.e.XYK;
    this.NHT = 1;
    this.NHU = Boolean.FALSE;
    this.NHV = Boolean.TRUE;
    this.NHW = Boolean.TRUE;
    this.NHX = Boolean.TRUE;
    this.NHY = Boolean.TRUE;
    this.NHZ = 10000;
    this.NIa = -1;
    this.NIb = false;
    this.NIc = true;
    this.NIj = 259200000L;
    this.NIk = true;
    this.NIl = false;
    this.NIm = false;
    this.mIB = new HashMap();
    this.NIn = new XEffectConfig();
    this.NIo = "";
    this.NIp = false;
    this.NIq = false;
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.NHN = Boolean.FALSE;
    this.nFY = 1080;
    this.recordType = 2;
    this.NHO = 1;
    this.NHP = Boolean.FALSE;
    this.NHQ = Boolean.FALSE;
    new UICustomParam.a();
    this.NHR = UICustomParam.a.aQr().lZB;
    this.NHS = i.e.XYK;
    this.NHT = 1;
    this.NHU = Boolean.FALSE;
    this.NHV = Boolean.TRUE;
    this.NHW = Boolean.TRUE;
    this.NHX = Boolean.TRUE;
    this.NHY = Boolean.TRUE;
    this.NHZ = 10000;
    this.NIa = -1;
    this.NIb = false;
    this.NIc = true;
    this.NIj = 259200000L;
    this.NIk = true;
    this.NIl = false;
    this.NIm = false;
    this.mIB = new HashMap();
    this.NIn = new XEffectConfig();
    this.NIo = "";
    this.NIp = false;
    this.NIq = false;
    this.remuxType = paramParcel.readInt();
    this.NHN = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.nFY = paramParcel.readInt();
    this.recordType = paramParcel.readInt();
    this.NHO = paramParcel.readInt();
    this.NHP = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.NHQ = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.oXZ = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.NHR = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    i.e locale;
    if (i == -1)
    {
      locale = null;
      this.NHS = locale;
      this.NHT = paramParcel.readInt();
      this.NHU = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.NHV = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.NHW = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.NHX = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.NHY = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.NHZ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label684;
      }
      bool1 = true;
      label438:
      this.NIb = bool1;
      if (paramParcel.readByte() == 0) {
        break label689;
      }
      bool1 = true;
      label452:
      this.NIc = bool1;
      this.NId = paramParcel.readString();
      this.NIe = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.NIf = paramParcel.readString();
      this.NIg = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.FQY = paramParcel.createStringArrayList();
      this.NIh = paramParcel.createStringArrayList();
      this.NIi = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.NIj = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label694;
      }
      bool1 = true;
      label554:
      this.NIk = bool1;
      if (paramParcel.readByte() == 0) {
        break label699;
      }
      bool1 = true;
      label568:
      this.NIl = bool1;
      this.oSS = paramParcel.readBundle();
      if (paramParcel.readByte() == 0) {
        break label704;
      }
      bool1 = true;
      label590:
      this.NIm = bool1;
      this.mIB = ((HashMap)paramParcel.readSerializable());
      this.NIn = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
      this.NIa = paramParcel.readInt();
      this.NIo = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label709;
      }
      bool1 = true;
      label647:
      this.NIp = bool1;
      if (paramParcel.readInt() != 1) {
        break label714;
      }
    }
    label684:
    label689:
    label694:
    label699:
    label704:
    label709:
    label714:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.NIq = bool1;
      AppMethodBeat.o(101505);
      return;
      locale = i.e.values()[i];
      break;
      bool1 = false;
      break label438;
      bool1 = false;
      break label452;
      bool1 = false;
      break label554;
      bool1 = false;
      break label568;
      bool1 = false;
      break label590;
      bool1 = false;
      break label647;
    }
  }
  
  public static RecordConfigProvider a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(101501);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.oXZ = paramVideoTransPara;
    localRecordConfigProvider.NHV = Boolean.TRUE;
    localRecordConfigProvider.NHX = Boolean.TRUE;
    localRecordConfigProvider.NHY = Boolean.FALSE;
    localRecordConfigProvider.NHZ = paramInt1;
    localRecordConfigProvider.NIe = y.n(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = y.n(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider aM(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.NId = y.n(paramString1, false);
    localRecordConfigProvider.NIe = y.n(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = y.n(paramString3, true);
    }
    localRecordConfigProvider.NIb = true;
    localRecordConfigProvider.NHT = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider gHF()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.NHV = Boolean.TRUE;
    localRecordConfigProvider.NHX = Boolean.TRUE;
    localRecordConfigProvider.NHY = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider lj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.NIf = y.n(paramString1, false);
    localRecordConfigProvider.NIg = y.n(paramString2, true);
    localRecordConfigProvider.NIb = true;
    localRecordConfigProvider.NHT = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider lk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.NIe = y.n(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = y.n(paramString2, true);
    }
    localRecordConfigProvider.NIb = true;
    localRecordConfigProvider.NHT = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void cD(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.mIB.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.NHN + ", resolutionLimit=" + this.nFY + ", recordType=" + this.recordType + ", recordLevel=" + this.NHO + ", useCameraApi2=" + this.NHP + ", useImageStream=" + this.NHQ + ", videoParam=" + this.oXZ + ", uiParam=" + this.NHR + ", outputType=" + this.NHT + ", previewForceFullScreen=" + this.NHU + ", enablePicture=" + this.NHV + ", enableVideo=" + this.NHW + ", forceForegroundMix=" + this.NHX + ", enableAlbum=" + this.NHY + ", maxRecordTimeMs=" + this.NHZ + ", saveSourceMedia=" + this.NIb + ", savaToSysAlbumIfMediaEdited=" + this.NIc + ", inputVideoPath='" + this.NId + '\'' + ", outputVideoPath='" + this.NIe + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.NIf + '\'' + ", outputPhotoPath='" + this.NIg + '\'' + ", scene=" + this.scene + ", images=" + this.FQY + ", videos=" + this.NIh + ", reportInfo=" + this.NIi + ", expiredTimeMsIfMixInBackground=" + this.NIj + ", supportCaptureLandscape=" + this.NIk + ", forcePortrait=" + this.NIl + ", autoAdjustFoldingScreen=" + this.NIm + ", router=" + this.mIB + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.NHN);
    paramParcel.writeInt(this.nFY);
    paramParcel.writeInt(this.recordType);
    paramParcel.writeInt(this.NHO);
    paramParcel.writeValue(this.NHP);
    paramParcel.writeValue(this.NHQ);
    paramParcel.writeParcelable(this.oXZ, paramInt);
    paramParcel.writeParcelable(this.NHR, paramInt);
    int i;
    byte b;
    if (this.NHS == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.NHT);
      paramParcel.writeValue(this.NHU);
      paramParcel.writeValue(this.NHV);
      paramParcel.writeValue(this.NHW);
      paramParcel.writeValue(this.NHX);
      paramParcel.writeValue(this.NHY);
      paramParcel.writeInt(this.NHZ);
      if (!this.NIb) {
        break label395;
      }
      b = 1;
      label164:
      paramParcel.writeByte(b);
      if (!this.NIc) {
        break label400;
      }
      b = 1;
      label178:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.NId);
      paramParcel.writeString(this.NIe);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.NIf);
      paramParcel.writeString(this.NIg);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.FQY);
      paramParcel.writeStringList(this.NIh);
      paramParcel.writeParcelable(this.NIi, paramInt);
      paramParcel.writeLong(this.NIj);
      if (!this.NIk) {
        break label405;
      }
      b = 1;
      label273:
      paramParcel.writeByte(b);
      if (!this.NIl) {
        break label410;
      }
      b = 1;
      label287:
      paramParcel.writeByte(b);
      paramParcel.writeBundle(this.oSS);
      if (!this.NIm) {
        break label415;
      }
      b = 1;
      label309:
      paramParcel.writeByte(b);
      paramParcel.writeSerializable(this.mIB);
      paramParcel.writeParcelable(this.NIn, paramInt);
      paramParcel.writeInt(this.NIa);
      paramParcel.writeString(this.NIo);
      if (!this.NIp) {
        break label420;
      }
      b = 1;
      label356:
      paramParcel.writeByte(b);
      if (!this.NIq) {
        break label425;
      }
    }
    label395:
    label400:
    label405:
    label410:
    label415:
    label420:
    label425:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(101504);
      return;
      i = this.NHS.ordinal();
      break;
      b = 0;
      break label164;
      b = 0;
      break label178;
      b = 0;
      break label273;
      b = 0;
      break label287;
      b = 0;
      break label309;
      b = 0;
      break label356;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */