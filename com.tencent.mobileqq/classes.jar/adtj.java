import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class adtj
{
  public static void a(azbw paramazbw, boolean paramBoolean1, boolean paramBoolean2)
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
    bjha localbjha1;
    label138:
    bjha localbjha2;
    if (paramazbw != null)
    {
      i3 = paramazbw.a(1);
      if (paramazbw == null) {
        break label685;
      }
      i2 = paramazbw.a(2);
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
      if (paramazbw == null) {
        break label691;
      }
      localObject2 = paramazbw.a(6);
      if (paramazbw == null) {
        break label697;
      }
      localbjha1 = paramazbw.a(61);
      if (paramazbw == null) {
        break label703;
      }
      localbjha2 = paramazbw.a(3);
      label149:
      k = i1;
      i = j;
      paramazbw = (azbw)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        paramazbw = (azbw)localObject1;
        if (((bjha)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
        {
          k = i1;
          i = j;
          paramazbw = (azbw)localObject1;
          if (((bjha)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            k = i1;
            i = j;
            paramazbw = (azbw)localObject1;
            if (((QZoneCountUserInfo)((bjha)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
            {
              k = i1;
              i = j;
              paramazbw = (azbw)localObject1;
              if (((bjha)localObject2).jdField_a_of_type_Long > 0L)
              {
                k = i1;
                i = j;
                paramazbw = (azbw)localObject1;
                if (!TextUtils.isEmpty(((bjha)localObject2).f))
                {
                  paramazbw = ((bjha)localObject2).f;
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
      localObject1 = paramazbw;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = paramazbw;
        if (localbjha1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = paramazbw;
          if (localbjha1.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i1 = k;
            j = i4;
            localObject1 = paramazbw;
            if (localbjha1.jdField_a_of_type_JavaUtilArrayList.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = paramazbw;
              if (((QZoneCountUserInfo)localbjha1.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = paramazbw;
                if (localbjha1.jdField_a_of_type_Long > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = paramazbw;
                  if (!TextUtils.isEmpty(localbjha1.f))
                  {
                    localObject1 = localbjha1.f;
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
      if (localbjha2 == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbjha2.jdField_a_of_type_JavaUtilArrayList == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbjha2.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localbjha2.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localbjha2.jdField_a_of_type_Long <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localbjha2.f)) {
        break label1008;
      }
      paramazbw = localbjha2.f;
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
              paramazbw = "1";
              label665:
              LpReportInfo_pf00064.report(637, 13, i, paramazbw, "0", null);
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
        localbjha1 = null;
        break label138;
        localbjha2 = null;
        break label149;
        i = 2;
        break label658;
        paramazbw = "2";
        break label665;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label762;
          }
          paramazbw = "1";
          if (i2 <= 1) {
            break label768;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, paramazbw, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramazbw = "2";
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
          for (paramazbw = "1";; paramazbw = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, paramazbw, "0", null);
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
          paramazbw = "1";
          if (i2 <= 1) {
            break label866;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, paramazbw, (String)localObject1, null);
          return;
          i = 2;
          break;
          paramazbw = "2";
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
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject1, null, paramazbw);
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
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject1, null, paramazbw);
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
        LpReportInfo_pf00064.report(637, 16, i, (String)localObject1, null, paramazbw);
        return;
        i = 2;
        break;
      }
      label1008:
      i = n;
      j = m;
      m = 0;
      paramazbw = (azbw)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    bjdn localbjdn = new bjdn();
    localbjdn.c = "637";
    localbjdn.d = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localbjdn, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtj
 * JD-Core Version:    0.7.0.1
 */