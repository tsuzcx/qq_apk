import android.util.LruCache;

class altu
  extends LruCache<String, altv>
{
  altu(altt paramaltt, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, altv paramaltv)
  {
    if ((paramaltv == null) || (paramaltv.a == null)) {
      return 0;
    }
    return paramaltv.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altu
 * JD-Core Version:    0.7.0.1
 */