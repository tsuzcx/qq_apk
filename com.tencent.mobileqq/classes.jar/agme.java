import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class agme
  implements avwu
{
  agme(agmd paramagmd) {}
  
  public void a(avwp paramavwp, int paramInt)
  {
    if ((agmd.a(this.a) == agmd.a(this.a).a().a()) && (agmd.a(this.a, paramavwp.a(), paramavwp.a()))) {
      agmd.a(this.a).a().a();
    }
  }
  
  public void a(avwp paramavwp, int paramInt1, int paramInt2) {}
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramavwp.a() + " itemList: " + paramList.size());
    }
    paramVenue = awbw.a(agmd.a(this.a).a).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramavwp))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramavwp, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!agmd.a(this.a, paramavwp.a(), paramavwp.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (agmd.a(this.a) != agmd.a(this.a).a().a());
    agmd.a(this.a).a().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((avwn)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(agmd.a(this.a).a.c());
    agmd.a(this.a).a(bool, agmd.a(this.a, paramavwp, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    agmd.a(this.a).a().a(agmd.a(this.a), new Object[0]);
  }
  
  public void b(avwp paramavwp, int paramInt)
  {
    if ((agmd.a(this.a) == agmd.a(this.a).a().a()) && (agmd.a(this.a, paramavwp.a(), paramavwp.a()))) {
      agmd.a(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agme
 * JD-Core Version:    0.7.0.1
 */