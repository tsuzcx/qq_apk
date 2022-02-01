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

public class aguw
{
  private SparseArrayCompat<SparseArrayCompat<agvc>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat(17);
  private List<agvp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private SparseArrayCompat<agvb> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private List<ague> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public <T extends agvb> T a(int paramInt)
  {
    return (agvb)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((ague)localIterator.next()).a(paramInt);
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
        ((agvc)localSparseArrayCompat.valueAt(i)).a(paramInt);
        i += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((agvp)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(int paramInt, agvb paramagvb)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramagvb);
  }
  
  void a(int paramInt, agvc paramagvc)
  {
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, paramagvc);
    int[] arrayOfInt = paramagvc.a();
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
      localSparseArrayCompat1.put(paramInt, paramagvc);
      i += 1;
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ague)localIterator.next()).a(paramInt, paramDialog);
    }
  }
  
  public void a(ague paramague)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramague);
  }
  
  public void a(agvp paramagvp)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramagvp);
  }
  
  public void a(aihd paramaihd)
  {
    a(23, new agwy(paramaihd));
  }
  
  public void a(aijc paramaijc)
  {
    a(50, new aqmb(paramaijc));
  }
  
  public void a(aijm paramaijm)
  {
    a(16, new avyl(paramaijm));
    a(30, new agwb(paramaijm));
    a(32, new awpd(paramaijm));
    a(35, new agtr(paramaijm));
    a(42, new bamz(paramaijm));
    a(45, new bbsi(paramaijm));
    a(50, new aqmb(paramaijm));
    a(60, new bejg(paramaijm));
    a(61, new agwa(paramaijm));
    a(52, new aqop(paramaijm));
  }
  
  public void a(aikg paramaikg)
  {
    a(56, new aguu(paramaikg));
  }
  
  public void a(aimd paramaimd)
  {
    a(16, new avyl(paramaimd));
    a(45, new bbsi(paramaimd));
    a(77, new ataa(paramaimd));
    a(52, new aqop(paramaimd));
  }
  
  public void a(aimx paramaimx)
  {
    a(42, new bamz(paramaimx));
  }
  
  public void a(aipj paramaipj)
  {
    a(23, new agwy(paramaipj));
    a(36, new agwd(paramaipj));
  }
  
  public void a(aipm paramaipm)
  {
    a(42, new bamz(paramaipm));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(1, new agvl(paramBaseChatPie));
    a(2, new avif(paramBaseChatPie));
    a(3, new aguz(paramBaseChatPie));
    a(4, new ambz(paramBaseChatPie));
    a(5, new agxd(paramBaseChatPie));
    a(6, new avqe(paramBaseChatPie));
    a(7, new agvq(this, paramBaseChatPie));
    a(8, new agtz(this, paramBaseChatPie));
    a(9, new bayp(paramBaseChatPie));
    a(10, new agvd(paramBaseChatPie));
    a(11, new agvi(paramBaseChatPie));
    a(12, new aguc(paramBaseChatPie));
    a(13, new avcj(paramBaseChatPie));
    a(57, new avba(paramBaseChatPie));
    a(37, new auzi(paramBaseChatPie));
    a(14, new agwn(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new agvv(paramBaseChatPie));
    a(18, new agux());
    a(19, new artb(paramBaseChatPie));
    a(20, new aguj());
    a(24, new aguk(paramBaseChatPie));
    a(22, new agxe());
    a(21, new agsp(paramBaseChatPie));
    a(25, new agui(paramBaseChatPie));
    a(26, new agvn(paramBaseChatPie));
    a(27, new agvx(paramBaseChatPie));
    a(29, new agwl(paramBaseChatPie));
    a(39, new aguy(paramBaseChatPie));
    a(44, new agwc(paramBaseChatPie));
    a(38, new agvu(paramBaseChatPie));
    a(40, new agwe(paramBaseChatPie));
    a(41, new agwm(paramBaseChatPie));
    a(43, new agwp(paramBaseChatPie));
    a(46, new agtj(paramBaseChatPie));
    a(47, new agvf(paramBaseChatPie));
    a(49, new ahzr(paramBaseChatPie));
    a(53, new agxc(paramBaseChatPie));
    a(54, new agso(paramBaseChatPie));
    a(59, new aiwv(paramBaseChatPie));
    a(62, new agsv(paramBaseChatPie));
    a(65, new agtu(paramBaseChatPie));
    a(66, new agth(paramBaseChatPie));
    a(67, new agvt(this, paramBaseChatPie));
    a(68, new agva(paramBaseChatPie));
    a(69, new aguf(paramBaseChatPie));
    a(70, new agss(this, paramBaseChatPie));
    a(72, new agti(paramBaseChatPie));
    a(74, new bemp(this, paramBaseChatPie));
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new TroopAddFriendTipsHelper(paramTroopChatPie));
    a(55, new agws(paramTroopChatPie));
    a(33, new awpf(paramTroopChatPie));
    a(34, new agsn(paramTroopChatPie));
    a(35, new agtr(paramTroopChatPie));
    a(48, new agww(paramTroopChatPie));
    a(50, new aqmb(paramTroopChatPie));
    a(51, new agwx(paramTroopChatPie));
    a(52, new agwg(paramTroopChatPie));
    a(58, new agwv(paramTroopChatPie));
    a(63, new agvs(paramTroopChatPie));
    a(71, new agtx(paramTroopChatPie));
    a(73, new aguv(paramTroopChatPie));
    a(75, new aiwa(paramTroopChatPie));
    a(76, new agwt(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aguw
 * JD-Core Version:    0.7.0.1
 */