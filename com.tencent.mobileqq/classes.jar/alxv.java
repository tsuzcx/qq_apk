import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class alxv
  implements aufw
{
  alxv(alxr paramalxr) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onBindStateChanged = " + paramInt);
    }
    this.a.d();
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onRecommendCountChanged = " + paramInt);
    }
    this.a.d();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onUpdateContactList = " + paramInt);
    }
    if ((paramInt & 0x1) != 0) {
      synchronized (alxr.a(this.a))
      {
        Iterator localIterator = alxr.a(this.a).iterator();
        if (localIterator.hasNext()) {
          ((alxx)localIterator.next()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxv
 * JD-Core Version:    0.7.0.1
 */