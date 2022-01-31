import com.tencent.mobileqq.activity.photo.TroopClipPic;
import java.util.List;
import java.util.Set;

public class aiiy
{
  public static int a;
  public static String a;
  public long a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "-5";
    jdField_a_of_type_Int = -5;
  }
  
  public aiiy()
  {
    this.jdField_d_of_type_Int = 0;
  }
  
  public static final aiiy a(TroopClipPic paramTroopClipPic, Set<String> paramSet)
  {
    aiiy localaiiy = new aiiy();
    localaiiy.jdField_c_of_type_JavaLangString = paramTroopClipPic.id;
    localaiiy.jdField_d_of_type_JavaLangString = paramTroopClipPic.clipInfo;
    localaiiy.jdField_d_of_type_Int = paramTroopClipPic.type;
    localaiiy.jdField_b_of_type_Int = 1;
    if (paramSet != null) {
      localaiiy.jdField_c_of_type_Boolean = paramSet.contains(paramTroopClipPic.id);
    }
    return localaiiy;
  }
  
  public static final boolean a(List<aiiy> paramList1, List<aiiy> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList1 == paramList2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramList1 == null);
        bool1 = bool2;
      } while (paramList2 == null);
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label89;
      }
      bool1 = bool2;
      if (!((aiiy)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label89:
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aiiy))) {}
    do
    {
      return false;
      paramObject = (aiiy)paramObject;
    } while ((!bdal.a(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (!bdal.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean) || (this.jdField_c_of_type_Boolean != paramObject.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean != paramObject.jdField_d_of_type_Boolean) || (!bdal.a(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) || (this.jdField_d_of_type_Int != paramObject.jdField_d_of_type_Int) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvatarInfo=[").append("seq").append("=").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" ").append("fromType").append("=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" ").append("type").append("=").append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" ").append("isUploading").append("=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" ").append("isVerifying").append("=").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" ").append("clipInfo").append("=").append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" ").append("ts").append("=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" ").append("localFile").append("=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiy
 * JD-Core Version:    0.7.0.1
 */