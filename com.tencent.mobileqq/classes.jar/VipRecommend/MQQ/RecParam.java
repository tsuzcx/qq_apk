package VipRecommend.MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RecParam
  extends JceStruct
{
  static PayParam cache_payParam;
  public String buttonText = "";
  public int canOpen = 0;
  public int h5Pay = 0;
  public int is_svip = 0;
  public int is_vip = 0;
  public int is_year = 0;
  public int openMode = 0;
  public int openMonth = 0;
  public PayParam payParam = null;
  public String type = "";
  
  public RecParam() {}
  
  public RecParam(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4, PayParam paramPayParam, int paramInt5, int paramInt6, int paramInt7)
  {
    this.canOpen = paramInt1;
    this.type = paramString1;
    this.openMode = paramInt2;
    this.openMonth = paramInt3;
    this.buttonText = paramString2;
    this.h5Pay = paramInt4;
    this.payParam = paramPayParam;
    this.is_vip = paramInt5;
    this.is_svip = paramInt6;
    this.is_year = paramInt7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.canOpen = paramJceInputStream.read(this.canOpen, 0, true);
    this.type = paramJceInputStream.readString(1, true);
    this.openMode = paramJceInputStream.read(this.openMode, 2, true);
    this.openMonth = paramJceInputStream.read(this.openMonth, 3, true);
    this.buttonText = paramJceInputStream.readString(4, true);
    this.h5Pay = paramJceInputStream.read(this.h5Pay, 5, true);
    if (cache_payParam == null) {
      cache_payParam = new PayParam();
    }
    this.payParam = ((PayParam)paramJceInputStream.read(cache_payParam, 6, true));
    this.is_vip = paramJceInputStream.read(this.is_vip, 7, true);
    this.is_svip = paramJceInputStream.read(this.is_svip, 8, true);
    this.is_year = paramJceInputStream.read(this.is_year, 9, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.canOpen, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.openMode, 2);
    paramJceOutputStream.write(this.openMonth, 3);
    paramJceOutputStream.write(this.buttonText, 4);
    paramJceOutputStream.write(this.h5Pay, 5);
    paramJceOutputStream.write(this.payParam, 6);
    paramJceOutputStream.write(this.is_vip, 7);
    paramJceOutputStream.write(this.is_svip, 8);
    paramJceOutputStream.write(this.is_year, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VipRecommend.MQQ.RecParam
 * JD-Core Version:    0.7.0.1
 */