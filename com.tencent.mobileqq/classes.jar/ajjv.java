import com.tencent.mobileqq.activity.recent.RecentBaseData;

class ajjv
  extends bibk
{
  ajjv(ajju paramajju, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
  {
    if ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0)) {
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
        if ((paramArrayOfbibj.length >= 0) || (!ajkm.a(((RecentBaseData)paramObject).a())) || (!ajks.a().a()) || (ajks.a().a(((RecentBaseData)paramObject).a()))) {
          break label483;
        }
        paramArrayOfbibj[0].b = 6;
        paramArrayOfbibj[0].a = 1;
      }
      label213:
      label477:
      label483:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbibj.length)
        {
          paramArrayOfbibj[i].b = 0;
          paramArrayOfbibj[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbibj.length)
        {
          paramArrayOfbibj[paramInt].b = -1;
          paramArrayOfbibj[paramInt].a = -1;
          paramInt += 1;
          continue;
          if (paramArrayOfbibj.length >= 0) {
            break label477;
          }
          paramInt = k & 0xF0;
          if (paramInt != 32) {
            break label417;
          }
          paramArrayOfbibj[0].b = 2;
          paramArrayOfbibj[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          paramInt = i;
          int j;
          if (i < paramArrayOfbibj.length)
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
                paramArrayOfbibj[i].b = 4;
                paramArrayOfbibj[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbibj.length)
            {
              i = paramInt;
              if ((0xF000000 & k) == 16777216)
              {
                paramArrayOfbibj[paramInt].b = 9;
                paramArrayOfbibj[paramInt].a = 1;
                i = paramInt + 1;
              }
            }
            j = i;
            if (i < paramArrayOfbibj.length)
            {
              j = i;
              if ((k & 0xF) == 1)
              {
                paramArrayOfbibj[i].b = 0;
                paramArrayOfbibj[i].a = 0;
                j = i + 1;
              }
            }
            paramInt = j;
            if (j >= paramArrayOfbibj.length) {
              break label151;
            }
            paramInt = j;
            if ((k & 0x300000) != 2097152) {
              break label151;
            }
            paramArrayOfbibj[j].b = 6;
            paramArrayOfbibj[j].a = 1;
            paramInt = j + 1;
            break label151;
            break;
            if (paramInt != 16) {
              break label477;
            }
            paramArrayOfbibj[0].b = 3;
            paramArrayOfbibj[0].a = 0;
            i = 1;
            break label213;
            paramInt = i;
            if (j == 131072)
            {
              paramArrayOfbibj[i].b = 5;
              paramArrayOfbibj[i].a = 1;
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
 * Qualified Name:     ajjv
 * JD-Core Version:    0.7.0.1
 */