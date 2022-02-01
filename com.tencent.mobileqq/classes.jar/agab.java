import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.1;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.12;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.17;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.19;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.2;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.20;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.21;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.25;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.3;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie.7;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.api.QZoneEventHandler;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;

public class agab
  extends BaseChatPie
{
  protected int a;
  private long jdField_a_of_type_Long = -1L;
  acmm jdField_a_of_type_Acmm;
  afoj jdField_a_of_type_Afoj = new agan(this);
  afwr jdField_a_of_type_Afwr;
  protected aiki a;
  aikn jdField_a_of_type_Aikn;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agap(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  View jdField_a_of_type_AndroidViewView;
  anqs jdField_a_of_type_Anqs = new agae(this);
  anvi jdField_a_of_type_Anvi = new agag(this);
  protected anyz a;
  private aoec jdField_a_of_type_Aoec = new agac(this);
  auzh jdField_a_of_type_Auzh = new agah(this);
  public axnb a;
  protected ayrc a;
  private bbds jdField_a_of_type_Bbds;
  private bcwb jdField_a_of_type_Bcwb = new agat(this);
  beci jdField_a_of_type_Beci = new agam(this);
  public bjxa a;
  private bjyh jdField_a_of_type_Bjyh = new agaj(this);
  protected BabyQAIOPanel a;
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendChatPie.3(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new agai(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new agaq(this);
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  boolean c = false;
  public boolean d;
  public boolean e;
  boolean f = false;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j = true;
  private boolean k;
  private boolean l;
  
  public agab(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ayrc = new agas(this);
    this.jdField_a_of_type_Anyz = new agad(this);
    if (paramQQAppInterface.isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.jdField_a_of_type_Bjxa = ((bjxa)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
  }
  
  private void a(long paramLong)
  {
    bibu localbibu = (bibu)this.app.getManager(QQManagerFactory.VIP_GIF_MANAGER);
    bibt localbibt = localbibu.a();
    if ((localbibt != null) && (this.mActivity.isResume()) && (localbibt.jdField_b_of_type_JavaLangString.equalsIgnoreCase(getCurFriendUin())) && (localbibt.d == 2L) && (paramLong == localbibt.jdField_a_of_type_Long)) {
      localbibu.a(localbibt, this.mActivity);
    }
  }
  
  private void a(Intent paramIntent)
  {
    this.l = false;
    String str = paramIntent.getStringExtra("uin");
    this.f = paramIntent.getBooleanExtra("open_chat_from_frd_rank_confess", false);
    aqvd localaqvd = (aqvd)this.app.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (this.f)
    {
      this.c = localaqvd.c(str, paramIntent);
      return;
    }
    this.c = localaqvd.a(str, paramIntent);
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "onUpdateSendMsgError uin " + paramString + " type " + paramInt + " uniseq " + paramLong);
    }
    MessageRecord localMessageRecord;
    boolean bool;
    if (paramInt == 0)
    {
      localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(paramString, paramInt, paramLong);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -2058) && ((localMessageRecord.extraflag == 32768) || (localMessageRecord.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.tag, 2, "onUpdateSendMsgError, sticker msg is failed!");
        }
        this.app.getMessageFacade().removeMsgByMessageRecord(localMessageRecord, false);
        paramString = acnh.a(paramString, paramInt);
        if (!EmojiStickerManager.a().b.containsKey(paramString)) {
          break label264;
        }
        paramLong = ((Long)EmojiStickerManager.a().b.get(paramString)).longValue();
        if (System.currentTimeMillis() - paramLong <= 300000L) {
          break label270;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (bool)
      {
        EmojiStickerManager.a().b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        ThreadManager.getUIHandler().post(new FriendChatPie.12(this, localMessageRecord));
      }
      return;
      label264:
      bool = true;
      continue;
      label270:
      bool = false;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Object localObject = this.mContext.getResources();
      int m;
      if (paramBoolean1)
      {
        m = 2130843942;
        localObject = ((Resources)localObject).getDrawable(m);
        if ((!bdfk.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label132;
        }
        ((Drawable)localObject).setColorFilter(this.mActivity.getResources().getColor(2131167023), PorterDuff.Mode.MULTIPLY);
        label64:
        if (!paramBoolean1) {
          break label166;
        }
        label68:
        this.mSubTilteText.setClickable(false);
        if (!paramBoolean2) {
          break label196;
        }
        this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        this.mSubTilteText.setCompoundDrawablePadding(UIUtils.dip2px(this.mContext, 4.0F));
        this.mSubTitleLayout.setClickable(true);
        this.mSubTitleLayout.setOnClickListener(this);
        return;
        m = 2130843949;
        break;
        label132:
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label64;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label64;
        label166:
        ((Drawable)localObject).setBounds(0, 0, UIUtils.dip2px(this.mContext, 10.0F), UIUtils.dip2px(this.mContext, 10.0F));
        break label68;
        label196:
        this.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c()
  {
    Friends localFriends = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.sessionInfo.curFriendUin);
    boolean bool;
    azbu localazbu;
    if ((localFriends != null) && ((ContactUtils.getFriendStatus(localFriends.detalStatusFlag, localFriends.iTermType) != 0) || ((!TextUtils.isEmpty(localFriends.strTermDesc)) && (localFriends.strTermDesc.contains("TIM"))))) {
      if (!this.app.getCurrentUin().equals(this.sessionInfo.curFriendUin))
      {
        bool = true;
        localazbu = azbj.a().a(AppRuntime.Status.online, localFriends.uExtOnlineStatus, bool);
        if ((ContactUtils.getFriendStatus(localFriends.detalStatusFlag, localFriends.iTermType) != 4) || (localazbu.jdField_a_of_type_Long <= 0L) || (localazbu == null)) {
          break label227;
        }
        bool = true;
        label132:
        String str = azbj.a().a(this.app, localFriends, this.mSubTilteText, 1, localazbu, Boolean.valueOf(bool));
        if ((TextUtils.isEmpty(str)) || (bhbx.b(this.sessionInfo.curFriendUin))) {
          break label232;
        }
        setSubTitleVisable(true);
        this.jdField_b_of_type_JavaLangString = str;
        setSubTitleText(str);
        azbj.a().a(localFriends, this.mSubTilteText, false, localazbu);
        if (jdField_a_of_type_Boolean) {
          this.mSubTilteText.setContentDescription(str);
        }
      }
    }
    label227:
    label232:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        bool = false;
        break label132;
        setSubTitleVisable(false);
        azbj.a().a(localFriends, this.mSubTilteText, true, localazbu);
        return;
      } while (this.mSubTilteText.getVisibility() != 0);
      setSubTitleVisable(false);
    } while (this.mTipsMgr.a() != 5);
    aiki.c(this.app, this.sessionInfo.curFriendUin);
    this.mTipsMgr.a();
  }
  
  private void d()
  {
    if (this.sessionInfo.isNightMode)
    {
      this.mSubTilteText.setTextColor(getActivity().getResources().getColor(2131167023));
      this.mSubTitleText2.setTextColor(getActivity().getResources().getColor(2131167023));
      Friends localFriends = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.sessionInfo.curFriendUin);
      if ((localFriends == null) || ((ContactUtils.getFriendStatus(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label256;
      }
      setSubTitleText(ContactUtils.getStatusName(localFriends));
      this.mSubTilteText.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.mSubTilteText.setCompoundDrawables(ahwv.a().b(5), null, null, null);
      bdla.b(this.app, "CliOper", "", "", "0X80085A4", "0X80085A4", 2, 0, "", "", "", "");
      this.mSubTilteText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "not setOnClickListener");
      }
      setSubTitleVisable(true);
    }
    label256:
    do
    {
      do
      {
        return;
        this.mSubTilteText.setTextColor(getActivity().getResources().getColor(2131167024));
        this.mSubTitleText2.setTextColor(getActivity().getResources().getColor(2131167024));
        break;
      } while (this.mSubTilteText.getVisibility() != 0);
      setSubTitleVisable(false);
    } while (this.mTipsMgr.a() != 5);
    aiki.c(this.app, this.sessionInfo.curFriendUin);
    this.mTipsMgr.a();
  }
  
  private void e()
  {
    if (this.sessionInfo.isNightMode)
    {
      this.mSubTilteText.setTextColor(getActivity().getResources().getColor(2131167023));
      this.mSubTitleText2.setTextColor(getActivity().getResources().getColor(2131167023));
      Friends localFriends = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.sessionInfo.curFriendUin);
      if ((localFriends == null) || ((ContactUtils.getFriendStatus(localFriends.detalStatusFlag, localFriends.iTermType) == 0) && (TextUtils.isEmpty(localFriends.strTermDesc)))) {
        break label193;
      }
      setSubTitleText(ContactUtils.getStatusName(localFriends));
      this.mSubTilteText.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, BaseApplicationImpl.getContext().getResources()));
      this.mSubTilteText.setCompoundDrawables(aijq.a().b(5), null, null, null);
      setSubTitleVisable(true);
    }
    label193:
    while (this.mSubTilteText.getVisibility() != 0)
    {
      return;
      this.mSubTilteText.setTextColor(getActivity().getResources().getColor(2131167024));
      this.mSubTitleText2.setTextColor(getActivity().getResources().getColor(2131167024));
      break;
    }
    setSubTitleVisable(false);
  }
  
  private void f()
  {
    Message localMessage = this.uiHandler.obtainMessage(85);
    if (beki.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false))
    {
      argc localargc = ((argb)aqxe.a().a(551)).a(4);
      if ((localargc != null) && (localargc.jdField_a_of_type_Boolean)) {
        localMessage.arg1 = 1;
      }
    }
    localMessage.sendToTarget();
  }
  
  private void g()
  {
    ThreadManager.post(new FriendChatPie.21(this), 5, null, false);
  }
  
  private void h()
  {
    if (this.l) {
      return;
    }
    ((aqvd)this.app.getManager(QQManagerFactory.CONFESS_MANAGER)).a(this.sessionInfo.curFriendUin);
    this.l = true;
  }
  
  private void i()
  {
    avrg localavrg = (avrg)getHelper(16);
    if (localavrg != null) {
      localavrg.b();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bbds == null)
    {
      this.jdField_a_of_type_Bbds = new bbds(this.app, this.sessionInfo.curType, this.sessionInfo.curFriendUin);
      this.jdField_a_of_type_Bbds.a(new agao(this));
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Bbds != null) {
      this.jdField_a_of_type_Bbds.a();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Bbds != null)
    {
      this.jdField_a_of_type_Bbds.b();
      this.jdField_a_of_type_Bbds = null;
    }
  }
  
  public void a()
  {
    Object localObject = bhaa.a(this.app, this.sessionInfo.curFriendUin);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.sessionInfo.curFriendUin, 8);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.getFriendNick(this.app, this.sessionInfo.curFriendUin);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.sessionInfo.curFriendUin))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.sessionInfo.curFriendNick;
    }
    localAllInOne.f = this.sessionInfo.curFriendUin;
    localAllInOne.e = this.sessionInfo.curType;
    localAllInOne.g = 2;
    localAllInOne.jdField_h_of_type_Int = 117;
    azrb localazrb = new azrb();
    localazrb.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
    localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = localAllInOne;
    localObject = aqkw.a(this.app, localazrb);
    bhaa.a(getActivity(), (BusinessCard)localObject, localAllInOne);
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "refreshHeadMessage==> aio cache is find! origUid" + paramLong1 + ", time" + paramLong2);
    }
    List localList = this.app.getMessageFacade().queryMsgItemByTime(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong2, paramLong1);
    int m;
    MessageRecord localMessageRecord;
    if ((localList != null) && (localList.size() > 0))
    {
      m = 0;
      if (m >= localList.size()) {
        break label286;
      }
      localMessageRecord = (MessageRecord)localList.get(m);
      if ((acnh.b(localMessageRecord)) || ((localMessageRecord instanceof MessageForSafeGrayTips))) {
        break label183;
      }
    }
    for (;;)
    {
      if ((localMessageRecord != null) && (!avia.a(localMessageRecord)))
      {
        m = this.listAdapter.a(localMessageRecord.uniseq);
        if (m != -1) {
          this.mScrollerRunnable.a(paramInt1, m, m, null, 10);
        }
      }
      label183:
      do
      {
        do
        {
          return;
          m += 1;
          break;
          if (localMessageRecord.msgtype == -2006) {
            QQToast.a(this.mActivity, anvx.a(2131704341), 0).b(this.mActivity.getTitleBarHeight());
          }
        } while (paramInt2 != 1);
        ahfa.a(this.app, null, "0X800A36B");
        return;
        QQToast.a(this.mActivity, 2131697439, 0).b(this.mActivity.getTitleBarHeight());
      } while (paramInt2 != 1);
      ahfa.a(this.app, null, "0X800A36B");
      return;
      label286:
      localMessageRecord = null;
    }
  }
  
  protected void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Runnable paramRunnable)
  {
    if (!NetworkUtil.isNetworkAvailable(this.mActivity))
    {
      QQToast.a(this.mActivity, 2131696954, 0).b(this.mActivity.getTitleBarHeight());
      if (paramInt2 == 1) {
        ahfa.a(this.app, null, "0X800A36B");
      }
    }
    do
    {
      return;
      if (aigh.a(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong2, paramLong1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.tag, 2, "refreshHeadMessage==> db is find! origUid" + paramLong1 + ", time" + paramLong2);
        }
        this.jdField_a_of_type_Acmm.a(paramLong1, paramLong2, false);
        this.mScrollerRunnable.a(paramInt1, 0, -1, paramRunnable, 10);
        return;
      }
      QQToast.a(this.mActivity, 2131697439, 0).b(this.mActivity.getTitleBarHeight());
    } while (paramInt2 != 1);
    ahfa.a(this.app, null, "0X800A36B");
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, MessageRecord paramMessageRecord)
  {
    a(paramInt, paramLong1, paramLong2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, MessageRecord paramMessageRecord, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "refreshHeadMessage==>type:" + paramInt1 + "|origUid:" + paramLong1);
    }
    paramMessageRecord = new FriendChatPie.17(this);
    boolean bool = a(paramLong1, paramLong2);
    this.mScrollerRunnable.b(paramInt2);
    if (!bool)
    {
      a(paramInt1, paramLong1, paramLong2, paramInt3, paramMessageRecord);
      return;
    }
    a(paramInt1, paramLong1, paramLong2, paramInt3);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "showAddFriendActivity-->uinType=" + paramInt1 + " peerUin=" + paramString1 + " name=" + paramString2 + " phoneNum=" + paramString3 + " srcId=" + paramInt2);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (((paramObject instanceof MessageForStructing)) && (((MessageForStructing)paramObject).isread))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.structingMsg == null) || (paramObject.structingMsg.mMsgServiceID != 38) || (TextUtils.isEmpty(paramObject.structingMsg.mResid)) || (!((bibu)this.app.getManager(QQManagerFactory.VIP_GIF_MANAGER)).a(paramObject))) {}
    }
  }
  
  @TargetApi(16)
  public boolean a()
  {
    Object localObject = axlr.a(this.app, this.sessionInfo.curFriendUin);
    if ((localObject == null) || ((((Pair)localObject).first == null) && (((Pair)localObject).second == null)))
    {
      this.mCustomTitleView.setTitleIconLeft(0, 0);
      this.mTitleIcon.setOnTouchListener(null);
      this.mTitleIcon2.setOnTouchListener(null);
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new agal(this);
    }
    axms localaxms = (axms)((Pair)localObject).first;
    localObject = (axms)((Pair)localObject).second;
    if (localaxms != null)
    {
      VipUtils.a(this.sessionInfo.curFriendUin, localaxms, this.app, "C2C_show");
      this.mTitleIcon.setTag(localaxms);
      this.mTitleIcon.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      if (localObject == null) {
        break label259;
      }
      VipUtils.a(this.sessionInfo.curFriendUin, (axms)localObject, this.app, "C2C_show");
      this.mTitleIcon2.setTag(localObject);
      this.mTitleIcon2.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    for (;;)
    {
      this.mCustomTitleView.setTitleIconLeftForMutualMark(localaxms, (axms)localObject);
      axlo.a(this.app, this.sessionInfo.curFriendUin, localaxms, (axms)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "updateSession_updateInteractive one:" + localaxms + " two:" + localObject);
      }
      return true;
      this.mTitleIcon.setOnTouchListener(null);
      break;
      label259:
      this.mTitleIcon2.setOnTouchListener(null);
    }
  }
  
  protected boolean a(long paramLong1, long paramLong2)
  {
    Object localObject = this.listAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while ((acnh.b(localChatMessage)) || (localChatMessage.msgUid != paramLong1) || (localChatMessage.time != paramLong2));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "refreshHeadMessage==>isFind:" + bool);
      }
      return bool;
    }
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addDefaultObservers(this.jdField_a_of_type_Anyz);
    this.app.addObserver(this.jdField_a_of_type_Aoec);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Auzh);
    this.app.registObserver(this.jdField_a_of_type_Bcwb);
    this.app.registObserver(this.jdField_a_of_type_Ayrc);
    this.app.addObserver(this.jdField_a_of_type_Bjyh);
    ((avhf)this.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.app.addObserver(this.jdField_a_of_type_Anqs);
    this.app.addObserver(this.jdField_a_of_type_Beci);
  }
  
  public void b()
  {
    if ((this.mSubTitleLeftImageView == null) || (this.mSubTilteText == null) || (this.mSubTitleLayout == null) || (this.mTitleText == null) || (this.mSubTitleText2 == null)) {}
    for (;;)
    {
      return;
      Object localObject = (awim)getHelper(32);
      boolean bool1 = ((awim)localObject).c();
      boolean bool2 = ((awim)localObject).d();
      agkk localagkk = (agkk)getHelper(43);
      boolean bool3 = localagkk.c();
      int m;
      if (bool1)
      {
        this.jdField_a_of_type_Int = 1;
        setSubTitleVisable(true);
        setSubTitleText(((awim)localObject).a(bool2));
        a(bool2, false);
        m = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
        awid.a(this.mSubTitleLayout, 0, m, 0, 0, this.mAIORootView.getRootView());
      }
      while (QLog.isColorLevel())
      {
        QLog.d("BaseListenTogetherPanel_C2C", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
        return;
        if (bool3)
        {
          this.jdField_a_of_type_Int = 2;
          setSubTitleVisable(true);
          bool3 = localagkk.a();
          setSubTitleText(localagkk.a());
          this.mSubTilteText.setTextColor(this.mActivity.getResources().getColor(2131167023));
          a(bool3, localagkk.d());
          localObject = (bbss)getHelper(45);
          m = AIOUtils.dp2px(8.0F, this.mSubTilteText.getResources());
          awid.a(this.mSubTitleLayout, 0, m, 0, 0, this.mAIORootView.getRootView());
        }
        else
        {
          this.mSubTitleLeftImageView.setVisibility(8);
          this.mSubTilteText.setClickable(true);
          this.mSubTitleLayout.setClickable(false);
          this.mSubTitleLayout.setOnClickListener(null);
          awid.a(this.mSubTitleLayout, this.mAIORootView.getRootView());
          this.jdField_a_of_type_Int = 0;
          setSubTitleText("");
          updateOnlineStatus();
          localObject = (bbss)getHelper(45);
          if (localObject != null) {
            ((bbss)localObject).b("");
          }
        }
      }
    }
  }
  
  protected void b(Object paramObject)
  {
    avrg localavrg;
    if ((paramObject instanceof MessageRecord))
    {
      paramObject = (MessageRecord)paramObject;
      localavrg = (avrg)getHelper(16);
      if (localavrg != null)
      {
        if (!paramObject.isSend()) {
          break label38;
        }
        localavrg.d();
      }
    }
    label38:
    while (paramObject.time <= localavrg.b) {
      return;
    }
    i();
  }
  
  protected void c(Object paramObject)
  {
    if ((paramObject instanceof MessageForText))
    {
      paramObject = (MessageForText)paramObject;
      String str = paramObject.msg;
      if (paramObject.frienduin.equals(this.sessionInfo.curFriendUin))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in FriendChatPie.update()");
        }
        bhyi.a().a(this.app, this.sessionInfo, paramObject, str, this.mContext, paramObject.isSend());
      }
    }
  }
  
  public ager createChatDrawer()
  {
    if (!agep.a())
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, not support!");
      return null;
    }
    if ((this.sessionInfo == null) || (TextUtils.isEmpty(this.sessionInfo.curFriendUin)))
    {
      QLog.d("intimate_relationship", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
      return null;
    }
    if ((!((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.sessionInfo.curFriendUin)) || (this.sessionInfo.curFriendUin.equalsIgnoreCase(this.app.getCurrentAccountUin())) || (this.sessionInfo.curFriendUin.equalsIgnoreCase(String.valueOf(66600000L))))
    {
      QLog.d("intimate_relationship", 1, String.format("createChatDrawer, not friendUin: %s", new Object[] { this.sessionInfo.curFriendUin }));
      return null;
    }
    if (!axmv.a(this.app.getCurrentUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "aio intimate is close");
      }
      return null;
    }
    return new agev(this);
  }
  
  public EntryModel createMiniAppEntryModel()
  {
    if (this.sessionInfo.curType == 0) {
      return new EntryModel(0, Long.parseLong(this.sessionInfo.curFriendUin), this.sessionInfo.curFriendNick, false);
    }
    return super.createMiniAppEntryModel();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QZoneEventHandler.handleActivityEvent(this, paramInt1, paramInt2, paramIntent)) {}
    for (;;)
    {
      return;
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt1 == 13008) {
        if (paramIntent != null)
        {
          String str = paramIntent.getStringExtra("result");
          Object localObject = str;
          if (str == null) {
            localObject = "";
          }
          if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            break label168;
          }
          if (this.friendListHandler == null) {
            break label142;
          }
          this.friendListHandler.setFriendComment(this.sessionInfo.curFriendUin, (String)localObject, false);
          localObject = new QZoneDistributedAppCtrl.Control();
          ((QZoneDistributedAppCtrl.Control)localObject).cmd = 5;
          QZoneDistributedAppCtrl.getInstance(this.sessionInfo.curFriendUin).submitCtrl((QZoneDistributedAppCtrl.Control)localObject);
        }
      }
      while (this.refreshMessageContext.roamMsgFetcher != null)
      {
        ((aigi)this.refreshMessageContext.roamMsgFetcher).a(paramInt1, paramInt2, paramIntent);
        return;
        label142:
        new bisy(this.mContext).a(2131693257, getTitleBarHeight(), 0, 1);
        continue;
        label168:
        new bisy(this.mContext).a(2131694302, getTitleBarHeight(), 0, 1);
        continue;
        if (paramInt1 != 13009) {}
      }
    }
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    Intent localIntent = this.mActivity.getIntent();
    String str = localIntent.getStringExtra("PREVIOUS_WINDOW");
    if ((str != null) && (str.equals(FriendProfileCardActivity.class.getName()))) {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    }
    this.jdField_b_of_type_Boolean = true;
    if (localIntent.getBooleanExtra("open_chat_from_avator", false))
    {
      str = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "upload avator " + str);
      }
      if (str != null)
      {
        if (!bhaa.a(this.app, str, localIntent)) {
          break label284;
        }
        QQToast.a(getActivity(), 2, 2131718543, 0).b(getTitleBarHeight());
        if (bhbx.b(this.sessionInfo.curFriendUin)) {
          ThreadManager.executeOnSubThread(new FriendChatPie.1(this), true);
        }
        bdla.b(this.app, "dc00898", "", "", "0X8007240", "0X8007240", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.c = localIntent.getBooleanExtra("open_chat_from_frd_rec_confess", false);
      if (this.c) {
        a(localIntent);
      }
      this.sessionInfo.isFromFrdRecConfess = this.c;
      this.jdField_a_of_type_Acmm = new acmm();
      this.jdField_a_of_type_Afwr = new afxg(getActivity());
      localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Axnb = new axnb(this.app);
      return super.doOnCreate(paramBoolean);
      label284:
      QQToast.a(getActivity(), 1, 2131718542, 0).b(getTitleBarHeight());
    }
  }
  
  public void doOnCreate_initData()
  {
    super.doOnCreate_initData();
    this.mSingleTitle = false;
    this.showOnlineStatus = true;
    ahfn.jdField_a_of_type_Long = 0L;
    if (this.aioTipsController != null) {
      this.aioTipsController.a(this.jdField_a_of_type_Afoj);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      ThreadManager.getSubThreadHandler().post(new FriendChatPie.2(this));
    }
    if (this.hasDestory)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "hasDestory = true return");
      }
      return;
    }
    if (this.mScrollerRunnable != null)
    {
      this.mScrollerRunnable.b();
      this.mScrollerRunnable.a(false);
    }
    if (this.c) {
      h();
    }
    if (!TextUtils.isEmpty(this.sessionInfo.curFriendUin))
    {
      acnh.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -4021);
      acnh.b(this.app, this.sessionInfo.curFriendUin, this.sessionInfo.curType, -4022);
    }
    if (bhbx.b(this.sessionInfo.curFriendUin)) {
      ((anqn)this.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a();
    }
    this.jdField_b_of_type_Boolean = false;
    super.doOnDestroy();
    if ((this.refreshMessageContext != null) && (this.refreshMessageContext.roamMsgFetcher != null))
    {
      ((aigi)this.refreshMessageContext.roamMsgFetcher).a();
      this.refreshMessageContext.roamMsgFetcher = null;
    }
    if ((this.sessionInfo != null) && (this.sessionInfo.chatBg != null) && (this.sessionInfo.chatBg.a != null))
    {
      this.sessionInfo.chatBg.a.setCallback(null);
      this.sessionInfo.chatBg.a = null;
    }
    if (this.mlightalkTipsBar != null) {
      this.mlightalkTipsBar = null;
    }
    if (this.jdField_a_of_type_Afwr != null) {
      this.jdField_a_of_type_Afwr.c();
    }
    this.i = false;
    ((vzt)this.app.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER)).a();
    if (this.mTitleBtnCall != null) {
      this.mTitleBtnCall.setOnClickListener(null);
    }
    if (this.aioTipsController != null) {
      this.aioTipsController.a(null);
    }
    l();
  }
  
  public void doOnNewIntent_updateBusinessData(Intent paramIntent)
  {
    super.doOnNewIntent_updateBusinessData(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Afwr != null) {
      this.jdField_a_of_type_Afwr.b();
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    this.mScrollerRunnable.a(true);
    if (this.jdField_a_of_type_Afwr != null) {
      this.jdField_a_of_type_Afwr.a();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (bhbx.b(this.sessionInfo.curFriendUin)) {
      ((anqn)this.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).b();
    }
  }
  
  public boolean enableBlur()
  {
    boolean bool = false;
    if ((this.isThemeDefault) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public QQRecorder.RecorderParam getRecorderParam()
  {
    if (this.sessionInfo.curType == 0)
    {
      boolean bool = super.isVoiceChangerPanel();
      return bhhd.a(this.app, bool);
    }
    return new QQRecorder.RecorderParam(bhhd.jdField_a_of_type_Int, 0, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.handleMessage(paramMessage);
    case 70: 
      if (this.jdField_a_of_type_Afwr != null)
      {
        this.jdField_a_of_type_Afwr.a(1);
        return true;
      }
      break;
    case 88: 
      if (this.jdField_a_of_type_Afwr != null)
      {
        this.jdField_a_of_type_Afwr.a(2);
        return true;
      }
      break;
    case 85: 
      int m = paramMessage.arg1;
      paramMessage = this.mRightButtonRedDot;
      if (m == 0) {}
      for (m = 8;; m = 0)
      {
        paramMessage.setVisibility(m);
        return true;
      }
    case 201: 
      if ((this.jdField_a_of_type_Afwr != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof String[])))
      {
        paramMessage = (String[])paramMessage.obj;
        if (paramMessage.length >= 2) {
          this.jdField_a_of_type_Afwr.a(3, paramMessage[0], paramMessage[1]);
        }
        return true;
      }
      break;
    }
    return true;
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void initTipsTaskList()
  {
    super.initTipsTaskList();
    if (this.mlightalkTipsBar == null) {
      this.mlightalkTipsBar = new aikw(this.app, this.mTipsMgr, this.sessionInfo, this.mActivity);
    }
    this.jdField_a_of_type_Aikn = new aikn(this.app, this.mTipsMgr, this.mActivity, this.sessionInfo);
    this.mTipsMgr.a(this.mlightalkTipsBar);
    this.mTipsMgr.a(this.jdField_a_of_type_Aikn);
  }
  
  public boolean isOneWayFriend()
  {
    return this.k;
  }
  
  public void leftBackEvent(boolean paramBoolean)
  {
    if ((this.h) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aigf.a(this.app, this.mActivity, this.sessionInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.tag, 2, "leftBackEvent WpaThirdAppStructMsgUtil return true");
      }
      return;
    }
    if (this.c) {
      h();
    }
    super.leftBackEvent(paramBoolean);
  }
  
  public void onAvatarLongClick()
  {
    super.onAvatarLongClick();
    Object localObject1 = "";
    Object localObject2 = bhaa.a(this.app, this.sessionInfo.curFriendUin);
    if (localObject2 != null) {
      localObject1 = ((Card)localObject2).strReMark;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(this.mContext);
      localObject2 = this.app.getCurrentAccountUin() + "-" + this.sessionInfo.curFriendUin + "-grayTipsRemarkMention";
      if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, false))
      {
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        FriendsStatusUtil.a(this.app, this.sessionInfo.curFriendUin);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.h) && (this.mActivity.getIntent().getStringExtra("callback_type").equals("schemeconfirm")) && (aigf.a(this.app, this.mActivity, this.sessionInfo))) {
      return true;
    }
    if (this.c) {
      h();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    argc localargc;
    if (paramView.getId() == 2131369245)
    {
      localargc = ((argb)aqxe.a().a(551)).a(4);
      if ((localargc != null) && (localargc.d > 0))
      {
        if (localargc.c != 1) {
          break label109;
        }
        ((avwq)this.app.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(this.sessionInfo.curFriendUin), localargc.d, true);
      }
      if ((this.mRightButtonRedDot != null) && (this.mRightButtonRedDot.getVisibility() == 0)) {
        break label117;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label109:
      int m = localargc.d;
      break;
      label117:
      if ((beki.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", true, false)) && (localargc != null) && (localargc.jdField_a_of_type_Boolean)) {
        beki.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_SETTING_RED_DOT_SHOW", false, false);
      }
    }
  }
  
  public void onClickTitleLayout(View paramView)
  {
    if (paramView.getId() == 2131378222)
    {
      if (this.jdField_a_of_type_Int == 1) {
        ((awim)getHelper(32)).b();
      }
      while (this.jdField_a_of_type_Int != 2) {
        return;
      }
      ((agkk)getHelper(43)).a(this.sessionInfo.curFriendUin);
      return;
    }
    super.onClickTitleLayout(paramView);
  }
  
  public View onCreatePanel(int paramInt)
  {
    if (paramInt == 29)
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel = ((BabyQAIOPanel)View.inflate(this.mContext, 2131558601, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a(this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openBabyQPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel;
    }
    return super.onCreatePanel(paramInt);
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
    if (((Integer)paramObject).intValue() == 29)
    {
      this.root.a(29);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
      }
      bdla.b(this.app, "dc00898", "", "", "0X800806C", "0X800806C", 0, 0, "", "", "", "");
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    if (nut.b(this.sessionInfo.curFriendUin)) {
      this.jdField_a_of_type_Bjxa = ((bjxa)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    axna.a(this.app, this.sessionInfo, this);
    g();
    if (bhbx.b(this.sessionInfo.curFriendUin))
    {
      localObject = (anqn)this.app.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if ((localObject != null) && (((anqn)localObject).a(this.mContext, this.app.getCurrentAccountUin())))
      {
        this.root.a(29);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
        ((anqn)localObject).a(this.mContext, this.app.getCurrentAccountUin(), false);
      }
    }
    if (((this instanceof ahyl)) || (nut.b(this.sessionInfo.curFriendUin)))
    {
      showC2BTips();
      if (this.jdField_a_of_type_Bjxa != null) {
        break label243;
      }
    }
    label243:
    for (Object localObject = "";; localObject = this.jdField_a_of_type_Bjxa.a(this.sessionInfo.curFriendUin))
    {
      bdla.b(this.app, "dc00899", "Qidian", this.sessionInfo.curFriendUin, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.4.10", "");
      ThreadManager.post(new FriendChatPie.20(this), 5, null, true);
      bbww.b(this, this.mActivity.getIntent());
      j();
      k();
      return;
    }
  }
  
  public void onShowSubTitleText(boolean paramBoolean, String paramString)
  {
    bbss localbbss = (bbss)getHelper(45);
    if ((localbbss != null) && (localbbss.a(paramBoolean, paramString))) {
      return;
    }
    getActivity().runOnUiThread(new FriendChatPie.25(this, paramString, paramBoolean));
  }
  
  public void onShow_business()
  {
    bhhy.a(null, "AIO_onShow_business");
    super.onShow_business();
    this.h = this.mActivity.getIntent().getBooleanExtra("from3rdApp", false);
    this.g = aigf.a(this.app, this.sessionInfo, this.mActivity.getIntent());
    bhhy.a("AIO_onShow_business", null);
    if ((this.sessionInfo.curType == 1024) && (!nwu.a(this.app, this.app.getCurrentAccountUin(), this.sessionInfo.curType))) {}
  }
  
  public void onShow_otherThings()
  {
    boolean bool1;
    if ((!this.friendListHandler.isGetOnlineListRecently()) && (!this.friendListHandler.shouldGetOnlineInfo())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      String str;
      if (!bool1)
      {
        bool2 = bhmx.a().a(this.sessionInfo.curFriendUin);
        if (QLog.isDevelopLevel())
        {
          QLog.d("CustomOnlineStatusManager", 4, "not update friend online info\nisGetOnlineListRecently = " + this.friendListHandler.isGetOnlineListRecently() + "\nshouldGetOnlineInfo = " + this.friendListHandler.shouldGetOnlineInfo());
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bool2) {
            break label292;
          }
          str = "need update online status";
          QLog.d("CustomOnlineStatusManager", 4, str + " for " + this.sessionInfo.curFriendUin);
        }
      }
      if (bool2) {}
      try
      {
        this.friendListHandler.getOnlineInfo(this.sessionInfo.curFriendUin, false);
        if (this.j)
        {
          this.j = false;
          ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
        }
        super.onShow_otherThings();
        if (!((aizi)this.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.sessionInfo.curType, this.sessionInfo.curFriendUin))
        {
          admh.a(this.app, this.sessionInfo, false);
          admh.b(this.app, this.sessionInfo, false);
          admh.b(this.app, this.sessionInfo);
          admh.c(this.app, this.sessionInfo);
          admh.d(this.app, this.sessionInfo);
        }
        f();
        return;
        bool1 = false;
        continue;
        label292:
        str = "not need update online status";
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.tag, 2, "friendchatpie onShow_otherThings, " + localNumberFormatException.toString());
          }
        }
      }
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "FriendChatPie onViewCompleteVisableAndReleased");
    }
    if (((this.listAdapter != null) && (this.listAdapter.getCount() > 0)) || (!bhbx.b(this.sessionInfo.curFriendUin)))
    {
      if (this.jdField_a_of_type_Acmm.jdField_b_of_type_Boolean)
      {
        this.pullReqTime = SystemClock.uptimeMillis();
        ((afrc)this.refreshMessageContext.context).a(this.pullReqTime);
        this.refreshMessageContext.needAutoNavigateTop = true;
        this.app.getMessageFacade().getC2CMessageManager().a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, this.refreshMessageContext, this.jdField_a_of_type_Acmm, this.mActivity);
        this.jdField_a_of_type_Acmm.jdField_b_of_type_Boolean = false;
        return true;
      }
      super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
      return true;
    }
    setOverScrollHandleVisable(false);
    return true;
  }
  
  public void refreshTitleReativeIcon()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.tag, 2, "==refreshTitleReativeIcon==");
    }
    a();
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Auzh);
    if (this.jdField_a_of_type_Bcwb != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Bcwb);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Ayrc);
    this.app.removeObserver(this.jdField_a_of_type_Aoec);
    this.app.removeObserver(this.jdField_a_of_type_Bjyh);
    ((avhf)this.app.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.app.removeObserver(this.jdField_a_of_type_Anqs);
    this.app.removeObserver(this.jdField_a_of_type_Beci);
  }
  
  public void send()
  {
    super.send();
    if (this.g)
    {
      aigf.a(this.app, this.mActivity, this.sessionInfo, this.g);
      this.g = false;
    }
    if (this.i)
    {
      this.i = false;
      this.app.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    super.send(paramEmoticonInfo);
    if (this.g)
    {
      aigf.a(this.app, this.mActivity, this.sessionInfo, this.g);
      this.g = false;
    }
    if (this.i)
    {
      this.i = false;
      this.app.reportClickEvent("CliOper", "", "", "0X8008073", "0X8008073", 0, 0, "", "", "", "");
    }
  }
  
  public void setLeftTitleToCancle(ChatMessage paramChatMessage)
  {
    super.setLeftTitleToCancle(paramChatMessage);
    this.mTitleBtnRightSearch.setVisibility(0);
  }
  
  public void setSubTitleText(String paramString)
  {
    avrg localavrg = (avrg)getHelper(16);
    if (localavrg != null) {
      localavrg.a(paramString);
    }
  }
  
  public void setTag()
  {
    this.tag = "FriendChatPie";
  }
  
  public void showZhituAfterDraft()
  {
    showZhituIcon();
  }
  
  public boolean showorhideAddFriend()
  {
    return isOneWayFriend();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof MessageForPokeEmo))
    {
      localObject = (MessageForPokeEmo)paramObject;
      if ((((MessageForPokeEmo)localObject).frienduin.equals(this.sessionInfo.curFriendUin)) && (((MessageForPokeEmo)localObject).isread)) {
        ((MessageForPokeEmo)localObject).setIsNeedPlayed(true);
      }
    }
    a(paramObject);
    if (((paramObject instanceof ChatMessage)) && (isActivityResume()))
    {
      localObject = (MessageRecord)paramObject;
      if ((((MessageRecord)localObject).istroop == 0) && (((MessageRecord)localObject).frienduin.equals(this.sessionInfo.curFriendUin)) && (this.d)) {
        axna.b(this.app, this.sessionInfo, this);
      }
    }
    super.update(paramObservable, paramObject);
    c(paramObject);
    admh.a(this, this.app, this.sessionInfo, false);
    b(paramObject);
  }
  
  public void updateListUnRead(int paramInt)
  {
    super.updateListUnRead(paramInt);
    agkb localagkb = (agkb)getHelper(52);
    if (localagkb != null) {
      localagkb.a(this.mContent);
    }
  }
  
  public void updateOnlineStatus()
  {
    if (((awim)getHelper(32)).c()) {
      if (QLog.isColorLevel()) {
        QLog.i(this.tag, 2, "updateOnlineStatus, isListenTogetherTime");
      }
    }
    do
    {
      return;
      if (!((agkk)getHelper(43)).c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(this.tag, 2, "updateOnlineStatus, isTogetherTime");
    return;
    if ((this.sessionInfo.isQimUserOnline) && (this.sessionInfo.isQimUserOnlineIcon))
    {
      d();
      return;
    }
    if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm))
    {
      e();
      return;
    }
    this.mSubTilteText.setTextColor(getActivity().getResources().getColor(2131167023));
    this.mSubTitleText2.setTextColor(getActivity().getResources().getColor(2131167023));
    this.mSubTilteText.setCompoundDrawables(null, null, null, null);
    if ((bhmx.a().a()) || (azbj.a().a(this.app, this.sessionInfo.curFriendUin))) {
      this.mSubTilteText.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("CustomOnlineStatusManager", 4, "setOnClickListener");
      }
      if ((!this.showOnlineStatus) || ((this.jdField_a_of_type_Bjxa != null) && (this.jdField_a_of_type_Bjxa.a(this.sessionInfo.curFriendUin))) || (isPublicChatActivity())) {
        break;
      }
      c();
      return;
      this.mSubTilteText.setOnClickListener(null);
    }
  }
  
  public void updateSession(Intent paramIntent)
  {
    super.updateSession(paramIntent);
    if (!bhbx.b(this.sessionInfo.curFriendUin)) {
      this.refreshMessageContext.roamMsgFetcher = new aigi(this.app, this.mActivity, this.sessionInfo.curFriendUin);
    }
    if ((this.jdField_a_of_type_Bjxa != null) && (this.jdField_a_of_type_Bjxa.a.containsKey(this.sessionInfo.curFriendUin))) {
      this.jdField_a_of_type_Bjxa.a(this.sessionInfo.curFriendUin, true);
    }
    if ((this.jdField_a_of_type_Bjxa != null) && (this.jdField_a_of_type_Bjxa.a(this.sessionInfo.curFriendUin)))
    {
      nwu.c(this.app, this.mContext, this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin);
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.sessionInfo.curFriendUin);
    }
    ThreadManager.post(new FriendChatPie.19(this), 5, null, false);
  }
  
  public void updateSession_business(Intent paramIntent)
  {
    super.updateSession_business(paramIntent);
    this.e = false;
  }
  
  public void updateSession_updateSubTitle()
  {
    if ((this.jdField_a_of_type_Bjxa != null) && (this.jdField_a_of_type_Bjxa.b(this.sessionInfo.curFriendUin, false))) {
      this.mSingleTitle = true;
    }
    updateOnlineStatus();
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    super.updateSession_updateTitle(paramIntent);
    a();
    VipUtils.a(this.app, this.sessionInfo.curFriendUin, this.mCustomTitleView, this.mTitleIconRight, this.isJubaoMode);
    this.mTitleText.setOnClickListener(new agak(this));
  }
  
  public void updateSession_updateTitleBtnCall()
  {
    int m;
    if ((!bhbx.b(this.sessionInfo.curFriendUin)) && (!this.app.getCurrentUin().equals(this.sessionInfo.curFriendUin))) {
      m = 1;
    }
    while (m != 0)
    {
      this.mTitleBtnCall.setOnClickListener(new agar(this));
      if (mbl.a().a(this.app.getCurrentAccountUin()))
      {
        this.mTitleBtnCall.setVisibility(0);
        this.mTitleBtnCall.setContentDescription(this.mActivity.getResources().getString(2131698258));
        return;
        m = 0;
      }
      else
      {
        this.mTitleBtnCall.setVisibility(8);
        return;
      }
    }
    this.mTitleBtnCall.setVisibility(4);
    ThreadManager.post(new FriendChatPie.7(this), 5, null, false);
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    long l1 = System.currentTimeMillis();
    if ((this.sessionInfo.isQimUserOnline) && (this.sessionInfo.isQimUserTitleForm) && (!this.sessionInfo.isNightMode))
    {
      bdla.b(this.app, "CliOper", "", "", "0X80085A4", "0X80085A4", 1, 0, "", "", "", "");
      this.mCustomTitleView.setBackgroundDrawable(ahwv.a().a(2130850109));
      this.mCustomTitleView.setRight1Icon(2130850150);
      this.mCustomTitleView.a(2130850728);
      if (this.qimRealAddView != null)
      {
        this.qimRealAddView.setVisibility(0);
        this.qimRealAddView.setBackgroundDrawable(ahwv.a().b(2));
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("shinkencai", 2, "set title time:" + (l2 - l1));
      return;
      this.qimRealAddView = this.addView.inflate();
      this.qimRealAddView.setBackgroundDrawable(ahwv.a().b(2));
      continue;
      if ((this.sessionInfo.isTimUserOnline) && (this.sessionInfo.isTimUserTitleForm) && (!this.sessionInfo.isNightMode))
      {
        this.mCustomTitleView.setBackgroundDrawable(aijq.a().a(2130850109));
        this.mCustomTitleView.setRight1Icon(2130850150);
        this.mCustomTitleView.a(2130850728);
        if (this.timRealAddView != null)
        {
          this.timRealAddView.setVisibility(0);
          this.timRealAddView.setBackgroundDrawable(aijq.a().b(2));
        }
        else
        {
          this.timRealAddView = this.addView.inflate();
          this.timRealAddView.setBackgroundDrawable(aijq.a().b(2));
        }
      }
      else
      {
        this.mCustomTitleView.setBackgroundResource(2130850109);
        this.mCustomTitleView.setRight1Icon(2130850149, 2130850150);
        this.mCustomTitleView.a(2130850727, 2130850728);
        if (this.addView != null) {
          this.addView.setVisibility(8);
        }
        if (this.qimRealAddView != null) {
          this.qimRealAddView.setVisibility(8);
        }
        if (this.timRealAddView != null) {
          this.timRealAddView.setVisibility(8);
        }
      }
    }
  }
  
  public void updateUI_titleBarForTheme()
  {
    super.updateUI_titleBarForTheme();
    if (bdfk.b())
    {
      QLog.d(this.tag, 1, "FriendChatPie updateUI_titleBarForTheme, SimpleUIMode is open now");
      return;
    }
    switch (VipUtils.a(this.app, this.sessionInfo.curFriendUin, false))
    {
    default: 
      return;
    }
    try
    {
      this.mTitleText.setTextColor(this.mContext.getResources().getColor(2131167170));
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.tag, 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agab
 * JD-Core Version:    0.7.0.1
 */