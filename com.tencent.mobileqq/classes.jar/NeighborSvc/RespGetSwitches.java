package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetSwitches
  extends JceStruct
{
  static RespHeader cache_stHeader;
  static ArrayList<Switch> cache_switches;
  public RespHeader stHeader;
  public ArrayList<Switch> switches;
  
  public RespGetSwitches() {}
  
  public RespGetSwitches(RespHeader paramRespHeader, ArrayList<Switch> paramArrayList)
  {
    this.stHeader = paramRespHeader;
    this.switches = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_switches == null)
    {
      cache_switches = new ArrayList();
      Switch localSwitch = new Switch();
      cache_switches.add(localSwitch);
    }
    this.switches = ((ArrayList)paramJceInputStream.read(cache_switches, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.switches, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.RespGetSwitches
 * JD-Core Version:    0.7.0.1
 */