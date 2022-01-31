package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetEntrance
  extends JceStruct
{
  static ArrayList cache_entrance_list = new ArrayList();
  static ArrayList cache_xml_list;
  public ArrayList entrance_list;
  public long interval = 300L;
  public ArrayList xml_list;
  
  static
  {
    EntranceContent localEntranceContent = new EntranceContent();
    cache_entrance_list.add(localEntranceContent);
    cache_xml_list = new ArrayList();
    cache_xml_list.add("");
  }
  
  public RespGetEntrance() {}
  
  public RespGetEntrance(ArrayList paramArrayList1, long paramLong, ArrayList paramArrayList2)
  {
    this.entrance_list = paramArrayList1;
    this.interval = paramLong;
    this.xml_list = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.entrance_list = ((ArrayList)paramJceInputStream.read(cache_entrance_list, 0, false));
    this.interval = paramJceInputStream.read(this.interval, 1, false);
    this.xml_list = ((ArrayList)paramJceInputStream.read(cache_xml_list, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.entrance_list != null) {
      paramJceOutputStream.write(this.entrance_list, 0);
    }
    paramJceOutputStream.write(this.interval, 1);
    if (this.xml_list != null) {
      paramJceOutputStream.write(this.xml_list, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     EncounterSvc.RespGetEntrance
 * JD-Core Version:    0.7.0.1
 */