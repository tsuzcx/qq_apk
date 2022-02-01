package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class aj
{
  private ai yEN;
  
  public aj()
  {
    AppMethodBeat.i(51655);
    this.yEN = new ai();
    AppMethodBeat.o(51655);
  }
  
  private static ai.a f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51657);
    paramXmlPullParser = new ai.a(paramXmlPullParser.getAttributeValue(null, "postOfficeBox"), paramXmlPullParser.getAttributeValue(null, "extendedAddress"), paramXmlPullParser.getAttributeValue(null, "street"), paramXmlPullParser.getAttributeValue(null, "locality"), paramXmlPullParser.getAttributeValue(null, "region"), paramXmlPullParser.getAttributeValue(null, "postalCode"), paramXmlPullParser.getAttributeValue(null, "country"));
    AppMethodBeat.o(51657);
    return paramXmlPullParser;
  }
  
  private static ai.c g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(51658);
    paramXmlPullParser = new ai.c(paramXmlPullParser.getAttributeValue(null, "type"), paramXmlPullParser.getAttributeValue(null, "buffer"));
    AppMethodBeat.o(51658);
    return paramXmlPullParser;
  }
  
  public final void aya(String paramString)
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
          this.yEN.yEw = new ai.b(localXmlPullParser.getAttributeValue(null, "firstName"), localXmlPullParser.getAttributeValue(null, "middleName"), localXmlPullParser.getAttributeValue(null, "lastName"));
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("address"))
        {
          this.yEN.yEB = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("deliveryAddress"))
        {
          this.yEN.yEC = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("homeAddress"))
        {
          this.yEN.yED = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("workAddress"))
        {
          this.yEN.yEE = f(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("photo"))
        {
          this.yEN.yEx = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else if (((String)localObject).equals("logo"))
        {
          this.yEN.yEy = g(localXmlPullParser);
          paramString = (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).equals("sound"))
          {
            this.yEN.yEz = g(localXmlPullParser);
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
                  this.yEN.bVF = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("photoUrl"))
                {
                  this.yEN.kML = str;
                  paramString = (String)localObject;
                }
                else if (((String)localObject).equals("birthday"))
                {
                  this.yEN.yEA = str;
                  paramString = (String)localObject;
                }
                else
                {
                  ai localai;
                  if (((String)localObject).equals("mobilePhoneNumber"))
                  {
                    localai = this.yEN;
                    if (localai.yEF == null) {
                      localai.yEF = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localai.yEF.contains(str))
                      {
                        localai.yEF.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("homePhoneNumber"))
                  {
                    localai = this.yEN;
                    if (localai.yEG == null) {
                      localai.yEG = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localai.yEG.contains(str))
                      {
                        localai.yEG.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("workPhoneNumber"))
                  {
                    localai = this.yEN;
                    if (localai.yEH == null) {
                      localai.yEH = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localai.yEH.contains(str))
                      {
                        localai.yEH.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("telAVPhoneNumber"))
                  {
                    localai = this.yEN;
                    if (localai.yEI == null) {
                      localai.yEI = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localai.yEI.contains(str))
                      {
                        localai.yEI.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("phoneNumber"))
                  {
                    localai = this.yEN;
                    if (localai.yEJ == null) {
                      localai.yEJ = new ArrayList();
                    }
                    paramString = (String)localObject;
                    if (str != null)
                    {
                      paramString = (String)localObject;
                      if (!localai.yEJ.contains(str))
                      {
                        localai.yEJ.add(str);
                        paramString = (String)localObject;
                      }
                    }
                  }
                  else if (((String)localObject).equals("email"))
                  {
                    this.yEN.eQY = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("title"))
                  {
                    this.yEN.title = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("role"))
                  {
                    this.yEN.yEK = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("agent"))
                  {
                    this.yEN.yEL = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("note"))
                  {
                    this.yEN.yEM = str;
                    paramString = (String)localObject;
                  }
                  else if (((String)localObject).equals("url"))
                  {
                    this.yEN.url = str;
                    paramString = (String)localObject;
                  }
                  else
                  {
                    paramString = (String)localObject;
                    if (((String)localObject).equals("organization"))
                    {
                      this.yEN.kMT = str;
                      paramString = (String)localObject;
                      continue;
                      ai.yEN = this.yEN;
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
    ai.yEN = this.yEN;
    AppMethodBeat.o(51656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aj
 * JD-Core Version:    0.7.0.1
 */