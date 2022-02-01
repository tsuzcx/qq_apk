package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.xeffect.d;
import com.tencent.mm.xeffect.d.a;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/WeVisModelListConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "configVersion", "", "getConfigVersion", "()I", "setConfigVersion", "(I)V", "isValid", "", "()Z", "modelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/xlabeffect/WeVisModelConfig;", "getModelList", "()Ljava/util/LinkedList;", "sdkVersion", "getSdkVersion", "setSdkVersion", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "reportModelRes", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public int XKk;
  public final LinkedList<e> XKl;
  public int sdkVersion;
  
  public g()
  {
    AppMethodBeat.i(261643);
    this.XKl = new LinkedList();
    AppMethodBeat.o(261643);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(261655);
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
            skip(paramXmlPullParser);
            AppMethodBeat.o(261655);
            return;
          } while (!paramString.equals("ModelList"));
          AppMethodBeat.o(261655);
          return;
        } while (!paramString.equals("ConfigVersion"));
        this.XKk = g(paramXmlPullParser);
        AppMethodBeat.o(261655);
        return;
      } while (!paramString.equals("Model"));
      paramString = new e();
      paramString.e(paramXmlPullParser);
      this.XKl.add(paramString);
      AppMethodBeat.o(261655);
      return;
    } while (!paramString.equals("SDKVersion"));
    this.sdkVersion = g(paramXmlPullParser);
    AppMethodBeat.o(261655);
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(261650);
    s.u(paramXmlPullParser, "parser");
    this.XKl.clear();
    super.e(paramXmlPullParser);
    AppMethodBeat.o(261650);
  }
  
  public final boolean isValid()
  {
    int i = this.sdkVersion;
    d.a locala = d.agXC;
    return i == 140;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.g
 * JD-Core Version:    0.7.0.1
 */