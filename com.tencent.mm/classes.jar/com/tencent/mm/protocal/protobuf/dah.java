package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dah
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public erh THB;
  public LinkedList<dzm> THC;
  public int type;
  
  public dah()
  {
    AppMethodBeat.i(91548);
    this.THC = new LinkedList();
    AppMethodBeat.o(91548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.THB != null)
      {
        paramVarArgs.oE(1, this.THB.computeSize());
        this.THB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.THC);
      paramVarArgs.aY(3, this.type);
      if (this.ROQ != null) {
        paramVarArgs.f(4, this.ROQ);
      }
      AppMethodBeat.o(91549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.THB == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.THB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.THC) + g.a.a.b.b.a.bM(3, this.type);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ROQ);
      }
      AppMethodBeat.o(91549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.THC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dah localdah = (dah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91549);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localdah.THB = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzm)localObject2).parseFrom((byte[])localObject1);
            }
            localdah.THC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 3: 
          localdah.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91549);
          return 0;
        }
        localdah.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91549);
        return 0;
      }
      AppMethodBeat.o(91549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dah
 * JD-Core Version:    0.7.0.1
 */