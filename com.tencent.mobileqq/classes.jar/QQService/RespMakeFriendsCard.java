package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespMakeFriendsCard
  extends JceStruct
{
  static RespHead cache_stHeader;
  static MakeFriendsCard cache_stMakeFriendsCard;
  static ArrayList<FaceInfo> cache_vFaceInfo;
  static ArrayList<Visitor> cache_vVisitors;
  static ArrayList<Visitor> cache_vVoter;
  public byte bShareLBS = 0;
  public byte cSqqLevel = 0;
  public int iVoteIncrement = 0;
  public long lCardShowNum = 0L;
  public int lListVoterTime = 0;
  public RespHead stHeader = null;
  public MakeFriendsCard stMakeFriendsCard = null;
  public ArrayList<FaceInfo> vFaceInfo = null;
  public ArrayList<Visitor> vVisitors = null;
  public ArrayList<Visitor> vVoter = null;
  
  public RespMakeFriendsCard() {}
  
  public RespMakeFriendsCard(RespHead paramRespHead, MakeFriendsCard paramMakeFriendsCard, long paramLong, ArrayList<FaceInfo> paramArrayList, int paramInt1, ArrayList<Visitor> paramArrayList1, ArrayList<Visitor> paramArrayList2, int paramInt2, byte paramByte1, byte paramByte2)
  {
    this.stHeader = paramRespHead;
    this.stMakeFriendsCard = paramMakeFriendsCard;
    this.lCardShowNum = paramLong;
    this.vFaceInfo = paramArrayList;
    this.iVoteIncrement = paramInt1;
    this.vVisitors = paramArrayList1;
    this.vVoter = paramArrayList2;
    this.lListVoterTime = paramInt2;
    this.bShareLBS = paramByte1;
    this.cSqqLevel = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stMakeFriendsCard == null) {
      cache_stMakeFriendsCard = new MakeFriendsCard();
    }
    this.stMakeFriendsCard = ((MakeFriendsCard)paramJceInputStream.read(cache_stMakeFriendsCard, 1, true));
    this.lCardShowNum = paramJceInputStream.read(this.lCardShowNum, 2, true);
    Object localObject;
    if (cache_vFaceInfo == null)
    {
      cache_vFaceInfo = new ArrayList();
      localObject = new FaceInfo();
      cache_vFaceInfo.add(localObject);
    }
    this.vFaceInfo = ((ArrayList)paramJceInputStream.read(cache_vFaceInfo, 3, false));
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 4, false);
    if (cache_vVisitors == null)
    {
      cache_vVisitors = new ArrayList();
      localObject = new Visitor();
      cache_vVisitors.add(localObject);
    }
    this.vVisitors = ((ArrayList)paramJceInputStream.read(cache_vVisitors, 5, false));
    if (cache_vVoter == null)
    {
      cache_vVoter = new ArrayList();
      localObject = new Visitor();
      cache_vVoter.add(localObject);
    }
    this.vVoter = ((ArrayList)paramJceInputStream.read(cache_vVoter, 6, false));
    this.lListVoterTime = paramJceInputStream.read(this.lListVoterTime, 7, false);
    this.bShareLBS = paramJceInputStream.read(this.bShareLBS, 8, false);
    this.cSqqLevel = paramJceInputStream.read(this.cSqqLevel, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stMakeFriendsCard, 1);
    paramJceOutputStream.write(this.lCardShowNum, 2);
    ArrayList localArrayList = this.vFaceInfo;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 3);
    }
    paramJceOutputStream.write(this.iVoteIncrement, 4);
    localArrayList = this.vVisitors;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 5);
    }
    localArrayList = this.vVoter;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 6);
    }
    paramJceOutputStream.write(this.lListVoterTime, 7);
    paramJceOutputStream.write(this.bShareLBS, 8);
    paramJceOutputStream.write(this.cSqqLevel, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespMakeFriendsCard
 * JD-Core Version:    0.7.0.1
 */