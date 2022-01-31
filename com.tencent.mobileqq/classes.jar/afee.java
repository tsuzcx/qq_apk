import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AppShortcutBarAIOHelper.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class afee
  implements affa
{
  private int jdField_a_of_type_Int;
  private alwx jdField_a_of_type_Alwx;
  protected View.OnClickListener a;
  private bcim jdField_a_of_type_Bcim;
  private bcio jdField_a_of_type_Bcio;
  private bcip jdField_a_of_type_Bcip;
  private bepm jdField_a_of_type_Bepm = new afei(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AppShortcutBarScrollView a;
  ArrayList<Pair<URLDrawable, URLImageView>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public afee(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afek(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (babd.a()) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      bool = false;
    }
    int i;
    int j;
    do
    {
      return bool;
      i = (int)(paramMotionEvent.getX() + 0.5F);
      j = (int)(paramMotionEvent.getY() + 0.5F);
      paramMotionEvent = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getLocationOnScreen(paramMotionEvent);
    } while (new RectF(paramMotionEvent[0], paramMotionEvent[1], paramMotionEvent[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getWidth(), paramMotionEvent[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight()).contains(i, j));
    return false;
  }
  
  public String a(String paramString, long paramLong, int paramInt, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$CLIENTVER$", "android8.3.5").replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
      if (!paramBoolean) {
        break label179;
      }
    }
    label179:
    for (paramString = "1";; paramString = "2")
    {
      str = str.replace("$ENTERSOURCE$", paramString).replace("$GUIN$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$UNREADNUM$", String.valueOf(paramInt));
      paramString = str;
      if (!TextUtils.isEmpty(paramTroopInfo.newTroopName)) {
        paramString = str.replace("$GNAME$", paramTroopInfo.newTroopName);
      }
      return paramString;
      if (paramTroopInfo.isAdmin())
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c != null)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558555, null));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new afef(this));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(2, 2131368344);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
            this.jdField_a_of_type_Bcim = ((bcim)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171));
            this.jdField_a_of_type_Bcio = ((bcio)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355));
            this.jdField_a_of_type_Bcip = new afeg(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_Alwx = new afeh(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcip);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got OOM, e:" + localOutOfMemoryError.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got InflateException, e:" + localInflateException.getMessage());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = null;
          System.gc();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      b();
      return;
    case 4: 
      d();
      return;
    }
    c();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131370829);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376206);
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131370829) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131370829);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376206);
  }
  
  void a(bcij parambcij, View paramView)
  {
    paramView.setTag(parambcij);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131376635);
    ((TextView)localObject).setText(parambcij.a());
    if (bool)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131376632);
      if (!bool) {
        break label264;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838519));
      label97:
      localObject = (TextView)paramView.findViewById(2131376634);
      if (parambcij.b() == 0) {
        break label288;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837725, 0, 0, 0);
      label147:
      paramView = (URLImageView)paramView.findViewById(2131376633);
      if (bool) {
        paramView.setColorFilter(1996488704);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bayu.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (parambcij.b() == null) {
        break label338;
      }
      parambcij = URLDrawable.getDrawable(parambcij.b(), (URLDrawable.URLDrawableOptions)localObject);
      if (parambcij.getStatus() != 1) {
        break label297;
      }
      parambcij = parambcij.getCurrDrawable();
      if ((parambcij instanceof RegionDrawable))
      {
        paramView.setImageBitmap(((RegionDrawable)parambcij).getBitmap());
        paramView.setVisibility(0);
      }
    }
    label264:
    label288:
    label297:
    do
    {
      return;
      ((TextView)localObject).setTextColor(Color.parseColor("#1C1D1E"));
      break;
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838518));
      break label97;
      ((TextView)localObject).setVisibility(4);
      break label147;
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parambcij, paramView));
      parambcij.setURLDrawableListener(new afej(this));
    } while (parambcij.isDownloadStarted());
    parambcij.startDownload();
    return;
    label338:
    paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843303));
  }
  
  void a(bcin parambcin)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    LinearLayout localLinearLayout;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          return;
          if (parambcin != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. info is null.");
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371563);
        if (localLinearLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. appShortcutPanel is null.");
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. troopInfo is null.");
    return;
    Object localObject1 = (bcik)aoks.a().a(590);
    int i;
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && ((((bcik)localObject1).a((int)localTroopInfo.dwGroupClassExt)) || (((bcik)localObject1).b((int)localTroopInfo.dwGroupClassExt))))
    {
      localLinearLayout.removeAllViews();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (i = 1; ((parambcin.a() == 1) && (i == 0)) || (parambcin.b() == 1); i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. Switch is off.");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        f();
        return;
      }
      parambcin = parambcin.a();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. applist size: " + parambcin.size());
      }
      parambcin = parambcin.iterator();
      i = 1;
      bool = false;
      if (parambcin.hasNext())
      {
        localObject2 = (bcij)parambcin.next();
        if (((bcij)localObject2).a() != 0) {
          break label763;
        }
      }
    }
    label763:
    for (;;)
    {
      try
      {
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561364, null);
        a((bcij)localObject2, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        int j = i;
        if (i != 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).setMargins(aepi.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          j = 0;
        }
        i = j;
        bool = true;
      }
      catch (OutOfMemoryError parambcin)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambcin.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambcin)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambcin.getMessage());
        }
        System.gc();
        return;
      }
      if (bool) {}
      try
      {
        parambcin = bcij.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696679), "https://pub.idqqimg.com/pc/misc/files/20200114/manager.png");
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561364, null);
        a(parambcin, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          e();
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            azqs.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
          }
          ThreadManager.getUIHandler().postDelayed(new AppShortcutBarAIOHelper.5(this), 200L);
          return;
        }
      }
      catch (OutOfMemoryError parambcin)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambcin.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambcin)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambcin.getMessage());
        }
        System.gc();
        return;
      }
      f();
      return;
      this.jdField_a_of_type_Boolean = false;
      f();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public boolean a()
  {
    boolean bool = this.c;
    this.c = false;
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "triggerSyncOnce() syncOnce = " + bool);
    }
    return bool;
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 11 };
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_Bepm);
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Boolean = false;
      f();
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
      }
      if (this.jdField_a_of_type_Bcip != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bcip);
      }
      if (this.jdField_a_of_type_Alwx != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_Bepm);
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localObject = (bcik)aoks.a().a(590);
    } while ((localObject == null) || (localTroopInfo == null) || ((!((bcik)localObject).a((int)localTroopInfo.dwGroupClassExt)) && (!((bcik)localObject).b((int)localTroopInfo.dwGroupClassExt))));
    Object localObject = this.jdField_a_of_type_Bcio.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    if (localObject != null)
    {
      if (babd.a()) {}
      for (int i = 1;; i = 0)
      {
        if ((((bcin)localObject).a() < System.currentTimeMillis()) || ((babd.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Bcim.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onShow. updateAppShortcutPanel. ");
        }
        a((bcin)localObject);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
    }
    this.jdField_a_of_type_Bcim.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      localObject = (afgn)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localObject == null) || (!((afgn)localObject).b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131376206);
    if ((ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundDrawable(localDrawable);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368344);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop() + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() update list.paddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Akpy != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Akpy.b(2131376206);
      }
      a(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundResource(0);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    boolean bool;
    do
    {
      return;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131368344);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "setListViewPaddingBottom , new :" + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Akpy != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Akpy.b(2131368344);
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.isShown();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(8);
    } while (!bool);
    a(true);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) {}
    LinearLayout localLinearLayout;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371563);
      } while (localLinearLayout == null);
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    } while (localTroopInfo == null);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHitRect(localRect);
    int i = 0;
    label83:
    long l;
    if (i < localLinearLayout.getChildCount())
    {
      Object localObject = localLinearLayout.getChildAt(i);
      if ((localObject != null) && (((View)localObject).getLocalVisibleRect(localRect)))
      {
        localObject = ((View)localObject).getTag();
        if ((localObject instanceof bcij))
        {
          localObject = (bcij)localObject;
          if (localObject != null)
          {
            l = ((bcij)localObject).a();
            localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (((Long)((Iterator)localObject).next()).longValue() != l);
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        azqs.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label83;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afee
 * JD-Core Version:    0.7.0.1
 */