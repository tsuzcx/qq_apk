package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserFacadeElementDetail
  extends JceStruct
{
  static ElementInfo cache_background = new ElementInfo();
  static ArrayList<ElementInfo> cache_icons = new ArrayList();
  static ArrayList<ElementInfo> cache_other;
  public ElementInfo background;
  public ArrayList<ElementInfo> icons;
  public int lottieId;
  public ArrayList<ElementInfo> other;
  public int templateId;
  public int themeId;
  
  static
  {
    ElementInfo localElementInfo = new ElementInfo();
    cache_icons.add(localElementInfo);
    cache_other = new ArrayList();
    localElementInfo = new ElementInfo();
    cache_other.add(localElementInfo);
  }
  
  public UserFacadeElementDetail() {}
  
  public UserFacadeElementDetail(int paramInt1, int paramInt2, int paramInt3, ElementInfo paramElementInfo, ArrayList<ElementInfo> paramArrayList1, ArrayList<ElementInfo> paramArrayList2)
  {
    this.templateId = paramInt1;
    this.themeId = paramInt2;
    this.lottieId = paramInt3;
    this.background = paramElementInfo;
    this.icons = paramArrayList1;
    this.other = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.templateId = paramJceInputStream.read(this.templateId, 0, false);
    this.themeId = paramJceInputStream.read(this.themeId, 1, false);
    this.lottieId = paramJceInputStream.read(this.lottieId, 2, false);
    this.background = ((ElementInfo)paramJceInputStream.read(cache_background, 3, false));
    this.icons = ((ArrayList)paramJceInputStream.read(cache_icons, 4, false));
    this.other = ((ArrayList)paramJceInputStream.read(cache_other, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.templateId, 0);
    paramJceOutputStream.write(this.themeId, 1);
    paramJceOutputStream.write(this.lottieId, 2);
    if (this.background != null) {
      paramJceOutputStream.write(this.background, 3);
    }
    if (this.icons != null) {
      paramJceOutputStream.write(this.icons, 4);
    }
    if (this.other != null) {
      paramJceOutputStream.write(this.other, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FACADE_DIY.UserFacadeElementDetail
 * JD-Core Version:    0.7.0.1
 */