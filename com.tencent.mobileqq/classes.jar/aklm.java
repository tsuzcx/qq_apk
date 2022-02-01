import com.tencent.mobileqq.activity.recent.RecentBaseData;

class aklm
  extends bjub
{
  aklm(akll paramakll, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua)
  {
    if ((paramArrayOfbjua == null) || (paramArrayOfbjua.length <= 0)) {
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
        if ((!akmc.a(((RecentBaseData)paramObject).getRecentUserUin())) || (!akmi.a().a()) || (akmi.a().a(((RecentBaseData)paramObject).getRecentUserUin()))) {
          break label473;
        }
        paramArrayOfbjua[0].b = 6;
        paramArrayOfbjua[0].a = 1;
      }
      label203:
      label467:
      label473:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbjua.length)
        {
          paramArrayOfbjua[i].b = 0;
          paramArrayOfbjua[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbjua.length)
        {
          paramArrayOfbjua[paramInt].b = -1;
          paramArrayOfbjua[paramInt].a = -1;
          paramInt += 1;
          continue;
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label407;
          }
          paramArrayOfbjua[0].b = 2;
          paramArrayOfbjua[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfbjua.length)
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
                paramArrayOfbjua[i].b = 4;
                paramArrayOfbjua[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbjua.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfbjua[paramInt].b = 9;
                paramArrayOfbjua[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfbjua.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfbjua[i].b = 0;
                paramArrayOfbjua[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfbjua.length) {
              break label146;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label146;
            }
            paramArrayOfbjua[j].b = 6;
            paramArrayOfbjua[j].a = 1;
            paramInt = j + 1;
            break label146;
            break;
            if (paramInt != 16) {
              break label467;
            }
            paramArrayOfbjua[0].b = 3;
            paramArrayOfbjua[0].a = 0;
            i = 1;
            break label203;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfbjua[i].b = 5;
              paramArrayOfbjua[i].a = 1;
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
 * Qualified Name:     aklm
 * JD-Core Version:    0.7.0.1
 */