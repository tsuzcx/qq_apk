package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import org.json.JSONObject;

public final class dbh
  extends com.tencent.mm.bx.a
{
  public int aaGP;
  public int id;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259539);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "id", Integer.valueOf(this.id), true);
      com.tencent.mm.bk.a.a(localJSONObject, "positionFlag", Integer.valueOf(this.aaGP), true);
      label41:
      AppMethodBeat.o(259539);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259543);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.id);
      paramVarArgs.bS(2, this.aaGP);
      AppMethodBeat.o(259543);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.id);
      int i = i.a.a.b.b.a.cJ(2, this.aaGP);
      AppMethodBeat.o(259543);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259543);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbh localdbh = (dbh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259543);
        return -1;
      case 1: 
        localdbh.id = locala.ajGk.aar();
        AppMethodBeat.o(259543);
        return 0;
      }
      localdbh.aaGP = locala.ajGk.aar();
      AppMethodBeat.o(259543);
      return 0;
    }
    AppMethodBeat.o(259543);
    return -1;
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(259544);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(259544);
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
        case 3355: 
          this.id = ((Integer)paramString.opt(str)).intValue();
          continue;
          if (!str.equals("id")) {
            break label176;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("IconConfig", paramString, "", new Object[0]);
        AppMethodBeat.o(259544);
        return this;
      }
      int i = 0;
      break label176;
      if (str.equals("positionFlag"))
      {
        i = 1;
        break label176;
        this.aaGP = ((Integer)paramString.opt(str)).intValue();
        continue;
      }
      label176:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbh
 * JD-Core Version:    0.7.0.1
 */