package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxu
  extends com.tencent.mm.bw.a
{
  public String CoU;
  public LinkedList<String> Msu;
  public String key;
  public String value;
  
  public cxu()
  {
    AppMethodBeat.i(117535);
    this.Msu = new LinkedList();
    AppMethodBeat.o(117535);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(2, this.value);
      }
      if (this.CoU != null) {
        paramVarArgs.e(3, this.CoU);
      }
      paramVarArgs.e(4, 1, this.Msu);
      AppMethodBeat.o(117536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.b.b.a.f(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.value);
      }
      i = paramInt;
      if (this.CoU != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.CoU);
      }
      paramInt = g.a.a.a.c(4, 1, this.Msu);
      AppMethodBeat.o(117536);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Msu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117536);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxu localcxu = (cxu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117536);
          return -1;
        case 1: 
          localcxu.key = locala.UbS.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 2: 
          localcxu.value = locala.UbS.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 3: 
          localcxu.CoU = locala.UbS.readString();
          AppMethodBeat.o(117536);
          return 0;
        }
        localcxu.Msu.add(locala.UbS.readString());
        AppMethodBeat.o(117536);
        return 0;
      }
      AppMethodBeat.o(117536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxu
 * JD-Core Version:    0.7.0.1
 */