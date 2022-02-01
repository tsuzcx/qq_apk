import android.arch.lifecycle.MutableLiveData;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ahvh
{
  ahvv jdField_a_of_type_Ahvv;
  private MutableLiveData<Integer> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray;
  private Map<Class<? extends BaseChatPie>, Integer> jdField_a_of_type_JavaUtilMap;
  private final int[] jdField_a_of_type_ArrayOfInt = { 1000, 1004, 1006, 1003, 1005, 1021, 1022, 1023, 1025, 10004, 10008, 10009, 10010 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_audio", "chat_tool_gaudio", "chat_tool_gaudio_new", "chat_tool_poke", "chat_tool_gift_clicked", "chat_tool_gift_stranger_clicked", "chat_tool_tencentdoc" };
  SparseArray<String> b;
  
  int a(Class<? extends BaseChatPie> paramClass)
  {
    a();
    paramClass = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    if (paramClass == null) {
      return 0;
    }
    return paramClass.intValue();
  }
  
  MutableLiveData<Integer> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  PlusPanelAppInfo a(int paramInt)
  {
    return this.jdField_a_of_type_Ahvv.a(paramInt);
  }
  
  String a(int paramInt)
  {
    a();
    return (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  ArrayList<ahvd> a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ahvv.a(paramBaseChatPie);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Ahvv.a();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (PlusPanelAppInfo)localList.get(i);
      localObject = this.jdField_a_of_type_Ahvv.a(paramBaseChatPie, (PlusPanelAppInfo)localObject, i);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if ((!localArrayList.isEmpty()) && (this.jdField_a_of_type_Ahvv.a() >= 0)) {
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.setValue(Integer.valueOf(this.jdField_a_of_type_Ahvv.a()));
    }
    return localArrayList;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864054, "0");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1200000003, "1");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864064, "2");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864066, "3");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1200000002, "23");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864068, "4");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1101487426, "5");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(100719166, "6");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(101847385, "6");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864070, "8");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(101761547, "24");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104651886, "11");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1106658188, "22");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104864062, "12");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104639410, "13");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1101678813, "14");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104536706, "15");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104445552, "17");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1104874204, "18");
      this.jdField_a_of_type_AndroidUtilSparseArray.put(1200000005, "21");
    }
    if (this.b == null)
    {
      this.b = new SparseArray();
      this.b.put(201, "0");
      this.b.put(202, "1");
      this.b.put(206, "3");
      this.b.put(208, "4");
      this.b.put(205, "5");
      this.b.put(219, "6");
      this.b.put(213, "7");
    }
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_a_of_type_JavaUtilMap.put(TroopChatPie.class, Integer.valueOf(1));
      this.jdField_a_of_type_JavaUtilMap.put(afzr.class, Integer.valueOf(6));
      this.jdField_a_of_type_JavaUtilMap.put(aidd.class, Integer.valueOf(3));
      this.jdField_a_of_type_JavaUtilMap.put(agab.class, Integer.valueOf(2));
      this.jdField_a_of_type_JavaUtilMap.put(ahyl.class, Integer.valueOf(2));
      this.jdField_a_of_type_JavaUtilMap.put(aifq.class, Integer.valueOf(2));
      this.jdField_a_of_type_JavaUtilMap.put(aift.class, Integer.valueOf(7));
      this.jdField_a_of_type_JavaUtilMap.put(aiag.class, Integer.valueOf(7));
    }
  }
  
  void a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Ahvv = new ahwa().a(paramBaseChatPie, paramBoolean);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(paramString2, 0);
    Object localObject1 = "";
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = arrayOfString[i];
      if (!TextUtils.equals(paramString1, (CharSequence)localObject2)) {
        break label117;
      }
      localObject1 = localObject2;
    }
    label117:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString1 + "_" + paramString2;
      }
      localSharedPreferences.edit().putBoolean((String)localObject2, false).apply();
      return;
    }
  }
  
  int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  String b(int paramInt)
  {
    a();
    return (String)this.b.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvh
 * JD-Core Version:    0.7.0.1
 */