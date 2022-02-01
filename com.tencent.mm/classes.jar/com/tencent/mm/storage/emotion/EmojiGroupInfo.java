package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bl;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class EmojiGroupInfo
  extends bl
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiGroupInfo> CREATOR;
  public static int aklA;
  public static int aklB;
  public static int aklC;
  public static int aklD;
  public static int aklE;
  public static int aklF;
  public static int aklG;
  public static int akly;
  public static int aklz;
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(104983);
    info = bl.aJm();
    akly = 1;
    aklz = 2;
    aklA = 3;
    aklB = 4;
    aklC = 256;
    aklD = 17;
    aklE = 18;
    aklF = 81;
    aklG = 65;
    CREATOR = new EmojiGroupInfo.1();
    AppMethodBeat.o(104983);
  }
  
  public EmojiGroupInfo() {}
  
  protected EmojiGroupInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(104982);
    this.field_productID = paramParcel.readString();
    this.field_packIconUrl = paramParcel.readString();
    this.field_packGrayIconUrl = paramParcel.readString();
    this.field_packCoverUrl = paramParcel.readString();
    this.field_packName = paramParcel.readString();
    this.field_packDesc = paramParcel.readString();
    this.field_packAuthInfo = paramParcel.readString();
    this.field_packPrice = paramParcel.readString();
    this.field_packType = paramParcel.readInt();
    this.field_packFlag = paramParcel.readInt();
    this.field_packExpire = paramParcel.readLong();
    this.field_packTimeStamp = paramParcel.readLong();
    this.field_packCopyright = paramParcel.readString();
    this.field_type = paramParcel.readInt();
    this.field_status = paramParcel.readInt();
    this.field_sort = paramParcel.readInt();
    this.field_lastUseTime = paramParcel.readLong();
    this.field_packStatus = paramParcel.readInt();
    this.field_flag = paramParcel.readInt();
    this.field_recommand = paramParcel.readInt();
    this.field_sync = paramParcel.readInt();
    this.field_idx = paramParcel.readInt();
    this.field_BigIconUrl = paramParcel.readString();
    this.field_MutiLanName = paramParcel.readString();
    this.field_recommandType = paramParcel.readInt();
    this.field_lang = paramParcel.readString();
    this.field_recommandWord = paramParcel.readString();
    this.field_buttonType = paramParcel.readInt();
    this.field_count = paramParcel.readInt();
    this.systemRowid = paramParcel.readLong();
    AppMethodBeat.o(104982);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final cjb kLX()
  {
    AppMethodBeat.i(104979);
    cjb localcjb = new cjb();
    localcjb.ProductID = this.field_productID;
    localcjb.IHo = this.field_packGrayIconUrl;
    localcjb.Zul = this.field_packName;
    localcjb.akka = this.field_packDesc;
    localcjb.akkb = this.field_packAuthInfo;
    localcjb.akkc = this.field_packPrice;
    localcjb.akkd = this.field_packType;
    localcjb.akke = this.field_packFlag;
    localcjb.ZtY = this.field_packCoverUrl;
    localcjb.akkh = ((int)this.field_packExpire);
    localcjb.akki = this.field_packCopyright;
    localcjb.Zvi = ((int)this.field_packTimeStamp);
    localcjb.akkj = this.field_packPrice;
    AppMethodBeat.o(104979);
    return localcjb;
  }
  
  public String toString()
  {
    AppMethodBeat.i(104980);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("field_productID:").append(this.field_productID).append("\n");
    ((StringBuilder)localObject).append("field_packIconUrl:").append(this.field_packIconUrl).append("\n");
    ((StringBuilder)localObject).append("field_packGrayIconUrl:").append(this.field_packGrayIconUrl).append("\n");
    ((StringBuilder)localObject).append("field_packCoverUrl:").append(this.field_packCoverUrl).append("\n");
    ((StringBuilder)localObject).append("field_packName:").append(this.field_packName).append("\n");
    ((StringBuilder)localObject).append("field_packDesc:").append(this.field_packDesc).append("\n");
    ((StringBuilder)localObject).append("field_packAuthInfo:").append(this.field_packAuthInfo).append("\n");
    ((StringBuilder)localObject).append("field_packPrice:").append(this.field_packPrice).append("\n");
    ((StringBuilder)localObject).append("field_packType:").append(this.field_packType).append("\n");
    ((StringBuilder)localObject).append("field_packFlag:").append(this.field_packFlag).append("\n");
    ((StringBuilder)localObject).append("field_packExpire:").append(this.field_packExpire).append("\n");
    ((StringBuilder)localObject).append("field_packTimeStamp:").append(this.field_packTimeStamp).append("\n");
    ((StringBuilder)localObject).append("field_packCopyright:").append(this.field_packCopyright).append("\n");
    ((StringBuilder)localObject).append("field_type:").append(this.field_type).append("\n");
    ((StringBuilder)localObject).append("field_status:").append(this.field_status).append("\n");
    ((StringBuilder)localObject).append("field_sort:").append(this.field_sort).append("\n");
    ((StringBuilder)localObject).append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    ((StringBuilder)localObject).append("field_packStatus:").append(this.field_packStatus).append("\n");
    ((StringBuilder)localObject).append("field_recommand:").append(this.field_recommand).append("\n");
    ((StringBuilder)localObject).append("field_sync:").append(this.field_sync).append("\n");
    ((StringBuilder)localObject).append("field_idx:").append(this.field_idx).append("\n");
    ((StringBuilder)localObject).append("field_BigIconUrl:").append(this.field_BigIconUrl).append("\n");
    ((StringBuilder)localObject).append("field_MutiLanName:").append(this.field_MutiLanName).append("\n");
    ((StringBuilder)localObject).append("field_count:").append(this.field_count).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(104980);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(104981);
    paramParcel.writeString(this.field_productID);
    paramParcel.writeString(this.field_packIconUrl);
    paramParcel.writeString(this.field_packGrayIconUrl);
    paramParcel.writeString(this.field_packCoverUrl);
    paramParcel.writeString(this.field_packName);
    paramParcel.writeString(this.field_packDesc);
    paramParcel.writeString(this.field_packAuthInfo);
    paramParcel.writeString(this.field_packPrice);
    paramParcel.writeInt(this.field_packType);
    paramParcel.writeInt(this.field_packFlag);
    paramParcel.writeLong(this.field_packExpire);
    paramParcel.writeLong(this.field_packTimeStamp);
    paramParcel.writeString(this.field_packCopyright);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeInt(this.field_status);
    paramParcel.writeInt(this.field_sort);
    paramParcel.writeLong(this.field_lastUseTime);
    paramParcel.writeInt(this.field_packStatus);
    paramParcel.writeInt(this.field_flag);
    paramParcel.writeInt(this.field_recommand);
    paramParcel.writeInt(this.field_sync);
    paramParcel.writeInt(this.field_idx);
    paramParcel.writeString(this.field_BigIconUrl);
    paramParcel.writeString(this.field_MutiLanName);
    paramParcel.writeInt(this.field_recommandType);
    paramParcel.writeString(this.field_lang);
    paramParcel.writeString(this.field_recommandWord);
    paramParcel.writeInt(this.field_buttonType);
    paramParcel.writeInt(this.field_count);
    paramParcel.writeLong(this.systemRowid);
    AppMethodBeat.o(104981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiGroupInfo
 * JD-Core Version:    0.7.0.1
 */