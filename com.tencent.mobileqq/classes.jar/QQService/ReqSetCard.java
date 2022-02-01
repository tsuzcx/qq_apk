package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ReqSetCard
  extends JceStruct
{
  static int cache_eSubCmd;
  static ReqHead cache_stHeader;
  static ArrayList<TagInfo> cache_vAddTags;
  static byte[] cache_vBackground;
  static ArrayList<TagInfo> cache_vDelTags;
  static byte[] cache_vReqSetTemplate;
  static ArrayList<TagInfo> cache_vTagsID;
  public byte bIsSingle = 0;
  public int eSubCmd = CARDSETTYPE.TYPE_SET_DEFAUT.value();
  public ReqHead stHeader = null;
  public ArrayList<TagInfo> vAddTags = null;
  public byte[] vBackground = null;
  public ArrayList<TagInfo> vDelTags = null;
  public byte[] vReqSetTemplate = null;
  public ArrayList<TagInfo> vTagsID = null;
  
  public ReqSetCard() {}
  
  public ReqSetCard(ReqHead paramReqHead, int paramInt, byte paramByte, ArrayList<TagInfo> paramArrayList1, byte[] paramArrayOfByte1, ArrayList<TagInfo> paramArrayList2, ArrayList<TagInfo> paramArrayList3, byte[] paramArrayOfByte2)
  {
    this.stHeader = paramReqHead;
    this.eSubCmd = paramInt;
    this.bIsSingle = paramByte;
    this.vTagsID = paramArrayList1;
    this.vBackground = paramArrayOfByte1;
    this.vDelTags = paramArrayList2;
    this.vAddTags = paramArrayList3;
    this.vReqSetTemplate = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.eSubCmd = paramJceInputStream.read(this.eSubCmd, 1, true);
    this.bIsSingle = paramJceInputStream.read(this.bIsSingle, 2, false);
    TagInfo localTagInfo;
    if (cache_vTagsID == null)
    {
      cache_vTagsID = new ArrayList();
      localTagInfo = new TagInfo();
      cache_vTagsID.add(localTagInfo);
    }
    this.vTagsID = ((ArrayList)paramJceInputStream.read(cache_vTagsID, 3, false));
    if (cache_vBackground == null)
    {
      cache_vBackground = (byte[])new byte[1];
      ((byte[])cache_vBackground)[0] = 0;
    }
    this.vBackground = ((byte[])paramJceInputStream.read(cache_vBackground, 4, false));
    if (cache_vDelTags == null)
    {
      cache_vDelTags = new ArrayList();
      localTagInfo = new TagInfo();
      cache_vDelTags.add(localTagInfo);
    }
    this.vDelTags = ((ArrayList)paramJceInputStream.read(cache_vDelTags, 5, false));
    if (cache_vAddTags == null)
    {
      cache_vAddTags = new ArrayList();
      localTagInfo = new TagInfo();
      cache_vAddTags.add(localTagInfo);
    }
    this.vAddTags = ((ArrayList)paramJceInputStream.read(cache_vAddTags, 6, false));
    if (cache_vReqSetTemplate == null)
    {
      cache_vReqSetTemplate = (byte[])new byte[1];
      ((byte[])cache_vReqSetTemplate)[0] = 0;
    }
    this.vReqSetTemplate = ((byte[])paramJceInputStream.read(cache_vReqSetTemplate, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.eSubCmd, 1);
    paramJceOutputStream.write(this.bIsSingle, 2);
    Object localObject = this.vTagsID;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.vBackground;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 4);
    }
    localObject = this.vDelTags;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    localObject = this.vAddTags;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.vReqSetTemplate;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqSetCard
 * JD-Core Version:    0.7.0.1
 */