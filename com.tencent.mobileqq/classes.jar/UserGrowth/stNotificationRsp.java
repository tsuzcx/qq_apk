package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class stNotificationRsp
  extends JceStruct
{
  static stGlobalConfig cache_config;
  static Map<String, String> cache_map_ext;
  static ArrayList<stSimpleMetaPerson> cache_persons = new ArrayList();
  static int cache_type;
  static ArrayList<String> cache_vtFeedid;
  public int cid = 0;
  public stGlobalConfig config = null;
  public String h5Url = "";
  public String imgurl = "";
  public String jump_url = "";
  public Map<String, String> map_ext = null;
  public ArrayList<stSimpleMetaPerson> persons = null;
  public String scheme_url = "";
  public String text = "";
  public String trace_id = "";
  public int type = 0;
  public ArrayList<String> vtFeedid = null;
  
  static
  {
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
    Object localObject = this.imgurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.persons;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.jump_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.vtFeedid;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.config;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.h5Url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.scheme_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.cid, 9);
    localObject = this.trace_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.map_ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stNotificationRsp
 * JD-Core Version:    0.7.0.1
 */