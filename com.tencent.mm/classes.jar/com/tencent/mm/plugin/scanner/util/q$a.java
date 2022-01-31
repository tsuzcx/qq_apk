package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

public final class q$a
{
  public String field_certification;
  public String field_certificationurl;
  public String field_detailurl;
  public String field_exposeurl;
  public String field_extinfo;
  public String field_feedbackurl;
  public int field_functionType;
  public int field_getaction;
  public String field_headerbackgroundurl;
  public String field_headermask;
  public String field_introlink;
  public String field_introtitle;
  public String field_playurl;
  public String field_productid;
  public String field_shareurl;
  public String field_source;
  public String field_subtitle;
  public String field_thumburl;
  public String field_title;
  public int field_type;
  public String field_xml;
  public int field_xmlType;
  public LinkedList<a> qDK;
  public q.a.a qDL;
  
  public final void n(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(81474);
    if (paramMap != null)
    {
      this.qDL = new q.a.a();
      this.qDL.qDM = new LinkedList();
      Object localObject2 = paramString + ".bannerlist.banner";
      int i = 0;
      Object localObject3;
      if (i < 1000)
      {
        localObject3 = new StringBuilder().append((String)localObject2);
        if (i > 0) {}
        for (localObject1 = Integer.valueOf(i);; localObject1 = "")
        {
          localObject1 = localObject1;
          localObject1 = (String)paramMap.get((String)localObject1 + ".link");
          if (bo.isNullOrNil((String)localObject1)) {
            break label182;
          }
          localObject3 = new q.a.a.a();
          ((q.a.a.a)localObject3).link = ((String)localObject1);
          this.qDL.qDM.add(localObject3);
          i += 1;
          break;
        }
      }
      label182:
      this.qDL.qDN = new LinkedList();
      Object localObject1 = paramString + ".detaillist.detail";
      i = 0;
      if (i < 1000)
      {
        localObject2 = new StringBuilder().append((String)localObject1);
        if (i > 0) {}
        for (paramString = Integer.valueOf(i);; paramString = "")
        {
          localObject2 = paramString;
          paramString = (String)paramMap.get((String)localObject2 + ".title");
          localObject2 = (String)paramMap.get((String)localObject2 + ".desc");
          if ((bo.isNullOrNil(paramString)) && (bo.isNullOrNil((String)localObject2))) {
            break label384;
          }
          localObject3 = new q.a.a.b();
          ((q.a.a.b)localObject3).title = paramString;
          ((q.a.a.b)localObject3).desc = ((String)localObject2);
          this.qDL.qDN.add(localObject3);
          i += 1;
          break;
        }
      }
    }
    label384:
    AppMethodBeat.o(81474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.q.a
 * JD-Core Version:    0.7.0.1
 */