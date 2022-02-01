import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class abrv
  implements Handler.Callback
{
  private static abrv jdField_a_of_type_Abrv = new abrv();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ConcurrentHashMap<String, WeakReference<View>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private abrv()
  {
    HandlerThread localHandlerThread = new HandlerThread("GdtImpressionPolicy");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static abrv a()
  {
    try
    {
      abrv localabrv = jdField_a_of_type_Abrv;
      return localabrv;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private GdtAd a(View paramView)
  {
    if (paramView == null) {
      paramView = null;
    }
    GdtAd localGdtAd;
    do
    {
      return paramView;
      paramView = paramView.getTag(2131380829);
      if (paramView == null) {
        return null;
      }
      if (!(paramView instanceof GdtAd)) {
        return null;
      }
      localGdtAd = (GdtAd)paramView;
      if (TextUtils.isEmpty(localGdtAd.getTraceId())) {
        return null;
      }
      paramView = localGdtAd;
    } while (!TextUtils.isEmpty(localGdtAd.getUrlForImpression()));
    return null;
  }
  
  private void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, int paramInt)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getAll();
    if (paramSharedPreferences != null)
    {
      Object localObject = paramSharedPreferences.keySet();
      if (((Set)localObject).size() - paramInt > 0)
      {
        int k = Math.abs((int)(((Set)localObject).size() - paramInt * 0.5F));
        paramSharedPreferences = new String[k];
        localObject = ((Set)localObject).iterator();
        int j;
        for (paramInt = 0;; paramInt = j) {
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            j = paramInt + 1;
            paramSharedPreferences[paramInt] = str;
            if (j < k) {}
          }
          else
          {
            j = paramSharedPreferences.length;
            paramInt = i;
            while (paramInt < j)
            {
              paramEditor.remove(paramSharedPreferences[paramInt]);
              paramInt += 1;
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, GdtAd paramGdtAd)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          if ((paramGdtAd.getTraceId() != null) && (!paramGdtAd.getTraceId().equals(str))) {
            a(str);
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  private void a(String paramString, WeakReference<View> paramWeakReference)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramWeakReference);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("GdtImpressionPolicyReported", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    a(localSharedPreferences, localEditor, 8192);
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static boolean a(View paramView)
  {
    return absw.a(paramView) > 0.5D;
  }
  
  private boolean a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("GdtImpressionPolicyReported", 0).getBoolean(paramString, false);
  }
  
  private boolean b(View paramView)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((paramView != null) && (localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(View paramView)
  {
    abrl.a("GdtImpressionPolicy", "report view: " + paramView.hashCode());
    GdtAd localGdtAd = a(paramView);
    if (localGdtAd == null)
    {
      abrl.a("GdtImpressionPolicy", "break: statistics == null");
      return;
    }
    if (localGdtAd.reportState == 2)
    {
      abrl.a("GdtImpressionPolicy", "break: already report " + localGdtAd.getTraceId());
      return;
    }
    if (!a(paramView))
    {
      abrl.a("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not");
      return;
    }
    a(paramView, localGdtAd);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    WeakReference localWeakReference = new WeakReference(paramView);
    localMessage.obj = localWeakReference;
    if (!b(paramView))
    {
      abrl.a("GdtImpressionPolicy", "inCountingMap not " + localGdtAd.getTraceId());
      a(localGdtAd.getTraceId(), localWeakReference);
    }
    localGdtAd.reportState = 1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    abrl.a("GdtImpressionPolicy", "handleMessage : ");
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    GdtAd localGdtAd;
    Object localObject;
    for (;;)
    {
      return false;
      paramMessage = (WeakReference)paramMessage.obj;
      if (paramMessage.get() != null)
      {
        paramMessage = (View)paramMessage.get();
        localGdtAd = a(paramMessage);
        if (localGdtAd == null)
        {
          abrl.a("GdtImpressionPolicy", "break: statistics == null");
        }
        else if (localGdtAd.reportState != 1)
        {
          abrl.a("GdtImpressionPolicy", "break: statistics.reportState != 1 " + localGdtAd.getTraceId());
        }
        else if (!a(paramMessage))
        {
          abrl.a("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not " + localGdtAd.getTraceId());
          localGdtAd.reportState = -1;
        }
        else if (!b(paramMessage))
        {
          abrl.a("GdtImpressionPolicy", "break: inCountingMap not " + localGdtAd.getTraceId());
        }
        else
        {
          localObject = paramMessage.getTag(2131380828);
          if (localObject == null)
          {
            abrl.a("GdtImpressionPolicy", "break: o2 == null " + localGdtAd.getTraceId());
          }
          else if (!(localObject instanceof abrw))
          {
            abrl.a("GdtImpressionPolicy", "break: o2 instanceof ReportListener not " + localGdtAd.getTraceId());
          }
          else
          {
            if (!a(localGdtAd.getTraceId())) {
              break;
            }
            abrl.a("GdtImpressionPolicy", "break: already reported " + localGdtAd.getTraceId());
          }
        }
      }
    }
    ((abrw)localObject).reportImpression(paramMessage);
    localGdtAd.reportState = 2;
    a(localGdtAd.getTraceId(), true);
    abrl.a("GdtImpressionPolicy", "report " + localGdtAd.getTraceId());
    a(localGdtAd.getTraceId());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrv
 * JD-Core Version:    0.7.0.1
 */