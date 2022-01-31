import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class adia
{
  private SparseArrayCompat<SparseArrayCompat<adif>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<adie> b = new SparseArrayCompat();
  
  public adia(BaseChatPie paramBaseChatPie)
  {
    a(1, new adio(paramBaseChatPie));
    a(2, new aqlp(paramBaseChatPie));
    a(3, new adid(paramBaseChatPie));
    a(4, new aibs(paramBaseChatPie));
    a(5, new adjt(paramBaseChatPie));
    a(6, new aqwc(paramBaseChatPie));
    a(7, new adis(paramBaseChatPie));
    a(8, new adhi(paramBaseChatPie));
    a(9, new avnn(paramBaseChatPie));
    a(10, new adig(paramBaseChatPie));
    a(11, new adil(paramBaseChatPie));
    a(12, new adhs(paramBaseChatPie));
    a(13, new aqfv(paramBaseChatPie));
    a(37, new aqcp(paramBaseChatPie));
    a(14, new adjg(paramBaseChatPie));
    a(15, new AIOLongShotHelper(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aeom))
    {
      a(16, new ardt((aeom)paramBaseChatPie));
      a(30, new adiz(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof aeqs)) {
      a(16, new ardt((aeqs)paramBaseChatPie));
    }
    a(17, new adiu(paramBaseChatPie));
    a(18, new adib());
    a(19, new anez(paramBaseChatPie));
    a(20, new adhv());
    a(24, new adhw(paramBaseChatPie));
    a(22, new adju());
    if (((paramBaseChatPie instanceof aetn)) || ((paramBaseChatPie instanceof aemd))) {
      a(23, new adjp(paramBaseChatPie));
    }
    a(21, new adgk(paramBaseChatPie));
    a(25, new adhu(paramBaseChatPie));
    a(26, new adiq(paramBaseChatPie));
    a(27, new adiw(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      a(28, new adjl(paramBaseChatPie));
      a(31, new adjn(paramBaseChatPie));
    }
    a(29, new adje(paramBaseChatPie));
    a(39, new adic(paramBaseChatPie));
    a(44, new adja(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      TroopChatPie localTroopChatPie = (TroopChatPie)paramBaseChatPie;
      a(33, new aruh(paramBaseChatPie));
      a(34, new adgj(localTroopChatPie));
    }
    if ((paramBaseChatPie instanceof aeom)) {
      a(32, new aruf(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeom))) {
      a(35, new adhf(paramBaseChatPie));
    }
    a(38, new adit(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aetn)) {
      a(36, new adjb(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof aeom)) || ((paramBaseChatPie instanceof aetq)) || ((paramBaseChatPie instanceof aerj))) {
      a(42, new avcy(paramBaseChatPie));
    }
    a(40, new adjc(paramBaseChatPie));
    a(41, new adjf(paramBaseChatPie));
    a(43, new adji(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aeom)) {
      a(45, new awbu(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof aeqs)) {
      a(45, new awbu(paramBaseChatPie));
    }
    a(46, new adgx(paramBaseChatPie));
    a(47, new adii(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(48, new adjm(paramBaseChatPie));
    }
    a(49, new adfz(paramBaseChatPie));
    if (((paramBaseChatPie instanceof aeom)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeoc))) {
      a(50, new amco(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(51, new adjo(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(52, new adhl(paramBaseChatPie));
    }
  }
  
  private void a(int paramInt, adie paramadie)
  {
    this.b.put(paramInt, paramadie);
  }
  
  private void a(int paramInt, adif paramadif)
  {
    this.b.put(paramInt, paramadif);
    int[] arrayOfInt = paramadif.a();
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
      localSparseArrayCompat1.put(paramInt, paramadif);
      i += 1;
    }
  }
  
  public <T extends adie> T a(int paramInt)
  {
    return (adie)this.b.get(paramInt);
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
        ((adif)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adia
 * JD-Core Version:    0.7.0.1
 */