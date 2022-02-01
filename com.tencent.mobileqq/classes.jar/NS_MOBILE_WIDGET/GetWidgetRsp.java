package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetWidgetRsp
  extends JceStruct
{
  static PartnerPlugin cache_partner_info = new PartnerPlugin();
  static PluginInfo cache_plugin_info = new PluginInfo();
  static byte[] cache_widget = (byte[])new byte[1];
  public String attach_info = "";
  public int expire = 0;
  public int iNameplateFlag = 0;
  public int iNeedRedPacket = 0;
  public int no_update = 0;
  public PartnerPlugin partner_info = null;
  public PluginInfo plugin_info = null;
  public int stored_widget_id = 0;
  public String tmp_data_json = "";
  public String tmp_url = "";
  public int today_delta = 0;
  public byte[] widget = null;
  
  static
  {
    ((byte[])cache_widget)[0] = 0;
  }
  
  public GetWidgetRsp() {}
  
  public GetWidgetRsp(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString1, PartnerPlugin paramPartnerPlugin, int paramInt3, PluginInfo paramPluginInfo, int paramInt4, int paramInt5, String paramString2, String paramString3, int paramInt6)
  {
    this.widget = paramArrayOfByte;
    this.expire = paramInt1;
    this.no_update = paramInt2;
    this.attach_info = paramString1;
    this.partner_info = paramPartnerPlugin;
    this.stored_widget_id = paramInt3;
    this.plugin_info = paramPluginInfo;
    this.iNameplateFlag = paramInt4;
    this.iNeedRedPacket = paramInt5;
    this.tmp_url = paramString2;
    this.tmp_data_json = paramString3;
    this.today_delta = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.widget = ((byte[])paramJceInputStream.read(cache_widget, 0, false));
    this.expire = paramJceInputStream.read(this.expire, 1, false);
    this.no_update = paramJceInputStream.read(this.no_update, 2, false);
    this.attach_info = paramJceInputStream.readString(3, false);
    this.partner_info = ((PartnerPlugin)paramJceInputStream.read(cache_partner_info, 4, false));
    this.stored_widget_id = paramJceInputStream.read(this.stored_widget_id, 5, false);
    this.plugin_info = ((PluginInfo)paramJceInputStream.read(cache_plugin_info, 6, false));
    this.iNameplateFlag = paramJceInputStream.read(this.iNameplateFlag, 7, false);
    this.iNeedRedPacket = paramJceInputStream.read(this.iNeedRedPacket, 8, false);
    this.tmp_url = paramJceInputStream.readString(9, false);
    this.tmp_data_json = paramJceInputStream.readString(10, false);
    this.today_delta = paramJceInputStream.read(this.today_delta, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.widget;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    paramJceOutputStream.write(this.expire, 1);
    paramJceOutputStream.write(this.no_update, 2);
    localObject = this.attach_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.partner_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.stored_widget_id, 5);
    localObject = this.plugin_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    paramJceOutputStream.write(this.iNameplateFlag, 7);
    paramJceOutputStream.write(this.iNeedRedPacket, 8);
    localObject = this.tmp_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.tmp_data_json;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.today_delta, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_WIDGET.GetWidgetRsp
 * JD-Core Version:    0.7.0.1
 */