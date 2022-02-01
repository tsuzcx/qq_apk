package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.fxy;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "()Landroid/graphics/Matrix;", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a NYL;
  Matrix NYM;
  public EmojiInfo mgK;
  
  static
  {
    AppMethodBeat.i(280376);
    NYL = new e.a((byte)0);
    AppMethodBeat.o(280376);
  }
  
  public e(jy paramjy)
  {
    super(d.NYe);
    AppMethodBeat.i(280368);
    this.NYM = new Matrix();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new amo();
      paramjy = paramjy.YMl.aaxD.Op;
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramjy);
        paramjy = (jy)localObject;
      }
      catch (Exception paramjy)
      {
        for (;;)
        {
          fxy localfxy;
          Log.printDebugStack("safeParser", "", new Object[] { paramjy });
          paramjy = null;
        }
      }
      paramjy = (amo)paramjy;
      if (paramjy != null)
      {
        this.mgK = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aof(paramjy.md5);
        localObject = this.NYM;
        localfxy = paramjy.ZtA;
        s.s(localfxy, "it.showMatrix");
        ((Matrix)localObject).setValues(a(localfxy));
        localObject = this.matrix;
        localfxy = paramjy.Ztz;
        s.s(localfxy, "it.editorMatrix");
        ((Matrix)localObject).setValues(a(localfxy));
        a(paramjy.NZv);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
        AppMethodBeat.o(280368);
        return;
      }
    }
    catch (IOException paramjy)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.EmojiItem", (Throwable)paramjy, "EmojiItem parse error", new Object[0]);
      AppMethodBeat.o(280368);
    }
  }
  
  public e(EmojiInfo paramEmojiInfo, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    super(d.NYe);
    AppMethodBeat.i(280356);
    this.NYM = new Matrix();
    this.mgK = paramEmojiInfo;
    this.NYM.set(paramMatrix1);
    this.matrix.set(paramMatrix2);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.EmojiItem", toString());
    AppMethodBeat.o(280356);
  }
  
  public final com.tencent.mm.bx.a gKs()
  {
    AppMethodBeat.i(280386);
    amo localamo = new amo();
    Object localObject = this.mgK;
    if (localObject == null)
    {
      localObject = "";
      localamo.md5 = ((String)localObject);
      localObject = this.mgK;
      if (localObject != null) {
        break label106;
      }
      localObject = "";
    }
    for (;;)
    {
      localamo.name = ((String)localObject);
      localamo.Ztz = h(this.matrix);
      localamo.ZtA = h(this.NYM);
      localamo.NZv = gKq();
      localObject = (com.tencent.mm.bx.a)localamo;
      AppMethodBeat.o(280386);
      return localObject;
      String str = ((EmojiInfo)localObject).getMd5();
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label106:
      str = ((EmojiInfo)localObject).getName();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(280392);
    StringBuilder localStringBuilder = new StringBuilder("[").append(hashCode()).append("]md5:");
    Object localObject1 = this.mgK;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" name:");
      localObject1 = this.mgK;
      if (localObject1 != null) {
        break label87;
      }
    }
    label87:
    for (localObject1 = localObject2;; localObject1 = ((EmojiInfo)localObject1).getName())
    {
      localObject1 = localObject1;
      AppMethodBeat.o(280392);
      return localObject1;
      localObject1 = ((EmojiInfo)localObject1).getMd5();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.e
 * JD-Core Version:    0.7.0.1
 */