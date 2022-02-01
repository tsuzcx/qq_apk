package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class ai
{
  private ah yoO;
  
  public ai()
  {
    AppMethodBeat.i(51655);
    this.yoO = new ah();
    AppMethodBeat.o(51655);
  }
  
  private static ah.a f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51657);
    paramXmlPullParser = new ah.a(paramXmlPullParser.getAttributeValue(null, "postOfficeBox"), paramXmlPullParser.getAttributeValue(null, "extendedAddress"), paramXmlPullParser.getAttributeValue(null, "street"), paramXmlPullParser.getAttributeValue(null, "locality"), paramXmlPullParser.getAttributeValue(null, "region"), paramXmlPullParser.getAttributeValue(null, "postalCode"), paramXmlPullParser.getAttributeValue(null, "country"));
    AppMethodBeat.o(51657);
    return paramXmlPullParser;
  }
  
  private static ah.c g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51658);
    paramXmlPullParser = new ah.c(paramXmlPullParser.getAttributeValue(null, "type"), paramXmlPullParser.getAttributeValue(null, "buffer"));
    AppMethodBeat.o(51658);
    return paramXmlPullParser;
  }
  
  public final void awL(String paramString)
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
          this.yoO.yox = new ah.b(localXmlPullParser.getAttributeValue(null, "firstName"), localXmlPullParser.getAttributeValue(null, "middleName"), localXmlPullParser.getAttributeValue(null, "lastName"));
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("address"))
        {
          this.yoO.yoC = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("deliveryAddress"))
        {
          this.yoO.yoD = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("homeAddress"))
        {
          this.yoO.yoE = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("workAddress"))
        {
          this.yoO.yoF = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("photo"))
        {
          this.yoO.yoy = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("logo"))
        {
          this.yoO.yoz = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).equals("sound"))
          {
            this.yoO.yoA = g(localXmlPullParser);
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
                  this.yoO.bVF = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("photoUrl"))
                {
                  this.yoO.kJw = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("birthday"))
                {
                  this.yoO.yoB = str;
                  paramString = (String)localObject;
                }
                else
                {
                  ah localah;
                  if (((String)localObject).equals("mobilePhoneNumber"))
                  {
                    localah = this.yoO;
                    if (localah.yoG == null) {
                      localah.yoG = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localah.yoG.contains(str))
                      {
                        localah.yoG.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("homePhoneNumber"))
                  {
                    localah = this.yoO;
                    if (localah.yoH == null) {
                      localah.yoH = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localah.yoH.contains(str))
                      {
                        localah.yoH.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("workPhoneNumber"))
                  {
                    localah = this.yoO;
                    if (localah.yoI == null) {
                      localah.yoI = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localah.yoI.contains(str))
                      {
                        localah.yoI.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("telAVPhoneNumber"))
                  {
                    localah = this.yoO;
                    if (localah.yoJ == null) {
                      localah.yoJ = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localah.yoJ.contains(str))
                      {
                        localah.yoJ.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("phoneNumber"))
                  {
                    localah = this.yoO;
                    if (localah.yoK == null) {
                      localah.yoK = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localah.yoK.contains(str))
                      {
                        localah.yoK.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("email"))
                  {
                    this.yoO.ePn = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("title"))
                  {
                    this.yoO.title = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("role"))
                  {
                    this.yoO.yoL = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("agent"))
                  {
                    this.yoO.yoM = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("note"))
                  {
                    this.yoO.yoN = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("url"))
                  {
                    this.yoO.url = str;
                    paramString = (String)localObject;
                  }
                  else
                  {
                    paramString = (String)localObject;
                    if (((String)localObject).equals("organization"))
                    {
                      this.yoO.kJE = str;
                      paramString = (String)localObject;
                      continue;
                      ah.yoO = this.yoO;
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
    ah.yoO = this.yoO;
    AppMethodBeat.o(51656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ai
 * JD-Core Version:    0.7.0.1
 */