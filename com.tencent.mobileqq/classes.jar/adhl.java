import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.InflateException;
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
import com.tencent.mobileqq.activity.aio.helper.AppShortcutBarAIOHelper.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AppShortcutBarScrollView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class adhl
  implements adif
{
  private akat jdField_a_of_type_Akat;
  protected View.OnClickListener a;
  private bafr jdField_a_of_type_Bafr;
  private baft jdField_a_of_type_Baft;
  private bafu jdField_a_of_type_Bafu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  public AppShortcutBarScrollView a;
  ArrayList<Pair<URLDrawable, URLImageView>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public adhl(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adhq(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public String a(String paramString, long paramLong, int paramInt, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$CLIENTVER$", "android8.3.0").replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
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
          this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView = ((AppShortcutBarScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558526, null));
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setOnScrollChangedListener(new adhm(this));
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(2, 2131368187);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView, localLayoutParams);
            this.jdField_a_of_type_Bafr = ((bafr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171));
            this.jdField_a_of_type_Baft = ((baft)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355));
            this.jdField_a_of_type_Bafu = new adhn(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_Akat = new adho(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bafu);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
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
    case 4: 
      c();
      return;
    }
    b();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131370504);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131375660);
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
        if ((TextView)paramRelativeLayout.findViewById(2131370504) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131370504);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131375660);
  }
  
  void a(bafo parambafo, View paramView)
  {
    paramView.setTag(parambafo);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131376082);
    ((TextView)localObject).setText(parambafo.a());
    if (bool)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131376079);
      if (!bool) {
        break label264;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838458));
      label97:
      localObject = (TextView)paramView.findViewById(2131376081);
      if (parambafo.b() == 0) {
        break label288;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837670, 0, 0, 0);
      label147:
      paramView = (URLImageView)paramView.findViewById(2131376080);
      if (bool) {
        paramView.setColorFilter(1996488704);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywm.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (parambafo.b() == null) {
        break label338;
      }
      parambafo = URLDrawable.getDrawable(parambafo.b(), (URLDrawable.URLDrawableOptions)localObject);
      if (parambafo.getStatus() != 1) {
        break label297;
      }
      parambafo = parambafo.getCurrDrawable();
      if ((parambafo instanceof RegionDrawable))
      {
        paramView.setImageBitmap(((RegionDrawable)parambafo).getBitmap());
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
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838457));
      break label97;
      ((TextView)localObject).setVisibility(4);
      break label147;
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parambafo, paramView));
      parambafo.setURLDrawableListener(new adhp(this));
    } while (parambafo.isDownloadStarted());
    parambafo.startDownload();
    return;
    label338:
    paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843106));
  }
  
  void a(bafs parambafs)
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
          if (parambafs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. info is null.");
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371232);
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
    Object localObject1 = (bafp)ampl.a().a(590);
    int i;
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && (((bafp)localObject1).a((int)localTroopInfo.dwGroupClassExt)))
    {
      localLinearLayout.removeAllViews();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (i = 1; ((parambafs.a() == 1) && (i == 0)) || (parambafs.b() == 1); i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. Switch is off.");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
        e();
        return;
      }
      parambafs = parambafs.a();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. applist size: " + parambafs.size());
      }
      parambafs = parambafs.iterator();
      i = 1;
      bool = false;
      if (parambafs.hasNext())
      {
        localObject2 = (bafo)parambafs.next();
        if (((bafo)localObject2).a() != 0) {
          break label740;
        }
      }
    }
    label740:
    for (;;)
    {
      try
      {
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561158, null);
        a((bafo)localObject2, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        int j = i;
        if (i != 0)
        {
          localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).setMargins(actj.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          j = 0;
        }
        i = j;
        bool = true;
      }
      catch (OutOfMemoryError parambafs)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambafs.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambafs)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambafs.getMessage());
        }
        System.gc();
        return;
      }
      if (bool) {}
      try
      {
        parambafs = bafo.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696502), "https://pub.idqqimg.com/pc/misc/files/20200114/manager.png");
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561158, null);
        a(parambafs, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          d();
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            axqy.b(null, "dc00898", "", "", "0X800ACFF", "0X800ACFF", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
          }
          ThreadManager.getUIHandler().postDelayed(new AppShortcutBarAIOHelper.4(this), 200L);
          return;
        }
      }
      catch (OutOfMemoryError parambafs)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambafs.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambafs)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambafs.getMessage());
        }
        System.gc();
        return;
      }
      e();
      return;
      this.jdField_a_of_type_Boolean = false;
      e();
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
    return new int[] { 4, 11 };
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Boolean = false;
    e();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.fullScroll(17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.removeAllViews();
    }
    if (this.jdField_a_of_type_Bafu != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bafu);
    }
    if (this.jdField_a_of_type_Akat != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localObject = (bafp)ampl.a().a(590);
    } while ((localObject == null) || (localTroopInfo == null) || (!((bafp)localObject).a((int)localTroopInfo.dwGroupClassExt)));
    Object localObject = this.jdField_a_of_type_Baft.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    if (localObject != null)
    {
      if (((bafs)localObject).a() < System.currentTimeMillis())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
        }
        this.jdField_a_of_type_Bafr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShow. updateAppShortcutPanel. ");
      }
      a((bafs)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
    }
    this.jdField_a_of_type_Bafr.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      localObject = (adjp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localObject == null) || (!((adjp)localObject).b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131375660);
    if ((ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundDrawable(localDrawable);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368187);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop() + this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() update list.paddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx.b(2131375660);
      }
      a(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setBackgroundResource(0);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131368187);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "setListViewPaddingBottom , new :" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitx.b(2131368187);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.setVisibility(8);
    a(true);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView == null) {}
    LinearLayout localLinearLayout;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetAppShortcutBarScrollView.findViewById(2131371232);
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
        if ((localObject instanceof bafo))
        {
          localObject = (bafo)localObject;
          if (localObject != null)
          {
            l = ((bafo)localObject).a();
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
        axqy.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      i += 1;
      break label83;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhl
 * JD-Core Version:    0.7.0.1
 */