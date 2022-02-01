package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bcl
  extends dyy
{
  public b SDI;
  public LinkedList<bbg> SKG;
  public int xFI;
  
  public bcl()
  {
    AppMethodBeat.i(231424);
    this.SKG = new LinkedList();
    AppMethodBeat.o(231424);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SKG);
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.aY(4, this.xFI);
      AppMethodBeat.o(231426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SKG);
      paramInt = i;
      if (this.SDI != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = g.a.a.b.b.a.bM(4, this.xFI);
      AppMethodBeat.o(231426);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SKG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcl localbcl = (bcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231426);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbcl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231426);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbg)localObject2).parseFrom((byte[])localObject1);
            }
            localbcl.SKG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231426);
          return 0;
        case 3: 
          localbcl.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231426);
          return 0;
        }
        localbcl.xFI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(231426);
        return 0;
      }
      AppMethodBeat.o(231426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcl
 * JD-Core Version:    0.7.0.1
 */