import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class acle
{
  public int a;
  public aclh a;
  public String a;
  public ArrayList<aclf> a;
  public boolean a;
  public aclh b;
  public String b;
  
  public acle()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static acle a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    acle localacle = new acle();
    localacle.jdField_a_of_type_Boolean = paramBoolean;
    localacle.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localacle.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localacle.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localacle.jdField_a_of_type_Aclh = aclh.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localacle.jdField_b_of_type_Aclh = aclh.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localacle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        aclf localaclf = new aclf();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localaclf.jdField_a_of_type_Aclh = aclh.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localaclf.jdField_b_of_type_Aclh = aclh.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localacle.jdField_a_of_type_JavaUtilArrayList.add(localaclf);
        i += 1;
      }
    }
    return localacle;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Aclh != null) {
        return this.jdField_a_of_type_Aclh.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Aclh != null) {
      return this.jdField_b_of_type_Aclh.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public aclg a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Aclh != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aclh.jdField_a_of_type_Aclj != null)
        {
          localObject1 = new aclg();
          ((aclg)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aclh.jdField_a_of_type_Aclj.jdField_a_of_type_JavaLangString;
          ((aclg)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Aclh.jdField_a_of_type_Aclj.jdField_e_of_type_Long;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Aclh == null);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj == null);
    Object localObject1 = new aclg();
    ((aclg)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_a_of_type_JavaLangString;
    ((aclg)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_e_of_type_Long;
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Aclh != null) && (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj != null)) {
      return this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Aclh != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.d))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_e_of_type_JavaLangString)) {
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
      if (this.jdField_a_of_type_Aclh != null) {
        return this.jdField_a_of_type_Aclh.a();
      }
    }
    else if (this.jdField_b_of_type_Aclh != null) {
      return this.jdField_b_of_type_Aclh.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Aclh != null) && (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj != null)) {
      return this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.d;
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_Aclh != null) {
      return this.jdField_b_of_type_Aclh.a();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Aclh != null) && (this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj != null)) {
      return this.jdField_b_of_type_Aclh.jdField_a_of_type_Aclj.jdField_e_of_type_JavaLangString;
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Aclh).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Aclh).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acle
 * JD-Core Version:    0.7.0.1
 */