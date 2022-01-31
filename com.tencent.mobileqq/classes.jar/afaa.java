import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class afaa
  extends GridLayoutManager.SpanSizeLookup
{
  afaa(aezz paramaezz) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afaa
 * JD-Core Version:    0.7.0.1
 */