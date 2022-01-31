import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class acvt
{
  public int a;
  public acvw a;
  public String a;
  public ArrayList<acvu> a;
  public boolean a;
  public acvw b;
  public String b;
  
  public acvt()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static acvt a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    acvt localacvt = new acvt();
    localacvt.jdField_a_of_type_Boolean = paramBoolean;
    localacvt.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localacvt.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localacvt.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localacvt.jdField_a_of_type_Acvw = acvw.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localacvt.jdField_b_of_type_Acvw = acvw.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localacvt.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        acvu localacvu = new acvu();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localacvu.jdField_a_of_type_Acvw = acvw.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localacvu.jdField_b_of_type_Acvw = acvw.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localacvt.jdField_a_of_type_JavaUtilArrayList.add(localacvu);
        i += 1;
      }
    }
    return localacvt;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Acvw != null) {
        return this.jdField_a_of_type_Acvw.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Acvw != null) {
      return this.jdField_b_of_type_Acvw.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public acvv a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Acvw != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Acvw.jdField_a_of_type_Acvy != null)
        {
          localObject1 = new acvv();
          ((acvv)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Acvw.jdField_a_of_type_Acvy.jdField_a_of_type_JavaLangString;
          ((acvv)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Acvw.jdField_a_of_type_Acvy.jdField_e_of_type_Long;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Acvw == null);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy == null);
    Object localObject1 = new acvv();
    ((acvv)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_a_of_type_JavaLangString;
    ((acvv)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_e_of_type_Long;
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Acvw != null) && (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null)) {
      return this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Acvw != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.d))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_e_of_type_JavaLangString)) {
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
      if (this.jdField_a_of_type_Acvw != null) {
        return this.jdField_a_of_type_Acvw.a();
      }
    }
    else if (this.jdField_b_of_type_Acvw != null) {
      return this.jdField_b_of_type_Acvw.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Acvw != null) && (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null)) {
      return this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.d;
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_Acvw != null) {
      return this.jdField_b_of_type_Acvw.a();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Acvw != null) && (this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null)) {
      return this.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_e_of_type_JavaLangString;
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Acvw).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Acvw).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvt
 * JD-Core Version:    0.7.0.1
 */