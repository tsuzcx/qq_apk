package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class UniSetReq
  extends JceStruct
{
  static Map<String, String> cache_ext_map;
  static Bubble cache_stBubble;
  static Concise cache_stConcise = new Concise();
  static ExtendFriend cache_stExtendFriend;
  static Font cache_stFont;
  static Funcall cache_stFuncall;
  static GroupEffect cache_stGroupEffect;
  static Hamlet cache_stHamletItem;
  static ArrayList<Hamlet> cache_stHamletItemList;
  static LoginInfo cache_stLogin = new LoginInfo();
  static MessageShow cache_stMessageShow;
  static NamePlate cache_stNamePlate;
  static Nudge cache_stNudge = new Nudge();
  static Redpacket cache_stRedpacket;
  static Signature cache_stSignature;
  static SummaryCard cache_stSummaryCard;
  static UniBusinessItem cache_stUniBusinessItem = new UniBusinessItem();
  public int clearflag;
  public Map<String, String> ext_map;
  public Bubble stBubble;
  public Concise stConcise;
  public ExtendFriend stExtendFriend;
  public Font stFont;
  public Funcall stFuncall;
  public GroupEffect stGroupEffect;
  public Hamlet stHamletItem;
  public ArrayList<Hamlet> stHamletItemList;
  public LoginInfo stLogin;
  public MessageShow stMessageShow;
  public NamePlate stNamePlate;
  public Nudge stNudge;
  public Redpacket stRedpacket;
  public Signature stSignature;
  public SummaryCard stSummaryCard;
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
    cache_stGroupEffect = new GroupEffect();
    cache_ext_map = new HashMap();
    cache_ext_map.put("", "");
    cache_stSummaryCard = new SummaryCard();
    cache_stSignature = new Signature();
    cache_stNamePlate = new NamePlate();
    cache_stExtendFriend = new ExtendFriend();
    cache_stFont = new Font();
  }
  
  public UniSetReq() {}
  
  public UniSetReq(LoginInfo paramLoginInfo, UniBusinessItem paramUniBusinessItem, Hamlet paramHamlet, Bubble paramBubble, Redpacket paramRedpacket, Funcall paramFuncall, MessageShow paramMessageShow, ArrayList<Hamlet> paramArrayList, int paramInt, GroupEffect paramGroupEffect, Map<String, String> paramMap, SummaryCard paramSummaryCard, Signature paramSignature, NamePlate paramNamePlate, ExtendFriend paramExtendFriend, Font paramFont, Concise paramConcise, Nudge paramNudge)
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
    this.stGroupEffect = paramGroupEffect;
    this.ext_map = paramMap;
    this.stSummaryCard = paramSummaryCard;
    this.stSignature = paramSignature;
    this.stNamePlate = paramNamePlate;
    this.stExtendFriend = paramExtendFriend;
    this.stFont = paramFont;
    this.stConcise = paramConcise;
    this.stNudge = paramNudge;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stLogin = ((LoginInfo)paramJceInputStream.read(cache_stLogin, 0, true));
    this.stUniBusinessItem = ((UniBusinessItem)paramJceInputStream.read(cache_stUniBusinessItem, 1, false));
    this.stHamletItem = ((Hamlet)paramJceInputStream.read(cache_stHamletItem, 2, false));
    this.stBubble = ((Bubble)paramJceInputStream.read(cache_stBubble, 3, false));
    this.stRedpacket = ((Redpacket)paramJceInputStream.read(cache_stRedpacket, 4, false));
    this.stFuncall = ((Funcall)paramJceInputStream.read(cache_stFuncall, 5, false));
    this.stMessageShow = ((MessageShow)paramJceInputStream.read(cache_stMessageShow, 6, false));
    this.stHamletItemList = ((ArrayList)paramJceInputStream.read(cache_stHamletItemList, 7, false));
    this.clearflag = paramJceInputStream.read(this.clearflag, 8, false);
    this.stGroupEffect = ((GroupEffect)paramJceInputStream.read(cache_stGroupEffect, 9, false));
    this.ext_map = ((Map)paramJceInputStream.read(cache_ext_map, 10, false));
    this.stSummaryCard = ((SummaryCard)paramJceInputStream.read(cache_stSummaryCard, 11, false));
    this.stSignature = ((Signature)paramJceInputStream.read(cache_stSignature, 12, false));
    this.stNamePlate = ((NamePlate)paramJceInputStream.read(cache_stNamePlate, 13, false));
    this.stExtendFriend = ((ExtendFriend)paramJceInputStream.read(cache_stExtendFriend, 14, false));
    this.stFont = ((Font)paramJceInputStream.read(cache_stFont, 15, false));
    this.stConcise = ((Concise)paramJceInputStream.read(cache_stConcise, 16, false));
    this.stNudge = ((Nudge)paramJceInputStream.read(cache_stNudge, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stLogin, 0);
    if (this.stUniBusinessItem != null) {
      paramJceOutputStream.write(this.stUniBusinessItem, 1);
    }
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
    if (this.stGroupEffect != null) {
      paramJceOutputStream.write(this.stGroupEffect, 9);
    }
    if (this.ext_map != null) {
      paramJceOutputStream.write(this.ext_map, 10);
    }
    if (this.stSummaryCard != null) {
      paramJceOutputStream.write(this.stSummaryCard, 11);
    }
    if (this.stSignature != null) {
      paramJceOutputStream.write(this.stSignature, 12);
    }
    if (this.stNamePlate != null) {
      paramJceOutputStream.write(this.stNamePlate, 13);
    }
    if (this.stExtendFriend != null) {
      paramJceOutputStream.write(this.stExtendFriend, 14);
    }
    if (this.stFont != null) {
      paramJceOutputStream.write(this.stFont, 15);
    }
    if (this.stConcise != null) {
      paramJceOutputStream.write(this.stConcise, 16);
    }
    if (this.stNudge != null) {
      paramJceOutputStream.write(this.stNudge, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniSetReq
 * JD-Core Version:    0.7.0.1
 */