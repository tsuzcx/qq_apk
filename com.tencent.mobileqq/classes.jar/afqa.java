import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class afqa
  implements afrc, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private andd jdField_a_of_type_Andd = new afqb(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, Long> b;
  
  public afqa(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private long a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(localSharedPreferences.getLong(str, 0L)));
    }
    return ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin() + paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("colckInEntryLastShowTime", 0).edit().putLong(paramString, paramLong);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) {}
    do
    {
      do
      {
        return;
        localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.findViewById(2131369077);
      } while (localObject == null);
      if (!paramBoolean1) {
        break label192;
      }
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (!paramBoolean2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    } while (!paramBoolean3);
    Object localObject = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))) {
        ((HashMap)localObject).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin()))) {
        ((HashMap)localObject).put("A8", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin());
      }
    }
    bddt.a("play#aio_icon_video", (HashMap)localObject);
    return;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setProgress(1.0F);
    return;
    label192:
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    ((ImageView)localObject).setVisibility(0);
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.findViewById(2131365271);
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        localObject = ((ViewStub)localObject).inflate();
        if (localObject != null) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null);
      return false;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)((View)localObject).findViewById(2131369113));
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null);
    return false;
  }
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private long b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    if (!this.b.containsKey(paramString))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin() + paramString;
      long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("colckInime", 0).getLong(str, 0L);
      this.b.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.b.get(paramString)).longValue();
  }
  
  private void b(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    this.b.put(paramString, Long.valueOf(paramLong));
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin() + paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("colckInime", 0).edit().putLong(paramString, paramLong);
  }
  
  private boolean b()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    if (TextUtils.isEmpty(str)) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = a(str);
      if (l1 <= 0L) {
        return true;
      }
      l2 = NetConnInfoCenter.getServerTime();
    } while (l1 > l2);
    if ((int)(l2 / 86400L - l1 / 86400L) > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    if (TextUtils.isEmpty(str)) {}
    long l1;
    do
    {
      return false;
      l1 = b(str);
    } while (l1 <= 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {
      return true;
    }
    if ((int)(l2 / 86400L - l1 / 86400L) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid chatPie");
      }
      return false;
    }
    if (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: is homeWorkTroop");
      }
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(52);
    if ((localObject != null) && (!((TroopManager)localObject).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: isPassiveExit");
      }
      return false;
    }
    localObject = (aqdf)apub.a().a(553);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid config, id: 553");
      }
      return false;
    }
    return ((aqdf)localObject).jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onCreate()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType != 1) || (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))) {
      return;
    }
    a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
    {
      QLog.d("ClockInEntryHelper.helper", 2, "onCreate ClockInEntry is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Andd);
    if (!d()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, localSharedPreferences.getLong(str, 0L));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
      a();
      return;
    case 5: 
      b();
      return;
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null)) {
      return;
    }
    if (!a())
    {
      QLog.d("ClockInEntryHelper.helper", 2, "handleClockInEntryThemeChange: !getClockInEntry()");
      return;
    }
    if (!d())
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    if (!ThemeUtil.isDefaultOrDIYTheme(false)) {}
    for (float f = 1.0F;; f = 3.0F)
    {
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(f, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getResources());
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      try
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity().getAssets().open("troop_sign_in/data.json");
          this.jdField_a_of_type_JavaLangString = npn.a((InputStream)localObject);
          ((InputStream)localObject).close();
        }
        int i = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView.findViewById(2131378707)).getCurrentTextColor();
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != i))
        {
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("ClockInEntryHelper.helper", 2, "color change: " + i);
          }
          double d1 = ((0xFF000000 & i) >> 20) / 255.0D;
          double d2 = ((0xFF0000 & i) >> 16) / 255.0D;
          double d3 = ((0xFF00 & i) >> 8) / 255.0D;
          double d4 = (i & 0xFF) / 255.0D;
          localObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
          JSONArray localJSONArray1 = ((JSONObject)localObject).getJSONArray("assets").getJSONObject(0).getJSONArray("layers");
          JSONArray localJSONArray2 = localJSONArray1.getJSONObject(1).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
          localJSONArray2.put(0, d2);
          localJSONArray2.put(1, d3);
          localJSONArray2.put(2, d4);
          localJSONArray2.put(3, d1);
          localJSONArray2 = localJSONArray1.getJSONObject(2).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
          localJSONArray2.put(0, d2);
          localJSONArray2.put(1, d3);
          localJSONArray2.put(2, d4);
          localJSONArray2.put(3, d1);
          localJSONArray2 = localJSONArray1.getJSONObject(3).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(3).getJSONObject("c").getJSONArray("k");
          localJSONArray2.put(0, d2);
          localJSONArray2.put(1, d3);
          localJSONArray2.put(2, d4);
          localJSONArray2.put(3, d1);
          localJSONArray1 = localJSONArray1.getJSONObject(4).getJSONArray("shapes").getJSONObject(0).getJSONArray("it").getJSONObject(1).getJSONObject("c").getJSONArray("k");
          localJSONArray1.put(0, d2);
          localJSONArray1.put(1, d3);
          localJSONArray1.put(2, d4);
          localJSONArray1.put(3, d1);
          if (!TextUtils.isEmpty(((JSONObject)localObject).toString())) {
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = "";
          QLog.d("ClockInEntryHelper.helper", 2, "json parse error", localException);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("troop_sign_in/data.json");
          continue;
          boolean bool = false;
        }
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromJson(this.jdField_a_of_type_JavaLangString);
      if (a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getScale(), 1)) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleXY(0.5F, 0.5F);
      }
      if (c()) {
        break label761;
      }
      bool = true;
      a(bool, b(), paramBoolean);
      return;
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 13 };
  }
  
  public void b()
  {
    if (!d()) {
      return;
    }
    boolean bool1 = c();
    boolean bool2 = b();
    int i;
    if (bool1)
    {
      a(false, false, false);
      NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mCustomTitleView;
      if (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
      {
        i = 2130850342;
        localNavBarAIO.setRight2Icon(i);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "onResume: mTitleClockInEntry visiable " + bool1 + " animation: " + bool2);
      }
      long l = NetConnInfoCenter.getServerTime();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, l);
      return;
      i = 2130850343;
      break;
      if (bool2) {
        a(true, true, false);
      } else {
        a(true, false, false);
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onDestroy()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Andd);
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369113)
    {
      afsw localafsw = (afsw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(43);
      if (localafsw != null) {
        localafsw.c(1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqa
 * JD-Core Version:    0.7.0.1
 */