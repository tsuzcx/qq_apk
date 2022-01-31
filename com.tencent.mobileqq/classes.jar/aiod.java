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

public class aiod
  extends bfxe
  implements View.OnClickListener, baxz, bfos, bfvz
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691507 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839239 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131369914 };
  private final int jdField_a_of_type_Int = 0;
  ajvj jdField_a_of_type_Ajvj = new aiol(this);
  private ajxj jdField_a_of_type_Ajxj = new aioj(this);
  private ajxl jdField_a_of_type_Ajxl;
  private akat jdField_a_of_type_Akat = new aiok(this);
  private akdq jdField_a_of_type_Akdq;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private baxy jdField_a_of_type_Baxy;
  private bcqf jdField_a_of_type_Bcqf;
  private bfwd jdField_a_of_type_Bfwd;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private ArrayList<atza> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<atza> jdField_a_of_type_JavaUtilComparator = new aioe(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final ConcurrentHashMap<Long, String> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public aiod(Activity paramActivity, QQAppInterface paramQQAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ajxl = ((ajxl)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Baxy = new baxy(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    h();
    g();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvj, true);
    this.jdField_a_of_type_Bfwd = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Akdq = ((akdq)paramQQAppInterface.getManager(257));
    a(true);
    paramView2.setOnClickListener(new aiog(this, paramQQAppInterface));
    if (a()) {
      ((FriendListHandler)paramQQAppInterface.a(1)).h();
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865);
  }
  
  private View a(Context paramContext, int paramInt, aiom paramaiom)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_Bfwd.a(paramContext, localView, paramaiom, -1);
  }
  
  private bfwd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aiof(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(aiom paramaiom)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgAdapter", 2, "handleBuddySystemMsg! start " + paramaiom.jdField_a_of_type_Long);
    }
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (atyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaiom.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
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
        Object localObject2 = paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramaiom.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
        }
        a((structmsg.StructMsg)paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramaiom.jdField_b_of_type_Long);
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
    aflf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject1);
  }
  
  private void a(aiom paramaiom, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramaiom.jdField_a_of_type_Long = paramInt;
    paramaiom.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramaiom.jdField_b_of_type_Long = paramLong;
    paramaiom.jdField_a_of_type_Int = 0;
    Object localObject2 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = paramStructMsg.msg.req_uin_nick.get();
    localObject2 = ((ajxl)localObject2).a(String.valueOf(paramStructMsg.req_uin.get()));
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
        paramaiom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaiom.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(str)) || (!bbbr.b(str))) {
          break label605;
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841310);
        ((Drawable)localObject1).setBounds(0, 0, actj.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), actj.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
        paramaiom.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramaiom.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
        label259:
        c(paramaiom);
        paramaiom.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaiom);
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramaiom.d.setText(String.format(Locale.getDefault(), ajya.a(2131707501), new Object[] { localObject1 }));
          paramaiom.d.setVisibility(0);
          label441:
          if (paramStructMsg.msg != null)
          {
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get())) {
              break label651;
            }
            if (TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
              break label631;
            }
            paramaiom.c.setText(paramStructMsg.msg.msg_qna.get());
            label497:
            switch (paramStructMsg.msg.sub_type.get())
            {
            }
          }
        }
        for (;;)
        {
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setTag(paramaiom);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          return;
          paramaiom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          label605:
          paramaiom.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
          break label259;
          paramaiom.d.setVisibility(8);
          break label441;
          label631:
          paramaiom.c.setText(paramStructMsg.msg.msg_additional.get());
          break label497;
          label651:
          paramaiom.c.setText(paramStructMsg.msg.msg_describe.get());
          break label497;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaiom.e.setVisibility(8);
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaiom);
            break;
            if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
            {
              paramaiom.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaiom.e.setText(paramStructMsg);
              paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
          }
          paramaiom.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaiom.e.setText(paramStructMsg);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaiom);
          continue;
          paramaiom.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaiom.e.setText(paramStructMsg);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaiom);
          continue;
          paramaiom.e.setVisibility(8);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramaiom.e.setVisibility(8);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
          {
            paramaiom.d.setText(paramStructMsg.msg.msg_additional.get());
            paramaiom.c.setText(paramStructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramaiom.e.setVisibility(8);
            break;
            paramaiom.d.setVisibility(8);
          }
          paramaiom.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaiom.e.setText(paramStructMsg);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          b(paramaiom);
          continue;
          paramaiom.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramaiom.e.setText(paramStructMsg);
          paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaiom.e.setVisibility(8);
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaiom);
            break;
            paramaiom.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaiom.e.setText(paramStructMsg);
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramaiom.e.setVisibility(8);
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
          }
          for (;;)
          {
            b(paramaiom);
            break;
            paramaiom.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramaiom.e.setText(paramStructMsg);
            paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          if (paramStructMsg.msg.reqsubtype.has()) {
            if (paramStructMsg.msg.reqsubtype.get() == 1)
            {
              paramaiom.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaiom.e.setText(paramStructMsg);
              paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            }
            else if (paramStructMsg.msg.reqsubtype.get() == 2)
            {
              paramaiom.e.setVisibility(8);
              paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              paramaiom.e.setVisibility(0);
              paramStructMsg = paramStructMsg.msg.msg_decided.get();
              paramaiom.e.setText(paramStructMsg);
              paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              paramaiom.d.setVisibility(8);
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
  
  private void a(aiom paramaiom, PhoneContactAdd paramPhoneContactAdd)
  {
    paramaiom.jdField_a_of_type_Int = 1;
    paramaiom.jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramaiom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramaiom.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
      paramaiom.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaiom.d.setVisibility(8);
      if (TextUtils.isEmpty(paramPhoneContactAdd.remindInfo)) {
        break label158;
      }
      paramaiom.c.setVisibility(0);
      paramaiom.c.setText(paramPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      paramaiom.e.setVisibility(0);
      paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramaiom.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131718754));
      paramaiom.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
      paramaiom.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
      return;
      paramaiom.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label158:
      paramaiom.c.setVisibility(8);
    }
  }
  
  private void a(aiom paramaiom, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramaiom.jdField_a_of_type_Int = 2;
    paramaiom.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramaiom.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    afjt.a(paramaiom.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((akdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257)).a(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramaiom.c.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajya.a(2131707515), new Object[] { localObject });
      paramaiom.d.setText((CharSequence)localObject);
      paramaiom.d.setVisibility(0);
      paramaiom.e.setVisibility(8);
      paramaiom.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131707503));
      paramaiom.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramaiom.jdField_a_of_type_AndroidWidgetButton.setTag(paramaiom);
      paramaiom.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramaiom.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
      paramaiom.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
      return;
      paramaiom.c.setVisibility(0);
      paramaiom.c.setText((CharSequence)localObject);
    }
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, bfwe parambfwe, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfwd != null) {}
    for (int i = this.jdField_a_of_type_Bfwd.a(paramContext, paramView, paramInt, paramObject, parambfwe, paramOnClickListener);; i = 0)
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
      aydc.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      aydc.a().b(l);
      aydc.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return amxk.a().a();
  }
  
  private void b()
  {
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_AndroidAppActivity.getString(2131699553), null, 2131690596, 2131699552, new aioh(this), new aioi(this)).show();
  }
  
  private void b(aiom paramaiom)
  {
    if (paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {}
    for (int k = paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();; k = -1)
    {
      int j;
      int i;
      switch (k)
      {
      default: 
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845022);
        j = 0;
        i = 0;
        m = i;
        if (paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
        {
          if ((paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) || ((k != 0) && (k != 1))) {
            break label205;
          }
          paramaiom.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        }
        break;
      }
      for (int m = 1;; m = i)
      {
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (m == 0) {
          break label221;
        }
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        j = 2130845021;
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845022);
        i = 1;
        break;
        j = 2130845019;
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130845020);
        i = 1;
        break;
        label205:
        paramaiom.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      label221:
      paramaiom.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void b(View paramView)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidAppActivity)) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
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
            if (bbbr.a("tag_swip_icon_menu_item", paramView.getTag())) {
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
      } while (!(paramView instanceof atza));
      paramView = (atza)paramView;
      if ((paramView instanceof atyv))
      {
        paramView = (atyv)paramView;
        d();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof atzj))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.9(this, paramView), null, true);
        return;
      }
    } while (!(paramView instanceof atzl));
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.10(this, paramView), null, true);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(aiom paramaiom)
  {
    if ((paramaiom == null) || (paramaiom.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((ajxl)localObject1).b(String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Baxy.a(32, String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxy.a())
          {
            this.jdField_a_of_type_Baxy.a(String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bbef.a();
        }
        paramaiom.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Baxy.a(1, String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxy.a())
          {
            this.jdField_a_of_type_Baxy.a(String.valueOf(paramaiom.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_Bcqf.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131719292));
    this.jdField_a_of_type_Bcqf.show();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.jdField_a_of_type_Bcqf = null;
  }
  
  private void g()
  {
    Object localObject;
    if (a())
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561126, null);
      }
      localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131376725);
      ((View)localObject).setOnClickListener(this);
      if (!ThemeUtil.isDefaultTheme()) {
        break label203;
      }
      ((View)localObject).setBackgroundResource(2130839132);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376726));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, bbll.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).e();
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
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561123, null);
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
        if (!bbfj.g(BaseApplication.getContext()))
        {
          bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajsd.M, 0);
      } while ((localList == null) || (localList.size() < 20) || (aydc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
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
    Bitmap localBitmap = this.jdField_a_of_type_Baxy.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.a(paramString, paramInt, true, (byte)0);
    }
    return bbef.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvj);
    this.jdField_a_of_type_Baxy.a(null);
    this.jdField_a_of_type_Baxy.d();
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
      paramViewGroup = new aiom();
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561122, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362195));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131375196));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131376341));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375183));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131375193));
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)paramViewGroup.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(true);
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.g.setTag(paramViewGroup);
      paramViewGroup.g.setOnClickListener(this);
      localObject = (atza)getItem(paramInt);
      a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, paramViewGroup, this);
      View localView = paramViewGroup.g;
      if (((atza)localObject).a()) {
        break label263;
      }
      bool = true;
      label206:
      afjt.a(localView, bool);
      if (!(localObject instanceof atyv)) {
        break label269;
      }
      localObject = ((atyv)getItem(paramInt)).a;
      a(paramViewGroup, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    label263:
    label269:
    do
    {
      return paramView;
      paramViewGroup = (aiom)paramView.getTag();
      break;
      bool = false;
      break label206;
      if ((localObject instanceof atzj))
      {
        a(paramViewGroup, ((atzj)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataPhoneContactAdd);
        return paramView;
      }
    } while (!(localObject instanceof atzl));
    Object localObject = ((atzl)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
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
    case 2131375335: 
    case 2131375183: 
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
              } while ((paramView == null) || (!(paramView instanceof aiom)));
              paramView = (aiom)paramView;
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
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
              return;
            case 2: 
            case 3: 
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              return;
            case 13: 
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
              return;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
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
      } while ((paramView == null) || (!(paramView instanceof aiom)));
      if (!bbfj.g(this.jdField_a_of_type_AndroidAppActivity))
      {
        bcql.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692321), 0).b(a());
        return;
      }
      paramView = (aiom)paramView;
      if (paramView.jdField_a_of_type_Int != 2)
      {
        a((structmsg.StructMsg)paramView.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramView.jdField_b_of_type_Long);
        long l1 = aydc.a().b();
        paramView = aydc.a().a(Long.valueOf(l1));
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
            if (bbbr.b(String.valueOf(l2))) {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
          }
        }
        for (int j = i;; j = 0)
        {
          if (j != 0) {
            d();
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
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
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
    ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).b(0);
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
        if ((paramString != null) && ((paramString instanceof aiom)))
        {
          paramString = (aiom)paramString;
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
      this.jdField_a_of_type_Baxy.a();
      this.jdField_a_of_type_Baxy.c();
      return;
    }
    if (this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.b();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    label70:
    if (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof aiom))
      {
        paramAbsListView = (aiom)paramAbsListView;
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
 * Qualified Name:     aiod
 * JD-Core Version:    0.7.0.1
 */