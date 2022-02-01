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
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public int gXd;
  public HashMap gmS;
  public Bundle hSN;
  public ArrayList<String> rHT;
  public int remuxType;
  public int scene;
  public String thumbPath;
  public Boolean wqA;
  public Boolean wqB;
  public int wqC;
  public boolean wqD;
  public boolean wqE;
  public String wqF;
  public String wqG;
  public String wqH;
  public String wqI;
  public ArrayList<String> wqJ;
  public VideoCaptureReportInfo wqK;
  public long wqL;
  public boolean wqM;
  public boolean wqN;
  public boolean wqO;
  public XEffectConfig wqP;
  public Boolean wqo;
  public int wqp;
  public int wqq;
  public Boolean wqr;
  public Boolean wqs;
  public VideoTransPara wqt;
  public UICustomParam wqu;
  public h.e wqv;
  public int wqw;
  public Boolean wqx;
  public Boolean wqy;
  public Boolean wqz;
  
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
    this.wqo = Boolean.FALSE;
    this.gXd = 1080;
    this.wqp = 2;
    this.wqq = 1;
    this.wqr = Boolean.FALSE;
    this.wqs = Boolean.FALSE;
    new UICustomParam.a();
    this.wqu = UICustomParam.a.YS().fKH;
    this.wqv = h.e.DnH;
    this.wqw = 1;
    this.wqx = Boolean.FALSE;
    this.wqy = Boolean.TRUE;
    this.wqz = Boolean.TRUE;
    this.wqA = Boolean.TRUE;
    this.wqB = Boolean.TRUE;
    this.wqC = 10000;
    this.wqD = false;
    this.wqE = true;
    this.wqL = 259200000L;
    this.wqM = true;
    this.wqN = false;
    this.wqO = false;
    this.gmS = new HashMap();
    this.wqP = new XEffectConfig();
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.wqo = Boolean.FALSE;
    this.gXd = 1080;
    this.wqp = 2;
    this.wqq = 1;
    this.wqr = Boolean.FALSE;
    this.wqs = Boolean.FALSE;
    new UICustomParam.a();
    this.wqu = UICustomParam.a.YS().fKH;
    this.wqv = h.e.DnH;
    this.wqw = 1;
    this.wqx = Boolean.FALSE;
    this.wqy = Boolean.TRUE;
    this.wqz = Boolean.TRUE;
    this.wqA = Boolean.TRUE;
    this.wqB = Boolean.TRUE;
    this.wqC = 10000;
    this.wqD = false;
    this.wqE = true;
    this.wqL = 259200000L;
    this.wqM = true;
    this.wqN = false;
    this.wqO = false;
    this.gmS = new HashMap();
    this.wqP = new XEffectConfig();
    this.remuxType = paramParcel.readInt();
    this.wqo = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.gXd = paramParcel.readInt();
    this.wqp = paramParcel.readInt();
    this.wqq = paramParcel.readInt();
    this.wqr = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.wqs = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.wqt = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.wqu = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    h.e locale;
    if (i == -1)
    {
      locale = null;
      this.wqv = locale;
      this.wqw = paramParcel.readInt();
      this.wqx = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqy = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqz = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqA = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqB = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.wqC = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label618;
      }
      bool1 = true;
      label417:
      this.wqD = bool1;
      if (paramParcel.readByte() == 0) {
        break label623;
      }
      bool1 = true;
      label431:
      this.wqE = bool1;
      this.wqF = paramParcel.readString();
      this.wqG = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.wqH = paramParcel.readString();
      this.wqI = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.rHT = paramParcel.createStringArrayList();
      this.wqJ = paramParcel.createStringArrayList();
      this.wqK = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.wqL = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label628;
      }
      bool1 = true;
      label533:
      this.wqM = bool1;
      if (paramParcel.readByte() == 0) {
        break label633;
      }
      bool1 = true;
      label547:
      this.wqN = bool1;
      this.hSN = paramParcel.readBundle();
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
      this.wqO = bool1;
      this.gmS = ((HashMap)paramParcel.readSerializable());
      this.wqP = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
      AppMethodBeat.o(101505);
      return;
      locale = h.e.values()[i];
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
    localRecordConfigProvider.wqt = paramVideoTransPara;
    localRecordConfigProvider.wqy = Boolean.TRUE;
    localRecordConfigProvider.wqA = Boolean.TRUE;
    localRecordConfigProvider.wqB = Boolean.FALSE;
    localRecordConfigProvider.wqC = paramInt1;
    localRecordConfigProvider.wqG = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.wqF = i.k(paramString1, true);
    localRecordConfigProvider.wqG = i.k(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = i.k(paramString3, true);
    }
    localRecordConfigProvider.wqD = true;
    localRecordConfigProvider.wqw = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider dvn()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.wqy = Boolean.TRUE;
    localRecordConfigProvider.wqA = Boolean.TRUE;
    localRecordConfigProvider.wqB = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.wqH = i.k(paramString1, true);
    localRecordConfigProvider.wqI = i.k(paramString2, true);
    localRecordConfigProvider.wqD = true;
    localRecordConfigProvider.wqw = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.wqG = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.wqD = true;
    localRecordConfigProvider.wqw = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.gmS.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.wqo + ", resolutionLimit=" + this.gXd + ", recordType=" + this.wqp + ", recordLevel=" + this.wqq + ", useCameraApi2=" + this.wqr + ", useImageStream=" + this.wqs + ", videoParam=" + this.wqt + ", uiParam=" + this.wqu + ", outputType=" + this.wqw + ", previewForceFullScreen=" + this.wqx + ", enablePicture=" + this.wqy + ", enableVideo=" + this.wqz + ", forceForegroundMix=" + this.wqA + ", enableAlbum=" + this.wqB + ", maxRecordTimeMs=" + this.wqC + ", saveSourceMedia=" + this.wqD + ", savaToSysAlbumIfMediaEdited=" + this.wqE + ", inputVideoPath='" + this.wqF + '\'' + ", outputVideoPath='" + this.wqG + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.wqH + '\'' + ", outputPhotoPath='" + this.wqI + '\'' + ", scene=" + this.scene + ", images=" + this.rHT + ", videos=" + this.wqJ + ", reportInfo=" + this.wqK + ", expiredTimeMsIfMixInBackground=" + this.wqL + ", supportCaptureLandscape=" + this.wqM + ", forcePortrait=" + this.wqN + ", autoAdjustFoldingScreen=" + this.wqO + ", router=" + this.gmS + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.wqo);
    paramParcel.writeInt(this.gXd);
    paramParcel.writeInt(this.wqp);
    paramParcel.writeInt(this.wqq);
    paramParcel.writeValue(this.wqr);
    paramParcel.writeValue(this.wqs);
    paramParcel.writeParcelable(this.wqt, paramInt);
    paramParcel.writeParcelable(this.wqu, paramInt);
    int i;
    if (this.wqv == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.wqw);
      paramParcel.writeValue(this.wqx);
      paramParcel.writeValue(this.wqy);
      paramParcel.writeValue(this.wqz);
      paramParcel.writeValue(this.wqA);
      paramParcel.writeValue(this.wqB);
      paramParcel.writeInt(this.wqC);
      if (!this.wqD) {
        break label351;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.wqE) {
        break label356;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.wqF);
      paramParcel.writeString(this.wqG);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.wqH);
      paramParcel.writeString(this.wqI);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.rHT);
      paramParcel.writeStringList(this.wqJ);
      paramParcel.writeParcelable(this.wqK, paramInt);
      paramParcel.writeLong(this.wqL);
      if (!this.wqM) {
        break label361;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.wqN) {
        break label366;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.hSN);
      if (!this.wqO) {
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
      paramParcel.writeSerializable(this.gmS);
      paramParcel.writeParcelable(this.wqP, paramInt);
      AppMethodBeat.o(101504);
      return;
      i = this.wqv.ordinal();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */