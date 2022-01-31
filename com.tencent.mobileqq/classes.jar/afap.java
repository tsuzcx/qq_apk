import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afap
  implements atlm
{
  afap(afao paramafao) {}
  
  public void a(atlh paramatlh, int paramInt)
  {
    if ((afao.a(this.a) == afao.a(this.a).a().a()) && (afao.a(this.a, paramatlh.a(), paramatlh.a()))) {
      afao.a(this.a).a().a();
    }
  }
  
  public void a(atlh paramatlh, int paramInt1, int paramInt2) {}
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramatlh.a() + " itemList: " + paramList.size());
    }
    paramVenue = atqj.a(afao.a(this.a).a).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramatlh))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramatlh, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!afao.a(this.a, paramatlh.a(), paramatlh.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (afao.a(this.a) != afao.a(this.a).a().a());
    afao.a(this.a).a().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((atlf)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(afao.a(this.a).a.c());
    afao.a(this.a).a(bool, afao.a(this.a, paramatlh, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    afao.a(this.a).a().a(afao.a(this.a), new Object[0]);
  }
  
  public void b(atlh paramatlh, int paramInt)
  {
    if ((afao.a(this.a) == afao.a(this.a).a().a()) && (afao.a(this.a, paramatlh.a(), paramatlh.a()))) {
      afao.a(this.a).a().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afap
 * JD-Core Version:    0.7.0.1
 */