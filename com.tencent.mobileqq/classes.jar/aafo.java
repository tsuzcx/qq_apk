import com.tencent.commonsdk.zip.QZipFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class aafo
  extends QZipFile
{
  protected File a;
  private HashMap<String, ZipEntry> a;
  protected ZipFile a;
  protected boolean a;
  
  public aafo(File paramFile1, File paramFile2, ZipFile paramZipFile)
  {
    super(paramFile1);
    this.jdField_a_of_type_JavaIoFile = paramFile2;
    this.jdField_a_of_type_JavaUtilZipZipFile = paramZipFile;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	aafo:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   18: invokevirtual 39	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: ldc 41
    //   23: invokevirtual 47	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: astore_2
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 53	java/lang/reflect/Field:setAccessible	(Z)V
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   37: invokevirtual 57	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 59	java/util/LinkedHashMap
    //   43: invokevirtual 63	java/util/LinkedHashMap:entrySet	()Ljava/util/Set;
    //   46: invokeinterface 69 1 0
    //   51: astore_2
    //   52: aload_2
    //   53: invokeinterface 75 1 0
    //   58: ifeq -47 -> 11
    //   61: aload_2
    //   62: invokeinterface 79 1 0
    //   67: checkcast 81	java/util/Map$Entry
    //   70: invokeinterface 84 1 0
    //   75: checkcast 86	java/lang/String
    //   78: ldc 88
    //   80: invokevirtual 92	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   83: ifne -31 -> 52
    //   86: aload_2
    //   87: invokeinterface 95 1 0
    //   92: goto -40 -> 52
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual 98	java/lang/NoSuchFieldException:printStackTrace	()V
    //   100: goto -89 -> 11
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 99	java/lang/IllegalAccessException:printStackTrace	()V
    //   113: goto -102 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	aafo
    //   6	2	1	bool	boolean
    //   26	61	2	localObject1	Object
    //   95	2	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   103	4	2	localObject2	Object
    //   108	2	2	localIllegalAccessException	java.lang.IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   14	52	95	java/lang/NoSuchFieldException
    //   52	92	95	java/lang/NoSuchFieldException
    //   2	7	103	finally
    //   14	52	103	finally
    //   52	92	103	finally
    //   96	100	103	finally
    //   109	113	103	finally
    //   14	52	108	java/lang/IllegalAccessException
    //   52	92	108	java/lang/IllegalAccessException
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 33	aafo:jdField_a_of_type_Boolean	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   30: invokevirtual 104	java/util/zip/ZipFile:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 33	aafo:jdField_a_of_type_Boolean	Z
    //   43: goto -28 -> 15
    //   46: astore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	aafo
    //   1	17	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   46	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	46	finally
    //   19	38	46	finally
    //   38	43	46	finally
  }
  
  public void close()
  {
    super.close();
    if (this.jdField_a_of_type_JavaUtilZipZipFile != null) {
      this.jdField_a_of_type_JavaUtilZipZipFile.close();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  /* Error */
  public java.util.Enumeration<? extends ZipEntry> entries()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	aafo:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +23 -> 31
    //   11: aload_0
    //   12: new 4	com/tencent/commonsdk/zip/QZipFile
    //   15: dup
    //   16: aload_0
    //   17: getfield 17	aafo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   20: invokespecial 15	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   23: putfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 33	aafo:jdField_a_of_type_Boolean	Z
    //   31: aload_0
    //   32: getfield 19	aafo:jdField_a_of_type_JavaUtilZipZipFile	Ljava/util/zip/ZipFile;
    //   35: invokevirtual 113	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: areturn
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   48: goto -17 -> 31
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	aafo
    //   6	2	1	bool	boolean
    //   38	4	2	localEnumeration	java.util.Enumeration
    //   43	2	2	localException	java.lang.Exception
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	31	43	java/lang/Exception
    //   2	7	51	finally
    //   11	31	51	finally
    //   31	39	51	finally
    //   44	48	51	finally
  }
  
  public ZipEntry getEntry(String paramString)
  {
    for (;;)
    {
      try
      {
        localZipEntry = (ZipEntry)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localZipEntry == null) {
          continue;
        }
        paramString = localZipEntry;
      }
      finally
      {
        try
        {
          this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
          this.jdField_a_of_type_Boolean = false;
          ZipEntry localZipEntry = this.jdField_a_of_type_JavaUtilZipZipFile.getEntry(paramString);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localZipEntry);
          paramString = localZipEntry;
        }
        catch (IOException paramString)
        {
          paramString = null;
        }
        paramString = finally;
      }
      return paramString;
      if (this.jdField_a_of_type_Boolean) {
        aafp.a(paramString, aafp.l);
      }
    }
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
        this.jdField_a_of_type_Boolean = false;
      }
      paramZipEntry = this.jdField_a_of_type_JavaUtilZipZipFile.getInputStream(paramZipEntry);
      return paramZipEntry;
    }
    finally {}
  }
  
  public String getName()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
      this.jdField_a_of_type_Boolean = false;
      return this.jdField_a_of_type_JavaUtilZipZipFile.getName();
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public int size()
  {
    int i = 0;
    label41:
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {}
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
      this.jdField_a_of_type_Boolean = false;
      i = this.jdField_a_of_type_JavaUtilZipZipFile.size();
    }
    catch (IOException localIOException)
    {
      break label41;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aafo
 * JD-Core Version:    0.7.0.1
 */