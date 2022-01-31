import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afag
{
  private SparseArrayCompat<SparseArrayCompat<afal>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(15);
  private List<afay> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<afak> b = new SparseArrayCompat();
  
  public afag(BaseChatPie paramBaseChatPie)
  {
    a(1, new afau(paramBaseChatPie));
    a(2, new asff(paramBaseChatPie));
    a(3, new afaj(paramBaseChatPie));
    a(4, new ajtc(paramBaseChatPie));
    a(5, new afcd(paramBaseChatPie));
    a(6, new asmq(paramBaseChatPie));
    a(7, new afaz(paramBaseChatPie));
    a(8, new aezm(this, paramBaseChatPie));
    a(9, new axfi(paramBaseChatPie));
    a(10, new afam(paramBaseChatPie));
    a(11, new afar(paramBaseChatPie));
    a(12, new aezx(paramBaseChatPie));
    a(13, new arzk(paramBaseChatPie));
    a(57, new arya(paramBaseChatPie));
    a(37, new arvx(paramBaseChatPie));
    a(14, new afbo(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new afbc(paramBaseChatPie));
    a(18, new afah());
    a(19, new aowg(paramBaseChatPie));
    a(20, new afaa());
    a(24, new afab(paramBaseChatPie));
    a(22, new afce());
    a(21, new aeyo(paramBaseChatPie));
    a(25, new aezz(paramBaseChatPie));
    a(26, new afaw(paramBaseChatPie));
    a(27, new afbe(paramBaseChatPie));
    a(29, new afbm(paramBaseChatPie));
    a(39, new afai(paramBaseChatPie));
    a(44, new afbi(paramBaseChatPie));
    a(38, new afbb(paramBaseChatPie));
    a(40, new afbk(paramBaseChatPie));
    a(41, new afbn(paramBaseChatPie));
    a(43, new afbq(paramBaseChatPie));
    a(46, new aezb(paramBaseChatPie));
    a(47, new afao(paramBaseChatPie));
    a(49, new aeyc(paramBaseChatPie));
    a(53, new afcc(paramBaseChatPie));
    a(54, new aeyn(paramBaseChatPie));
  }
  
  private void a(int paramInt, afak paramafak)
  {
    this.b.put(paramInt, paramafak);
  }
  
  private void a(int paramInt, afal paramafal)
  {
    this.b.put(paramInt, paramafal);
    int[] arrayOfInt = paramafal.a();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramafal);
      i += 1;
    }
  }
  
  public <T extends afak> T a(int paramInt)
  {
    return (afak)this.b.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((afal)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((afay)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(afay paramafay)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramafay);
  }
  
  public void a(agiu paramagiu)
  {
    a(23, new afby(paramagiu));
  }
  
  public void a(agkt paramagkt)
  {
    a(50, new antn(paramagkt));
  }
  
  public void a(agld paramagld)
  {
    a(16, new asuh(paramagld));
    a(30, new afbh(paramagld));
    a(32, new atla(paramagld));
    a(35, new aezj(paramagld));
    a(42, new awul(paramagld));
    a(45, new axwx(paramagld));
    a(50, new antn(paramagld));
  }
  
  public void a(aglv paramaglv)
  {
    a(56, new afaf(paramaglv));
  }
  
  public void a(agnp paramagnp)
  {
    a(16, new asuh(paramagnp));
    a(45, new axwx(paramagnp));
  }
  
  public void a(agoj paramagoj)
  {
    a(42, new awul(paramagoj));
  }
  
  public void a(agqn paramagqn)
  {
    a(23, new afby(paramagqn));
    a(36, new afbj(paramagqn));
  }
  
  public void a(agqq paramagqq)
  {
    a(42, new awul(paramagqq));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new afbt(paramTroopChatPie));
    a(55, new afbu(paramTroopChatPie));
    a(33, new atlc(paramTroopChatPie));
    a(34, new aeym(paramTroopChatPie));
    a(35, new aezj(paramTroopChatPie));
    a(48, new afbw(paramTroopChatPie));
    a(50, new antn(paramTroopChatPie));
    a(51, new afbx(paramTroopChatPie));
    a(52, new aezp(paramTroopChatPie));
    a(58, new afbv(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afag
 * JD-Core Version:    0.7.0.1
 */