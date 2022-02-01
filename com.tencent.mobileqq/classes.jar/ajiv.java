import com.tencent.mobileqq.widget.QQToast;

class ajiv
  extends anuw
{
  ajiv(ajis paramajis) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(ajis.a(this.a), 2131698208, 3000).a();
      if (ajis.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(ajis.a(this.a), 2131698207, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajiv
 * JD-Core Version:    0.7.0.1
 */