import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class ajpv
  extends aohy
{
  public ajpv(TroopActivity paramTroopActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (paramBoolean)
    {
      if (paramPBRepeatMessageField != null)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        while (paramPBRepeatMessageField.hasNext())
        {
          oidb_0x5d4.DelResult localDelResult = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
          QLog.d("TroopActivity", 2, "ondelete: uin " + localDelResult.uin.get());
          if (this.a.a != null)
          {
            int i = 0;
            while (i < this.a.a.size())
            {
              Stranger localStranger = (Stranger)this.a.a.get(i);
              if (localStranger.uin.equals(String.valueOf(localDelResult.uin.get()))) {
                this.a.a.remove(localStranger);
              }
              i += 1;
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TroopActivity", 2, "onDelete is failed");
    }
  }
  
  public void a(boolean paramBoolean, List<Stranger> paramList)
  {
    if (paramBoolean) {
      if (paramList != null)
      {
        this.a.a.clear();
        this.a.a.addAll(paramList);
        QLog.d("TroopActivity", 2, "onGetListRemote :" + this.a.a.size());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopActivity", 2, "onGetListRemote is failed");
  }
  
  public void b(boolean paramBoolean, List<Stranger> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      this.a.a.clear();
      this.a.a.addAll(paramList);
      QLog.d("TroopActivity", 2, "onGetListLocal :" + this.a.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpv
 * JD-Core Version:    0.7.0.1
 */