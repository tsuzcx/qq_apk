import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class aghx
{
  public int a;
  public agia a;
  public String a;
  public ArrayList<aghy> a;
  public boolean a;
  public agia b;
  public String b;
  
  public aghx()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aghx a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    aghx localaghx = new aghx();
    localaghx.jdField_a_of_type_Boolean = paramBoolean;
    localaghx.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localaghx.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localaghx.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localaghx.jdField_a_of_type_Agia = agia.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localaghx.jdField_b_of_type_Agia = agia.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localaghx.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        aghy localaghy = new aghy();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localaghy.jdField_a_of_type_Agia = agia.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localaghy.jdField_b_of_type_Agia = agia.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localaghx.jdField_a_of_type_JavaUtilArrayList.add(localaghy);
        i += 1;
      }
    }
    return localaghx;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Agia != null) {
        return this.jdField_a_of_type_Agia.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Agia != null) {
      return this.jdField_b_of_type_Agia.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public aghz a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Agia != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Agia.jdField_a_of_type_Agic != null)
        {
          localObject1 = new aghz();
          ((aghz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Agia.jdField_a_of_type_Agic.jdField_a_of_type_JavaLangString;
          ((aghz)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Agia.jdField_a_of_type_Agic.jdField_e_of_type_Long;
          ((aghz)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Agia.jdField_a_of_type_Agic.jdField_b_of_type_JavaLangString;
          ((aghz)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Agia.jdField_a_of_type_Agic.jdField_b_of_type_Int;
        }
      }
    }
    for (;;)
    {
      long l1 = a();
      long l2 = b();
      if ((l1 == 21L) && (l2 == 1L)) {
        ((aghz)localObject1).jdField_a_of_type_Int = 1;
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jdField_b_of_type_Agia != null)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)
        {
          localObject1 = new aghz();
          ((aghz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_a_of_type_JavaLangString;
          ((aghz)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_e_of_type_Long;
          ((aghz)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_b_of_type_JavaLangString;
          ((aghz)localObject1).jdField_a_of_type_Int = this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_b_of_type_Int;
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Agia != null) && (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)) {
      return this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.c;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Agia != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_e_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.f)) {
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
      if (this.jdField_a_of_type_Agia != null) {
        return this.jdField_a_of_type_Agia.a();
      }
    }
    else if (this.jdField_b_of_type_Agia != null) {
      return this.jdField_b_of_type_Agia.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Agia != null) && (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)) {
      return this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Agia != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.c)) {
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
      if (this.jdField_a_of_type_Agia != null) {
        return this.jdField_a_of_type_Agia.b();
      }
    }
    else if (this.jdField_b_of_type_Agia != null) {
      return this.jdField_b_of_type_Agia.b();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Agia != null) && (this.jdField_b_of_type_Agia.jdField_a_of_type_Agic != null)) {
      return this.jdField_b_of_type_Agia.jdField_a_of_type_Agic.f;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_b_of_type_Agia != null) {
      return this.jdField_b_of_type_Agia.a();
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Agia).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Agia).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghx
 * JD-Core Version:    0.7.0.1
 */