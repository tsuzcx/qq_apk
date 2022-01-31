package FileUpload;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stPoi
  extends JceStruct
  implements Cloneable
{
  public String poi_address = "";
  public String poi_id = "";
  public String poi_name = "";
  public int poi_type = 0;
  public String poi_x = "";
  public String poi_y = "";
  public int show_poi = 0;
  
  static
  {
    if (!stPoi.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public stPoi() {}
  
  public stPoi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    this.poi_id = paramString1;
    this.poi_x = paramString2;
    this.poi_y = paramString3;
    this.poi_name = paramString4;
    this.poi_address = paramString5;
    this.poi_type = paramInt1;
    this.show_poi = paramInt2;
  }
  
  public String className()
  {
    return "FileUpload.stPoi";
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
    paramStringBuilder.display(this.poi_id, "poi_id");
    paramStringBuilder.display(this.poi_x, "poi_x");
    paramStringBuilder.display(this.poi_y, "poi_y");
    paramStringBuilder.display(this.poi_name, "poi_name");
    paramStringBuilder.display(this.poi_address, "poi_address");
    paramStringBuilder.display(this.poi_type, "poi_type");
    paramStringBuilder.display(this.show_poi, "show_poi");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.poi_id, true);
    paramStringBuilder.displaySimple(this.poi_x, true);
    paramStringBuilder.displaySimple(this.poi_y, true);
    paramStringBuilder.displaySimple(this.poi_name, true);
    paramStringBuilder.displaySimple(this.poi_address, true);
    paramStringBuilder.displaySimple(this.poi_type, true);
    paramStringBuilder.displaySimple(this.show_poi, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (stPoi)paramObject;
    } while ((!JceUtil.equals(this.poi_id, paramObject.poi_id)) || (!JceUtil.equals(this.poi_x, paramObject.poi_x)) || (!JceUtil.equals(this.poi_y, paramObject.poi_y)) || (!JceUtil.equals(this.poi_name, paramObject.poi_name)) || (!JceUtil.equals(this.poi_address, paramObject.poi_address)) || (!JceUtil.equals(this.poi_type, paramObject.poi_type)) || (!JceUtil.equals(this.show_poi, paramObject.show_poi)));
    return true;
  }
  
  public String fullClassName()
  {
    return "FileUpload.stPoi";
  }
  
  public String getPoi_address()
  {
    return this.poi_address;
  }
  
  public String getPoi_id()
  {
    return this.poi_id;
  }
  
  public String getPoi_name()
  {
    return this.poi_name;
  }
  
  public int getPoi_type()
  {
    return this.poi_type;
  }
  
  public String getPoi_x()
  {
    return this.poi_x;
  }
  
  public String getPoi_y()
  {
    return this.poi_y;
  }
  
  public int getShow_poi()
  {
    return this.show_poi;
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
    this.poi_id = paramJceInputStream.readString(0, true);
    this.poi_x = paramJceInputStream.readString(1, true);
    this.poi_y = paramJceInputStream.readString(2, true);
    this.poi_name = paramJceInputStream.readString(3, true);
    this.poi_address = paramJceInputStream.readString(4, true);
    this.poi_type = paramJceInputStream.read(this.poi_type, 5, true);
    this.show_poi = paramJceInputStream.read(this.show_poi, 6, false);
  }
  
  public void setPoi_address(String paramString)
  {
    this.poi_address = paramString;
  }
  
  public void setPoi_id(String paramString)
  {
    this.poi_id = paramString;
  }
  
  public void setPoi_name(String paramString)
  {
    this.poi_name = paramString;
  }
  
  public void setPoi_type(int paramInt)
  {
    this.poi_type = paramInt;
  }
  
  public void setPoi_x(String paramString)
  {
    this.poi_x = paramString;
  }
  
  public void setPoi_y(String paramString)
  {
    this.poi_y = paramString;
  }
  
  public void setShow_poi(int paramInt)
  {
    this.show_poi = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.poi_id, 0);
    paramJceOutputStream.write(this.poi_x, 1);
    paramJceOutputStream.write(this.poi_y, 2);
    paramJceOutputStream.write(this.poi_name, 3);
    paramJceOutputStream.write(this.poi_address, 4);
    paramJceOutputStream.write(this.poi_type, 5);
    paramJceOutputStream.write(this.show_poi, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.stPoi
 * JD-Core Version:    0.7.0.1
 */