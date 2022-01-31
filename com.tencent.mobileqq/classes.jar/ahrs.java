import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.4;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.5;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.6;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ahrs
  extends akll
  implements View.OnClickListener, View.OnLongClickListener, bhux, bhwx, bibg
{
  public int a;
  public alrk a;
  ameq jdField_a_of_type_Ameq = new ahry(this);
  protected Context a;
  protected bibk a;
  public QQAppInterface a;
  public HashSet<Integer> a;
  public List<Integer> a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int[] a;
  private int b;
  public List<awge> b;
  protected int[] b;
  private int c;
  public List<aklz> c;
  protected int[] c;
  public List<aklz> d = new ArrayList();
  public List<aklz> e = new ArrayList();
  public List<aklz> f = new ArrayList();
  public List<aklz> g = new ArrayList();
  
  public ahrs(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(5);
    this.jdField_a_of_type_Int = -2;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_c_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = aepi.a(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = aepi.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_Bibk = new ahrt(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296691) }, -1, new int[] { 2131370214, 2131370214 }, new int[] { 2131693304, 2131693302 }, new int[] { 2130839330, 2130839330 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
    this.jdField_a_of_type_Alrk = ((alrk)paramQQAppInterface.getManager(53));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return 0;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return 0;
    case 0: 
      return 0;
    case 4: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 10: 
      return 4;
    }
    return 5;
  }
  
  private int a(List<aklz> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      aklz localaklz = (aklz)paramList.next();
      if ((localaklz.a == null) || (!(localaklz.a instanceof TroopInfo)) || (((TroopInfo)localaklz.a).lastMsgTime <= 0L)) {
        break label100;
      }
      i += 1;
    }
    label100:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
      }
      return i;
    }
  }
  
  private awge a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return (awge)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
    case 4: 
      return ((aklz)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
    case 6: 
      return ((aklz)this.d.get(paramInt2)).a;
    case 2: 
      return ((aklz)this.e.get(paramInt2)).a;
    case 8: 
      return ((aklz)this.f.get(paramInt2)).a;
    }
    return ((aklz)this.g.get(paramInt2)).a;
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
    int i;
    label107:
    int k;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      if (j <= 10)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
        if (j > 10) {
          break label286;
        }
        k = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
      return;
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      j = this.d.size();
      i = a(this.d);
      break;
      j = this.e.size();
      i = a(this.e);
      break;
      j = this.f.size();
      i = a(this.f);
      break;
      j = this.g.size();
      i = a(this.g);
      break;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label107;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      break label107;
      label286:
      k = i;
      if (i < 10) {
        k = 10;
      }
    }
  }
  
  private void a(akhv paramakhv)
  {
    int k = 0;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      i = 0;
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)) {
        break label100;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2) {
        this.jdField_a_of_type_ArrayOfInt[i] = 1;
      }
      i += 1;
      continue;
      i = paramakhv.jdField_a_of_type_Int;
      break;
      label100:
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j))
        {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(j);
          this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(j));
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
  }
  
  private void a(akhv paramakhv, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int j;
    int k;
    label117:
    String str2;
    label131:
    label187:
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramakhv != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      default: 
        i = 0;
        str1 = "";
        j = 0;
        if (j <= 10)
        {
          k = j;
          if (j > 10) {
            break label607;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label630;
          }
          str2 = k + "/" + j;
          localStringBuilder1 = paramakhv.jdField_a_of_type_JavaLangStringBuilder;
          localStringBuilder2 = localStringBuilder1;
          if (AppSetting.c)
          {
            if (localStringBuilder1 != null) {
              break label655;
            }
            localStringBuilder1 = new StringBuilder(24);
            label219:
            localStringBuilder1.append(str1 + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
          paramakhv.jdField_a_of_type_Int = paramInt;
          paramakhv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
          paramakhv.b.setVisibility(8);
          paramakhv.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramakhv.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramakhv.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText(str2);
          if (AppSetting.c) {
            localStringBuilder2.append("共" + j + "个" + str1);
          }
          paramakhv.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
          if (AppSetting.c)
          {
            if (!paramakhv.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label670;
            }
            localStringBuilder2.append(" 已展开");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramakhv.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setContentDescription(localStringBuilder2.toString());
      bczz.a(paramakhv.jdField_a_of_type_AndroidWidgetCheckBox, false);
      return;
      str1 = alud.a(2131702948);
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      str1 = alud.a(2131716213);
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      str1 = alud.a(2131716216);
      j = this.d.size();
      i = a(this.d);
      break;
      str1 = alud.a(2131716209);
      j = this.e.size();
      i = a(this.e);
      break;
      str1 = alud.a(2131716214);
      j = this.f.size();
      i = a(this.f);
      break;
      str1 = alud.a(2131702964);
      j = this.g.size();
      i = a(this.g);
      break;
      k = i;
      if (i >= 10) {
        break label117;
      }
      k = 10;
      break label117;
      label607:
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label131;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      notifyDataSetChanged();
      break label131;
      label630:
      str2 = "" + j;
      break label187;
      label655:
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label219;
      label670:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void a(akmt paramakmt, DiscussionInfo paramDiscussionInfo)
  {
    bdeq.a(true);
    Intent localIntent = aepi.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramakmt.jdField_b_of_type_Int)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).a();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfInt.length) && (paramInt2 > this.jdField_b_of_type_ArrayOfInt[paramInt1]);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    label168:
    int i;
    label170:
    int j;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          if (localHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
            if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
              break label427;
            }
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
        a(i);
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.a(i);
      if ((i < this.jdField_a_of_type_ArrayOfInt.length) && (this.jdField_a_of_type_ArrayOfInt[i] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(j)))
      {
        j = a(i);
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(j) }).a();
      }
      i += 1;
      break label170;
      break;
      this.jdField_a_of_type_Boolean = true;
      break label168;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label168;
      }
      localObject = ((String)localObject).split("_");
      j = localObject.length;
      i = 0;
      label394:
      if (i >= j) {
        break label168;
      }
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label420:
        i += 1;
        break label394;
        label427:
        j = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label420;
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      localStringBuffer = new StringBuffer();
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((Integer)localIterator.next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void i()
  {
    ThreadManager.post(new ContactsTroopAdapter.6(this, (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()), 8, null, true);
  }
  
  public int a()
  {
    return 2131558878;
  }
  
  public void a()
  {
    h();
  }
  
  protected void a(int paramInt, bibj[] paramArrayOfbibj, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfbibj.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfbibj[0].jdField_b_of_type_Int = paramInt;
            paramArrayOfbibj[0].jdField_a_of_type_Int = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfbibj.length) {
          break label97;
        }
        paramArrayOfbibj[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfbibj[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
        break;
        paramInt = 0;
      }
    }
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
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof akhv))
    {
      localObject = new akhv();
      ((akhv)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368775));
      ((akhv)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367351));
      ((akhv)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((akhv)localObject).b = ((SingleLineTextView)paramView.findViewById(2131378965));
      ((akhv)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364710));
      ((akhv)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      ((akhv)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368868));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label180;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(paramInt));
      return;
      paramView = (akhv)paramView.getTag();
      break;
      label180:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166981);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public void a(View paramView, int paramInt, akmp paramakmp, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_Bibk != null) {}
    for (int i = this.jdField_a_of_type_Bibk.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramakmp, paramOnClickListener);; i = 0)
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (paramInt != this.jdField_a_of_type_Int) {
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
  
  public void a(TroopInfo paramTroopInfo, amnz paramamnz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramamnz.a(paramTroopInfo.troopuin, 1).lastmsgtime;
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
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof akhv)) {
      a((akhv)paramExpandableListView);
    }
    return true;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.b(i);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(null);
      int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(null);
          localView.setOnLongClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562759, null);
      paramView = (TextView)paramViewGroup.findViewById(2131366728);
      localObject = alud.a(2131702936) + this.jdField_c_of_type_ArrayOfInt[paramInt1] + ")";
      paramView.setText((CharSequence)localObject);
      paramViewGroup.setOnClickListener(new ahru(this, paramInt1));
      paramViewGroup.setOnTouchListener(new ahrv(this, paramView));
      paramViewGroup.setContentDescription((String)localObject + alud.a(2131702909));
    }
    label479:
    label504:
    do
    {
      return paramViewGroup;
      TroopInfo localTroopInfo;
      int i;
      if ((paramView == null) || (!(paramView.getTag() instanceof akmt)))
      {
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562760, null);
        ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
        paramViewGroup = new akmt();
        paramView = this.jdField_a_of_type_Bibk.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.g = ((View)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377607));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377609));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367819));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370086));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377006));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370823));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131378344));
        localObject = paramView.getResources().getColorStateList(2131166910);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        localObject = a(paramInt1, paramInt2);
        if ((localObject == null) || (!(localObject instanceof TroopInfo))) {
          break label963;
        }
        localTroopInfo = (TroopInfo)localObject;
        paramViewGroup.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localTroopInfo;
        paramViewGroup.jdField_a_of_type_Int = 4;
        paramViewGroup.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localTroopInfo.troopuin);
        if (i != 3) {
          break label786;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849841);
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
          break label827;
        }
        localObject = localTroopInfo.getTroopName();
        localTextView.setText((CharSequence)localObject);
        if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
          break label837;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
        if (QLog.isColorLevel()) {
          QLog.d("ContactsTroopAdapter", 2, "TroopInfo hasSetTroopName:" + localTroopInfo.hasSetTroopName() + " | memberNum:" + localTroopInfo.wMemberNumClient);
        }
        if ((localTroopInfo.lastMsgTime == 0L) && ((localTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
          break label896;
        }
        if (localTroopInfo.dwAuthGroupType != 2L) {
          break label850;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setBackgroundResource(2130843430);
        if (localTroopInfo.troopCreditLevel != 2L) {
          break label909;
        }
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849844);
      }
      for (;;)
      {
        if (AppSetting.c) {
          paramViewGroup.g.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
        }
        a(paramViewGroup, null);
        paramView.setOnClickListener(this);
        paramView.setOnLongClickListener(this);
        a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, this, localTroopInfo);
        return paramView;
        paramViewGroup = (akmt)paramView.getTag();
        break;
        if (i == 1)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          break label479;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839303);
        break label479;
        localObject = localTroopInfo.troopuin;
        break label504;
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label565;
        if (localTroopInfo.dwAuthGroupType == 1L)
        {
          paramViewGroup.d.setVisibility(0);
          paramViewGroup.d.setBackgroundResource(2130843430);
          break label671;
        }
        paramViewGroup.d.setVisibility(8);
        break label671;
        paramViewGroup.d.setVisibility(8);
        break label671;
        if (localTroopInfo.troopCreditLevel == 1L)
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849842);
        }
        else
        {
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
      {
        localObject = (DiscussionInfo)localObject;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
        paramViewGroup.jdField_a_of_type_Int = 101;
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((DiscussionInfo)localObject).discussionName);
        i = this.jdField_a_of_type_Alrk.a(((DiscussionInfo)localObject).uin);
        if ((!((DiscussionInfo)localObject).hasRenamed()) && (i > 0))
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + ((DiscussionInfo)localObject).hasRenamed() + " | memberNum:" + i + " | uin:" + ((DiscussionInfo)localObject).uin + "  discussionName:" + ((DiscussionInfo)localObject).discussionName);
          }
          if ((((DiscussionInfo)localObject).lastMsgTime != 0L) || (AppSetting.c)) {
            paramViewGroup.g.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
          }
          a(paramViewGroup, null);
          paramView.setOnClickListener(this);
          paramView.setOnLongClickListener(this);
          a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, this, localObject);
          return paramView;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    label565:
    label827:
    label837:
    label850:
    QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
    label671:
    label963:
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      i = 0;
      return i;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
      {
        j = i;
        if (this.jdField_b_of_type_ArrayOfInt[paramInt] < i) {
          j = this.jdField_b_of_type_ArrayOfInt[paramInt] + 1;
        }
      }
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount count:" + j + "  groupPosition:" + paramInt);
      return j;
      i = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      continue;
      i = this.jdField_c_of_type_JavaUtilList.size();
      continue;
      i = this.d.size();
      continue;
      i = this.e.size();
      continue;
      i = this.f.size();
      continue;
      i = this.g.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558878, paramViewGroup, false);
      paramViewGroup = new akhv();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367351));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368775));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView = ((SimpleTextView)paramView.findViewById(2131364710));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368868));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131378965));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (akhv)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_c_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166981);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setTextColor(localColorStateList);
    }
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b == null)
    {
      ThreadManager.postImmediately(new ContactsTroopAdapter.4(this), null, false);
      return;
    }
    i();
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int i;
    if ((paramView instanceof akhv))
    {
      a((akhv)paramView);
      paramView = (akhv)paramView;
      a(paramView.jdField_a_of_type_Int);
      if ((paramView.jdField_a_of_type_Int >= 0) && (paramView.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length))
      {
        if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
          break label158;
        }
        i = 0;
        if ((this.jdField_a_of_type_ArrayOfInt[paramView.jdField_a_of_type_Int] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.c(i)))
        {
          i = a(paramView.jdField_a_of_type_Int);
          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).a();
        }
      }
    }
    label158:
    do
    {
      return;
      i = paramView.jdField_a_of_type_Int;
      break;
      if ((paramView instanceof akmt))
      {
        localObject = (akmt)paramView;
        if ((((akmt)localObject).jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
        {
          a((akmt)localObject, (DiscussionInfo)((akmt)localObject).jdField_a_of_type_JavaLangObject);
          return;
        }
        paramView = (TroopInfo)((akmt)localObject).jdField_a_of_type_JavaLangObject;
        int j;
        switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(((akmt)localObject).jdField_b_of_type_Int)).intValue())
        {
        case 1: 
        case 3: 
        case 5: 
        case 7: 
        case 9: 
        default: 
          i = 0;
          switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramView.troopuin))
          {
          default: 
            j = 0;
          }
          break;
        }
        for (;;)
        {
          if (((akmt)localObject).jdField_a_of_type_Boolean) {
            new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramView.troopuin, String.valueOf(i) }).a();
          }
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramView.troopuin + "", String.valueOf(i), j + "", "");
          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramView.troopuin, String.valueOf(i) }).a();
          if (i == 5) {
            new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramView.troopuin }).a();
          }
          bdeq.a(true);
          localObject = aepi.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
          ((Intent)localObject).putExtra("uin", paramView.troopuin);
          if (paramView.troopcode != null) {
            ((Intent)localObject).putExtra("troop_uin", paramView.troopcode);
          }
          ((Intent)localObject).putExtra("uintype", 1);
          ((Intent)localObject).putExtra("uinname", paramView.getTroopName());
          ((Intent)localObject).putExtra("open_chatfragment_withanim", true);
          ((Intent)localObject).putExtra("isFromContactTab", true);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          return;
          i = 0;
          break;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          i = 4;
          break;
          i = 5;
          break;
          j = 0;
          continue;
          j = 2;
          continue;
          j = 3;
          continue;
          j = 1;
        }
      }
    } while (!(paramView instanceof TroopInfo));
    Object localObject = (TroopInfo)paramView;
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(((TroopInfo)localObject).troopuin);
    paramView = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    label806:
    label828:
    azqx localazqx;
    label900:
    String str;
    if (bool)
    {
      i = 1;
      if (!paramView.a(((TroopInfo)localObject).troopcode, i)) {
        break label952;
      }
      if (!bool) {
        break label954;
      }
      paramView = "Clk_uncommgrp";
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", paramView, 0, 0, ((TroopInfo)localObject).troopuin, "", "", "");
      localazqx = new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label961;
      }
      paramView = "Clk_unstick";
      localazqx = localazqx.d(paramView);
      str = ((TroopInfo)localObject).troopuin;
      if (!((TroopInfo)localObject).hasSetTroopHead()) {
        break label968;
      }
    }
    label952:
    label954:
    label961:
    label968:
    for (paramView = "1";; paramView = "0")
    {
      localazqx.a(new String[] { str, paramView }).a();
      return;
      i = 0;
      break label806;
      break;
      paramView = "Clk_setcommgrp";
      break label828;
      paramView = "Clk_stick";
      break label900;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = 2131693302;
    Object localObject1 = paramView.getParent();
    Object localObject2 = null;
    while ((localObject1 != null) && (localObject2 == null)) {
      if ((localObject1 instanceof HeaderScrollView)) {
        localObject2 = (HeaderScrollView)localObject1;
      } else if ((localObject1 instanceof View)) {
        localObject1 = ((View)localObject1).getParent();
      } else {
        localObject1 = null;
      }
    }
    if ((localObject2 != null) && (((HeaderScrollView)localObject2).jdField_a_of_type_Boolean)) {
      return false;
    }
    paramView = paramView.getTag();
    boolean bool;
    if ((paramView != null) && ((paramView instanceof akmp)))
    {
      paramView = ((akmp)paramView).jdField_a_of_type_JavaLangObject;
      if (paramView != null) {
        if ((paramView instanceof TroopInfo))
        {
          localObject1 = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
          localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          paramView = (TroopInfo)paramView;
          bool = ((TroopManager)localObject2).b(paramView.troopuin);
          if (bool)
          {
            i = 2131693302;
            ((bhuf)localObject1).b(i);
            ((bhuf)localObject1).c(2131690648);
            ((bhuf)localObject1).a(new ahrw(this, bool, paramView, (bhuf)localObject1));
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ((bhuf)localObject1).show();
        bool = true;
        return bool;
        i = 2131693304;
        break;
        if (!(paramView instanceof DiscussionInfo)) {
          continue;
        }
        localObject1 = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
        localObject2 = (alri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
        paramView = (DiscussionInfo)paramView;
        bool = ((alri)localObject2).a(paramView);
        if (bool)
        {
          ((bhuf)localObject1).b(i);
          ((bhuf)localObject1).c(2131690648);
          ((bhuf)localObject1).a(new ahrx(this, (alri)localObject2, paramView, bool, (bhuf)localObject1));
          try
          {
            ((bhuf)localObject1).show();
          }
          catch (Exception paramView) {}
          continue;
        }
        i = 2131693304;
        continue;
      }
      catch (Exception paramView)
      {
        continue;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrs
 * JD-Core Version:    0.7.0.1
 */