import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

public class adho
  implements adih
{
  private akav jdField_a_of_type_Akav;
  protected View.OnClickListener a;
  public HorizontalScrollView a;
  private bafd jdField_a_of_type_Bafd;
  private baff jdField_a_of_type_Baff;
  private bafg jdField_a_of_type_Bafg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  ArrayList<Pair<URLDrawable, URLImageView>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public adho(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adhs(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public String a(String paramString, long paramLong, int paramInt, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    String str;
    if (paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      str = "0";
      str = paramString.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$CLIENTVER$", "android8.2.8").replace("$UIN$", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", str);
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
          this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131558526, null));
          if (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView != null)
          {
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
            localLayoutParams.addRule(2, 2131368187);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().addView(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, localLayoutParams);
            this.jdField_a_of_type_Bafd = ((bafd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(171));
            this.jdField_a_of_type_Baff = ((baff)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(355));
            this.jdField_a_of_type_Bafg = new adhp(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            this.jdField_a_of_type_Akav = new adhq(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bafg);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akav);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got OOM, e:" + localOutOfMemoryError.getMessage());
          }
          this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
          System.gc();
          return;
        }
        catch (InflateException localInflateException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.initData got InflateException, e:" + localInflateException.getMessage());
          }
          this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
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
    if ((paramRelativeLayout == null) || (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView == null)) {}
    do
    {
      do
      {
        return;
        paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131370505);
        if (paramRelativeLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AppShortcutBarAIOHelper", 2, "updateListUnRead unread textview is null");
      return;
      paramRelativeLayout = paramRelativeLayout.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131375658);
  }
  
  public void a(RelativeLayout paramRelativeLayout, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView == null)) {}
    int i;
    do
    {
      return;
      int j = 0;
      i = j;
      if (paramRelativeLayout != null)
      {
        i = j;
        if ((TextView)paramRelativeLayout.findViewById(2131370505) != null) {
          i = 1;
        }
      }
      paramRelativeLayout = paramView.getLayoutParams();
    } while (!(paramRelativeLayout instanceof RelativeLayout.LayoutParams));
    if (i != 0)
    {
      ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131370505);
      return;
    }
    ((RelativeLayout.LayoutParams)paramRelativeLayout).addRule(2, 2131375658);
  }
  
  void a(bafa parambafa, View paramView)
  {
    paramView.setTag(parambafa);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (TextView)paramView.findViewById(2131376080);
    ((TextView)localObject).setText(parambafa.a());
    if (bool)
    {
      ((TextView)localObject).setTextColor(Color.parseColor("#ffffff"));
      localObject = (LinearLayout)paramView.findViewById(2131376077);
      if (!bool) {
        break label264;
      }
      ((LinearLayout)localObject).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838458));
      label97:
      localObject = (TextView)paramView.findViewById(2131376079);
      if (parambafa.b() == 0) {
        break label288;
      }
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(0);
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2130837670, 0, 0, 0);
      label147:
      paramView = (URLImageView)paramView.findViewById(2131376078);
      if (bool) {
        paramView.setColorFilter(1996488704);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywk.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywk.a;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      if (parambafa.b() == null) {
        break label338;
      }
      parambafa = URLDrawable.getDrawable(parambafa.b(), (URLDrawable.URLDrawableOptions)localObject);
      if (parambafa.getStatus() != 1) {
        break label297;
      }
      parambafa = parambafa.getCurrDrawable();
      if ((parambafa instanceof RegionDrawable))
      {
        paramView.setImageBitmap(((RegionDrawable)parambafa).getBitmap());
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
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(parambafa, paramView));
      parambafa.setURLDrawableListener(new adhr(this));
    } while (parambafa.isDownloadStarted());
    parambafa.startDownload();
    return;
    label338:
    paramView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843105));
  }
  
  void a(bafe parambafe)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView == null)) {}
    LinearLayout localLinearLayout;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          if (parambafe != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. info is null.");
        return;
        localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.findViewById(2131371232);
        if (localLinearLayout != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. appShortcutPanel is null.");
      return;
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. troopInfo is null.");
    return;
    Object localObject2 = (bafb)ampm.a().a(590);
    int i;
    if ((localObject2 != null) && (((bafb)localObject2).a((int)((TroopInfo)localObject1).dwGroupClassExt)))
    {
      localLinearLayout.removeAllViews();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((((TroopInfo)localObject1).isAdmin()) || (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (i = 1; ((parambafe.a() == 1) && (i == 0)) || (parambafe.b() == 1); i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. Switch is off.");
        }
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(17);
        e();
        return;
      }
      parambafe = parambafe.a();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "updateAppShortcutPanel. applist size: " + parambafe.size());
      }
      parambafe = parambafe.iterator();
      i = 1;
      if (parambafe.hasNext())
      {
        localObject2 = (bafa)parambafe.next();
        if (((bafa)localObject2).a() != 0) {
          break label654;
        }
      }
    }
    label654:
    for (;;)
    {
      try
      {
        View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561159, null);
        a((bafa)localObject2, localView);
        localLinearLayout.addView(localView);
        int j = i;
        if (i != 0)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.setMargins(actn.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources()), 0, 0, 0);
          localView.setLayoutParams(localLayoutParams);
          j = 0;
        }
        a((TroopInfo)localObject1, ((bafa)localObject2).a());
        i = j;
      }
      catch (OutOfMemoryError parambafe)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambafe.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambafe)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambafe.getMessage());
        }
        System.gc();
        return;
      }
      try
      {
        parambafe = bafa.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696501), "https://pub.idqqimg.com/pc/misc/files/20200114/manager.png");
        localObject1 = View.inflate(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561159, null);
        a(parambafe, (View)localObject1);
        localLinearLayout.addView((View)localObject1);
        this.jdField_a_of_type_Boolean = true;
        d();
        return;
      }
      catch (OutOfMemoryError parambafe)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got OOM, e:" + parambafe.getMessage());
        }
        System.gc();
        return;
      }
      catch (InflateException parambafe)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarAIOHelper", 2, "AppShortcutBarAioHelper.updateAppShortcutPanel got InflateException, e:" + parambafe.getMessage());
        }
        System.gc();
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      e();
      return;
    }
  }
  
  void a(TroopInfo paramTroopInfo, long paramLong)
  {
    Object localObject;
    int i;
    if ((paramTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
    {
      localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        if (((Long)((Iterator)localObject).next()).longValue() != paramLong) {
          break label128;
        }
        i = 1;
      }
    }
    label128:
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject = new Long(paramLong);
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
        axqw.b(null, "dc00898", "", "", "0X800AAD3", "0X800AAD3", 0, 0, String.valueOf(paramLong), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, String.valueOf(paramTroopInfo.dwGroupClassExt), "");
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = false;
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
    e();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView != null)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(17);
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.removeAllViews();
    }
    if (this.jdField_a_of_type_Bafg != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bafg);
    }
    if (this.jdField_a_of_type_Akav != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akav);
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
      localObject = (bafb)ampm.a().a(590);
    } while ((localObject == null) || (localTroopInfo == null) || (!((bafb)localObject).a((int)localTroopInfo.dwGroupClassExt)));
    Object localObject = this.jdField_a_of_type_Baff.a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    if (localObject != null)
    {
      if (((bafe)localObject).a() < System.currentTimeMillis())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
        }
        this.jdField_a_of_type_Bafd.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onShow. updateAppShortcutPanel. ");
      }
      a((bafe)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
    }
    this.jdField_a_of_type_Bafd.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)localTroopInfo.dwGroupClassExt);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView == null)) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      localObject = (adjr)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(23);
      if ((localObject == null) || (!((adjr)localObject).b())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() isRobotPanelShow, will not resume app shortcut bar");
    return;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131375658);
    if ((ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localDrawable != null)
      {
        localDrawable = localDrawable.getConstantState().newDrawable();
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setBackgroundDrawable(localDrawable);
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368187);
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop() + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "resumeAppShorcutBar() update list.paddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz.b(2131375658);
      }
      a(true);
      return;
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setBackgroundResource(0);
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView == null)) {
      return;
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.getLayoutParams()).addRule(6, 2131368187);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarAIOHelper", 2, "setListViewPaddingBottom , new :" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Aitz.b(2131368187);
    }
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adho
 * JD-Core Version:    0.7.0.1
 */