import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment.MyTroopObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class affy
  extends ajuc
{
  public affy(TroopFragment paramTroopFragment) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.h();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.h();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.h();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_Afdq != null) {
      this.a.jdField_a_of_type_Afdq.b();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (this.a.jdField_a_of_type_Afex != null) {
        this.a.jdField_a_of_type_Afex.a(this.a.b(), paramBoolean, null);
      }
    }
    ThreadManager.getUIHandler().postDelayed(new TroopFragment.MyTroopObserver.1(this), 500L);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     affy
 * JD-Core Version:    0.7.0.1
 */