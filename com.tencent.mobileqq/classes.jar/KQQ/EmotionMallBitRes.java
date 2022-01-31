package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EmotionMallBitRes
  extends JceStruct
{
  public byte cEmotionMall = -1;
  
  public EmotionMallBitRes() {}
  
  public EmotionMallBitRes(byte paramByte)
  {
    this.cEmotionMall = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.EmotionMallBitRes
 * JD-Core Version:    0.7.0.1
 */