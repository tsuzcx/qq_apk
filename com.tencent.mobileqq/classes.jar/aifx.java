import com.tencent.qphone.base.util.QLog;

class aifx
  extends avva
{
  aifx(aiez paramaiez) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramInt != 2)) {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGameCenterMsgReceive.type=" + paramInt);
      }
    }
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
      this.a.g();
      return;
    case 1: 
      this.a.g();
      return;
    case 4: 
      this.a.g();
      return;
    }
    this.a.g();
    this.a.e();
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifx
 * JD-Core Version:    0.7.0.1
 */