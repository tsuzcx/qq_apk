import android.app.Dialog;
import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agih
{
  private SparseArrayCompat<SparseArrayCompat<agin>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(18);
  private List<agja> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<agim> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private List<aghh> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<agjb> c = new ArrayList();
  private List<agjc> d = new ArrayList();
  private List<agjd> e = new ArrayList();
  
  public <T extends agim> T a(int paramInt)
  {
    return (agim)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((aghh)localIterator.next()).a(paramInt);
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
        ((agin)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((agjb)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agja)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(int paramInt, agim paramagim)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramagim);
  }
  
  void a(int paramInt, agin paramagin)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramagin);
    int[] arrayOfInt = paramagin.a();
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
      localSparseArrayCompat1.put(paramInt, paramagin);
      i += 1;
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aghh)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((agjd)localIterator.next()).a(paramInt, paramTroopChatPie, paramList);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((agjc)localIterator.next()).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(afzn paramafzn)
  {
    a(23, new agld(paramafzn));
  }
  
  public void a(afzr paramafzr)
  {
    a(50, new aqiq(paramafzr));
  }
  
  public void a(agab paramagab)
  {
    a(16, new avrg(paramagab));
    a(30, new agjw(paramagab));
    a(32, new awim(paramagab));
    a(35, new aggp(paramagab));
    a(42, new bain(paramagab));
    a(45, new bbss(paramagab));
    a(50, new aqiq(paramagab));
    a(60, new bejc(paramagab));
    a(61, new agjv(paramagab));
    a(52, new aqlc(paramagab));
    a(new nab(paramagab));
  }
  
  public void a(aghh paramaghh)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramaghh);
  }
  
  public void a(agja paramagja)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramagja);
  }
  
  public void a(agjb paramagjb)
  {
    this.c.add(paramagjb);
  }
  
  public void a(agjc paramagjc)
  {
    this.d.add(paramagjc);
  }
  
  public void a(agjd paramagjd)
  {
    this.e.add(paramagjd);
  }
  
  public void a(aiah paramaiah)
  {
    a(56, new agie(paramaiah));
  }
  
  public void a(aici paramaici)
  {
    a(16, new avrg(paramaici));
    a(45, new bbss(paramaici));
    a(77, new asqn(paramaici));
    a(52, new aqlc(paramaici));
  }
  
  public void a(aidd paramaidd)
  {
    a(42, new bain(paramaidd));
  }
  
  public void a(aifq paramaifq)
  {
    a(23, new agld(paramaifq));
    a(36, new agjy(paramaifq));
  }
  
  public void a(aift paramaift)
  {
    a(42, new bain(paramaift));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(1, new agiw(paramBaseChatPie));
    a(2, new aval(paramBaseChatPie));
    a(3, new agik(paramBaseChatPie));
    a(4, new alvw(paramBaseChatPie));
    a(5, new agli(paramBaseChatPie));
    a(6, new avja(paramBaseChatPie));
    a(7, new agje(this, paramBaseChatPie));
    a(8, new aggy(this, paramBaseChatPie));
    a(9, new bazj(paramBaseChatPie));
    a(10, new agio(paramBaseChatPie));
    a(11, new agit(paramBaseChatPie));
    a(12, new aghb(paramBaseChatPie));
    a(13, new auui(paramBaseChatPie));
    a(57, new ausz(paramBaseChatPie));
    a(37, new aurh(paramBaseChatPie));
    a(14, new agki(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new agjk(paramBaseChatPie));
    a(18, new agii());
    a(19, new arqk(paramBaseChatPie));
    a(20, new aghs());
    a(24, new aght(paramBaseChatPie));
    a(22, new aglk());
    a(21, new agfn(paramBaseChatPie));
    a(25, new aghr(paramBaseChatPie));
    a(26, new agiy(paramBaseChatPie));
    a(27, new agjr(paramBaseChatPie));
    a(29, new agkg(paramBaseChatPie));
    a(39, new agij(paramBaseChatPie));
    a(44, new agjx(paramBaseChatPie));
    a(38, new agji(paramBaseChatPie));
    a(40, new agjz(paramBaseChatPie));
    a(41, new agkh(paramBaseChatPie));
    a(43, new agkk(paramBaseChatPie));
    a(46, new aggh(paramBaseChatPie));
    a(47, new agiq(paramBaseChatPie));
    a(49, new ahpf(paramBaseChatPie));
    a(53, new aglh(paramBaseChatPie));
    a(54, new agfm(paramBaseChatPie));
    a(59, new aimf(paramBaseChatPie));
    a(83, new aghq(paramBaseChatPie));
    a(62, new agft(paramBaseChatPie));
    a(65, new aggs(paramBaseChatPie));
    a(66, new aggf(paramBaseChatPie));
    a(67, new agjh(this, paramBaseChatPie));
    a(68, new agil(paramBaseChatPie));
    a(69, new aghi(paramBaseChatPie));
    a(70, new agfq(this, paramBaseChatPie));
    a(72, new aggg(paramBaseChatPie));
    a(80, new aglj(paramBaseChatPie));
    a(74, new benk(this, paramBaseChatPie));
    a(78, new agid(this, paramBaseChatPie));
    a(82, new agjj(paramBaseChatPie));
    a(84, new AioPaiYiPaiHelper(this, paramBaseChatPie));
    a(87, new agjp(paramBaseChatPie));
    a(88, new aghl(paramBaseChatPie));
    a(89, new aghg(paramBaseChatPie));
    a(63, new agjg(paramBaseChatPie));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new TroopAddFriendTipsHelper(paramTroopChatPie));
    a(55, new agkp(paramTroopChatPie));
    a(33, new awio(paramTroopChatPie));
    a(34, new agfl(paramTroopChatPie));
    a(35, new aggp(paramTroopChatPie));
    a(48, new agkz(paramTroopChatPie));
    a(50, new aqiq(paramTroopChatPie));
    a(51, new agla(paramTroopChatPie));
    a(52, new agkb(paramTroopChatPie));
    a(58, new agks(paramTroopChatPie));
    a(71, new aggv(paramTroopChatPie));
    a(73, new agif(paramTroopChatPie));
    a(75, new ailk(paramTroopChatPie));
    a(76, new agkq(paramTroopChatPie));
    a(79, new aglb(paramTroopChatPie));
    a(81, new blvc(this, paramTroopChatPie));
    a(85, new aghe(paramTroopChatPie));
    a(91, new agho(paramTroopChatPie));
    a(86, new agju(this, paramTroopChatPie));
    a(90, new agjm(paramTroopChatPie));
    a(92, new agkt(paramTroopChatPie));
    a(93, new agky(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agih
 * JD-Core Version:    0.7.0.1
 */