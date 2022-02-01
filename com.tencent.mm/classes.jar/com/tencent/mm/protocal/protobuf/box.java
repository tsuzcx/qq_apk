package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class box
  extends dyy
{
  public int Svi;
  public LinkedList<com.tencent.mm.cd.b> TaK;
  public int TaL;
  public LinkedList<Integer> TaM;
  
  public box()
  {
    AppMethodBeat.i(153147);
    this.TaK = new LinkedList();
    this.TaM = new LinkedList();
    AppMethodBeat.o(153147);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153148);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153148);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.TaK);
      paramVarArgs.aY(3, this.TaL);
      paramVarArgs.aY(4, this.Svi);
      paramVarArgs.e(5, 2, this.TaM);
      AppMethodBeat.o(153148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label551;
      }
    }
    label551:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 6, this.TaK);
      int j = g.a.a.b.b.a.bM(3, this.TaL);
      int k = g.a.a.b.b.a.bM(4, this.Svi);
      int m = g.a.a.a.c(5, 2, this.TaM);
      AppMethodBeat.o(153148);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TaK.clear();
        this.TaM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        box localbox = (box)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153148);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbox.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(153148);
          return 0;
        case 2: 
          localbox.TaK.add(((g.a.a.a.a)localObject).abFh.iUw());
          AppMethodBeat.o(153148);
          return 0;
        case 3: 
          localbox.TaL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153148);
          return 0;
        case 4: 
          localbox.Svi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153148);
          return 0;
        }
        localbox.TaM.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
        AppMethodBeat.o(153148);
        return 0;
      }
      AppMethodBeat.o(153148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.box
 * JD-Core Version:    0.7.0.1
 */