package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Date
  extends JceStruct
{
  public short _day;
  public short _mon;
  public short _year;
  
  public Date() {}
  
  public Date(short paramShort1, short paramShort2, short paramShort3)
  {
    this._year = paramShort1;
    this._mon = paramShort2;
    this._day = paramShort3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._year = paramJceInputStream.read(this._year, 0, true);
    this._mon = paramJceInputStream.read(this._mon, 1, true);
    this._day = paramJceInputStream.read(this._day, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._year, 0);
    paramJceOutputStream.write(this._mon, 1);
    paramJceOutputStream.write(this._day, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     LBS_V2_PROTOCOL.Date
 * JD-Core Version:    0.7.0.1
 */