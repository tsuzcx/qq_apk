package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dxb
  extends dyy
{
  public int TeM;
  public LinkedList<Integer> TeN;
  public LinkedList<alk> TeO;
  public int UcJ;
  
  public dxb()
  {
    AppMethodBeat.i(255901);
    this.TeO = new LinkedList();
    this.TeN = new LinkedList();
    AppMethodBeat.o(255901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255905);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(255905);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TeM);
      paramVarArgs.aY(3, this.UcJ);
      paramVarArgs.e(4, 8, this.TeO);
      paramVarArgs.e(5, 2, this.TeN);
      AppMethodBeat.o(255905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label609;
      }
    }
    label609:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TeM);
      int j = g.a.a.b.b.a.bM(3, this.UcJ);
      int k = g.a.a.a.c(4, 8, this.TeO);
      int m = g.a.a.a.c(5, 2, this.TeN);
      AppMethodBeat.o(255905);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TeO.clear();
        this.TeN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(255905);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255905);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxb localdxb = (dxb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255905);
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
            localdxb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255905);
          return 0;
        case 2: 
          localdxb.TeM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255905);
          return 0;
        case 3: 
          localdxb.UcJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255905);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alk)localObject2).parseFrom((byte[])localObject1);
            }
            localdxb.TeO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255905);
          return 0;
        }
        localdxb.TeN.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
        AppMethodBeat.o(255905);
        return 0;
      }
      AppMethodBeat.o(255905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxb
 * JD-Core Version:    0.7.0.1
 */