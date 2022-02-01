import com.tencent.mobileqq.activity.recent.RecentBaseData;

class alhe
  extends blfn
{
  alhe(alhd paramalhd, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
  {
    if ((paramArrayOfblfm == null) || (paramArrayOfblfm.length <= 0)) {
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
        if ((!alhu.a(((RecentBaseData)paramObject).getRecentUserUin())) || (!alia.a().a()) || (alia.a().a(((RecentBaseData)paramObject).getRecentUserUin()))) {
          break label473;
        }
        paramArrayOfblfm[0].b = 6;
        paramArrayOfblfm[0].a = 1;
      }
      label203:
      label467:
      label473:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfblfm.length)
        {
          paramArrayOfblfm[i].b = 0;
          paramArrayOfblfm[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfblfm.length)
        {
          paramArrayOfblfm[paramInt].b = -1;
          paramArrayOfblfm[paramInt].a = -1;
          paramInt += 1;
          continue;
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label407;
          }
          paramArrayOfblfm[0].b = 2;
          paramArrayOfblfm[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfblfm.length)
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
                paramArrayOfblfm[i].b = 4;
                paramArrayOfblfm[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfblfm.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfblfm[paramInt].b = 9;
                paramArrayOfblfm[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfblfm.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfblfm[i].b = 0;
                paramArrayOfblfm[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfblfm.length) {
              break label146;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label146;
            }
            paramArrayOfblfm[j].b = 6;
            paramArrayOfblfm[j].a = 1;
            paramInt = j + 1;
            break label146;
            break;
            if (paramInt != 16) {
              break label467;
            }
            paramArrayOfblfm[0].b = 3;
            paramArrayOfblfm[0].a = 0;
            i = 1;
            break label203;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfblfm[i].b = 5;
              paramArrayOfblfm[i].a = 1;
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
 * Qualified Name:     alhe
 * JD-Core Version:    0.7.0.1
 */