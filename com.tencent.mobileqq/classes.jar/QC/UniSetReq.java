package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniSetReq
  extends JceStruct
{
  static Bubble cache_stBubble;
  static Funcall cache_stFuncall = new Funcall();
  static Hamlet cache_stHamletItem;
  static LoginInfo cache_stLogin = new LoginInfo();
  static MessageShow cache_stMessageShow = new MessageShow();
  static Redpacket cache_stRedpacket;
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public Bubble stBubble;
  public Funcall stFuncall;
  public Hamlet stHamletItem;
  public LoginInfo stLogin;
  public MessageShow stMessageShow;
  public Redpacket stRedpacket;
  public UniBusinessItem stUniBusinessItem;
  
  static
  {
    cache_stHamletItem = new Hamlet();
    cache_stBubble = new Bubble();
    cache_stRedpacket = new Redpacket();
  }
  
  public UniSetReq() {}
  
  public UniSetReq(LoginInfo paramLoginInfo, UniBusinessItem paramUniBusinessItem, Hamlet paramHamlet, Bubble paramBubble, Redpacket paramRedpacket, Funcall paramFuncall, MessageShow paramMessageShow)
  {
    this.stLogin = paramLoginInfo;
    this.stUniBusinessItem = paramUniBusinessItem;
    this.stHamletItem = paramHamlet;
    this.stBubble = paramBubble;
    this.stRedpacket = paramRedpacket;
    this.stFuncall = paramFuncall;
    this.stMessageShow = paramMessageShow;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.stUniBusinessItem = ((UniBusinessItem)paramJceInputStream.read(cache_stUniBusinessItem, 1, true));
    this.stHamletItem = ((Hamlet)paramJceInputStream.read(cache_stHamletItem, 2, false));
    this.stBubble = ((Bubble)paramJceInputStream.read(cache_stBubble, 3, false));
    this.stRedpacket = ((Redpacket)paramJceInputStream.read(cache_stRedpacket, 4, false));
    this.stFuncall = ((Funcall)paramJceInputStream.read(cache_stFuncall, 5, false));
    this.stMessageShow = ((MessageShow)paramJceInputStream.read(cache_stMessageShow, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    paramJceOutputStream.write(this.stUniBusinessItem, 1);
    if (this.stHamletItem != null) {
      paramJceOutputStream.write(this.stHamletItem, 2);
    }
    if (this.stBubble != null) {
      paramJceOutputStream.write(this.stBubble, 3);
    }
    if (this.stRedpacket != null) {
      paramJceOutputStream.write(this.stRedpacket, 4);
    }
    if (this.stFuncall != null) {
      paramJceOutputStream.write(this.stFuncall, 5);
    }
    if (this.stMessageShow != null) {
      paramJceOutputStream.write(this.stMessageShow, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniSetReq
 * JD-Core Version:    0.7.0.1
 */