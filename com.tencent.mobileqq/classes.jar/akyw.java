import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class akyw
  implements alcc
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private akzo jdField_a_of_type_Akzo = new akyy(this);
  private alaa jdField_a_of_type_Alaa;
  private Context jdField_a_of_type_AndroidContentContext;
  bdqc jdField_a_of_type_Bdqc = new akyx(this);
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public akyw(alaa paramalaa, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ApolloTextureView paramApolloTextureView)
  {
    this.jdField_a_of_type_Alaa = paramalaa;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdqc);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 1;
    }
    if (paramInt2 == 9) {
      return 2;
    }
    return 0;
  }
  
  public List<akzy> a(aknx paramaknx)
  {
    Object localObject1 = null;
    if (paramaknx == null) {
      return localObject1;
    }
    label784:
    for (;;)
    {
      ArrayList localArrayList;
      akzy localakzy;
      int i;
      akny localakny;
      JSONObject localJSONObject;
      try
      {
        Object localObject3 = paramaknx.jdField_a_of_type_JavaUtilHashMap;
        if (localObject3 == null) {
          break;
        }
        localArrayList = new ArrayList();
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label638;
        }
        localakzy = new akzy();
        localObject1 = (Map.Entry)((Iterator)localObject3).next();
        if (localObject1 == null) {
          continue;
        }
        i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
        localakzy.jdField_a_of_type_Int = i;
        localakny = (akny)((Map.Entry)localObject1).getValue();
        if ((localakny == null) || (localakny.a == null) || (localakny.a.size() <= 0)) {
          continue;
        }
        localakzy.g = a(localakny.c, localakny.b);
        localObject1 = new File(alef.f + i + "/config.json");
        if (((File)localObject1).exists()) {
          localObject1 = bdcs.a((File)localObject1);
        }
      }
      finally {}
      try
      {
        localJSONObject = new JSONObject(new String((byte[])localObject1, "UTF-8"));
        if ((localJSONObject.has("isShowInCard")) && (localJSONObject.getInt("isShowInCard") == 0)) {
          continue;
        }
        localObject1 = localJSONObject.optString("name");
        if (!localJSONObject.has("showName")) {
          break label784;
        }
        if (!TextUtils.isEmpty(localJSONObject.getString("showName"))) {
          break label581;
        }
      }
      catch (Exception localException)
      {
        label581:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloGuestsPresenter", 2, "initTag e=" + localException.toString());
        continue;
      }
      localakzy.h = ((Integer)aknx.jdField_a_of_type_JavaUtilMap.get(localakny.a.get(0))).intValue();
      if ((localObject1 != null) && (((String)localObject1).length() > 5))
      {
        localObject1 = ((String)localObject1).substring(0, 4);
        localakzy.jdField_a_of_type_JavaLangString = (aknx.jdField_a_of_type_ArrayOfJavaLangString[localakzy.h] + (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onGetDressRect((String)localakny.a.get(0));
        if ((localObject1 != null) && ((((RectF)localObject1).bottom != ((RectF)localObject1).top) || (((RectF)localObject1).left != ((RectF)localObject1).right)))
        {
          localakzy.d = (((int)((RectF)localObject1).top + (int)((RectF)localObject1).bottom) / 2);
          localakzy.f = ((int)((RectF)localObject1).left);
          localakzy.e = ((int)((RectF)localObject1).right);
          localakzy.i = paramaknx.e;
          localakzy.j = paramaknx.f;
          localArrayList.add(localakzy);
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloGuestsPresenter", 2, "item.name =" + localakzy.jdField_a_of_type_JavaLangString + " item.y = " + localakzy.d + " item.left = " + localakzy.f + " item.right = " + localakzy.e);
            continue;
            localObject1 = null;
            continue;
            localObject1 = localJSONObject.getString("showName");
          }
        }
      }
      else
      {
        continue;
        label638:
        if (localArrayList.size() > 4)
        {
          Collections.sort(localArrayList, new akyz(this));
          i = localArrayList.size() - 1;
          while (i >= 4)
          {
            localArrayList.remove(i);
            i -= 1;
          }
        }
        Collections.sort(localArrayList);
        int j = 0;
        i = 0;
        label702:
        if (j < localArrayList.size())
        {
          ((akzy)localArrayList.get(j)).b = i;
          ((akzy)localArrayList.get(j)).c = ((int)(123.0F * this.jdField_a_of_type_Float));
          if (i == 0) {
            i = 1;
          }
        }
        for (;;)
        {
          j += 1;
          break label702;
          if (i == 1)
          {
            i = 0;
            continue;
            Object localObject2 = localArrayList;
            break;
          }
        }
      }
    }
  }
  
  public void a()
  {
    int i = 99999;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cmshow_zan", 0).getInt("apollo_zan_count" + this.jdField_a_of_type_JavaLangString, 0);
    String str = String.valueOf(j);
    if (j >= 99999) {
      str = 99999 + "+";
    }
    for (;;)
    {
      this.jdField_a_of_type_Alaa.a(str, i, i);
      ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_JavaLangString, 256, "myApollo");
      return;
      i = j;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_JavaLangString, "myApollo");
    }
  }
  
  public void c()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    Object localObject1 = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_JavaLangString);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress();
      if (localObject1 != null)
      {
        i = ((aknx)localObject1).jdField_a_of_type_Int;
        localObject2 = ((aknx)localObject1).a();
        localObject1 = localObject2;
        if (i > 0)
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localObject2.length > 0)
            {
              localObject1 = localObject2;
              if (!albu.a(this.jdField_a_of_type_JavaLangString, i, (int[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Akzo)) {
                localObject1 = akzg.a(i);
              }
            }
          }
        }
        if (i >= 0) {
          break label206;
        }
        i = j;
      }
    }
    label206:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length > 0) {}
      }
      else
      {
        localObject2 = akzg.a(i);
      }
      if (this.jdField_a_of_type_Alaa != null) {
        this.jdField_a_of_type_Alaa.a((int[])localObject2, i);
      }
      this.jdField_a_of_type_Int = i;
      return;
      ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).b(this.jdField_a_of_type_JavaLangString);
      for (;;)
      {
        localObject2 = null;
        i = 0;
        break;
        ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).b(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localObject = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (this.jdField_a_of_type_Alaa == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null));
    Object localObject = a(((ApolloBaseInfo)localObject).getApolloDress());
    this.jdField_a_of_type_Alaa.b((List)localObject);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdqc);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyw
 * JD-Core Version:    0.7.0.1
 */