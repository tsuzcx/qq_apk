import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.adapter.BuddyListAdapter.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class akdd
  extends akgw
  implements akhz, View.OnClickListener, View.OnLongClickListener, bhwz
{
  private static final akdj jdField_a_of_type_Akdj = new akdj(null);
  public int a;
  private akdh jdField_a_of_type_Akdh = new akdh(this);
  private akdi jdField_a_of_type_Akdi = new akdi(this);
  private final aloz jdField_a_of_type_Aloz;
  private SparseArray<List<akhx>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final axzt jdField_a_of_type_Axzt;
  private bhpo jdField_a_of_type_Bhpo;
  private SimpleTextView jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new akdf(this);
  private SimpleTextView jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView;
  private final boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d = -1;
  
  public akdd(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SwipPinnedHeaderExpandableListView paramSwipPinnedHeaderExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseActivity, paramQQAppInterface, paramSwipPinnedHeaderExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Axzt = ((axzt)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_Aloz = ((aloz)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_Int = ((int)bdcq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 12.0F));
    notifyDataSetChanged();
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(akdg paramakdg, Groups paramGroups, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramakdg == null) {
      return;
    }
    if (!paramakdg.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      paramakdg.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    Object localObject2 = paramakdg.jdField_a_of_type_JavaLangStringBuilder;
    Object localObject1 = localObject2;
    int i;
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder(24);
        ((StringBuilder)localObject1).append(paramGroups.group_name + " 分组");
      }
    }
    else
    {
      paramakdg.jdField_a_of_type_Int = paramInt1;
      paramakdg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramGroups.group_name);
      paramakdg.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
      paramakdg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramakdg.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramGroups.group_id);
      paramInt1 = getChildrenCount(paramInt1);
      if (paramGroups.group_id != 1005) {
        break label363;
      }
      paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(paramInt1 + "");
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((StringBuilder)localObject1).append("共" + paramInt1 + "个常用群聊");
      }
      if (paramInt2 != 0) {
        break label535;
      }
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramakdg.jdField_a_of_type_Int)) {
        break label470;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      label237:
      localObject2 = paramakdg.jdField_a_of_type_AndroidWidgetCheckBox;
      boolean bool;
      if (paramInt1 == 2)
      {
        bool = true;
        label251:
        ((CheckBox)localObject2).setChecked(bool);
        if (AppSetting.jdField_c_of_type_Boolean)
        {
          if (!paramakdg.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label481;
          }
          ((StringBuilder)localObject1).append(" 已展开");
        }
      }
      for (;;)
      {
        paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setContentDescription(((StringBuilder)localObject1).toString());
        bcvq.a(paramakdg.jdField_a_of_type_AndroidWidgetCheckBox, false);
        if ((paramGroups.group_id != 1002) || (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d() != this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())) {
          break label502;
        }
        if (!paramBoolean) {
          break label493;
        }
        this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
        return;
        ((StringBuilder)localObject2).delete(0, ((StringBuilder)localObject2).length());
        localObject1 = localObject2;
        break;
        label363:
        SimpleTextView localSimpleTextView = paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
        if (this.jdField_b_of_type_Boolean) {}
        for (localObject2 = "%d / %d";; localObject2 = "%d/%d")
        {
          localSimpleTextView.setText(String.format((String)localObject2, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) }));
          if (!AppSetting.jdField_c_of_type_Boolean) {
            break;
          }
          ((StringBuilder)localObject1).append("在线" + i + "人，共" + paramInt1 + "人");
          break;
        }
        label470:
        paramInt1 = 1;
        break label237;
        bool = false;
        break label251;
        label481:
        ((StringBuilder)localObject1).append(" 已折叠");
      }
      label493:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView;
      return;
      label502:
      if (this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView == paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView != paramakdg.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = null;
      return;
      label535:
      paramInt1 = paramInt2;
    }
  }
  
  private void a(ArrayList<Object> paramArrayList, SparseArray<List<akhx>> paramSparseArray, SparseIntArray paramSparseIntArray)
  {
    Groups localGroups1 = new Groups();
    localGroups1.group_id = 1004;
    localGroups1.group_name = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717857);
    localGroups1.group_friend_count = 1;
    localGroups1.seqid = 0;
    paramArrayList.add(localGroups1);
    ArrayList localArrayList1 = new ArrayList();
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localaloz != null)
    {
      localObject1 = localaloz.c();
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((List)localObject1).size() != 0) {}
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("group list is ");
          if (localObject1 != null) {
            break label438;
          }
          localObject2 = "null";
          label139:
          QLog.d("BuddyListAdapter", 2, (String)localObject2);
        }
        if (localObject1 != null) {
          break label697;
        }
        localObject1 = new ArrayList();
      }
    }
    label285:
    label438:
    label694:
    label697:
    for (;;)
    {
      paramArrayList.remove(localGroups1);
      localObject2 = localObject1;
      Iterator localIterator1 = ((List)localObject2).iterator();
      int i = 0;
      Groups localGroups2;
      label254:
      ArrayList localArrayList2;
      int j;
      Friends localFriends;
      int k;
      Object localObject4;
      if (localIterator1.hasNext())
      {
        localGroups2 = (Groups)localIterator1.next();
        paramArrayList.add(localGroups2);
        localObject1 = localaloz.a(String.valueOf(localGroups2.group_id));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          localArrayList2 = new ArrayList(((List)localObject1).size());
          Iterator localIterator2 = ((List)localObject1).iterator();
          localObject2 = null;
          j = 0;
          if (!localIterator2.hasNext()) {
            break label555;
          }
          localObject3 = (awbv)localIterator2.next();
          localFriends = (Friends)localObject3;
          k = bdbt.a(localFriends.detalStatusFlag, localFriends.iTermType);
          localObject4 = this.jdField_a_of_type_Aloz.a(localFriends.uin);
          if ((localObject4 == null) || (((SpecialCareInfo)localObject4).globalSwitch == 0)) {
            break label694;
          }
          localArrayList1.add(akhs.a(4, (awbv)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
          if ((k == 0) || (k == 6)) {
            break label694;
          }
          i += 1;
        }
      }
      for (;;)
      {
        if (((Friends)localObject3).gathtertype == 1)
        {
          break label285;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BuddyListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label139;
          localObject1 = new ArrayList((Collection)localObject1);
          break label254;
        }
        if ((k != 0) && (k != 6)) {
          j += 1;
        }
        for (;;)
        {
          for (;;)
          {
            localObject3 = akhs.a(0, (awbv)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
            ((akhx)localObject3).a(this);
            try
            {
              localObject4 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              boolean bool = localFriends.uin.equals(localObject4);
              if (bool) {
                localObject2 = localObject3;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
              localArrayList2.add(localObject3);
            }
          }
          break label285;
          a(localArrayList2);
          if (localObject2 != null) {
            localArrayList2.add(0, localObject2);
          }
          paramSparseIntArray.put(localGroups2.group_id, j);
          paramSparseArray.put(localGroups2.group_id, localArrayList2);
          if (QLog.isColorLevel()) {
            QLog.d("BuddyListAdapter", 2, "groupId: " + localGroups2.group_id + " num: " + ((List)localObject1).size());
          }
          break;
          a(localArrayList1);
          paramSparseIntArray.put(1004, i);
          paramSparseArray.put(1004, localArrayList1);
          localGroups1.group_friend_count = localArrayList1.size();
          return;
        }
      }
    }
  }
  
  private void a(List<akhx> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_Akdj);
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("BuddyListAdapter", 2, "", paramList);
    }
  }
  
  private void c()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof akhw)))
      {
        localObject = (akhw)localObject;
        if ((TextUtils.isEmpty(((akhw)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView.a().toString())) && ((((akhw)localObject).jdField_a_of_type_JavaLangObject instanceof Friends))) {
          a((Friends)((akhw)localObject).jdField_a_of_type_JavaLangObject, (akhw)localObject);
        }
      }
      i += 1;
    }
  }
  
  private void d()
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_expanded", "700_sp_key_last_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    int i;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_expanded"))
    {
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (getGroupType(i) == 0)
        {
          localObject = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((Groups)localObject).group_friend_count > 0) {
            localHashSet.add(Integer.valueOf(((Groups)localObject).group_id));
          }
        }
      }
      else
      {
        i = k;
        if (localHashSet.size() == 0)
        {
          this.jdField_c_of_type_Boolean = true;
          i = k;
        }
      }
    }
    int m;
    int j;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((getGroupType(i) == 0) && (localHashSet.contains(Integer.valueOf(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i)).group_id)))) {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
        }
        i += 1;
        continue;
        i += 1;
        break;
        i = k;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          m = localObject.length;
          j = 0;
        }
      }
    }
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      String str = localObject[j];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label290:
        j += 1;
        continue;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label290;
      }
    }
  }
  
  private void g()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = getGroupCount();
    if (j <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BuddyListAdapter", 2, "no data. don't save group");
      }
      return;
    }
    int i = 0;
    while (i < j)
    {
      if (getGroupType(i) == 0)
      {
        Groups localGroups = (Groups)getGroup(i);
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i))
        {
          localStringBuffer.append(localGroups.group_id);
          localStringBuffer.append("_");
        }
      }
      i += 1;
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_expanded", localStringBuffer.toString()).commit();
  }
  
  public int a()
  {
    return 2131558879;
  }
  
  String a(Friends paramFriends, akhw paramakhw)
  {
    if ((this.jdField_a_of_type_Axzt == null) || (this.jdField_a_of_type_Aloz == null)) {
      return null;
    }
    ExtensionInfo localExtensionInfo = this.jdField_a_of_type_Aloz.a(paramFriends.uin);
    Object localObject = null;
    boolean bool;
    label65:
    int j;
    label98:
    int k;
    if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.feedContent)))
    {
      i = 1;
      if (localExtensionInfo != null)
      {
        if (this.jdField_b_of_type_Int == 0) {
          break label285;
        }
        bool = true;
        localObject = localExtensionInfo.getRichStatus(bool);
      }
      if ((localObject == null) || (localObject == RichStatus.getEmptyStatus()) || (((RichStatus)localObject).isEmpty())) {
        break label291;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(((RichStatus)localObject).actionText))) {
        break label297;
      }
      k = 1;
      label117:
      if ((i == 0) || ((localExtensionInfo.feedTime <= localExtensionInfo.richTime) && (j != 0))) {
        break label413;
      }
      paramFriends = new String(localExtensionInfo.feedContent);
      paramakhw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      if (localExtensionInfo.feedType != 2) {
        break label322;
      }
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localExtensionInfo.feedPhotoUrl)) {
        break label303;
      }
      bczi.a(paramakhw.jdField_b_of_type_AndroidWidgetImageView, localExtensionInfo.feedPhotoUrl, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130849605));
    }
    for (;;)
    {
      paramakhw.c.setVisibility(8);
      paramakhw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      localObject = null;
      if (localExtensionInfo == null)
      {
        paramakhw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        paramakhw.c.setVisibility(8);
      }
      paramakhw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText((String)localObject, 1);
      paramakhw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label285:
      bool = false;
      break label65;
      label291:
      j = 0;
      break label98;
      label297:
      k = 0;
      break label117;
      label303:
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849605));
    }
    label322:
    paramakhw.c.setVisibility(0);
    localObject = paramakhw.c;
    if (localExtensionInfo.feedType == 1)
    {
      i = 2130848971;
      label349:
      ((ImageView)localObject).setBackgroundResource(i);
      localObject = paramakhw.jdField_a_of_type_ComTencentImageURLImageView;
      if (!localExtensionInfo.feedHasPhoto) {
        break label407;
      }
    }
    label407:
    for (int i = 0;; i = 8)
    {
      ((URLImageView)localObject).setVisibility(i);
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = null;
      break;
      i = 2130848969;
      break label349;
    }
    label413:
    if (k != 0)
    {
      ((RichStatus)localObject).enableSummaryCached = paramFriends.isFriend();
      paramFriends = this.jdField_a_of_type_Axzt.a(((RichStatus)localObject).actionId, 200);
      paramFriends = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), paramFriends);
      i = this.jdField_c_of_type_Int;
      paramFriends.setBounds(0, 0, Math.round(paramFriends.getIntrinsicWidth() * 1.0F / paramFriends.getIntrinsicHeight() * i), i);
      paramakhw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramFriends, null);
    }
    for (;;)
    {
      String str = ((RichStatus)localObject).getActionAndData();
      paramFriends = ((RichStatus)localObject).getPlainText();
      paramakhw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramakhw.c.setVisibility(8);
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramakhw.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = str;
      break;
      if (j == 0)
      {
        localObject = RichStatus.getEmptyStatus();
        paramakhw.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
      }
    }
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView)
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
  
  public void a(View paramView, int paramInt)
  {
    Groups localGroups = (Groups)getGroup(paramInt);
    if (!(paramView.getTag() instanceof akdg))
    {
      localObject = new akdg();
      ((akdg)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368762));
      ((akdg)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367341));
      ((akdg)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((akdg)localObject).jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378908));
      ((akdg)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364709));
      ((akdg)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      ((akdg)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368853));
      paramView.setTag(localObject);
    }
    for (paramView = (View)localObject;; paramView = (akdg)paramView.getTag())
    {
      a(paramView, localGroups, paramInt, true, 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTypeface(Typeface.SANS_SERIF);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131166979);
    paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor((ColorStateList)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((paramView.getTag() instanceof akhw))
    {
      paramView = (akhw)paramView.getTag();
      if ((paramView.jdField_a_of_type_JavaLangObject instanceof Friends))
      {
        paramView = (Friends)paramView.jdField_a_of_type_JavaLangObject;
        if ((paramView.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (bdal.b(paramView.uin))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    g();
    aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void e() {}
  
  public void f()
  {
    g();
    aupk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    super.f();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
      return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id)).get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    long l2 = 0L;
    if ((localObject instanceof Friends)) {
      localObject = (Friends)localObject;
    }
    do
    {
      long l1;
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
              QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
            }
            l1 = 0L;
          }
        }
        if ((localThrowable1 instanceof PublicAccountInfo)) {
          return ((PublicAccountInfo)localThrowable1).uin;
        }
        l1 = l2;
      } while (!(localThrowable1 instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)localThrowable1;
      try
      {
        l1 = Long.parseLong(localPhoneContact.mobileNo);
        return l1;
      }
      catch (Throwable localThrowable2)
      {
        l1 = l2;
      }
    } while (!QLog.isColorLevel());
    QLog.i("BuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
    return 0L;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    if (getGroupType(paramInt1) == 0)
    {
      if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
        return 1;
      }
      return 0;
    }
    return 99;
  }
  
  public int getChildTypeCount()
  {
    return 6;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    bhxr.a("getChildView");
    akhx localakhx = (akhx)getChild(paramInt1, paramInt2);
    if (localakhx == null) {}
    for (paramView = null;; paramView = localakhx.a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener))
    {
      if (paramView != null)
      {
        a((akia)paramView.getTag(), null);
        if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        paramView.setOnLongClickListener(this.jdField_a_of_type_Akdi);
      }
      bhxr.a();
      return paramView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    if (getGroupType(paramInt) == 1) {
      return 0;
    }
    paramInt = ((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id;
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localList == null) {}
    for (paramInt = 0;; paramInt = localList.size()) {
      return paramInt;
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    if (getGroupType(paramInt) == 0) {
      return ((Groups)getGroup(paramInt)).group_id;
    }
    return 1000L;
  }
  
  public int getGroupType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      QLog.e("BuddyListAdapter", 1, "getGroupType illegal, groupPosition =" + paramInt + ", size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    while ((this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) instanceof String)) {
      return 1;
    }
    return 0;
  }
  
  public int getGroupTypeCount()
  {
    return 2;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    if (getGroupType(paramInt) == 1)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558876, paramViewGroup, false);
        paramViewGroup = (SingleLineTextView)paramView.findViewById(2131378697);
        paramViewGroup.setDefaultTextColor(-8355712);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject = (String)getGroup(paramInt);
        paramViewGroup.setText("");
        return paramView;
        paramViewGroup = (SingleLineTextView)paramView.getTag();
      }
    }
    Object localObject = (Groups)getGroup(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131558879, paramViewGroup, false);
      paramViewGroup = new akdg();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367341));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368762));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364709));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368853));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378908));
      paramView.setTag(paramViewGroup);
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label293;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      paramView.setOnClickListener(this.jdField_a_of_type_Akdh);
      paramView.setOnLongClickListener(this.jdField_a_of_type_Akdi);
      if (paramBoolean) {
        i = 2;
      }
      a(paramViewGroup, (Groups)localObject, paramInt, false, i);
      return paramView;
      paramViewGroup = (akdg)paramView.getTag();
      break;
      label293:
      ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131166979);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
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
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged");
    }
    ThreadManager.postImmediately(new BuddyListAdapter.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    paramView = (akdg)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(paramView.jdField_a_of_type_Int);
    ((axfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91)).a();
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = paramView.getTag();
      if (localObject1 != null) {
        if ((localObject1 instanceof akdg))
        {
          localObject1 = new bdkz();
          ((bdkz)localObject1).a(0, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131693327));
          bdbk.a(paramView, (bdkz)localObject1, this.jdField_b_of_type_AndroidViewView$OnClickListener, null);
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      return bool1;
      if (!(localObject1 instanceof akia)) {
        break;
      }
      Object localObject2 = ((akia)localObject1).jdField_a_of_type_JavaLangObject;
      if ((localObject2 == null) || (!(localObject2 instanceof Friends))) {
        break;
      }
      paramView = (bhpy)bhql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      localObject1 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = (Friends)localObject2;
      localObject1 = ((aloz)localObject1).a(((Friends)localObject2).uin);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(((Friends)localObject2).uin))
      {
        bool1 = bool2;
        if (localObject1 != null)
        {
          if (((SpecialCareInfo)localObject1).globalSwitch == 0) {
            bool1 = bool2;
          }
        }
        else {
          label188:
          if (!bool1) {
            break label240;
          }
        }
        label240:
        for (int i = 2131691118;; i = 2131691119)
        {
          for (;;)
          {
            paramView.b(i);
            paramView.c(2131690648);
            paramView.a(new akde(this, bool1, (Friends)localObject2, paramView));
            try
            {
              paramView.show();
            }
            catch (Exception paramView) {}
          }
          break;
          bool1 = true;
          break label188;
        }
        bool1 = false;
      }
    }
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
    this.jdField_b_of_type_Int = paramInt;
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      c();
      abqw.a().a("list_g_contacts", false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhpo != null) {
        this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
      }
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
      if (paramInt == 0) {
        ApngImage.playByTag(3);
      }
      return;
      abqw.a().a("list_g_contacts");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdd
 * JD-Core Version:    0.7.0.1
 */