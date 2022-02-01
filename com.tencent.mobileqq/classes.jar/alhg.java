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

public class alhg
{
  protected static final int[] a;
  protected static final int[] b = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  protected static final int[] c = { 0, 1, 2, 3 };
  protected static final int[] d = { 0, 1 };
  protected static final int[] e = { 0, 1, 2, 3 };
  protected static final int[] f = { 0, 1 };
  protected static final int[] g = { 0, 1, 2 };
  protected static final int[] h = { 0, 1, 2 };
  protected static final int[] i = { 0, 1, 2 };
  protected static final int[] j = { 0, 1, 2 };
  protected static final int[] k = { 0, 1, 2, 3, 4 };
  protected static final int[] l = { 0, 1, 2, 3 };
  protected static final int[] m = { 0, 1, 2, 3 };
  protected int a;
  protected algc a;
  protected alhd[] a;
  protected int[] n;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public alhg(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.n = b;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlhd = new alhd[this.n.length];
      return;
      if (this.jdField_a_of_type_Int == 1) {
        this.n = e;
      } else if (this.jdField_a_of_type_Int == 5) {
        this.n = i;
      } else if (this.jdField_a_of_type_Int == 6) {
        this.n = c;
      } else if (this.jdField_a_of_type_Int == 7) {
        this.n = d;
      } else if (this.jdField_a_of_type_Int == 9) {
        this.n = j;
      } else if (this.jdField_a_of_type_Int == 10) {
        this.n = k;
      } else if (this.jdField_a_of_type_Int == 11) {
        this.n = l;
      } else if (this.jdField_a_of_type_Int == 12) {
        this.n = h;
      } else if (this.jdField_a_of_type_Int == 13) {
        this.n = m;
      } else if (this.jdField_a_of_type_Int == 14) {
        this.n = f;
      } else if (this.jdField_a_of_type_Int == 15) {
        this.n = g;
      } else {
        this.n = jdField_a_of_type_ArrayOfInt;
      }
    }
  }
  
  private int a(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentBaseData)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 23);
    return this.n[0];
  }
  
  private alhd a(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new algn();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    while (paramInt != 2) {
      return localalhd;
    }
    if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[2] = new algn();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[2];
  }
  
  private int b(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentMatchChatListItem)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 20)) {
          return this.n[2];
        }
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 21);
    return this.n[3];
  }
  
  @Nullable
  private alhd b(int paramInt)
  {
    alhd localalhd = null;
    Object localObject = localalhd;
    if (paramInt > 0)
    {
      localObject = localalhd;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlhd.length)
      {
        localalhd = this.jdField_a_of_type_ArrayOfAlhd[paramInt];
        localObject = localalhd;
        if (localalhd == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalhd;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlhd[paramInt] = localObject;
      return localObject;
      localObject = new algv();
      continue;
      localObject = new awuk();
    }
  }
  
  private int c(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof RecentItemConfessMsg)) {
      i1 = this.n[1];
    }
    do
    {
      do
      {
        return i1;
        if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
          return this.n[2];
        }
        i1 = paramInt;
      } while (!(paramObject instanceof Integer));
      i1 = paramInt;
    } while (((Integer)paramObject).intValue() != 17);
    return this.n[3];
  }
  
  @Nullable
  private alhd c(int paramInt)
  {
    alhd localalhd = null;
    Object localObject = localalhd;
    if (paramInt > 0)
    {
      localObject = localalhd;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlhd.length)
      {
        localalhd = this.jdField_a_of_type_ArrayOfAlhd[paramInt];
        localObject = localalhd;
        if (localalhd == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalhd;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlhd[paramInt] = localObject;
      return localObject;
      localObject = new algo();
      continue;
      localObject = new aqvb();
    }
  }
  
  private int d(Object paramObject, int paramInt)
  {
    int i1;
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 13) {
        i1 = this.n[2];
      }
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (paramObject.intValue() != 4);
      return this.n[1];
      i1 = paramInt;
    } while (!(paramObject instanceof RecentHotchatItem));
    switch (((RecentHotchatItem)paramObject).mType)
    {
    default: 
      return paramInt;
    case 1: 
      return this.n[3];
    case 4: 
      return this.n[4];
    case 2: 
      return this.n[2];
    }
    return this.n[1];
  }
  
  @Nullable
  private alhd d(int paramInt)
  {
    alhd localalhd = null;
    Object localObject = localalhd;
    if (paramInt > 0)
    {
      localObject = localalhd;
      if (paramInt < this.jdField_a_of_type_ArrayOfAlhd.length)
      {
        localalhd = this.jdField_a_of_type_ArrayOfAlhd[paramInt];
        localObject = localalhd;
        if (localalhd == null) {
          switch (paramInt)
          {
          default: 
            localObject = localalhd;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAlhd[paramInt] = localObject;
      return localObject;
      localObject = new algt();
      continue;
      localObject = new alir();
      continue;
      localObject = new HotChatCenterItemBuilder();
      continue;
      localObject = new alfu();
    }
  }
  
  private int e(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.n[0];
    }
    while (!(paramObject instanceof RecentSayHelloListItem)) {
      return paramInt;
    }
    return this.n[1];
  }
  
  private alhd e(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new alio();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    return localalhd;
  }
  
  private int f(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof String)) {
      paramInt = this.n[0];
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.n[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.n[3];
      }
    } while (!(paramObject instanceof RecentMsgBoxItem));
    return this.n[1];
  }
  
  private alhd f(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[2] = new alil();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[2];
    }
    do
    {
      return localalhd;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[1] = new algt();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[1];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfAlhd[3] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[3] = new alhh();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[3];
  }
  
  private int g(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      paramInt = this.n[1];
    }
    while (!(paramObject instanceof RecentBaseData)) {
      return paramInt;
    }
    return this.n[2];
  }
  
  private alhd g(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new algm();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    while (paramInt != 2) {
      return localalhd;
    }
    if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[2] = new algt();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[2];
  }
  
  private int h(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 11) {
        paramInt = this.n[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 12);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private alhd h(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new alir();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    while (paramInt != 2) {
      return localalhd;
    }
    if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[2] = new algt();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[2];
  }
  
  private int i(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 18) {
        paramInt = this.n[1];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
      } while (paramObject.intValue() != 19);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private alhd i(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new alir();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    while (paramInt != 2) {
      return localalhd;
    }
    if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[2] = new algt();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[2];
  }
  
  private int j(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      if (paramObject.intValue() == 3) {
        paramInt = this.n[3];
      }
    }
    while (!(paramObject instanceof RecentBaseData))
    {
      do
      {
        return paramInt;
        if (paramObject.intValue() == 4) {
          return this.n[1];
        }
      } while (paramObject.intValue() != 5);
      return this.n[1];
    }
    return this.n[2];
  }
  
  private alhd j(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new alir();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    do
    {
      return localalhd;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[2] = new algt();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[2];
      }
    } while (paramInt != 3);
    if (this.jdField_a_of_type_ArrayOfAlhd[3] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[3] = new aliq();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[3];
  }
  
  private int k(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RecentBaseData)) {
      paramInt = this.n[1];
    }
    return paramInt;
  }
  
  private alhd k(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new algn();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    return localalhd;
  }
  
  private int l(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Integer)) {
      if (((Integer)paramObject).intValue() == 0) {
        paramInt = this.n[1];
      }
    }
    do
    {
      return paramInt;
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.n[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.n[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.n[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.n[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.n[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.n[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.n[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.n[10];
        }
        return this.n[2];
      }
    } while (!(paramObject instanceof String));
    return this.n[0];
  }
  
  private alhd l(int paramInt)
  {
    alhd localalhd = null;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ArrayOfAlhd[1] == null) {
        this.jdField_a_of_type_ArrayOfAlhd[1] = new algx();
      }
      localalhd = this.jdField_a_of_type_ArrayOfAlhd[1];
    }
    do
    {
      return localalhd;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[2] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[2] = new algv();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[2];
      }
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[3] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[3] = new alib();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[3];
      }
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[4] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[4] = new algz();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[4];
      }
      if (paramInt == 5)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[5] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[5] = new algn();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[5];
      }
      if (paramInt == 6)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[6] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[6] = new alhj();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[6];
      }
      if (paramInt == 7)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[7] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[7] = new alhm();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[7];
      }
      if (paramInt == 8)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[8] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[8] = new algk();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[8];
      }
      if (paramInt == 9)
      {
        if (this.jdField_a_of_type_ArrayOfAlhd[9] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[9] = new algp();
        }
        return this.jdField_a_of_type_ArrayOfAlhd[9];
      }
    } while (paramInt != 10);
    if (this.jdField_a_of_type_ArrayOfAlhd[10] == null) {
      this.jdField_a_of_type_ArrayOfAlhd[10] = new alif();
    }
    return this.jdField_a_of_type_ArrayOfAlhd[10];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(Object paramObject)
  {
    int i1 = this.n[0];
    switch (this.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 8: 
    default: 
      return i1;
    case 0: 
      return l(paramObject, i1);
    case 1: 
      return j(paramObject, i1);
    case 12: 
      return i(paramObject, i1);
    case 9: 
      return h(paramObject, i1);
    case 5: 
      return g(paramObject, i1);
    case 6: 
      return f(paramObject, i1);
    case 7: 
      return e(paramObject, i1);
    case 10: 
      return d(paramObject, i1);
    case 11: 
      return c(paramObject, i1);
    case 13: 
      return b(paramObject, i1);
    case 14: 
      return k(paramObject, i1);
    }
    return a(paramObject, i1);
  }
  
  public alhd a(Object paramObject)
  {
    Object localObject = null;
    int i1 = a(paramObject);
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
        if (this.jdField_a_of_type_ArrayOfAlhd[0] == null) {
          this.jdField_a_of_type_ArrayOfAlhd[0] = new algm();
        }
        localObject = this.jdField_a_of_type_ArrayOfAlhd[0];
      }
      ((alhd)localObject).a(this.jdField_a_of_type_Algc);
      return localObject;
      paramObject = l(i1);
      continue;
      paramObject = j(i1);
      continue;
      paramObject = i(i1);
      continue;
      paramObject = h(i1);
      continue;
      paramObject = g(i1);
      continue;
      paramObject = f(i1);
      continue;
      paramObject = e(i1);
      continue;
      paramObject = d(i1);
      continue;
      paramObject = c(i1);
      continue;
      paramObject = b(i1);
      continue;
      paramObject = k(i1);
      continue;
      paramObject = a(i1);
    }
  }
  
  public void a(algc paramalgc)
  {
    this.jdField_a_of_type_Algc = paramalgc;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAlhd != null) && (this.jdField_a_of_type_ArrayOfAlhd.length > 6) && ((this.jdField_a_of_type_ArrayOfAlhd[6] instanceof alhj)))
    {
      ((alhj)this.jdField_a_of_type_ArrayOfAlhd[6]).a();
      this.jdField_a_of_type_ArrayOfAlhd[6] = null;
    }
  }
  
  public int b()
  {
    return this.n.length;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAlhd != null) && (this.jdField_a_of_type_ArrayOfAlhd.length > 6) && ((this.jdField_a_of_type_ArrayOfAlhd[6] instanceof alhj)))
    {
      ((alhj)this.jdField_a_of_type_ArrayOfAlhd[6]).a();
      this.jdField_a_of_type_ArrayOfAlhd[6] = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhg
 * JD-Core Version:    0.7.0.1
 */