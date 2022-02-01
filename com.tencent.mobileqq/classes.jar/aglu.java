import android.app.Dialog;
import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aglu
{
  private SparseArrayCompat<SparseArrayCompat<agma>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(17);
  private List<agmn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<aglz> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private List<agld> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public <T extends aglz> T a(int paramInt)
  {
    return (aglz)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((agld)localIterator.next()).a(paramInt);
      localObject = localDialog;
      if (localDialog != null) {
        localObject = localDialog;
      }
    }
    return localObject;
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
        ((agma)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agmn)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(int paramInt, aglz paramaglz)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramaglz);
  }
  
  void a(int paramInt, agma paramagma)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramagma);
    int[] arrayOfInt = paramagma.a();
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
      localSparseArrayCompat1.put(paramInt, paramagma);
      i += 1;
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agld)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  public void a(agld paramagld)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramagld);
  }
  
  public void a(agmn paramagmn)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramagmn);
  }
  
  public void a(ahxp paramahxp)
  {
    a(23, new agnt(paramahxp));
  }
  
  public void a(ahzo paramahzo)
  {
    a(50, new apyb(paramahzo));
  }
  
  public void a(ahzy paramahzy)
  {
    a(16, new avgi(paramahzy));
    a(30, new agmz(paramahzy));
    a(32, new avwi(paramahzy));
    a(35, new agkq(paramahzy));
    a(42, new azuj(paramahzy));
    a(45, new bazp(paramahzy));
    a(50, new apyb(paramahzy));
    a(60, new bdqk(paramahzy));
    a(61, new agmy(paramahzy));
  }
  
  public void a(aias paramaias)
  {
    a(56, new aglt(paramaias));
  }
  
  public void a(aicl paramaicl)
  {
    a(16, new avgi(paramaicl));
    a(45, new bazp(paramaicl));
  }
  
  public void a(aidf paramaidf)
  {
    a(42, new azuj(paramaidf));
  }
  
  public void a(aifq paramaifq)
  {
    a(23, new agnt(paramaifq));
    a(36, new agnb(paramaifq));
  }
  
  public void a(aift paramaift)
  {
    a(42, new azuj(paramaift));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(1, new agmj(paramBaseChatPie));
    a(2, new auqf(paramBaseChatPie));
    a(3, new aglx(paramBaseChatPie));
    a(4, new alqh(paramBaseChatPie));
    a(5, new agnx(paramBaseChatPie));
    a(6, new auyd(paramBaseChatPie));
    a(7, new agmo(this, paramBaseChatPie));
    a(8, new agky(this, paramBaseChatPie));
    a(9, new bafz(paramBaseChatPie));
    a(10, new agmb(paramBaseChatPie));
    a(11, new agmg(paramBaseChatPie));
    a(12, new aglb(paramBaseChatPie));
    a(13, new aukj(paramBaseChatPie));
    a(57, new aujb(paramBaseChatPie));
    a(37, new auhk(paramBaseChatPie));
    a(14, new agnk(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new agmt(paramBaseChatPie));
    a(18, new aglv());
    a(19, new ardm(paramBaseChatPie));
    a(20, new agli());
    a(24, new aglj(paramBaseChatPie));
    a(22, new agny());
    a(21, new agjo(paramBaseChatPie));
    a(25, new aglh(paramBaseChatPie));
    a(26, new agml(paramBaseChatPie));
    a(27, new agmv(paramBaseChatPie));
    a(29, new agni(paramBaseChatPie));
    a(39, new aglw(paramBaseChatPie));
    a(44, new agna(paramBaseChatPie));
    a(38, new agms(paramBaseChatPie));
    a(40, new agnc(paramBaseChatPie));
    a(41, new agnj(paramBaseChatPie));
    a(43, new agnm(paramBaseChatPie));
    a(46, new agki(paramBaseChatPie));
    a(47, new agmd(paramBaseChatPie));
    a(49, new ahqd(paramBaseChatPie));
    a(53, new agnw(paramBaseChatPie));
    a(54, new agjn(paramBaseChatPie));
    a(59, new aimx(paramBaseChatPie));
    a(62, new agju(paramBaseChatPie));
    a(65, new agkt(paramBaseChatPie));
    a(66, new agkg(paramBaseChatPie));
    a(67, new agmr(this, paramBaseChatPie));
    a(68, new agly(paramBaseChatPie));
    a(69, new agle(paramBaseChatPie));
    a(70, new agjr(this, paramBaseChatPie));
    a(72, new agkh(paramBaseChatPie));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new TroopAddFriendTipsHelper(paramTroopChatPie));
    a(55, new agnp(paramTroopChatPie));
    a(33, new avwk(paramTroopChatPie));
    a(34, new agjm(paramTroopChatPie));
    a(35, new agkq(paramTroopChatPie));
    a(48, new agnr(paramTroopChatPie));
    a(50, new apyb(paramTroopChatPie));
    a(51, new agns(paramTroopChatPie));
    a(52, new agne(paramTroopChatPie));
    a(58, new agnq(paramTroopChatPie));
    a(63, new agmq(paramTroopChatPie));
    a(71, new agkw(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglu
 * JD-Core Version:    0.7.0.1
 */