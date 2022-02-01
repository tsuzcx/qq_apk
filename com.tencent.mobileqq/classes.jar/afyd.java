import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class afyd
{
  public int a;
  public afyg a;
  public String a;
  public ArrayList<afye> a;
  public boolean a;
  public afyg b;
  public String b;
  
  public afyd()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static afyd a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    afyd localafyd = new afyd();
    localafyd.jdField_a_of_type_Boolean = paramBoolean;
    localafyd.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localafyd.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localafyd.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localafyd.jdField_a_of_type_Afyg = afyg.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localafyd.jdField_b_of_type_Afyg = afyg.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localafyd.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        afye localafye = new afye();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localafye.jdField_a_of_type_Afyg = afyg.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localafye.jdField_b_of_type_Afyg = afyg.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localafyd.jdField_a_of_type_JavaUtilArrayList.add(localafye);
        i += 1;
      }
    }
    return localafyd;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Afyg != null) {
        return this.jdField_a_of_type_Afyg.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Afyg != null) {
      return this.jdField_b_of_type_Afyg.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public afyf a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Afyg != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Afyg.jdField_a_of_type_Afyi != null)
        {
          localObject1 = new afyf();
          ((afyf)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Afyg.jdField_a_of_type_Afyi.jdField_a_of_type_JavaLangString;
          ((afyf)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Afyg.jdField_a_of_type_Afyi.jdField_e_of_type_Long;
          ((afyf)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Afyg.jdField_a_of_type_Afyi.jdField_b_of_type_JavaLangString;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Afyg == null);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi == null);
    Object localObject1 = new afyf();
    ((afyf)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_a_of_type_JavaLangString;
    ((afyf)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_e_of_type_Long;
    ((afyf)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_b_of_type_JavaLangString;
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Afyg != null) && (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi != null)) {
      return this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.c;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Afyg != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_e_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.f)) {
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
      if (this.jdField_a_of_type_Afyg != null) {
        return this.jdField_a_of_type_Afyg.a();
      }
    }
    else if (this.jdField_b_of_type_Afyg != null) {
      return this.jdField_b_of_type_Afyg.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Afyg != null) && (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi != null)) {
      return this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_Afyg != null) {
      return this.jdField_b_of_type_Afyg.a();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Afyg != null) && (this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi != null)) {
      return this.jdField_b_of_type_Afyg.jdField_a_of_type_Afyi.f;
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Afyg).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Afyg).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyd
 * JD-Core Version:    0.7.0.1
 */