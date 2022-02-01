package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asm
  extends com.tencent.mm.cd.a
{
  public FinderObject SFP;
  public int SFQ;
  public bfl SFR;
  public bed SFS;
  public int dataType;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.bm(2, this.id);
      if (this.SFP != null)
      {
        paramVarArgs.oE(3, this.SFP.computeSize());
        this.SFP.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.SFQ);
      if (this.SFR != null)
      {
        paramVarArgs.oE(5, this.SFR.computeSize());
        this.SFR.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.dataType);
      if (this.SFS != null)
      {
        paramVarArgs.oE(7, this.SFS.computeSize());
        this.SFS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0 + g.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.SFP != null) {
        paramInt = i + g.a.a.a.oD(3, this.SFP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SFQ);
      paramInt = i;
      if (this.SFR != null) {
        paramInt = i + g.a.a.a.oD(5, this.SFR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.dataType);
      paramInt = i;
      if (this.SFS != null) {
        paramInt = i + g.a.a.a.oD(7, this.SFS.computeSize());
      }
      AppMethodBeat.o(168953);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      asm localasm = (asm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localasm.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localasm.id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localasm.SFP = ((FinderObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localasm.SFQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168953);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bfl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bfl)localObject2).parseFrom((byte[])localObject1);
          }
          localasm.SFR = ((bfl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 6: 
        localasm.dataType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168953);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bed();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bed)localObject2).parseFrom((byte[])localObject1);
        }
        localasm.SFS = ((bed)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asm
 * JD-Core Version:    0.7.0.1
 */