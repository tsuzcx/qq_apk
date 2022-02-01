package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class agf
  extends com.tencent.mm.bx.a
{
  public fjr Zpp;
  public String title;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259514);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, true);
      com.tencent.mm.bk.a.a(localJSONObject, "subContent", this.Zpp, true);
      label35:
      AppMethodBeat.o(259514);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.Zpp != null)
      {
        paramVarArgs.qD(2, this.Zpp.computeSize());
        this.Zpp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zpp != null) {
        i = paramInt + i.a.a.a.qC(2, this.Zpp.computeSize());
      }
      AppMethodBeat.o(259520);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        agf localagf = (agf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259520);
          return -1;
        case 1: 
          localagf.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259520);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fjr localfjr = new fjr();
          if ((localObject != null) && (localObject.length > 0)) {
            localfjr.parseFrom((byte[])localObject);
          }
          localagf.Zpp = localfjr;
          paramInt += 1;
        }
        AppMethodBeat.o(259520);
        return 0;
      }
      AppMethodBeat.o(259520);
      return -1;
    }
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(259525);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(259525);
      return this;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          i = -1;
        }
        switch (((String)localObject).hashCode())
        {
        case 110371416: 
          this.title = ((String)paramString.opt((String)localObject));
          continue;
          if (!((String)localObject).equals("title")) {
            break label198;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("Content", paramString, "", new Object[0]);
        AppMethodBeat.o(259525);
        return this;
      }
      int i = 0;
      break label198;
      if (((String)localObject).equals("subContent"))
      {
        i = 1;
        break label198;
        localObject = paramString.opt((String)localObject);
        if (!(localObject instanceof JSONObject)) {
          continue;
        }
        this.Zpp = ((fjr)new fjr().toPb(((JSONObject)localObject).toString()));
        continue;
      }
      label198:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agf
 * JD-Core Version:    0.7.0.1
 */