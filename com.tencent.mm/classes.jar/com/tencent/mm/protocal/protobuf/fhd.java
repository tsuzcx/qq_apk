package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fhd
  extends com.tencent.mm.cd.a
{
  public String RRu;
  public String RRv;
  public eae RRy;
  public String UHm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RRy == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.RRu != null) {
        paramVarArgs.f(1, this.RRu);
      }
      if (this.RRv != null) {
        paramVarArgs.f(2, this.RRv);
      }
      if (this.UHm != null) {
        paramVarArgs.f(3, this.UHm);
      }
      if (this.RRy != null)
      {
        paramVarArgs.oE(4, this.RRy.computeSize());
        this.RRy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RRu == null) {
        break label516;
      }
    }
    label516:
    for (int i = g.a.a.b.b.a.g(1, this.RRu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RRv);
      }
      i = paramInt;
      if (this.UHm != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UHm);
      }
      paramInt = i;
      if (this.RRy != null) {
        paramInt = i + g.a.a.a.oD(4, this.RRy.computeSize());
      }
      AppMethodBeat.o(133206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RRy == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fhd localfhd = (fhd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localfhd.RRu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localfhd.RRv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localfhd.UHm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(133206);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eae localeae = new eae();
          if ((localObject != null) && (localObject.length > 0)) {
            localeae.dd((byte[])localObject);
          }
          localfhd.RRy = localeae;
          paramInt += 1;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      AppMethodBeat.o(133206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhd
 * JD-Core Version:    0.7.0.1
 */