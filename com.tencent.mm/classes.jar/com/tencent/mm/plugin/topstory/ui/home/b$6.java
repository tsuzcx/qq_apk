package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.e.a;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.webview.e.2;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class b$6
  implements e.a
{
  b$6(b paramb) {}
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(1578);
    if (this.tgw.tgd != null) {
      this.tgw.tgd.c(paramString1, paramString2, paramInt2, paramInt3, paramInt1, paramString3);
    }
    paramString1 = this.tgw.tgg.iterator();
    while (paramString1.hasNext())
    {
      paramString3 = (d.b)paramString1.next();
      if (paramString3.category == 110)
      {
        this.tgw.tfZ.runOnUiThread(new b.6.1(this, paramString3, paramInt1, paramString2));
        if (!this.tgw.cvo) {
          an.a(((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIg(), 107, 2, paramInt1, 0L, "");
        }
      }
    }
    AppMethodBeat.o(1578);
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(1580);
    if ((paramBoolean) && (this.tgw.tgd != null)) {
      this.tgw.tgd.c(paramString1, paramString2, paramInt2, paramInt3, paramInt1, paramString3);
    }
    paramString1 = this.tgw.tgg.iterator();
    while (paramString1.hasNext())
    {
      paramString3 = (d.b)paramString1.next();
      if (paramString3.category == 110)
      {
        this.tgw.tfZ.runOnUiThread(new b.6.3(this, paramString3, paramInt1, paramString2));
        if ((paramInt1 > 0) && (!this.tgw.cvo))
        {
          an.a(((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIg(), 107, 2, paramString3.tfN, 0L, "");
          AppMethodBeat.o(1580);
          return;
        }
      }
    }
    AppMethodBeat.o(1580);
  }
  
  public final void aI(String paramString, long paramLong)
  {
    AppMethodBeat.i(1579);
    if (this.tgw.tgd != null) {
      this.tgw.tgd.aM(paramString, paramLong);
    }
    Object localObject = this.tgw.tgg.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (d.b)((Iterator)localObject).next();
      if (((d.b)localObject).category == 110)
      {
        this.tgw.tfZ.runOnUiThread(new b.6.2(this, (d.b)localObject, paramString));
        if ((!this.tgw.cvo) && (((d.b)localObject).tfN <= 0)) {
          an.a(((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cHZ(), 107, 1, 0, 0L, "");
        }
      }
    }
    AppMethodBeat.o(1579);
  }
  
  public final void aJ(String paramString, long paramLong)
  {
    AppMethodBeat.i(1583);
    this.tgw.tfZ.runOnUiThread(new b.6.5(this, paramString, paramLong));
    AppMethodBeat.o(1583);
  }
  
  public final void aee(String paramString)
  {
    AppMethodBeat.i(1582);
    com.tencent.mm.plugin.topstory.ui.webview.e locale;
    JSONObject localJSONObject;
    if (this.tgw.tgd != null)
    {
      locale = this.tgw.tgd;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("params", paramString);
      al.d(new e.2(locale, localJSONObject.toString()));
      AppMethodBeat.o(1582);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + paramString.getMessage());
      }
    }
  }
  
  public final void cIu()
  {
    AppMethodBeat.i(1581);
    Iterator localIterator = this.tgw.tgg.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.category == 110)
      {
        this.tgw.tfZ.runOnUiThread(new b.6.4(this, localb));
        AppMethodBeat.o(1581);
        return;
      }
    }
    AppMethodBeat.o(1581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.6
 * JD-Core Version:    0.7.0.1
 */