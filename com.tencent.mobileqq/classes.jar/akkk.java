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
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter.1;
import com.tencent.mobileqq.activity.recent.RecentAdapter.4;
import com.tencent.mobileqq.activity.recent.RecentAdapter.7;
import com.tencent.mobileqq.activity.recent.RecentAdapter.8;
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
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.data.SendBlessRecentItemData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class akkk
  extends BaseAdapter
  implements aknk, aknm, View.OnClickListener, View.OnLongClickListener, bjtu, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  private long jdField_a_of_type_Long;
  private akkd jdField_a_of_type_Akkd;
  private akkr jdField_a_of_type_Akkr;
  protected aklg a;
  protected aklo a;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akkq(this);
  protected DragFrameLayout a;
  public QQAppInterface a;
  protected BubblePopupWindow a;
  protected XListView a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new RecentAdapter.1(this, 20);
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected final List<Object> a;
  protected wcn a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  protected List<Object> b;
  private int c;
  
  public akkk(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, akkd paramakkd, int paramInt)
  {
    this(paramContext, paramQQAppInterface, paramXListView, paramakkd, paramInt, false);
  }
  
  public akkk(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, akkd paramakkd, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Akkd = paramakkd;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_Aklo = new aklo(paramInt);
    this.jdField_a_of_type_Aklo.a(this);
    this.jdField_a_of_type_Aklg = new aklg(paramQQAppInterface, this, paramBoolean);
    this.jdField_a_of_type_Wcn = new wcn(paramQQAppInterface);
    this.jdField_a_of_type_Wcn.a(new akkm(this));
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
  
  private void a(int paramInt, RecentItemServiceAccountFolderData paramRecentItemServiceAccountFolderData)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByFolderRed, red dot switch:" + uex.b);
    }
    int j = paramRecentItemServiceAccountFolderData.mUnreadNum;
    if (!uex.b)
    {
      paramRecentItemServiceAccountFolderData.clearUnReadNum();
      uaw.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
      if (uex.c) {
        uaw.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramRecentItemServiceAccountFolderData.getRecentUserUin(), paramRecentItemServiceAccountFolderData.getRecentUserType());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshMsgTabUnreadNum(true, 0);
    }
    if (uex.b) {
      if (!paramRecentItemServiceAccountFolderData.isUnreadMsgNumInTabNum()) {
        break label181;
      }
    }
    label181:
    for (paramRecentItemServiceAccountFolderData = "0";; paramRecentItemServiceAccountFolderData = "1")
    {
      ThreadManager.executeOnSubThread(new RecentAdapter.8(this, i, paramRecentItemServiceAccountFolderData, String.valueOf(j), String.valueOf(paramInt + 1)));
      paramRecentItemServiceAccountFolderData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if ((paramRecentItemServiceAccountFolderData instanceof azvi)) {
        ((azvi)paramRecentItemServiceAccountFolderData).a(104000, "104000.104001");
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void a(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof RecentItemServiceAccountFolderData)) {
      a(paramInt, (RecentItemServiceAccountFolderData)paramObject);
    }
    do
    {
      do
      {
        Object localObject;
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
                  return;
                  if (!(paramObject instanceof RecentItemEcShopAssitant)) {
                    break;
                  }
                  paramObject = (RecentItemEcShopAssitant)paramObject;
                  paramObject.clearUnReadNum();
                  akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
                  paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
                } while (paramObject == null);
                localObject = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
              } while (localObject == null);
              ((ofx)localObject).a(paramObject.time);
              return;
              if ((paramObject instanceof RecentUserBaseData))
              {
                localObject = (RecentUserBaseData)paramObject;
                RecentUser localRecentUser = (RecentUser)((RecentUserBaseData)localObject).getRecentUser();
                if (localRecentUser.getType() == 1008) {
                  bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "" + localRecentUser.uin, "0X80064CA", "0X80064CA", 0, 0, "" + ((RecentUserBaseData)localObject).mUnreadNum, "", "", "");
                }
                for (;;)
                {
                  ((RecentUserBaseData)localObject).clearUnReadNum();
                  bjnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject).getRecentUserUin());
                  akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, true, false);
                  if (this.c == 0) {
                    akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
                  }
                  if ((paramObject instanceof SendBlessRecentItemData)) {
                    ((ahux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138)).b(true);
                  }
                  a(localRecentUser);
                  return;
                  if (localRecentUser.getType() == 6004) {
                    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EA", "0X80090EA", 0, 0, "", "", "", "");
                  }
                }
              }
              if (!(paramObject instanceof RecentTroopAssistantItem)) {
                break;
              }
              paramObject = (RecentTroopAssistantItem)paramObject;
              paramObject.clearUnReadNum();
              akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
              paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1);
            } while (paramObject == null);
            avnu.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.time);
            return;
            if (!(paramObject instanceof RecentItemEcShop)) {
              break;
            }
            paramObject = (RecentItemEcShop)paramObject;
            bcef.b(null, "dc00899", "Pb_account_lifeservice", paramObject.getRecentUserUin(), "0X80064D3", "0X80064D3", 0, 0, "" + paramObject.mUnreadNum, "", "", "");
            paramObject.clearUnReadNum();
            akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
            paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1008);
          } while (paramObject == null);
          localObject = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
        } while (localObject == null);
        ((ofx)localObject).a(paramObject.time);
        return;
        if ((paramObject instanceof RecentMsgBoxItem))
        {
          a((RecentMsgBoxItem)paramObject);
          return;
        }
        if ((paramObject instanceof RecentSayHelloListItem))
        {
          paramObject = (RecentSayHelloListItem)paramObject;
          paramObject.clearUnReadNum();
          akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
          return;
        }
        if (!(paramObject instanceof RecentHotchatItem)) {
          break;
        }
        paramObject = (RecentHotchatItem)paramObject;
        paramObject.clearUnReadNum();
        akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramObject.getRecentUserUin(), 1);
      } while (paramObject == null);
      ((amtm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramObject.time);
      return;
      if ((paramObject instanceof RecentItemConfessMsg))
      {
        apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentItemConfessMsg)paramObject, false);
        return;
      }
    } while (!(paramObject instanceof RecentMatchChatListItem));
    paramObject = (RecentMatchChatListItem)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramObject.getRecentUserUin(), paramObject.getRecentUserType());
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString, "", "");
      return;
    case 0: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString, "");
      return;
    case 1: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString, "");
      return;
    case 3000: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString, "");
      return;
    case 1008: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString, "");
      if ((paramRecentBaseData instanceof RecentItemEcShop)) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsghelper", "Clk_DelshopItem", 0, 0, paramRecentBaseData.getRecentUserUin(), "", paramRecentBaseData.mTitleName, "");
      }
      paramString = paramRecentBaseData.getRecentUserUin();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramString, "0X80064C9", "0X80064C9", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.getRecentUserUin(), "", "", "");
      akmc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName());
      if (AppConstants.WEISHI_UIN.equals(paramString)) {
        pbo.c();
      }
      uhv.a(paramString);
      return;
    case 5000: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString, "");
      return;
    case 7000: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString, "");
      return;
    case 4000: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString, "");
      return;
    case 1022: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString, "");
      return;
    case 6000: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString, "");
      return;
    case 7200: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString, "");
      return;
    case 1001: 
    case 10002: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FC", "0X80050FC", 0, 0, "", "", "", "");
      if ((paramRecentBaseData instanceof RecentMsgBoxItem))
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", ((RecentMsgBoxItem)paramRecentBaseData).a(), "msg_box", "delete_msg", 0, 0, "", "", "", "");
        return;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "swipe_msg", 0, 0, "", "", "", "");
      return;
    case 1010: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80050FE", "0X80050FE", 0, 0, "", "", "", "");
      return;
    case 9505: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006353", "0X8006353", 0, 0, "", "", "", "");
      return;
    case 7210: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.getRecentUserUin(), "", "", "");
      return;
    case 7120: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064C5", "0X80064C5", 0, 0, "" + paramRecentBaseData.mUnreadNum, "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X80067EE", "0X80067EE", 0, 0, "" + paramRecentBaseData.getRecentUserUin(), "", "", "");
      return;
    case 7220: 
      uhv.a();
      akmc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramRecentBaseData.getTitleName());
      return;
    case 6004: 
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80090EB", "0X80090EB", 0, 0, "", "", "", "");
      return;
    }
    LpReportInfo_dc00518.report(100, 3, 0);
    if (QLog.isColorLevel()) {
      QLog.d("RecentAdapter", 2, "do report: QQnotice.list.delete");
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.delete", 0, 0, "", "", "", "");
  }
  
  private void a(RecentMsgBoxItem paramRecentMsgBoxItem)
  {
    paramRecentMsgBoxItem.clearUnReadNum();
    if (abwz.b(paramRecentMsgBoxItem.getRecentUserUin()))
    {
      ThreadManager.post(new RecentAdapter.7(this, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType()), 8, null, false);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005298", "0X8005298", 0, 0, "", "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_hi", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      akms.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReaded(paramRecentMsgBoxItem.getRecentUserUin(), paramRecentMsgBoxItem.getRecentUserType());
      if (abwz.e(paramRecentMsgBoxItem.getRecentUserUin()))
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_update", 0, 0, "", "", String.valueOf(paramRecentMsgBoxItem.mFromFlag), "");
        return;
      }
    } while (!abwz.f(paramRecentMsgBoxItem.getRecentUserUin()));
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_focus", 0, 0, "", "", "", "");
  }
  
  private void a(RecentUser paramRecentUser)
  {
    if ((paramRecentUser.getType() == 0) && (bftf.b(paramRecentUser.uin)))
    {
      paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if (!paramRecentUser.getBoolean("babyQ_toast_flag", false))
      {
        int j = paramRecentUser.getInt("babyQ_drag_count", 0) + 1;
        int i = j;
        if (j >= 3)
        {
          bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, "babyQ提醒", "是否需要关闭babyQ的推送开关\n", amtj.a(2131712262), amtj.a(2131712261), new akko(this), new akkp(this)).show();
          paramRecentUser.edit().putBoolean("babyQ_toast_flag", true);
          i = 0;
        }
        paramRecentUser.edit().putInt("babyQ_drag_count", i).commit();
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    if (this.c == 0)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(paramStringBuilder1)) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", String.valueOf(paramStringBuilder3), "0X8005C37", "0X8005C37", 0, 1, 0, String.valueOf(paramStringBuilder1), String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", String.valueOf(paramStringBuilder2));
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
      return true;
    }
    Object localObject;
    if (bftf.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      localObject = paramView.getTag(-1);
      paramView = paramView.getTag(-2);
      if ((!(localObject instanceof Integer)) || (!(paramView instanceof Integer)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
        }
        return true;
      }
      int i = ((Integer)localObject).intValue();
      int j = ((Integer)paramView).intValue();
      try
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
        localObject = getItem(i);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "onClick|obj = " + localObject + ", " + paramView);
        }
        if ((paramView != null) && ((localObject instanceof RecentBaseData))) {
          a((RecentBaseData)localObject, paramView, "2");
        }
        if (AppSetting.c) {
          this.jdField_a_of_type_Int = -1;
        }
        return true;
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
    if (bftf.a("tag_recent_item_icon", paramView.getTag()))
    {
      localObject = paramView.getTag(-22);
      if ((this.jdField_a_of_type_Akkd != null) && (localObject != null)) {
        this.jdField_a_of_type_Akkd.a(paramView, localObject);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    boolean bool2 = false;
    if (akms.a(paramRecentBaseData))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramRecentBaseData instanceof RecentItemChatMsgData))
    {
      paramRecentBaseData = ((RecentItemChatMsgData)paramRecentBaseData).mUser;
      if ((paramRecentBaseData == null) || (paramRecentBaseData.getType() != 1008) || (!uaw.b(paramQQAppInterface, paramRecentBaseData.uin))) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = true;; bool1 = false)
    {
      return bool1;
      bool1 = bool2;
      if (!(paramRecentBaseData instanceof RecentItemTroopMsgData)) {
        break;
      }
      paramRecentBaseData = paramQQAppInterface.getHotChatMng(true).a(((RecentItemTroopMsgData)paramRecentBaseData).mUser.uin);
      bool1 = bool2;
      if (paramRecentBaseData == null) {
        break;
      }
      paramQQAppInterface = ((bhab)paramQQAppInterface.getBusinessHandler(107)).a("");
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
    int i = paramRecentBaseData.getRecentUserType();
    if (i == 7220)
    {
      pay.a();
      odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067CE", "0X80067CE", 0, 0, "", "", "", pay.f(), false);
    }
    try
    {
      paramString1 = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      paramString1.g();
      paramString1.e();
      if (i == 8112) {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
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
      paramString1 = paramRecentBaseData.getRecentUserUin();
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).cancelMayKnowRecommend(paramString1);
      if (((paramRecentBaseData instanceof RecentItemMayKnowFriendVerticalListData)) && ((((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo instanceof MayKnowRecommend)))
      {
        paramString1 = (MayKnowRecommend)((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).mUser.extraInfo;
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1.uin, "frd_list_dlt", 25, 0, paramString1.recommendReason, 0, paramString1.algBuffer, 2);
      }
      if (i == 8113)
      {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
          return;
        }
        paramString1 = paramRecentBaseData.getRecentUserUin();
        ((amvo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).d(paramString1);
      }
      if ((i == 1008) && ("2747277822".equals(paramRecentBaseData.getRecentUserUin()))) {
        i();
      }
      a(paramRecentBaseData, paramString2);
      a(paramRecentBaseData, paramString2, i);
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData.getRecentUserType() == 1)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramRecentBaseData.getRecentUserUin());
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, paramRecentBaseData.getRecentUserUin(), String.valueOf(i - 1), "", "");
    }
    if ("9970".equals(paramRecentBaseData.getRecentUserUin())) {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Press_Shopfolderlong", 0, 0, "", "", "", "");
    }
  }
  
  private void d() {}
  
  private void e()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {}
    }
    for (;;)
    {
      i += 1;
      break;
      int k = localRecentBaseData.getRecentUserType();
      k = ((Integer)aklg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, localRecentBaseData.getRecentUserUin()).first).intValue();
      if (k != -2147483648)
      {
        Object localObject1;
        if ((localRecentBaseData instanceof RecentSayHelloBoxItem))
        {
          Object localObject2 = ((RecentSayHelloBoxItem)localRecentBaseData).mUnreadMRList;
          localObject1 = ((RecentSayHelloBoxItem)localRecentBaseData).lock;
          if (localObject2 != null) {
            try
            {
              if (((List)localObject2).size() > 0)
              {
                localObject2 = new LinkedList((Collection)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
                  Object localObject5 = k + ":" + localMessageRecord.senderuin;
                  localObject5 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject5);
                  if (localObject5 != null) {
                    a(localView, localRecentBaseData, localMessageRecord, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject5));
                  }
                }
              }
            }
            finally {}
          }
        }
        else
        {
          localObject1 = k + ":" + localRecentBaseData.getRecentUserUin();
          localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject1);
          if (localObject1 != null)
          {
            Object localObject4;
            if (k == 103)
            {
              long l = System.currentTimeMillis();
              localObject4 = BaseApplication.getContext().getResources().getDrawable(2130840392);
              if ((localObject4 instanceof SkinnableBitmapDrawable)) {
                ((SkinnableBitmapDrawable)localObject4).setGravity(81);
              }
              if ((localObject4 instanceof BitmapDrawable)) {
                ((BitmapDrawable)localObject4).setGravity(81);
              }
              ((Drawable)localObject4).setBounds(0, 0, ((Drawable)localObject4).getIntrinsicWidth(), ((Drawable)localObject4).getIntrinsicHeight());
              localObject4 = new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1), localObject4 });
              localObject1 = localObject4;
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onDecodeTaskCompleted, subaccount cost = " + (System.currentTimeMillis() - l));
              }
            }
            for (localObject1 = localObject4;; localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject1))
            {
              a(localView, localRecentBaseData, (Drawable)localObject1);
              bool = true;
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
            }
            return;
          }
        }
      }
    }
  }
  
  private void g()
  {
    MessageHandler localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(0);
    if (localMessageHandler != null) {
      localMessageHandler.d(false);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject8;
    Object localObject4;
    Object localObject7;
    Object localObject6;
    Object localObject5;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject8 = localIterator.next();
        if (((localObject8 instanceof RecentBaseData)) && ((localObject8 instanceof RecentUserBaseData)))
        {
          localObject4 = (RecentUserBaseData)localObject8;
          if (((RecentUserBaseData)localObject4).mUnreadNum > 0)
          {
            localObject7 = (RecentUser)((RecentUserBaseData)localObject4).getRecentUser();
            ((RecentUserBaseData)localObject4).clearUnReadNum();
            bjnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(((RecentUserBaseData)localObject4).getRecentUserUin());
            localObject6 = localObject3;
            localObject5 = localObject2;
            localObject4 = localObject1;
            if (((RecentUser)localObject7).getType() == 1008)
            {
              if (localObject1 != null) {
                break label510;
              }
              localObject3 = new StringBuilder();
              localObject2 = new StringBuilder();
              localObject1 = new StringBuilder();
            }
          }
        }
      }
    }
    for (;;)
    {
      a((RecentUser)localObject7, (StringBuilder)localObject3, (StringBuilder)localObject2, (StringBuilder)localObject1);
      localObject4 = localObject3;
      localObject5 = localObject2;
      localObject6 = localObject1;
      if ((localObject8 instanceof RecentItemTroopMsgData))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((RecentUser)localObject7).uin);
        if ((i == 2) || (i == 4))
        {
          akms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject7, true, false);
          localObject3 = localObject6;
          localObject2 = localObject5;
          localObject1 = localObject4;
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (bool = true;; bool = false)
        {
          akms.a((QQAppInterface)localObject1, (RecentUser)localObject7, bool, false);
          localObject3 = localObject6;
          localObject2 = localObject5;
          localObject1 = localObject4;
          break;
        }
      }
      if ((localObject8 instanceof RecentItemServiceAccountFolderData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentAdapter", 2, "clearServiceAccountFolderUnreadByTabRed");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localMessageHandler == null) {}
        for (bool = true;; bool = false)
        {
          akms.a((QQAppInterface)localObject1, (RecentUser)localObject7, bool, false);
          uaw.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime());
          if (uex.c) {
            uaw.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject3 = localObject6;
          localObject2 = localObject5;
          localObject1 = localObject4;
          if (!(localObject7 instanceof azvi)) {
            break;
          }
          ((azvi)localObject7).a(104000, "104000.104001");
          localObject3 = localObject6;
          localObject2 = localObject5;
          localObject1 = localObject4;
          break;
        }
      }
      if ((localObject8 instanceof SendBlessRecentItemData))
      {
        ThreadManager.post(new RecentAdapter.4(this), 5, null, true);
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localMessageHandler == null) {}
      for (boolean bool = true;; bool = false)
      {
        akms.a((QQAppInterface)localObject1, (RecentUser)localObject7, bool, false);
        localObject3 = localObject6;
        localObject2 = localObject5;
        localObject1 = localObject4;
        break;
      }
      a((StringBuilder)localObject1, (StringBuilder)localObject2, (StringBuilder)localObject3);
      return;
      label510:
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  private void h()
  {
    Object localObject = (ofx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
    if ((localObject != null) && (((ofx)localObject).e))
    {
      ((ofx)localObject).e = false;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "noLogin";
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("ecshop_sp" + (String)localObject, 0).edit().putBoolean("folder_reddot", false).commit();
    }
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject = (atyd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358);
        if (localObject != null)
        {
          ((atyd)localObject).c(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      bcdb.a(localException);
    }
  }
  
  public aklg a()
  {
    return this.jdField_a_of_type_Aklg;
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
          if (avxy.a(((RecentBaseData)localObject).getRecentUserType())) {
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
        localView = localView.findViewById(2131380166);
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
  
  public void a(akkr paramakkr)
  {
    this.jdField_a_of_type_Akkr = paramakkr;
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
      i = paramRecentBaseData.getRecentUserType();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).a())) {
        break label108;
      }
      i = 3002;
    }
    label108:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_Aklg.a(i, paramRecentBaseData.getRecentUserUin());
      paramDrawable = this.jdField_a_of_type_Aklo.a(paramRecentBaseData);
      if (paramDrawable == null) {
        break;
      }
      try
      {
        paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
        return;
      }
      catch (Throwable paramView) {}
      if (!akmb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
        break;
      }
      throw new RuntimeException(paramView);
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
        localDrawable = this.jdField_a_of_type_Aklg.a(paramMessageRecord.istroop, paramMessageRecord.senderuin);
      }
      paramDrawable = this.jdField_a_of_type_Aklo.a(paramRecentBaseData);
    } while ((paramDrawable == null) || (!(paramDrawable instanceof akmt)));
    ((akmt)paramDrawable).a(paramView, paramRecentBaseData, paramMessageRecord, localDrawable);
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
    if (this.jdField_a_of_type_Akkd != null) {
      this.jdField_a_of_type_Akkd.a(paramRecentBaseData, paramString);
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
    if (bftf.a(paramString1, localResources.getString(akll.a[0])))
    {
      paramRecentBaseData.getRecentUserType();
      b(paramRecentBaseData, paramString1, paramString2);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A360", "0X800A360", 0, 0, "1", "", paramString2, "");
    }
    while (this.jdField_a_of_type_Akkd == null) {
      return;
    }
    this.jdField_a_of_type_Akkd.a(paramString1, paramRecentBaseData, paramString2);
    uhv.a(paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin(), paramString1, localResources);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aklg.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Wcn != null) {
      this.jdField_a_of_type_Wcn.a();
    }
    if (this.jdField_a_of_type_Aklo != null) {
      this.jdField_a_of_type_Aklo.a(paramQQAppInterface);
    }
    this.jdField_a_of_type_Wcn = new wcn(paramQQAppInterface);
    this.jdField_a_of_type_Wcn.a(new akkl(this));
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "onAccountChanged: invoked. Message: app: " + paramQQAppInterface + " recreate mRecentTabHaloPresenter: " + this.jdField_a_of_type_Wcn);
    }
  }
  
  public void a(RecentUser paramRecentUser, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, 1008);
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
    bcef.b(null, "dc00899", "Grp_video", "", "notice", "call", 0, 0, paramString, "" + TroopUtils.getTroopIdentity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), "", "");
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
      if ((localRecentBaseData != null) && (localRecentBaseData.getRecentUserType() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!bftf.a(localRecentBaseData.getRecentUserUin(), paramString))
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
      if ((localRecentBaseData != null) && (bftf.a(paramString, localRecentBaseData.getRecentUserUin()))) {
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
      k = localRecentBaseData.getRecentUserType();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(k))));
    a(localView, localRecentBaseData);
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    f();
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
              break label531;
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
          label531:
          i += 1;
        }
        localObject2 = null;
        break;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aklg.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aklg.a.cancelPendingRequests();
      this.jdField_a_of_type_Aklg.a.pause();
      return;
    }
    if (this.jdField_a_of_type_Aklg.a.isPausing()) {
      this.jdField_a_of_type_Aklg.a.resume();
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
        this.jdField_a_of_type_Aklg.a(localRecentBaseData.getRecentUserType(), localRecentBaseData.getRecentUserUin(), false);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    int i;
    RecentUser localRecentUser;
    if (paramBoolean)
    {
      if (this.c == 0)
      {
        i = 1;
        if (paramInt != 2) {
          break label230;
        }
        if (paramDragFrameLayout != null) {
          break label170;
        }
      }
      label170:
      for (paramDragFrameLayout = "null";; paramDragFrameLayout = paramDragFrameLayout.getClass().getSimpleName())
      {
        QLog.d("RecentAdapter", 2, new Object[] { "onChange type=", Integer.valueOf(paramInt), " from=", paramDragFrameLayout, " Current Thread=", Thread.currentThread().getName() });
        if (i == 0) {
          break label181;
        }
        paramDragFrameLayout = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramDragFrameLayout.hasNext())
        {
          localObject = paramDragFrameLayout.next();
          if (((localObject instanceof RecentBaseData)) && ((localObject instanceof RecentUserBaseData)))
          {
            localObject = (RecentUserBaseData)localObject;
            if (((RecentUserBaseData)localObject).mUnreadNum > 0)
            {
              localRecentUser = (RecentUser)((RecentUserBaseData)localObject).getRecentUser();
              akmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject, localRecentUser, true);
            }
          }
        }
        i = 0;
        break;
      }
      label181:
      h();
      g();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCallTabShow)
      {
        paramDragFrameLayout = (azjc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(38);
        if (paramDragFrameLayout != null) {
          paramDragFrameLayout.a(bbko.a());
        }
      }
      ple.a().h();
    }
    label230:
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
      paramInt = paramDragFrameLayout.intValue();
      paramDragFrameLayout = getItem(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
      }
    } while (!(paramDragFrameLayout instanceof RecentBaseData));
    Object localObject = (RecentBaseData)paramDragFrameLayout;
    if ((i != 0) && ((paramDragFrameLayout instanceof RecentUserBaseData)))
    {
      localRecentUser = (RecentUser)((RecentUserBaseData)paramDragFrameLayout).getRecentUser();
      akmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentBaseData)localObject, localRecentUser, false);
    }
    a(paramInt, paramDragFrameLayout);
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
    this.jdField_a_of_type_Aklg.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Wcn != null) {
      this.jdField_a_of_type_Wcn.a();
    }
  }
  
  public void b(RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 8) && (paramRecentBaseData.mExtraType == 25))
    {
      localObject = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if ((localObject == null) || (paramRecentBaseData.mPhoneNumber == null)) {
        break label104;
      }
    }
    label104:
    for (Object localObject = ((avsy)localObject).c(paramRecentBaseData.mPhoneNumber);; localObject = null)
    {
      if (localObject != null) {
        paramRecentBaseData.mTitleName = ((PhoneContact)localObject).name;
      }
      do
      {
        return;
        localObject = ((azis)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(140)).a(paramRecentBaseData.getRecentUserUin());
      } while (localObject == null);
      paramRecentBaseData.mTitleName = ((QCallCardInfo)localObject).nickname;
      return;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Aklo != null) {
      this.jdField_a_of_type_Aklo.b(paramQQAppInterface);
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
    if (this.jdField_a_of_type_Aklg != null) {
      this.jdField_a_of_type_Aklg.b();
    }
  }
  
  protected boolean c()
  {
    return (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 8);
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
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
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
    return this.jdField_a_of_type_Aklo.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    for (;;)
    {
      try
      {
        localObject2 = getItem(paramInt);
        localObject1 = this.jdField_a_of_type_Aklo.a(localObject2);
        if (!(localObject2 instanceof RecentBaseData)) {
          continue;
        }
        localObject2 = (RecentBaseData)localObject2;
        b((RecentBaseData)localObject2);
        localObject1 = ((akll)localObject1).a(paramInt, localObject2, this.jdField_a_of_type_Aklg, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
        paramView = (View)localObject1;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject1;
        akmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, localThrowable);
        if (!akmb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
          continue;
        }
        throw new RuntimeException(localThrowable);
        continue;
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if ((localObject2 instanceof Integer))
      {
        localObject1 = ((akll)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
        paramView = (View)localObject1;
      }
      else if ((localObject2 instanceof String))
      {
        localObject1 = ((akll)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
        paramView = (View)localObject1;
      }
      else
      {
        localObject1 = ((akll)localObject1).a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
        paramView = (View)localObject1;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_Aklo.b();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    akkr localakkr = this.jdField_a_of_type_Akkr;
    if (localakkr == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof RecentUserBaseData)))
    {
      localakkr.m();
      return;
    }
    RecentUser localRecentUser = (RecentUser)((RecentUserBaseData)this.jdField_a_of_type_JavaUtilList.get(0)).getRecentUser();
    if ((localRecentUser != null) && (localRecentUser.showUpTime > 0L))
    {
      localakkr.l();
      return;
    }
    localakkr.m();
  }
  
  public void onClick(View paramView)
  {
    if (a(paramView)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (vlj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
      if (this.jdField_a_of_type_Akkd != null)
      {
        Object localObject2 = paramView.getTag(-22);
        if (((vlj)localObject1).b(localObject2)) {
          this.jdField_a_of_type_Akkd.a(paramView, localObject2);
        }
        localObject1 = paramView.getTag(-1);
        if (!(localObject1 instanceof Integer))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
          }
        }
        else
        {
          int i = ((Integer)localObject1).intValue();
          localObject1 = getItem(i);
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "onClick|obj = " + localObject1);
          }
          if ((localObject1 instanceof RecentBaseData))
          {
            if (((paramView instanceof bjra)) && ((localObject1 instanceof RecentItemEcShop)))
            {
              this.jdField_a_of_type_Akkd.a(paramView, localObject1);
              label177:
              if (!(localObject1 instanceof RecentItemTroopMsgData)) {
                break label255;
              }
              localObject2 = (RecentItemTroopMsgData)localObject1;
              if ((localObject2 != null) && (((RecentItemTroopMsgData)localObject2).mIsGroupVideoNotify)) {
                a(((RecentItemTroopMsgData)localObject2).getRecentUserUin());
              }
            }
            for (;;)
            {
              nsf.a.a(localObject1);
              break;
              localObject2 = (RecentBaseData)localObject1;
              ((RecentBaseData)localObject2).mPosition = i;
              this.jdField_a_of_type_Akkd.a(paramView, (RecentBaseData)localObject2, ((RecentBaseData)localObject2).mTitleName, true);
              break label177;
              label255:
              if ((localObject1 instanceof RecentTroopAssistantItem))
              {
                localObject2 = (RecentTroopAssistantItem)localObject1;
                if ((localObject2 != null) && (((RecentTroopAssistantItem)localObject2).mIsGroupVideoNotify)) {
                  a(((RecentTroopAssistantItem)localObject2).getRecentUserUin());
                }
              }
            }
          }
          this.jdField_a_of_type_Akkd.a(paramView, localObject1);
        }
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(???))) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
          {
            bool1 = true;
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder().append("RecentAdapter.onDecodeTaskCompleted type=").append(paramInt2).append(", uin=").append(???).append(", remainingTasks=").append(paramInt1).append(", isdecodeFaceTimeout=").append(bool1).append(", avatar == null ? | ");
              if (paramBitmap != null) {
                break label276;
              }
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
            boolean bool1 = false;
            continue;
            label276:
            bool2 = false;
          }
        }
      }
    }
    if (paramInt1 == 0) {}
    for (this.jdField_a_of_type_Long = 0L;; this.jdField_a_of_type_Long = l)
    {
      e();
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 2, "RecentAdpater onLongClick");
    }
    int i;
    if (this.jdField_a_of_type_Aklo != null)
    {
      i = this.jdField_a_of_type_Aklo.a();
      if ((i != 0) || (!FrameHelperActivity.b())) {
        break label51;
      }
    }
    label51:
    label73:
    do
    {
      do
      {
        do
        {
          return false;
          i = 0;
          break;
          if (paramView != null) {
            break label73;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
        return false;
      } while ((paramView.getContext() instanceof TroopAssistantActivity));
      localObject1 = paramView.getTag(-1);
      if ((localObject1 instanceof Integer)) {
        break label116;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
    return false;
    label116:
    int j = ((Integer)localObject1).intValue();
    Object localObject1 = getItem(j);
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onLongClick|obj = " + localObject1);
    }
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        return false;
      }
      if (this.jdField_a_of_type_Aklo == null) {
        break;
      }
      Object localObject2 = this.jdField_a_of_type_Aklo.a(localObject1);
      c((RecentBaseData)localObject1);
      if (localObject2 != null) {}
      for (List localList = ((akll)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localList = null)
      {
        if ((localList != null) && (localList.size() > 0) && (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long > 100L))
        {
          localObject2 = new bgaz();
          i = 0;
          while (i < localList.size())
          {
            ((bgaz)localObject2).a(j, (String)localList.get(i));
            i += 1;
          }
          boolean bool1;
          if ((this.jdField_a_of_type_Boolean) && (avyf.a(this.jdField_a_of_type_AndroidContentContext, ((RecentBaseData)localObject1).getRecentUserUin(), ((RecentBaseData)localObject1).getRecentUserType(), ((RecentBaseData)localObject1).getTitleName(), "conversation_tab_list")))
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
              this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bfue.a(paramView, (bgaz)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new akkn(this, paramView));
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
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */