package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

final class b$1
  extends g
{
  b$1(b paramb, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(46468);
    switch (paramInt)
    {
    default: 
      localObject = super.getTips(paramInt);
      AppMethodBeat.o(46468);
      return localObject;
    case 1: 
      localObject = this.hwZ.getString(2131305109);
      AppMethodBeat.o(46468);
      return localObject;
    }
    Object localObject = this.hwZ.getString(2131305011);
    AppMethodBeat.o(46468);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.b.1
 * JD-Core Version:    0.7.0.1
 */