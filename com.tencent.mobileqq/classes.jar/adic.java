import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class adic
{
  private SparseArrayCompat<SparseArrayCompat<adih>> a = new SparseArrayCompat(15);
  private SparseArrayCompat<adig> b = new SparseArrayCompat();
  
  public adic(BaseChatPie paramBaseChatPie)
  {
    a(1, new adiq(paramBaseChatPie));
    a(2, new aqln(paramBaseChatPie));
    a(3, new adif(paramBaseChatPie));
    a(4, new aibu(paramBaseChatPie));
    a(5, new adjv(paramBaseChatPie));
    a(6, new aqwa(paramBaseChatPie));
    a(7, new adiu(paramBaseChatPie));
    a(8, new adhl(paramBaseChatPie));
    a(9, new avnl(paramBaseChatPie));
    a(10, new adii(paramBaseChatPie));
    a(11, new adin(paramBaseChatPie));
    a(12, new adhu(paramBaseChatPie));
    a(13, new aqft(paramBaseChatPie));
    a(37, new aqcn(paramBaseChatPie));
    a(14, new adji(paramBaseChatPie));
    a(15, new AIOLongShotHelper(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aeoo))
    {
      a(16, new ardr((aeoo)paramBaseChatPie));
      a(30, new adjb(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof aequ)) {
      a(16, new ardr((aequ)paramBaseChatPie));
    }
    a(17, new adiw(paramBaseChatPie));
    a(18, new adid());
    a(19, new aneu(paramBaseChatPie));
    a(20, new adhx());
    a(24, new adhy(paramBaseChatPie));
    a(22, new adjw());
    if (((paramBaseChatPie instanceof aetp)) || ((paramBaseChatPie instanceof aemf))) {
      a(23, new adjr(paramBaseChatPie));
    }
    a(21, new adgn(paramBaseChatPie));
    a(25, new adhw(paramBaseChatPie));
    a(26, new adis(paramBaseChatPie));
    a(27, new adiy(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      a(28, new adjn(paramBaseChatPie));
      a(31, new adjp(paramBaseChatPie));
    }
    a(29, new adjg(paramBaseChatPie));
    a(39, new adie(paramBaseChatPie));
    a(44, new adjc(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie))
    {
      TroopChatPie localTroopChatPie = (TroopChatPie)paramBaseChatPie;
      a(33, new aruf(paramBaseChatPie));
      a(34, new adgm(localTroopChatPie));
    }
    if ((paramBaseChatPie instanceof aeoo)) {
      a(32, new arud(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeoo))) {
      a(35, new adhi(paramBaseChatPie));
    }
    a(38, new adiv(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aetp)) {
      a(36, new adjd(paramBaseChatPie));
    }
    if (((paramBaseChatPie instanceof aeoo)) || ((paramBaseChatPie instanceof aets)) || ((paramBaseChatPie instanceof aerl))) {
      a(42, new avcw(paramBaseChatPie));
    }
    a(40, new adje(paramBaseChatPie));
    a(41, new adjh(paramBaseChatPie));
    a(43, new adjk(paramBaseChatPie));
    if ((paramBaseChatPie instanceof aeoo)) {
      a(45, new awbs(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof aequ)) {
      a(45, new awbs(paramBaseChatPie));
    }
    a(46, new adha(paramBaseChatPie));
    a(47, new adik(paramBaseChatPie));
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(48, new adjo(paramBaseChatPie));
    }
    a(49, new adgc(paramBaseChatPie));
    if (((paramBaseChatPie instanceof aeoo)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeoe))) {
      a(50, new amcp(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(51, new adjq(paramBaseChatPie));
    }
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      a(52, new adho(paramBaseChatPie));
    }
  }
  
  private void a(int paramInt, adig paramadig)
  {
    this.b.put(paramInt, paramadig);
  }
  
  private void a(int paramInt, adih paramadih)
  {
    this.b.put(paramInt, paramadih);
    int[] arrayOfInt = paramadih.a();
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
      localSparseArrayCompat1.put(paramInt, paramadih);
      i += 1;
    }
  }
  
  public <T extends adig> T a(int paramInt)
  {
    return (adig)this.b.get(paramInt);
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
        ((adih)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adic
 * JD-Core Version:    0.7.0.1
 */