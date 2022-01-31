package SecurityAccountServer;

import alpo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import org.json.JSONException;
import org.json.JSONObject;

public final class RecommendedContactInfo
  extends JceStruct
{
  static byte[] cache_MobileNoMask = (byte[])new byte[1];
  static int cache_conType = 0;
  static int cache_eNetworkType = 0;
  public byte[] MobileNoMask;
  public int age;
  public int conType = 0;
  public String contactsInfoEncrypt = "";
  public byte detalStatusFlag;
  public int eNetworkType = 0;
  public long faceFlag;
  public long faceSysId;
  public long faceTimeStamp;
  public long faceType;
  public String faceUrl = "";
  public int iTermType;
  public String name;
  public String personalSign = "";
  public int sex;
  public String strTermDesc = "";
  public long uAbiFlag;
  public String unicode;
  public String url;
  
  static
  {
    ((byte[])cache_MobileNoMask)[0] = 0;
  }
  
  public RecommendedContactInfo() {}
  
  public RecommendedContactInfo(String paramString1, byte[] paramArrayOfByte, int paramInt1, byte paramByte, int paramInt2, int paramInt3, String paramString2, long paramLong1, int paramInt4, int paramInt5, String paramString3, long paramLong2, long paramLong3, long paramLong4, String paramString4, long paramLong5)
  {
    this.contactsInfoEncrypt = paramString1;
    this.MobileNoMask = paramArrayOfByte;
    this.conType = paramInt1;
    this.detalStatusFlag = paramByte;
    this.iTermType = paramInt2;
    this.eNetworkType = paramInt3;
    this.strTermDesc = paramString2;
    this.uAbiFlag = paramLong1;
    this.sex = paramInt4;
    this.age = paramInt5;
    this.personalSign = paramString3;
    this.faceType = paramLong2;
    this.faceTimeStamp = paramLong3;
    this.faceFlag = paramLong4;
    this.faceUrl = paramString4;
    this.faceSysId = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contactsInfoEncrypt = paramJceInputStream.readString(1, true);
    this.MobileNoMask = ((byte[])paramJceInputStream.read(cache_MobileNoMask, 2, true));
    this.conType = paramJceInputStream.read(this.conType, 3, false);
    this.detalStatusFlag = paramJceInputStream.read(this.detalStatusFlag, 4, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 5, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 6, false);
    this.strTermDesc = paramJceInputStream.readString(7, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 8, false);
    this.sex = paramJceInputStream.read(this.sex, 9, false);
    this.age = paramJceInputStream.read(this.age, 10, false);
    this.personalSign = paramJceInputStream.readString(11, false);
    this.faceType = paramJceInputStream.read(this.faceType, 12, false);
    this.faceTimeStamp = paramJceInputStream.read(this.faceTimeStamp, 13, false);
    this.faceFlag = paramJceInputStream.read(this.faceFlag, 14, false);
    this.faceUrl = paramJceInputStream.readString(15, false);
    this.faceSysId = paramJceInputStream.read(this.faceSysId, 16, false);
  }
  
  public JSONObject toJson()
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mobile", this.unicode);
      localJSONObject.put("name", this.name);
      localJSONObject.put("age", this.age);
      localJSONObject.put("sex", this.sex);
      localJSONObject.put("signature", this.personalSign);
      if (this.eNetworkType != 0) {}
      for (String str = alpo.a(2131720302);; str = alpo.a(2131720301))
      {
        localJSONObject.put("online", str);
        localJSONObject.put("url", this.url);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contactsInfoEncrypt, 1);
    paramJceOutputStream.write(this.MobileNoMask, 2);
    paramJceOutputStream.write(this.conType, 3);
    paramJceOutputStream.write(this.detalStatusFlag, 4);
    paramJceOutputStream.write(this.iTermType, 5);
    paramJceOutputStream.write(this.eNetworkType, 6);
    if (this.strTermDesc != null) {
      paramJceOutputStream.write(this.strTermDesc, 7);
    }
    paramJceOutputStream.write(this.uAbiFlag, 8);
    paramJceOutputStream.write(this.sex, 9);
    paramJceOutputStream.write(this.age, 10);
    if (this.personalSign != null) {
      paramJceOutputStream.write(this.personalSign, 11);
    }
    paramJceOutputStream.write(this.faceType, 12);
    paramJceOutputStream.write(this.faceTimeStamp, 13);
    paramJceOutputStream.write(this.faceFlag, 14);
    if (this.faceUrl != null) {
      paramJceOutputStream.write(this.faceUrl, 15);
    }
    paramJceOutputStream.write(this.faceSysId, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SecurityAccountServer.RecommendedContactInfo
 * JD-Core Version:    0.7.0.1
 */