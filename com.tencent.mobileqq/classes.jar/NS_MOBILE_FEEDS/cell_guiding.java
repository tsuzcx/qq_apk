package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class cell_guiding
  extends JceStruct
{
  static Map<String, String> cache_extendInfo;
  static int cache_guiding_type;
  static s_picdata cache_picdata = new s_picdata();
  static ArrayList<guide_button> cache_vecButton;
  static ArrayList<s_user> cache_vecUsers;
  public String action_url = "";
  public String button_icon = "";
  public String button_title = "";
  public Map<String, String> extendInfo = null;
  public int guiding_type = 0;
  public s_picdata picdata = null;
  public String strJsonClient = "";
  public String subsummary = "";
  public String summary = "";
  public String title = "";
  public ArrayList<guide_button> vecButton = null;
  public ArrayList<s_user> vecUsers = null;
  
  static
  {
    cache_extendInfo = new HashMap();
    cache_extendInfo.put("", "");
    cache_guiding_type = 0;
    cache_vecUsers = new ArrayList();
    Object localObject = new s_user();
    cache_vecUsers.add(localObject);
    cache_vecButton = new ArrayList();
    localObject = new guide_button();
    cache_vecButton.add(localObject);
  }
  
  public cell_guiding() {}
  
  public cell_guiding(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, int paramInt, ArrayList<s_user> paramArrayList, ArrayList<guide_button> paramArrayList1, String paramString5, String paramString6, String paramString7)
  {
    this.picdata = params_picdata;
    this.title = paramString1;
    this.summary = paramString2;
    this.button_title = paramString3;
    this.action_url = paramString4;
    this.extendInfo = paramMap;
    this.guiding_type = paramInt;
    this.vecUsers = paramArrayList;
    this.vecButton = paramArrayList1;
    this.subsummary = paramString5;
    this.button_icon = paramString6;
    this.strJsonClient = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 0, false));
    this.title = paramJceInputStream.readString(1, false);
    this.summary = paramJceInputStream.readString(2, false);
    this.button_title = paramJceInputStream.readString(3, false);
    this.action_url = paramJceInputStream.readString(4, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 5, false));
    this.guiding_type = paramJceInputStream.read(this.guiding_type, 6, false);
    this.vecUsers = ((ArrayList)paramJceInputStream.read(cache_vecUsers, 7, false));
    this.vecButton = ((ArrayList)paramJceInputStream.read(cache_vecButton, 8, false));
    this.subsummary = paramJceInputStream.readString(9, false);
    this.button_icon = paramJceInputStream.readString(10, false);
    this.strJsonClient = paramJceInputStream.readString(11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.picdata;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.summary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.button_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.extendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 5);
    }
    paramJceOutputStream.write(this.guiding_type, 6);
    localObject = this.vecUsers;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.vecButton;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.subsummary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.button_icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.strJsonClient;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_guiding
 * JD-Core Version:    0.7.0.1
 */