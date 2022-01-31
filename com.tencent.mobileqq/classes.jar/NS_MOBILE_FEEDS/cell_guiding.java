package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_guiding
  extends JceStruct
  implements Cloneable
{
  static Map cache_extendInfo;
  static int cache_guiding_type;
  static s_picdata cache_picdata;
  static ArrayList cache_vecButton;
  static ArrayList cache_vecUsers;
  public String action_url = "";
  public String button_title = "";
  public Map extendInfo;
  public int guiding_type;
  public s_picdata picdata;
  public String summary = "";
  public String title = "";
  public ArrayList vecButton;
  public ArrayList vecUsers;
  
  static
  {
    if (!cell_guiding.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_picdata = new s_picdata();
      cache_extendInfo = new HashMap();
      cache_extendInfo.put("", "");
      cache_guiding_type = 0;
      cache_vecUsers = new ArrayList();
      Object localObject = new s_user();
      cache_vecUsers.add(localObject);
      cache_vecButton = new ArrayList();
      localObject = new guide_button();
      cache_vecButton.add(localObject);
      return;
    }
  }
  
  public cell_guiding() {}
  
  public cell_guiding(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.picdata = params_picdata;
    this.title = paramString1;
    this.summary = paramString2;
    this.button_title = paramString3;
    this.action_url = paramString4;
    this.extendInfo = paramMap;
    this.guiding_type = paramInt;
    this.vecUsers = paramArrayList1;
    this.vecButton = paramArrayList2;
  }
  
  public String className()
  {
    return "NS_MOBILE_FEEDS.cell_guiding";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.picdata, "picdata");
    paramStringBuilder.display(this.title, "title");
    paramStringBuilder.display(this.summary, "summary");
    paramStringBuilder.display(this.button_title, "button_title");
    paramStringBuilder.display(this.action_url, "action_url");
    paramStringBuilder.display(this.extendInfo, "extendInfo");
    paramStringBuilder.display(this.guiding_type, "guiding_type");
    paramStringBuilder.display(this.vecUsers, "vecUsers");
    paramStringBuilder.display(this.vecButton, "vecButton");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.picdata, true);
    paramStringBuilder.displaySimple(this.title, true);
    paramStringBuilder.displaySimple(this.summary, true);
    paramStringBuilder.displaySimple(this.button_title, true);
    paramStringBuilder.displaySimple(this.action_url, true);
    paramStringBuilder.displaySimple(this.extendInfo, true);
    paramStringBuilder.displaySimple(this.guiding_type, true);
    paramStringBuilder.displaySimple(this.vecUsers, true);
    paramStringBuilder.displaySimple(this.vecButton, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (cell_guiding)paramObject;
    } while ((!JceUtil.equals(this.picdata, paramObject.picdata)) || (!JceUtil.equals(this.title, paramObject.title)) || (!JceUtil.equals(this.summary, paramObject.summary)) || (!JceUtil.equals(this.button_title, paramObject.button_title)) || (!JceUtil.equals(this.action_url, paramObject.action_url)) || (!JceUtil.equals(this.extendInfo, paramObject.extendInfo)) || (!JceUtil.equals(this.guiding_type, paramObject.guiding_type)) || (!JceUtil.equals(this.vecUsers, paramObject.vecUsers)) || (!JceUtil.equals(this.vecButton, paramObject.vecButton)));
    return true;
  }
  
  public String fullClassName()
  {
    return "NS_MOBILE_FEEDS.cell_guiding";
  }
  
  public String getAction_url()
  {
    return this.action_url;
  }
  
  public String getButton_title()
  {
    return this.button_title;
  }
  
  public Map getExtendInfo()
  {
    return this.extendInfo;
  }
  
  public int getGuiding_type()
  {
    return this.guiding_type;
  }
  
  public s_picdata getPicdata()
  {
    return this.picdata;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public ArrayList getVecButton()
  {
    return this.vecButton;
  }
  
  public ArrayList getVecUsers()
  {
    return this.vecUsers;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
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
  }
  
  public void setAction_url(String paramString)
  {
    this.action_url = paramString;
  }
  
  public void setButton_title(String paramString)
  {
    this.button_title = paramString;
  }
  
  public void setExtendInfo(Map paramMap)
  {
    this.extendInfo = paramMap;
  }
  
  public void setGuiding_type(int paramInt)
  {
    this.guiding_type = paramInt;
  }
  
  public void setPicdata(s_picdata params_picdata)
  {
    this.picdata = params_picdata;
  }
  
  public void setSummary(String paramString)
  {
    this.summary = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setVecButton(ArrayList paramArrayList)
  {
    this.vecButton = paramArrayList;
  }
  
  public void setVecUsers(ArrayList paramArrayList)
  {
    this.vecUsers = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 0);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 1);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 2);
    }
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 3);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 4);
    }
    if (this.extendInfo != null) {
      paramJceOutputStream.write(this.extendInfo, 5);
    }
    paramJceOutputStream.write(this.guiding_type, 6);
    if (this.vecUsers != null) {
      paramJceOutputStream.write(this.vecUsers, 7);
    }
    if (this.vecButton != null) {
      paramJceOutputStream.write(this.vecButton, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_guiding
 * JD-Core Version:    0.7.0.1
 */