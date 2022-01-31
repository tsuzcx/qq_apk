package AvatarInfo;

import a;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQHeadInfo
  extends JceStruct
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QQHeadInfo> CREATOR = new a();
  public byte cHeadType;
  public String downLoadUrl = "";
  public byte dstUsrType;
  public byte dwFaceFlgas;
  public long dwTimestamp;
  public byte headLevel;
  public String headVerify = "";
  public int idType;
  public int originUsrType;
  public String phoneNum = "";
  public short systemHeadID;
  public long uin;
  
  public QQHeadInfo() {}
  
  public QQHeadInfo(long paramLong1, long paramLong2, byte paramByte1, byte paramByte2, byte paramByte3, String paramString1, short paramShort, String paramString2)
  {
    this.uin = paramLong1;
    this.dwTimestamp = paramLong2;
    this.cHeadType = paramByte1;
    this.dstUsrType = paramByte2;
    this.dwFaceFlgas = paramByte3;
    this.downLoadUrl = paramString1;
    this.systemHeadID = paramShort;
    this.phoneNum = paramString2;
  }
  
  public QQHeadInfo(MultiHeadUrl.RspHeadInfo paramRspHeadInfo)
  {
    this.dwTimestamp = paramRspHeadInfo.timestamp.get();
    this.cHeadType = ((byte)paramRspHeadInfo.faceType.get());
    this.dstUsrType = 32;
    this.dwFaceFlgas = ((byte)paramRspHeadInfo.faceFlag.get());
    this.downLoadUrl = paramRspHeadInfo.url.get();
    this.systemHeadID = ((short)paramRspHeadInfo.sysid.get());
    this.originUsrType = paramRspHeadInfo.usrType.get();
    if (this.dstUsrType == 32) {
      this.headLevel = 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.dwTimestamp = paramJceInputStream.read(this.dwTimestamp, 1, true);
    this.cHeadType = paramJceInputStream.read(this.cHeadType, 2, true);
    this.dstUsrType = paramJceInputStream.read(this.dstUsrType, 3, true);
    this.dwFaceFlgas = paramJceInputStream.read(this.dwFaceFlgas, 4, true);
    this.downLoadUrl = paramJceInputStream.readString(5, true);
    this.systemHeadID = paramJceInputStream.read(this.systemHeadID, 6, false);
    this.phoneNum = paramJceInputStream.readString(7, false);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.uin = paramParcel.readLong();
    this.dwTimestamp = paramParcel.readLong();
    this.cHeadType = paramParcel.readByte();
    this.dstUsrType = paramParcel.readByte();
    this.dwFaceFlgas = paramParcel.readByte();
    this.downLoadUrl = paramParcel.readString();
    this.systemHeadID = ((short)paramParcel.readInt());
    this.phoneNum = paramParcel.readString();
    this.headLevel = paramParcel.readByte();
    this.idType = paramParcel.readInt();
    this.originUsrType = paramParcel.readInt();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("uin=").append(this.uin);
    localStringBuilder.append(",dwTimestamp=").append(this.dwTimestamp);
    localStringBuilder.append(",cHeadType=").append(this.cHeadType);
    localStringBuilder.append(",dstUsrType=").append(this.dstUsrType);
    localStringBuilder.append(",dwFaceFlgas=").append(this.dwFaceFlgas);
    localStringBuilder.append(",downLoadUrl=").append(this.downLoadUrl);
    localStringBuilder.append(",systemHeadID=").append(this.systemHeadID);
    localStringBuilder.append(",phoneNum=").append(this.phoneNum);
    localStringBuilder.append(",headLevel=").append(this.headLevel);
    localStringBuilder.append(",idType=").append(this.idType);
    localStringBuilder.append(",originUsrType=").append(this.originUsrType);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.dwTimestamp, 1);
    paramJceOutputStream.write(this.cHeadType, 2);
    paramJceOutputStream.write(this.dstUsrType, 3);
    paramJceOutputStream.write(this.dwFaceFlgas, 4);
    paramJceOutputStream.write(this.downLoadUrl, 5);
    paramJceOutputStream.write(this.systemHeadID, 6);
    if (this.phoneNum != null) {
      paramJceOutputStream.write(this.phoneNum, 7);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uin);
    paramParcel.writeLong(this.dwTimestamp);
    paramParcel.writeByte(this.cHeadType);
    paramParcel.writeByte(this.dstUsrType);
    paramParcel.writeByte(this.dwFaceFlgas);
    paramParcel.writeString(this.downLoadUrl);
    paramParcel.writeInt(this.systemHeadID);
    paramParcel.writeString(this.phoneNum);
    paramParcel.writeByte(this.headLevel);
    paramParcel.writeInt(this.idType);
    paramParcel.writeInt(this.originUsrType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AvatarInfo.QQHeadInfo
 * JD-Core Version:    0.7.0.1
 */