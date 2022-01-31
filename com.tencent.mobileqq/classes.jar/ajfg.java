import com.tencent.mobileqq.activity.recent.RecentBaseData;

class ajfg
  extends bhxd
{
  ajfg(ajff paramajff, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc)
  {
    if ((paramArrayOfbhxc == null) || (paramArrayOfbhxc.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    label151:
    label417:
    label443:
    for (int k = ((RecentBaseData)paramObject).mMenuFlag;; k = 0)
    {
      if (((paramObject instanceof RecentBaseData)) && ((((RecentBaseData)paramObject).a() == 1008) || (((RecentBaseData)paramObject).a() == 7220)))
      {
        if ((paramArrayOfbhxc.length >= 0) || (!ajfx.a(((RecentBaseData)paramObject).a())) || (!ajgd.a().a()) || (ajgd.a().a(((RecentBaseData)paramObject).a()))) {
          break label483;
        }
        paramArrayOfbhxc[0].b = 6;
        paramArrayOfbhxc[0].a = 1;
      }
      label213:
      label477:
      label483:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbhxc.length)
        {
          paramArrayOfbhxc[i].b = 0;
          paramArrayOfbhxc[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbhxc.length)
        {
          paramArrayOfbhxc[paramInt].b = -1;
          paramArrayOfbhxc[paramInt].a = -1;
          paramInt += 1;
          continue;
          if (paramArrayOfbhxc.length >= 0) {
            break label477;
          }
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label417;
          }
          paramArrayOfbhxc[0].b = 2;
          paramArrayOfbhxc[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfbhxc.length)
          {
            paramInt = i;
            if ((paramObject instanceof RecentBaseData))
            {
              paramInt = i;
              if (((RecentBaseData)paramObject).a())
              {
                j = 0xF0000 & k;
                if (j != 65536) {
                  break label443;
                }
                paramArrayOfbhxc[i].b = 4;
                paramArrayOfbhxc[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbhxc.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfbhxc[paramInt].b = 9;
                paramArrayOfbhxc[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfbhxc.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfbhxc[i].b = 0;
                paramArrayOfbhxc[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfbhxc.length) {
              break label151;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label151;
            }
            paramArrayOfbhxc[j].b = 6;
            paramArrayOfbhxc[j].a = 1;
            paramInt = j + 1;
            break label151;
            break;
            if (paramInt != 16) {
              break label477;
            }
            paramArrayOfbhxc[0].b = 3;
            paramArrayOfbhxc[0].a = 0;
            i = 1;
            break label213;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfbhxc[i].b = 5;
              paramArrayOfbhxc[i].a = 1;
              paramInt = i + 1;
            }
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfg
 * JD-Core Version:    0.7.0.1
 */