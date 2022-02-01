import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class aabk
  extends GridLayoutManager.SpanSizeLookup
{
  aabk(aabj paramaabj) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = aabj.a(this.a, paramInt);
    aabp localaabp = this.a.a(paramInt);
    if (localaabp != null) {
      return localaabp.getSpanCount(localaabp.getLocalPosition(paramInt));
    }
    return ((GridLayoutManager)aabj.a(this.a)).getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabk
 * JD-Core Version:    0.7.0.1
 */