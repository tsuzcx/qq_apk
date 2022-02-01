package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctd
  extends com.tencent.mm.cd.a
{
  public cte TAV;
  public cte TAW;
  public cte TAY;
  public int style;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.f(1, this.wording);
      }
      paramVarArgs.aY(2, this.style);
      if (this.TAV != null)
      {
        paramVarArgs.oE(3, this.TAV.computeSize());
        this.TAV.writeFields(paramVarArgs);
      }
      if (this.TAW != null)
      {
        paramVarArgs.oE(4, this.TAW.computeSize());
        this.TAW.writeFields(paramVarArgs);
      }
      if (this.TAY != null)
      {
        paramVarArgs.oE(5, this.TAY.computeSize());
        this.TAY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(250479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = g.a.a.b.b.a.g(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.style);
      paramInt = i;
      if (this.TAV != null) {
        paramInt = i + g.a.a.a.oD(3, this.TAV.computeSize());
      }
      i = paramInt;
      if (this.TAW != null) {
        i = paramInt + g.a.a.a.oD(4, this.TAW.computeSize());
      }
      paramInt = i;
      if (this.TAY != null) {
        paramInt = i + g.a.a.a.oD(5, this.TAY.computeSize());
      }
      AppMethodBeat.o(250479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ctd localctd = (ctd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        cte localcte;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250479);
          return -1;
        case 1: 
          localctd.wording = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250479);
          return 0;
        case 2: 
          localctd.style = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(250479);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcte = new cte();
            if ((localObject != null) && (localObject.length > 0)) {
              localcte.parseFrom((byte[])localObject);
            }
            localctd.TAV = localcte;
            paramInt += 1;
          }
          AppMethodBeat.o(250479);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localcte = new cte();
            if ((localObject != null) && (localObject.length > 0)) {
              localcte.parseFrom((byte[])localObject);
            }
            localctd.TAW = localcte;
            paramInt += 1;
          }
          AppMethodBeat.o(250479);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcte = new cte();
          if ((localObject != null) && (localObject.length > 0)) {
            localcte.parseFrom((byte[])localObject);
          }
          localctd.TAY = localcte;
          paramInt += 1;
        }
        AppMethodBeat.o(250479);
        return 0;
      }
      AppMethodBeat.o(250479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctd
 * JD-Core Version:    0.7.0.1
 */