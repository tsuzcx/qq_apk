import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class agir
  implements awiy
{
  agir(agiq paramagiq) {}
  
  public void a(awit paramawit, int paramInt)
  {
    if ((agiq.a(this.a) == agiq.a(this.a).getTipManager().a()) && (agiq.a(this.a, paramawit.a(), paramawit.a()))) {
      agiq.a(this.a).getTipManager().a();
    }
  }
  
  public void a(awit paramawit, int paramInt1, int paramInt2) {}
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramawit.a() + " itemList: " + paramList.size());
    }
    paramVenue = awnx.a(agiq.a(this.a).app).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramawit))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramawit, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!agiq.a(this.a, paramawit.a(), paramawit.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (agiq.a(this.a) != agiq.a(this.a).getTipManager().a());
    agiq.a(this.a).getTipManager().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((awir)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(agiq.a(this.a).app.getCurrentUin());
    agiq.a(this.a).a(bool, agiq.a(this.a, paramawit, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    agiq.a(this.a).getTipManager().a(agiq.a(this.a), new Object[0]);
  }
  
  public void b(awit paramawit, int paramInt)
  {
    if ((agiq.a(this.a) == agiq.a(this.a).getTipManager().a()) && (agiq.a(this.a, paramawit.a(), paramawit.a()))) {
      agiq.a(this.a).getTipManager().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agir
 * JD-Core Version:    0.7.0.1
 */