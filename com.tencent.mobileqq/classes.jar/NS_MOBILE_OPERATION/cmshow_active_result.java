package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cmshow_active_result
  extends JceStruct
{
  public int cm_cardli_count = 0;
  public int cm_stone_count = 0;
  public int fire_score = 0;
  public byte is_reach_friend_limit = 0;
  public byte is_reach_limit = 0;
  
  public cmshow_active_result() {}
  
  public cmshow_active_result(int paramInt1, int paramInt2, byte paramByte1, int paramInt3, byte paramByte2)
  {
    this.fire_score = paramInt1;
    this.cm_stone_count = paramInt2;
    this.is_reach_limit = paramByte1;
    this.cm_cardli_count = paramInt3;
    this.is_reach_friend_limit = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fire_score = paramJceInputStream.read(this.fire_score, 1, false);
    this.cm_stone_count = paramJceInputStream.read(this.cm_stone_count, 2, false);
    this.is_reach_limit = paramJceInputStream.read(this.is_reach_limit, 3, false);
    this.cm_cardli_count = paramJceInputStream.read(this.cm_cardli_count, 4, false);
    this.is_reach_friend_limit = paramJceInputStream.read(this.is_reach_friend_limit, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fire_score, 1);
    paramJceOutputStream.write(this.cm_stone_count, 2);
    paramJceOutputStream.write(this.is_reach_limit, 3);
    paramJceOutputStream.write(this.cm_cardli_count, 4);
    paramJceOutputStream.write(this.is_reach_friend_limit, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.cmshow_active_result
 * JD-Core Version:    0.7.0.1
 */