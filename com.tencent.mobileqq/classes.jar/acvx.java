import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class acvx
{
  public int a;
  public acwa a;
  public String a;
  public ArrayList<acvy> a;
  public boolean a;
  public acwa b;
  public String b;
  
  public acvx()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static acvx a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    acvx localacvx = new acvx();
    localacvx.jdField_a_of_type_Boolean = paramBoolean;
    localacvx.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localacvx.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localacvx.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localacvx.jdField_a_of_type_Acwa = acwa.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localacvx.jdField_b_of_type_Acwa = acwa.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localacvx.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        acvy localacvy = new acvy();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localacvy.jdField_a_of_type_Acwa = acwa.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localacvy.jdField_b_of_type_Acwa = acwa.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localacvx.jdField_a_of_type_JavaUtilArrayList.add(localacvy);
        i += 1;
      }
    }
    return localacvx;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Acwa != null) {
        return this.jdField_a_of_type_Acwa.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Acwa != null) {
      return this.jdField_b_of_type_Acwa.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public acvz a()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Acwa != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Acwa.jdField_a_of_type_Acwc != null)
        {
          localObject1 = new acvz();
          ((acvz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Acwa.jdField_a_of_type_Acwc.jdField_a_of_type_JavaLangString;
          ((acvz)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Acwa.jdField_a_of_type_Acwc.jdField_e_of_type_Long;
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.jdField_b_of_type_Acwa == null);
      localObject1 = localObject2;
    } while (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc == null);
    Object localObject1 = new acvz();
    ((acvz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_a_of_type_JavaLangString;
    ((acvz)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_e_of_type_Long;
    return localObject1;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Acwa != null) && (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc != null)) {
      return this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Acwa != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.d))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_e_of_type_JavaLangString)) {
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
      if (this.jdField_a_of_type_Acwa != null) {
        return this.jdField_a_of_type_Acwa.a();
      }
    }
    else if (this.jdField_b_of_type_Acwa != null) {
      return this.jdField_b_of_type_Acwa.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Acwa != null) && (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc != null)) {
      return this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.d;
    }
    return null;
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_Acwa != null) {
      return this.jdField_b_of_type_Acwa.a();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Acwa != null) && (this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc != null)) {
      return this.jdField_b_of_type_Acwa.jdField_a_of_type_Acwc.jdField_e_of_type_JavaLangString;
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Acwa).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Acwa).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvx
 * JD-Core Version:    0.7.0.1
 */