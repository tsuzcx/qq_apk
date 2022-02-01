package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/WeVisModelConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "compatVersion", "", "getCompatVersion", "()I", "setCompatVersion", "(I)V", "configFileName", "", "getConfigFileName", "()Ljava/lang/String;", "isNeedUpdate", "", "()Z", "isValid", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "name", "getName", "setName", "sha1", "getSha1", "setSha1", "subType", "getSubType", "setSubType", "targetModelVersion", "getTargetModelVersion", "setTargetModelVersion", "targetSha1", "getTargetSha1", "setTargetSha1", "copyTo", "", "other", "parseTag", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  int XKi = -1;
  String XKj = "";
  String key = "";
  String name = "";
  int obC = -1;
  String obF = "";
  public int subType = -1;
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(261664);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              skip(paramXmlPullParser);
              AppMethodBeat.o(261664);
              return;
            } while (!paramString.equals("CompatVersion"));
            this.obC = g(paramXmlPullParser);
            AppMethodBeat.o(261664);
            return;
          } while (!paramString.equals("Sha1"));
          this.obF = f(paramXmlPullParser);
          AppMethodBeat.o(261664);
          return;
        } while (!paramString.equals("SubType"));
        this.subType = g(paramXmlPullParser);
        AppMethodBeat.o(261664);
        return;
      } while (!paramString.equals("Key"));
      this.key = f(paramXmlPullParser);
      AppMethodBeat.o(261664);
      return;
    } while (!paramString.equals("Name"));
    this.name = f(paramXmlPullParser);
    AppMethodBeat.o(261664);
  }
  
  public final void boK(String paramString)
  {
    AppMethodBeat.i(261647);
    s.u(paramString, "<set-?>");
    this.obF = paramString;
    AppMethodBeat.o(261647);
  }
  
  public final String getConfigFileName()
  {
    AppMethodBeat.i(261656);
    String str = s.X(this.key, ".xml");
    AppMethodBeat.o(261656);
    return str;
  }
  
  public final boolean isValid()
  {
    return this.obC == this.XKi;
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(261646);
    s.u(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(261646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.e
 * JD-Core Version:    0.7.0.1
 */