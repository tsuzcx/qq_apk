import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo;", "", "hasGetLatestInfo", "", "questId", "", "praiseNum", "", "beenPraised", "commentNum", "showTimes", "(ZLjava/lang/String;JZJJ)V", "getBeenPraised", "()Z", "setBeenPraised", "(Z)V", "getCommentNum", "()J", "setCommentNum", "(J)V", "getHasGetLatestInfo", "setHasGetLatestInfo", "getPraiseNum", "setPraiseNum", "getQuestId", "()Ljava/lang/String;", "setQuestId", "(Ljava/lang/String;)V", "getShowTimes", "setShowTimes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ahka
{
  private long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  public ahka()
  {
    this(false, null, 0L, false, 0L, 0L, 63, null);
  }
  
  public ahka(boolean paramBoolean1, @NotNull String paramString, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramLong3;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public final void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ahka))
      {
        paramObject = (ahka)paramObject;
        if ((this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.jdField_b_of_type_Boolean != paramObject.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Long != paramObject.jdField_b_of_type_Long) || (this.c != paramObject.c)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "LatestAnonymousInfo(hasGetLatestInfo=" + this.jdField_a_of_type_Boolean + ", questId=" + this.jdField_a_of_type_JavaLangString + ", praiseNum=" + this.jdField_a_of_type_Long + ", beenPraised=" + this.jdField_b_of_type_Boolean + ", commentNum=" + this.jdField_b_of_type_Long + ", showTimes=" + this.c + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahka
 * JD-Core Version:    0.7.0.1
 */