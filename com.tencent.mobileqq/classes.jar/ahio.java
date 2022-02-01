import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap;
import java.util.ArrayList;
import java.util.Iterator;

public class ahio
{
  private static final String jdField_a_of_type_JavaLangString = ahio.class.getSimpleName();
  private StructingMsgItemBuilder.CacheMap jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap = new StructingMsgItemBuilder.CacheMap(null);
  private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
  
  private ahip a(String paramString, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.b.get(paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (ahip)localIterator.next();
      if (paramString != null) {
        paramString.a(paramViewGroup);
      }
    }
    for (;;)
    {
      this.b.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.add(paramString);
      return paramString;
      paramString = null;
    }
  }
  
  public View a(String paramString, ViewGroup paramViewGroup)
  {
    a(paramString, paramViewGroup);
    paramString = a(paramString, paramViewGroup);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.clear();
    this.b.clear();
  }
  
  public void a(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.add(new ahip(paramString, paramView, paramViewGroup));
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    ahip localahip;
    do
    {
      return;
      while (!paramString.hasNext()) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.get(paramString).iterator();
      }
      localahip = (ahip)paramString.next();
    } while ((localahip == null) || (localahip.a() == null) || (localahip.a() != paramViewGroup));
    localahip.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.remove(localahip);
    this.b.add(localahip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahio
 * JD-Core Version:    0.7.0.1
 */