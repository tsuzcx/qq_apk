import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ajnj
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, bfph
{
  private long jdField_a_of_type_Long;
  private ajrd jdField_a_of_type_Ajrd;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<AppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  private WeakReference<bfpc> c;
  
  public ajnj(AppInterface paramAppInterface, Activity paramActivity)
  {
    try
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      this.jdField_a_of_type_JavaLangString = "";
      return;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.i("ApolloGameInvitation", 1, "[ApolloGameInvitation], errInfo->" + paramAppInterface.getMessage());
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ajrd != null)
    {
      ajcf localajcf = ajac.a(this.jdField_a_of_type_Ajrd.jdField_a_of_type_Int);
      if (localajcf != null) {
        localajcf.a(paramInt1, paramInt2, 0, "");
      }
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    d();
  }
  
  public ajrd a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame.sendmsg", 2, new Object[] { "[getGameMsgInfo], params:", paramString, ",app:", this.jdField_b_of_type_JavaLangRefWeakReference });
    }
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_b_of_type_JavaLangRefWeakReference == null)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      if ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
        return null;
      }
      try
      {
        ajrd localajrd = new ajrd();
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("gameId");
        long l = paramString.optLong("roomId");
        int j = paramString.optInt("gameMode");
        int k = paramString.optInt("activityId");
        Object localObject = ajac.a(i);
        if (localObject != null)
        {
          ((ajcf)localObject).jdField_b_of_type_Int = k;
          localObject = ((ajcf)localObject).a();
          if (localObject != null)
          {
            localajrd.jdField_b_of_type_JavaLangString = ((CmGameInitParams)localObject).mChineseName;
            localajrd.jdField_b_of_type_Int = ((CmGameInitParams)localObject).mActionId;
          }
        }
        if (0L == l) {
          QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo] roomId is invalid. gameId:" + i + ",gameMode:" + j);
        }
        localajrd.jdField_c_of_type_Int = j;
        localajrd.jdField_a_of_type_Long = l;
        localajrd.jdField_a_of_type_Int = i;
        localajrd.d = 3;
        localObject = ajcm.a();
        if ((localObject != null) && (((ajcm)localObject).a != null) && (0L != l)) {
          ((ajcm)localObject).a.roomId = l;
        }
        localObject = paramString.optString("extendInfo");
        JSONObject localJSONObject = new JSONObject();
        paramString = localajrd;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localJSONObject.put("extendInfo", localObject);
          if (((String)localObject).length() >= 500)
          {
            QLog.w("cmgame.sendmsg", 1, "[getGameMsgInfo],extendInfo is too long, extendInfo:" + (String)localObject);
            return null;
          }
          localajrd.jdField_c_of_type_JavaLangString = localJSONObject.toString();
          return localajrd;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloGameInvitation", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void a()
  {
    bfpm localbfpm = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(bfpm.a(0));
    localArrayList.add(bfpm.a(2));
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject != null)
      {
        localbfpm = new bfpm((Context)localObject);
        localbfpm.a(localArrayList);
      }
      if (((this.c == null) || (this.c.get() == null)) && (localObject != null)) {
        this.c = new WeakReference(bfpm.a((Context)localObject, localbfpm, this, this, this, false));
      }
      if ((this.c != null) && (this.c.get() != null))
      {
        localObject = (bfpc)this.c.get();
        if ((localObject != null) && (!((bfpc)localObject).isShowing()))
        {
          ((bfpc)localObject).setOnDismissListener(this);
          ((bfpc)localObject).show();
        }
      }
      return;
    }
  }
  
  public void a(ajrd paramajrd)
  {
    this.jdField_a_of_type_Ajrd = paramajrd;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localActivity == null);
    ajnc.a(this.jdField_a_of_type_Ajrd, localActivity, 1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameInvitation", 2, "[inviteWechatFriend]");
    }
    if (this.jdField_a_of_type_Ajrd == null)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, mGameMsg is null.");
      return;
    }
    ThreadManager.post(new ApolloGameInvitation.1(this), 5, null, true);
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.get() != null))
    {
      bfpc localbfpc = (bfpc)this.c.get();
      if (localbfpc != null) {
        localbfpc.dismiss();
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1000L) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = l;
      d();
      if (paramLong == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_WX_FRIEND is clicked.");
        }
        c();
      }
      for (paramInt = 1; (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_Ajrd != null) && ((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get() != null); paramInt = 0)
      {
        VipUtils.a(null, "cmshow", "Apollo", "invite_chose", paramInt, 0, new String[] { Integer.toString(this.jdField_a_of_type_Ajrd.jdField_a_of_type_Int) });
        return;
        if (paramLong == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloGameInvitation", 2, "ActionSheetAdapter.CHANNEL_QQ is clicked.");
          }
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajnj
 * JD-Core Version:    0.7.0.1
 */