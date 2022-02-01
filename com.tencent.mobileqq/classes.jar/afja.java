import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class afja
{
  public static void a(bcvn parambcvn, boolean paramBoolean1, boolean paramBoolean2)
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
    bmwi localbmwi1;
    label138:
    bmwi localbmwi2;
    if (parambcvn != null)
    {
      i3 = parambcvn.a(1);
      if (parambcvn == null) {
        break label685;
      }
      i2 = parambcvn.a(2);
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
      if (parambcvn == null) {
        break label691;
      }
      localObject2 = parambcvn.a(6);
      if (parambcvn == null) {
        break label697;
      }
      localbmwi1 = parambcvn.a(61);
      if (parambcvn == null) {
        break label703;
      }
      localbmwi2 = parambcvn.a(3);
      label149:
      k = i1;
      i = j;
      parambcvn = (bcvn)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        parambcvn = (bcvn)localObject1;
        if (((bmwi)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
        {
          k = i1;
          i = j;
          parambcvn = (bcvn)localObject1;
          if (((bmwi)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            k = i1;
            i = j;
            parambcvn = (bcvn)localObject1;
            if (((QZoneCountUserInfo)((bmwi)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
            {
              k = i1;
              i = j;
              parambcvn = (bcvn)localObject1;
              if (((bmwi)localObject2).jdField_a_of_type_Long > 0L)
              {
                k = i1;
                i = j;
                parambcvn = (bcvn)localObject1;
                if (!TextUtils.isEmpty(((bmwi)localObject2).f))
                {
                  parambcvn = ((bmwi)localObject2).f;
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
      localObject1 = parambcvn;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = parambcvn;
        if (localbmwi1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = parambcvn;
          if (localbmwi1.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = k;
            j = i4;
            localObject1 = parambcvn;
            if (localbmwi1.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = parambcvn;
              if (((QZoneCountUserInfo)localbmwi1.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = parambcvn;
                if (localbmwi1.jdField_a_of_type_Long > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = parambcvn;
                  if (!TextUtils.isEmpty(localbmwi1.f))
                  {
                    localObject1 = localbmwi1.f;
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
      if (localbmwi2 == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbmwi2.jdField_a_of_type_JavaUtilArrayList == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbmwi2.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localbmwi2.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbmwi2.jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localbmwi2.f)) {
        break label1008;
      }
      parambcvn = localbmwi2.f;
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
              parambcvn = "1";
              label665:
              LpReportInfo_pf00064.report(637, 13, i, parambcvn, "0", null);
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
        localbmwi1 = null;
        break label138;
        localbmwi2 = null;
        break label149;
        i = 2;
        break label658;
        parambcvn = "2";
        break label665;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label762;
          }
          parambcvn = "1";
          if (i2 <= 1) {
            break label768;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, parambcvn, (String)localObject1, null);
          return;
          i = 2;
          break;
          parambcvn = "2";
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
          for (parambcvn = "1";; parambcvn = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, parambcvn, "0", null);
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
          parambcvn = "1";
          if (i2 <= 1) {
            break label866;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, parambcvn, (String)localObject1, null);
          return;
          i = 2;
          break;
          parambcvn = "2";
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
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject1, null, parambcvn);
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
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject1, null, parambcvn);
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
        LpReportInfo_pf00064.report(637, 16, i, (String)localObject1, null, parambcvn);
        return;
        i = 2;
        break;
      }
      label1008:
      i = n;
      j = m;
      m = 0;
      parambcvn = (bcvn)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    bmsx localbmsx = new bmsx();
    localbmsx.c = "637";
    localbmsx.d = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localbmsx, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afja
 * JD-Core Version:    0.7.0.1
 */