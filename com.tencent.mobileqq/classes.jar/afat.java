import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class afat
{
  public int a;
  public afaw a;
  public String a;
  public ArrayList<afau> a;
  public boolean a;
  public afaw b;
  public String b;
  
  public afat()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static afat a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    afat localafat = new afat();
    localafat.jdField_a_of_type_Boolean = paramBoolean;
    localafat.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localafat.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localafat.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localafat.jdField_a_of_type_Afaw = afaw.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localafat.jdField_b_of_type_Afaw = afaw.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localafat.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        afau localafau = new afau();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localafau.jdField_a_of_type_Afaw = afaw.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localafau.jdField_b_of_type_Afaw = afaw.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localafat.jdField_a_of_type_JavaUtilArrayList.add(localafau);
        i += 1;
      }
    }
    return localafat;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Afaw != null) {
        return this.jdField_a_of_type_Afaw.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Afaw != null) {
      return this.jdField_b_of_type_Afaw.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public afav a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Afaw != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Afaw.jdField_a_of_type_Afay != null)
        {
          localObject1 = new afav();
          ((afav)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Afaw.jdField_a_of_type_Afay.jdField_a_of_type_JavaLangString;
          ((afav)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Afaw.jdField_a_of_type_Afay.jdField_e_of_type_Long;
          ((afav)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Afaw.jdField_a_of_type_Afay.jdField_b_of_type_JavaLangString;
          ((afav)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Afaw.jdField_a_of_type_Afay.jdField_b_of_type_Int;
        }
      }
    }
    for (;;)
    {
      long l1 = a();
      long l2 = b();
      if ((l1 == 21L) && (localObject1 != null) && (l2 == 1L)) {
        ((afav)localObject1).jdField_a_of_type_Int = 1;
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jdField_b_of_type_Afaw != null)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)
        {
          localObject1 = new afav();
          ((afav)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_a_of_type_JavaLangString;
          ((afav)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_e_of_type_Long;
          ((afav)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_b_of_type_JavaLangString;
          ((afav)localObject1).jdField_a_of_type_Int = this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_b_of_type_Int;
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Afaw != null) && (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)) {
      return this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.c;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Afaw != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_e_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.f)) {
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
      if (this.jdField_a_of_type_Afaw != null) {
        return this.jdField_a_of_type_Afaw.a();
      }
    }
    else if (this.jdField_b_of_type_Afaw != null) {
      return this.jdField_b_of_type_Afaw.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Afaw != null) && (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)) {
      return this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Afaw != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.c)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Afaw != null) {
        return this.jdField_a_of_type_Afaw.b();
      }
    }
    else if (this.jdField_b_of_type_Afaw != null) {
      return this.jdField_b_of_type_Afaw.b();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Afaw != null) && (this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay != null)) {
      return this.jdField_b_of_type_Afaw.jdField_a_of_type_Afay.f;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_b_of_type_Afaw != null) {
      return this.jdField_b_of_type_Afaw.a();
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationChainChangePushInfo{");
    localStringBuilder.append("selfUin:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("friendUin:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("changeType:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Afaw).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Afaw).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afat
 * JD-Core Version:    0.7.0.1
 */