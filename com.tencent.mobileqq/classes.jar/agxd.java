import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class agxd
  extends GridLayoutManager.SpanSizeLookup
{
  agxd(agxc paramagxc) {}
  
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
 * Qualified Name:     agxd
 * JD-Core Version:    0.7.0.1
 */