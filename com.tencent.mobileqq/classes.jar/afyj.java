import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap;
import java.util.ArrayList;
import java.util.Iterator;

public class afyj
{
  private static final String jdField_a_of_type_JavaLangString = afyj.class.getSimpleName();
  private StructingMsgItemBuilder.CacheMap jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap = new StructingMsgItemBuilder.CacheMap(null);
  private StructingMsgItemBuilder.CacheMap b = new StructingMsgItemBuilder.CacheMap(null);
  
  private afyk a(String paramString, ViewGroup paramViewGroup)
  {
    Iterator localIterator = this.b.get(paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (afyk)localIterator.next();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.add(new afyk(paramString, paramView, paramViewGroup));
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    afyk localafyk;
    do
    {
      return;
      while (!paramString.hasNext()) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.get(paramString).iterator();
      }
      localafyk = (afyk)paramString.next();
    } while ((localafyk == null) || (localafyk.a() == null) || (localafyk.a() != paramViewGroup));
    localafyk.a().removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$CacheMap.remove(localafyk);
    this.b.add(localafyk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyj
 * JD-Core Version:    0.7.0.1
 */