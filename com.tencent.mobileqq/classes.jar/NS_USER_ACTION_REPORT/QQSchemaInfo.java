package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QQSchemaInfo
  extends JceStruct
{
  public String appid = "";
  public String schema_desc = "";
  public String schema_url = "";
  
  public QQSchemaInfo() {}
  
  public QQSchemaInfo(String paramString1, String paramString2, String paramString3)
  {
    this.appid = paramString1;
    this.schema_desc = paramString2;
    this.schema_url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.readString(0, true);
    this.schema_desc = paramJceInputStream.readString(1, true);
    this.schema_url = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    paramJceOutputStream.write(this.schema_desc, 1);
    paramJceOutputStream.write(this.schema_url, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.QQSchemaInfo
 * JD-Core Version:    0.7.0.1
 */