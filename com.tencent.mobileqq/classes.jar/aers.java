import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class aers
{
  public int a;
  public aerv a;
  public String a;
  public ArrayList<aert> a;
  public boolean a;
  public aerv b;
  public String b;
  
  public aers()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aers a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    aers localaers = new aers();
    localaers.jdField_a_of_type_Boolean = paramBoolean;
    localaers.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localaers.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localaers.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localaers.jdField_a_of_type_Aerv = aerv.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localaers.jdField_b_of_type_Aerv = aerv.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localaers.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        aert localaert = new aert();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localaert.jdField_a_of_type_Aerv = aerv.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localaert.jdField_b_of_type_Aerv = aerv.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localaers.jdField_a_of_type_JavaUtilArrayList.add(localaert);
        i += 1;
      }
    }
    return localaers;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Aerv != null) {
        return this.jdField_a_of_type_Aerv.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Aerv != null) {
      return this.jdField_b_of_type_Aerv.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public aeru a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Aerv != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aerv.jdField_a_of_type_Aerx != null)
        {
          localObject1 = new aeru();
          ((aeru)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aerv.jdField_a_of_type_Aerx.jdField_a_of_type_JavaLangString;
          ((aeru)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Aerv.jdField_a_of_type_Aerx.jdField_e_of_type_Long;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Aerv == null);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx == null);
    Object localObject1 = new aeru();
    ((aeru)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_a_of_type_JavaLangString;
    ((aeru)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_e_of_type_Long;
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Aerv != null) && (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx != null)) {
      return this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Aerv != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.d))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_e_of_type_JavaLangString)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Aerv != null) {
        return this.jdField_a_of_type_Aerv.a();
      }
    }
    else if (this.jdField_b_of_type_Aerv != null) {
      return this.jdField_b_of_type_Aerv.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Aerv != null) && (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx != null)) {
      return this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.d;
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_Aerv != null) {
      return this.jdField_b_of_type_Aerv.a();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Aerv != null) && (this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx != null)) {
      return this.jdField_b_of_type_Aerv.jdField_a_of_type_Aerx.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationChainChangePushInfo{");
    localStringBuilder.append("selfUin:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("friendUin:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("changeType:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Aerv).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Aerv).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aers
 * JD-Core Version:    0.7.0.1
 */