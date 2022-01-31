import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.commonsdk.cache.Sizeable;

public class aijs
  extends MQLruCache
{
  public aijs(Integer paramInteger)
  {
    super(paramInteger.intValue());
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    if ((paramObject instanceof Bitmap))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    if ((paramObject instanceof BitmapDrawable))
    {
      paramObject = ((BitmapDrawable)paramObject).getBitmap();
      if (paramObject != null)
      {
        int i = paramObject.getRowBytes();
        return paramObject.getHeight() * i;
      }
    }
    else if ((paramObject instanceof Sizeable))
    {
      return ((Sizeable)paramObject).getByteSize();
    }
    MemoryClearManagerNew.a(paramString, MemoryClearManagerNew.m);
    return 204800;
  }
  
  public void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aijs
 * JD-Core Version:    0.7.0.1
 */