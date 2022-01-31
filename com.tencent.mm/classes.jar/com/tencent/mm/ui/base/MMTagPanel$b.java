package com.tencent.mm.ui.base;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class MMTagPanel$b
  implements InputFilter
{
  int mark;
  List<String> zmH;
  
  public MMTagPanel$b(MMTagPanel paramMMTagPanel)
  {
    AppMethodBeat.i(106824);
    this.zmH = new LinkedList();
    AppMethodBeat.o(106824);
  }
  
  public final CharSequence filter(final CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106825);
    ab.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(MMTagPanel.i(this.zmE)) });
    this.mark = -1;
    this.zmH.clear();
    Object localObject = new char[paramInt2 - paramInt1];
    TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, (char[])localObject, 0);
    if (!MMTagPanel.j(this.zmE))
    {
      i = 0;
      paramCharSequence = new StringBuilder();
      if (paramInt1 < paramInt2)
      {
        if (localObject[paramInt1] == '\n') {
          i = 1;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramCharSequence.append(localObject[paramInt1]);
        }
      }
      if (i != 0)
      {
        localObject = paramCharSequence.toString();
        paramCharSequence.insert(0, paramSpanned.subSequence(0, paramInt3));
        paramCharSequence.append(paramSpanned.subSequence(paramInt4, paramSpanned.length()));
        this.zmE.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(106821);
            MMTagPanel.e(MMTagPanel.b.this.zmE).Li(paramCharSequence.toString());
            AppMethodBeat.o(106821);
          }
        });
        AppMethodBeat.o(106825);
        return localObject;
      }
      AppMethodBeat.o(106825);
      return null;
    }
    int i = paramInt1;
    if (i < paramInt2)
    {
      if ((localObject[i] == '\n') || (localObject[i] == ',') || (localObject[i] == ';') || (localObject[i] == '、') || (localObject[i] == 65292) || (localObject[i] == 65307))
      {
        if (-1 != this.mark) {
          break label385;
        }
        this.zmH.add((paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, i)).trim());
      }
      for (;;)
      {
        this.mark = (i + 1);
        i += 1;
        break;
        label385:
        this.zmH.add(paramCharSequence.subSequence(this.mark, i).toString().trim());
      }
    }
    if (MMTagPanel.h(this.zmE))
    {
      paramInt1 = f.auQ(paramSpanned.toString());
      if ((MMTagPanel.i(this.zmE)) && (paramCharSequence.equals("\n")) && (36 < paramInt1)) {
        this.zmH.clear();
      }
    }
    if (this.zmH.isEmpty())
    {
      AppMethodBeat.o(106825);
      return null;
    }
    if (MMTagPanel.e(this.zmE) != null)
    {
      localObject = this.zmH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (str.length() > 0) {
          this.zmE.post(new MMTagPanel.b.2(this, str));
        }
      }
    }
    if (this.mark >= paramInt2) {
      paramSpanned.length();
    }
    for (paramCharSequence = paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();; paramCharSequence = paramCharSequence.subSequence(this.mark, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()))
    {
      this.zmE.post(new MMTagPanel.b.3(this, paramCharSequence));
      AppMethodBeat.o(106825);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.b
 * JD-Core Version:    0.7.0.1
 */