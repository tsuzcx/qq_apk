import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class acxk
  implements aqzb
{
  acxk(acxj paramacxj) {}
  
  public void a(aqyw paramaqyw, int paramInt)
  {
    if ((acxj.a(this.a) == acxj.a(this.a).a().a()) && (acxj.a(this.a, paramaqyw.a(), paramaqyw.a()))) {
      acxj.a(this.a).a().a();
    }
  }
  
  public void a(aqyw paramaqyw, int paramInt1, int paramInt2) {}
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramaqyw.a() + " itemList: " + paramList.size());
    }
    paramVenue = ardn.a(acxj.a(this.a).a).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramaqyw))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramaqyw, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!acxj.a(this.a, paramaqyw.a(), paramaqyw.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (acxj.a(this.a) != acxj.a(this.a).a().a());
    acxj.a(this.a).a().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((aqyu)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(acxj.a(this.a).a.c());
    acxj.a(this.a).a(bool, acxj.a(this.a, paramaqyw, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    acxj.a(this.a).a().a(acxj.a(this.a), new Object[0]);
  }
  
  public void b(aqyw paramaqyw, int paramInt)
  {
    if ((acxj.a(this.a) == acxj.a(this.a).a().a()) && (acxj.a(this.a, paramaqyw.a(), paramaqyw.a()))) {
      acxj.a(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxk
 * JD-Core Version:    0.7.0.1
 */