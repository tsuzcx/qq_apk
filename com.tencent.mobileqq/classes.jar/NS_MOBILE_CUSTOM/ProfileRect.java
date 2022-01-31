package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfileRect
  extends JceStruct
{
  static int cache_eAlignType;
  static ArrayList cache_vecIndexContainer;
  public int eAlignType;
  public int iHp;
  public int iWp;
  public int iXp;
  public int iYp;
  public ArrayList vecIndexContainer;
  
  public ProfileRect() {}
  
  public ProfileRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ArrayList paramArrayList)
  {
    this.iXp = paramInt1;
    this.iYp = paramInt2;
    this.iWp = paramInt3;
    this.iHp = paramInt4;
    this.eAlignType = paramInt5;
    this.vecIndexContainer = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iXp = paramJceInputStream.read(this.iXp, 0, false);
    this.iYp = paramJceInputStream.read(this.iYp, 1, false);
    this.iWp = paramJceInputStream.read(this.iWp, 2, false);
    this.iHp = paramJceInputStream.read(this.iHp, 3, false);
    this.eAlignType = paramJceInputStream.read(this.eAlignType, 4, false);
    if (cache_vecIndexContainer == null)
    {
      cache_vecIndexContainer = new ArrayList();
      cache_vecIndexContainer.add(Integer.valueOf(0));
    }
    this.vecIndexContainer = ((ArrayList)paramJceInputStream.read(cache_vecIndexContainer, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iXp, 0);
    paramJceOutputStream.write(this.iYp, 1);
    paramJceOutputStream.write(this.iWp, 2);
    paramJceOutputStream.write(this.iHp, 3);
    paramJceOutputStream.write(this.eAlignType, 4);
    if (this.vecIndexContainer != null) {
      paramJceOutputStream.write(this.vecIndexContainer, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.ProfileRect
 * JD-Core Version:    0.7.0.1
 */