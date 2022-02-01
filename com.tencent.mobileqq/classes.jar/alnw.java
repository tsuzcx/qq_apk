import com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import org.jetbrains.annotations.Nullable;

public class alnw
{
  protected static final int[] a;
  protected static final int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  protected static final int[] c = { 0, 1, 2, 3 };
  protected static final int[] d = { 0, 1 };
  protected static final int[] e = { 0, 1, 2, 3 };
  protected static final int[] f = { 0, 1, 2 };
  protected static final int[] g = { 0, 1, 2 };
  protected static final int[] h = { 0, 1, 2 };
  protected static final int[] i = { 0, 1, 2, 3, 4 };
  protected static final int[] j = { 0, 1, 2, 3 };
  protected static final int[] k = { 0, 1, 2, 3 };
  protected int a;
  protected alms a;
  protected alnt[] a;
  protected int[] l;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public alnw(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.l = b;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlnt = new alnt[this.l.length];
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.l = e;
      } else if (this.jdField_a_of_type_Int == 5) {
        this.l = g;
      } else if (this.jdField_a_of_type_Int == 6) {
        this.l = c;
      } else if (this.jdField_a_of_type_Int == 7) {
        this.l = d;
      } else if (this.jdField_a_of_type_Int == 9) {
        this.l = h;
      } else if (this.jdField_a_of_type_Int == 10) {
        this.l = i;
      } else if (this.jdField_a_of_type_Int == 11) {
        this.l = j;
      } else if (this.jdField_a_of_type_Int == 12) {
        this.l = f;
      } else if (this.jdField_a_of_type_Int == 13) {
        this.l = k;
      } else {
        this.l = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  private int a(Object paramObject, int paramInt)
  {
    int m;
    if ((paramObject instanceof RecentMatchChatListItem)) {
      m = this.l[1];
    }
    do
    {
      do
      {
        return m;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 20)) {
          return this.l[2];
        }
        m = paramInt;
      } while (!(paramObject instanceof Integer));
      m = paramInt;
    } while (((Integer)paramObject).intValue() != 21);
    return this.l[3];
  }
  
  @Nullable
  private alnt a(int paramInt)
  {
    alnt localalnt = null;
    Object localObject = localalnt;
    if (paramInt > 0)
    {
      localObject = localalnt;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlnt.length)
      {
        localalnt = this.jdField_a_of_type_ArrayOfAlnt[paramInt];
        localObject = localalnt;
        if (localalnt == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalnt;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlnt[paramInt] = localObject;
      return localObject;
      localObject = new alnl();
      continue;
      localObject = new axay();
    }
  }
  
  private int b(Object paramObject, int paramInt)
  {
    int m;
    if ((paramObject instanceof RecentItemConfessMsg)) {
      m = this.l[1];
    }
    do
    {
      do
      {
        return m;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
          return this.l[2];
        }
        m = paramInt;
      } while (!(paramObject instanceof Integer));
      m = paramInt;
    } while (((Integer)paramObject).intValue() != 17);
    return this.l[3];
  }
  
  @Nullable
  private alnt b(int paramInt)
  {
    alnt localalnt = null;
    Object localObject = localalnt;
    if (paramInt > 0)
    {
      localObject = localalnt;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlnt.length)
      {
        localalnt = this.jdField_a_of_type_ArrayOfAlnt[paramInt];
        localObject = localalnt;
        if (localalnt == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalnt;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlnt[paramInt] = localObject;
      return localObject;
      localObject = new alne();
      continue;
      localObject = new aqyn();
    }
  }
  
  private int c(Object paramObject, int paramInt)
  {
    int m;
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 13) {
        m = this.l[2];
      }
    }
    do
    {
      do
      {
        return m;
        m = paramInt;
      } while (paramObject.intValue() != 4);
      return this.l[1];
      m = paramInt;
    } while (!(paramObject instanceof RecentHotchatItem));
    switch (((RecentHotchatItem)paramObject).mType)
    {
    default: 
      return paramInt;
    case 1: 
      return this.l[3];
    case 4: 
      return this.l[4];
    case 2: 
      return this.l[2];
    }
    return this.l[1];
  }
  
  @Nullable
  private alnt c(int paramInt)
  {
    alnt localalnt = null;
    Object localObject = localalnt;
    if (paramInt > 0)
    {
      localObject = localalnt;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlnt.length)
      {
        localalnt = this.jdField_a_of_type_ArrayOfAlnt[paramInt];
        localObject = localalnt;
        if (localalnt == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalnt;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlnt[paramInt] = localObject;
      return localObject;
      localObject = new alnj();
      continue;
      localObject = new alpi();
      continue;
      localObject = new HotChatCenterItemBuilder();
      continue;
      localObject = new almk();
    }
  }
  
  private int d(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.l[0];
    }
    while (!(paramObject instanceof RecentSayHelloListItem)) {
      return paramInt;
    }
    return this.l[1];
  }
  
  private alnt d(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alpf();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    return localalnt;
  }
  
  private int e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.l[0];
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.l[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.l[3];
      }
    } while (!(paramObject instanceof RecentMsgBoxItem));
    return this.l[1];
  }
  
  private alnt e(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[2] = new alpc();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[2];
    }
    do
    {
      return localalnt;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[1] = new alnj();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[1];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfAlnt[3] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[3] = new alnx();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[3];
  }
  
  private int f(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      paramInt = this.l[1];
    }
    while (!(paramObject instanceof RecentBaseData)) {
      return paramInt;
    }
    return this.l[2];
  }
  
  private alnt f(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alnc();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    while (paramInt != 2) {
      return localalnt;
    }
    if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[2] = new alnj();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[2];
  }
  
  private int g(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 11) {
        paramInt = this.l[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 12);
      return this.l[1];
    }
    return this.l[2];
  }
  
  private alnt g(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alpi();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    while (paramInt != 2) {
      return localalnt;
    }
    if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[2] = new alnj();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[2];
  }
  
  private int h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 18) {
        paramInt = this.l[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 19);
      return this.l[1];
    }
    return this.l[2];
  }
  
  private alnt h(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alpi();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    while (paramInt != 2) {
      return localalnt;
    }
    if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[2] = new alnj();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[2];
  }
  
  private int i(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 3) {
        paramInt = this.l[3];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
        if (paramObject.intValue() == 4) {
          return this.l[1];
        }
      } while (paramObject.intValue() != 5);
      return this.l[1];
    }
    return this.l[2];
  }
  
  private alnt i(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alpi();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    do
    {
      return localalnt;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[2] = new alnj();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[2];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfAlnt[3] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[3] = new alph();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[3];
  }
  
  private int j(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      if (((Integer)paramObject).intValue() == 0) {
        paramInt = this.l[1];
      }
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.l[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.l[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.l[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.l[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.l[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.l[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.l[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.l[10];
        }
        return this.l[2];
      }
    } while (!(paramObject instanceof String));
    return this.l[0];
  }
  
  private alnt j(int paramInt)
  {
    alnt localalnt = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlnt[1] == null) {
        this.jdField_a_of_type_ArrayOfAlnt[1] = new alnn();
      }
      localalnt = this.jdField_a_of_type_ArrayOfAlnt[1];
    }
    do
    {
      return localalnt;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[2] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[2] = new alnl();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[2];
      }
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[3] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[3] = new alos();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[3];
      }
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[4] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[4] = new alnp();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[4];
      }
      if (paramInt == 5)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[5] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[5] = new alnd();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[5];
      }
      if (paramInt == 6)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[6] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[6] = new alnz();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[6];
      }
      if (paramInt == 7)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[7] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[7] = new aloc();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[7];
      }
      if (paramInt == 8)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[8] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[8] = new alna();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[8];
      }
      if (paramInt == 9)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[9] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[9] = new alnf();
        }
        return this.jdField_a_of_type_ArrayOfAlnt[9];
      }
    } while (paramInt != 10);
    if (this.jdField_a_of_type_ArrayOfAlnt[10] == null) {
      this.jdField_a_of_type_ArrayOfAlnt[10] = new alow();
    }
    return this.jdField_a_of_type_ArrayOfAlnt[10];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Object paramObject)
  {
    int m = this.l[0];
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      return m;
    case 0: 
      return j(paramObject, m);
    case 1: 
      return i(paramObject, m);
    case 12: 
      return h(paramObject, m);
    case 9: 
      return g(paramObject, m);
    case 5: 
      return f(paramObject, m);
    case 6: 
      return e(paramObject, m);
    case 7: 
      return d(paramObject, m);
    case 10: 
      return c(paramObject, m);
    case 11: 
      return b(paramObject, m);
    }
    return a(paramObject, m);
  }
  
  public alnt a(Object paramObject)
  {
    Object localObject = null;
    int m = a(paramObject);
    paramObject = localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramObject = localObject;
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.jdField_a_of_type_ArrayOfAlnt[0] == null) {
          this.jdField_a_of_type_ArrayOfAlnt[0] = new alnc();
        }
        localObject = this.jdField_a_of_type_ArrayOfAlnt[0];
      }
      ((alnt)localObject).a(this.jdField_a_of_type_Alms);
      return localObject;
      paramObject = j(m);
      continue;
      paramObject = i(m);
      continue;
      paramObject = h(m);
      continue;
      paramObject = g(m);
      continue;
      paramObject = f(m);
      continue;
      paramObject = e(m);
      continue;
      paramObject = d(m);
      continue;
      paramObject = c(m);
      continue;
      paramObject = b(m);
      continue;
      paramObject = a(m);
    }
  }
  
  public void a(alms paramalms)
  {
    this.jdField_a_of_type_Alms = paramalms;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAlnt != null) && (this.jdField_a_of_type_ArrayOfAlnt.length > 6) && ((this.jdField_a_of_type_ArrayOfAlnt[6] instanceof alnz)))
    {
      ((alnz)this.jdField_a_of_type_ArrayOfAlnt[6]).a();
      this.jdField_a_of_type_ArrayOfAlnt[6] = null;
    }
  }
  
  public int b()
  {
    return this.l.length;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAlnt != null) && (this.jdField_a_of_type_ArrayOfAlnt.length > 6) && ((this.jdField_a_of_type_ArrayOfAlnt[6] instanceof alnz)))
    {
      ((alnz)this.jdField_a_of_type_ArrayOfAlnt[6]).a();
      this.jdField_a_of_type_ArrayOfAlnt[6] = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnw
 * JD-Core Version:    0.7.0.1
 */