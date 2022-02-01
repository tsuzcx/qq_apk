package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import org.json.JSONObject;

public final class adf
  extends com.tencent.mm.bx.a
{
  public int ZlK;
  public String ZlL;
  public long ZlM;
  public int ZlN;
  public long ZlO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257666);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "expose_count", Integer.valueOf(this.ZlK), true);
      com.tencent.mm.bk.a.a(localJSONObject, "oob", this.ZlL, true);
      com.tencent.mm.bk.a.a(localJSONObject, "first_expose_time", Long.valueOf(this.ZlM), true);
      com.tencent.mm.bk.a.a(localJSONObject, "had_sync_for_cold_time", Integer.valueOf(this.ZlN), true);
      com.tencent.mm.bk.a.a(localJSONObject, "last_expose_time", Long.valueOf(this.ZlO), true);
      label80:
      AppMethodBeat.o(257666);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZlK);
      if (this.ZlL != null) {
        paramVarArgs.g(2, this.ZlL);
      }
      paramVarArgs.bv(3, this.ZlM);
      paramVarArgs.bS(100, this.ZlN);
      paramVarArgs.bv(101, this.ZlO);
      AppMethodBeat.o(257671);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZlK) + 0;
      paramInt = i;
      if (this.ZlL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZlL);
      }
      i = i.a.a.b.b.a.q(3, this.ZlM);
      int j = i.a.a.b.b.a.cJ(100, this.ZlN);
      int k = i.a.a.b.b.a.q(101, this.ZlO);
      AppMethodBeat.o(257671);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257671);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      adf localadf = (adf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257671);
        return -1;
      case 1: 
        localadf.ZlK = locala.ajGk.aar();
        AppMethodBeat.o(257671);
        return 0;
      case 2: 
        localadf.ZlL = locala.ajGk.readString();
        AppMethodBeat.o(257671);
        return 0;
      case 3: 
        localadf.ZlM = locala.ajGk.aaw();
        AppMethodBeat.o(257671);
        return 0;
      case 100: 
        localadf.ZlN = locala.ajGk.aar();
        AppMethodBeat.o(257671);
        return 0;
      }
      localadf.ZlO = locala.ajGk.aaw();
      AppMethodBeat.o(257671);
      return 0;
    }
    AppMethodBeat.o(257671);
    return -1;
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(257674);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(257674);
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
        case 785900756: 
          this.ZlK = ((Integer)paramString.opt(str)).intValue();
          continue;
          if (!str.equals("expose_count")) {
            break label299;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("ClientStatsInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(257674);
        return this;
      }
      int i = 0;
      break label299;
      if (str.equals("oob"))
      {
        i = 1;
        break label299;
        if (str.equals("first_expose_time"))
        {
          i = 2;
          break label299;
          if (str.equals("had_sync_for_cold_time"))
          {
            i = 3;
            break label299;
            if (str.equals("last_expose_time"))
            {
              i = 4;
              break label299;
              this.ZlL = ((String)paramString.opt(str));
              continue;
              this.ZlM = ((Long)paramString.opt(str)).longValue();
              continue;
              this.ZlN = ((Integer)paramString.opt(str)).intValue();
              continue;
              this.ZlO = ((Long)paramString.opt(str)).longValue();
              continue;
            }
          }
        }
      }
      label299:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adf
 * JD-Core Version:    0.7.0.1
 */