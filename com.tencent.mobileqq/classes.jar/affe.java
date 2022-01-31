import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class affe
  implements atpv
{
  affe(affd paramaffd) {}
  
  public void a(atpq paramatpq, int paramInt)
  {
    if ((affd.a(this.a) == affd.a(this.a).a().a()) && (affd.a(this.a, paramatpq.a(), paramatpq.a()))) {
      affd.a(this.a).a().a();
    }
  }
  
  public void a(atpq paramatpq, int paramInt1, int paramInt2) {}
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramatpq.a() + " itemList: " + paramList.size());
    }
    paramVenue = atus.a(affd.a(this.a).a).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramatpq))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramatpq, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!affd.a(this.a, paramatpq.a(), paramatpq.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (affd.a(this.a) != affd.a(this.a).a().a());
    affd.a(this.a).a().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((atpo)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(affd.a(this.a).a.c());
    affd.a(this.a).a(bool, affd.a(this.a, paramatpq, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    affd.a(this.a).a().a(affd.a(this.a), new Object[0]);
  }
  
  public void b(atpq paramatpq, int paramInt)
  {
    if ((affd.a(this.a) == affd.a(this.a).a().a()) && (affd.a(this.a, paramatpq.a(), paramatpq.a()))) {
      affd.a(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affe
 * JD-Core Version:    0.7.0.1
 */