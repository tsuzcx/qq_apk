import Wallet.PfaFriend;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter.1;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ajwc
  extends akcy
  implements aisg, View.OnClickListener, View.OnLongClickListener, aubn
{
  private static final ajwh jdField_a_of_type_Ajwh = new ajwh(null);
  private final int jdField_a_of_type_Int;
  ajwk jdField_a_of_type_Ajwk = null;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<ArrayList<awbv>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private bbjz jdField_a_of_type_Bbjz;
  private bhpo jdField_a_of_type_Bhpo;
  protected SelectMemberActivity a;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<awbv> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ajwe(this);
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  private final ArrayList<Groups> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public ajwc(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = ((SelectMemberActivity)paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView != null) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.post(new SelectMemberBuddyListAdapter.1(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this);
    }
    this.jdField_a_of_type_Int = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.jdField_b_of_type_Int = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560250, paramViewGroup, false);
      paramViewGroup = new ajwj();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364254));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378922);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView.findViewById(2131378790).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject1 = getChild(paramInt1, paramInt2);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
      paramViewGroup.jdField_a_of_type_Long = getGroupId(paramInt1);
      if (!(localObject1 instanceof TroopMemberInfo)) {
        break label431;
      }
      localObject2 = (TroopMemberInfo)localObject1;
      if (this.jdField_a_of_type_Ajwk == null) {
        this.jdField_a_of_type_Ajwk = new ajwk(this, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      localObject1 = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      a(paramViewGroup, this.jdField_a_of_type_Ajwk.a((TroopMemberInfo)localObject2));
      label234:
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null)
      {
        if (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
          break label465;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label266:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.d.setText((CharSequence)localObject1);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label478;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label309:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList.contains(paramViewGroup.jdField_a_of_type_JavaLangString))) {
        break label490;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label502;
        }
        paramView.setContentDescription((String)localObject1 + alpo.a(2131714128));
      }
      return paramView;
      paramViewGroup = (ajwj)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label431:
      localObject2 = (Friends)localObject1;
      localObject1 = bdbt.a((Friends)localObject2);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((Friends)localObject2).uin;
      a(paramViewGroup, null);
      break label234;
      label465:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label266;
      label478:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label309;
      label490:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label502:
    paramView.setContentDescription((String)localObject1 + alpo.a(2131714105));
    return paramView;
  }
  
  private void a(List<ajwf> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Ajwh);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "", paramList);
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560250, paramViewGroup, false);
      paramViewGroup = new ajwj();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131370958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364254));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378922);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(paramViewGroup);
      Object localObject = getChild(paramInt1, paramInt2);
      localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.d.setText(localPhoneContact.name);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label353;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label214:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList == null) || ("0".equals(localPhoneContact.uin)) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList.contains(localPhoneContact.uin))) {
        break label365;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.c) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label377;
        }
        paramView.setContentDescription(localPhoneContact.name + alpo.a(2131714120));
      }
      return paramView;
      paramViewGroup = (ajwj)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label353:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label214;
      label365:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label377:
    paramView.setContentDescription(localPhoneContact.name + alpo.a(2131714134));
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof ajwj)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559490, paramViewGroup, false);
      paramViewGroup = new ajwi();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366461));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131377553));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372419));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372402));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131372429));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131377555));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
        break label483;
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label483:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166901));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        if (AppSetting.c) {
          paramView.setContentDescription(paramViewGroup.d.getText());
        }
        return paramView;
        paramViewGroup = (ajwi)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841431);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.b.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = true;
    if (!this.c) {
      this.c = true;
    }
    for (;;)
    {
      Object localObject2 = aisa.a(this, bool, 0, 0);
      Object localObject3 = ((HashMap)localObject2).get(aisa.jdField_a_of_type_JavaLangString);
      Object localObject1 = null;
      if (localObject3 != null) {
        localObject1 = (ArrayList)localObject3;
      }
      localObject2 = ((HashMap)localObject2).get(aisa.b);
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f = ((ArrayList)localObject2);
      }
      if (localObject1 != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject2 = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject4 = (PfaFriend)((Iterator)localObject1).next();
          if (localObject4 != null) {
            try
            {
              if ((((PfaFriend)localObject4).uin != null) && (!((PfaFriend)localObject4).uin.equals(localObject3)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList.contains(((PfaFriend)localObject4).uin)))
              {
                localObject4 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(((PfaFriend)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject2).add(localObject4);
                }
              }
            }
            catch (Exception localException) {}
          }
        }
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = 1003;
          ((Groups)localObject1).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131692847);
          ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
          ((Groups)localObject1).seqid = 0;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject1).group_id, localObject2);
        }
      }
      return;
      bool = false;
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((amjk)localObject1).a(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList.contains(((RecentUser)localObject4).uin)) && (!bdal.b(((RecentUser)localObject4).uin)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.w) || (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin))))
              {
                localObject4 = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131719111);
          ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_AndroidContentIntent.getStringExtra("group_name");
    Groups localGroups = new Groups();
    localGroups.group_id = 1006;
    localGroups.group_name = str;
    localGroups.group_friend_count = this.jdField_a_of_type_JavaUtilArrayList.size();
    localGroups.seqid = 0;
    this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isDevelopLevel()) {
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, "addCurGroup, mGroupmembers[" + this.jdField_a_of_type_JavaUtilArrayList.size() + "]");
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
        } while ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c()) && (i != 8));
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      } while (localObject == null);
      localArrayList = new ArrayList();
      localArrayList.addAll((Collection)localObject);
    } while (localArrayList.isEmpty());
    Object localObject = new Groups();
    ((Groups)localObject).group_id = 1002;
    ((Groups)localObject).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131695186);
    ((Groups)localObject).group_friend_count = 1;
    ((Groups)localObject).seqid = 0;
    this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject).group_id, localArrayList);
  }
  
  private void g()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Bbjz.a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidUtilSparseArray);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_Int == 1)) {
      e();
    }
    aloz localaloz;
    Object localObject2;
    Object localObject1;
    label104:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 33)
    {
      c();
      f();
      localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = null;
      if (localaloz == null) {
        break label313;
      }
      localObject1 = localaloz.b();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label677;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label338;
        }
        localObject2 = "null";
        label147:
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label677;
      }
      localObject1 = new ArrayList();
    }
    label674:
    label677:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      label313:
      label338:
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
        localObject2 = localaloz.a(String.valueOf(localGroups.group_id));
        if (localObject2 == null) {}
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new ajwf((Friends)((Iterator)localObject5).next(), -1));
          }
          d();
          break;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label104;
          }
          QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break label104;
          localObject2 = "empty";
          break label147;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((ajwf)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label425:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = bdbt.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label674;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label425;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_JavaUtilArrayList.contains(((Friends)localObject5).uin)) && (!bdal.b(((Friends)localObject5).uin)) && (!bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin)) && ((!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.w) || (!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin)))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject4);
        break;
        if ((this.jdField_b_of_type_ComTencentWidgetExpandableListView != null) && (!((List)localObject1).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.a(0);
        }
        return;
      }
    }
  }
  
  public int a()
  {
    return 2131558878;
  }
  
  public Groups a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Groups localGroups = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void a(long paramLong) {}
  
  public void a(View paramView, int paramInt)
  {
    ajwg localajwg = (ajwg)paramView.getTag();
    if (localajwg == null)
    {
      localajwg = new ajwg();
      paramView.findViewById(2131368762).setVisibility(0);
      localajwg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367341));
      paramView.setTag(localajwg);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localajwg.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      if (this.jdField_b_of_type_ComTencentWidgetExpandableListView != null) {
        ((CheckBox)paramView.findViewById(2131368762)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      }
      return;
    }
  }
  
  public void a(bbjz parambbjz)
  {
    this.jdField_a_of_type_Bbjz = parambbjz;
  }
  
  public void a(ArrayList<awbv> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onRecommendCountChanged count=" + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_d_of_type_Int == 33) {
      aisa.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app);
    }
    if (this.jdField_a_of_type_Ajwk != null)
    {
      this.jdField_a_of_type_Ajwk.a();
      this.jdField_a_of_type_Ajwk = null;
    }
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = null;
    super.b();
  }
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.isFinishing())) {
      return;
    }
    notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    int i = ((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id;
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if ((paramInt2 < localArrayList.size()) && (paramInt2 >= 0)) {
      return localArrayList.get(paramInt2);
    }
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, "getChild error,members.size = " + localArrayList.size() + ",childPositon = " + paramInt2 + "，groupPosition = " + paramInt1);
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l1 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
      do
      {
        try
        {
          l1 = Long.parseLong(((Friends)localObject).uin);
          return l1;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        if (!(localThrowable1 instanceof TroopMemberInfo)) {
          break;
        }
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localThrowable1;
        try
        {
          long l2 = Long.parseLong(localTroopMemberInfo.memberuin);
          return l2;
        }
        catch (Throwable localThrowable2) {}
      } while (!QLog.isColorLevel());
      QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
      return 0L;
    } while (!(localThrowable2 instanceof RelationTroopEntity));
    RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable2;
    return this.jdField_a_of_type_Bbjz.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    bhxr.a("getChildView");
    if (a(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    for (;;)
    {
      bhxr.a();
      return paramView;
      if (a(paramInt1, paramInt2) == 1)
      {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
      else if (a(paramInt1, paramInt2) == 2)
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)getChild(paramInt1, paramInt2);
        paramView = this.jdField_a_of_type_Bbjz.b(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener, localRelationTroopEntity);
      }
      else
      {
        paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) == null)) {
      return 0;
    }
    return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (ajwg)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (AppSetting.c)
      {
        if (!paramBoolean) {
          break label153;
        }
        paramViewGroup.setContentDescription(((Groups)localObject).group_name + alpo.a(2131714124));
      }
    }
    for (;;)
    {
      paramViewGroup.setOnLongClickListener(this);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560249, paramViewGroup, false);
      paramView = new ajwg();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367341));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
      break;
      label153:
      paramViewGroup.setContentDescription(((Groups)localObject).group_name + alpo.a(2131714115));
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    g();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (ajwg)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
      paramView = (Groups)getGroup(paramView.jdField_a_of_type_Int);
      if (paramView.group_id == 1003)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Int == 0)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005442", "0X8005442", 1, 0, "", "", "", "");
          return;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005442", "0X8005442", 2, 0, "", "", "", "");
        return;
      }
      if (paramView.group_id == 1002)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Int == 0)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005444", "0X8005444", 1, 0, "", "", "", "");
          return;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005444", "0X8005444", 2, 0, "", "", "", "");
        return;
      }
      if (paramView.group_id == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Int == 0)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005443", "0X8005443", 1, 0, "", "", "", "");
          return;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005443", "0X8005443", 2, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Int == 0)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005445", "0X8005445", 1, 0, "", "", "", "");
        return;
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005445", "0X8005445", 2, 0, "", "", "", "");
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public boolean onLongClick(View paramView)
  {
    bdkz localbdkz = new bdkz();
    localbdkz.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693327));
    bdbk.a(paramView, localbdkz, this.jdField_b_of_type_AndroidViewView$OnClickListener, new ajwd(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwc
 * JD-Core Version:    0.7.0.1
 */