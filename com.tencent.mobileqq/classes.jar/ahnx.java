import com.tencent.mobileqq.activity.recent.RecentBaseData;

class ahnx
  extends bfwg
{
  ahnx(ahnw paramahnw, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bfwf[] paramArrayOfbfwf)
  {
    if ((paramArrayOfbfwf == null) || (paramArrayOfbfwf.length <= 0)) {
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
        if ((paramArrayOfbfwf.length >= 0) || (!ahoo.a(((RecentBaseData)paramObject).a())) || (!ahou.a().a()) || (ahou.a().a(((RecentBaseData)paramObject).a()))) {
          break label483;
        }
        paramArrayOfbfwf[0].b = 6;
        paramArrayOfbfwf[0].a = 1;
      }
      label213:
      label477:
      label483:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbfwf.length)
        {
          paramArrayOfbfwf[i].b = 0;
          paramArrayOfbfwf[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbfwf.length)
        {
          paramArrayOfbfwf[paramInt].b = -1;
          paramArrayOfbfwf[paramInt].a = -1;
          paramInt += 1;
          continue;
          if (paramArrayOfbfwf.length >= 0) {
            break label477;
          }
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label417;
          }
          paramArrayOfbfwf[0].b = 2;
          paramArrayOfbfwf[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfbfwf.length)
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
                paramArrayOfbfwf[i].b = 4;
                paramArrayOfbfwf[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbfwf.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfbfwf[paramInt].b = 9;
                paramArrayOfbfwf[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfbfwf.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfbfwf[i].b = 0;
                paramArrayOfbfwf[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfbfwf.length) {
              break label151;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label151;
            }
            paramArrayOfbfwf[j].b = 6;
            paramArrayOfbfwf[j].a = 1;
            paramInt = j + 1;
            break label151;
            break;
            if (paramInt != 16) {
              break label477;
            }
            paramArrayOfbfwf[0].b = 3;
            paramArrayOfbfwf[0].a = 0;
            i = 1;
            break label213;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfbfwf[i].b = 5;
              paramArrayOfbfwf[i].a = 1;
              paramInt = i + 1;
            }
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnx
 * JD-Core Version:    0.7.0.1
 */