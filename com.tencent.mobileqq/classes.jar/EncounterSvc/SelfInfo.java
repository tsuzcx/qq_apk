package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SelfInfo
  extends JceStruct
{
  public int NearRanking = 0;
  public byte cAge = 0;
  public byte cSex = 0;
  public int charm = 0;
  public int charm_level = 0;
  public byte god_flag = 0;
  public int iVoteIncrement = -1;
  public int iVoteNum = 0;
  public String strBirthDay = "";
  public String strNick = "";
  
  public SelfInfo() {}
  
  public SelfInfo(byte paramByte1, byte paramByte2, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte paramByte3)
  {
    this.cSex = paramByte1;
    this.cAge = paramByte2;
    this.strBirthDay = paramString1;
    this.strNick = paramString2;
    this.iVoteNum = paramInt1;
    this.iVoteIncrement = paramInt2;
    this.charm = paramInt3;
    this.charm_level = paramInt4;
    this.NearRanking = paramInt5;
    this.god_flag = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cSex = paramJceInputStream.read(this.cSex, 0, false);
    this.cAge = paramJceInputStream.read(this.cAge, 1, false);
    this.strBirthDay = paramJceInputStream.readString(2, false);
    this.strNick = paramJceInputStream.readString(3, false);
    this.iVoteNum = paramJceInputStream.read(this.iVoteNum, 4, false);
    this.iVoteIncrement = paramJceInputStream.read(this.iVoteIncrement, 5, false);
    this.charm = paramJceInputStream.read(this.charm, 6, false);
    this.charm_level = paramJceInputStream.read(this.charm_level, 7, false);
    this.NearRanking = paramJceInputStream.read(this.NearRanking, 8, false);
    this.god_flag = paramJceInputStream.read(this.god_flag, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cSex, 0);
    paramJceOutputStream.write(this.cAge, 1);
    if (this.strBirthDay != null) {
      paramJceOutputStream.write(this.strBirthDay, 2);
    }
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    paramJceOutputStream.write(this.iVoteNum, 4);
    paramJceOutputStream.write(this.iVoteIncrement, 5);
    paramJceOutputStream.write(this.charm, 6);
    paramJceOutputStream.write(this.charm_level, 7);
    paramJceOutputStream.write(this.NearRanking, 8);
    paramJceOutputStream.write(this.god_flag, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.SelfInfo
 * JD-Core Version:    0.7.0.1
 */