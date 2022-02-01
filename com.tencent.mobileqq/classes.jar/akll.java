import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import mqq.observer.AccountObserver;

class akll
  extends AccountObserver
{
  akll(aklk paramaklk) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      aklk.b(this.a, null);
      aklk.a(this.a, null);
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.startUpload(aklk.a(this.a), this.a.mTroopInfo.troopcode, paramString1, this.a.mApp.getCurrentAccountUin());
    aklk.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akll
 * JD-Core Version:    0.7.0.1
 */