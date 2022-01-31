import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

class alza
  implements alyr
{
  alza(alyy paramalyy) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String arg1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onDownloadFinish url: " + ??? + " isSuccess: " + paramBoolean1 + " isFileExist: " + paramBoolean2);
    }
    if (TextUtils.isEmpty(???)) {
      return;
    }
    int i;
    synchronized (this.a.c)
    {
      i = this.a.c.size() - 1;
      if (i >= 0)
      {
        WeakReference localWeakReference = (WeakReference)this.a.c.get(i);
        if ((localWeakReference == null) || (localWeakReference.get() == null))
        {
          this.a.c.remove(i);
        }
        else if (???.equals(((baxo)((WeakReference)this.a.c.get(i)).get()).jdField_b_of_type_JavaLangString))
        {
          localWeakReference = (WeakReference)this.a.c.remove(i);
          if (paramBoolean1)
          {
            this.a.b.add(localWeakReference);
            if (QLog.isColorLevel()) {
              QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish add to wait play list.");
            }
          }
        }
      }
    }
    if (!baxo.jdField_b_of_type_Boolean) {
      synchronized (this.a.d)
      {
        i = this.a.d.size() - 1;
        label257:
        if (i >= 0) {
          if ((this.a.d.get(i) != null) && (((WeakReference)this.a.d.get(i)).get() != null))
          {
            ??? = (WeakReference)this.a.d.get(i);
            label314:
            if ((??? != null) && (???.get() != null)) {
              this.a.a((baxo)???.get(), false, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.a.a)
      {
        i = this.a.a.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.a.a.get(i)).get() == null) {
            this.a.a.remove(i);
          }
          i -= 1;
          continue;
          this.a.d.remove(i);
          i -= 1;
          break label257;
          ??? = finally;
          throw ???;
        }
        i = this.a.b.size() - 1;
        if (i < 0) {
          break label695;
        }
        ??? = (WeakReference)this.a.b.get(i);
        if ((??? == null) || (((WeakReference)???).get() == null))
        {
          this.a.b.remove(i);
        }
        else if (this.a.a.size() < alyy.a(this.a).a)
        {
          this.a.b.remove(i);
          if (this.a.a.contains(???)) {
            break label712;
          }
          paramBoolean1 = this.a.a((baxo)((WeakReference)???).get());
          if (paramBoolean1) {
            this.a.a.add(???);
          }
          if (!QLog.isColorLevel()) {
            break label712;
          }
          QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 result : " + paramBoolean1 + " playing size: " + this.a.a.size());
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("Q.dynamicAvatar", 2, "onFileDownloadFinish to play.02 beyond maxPlayingCount : " + alyy.a(this.a).a);
        break label712;
        label695:
        return;
        ??? = null;
        break label314;
        i -= 1;
        break;
      }
      label712:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alza
 * JD-Core Version:    0.7.0.1
 */