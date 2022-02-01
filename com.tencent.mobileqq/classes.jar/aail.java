import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExclusiveGiftItem;

public class aail
{
  public int a;
  public long a;
  public aahz a;
  public aaia a;
  public aaib a;
  public aaio a;
  public aaip a;
  public aaiq a;
  public SparseArray<bgky> a;
  public String a;
  public ArrayList<Object> a;
  public boolean a;
  public int b;
  public SparseArray<bgkz> b;
  public String b;
  public ArrayList<Object> b;
  public int c;
  public String c;
  public ArrayList<Object> c;
  public int d;
  public ArrayList<Object> d;
  public int e;
  public ArrayList<Object> e;
  public ArrayList<aais> f;
  
  public aail(JSONObject paramJSONObject, String paramString)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.jdField_c_of_type_JavaLangString = paramJSONObject.toString();
      try
      {
        Object localObject1 = paramJSONObject.optString("date");
        this.jdField_a_of_type_Long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)localObject1).getTime();
        this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isShowRedDot");
        this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("defaultPackageID");
        this.jdField_a_of_type_Int = paramJSONObject.optInt("defaultPersonalID");
        this.jdField_b_of_type_Int = paramJSONObject.optInt("defaultPublicID");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("defaultQuantity");
        Object localObject6 = paramJSONObject.optJSONArray("items_personal");
        Object localObject4 = paramJSONObject.optJSONArray("items_public");
        Object localObject7 = paramJSONObject.optJSONArray("items_custom");
        Object localObject5 = paramJSONObject.optJSONArray("items_interact");
        JSONArray localJSONArray1 = paramJSONObject.optJSONArray("items_exclusive_lib");
        Object localObject3 = paramJSONObject.optJSONArray("items_package_lib");
        JSONArray localJSONArray2 = paramJSONObject.optJSONArray("items_personal_tab");
        Object localObject2 = paramJSONObject.optJSONArray("items_personal_free_tab");
        localObject1 = paramJSONObject.optJSONArray("web_panel_tab");
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject("operationInfo");
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject("coinInfo");
        if ((localObject7 != null) && (localObject6 != null))
        {
          j = ((JSONArray)localObject7).length();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          if (i < j)
          {
            Object localObject8 = ((JSONArray)localObject7).optJSONObject(i);
            if (localObject8 != null)
            {
              localObject8 = new aaik((JSONObject)localObject8, i);
              if (((aaik)localObject8).jdField_c_of_type_Int <= 4) {
                break label293;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label293:
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject8);
            }
          }
          j = ((JSONArray)localObject6).length();
          i = 0;
          if (i < j)
          {
            localObject7 = ((JSONArray)localObject6).optJSONObject(i);
            if (localObject7 != null)
            {
              localObject7 = new aaik((JSONObject)localObject7, this.jdField_a_of_type_JavaUtilArrayList.size());
              if (((aaik)localObject7).jdField_c_of_type_Int <= 4) {
                break label368;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label368:
              if (((aaik)localObject7).jdField_b_of_type_Int != 0) {
                this.jdField_a_of_type_JavaUtilArrayList.add(localObject7);
              }
            }
          }
        }
        else if (localObject6 != null)
        {
          j = ((JSONArray)localObject6).length();
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          i = 0;
          if (i < j)
          {
            localObject7 = ((JSONArray)localObject6).optJSONObject(i);
            if (localObject7 != null)
            {
              localObject7 = new aaik((JSONObject)localObject7, this.jdField_a_of_type_JavaUtilArrayList.size());
              if (((aaik)localObject7).jdField_c_of_type_Int <= 4) {
                break label467;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label467:
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject7);
            }
          }
        }
        if (localObject5 != null)
        {
          j = ((JSONArray)localObject5).length();
          this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(j);
          i = 0;
          if (i < j)
          {
            localObject6 = ((JSONArray)localObject5).optJSONObject(i);
            if (localObject6 != null)
            {
              localObject6 = new aaik((JSONObject)localObject6, i);
              if (((aaik)localObject6).jdField_c_of_type_Int <= 4) {
                break label554;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label554:
              ((aaik)localObject6).jdField_b_of_type_Boolean = true;
              this.jdField_d_of_type_JavaUtilArrayList.add(localObject6);
            }
          }
        }
        if (localObject4 != null)
        {
          j = ((JSONArray)localObject4).length();
          if (this.jdField_d_of_type_JavaUtilArrayList == null) {
            this.jdField_d_of_type_JavaUtilArrayList = new ArrayList(j);
          }
          i = 0;
          if (i < j)
          {
            localObject5 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject5 != null)
            {
              localObject5 = new aaik((JSONObject)localObject5, this.jdField_d_of_type_JavaUtilArrayList.size());
              if (((aaik)localObject5).jdField_c_of_type_Int <= 2) {
                break label660;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label660:
              this.jdField_d_of_type_JavaUtilArrayList.add(localObject5);
            }
          }
        }
        if (localJSONObject1 != null) {
          this.jdField_a_of_type_Aaiq = new aaiq(localJSONObject1);
        }
        if (localJSONObject2 != null) {
          this.jdField_a_of_type_Aaio = new aaio(localJSONObject2);
        }
        a(localJSONArray1, paramString);
        if (localObject3 != null)
        {
          j = ((JSONArray)localObject3).length();
          if (this.jdField_e_of_type_JavaUtilArrayList == null) {
            this.jdField_e_of_type_JavaUtilArrayList = new ArrayList(j);
          }
          i = 0;
          if (i < j)
          {
            localObject4 = ((JSONArray)localObject3).optJSONObject(i);
            if (localObject4 != null)
            {
              localObject4 = new aaik((JSONObject)localObject4, i);
              if (((aaik)localObject4).jdField_c_of_type_Int <= 4) {
                break label797;
              }
            }
            for (;;)
            {
              i += 1;
              break;
              label797:
              ((aaik)localObject4).jdField_c_of_type_Int = 5;
              ((aaik)localObject4).d = true;
              this.jdField_e_of_type_JavaUtilArrayList.add(localObject4);
            }
          }
        }
        this.jdField_a_of_type_Aahz = aahy.a(paramJSONObject.optJSONObject("activityInfo"));
        localObject3 = paramJSONObject.optJSONObject("profileCard");
        if (localObject3 != null) {
          this.jdField_a_of_type_Aaib = aahy.a(((JSONObject)localObject3).optJSONObject("giftItem"));
        }
        this.jdField_a_of_type_Aaia = aahy.a(paramJSONObject.optJSONObject("panelEntry"));
        paramJSONObject = new HashMap();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((Iterator)localObject3).next();
            if ((localObject4 instanceof aaik))
            {
              localObject4 = (aaik)localObject4;
              paramJSONObject.put(Integer.valueOf(((aaik)localObject4).jdField_a_of_type_Int), localObject4);
            }
          }
        }
        int k;
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          j = ((JSONArray)localObject2).length();
          this.jdField_c_of_type_JavaUtilArrayList = new ArrayList(j);
          i = 0;
          while (i < j)
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 != null)
            {
              localObject3 = new aair((JSONObject)localObject3);
              this.jdField_c_of_type_JavaUtilArrayList.add(localObject3);
              localObject4 = ((aair)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                k = ((Integer)((Iterator)localObject4).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(k))) {
                  ((aair)localObject3).jdField_b_of_type_JavaUtilArrayList.add(paramJSONObject.get(Integer.valueOf(k)));
                }
              }
            }
            i += 1;
          }
        }
        if (localJSONArray2 != null)
        {
          int n = localJSONArray2.length();
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(n);
          }
          j = 0;
          if (j < n)
          {
            localObject2 = localJSONArray2.optJSONObject(j);
            if (localObject2 != null)
            {
              localObject2 = new aair((JSONObject)localObject2);
              if ((!TextUtils.isEmpty(((aair)localObject2).jdField_a_of_type_JavaLangString)) && (((aair)localObject2).jdField_a_of_type_JavaUtilArrayList != null) && (((aair)localObject2).jdField_b_of_type_JavaUtilArrayList != null)) {
                break label1214;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label1214:
              localObject3 = ((aair)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                int i1 = ((Integer)((Iterator)localObject3).next()).intValue();
                if (paramJSONObject.containsKey(Integer.valueOf(i1)))
                {
                  int m = 1;
                  i = m;
                  int i3;
                  if (localJSONArray1 != null)
                  {
                    i3 = localJSONArray1.length();
                    k = 0;
                  }
                  for (;;)
                  {
                    i = m;
                    int i2;
                    if (k < i3)
                    {
                      localObject4 = localJSONArray1.optJSONObject(k);
                      if (localObject4 != null)
                      {
                        i2 = ((JSONObject)localObject4).optInt("packageID");
                        if ((((JSONObject)localObject4).optInt("giftType") != 0) || (i2 != i1)) {}
                      }
                    }
                    else
                    {
                      for (;;)
                      {
                        try
                        {
                          localObject4 = new JSONArray(paramString);
                          i = 0;
                          if (i >= ((JSONArray)localObject4).length()) {
                            break label1615;
                          }
                          k = ((Integer)((JSONArray)localObject4).get(i)).intValue();
                          if (k != i2) {
                            continue;
                          }
                          i = 1;
                        }
                        catch (Exception localException)
                        {
                          if (!QLog.isColorLevel()) {
                            continue;
                          }
                          QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", localException);
                          i = 0;
                          continue;
                        }
                        if (i == 0) {
                          break;
                        }
                        ((aair)localObject2).jdField_b_of_type_JavaUtilArrayList.add(paramJSONObject.get(Integer.valueOf(i1)));
                        break;
                        i += 1;
                      }
                    }
                    k += 1;
                  }
                }
              }
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 0;
          if (this.jdField_b_of_type_JavaUtilArrayList == null) {
            this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          }
          paramJSONObject = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          while (paramJSONObject.hasNext())
          {
            paramString = paramJSONObject.next();
            this.jdField_b_of_type_JavaUtilArrayList.add(i, paramString);
            i += 1;
          }
        }
        if (localObject1 == null) {
          continue;
        }
        int j = ((JSONArray)localObject1).length();
        if (this.f == null) {
          this.f = new ArrayList(j);
        }
        i = 0;
        while (i < j)
        {
          paramJSONObject = ((JSONArray)localObject1).optJSONObject(i);
          if (paramJSONObject != null)
          {
            paramJSONObject = new aais(paramJSONObject);
            this.f.add(paramJSONObject);
          }
          i += 1;
        }
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          continue;
          label1615:
          int i = 0;
        }
      }
    }
  }
  
  public static aail a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, "");
  }
  
  public static aail a(Context paramContext, int paramInt, String paramString)
  {
    long l = System.currentTimeMillis();
    String str = SharePreferenceUtils.get(paramContext, "troop_gift_aio_panel_data_v2_" + paramInt);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        if (paramInt != 5) {
          break label159;
        }
        paramContext = a();
        paramContext = new aail(localJSONObject, paramContext);
        if (!QLog.isColorLevel()) {
          break label157;
        }
        QLog.d("TroopGiftPanel.time", 2, "getLocalGiftData, time=" + (System.currentTimeMillis() - l) + ", data.len=" + str.length());
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        label122:
        if (!QLog.isColorLevel()) {
          break label148;
        }
        QLog.d("zivonchen", 2, QLog.getStackTraceString(paramContext));
      }
      paramContext = a(paramString);
      continue;
      label148:
      return null;
      label157:
      label159:
      do
      {
        paramContext = "";
        break;
        return paramContext;
        if ((paramInt == 1) || (paramInt == 6)) {
          break label122;
        }
      } while (paramInt != 4);
    }
  }
  
  public static String a()
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "exclusive_gift_ids_c2c_" + str;
    localObject = SharePreferenceUtils.get((Context)localObject, str);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "getC2CExclusiveGiftIds, key=" + str + ", data=" + (String)localObject);
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    Object localObject = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramString = "exclusive_gift_ids_troop_" + str + "_" + paramString;
    localObject = SharePreferenceUtils.get((Context)localObject, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "getTroopExclusiveGiftIds, key=" + paramString + ", data=" + (String)localObject);
    }
    return localObject;
  }
  
  public static String a(List<oidb_0x6c3.ExclusiveGiftItem> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localJSONArray.put(((oidb_0x6c3.ExclusiveGiftItem)paramList.get(i)).gift_id.get());
        i += 1;
      }
    }
    return localJSONArray.toString();
  }
  
  public static void a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "exclusive_gift_ids_c2c_" + str;
    SharePreferenceUtils.set(localBaseApplication, str, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAioPanelData", 2, "saveC2CExclusiveGiftIds, key=" + str + ", data=" + paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramString2 = "exclusive_gift_ids_troop_" + str + "_" + paramString2;
      SharePreferenceUtils.set(localBaseApplication, paramString2, paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "saveTroopExclusiveGiftIds, key=" + paramString2 + ", data=" + paramString1);
  }
  
  public static String b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return SharePreferenceUtils.get(localBaseApplication, "troop_gift_last_receiver_" + str + "_" + paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplication.getContext();
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramString1 = "troop_gift_last_receiver_" + str + "_" + paramString1;
      SharePreferenceUtils.set(localBaseApplication, paramString1, paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "saveLastGiftReceiver, key=" + paramString1 + ", data=" + paramString2);
  }
  
  public void a(aaip paramaaip)
  {
    this.jdField_a_of_type_Aaip = paramaaip;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      SharePreferenceUtils.set(paramContext, "troop_gift_aio_panel_data_v2_" + paramInt, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(List<bgky> paramList)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    int i = 0;
    while (i < paramList.size())
    {
      bgky localbgky = (bgky)paramList.get(i);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localbgky.jdField_a_of_type_Int, localbgky);
      i += 1;
    }
  }
  
  protected void a(JSONArray paramJSONArray, String paramString)
  {
    int k = 0;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift jsonArrayExclusive is empty");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift exclusiveGiftIds is empty");
    return;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    label98:
    int j;
    try
    {
      paramString = new JSONArray(paramString);
      if ((paramString.length() > 0) && (paramJSONArray.length() > 0))
      {
        i = 0;
        if (i < paramString.length())
        {
          int m = ((Integer)paramString.get(i)).intValue();
          j = 0;
          label122:
          if (j >= paramJSONArray.length()) {
            break label486;
          }
          JSONObject localJSONObject = paramJSONArray.optJSONObject(j);
          int n = localJSONObject.optInt("packageID");
          int i1 = localJSONObject.optInt("giftType");
          if (m != n) {
            break label493;
          }
          if (i1 == 0) {
            localArrayList2.add(new aaik(localJSONObject, localArrayList2.size()));
          } else if (i1 == 1) {
            localArrayList1.add(new aaik(localJSONObject, localArrayList1.size()));
          }
        }
      }
    }
    catch (Exception paramJSONArray)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift search exp:", paramJSONArray);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAioPanelData", 2, "mergeExclusiveGift, persional.size=" + localArrayList2.size() + ", public.size=" + localArrayList1.size());
      }
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (localArrayList2.size() > 0))
        {
          i = localArrayList2.size() - 1;
          if (i < 0) {
            break label502;
          }
          paramJSONArray = localArrayList2.get(i);
          this.jdField_a_of_type_JavaUtilArrayList.add(0, paramJSONArray);
          i -= 1;
          continue;
          if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            ((aaik)this.jdField_a_of_type_JavaUtilArrayList.get(i)).g = i;
            i += 1;
            continue;
          }
        }
        if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (localArrayList1.size() <= 0)) {
          break;
        }
        i = localArrayList1.size() - 1;
        j = k;
        if (i >= 0)
        {
          paramJSONArray = localArrayList1.get(i);
          this.jdField_d_of_type_JavaUtilArrayList.add(0, paramJSONArray);
          i -= 1;
          continue;
        }
        if (j >= this.jdField_d_of_type_JavaUtilArrayList.size()) {
          break;
        }
        ((aaik)this.jdField_d_of_type_JavaUtilArrayList.get(j)).g = j;
        j += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramJSONArray) {}
      QLog.e("TroopGiftAioPanelData", 2, "mergeExclusiveGift merge exp:", paramJSONArray);
      return;
      label486:
      i += 1;
      break label98;
      label493:
      j += 1;
      break label122;
      label502:
      i = 0;
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size()) && (paramInt < this.jdField_c_of_type_JavaUtilArrayList.size()) && ((this.jdField_b_of_type_JavaUtilArrayList.get(paramInt) instanceof aair)))
    {
      aair localaair1 = (aair)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      if ((this.jdField_c_of_type_JavaUtilArrayList.get(paramInt) instanceof aair))
      {
        aair localaair2 = (aair)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt);
        if ((localaair2.jdField_a_of_type_JavaLangString != null) && (localaair2.jdField_a_of_type_JavaLangString.equals(localaair1.jdField_a_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(List<bgkz> paramList)
  {
    int j = 0;
    this.jdField_b_of_type_AndroidUtilSparseArray.clear();
    int i = 0;
    Object localObject;
    while (i < paramList.size())
    {
      localObject = (bgkz)paramList.get(i);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(((bgkz)localObject).jdField_a_of_type_Int, localObject);
      i += 1;
    }
    if (this.jdField_e_of_type_JavaUtilArrayList != null)
    {
      paramList = new ArrayList();
      i = j;
      if (this.jdField_e_of_type_JavaUtilArrayList != null)
      {
        i = j;
        if (this.jdField_e_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          while (i < this.jdField_e_of_type_JavaUtilArrayList.size())
          {
            localObject = (aaik)this.jdField_e_of_type_JavaUtilArrayList.get(i);
            if (this.jdField_b_of_type_AndroidUtilSparseArray.get(((aaik)localObject).jdField_a_of_type_Int) != null)
            {
              ((aaik)localObject).g = i;
              paramList.add(localObject);
            }
            i += 1;
          }
          this.jdField_e_of_type_JavaUtilArrayList.clear();
          this.jdField_e_of_type_JavaUtilArrayList.addAll(paramList);
          paramList.clear();
          i = j;
        }
      }
      while (i < this.jdField_e_of_type_JavaUtilArrayList.size())
      {
        ((aaik)this.jdField_e_of_type_JavaUtilArrayList.get(i)).g = i;
        i += 1;
      }
      if (this.jdField_e_of_type_JavaUtilArrayList.size() > this.jdField_e_of_type_Int) {
        ((aaik)this.jdField_e_of_type_JavaUtilArrayList.get(this.jdField_e_of_type_Int)).jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aail
 * JD-Core Version:    0.7.0.1
 */