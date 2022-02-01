import com.tencent.mobileqq.activity.recent.RecentBaseData;

class alce
  extends bkov
{
  alce(alcd paramalcd, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bkou[] paramArrayOfbkou)
  {
    if ((paramArrayOfbkou == null) || (paramArrayOfbkou.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    label146:
    label407:
    label433:
    for (int k = ((RecentBaseData)paramObject).mMenuFlag;; k = 0)
    {
      if (((paramObject instanceof RecentBaseData)) && ((((RecentBaseData)paramObject).getRecentUserType() == 1008) || (((RecentBaseData)paramObject).getRecentUserType() == 7220)))
      {
        if ((!alcv.a(((RecentBaseData)paramObject).getRecentUserUin())) || (!aldb.a().a()) || (aldb.a().a(((RecentBaseData)paramObject).getRecentUserUin()))) {
          break label473;
        }
        paramArrayOfbkou[0].b = 6;
        paramArrayOfbkou[0].a = 1;
      }
      label203:
      label467:
      label473:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbkou.length)
        {
          paramArrayOfbkou[i].b = 0;
          paramArrayOfbkou[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbkou.length)
        {
          paramArrayOfbkou[paramInt].b = -1;
          paramArrayOfbkou[paramInt].a = -1;
          paramInt += 1;
          continue;
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label407;
          }
          paramArrayOfbkou[0].b = 2;
          paramArrayOfbkou[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfbkou.length)
          {
            paramInt = i;
            if ((paramObject instanceof RecentBaseData))
            {
              paramInt = i;
              if (((RecentBaseData)paramObject).isUnreadMsgNumInTabNum())
              {
                j = 0xF0000 & k;
                if (j != 65536) {
                  break label433;
                }
                paramArrayOfbkou[i].b = 4;
                paramArrayOfbkou[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbkou.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfbkou[paramInt].b = 9;
                paramArrayOfbkou[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfbkou.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfbkou[i].b = 0;
                paramArrayOfbkou[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfbkou.length) {
              break label146;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label146;
            }
            paramArrayOfbkou[j].b = 6;
            paramArrayOfbkou[j].a = 1;
            paramInt = j + 1;
            break label146;
            break;
            if (paramInt != 16) {
              break label467;
            }
            paramArrayOfbkou[0].b = 3;
            paramArrayOfbkou[0].a = 0;
            i = 1;
            break label203;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfbkou[i].b = 5;
              paramArrayOfbkou[i].a = 1;
              paramInt = i + 1;
            }
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */