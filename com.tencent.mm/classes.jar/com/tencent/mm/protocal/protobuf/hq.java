package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class hq
  extends com.tencent.mm.bx.a
{
  public agf YIX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257952);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "content", this.YIX, true);
      label24:
      AppMethodBeat.o(257952);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257956);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIX != null)
      {
        paramVarArgs.qD(1, this.YIX.computeSize());
        this.YIX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIX == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.YIX.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(257956);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hq localhq = (hq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257956);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          agf localagf = new agf();
          if ((localObject != null) && (localObject.length > 0)) {
            localagf.parseFrom((byte[])localObject);
          }
          localhq.YIX = localagf;
          paramInt += 1;
        }
        AppMethodBeat.o(257956);
        return 0;
      }
      AppMethodBeat.o(257956);
      return -1;
    }
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(257959);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(257959);
      return this;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        Object localObject;
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          i = -1;
        }
        switch (((String)localObject).hashCode())
        {
        case 951530617: 
          localObject = paramString.opt((String)localObject);
          if (!(localObject instanceof JSONObject)) {
            continue;
          }
          this.YIX = ((agf)new agf().toPb(((JSONObject)localObject).toString()));
          continue;
          bool = ((String)localObject).equals("content");
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("AttributeTitle", paramString, "", new Object[0]);
        AppMethodBeat.o(257959);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hq
 * JD-Core Version:    0.7.0.1
 */