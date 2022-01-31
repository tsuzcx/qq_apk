package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SQ_CLIENT_UPDATE_REQ
  extends JceStruct
{
  static int cache_triggerType = 0;
  static ArrayList cache_vModule;
  static ArrayList cache_vPlugin = new ArrayList();
  public int apiLevel;
  public String qua = "";
  public int triggerType;
  public ArrayList vModule;
  public ArrayList vPlugin;
  public String version = "";
  
  static
  {
    UPDATE_INFO localUPDATE_INFO = new UPDATE_INFO();
    cache_vPlugin.add(localUPDATE_INFO);
    cache_vModule = new ArrayList();
    localUPDATE_INFO = new UPDATE_INFO();
    cache_vModule.add(localUPDATE_INFO);
  }
  
  public SQ_CLIENT_UPDATE_REQ() {}
  
  public SQ_CLIENT_UPDATE_REQ(String paramString1, String paramString2, int paramInt1, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.qua = paramString1;
    this.version = paramString2;
    this.apiLevel = paramInt1;
    this.triggerType = paramInt2;
    this.vPlugin = paramArrayList1;
    this.vModule = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qua = paramJceInputStream.readString(0, false);
    this.version = paramJceInputStream.readString(1, false);
    this.apiLevel = paramJceInputStream.read(this.apiLevel, 2, false);
    this.triggerType = paramJceInputStream.read(this.triggerType, 3, false);
    this.vPlugin = ((ArrayList)paramJceInputStream.read(cache_vPlugin, 4, false));
    this.vModule = ((ArrayList)paramJceInputStream.read(cache_vModule, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 0);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 1);
    }
    paramJceOutputStream.write(this.apiLevel, 2);
    paramJceOutputStream.write(this.triggerType, 3);
    if (this.vPlugin != null) {
      paramJceOutputStream.write(this.vPlugin, 4);
    }
    if (this.vModule != null) {
      paramJceOutputStream.write(this.vModule, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_REQ
 * JD-Core Version:    0.7.0.1
 */