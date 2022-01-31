import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ajnj
  implements aroi
{
  ajnj(ajnf paramajnf) {}
  
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
      synchronized (ajnf.a(this.a))
      {
        Iterator localIterator = ajnf.a(this.a).iterator();
        if (localIterator.hasNext()) {
          ((ajnk)localIterator.next()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajnj
 * JD-Core Version:    0.7.0.1
 */