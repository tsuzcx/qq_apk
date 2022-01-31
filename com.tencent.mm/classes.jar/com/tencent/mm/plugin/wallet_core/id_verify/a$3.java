package com.tencent.mm.plugin.wallet_core.id_verify;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class a$3
  extends g
{
  a$3(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(46579);
    Object localObject = null;
    if (paramInt == 0)
    {
      String str = this.hwZ.getString(2131305540);
      localObject = this.hwZ.getString(2131305536);
      str = this.hwZ.getString(2131305546, new Object[] { str, localObject });
      j localj = new j(this.hwZ);
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(localj, str.length() - ((String)localObject).length(), str.length(), 33);
      localObject = localSpannableString.subSequence(0, localSpannableString.length());
    }
    AppMethodBeat.o(46579);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.a.3
 * JD-Core Version:    0.7.0.1
 */