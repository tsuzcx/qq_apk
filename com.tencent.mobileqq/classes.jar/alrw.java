import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.ColorNoteCurd.1;
import com.tencent.mobileqq.colornote.ColorNoteCurd.2;
import com.tencent.mobileqq.colornote.ColorNoteCurd.3;
import com.tencent.mobileqq.colornote.ColorNoteCurd.4;
import com.tencent.mobileqq.colornote.ColorNoteCurd.5;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.util.Pair;

public class alrw
{
  private alry jdField_a_of_type_Alry;
  private Handler jdField_a_of_type_AndroidOsHandler = new alrx(this);
  
  private void b(int paramInt, String paramString)
  {
    boolean bool = alrz.b(paramInt, paramString);
    Message localMessage = Message.obtain();
    localMessage.obj = new Pair(Integer.valueOf(paramInt), paramString);
    if (bool) {}
    for (localMessage.what = 5;; localMessage.what = 6)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = alrz.a(paramInt, paramString, paramBoolean);
    localBundle.putInt("key_service_type", paramInt);
    localBundle.putString("key_sub_type", paramString);
    paramString = Message.obtain();
    paramString.what = 9;
    paramString.obj = localBundle;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  private void b(Bundle paramBundle)
  {
    boolean bool = alrz.a(paramBundle);
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (bool) {}
    for (localMessage.what = 3;; localMessage.what = 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void c(ColorNote paramColorNote)
  {
    Object localObject = paramColorNote.mUniKey;
    boolean bool2 = true;
    if (paramColorNote.mMainTitle != null) {
      bool2 = alrz.a((String)localObject, "mMainTitle", paramColorNote.mMainTitle);
    }
    boolean bool1 = bool2;
    if (paramColorNote.mSubTitle != null) {
      bool1 = bool2 & alrz.a((String)localObject, "mSubTitle", paramColorNote.mSubTitle);
    }
    bool2 = bool1;
    if (paramColorNote.mPicUrl != null) {
      bool2 = bool1 & alrz.a((String)localObject, "mPicUrl", paramColorNote.mPicUrl);
    }
    localObject = Message.obtain();
    if (bool2) {}
    for (((Message)localObject).what = 10;; ((Message)localObject).what = 11)
    {
      ((Message)localObject).obj = paramColorNote;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  private boolean c()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private void d(ColorNote paramColorNote)
  {
    alrz.a(paramColorNote);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.2(this, paramInt, paramString), 32, null, true);
      return;
    }
    b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.3(this, paramInt, paramString, paramBoolean), 32, null, true);
      return;
    }
    b(paramInt, paramString, paramBoolean);
  }
  
  public void a(alry paramalry)
  {
    this.jdField_a_of_type_Alry = paramalry;
  }
  
  public void a(Bundle paramBundle)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.1(this, paramBundle), 32, null, true);
      return;
    }
    b(paramBundle);
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.4(this, paramColorNote), 32, null, true);
      return;
    }
    c(paramColorNote);
  }
  
  public boolean a()
  {
    return alss.a().c();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return alss.a().a(paramInt, paramString);
  }
  
  public void b(ColorNote paramColorNote)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.5(this, paramColorNote), 32, null, true);
      return;
    }
    d(paramColorNote);
  }
  
  public boolean b()
  {
    return alss.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alrw
 * JD-Core Version:    0.7.0.1
 */