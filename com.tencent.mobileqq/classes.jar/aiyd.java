import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class aiyd
  extends CardObserver
{
  aiyd(aiya paramaiya) {}
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(aiya.a(this.a), 2131698669, 3000).a();
      if (aiya.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(aiya.a(this.a), 2131698668, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyd
 * JD-Core Version:    0.7.0.1
 */