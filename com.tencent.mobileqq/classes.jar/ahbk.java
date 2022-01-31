import com.tencent.mobileqq.activity.recent.RecentBaseData;

class ahbk
  extends benv
{
  ahbk(ahbj paramahbj, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, benu[] paramArrayOfbenu)
  {
    if ((paramArrayOfbenu == null) || (paramArrayOfbenu.length <= 0)) {
      return;
    }
    if ((paramObject instanceof RecentBaseData)) {}
    label395:
    for (int j = ((RecentBaseData)paramObject).mMenuFlag;; j = 0)
    {
      if (((paramObject instanceof RecentBaseData)) && ((((RecentBaseData)paramObject).a() == 1008) || (((RecentBaseData)paramObject).a() == 7220)))
      {
        if ((paramArrayOfbenu.length >= 0) || (!ahcb.a(((RecentBaseData)paramObject).a())) || (!ahch.a().a()) || (ahch.a().a(((RecentBaseData)paramObject).a()))) {
          break label435;
        }
        paramArrayOfbenu[0].b = 6;
        paramArrayOfbenu[0].a = 1;
      }
      label151:
      label429:
      label435:
      for (int i = 1;; i = 0)
      {
        paramInt = i;
        if (i < paramArrayOfbenu.length)
        {
          paramArrayOfbenu[i].b = 0;
          paramArrayOfbenu[i].a = 0;
          paramInt = i + 1;
        }
        while (paramInt < paramArrayOfbenu.length)
        {
          paramArrayOfbenu[paramInt].b = -1;
          paramArrayOfbenu[paramInt].a = -1;
          paramInt += 1;
          continue;
          if (paramArrayOfbenu.length >= 0) {
            break label429;
          }
          paramInt = j & 0xF0;
          if (paramInt != 32) {
            break label369;
          }
          paramArrayOfbenu[0].b = 2;
          paramArrayOfbenu[0].a = 1;
          i = 1;
        }
        for (;;)
        {
          label213:
          paramInt = i;
          int k;
          if (i < paramArrayOfbenu.length)
          {
            paramInt = i;
            if ((paramObject instanceof RecentBaseData))
            {
              paramInt = i;
              if (((RecentBaseData)paramObject).a())
              {
                k = 0xF0000 & j;
                if (k != 65536) {
                  break label395;
                }
                paramArrayOfbenu[i].b = 4;
                paramArrayOfbenu[i].a = 1;
                paramInt = i + 1;
              }
            }
          }
          for (;;)
          {
            i = paramInt;
            if (paramInt < paramArrayOfbenu.length)
            {
              i = paramInt;
              if ((j & 0xF) == 1)
              {
                paramArrayOfbenu[paramInt].b = 0;
                paramArrayOfbenu[paramInt].a = 0;
                i = paramInt + 1;
              }
            }
            paramInt = i;
            if (i >= paramArrayOfbenu.length) {
              break label151;
            }
            paramInt = i;
            if ((j & 0x300000) != 2097152) {
              break label151;
            }
            paramArrayOfbenu[i].b = 6;
            paramArrayOfbenu[i].a = 1;
            paramInt = i + 1;
            break label151;
            break;
            label369:
            if (paramInt != 16) {
              break label429;
            }
            paramArrayOfbenu[0].b = 3;
            paramArrayOfbenu[0].a = 0;
            i = 1;
            break label213;
            paramInt = i;
            if (k == 131072)
            {
              paramArrayOfbenu[i].b = 5;
              paramArrayOfbenu[i].a = 1;
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
 * Qualified Name:     ahbk
 * JD-Core Version:    0.7.0.1
 */