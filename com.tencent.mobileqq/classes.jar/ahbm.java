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

public class ahbm
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
  protected ahai a;
  protected ahbj[] a;
  protected int[] l;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0 };
  }
  
  public ahbm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0) {
      this.l = b;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAhbj = new ahbj[this.l.length];
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
      if ((paramObject instanceof Integer))
      {
        if (((Integer)paramObject).intValue() != 0) {
          break label802;
        }
        m = this.l[1];
      }
      break;
    }
    label802:
    for (;;)
    {
      return m;
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
      if (!(paramObject instanceof String)) {
        break;
      }
      return this.l[0];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 3) {
          return this.l[3];
        }
        if (paramObject.intValue() == 4) {
          return this.l[1];
        }
        if (paramObject.intValue() != 5) {
          break;
        }
        return this.l[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.l[2];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 18) {
          return this.l[1];
        }
        if (paramObject.intValue() != 19) {
          break;
        }
        return this.l[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.l[2];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 11) {
          return this.l[1];
        }
        if (paramObject.intValue() != 12) {
          break;
        }
        return this.l[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.l[2];
      if ((paramObject instanceof Integer)) {
        return this.l[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.l[2];
      if ((paramObject instanceof String)) {
        return this.l[0];
      }
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.l[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.l[3];
      }
      if (!(paramObject instanceof RecentMsgBoxItem)) {
        break;
      }
      return this.l[1];
      if ((paramObject instanceof String)) {
        return this.l[0];
      }
      if (!(paramObject instanceof RecentSayHelloListItem)) {
        break;
      }
      return this.l[1];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 13) {
          return this.l[2];
        }
        if (paramObject.intValue() != 4) {
          break;
        }
        return this.l[1];
      }
      if (!(paramObject instanceof RecentHotchatItem)) {
        break;
      }
      switch (((RecentHotchatItem)paramObject).mType)
      {
      default: 
        return m;
      case 1: 
        return this.l[3];
      case 4: 
        return this.l[4];
      case 2: 
        return this.l[2];
      }
      return this.l[1];
      if ((paramObject instanceof RecentItemConfessMsg)) {
        return this.l[1];
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
        return this.l[2];
      }
      if ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 17)) {
        break;
      }
      return this.l[3];
      if ((paramObject instanceof RecentMatchChatListItem)) {
        return this.l[1];
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 20)) {
        return this.l[2];
      }
      if ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 21)) {
        break;
      }
      return this.l[3];
    }
  }
  
  public ahbj a(Object paramObject)
  {
    Object localObject = null;
    int m = a(paramObject);
    if (this.jdField_a_of_type_Int == 0) {
      if (m == 1)
      {
        if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
          this.jdField_a_of_type_ArrayOfAhbj[1] = new ahbd();
        }
        paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          localObject = paramObject;
                          if (paramObject == null)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[0] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[0] = new ahas();
                            }
                            localObject = this.jdField_a_of_type_ArrayOfAhbj[0];
                          }
                          ((ahbj)localObject).a(this.jdField_a_of_type_Ahai);
                          return localObject;
                          if (m == 2)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[2] = new ahbb();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                          }
                          else if (m == 3)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[3] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[3] = new ahci();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[3];
                          }
                          else if (m == 4)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[4] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[4] = new ahbf();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[4];
                          }
                          else if (m == 5)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[5] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[5] = new ahat();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[5];
                          }
                          else if (m == 6)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[6] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[6] = new ahbp();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[6];
                          }
                          else if (m == 7)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[7] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[7] = new ahbs();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[7];
                          }
                          else if (m == 8)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[8] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[8] = new ahaq();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[8];
                          }
                          else if (m == 9)
                          {
                            if (this.jdField_a_of_type_ArrayOfAhbj[9] == null) {
                              this.jdField_a_of_type_ArrayOfAhbj[9] = new ahav();
                            }
                            paramObject = this.jdField_a_of_type_ArrayOfAhbj[9];
                          }
                          else
                          {
                            paramObject = localObject;
                            if (m == 10)
                            {
                              if (this.jdField_a_of_type_ArrayOfAhbj[10] == null) {
                                this.jdField_a_of_type_ArrayOfAhbj[10] = new ahcm();
                              }
                              paramObject = this.jdField_a_of_type_ArrayOfAhbj[10];
                              continue;
                              if (this.jdField_a_of_type_Int == 1)
                              {
                                if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahcy();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                                else if (m == 2)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[2] = new ahaz();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                                }
                                else
                                {
                                  paramObject = localObject;
                                  if (m == 3)
                                  {
                                    if (this.jdField_a_of_type_ArrayOfAhbj[3] == null) {
                                      this.jdField_a_of_type_ArrayOfAhbj[3] = new ahcx();
                                    }
                                    paramObject = this.jdField_a_of_type_ArrayOfAhbj[3];
                                  }
                                }
                              }
                              else if (this.jdField_a_of_type_Int == 12)
                              {
                                if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahcy();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                                else
                                {
                                  paramObject = localObject;
                                  if (m == 2)
                                  {
                                    if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                                      this.jdField_a_of_type_ArrayOfAhbj[2] = new ahaz();
                                    }
                                    paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                                  }
                                }
                              }
                              else if (this.jdField_a_of_type_Int == 9)
                              {
                                if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahcy();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                                else
                                {
                                  paramObject = localObject;
                                  if (m == 2)
                                  {
                                    if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                                      this.jdField_a_of_type_ArrayOfAhbj[2] = new ahaz();
                                    }
                                    paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                                  }
                                }
                              }
                              else if (this.jdField_a_of_type_Int == 5)
                              {
                                if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahas();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                                else
                                {
                                  paramObject = localObject;
                                  if (m == 2)
                                  {
                                    if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                                      this.jdField_a_of_type_ArrayOfAhbj[2] = new ahaz();
                                    }
                                    paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                                  }
                                }
                              }
                              else if (this.jdField_a_of_type_Int == 6)
                              {
                                if (m == 2)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[2] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[2] = new ahcr();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[2];
                                }
                                else if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahaz();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                                else
                                {
                                  paramObject = localObject;
                                  if (m == 3)
                                  {
                                    if (this.jdField_a_of_type_ArrayOfAhbj[3] == null) {
                                      this.jdField_a_of_type_ArrayOfAhbj[3] = new ahbn();
                                    }
                                    paramObject = this.jdField_a_of_type_ArrayOfAhbj[3];
                                  }
                                }
                              }
                              else
                              {
                                if (this.jdField_a_of_type_Int != 7) {
                                  break;
                                }
                                paramObject = localObject;
                                if (m == 1)
                                {
                                  if (this.jdField_a_of_type_ArrayOfAhbj[1] == null) {
                                    this.jdField_a_of_type_ArrayOfAhbj[1] = new ahcu();
                                  }
                                  paramObject = this.jdField_a_of_type_ArrayOfAhbj[1];
                                }
                              }
                            }
                          }
                        }
                        if (this.jdField_a_of_type_Int != 10) {
                          break;
                        }
                        paramObject = localObject;
                      } while (m <= 0);
                      paramObject = localObject;
                    } while (m >= this.jdField_a_of_type_ArrayOfAhbj.length);
                    localObject = this.jdField_a_of_type_ArrayOfAhbj[m];
                    paramObject = localObject;
                  } while (localObject != null);
                  switch (m)
                  {
                  default: 
                    paramObject = localObject;
                  }
                  for (;;)
                  {
                    this.jdField_a_of_type_ArrayOfAhbj[m] = paramObject;
                    break;
                    paramObject = new ahaz();
                    continue;
                    paramObject = new ahcy();
                    continue;
                    paramObject = new HotChatCenterItemBuilder();
                    continue;
                    paramObject = new ahaa();
                  }
                  if (this.jdField_a_of_type_Int != 11) {
                    break;
                  }
                  paramObject = localObject;
                } while (m <= 0);
                paramObject = localObject;
              } while (m >= this.jdField_a_of_type_ArrayOfAhbj.length);
              localObject = this.jdField_a_of_type_ArrayOfAhbj[m];
              paramObject = localObject;
            } while (localObject != null);
            switch (m)
            {
            default: 
              paramObject = localObject;
            }
            for (;;)
            {
              this.jdField_a_of_type_ArrayOfAhbj[m] = paramObject;
              break;
              paramObject = new ahau();
              continue;
              paramObject = new alxw();
            }
            paramObject = localObject;
          } while (this.jdField_a_of_type_Int != 13);
          paramObject = localObject;
        } while (m <= 0);
        paramObject = localObject;
      } while (m >= this.jdField_a_of_type_ArrayOfAhbj.length);
      localObject = this.jdField_a_of_type_ArrayOfAhbj[m];
      paramObject = localObject;
    } while (localObject != null);
    switch (m)
    {
    default: 
      paramObject = localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfAhbj[m] = paramObject;
      break;
      paramObject = new ahbb();
      continue;
      paramObject = new arji();
    }
  }
  
  public void a(ahai paramahai)
  {
    this.jdField_a_of_type_Ahai = paramahai;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAhbj != null) && (this.jdField_a_of_type_ArrayOfAhbj.length > 6) && ((this.jdField_a_of_type_ArrayOfAhbj[6] instanceof ahbp)))
    {
      ((ahbp)this.jdField_a_of_type_ArrayOfAhbj[6]).a();
      this.jdField_a_of_type_ArrayOfAhbj[6] = null;
    }
  }
  
  public int b()
  {
    return this.l.length;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ArrayOfAhbj != null) && (this.jdField_a_of_type_ArrayOfAhbj.length > 6) && ((this.jdField_a_of_type_ArrayOfAhbj[6] instanceof ahbp)))
    {
      ((ahbp)this.jdField_a_of_type_ArrayOfAhbj[6]).a();
      this.jdField_a_of_type_ArrayOfAhbj[6] = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahbm
 * JD-Core Version:    0.7.0.1
 */