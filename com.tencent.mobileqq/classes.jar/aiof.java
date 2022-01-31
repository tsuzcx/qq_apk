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

public class aiof
  extends bfwn
  implements View.OnClickListener, baxl, bfob, bfvi
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691507 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839239 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131369915 };
  private final int jdField_a_of_type_Int = 0;
  ajvl jdField_a_of_type_Ajvl = new aion(this);
  private ajxl jdField_a_of_type_Ajxl = new aiol(this);
  private ajxn jdField_a_of_type_Ajxn;
  private akav jdField_a_of_type_Akav = new aiom(this);
  private akdr jdField_a_of_type_Akdr;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private baxk jdField_a_of_type_Baxk;
  private bcpq jdField_a_of_type_Bcpq;
  private bfvm jdField_a_of_type_Bfvm;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<atyy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<atyy> jdField_a_of_type_JavaUtilComparator = new aiog(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public aiof(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajxn = ((ajxn)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Baxk = new baxk(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akav);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvl, true);
    this.jdField_a_of_type_Bfvm = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Akdr = ((akdr)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new aioi(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.a(1)).h();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865);
  }
  
  private View a(Context paramContext, int paramInt, aioo paramaioo)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bfvm.a(paramContext, localView, paramaioo, -1);
  }
  
  private bfvm a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aioh(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(aioo paramaioo)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramaioo.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (atyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaioo.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
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
        Object localObject2 = paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramaioo.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramaioo.jdField_b_of_type_Long);
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
    aflh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(aioo paramaioo, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramaioo.jdField_a_of_type_Long = paramInt;
    paramaioo.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramaioo.jdField_b_of_type_Long = paramLong;
    paramaioo.jdField_a_of_type_Int = 0;
    Object localObject2 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((ajxn)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
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
        paramaioo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaioo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!bbbd.b(str))) {
          break label605;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841313);
        ((Drawable)localObject1).setBounds(0, 0, actn.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actn.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        paramaioo.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actn.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramaioo.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(paramaioo);
        paramaioo.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaioo);
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramaioo.d.setText(String.format(Locale.getDefault(), ajyc.a(2131707490), new Object[] { localObject1 }));
          paramaioo.d.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            paramaioo.c.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setTag(paramaioo);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          return;
          paramaioo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label605:
          paramaioo.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label259;
          paramaioo.d.setVisibility(8);
          break label441;
          label631:
          paramaioo.c.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          paramaioo.c.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaioo.e.setVisibility(8);
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaioo);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramaioo.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaioo.e.setText(paramStructMsg);
              paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramaioo.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaioo.e.setText(paramStructMsg);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaioo);
          continue;
          paramaioo.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaioo.e.setText(paramStructMsg);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaioo);
          continue;
          paramaioo.e.setVisibility(8);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramaioo.e.setVisibility(8);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramaioo.d.setText(paramStructMsg.msg.msg_additional.get());
            paramaioo.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramaioo.e.setVisibility(8);
            break;
            paramaioo.d.setVisibility(8);
          }
          paramaioo.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaioo.e.setText(paramStructMsg);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaioo);
          continue;
          paramaioo.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaioo.e.setText(paramStructMsg);
          paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaioo.e.setVisibility(8);
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaioo);
            break;
            paramaioo.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaioo.e.setText(paramStructMsg);
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaioo.e.setVisibility(8);
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaioo);
            break;
            paramaioo.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaioo.e.setText(paramStructMsg);
            paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramaioo.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaioo.e.setText(paramStructMsg);
              paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramaioo.e.setVisibility(8);
              paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramaioo.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaioo.e.setText(paramStructMsg);
              paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramaioo.d.setVisibility(8);
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
  
  private void a(aioo paramaioo, PhoneContactAdd paramPhoneContactAdd)
  {
    paramaioo.jdField_a_of_type_Int = 1;
    paramaioo.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramaioo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaioo.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramaioo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaioo.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramaioo.c.setVisibility(0);
      paramaioo.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramaioo.e.setVisibility(0);
      paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramaioo.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131718743));
      paramaioo.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramaioo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramaioo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramaioo.c.setVisibility(8);
    }
  }
  
  private void a(aioo paramaioo, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramaioo.jdField_a_of_type_Int = 2;
    paramaioo.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramaioo.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    afjv.a(paramaioo.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((akdr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramaioo.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajyc.a(2131707504), new Object[] { localObject });
      paramaioo.d.setText((CharSequence)localObject);
      paramaioo.d.setVisibility(0);
      paramaioo.e.setVisibility(8);
      paramaioo.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131707492));
      paramaioo.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramaioo.jdField_a_of_type_AndroidWidgetButton.setTag(paramaioo);
      paramaioo.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramaioo.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramaioo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramaioo.c.setVisibility(0);
      paramaioo.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bfvn parambfvn, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfvm != null) {}
    for (int i = this.jdField_a_of_type_Bfvm.a(paramContext, paramView, paramInt, paramObject, parambfvn, paramOnClickListener);; i = 0)
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
      ayda.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      ayda.a().b(l);
      ayda.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return amxl.a().a();
  }
  
  private void b()
  {
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131699542), null, 2131690596, 2131699541, new aioj(this), new aiok(this)).show();
  }
  
  private void b(aioo paramaioo)
  {
    if (paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845021);
        j = 0;
        i = 0;
        m = i;
        if (paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramaioo.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845020;
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845021);
        i = 1;
        break;
        j = 2130845018;
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845019);
        i = 1;
        break;
        label205:
        paramaioo.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramaioo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidAppActivity)) {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
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
            if (bbbd.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof atyy));
      paramView = (atyy)paramView;
      if ((paramView instanceof atyt))
      {
        paramView = (atyt)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof atzh))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof atzj));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(aioo paramaioo)
  {
    if ((paramaioo == null) || (paramaioo.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((ajxn)localObject1).b(String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Baxk.a(32, String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxk.a())
          {
            this.jdField_a_of_type_Baxk.a(String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bbdr.a();
        }
        paramaioo.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Baxk.a(1, String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxk.a())
          {
            this.jdField_a_of_type_Baxk.a(String.valueOf(paramaioo.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bcpq.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131719281));
    this.jdField_a_of_type_Bcpq.show();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.jdField_a_of_type_Bcpq = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561127, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131376723);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839132);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376724));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, bbkx.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839129);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561124, null);
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
        if (!bbev.g(BaseApplication.getContext()))
        {
          bcpw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajsf.M, 0);
      } while ((localList == null) || (localList.size() < 20) || (ayda.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
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
    Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxk.a()) {
      this.jdField_a_of_type_Baxk.a(paramString, paramInt, true, (byte)0);
    }
    return bbdr.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akav);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvl);
    this.jdField_a_of_type_Baxk.a(null);
    this.jdField_a_of_type_Baxk.d();
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
      paramViewGroup = new aioo();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561123, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362196));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131375194));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131376339));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375181));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131375191));
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setTag(paramViewGroup);
      paramViewGroup.g.setOnClickListener(this);
      localObject = (atyy)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, paramViewGroup, this);
      View localView = paramViewGroup.g;
      if (((atyy)localObject).a()) {
        break label263;
      }
      bool = true;
      label206:
      afjv.a(localView, bool);
      if (!(localObject instanceof atyt)) {
        break label269;
      }
      localObject = ((atyt)getItem(paramInt)).a;
      a(paramViewGroup, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    label263:
    label269:
    do
    {
      return paramView;
      paramViewGroup = (aioo)paramView.getTag();
      break;
      bool = false;
      break label206;
      if ((localObject instanceof atzh))
      {
        a(paramViewGroup, ((atzh)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
        return paramView;
      }
    } while (!(localObject instanceof atzj));
    Object localObject = ((atzj)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
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
    case 2131375333: 
    case 2131375181: 
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
              } while ((paramView == null) || (!(paramView instanceof aioo)));
              paramView = (aioo)paramView;
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
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              return;
            case 2: 
            case 3: 
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              return;
            case 13: 
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              return;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
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
      } while ((paramView == null) || (!(paramView instanceof aioo)));
      if (!bbev.g(this.jdField_a_of_type_AndroidAppActivity))
      {
        bcpw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
        return;
      }
      paramView = (aioo)paramView;
      if (paramView.jdField_a_of_type_Int != 2)
      {
        a((structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.jdField_b_of_type_Long);
        long l1 = ayda.a().b();
        paramView = ayda.a().a(Long.valueOf(l1));
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
            if (bbbd.b(String.valueOf(l2))) {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j != 0) {
            d();
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
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
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
    ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
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
        if ((paramString != null) && ((paramString instanceof aioo)))
        {
          paramString = (aioo)paramString;
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
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.c();
      return;
    }
    if (this.jdField_a_of_type_Baxk.a()) {
      this.jdField_a_of_type_Baxk.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof aioo))
      {
        paramAbsListView = (aioo)paramAbsListView;
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
 * Qualified Name:     aiof
 * JD-Core Version:    0.7.0.1
 */