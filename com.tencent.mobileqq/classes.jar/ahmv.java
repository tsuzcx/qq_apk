import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.activity.recent.RecentAdapter.3;
import com.tencent.mobileqq.activity.recent.RecentAdapter.4;
import com.tencent.mobileqq.activity.recent.RecentAdapter.7;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class ahmv
  extends BaseAdapter
  implements ahpm, ahpo, View.OnClickListener, View.OnLongClickListener, baxz, bfvz
{
  public int a;
  private long jdField_a_of_type_Long;
  private ahmo jdField_a_of_type_Ahmo;
  private ahnc jdField_a_of_type_Ahnc;
  protected ahnr a;
  protected ahnz a;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahnb(this);
  protected DragFrameLayout a;
  public QQAppInterface a;
  protected BubblePopupWindow a;
  protected XListView a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected final List<Object> a;
  protected tkp a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  protected List<Object> b;
  private int c;
  
  public ahmv(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, ahmo paramahmo, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramahmo, paramInt, false);
  }
  
  public ahmv(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, ahmo paramahmo, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Ahmo = paramahmo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_Ahnz = new ahnz(paramInt);
    this.jdField_a_of_type_Ahnz.a(this);
    this.jdField_a_of_type_Ahnr = new ahnr(paramQQAppInterface, this, paramBoolean);
    this.jdField_a_of_type_Tkp = new tkp(paramQQAppInterface);
    this.jdField_a_of_type_Tkp.a(new ahmw(this));
    if (paramInt == 0) {
      this.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.c = paramInt;
      return;
      if (paramInt == 1) {
        this.jdField_b_of_type_Int = 5;
      } else if (paramInt == 9) {
        this.jdField_b_of_type_Int = 11;
      } else if (paramInt == 10) {
        this.jdField_b_of_type_Int = 15;
      } else if (paramInt == 11) {
        this.jdField_b_of_type_Int = 17;
      } else if (paramInt == 12) {
        this.jdField_b_of_type_Int = 19;
      } else if (paramInt == 13) {
        this.jdField_b_of_type_Int = 21;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    boolean bool2 = false;
    if (ahpd.a(paramRecentBaseData))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramRecentBaseData instanceof RecentItemChatMsgData))
    {
      paramRecentBaseData = ((RecentItemChatMsgData)paramRecentBaseData).mUser;
      if ((paramRecentBaseData == null) || (paramRecentBaseData.getType() != 1008) || (!saz.b(paramQQAppInterface, paramRecentBaseData.uin))) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      return bool1;
      bool1 = bool2;
      if (!(paramRecentBaseData instanceof RecentItemTroopMsgData)) {
        break;
      }
      paramRecentBaseData = paramQQAppInterface.a(true).a(((RecentItemTroopMsgData)paramRecentBaseData).mUser.uin);
      bool1 = bool2;
      if (paramRecentBaseData == null) {
        break;
      }
      paramQQAppInterface = ((bciq)paramQQAppInterface.a(107)).a("");
      if (!paramRecentBaseData.isGameRoom)
      {
        bool1 = bool2;
        if (!paramRecentBaseData.troopUin.equals(paramQQAppInterface.a)) {
          break;
        }
      }
      return true;
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    int i = paramRecentBaseData.a();
    if (i == 7220)
    {
      onh.a();
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", onh.c(), false);
    }
    try
    {
      paramString1 = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      paramString1.f();
      paramString1.d();
      if (i == 8112) {
        if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
        {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.d("Q.recent", 1, "clean kandian error" + paramString1);
      }
      paramString1 = paramRecentBaseData.a();
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(paramString1);
      if (((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData)) && ((((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo instanceof MayKnowRecommend)))
      {
        paramString1 = (MayKnowRecommend)((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo;
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.uin, "frd_list_dlt", 25, 0, paramString1.recommendReason, 0, paramString1.algBuffer, 2);
      }
      if (i == 8113)
      {
        if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
        {
          bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        paramString1 = paramRecentBaseData.a();
        ((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).d(paramString1);
      }
      a(paramRecentBaseData, paramString2);
      switch (i)
      {
      default: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
        return;
      case 0: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
        return;
      case 1: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
        return;
      case 3000: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
        return;
      case 1008: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
        if ((paramRecentBaseData instanceof RecentItemEcShop)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.a(), "", paramRecentBaseData.mTitleName, "");
        }
        paramString1 = paramRecentBaseData.a();
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString1, "0X80064C9", "0X80064C9", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
        ahoo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.b(), 1, paramRecentBaseData.b());
        if (ajsd.aP.equals(paramString1)) {
          oob.a();
        }
        shu.a(paramString1);
        return;
      case 5000: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
        return;
      case 7000: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
        return;
      case 4000: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
        return;
      case 1022: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
        return;
      case 6000: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
        return;
      case 7200: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
        return;
      case 1001: 
      case 10002: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
        if ((paramRecentBaseData instanceof RecentMsgBoxItem))
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", ((RecentMsgBoxItem)paramRecentBaseData).c(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
          return;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
        return;
      case 1010: 
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
        return;
      }
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
    return;
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
    return;
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.a(), "", "", "");
    return;
    shu.a();
    ahoo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.b(), 1, paramRecentBaseData.b());
    return;
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
    return;
    LpReportInfo_dc00518.report(100, 3, 0);
    if (QLog.isColorLevel()) {
      QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
  }
  
  private void d() {}
  
  public ahnr a()
  {
    return this.jdField_a_of_type_Ahnr;
  }
  
  public RecentBaseData a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (aspm.a(((RecentBaseData)localObject).a())) {
            return localObject;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131378655);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "setExtraFlag:" + paramInt);
    }
  }
  
  public void a(ahnc paramahnc)
  {
    this.jdField_a_of_type_Ahnc = paramahnc;
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.a();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
        break label85;
      }
      i = 3002;
    }
    label85:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_Ahnr.a(i, paramRecentBaseData.a());
      paramDrawable = this.jdField_a_of_type_Ahnz.a(paramRecentBaseData);
      if (paramDrawable == null) {
        break;
      }
      paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent", 4, "updateSayHelloBoxItem|uin:" + paramMessageRecord.senderuin);
      }
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.jdField_a_of_type_Ahnr.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_Ahnz.a(paramRecentBaseData);
    } while ((paramDrawable == null) || (!(paramDrawable instanceof ahpe)));
    ((ahpe)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, localDrawable);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label22:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label57;
      }
    }
    label57:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label22;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_Ahmo != null) {
      this.jdField_a_of_type_Ahmo.a(paramRecentBaseData, paramString);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramRecentBaseData);
      d();
      notifyDataSetChanged();
    }
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    if (bbbr.a(paramString1, localResources.getString(ahnw.a[0])))
    {
      paramRecentBaseData.a();
      b(paramRecentBaseData, paramString1, paramString2);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", paramString2, "");
    }
    while (this.jdField_a_of_type_Ahmo == null) {
      return;
    }
    this.jdField_a_of_type_Ahmo.a(paramString1, paramRecentBaseData, paramString2);
    shu.a(paramRecentBaseData.a(), paramRecentBaseData.a(), paramString1, localResources);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ahnr.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Tkp != null) {
      this.jdField_a_of_type_Tkp.a();
    }
    if (this.jdField_a_of_type_Ahnz != null) {
      this.jdField_a_of_type_Ahnz.a(paramQQAppInterface);
    }
    this.jdField_a_of_type_Tkp = new tkp(paramQQAppInterface);
    this.jdField_a_of_type_Tkp.a(new ahmx(this));
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "onAccountChanged: invoked. Message: app: " + paramQQAppInterface + " recreate mRecentTabHaloPresenter: " + this.jdField_a_of_type_Tkp);
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRecentUser.uin, 1008);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((MessageRecord)localObject2).getExtInfoFromExtStr("gdt_msgClick");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = "0";
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("pa_msgId");
        paramStringBuilder1.append((String)localObject2 + ",");
      }
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      paramStringBuilder1 = str;
      if (((JSONObject)localObject1).has("ad_id")) {
        paramStringBuilder1 = ((JSONObject)localObject1).getString("ad_id");
      }
    }
    catch (Exception paramStringBuilder1)
    {
      for (;;)
      {
        paramStringBuilder1 = str;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.recent", 2, " parse ad_id error");
          paramStringBuilder1 = str;
        }
      }
    }
    paramStringBuilder2.append(paramStringBuilder1 + ",");
    paramStringBuilder3.append(paramRecentUser.uin + ",");
  }
  
  protected void a(String paramString)
  {
    axqy.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, "" + banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.a() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!bbbr.a(localRecentBaseData.a(), paramString))
    {
      i += 1;
      break label26;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 1;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (bbbr.a(paramString, localRecentBaseData.a()))) {
        break label74;
      }
    }
    label74:
    int k;
    do
    {
      i += 1;
      break label26;
      break;
      k = localRecentBaseData.a();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 10002) && (k != 10004) && (k != 1009) && (k != 1023) && (k != 1024) && (k != 7000) && (k != 1010) && (k != 7220)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    e();
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "setDataList size = " + i);
      }
      if (i == 0) {
        QLog.i("Q.recent", 2, "setDataList size = " + i, new Exception("setDataListEmpty"));
      }
      Object localObject3;
      if ((this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView))
      {
        localObject3 = (SwipListView)this.jdField_a_of_type_ComTencentWidgetXListView;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Int >= 0)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
            localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "setDataList findsel, [" + this.jdField_a_of_type_Int + "," + localObject1 + "]");
        }
        this.jdField_a_of_type_Int = -1;
        localObject2 = localObject3;
        this.jdField_a_of_type_JavaUtilList.clear();
        if (paramList == null) {}
      }
      for (;;)
      {
        int j;
        try
        {
          paramList = paramList.iterator();
          i = -1;
          if (paramList.hasNext())
          {
            localObject3 = (RecentBaseData)paramList.next();
            if (localObject3 != null)
            {
              j = i + 1;
              if ((localObject3 instanceof RecentItemChatMsgData)) {
                ((RecentBaseData)localObject3).mPosition = j;
              }
              i = j;
              if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject3))
              {
                this.jdField_a_of_type_JavaUtilList.add(localObject3);
                i = j;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.i("Q.recent", 2, "setDataList, [item is null]");
            }
          }
        }
        catch (Exception paramList) {}
        boolean bool;
        if (localObject2 != null)
        {
          if (this.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            bool = false;
            localObject2.setDragEnable(bool);
          }
        }
        else if ((localObject1 instanceof RecentBaseData))
        {
          paramList = (RecentBaseData)localObject1;
          i = Math.max(localObject2.getFirstVisiblePosition(), 0);
          j = Math.min(localObject2.getLastVisiblePosition() + 1, this.jdField_a_of_type_JavaUtilList.size());
        }
        for (;;)
        {
          if (i < j)
          {
            if (!paramList.equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
              break label526;
            }
            this.jdField_a_of_type_Int = i;
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.jdField_a_of_type_JavaUtilList.get(i) + "]");
            }
          }
          if ((localObject2 != null) && (this.jdField_a_of_type_Int == -1)) {
            localObject2.t();
          }
          notifyDataSetChanged();
          return;
          bool = true;
          break;
          label526:
          i += 1;
        }
        localObject2 = null;
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ahnr.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ahnr.a.a();
      this.jdField_a_of_type_Ahnr.a.c();
      return;
    }
    if (this.jdField_a_of_type_Ahnr.a.a()) {
      this.jdField_a_of_type_Ahnr.a.b();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label76:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label107:
      if (!(localRecentBaseData instanceof RecentItemImaxADData)) {
        this.jdField_a_of_type_Ahnr.a(localRecentBaseData.a(), localRecentBaseData.a(), false);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    int i;
    Object localObject1;
    Object localObject2;
    MessageHandler localMessageHandler;
    Object localObject5;
    Object localObject3;
    Object localObject4;
    if (paramBoolean)
    {
      if (this.c == 0) {
        i = 1;
      }
      for (;;)
      {
        if (paramInt == 2)
        {
          if (i != 0)
          {
            paramDragFrameLayout = this.jdField_a_of_type_JavaUtilList.iterator();
            for (;;)
            {
              if (paramDragFrameLayout.hasNext())
              {
                localObject1 = paramDragFrameLayout.next();
                if (((localObject1 instanceof RecentBaseData)) && ((localObject1 instanceof RecentUserBaseData)))
                {
                  localObject1 = (RecentUserBaseData)localObject1;
                  if (((RecentUserBaseData)localObject1).mUnreadNum > 0)
                  {
                    localObject2 = ((RecentUserBaseData)localObject1).a();
                    ahpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, true);
                    continue;
                    i = 0;
                    break;
                  }
                }
              }
            }
          }
          paramDragFrameLayout = (nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
          if ((paramDragFrameLayout != null) && (paramDragFrameLayout.e))
          {
            paramDragFrameLayout.e = false;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            paramDragFrameLayout = (DragFrameLayout)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramDragFrameLayout = "noLogin";
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("ecshop_sp" + paramDragFrameLayout, 0).edit().putBoolean("folder_reddot", false).commit();
          }
          localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
          if (localMessageHandler != null) {
            localMessageHandler.d(false);
          }
          paramDragFrameLayout = null;
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator.hasNext())
          {
            localObject5 = localIterator.next();
            if ((!(localObject5 instanceof RecentBaseData)) || (!(localObject5 instanceof RecentUserBaseData))) {
              break label2434;
            }
            localObject3 = (RecentUserBaseData)localObject5;
            if (((RecentUserBaseData)localObject3).mUnreadNum <= 0) {
              break label2434;
            }
            localObject4 = ((RecentUserBaseData)localObject3).a();
            ((RecentUserBaseData)localObject3).c();
            bfoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject3).a());
            if (((RecentUser)localObject4).getType() != 1008) {
              break label2421;
            }
            if (paramDragFrameLayout != null) {
              break label2408;
            }
            localObject2 = new StringBuilder();
            localObject1 = new StringBuilder();
            paramDragFrameLayout = new StringBuilder();
            label375:
            a((RecentUser)localObject4, (StringBuilder)localObject2, (StringBuilder)localObject1, paramDragFrameLayout);
            label386:
            if ((localObject5 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentUser)localObject4).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject4, true, false);
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = paramDragFrameLayout;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      localObject1 = localObject4;
      paramDragFrameLayout = (DragFrameLayout)localObject5;
      break;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localMessageHandler == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ahpd.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
        break;
      }
      if ((localObject5 instanceof RecentItemTroopBarAssitant))
      {
        sdc.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        scr.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ahpd.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof RecentItemServiceAccountFolderData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ahpd.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          saz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          if (!sfe.c) {
            break;
          }
          saz.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
      }
      if ((localObject5 instanceof SendBlessRecentItemData))
      {
        ThreadManager.post(new RecentAdapter.3(this), 5, null, true);
        localObject3 = paramDragFrameLayout;
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
      else
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ahpd.a((QQAppInterface)localObject3, (RecentUser)localObject4, paramBoolean, false);
          localObject3 = paramDragFrameLayout;
          localObject4 = localObject1;
          localObject5 = localObject2;
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.n)
        {
          localObject3 = (avet)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
          if (localObject3 != null) {
            ((avet)localObject3).a(awzy.a());
          }
        }
        if (this.c == 0)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
          if (!TextUtils.isEmpty(paramDragFrameLayout)) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", String.valueOf(localObject2), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramDragFrameLayout), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(localObject1));
          }
        }
        osx.a().h();
        label1192:
        label1264:
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        int j;
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              paramDragFrameLayout = paramDragFrameLayout.a();
                            } while (paramDragFrameLayout == null);
                            paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
                          } while (paramDragFrameLayout == null);
                          j = paramDragFrameLayout.intValue();
                          paramDragFrameLayout = getItem(j);
                          if (QLog.isColorLevel()) {
                            QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
                          }
                        } while (!(paramDragFrameLayout instanceof RecentBaseData));
                        localObject1 = (RecentBaseData)paramDragFrameLayout;
                        if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
                        {
                          localObject2 = ((RecentUserBaseData)paramDragFrameLayout).a();
                          ahpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject1, (RecentUser)localObject2, false);
                        }
                        if ((paramDragFrameLayout instanceof RecentItemTroopBarAssitant))
                        {
                          paramDragFrameLayout = (RecentItemTroopBarAssitant)paramDragFrameLayout;
                          paramDragFrameLayout.c();
                          sdc.a().i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                          return;
                        }
                        if ((paramDragFrameLayout instanceof RecentItemServiceAccountFolderData))
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByFolderRed, red dot switch:" + sfe.b);
                          }
                          paramDragFrameLayout = (RecentItemServiceAccountFolderData)paramDragFrameLayout;
                          i = paramDragFrameLayout.mUnreadNum;
                          if (!sfe.b)
                          {
                            paramDragFrameLayout.c();
                            saz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
                            if (sfe.c) {
                              saz.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                            }
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0);
                          }
                          if (sfe.b)
                          {
                            paramInt = 1;
                            if (!paramDragFrameLayout.a()) {
                              break label1264;
                            }
                          }
                          for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
                          {
                            ThreadManager.executeOnSubThread(new RecentAdapter.4(this, paramInt, paramDragFrameLayout, String.valueOf(i), String.valueOf(j + 1)));
                            paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
                            if (!(paramDragFrameLayout instanceof avps)) {
                              break;
                            }
                            ((avps)paramDragFrameLayout).a(104000, "104000.104001");
                            return;
                            paramInt = 0;
                            break label1192;
                          }
                        }
                        if (!(paramDragFrameLayout instanceof RecentItemEcShopAssitant)) {
                          break;
                        }
                        paramDragFrameLayout = (RecentItemEcShopAssitant)paramDragFrameLayout;
                        paramDragFrameLayout.c();
                        ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                        paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                      } while (paramDragFrameLayout == null);
                      localObject1 = (nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
                    } while (localObject1 == null);
                    ((nqn)localObject1).a(paramDragFrameLayout.time);
                    return;
                    if ((paramDragFrameLayout instanceof RecentUserBaseData))
                    {
                      localObject1 = (RecentUserBaseData)paramDragFrameLayout;
                      localObject2 = ((RecentUserBaseData)localObject1).a();
                      if (((RecentUser)localObject2).getType() == 1008) {
                        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + ((RecentUser)localObject2).uin, "0X80064CA", "0X80064CA", 0, 0, "" + ((RecentUserBaseData)localObject1).mUnreadNum, "", "", "");
                      }
                      for (;;)
                      {
                        ((RecentUserBaseData)localObject1).c();
                        bfoi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject1).a());
                        ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2, true, false);
                        if (this.c == 0) {
                          ahpd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject2);
                        }
                        if ((paramDragFrameLayout instanceof SendBlessRecentItemData)) {
                          ((afax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).b(true);
                        }
                        if ((((RecentUser)localObject2).getType() != 0) || (!bbbr.b(((RecentUser)localObject2).uin))) {
                          break;
                        }
                        paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                        if (paramDragFrameLayout.getBoolean("babyQ_toast_flag", false)) {
                          break;
                        }
                        i = paramDragFrameLayout.getInt("babyQ_drag_count", 0) + 1;
                        paramInt = i;
                        if (i >= 3)
                        {
                          bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", ajya.a(2131713158), ajya.a(2131713157), new ahmz(this), new ahna(this)).show();
                          paramInt = 0;
                          paramDragFrameLayout.edit().putBoolean("babyQ_toast_flag", true);
                        }
                        paramDragFrameLayout.edit().putInt("babyQ_drag_count", paramInt).commit();
                        return;
                        if (((RecentUser)localObject2).getType() == 6004) {
                          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
                        }
                      }
                    }
                    if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
                      break;
                    }
                    paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
                    paramDragFrameLayout.c();
                    ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                    paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
                  } while (paramDragFrameLayout == null);
                  asfd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
                  return;
                  if (!(paramDragFrameLayout instanceof RecentItemEcShop)) {
                    break;
                  }
                  paramDragFrameLayout = (RecentItemEcShop)paramDragFrameLayout;
                  axqy.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.a(), "0X80064D3", "0X80064D3", 0, 0, "" + paramDragFrameLayout.mUnreadNum, "", "", "");
                  paramDragFrameLayout.c();
                  ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
                  paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1008);
                } while (paramDragFrameLayout == null);
                localObject1 = (nqn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
              } while (localObject1 == null);
              ((nqn)localObject1).a(paramDragFrameLayout.time);
              return;
              if (!(paramDragFrameLayout instanceof RecentMsgBoxItem)) {
                break;
              }
              paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
              paramDragFrameLayout.c();
              if (akpx.c(paramDragFrameLayout.a()))
              {
                ThreadManager.post(new RecentAdapter.7(this, paramDragFrameLayout.a(), paramDragFrameLayout.a()), 8, null, false);
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
                return;
              }
              ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              if (akpx.f(paramDragFrameLayout.a()))
              {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(paramDragFrameLayout.mFromFlag), "");
                return;
              }
            } while (!akpx.g(paramDragFrameLayout.a()));
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
            return;
            if ((paramDragFrameLayout instanceof RecentSayHelloListItem))
            {
              paramDragFrameLayout = (RecentSayHelloListItem)paramDragFrameLayout;
              paramDragFrameLayout.c();
              ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
              return;
            }
            if (!(paramDragFrameLayout instanceof RecentHotchatItem)) {
              break;
            }
            paramDragFrameLayout = (RecentHotchatItem)paramDragFrameLayout;
            paramDragFrameLayout.c();
            ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
            paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
          } while (paramDragFrameLayout == null);
          ((ajyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramDragFrameLayout.time);
          return;
          if ((paramDragFrameLayout instanceof RecentItemConfessMsg))
          {
            amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramDragFrameLayout, false);
            return;
          }
        } while (!(paramDragFrameLayout instanceof RecentMatchChatListItem));
        paramDragFrameLayout = (RecentMatchChatListItem)paramDragFrameLayout;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
        return;
        label2408:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject2;
        localObject2 = localObject3;
        break label375;
        label2421:
        localObject3 = paramDragFrameLayout;
        paramDragFrameLayout = (DragFrameLayout)localObject2;
        localObject2 = localObject3;
        break label386;
        label2434:
        localObject3 = localObject2;
        localObject4 = localObject1;
        localObject5 = paramDragFrameLayout;
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public List<Object> b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return new ArrayList(this.jdField_a_of_type_JavaUtilList);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ahnr.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Tkp != null) {
      this.jdField_a_of_type_Tkp.a();
    }
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.a() == 8) && (paramRecentBaseData.mExtraType == 25))
    {
      localObject = (askn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localObject == null) || (paramRecentBaseData.mPhoneNumber == null)) {
        break label104;
      }
    }
    label104:
    for (Object localObject = ((askn)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null) {
        paramRecentBaseData.mTitleName = ((PhoneContact)localObject).name;
      }
      do
      {
        return;
        localObject = ((avej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(140)).a(paramRecentBaseData.a());
      } while (localObject == null);
      paramRecentBaseData.mTitleName = ((QCallCardInfo)localObject).nickname;
      return;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Ahnz != null) {
      this.jdField_a_of_type_Ahnz.b(paramQQAppInterface);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ahnr != null) {
      this.jdField_a_of_type_Ahnr.b();
    }
  }
  
  protected boolean c()
  {
    return (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 8);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public int getCount()
  {
    if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        return Integer.valueOf(this.jdField_b_of_type_Int);
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_Ahnz.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      Object localObject = getItem(paramInt);
      ahnw localahnw = this.jdField_a_of_type_Ahnz.a(localObject);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        b((RecentBaseData)localObject);
        return localahnw.a(paramInt, localObject, this.jdField_a_of_type_Ahnr, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      }
      if ((localObject instanceof Integer)) {
        return localahnw.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      }
      if ((localObject instanceof String)) {
        return localahnw.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
      }
      paramView = localahnw.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
      return paramView;
    }
    catch (Throwable paramView)
    {
      ahon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, paramView);
      throw new RuntimeException(paramView);
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_Ahnz.b();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    ahnc localahnc = this.jdField_a_of_type_Ahnc;
    if (localahnc == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof RecentUserBaseData)))
    {
      localahnc.n();
      return;
    }
    RecentUser localRecentUser = ((RecentUserBaseData)this.jdField_a_of_type_JavaUtilList.get(0)).a();
    if ((localRecentUser != null) && (localRecentUser.showUpTime > 0L))
    {
      localahnc.l();
      return;
    }
    localahnc.n();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label486:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          Object localObject2;
          do
          {
            do
            {
              for (;;)
              {
                return;
                if (bbbr.a("tag_swip_icon_menu_item", paramView.getTag()))
                {
                  localObject1 = paramView.getTag(-1);
                  paramView = paramView.getTag(-2);
                  if ((!(localObject1 instanceof Integer)) || (!(paramView instanceof Integer)))
                  {
                    if (!QLog.isDevelopLevel()) {
                      continue;
                    }
                    QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
                    return;
                  }
                  i = ((Integer)localObject1).intValue();
                  int j = ((Integer)paramView).intValue();
                  try
                  {
                    paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
                    localObject1 = getItem(i);
                    if (QLog.isDevelopLevel()) {
                      QLog.i("Q.recent", 4, "onClick|obj = " + localObject1 + ", " + paramView);
                    }
                    if ((paramView != null) && ((localObject1 instanceof RecentBaseData)))
                    {
                      a((RecentBaseData)localObject1, paramView, "2");
                      return;
                    }
                  }
                  catch (Exception paramView)
                  {
                    for (;;)
                    {
                      if (QLog.isDevelopLevel()) {
                        QLog.i("Q.recent", 4, paramView.toString());
                      }
                      paramView = null;
                    }
                  }
                }
              }
              if (!bbbr.a("tag_recent_item_icon", paramView.getTag())) {
                break;
              }
              localObject1 = paramView.getTag(-22);
            } while ((this.jdField_a_of_type_Ahmo == null) || (localObject1 == null));
            this.jdField_a_of_type_Ahmo.a(paramView, localObject1);
            return;
            localObject1 = (stc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
            if (this.jdField_a_of_type_Ahmo == null) {
              break label533;
            }
            localObject2 = paramView.getTag(-22);
            if (((stc)localObject1).b(localObject2)) {
              this.jdField_a_of_type_Ahmo.a(paramView, localObject2);
            }
            localObject1 = paramView.getTag(-1);
            if ((localObject1 instanceof Integer)) {
              break;
            }
          } while (!QLog.isDevelopLevel());
          QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          return;
          int i = ((Integer)localObject1).intValue();
          localObject1 = getItem(i);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onClick|obj = " + localObject1);
          }
          if (!(localObject1 instanceof RecentBaseData)) {
            break;
          }
          if (((paramView instanceof bfss)) && ((localObject1 instanceof RecentItemEcShop))) {
            this.jdField_a_of_type_Ahmo.a(paramView, localObject1);
          }
          for (;;)
          {
            if (!(localObject1 instanceof RecentItemTroopMsgData)) {
              break label486;
            }
            paramView = (RecentItemTroopMsgData)localObject1;
            if ((paramView == null) || (!paramView.mIsGroupVideoNotify)) {
              break;
            }
            a(paramView.a());
            return;
            localObject2 = (RecentBaseData)localObject1;
            ((RecentBaseData)localObject2).mPosition = i;
            this.jdField_a_of_type_Ahmo.a(paramView, (RecentBaseData)localObject2, ((RecentBaseData)localObject2).mTitleName, true);
          }
        } while (!(localObject1 instanceof RecentTroopAssistantItem));
        paramView = (RecentTroopAssistantItem)localObject1;
      } while ((paramView == null) || (!paramView.mIsGroupVideoNotify));
      a(paramView.a());
      return;
      this.jdField_a_of_type_Ahmo.a(paramView, localObject1);
      return;
    } while (!QLog.isDevelopLevel());
    label533:
    QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    boolean bool1;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + paramString, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
          {
            bool1 = true;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(paramString).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
              if (paramBitmap != null) {
                break label280;
              }
              bool2 = true;
              QLog.d("RecentAdapter", 2, bool2 + ",style | " + this.c);
            }
            if ((paramInt1 > 0) && (!bool1)) {
              continue;
            }
            synchronized (this.jdField_a_of_type_JavaUtilHashtable)
            {
              if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            QLog.i("RecentAdapter", 1, "onDecodeTaskCompleted error:" + localOutOfMemoryError.getMessage());
            continue;
            bool1 = false;
            continue;
            label280:
            boolean bool2 = false;
          }
        }
      }
    }
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      bool1 = false;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(localView);
        if (localRecentBaseData == null)
        {
          break label856;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = localRecentBaseData.a();
        i = ((Integer)ahnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label856;
        }
        if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
        {
          paramBitmap = ((RecentSayHelloBoxItem)localRecentBaseData).mUnreadMRList;
          paramString = ((RecentSayHelloBoxItem)localRecentBaseData).lock;
          if (paramBitmap != null) {
            try
            {
              if (paramBitmap.size() > 0)
              {
                paramBitmap = new LinkedList(paramBitmap).iterator();
                while (paramBitmap.hasNext())
                {
                  MessageRecord localMessageRecord = (MessageRecord)paramBitmap.next();
                  Object localObject = i + ":" + localMessageRecord.senderuin;
                  localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
                  if (localObject != null) {
                    a(localView, localRecentBaseData, localMessageRecord, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject));
                  }
                }
              }
            }
            finally {}
          }
          break label856;
        }
        paramString = i + ":" + localRecentBaseData.a();
        paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString);
        if (paramString == null) {
          break label856;
        }
        if (i == 103)
        {
          l = System.currentTimeMillis();
          paramBitmap = BaseApplication.getContext().getResources().getDrawable(2130840062);
          if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramBitmap).setGravity(81);
          }
          if ((paramBitmap instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramBitmap).setGravity(81);
          }
          paramBitmap.setBounds(0, 0, paramBitmap.getIntrinsicWidth(), paramBitmap.getIntrinsicHeight());
          paramBitmap = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), paramString), paramBitmap });
          paramString = paramBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
          }
        }
        for (paramString = paramBitmap;; paramString = new BitmapDrawable(BaseApplication.getContext().getResources(), paramString))
        {
          a(localView, localRecentBaseData, paramString);
          bool1 = true;
          break;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool1);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label856:
      paramInt1 += 1;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
    }
    if (this.jdField_a_of_type_Ahnz != null) {}
    for (int i = this.jdField_a_of_type_Ahnz.a(); (i == 0) && (FrameHelperActivity.b()); i = 0) {
      return false;
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    if ((paramView.getContext() instanceof TroopAssistantActivity)) {
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onLongClick|obj = " + localObject1);
    }
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_Ahnz.a(localObject1);
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      if ("9970".equals(((RecentBaseData)localObject1).a())) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
      }
      if (localObject2 != null) {}
      for (List localList = ((ahnw)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localList = null)
      {
        if ((localList != null) && (localList.size() > 0) && (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long > 100L))
        {
          localObject2 = new bbmf();
          i = 0;
          while (i < localList.size())
          {
            ((bbmf)localObject2).a(j, (String)localList.get(i));
            i += 1;
          }
          boolean bool2 = false;
          boolean bool1;
          if ((this.jdField_a_of_type_Boolean) && (aspt.a(this.jdField_a_of_type_AndroidContentContext, ((RecentBaseData)localObject1).a(), ((RecentBaseData)localObject1).a(), ((RecentBaseData)localObject1).b(), "conversation_tab_list")))
          {
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.recent", 2, "MultiAIOStarter start multiaio successfully!");
              bool1 = bool2;
            }
          }
          for (;;)
          {
            this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
            return bool1;
            try
            {
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, (bbmf)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new ahmy(this, paramView));
              bool1 = true;
            }
            catch (Throwable paramView)
            {
              paramView.printStackTrace();
              bool1 = bool2;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("Q.recent", 2, "long click showAsDropDown", paramView);
              bool1 = bool2;
            }
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */