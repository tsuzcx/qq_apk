package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.Map;

public final class o$a
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
  public LinkedList<a> nPR;
  public o.a.a nPS;
  
  public final void n(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      this.nPS = new o.a.a();
      this.nPS.nPT = new LinkedList();
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
          if (bk.bl((String)localObject1)) {
            break label177;
          }
          localObject3 = new o.a.a.a();
          ((o.a.a.a)localObject3).eAl = ((String)localObject1);
          this.nPS.nPT.add(localObject3);
          i += 1;
          break;
        }
      }
      label177:
      this.nPS.nPU = new LinkedList();
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
          if ((bk.bl(paramString)) && (bk.bl((String)localObject2))) {
            return;
          }
          localObject3 = new a.b();
          ((a.b)localObject3).title = paramString;
          ((a.b)localObject3).desc = ((String)localObject2);
          this.nPS.nPU.add(localObject3);
          i += 1;
          break;
        }
      }
    }
  }
  
  public static final class a$b
  {
    public String desc;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o.a
 * JD-Core Version:    0.7.0.1
 */