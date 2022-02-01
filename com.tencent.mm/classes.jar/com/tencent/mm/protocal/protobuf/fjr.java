package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import org.json.JSONObject;

public final class fjr
  extends com.tencent.mm.bx.a
{
  public String abKn;
  public String abKo;
  public String iconUrl;
  public String uCW;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259513);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "subTitle", this.uCW, true);
      com.tencent.mm.bk.a.a(localJSONObject, "iconUrl", this.iconUrl, true);
      com.tencent.mm.bk.a.a(localJSONObject, "lightColor", this.abKn, true);
      com.tencent.mm.bk.a.a(localJSONObject, "darkColor", this.abKo, true);
      label57:
      AppMethodBeat.o(259513);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259515);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.uCW != null) {
        paramVarArgs.g(1, this.uCW);
      }
      if (this.iconUrl != null) {
        paramVarArgs.g(2, this.iconUrl);
      }
      if (this.abKn != null) {
        paramVarArgs.g(3, this.abKn);
      }
      if (this.abKo != null) {
        paramVarArgs.g(4, this.abKo);
      }
      AppMethodBeat.o(259515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uCW == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.uCW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.iconUrl);
      }
      i = paramInt;
      if (this.abKn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abKn);
      }
      paramInt = i;
      if (this.abKo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abKo);
      }
      AppMethodBeat.o(259515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259515);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fjr localfjr = (fjr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259515);
          return -1;
        case 1: 
          localfjr.uCW = locala.ajGk.readString();
          AppMethodBeat.o(259515);
          return 0;
        case 2: 
          localfjr.iconUrl = locala.ajGk.readString();
          AppMethodBeat.o(259515);
          return 0;
        case 3: 
          localfjr.abKn = locala.ajGk.readString();
          AppMethodBeat.o(259515);
          return 0;
        }
        localfjr.abKo = locala.ajGk.readString();
        AppMethodBeat.o(259515);
        return 0;
      }
      AppMethodBeat.o(259515);
      return -1;
    }
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(259522);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(259522);
      return this;
    }
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          i = -1;
        }
        switch (str.hashCode())
        {
        case -2090050568: 
          this.uCW = ((String)paramString.opt(str));
          continue;
          if (!str.equals("subTitle")) {
            break label248;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("SubContent", paramString, "", new Object[0]);
        AppMethodBeat.o(259522);
        return this;
      }
      int i = 0;
      break label248;
      if (str.equals("iconUrl"))
      {
        i = 1;
        break label248;
        if (str.equals("lightColor"))
        {
          i = 2;
          break label248;
          if (str.equals("darkColor"))
          {
            i = 3;
            break label248;
            this.iconUrl = ((String)paramString.opt(str));
            continue;
            this.abKn = ((String)paramString.opt(str));
            continue;
            this.abKo = ((String)paramString.opt(str));
            continue;
          }
        }
      }
      label248:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjr
 * JD-Core Version:    0.7.0.1
 */