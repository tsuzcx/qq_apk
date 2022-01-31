import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class abxm
{
  public static void a(axcj paramaxcj, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneEntryReporterInLeba", 2, "Leba isTableModel:" + paramBoolean2);
    }
    int i3;
    int i2;
    label53:
    Object localObject1;
    int i;
    int j;
    int n;
    int m;
    int k;
    Object localObject2;
    label126:
    bhbm localbhbm1;
    label138:
    bhbm localbhbm2;
    if (paramaxcj != null)
    {
      i3 = paramaxcj.a(1);
      if (paramaxcj == null) {
        break label685;
      }
      i2 = paramaxcj.a(2);
      localObject1 = "";
      i = 0;
      j = 0;
      int i5 = 0;
      int i4 = 0;
      int i6 = 0;
      int i1 = 0;
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i3 > 0) {
        break label1008;
      }
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i2 > 0) {
        break label1008;
      }
      if (paramaxcj == null) {
        break label691;
      }
      localObject2 = paramaxcj.a(6);
      if (paramaxcj == null) {
        break label697;
      }
      localbhbm1 = paramaxcj.a(61);
      if (paramaxcj == null) {
        break label703;
      }
      localbhbm2 = paramaxcj.a(3);
      label149:
      k = i1;
      i = j;
      paramaxcj = (axcj)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        paramaxcj = (axcj)localObject1;
        if (((bhbm)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
        {
          k = i1;
          i = j;
          paramaxcj = (axcj)localObject1;
          if (((bhbm)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            k = i1;
            i = j;
            paramaxcj = (axcj)localObject1;
            if (((QZoneCountUserInfo)((bhbm)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
            {
              k = i1;
              i = j;
              paramaxcj = (axcj)localObject1;
              if (((bhbm)localObject2).jdField_a_of_type_Long > 0L)
              {
                k = i1;
                i = j;
                paramaxcj = (axcj)localObject1;
                if (!TextUtils.isEmpty(((bhbm)localObject2).f))
                {
                  paramaxcj = ((bhbm)localObject2).f;
                  k = 1;
                  i = 1;
                }
              }
            }
          }
        }
      }
      i1 = k;
      j = i4;
      localObject1 = paramaxcj;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = paramaxcj;
        if (localbhbm1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = paramaxcj;
          if (localbhbm1.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = k;
            j = i4;
            localObject1 = paramaxcj;
            if (localbhbm1.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = paramaxcj;
              if (((QZoneCountUserInfo)localbhbm1.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = paramaxcj;
                if (localbhbm1.jdField_a_of_type_Long > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = paramaxcj;
                  if (!TextUtils.isEmpty(localbhbm1.f))
                  {
                    localObject1 = localbhbm1.f;
                    i1 = 1;
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (i1 != 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbhbm2 == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbhbm2.jdField_a_of_type_JavaUtilArrayList == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbhbm2.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localbhbm2.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbhbm2.jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localbhbm2.f)) {
        break label1008;
      }
      paramaxcj = localbhbm2.f;
      n = 1;
      m = 1;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0) {
        if (i3 <= 0) {
          if (i2 <= 0) {
            if (paramBoolean1)
            {
              i = 1;
              label658:
              if (!paramBoolean2) {
                break label714;
              }
              paramaxcj = "1";
              label665:
              LpReportInfo_pf00064.report(637, 13, i, paramaxcj, "0", null);
            }
          }
        }
      }
      label685:
      label691:
      label697:
      label703:
      label714:
      label733:
      label762:
      do
      {
        return;
        i3 = 0;
        break;
        i2 = 0;
        break label53;
        localObject2 = null;
        break label126;
        localbhbm1 = null;
        break label138;
        localbhbm2 = null;
        break label149;
        i = 2;
        break label658;
        paramaxcj = "2";
        break label665;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label762;
          }
          paramaxcj = "1";
          if (i2 <= 1) {
            break label768;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, paramaxcj, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramaxcj = "2";
          break label733;
        }
        if (i2 <= 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label812;
            }
          }
          for (paramaxcj = "1";; paramaxcj = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, paramaxcj, "0", null);
            return;
            i = 2;
            break;
          }
        }
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label860;
          }
          paramaxcj = "1";
          if (i2 <= 1) {
            break label866;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, paramaxcj, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramaxcj = "2";
          break label831;
        }
        if (m != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label911;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject1, null, paramaxcj);
            return;
            i = 2;
            break;
          }
        }
        if (k != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label956;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject1, null, paramaxcj);
            return;
            i = 2;
            break;
          }
        }
      } while (j == 0);
      label768:
      label812:
      label831:
      label860:
      label866:
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label1001;
        }
      }
      label911:
      label956:
      label1001:
      for (localObject1 = "1";; localObject1 = "2")
      {
        LpReportInfo_pf00064.report(637, 16, i, (String)localObject1, null, paramaxcj);
        return;
        i = 2;
        break;
      }
      label1008:
      i = n;
      j = m;
      m = 0;
      paramaxcj = (axcj)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    bgyj localbgyj = new bgyj();
    localbgyj.c = "637";
    localbgyj.d = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localbgyj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abxm
 * JD-Core Version:    0.7.0.1
 */