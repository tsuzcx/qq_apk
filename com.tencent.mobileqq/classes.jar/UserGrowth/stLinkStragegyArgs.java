package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLinkStragegyArgs
  extends JceStruct
{
  public boolean hasInstalledWeish = false;
  public int todayClickCount = 0;
  public int todayEnterCount = 0;
  public int todayLastLinkId = 0;
  
  public stLinkStragegyArgs() {}
  
  public stLinkStragegyArgs(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.hasInstalledWeish = paramBoolean;
    this.todayEnterCount = paramInt1;
    this.todayClickCount = paramInt2;
    this.todayLastLinkId = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasInstalledWeish = paramJceInputStream.read(this.hasInstalledWeish, 1, false);
    this.todayEnterCount = paramJceInputStream.read(this.todayEnterCount, 2, false);
    this.todayClickCount = paramJceInputStream.read(this.todayClickCount, 3, false);
    this.todayLastLinkId = paramJceInputStream.read(this.todayLastLinkId, 4, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stLinkStragegyArgs{hasInstalledWeish=");
    localStringBuilder.append(this.hasInstalledWeish);
    localStringBuilder.append(", todayEnterCount=");
    localStringBuilder.append(this.todayEnterCount);
    localStringBuilder.append(", todayClickCount=");
    localStringBuilder.append(this.todayClickCount);
    localStringBuilder.append(", todayLastLinkId=");
    localStringBuilder.append(this.todayLastLinkId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasInstalledWeish, 1);
    paramJceOutputStream.write(this.todayEnterCount, 2);
    paramJceOutputStream.write(this.todayClickCount, 3);
    paramJceOutputStream.write(this.todayLastLinkId, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stLinkStragegyArgs
 * JD-Core Version:    0.7.0.1
 */