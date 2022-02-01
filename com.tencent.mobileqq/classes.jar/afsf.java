import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfos;

public class afsf
{
  public int a;
  public afsi a;
  public String a;
  public ArrayList<afsg> a;
  public boolean a;
  public afsi b;
  public String b;
  
  public afsf()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static afsf a(submsgtype0xc7.RelationalChainChange paramRelationalChainChange, boolean paramBoolean)
  {
    afsf localafsf = new afsf();
    localafsf.jdField_a_of_type_Boolean = paramBoolean;
    localafsf.jdField_a_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_src_uin.get());
    localafsf.jdField_b_of_type_JavaLangString = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
    localafsf.jdField_a_of_type_Int = paramRelationalChainChange.uint32_change_type.get();
    if (paramRelationalChainChange.msg_relational_chain_info_old.has()) {
      localafsf.jdField_a_of_type_Afsi = afsi.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_old.get());
    }
    if (paramRelationalChainChange.msg_relational_chain_info_new.has()) {
      localafsf.jdField_b_of_type_Afsi = afsi.a((submsgtype0xc7.RelationalChainInfo)paramRelationalChainChange.msg_relational_chain_info_new.get());
    }
    if ((paramRelationalChainChange.rpt_relational_chain_infos.has()) && (paramRelationalChainChange.rpt_relational_chain_infos.size() > 0))
    {
      localafsf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      int i = 0;
      while (i < paramRelationalChainChange.rpt_relational_chain_infos.size())
      {
        afsg localafsg = new afsg();
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.has())) {
          localafsg.jdField_a_of_type_Afsi = afsi.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_old.get());
        }
        if ((paramRelationalChainChange.rpt_relational_chain_infos.get(i) != null) && (((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.has())) {
          localafsg.jdField_b_of_type_Afsi = afsi.a((submsgtype0xc7.RelationalChainInfo)((submsgtype0xc7.RelationalChainInfos)paramRelationalChainChange.rpt_relational_chain_infos.get(i)).msg_relational_chain_info_new.get());
        }
        localafsf.jdField_a_of_type_JavaUtilArrayList.add(localafsg);
        i += 1;
      }
    }
    return localafsf;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_Afsi != null) {
        return this.jdField_a_of_type_Afsi.jdField_a_of_type_Int;
      }
    }
    else if (this.jdField_b_of_type_Afsi != null) {
      return this.jdField_b_of_type_Afsi.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public afsh a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Afsi != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Afsi.jdField_a_of_type_Afsk != null)
        {
          localObject1 = new afsh();
          ((afsh)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Afsi.jdField_a_of_type_Afsk.jdField_a_of_type_JavaLangString;
          ((afsh)localObject1).jdField_a_of_type_Long = this.jdField_a_of_type_Afsi.jdField_a_of_type_Afsk.jdField_e_of_type_Long;
          ((afsh)localObject1).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Afsi.jdField_a_of_type_Afsk.jdField_b_of_type_JavaLangString;
          ((afsh)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Afsi.jdField_a_of_type_Afsk.jdField_b_of_type_Int;
        }
      }
    }
    for (;;)
    {
      long l1 = a();
      long l2 = b();
      if ((l1 == 21L) && (localObject1 != null) && (l2 == 1L)) {
        ((afsh)localObject1).jdField_a_of_type_Int = 1;
      }
      return localObject1;
      localObject1 = localObject2;
      if (this.jdField_b_of_type_Afsi != null)
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)
        {
          localObject1 = new afsh();
          ((afsh)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_a_of_type_JavaLangString;
          ((afsh)localObject1).jdField_a_of_type_Long = this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_e_of_type_Long;
          ((afsh)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_b_of_type_JavaLangString;
          ((afsh)localObject1).jdField_a_of_type_Int = this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_b_of_type_Int;
        }
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Afsi != null) && (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)) {
      return this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c;
    }
    return null;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Afsi != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_b_of_type_Boolean)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_e_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.f)) {
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
      if (this.jdField_a_of_type_Afsi != null) {
        return this.jdField_a_of_type_Afsi.a();
      }
    }
    else if (this.jdField_b_of_type_Afsi != null) {
      return this.jdField_b_of_type_Afsi.a();
    }
    return 0;
  }
  
  public String b()
  {
    if ((this.jdField_b_of_type_Afsi != null) && (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)) {
      return this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_e_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_Afsi != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c)) {
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
      if (this.jdField_a_of_type_Afsi != null) {
        return this.jdField_a_of_type_Afsi.b();
      }
    }
    else if (this.jdField_b_of_type_Afsi != null) {
      return this.jdField_b_of_type_Afsi.b();
    }
    return 0;
  }
  
  public String c()
  {
    if ((this.jdField_b_of_type_Afsi != null) && (this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)) {
      return this.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.f;
    }
    return null;
  }
  
  public int d()
  {
    if (this.jdField_b_of_type_Afsi != null) {
      return this.jdField_b_of_type_Afsi.a();
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
    localStringBuilder.append("old:").append(this.jdField_a_of_type_Afsi).append(", ");
    localStringBuilder.append("now:").append(this.jdField_b_of_type_Afsi).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsf
 * JD-Core Version:    0.7.0.1
 */