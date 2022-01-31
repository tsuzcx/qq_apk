package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class stNotificationRsp
  extends JceStruct
{
  static stGlobalConfig cache_config;
  static Map<String, String> cache_map_ext;
  static ArrayList<stSimpleMetaPerson> cache_persons;
  static int cache_type = 0;
  static ArrayList<String> cache_vtFeedid;
  public int cid;
  public stGlobalConfig config;
  public String h5Url = "";
  public String imgurl = "";
  public String jump_url = "";
  public Map<String, String> map_ext;
  public ArrayList<stSimpleMetaPerson> persons;
  public String scheme_url = "";
  public String text = "";
  public String trace_id = "";
  public int type;
  public ArrayList<String> vtFeedid;
  
  static
  {
    cache_persons = new ArrayList();
    stSimpleMetaPerson localstSimpleMetaPerson = new stSimpleMetaPerson();
    cache_persons.add(localstSimpleMetaPerson);
    cache_vtFeedid = new ArrayList();
    cache_vtFeedid.add("");
    cache_config = new stGlobalConfig();
    cache_map_ext = new HashMap();
    cache_map_ext.put("", "");
  }
  
  public stNotificationRsp() {}
  
  public stNotificationRsp(int paramInt1, String paramString1, String paramString2, ArrayList<stSimpleMetaPerson> paramArrayList, String paramString3, ArrayList<String> paramArrayList1, stGlobalConfig paramstGlobalConfig, String paramString4, String paramString5, int paramInt2, String paramString6, Map<String, String> paramMap)
  {
    this.type = paramInt1;
    this.imgurl = paramString1;
    this.text = paramString2;
    this.persons = paramArrayList;
    this.jump_url = paramString3;
    this.vtFeedid = paramArrayList1;
    this.config = paramstGlobalConfig;
    this.h5Url = paramString4;
    this.scheme_url = paramString5;
    this.cid = paramInt2;
    this.trace_id = paramString6;
    this.map_ext = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.imgurl = paramJceInputStream.readString(1, false);
    this.text = paramJceInputStream.readString(2, false);
    this.persons = ((ArrayList)paramJceInputStream.read(cache_persons, 3, false));
    this.jump_url = paramJceInputStream.readString(4, false);
    this.vtFeedid = ((ArrayList)paramJceInputStream.read(cache_vtFeedid, 5, false));
    this.config = ((stGlobalConfig)paramJceInputStream.read(cache_config, 6, false));
    this.h5Url = paramJceInputStream.readString(7, false);
    this.scheme_url = paramJceInputStream.readString(8, false);
    this.cid = paramJceInputStream.read(this.cid, 9, false);
    this.trace_id = paramJceInputStream.readString(10, false);
    this.map_ext = ((Map)paramJceInputStream.read(cache_map_ext, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.imgurl != null) {
      paramJceOutputStream.write(this.imgurl, 1);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 2);
    }
    if (this.persons != null) {
      paramJceOutputStream.write(this.persons, 3);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 4);
    }
    if (this.vtFeedid != null) {
      paramJceOutputStream.write(this.vtFeedid, 5);
    }
    if (this.config != null) {
      paramJceOutputStream.write(this.config, 6);
    }
    if (this.h5Url != null) {
      paramJceOutputStream.write(this.h5Url, 7);
    }
    if (this.scheme_url != null) {
      paramJceOutputStream.write(this.scheme_url, 8);
    }
    paramJceOutputStream.write(this.cid, 9);
    if (this.trace_id != null) {
      paramJceOutputStream.write(this.trace_id, 10);
    }
    if (this.map_ext != null) {
      paramJceOutputStream.write(this.map_ext, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stNotificationRsp
 * JD-Core Version:    0.7.0.1
 */