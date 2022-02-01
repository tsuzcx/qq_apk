import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afrg
  implements avcv
{
  afrg(afrf paramafrf) {}
  
  public void a(avcq paramavcq, int paramInt)
  {
    if ((afrf.a(this.a) == afrf.a(this.a).getTipManager().a()) && (afrf.a(this.a, paramavcq.a(), paramavcq.a()))) {
      afrf.a(this.a).getTipManager().a();
    }
  }
  
  public void a(avcq paramavcq, int paramInt1, int paramInt2) {}
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] onUpdateUserLocations: invoked. sessionUin: " + paramavcq.a() + " itemList: " + paramList.size());
    }
    paramVenue = avhu.a(afrf.a(this.a).app).a().a();
    if ((paramVenue != null) && (paramVenue.equals(paramavcq))) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramavcq, " currentFloatWindowVisibleRoomKey: ", paramVenue });
      }
    }
    do
    {
      do
      {
        return;
      } while (!afrf.a(this.a, paramavcq.a(), paramavcq.a()));
      if ((paramList != null) && (!paramList.isEmpty())) {
        break;
      }
    } while (afrf.a(this.a) != afrf.a(this.a).getTipManager().a());
    afrf.a(this.a).getTipManager().a();
    return;
    paramVenue = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      paramVenue.add(((avco)paramList.get(i)).a());
      i += 1;
    }
    boolean bool = paramVenue.contains(afrf.a(this.a).app.getCurrentUin());
    afrf.a(this.a).a(bool, afrf.a(this.a, paramavcq, (String)paramVenue.get(0)), paramList.size(), paramVenue);
    afrf.a(this.a).getTipManager().a(afrf.a(this.a), new Object[0]);
  }
  
  public void b(avcq paramavcq, int paramInt)
  {
    if ((afrf.a(this.a) == afrf.a(this.a).getTipManager().a()) && (afrf.a(this.a, paramavcq.a(), paramavcq.a()))) {
      afrf.a(this.a).getTipManager().a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrg
 * JD-Core Version:    0.7.0.1
 */