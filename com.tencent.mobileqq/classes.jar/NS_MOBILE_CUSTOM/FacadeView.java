package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class FacadeView
  extends JceStruct
{
  static CustomFileInfo cache_stFileInfo;
  static ProfileRect cache_stProfileRect;
  static ArrayList<ConfigRect> cache_vecConfRect;
  public int iNeedProfileAdjust;
  public CustomFileInfo stFileInfo;
  public ProfileRect stProfileRect;
  public ArrayList<ConfigRect> vecConfRect;
  
  public FacadeView() {}
  
  public FacadeView(CustomFileInfo paramCustomFileInfo, ArrayList<ConfigRect> paramArrayList, ProfileRect paramProfileRect, int paramInt)
  {
    this.stFileInfo = paramCustomFileInfo;
    this.vecConfRect = paramArrayList;
    this.stProfileRect = paramProfileRect;
    this.iNeedProfileAdjust = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stFileInfo == null) {
      cache_stFileInfo = new CustomFileInfo();
    }
    this.stFileInfo = ((CustomFileInfo)paramJceInputStream.read(cache_stFileInfo, 0, false));
    if (cache_vecConfRect == null)
    {
      cache_vecConfRect = new ArrayList();
      ConfigRect localConfigRect = new ConfigRect();
      cache_vecConfRect.add(localConfigRect);
    }
    this.vecConfRect = ((ArrayList)paramJceInputStream.read(cache_vecConfRect, 1, false));
    if (cache_stProfileRect == null) {
      cache_stProfileRect = new ProfileRect();
    }
    this.stProfileRect = ((ProfileRect)paramJceInputStream.read(cache_stProfileRect, 2, false));
    this.iNeedProfileAdjust = paramJceInputStream.read(this.iNeedProfileAdjust, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stFileInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vecConfRect;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.stProfileRect;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    paramJceOutputStream.write(this.iNeedProfileAdjust, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FacadeView
 * JD-Core Version:    0.7.0.1
 */