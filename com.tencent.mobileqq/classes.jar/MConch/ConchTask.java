package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ConchTask
  extends JceStruct
{
  static ArrayList<Conch> cache_conchList = new ArrayList();
  public ArrayList<Conch> conchList = null;
  public long taskId = 0L;
  public long taskSeqno = 0L;
  
  static
  {
    Conch localConch = new Conch();
    cache_conchList.add(localConch);
  }
  
  public JceStruct newInit()
  {
    return new ConchTask();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.taskId = paramJceInputStream.read(this.taskId, 0, false);
    this.taskSeqno = paramJceInputStream.read(this.taskSeqno, 1, false);
    this.conchList = ((ArrayList)paramJceInputStream.read(cache_conchList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.taskId != 0L) {
      paramJceOutputStream.write(this.taskId, 0);
    }
    if (this.taskSeqno != 0L) {
      paramJceOutputStream.write(this.taskSeqno, 1);
    }
    if (this.conchList != null) {
      paramJceOutputStream.write(this.conchList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MConch.ConchTask
 * JD-Core Version:    0.7.0.1
 */