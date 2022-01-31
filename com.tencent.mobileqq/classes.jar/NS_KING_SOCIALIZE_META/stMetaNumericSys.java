package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaNumericSys
  extends JceStruct
{
  public int fans_num;
  public int feed_num;
  public int frdonly_feed_num;
  public int fri_follow_num;
  public int interest_num;
  public int is_followed;
  public int praise_num;
  public int priv_feed_num;
  public int receivepraise_num;
  
  public stMetaNumericSys() {}
  
  public stMetaNumericSys(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.feed_num = paramInt1;
    this.praise_num = paramInt2;
    this.fans_num = paramInt3;
    this.interest_num = paramInt4;
    this.receivepraise_num = paramInt5;
    this.is_followed = paramInt6;
    this.priv_feed_num = paramInt7;
    this.fri_follow_num = paramInt8;
    this.frdonly_feed_num = paramInt9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feed_num = paramJceInputStream.read(this.feed_num, 0, false);
    this.praise_num = paramJceInputStream.read(this.praise_num, 1, false);
    this.fans_num = paramJceInputStream.read(this.fans_num, 2, false);
    this.interest_num = paramJceInputStream.read(this.interest_num, 3, false);
    this.receivepraise_num = paramJceInputStream.read(this.receivepraise_num, 4, false);
    this.is_followed = paramJceInputStream.read(this.is_followed, 5, false);
    this.priv_feed_num = paramJceInputStream.read(this.priv_feed_num, 6, false);
    this.fri_follow_num = paramJceInputStream.read(this.fri_follow_num, 7, false);
    this.frdonly_feed_num = paramJceInputStream.read(this.frdonly_feed_num, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.feed_num, 0);
    paramJceOutputStream.write(this.praise_num, 1);
    paramJceOutputStream.write(this.fans_num, 2);
    paramJceOutputStream.write(this.interest_num, 3);
    paramJceOutputStream.write(this.receivepraise_num, 4);
    paramJceOutputStream.write(this.is_followed, 5);
    paramJceOutputStream.write(this.priv_feed_num, 6);
    paramJceOutputStream.write(this.fri_follow_num, 7);
    paramJceOutputStream.write(this.frdonly_feed_num, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaNumericSys
 * JD-Core Version:    0.7.0.1
 */