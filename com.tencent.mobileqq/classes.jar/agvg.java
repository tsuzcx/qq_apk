import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class agvg
  implements awpp
{
  agvg(agvf paramagvf) {}
  
  public void a(awpk paramawpk, int paramInt)
  {
    if ((agvf.a(this.a) == agvf.a(this.a).a().a()) && (agvf.a(this.a, paramawpk.a(), paramawpk.a()))) {
      agvf.a(this.a).a().a();
    }
  }
  
  public void a(awpk paramawpk, int paramInt1, int paramInt2) {}
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramawpk.a() + " itemList: " + paramList.size());
    }
    paramVenue = awuo.a(agvf.a(this.a).a).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramawpk))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramawpk, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!agvf.a(this.a, paramawpk.a(), paramawpk.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (agvf.a(this.a) != agvf.a(this.a).a().a());
    agvf.a(this.a).a().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((awpi)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(agvf.a(this.a).a.c());
    agvf.a(this.a).a(bool, agvf.a(this.a, paramawpk, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    agvf.a(this.a).a().a(agvf.a(this.a), new Object[0]);
  }
  
  public void b(awpk paramawpk, int paramInt)
  {
    if ((agvf.a(this.a) == agvf.a(this.a).a().a()) && (agvf.a(this.a, paramawpk.a(), paramawpk.a()))) {
      agvf.a(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvg
 * JD-Core Version:    0.7.0.1
 */