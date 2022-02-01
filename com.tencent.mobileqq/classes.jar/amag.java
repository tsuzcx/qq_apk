import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "webPageData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "getWebPageData", "()Landroid/arch/lifecycle/MutableLiveData;", "onArkLoadState", "", "state", "", "onArkMsgToClient", "params", "", "onArkMsgToWeb", "requestAndCompareAdCode", "originAdCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amag
  extends ViewModel
{
  public static final amah a;
  @NotNull
  private final MutableLiveData<amaq> a;
  
  static
  {
    jdField_a_of_type_Amah = new amah(null);
  }
  
  public amag()
  {
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  }
  
  @NotNull
  public final MutableLiveData<amaq> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkLoadComplete  state: " + paramInt);
    }
    this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.postValue(new amaq(2, null, null, null, paramInt, 0, 46, null));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    aoor.a((aoou)new amai(this, paramString, "qq_weather", false));
  }
  
  public final void b(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToWeb  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.optInt("type") == 1)
      {
        i = localJSONObject.optJSONObject("data").optInt("height");
        this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.postValue(new amaq(0, "receive_ark_msg", paramString, null, 0, i, 24, null));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
        int i = 0;
      }
    }
  }
  
  public final void c(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToClient  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).optInt("type") == 1)
      {
        localObject = ((JSONObject)localObject).optJSONObject("data").optString("bg_url");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          MutableLiveData localMutableLiveData = this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "bgUrl");
          localMutableLiveData.postValue(new amaq(1, null, null, (String)localObject, 0, 0, 54, null));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amag
 * JD-Core Version:    0.7.0.1
 */