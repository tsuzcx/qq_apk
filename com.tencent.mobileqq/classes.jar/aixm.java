import com.tencent.mobileqq.widget.QQToast;

class aixm
  extends aniz
{
  aixm(aixj paramaixj) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(aixj.a(this.a), 2131698107, 3000).a();
      if (aixj.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(aixj.a(this.a), 2131698106, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixm
 * JD-Core Version:    0.7.0.1
 */