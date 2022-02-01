package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UserFacadeElementDetail
  extends JceStruct
{
  static ElementInfo cache_background = new ElementInfo();
  static ArrayList<ElementInfo> cache_icons = new ArrayList();
  static ArrayList<ElementInfo> cache_other;
  public ElementInfo background = null;
  public ArrayList<ElementInfo> icons = null;
  public int lottieId = 0;
  public ArrayList<ElementInfo> other = null;
  public int templateId = 0;
  public int themeId = 0;
  
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
    Object localObject = this.background;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.icons;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.other;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FACADE_DIY.UserFacadeElementDetail
 * JD-Core Version:    0.7.0.1
 */