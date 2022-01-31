import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class abnm
{
  public static void a(awcz paramawcz, boolean paramBoolean)
  {
    int i3;
    int i2;
    label22:
    int i;
    int j;
    int n;
    int m;
    int k;
    Object localObject2;
    label94:
    bfso localbfso1;
    label106:
    bfso localbfso2;
    if (paramawcz != null)
    {
      i3 = paramawcz.a(1);
      if (paramawcz == null) {
        break label625;
      }
      i2 = paramawcz.a(2);
      Object localObject1 = "";
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
        break label848;
      }
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i2 > 0) {
        break label848;
      }
      if (paramawcz == null) {
        break label631;
      }
      localObject2 = paramawcz.a(6);
      if (paramawcz == null) {
        break label637;
      }
      localbfso1 = paramawcz.a(61);
      if (paramawcz == null) {
        break label643;
      }
      localbfso2 = paramawcz.a(3);
      label117:
      k = i1;
      i = j;
      paramawcz = (awcz)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        paramawcz = (awcz)localObject1;
        if (((bfso)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
        {
          k = i1;
          i = j;
          paramawcz = (awcz)localObject1;
          if (((bfso)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            k = i1;
            i = j;
            paramawcz = (awcz)localObject1;
            if (((QZoneCountUserInfo)((bfso)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
            {
              k = i1;
              i = j;
              paramawcz = (awcz)localObject1;
              if (((bfso)localObject2).jdField_a_of_type_Long > 0L)
              {
                k = i1;
                i = j;
                paramawcz = (awcz)localObject1;
                if (!TextUtils.isEmpty(((bfso)localObject2).f))
                {
                  paramawcz = ((bfso)localObject2).f;
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
      localObject1 = paramawcz;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = paramawcz;
        if (localbfso1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = paramawcz;
          if (localbfso1.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = k;
            j = i4;
            localObject1 = paramawcz;
            if (localbfso1.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = paramawcz;
              if (((QZoneCountUserInfo)localbfso1.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = paramawcz;
                if (localbfso1.jdField_a_of_type_Long > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = paramawcz;
                  if (!TextUtils.isEmpty(localbfso1.f))
                  {
                    localObject1 = localbfso1.f;
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
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbfso2 == null) {
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbfso2.jdField_a_of_type_JavaUtilArrayList == null) {
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbfso2.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localbfso2.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) {
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbfso2.jdField_a_of_type_Long <= 0L) {
        break label848;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localbfso2.f)) {
        break label848;
      }
      paramawcz = localbfso2.f;
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
            if (paramBoolean)
            {
              i = 1;
              label605:
              LpReportInfo_pf00064.report(637, 13, i, null, "0", null);
            }
          }
        }
      }
      label625:
      label631:
      label637:
      do
      {
        return;
        i3 = 0;
        break;
        i2 = 0;
        break label22;
        localObject2 = null;
        break label94;
        localbfso1 = null;
        break label106;
        localbfso2 = null;
        break label117;
        i = 2;
        break label605;
        if (paramBoolean)
        {
          i = 1;
          if (i2 <= 1) {
            break label687;
          }
        }
        for (paramawcz = "2";; paramawcz = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, null, paramawcz, null);
          return;
          i = 2;
          break;
        }
        if (i2 <= 0)
        {
          if (paramBoolean) {}
          for (i = 1;; i = 2)
          {
            LpReportInfo_pf00064.report(637, 12, i, null, "0", null);
            return;
          }
        }
        if (paramBoolean)
        {
          i = 1;
          if (i2 <= 1) {
            break label756;
          }
        }
        for (paramawcz = "2";; paramawcz = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, null, paramawcz, null);
          return;
          i = 2;
          break;
        }
        if (m != 0)
        {
          if (paramBoolean) {}
          for (i = 1;; i = 2)
          {
            LpReportInfo_pf00064.report(637, 15, i, null, null, paramawcz);
            return;
          }
        }
        if (k != 0)
        {
          if (paramBoolean) {}
          for (i = 1;; i = 2)
          {
            LpReportInfo_pf00064.report(637, 17, i, null, null, paramawcz);
            return;
          }
        }
      } while (j == 0);
      label643:
      label687:
      label756:
      if (paramBoolean) {}
      for (i = 1;; i = 2)
      {
        LpReportInfo_pf00064.report(637, 16, i, null, null, paramawcz);
        return;
      }
      label848:
      i = n;
      j = m;
      m = 0;
      paramawcz = (awcz)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    bfpl localbfpl = new bfpl();
    localbfpl.c = "637";
    localbfpl.d = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localbfpl, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abnm
 * JD-Core Version:    0.7.0.1
 */