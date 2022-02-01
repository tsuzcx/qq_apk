package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/BaseJsonObject;", "", "()V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "Companion", "plugin-sticker_release"})
public abstract class a
{
  public static final a Fct = new a((byte)0);
  private static final String TAG = "MicroMsg.BaseJsonObject";
  
  public a bx(JSONObject paramJSONObject)
  {
    k.h(paramJSONObject, "jsonObj");
    return this;
  }
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/BaseJsonObject$Companion;", "", "()V", "TAG", "", "parseJson", "", "jsonFile", "obj", "Lcom/tencent/mm/sticker/BaseJsonObject;", "saveJson", "plugin-sticker_release"})
  public static final class a
  {
    public static void a(a parama, String paramString)
    {
      AppMethodBeat.i(105886);
      k.h(parama, "obj");
      k.h(paramString, "jsonFile");
      Charset localCharset;
      try
      {
        parama = parama.toJson().toString();
        k.g(parama, "obj.toJson().toString()");
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
        ad.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(105886);
        return;
      }
      parama = parama.getBytes(localCharset);
      k.g(parama, "(this as java.lang.String).getBytes(charset)");
      i.B(paramString, parama);
      AppMethodBeat.o(105886);
    }
    
    public static void a(String paramString, a parama)
    {
      AppMethodBeat.i(105885);
      k.h(paramString, "jsonFile");
      k.h(parama, "obj");
      try
      {
        paramString = h.qE(i.aMP(paramString));
        k.g(paramString, "jsonObj");
        parama.bx(paramString);
        AppMethodBeat.o(105885);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105885);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.a
 * JD-Core Version:    0.7.0.1
 */