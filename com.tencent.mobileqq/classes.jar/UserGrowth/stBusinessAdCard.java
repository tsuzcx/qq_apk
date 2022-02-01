package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stBusinessAdCard
  extends JceStruct
{
  public String cardButtonTxt = "";
  public String cardImage = "";
  public String cardTitle = "";
  
  public stBusinessAdCard() {}
  
  public stBusinessAdCard(String paramString1, String paramString2, String paramString3)
  {
    this.cardImage = paramString1;
    this.cardTitle = paramString2;
    this.cardButtonTxt = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cardImage = paramJceInputStream.readString(0, false);
    this.cardTitle = paramJceInputStream.readString(1, false);
    this.cardButtonTxt = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.cardImage;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.cardTitle;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.cardButtonTxt;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stBusinessAdCard
 * JD-Core Version:    0.7.0.1
 */