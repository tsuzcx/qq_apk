package com.tencent.mm.sns_compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "", "snsWithTaBase", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;)V", "userName", "", "contentDesc", "createTime", "", "snsId", "localId", "stringSeq", "type", "withTa", "", "addressText", "withFriends", "extFlag", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "getAddressText", "()Ljava/lang/String;", "getContentDesc", "getCreateTime", "()I", "getExtFlag", "getLocalId", "setLocalId", "(I)V", "getSnsId", "getStringSeq", "getType", "getUserName", "getWithFriends", "getWithTa", "()Ljava/util/List;", "SnsWithTaBaseInfo", "SnsWithTaFinder", "SnsWithTaImage", "SnsWithTaMusicMv", "SnsWithTaText", "SnsWithTaUrl", "SnsWithTaVideo", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaImage;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaText;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaUrl;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaMusicMv;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaVideo;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaFinder;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaBaseInfo;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  public final String aczi;
  private final List<String> aczj;
  public final String aczk;
  public final String aczl;
  public final int createTime;
  public final int extFlag;
  public final String hQX;
  public int icg;
  private final int type;
  public final String userName;
  public final String uyk;
  
  private f(f paramf)
  {
    this(paramf.userName, paramf.uyk, paramf.createTime, paramf.hQX, paramf.icg, paramf.aczi, paramf.type, paramf.aczj, paramf.aczk, paramf.aczl, paramf.extFlag, (byte)0);
  }
  
  private f(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, int paramInt3, List<String> paramList, String paramString5, String paramString6, int paramInt4)
  {
    this.userName = paramString1;
    this.uyk = paramString2;
    this.createTime = paramInt1;
    this.hQX = paramString3;
    this.icg = paramInt2;
    this.aczi = paramString4;
    this.type = paramInt3;
    this.aczj = paramList;
    this.aczk = paramString5;
    this.aczl = paramString6;
    this.extFlag = paramInt4;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaBaseInfo;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "userName", "", "contentDesc", "createTime", "", "snsId", "localId", "stringSeq", "type", "withTa", "", "addressText", "withFriends", "extFlag", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;I)V", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends f
  {
    public a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4, int paramInt3, List<String> paramList, String paramString5, String paramString6, int paramInt4)
    {
      super(paramString2, paramInt1, paramString3, paramInt2, paramString4, paramInt3, paramList, paramString5, paramString6, paramInt4, (byte)0);
      AppMethodBeat.i(235498);
      AppMethodBeat.o(235498);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaFinder;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "thumbUrl", "", "isVideo", "", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;Ljava/lang/String;Z)V", "()Z", "getThumbUrl", "()Ljava/lang/String;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f
  {
    public final boolean AnF;
    public final String thumbUrl;
    
    public b(f paramf, String paramString, boolean paramBoolean)
    {
      super((byte)0);
      AppMethodBeat.i(235503);
      this.thumbUrl = paramString;
      this.AnF = paramBoolean;
      AppMethodBeat.o(235503);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaImage;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "medias", "", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;Ljava/util/List;)V", "getMedias", "()Ljava/util/List;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends f
  {
    public final List<dmz> aczm;
    
    public c(f paramf, List<? extends dmz> paramList)
    {
      super((byte)0);
      AppMethodBeat.i(235488);
      this.aczm = paramList;
      AppMethodBeat.o(235488);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaMusicMv;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "title", "", "subTitle", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;Lcom/tencent/mm/protocal/protobuf/MediaObj;Ljava/lang/String;Ljava/lang/String;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/MediaObj;", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends f
  {
    public final dmz ibT;
    public String title;
    public String uCW;
    
    public d(f paramf, dmz paramdmz, String paramString1, String paramString2)
    {
      super((byte)0);
      AppMethodBeat.i(235484);
      this.ibT = paramdmz;
      this.title = paramString1;
      this.uCW = paramString2;
      AppMethodBeat.o(235484);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaText;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;)V", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends f
  {
    public e(f paramf)
    {
      super((byte)0);
      AppMethodBeat.i(235490);
      AppMethodBeat.o(235490);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaUrl;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "title", "", "subTitle", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;Lcom/tencent/mm/protocal/protobuf/MediaObj;Ljava/lang/String;Ljava/lang/String;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/MediaObj;", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "getTitle", "setTitle", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends f
  {
    public final dmz ibT;
    public String title;
    public String uCW;
    
    private f(f paramf, dmz paramdmz, String paramString)
    {
      super((byte)0);
      AppMethodBeat.i(235492);
      this.ibT = paramdmz;
      this.title = paramString;
      this.uCW = null;
      AppMethodBeat.o(235492);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/SnsWithTaBase$SnsWithTaVideo;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "snsWithTaBase", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "(Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;Lcom/tencent/mm/protocal/protobuf/MediaObj;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/MediaObj;", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends f
  {
    public final dmz ibT;
    
    public g(f paramf, dmz paramdmz)
    {
      super((byte)0);
      AppMethodBeat.i(235495);
      this.ibT = paramdmz;
      AppMethodBeat.o(235495);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.f
 * JD-Core Version:    0.7.0.1
 */