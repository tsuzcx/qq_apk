package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiNodeProcessorSm;", "", "rootNode", "Lcom/tencent/mm/smiley/IEmojiNode;", "(Lcom/tencent/mm/smiley/IEmojiNode;)V", "currentDepth", "", "currentNode", "flushNode", "lastCodepoint", "state", "check", "codePoint", "defaultCheck", "node", "getCurrentNodeEmojiItem", "Lcom/tencent/mm/smiley/IEmojiItem;", "getFlushNodeEmojiItem", "isInFlushableState", "", "matchEmojiItem", "", "content", "", "start", "end", "processor", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "reset", "shouldUseEmojiPresentationStyleForSingleCodepoint", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final int DYC;
  public static final a acxs;
  private static final int acxy;
  private final n acxt;
  private n acxu;
  private int acxv;
  private int acxw;
  private n acxx;
  private int state;
  
  static
  {
    AppMethodBeat.i(242855);
    acxs = new a((byte)0);
    DYC = 1;
    acxy = 2;
    AppMethodBeat.o(242855);
  }
  
  public f(n paramn)
  {
    AppMethodBeat.i(242837);
    this.acxt = paramn;
    this.acxu = this.acxt;
    this.state = DYC;
    AppMethodBeat.o(242837);
  }
  
  private int ayp(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(242839);
    n localn = this.acxu.ayn(paramInt);
    if (this.state == acxy) {
      if (localn != null)
      {
        this.acxu = localn;
        this.acxw += 1;
      }
    }
    for (;;)
    {
      this.acxv = paramInt;
      AppMethodBeat.o(242839);
      return i;
      if (paramInt == 65038) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label84;
        }
        i = iUS();
        break;
      }
      label84:
      if (this.acxu.iUH() != null)
      {
        this.acxx = this.acxu;
        i = 3;
        iUS();
      }
      else
      {
        i = iUS();
        continue;
        if (localn == null)
        {
          i = iUS();
        }
        else
        {
          this.state = acxy;
          this.acxu = localn;
          this.acxw = 1;
        }
      }
    }
  }
  
  private final int iUS()
  {
    this.state = DYC;
    this.acxu = this.acxt;
    this.acxw = 0;
    return 1;
  }
  
  private l iUT()
  {
    AppMethodBeat.i(242844);
    Object localObject = this.acxx;
    if (localObject == null)
    {
      AppMethodBeat.o(242844);
      return null;
    }
    localObject = ((n)localObject).iUH();
    AppMethodBeat.o(242844);
    return localObject;
  }
  
  private l iUU()
  {
    AppMethodBeat.i(242846);
    l locall = this.acxu.iUH();
    AppMethodBeat.o(242846);
    return locall;
  }
  
  private boolean iUV()
  {
    AppMethodBeat.i(242852);
    if ((this.state == acxy) && (this.acxu.iUH() != null))
    {
      int i;
      if (this.acxw <= 1)
      {
        l locall = this.acxu.iUH();
        if (locall == null) {
          break label100;
        }
        if (locall.aTW().length != 0) {
          break label90;
        }
        i = 1;
        if (i != 0) {
          break label95;
        }
        i = 1;
        label67:
        if (i == 0) {
          break label100;
        }
        i = 1;
        label73:
        if (i == 0) {
          break label105;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label125;
        }
        AppMethodBeat.o(242852);
        return true;
        label90:
        i = 0;
        break;
        label95:
        i = 0;
        break label67;
        label100:
        i = 0;
        break label73;
        label105:
        if (a.ayq(this.acxv)) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    label125:
    AppMethodBeat.o(242852);
    return false;
  }
  
  public final void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, m paramm)
  {
    int j = 0;
    AppMethodBeat.i(242860);
    s.u(paramm, "processor");
    if (paramCharSequence != null) {
      if (paramCharSequence.length() != 0) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(242860);
      return;
    }
    if (paramInt1 < 0)
    {
      paramInt1 = j;
      if ((paramInt2 < 0) || (paramInt2 > paramCharSequence.length())) {
        break label87;
      }
    }
    label87:
    for (j = paramInt2;; j = paramCharSequence.length())
    {
      if (j > paramInt1) {
        break label98;
      }
      AppMethodBeat.o(242860);
      return;
      break;
    }
    label98:
    paramInt2 = Character.codePointAt(paramCharSequence, paramInt1);
    i = paramInt1;
    for (;;)
    {
      if (paramInt1 < j)
      {
        if (a.ayq(paramInt2))
        {
          paramInt1 = Character.charCount(paramInt2) + paramInt1;
          if (paramInt1 < j) {
            paramInt2 = Character.codePointAt(paramCharSequence, paramInt1);
          }
        }
        else
        {
          switch (ayp(paramInt2))
          {
          default: 
            break;
          case 1: 
            paramInt1 = i + Character.charCount(Character.codePointAt(paramCharSequence, i));
            if (paramInt1 >= j) {
              break label311;
            }
            paramInt2 = Character.codePointAt(paramCharSequence, paramInt1);
            i = paramInt1;
            break;
          case 2: 
            paramInt1 = Character.charCount(paramInt2) + paramInt1;
            if (paramInt1 >= j) {
              break label308;
            }
            paramInt2 = Character.codePointAt(paramCharSequence, paramInt1);
            break;
          case 3: 
            l locall = iUT();
            if ((locall != null) && (paramm.a(locall, i, paramInt1)))
            {
              AppMethodBeat.o(242860);
              return;
            }
            i = paramInt1;
            break;
          }
        }
      }
      else
      {
        if (iUV())
        {
          paramCharSequence = iUU();
          if ((paramCharSequence != null) && (paramm.a(paramCharSequence, i, paramInt1)))
          {
            AppMethodBeat.o(242860);
            return;
          }
        }
        AppMethodBeat.o(242860);
        return;
        label308:
        continue;
        label311:
        i = paramInt1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiNodeProcessorSm$Companion;", "", "()V", "ACTION_ADVANCE_BOTH", "", "ACTION_ADVANCE_END", "ACTION_FLUSH", "STATE_DEFAULT", "STATE_WALKING", "isDefaultEmoji", "", "emojiItem", "Lcom/tencent/mm/smiley/IEmojiItem;", "isEmojiVariantFlag", "codePoint", "isTextStyle", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean ayq(int paramInt)
    {
      return paramInt == 65039;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.f
 * JD-Core Version:    0.7.0.1
 */