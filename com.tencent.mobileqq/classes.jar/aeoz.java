import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

public class aeoz
  extends alif
{
  public int a;
  public String a;
  public LinkedHashMap<String, List<aeox>> a;
  public List<aeox> a;
  public int[] a;
  public String[] a;
  public int b;
  public List<String> b;
  public int c;
  public List<String> c;
  public List<String> d;
  public List<oidb_0xa2a.UserInfo> e;
  
  public aeoz(TroopMemberListActivity paramTroopMemberListActivity)
  {
    super(paramTroopMemberListActivity, paramTroopMemberListActivity.app, paramTroopMemberListActivity.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 11)) {
      paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131691649);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramTroopMemberListActivity;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131695789);
      } else {
        paramTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719265);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {
      return 0;
    }
    return 2131559320;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public String a(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    if (paramLong == 0L) {
      return paramArrayOfString[7];
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
    if (i <= 0) {
      return paramArrayOfString[0];
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    return paramArrayOfString[6];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size()) });
    Object[] arrayOfObject = a();
    if (arrayOfObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct result == null!");
      }
    }
    do
    {
      return;
      if (arrayOfObject.length >= 3)
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)arrayOfObject[0]);
        this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject[1]);
        this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])arrayOfObject[2]);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.runOnUiThread(new TroopMemberListActivity.ListAdapter.1(this));
        return;
      }
    } while ((arrayOfObject.length != 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 21)));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19)) {
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
    while ((this.jdField_a_of_type_ArrayOfInt.length <= 0) || (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0)) {
      return;
    }
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1) - 1;
    }
    for (;;)
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      if ((localList != null) && (localList.size() > 1))
      {
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719731, new Object[] { Integer.valueOf(localList.size()) }));
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k) {
          break label207;
        }
        paramView.setBackgroundResource(2130838891);
      }
      for (;;)
      {
        paramView.setPadding((int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Float), 0, 0, 0);
        return;
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        break;
        label207:
        paramView.setBackgroundResource(2130850014);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {}
    while (Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) < 0) {
      return false;
    }
    return true;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public Object[] a()
  {
    long l1 = System.currentTimeMillis();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject6 = (bfdm)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getManager(203);
    Object localObject9;
    Object localObject10;
    Object localObject7;
    ArrayList localArrayList1;
    Object localObject8;
    Object localObject3;
    int i;
    for (;;)
    {
      ArrayList localArrayList2;
      aeox localaeox;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int != 0) {
          break label1513;
        }
        localObject9 = new ArrayList();
        localObject10 = new ArrayList();
        localObject7 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject8 = new ArrayList();
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_c_of_type_Int = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaeox = (aeox)localIterator.next();
        if (((bfdm)localObject6).b(localaeox.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 2) || (TroopMemberListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))) {
            continue;
          }
          ((List)localObject8).add(localaeox);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 20))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_JavaLangString.contains(localaeox.jdField_a_of_type_JavaLangString))) {
          localArrayList2.add(localaeox);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.l != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.l.contains(localaeox.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localaeox))) {
          this.jdField_a_of_type_JavaUtilList.add(localaeox);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList.contains(localaeox.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localaeox)))
        {
          this.jdField_a_of_type_JavaUtilList.add(localaeox);
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_JavaUtilArrayList.remove(localaeox.jdField_a_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 21))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((localaeox.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_JavaUtilList.contains(localaeox.jdField_a_of_type_JavaLangString)))) {
          ((List)localObject9).add(localaeox);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && (localaeox.jdField_b_of_type_Boolean)) {
          localArrayList1.add(localaeox);
        }
        if ((!localaeox.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app.getCurrentAccountUin())) && (localaeox.jdField_d_of_type_Long == 1L)) {
          ((List)localObject10).add(localaeox);
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString.equals(localaeox.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f.contains(localaeox.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((localaeox.jdField_a_of_type_Int == 332) || (localaeox.jdField_a_of_type_Int == 333))))
      {
        ((List)localObject7).add(localaeox);
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "constructHashStruct uin = " + localaeox.jdField_a_of_type_JavaLangString + ", name = " + localaeox.g + ", level = " + localaeox.jdField_a_of_type_Int);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 5) && (!TextUtils.isEmpty(localaeox.u)))
      {
        ((List)localObject7).add(localaeox);
      }
      else
      {
        if (localaeox.jdField_c_of_type_JavaLangString == null) {
          break label4523;
        }
        if (localaeox.jdField_c_of_type_JavaLangString.length() == 0) {
          break label4523;
        }
        for (;;)
        {
          localObject4 = localObject3;
          if (((String)localObject3).length() == 1)
          {
            i = ((String)localObject3).charAt(0);
            if ((65 > i) || (i > 90)) {
              break label4531;
            }
            label807:
            localObject4 = ((String)localObject3).toUpperCase();
          }
          label814:
          if (localObject1.get(localObject4) == null) {
            localObject1.put(localObject4, new ArrayList());
          }
          this.jdField_b_of_type_Int += 1;
          ((List)localObject1.get(localObject4)).add(localaeox);
          break;
          localObject3 = localaeox.jdField_c_of_type_JavaLangString.substring(0, 1);
        }
      }
    }
    localObject6 = new aepa(0, true);
    Object localObject4 = new LinkedHashMap();
    label976:
    label1375:
    char c1;
    label1442:
    label1513:
    Object localObject2;
    label1687:
    label1999:
    label2279:
    label2920:
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19)
    {
      if (((List)localObject7).size() > 0)
      {
        Collections.sort((List)localObject7, (Comparator)localObject6);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
        ((LinkedHashMap)localObject4).put(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity), localObject7);
      }
    }
    else
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_Boolean) {
          localObject1.remove(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131718566));
        }
        localObject3 = new int[localObject1.keySet().size()];
        localObject4 = new String[localObject3.length];
        ??? = localObject1.keySet().iterator();
        if (localObject3.length != 0) {
          break label4296;
        }
        return new Object[0];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_Int = 0;
          Collections.sort((List)localObject7, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(amtj.a(2131714600), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList);
          break label4554;
        }
        if ((((List)localObject9).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 12))
        {
          Collections.sort((List)localObject9, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131718566), localObject9);
        }
        if ((localArrayList1.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 3))
        {
          Collections.sort(localArrayList1, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719240), localArrayList1);
        }
        if ((((List)localObject10).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 3))
        {
          Collections.sort((List)localObject10, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131691191), localObject10);
        }
        if (((List)localObject7).size() > 0)
        {
          Collections.sort((List)localObject7, (Comparator)localObject6);
          this.jdField_c_of_type_Int += ((List)localObject7).size();
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
            break label1442;
          }
        }
        for (localObject3 = TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity);; localObject3 = this.jdField_a_of_type_JavaLangString)
        {
          ((LinkedHashMap)localObject4).put(localObject3, localObject7);
          if (((List)localObject8).size() <= 0) {
            break label4561;
          }
          Collections.sort((List)localObject8, (Comparator)localObject6);
          this.jdField_c_of_type_Int += ((List)localObject8).size();
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719267), localObject8);
          break label4561;
          if (c1 > 'Z') {
            break;
          }
          if (localObject1.get(String.valueOf(c1)) == null) {
            break label4567;
          }
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localObject1.get(String.valueOf(c1)), (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(String.valueOf(c1), localObject1.get(String.valueOf(c1)));
          break label4567;
        }
        if (localObject1.get("#") != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localObject1.get("#"), (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put("#", localObject1.get("#"));
        }
        localObject1.clear();
        break label4554;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 2)
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2130968678);
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (aeox)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((aeox)localObject7).r)) {
              ((aeox)localObject7).r = a((String[])localObject4, ((aeox)localObject7).jdField_b_of_type_Long, (Calendar)localObject3);
            }
            if (localObject1.get(((aeox)localObject7).r) == null) {
              localObject1.put(((aeox)localObject7).r, new ArrayList());
            }
            ((List)localObject1.get(((aeox)localObject7).r)).add(localObject7);
          }
          localObject3 = new LinkedHashMap();
          i = 0;
          if (i < localObject4.length)
          {
            if (localObject1.get(localObject4[i]) == null) {
              break label4575;
            }
            Collections.sort((List)localObject1.get(localObject4[i]), new aepa(2, true));
            ((LinkedHashMap)localObject3).put(localObject4[i], localObject1.get(localObject4[i]));
            break label4575;
          }
          localObject1.clear();
          localObject2 = localObject3;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 6)
        {
          if (TroopMemberListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).size() == 0) {
            return null;
          }
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (aeox)((Iterator)localObject4).next();
            if (TextUtils.isEmpty(((aeox)localObject6).r))
            {
              if (((aeox)localObject6).jdField_b_of_type_Long == 0L) {
                ((aeox)localObject6).jdField_b_of_type_Long = ((aeox)localObject6).jdField_a_of_type_Long;
              }
              ((aeox)localObject6).r = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a(((aeox)localObject6).jdField_b_of_type_Long, (Calendar)localObject3, TroopMemberListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity), TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity));
            }
            if (localObject2.get(((aeox)localObject6).r) == null) {
              localObject2.put(((aeox)localObject6).r, new ArrayList());
            }
            if (!TextUtils.isEmpty(((aeox)localObject6).r)) {
              ((List)localObject2.get(((aeox)localObject6).r)).add(localObject6);
            }
          }
          localObject3 = new LinkedHashMap();
          i = TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).size() - 1;
          if (i >= 0)
          {
            if (localObject2.get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)) == null) {
              break label4582;
            }
            Collections.sort((List)localObject2.get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)), new aepa(2, false));
            ((LinkedHashMap)localObject3).put(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i), localObject2.get(TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).get(i)));
            break label4582;
          }
          localObject2.clear();
          localObject2 = localObject3;
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int != 3) {
            break;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2130968679);
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (aeox)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((aeox)localObject7).q)) {
              ((aeox)localObject7).q = b((String[])localObject4, ((aeox)localObject7).jdField_a_of_type_Long, (Calendar)localObject3);
            }
            if (localObject2.get(((aeox)localObject7).q) == null) {
              localObject2.put(((aeox)localObject7).q, new ArrayList());
            }
            ((List)localObject2.get(((aeox)localObject7).q)).add(localObject7);
          }
          localObject3 = new LinkedHashMap();
          i = localObject4.length - 1;
          if (i >= 0)
          {
            if (localObject2.get(localObject4[i]) == null) {
              break label4589;
            }
            Collections.sort((List)localObject2.get(localObject4[i]), new aepa(3, false));
            ((LinkedHashMap)localObject3).put(localObject4[i], localObject2.get(localObject4[i]));
            break label4589;
          }
          localObject2.clear();
          localObject2 = localObject3;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 1)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject7 = new ArrayList();
        localObject8 = new ArrayList();
        localObject9 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject9).hasNext())
        {
          localObject10 = (aeox)((Iterator)localObject9).next();
          if (((bfdm)localObject6).b(((aeox)localObject10).jdField_a_of_type_JavaLangString))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 5) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 2) && (!TroopMemberListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))) {
              if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((aeox)localObject10).jdField_a_of_type_JavaLangString)))
              {
                ((List)localObject3).add(localObject10);
                ((aeox)localObject10).jdField_d_of_type_Boolean = true;
              }
              else
              {
                ((List)localObject8).add(localObject10);
                ((aeox)localObject10).jdField_d_of_type_Boolean = false;
              }
            }
          }
          else if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((aeox)localObject10).jdField_a_of_type_JavaLangString)))
          {
            ((aeox)localObject10).jdField_d_of_type_Boolean = true;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString.equals(((aeox)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f.contains(((aeox)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) && ((((aeox)localObject10).jdField_a_of_type_Int == 332) || (((aeox)localObject10).jdField_a_of_type_Int == 333)))) {
              ((List)localObject4).add(localObject10);
            } else {
              ((List)localObject7).add(localObject10);
            }
          }
          else
          {
            ((aeox)localObject10).jdField_d_of_type_Boolean = false;
            ((List)localObject8).add(localObject10);
          }
        }
        localObject2.clear();
        Collections.sort((List)localObject3, new aepa(1, false));
        if (((List)localObject3).size() > 0) {
          localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719267), localObject3);
        }
        if (((List)localObject4).size() > 0)
        {
          Collections.sort((List)localObject4, new aepa(1, false));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((List)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.f);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_b_of_type_Boolean) {
            break label2920;
          }
        }
        for (localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131694226);; localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131694225))
        {
          localObject2.put(localObject3, localObject4);
          Collections.sort((List)localObject7, new aepa(1, false));
          if (((List)localObject7).size() > 0) {
            localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719263), localObject7);
          }
          Collections.sort((List)localObject8, new aepa(1, false));
          if (((List)localObject8).size() <= 0) {
            break;
          }
          localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719262), localObject8);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 7)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size();
        localObject8 = new HashMap(j);
        i = 0;
        while (i < j)
        {
          localObject9 = (aeox)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(i);
          ((aeox)localObject9).l = 0;
          ((HashMap)localObject8).put(((aeox)localObject9).jdField_a_of_type_JavaLangString, localObject9);
          i += 1;
        }
        if (TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null)
        {
          i = 0;
          label3069:
          if (i < TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
          {
            localObject9 = (aeox)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
            if (localObject9 == null) {
              break label4599;
            }
            ((List)localObject3).add(localObject9);
            break label4599;
          }
        }
        if (TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null)
        {
          i = 0;
          label3133:
          if (i < TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
          {
            localObject9 = (aeox)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
            if (localObject9 == null) {
              break label4606;
            }
            ((List)localObject4).add(localObject9);
            break label4606;
          }
        }
        if (TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity) != null)
        {
          i = 0;
          label3197:
          if (i < TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity).length)
          {
            localObject9 = (aeox)((HashMap)localObject8).remove(String.valueOf(TroopMemberListActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)[i]));
            if (localObject9 == null) {
              break label4613;
            }
            ((List)localObject6).add(localObject9);
            break label4613;
          }
        }
        localObject8 = ((HashMap)localObject8).entrySet().iterator();
        while (((Iterator)localObject8).hasNext()) {
          ((List)localObject7).add(((Map.Entry)((Iterator)localObject8).next()).getValue());
        }
        Collections.sort((List)localObject3, new aepa(2, true));
        if (!((List)localObject3).isEmpty()) {
          localObject2.put(amtj.a(2131714633), localObject3);
        }
        if (!((List)localObject4).isEmpty()) {
          localObject2.put(amtj.a(2131714607), localObject4);
        }
        if (!((List)localObject6).isEmpty()) {
          localObject2.put(amtj.a(2131714652), localObject6);
        }
        Collections.sort((List)localObject7, new aepa(2, true));
        if (((List)localObject7).isEmpty()) {
          break label4620;
        }
        localObject2.put(amtj.a(2131714599), localObject7);
        break label4620;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 8)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject6 = new HashMap();
        if (this.e != null)
        {
          j = this.e.size();
          i = 0;
          while (i < j)
          {
            localObject7 = (oidb_0xa2a.UserInfo)this.e.get(i);
            ((HashMap)localObject6).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject7).uin.get()), localObject7);
            i += 1;
          }
        }
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (aeox)((Iterator)localObject7).next();
          localObject9 = (oidb_0xa2a.UserInfo)((HashMap)localObject6).get(((aeox)localObject8).jdField_a_of_type_JavaLangString);
          if (localObject9 != null)
          {
            ((List)localObject3).add(localObject8);
            ((aeox)localObject8).jdField_m_of_type_Int = ((oidb_0xa2a.UserInfo)localObject9).score.get();
          }
          else
          {
            ((List)localObject4).add(localObject8);
          }
        }
        if (((List)localObject3).size() > 0)
        {
          Collections.sort((List)localObject3, new aepa(8, false));
          localObject2.put(amtj.a(2131714613), localObject3);
        }
        if (((List)localObject4).size() <= 0) {
          break label4623;
        }
        Collections.sort((List)localObject4, new aepa(8, false));
        localObject2.put(amtj.a(2131714667), localObject4);
        break label4623;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 4)
      {
        localObject3 = new LinkedHashMap();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getResources().getStringArray(2130968673);
        localObject6 = amtj.a(2131714601);
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (aeox)((Iterator)localObject7).next();
          j = ((aeox)localObject8).jdField_a_of_type_Int;
          i = j;
          if (j >= 10000) {
            i = ((aeox)localObject8).jdField_a_of_type_Int - 10000;
          }
          if ((i >= 321) && (i <= 327))
          {
            localObject9 = localObject4[(i - 321)];
            if (((LinkedHashMap)localObject3).get(localObject9) == null) {
              ((LinkedHashMap)localObject3).put(localObject9, new ArrayList());
            }
            ((List)((LinkedHashMap)localObject3).get(localObject9)).add(localObject8);
          }
          else
          {
            if (((LinkedHashMap)localObject3).get(localObject6) == null) {
              ((LinkedHashMap)localObject3).put(localObject6, new ArrayList());
            }
            ((List)((LinkedHashMap)localObject3).get(localObject6)).add(localObject8);
          }
        }
        i = localObject4.length - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (((LinkedHashMap)localObject3).get(localObject4[i]) != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject3).get(localObject4[i]), new aepa(0, false));
          localObject2.put(localObject4[i], ((LinkedHashMap)localObject3).get(localObject4[i]));
        }
      }
      else
      {
        if (((LinkedHashMap)localObject3).get(localObject6) != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject3).get(localObject6), new aepa(0, false));
          localObject2.put(localObject6, ((LinkedHashMap)localObject3).get(localObject6));
        }
        abet.a(null, "846", "205607", "", "84601", "1", "145");
        break label976;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int == 5)
        {
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject7).hasNext())
          {
            localObject8 = (aeox)((Iterator)localObject7).next();
            if (!((bfdm)localObject6).b(((aeox)localObject8).jdField_a_of_type_JavaLangString)) {
              if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.contains(((aeox)localObject8).jdField_a_of_type_JavaLangString)))
              {
                ((aeox)localObject8).jdField_d_of_type_Boolean = true;
                ((List)localObject3).add(localObject8);
              }
              else
              {
                ((aeox)localObject8).jdField_d_of_type_Boolean = false;
                ((List)localObject4).add(localObject8);
              }
            }
          }
          localObject2.clear();
          Collections.sort((List)localObject3, new aepa(0, false));
          if (((List)localObject3).size() > 0) {
            localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719162), localObject3);
          }
          Collections.sort((List)localObject4, new aepa(0, false));
          if (((List)localObject4).size() > 0) {
            localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719161), localObject4);
          }
        }
        break label976;
        label4296:
        localObject3[0] = 0;
        i = 1;
        while (i < localObject3.length)
        {
          j = localObject3[i];
          int k = localObject3[(i - 1)];
          localObject3[i] = (((List)localObject2.get(((Iterator)???).next())).size() + k + 1 + j);
          i += 1;
        }
        ??? = localObject2.keySet().iterator();
        i = 0;
        while (((Iterator)???).hasNext())
        {
          localObject4[i] = ((String)((Iterator)???).next());
          i += 1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((int[])localObject3);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_m_of_type_Int + ", listSize:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size());
        }
        return new Object[] { localObject2, localObject3, localObject4 };
        label4523:
        localObject3 = "#";
        break;
        label4531:
        if ((97 <= i) && (i <= 122)) {
          break label807;
        }
        localObject4 = "#";
        break label814;
        label4554:
        localObject2 = localObject4;
        break label976;
        label4561:
        c1 = 'A';
        break label1375;
        label4567:
        c1 = (char)(c1 + '\001');
        break label1375;
        label4575:
        i += 1;
        break label1687;
        label4582:
        i -= 1;
        break label1999;
        label4589:
        i -= 1;
        break label2279;
        break label976;
        label4599:
        i += 1;
        break label3069;
        label4606:
        i += 1;
        break label3133;
        label4613:
        i += 1;
        break label3197;
        label4620:
        break label976;
        label4623:
        break label976;
      }
      i -= 1;
    }
  }
  
  public String b(String[] paramArrayOfString, long paramLong, Calendar paramCalendar)
  {
    Calendar localCalendar = Calendar.getInstance();
    if (paramLong > 0L) {
      localCalendar.setTimeInMillis(1000L * paramLong);
    }
    int i;
    for (;;)
    {
      i = (paramCalendar.get(1) - localCalendar.get(1)) * 365 + paramCalendar.get(6) - localCalendar.get(6);
      if (i > 0) {
        break;
      }
      return paramArrayOfString[0];
      localCalendar.set(1, 2012);
      localCalendar.set(2, 5);
      localCalendar.set(5, 1);
    }
    if (i <= 7) {
      return paramArrayOfString[1];
    }
    if (i <= 30) {
      return paramArrayOfString[2];
    }
    if (i <= 90) {
      return paramArrayOfString[3];
    }
    if (i <= 180) {
      return paramArrayOfString[4];
    }
    if (i <= 365) {
      return paramArrayOfString[5];
    }
    if (i <= 730) {
      return paramArrayOfString[6];
    }
    if (i <= 1095) {
      return paramArrayOfString[7];
    }
    if (i <= 1825) {
      return paramArrayOfString[8];
    }
    if (i <= 2555) {
      return paramArrayOfString[9];
    }
    if (i <= 3650) {
      return paramArrayOfString[10];
    }
    return paramArrayOfString[11];
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList != null) {}
    }
    while (this.jdField_a_of_type_ArrayOfInt.length == 0)
    {
      return 0;
      return this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size();
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt <= this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.size() - 1) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    do
    {
      return localObject1;
      i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      localObject1 = localObject2;
    } while (i >= 0);
    int i = -(i + 1) - 1;
    return (aeox)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (TroopMemberListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity))
    {
      int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (i < 0)
      {
        i = -(i + 1) - 1;
        aeox localaeox = (aeox)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if ((TextUtils.isEmpty(localaeox.jdField_m_of_type_JavaLangString)) && (!TextUtils.isEmpty(localaeox.p)) && (!TextUtils.isEmpty(localaeox.g)) && (!localaeox.g.equals(localaeox.p))) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    int i = getItemViewType(paramInt);
    Object localObject1;
    label67:
    Object localObject2;
    if (paramView == null) {
      if (i == 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562924, paramViewGroup, false);
        paramView = new aepe((View)localObject1, false);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.k) {
          break label282;
        }
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setBackgroundResource(2130839437);
        ((View)localObject1).setTag(paramView);
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
        label83:
        ((aepe)localObject1).jdField_a_of_type_JavaLangString = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int != 9) {
          break label307;
        }
        localObject2 = (aeox)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
        ((aepe)localObject1).g.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_b_of_type_AndroidViewView.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_a_of_type_AndroidViewView.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a((aepe)localObject1, (aeox)localObject2, a(((aeox)localObject2).jdField_a_of_type_JavaLangString, 2), false, false);
        label195:
        if ((((aepe)localObject1).jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0) {
            break label1094;
          }
          ((aepe)localObject1).jdField_e_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562928, paramViewGroup, false);
      paramView = new aepe((View)localObject1, true);
      break;
      label282:
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setBackgroundResource(2130839434);
      break label67;
      localObject1 = (aepe)paramView.getTag();
      break label83;
      label307:
      int j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (j < 0)
      {
        j = -(j + 1) - 1;
        localObject2 = (aeox)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1);
        ((aepe)localObject1).g.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_b_of_type_AndroidViewView.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_a_of_type_AndroidViewView.setTag(((aeox)localObject2).jdField_a_of_type_JavaLangString);
        ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        Object localObject3;
        if (((aeox)localObject2).jdField_c_of_type_Boolean)
        {
          localObject3 = new bczs(((aeox)localObject2).jdField_b_of_type_JavaLangString, 16).a();
          ((aepe)localObject1).jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          bgdk.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, ((aepe)localObject1).jdField_e_of_type_AndroidWidgetTextView, (Spannable)localObject3);
          ((aepe)localObject1).c.setImageResource(2130839608);
          ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12)
          {
            if (!this.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
              break label605;
            }
            ((aepe)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Boolean) {
            break label618;
          }
          ((aepe)localObject1).f.setVisibility(8);
          break;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
          Bitmap localBitmap = a(((aeox)localObject2).jdField_a_of_type_JavaLangString, 2);
          if (i == 1) {}
          for (;;)
          {
            ((TroopMemberListActivity)localObject3).a((aepe)localObject1, (aeox)localObject2, localBitmap, false, bool);
            break;
            bool = false;
          }
          label605:
          ((aepe)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        label618:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Azwa == null) {
          break label195;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_a_of_type_Azwa.a((aepe)localObject1, (aeox)localObject2);
        if (((aepe)localObject1).f.getVisibility() != 0) {
          break label195;
        }
        i = VipUtils.d(2);
        ((aepe)localObject1).jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(i);
        TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, ((aepe)localObject1).jdField_e_of_type_AndroidWidgetTextView, ((aepe)localObject1).d, ((aeox)localObject2).jdField_a_of_type_JavaLangString, i);
        break label195;
      }
      ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
      ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
      ((aepe)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((aepe)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
      ((aepe)localObject1).g.setTag("");
      ((aepe)localObject1).jdField_b_of_type_AndroidViewView.setTag("");
      ((aepe)localObject1).jdField_a_of_type_AndroidViewView.setTag("");
      ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 19))
      {
        ((aepe)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label826:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.jdField_d_of_type_Int == 12)
        {
          localObject2 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
          i = paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1;
          if ((i >= 0) && (i < ((List)localObject2).size()))
          {
            localObject2 = (aeox)((List)localObject2).get(i);
            if (!this.jdField_a_of_type_JavaUtilList.contains(localObject2)) {
              break label1081;
            }
            ((aepe)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        ((aepe)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
        break;
        ((aepe)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject2 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
        if (localObject2 == null) {
          break label826;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719267).equals(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j])))
        {
          ((aepe)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]));
          break label826;
        }
        ((aepe)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getString(2131719731, new Object[] { Integer.valueOf(((List)localObject2).size()) }));
        break label826;
        label1081:
        ((aepe)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      label1094:
      ((aepe)localObject1).jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoz
 * JD-Core Version:    0.7.0.1
 */