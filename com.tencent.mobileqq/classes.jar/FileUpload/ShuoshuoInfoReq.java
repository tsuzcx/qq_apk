package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ShuoshuoInfoReq
  extends JceStruct
{
  static byte[] cache_busiData = (byte[])new byte[1];
  static ArrayList<ShuoshuoPicInfo> cache_pic_list;
  public byte[] busiData = null;
  public int iAlbumTypeID = 0;
  public long iBatchID = 0L;
  public ArrayList<ShuoshuoPicInfo> pic_list = null;
  public String sAlbumID = "";
  
  static
  {
    ((byte[])cache_busiData)[0] = 0;
    cache_pic_list = new ArrayList();
    ShuoshuoPicInfo localShuoshuoPicInfo = new ShuoshuoPicInfo();
    cache_pic_list.add(localShuoshuoPicInfo);
  }
  
  public ShuoshuoInfoReq() {}
  
  public ShuoshuoInfoReq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte, ArrayList<ShuoshuoPicInfo> paramArrayList)
  {
    this.sAlbumID = paramString;
    this.iAlbumTypeID = paramInt;
    this.iBatchID = paramLong;
    this.busiData = paramArrayOfByte;
    this.pic_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sAlbumID = paramJceInputStream.readString(0, true);
    this.iAlbumTypeID = paramJceInputStream.read(this.iAlbumTypeID, 1, true);
    this.iBatchID = paramJceInputStream.read(this.iBatchID, 2, true);
    this.busiData = ((byte[])paramJceInputStream.read(cache_busiData, 3, true));
    this.pic_list = ((ArrayList)paramJceInputStream.read(cache_pic_list, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sAlbumID, 0);
    paramJceOutputStream.write(this.iAlbumTypeID, 1);
    paramJceOutputStream.write(this.iBatchID, 2);
    paramJceOutputStream.write(this.busiData, 3);
    if (this.pic_list != null) {
      paramJceOutputStream.write(this.pic_list, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.ShuoshuoInfoReq
 * JD-Core Version:    0.7.0.1
 */