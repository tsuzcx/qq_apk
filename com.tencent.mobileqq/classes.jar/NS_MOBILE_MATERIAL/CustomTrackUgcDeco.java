package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CustomTrackUgcDeco
  extends JceStruct
{
  static UgcCustomTrack cache_stUgcCustomTrack = new UgcCustomTrack();
  public UgcCustomTrack stUgcCustomTrack = null;
  
  public CustomTrackUgcDeco() {}
  
  public CustomTrackUgcDeco(UgcCustomTrack paramUgcCustomTrack)
  {
    this.stUgcCustomTrack = paramUgcCustomTrack;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stUgcCustomTrack = ((UgcCustomTrack)paramJceInputStream.read(cache_stUgcCustomTrack, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    UgcCustomTrack localUgcCustomTrack = this.stUgcCustomTrack;
    if (localUgcCustomTrack != null) {
      paramJceOutputStream.write(localUgcCustomTrack, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomTrackUgcDeco
 * JD-Core Version:    0.7.0.1
 */