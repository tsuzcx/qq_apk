import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class alis
{
  protected float a;
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new alit(this);
  protected Context a;
  public Bitmap a;
  protected Handler a;
  protected LruCache<String, Bitmap> a;
  protected ArrayList<String> a;
  protected HashSet<String> a;
  List<aliw> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  protected Handler b;
  protected LruCache<String, String> b;
  
  public alis(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new aliu(this, Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new aliv(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    float f2 = this.jdField_a_of_type_Float;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < 50 * f2) {
        f1 = i / 50;
      }
    }
    i = (int)(50 * f1);
    int j = (int)(f1 * 50);
    return bacm.a(paramBitmap, i, i, j);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    try
    {
      localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, not in cache:" + paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
        {
          localObject = new ArrayList(1);
          Message localMessage = Message.obtain();
          ((ArrayList)localObject).add(paramString);
          localMessage.obj = localObject;
          localMessage.what = 1001;
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        else if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 50L);
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("NonMainAppHeadLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        return paramBitmap;
        return localObject;
      }
    }
    return paramBitmap;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(aliw paramaliw)
  {
    if (paramaliw == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaliw);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "sendQQHeadRequest, reqSize:" + this.jdField_a_of_type_JavaUtilHashSet.size() + " cacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " " + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        localArrayList.add(str);
      }
    }
    paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
    paramArrayList.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramArrayList.putExtra("faceType", this.jdField_a_of_type_Int);
    paramArrayList.putStringArrayListExtra("uinList", localArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramArrayList, "com.tencent.qqhead.permission.getheadresp");
    this.jdField_a_of_type_JavaUtilHashSet.addAll(localArrayList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "destroy");
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilHashSet.clear();
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
          return;
          localThrowable = localThrowable;
          if (QLog.isColorLevel()) {
            QLog.e("NonMainAppHeadLoader", 2, "destroy:" + localThrowable.toString());
          }
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NonMainAppHeadLoader", 2, "destroy:" + localException.toString());
      }
    }
  }
  
  public void b(aliw paramaliw)
  {
    if (paramaliw == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramaliw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alis
 * JD-Core Version:    0.7.0.1
 */