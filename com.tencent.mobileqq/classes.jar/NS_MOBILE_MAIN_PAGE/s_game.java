package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_game
  extends JceStruct
{
  static ArrayList<s_one_game> cache_stVecGame;
  public ArrayList<s_one_game> stVecGame;
  public long uTotalCount;
  
  public s_game() {}
  
  public s_game(long paramLong, ArrayList<s_one_game> paramArrayList)
  {
    this.uTotalCount = paramLong;
    this.stVecGame = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTotalCount = paramJceInputStream.read(this.uTotalCount, 0, false);
    if (cache_stVecGame == null)
    {
      cache_stVecGame = new ArrayList();
      s_one_game locals_one_game = new s_one_game();
      cache_stVecGame.add(locals_one_game);
    }
    this.stVecGame = ((ArrayList)paramJceInputStream.read(cache_stVecGame, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTotalCount, 0);
    ArrayList localArrayList = this.stVecGame;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_game
 * JD-Core Version:    0.7.0.1
 */