package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfFullUsrQryReq
  extends JceStruct
{
  static ArrayList<Long> cache_vFriendUin;
  public int iAppId = 0;
  public int iGetTagFlag = -1;
  public int iReloadFlag = 0;
  public int iRetIncomPlete = 0;
  public String strSessionKey = "";
  public long usruin = 0L;
  public ArrayList<Long> vFriendUin = null;
  
  public ProfFullUsrQryReq() {}
  
  public ProfFullUsrQryReq(int paramInt1, String paramString, long paramLong, ArrayList<Long> paramArrayList, int paramInt2, int paramInt3, int paramInt4)
  {
    this.iAppId = paramInt1;
    this.strSessionKey = paramString;
    this.usruin = paramLong;
    this.vFriendUin = paramArrayList;
    this.iRetIncomPlete = paramInt2;
    this.iReloadFlag = paramInt3;
    this.iGetTagFlag = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 1, true);
    this.strSessionKey = paramJceInputStream.readString(2, true);
    this.usruin = paramJceInputStream.read(this.usruin, 3, true);
    if (cache_vFriendUin == null)
    {
      cache_vFriendUin = new ArrayList();
      cache_vFriendUin.add(Long.valueOf(0L));
    }
    this.vFriendUin = ((ArrayList)paramJceInputStream.read(cache_vFriendUin, 4, false));
    this.iRetIncomPlete = paramJceInputStream.read(this.iRetIncomPlete, 5, false);
    this.iReloadFlag = paramJceInputStream.read(this.iReloadFlag, 6, false);
    this.iGetTagFlag = paramJceInputStream.read(this.iGetTagFlag, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 1);
    paramJceOutputStream.write(this.strSessionKey, 2);
    paramJceOutputStream.write(this.usruin, 3);
    ArrayList localArrayList = this.vFriendUin;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 4);
    }
    paramJceOutputStream.write(this.iRetIncomPlete, 5);
    paramJceOutputStream.write(this.iReloadFlag, 6);
    paramJceOutputStream.write(this.iGetTagFlag, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.ProfFullUsrQryReq
 * JD-Core Version:    0.7.0.1
 */