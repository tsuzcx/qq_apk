package com.tencent.mm.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.pluginsdk.ui.chat.j;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "emojiMD5", "", "chatID", "timestamp", "", "scene", "", "toUser", "panelEmojiCtx", "Lcom/tencent/mm/protobuf/ByteString;", "PageBuff", "enableSos", "", "panelCallbackImpl", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getPageBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "setPageBuff", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getChatID", "()Ljava/lang/String;", "setChatID", "(Ljava/lang/String;)V", "getEmojiMD5", "setEmojiMD5", "getEnableSos", "()Z", "setEnableSos", "(Z)V", "getPanelCallbackImpl", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setPanelCallbackImpl", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getPanelEmojiCtx", "setPanelEmojiCtx", "getScene", "()I", "setScene", "(I)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "getToUser", "setToUser", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-emojisdk_release"})
public final class SimilarEmojiQueryModel
  implements Parcelable
{
  public static final Parcelable.Creator<SimilarEmojiQueryModel> CREATOR;
  public static final a EZd;
  private b Dvp;
  String EYZ;
  b EZa;
  public boolean EZb;
  public j EZc;
  public String emojiMD5;
  int scene;
  long timestamp;
  public String toUser;
  
  static
  {
    AppMethodBeat.i(105830);
    EZd = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(105830);
  }
  
  public SimilarEmojiQueryModel(Parcel paramParcel)
  {
    this(str1, str2, l, i, paramParcel);
    AppMethodBeat.i(105829);
    AppMethodBeat.o(105829);
  }
  
  public SimilarEmojiQueryModel(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, b paramb, boolean paramBoolean, j paramj)
  {
    AppMethodBeat.i(105828);
    this.emojiMD5 = paramString1;
    this.EYZ = paramString2;
    this.timestamp = paramLong;
    this.scene = paramInt;
    this.toUser = paramString3;
    this.EZa = paramb;
    this.Dvp = null;
    this.EZb = paramBoolean;
    this.EZc = paramj;
    AppMethodBeat.o(105828);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105833);
    if (this != paramObject)
    {
      if ((paramObject instanceof SimilarEmojiQueryModel))
      {
        paramObject = (SimilarEmojiQueryModel)paramObject;
        if ((!k.g(this.emojiMD5, paramObject.emojiMD5)) || (!k.g(this.EYZ, paramObject.EYZ)) || (this.timestamp != paramObject.timestamp) || (this.scene != paramObject.scene) || (!k.g(this.toUser, paramObject.toUser)) || (!k.g(this.EZa, paramObject.EZa)) || (!k.g(this.Dvp, paramObject.Dvp)) || (this.EZb != paramObject.EZb) || (!k.g(this.EZc, paramObject.EZc))) {}
      }
    }
    else
    {
      AppMethodBeat.o(105833);
      return true;
    }
    AppMethodBeat.o(105833);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(105831);
    String str = "SimilarEmojiQueryModel(emojiMD5=" + this.emojiMD5 + ", chatID=" + this.EYZ + ", timestamp=" + this.timestamp + ", scene=" + this.scene + ", toUser=" + this.toUser + ", panelEmojiCtx=" + this.EZa + ", PageBuff=" + this.Dvp + ", enableSos=" + this.EZb + ", panelCallbackImpl=" + this.EZc + ")";
    AppMethodBeat.o(105831);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105827);
    k.h(paramParcel, "dest");
    paramParcel.writeString(this.emojiMD5);
    paramParcel.writeString(this.EYZ);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.toUser);
    AppMethodBeat.o(105827);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/search/data/SimilarEmojiQueryModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/search/data/SimilarEmojiQueryModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "plugin-emojisdk_release"})
  public static final class b
    implements Parcelable.Creator<SimilarEmojiQueryModel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.search.data.SimilarEmojiQueryModel
 * JD-Core Version:    0.7.0.1
 */