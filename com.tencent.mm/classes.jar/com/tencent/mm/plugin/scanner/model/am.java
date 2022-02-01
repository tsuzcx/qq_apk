package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class am
{
  private al CHN;
  
  public am()
  {
    AppMethodBeat.i(51655);
    this.CHN = new al();
    AppMethodBeat.o(51655);
  }
  
  private static al.a g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51657);
    paramXmlPullParser = new al.a(paramXmlPullParser.getAttributeValue(null, "postOfficeBox"), paramXmlPullParser.getAttributeValue(null, "extendedAddress"), paramXmlPullParser.getAttributeValue(null, "street"), paramXmlPullParser.getAttributeValue(null, "locality"), paramXmlPullParser.getAttributeValue(null, "region"), paramXmlPullParser.getAttributeValue(null, "postalCode"), paramXmlPullParser.getAttributeValue(null, "country"));
    AppMethodBeat.o(51657);
    return paramXmlPullParser;
  }
  
  private static al.c h(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51658);
    paramXmlPullParser = new al.c(paramXmlPullParser.getAttributeValue(null, "type"), paramXmlPullParser.getAttributeValue(null, "buffer"));
    AppMethodBeat.o(51658);
    return paramXmlPullParser;
  }
  
  public final void aME(String paramString)
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
          this.CHN.CHw = new al.b(localXmlPullParser.getAttributeValue(null, "firstName"), localXmlPullParser.getAttributeValue(null, "middleName"), localXmlPullParser.getAttributeValue(null, "lastName"));
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("address"))
        {
          this.CHN.CHB = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("deliveryAddress"))
        {
          this.CHN.CHC = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("homeAddress"))
        {
          this.CHN.CHD = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("workAddress"))
        {
          this.CHN.CHE = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("photo"))
        {
          this.CHN.CHx = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("logo"))
        {
          this.CHN.CHy = h(localXmlPullParser);
          paramString = (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).equals("sound"))
          {
            this.CHN.CHz = h(localXmlPullParser);
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
                  this.CHN.nickName = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("photoUrl"))
                {
                  this.CHN.lRD = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("birthday"))
                {
                  this.CHN.CHA = str;
                  paramString = (String)localObject;
                }
                else
                {
                  al localal;
                  if (((String)localObject).equals("mobilePhoneNumber"))
                  {
                    localal = this.CHN;
                    if (localal.CHF == null) {
                      localal.CHF = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localal.CHF.contains(str))
                      {
                        localal.CHF.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("homePhoneNumber"))
                  {
                    localal = this.CHN;
                    if (localal.CHG == null) {
                      localal.CHG = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localal.CHG.contains(str))
                      {
                        localal.CHG.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("workPhoneNumber"))
                  {
                    localal = this.CHN;
                    if (localal.CHH == null) {
                      localal.CHH = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localal.CHH.contains(str))
                      {
                        localal.CHH.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("telAVPhoneNumber"))
                  {
                    localal = this.CHN;
                    if (localal.CHI == null) {
                      localal.CHI = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localal.CHI.contains(str))
                      {
                        localal.CHI.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("phoneNumber"))
                  {
                    localal = this.CHN;
                    if (localal.CHJ == null) {
                      localal.CHJ = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localal.CHJ.contains(str))
                      {
                        localal.CHJ.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("email"))
                  {
                    this.CHN.fuD = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("title"))
                  {
                    this.CHN.title = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("role"))
                  {
                    this.CHN.CHK = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("agent"))
                  {
                    this.CHN.CHL = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("note"))
                  {
                    this.CHN.CHM = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("url"))
                  {
                    this.CHN.url = str;
                    paramString = (String)localObject;
                  }
                  else
                  {
                    paramString = (String)localObject;
                    if (((String)localObject).equals("organization"))
                    {
                      this.CHN.lRL = str;
                      paramString = (String)localObject;
                      continue;
                      al.CHN = this.CHN;
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
    al.CHN = this.CHN;
    AppMethodBeat.o(51656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.am
 * JD-Core Version:    0.7.0.1
 */