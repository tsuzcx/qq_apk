import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.ListAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import com.tencent.qphone.base.util.QLog;
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

public class afow
  extends ahzi
{
  public int a;
  public String a;
  public LinkedHashMap<String, List<afou>> a;
  public List<afou> a;
  public int[] a;
  public String[] a;
  public int b;
  public List<String> b;
  public int c;
  public List<String> c;
  public List<oidb_0xa2a.UserInfo> d;
  
  public afow(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment)
  {
    super(paramChatHistoryTroopMemberFragment.getActivity(), paramChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 11)) {
      paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131626267);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramChatHistoryTroopMemberFragment;
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5) {
        paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131630891);
      } else {
        paramChatHistoryTroopMemberFragment = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654653);
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) {
      return 0;
    }
    return 2131493626;
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
      QLog.d("Q.history.BaseFragment", 2, "mAdapter.notifyDataSetChanged2()");
    }
    QLog.d(".troop.troopManagerVASH", 2, new Object[] { "notifyDataSetChanged2 List count: ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size()) });
    Object[] arrayOfObject = a();
    if (arrayOfObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "constructHashStruct result == null!");
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
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.ListAdapter.1(this));
        return;
      }
    } while ((arrayOfObject.length != 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 21)));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 19)) {
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
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131655018, new Object[] { Integer.valueOf(localList.size()) }));
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_Boolean) {
          break label207;
        }
        paramView.setBackgroundResource(2130838503);
      }
      for (;;)
      {
        paramView.setPadding((int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Float), 0, 0, 0);
        return;
        ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
        break;
        label207:
        paramView.setBackgroundResource(2130848799);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) {}
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
    Object localObject6 = (azks)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
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
      afou localafou;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int != 0) {
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
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localafou = (afou)localIterator.next();
        if (((azks)localObject6).b(localafou.jdField_a_of_type_JavaLangString))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 2) || (ChatHistoryTroopMemberFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))) {
            continue;
          }
          ((List)localObject8).add(localafou);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 20))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_JavaLangString.contains(localafou.jdField_a_of_type_JavaLangString))) {
          localArrayList2.add(localafou);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_JavaLangString.contains(localafou.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localafou))) {
          this.jdField_a_of_type_JavaUtilList.add(localafou);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList.contains(localafou.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilList.contains(localafou)))
        {
          this.jdField_a_of_type_JavaUtilList.add(localafou);
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_JavaUtilArrayList.remove(localafou.jdField_a_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 13) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 21))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((localafou.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_JavaUtilList.contains(localafou.jdField_a_of_type_JavaLangString)))) {
          ((List)localObject9).add(localafou);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && (localafou.jdField_b_of_type_Boolean)) {
          localArrayList1.add(localafou);
        }
        if ((!localafou.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (localafou.jdField_d_of_type_Long == 1L)) {
          ((List)localObject10).add(localafou);
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f.equals(localafou.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString.contains(localafou.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((localafou.jdField_a_of_type_Int == 332) || (localafou.jdField_a_of_type_Int == 333))))
      {
        ((List)localObject7).add(localafou);
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "constructHashStruct uin = " + localafou.jdField_a_of_type_JavaLangString + ", name = " + localafou.jdField_g_of_type_JavaLangString + ", level = " + localafou.jdField_a_of_type_Int);
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 5) && (!TextUtils.isEmpty(localafou.u)))
      {
        ((List)localObject7).add(localafou);
      }
      else
      {
        if (localafou.jdField_c_of_type_JavaLangString == null) {
          break label4292;
        }
        if (localafou.jdField_c_of_type_JavaLangString.length() == 0) {
          break label4292;
        }
        for (;;)
        {
          localObject4 = localObject3;
          if (((String)localObject3).length() == 1)
          {
            i = ((String)localObject3).charAt(0);
            if ((65 > i) || (i > 90)) {
              break label4300;
            }
            label807:
            localObject4 = ((String)localObject3).toUpperCase();
          }
          label814:
          if (localObject1.get(localObject4) == null) {
            localObject1.put(localObject4, new ArrayList());
          }
          this.jdField_b_of_type_Int += 1;
          ((List)localObject1.get(localObject4)).add(localafou);
          break;
          localObject3 = localafou.jdField_c_of_type_JavaLangString.substring(0, 1);
        }
      }
    }
    localObject6 = new afox(0, true);
    Object localObject4 = new LinkedHashMap();
    label976:
    label1375:
    char c1;
    label1442:
    label1513:
    Object localObject2;
    label1691:
    label2000:
    label2280:
    label2921:
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 19)
    {
      if (((List)localObject7).size() > 0)
      {
        Collections.sort((List)localObject7, (Comparator)localObject6);
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
        ((LinkedHashMap)localObject4).put(ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment), localObject7);
      }
    }
    else
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.h) {
          localObject1.remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131653834));
        }
        localObject3 = new int[localObject1.keySet().size()];
        localObject4 = new String[localObject3.length];
        ??? = localObject1.keySet().iterator();
        if (localObject3.length != 0) {
          break label4065;
        }
        return new Object[0];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 21)
        {
          this.jdField_a_of_type_Int = 0;
          Collections.sort((List)localObject7, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(ajjy.a(2131635798), this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList);
          break label4323;
        }
        if ((((List)localObject9).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 12))
        {
          Collections.sort((List)localObject9, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131653834), localObject9);
        }
        if ((localArrayList1.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 3))
        {
          Collections.sort(localArrayList1, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654639), localArrayList1);
        }
        if ((((List)localObject10).size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 3))
        {
          Collections.sort((List)localObject10, (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131625743), localObject10);
        }
        if (((List)localObject7).size() > 0)
        {
          Collections.sort((List)localObject7, (Comparator)localObject6);
          this.jdField_c_of_type_Int += ((List)localObject7).size();
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject7, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) {
            break label1442;
          }
        }
        for (localObject3 = ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment);; localObject3 = this.jdField_a_of_type_JavaLangString)
        {
          ((LinkedHashMap)localObject4).put(localObject3, localObject7);
          if (((List)localObject8).size() <= 0) {
            break label4330;
          }
          Collections.sort((List)localObject8, (Comparator)localObject6);
          this.jdField_c_of_type_Int += ((List)localObject8).size();
          ((LinkedHashMap)localObject4).put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654655), localObject8);
          break label4330;
          if (c1 > 'Z') {
            break;
          }
          if (localObject1.get(String.valueOf(c1)) == null) {
            break label4336;
          }
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localObject1.get(String.valueOf(c1)), (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put(String.valueOf(c1), localObject1.get(String.valueOf(c1)));
          break label4336;
        }
        if (localObject1.get("#") != null)
        {
          this.jdField_a_of_type_Int += 1;
          Collections.sort((List)localObject1.get("#"), (Comparator)localObject6);
          ((LinkedHashMap)localObject4).put("#", localObject1.get("#"));
        }
        localObject1.clear();
        break label4323;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 2)
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130903138);
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (afou)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((afou)localObject7).r)) {
              ((afou)localObject7).r = a((String[])localObject4, ((afou)localObject7).jdField_b_of_type_Long, (Calendar)localObject3);
            }
            if (localObject1.get(((afou)localObject7).r) == null) {
              localObject1.put(((afou)localObject7).r, new ArrayList());
            }
            ((List)localObject1.get(((afou)localObject7).r)).add(localObject7);
          }
          localObject3 = new LinkedHashMap();
          i = localObject4.length - 1;
          if (i >= 0)
          {
            if (localObject1.get(localObject4[i]) == null) {
              break label4344;
            }
            Collections.sort((List)localObject1.get(localObject4[i]), new afox(2, false));
            ((LinkedHashMap)localObject3).put(localObject4[i], localObject1.get(localObject4[i]));
            break label4344;
          }
          localObject1.clear();
          localObject2 = localObject3;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 6)
        {
          if (ChatHistoryTroopMemberFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).size() == 0) {
            return null;
          }
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (afou)((Iterator)localObject4).next();
            if (TextUtils.isEmpty(((afou)localObject6).r))
            {
              if (((afou)localObject6).jdField_b_of_type_Long == 0L) {
                ((afou)localObject6).jdField_b_of_type_Long = ((afou)localObject6).jdField_a_of_type_Long;
              }
              ((afou)localObject6).r = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a(((afou)localObject6).jdField_b_of_type_Long, (Calendar)localObject3, ChatHistoryTroopMemberFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment), ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment));
            }
            if (localObject2.get(((afou)localObject6).r) == null) {
              localObject2.put(((afou)localObject6).r, new ArrayList());
            }
            if (!TextUtils.isEmpty(((afou)localObject6).r)) {
              ((List)localObject2.get(((afou)localObject6).r)).add(localObject6);
            }
          }
          localObject3 = new LinkedHashMap();
          i = ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).size() - 1;
          if (i >= 0)
          {
            if (localObject2.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)) == null) {
              break label4351;
            }
            Collections.sort((List)localObject2.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)), new afox(2, false));
            ((LinkedHashMap)localObject3).put(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i), localObject2.get(ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).get(i)));
            break label4351;
          }
          localObject2.clear();
          localObject2 = localObject3;
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int != 3) {
            break;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130903139);
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000L);
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (afou)((Iterator)localObject6).next();
            if (TextUtils.isEmpty(((afou)localObject7).q)) {
              ((afou)localObject7).q = b((String[])localObject4, ((afou)localObject7).jdField_a_of_type_Long, (Calendar)localObject3);
            }
            if (localObject2.get(((afou)localObject7).q) == null) {
              localObject2.put(((afou)localObject7).q, new ArrayList());
            }
            ((List)localObject2.get(((afou)localObject7).q)).add(localObject7);
          }
          localObject3 = new LinkedHashMap();
          i = localObject4.length - 1;
          if (i >= 0)
          {
            if (localObject2.get(localObject4[i]) == null) {
              break label4358;
            }
            Collections.sort((List)localObject2.get(localObject4[i]), new afox(3, false));
            ((LinkedHashMap)localObject3).put(localObject4[i], localObject2.get(localObject4[i]));
            break label4358;
          }
          localObject2.clear();
          localObject2 = localObject3;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 1)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject7 = new ArrayList();
        localObject8 = new ArrayList();
        localObject9 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject9).hasNext())
        {
          localObject10 = (afou)((Iterator)localObject9).next();
          if (((azks)localObject6).b(((afou)localObject10).jdField_a_of_type_JavaLangString))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 5) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 2) && (!ChatHistoryTroopMemberFragment.f(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))) {
              if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((afou)localObject10).jdField_a_of_type_JavaLangString)))
              {
                ((List)localObject3).add(localObject10);
                ((afou)localObject10).jdField_d_of_type_Boolean = true;
              }
              else
              {
                ((List)localObject8).add(localObject10);
                ((afou)localObject10).jdField_d_of_type_Boolean = false;
              }
            }
          }
          else if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.contains(((afou)localObject10).jdField_a_of_type_JavaLangString)))
          {
            ((afou)localObject10).jdField_d_of_type_Boolean = true;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f.equals(((afou)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString.contains(((afou)localObject10).jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) && ((((afou)localObject10).jdField_a_of_type_Int == 332) || (((afou)localObject10).jdField_a_of_type_Int == 333)))) {
              ((List)localObject4).add(localObject10);
            } else {
              ((List)localObject7).add(localObject10);
            }
          }
          else
          {
            ((afou)localObject10).jdField_d_of_type_Boolean = false;
            ((List)localObject8).add(localObject10);
          }
        }
        localObject2.clear();
        Collections.sort((List)localObject3, new afox(1, false));
        if (((List)localObject3).size() > 0) {
          localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654655), localObject3);
        }
        if (((List)localObject4).size() > 0)
        {
          Collections.sort((List)localObject4, new afox(1, false));
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((List)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.f, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_JavaLangString);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.e) {
            break label2921;
          }
        }
        for (localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131629182);; localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131629181))
        {
          localObject2.put(localObject3, localObject4);
          Collections.sort((List)localObject7, new afox(1, false));
          if (((List)localObject7).size() > 0) {
            localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654651), localObject7);
          }
          Collections.sort((List)localObject8, new afox(1, false));
          if (((List)localObject8).size() <= 0) {
            break;
          }
          localObject2.put(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654650), localObject8);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 7)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject6 = new ArrayList();
        localObject7 = new ArrayList();
        j = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size();
        localObject8 = new HashMap(j);
        i = 0;
        while (i < j)
        {
          localObject9 = (afou)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(i);
          ((afou)localObject9).k = 0;
          ((HashMap)localObject8).put(((afou)localObject9).jdField_a_of_type_JavaLangString, localObject9);
          i += 1;
        }
        if (ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
        {
          i = 0;
          label3070:
          if (i < ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
          {
            localObject9 = (afou)((HashMap)localObject8).remove(String.valueOf(ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
            if (localObject9 == null) {
              break label4368;
            }
            ((List)localObject3).add(localObject9);
            break label4368;
          }
        }
        if (ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
        {
          i = 0;
          label3134:
          if (i < ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
          {
            localObject9 = (afou)((HashMap)localObject8).remove(String.valueOf(ChatHistoryTroopMemberFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
            if (localObject9 == null) {
              break label4375;
            }
            ((List)localObject4).add(localObject9);
            break label4375;
          }
        }
        if (ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment) != null)
        {
          i = 0;
          label3198:
          if (i < ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment).length)
          {
            localObject9 = (afou)((HashMap)localObject8).remove(String.valueOf(ChatHistoryTroopMemberFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment)[i]));
            if (localObject9 == null) {
              break label4382;
            }
            ((List)localObject6).add(localObject9);
            break label4382;
          }
        }
        localObject8 = ((HashMap)localObject8).entrySet().iterator();
        while (((Iterator)localObject8).hasNext()) {
          ((List)localObject7).add(((Map.Entry)((Iterator)localObject8).next()).getValue());
        }
        Collections.sort((List)localObject3, new afox(2, true));
        if (!((List)localObject3).isEmpty()) {
          localObject2.put(ajjy.a(2131635811), localObject3);
        }
        if (!((List)localObject4).isEmpty()) {
          localObject2.put(ajjy.a(2131635871), localObject4);
        }
        if (!((List)localObject6).isEmpty()) {
          localObject2.put(ajjy.a(2131635837), localObject6);
        }
        Collections.sort((List)localObject7, new afox(2, true));
        if (((List)localObject7).isEmpty()) {
          break label4389;
        }
        localObject2.put(ajjy.a(2131635796), localObject7);
        break label4389;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 8)
      {
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject6 = new HashMap();
        if (this.jdField_d_of_type_JavaUtilList != null)
        {
          j = this.jdField_d_of_type_JavaUtilList.size();
          i = 0;
          while (i < j)
          {
            localObject7 = (oidb_0xa2a.UserInfo)this.jdField_d_of_type_JavaUtilList.get(i);
            ((HashMap)localObject6).put(String.valueOf(((oidb_0xa2a.UserInfo)localObject7).uin.get()), localObject7);
            i += 1;
          }
        }
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (afou)((Iterator)localObject7).next();
          localObject9 = (oidb_0xa2a.UserInfo)((HashMap)localObject6).get(((afou)localObject8).jdField_a_of_type_JavaLangString);
          if (localObject9 != null)
          {
            ((List)localObject3).add(localObject8);
            ((afou)localObject8).l = ((oidb_0xa2a.UserInfo)localObject9).score.get();
          }
          else
          {
            ((List)localObject4).add(localObject8);
          }
        }
        if (((List)localObject3).size() > 0)
        {
          Collections.sort((List)localObject3, new afox(8, false));
          localObject2.put(ajjy.a(2131635833), localObject3);
        }
        if (((List)localObject4).size() <= 0) {
          break label4392;
        }
        Collections.sort((List)localObject4, new afox(8, false));
        localObject2.put(ajjy.a(2131635826), localObject4);
        break label4392;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int == 4)
      {
        localObject3 = new LinkedHashMap();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getResources().getStringArray(2130903133);
        localObject6 = ajjy.a(2131635802);
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (afou)((Iterator)localObject7).next();
          j = ((afou)localObject8).jdField_a_of_type_Int;
          i = j;
          if (j >= 10000) {
            i = ((afou)localObject8).jdField_a_of_type_Int - 10000;
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
          Collections.sort((List)((LinkedHashMap)localObject3).get(localObject4[i]), new afox(0, false));
          localObject2.put(localObject4[i], ((LinkedHashMap)localObject3).get(localObject4[i]));
        }
      }
      else
      {
        if (((LinkedHashMap)localObject3).get(localObject6) != null)
        {
          Collections.sort((List)((LinkedHashMap)localObject3).get(localObject6), new afox(0, false));
          localObject2.put(localObject6, ((LinkedHashMap)localObject3).get(localObject6));
        }
        yez.a(null, "846", "205607", "", "84601", "1", "145");
        break label976;
        label4065:
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a((int[])localObject3);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "constructHashStruct, time:" + (l2 - l1) + ", sortType:" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_m_of_type_Int + ", listSize:" + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size());
        }
        return new Object[] { localObject2, localObject3, localObject4 };
        label4292:
        localObject3 = "#";
        break;
        label4300:
        if ((97 <= i) && (i <= 122)) {
          break label807;
        }
        localObject4 = "#";
        break label814;
        label4323:
        localObject2 = localObject4;
        break label976;
        label4330:
        c1 = 'A';
        break label1375;
        label4336:
        c1 = (char)(c1 + '\001');
        break label1375;
        label4344:
        i -= 1;
        break label1691;
        label4351:
        i -= 1;
        break label2000;
        label4358:
        i -= 1;
        break label2280;
        break label976;
        label4368:
        i += 1;
        break label3070;
        label4375:
        i += 1;
        break label3134;
        label4382:
        i += 1;
        break label3198;
        label4389:
        break label976;
        label4392:
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList != null) {}
    }
    while (this.jdField_a_of_type_ArrayOfInt.length == 0)
    {
      return 0;
      return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size();
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt <= this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.size() - 1) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    return (afou)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ChatHistoryTroopMemberFragment.e(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment))
    {
      int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (i < 0)
      {
        i = -(i + 1) - 1;
        afou localafou = (afou)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        if ((TextUtils.isEmpty(localafou.jdField_m_of_type_JavaLangString)) && (!TextUtils.isEmpty(localafou.p)) && (!TextUtils.isEmpty(localafou.jdField_g_of_type_JavaLangString)) && (!localafou.jdField_g_of_type_JavaLangString.equals(localafou.p))) {
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
    label65:
    Object localObject1;
    if (paramView == null) {
      if (i == 0)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496951, paramViewGroup, false);
        paramView = new afpb(paramViewGroup, false);
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_n_of_type_Boolean) {
          break label253;
        }
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setBackgroundResource(2130839104);
        paramViewGroup.setTag(paramView);
        localObject1 = paramView;
        paramView = paramViewGroup;
        paramViewGroup = (ViewGroup)localObject1;
        label78:
        paramViewGroup.jdField_a_of_type_JavaLangString = "";
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int != 9) {
          break label277;
        }
        localObject1 = (afou)this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup.g.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.a(paramViewGroup, (afou)localObject1, a(((afou)localObject1).jdField_a_of_type_JavaLangString, 2), false, false);
      }
    }
    label253:
    int j;
    for (;;)
    {
      if ((paramViewGroup.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqWidgetIndexView != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0) {
          break label1024;
        }
        paramViewGroup.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      return paramView;
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496955, paramViewGroup, false);
      paramView = new afpb(paramViewGroup, true);
      break;
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setBackgroundResource(2130839101);
      break label65;
      paramViewGroup = (afpb)paramView.getTag();
      break label78;
      label277:
      j = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
      if (j >= 0) {
        break label649;
      }
      j = -(j + 1) - 1;
      localObject1 = (afou)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1);
      paramViewGroup.g.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(((afou)localObject1).jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(paramInt));
      Object localObject2;
      if (((afou)localObject1).jdField_c_of_type_Boolean)
      {
        localObject2 = new axjq(((afou)localObject1).jdField_b_of_type_JavaLangString, 16).a();
        paramViewGroup.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        bami.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_e_of_type_AndroidWidgetTextView, (Spannable)localObject2);
        paramViewGroup.c.setImageResource(2130839271);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.c);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12)
        {
          if (!this.jdField_a_of_type_JavaUtilList.contains(localObject1)) {
            break label564;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_g_of_type_Boolean) {
          break label576;
        }
        paramViewGroup.f.setVisibility(8);
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment;
        Bitmap localBitmap = a(((afou)localObject1).jdField_a_of_type_JavaLangString, 2);
        if (i == 1) {}
        for (;;)
        {
          ((ChatHistoryTroopMemberFragment)localObject2).a(paramViewGroup, (afou)localObject1, localBitmap, false, bool);
          break;
          bool = false;
        }
        label564:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      label576:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Afph != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_a_of_type_Afph.a(paramViewGroup, (afou)localObject1);
        if (paramViewGroup.f.getVisibility() == 0)
        {
          paramInt = bajr.d(2);
          paramViewGroup.jdField_e_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
          ChatHistoryTroopMemberFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_e_of_type_AndroidWidgetTextView, paramViewGroup.d, ((afou)localObject1).jdField_a_of_type_JavaLangString, paramInt);
        }
      }
    }
    label649:
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setOnClickListener(null);
    paramViewGroup.g.setTag("");
    paramViewGroup.jdField_b_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_AndroidViewView.setTag("");
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setTag(Integer.valueOf(-1));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 9) || (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 19))
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      label766:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.jdField_d_of_type_Int == 12)
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
        paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[j] - 1;
        if ((paramInt >= 0) && (paramInt < ((List)localObject1).size()))
        {
          localObject1 = (afou)((List)localObject1).get(paramInt);
          if (!this.jdField_a_of_type_JavaUtilList.contains(localObject1)) {
            break label1012;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setContentDescription("");
      break;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[j]);
      if (localObject1 == null) {
        break label766;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131654655).equals(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j])))
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]));
        break label766;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[j]) + this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment.getString(2131655018, new Object[] { Integer.valueOf(((List)localObject1).size()) }));
      break label766;
      label1012:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label1024:
    paramViewGroup.jdField_e_of_type_AndroidViewView.setVisibility(8);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afow
 * JD-Core Version:    0.7.0.1
 */