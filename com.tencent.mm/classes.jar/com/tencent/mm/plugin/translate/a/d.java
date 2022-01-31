package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  implements f
{
  public int index;
  public SparseArray<c.c> pKL = null;
  public boolean pKM = false;
  public b pKN;
  a pKO;
  public am pKP = new am(new d.1(this), false);
  long start;
  
  public d(int paramInt, a parama)
  {
    this.index = paramInt;
    this.pKO = parama;
  }
  
  public final void bOX()
  {
    this.pKN = null;
    this.pKM = false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.pKN != paramm)
    {
      y.e("MicroMsg.WorkingTranslate", "not my translate work");
      return;
    }
    this.pKP.stopTimer();
    y.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
    if (((b)paramm).pKC != null) {}
    for (int i = ((b)paramm).pKC.size();; i = 0)
    {
      y.d("MicroMsg.WorkingTranslate", "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i) });
      bOX();
      this.pKO.a(paramInt2, this.pKL, ((b)paramm).pKC);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d
 * JD-Core Version:    0.7.0.1
 */