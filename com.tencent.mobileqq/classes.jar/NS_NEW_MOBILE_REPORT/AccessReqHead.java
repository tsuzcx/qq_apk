package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AccessReqHead
  extends JceStruct
{
  static ArrayList<String> cache_installPkgList;
  static IOSTerminal cache_iosTerminal;
  static Terminal cache_terminal = new Terminal();
  static TicketForQQ cache_ticketForQQ = new TicketForQQ();
  static ArrayList<String> cache_uninstallPkgList;
  public ArrayList<String> installPkgList = null;
  public IOSTerminal iosTerminal = null;
  public int loginType = 0;
  public String opendId = "";
  public String phoneNum = "";
  public int platform = 1;
  public String qua = "";
  public Terminal terminal = null;
  public TicketForQQ ticketForQQ = null;
  public long uin = 0L;
  public ArrayList<String> uninstallPkgList = null;
  public String uniqueId = "";
  
  static
  {
    cache_iosTerminal = new IOSTerminal();
    cache_installPkgList = new ArrayList();
    cache_installPkgList.add("");
    cache_uninstallPkgList = new ArrayList();
    cache_uninstallPkgList.add("");
  }
  
  public AccessReqHead() {}
  
  public AccessReqHead(String paramString1, long paramLong, String paramString2, Terminal paramTerminal, TicketForQQ paramTicketForQQ, int paramInt1, IOSTerminal paramIOSTerminal, int paramInt2, String paramString3, String paramString4, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.qua = paramString1;
    this.uin = paramLong;
    this.uniqueId = paramString2;
    this.terminal = paramTerminal;
    this.ticketForQQ = paramTicketForQQ;
    this.platform = paramInt1;
    this.iosTerminal = paramIOSTerminal;
    this.loginType = paramInt2;
    this.opendId = paramString3;
    this.phoneNum = paramString4;
    this.installPkgList = paramArrayList1;
    this.uninstallPkgList = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qua = paramJceInputStream.readString(0, false);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.uniqueId = paramJceInputStream.readString(2, false);
    this.terminal = ((Terminal)paramJceInputStream.read(cache_terminal, 3, false));
    this.ticketForQQ = ((TicketForQQ)paramJceInputStream.read(cache_ticketForQQ, 4, false));
    this.platform = paramJceInputStream.read(this.platform, 5, false);
    this.iosTerminal = ((IOSTerminal)paramJceInputStream.read(cache_iosTerminal, 6, false));
    this.loginType = paramJceInputStream.read(this.loginType, 7, false);
    this.opendId = paramJceInputStream.readString(8, false);
    this.phoneNum = paramJceInputStream.readString(9, false);
    this.installPkgList = ((ArrayList)paramJceInputStream.read(cache_installPkgList, 10, false));
    this.uninstallPkgList = ((ArrayList)paramJceInputStream.read(cache_uninstallPkgList, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    if (this.uniqueId != null) {
      paramJceOutputStream.write(this.uniqueId, 2);
    }
    if (this.terminal != null) {
      paramJceOutputStream.write(this.terminal, 3);
    }
    if (this.ticketForQQ != null) {
      paramJceOutputStream.write(this.ticketForQQ, 4);
    }
    paramJceOutputStream.write(this.platform, 5);
    if (this.iosTerminal != null) {
      paramJceOutputStream.write(this.iosTerminal, 6);
    }
    paramJceOutputStream.write(this.loginType, 7);
    if (this.opendId != null) {
      paramJceOutputStream.write(this.opendId, 8);
    }
    if (this.phoneNum != null) {
      paramJceOutputStream.write(this.phoneNum, 9);
    }
    if (this.installPkgList != null) {
      paramJceOutputStream.write(this.installPkgList, 10);
    }
    if (this.uninstallPkgList != null) {
      paramJceOutputStream.write(this.uninstallPkgList, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_NEW_MOBILE_REPORT.AccessReqHead
 * JD-Core Version:    0.7.0.1
 */