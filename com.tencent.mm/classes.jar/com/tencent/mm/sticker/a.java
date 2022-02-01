package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/BaseJsonObject;", "", "()V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "Companion", "plugin-sticker_release"})
public abstract class a
{
  public static final a IFQ = new a((byte)0);
  private static final String TAG = "MicroMsg.BaseJsonObject";
  
  public a bH(JSONObject paramJSONObject)
  {
    p.h(paramJSONObject, "jsonObj");
    return this;
  }
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/BaseJsonObject$Companion;", "", "()V", "TAG", "", "parseJson", "", "jsonFile", "obj", "Lcom/tencent/mm/sticker/BaseJsonObject;", "saveJson", "plugin-sticker_release"})
  public static final class a
  {
    public static void a(a parama, String paramString)
    {
      AppMethodBeat.i(105886);
      p.h(parama, "obj");
      p.h(paramString, "jsonFile");
      Charset localCharset;
      try
      {
        parama = parama.toJson().toString();
        p.g(parama, "obj.toJson().toString()");
        localCharset = d.UTF_8;
        if (parama == null)
        {
          parama = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(105886);
          throw parama;
        }
      }
      catch (Exception parama)
      {
        ae.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(105886);
        return;
      }
      parama = parama.getBytes(localCharset);
      p.g(parama, "(this as java.lang.String).getBytes(charset)");
      o.C(paramString, parama);
      AppMethodBeat.o(105886);
    }
    
    public static void a(String paramString, a parama)
    {
      AppMethodBeat.i(105885);
      p.h(paramString, "jsonFile");
      p.h(parama, "obj");
      try
      {
        paramString = h.xs(o.aZT(paramString));
        p.g(paramString, "jsonObj");
        parama.bH(paramString);
        AppMethodBeat.o(105885);
        return;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105885);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.a
 * JD-Core Version:    0.7.0.1
 */