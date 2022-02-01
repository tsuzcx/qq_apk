import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class ahtw
  extends GridLayoutManager.SpanSizeLookup
{
  ahtw(ahtv paramahtv) {}
  
  public int getSpanSize(int paramInt)
  {
    switch (this.a.getItemViewType(paramInt))
    {
    case 1: 
    default: 
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtw
 * JD-Core Version:    0.7.0.1
 */