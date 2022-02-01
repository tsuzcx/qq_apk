package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.Facade;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallFacade
  extends JceStruct
{
  static Facade cache_stFacade = new Facade();
  public int iShowOnFriDyn = 0;
  public Facade stFacade = null;
  
  public QzmallFacade() {}
  
  public QzmallFacade(Facade paramFacade, int paramInt)
  {
    this.stFacade = paramFacade;
    this.iShowOnFriDyn = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFacade = ((Facade)paramJceInputStream.read(cache_stFacade, 0, false));
    this.iShowOnFriDyn = paramJceInputStream.read(this.iShowOnFriDyn, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFacade != null) {
      paramJceOutputStream.write(this.stFacade, 0);
    }
    paramJceOutputStream.write(this.iShowOnFriDyn, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallFacade
 * JD-Core Version:    0.7.0.1
 */