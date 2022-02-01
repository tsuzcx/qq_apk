package j.a.a;

import android.content.Context;

abstract class b
{
  protected static boolean objectEquals(Object paramObject1, Object paramObject2)
  {
    return ((paramObject1 == null) && (paramObject2 == null)) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  abstract int P(double paramDouble);
  
  abstract void a(c paramc);
  
  abstract void a(String paramString, boolean paramBoolean, Context paramContext);
  
  abstract void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext);
  
  abstract String esX();
  
  abstract int getCurrentPosition();
  
  abstract int getDuration();
  
  abstract boolean hRs();
  
  abstract void mb(Context paramContext);
  
  abstract void p(String paramString, Context paramContext);
  
  abstract void pause();
  
  abstract void release();
  
  abstract void seek(int paramInt);
  
  abstract void stop();
  
  abstract void u(double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     j.a.a.b
 * JD-Core Version:    0.7.0.1
 */