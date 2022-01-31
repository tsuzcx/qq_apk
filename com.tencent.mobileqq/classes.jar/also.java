import android.content.ContentValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class also
  extends akej
{
  public static int a;
  List<ColorNote> a;
  
  static
  {
    jdField_a_of_type_Int = 9;
  }
  
  public also(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private boolean a(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bool1 = bool2;
      if (a(paramColorNote.getUniKey()) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int a()
  {
    try
    {
      int i = a(false).size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final ColorNote a(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = a(false).iterator();
        if (localIterator.hasNext())
        {
          ColorNote localColorNote = (ColorNote)localIterator.next();
          boolean bool = localColorNote.getUniKey().equals(paramString);
          if (!bool) {
            continue;
          }
          paramString = localColorNote;
          return paramString;
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  public ColorNote a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    ColorNote localColorNote = a(paramString2);
    for (;;)
    {
      try
      {
        localObject = ColorNote.class.getDeclaredField(paramString3);
        localClass = ((Field)localObject).getType();
        ((Field)localObject).setAccessible(true);
        if (localColorNote != null) {
          ((Field)localObject).set(localColorNote, paramObject);
        }
        if ((Modifier.isStatic(((Field)localObject).getModifiers())) || (((Field)localObject).isAnnotationPresent(atnz.class))) {
          break label381;
        }
        localObject = new ContentValues();
        if (localClass != Long.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Long)paramObject);
      }
      catch (NoSuchFieldException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error NoSuchFieldException! ", paramString1);
        return null;
        if (localClass != String.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (String)paramObject);
        continue;
      }
      catch (IllegalAccessException paramString1)
      {
        Object localObject;
        Class localClass;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateColorNoteFieldByKey error IllegalAccessException! ", paramString1);
        continue;
        if (localClass != Byte.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Byte)paramObject);
        continue;
        if (localClass != [B.class) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (byte[])paramObject);
        continue;
        if (localClass != Short.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Short)paramObject);
        continue;
        if (localClass != Boolean.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Boolean)paramObject);
        continue;
        if (localClass != Float.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Float)paramObject);
        continue;
        if (localClass != Double.TYPE) {
          continue;
        }
        ((ContentValues)localObject).put(paramString3, (Double)paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ColorNoteProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
        continue;
      }
      if (localColorNote == null) {
        continue;
      }
      a(paramString1, 0, localColorNote.getTableName(), (ContentValues)localObject, "mUniKey=?", new String[] { paramString2 }, null);
      return localColorNote;
      if (localClass != Integer.TYPE) {
        continue;
      }
      ((ContentValues)localObject).put(paramString3, (Integer)paramObject);
    }
    label381:
    return null;
  }
  
  public ArrayList<ColorNote> a(String paramString, akes paramakes)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    a(paramString, 0, ColorNote.class.getSimpleName(), null, null, paramakes);
    return localArrayList;
  }
  
  public final List<ColorNote> a()
  {
    for (;;)
    {
      int i;
      ColorNote localColorNote;
      boolean bool;
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label159;
        }
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i < 0) {
          break label159;
        }
        localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localColorNote.isOpen()) {
          break label163;
        }
        bool = alsr.b(localColorNote);
        if (localColorNote.getServiceType() == 16973824) {
          if ((localArrayList.size() > 0) && (alsr.b((ColorNote)localArrayList.get(0)))) {
            localArrayList.add(1, localColorNote);
          } else {
            localArrayList.add(0, localColorNote);
          }
        }
      }
      finally {}
      if (bool)
      {
        localList.add(0, localColorNote);
      }
      else
      {
        localList.add(localColorNote);
        break label163;
        label159:
        return localList;
      }
      label163:
      i -= 1;
    }
  }
  
  public final List<ColorNote> a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramBoolean))
      {
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(ColorNote.class);
        if ((localList != null) && (!localList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilList = localList;
        }
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteProxy", 2, "init ~~ ");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(ColorNote.class, true, null, null, null, null, null, null);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      aluq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), false, false);
    }
    localObject = alrt.a();
    if ((localObject != null) && (((alrs)localObject).a() != -1))
    {
      jdField_a_of_type_Int = ((alrs)localObject).a();
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteConfigProcessor", 2, "init MAX_COUNT " + jdField_a_of_type_Int);
      }
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramakes);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramakes);
  }
  
  protected void a(String paramString, ColorNote paramColorNote, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(paramString, 0, paramColorNote.getTableName(), paramColorNote, 0, paramakes);
  }
  
  public void a(String paramString, ColorNote paramColorNote, akes paramakes, boolean paramBoolean)
  {
    if ((!a(paramColorNote)) && (aluq.a()))
    {
      if (paramColorNote.getServiceType() == 16973824) {
        awqx.b(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
      }
      if (alsr.b(paramColorNote))
      {
        this.jdField_a_of_type_JavaUtilList.add(0, paramColorNote);
        if (paramColorNote.getServiceType() != 16973824) {
          b(paramString, paramColorNote, paramakes, paramBoolean);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      }
    }
    QLog.e("ColorNoteProxy", 2, "addColorNote error! isAfterSyncMsg = " + aluq.a());
  }
  
  public boolean a()
  {
    Object localObject = a(false);
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    int j;
    if (((Iterator)localObject).hasNext())
    {
      ColorNote localColorNote = (ColorNote)((Iterator)localObject).next();
      j = i;
      if (alsr.b(localColorNote)) {
        j = i - 1;
      }
      if (localColorNote.getServiceType() != 16973824) {
        break label82;
      }
    }
    label82:
    for (i = j - 1;; i = j)
    {
      break;
      return i < jdField_a_of_type_Int;
    }
  }
  
  public boolean a(String paramString, ColorNote paramColorNote)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ColorNote localColorNote = (ColorNote)localIterator.next();
      if (alsr.b(localColorNote)) {
        localArrayList.add(localColorNote);
      }
    }
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      c(paramString, (ColorNote)localIterator.next(), null);
    }
    localList.removeAll(localArrayList);
    if (paramColorNote != null) {
      a(paramString, paramColorNote, null, false);
    }
    return true;
  }
  
  protected void b() {}
  
  protected void b(String paramString, ColorNote paramColorNote, akes paramakes)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c(paramString, 0, paramColorNote.getTableName(), paramColorNote, 0, paramakes);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.d();
  }
  
  protected void b(String paramString, ColorNote paramColorNote, akes paramakes, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramString, paramColorNote, paramakes);
      return;
    }
    a(paramString, paramColorNote, paramakes);
  }
  
  public void c(String paramString, ColorNote paramColorNote, akes paramakes)
  {
    if (paramColorNote != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramColorNote);
      a(paramString, 0, paramColorNote.getTableName(), "mUniKey=?", new String[] { String.valueOf(paramColorNote.getUniKey()) }, paramakes);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     also
 * JD-Core Version:    0.7.0.1
 */