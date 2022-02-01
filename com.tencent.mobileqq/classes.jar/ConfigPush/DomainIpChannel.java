package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class DomainIpChannel
  extends JceStruct
{
  static ArrayList<DomainIpList> cache_vDomain_iplists;
  public ArrayList<DomainIpList> vDomain_iplists = null;
  
  public DomainIpChannel() {}
  
  public DomainIpChannel(ArrayList<DomainIpList> paramArrayList)
  {
    this.vDomain_iplists = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vDomain_iplists == null)
    {
      cache_vDomain_iplists = new ArrayList();
      DomainIpList localDomainIpList = new DomainIpList();
      cache_vDomain_iplists.add(localDomainIpList);
    }
    this.vDomain_iplists = ((ArrayList)paramJceInputStream.read(cache_vDomain_iplists, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vDomain_iplists, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.DomainIpChannel
 * JD-Core Version:    0.7.0.1
 */