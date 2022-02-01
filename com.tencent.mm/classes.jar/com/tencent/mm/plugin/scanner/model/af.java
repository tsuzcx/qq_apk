package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class af
{
  private ae xaP;
  
  public af()
  {
    AppMethodBeat.i(51655);
    this.xaP = new ae();
    AppMethodBeat.o(51655);
  }
  
  private static ae.a g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51657);
    paramXmlPullParser = new ae.a(paramXmlPullParser.getAttributeValue(null, "postOfficeBox"), paramXmlPullParser.getAttributeValue(null, "extendedAddress"), paramXmlPullParser.getAttributeValue(null, "street"), paramXmlPullParser.getAttributeValue(null, "locality"), paramXmlPullParser.getAttributeValue(null, "region"), paramXmlPullParser.getAttributeValue(null, "postalCode"), paramXmlPullParser.getAttributeValue(null, "country"));
    AppMethodBeat.o(51657);
    return paramXmlPullParser;
  }
  
  private static ae.c h(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51658);
    paramXmlPullParser = new ae.c(paramXmlPullParser.getAttributeValue(null, "type"), paramXmlPullParser.getAttributeValue(null, "buffer"));
    AppMethodBeat.o(51658);
    return paramXmlPullParser;
  }
  
  public final void arK(String paramString)
  {
    AppMethodBeat.i(51656);
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
          this.xaP.xay = new ae.b(localXmlPullParser.getAttributeValue(null, "firstName"), localXmlPullParser.getAttributeValue(null, "middleName"), localXmlPullParser.getAttributeValue(null, "lastName"));
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("address"))
        {
          this.xaP.xaD = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("deliveryAddress"))
        {
          this.xaP.xaE = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("homeAddress"))
        {
          this.xaP.xaF = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("workAddress"))
        {
          this.xaP.xaG = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("photo"))
        {
          this.xaP.xaz = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("logo"))
        {
          this.xaP.xaA = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).equals("sound"))
          {
            this.xaP.xaB = h(localXmlPullParser);
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
                  this.xaP.bLs = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("photoUrl"))
                {
                  this.xaP.kow = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("birthday"))
                {
                  this.xaP.xaC = str;
                  paramString = (String)localObject;
                }
                else
                {
                  ae localae;
                  if (((String)localObject).equals("mobilePhoneNumber"))
                  {
                    localae = this.xaP;
                    if (localae.xaH == null) {
                      localae.xaH = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localae.xaH.contains(str))
                      {
                        localae.xaH.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("homePhoneNumber"))
                  {
                    localae = this.xaP;
                    if (localae.xaI == null) {
                      localae.xaI = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localae.xaI.contains(str))
                      {
                        localae.xaI.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("workPhoneNumber"))
                  {
                    localae = this.xaP;
                    if (localae.xaJ == null) {
                      localae.xaJ = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localae.xaJ.contains(str))
                      {
                        localae.xaJ.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("telAVPhoneNumber"))
                  {
                    localae = this.xaP;
                    if (localae.xaK == null) {
                      localae.xaK = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localae.xaK.contains(str))
                      {
                        localae.xaK.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("phoneNumber"))
                  {
                    localae = this.xaP;
                    if (localae.xaL == null) {
                      localae.xaL = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localae.xaL.contains(str))
                      {
                        localae.xaL.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("email"))
                  {
                    this.xaP.exO = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("title"))
                  {
                    this.xaP.title = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("role"))
                  {
                    this.xaP.xaM = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("agent"))
                  {
                    this.xaP.xaN = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("note"))
                  {
                    this.xaP.xaO = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("url"))
                  {
                    this.xaP.url = str;
                    paramString = (String)localObject;
                  }
                  else
                  {
                    paramString = (String)localObject;
                    if (((String)localObject).equals("organization"))
                    {
                      this.xaP.koE = str;
                      paramString = (String)localObject;
                      continue;
                      ae.xaP = this.xaP;
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
    ae.xaP = this.xaP;
    AppMethodBeat.o(51656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.af
 * JD-Core Version:    0.7.0.1
 */