import com.tencent.qphone.base.util.QLog;

class akky
  extends ameq
{
  akky(akkt paramakkt) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(akkt.a(this.a))))
    {
      akkt.a(this.a, String.valueOf(paramLong2), paramBoolean, paramInt);
      QLog.d("RobotAdapter", 2, "onAddRobot  success" + paramBoolean + " resultCode " + paramInt);
      return;
    }
    QLog.i("RobotAdapter", 2, "onAddRobot  troop" + paramLong1 + " cur " + akkt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akky
 * JD-Core Version:    0.7.0.1
 */