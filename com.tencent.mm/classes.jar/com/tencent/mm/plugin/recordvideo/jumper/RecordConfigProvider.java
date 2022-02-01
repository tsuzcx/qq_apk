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
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider
  implements Parcelable
{
  public static final Parcelable.Creator<RecordConfigProvider> CREATOR;
  public HashMap gGB;
  public int hpj;
  public Bundle ime;
  public int remuxType;
  public ArrayList<String> sCR;
  public int scene;
  public String thumbPath;
  public ArrayList<String> xyA;
  public VideoCaptureReportInfo xyB;
  public long xyC;
  public boolean xyD;
  public boolean xyE;
  public boolean xyF;
  public XEffectConfig xyG;
  public Boolean xye;
  public int xyf;
  public int xyg;
  public Boolean xyh;
  public Boolean xyi;
  public VideoTransPara xyj;
  public UICustomParam xyk;
  public i.e xyl;
  public int xym;
  public Boolean xyn;
  public Boolean xyo;
  public Boolean xyp;
  public Boolean xyq;
  public Boolean xyr;
  public int xyt;
  public boolean xyu;
  public boolean xyv;
  public String xyw;
  public String xyx;
  public String xyy;
  public String xyz;
  
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
    this.xye = Boolean.FALSE;
    this.hpj = 1080;
    this.xyf = 2;
    this.xyg = 1;
    this.xyh = Boolean.FALSE;
    this.xyi = Boolean.FALSE;
    new UICustomParam.a();
    this.xyk = UICustomParam.a.abt().gei;
    this.xyl = i.e.ESM;
    this.xym = 1;
    this.xyn = Boolean.FALSE;
    this.xyo = Boolean.TRUE;
    this.xyp = Boolean.TRUE;
    this.xyq = Boolean.TRUE;
    this.xyr = Boolean.TRUE;
    this.xyt = 10000;
    this.xyu = false;
    this.xyv = true;
    this.xyC = 259200000L;
    this.xyD = true;
    this.xyE = false;
    this.xyF = false;
    this.gGB = new HashMap();
    this.xyG = new XEffectConfig();
    AppMethodBeat.o(101502);
  }
  
  protected RecordConfigProvider(Parcel paramParcel)
  {
    AppMethodBeat.i(101505);
    this.remuxType = 1;
    this.xye = Boolean.FALSE;
    this.hpj = 1080;
    this.xyf = 2;
    this.xyg = 1;
    this.xyh = Boolean.FALSE;
    this.xyi = Boolean.FALSE;
    new UICustomParam.a();
    this.xyk = UICustomParam.a.abt().gei;
    this.xyl = i.e.ESM;
    this.xym = 1;
    this.xyn = Boolean.FALSE;
    this.xyo = Boolean.TRUE;
    this.xyp = Boolean.TRUE;
    this.xyq = Boolean.TRUE;
    this.xyr = Boolean.TRUE;
    this.xyt = 10000;
    this.xyu = false;
    this.xyv = true;
    this.xyC = 259200000L;
    this.xyD = true;
    this.xyE = false;
    this.xyF = false;
    this.gGB = new HashMap();
    this.xyG = new XEffectConfig();
    this.remuxType = paramParcel.readInt();
    this.xye = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.hpj = paramParcel.readInt();
    this.xyf = paramParcel.readInt();
    this.xyg = paramParcel.readInt();
    this.xyh = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.xyi = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.xyj = ((VideoTransPara)paramParcel.readParcelable(VideoTransPara.class.getClassLoader()));
    this.xyk = ((UICustomParam)paramParcel.readParcelable(UICustomParam.class.getClassLoader()));
    int i = paramParcel.readInt();
    i.e locale;
    if (i == -1)
    {
      locale = null;
      this.xyl = locale;
      this.xym = paramParcel.readInt();
      this.xyn = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyo = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyp = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyq = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyr = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
      this.xyt = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label618;
      }
      bool1 = true;
      label417:
      this.xyu = bool1;
      if (paramParcel.readByte() == 0) {
        break label623;
      }
      bool1 = true;
      label431:
      this.xyv = bool1;
      this.xyw = paramParcel.readString();
      this.xyx = paramParcel.readString();
      this.thumbPath = paramParcel.readString();
      this.xyy = paramParcel.readString();
      this.xyz = paramParcel.readString();
      this.scene = paramParcel.readInt();
      this.sCR = paramParcel.createStringArrayList();
      this.xyA = paramParcel.createStringArrayList();
      this.xyB = ((VideoCaptureReportInfo)paramParcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader()));
      this.xyC = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label628;
      }
      bool1 = true;
      label533:
      this.xyD = bool1;
      if (paramParcel.readByte() == 0) {
        break label633;
      }
      bool1 = true;
      label547:
      this.xyE = bool1;
      this.ime = paramParcel.readBundle();
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
      this.xyF = bool1;
      this.gGB = ((HashMap)paramParcel.readSerializable());
      this.xyG = ((XEffectConfig)paramParcel.readParcelable(XEffectConfig.class.getClassLoader()));
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
    localRecordConfigProvider.xyj = paramVideoTransPara;
    localRecordConfigProvider.xyo = Boolean.TRUE;
    localRecordConfigProvider.xyq = Boolean.TRUE;
    localRecordConfigProvider.xyr = Boolean.FALSE;
    localRecordConfigProvider.xyt = paramInt1;
    localRecordConfigProvider.xyx = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.scene = paramInt2;
    AppMethodBeat.o(101501);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider as(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(101498);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xyw = i.k(paramString1, false);
    localRecordConfigProvider.xyx = i.k(paramString2, true);
    localRecordConfigProvider.thumbPath = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      localRecordConfigProvider.thumbPath = i.k(paramString3, true);
    }
    localRecordConfigProvider.xyu = true;
    localRecordConfigProvider.xym = 4;
    AppMethodBeat.o(101498);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider dFI()
  {
    AppMethodBeat.i(101500);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xyo = Boolean.TRUE;
    localRecordConfigProvider.xyq = Boolean.TRUE;
    localRecordConfigProvider.xyr = Boolean.FALSE;
    localRecordConfigProvider.scene = 4;
    AppMethodBeat.o(101500);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101497);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xyy = i.k(paramString1, false);
    localRecordConfigProvider.xyz = i.k(paramString2, true);
    localRecordConfigProvider.xyu = true;
    localRecordConfigProvider.xym = 3;
    AppMethodBeat.o(101497);
    return localRecordConfigProvider;
  }
  
  public static RecordConfigProvider iJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(101499);
    RecordConfigProvider localRecordConfigProvider = new RecordConfigProvider();
    localRecordConfigProvider.xyx = i.k(paramString1, true);
    localRecordConfigProvider.thumbPath = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      localRecordConfigProvider.thumbPath = i.k(paramString2, true);
    }
    localRecordConfigProvider.xyu = true;
    localRecordConfigProvider.xym = 4;
    AppMethodBeat.o(101499);
    return localRecordConfigProvider;
  }
  
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(101503);
    this.gGB.put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(101503);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(101496);
    String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.xye + ", resolutionLimit=" + this.hpj + ", recordType=" + this.xyf + ", recordLevel=" + this.xyg + ", useCameraApi2=" + this.xyh + ", useImageStream=" + this.xyi + ", videoParam=" + this.xyj + ", uiParam=" + this.xyk + ", outputType=" + this.xym + ", previewForceFullScreen=" + this.xyn + ", enablePicture=" + this.xyo + ", enableVideo=" + this.xyp + ", forceForegroundMix=" + this.xyq + ", enableAlbum=" + this.xyr + ", maxRecordTimeMs=" + this.xyt + ", saveSourceMedia=" + this.xyu + ", savaToSysAlbumIfMediaEdited=" + this.xyv + ", inputVideoPath='" + this.xyw + '\'' + ", outputVideoPath='" + this.xyx + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.xyy + '\'' + ", outputPhotoPath='" + this.xyz + '\'' + ", scene=" + this.scene + ", images=" + this.sCR + ", videos=" + this.xyA + ", reportInfo=" + this.xyB + ", expiredTimeMsIfMixInBackground=" + this.xyC + ", supportCaptureLandscape=" + this.xyD + ", forcePortrait=" + this.xyE + ", autoAdjustFoldingScreen=" + this.xyF + ", router=" + this.gGB + '}';
    AppMethodBeat.o(101496);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(101504);
    paramParcel.writeInt(this.remuxType);
    paramParcel.writeValue(this.xye);
    paramParcel.writeInt(this.hpj);
    paramParcel.writeInt(this.xyf);
    paramParcel.writeInt(this.xyg);
    paramParcel.writeValue(this.xyh);
    paramParcel.writeValue(this.xyi);
    paramParcel.writeParcelable(this.xyj, paramInt);
    paramParcel.writeParcelable(this.xyk, paramInt);
    int i;
    if (this.xyl == null)
    {
      i = -1;
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.xym);
      paramParcel.writeValue(this.xyn);
      paramParcel.writeValue(this.xyo);
      paramParcel.writeValue(this.xyp);
      paramParcel.writeValue(this.xyq);
      paramParcel.writeValue(this.xyr);
      paramParcel.writeInt(this.xyt);
      if (!this.xyu) {
        break label351;
      }
      b1 = 1;
      label164:
      paramParcel.writeByte(b1);
      if (!this.xyv) {
        break label356;
      }
      b1 = 1;
      label178:
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.xyw);
      paramParcel.writeString(this.xyx);
      paramParcel.writeString(this.thumbPath);
      paramParcel.writeString(this.xyy);
      paramParcel.writeString(this.xyz);
      paramParcel.writeInt(this.scene);
      paramParcel.writeStringList(this.sCR);
      paramParcel.writeStringList(this.xyA);
      paramParcel.writeParcelable(this.xyB, paramInt);
      paramParcel.writeLong(this.xyC);
      if (!this.xyD) {
        break label361;
      }
      b1 = 1;
      label273:
      paramParcel.writeByte(b1);
      if (!this.xyE) {
        break label366;
      }
      b1 = 1;
      label287:
      paramParcel.writeByte(b1);
      paramParcel.writeBundle(this.ime);
      if (!this.xyF) {
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
      paramParcel.writeSerializable(this.gGB);
      paramParcel.writeParcelable(this.xyG, paramInt);
      AppMethodBeat.o(101504);
      return;
      i = this.xyl.ordinal();
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