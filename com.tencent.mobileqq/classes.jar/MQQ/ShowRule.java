package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ShowRule
  extends JceStruct
{
  static ArrayList<ShowRangeTime> cache_rangTimes = new ArrayList();
  public ArrayList<ShowRangeTime> rangTimes = null;
  public int showCount = 0;
  public int showType = 0;
  
  static
  {
    ShowRangeTime localShowRangeTime = new ShowRangeTime();
    cache_rangTimes.add(localShowRangeTime);
  }
  
  public ShowRule() {}
  
  public ShowRule(int paramInt1, int paramInt2, ArrayList<ShowRangeTime> paramArrayList)
  {
    this.showType = paramInt1;
    this.showCount = paramInt2;
    this.rangTimes = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.showType = paramJceInputStream.read(this.showType, 0, false);
    this.showCount = paramJceInputStream.read(this.showCount, 1, false);
    this.rangTimes = ((ArrayList)paramJceInputStream.read(cache_rangTimes, 2, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowRule{showType=");
    localStringBuilder.append(this.showType);
    localStringBuilder.append(", showCount=");
    localStringBuilder.append(this.showCount);
    localStringBuilder.append(", rangTimes=");
    localStringBuilder.append(this.rangTimes);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.showType, 0);
    paramJceOutputStream.write(this.showCount, 1);
    ArrayList localArrayList = this.rangTimes;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.ShowRule
 * JD-Core Version:    0.7.0.1
 */