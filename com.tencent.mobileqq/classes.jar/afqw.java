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

public class afqw
{
  private SparseArrayCompat<SparseArrayCompat<afrc>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(17);
  private List<afrp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<afrb> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private List<afqc> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<afrq> c = new ArrayList();
  private List<afrr> d = new ArrayList();
  private List<afrs> e = new ArrayList();
  
  public <T extends afrb> T a(int paramInt)
  {
    return (afrb)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((afqc)localIterator.next()).a(paramInt);
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
        ((afrc)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((afrp)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(int paramInt, afrb paramafrb)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramafrb);
  }
  
  void a(int paramInt, afrc paramafrc)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramafrc);
    int[] arrayOfInt = paramafrc.a();
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
      localSparseArrayCompat1.put(paramInt, paramafrc);
      i += 1;
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((afqc)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((afrs)localIterator.next()).a(paramInt, paramTroopChatPie, paramList);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((afrr)localIterator.next()).a(paramInt, paramVarArgs);
    }
  }
  
  public void a(afii paramafii)
  {
    a(23, new aftj(paramafii));
  }
  
  public void a(afim paramafim)
  {
    a(50, new apfm(paramafim));
  }
  
  public void a(afiw paramafiw)
  {
    a(16, new aull(paramafiw));
    a(30, new afsi(paramafiw));
    a(32, new avcj(paramafiw));
    a(35, new afpl(paramafiw));
    a(42, new azcz(paramafiw));
    a(45, new bamd(paramafiw));
    a(50, new apfm(paramafiw));
    a(60, new bdcc(paramafiw));
    a(61, new afsh(paramafiw));
    a(52, new aphy(paramafiw));
  }
  
  public void a(afqc paramafqc)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramafqc);
  }
  
  public void a(afrp paramafrp)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramafrp);
  }
  
  public void a(afrq paramafrq)
  {
    this.c.add(paramafrq);
  }
  
  public void a(afrr paramafrr)
  {
    this.d.add(paramafrr);
  }
  
  public void a(afrs paramafrs)
  {
    this.e.add(paramafrs);
  }
  
  public void a(ahfp paramahfp)
  {
    a(56, new afqu(paramahfp));
  }
  
  public void a(ahhp paramahhp)
  {
    a(16, new aull(paramahhp));
    a(45, new bamd(paramahhp));
    a(77, new armh(paramahhp));
    a(52, new aphy(paramahhp));
  }
  
  public void a(ahik paramahik)
  {
    a(42, new azcz(paramahik));
  }
  
  public void a(ahkw paramahkw)
  {
    a(23, new aftj(paramahkw));
    a(36, new afsk(paramahkw));
  }
  
  public void a(ahkz paramahkz)
  {
    a(42, new azcz(paramahkz));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(1, new afrl(paramBaseChatPie));
    a(2, new atvl(paramBaseChatPie));
    a(3, new afqz(paramBaseChatPie));
    a(4, new akya(paramBaseChatPie));
    a(5, new afto(paramBaseChatPie));
    a(6, new audg(paramBaseChatPie));
    a(7, new afrt(this, paramBaseChatPie));
    a(8, new afpu(this, paramBaseChatPie));
    a(9, new aztb(paramBaseChatPie));
    a(10, new afrd(paramBaseChatPie));
    a(11, new afri(paramBaseChatPie));
    a(12, new afpx(paramBaseChatPie));
    a(13, new atpn(paramBaseChatPie));
    a(57, new atoe(paramBaseChatPie));
    a(37, new atmm(paramBaseChatPie));
    a(14, new afsu(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new afrz(paramBaseChatPie));
    a(18, new afqx());
    a(19, new aqmz(paramBaseChatPie));
    a(20, new afqi());
    a(24, new afqj(paramBaseChatPie));
    a(22, new aftq());
    a(21, new afoj(paramBaseChatPie));
    a(25, new afqh(paramBaseChatPie));
    a(26, new afrn(paramBaseChatPie));
    a(27, new afsd(paramBaseChatPie));
    a(29, new afss(paramBaseChatPie));
    a(39, new afqy(paramBaseChatPie));
    a(44, new afsj(paramBaseChatPie));
    a(38, new afrx(paramBaseChatPie));
    a(40, new afsl(paramBaseChatPie));
    a(41, new afst(paramBaseChatPie));
    a(43, new afsw(paramBaseChatPie));
    a(46, new afpd(paramBaseChatPie));
    a(47, new afrf(paramBaseChatPie));
    a(49, new agwf(paramBaseChatPie));
    a(53, new aftn(paramBaseChatPie));
    a(54, new afoi(paramBaseChatPie));
    a(59, new ahrg(paramBaseChatPie));
    a(83, new afqg(paramBaseChatPie));
    a(62, new afop(paramBaseChatPie));
    a(65, new afpo(paramBaseChatPie));
    a(66, new afpb(paramBaseChatPie));
    a(67, new afrw(this, paramBaseChatPie));
    a(68, new afra(paramBaseChatPie));
    a(69, new afqd(paramBaseChatPie));
    a(70, new afom(this, paramBaseChatPie));
    a(72, new afpc(paramBaseChatPie));
    a(80, new aftp(paramBaseChatPie));
    a(74, new bdgh(this, paramBaseChatPie));
    a(78, new afqt(this, paramBaseChatPie));
    a(82, new afry(paramBaseChatPie));
    a(84, new AioPaiYiPaiHelper(this, paramBaseChatPie));
    a(87, new afsb(paramBaseChatPie));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new TroopAddFriendTipsHelper(paramTroopChatPie));
    a(55, new aftb(paramTroopChatPie));
    a(33, new avcl(paramTroopChatPie));
    a(34, new afoh(paramTroopChatPie));
    a(35, new afpl(paramTroopChatPie));
    a(48, new aftf(paramTroopChatPie));
    a(50, new apfm(paramTroopChatPie));
    a(51, new aftg(paramTroopChatPie));
    a(52, new afsn(paramTroopChatPie));
    a(58, new afte(paramTroopChatPie));
    a(63, new afrv(paramTroopChatPie));
    a(71, new afpr(paramTroopChatPie));
    a(73, new afqv(paramTroopChatPie));
    a(75, new ahql(paramTroopChatPie));
    a(76, new aftc(paramTroopChatPie));
    a(79, new afth(paramTroopChatPie));
    a(81, new bkjp(this, paramTroopChatPie));
    a(85, new afqa(paramTroopChatPie));
    a(86, new afsg(this, paramTroopChatPie));
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((afrq)localIterator.next()).b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqw
 * JD-Core Version:    0.7.0.1
 */