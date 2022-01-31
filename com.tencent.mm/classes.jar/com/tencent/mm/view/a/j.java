package com.tencent.mm.view.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;
import java.util.ArrayList;

public final class j
  extends RecyclerView.a<j.b>
{
  public static final String ASy = File.separator;
  private com.tencent.mm.view.f.a AQS;
  c ASv;
  private int ASw;
  public j.a ASx;
  public int lxQ;
  private Context mContext;
  public ArrayList<EmojiGroupInfo> mData;
  
  public j(Context paramContext, com.tencent.mm.view.f.a parama)
  {
    AppMethodBeat.i(63009);
    this.mData = new ArrayList();
    this.ASv = null;
    this.mContext = paramContext;
    this.ASw = com.tencent.mm.emoji.e.a.A(paramContext, 2130771985);
    this.AQS = parama;
    paramContext = new c.a();
    paramContext.eNK = true;
    paramContext.fHt = 4;
    paramContext.eOa = this.ASw;
    paramContext.eNS = this.AQS.AUI;
    paramContext.eNS = this.AQS.AUI;
    this.ASv = paramContext.ahY();
    AppMethodBeat.o(63009);
  }
  
  private static String L(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    AppMethodBeat.i(63012);
    if ((bo.isNullOrNil(paramString2)) && (bo.isNullOrNil(paramString3)))
    {
      ab.w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
      AppMethodBeat.o(63012);
      return null;
    }
    if ((bo.isNullOrNil(paramString2)) && (bo.isNullOrNil(paramString3)))
    {
      ab.e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
      paramString3 = null;
      if (!bo.isNullOrNil(paramString3)) {
        if (!bo.isNullOrNil(paramString2)) {
          break label127;
        }
      }
    }
    label127:
    for (str = paramString1 + paramString3;; str = paramString1 + paramString2 + ASy + paramString3)
    {
      AppMethodBeat.o(63012);
      return str;
      if (bo.isNullOrNil(paramString3))
      {
        paramString3 = g.w(paramString2.getBytes());
        break;
      }
      paramString3 = g.w(paramString3.getBytes());
      break;
    }
  }
  
  public final EmojiGroupInfo RK(int paramInt)
  {
    AppMethodBeat.i(63010);
    if ((this.mData == null) || (this.mData.isEmpty()) || (this.mData.size() < paramInt) || (paramInt < 0))
    {
      AppMethodBeat.o(63010);
      return null;
    }
    EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)this.mData.get(paramInt);
    AppMethodBeat.o(63010);
    return localEmojiGroupInfo;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(63011);
    if (this.mData == null)
    {
      AppMethodBeat.o(63011);
      return 0;
    }
    int i = this.mData.size();
    AppMethodBeat.o(63011);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.a.j
 * JD-Core Version:    0.7.0.1
 */