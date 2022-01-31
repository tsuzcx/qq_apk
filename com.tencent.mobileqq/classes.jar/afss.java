import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class afss
{
  public static long a;
  private static afss jdField_a_of_type_Afss;
  public static final String a;
  public static long b;
  public static final String b;
  public Handler a;
  public HandlerThread a;
  HashMap<String, afst> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public MqqHandler a;
  afsu[] jdField_a_of_type_ArrayOfAfsu = null;
  private ArrayList[] jdField_a_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
  private ArrayList[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = bduw.a("Tencent/MobileQQ/poke/");
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "/dazhao_motion/dazhao_move.png";
    jdField_a_of_type_Long = 1500L;
  }
  
  private afss()
  {
    this.jdField_b_of_type_ArrayOfJavaUtilArrayList = new ArrayList[6];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaUtilArrayList.length)
    {
      this.jdField_a_of_type_ArrayOfJavaUtilArrayList[i] = null;
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfJavaUtilArrayList.length)
    {
      this.jdField_b_of_type_ArrayOfJavaUtilArrayList[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfAfsu = new afsu[6];
    afsu[] arrayOfafsu = this.jdField_a_of_type_ArrayOfAfsu;
    int k = arrayOfafsu.length;
    i = j;
    while (i < k)
    {
      afsu localafsu = arrayOfafsu[i];
      localafsu = new afsu(this);
      localafsu.jdField_a_of_type_Int = 1;
      localafsu.jdField_a_of_type_Long = -1L;
      i += 1;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("PokeAIOAnimThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  public static afss a()
  {
    if (jdField_a_of_type_Afss == null) {}
    try
    {
      if (jdField_a_of_type_Afss == null) {
        jdField_a_of_type_Afss = new afss();
      }
      return jdField_a_of_type_Afss;
    }
    finally {}
  }
  
  private void a(String paramString, Context paramContext)
  {
    File localFile1 = new File(paramString);
    if ((localFile1.exists()) && (localFile1.isDirectory()))
    {
      String[] arrayOfString = localFile1.list();
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str1 = arrayOfString[i];
        if (QLog.isColorLevel()) {
          QLog.d("LzmaUtils", 2, "deal current file:" + str1);
        }
        if (new File(paramString + "/" + str1).isDirectory()) {
          a(paramString + "/" + str1, paramContext);
        }
        for (;;)
        {
          i += 1;
          break;
          if (str1.endsWith("7z"))
          {
            String str2 = str1.split("\\.")[0];
            if (QLog.isColorLevel()) {
              QLog.d("LzmaUtils", 2, "dirName:" + str2);
            }
            File localFile2 = new File(localFile1, str2);
            if (localFile2.exists()) {
              bdcs.a(str2, false);
            }
            localFile2.mkdir();
            LzmaUtils.a(paramContext, paramString + "/" + str1, localFile2.getAbsolutePath());
            bdcs.a(paramString + "/" + str1, true);
          }
        }
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS" + jdField_b_of_type_Long + "curFriendUin" + paramString + "type" + paramInt1 + "status" + paramInt3);
    }
    long l1;
    if (jdField_b_of_type_Long == 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      localObject2 = paramQQAppInterface.getAccount();
      l1 = ((SharedPreferences)localObject1).getLong((String)localObject2 + "_" + "aio_poke_strength_rule_interval", 0L) * 1000L;
      jdField_b_of_type_Long = l1;
      if (l1 == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength D_HIT_TIME_MS is not ready");
        }
        return 0;
      }
    }
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null))
    {
      localObject1 = new afst(this);
      ((afst)localObject1).jdField_a_of_type_ArrayOfAfsv = new afsv[6];
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    Object localObject2 = (afst)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localObject2 == null)
    {
      paramQQAppInterface = new HashMap();
      paramQQAppInterface.put(BaseConstants.RDM_NoChangeFailCode, "");
      azmz.a(BaseApplication.getContext()).a(null, "pokeStrengthNullPoint", false, 0L, 0L, paramQQAppInterface, "");
      return 0;
    }
    Object localObject1 = ((afst)localObject2).jdField_a_of_type_ArrayOfAfsv;
    paramInt2 = ((afst)localObject2).jdField_a_of_type_Int;
    if (paramInt1 - 1 == -1) {
      paramInt1 = 0;
    }
    while ((paramInt1 >= 0) && (paramInt1 < 6))
    {
      l1 = SystemClock.uptimeMillis();
      if (localObject1[paramInt1] == null)
      {
        localObject1[paramInt1] = new afsv(this);
        localObject1[paramInt1].jdField_a_of_type_Int = 0;
        localObject1[paramInt1].jdField_b_of_type_Int = 0;
        localObject1[paramInt1].jdField_a_of_type_Long = -1L;
      }
      if (paramInt3 != -1)
      {
        localObject1[paramInt1].jdField_a_of_type_Int = paramInt3;
        localObject1[paramInt1].jdField_a_of_type_Long = l1;
        ((afst)localObject2).jdField_a_of_type_Int = paramInt1;
        return localObject1[paramInt1].jdField_a_of_type_Int;
        paramInt1 -= 1;
      }
      else
      {
        if ((paramInt2 == -1) || (localObject1[paramInt1].jdField_a_of_type_Long == -1L))
        {
          if (paramInt2 != -1) {
            azmj.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          }
          localObject1[paramInt1].jdField_a_of_type_Long = l1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength first click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int);
          }
          ((afst)localObject2).jdField_a_of_type_Int = paramInt1;
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          return localObject1[paramInt1].jdField_a_of_type_Int;
        }
        long l2 = localObject1[paramInt1].jdField_a_of_type_Long;
        localObject1[paramInt1].jdField_a_of_type_Long = l1;
        if (paramInt2 != paramInt1)
        {
          azmj.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int + "to 0");
          }
          ((afst)localObject2).jdField_a_of_type_Int = paramInt1;
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          return localObject1[paramInt1].jdField_a_of_type_Int;
        }
        if (l1 - l2 < jdField_b_of_type_Long)
        {
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.jdField_a_of_type_Int += 1;
          paramQQAppInterface = localObject1[paramInt1];
          paramQQAppInterface.jdField_b_of_type_Int += 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click ,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int);
          }
        }
        for (;;)
        {
          if (localObject1[paramInt1].jdField_a_of_type_Int > 3) {
            localObject1[paramInt1].jdField_a_of_type_Int = 3;
          }
          return localObject1[paramInt1].jdField_a_of_type_Int;
          azmj.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
          localObject1[paramInt1].jdField_a_of_type_Int = 0;
          localObject1[paramInt1].jdField_b_of_type_Int = 1;
          if (QLog.isColorLevel()) {
            QLog.d("PokeMsg", 2, "Strength click,type:" + paramInt1 + ".with status " + localObject1[paramInt1].jdField_a_of_type_Int + ",out of time");
          }
        }
      }
    }
    if (paramInt2 != -1)
    {
      azmj.b(paramQQAppInterface, "CliOper", "", paramString, "0X8008914", "0X8008914", 0, 0, "" + localObject1[paramInt2].jdField_b_of_type_Int, "", "", "");
      ((afst)localObject2).jdField_a_of_type_Int = -1;
    }
    return 0;
  }
  
  public MqqHandler a()
  {
    if ((this.jdField_a_of_type_MqqOsMqqHandler == null) || (this.jdField_a_of_type_AndroidOsHandlerThread == null))
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("PokeAIOAnimThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    }
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label49;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_MqqOsMqqHandler = null;
      return;
      label49:
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Message localMessage;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (localMessage.arg2 = 1;; localMessage.arg2 = 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = paramInt;
      localMessage.obj = Boolean.valueOf(paramBoolean);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  public void a(View paramView)
  {
    paramView = aekt.a(paramView);
    Object localObject;
    if (afiv.class.isInstance(paramView))
    {
      localObject = (afiv)paramView;
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, new Object[] { "==>to be remove obj:", Integer.valueOf(((afiv)localObject).jdField_b_of_type_Int) });
      }
      if ((((afiv)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke))
      {
        paramView = (MessageForPoke)((afiv)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (afsw.a(paramView.interactType)) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      do
      {
        do
        {
          return;
          if (paramView.interactType != 6) {
            break;
          }
        } while (!((afiv)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a());
        localObject = ((afiv)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a();
        paramView.mUnlimitedState.jdField_a_of_type_Int = ((agbq)localObject).jdField_a_of_type_Int;
        paramView.mUnlimitedState.jdField_b_of_type_Int = ((agbq)localObject).jdField_b_of_type_Int;
        paramView.mUnlimitedState.jdField_a_of_type_Long = ((agbq)localObject).jdField_a_of_type_Long;
        paramView.mFrameState.c = ((agbq)localObject).jdField_b_of_type_Boolean;
        paramView.mFrameState.jdField_a_of_type_Boolean = ((agbq)localObject).jdField_a_of_type_Boolean;
        return;
        localObject = ((afiv)localObject).jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getBackground();
      } while (!(localObject instanceof CustomFrameAnimationDrawable));
      localObject = (CustomFrameAnimationDrawable)localObject;
      ((CustomFrameAnimationDrawable)localObject).f();
      ((CustomFrameAnimationDrawable)localObject).a(null);
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "drawble pause");
      }
    } while (paramView.mFrameState.jdField_a_of_type_Int != ((CustomFrameAnimationDrawable)localObject).b());
    paramView.mFrameState.jdField_a_of_type_Boolean = false;
    paramView.mFrameState.c = true;
  }
  
  public void a(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bhow(Looper.getMainLooper(), paramFitSystemWindowsRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afss
 * JD-Core Version:    0.7.0.1
 */