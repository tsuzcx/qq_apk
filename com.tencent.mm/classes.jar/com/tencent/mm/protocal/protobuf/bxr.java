package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import org.json.JSONObject;

public final class bxr
  extends com.tencent.mm.bx.a
{
  public int aagC;
  public String show_ext_info;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258151);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "jumpPriority", Integer.valueOf(this.aagC), true);
      com.tencent.mm.bk.a.a(localJSONObject, "show_ext_info", this.show_ext_info, true);
      label38:
      AppMethodBeat.o(258151);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258154);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aagC);
      if (this.show_ext_info != null) {
        paramVarArgs.g(2, this.show_ext_info);
      }
      AppMethodBeat.o(258154);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aagC) + 0;
      paramInt = i;
      if (this.show_ext_info != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.show_ext_info);
      }
      AppMethodBeat.o(258154);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258154);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bxr localbxr = (bxr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258154);
        return -1;
      case 1: 
        localbxr.aagC = locala.ajGk.aar();
        AppMethodBeat.o(258154);
        return 0;
      }
      localbxr.show_ext_info = locala.ajGk.readString();
      AppMethodBeat.o(258154);
      return 0;
    }
    AppMethodBeat.o(258154);
    return -1;
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(258157);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(258157);
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
        case -609434638: 
          this.aagC = ((Integer)paramString.opt(str)).intValue();
          continue;
          if (!str.equals("jumpPriority")) {
            break label173;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FinderTipsShowTabExtInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(258157);
        return this;
      }
      int i = 0;
      break label173;
      if (str.equals("show_ext_info"))
      {
        i = 1;
        break label173;
        this.show_ext_info = ((String)paramString.opt(str));
        continue;
      }
      label173:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxr
 * JD-Core Version:    0.7.0.1
 */