package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PolymorphicPraise
  extends JceStruct
{
  static EmotionPraise cache_stOperationPraise = new EmotionPraise();
  static ArrayList<EmotionPraise> cache_vecEmotionPraise = new ArrayList();
  public int iGuideToUse = 0;
  public int iItemId = -1;
  public EmotionPraise stOperationPraise = null;
  public ArrayList<EmotionPraise> vecEmotionPraise = null;
  
  static
  {
    EmotionPraise localEmotionPraise = new EmotionPraise();
    cache_vecEmotionPraise.add(localEmotionPraise);
  }
  
  public PolymorphicPraise() {}
  
  public PolymorphicPraise(int paramInt1, ArrayList<EmotionPraise> paramArrayList, EmotionPraise paramEmotionPraise, int paramInt2)
  {
    this.iItemId = paramInt1;
    this.vecEmotionPraise = paramArrayList;
    this.stOperationPraise = paramEmotionPraise;
    this.iGuideToUse = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.vecEmotionPraise = ((ArrayList)paramJceInputStream.read(cache_vecEmotionPraise, 1, false));
    this.stOperationPraise = ((EmotionPraise)paramJceInputStream.read(cache_stOperationPraise, 2, false));
    this.iGuideToUse = paramJceInputStream.read(this.iGuideToUse, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.vecEmotionPraise != null) {
      paramJceOutputStream.write(this.vecEmotionPraise, 1);
    }
    if (this.stOperationPraise != null) {
      paramJceOutputStream.write(this.stOperationPraise, 2);
    }
    paramJceOutputStream.write(this.iGuideToUse, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.PolymorphicPraise
 * JD-Core Version:    0.7.0.1
 */