package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fhv
  extends com.tencent.mm.cd.a
{
  public String UHJ;
  public tj UHK;
  public boolean UHL;
  public String UHM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UHJ != null) {
        paramVarArgs.f(1, this.UHJ);
      }
      if (this.UHK != null)
      {
        paramVarArgs.oE(2, this.UHK.computeSize());
        this.UHK.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.UHL);
      if (this.UHM != null) {
        paramVarArgs.f(4, this.UHM);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UHJ == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.b.b.a.g(1, this.UHJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UHK != null) {
        i = paramInt + g.a.a.a.oD(2, this.UHK.computeSize());
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.UHM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UHM);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fhv localfhv = (fhv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localfhv.UHJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            tj localtj = new tj();
            if ((localObject != null) && (localObject.length > 0)) {
              localtj.parseFrom((byte[])localObject);
            }
            localfhv.UHK = localtj;
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localfhv.UHL = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(91731);
          return 0;
        }
        localfhv.UHM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhv
 * JD-Core Version:    0.7.0.1
 */