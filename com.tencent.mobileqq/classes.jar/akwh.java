import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONObject;

public class akwh
  extends Observable
{
  private static volatile akwh jdField_a_of_type_Akwh;
  private static akwl jdField_a_of_type_Akwl;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static akwh a()
  {
    if (jdField_a_of_type_Akwh == null) {}
    try
    {
      if (jdField_a_of_type_Akwh == null) {
        jdField_a_of_type_Akwh = new akwh();
      }
      return jdField_a_of_type_Akwh;
    }
    finally {}
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator;
        if (((AudioManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2)
        {
          bool = true;
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("is_muted", bool);
          if (QLog.isColorLevel()) {
            QLog.i("ArkPubicEventWrap", 2, "ad_query_mute: " + localJSONObject1.toString());
          }
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            ark.arkNotify((String)localIterator.next(), "ad_query_mute_callback", localJSONObject1.toString(), "json");
            continue;
          }
        }
        JSONObject localJSONObject2;
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("is_muted", false);
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext()) {
            ark.arkNotify((String)localIterator.next(), "ad_query_mute_callback", localJSONObject2.toString(), "json");
          } else {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        if (bgsp.a(paramString2)) {
          return;
        }
        localObject2 = (FragmentActivity)BaseActivity.sTopActivity;
        if (((FragmentActivity)localObject2).getChatFragment() == null) {
          break label609;
        }
        Object localObject1 = ((FragmentActivity)localObject2).getChatFragment();
        if (((ChatFragment)localObject1).a == null) {
          break label578;
        }
        localObject1 = ((ChatFragment)localObject1).a.a;
        JSONArray localJSONArray = new JSONArray();
        localJSONObject1.put("results", localJSONArray);
        float f1 = zlx.a((Context)localObject2, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
        float f2 = ((FragmentActivity)localObject2).getResources().getDimension(2131298998);
        Object localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("width", zlx.a((Context)localObject2, ImmersiveUtils.a()));
        ((JSONObject)localObject3).put("height", zlx.a((Context)localObject2, f1 + f2));
        ((JSONObject)localObject3).put("x", 0);
        ((JSONObject)localObject3).put("y", 0);
        localJSONObject1.put("navigationBarRect", localObject3);
        paramString2 = new JSONObject(paramString2).optJSONArray("arkViewIDs");
        i = 0;
        if (i >= paramString2.length()) {
          break label593;
        }
        localObject3 = paramString2.optString(i);
        Object localObject4 = agpp.a((String)localObject3);
        if (localObject4 == null) {
          break label627;
        }
        JSONObject localJSONObject2 = new JSONObject();
        localJSONArray.put(localJSONObject2);
        localObject2 = new JSONObject();
        localJSONObject2.put("viewID", localObject3);
        localJSONObject2.put("rect", localObject2);
        localObject3 = akxe.a((ChatMessage)localObject4, (ChatXListView)localObject1);
        if (localObject3 == null) {
          break label539;
        }
        localObject3 = (ArkAppView)((View)localObject3).findViewById(2131362910);
        if (localObject3 == null) {
          break label500;
        }
        localObject4 = akxe.a((View)localObject3);
        if (localObject4 != null)
        {
          f1 = zlx.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).top);
          float f3 = zlx.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).bottom);
          f2 = zlx.a(((ArkAppView)localObject3).getContext(), ((ArkAppView)localObject3).getMeasuredHeight());
          if (f3 <= f2) {
            f1 = f3 - f2;
          }
          ((JSONObject)localObject2).put("x", zlx.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).left));
          ((JSONObject)localObject2).put("y", f1);
          ((JSONObject)localObject2).put("width", zlx.a(((ArkAppView)localObject3).getContext(), ((Rect)localObject4).width()));
          ((JSONObject)localObject2).put("height", f2);
        }
      }
      catch (Exception paramString2)
      {
        ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
        return;
      }
      ((JSONObject)localObject2).put("x", 0);
      ((JSONObject)localObject2).put("y", 0);
      ((JSONObject)localObject2).put("width", 0);
      ((JSONObject)localObject2).put("height", 0);
      break label627;
      label500:
      ((JSONObject)localObject2).put("x", 0);
      ((JSONObject)localObject2).put("y", 0);
      ((JSONObject)localObject2).put("width", 0);
      ((JSONObject)localObject2).put("height", 0);
      break label627;
      label539:
      ((JSONObject)localObject2).put("x", 0);
      ((JSONObject)localObject2).put("y", 0);
      ((JSONObject)localObject2).put("width", 0);
      ((JSONObject)localObject2).put("height", 0);
      break label627;
      label578:
      ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
      for (;;)
      {
        label593:
        ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
        return;
        label609:
        ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
      }
      label627:
      i += 1;
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      if (((AudioManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("audio")).getRingerMode() != 2) {}
      for (boolean bool = true;; bool = false)
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("is_muted", bool);
        if (QLog.isColorLevel()) {
          QLog.i("ArkPubicEventWrap", 2, "ad_query_mute: " + localJSONObject1.toString());
        }
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject1.toString(), "json");
        return;
      }
      JSONObject localJSONObject2;
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("is_muted", false);
        ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject2.toString(), "json");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    ArkAppNotifyCenter.setNotify(paramString, new WeakReference(new akwk(this)));
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (jdField_a_of_type_Akwl == null) {
        jdField_a_of_type_Akwl = new akwl(null);
      }
      paramList = new IntentFilter();
      paramList.addAction("android.media.VOLUME_CHANGED_ACTION");
      paramList.addAction("android.intent.action.HEADSET_PLUG");
      paramList.addAction("android.media.AUDIO_BECOMING_NOISY");
      paramList.addAction("android.media.RINGER_MODE_CHANGED");
      BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(jdField_a_of_type_Akwl, paramList);
    }
  }
  
  public void a(String... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.jdField_a_of_type_JavaUtilList.remove(str);
        i += 1;
      }
    }
    if (jdField_a_of_type_Akwl != null)
    {
      BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(jdField_a_of_type_Akwl);
      jdField_a_of_type_Akwl = null;
    }
  }
  
  public void b(String paramString)
  {
    ArkAppNotifyCenter.setNotify(paramString, null);
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
      if (jdField_a_of_type_Akwl != null)
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(jdField_a_of_type_Akwl);
        jdField_a_of_type_Akwl = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwh
 * JD-Core Version:    0.7.0.1
 */