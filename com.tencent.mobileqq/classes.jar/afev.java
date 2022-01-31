import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afev
{
  private SparseArrayCompat<SparseArrayCompat<affa>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(15);
  private List<affn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<afez> b = new SparseArrayCompat();
  
  public afev(BaseChatPie paramBaseChatPie)
  {
    a(1, new affj(paramBaseChatPie));
    a(2, new asjo(paramBaseChatPie));
    a(3, new afey(paramBaseChatPie));
    a(4, new ajxr(paramBaseChatPie));
    a(5, new afgs(paramBaseChatPie));
    a(6, new asqz(paramBaseChatPie));
    a(7, new affo(paramBaseChatPie));
    a(8, new afeb(this, paramBaseChatPie));
    a(9, new axjr(paramBaseChatPie));
    a(10, new affb(paramBaseChatPie));
    a(11, new affg(paramBaseChatPie));
    a(12, new afem(paramBaseChatPie));
    a(13, new asdt(paramBaseChatPie));
    a(57, new ascj(paramBaseChatPie));
    a(37, new asag(paramBaseChatPie));
    a(14, new afgd(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new affr(paramBaseChatPie));
    a(18, new afew());
    a(19, new apap(paramBaseChatPie));
    a(20, new afep());
    a(24, new afeq(paramBaseChatPie));
    a(22, new afgt());
    a(21, new afdd(paramBaseChatPie));
    a(25, new afeo(paramBaseChatPie));
    a(26, new affl(paramBaseChatPie));
    a(27, new afft(paramBaseChatPie));
    a(29, new afgb(paramBaseChatPie));
    a(39, new afex(paramBaseChatPie));
    a(44, new affx(paramBaseChatPie));
    a(38, new affq(paramBaseChatPie));
    a(40, new affz(paramBaseChatPie));
    a(41, new afgc(paramBaseChatPie));
    a(43, new afgf(paramBaseChatPie));
    a(46, new afdq(paramBaseChatPie));
    a(47, new affd(paramBaseChatPie));
    a(49, new afcr(paramBaseChatPie));
    a(53, new afgr(paramBaseChatPie));
    a(54, new afdc(paramBaseChatPie));
  }
  
  private void a(int paramInt, afez paramafez)
  {
    this.b.put(paramInt, paramafez);
  }
  
  private void a(int paramInt, affa paramaffa)
  {
    this.b.put(paramInt, paramaffa);
    int[] arrayOfInt = paramaffa.a();
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
      localSparseArrayCompat1.put(paramInt, paramaffa);
      i += 1;
    }
  }
  
  public <T extends afez> T a(int paramInt)
  {
    return (afez)this.b.get(paramInt);
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
        ((affa)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((affn)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(affn paramaffn)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaffn);
  }
  
  public void a(agnj paramagnj)
  {
    a(23, new afgn(paramagnj));
  }
  
  public void a(agpi paramagpi)
  {
    a(50, new anxw(paramagpi));
  }
  
  public void a(agps paramagps)
  {
    a(16, new asyq(paramagps));
    a(30, new affw(paramagps));
    a(32, new atpj(paramagps));
    a(35, new afdy(paramagps));
    a(42, new awyu(paramagps));
    a(45, new aybg(paramagps));
    a(50, new anxw(paramagps));
  }
  
  public void a(agqk paramagqk)
  {
    a(56, new afeu(paramagqk));
  }
  
  public void a(agse paramagse)
  {
    a(16, new asyq(paramagse));
    a(45, new aybg(paramagse));
  }
  
  public void a(agsy paramagsy)
  {
    a(42, new awyu(paramagsy));
  }
  
  public void a(agvc paramagvc)
  {
    a(23, new afgn(paramagvc));
    a(36, new affy(paramagvc));
  }
  
  public void a(agvf paramagvf)
  {
    a(42, new awyu(paramagvf));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new afgi(paramTroopChatPie));
    a(55, new afgj(paramTroopChatPie));
    a(33, new atpl(paramTroopChatPie));
    a(34, new afdb(paramTroopChatPie));
    a(35, new afdy(paramTroopChatPie));
    a(48, new afgl(paramTroopChatPie));
    a(50, new anxw(paramTroopChatPie));
    a(51, new afgm(paramTroopChatPie));
    a(52, new afee(paramTroopChatPie));
    a(58, new afgk(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afev
 * JD-Core Version:    0.7.0.1
 */