package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
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
  public int clearflag = 0;
  public Map<String, String> ext_map = null;
  public Bubble stBubble = null;
  public Concise stConcise = null;
  public ExtendFriend stExtendFriend = null;
  public Font stFont = null;
  public Funcall stFuncall = null;
  public GroupEffect stGroupEffect = null;
  public Hamlet stHamletItem = null;
  public ArrayList<Hamlet> stHamletItemList = null;
  public LoginInfo stLogin = null;
  public MessageShow stMessageShow = null;
  public NamePlate stNamePlate = null;
  public Nudge stNudge = null;
  public Redpacket stRedpacket = null;
  public Signature stSignature = null;
  public SummaryCard stSummaryCard = null;
  public UniBusinessItem stUniBusinessItem = null;
  
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
    Object localObject = this.stUniBusinessItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stHamletItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stBubble;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stRedpacket;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stFuncall;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.stMessageShow;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stHamletItemList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    paramJceOutputStream.write(this.clearflag, 8);
    localObject = this.stGroupEffect;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.ext_map;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
    localObject = this.stSummaryCard;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 11);
    }
    localObject = this.stSignature;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 12);
    }
    localObject = this.stNamePlate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
    localObject = this.stExtendFriend;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    localObject = this.stFont;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
    localObject = this.stConcise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 16);
    }
    localObject = this.stNudge;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniSetReq
 * JD-Core Version:    0.7.0.1
 */