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
import com.tencent.mobileqq.widget.QQToast;
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

public class akfo
  extends bhyb
  implements View.OnClickListener, bcwt, bhpo, bhww
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691561 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839328 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370179 };
  private final int jdField_a_of_type_Int = 0;
  almw jdField_a_of_type_Almw = new akfw(this);
  private alox jdField_a_of_type_Alox = new akfu(this);
  private aloz jdField_a_of_type_Aloz;
  private alsi jdField_a_of_type_Alsi = new akfv(this);
  private alvf jdField_a_of_type_Alvf;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcws jdField_a_of_type_Bcws;
  private bepp jdField_a_of_type_Bepp;
  private bhxa jdField_a_of_type_Bhxa;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<avqe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<avqe> jdField_a_of_type_JavaUtilComparator = new akfp(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public akfo(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Bcws = new bcws(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Almw, true);
    this.jdField_a_of_type_Bhxa = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Alvf = ((alvf)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new akfr(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.a(1)).i();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914);
  }
  
  private View a(Context paramContext, int paramInt, akfx paramakfx)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bhxa.a(paramContext, localView, paramakfx, -1);
  }
  
  private bhxa a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new akfq(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(akfx paramakfx)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramakfx.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (avpz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramakfx.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
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
        Object localObject2 = paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramakfx.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramakfx.jdField_b_of_type_Long);
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
    ahik.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(akfx paramakfx, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramakfx.jdField_a_of_type_Long = paramInt;
    paramakfx.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramakfx.jdField_b_of_type_Long = paramLong;
    paramakfx.jdField_a_of_type_Int = 0;
    Object localObject2 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((aloz)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
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
        paramakfx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramakfx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!bdal.b(str))) {
          break label605;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841431);
        ((Drawable)localObject1).setBounds(0, 0, aekt.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), aekt.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        paramakfx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(aekt.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramakfx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(paramakfx);
        paramakfx.jdField_a_of_type_AndroidWidgetImageView.setTag(paramakfx);
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramakfx.d.setText(String.format(Locale.getDefault(), alpo.a(2131707873), new Object[] { localObject1 }));
          paramakfx.d.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            paramakfx.c.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setTag(paramakfx);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          return;
          paramakfx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label605:
          paramakfx.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label259;
          paramakfx.d.setVisibility(8);
          break label441;
          label631:
          paramakfx.c.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          paramakfx.c.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramakfx.e.setVisibility(8);
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramakfx);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramakfx.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramakfx.e.setText(paramStructMsg);
              paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramakfx.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramakfx.e.setText(paramStructMsg);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramakfx);
          continue;
          paramakfx.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramakfx.e.setText(paramStructMsg);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramakfx);
          continue;
          paramakfx.e.setVisibility(8);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramakfx.e.setVisibility(8);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramakfx.d.setText(paramStructMsg.msg.msg_additional.get());
            paramakfx.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramakfx.e.setVisibility(8);
            break;
            paramakfx.d.setVisibility(8);
          }
          paramakfx.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramakfx.e.setText(paramStructMsg);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramakfx);
          continue;
          paramakfx.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramakfx.e.setText(paramStructMsg);
          paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramakfx.e.setVisibility(8);
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramakfx);
            break;
            paramakfx.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramakfx.e.setText(paramStructMsg);
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramakfx.e.setVisibility(8);
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramakfx);
            break;
            paramakfx.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramakfx.e.setText(paramStructMsg);
            paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramakfx.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramakfx.e.setText(paramStructMsg);
              paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramakfx.e.setVisibility(8);
              paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramakfx.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramakfx.e.setText(paramStructMsg);
              paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramakfx.d.setVisibility(8);
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
  
  private void a(akfx paramakfx, PhoneContactAdd paramPhoneContactAdd)
  {
    paramakfx.jdField_a_of_type_Int = 1;
    paramakfx.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramakfx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramakfx.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramakfx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramakfx.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramakfx.c.setVisibility(0);
      paramakfx.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramakfx.e.setVisibility(0);
      paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramakfx.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131719227));
      paramakfx.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramakfx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramakfx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramakfx.c.setVisibility(8);
    }
  }
  
  private void a(akfx paramakfx, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramakfx.jdField_a_of_type_Int = 2;
    paramakfx.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramakfx.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    ahgy.a(paramakfx.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((alvf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramakfx.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), alpo.a(2131707887), new Object[] { localObject });
      paramakfx.d.setText((CharSequence)localObject);
      paramakfx.d.setVisibility(0);
      paramakfx.e.setVisibility(8);
      paramakfx.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131707875));
      paramakfx.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramakfx.jdField_a_of_type_AndroidWidgetButton.setTag(paramakfx);
      paramakfx.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramakfx.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramakfx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramakfx.c.setVisibility(0);
      paramakfx.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bhxb parambhxb, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {}
    for (int i = this.jdField_a_of_type_Bhxa.a(paramContext, paramView, paramInt, paramObject, parambhxb, paramOnClickListener);; i = 0)
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
      baaz.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      baaz.a().b(l);
      baaz.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return aoor.a().a();
  }
  
  private void b()
  {
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131699908), null, 2131690648, 2131699907, new akfs(this), new akft(this)).show();
  }
  
  private void b(akfx paramakfx)
  {
    if (paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845387);
        j = 0;
        i = 0;
        m = i;
        if (paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramakfx.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845386;
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845387);
        i = 1;
        break;
        j = 2130845384;
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845385);
        i = 1;
        break;
        label205:
        paramakfx.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramakfx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidAppActivity)) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692397), 0).b(a());
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
            if (bdal.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof avqe));
      paramView = (avqe)paramView;
      if ((paramView instanceof avpz))
      {
        paramView = (avpz)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof avqn))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof avqp));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(akfx paramakfx)
  {
    if ((paramakfx == null) || (paramakfx.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((aloz)localObject1).b(String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Bcws.a(32, String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bcws.a())
          {
            this.jdField_a_of_type_Bcws.a(String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bdda.a();
        }
        paramakfx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Bcws.a(1, String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Bcws.a())
          {
            this.jdField_a_of_type_Bcws.a(String.valueOf(paramakfx.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bepp.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131719773));
    this.jdField_a_of_type_Bepp.show();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
    this.jdField_a_of_type_Bepp = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561313, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131377235);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839216);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131377236));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, bdkf.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      label203:
      ((View)localObject).setBackgroundResource(2130839213);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561310, null);
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
        if (!bdee.g(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692397), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(aljq.M, 0);
      } while ((localList == null) || (localList.size() < 20) || (baaz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
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
    Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.a(paramString, paramInt, true, (byte)0);
    }
    return bdda.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Almw);
    this.jdField_a_of_type_Bcws.a(null);
    this.jdField_a_of_type_Bcws.d();
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
      paramViewGroup = new akfx();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561309, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371142));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362215));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131375678));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131376845));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375665));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131375675));
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setTag(paramViewGroup);
      paramViewGroup.g.setOnClickListener(this);
      localObject = (avqe)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, paramViewGroup, this);
      View localView = paramViewGroup.g;
      if (((avqe)localObject).a()) {
        break label263;
      }
      bool = true;
      label206:
      ahgy.a(localView, bool);
      if (!(localObject instanceof avpz)) {
        break label269;
      }
      localObject = ((avpz)getItem(paramInt)).a;
      a(paramViewGroup, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    label263:
    label269:
    do
    {
      return paramView;
      paramViewGroup = (akfx)paramView.getTag();
      break;
      bool = false;
      break label206;
      if ((localObject instanceof avqn))
      {
        a(paramViewGroup, ((avqn)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
        return paramView;
      }
    } while (!(localObject instanceof avqp));
    Object localObject = ((avqp)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
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
    case 2131375820: 
    case 2131375665: 
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
              } while ((paramView == null) || (!(paramView instanceof akfx)));
              paramView = (akfx)paramView;
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
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              return;
            case 2: 
            case 3: 
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              return;
            case 13: 
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              return;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
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
      } while ((paramView == null) || (!(paramView instanceof akfx)));
      if (!bdee.g(this.jdField_a_of_type_AndroidAppActivity))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692397), 0).b(a());
        return;
      }
      paramView = (akfx)paramView;
      if (paramView.jdField_a_of_type_Int != 2)
      {
        a((structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.jdField_b_of_type_Long);
        long l1 = baaz.a().b();
        paramView = baaz.a().a(Long.valueOf(l1));
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
            if (bdal.b(String.valueOf(l2))) {
              azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j != 0) {
            d();
          }
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
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
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
    ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
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
        if ((paramString != null) && ((paramString instanceof akfx)))
        {
          paramString = (akfx)paramString;
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
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.c();
      return;
    }
    if (this.jdField_a_of_type_Bcws.a()) {
      this.jdField_a_of_type_Bcws.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof akfx))
      {
        paramAbsListView = (akfx)paramAbsListView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfo
 * JD-Core Version:    0.7.0.1
 */