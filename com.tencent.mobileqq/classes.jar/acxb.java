import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;

public class acxb
{
  private SparseArrayCompat<SparseArrayCompat<acxg>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<acxf> b = new SparseArrayCompat();
  
  public acxb(BaseChatPie paramBaseChatPie)
  {
    a(1, new acxp(paramBaseChatPie));
    a(2, new apry(paramBaseChatPie));
    a(3, new acxe(paramBaseChatPie));
    a(4, new ahpc(paramBaseChatPie));
    a(5, new acyt(paramBaseChatPie));
    a(6, new aqby(paramBaseChatPie));
    a(7, new acxt(paramBaseChatPie));
    a(8, new acwp(paramBaseChatPie));
    a(9, new auod(paramBaseChatPie));
    a(10, new acxh(paramBaseChatPie));
    a(11, new acxm(paramBaseChatPie));
    a(12, new acwt(paramBaseChatPie));
    a(13, new apmf(paramBaseChatPie));
    a(37, new apja(paramBaseChatPie));
    a(14, new acyh(paramBaseChatPie));
    a(15, new AIOLongShotHelper(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aedo))
    {
      a(16, new aqjm((aedo)paramBaseChatPie));
      a(30, new acya(paramBaseChatPie));
    }
    a(17, new acxv(paramBaseChatPie));
    a(18, new acxc());
    a(19, new amon(paramBaseChatPie));
    a(20, new acww());
    a(24, new acwx(paramBaseChatPie));
    a(22, new acyu());
    if (((paramBaseChatPie instanceof aeis)) || ((paramBaseChatPie instanceof aebg))) {
      a(23, new acyp(paramBaseChatPie));
    }
    a(21, new acvp(paramBaseChatPie));
    a(25, new acwv(paramBaseChatPie));
    a(26, new acxr(paramBaseChatPie));
    a(27, new acxx(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aejb))
    {
      a(28, new acym(paramBaseChatPie));
      a(31, new acyo(paramBaseChatPie));
    }
    a(29, new acyf(paramBaseChatPie));
    a(39, new acxd(paramBaseChatPie));
    a(44, new acyb(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aejb))
    {
      aejb localaejb = (aejb)paramBaseChatPie;
      a(33, new aqyr(paramBaseChatPie));
      a(34, new acvo(localaejb));
    }
    if ((paramBaseChatPie instanceof aedo)) {
      a(32, new aqyp(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof aejb)) || ((paramBaseChatPie instanceof aedo))) {
      a(35, new acwm(paramBaseChatPie));
    }
    a(38, new acxu(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aeis)) {
      a(36, new acyc(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof aedo)) || ((paramBaseChatPie instanceof aeiv)) || ((paramBaseChatPie instanceof aego))) {
      a(42, new audq(paramBaseChatPie));
    }
    a(40, new acyd(paramBaseChatPie));
    a(41, new acyg(paramBaseChatPie));
    a(43, new acyj(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aedo)) {
      a(45, new avbz(paramBaseChatPie));
    }
    a(46, new acwe(paramBaseChatPie));
    a(47, new acxj(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aejb)) {
      a(48, new acyn(paramBaseChatPie));
    }
  }
  
  private void a(int paramInt, acxf paramacxf)
  {
    this.b.put(paramInt, paramacxf);
  }
  
  private void a(int paramInt, acxg paramacxg)
  {
    this.b.put(paramInt, paramacxg);
    int[] arrayOfInt = paramacxg.a();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.a.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.a.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramacxg);
      i += 1;
    }
  }
  
  public <T extends acxf> T a(int paramInt)
  {
    return (acxf)this.b.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.a.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((acxg)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acxb
 * JD-Core Version:    0.7.0.1
 */