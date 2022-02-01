package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniSetReq
  extends JceStruct
{
  static Bubble cache_stBubble;
  static Concise cache_stConcise = new Concise();
  static Funcall cache_stFuncall;
  static Hamlet cache_stHamletItem;
  static ArrayList<Hamlet> cache_stHamletItemList;
  static LoginInfo cache_stLogin = new LoginInfo();
  static MessageShow cache_stMessageShow;
  static Redpacket cache_stRedpacket;
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public int clearflag;
  public Bubble stBubble;
  public Concise stConcise;
  public Funcall stFuncall;
  public Hamlet stHamletItem;
  public ArrayList<Hamlet> stHamletItemList;
  public LoginInfo stLogin;
  public MessageShow stMessageShow;
  public Redpacket stRedpacket;
  public UniBusinessItem stUniBusinessItem;
  
  static
  {
    cache_stHamletItem = new Hamlet();
    cache_stBubble = new Bubble();
    cache_stRedpacket = new Redpacket();
    cache_stFuncall = new Funcall();
    cache_stMessageShow = new MessageShow();
    cache_stHamletItemList = new ArrayList();
    Hamlet localHamlet = new Hamlet();
    cache_stHamletItemList.add(localHamlet);
  }
  
  public UniSetReq() {}
  
  public UniSetReq(LoginInfo paramLoginInfo, UniBusinessItem paramUniBusinessItem, Hamlet paramHamlet, Bubble paramBubble, Redpacket paramRedpacket, Funcall paramFuncall, MessageShow paramMessageShow, ArrayList<Hamlet> paramArrayList, int paramInt, Concise paramConcise)
  {
    this.stLogin = paramLoginInfo;
    this.stUniBusinessItem = paramUniBusinessItem;
    this.stHamletItem = paramHamlet;
    this.stBubble = paramBubble;
    this.stRedpacket = paramRedpacket;
    this.stFuncall = paramFuncall;
    this.stMessageShow = paramMessageShow;
    this.stHamletItemList = paramArrayList;
    this.clearflag = paramInt;
    this.stConcise = paramConcise;
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
    this.stHamletItemList = ((ArrayList)paramJceInputStream.read(cache_stHamletItemList, 7, false));
    this.clearflag = paramJceInputStream.read(this.clearflag, 8, false);
    this.stConcise = ((Concise)paramJceInputStream.read(cache_stConcise, 16, false));
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
    if (this.stHamletItemList != null) {
      paramJceOutputStream.write(this.stHamletItemList, 7);
    }
    paramJceOutputStream.write(this.clearflag, 8);
    if (this.stConcise != null) {
      paramJceOutputStream.write(this.stConcise, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniSetReq
 * JD-Core Version:    0.7.0.1
 */