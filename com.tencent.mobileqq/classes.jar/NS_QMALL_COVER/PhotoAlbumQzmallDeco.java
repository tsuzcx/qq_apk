package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoAlbumQzmallDeco
  extends JceStruct
{
  static AlbumThemeSkin cache_stAlbumSkin = new AlbumThemeSkin();
  public AlbumThemeSkin stAlbumSkin = null;
  
  public PhotoAlbumQzmallDeco() {}
  
  public PhotoAlbumQzmallDeco(AlbumThemeSkin paramAlbumThemeSkin)
  {
    this.stAlbumSkin = paramAlbumThemeSkin;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stAlbumSkin = ((AlbumThemeSkin)paramJceInputStream.read(cache_stAlbumSkin, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    AlbumThemeSkin localAlbumThemeSkin = this.stAlbumSkin;
    if (localAlbumThemeSkin != null) {
      paramJceOutputStream.write(localAlbumThemeSkin, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.PhotoAlbumQzmallDeco
 * JD-Core Version:    0.7.0.1
 */