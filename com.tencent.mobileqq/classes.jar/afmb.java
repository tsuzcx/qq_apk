class afmb
  extends ajto
{
  afmb(afly paramafly) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      bcql.a(afly.a(this.a), 2131699212, 3000).a();
      if (afly.a(this.a) != 23) {
        this.a.a(true);
      }
      return;
    }
    bcql.a(afly.a(this.a), 2131699211, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmb
 * JD-Core Version:    0.7.0.1
 */