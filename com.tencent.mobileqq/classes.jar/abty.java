import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Game;
import com.tencent.mobileqq.data.IPSiteModel.GameRich;
import java.util.ArrayList;
import java.util.List;

public final class abty
  implements Parcelable.Creator
{
  public IPSiteModel.Game a(Parcel paramParcel)
  {
    IPSiteModel.Game localGame = new IPSiteModel.Game();
    localGame.cover = paramParcel.readString();
    localGame.desc = paramParcel.readString();
    localGame.id = paramParcel.readString();
    localGame.jumpUrl = paramParcel.readString();
    localGame.name = paramParcel.readString();
    localGame.recommDesc = paramParcel.readString();
    if (localGame.gameRiches == null) {
      localGame.gameRiches = new ArrayList();
    }
    localGame.gameRiches.clear();
    paramParcel.readList(localGame.gameRiches, IPSiteModel.GameRich.class.getClassLoader());
    return localGame;
  }
  
  public IPSiteModel.Game[] a(int paramInt)
  {
    return new IPSiteModel.Game[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abty
 * JD-Core Version:    0.7.0.1
 */