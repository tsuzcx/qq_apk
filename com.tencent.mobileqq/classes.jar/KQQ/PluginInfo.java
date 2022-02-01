package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PluginInfo
  extends JceStruct
{
  public long Count = 0L;
  public boolean Flag = false;
  public long Id = 0L;
  public String PicUrl = "";
  public boolean RedPoint = false;
  public boolean Tab = true;
  public String Text = "";
  
  public PluginInfo() {}
  
  public PluginInfo(long paramLong1, long paramLong2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.Id = paramLong1;
    this.Count = paramLong2;
    this.Flag = paramBoolean1;
    this.Text = paramString1;
    this.PicUrl = paramString2;
    this.RedPoint = paramBoolean2;
    this.Tab = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Id = paramJceInputStream.read(this.Id, 0, true);
    this.Count = paramJceInputStream.read(this.Count, 1, true);
    this.Flag = paramJceInputStream.read(this.Flag, 2, true);
    this.Text = paramJceInputStream.readString(3, false);
    this.PicUrl = paramJceInputStream.readString(4, false);
    this.RedPoint = paramJceInputStream.read(this.RedPoint, 5, false);
    this.Tab = paramJceInputStream.read(this.Tab, 6, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.Id);
    localStringBuilder.append(",count=");
    localStringBuilder.append(this.Count);
    localStringBuilder.append(",flag=");
    localStringBuilder.append(this.Flag);
    localStringBuilder.append(",text=");
    localStringBuilder.append(this.Text);
    localStringBuilder.append(",picurl=");
    localStringBuilder.append(this.PicUrl);
    localStringBuilder.append(",redpoint=");
    localStringBuilder.append(this.RedPoint);
    localStringBuilder.append(",tab=");
    localStringBuilder.append(this.Tab);
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Id, 0);
    paramJceOutputStream.write(this.Count, 1);
    paramJceOutputStream.write(this.Flag, 2);
    String str = this.Text;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.PicUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.RedPoint, 5);
    paramJceOutputStream.write(this.Tab, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.PluginInfo
 * JD-Core Version:    0.7.0.1
 */