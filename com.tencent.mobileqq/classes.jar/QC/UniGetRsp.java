package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UniGetRsp
  extends JceStruct
{
  static NamePlate cache_stNamePlate = new NamePlate();
  static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList();
  public String errmsg = "";
  public int ret = 0;
  public NamePlate stNamePlate = null;
  public ArrayList<UniBusinessItem> uniBusinessItemList = null;
  
  static
  {
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    cache_uniBusinessItemList.add(localUniBusinessItem);
  }
  
  public UniGetRsp() {}
  
  public UniGetRsp(int paramInt, String paramString, ArrayList<UniBusinessItem> paramArrayList, NamePlate paramNamePlate)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.uniBusinessItemList = paramArrayList;
    this.stNamePlate = paramNamePlate;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.uniBusinessItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusinessItemList, 2, false));
    this.stNamePlate = ((NamePlate)paramJceInputStream.read(cache_stNamePlate, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.uniBusinessItemList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stNamePlate;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniGetRsp
 * JD-Core Version:    0.7.0.1
 */