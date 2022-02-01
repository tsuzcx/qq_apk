class agig
  extends aofu
{
  agig(agif paramagif) {}
  
  protected void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong)
  {
    agif.a(this.a, paramBoolean, paramString);
  }
  
  protected void onTroopFlagExt4Changed(boolean paramBoolean, String paramString, int paramInt)
  {
    agif.a(this.a, paramBoolean, paramString);
  }
  
  protected void onUpdateRecentList()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agig
 * JD-Core Version:    0.7.0.1
 */