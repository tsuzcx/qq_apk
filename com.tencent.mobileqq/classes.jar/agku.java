import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class agku
{
  private long jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_update_time", System.currentTimeMillis());
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pic_predown", 0);
  private long b;
  private long c;
  private long d = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_c2c", 0L);
  private long e = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_xg_grp", 0L);
  private long f = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_c2c", 0L);
  private long g = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_wifi_grp", 0L);
  
  public void a()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localEditor.putLong("key_update_time", this.jdField_a_of_type_Long);
      localEditor.putLong("key_xg_c2c", this.d);
      localEditor.putLong("key_xg_grp", this.e);
      localEditor.putLong("key_wifi_c2c", this.f);
      localEditor.putLong("key_wifi_grp", this.g);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	agku:b	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +47 -> 55
    //   11: invokestatic 87	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   14: aload_0
    //   15: getfield 47	agku:jdField_a_of_type_Long	J
    //   18: invokevirtual 91	java/util/TimeZone:getOffset	(J)I
    //   21: i2l
    //   22: lstore_3
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 47	agku:jdField_a_of_type_Long	J
    //   28: lload_3
    //   29: ladd
    //   30: ldc2_w 92
    //   33: ldiv
    //   34: ldc2_w 92
    //   37: lmul
    //   38: lload_3
    //   39: lsub
    //   40: putfield 95	agku:c	J
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 95	agku:c	J
    //   48: ldc2_w 92
    //   51: ladd
    //   52: putfield 81	agku:b	J
    //   55: lload_1
    //   56: aload_0
    //   57: getfield 81	agku:b	J
    //   60: lcmp
    //   61: ifgt +12 -> 73
    //   64: lload_1
    //   65: aload_0
    //   66: getfield 95	agku:c	J
    //   69: lcmp
    //   70: ifge +46 -> 116
    //   73: aload_0
    //   74: lconst_0
    //   75: putfield 81	agku:b	J
    //   78: aload_0
    //   79: lconst_0
    //   80: putfield 95	agku:c	J
    //   83: aload_0
    //   84: lconst_0
    //   85: putfield 63	agku:g	J
    //   88: aload_0
    //   89: lconst_0
    //   90: putfield 59	agku:f	J
    //   93: aload_0
    //   94: lconst_0
    //   95: putfield 55	agku:e	J
    //   98: aload_0
    //   99: lconst_0
    //   100: putfield 51	agku:d	J
    //   103: aload_0
    //   104: lload_1
    //   105: putfield 47	agku:jdField_a_of_type_Long	J
    //   108: iconst_0
    //   109: istore 5
    //   111: aload_0
    //   112: monitorexit
    //   113: iload 5
    //   115: ireturn
    //   116: iconst_1
    //   117: istore 5
    //   119: goto -8 -> 111
    //   122: astore 6
    //   124: aload_0
    //   125: monitorexit
    //   126: aload 6
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	agku
    //   0	129	1	paramLong	long
    //   22	17	3	l	long
    //   109	9	5	bool	boolean
    //   122	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	55	122	finally
    //   55	73	122	finally
    //   73	108	122	finally
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        int i;
        if (!a(l))
        {
          i = 1;
          if (!paramBoolean1) {
            break label112;
          }
          if (paramBoolean2)
          {
            this.d += paramLong;
            if (Math.abs(l - this.jdField_a_of_type_Long) <= 60000L) {
              break label143;
            }
            j = 1;
            this.jdField_a_of_type_Long = l;
            if (i == 0)
            {
              paramBoolean1 = bool;
              if (j == 0) {}
            }
            else
            {
              paramBoolean1 = true;
            }
            return paramBoolean1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        this.e += paramLong;
        continue;
        if (!paramBoolean2) {
          break label130;
        }
      }
      finally {}
      label112:
      this.f += paramLong;
      continue;
      label130:
      this.g += paramLong;
      continue;
      label143:
      int j = 0;
    }
  }
  
  public long[] a()
  {
    try
    {
      a(System.currentTimeMillis());
      long l1 = this.d;
      long l2 = this.e;
      long l3 = this.f;
      long l4 = this.g;
      return new long[] { l1, l2, l3, l4 };
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agku
 * JD-Core Version:    0.7.0.1
 */