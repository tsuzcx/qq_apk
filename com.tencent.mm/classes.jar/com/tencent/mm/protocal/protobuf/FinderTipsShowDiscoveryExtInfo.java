package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import org.json.JSONObject;

public class FinderTipsShowDiscoveryExtInfo
  extends com.tencent.mm.bx.a
{
  public String show_ext_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.show_ext_info != null) {
        paramVarArgs.g(1, this.show_ext_info);
      }
      AppMethodBeat.o(257333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.show_ext_info == null) {
        break label209;
      }
    }
    label209:
    for (paramInt = i.a.a.b.b.a.h(1, this.show_ext_info) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(257333);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257333);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        FinderTipsShowDiscoveryExtInfo localFinderTipsShowDiscoveryExtInfo = (FinderTipsShowDiscoveryExtInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257333);
          return -1;
        }
        localFinderTipsShowDiscoveryExtInfo.show_ext_info = locala.ajGk.readString();
        AppMethodBeat.o(257333);
        return 0;
      }
      AppMethodBeat.o(257333);
      return -1;
    }
  }
  
  public JSONObject toJSON()
  {
    AppMethodBeat.i(257334);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "show_ext_info", this.show_ext_info, true);
      label24:
      AppMethodBeat.o(257334);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(257336);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(257336);
      return this;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        String str;
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          i = -1;
        }
        switch (str.hashCode())
        {
        case -86367474: 
          this.show_ext_info = ((String)paramString.opt(str));
          continue;
          bool = str.equals("show_ext_info");
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FinderTipsShowDiscoveryExtInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(257336);
        return this;
      }
      boolean bool;
      if (bool) {
        i = 0;
      }
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderTipsShowDiscoveryExtInfo
 * JD-Core Version:    0.7.0.1
 */