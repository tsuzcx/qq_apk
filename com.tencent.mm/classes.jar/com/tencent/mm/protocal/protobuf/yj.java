package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yj
  extends dyy
{
  public LinkedList<yk> Sku;
  public String fAo;
  public String kwF;
  public int niJ;
  
  public yj()
  {
    AppMethodBeat.i(186779);
    this.Sku = new LinkedList();
    AppMethodBeat.o(186779);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186786);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Sku);
      if (this.fAo != null) {
        paramVarArgs.f(3, this.fAo);
      }
      paramVarArgs.aY(4, this.niJ);
      if (this.kwF != null) {
        paramVarArgs.f(5, this.kwF);
      }
      AppMethodBeat.o(186786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Sku);
      paramInt = i;
      if (this.fAo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fAo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.niJ);
      paramInt = i;
      if (this.kwF != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.kwF);
      }
      AppMethodBeat.o(186786);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sku.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yj localyj = (yj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(186786);
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
            localyj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(186786);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new yk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((yk)localObject2).parseFrom((byte[])localObject1);
            }
            localyj.Sku.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(186786);
          return 0;
        case 3: 
          localyj.fAo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(186786);
          return 0;
        case 4: 
          localyj.niJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(186786);
          return 0;
        }
        localyj.kwF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(186786);
        return 0;
      }
      AppMethodBeat.o(186786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yj
 * JD-Core Version:    0.7.0.1
 */