package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiGroupInfo
  extends bi
  implements Parcelable
{
  public static final Parcelable.Creator<EmojiGroupInfo> CREATOR;
  public static int TYPE_CUSTOM;
  public static int TYPE_SYSTEM;
  public static int Uuj;
  public static int Uuk;
  public static int Uul;
  public static int Uum;
  public static int Uun;
  public static int Uuo;
  public static int Uup;
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(104983);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[29];
    localMAutoDBInfo.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "productID";
    localMAutoDBInfo.colsMap.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "productID";
    localMAutoDBInfo.columns[1] = "packIconUrl";
    localMAutoDBInfo.colsMap.put("packIconUrl", "TEXT");
    localStringBuilder.append(" packIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "packGrayIconUrl";
    localMAutoDBInfo.colsMap.put("packGrayIconUrl", "TEXT");
    localStringBuilder.append(" packGrayIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "packCoverUrl";
    localMAutoDBInfo.colsMap.put("packCoverUrl", "TEXT");
    localStringBuilder.append(" packCoverUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "packName";
    localMAutoDBInfo.colsMap.put("packName", "TEXT");
    localStringBuilder.append(" packName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "packDesc";
    localMAutoDBInfo.colsMap.put("packDesc", "TEXT");
    localStringBuilder.append(" packDesc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "packAuthInfo";
    localMAutoDBInfo.colsMap.put("packAuthInfo", "TEXT");
    localStringBuilder.append(" packAuthInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "packPrice";
    localMAutoDBInfo.colsMap.put("packPrice", "TEXT");
    localStringBuilder.append(" packPrice TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "packType";
    localMAutoDBInfo.colsMap.put("packType", "INTEGER");
    localStringBuilder.append(" packType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "packFlag";
    localMAutoDBInfo.colsMap.put("packFlag", "INTEGER");
    localStringBuilder.append(" packFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "packExpire";
    localMAutoDBInfo.colsMap.put("packExpire", "LONG");
    localStringBuilder.append(" packExpire LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "packTimeStamp";
    localMAutoDBInfo.colsMap.put("packTimeStamp", "LONG");
    localStringBuilder.append(" packTimeStamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "packCopyright";
    localMAutoDBInfo.colsMap.put("packCopyright", "TEXT");
    localStringBuilder.append(" packCopyright TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "sort";
    localMAutoDBInfo.colsMap.put("sort", "INTEGER default '1' ");
    localStringBuilder.append(" sort INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "packStatus";
    localMAutoDBInfo.colsMap.put("packStatus", "INTEGER default '0' ");
    localStringBuilder.append(" packStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "recommand";
    localMAutoDBInfo.colsMap.put("recommand", "INTEGER default '0' ");
    localStringBuilder.append(" recommand INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "sync";
    localMAutoDBInfo.colsMap.put("sync", "INTEGER default '0' ");
    localStringBuilder.append(" sync INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "idx";
    localMAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "BigIconUrl";
    localMAutoDBInfo.colsMap.put("BigIconUrl", "TEXT");
    localStringBuilder.append(" BigIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "MutiLanName";
    localMAutoDBInfo.colsMap.put("MutiLanName", "TEXT");
    localStringBuilder.append(" MutiLanName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "recommandType";
    localMAutoDBInfo.colsMap.put("recommandType", "INTEGER default '-1' ");
    localStringBuilder.append(" recommandType INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "lang";
    localMAutoDBInfo.colsMap.put("lang", "TEXT");
    localStringBuilder.append(" lang TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "recommandWord";
    localMAutoDBInfo.colsMap.put("recommandWord", "TEXT");
    localStringBuilder.append(" recommandWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "buttonType";
    localMAutoDBInfo.colsMap.put("buttonType", "INTEGER");
    localStringBuilder.append(" buttonType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "count";
    localMAutoDBInfo.colsMap.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    localMAutoDBInfo.columns[29] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    TYPE_SYSTEM = 1;
    Uuj = 2;
    TYPE_CUSTOM = 3;
    Uuk = 4;
    Uul = 256;
    Uum = 17;
    Uun = 18;
    Uuo = 81;
    Uup = 65;
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
  
  public final String beq()
  {
    return this.field_packName;
  }
  
  public final void bxl(String paramString)
  {
    this.field_packName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String hRu()
  {
    return this.field_productID;
  }
  
  public final String hRv()
  {
    return this.field_packGrayIconUrl;
  }
  
  public final EmotionSummary hRw()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiGroupInfo
 * JD-Core Version:    0.7.0.1
 */