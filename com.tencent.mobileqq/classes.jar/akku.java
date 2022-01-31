import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qphone.base.util.QLog;

class akku
  implements Runnable
{
  akku(akko paramakko) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "--> handler message UPDATE_DROP_DOWN_VIEWS");
    }
    this.a.a.a.a.b();
    this.a.a.runOnUiThread(new akkv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akku
 * JD-Core Version:    0.7.0.1
 */