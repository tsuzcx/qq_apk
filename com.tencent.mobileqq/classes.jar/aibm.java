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
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.10;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5;
import com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.9;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
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

public class aibm
  extends beot
  implements View.OnClickListener, azwh, begh, beno
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131625931 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839215 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131304236 };
  private final int jdField_a_of_type_Int = 0;
  ajhi jdField_a_of_type_Ajhi = new aibu(this);
  private ajjh jdField_a_of_type_Ajjh = new aibs(this);
  private ajjj jdField_a_of_type_Ajjj;
  private ajmm jdField_a_of_type_Ajmm = new aibt(this);
  private ajph jdField_a_of_type_Ajph;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azwg jdField_a_of_type_Azwg;
  private bbms jdField_a_of_type_Bbms;
  private bens jdField_a_of_type_Bens;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<atcu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<atcu> jdField_a_of_type_JavaUtilComparator = new aibn(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public aibm(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajjj = ((ajjj)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Azwg = new azwg(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajhi, true);
    this.jdField_a_of_type_Bens = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ajph = ((ajph)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new aibp(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.a(1)).h();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131167766);
  }
  
  private View a(Context paramContext, int paramInt, aibv paramaibv)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bens.a(paramContext, localView, paramaibv, -1);
  }
  
  private bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aibo(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(aibv paramaibv)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramaibv.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (atcp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaibv.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramaibv.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramaibv.jdField_b_of_type_Long);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("param_wzry_data", localWZRYUIinfo);
    aezr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(aibv paramaibv, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramaibv.jdField_a_of_type_Long = paramInt;
    paramaibv.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramaibv.jdField_b_of_type_Long = paramLong;
    paramaibv.jdField_a_of_type_Int = 0;
    Object localObject2 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((ajjj)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
    if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark))) {
      localObject1 = ((Friends)localObject2).remark;
    }
    for (;;)
    {
      String str = String.valueOf(paramStructMsg.req_uin.get());
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = str;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramaibv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaibv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!azzz.b(str))) {
          break label605;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841234);
        ((Drawable)localObject1).setBounds(0, 0, aciy.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aciy.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        paramaibv.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aciy.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramaibv.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(paramaibv);
        paramaibv.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaibv);
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        if (paramStructMsg.msg == null) {
          break label1630;
        }
        localObject1 = paramStructMsg.msg.msg_source.get();
        paramInt = paramStructMsg.msg.uint32_source_flag.get();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || ((paramInt & 0x8) != 8)) {
          break label1627;
        }
        paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
        if (paramLong == 0L) {
          break label1627;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1627;
        }
        localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject1, localObject2 });
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramaibv.d.setText(String.format(Locale.getDefault(), ajjy.a(2131641705), new Object[] { localObject1 }));
          paramaibv.d.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            paramaibv.c.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setTag(paramaibv);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          return;
          paramaibv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label605:
          paramaibv.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label259;
          paramaibv.d.setVisibility(8);
          break label441;
          label631:
          paramaibv.c.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          paramaibv.c.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaibv.e.setVisibility(8);
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaibv);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramaibv.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaibv.e.setText(paramStructMsg);
              paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramaibv.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaibv.e.setText(paramStructMsg);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaibv);
          continue;
          paramaibv.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaibv.e.setText(paramStructMsg);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaibv);
          continue;
          paramaibv.e.setVisibility(8);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramaibv.e.setVisibility(8);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramaibv.d.setText(paramStructMsg.msg.msg_additional.get());
            paramaibv.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramaibv.e.setVisibility(8);
            break;
            paramaibv.d.setVisibility(8);
          }
          paramaibv.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaibv.e.setText(paramStructMsg);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaibv);
          continue;
          paramaibv.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaibv.e.setText(paramStructMsg);
          paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaibv.e.setVisibility(8);
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaibv);
            break;
            paramaibv.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaibv.e.setText(paramStructMsg);
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaibv.e.setVisibility(8);
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaibv);
            break;
            paramaibv.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaibv.e.setText(paramStructMsg);
            paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramaibv.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaibv.e.setText(paramStructMsg);
              paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramaibv.e.setVisibility(8);
              paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramaibv.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaibv.e.setText(paramStructMsg);
              paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramaibv.d.setVisibility(8);
            }
          }
        }
        label1627:
        continue;
        label1630:
        localObject1 = null;
      }
    }
  }
  
  private void a(aibv paramaibv, PhoneContactAdd paramPhoneContactAdd)
  {
    paramaibv.jdField_a_of_type_Int = 1;
    paramaibv.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramaibv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaibv.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramaibv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaibv.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramaibv.c.setVisibility(0);
      paramaibv.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramaibv.e.setVisibility(0);
      paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramaibv.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131652918));
      paramaibv.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramaibv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramaibv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramaibv.c.setVisibility(8);
    }
  }
  
  private void a(aibv paramaibv, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramaibv.jdField_a_of_type_Int = 2;
    paramaibv.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramaibv.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    aeyf.a(paramaibv.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((ajph)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramaibv.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajjy.a(2131641719), new Object[] { localObject });
      paramaibv.d.setText((CharSequence)localObject);
      paramaibv.d.setVisibility(0);
      paramaibv.e.setVisibility(8);
      paramaibv.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131641707));
      paramaibv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramaibv.jdField_a_of_type_AndroidWidgetButton.setTag(paramaibv);
      paramaibv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramaibv.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramaibv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramaibv.c.setVisibility(0);
      paramaibv.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {}
    for (int i = this.jdField_a_of_type_Bens.a(paramContext, paramView, paramInt, paramObject, parambent, paramOnClickListener);; i = 0)
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
      axcy.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      axcy.a().b(l);
      axcy.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return amhh.a().a();
  }
  
  private void b()
  {
    babr.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131633760), null, 2131625035, 2131633759, new aibq(this), new aibr(this)).show();
  }
  
  private void b(aibv paramaibv)
  {
    if (paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844934);
        j = 0;
        i = 0;
        m = i;
        if (paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramaibv.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130844933;
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844934);
        i = 1;
        break;
        j = 2130844931;
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130844932);
        i = 1;
        break;
        label205:
        paramaibv.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramaibv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!badq.g(this.jdField_a_of_type_AndroidAppActivity)) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131626719), 0).b(a());
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
            if (azzz.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof atcu));
      paramView = (atcu)paramView;
      if ((paramView instanceof atcp))
      {
        paramView = (atcp)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof atdd))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof atdf));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(aibv paramaibv)
  {
    if ((paramaibv == null) || (paramaibv.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((ajjj)localObject1).b(String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Azwg.a(32, String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Azwg.a())
          {
            this.jdField_a_of_type_Azwg.a(String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bacm.a();
        }
        paramaibv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Azwg.a(1, String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Azwg.a())
          {
            this.jdField_a_of_type_Azwg.a(String.valueOf(paramaibv.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bbms.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131653452));
    this.jdField_a_of_type_Bbms.show();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    this.jdField_a_of_type_Bbms = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131495539, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131310915);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839104);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131310916));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, bajq.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839101);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131495536, null);
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
        if (!badq.g(BaseApplication.getContext()))
        {
          bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131626719), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajed.M, 0);
      } while ((localList == null) || (localList.size() < 20) || (axcy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().g();
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
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, paramInt, true, (byte)0);
    }
    return bacm.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajhi);
    this.jdField_a_of_type_Azwg.a(null);
    this.jdField_a_of_type_Azwg.d();
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
  
  public void e() {}
  
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
    boolean bool;
    if (paramView == null)
    {
      paramViewGroup = new aibv();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131495535, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305159));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296655));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131309446));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131310547));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131309433));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131309443));
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setTag(paramViewGroup);
      paramViewGroup.g.setOnClickListener(this);
      localObject = (atcu)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, paramViewGroup, this);
      View localView = paramViewGroup.g;
      if (((atcu)localObject).a()) {
        break label263;
      }
      bool = true;
      label206:
      aeyf.a(localView, bool);
      if (!(localObject instanceof atcp)) {
        break label269;
      }
      localObject = ((atcp)getItem(paramInt)).a;
      a(paramViewGroup, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    label263:
    label269:
    do
    {
      return paramView;
      paramViewGroup = (aibv)paramView.getTag();
      break;
      bool = false;
      break label206;
      if ((localObject instanceof atdd))
      {
        a(paramViewGroup, ((atdd)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
        return paramView;
      }
    } while (!(localObject instanceof atdf));
    Object localObject = ((atdf)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
    paramViewGroup.g.setClickable(false);
    a(paramViewGroup, (QIMNotifyAddFriend)localObject);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      b(paramView);
    case 2131309584: 
    case 2131309433: 
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
                paramView = paramView.getTag();
              } while ((paramView == null) || (!(paramView instanceof aibv)));
              paramView = (aibv)paramView;
              if (paramView.jdField_a_of_type_Int != 0) {
                break;
              }
            } while (paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
            a(paramView);
            switch (paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
            {
            default: 
              return;
            case 1: 
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              return;
            case 2: 
            case 3: 
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              return;
            case 13: 
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              return;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
            return;
          } while (paramView.jdField_a_of_type_Int != 1);
          localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd;
        } while (localObject == null);
        if (((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).h()) {}
        for (paramView = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject).unifiedCode, 34);; paramView = new ProfileActivity.AllInOne(((PhoneContactAdd)localObject).unifiedCode, 29))
        {
          paramView.h = ((PhoneContactAdd)localObject).name;
          ProfileActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramView);
          return;
        }
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof aibv)));
      if (!badq.g(this.jdField_a_of_type_AndroidAppActivity))
      {
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131626719), 0).b(a());
        return;
      }
      paramView = (aibv)paramView;
      if (paramView.jdField_a_of_type_Int != 2)
      {
        a((structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.jdField_b_of_type_Long);
        long l1 = axcy.a().b();
        paramView = axcy.a().a(Long.valueOf(l1));
        int i;
        if (paramView != null)
        {
          i = paramView.msg_type.get();
          l1 = paramView.msg_seq.get();
          long l2 = paramView.req_uin.get();
          j = paramView.msg.sub_type.get();
          int k = paramView.msg.src_id.get();
          int m = paramView.msg.sub_src_id.get();
          int n = paramView.msg.group_msg_type.get();
          localObject = paramView.msg.actions.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
            i = 1;
            j = i;
            if (azzz.b(String.valueOf(l2))) {
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j != 0) {
            d();
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
          return;
          paramView = new StringBuilder().append("agree, ");
          if (localObject != null) {}
          for (i = ((List)localObject).size();; i = -1)
          {
            QLog.d("NewFriendMoreSysMsgAdapter", 1, i);
            i = 0;
            break;
          }
          QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
        }
      }
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidAppActivity, null);
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, NewFriendMoreSysMsgSuspiciousFragment.class);
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
        if ((paramString != null) && ((paramString instanceof aibv)))
        {
          paramString = (aibv)paramString;
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
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
      return;
    }
    if (this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof aibv))
      {
        paramAbsListView = (aibv)paramAbsListView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aibm
 * JD-Core Version:    0.7.0.1
 */