package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SCPullConchs
  extends JceStruct
{
  static ArrayList<ConchTask> cache_conchTaskList = new ArrayList();
  public ArrayList<ConchTask> conchTaskList = null;
  public int result = 0;
  
  static
  {
    ConchTask localConchTask = new ConchTask();
    cache_conchTaskList.add(localConchTask);
  }
  
  public JceStruct newInit()
  {
    return new SCPullConchs();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, false);
    this.conchTaskList = ((ArrayList)paramJceInputStream.read(cache_conchTaskList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.result;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    ArrayList localArrayList = this.conchTaskList;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MConch.SCPullConchs
 * JD-Core Version:    0.7.0.1
 */