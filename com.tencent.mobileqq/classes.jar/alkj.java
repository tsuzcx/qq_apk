import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class alkj
  extends bjuw
  implements View.OnClickListener, bjtu, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691363 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839549 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370711 };
  private final int jdField_a_of_type_Int = 0;
  amrc jdField_a_of_type_Amrc = new alkr(this);
  private amsu jdField_a_of_type_Amsu = new alkp(this);
  private amsw jdField_a_of_type_Amsw;
  private amwl jdField_a_of_type_Amwl = new alkq(this);
  private amyk jdField_a_of_type_Amyk;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhht jdField_a_of_type_Bhht;
  private bjty jdField_a_of_type_Bjty;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public QQAppInterface a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<aigo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<aigo> jdField_a_of_type_JavaUtilComparator = new alkk(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public alkj(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amwl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amrc, true);
    this.jdField_a_of_type_Bjty = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Amyk = ((amyk)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new alkm(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).getSuspiciousFriendsUnreadNum();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299076);
  }
  
  private View a(Context paramContext, int paramInt, alks paramalks)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bjty.a(paramContext, localView, paramalks, -1);
  }
  
  private bjty a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298791);
    int j = paramContext.getResources().getDimensionPixelSize(2131298792);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new alkl(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(alks paramalks)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramalks.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (aigj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramalks.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramalks.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramalks.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    case 2: 
    case 3: 
      aift.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    aift.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(alks paramalks, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    String str = null;
    paramalks.jdField_a_of_type_Long = paramInt;
    paramalks.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramalks.jdField_b_of_type_Long = paramLong;
    paramalks.jdField_a_of_type_Int = 0;
    Object localObject1 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2;
    if (paramStructMsg.msg != null)
    {
      localObject2 = paramStructMsg.msg.req_uin_nick.get();
      Object localObject3 = ((amsw)localObject1).a(String.valueOf(paramStructMsg.req_uin.get()));
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
          localObject1 = ((Friends)localObject3).remark;
        }
      }
      localObject3 = String.valueOf(paramStructMsg.req_uin.get());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = localObject3;
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label603;
      }
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      label173:
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!bftf.b((String)localObject3))) {
        break label615;
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841793);
      ((Drawable)localObject1).setBounds(0, 0, AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      label277:
      c(paramalks);
      paramalks.jdField_a_of_type_AndroidWidgetImageView.setTag(paramalks);
      paramalks.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = str;
      if (paramStructMsg.msg != null)
      {
        localObject2 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if ((paramInt & 0x8) == 8)
          {
            paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
            localObject1 = localObject2;
            if (paramLong != 0L)
            {
              str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(str)) {
                localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject2, str });
              }
            }
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label629;
      }
      paramalks.d.setText(String.format(Locale.getDefault(), amtj.a(2131706613), new Object[] { localObject1 }));
      paramalks.d.setVisibility(0);
      label479:
      if (paramStructMsg.msg != null)
      {
        paramalks.c.setText(aigj.a(this.jdField_a_of_type_AndroidAppActivity, paramStructMsg));
        switch (paramStructMsg.msg.sub_type.get())
        {
        }
      }
    }
    for (;;)
    {
      paramalks.jdField_a_of_type_AndroidWidgetButton.setTag(paramalks);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      localObject2 = null;
      break;
      label603:
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label173;
      label615:
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      break label277;
      label629:
      paramalks.d.setVisibility(8);
      break label479;
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramalks.e.setVisibility(8);
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramalks.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramalks);
        break;
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
        {
          paramalks.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramalks.e.setText(paramStructMsg);
          paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      paramalks.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramalks.e.setText(paramStructMsg);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramalks);
      continue;
      paramalks.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramalks.e.setText(paramStructMsg);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramalks);
      continue;
      paramalks.e.setVisibility(8);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      paramalks.e.setVisibility(8);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
      {
        paramalks.d.setText(paramStructMsg.msg.msg_additional.get());
        paramalks.c.setText(paramStructMsg.msg.msg_describe.get());
      }
      for (;;)
      {
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramalks.e.setVisibility(8);
        break;
        paramalks.d.setVisibility(8);
      }
      paramalks.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramalks.e.setText(paramStructMsg);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      b(paramalks);
      continue;
      paramalks.e.setVisibility(0);
      paramStructMsg = paramStructMsg.msg.msg_decided.get();
      paramalks.e.setText(paramStructMsg);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramalks.e.setVisibility(8);
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramalks.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramalks);
        break;
        paramalks.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramalks.e.setText(paramStructMsg);
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
      {
        paramalks.e.setVisibility(8);
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
        paramalks.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
      for (;;)
      {
        b(paramalks);
        break;
        paramalks.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramalks.e.setText(paramStructMsg);
        paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramStructMsg.msg.reqsubtype.has()) {
        if (paramStructMsg.msg.reqsubtype.get() == 1)
        {
          paramalks.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramalks.e.setText(paramStructMsg);
          paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else if (paramStructMsg.msg.reqsubtype.get() == 2)
        {
          paramalks.e.setVisibility(8);
          paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramalks.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramalks.e.setText(paramStructMsg);
          paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramalks.d.setVisibility(8);
        }
      }
    }
  }
  
  private void a(alks paramalks, PhoneContactAdd paramPhoneContactAdd)
  {
    paramalks.jdField_a_of_type_Int = 1;
    paramalks.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramalks.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramalks.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramalks.c.setVisibility(0);
      paramalks.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramalks.e.setVisibility(0);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramalks.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131717690));
      paramalks.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramalks.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramalks.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramalks.c.setVisibility(8);
    }
  }
  
  private void a(alks paramalks, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramalks.jdField_a_of_type_Int = 2;
    paramalks.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramalks.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    aiea.a(paramalks.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((amyk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramalks.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), amtj.a(2131706627), new Object[] { localObject });
      paramalks.d.setText((CharSequence)localObject);
      paramalks.d.setVisibility(0);
      paramalks.e.setVisibility(8);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131706615));
      paramalks.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setTag(paramalks);
      paramalks.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramalks.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramalks.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramalks.c.setVisibility(0);
      paramalks.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bjtz parambjtz, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bjty != null) {}
    for (int i = this.jdField_a_of_type_Bjty.a(paramContext, paramView, paramInt, paramObject, parambjtz, paramOnClickListener);; i = 0)
    {
      if (this.jdField_b_of_type_Int != -1)
      {
        if (paramInt != this.jdField_b_of_type_Int) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bcsy.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bcsy.a().b(l);
      bcsy.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return aqes.a().a();
  }
  
  private void b()
  {
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131698635), null, 2131690620, 2131698634, new alkn(this), new alko(this)).show();
  }
  
  private void b(alks paramalks)
  {
    if (paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845771);
        j = 0;
        i = 0;
        m = i;
        if (paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramalks.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845770;
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845771);
        i = 1;
        break;
        j = 2130845768;
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845769);
        i = 1;
        break;
        label205:
        paramalks.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramalks.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692035), 0).b(a());
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
            return;
            if (bftf.a("tag_swip_icon_menu_item", paramView.getTag())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick tag is not int");
          return;
          localObject = paramView.getTag(-1);
          paramView = paramView.getTag(-2);
          if (((localObject instanceof Integer)) && ((paramView instanceof Integer))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
        return;
        int i = ((Integer)localObject).intValue();
        if (QLog.isColorLevel()) {
          QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick position = " + i);
        }
        paramView = getItem(i);
      } while (!(paramView instanceof aigo));
      paramView = (aigo)paramView;
      if ((paramView instanceof aigj))
      {
        paramView = (aigj)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof aigx))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof aigz));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(alks paramalks)
  {
    if ((paramalks == null) || (paramalks.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((amsw)localObject1).b(String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bfvo.a();
        }
        paramalks.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(String.valueOf(paramalks.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bhht == null) {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bhht.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131718142));
    this.jdField_a_of_type_Bhht.show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
    this.jdField_a_of_type_Bhht = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561483, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131378027);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839437);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378028));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, ViewUtils.dip2px(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839434);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561480, null);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      List localList;
      do
      {
        return;
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692035), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
      } while ((localList == null) || (localList.size() < 20) || (bcsy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().g();
    } while (!QLog.isColorLevel());
    QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
    }
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return bfvo.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amsu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amwl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amrc);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
      this.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void f() {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return new Object();
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    alks localalks;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      localalks = new alks();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561479, localalks);
      localalks.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localalks.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371791));
      localalks.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362305));
      localalks.c = ((TextView)paramView.findViewById(2131376354));
      localalks.d = ((TextView)paramView.findViewById(2131377631));
      localalks.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376341));
      localalks.e = ((TextView)paramView.findViewById(2131376351));
      if ((localalks.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localalks.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
      }
      paramView.setTag(localalks);
      localalks.g.setTag(localalks);
      localalks.g.setOnClickListener(this);
      localObject = (aigo)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, localalks, this);
      View localView = localalks.g;
      if (((aigo)localObject).a()) {
        break label296;
      }
      bool = true;
      label223:
      aiea.a(localView, bool);
      if (!(localObject instanceof aigj)) {
        break label302;
      }
      localObject = ((aigj)getItem(paramInt)).a;
      a(localalks, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localalks = (alks)paramView.getTag();
      break;
      label296:
      bool = false;
      break label223;
      label302:
      if ((localObject instanceof aigx))
      {
        a(localalks, ((aigx)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
      }
      else if ((localObject instanceof aigz))
      {
        localObject = ((aigz)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
        localalks.g.setClickable(false);
        a(localalks, (QIMNotifyAddFriend)localObject);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      b(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof alks)))
      {
        localObject1 = (alks)localObject1;
        if (((alks)localObject1).jdField_a_of_type_Int == 0)
        {
          if (((alks)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
          {
            a((alks)localObject1);
            switch (((alks)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
            {
            default: 
              break;
            case 1: 
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              break;
            case 2: 
            case 3: 
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              break;
            case 13: 
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              break;
            case 6: 
              bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
              break;
            }
          }
        }
        else if (((alks)localObject1).jdField_a_of_type_Int == 1)
        {
          Object localObject2 = ((alks)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
          if (localObject2 != null)
          {
            if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i()) {}
            for (localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29))
            {
              ((ProfileActivity.AllInOne)localObject1).h = ((PhoneContactAdd)localObject2).name;
              ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, (ProfileActivity.AllInOne)localObject1);
              break;
            }
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof alks))) {
              if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
              {
                QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692035), 0).b(a());
              }
              else
              {
                localObject1 = (alks)localObject1;
                if (((alks)localObject1).jdField_a_of_type_Int != 2)
                {
                  a((structmsg.StructMsg)((alks)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((alks)localObject1).jdField_b_of_type_Long);
                  long l1 = bcsy.a().b();
                  localObject1 = bcsy.a().a(Long.valueOf(l1));
                  int i;
                  if (localObject1 != null)
                  {
                    i = ((structmsg.StructMsg)localObject1).msg_type.get();
                    l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                    long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                    j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                    int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                    int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                    int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                    localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                    if ((localObject2 != null) && (((List)localObject2).size() > 0))
                    {
                      localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                      ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                      ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                      structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                      localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                      localAddFrdSNInfo.uint32_set_sn.set(0);
                      ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                      i = 1;
                      j = i;
                      if (bftf.b(String.valueOf(l2))) {
                        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                      }
                    }
                  }
                  for (int j = i;; j = 0)
                  {
                    if (j != 0) {
                      d();
                    }
                    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
                    break;
                    localObject1 = new StringBuilder().append("agree, ");
                    if (localObject2 != null) {}
                    for (i = ((List)localObject2).size();; i = -1)
                    {
                      QLog.d("NewFriendMoreSysMsgAdapter", 1, i);
                      i = 0;
                      break;
                    }
                    QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                  }
                }
                ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidAppActivity, null);
                continue;
                if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
                  this.jdField_a_of_type_AndroidWidgetTextView.setText("");
                }
                bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
                ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
                PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, NewFriendMoreSysMsgSuspiciousFragment.class);
              }
            }
          }
        }
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof alks)))
        {
          paramString = (alks)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_Int == getCount())) {
      i();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof alks))
      {
        paramAbsListView = (alks)paramAbsListView;
        if (paramAbsListView.jdField_a_of_type_Int != 0) {
          break label118;
        }
        c(paramAbsListView);
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label70;
      break;
      label118:
      if (paramAbsListView.jdField_a_of_type_Int == 1) {
        paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramAbsListView.jdField_a_of_type_JavaLangString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkj
 * JD-Core Version:    0.7.0.1
 */