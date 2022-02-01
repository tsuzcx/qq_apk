package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class gs
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String RIC;
  public String RLF;
  public gt RLG;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(125712);
        throw paramVarArgs;
      }
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.RLF != null) {
        paramVarArgs.f(3, this.RLF);
      }
      if (this.RIC != null) {
        paramVarArgs.f(4, this.RIC);
      }
      if (this.RLG != null)
      {
        paramVarArgs.oE(5, this.RLG.computeSize());
        this.RLG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.b.b.a.g(1, this.CMP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.RLF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLF);
      }
      paramInt = i;
      if (this.RIC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RIC);
      }
      i = paramInt;
      if (this.RLG != null) {
        i = paramInt + g.a.a.a.oD(5, this.RLG.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RLG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisIcon");
          AppMethodBeat.o(125712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gs localgs = (gs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localgs.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localgs.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localgs.RLF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localgs.RIC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gt localgt = new gt();
          if ((localObject != null) && (localObject.length > 0)) {
            localgt.parseFrom((byte[])localObject);
          }
          localgs.RLG = localgt;
          paramInt += 1;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      AppMethodBeat.o(125712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gs
 * JD-Core Version:    0.7.0.1
 */