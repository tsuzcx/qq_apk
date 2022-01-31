package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.h.c.ay;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiGroupInfo
  extends ay
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiGroupInfo> CREATOR = new EmojiGroupInfo.1();
  public static int TYPE_CUSTOM;
  public static int TYPE_SYSTEM;
  protected static c.a buS;
  public static int uCN;
  public static int uCO;
  public static int uCP;
  public static int uCQ;
  public static int uCR;
  public static int uCS;
  public static int uCT;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[29];
    locala.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.ujN.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.ujM = "productID";
    locala.columns[1] = "packIconUrl";
    locala.ujN.put("packIconUrl", "TEXT");
    localStringBuilder.append(" packIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "packGrayIconUrl";
    locala.ujN.put("packGrayIconUrl", "TEXT");
    localStringBuilder.append(" packGrayIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "packCoverUrl";
    locala.ujN.put("packCoverUrl", "TEXT");
    localStringBuilder.append(" packCoverUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "packName";
    locala.ujN.put("packName", "TEXT");
    localStringBuilder.append(" packName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "packDesc";
    locala.ujN.put("packDesc", "TEXT");
    localStringBuilder.append(" packDesc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "packAuthInfo";
    locala.ujN.put("packAuthInfo", "TEXT");
    localStringBuilder.append(" packAuthInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packPrice";
    locala.ujN.put("packPrice", "TEXT");
    localStringBuilder.append(" packPrice TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "packType";
    locala.ujN.put("packType", "INTEGER");
    localStringBuilder.append(" packType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "packFlag";
    locala.ujN.put("packFlag", "INTEGER");
    localStringBuilder.append(" packFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "packExpire";
    locala.ujN.put("packExpire", "LONG");
    localStringBuilder.append(" packExpire LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "packTimeStamp";
    locala.ujN.put("packTimeStamp", "LONG");
    localStringBuilder.append(" packTimeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "packCopyright";
    locala.ujN.put("packCopyright", "TEXT");
    localStringBuilder.append(" packCopyright TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "sort";
    locala.ujN.put("sort", "INTEGER default '1' ");
    localStringBuilder.append(" sort INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "lastUseTime";
    locala.ujN.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "packStatus";
    locala.ujN.put("packStatus", "INTEGER default '0' ");
    localStringBuilder.append(" packStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "flag";
    locala.ujN.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "recommand";
    locala.ujN.put("recommand", "INTEGER default '0' ");
    localStringBuilder.append(" recommand INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "sync";
    locala.ujN.put("sync", "INTEGER default '0' ");
    localStringBuilder.append(" sync INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "idx";
    locala.ujN.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "BigIconUrl";
    locala.ujN.put("BigIconUrl", "TEXT");
    localStringBuilder.append(" BigIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "MutiLanName";
    locala.ujN.put("MutiLanName", "TEXT");
    localStringBuilder.append(" MutiLanName TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "recommandType";
    locala.ujN.put("recommandType", "INTEGER default '-1' ");
    localStringBuilder.append(" recommandType INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "lang";
    locala.ujN.put("lang", "TEXT");
    localStringBuilder.append(" lang TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "recommandWord";
    locala.ujN.put("recommandWord", "TEXT");
    localStringBuilder.append(" recommandWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "buttonType";
    locala.ujN.put("buttonType", "INTEGER");
    localStringBuilder.append(" buttonType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "count";
    locala.ujN.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    locala.columns[29] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
    TYPE_SYSTEM = 1;
    uCN = 2;
    TYPE_CUSTOM = 3;
    uCO = 4;
    uCP = 256;
    uCQ = 17;
    uCR = 18;
    uCS = 81;
    uCT = 65;
  }
  
  public EmojiGroupInfo() {}
  
  protected EmojiGroupInfo(Parcel paramParcel)
  {
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
    this.ujK = paramParcel.readLong();
  }
  
  public final vn cwf()
  {
    vn localvn = new vn();
    localvn.syc = this.field_productID;
    localvn.kSy = this.field_packIconUrl;
    localvn.sSc = this.field_packName;
    localvn.sSd = this.field_packDesc;
    localvn.sSe = this.field_packAuthInfo;
    localvn.sSf = this.field_packPrice;
    localvn.sSg = this.field_packType;
    localvn.sSh = this.field_packFlag;
    localvn.sSk = this.field_packCoverUrl;
    localvn.sSl = ((int)this.field_packExpire);
    localvn.sSm = this.field_packCopyright;
    localvn.sSK = ((int)this.field_packTimeStamp);
    localvn.sSn = this.field_packPrice;
    return localvn;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("field_productID:").append(this.field_productID).append("\n");
    localStringBuilder.append("field_packIconUrl:").append(this.field_packIconUrl).append("\n");
    localStringBuilder.append("field_packGrayIconUrl:").append(this.field_packGrayIconUrl).append("\n");
    localStringBuilder.append("field_packCoverUrl:").append(this.field_packCoverUrl).append("\n");
    localStringBuilder.append("field_packName:").append(this.field_packName).append("\n");
    localStringBuilder.append("field_packDesc:").append(this.field_packDesc).append("\n");
    localStringBuilder.append("field_packAuthInfo:").append(this.field_packAuthInfo).append("\n");
    localStringBuilder.append("field_packPrice:").append(this.field_packPrice).append("\n");
    localStringBuilder.append("field_packType:").append(this.field_packType).append("\n");
    localStringBuilder.append("field_packFlag:").append(this.field_packFlag).append("\n");
    localStringBuilder.append("field_packExpire:").append(this.field_packExpire).append("\n");
    localStringBuilder.append("field_packTimeStamp:").append(this.field_packTimeStamp).append("\n");
    localStringBuilder.append("field_packCopyright:").append(this.field_packCopyright).append("\n");
    localStringBuilder.append("field_type:").append(this.field_type).append("\n");
    localStringBuilder.append("field_status:").append(this.field_status).append("\n");
    localStringBuilder.append("field_sort:").append(this.field_sort).append("\n");
    localStringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    localStringBuilder.append("field_packStatus:").append(this.field_packStatus).append("\n");
    localStringBuilder.append("field_recommand:").append(this.field_recommand).append("\n");
    localStringBuilder.append("field_sync:").append(this.field_sync).append("\n");
    localStringBuilder.append("field_idx:").append(this.field_idx).append("\n");
    localStringBuilder.append("field_BigIconUrl:").append(this.field_BigIconUrl).append("\n");
    localStringBuilder.append("field_MutiLanName:").append(this.field_MutiLanName).append("\n");
    localStringBuilder.append("field_count:").append(this.field_count).append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
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
    paramParcel.writeLong(this.ujK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiGroupInfo
 * JD-Core Version:    0.7.0.1
 */