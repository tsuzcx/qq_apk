package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gz
  extends com.tencent.mm.cd.a
{
  public String RLP;
  public eyy RLQ;
  public String RLR;
  public eaz RLS;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.f(1, this.scope);
      }
      if (this.RLP != null) {
        paramVarArgs.f(2, this.RLP);
      }
      paramVarArgs.aY(3, this.state);
      if (this.RLQ != null)
      {
        paramVarArgs.oE(4, this.RLQ.computeSize());
        this.RLQ.writeFields(paramVarArgs);
      }
      if (this.RLR != null) {
        paramVarArgs.f(5, this.RLR);
      }
      if (this.RLS != null)
      {
        paramVarArgs.oE(6, this.RLS.computeSize());
        this.RLS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.b.b.a.g(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLP != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RLP);
      }
      i += g.a.a.b.b.a.bM(3, this.state);
      paramInt = i;
      if (this.RLQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.RLQ.computeSize());
      }
      i = paramInt;
      if (this.RLR != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RLR);
      }
      paramInt = i;
      if (this.RLS != null) {
        paramInt = i + g.a.a.a.oD(6, this.RLS.computeSize());
      }
      AppMethodBeat.o(147757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gz localgz = (gz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localgz.scope = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localgz.RLP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localgz.state = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eyy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eyy)localObject2).parseFrom((byte[])localObject1);
            }
            localgz.RLQ = ((eyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 5: 
          localgz.RLR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147757);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaz)localObject2).parseFrom((byte[])localObject1);
          }
          localgz.RLS = ((eaz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gz
 * JD-Core Version:    0.7.0.1
 */