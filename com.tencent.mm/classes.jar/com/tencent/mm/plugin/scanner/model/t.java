package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class t
{
  private s qvq;
  
  public t()
  {
    AppMethodBeat.i(80890);
    this.qvq = new s();
    AppMethodBeat.o(80890);
  }
  
  private static s.a g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(80892);
    paramXmlPullParser = new s.a(paramXmlPullParser.getAttributeValue(null, "postOfficeBox"), paramXmlPullParser.getAttributeValue(null, "extendedAddress"), paramXmlPullParser.getAttributeValue(null, "street"), paramXmlPullParser.getAttributeValue(null, "locality"), paramXmlPullParser.getAttributeValue(null, "region"), paramXmlPullParser.getAttributeValue(null, "postalCode"), paramXmlPullParser.getAttributeValue(null, "country"));
    AppMethodBeat.o(80892);
    return paramXmlPullParser;
  }
  
  private static s.c h(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(80893);
    paramXmlPullParser = new s.c(paramXmlPullParser.getAttributeValue(null, "type"), paramXmlPullParser.getAttributeValue(null, "buffer"));
    AppMethodBeat.o(80893);
    return paramXmlPullParser;
  }
  
  public final void Yy(String paramString)
  {
    AppMethodBeat.i(80891);
    Object localObject = XmlPullParserFactory.newInstance();
    ((XmlPullParserFactory)localObject).setNamespaceAware(true);
    XmlPullParser localXmlPullParser = ((XmlPullParserFactory)localObject).newPullParser();
    localXmlPullParser.setInput(new StringReader(paramString));
    int i = localXmlPullParser.getEventType();
    localObject = "";
    if (i != 1)
    {
      paramString = (String)localObject;
      switch (i)
      {
      default: 
        paramString = (String)localObject;
      }
      for (;;)
      {
        i = localXmlPullParser.next();
        localObject = paramString;
        break;
        localObject = localXmlPullParser.getName();
        if (((String)localObject).equals("name"))
        {
          this.qvq.quZ = new s.b(localXmlPullParser.getAttributeValue(null, "firstName"), localXmlPullParser.getAttributeValue(null, "middleName"), localXmlPullParser.getAttributeValue(null, "lastName"));
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("address"))
        {
          this.qvq.qve = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("deliveryAddress"))
        {
          this.qvq.qvf = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("homeAddress"))
        {
          this.qvq.qvg = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("workAddress"))
        {
          this.qvq.qvh = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("photo"))
        {
          this.qvq.qva = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("logo"))
        {
          this.qvq.qvb = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).equals("sound"))
          {
            this.qvq.qvc = h(localXmlPullParser);
            paramString = (String)localObject;
            continue;
            String str = localXmlPullParser.getText();
            paramString = (String)localObject;
            if (str != null)
            {
              paramString = (String)localObject;
              if (str.trim().length() > 0)
              {
                str = str.trim();
                if (((String)localObject).equals("nickName"))
                {
                  this.qvq.blZ = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("photoUrl"))
                {
                  this.qvq.hJS = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("birthday"))
                {
                  this.qvq.qvd = str;
                  paramString = (String)localObject;
                }
                else
                {
                  s locals;
                  if (((String)localObject).equals("mobilePhoneNumber"))
                  {
                    locals = this.qvq;
                    if (locals.qvi == null) {
                      locals.qvi = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!locals.qvi.contains(str))
                      {
                        locals.qvi.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("homePhoneNumber"))
                  {
                    locals = this.qvq;
                    if (locals.qvj == null) {
                      locals.qvj = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!locals.qvj.contains(str))
                      {
                        locals.qvj.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("workPhoneNumber"))
                  {
                    locals = this.qvq;
                    if (locals.qvk == null) {
                      locals.qvk = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!locals.qvk.contains(str))
                      {
                        locals.qvk.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("telAVPhoneNumber"))
                  {
                    locals = this.qvq;
                    if (locals.qvl == null) {
                      locals.qvl = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!locals.qvl.contains(str))
                      {
                        locals.qvl.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("phoneNumber"))
                  {
                    locals = this.qvq;
                    if (locals.qvm == null) {
                      locals.qvm = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!locals.qvm.contains(str))
                      {
                        locals.qvm.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("email"))
                  {
                    this.qvq.dqF = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("title"))
                  {
                    this.qvq.title = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("role"))
                  {
                    this.qvq.qvn = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("agent"))
                  {
                    this.qvq.qvo = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("note"))
                  {
                    this.qvq.qvp = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("url"))
                  {
                    this.qvq.url = str;
                    paramString = (String)localObject;
                  }
                  else
                  {
                    paramString = (String)localObject;
                    if (((String)localObject).equals("organization"))
                    {
                      this.qvq.hKb = str;
                      paramString = (String)localObject;
                      continue;
                      s.qvq = this.qvq;
                      paramString = (String)localObject;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    s.qvq = this.qvq;
    AppMethodBeat.o(80891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.t
 * JD-Core Version:    0.7.0.1
 */