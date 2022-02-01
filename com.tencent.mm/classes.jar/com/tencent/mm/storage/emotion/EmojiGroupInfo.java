package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bg;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiGroupInfo
  extends bg
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiGroupInfo> CREATOR;
  public static int Jsm;
  public static int Jsn;
  public static int Jso;
  public static int Jsp;
  public static int Jsq;
  public static int Jsr;
  public static int Jss;
  public static int TYPE_CUSTOM;
  public static int TYPE_SYSTEM;
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(104983);
    c.a locala = new c.a();
    locala.GvF = new Field[29];
    locala.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "productID";
    locala.GvH.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.GvG = "productID";
    locala.columns[1] = "packIconUrl";
    locala.GvH.put("packIconUrl", "TEXT");
    localStringBuilder.append(" packIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "packGrayIconUrl";
    locala.GvH.put("packGrayIconUrl", "TEXT");
    localStringBuilder.append(" packGrayIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "packCoverUrl";
    locala.GvH.put("packCoverUrl", "TEXT");
    localStringBuilder.append(" packCoverUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "packName";
    locala.GvH.put("packName", "TEXT");
    localStringBuilder.append(" packName TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "packDesc";
    locala.GvH.put("packDesc", "TEXT");
    localStringBuilder.append(" packDesc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "packAuthInfo";
    locala.GvH.put("packAuthInfo", "TEXT");
    localStringBuilder.append(" packAuthInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "packPrice";
    locala.GvH.put("packPrice", "TEXT");
    localStringBuilder.append(" packPrice TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "packType";
    locala.GvH.put("packType", "INTEGER");
    localStringBuilder.append(" packType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "packFlag";
    locala.GvH.put("packFlag", "INTEGER");
    localStringBuilder.append(" packFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "packExpire";
    locala.GvH.put("packExpire", "LONG");
    localStringBuilder.append(" packExpire LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "packTimeStamp";
    locala.GvH.put("packTimeStamp", "LONG");
    localStringBuilder.append(" packTimeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "packCopyright";
    locala.GvH.put("packCopyright", "TEXT");
    localStringBuilder.append(" packCopyright TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "sort";
    locala.GvH.put("sort", "INTEGER default '1' ");
    localStringBuilder.append(" sort INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "lastUseTime";
    locala.GvH.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "packStatus";
    locala.GvH.put("packStatus", "INTEGER default '0' ");
    localStringBuilder.append(" packStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "flag";
    locala.GvH.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "recommand";
    locala.GvH.put("recommand", "INTEGER default '0' ");
    localStringBuilder.append(" recommand INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "sync";
    locala.GvH.put("sync", "INTEGER default '0' ");
    localStringBuilder.append(" sync INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "idx";
    locala.GvH.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[22] = "BigIconUrl";
    locala.GvH.put("BigIconUrl", "TEXT");
    localStringBuilder.append(" BigIconUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "MutiLanName";
    locala.GvH.put("MutiLanName", "TEXT");
    localStringBuilder.append(" MutiLanName TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "recommandType";
    locala.GvH.put("recommandType", "INTEGER default '-1' ");
    localStringBuilder.append(" recommandType INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[25] = "lang";
    locala.GvH.put("lang", "TEXT");
    localStringBuilder.append(" lang TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "recommandWord";
    locala.GvH.put("recommandWord", "TEXT");
    localStringBuilder.append(" recommandWord TEXT");
    localStringBuilder.append(", ");
    locala.columns[27] = "buttonType";
    locala.GvH.put("buttonType", "INTEGER");
    localStringBuilder.append(" buttonType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[28] = "count";
    locala.GvH.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    locala.columns[29] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    TYPE_SYSTEM = 1;
    Jsm = 2;
    TYPE_CUSTOM = 3;
    Jsn = 4;
    Jso = 256;
    Jsp = 17;
    Jsq = 18;
    Jsr = 81;
    Jss = 65;
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
  
  public final String aGJ()
  {
    return this.field_packName;
  }
  
  public final void aXI(String paramString)
  {
    this.field_packName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String fdm()
  {
    return this.field_productID;
  }
  
  public final String fdn()
  {
    return this.field_packGrayIconUrl;
  }
  
  public final EmotionSummary fdo()
  {
    AppMethodBeat.i(104979);
    EmotionSummary localEmotionSummary = new EmotionSummary();
    localEmotionSummary.ProductID = this.field_productID;
    localEmotionSummary.IconUrl = this.field_packIconUrl;
    localEmotionSummary.PackName = this.field_packName;
    localEmotionSummary.PackDesc = this.field_packDesc;
    localEmotionSummary.PackAuthInfo = this.field_packAuthInfo;
    localEmotionSummary.PackPrice = this.field_packPrice;
    localEmotionSummary.PackType = this.field_packType;
    localEmotionSummary.PackFlag = this.field_packFlag;
    localEmotionSummary.CoverUrl = this.field_packCoverUrl;
    localEmotionSummary.PackExpire = ((int)this.field_packExpire);
    localEmotionSummary.PackCopyright = this.field_packCopyright;
    localEmotionSummary.Timestamp = ((int)this.field_packTimeStamp);
    localEmotionSummary.PriceNum = this.field_packPrice;
    AppMethodBeat.o(104979);
    return localEmotionSummary;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final void setProductID(String paramString)
  {
    this.field_productID = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiGroupInfo
 * JD-Core Version:    0.7.0.1
 */