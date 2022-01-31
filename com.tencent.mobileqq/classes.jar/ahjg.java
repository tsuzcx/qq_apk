import com.tencent.mobileqq.widget.QQToast;

class ahjg
  extends allb
{
  ahjg(ahjd paramahjd) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(ahjd.a(this.a), 2131699558, 3000).a();
      if (ahjd.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    QQToast.a(ahjd.a(this.a), 2131699557, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjg
 * JD-Core Version:    0.7.0.1
 */