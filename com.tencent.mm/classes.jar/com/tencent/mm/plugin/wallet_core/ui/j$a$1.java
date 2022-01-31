package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.a;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Vector;

final class j$a$1
  extends m<String>
{
  j$a$1(j.a parama) {}
  
  public final String a(Vector<m<String>.b> paramVector, int paramInt)
  {
    if (paramVector == null)
    {
      y.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVector.size())
    {
      m.a locala = ((m.b)paramVector.get(i)).qwi;
      if ((i == paramInt) || (locala == m.a.qwe)) {
        localStringBuilder.append((String)((m.b)paramVector.get(i)).qwh + "-");
      }
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "0";
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j.a.1
 * JD-Core Version:    0.7.0.1
 */