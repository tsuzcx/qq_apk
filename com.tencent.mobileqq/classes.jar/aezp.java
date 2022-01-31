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

public class aezp
  implements afal
{
  private int jdField_a_of_type_Int;
  private alsi jdField_a_of_type_Alsi;
  protected View.OnClickListener a;
  private bced jdField_a_of_type_Bced;
  private bcef jdField_a_of_type_Bcef;
  private bceg jdField_a_of_type_Bceg;
  private beld jdField_a_of_type_Beld = new aezt(this);
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AppShortcutBarScrollView a;
  ArrayList<Pair<URLDrawable, URLImageView>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public aezp(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aezv(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (azwu.a()) {}
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
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$CLIENTVER$", "android8.3.3").replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new aezq(this));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(2, 2131368333);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
            this.jdField_a_of_type_Bced = ((bced)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171));
            this.jdField_a_of_type_Bcef = ((bcef)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355));
            this.jdField_a_of_type_Bceg = new aezr(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_Alsi = new aezs(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bceg);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
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
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131370810);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376152);
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
        if ((TextView)paramRelativeLayout.findViewById(2131370810) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131370810);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131376152);
  }
  
  void a(bcea parambcea, View paramView)
  {
    paramView.setTag(parambcea);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131376581);
    ((TextView)localObject).setText(parambcea.a());
    if (bool)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131376578);
      if (!bool) {
        break label264;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838518));
      label97:
      localObject = (TextView)paramView.findViewById(2131376580);
      if (parambcea.b() == 0) {
        break label288;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837724, 0, 0, 0);
      label147:
      paramView = (URLImageView)paramView.findViewById(2131376579);
      if (bool) {
        paramView.setColorFilter(1996488704);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (parambcea.b() == null) {
        break label338;
      }
      parambcea = URLDrawable.getDrawable(parambcea.b(), (URLDrawable.URLDrawableOptions)localObject);
      if (parambcea.getStatus() != 1) {
        break label297;
      }
      parambcea = parambcea.getCurrDrawable();
      if ((parambcea instanceof RegionDrawable))
      {
        paramView.setImageBitmap(((RegionDrawable)parambcea).getBitmap());
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
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838517));
      break label97;
      ((TextView)localObject).setVisibility(4);
      break label147;
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parambcea, paramView));
      parambcea.setURLDrawableListener(new aezu(this));
    } while (parambcea.isDownloadStarted());
    parambcea.startDownload();
    return;
    label338:
    paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843290));
  }
  
  void a(bcee parambcee)
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
          if (parambcee != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. info is null.");
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371544);
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
    Object localObject1 = (bceb)aogj.a().a(590);
    int i;
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && ((((bceb)localObject1).a((int)localTroopInfo.dwGroupClassExt)) || (((bceb)localObject1).b((int)localTroopInfo.dwGroupClassExt))))
    {
      localLinearLayout.removeAllViews();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (i = 1; ((parambcee.a() == 1) && (i == 0)) || (parambcee.b() == 1); i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. Switch is off.");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        f();
        return;
      }
      parambcee = parambcee.a();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. applist size: " + parambcee.size());
      }
      parambcee = parambcee.iterator();
      i = 1;
      bool = false;
      if (parambcee.hasNext())
      {
        localObject2 = (bcea)parambcee.next();
        if (((bcea)localObject2).a() != 0) {
          break label763;
        }
      }
    }
    label763:
    for (;;)
    {
      try
      {
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561346, null);
        a((bcea)localObject2, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        int j = i;
        if (i != 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).setMargins(aekt.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          j = 0;
        }
        i = j;
        bool = true;
      }
      catch (OutOfMemoryError parambcee)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambcee.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambcee)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambcee.getMessage());
        }
        System.gc();
        return;
      }
      if (bool) {}
      try
      {
        parambcee = bcea.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696677), "https://pub.idqqimg.com/pc/misc/files/20200114/manager.png");
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561346, null);
        a(parambcee, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          e();
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            azmj.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
          }
          ThreadManager.getUIHandler().postDelayed(new AppShortcutBarAIOHelper.5(this), 200L);
          return;
        }
      }
      catch (OutOfMemoryError parambcee)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambcee.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambcee)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambcee.getMessage());
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
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a(this.jdField_a_of_type_Beld);
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
      if (this.jdField_a_of_type_Bceg != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bceg);
      }
      if (this.jdField_a_of_type_Alsi != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.b(this.jdField_a_of_type_Beld);
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localObject = (bceb)aogj.a().a(590);
    } while ((localObject == null) || (localTroopInfo == null) || ((!((bceb)localObject).a((int)localTroopInfo.dwGroupClassExt)) && (!((bceb)localObject).b((int)localTroopInfo.dwGroupClassExt))));
    Object localObject = this.jdField_a_of_type_Bcef.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    if (localObject != null)
    {
      if (azwu.a()) {}
      for (int i = 1;; i = 0)
      {
        if ((((bcee)localObject).a() < System.currentTimeMillis()) || ((azwu.a()) && (this.jdField_a_of_type_Int != i)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
          }
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_Bced.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onShow. updateAppShortcutPanel. ");
        }
        a((bcee)localObject);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
    }
    this.jdField_a_of_type_Bced.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
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
      localObject = (afby)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localObject == null) || (!((afby)localObject).b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131376152);
    if ((ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundDrawable(localDrawable);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368333);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop() + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() update list.paddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj.b(2131376152);
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
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131368333);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "setListViewPaddingBottom , new :" + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aklj.b(2131368333);
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
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371544);
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
        if ((localObject instanceof bcea))
        {
          localObject = (bcea)localObject;
          if (localObject != null)
          {
            l = ((bcea)localObject).a();
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
        azmj.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label83;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aezp
 * JD-Core Version:    0.7.0.1
 */