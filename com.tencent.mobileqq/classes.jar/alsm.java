import common.qzone.component.cache.common.SoftHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class alsm
  implements Iterator
{
  int jdField_a_of_type_Int;
  alsj jdField_a_of_type_Alsj = null;
  Object jdField_a_of_type_JavaLangObject = null;
  int jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
  alsj jdField_b_of_type_Alsj = null;
  Object jdField_b_of_type_JavaLangObject = null;
  
  alsm(SoftHashMap paramSoftHashMap)
  {
    if (paramSoftHashMap.size() != 0) {}
    for (int i = SoftHashMap.a(paramSoftHashMap).length;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  protected alsj a()
  {
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    if ((this.jdField_a_of_type_JavaLangObject == null) && (!hasNext())) {
      throw new NoSuchElementException();
    }
    this.jdField_b_of_type_Alsj = this.jdField_a_of_type_Alsj;
    this.jdField_a_of_type_Alsj = alsj.a(this.jdField_a_of_type_Alsj);
    this.jdField_b_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = null;
    return this.jdField_b_of_type_Alsj;
  }
  
  public boolean hasNext()
  {
    alsj[] arrayOfalsj = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    while (this.jdField_a_of_type_JavaLangObject == null)
    {
      alsj localalsj = this.jdField_a_of_type_Alsj;
      int i = this.jdField_a_of_type_Int;
      while ((localalsj == null) && (i > 0))
      {
        i -= 1;
        localalsj = arrayOfalsj[i];
      }
      this.jdField_a_of_type_Alsj = localalsj;
      this.jdField_a_of_type_Int = i;
      if (localalsj == null)
      {
        this.jdField_b_of_type_JavaLangObject = null;
        return false;
      }
      this.jdField_a_of_type_JavaLangObject = localalsj.get();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_Alsj = alsj.a(this.jdField_a_of_type_Alsj);
      }
    }
    return true;
  }
  
  public void remove()
  {
    if (this.jdField_b_of_type_Alsj == null) {
      throw new IllegalStateException();
    }
    if (SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap) != this.jdField_b_of_type_Int) {
      throw new ConcurrentModificationException();
    }
    this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap.remove(this.jdField_b_of_type_JavaLangObject);
    this.jdField_b_of_type_Int = SoftHashMap.a(this.jdField_b_of_type_CommonQzoneComponentCacheCommonSoftHashMap);
    this.jdField_b_of_type_Alsj = null;
    this.jdField_b_of_type_JavaLangObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsm
 * JD-Core Version:    0.7.0.1
 */