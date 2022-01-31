package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.model.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Vector;

final class l$a$1
  extends r<String>
{
  l$a$1(l.a parama) {}
  
  public final String a(Vector<r<String>.b> paramVector, int paramInt)
  {
    AppMethodBeat.i(47379);
    if (paramVector == null)
    {
      ab.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
      AppMethodBeat.o(47379);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVector.size())
    {
      r.a locala = ((r.b)paramVector.get(i)).uiH;
      if ((i == paramInt) || (locala == r.a.uiD)) {
        localStringBuilder.append((String)((r.b)paramVector.get(i)).uiG + "-");
      }
      i += 1;
    }
    if (localStringBuilder.length() == 0)
    {
      AppMethodBeat.o(47379);
      return "0";
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    paramVector = localStringBuilder.toString();
    AppMethodBeat.o(47379);
    return paramVector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l.a.1
 * JD-Core Version:    0.7.0.1
 */