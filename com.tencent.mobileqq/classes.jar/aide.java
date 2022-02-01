import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class aide
  extends CardObserver
{
  aide(aidb paramaidb) {}
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(aidb.a(this.a), 2131698373, 3000).a();
      if (aidb.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(aidb.a(this.a), 2131698372, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aide
 * JD-Core Version:    0.7.0.1
 */