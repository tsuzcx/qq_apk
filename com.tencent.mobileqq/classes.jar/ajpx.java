import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import mqq.observer.AccountObserver;

class ajpx
  extends AccountObserver
{
  ajpx(ajpw paramajpw) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      ajpw.b(this.a, null);
      ajpw.a(this.a, null);
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.startUpload(ajpw.a(this.a), this.a.mTroopInfo.troopcode, paramString1, this.a.mApp.getCurrentAccountUin());
    ajpw.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */