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
  public int gwG;
  public Bundle hsl;
  public ArrayList<String> qMA;
  public int scene;
  public String thumbPath;
  public int vhB;
  public Boolean vhC;
  public int vhD;
  public int vhE;
  public Boolean vhF;
  public Boolean vhG;
  public VideoTransPara vhH;
  public UICustomParam vhI;
  public h.e vhJ;
  public int vhK;
  public Boolean vhL;
  public Boolean vhM;
  public Boolean vhN;
  public Boolean vhO;
  public Boolean vhP;
  public int vhQ;
  public boolean vhR;
  public boolean vhS;
  public String vhT;
  public String vhU;
  public String vhV;
  public String vhW;
  public ArrayList<String> vhX;
  public VideoCaptureReportInfo vhY;
  public long vhZ;
  public boolean vib;
  public boolean vic;
  public boolean vid;
  public HashMap vie;
  public XEffectConfig vif;
  
  static
  {
    AppMethodBeat.i(101506);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(101506);
  }
  
  private RecordConfigProvider()
  {
    AppMethodBeat.i(101502);
    this.vhB = 1;
    this.vhC = Boolean.FALSE;
    this.gwG = 1080;
    this.vhD = 2;
    this.vhE = 1;
    this.vhF = Boolean.FALSE;
    this.vhG = Boolean.FALSE;
    new UICustomParam.a();
    this.vhI = UICustomParam.a.XV().fHa;
    this.vhJ = h.e.BVq;
    this.vhK = 1;
    this.vhL = Boolean.FALSE;
    this.vhM = Boolean.TRUE;
    this.vhN = Boolean.TRUE;
    this.vhO = Boolean.TRUE;
    this.vhP = Boolean.TRUE;
    this.vhQ = 10000;
    this.vhR = false;
    this.vhS = true;
    this.vhZ = 259200000L;
    this.vib = true;
    this.vic = false;
    this.vid = false;
    this.vie = new HashMap();
    this.vif = new XEffectConfig();
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.vhB = 1;
    this.vhC = Boolean.FALSE;
    this.gwG = 1080;
    this.vhD = 2;
    this.vhE = 1;
    this.vhF = Boolean.FALSE;
    this.vhG = Boolean.FALSE;
    new UICustomParam.a();
    this.vhI = UICustomParam.a.XV().fHa;
    this.vhJ = h.e.BVq;
    this.vhK = 1;
    this.vhL = Boolean.FALSE;
    this.vhM = Boolean.TRUE;
    this.vhN = Boolean.TRUE;
    this.vhO = Boolean.TRUE;
    this.vhP = Boolean.TRUE;
    this.vhQ = 10000;
    this.vhR = false;
    this.vhS = true;
    this.vhZ = 259200000L;
    this.vib = true;
    this.vic = false;
    this.vid = false;
    this.vie = new HashMap();
    this.vif = new XEffectConfig();
    this.vhB = paramParcel.readInt();
    this.vhC = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.gwG = paramParcel.readInt();
    this.vhD = paramParcel.readInt();
    this.vhE = paramParcel.readInt();
    this.vhF = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.vhG = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.vhH = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.vhI = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    h.e locale;
    if (i == -1)
    {
      locale = null;
      this.vhJ = locale;
      this.vhK = paramParcel.readInt();
      this.vhL = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhM = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhN = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhO = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhP = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.vhQ = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label618;
      }
      bool1 = true;
      label417:
      this.vhR = bool1;
      if (paramParcel.readByte() == 0) {
        break label623;
      }
      bool1 = true;
      label431:
      this.vhS = bool1;
      this.vhT = paramParcel.readString();
      this.vhU = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.vhV = paramParcel.readString();
      this.vhW = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.qMA = paramParcel.createStringArrayList();
      this.vhX = paramParcel.createStringArrayList();
      this.vhY = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.vhZ = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label628;
      }
      bool1 = true;
      label533:
      this.vib = bool1;
      if (paramParcel.readByte() == 0) {
        break label633;
      }
      bool1 = true;
      label547:
      this.vic = bool1;
      this.hsl = paramParcel.readBundle();
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
      this.vid = bool1;
      this.vie = ((HashMap)paramParcel.readSerializable());
      this.vif = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
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
    localRecordConfigProvider.vhH = paramVideoTransPara;
    localRecordConfigProvider.vhM = Boolean.TRUE;
    localRecordConfigProvider.vhO = Boolean.TRUE;
    localRecordConfigProvider.vhP = Boolean.FALSE;
    localRecordConfigProvider.vhQ = paramInt1;
    localRecordConfigProvider.vhU = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider aj(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.vhT = i.k(paramString1, true);
    localRecordConfigProvider.vhU = i.k(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = i.k(paramString3, true);
    }
    localRecordConfigProvider.vhR = true;
    localRecordConfigProvider.vhK = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider dhF()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.vhM = Boolean.TRUE;
    localRecordConfigProvider.vhO = Boolean.TRUE;
    localRecordConfigProvider.vhP = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider ic(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.vhV = i.k(paramString1, true);
    localRecordConfigProvider.vhW = i.k(paramString2, true);
    localRecordConfigProvider.vhR = true;
    localRecordConfigProvider.vhK = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider id(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.vhU = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.vhR = true;
    localRecordConfigProvider.vhK = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void bx(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.vie.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.vhB + ", useCPUCrop=" + this.vhC + ", resolutionLimit=" + this.gwG + ", recordType=" + this.vhD + ", recordLevel=" + this.vhE + ", useCameraApi2=" + this.vhF + ", useImageStream=" + this.vhG + ", videoParam=" + this.vhH + ", uiParam=" + this.vhI + ", outputType=" + this.vhK + ", previewForceFullScreen=" + this.vhL + ", enablePicture=" + this.vhM + ", enableVideo=" + this.vhN + ", forceForegroundMix=" + this.vhO + ", enableAlbum=" + this.vhP + ", maxRecordTimeMs=" + this.vhQ + ", saveSourceMedia=" + this.vhR + ", savaToSysAlbumIfMediaEdited=" + this.vhS + ", inputVideoPath='" + this.vhT + '\'' + ", outputVideoPath='" + this.vhU + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.vhV + '\'' + ", outputPhotoPath='" + this.vhW + '\'' + ", scene=" + this.scene + ", images=" + this.qMA + ", videos=" + this.vhX + ", reportInfo=" + this.vhY + ", expiredTimeMsIfMixInBackground=" + this.vhZ + ", supportCaptureLandscape=" + this.vib + ", forcePortrait=" + this.vic + ", autoAdjustFoldingScreen=" + this.vid + ", router=" + this.vie + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.vhB);
    paramParcel.writeValue(this.vhC);
    paramParcel.writeInt(this.gwG);
    paramParcel.writeInt(this.vhD);
    paramParcel.writeInt(this.vhE);
    paramParcel.writeValue(this.vhF);
    paramParcel.writeValue(this.vhG);
    paramParcel.writeParcelable(this.vhH, paramInt);
    paramParcel.writeParcelable(this.vhI, paramInt);
    int i;
    if (this.vhJ == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.vhK);
      paramParcel.writeValue(this.vhL);
      paramParcel.writeValue(this.vhM);
      paramParcel.writeValue(this.vhN);
      paramParcel.writeValue(this.vhO);
      paramParcel.writeValue(this.vhP);
      paramParcel.writeInt(this.vhQ);
      if (!this.vhR) {
        break label351;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.vhS) {
        break label356;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.vhT);
      paramParcel.writeString(this.vhU);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.vhV);
      paramParcel.writeString(this.vhW);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.qMA);
      paramParcel.writeStringList(this.vhX);
      paramParcel.writeParcelable(this.vhY, paramInt);
      paramParcel.writeLong(this.vhZ);
      if (!this.vib) {
        break label361;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.vic) {
        break label366;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.hsl);
      if (!this.vid) {
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
      paramParcel.writeSerializable(this.vie);
      paramParcel.writeParcelable(this.vif, paramInt);
      AppMethodBeat.o(101504);
      return;
      i = this.vhJ.ordinal();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
 * JD-Core Version:    0.7.0.1
 */