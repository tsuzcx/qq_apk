package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fda
  extends dyy
{
  public int Svu;
  public long Svv;
  public int UCE;
  public int UCN;
  public fep UCO;
  public int UCP;
  public int UCQ;
  public int UCR;
  public int UCS;
  public eae UCT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.UCN);
      if (this.UCO != null)
      {
        paramVarArgs.oE(5, this.UCO.computeSize());
        this.UCO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.UCE);
      paramVarArgs.aY(7, this.UCP);
      paramVarArgs.aY(8, this.UCQ);
      paramVarArgs.aY(9, this.UCR);
      paramVarArgs.aY(10, this.UCS);
      if (this.UCT != null)
      {
        paramVarArgs.oE(11, this.UCT.computeSize());
        this.UCT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label952;
      }
    }
    label952:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.UCN);
      paramInt = i;
      if (this.UCO != null) {
        paramInt = i + g.a.a.a.oD(5, this.UCO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UCE) + g.a.a.b.b.a.bM(7, this.UCP) + g.a.a.b.b.a.bM(8, this.UCQ) + g.a.a.b.b.a.bM(9, this.UCR) + g.a.a.b.b.a.bM(10, this.UCS);
      paramInt = i;
      if (this.UCT != null) {
        paramInt = i + g.a.a.a.oD(11, this.UCT.computeSize());
      }
      AppMethodBeat.o(115859);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fda localfda = (fda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localfda.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localfda.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localfda.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localfda.UCN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fep();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fep)localObject2).parseFrom((byte[])localObject1);
            }
            localfda.UCO = ((fep)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localfda.UCE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localfda.UCP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localfda.UCQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localfda.UCR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localfda.UCS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localfda.UCT = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fda
 * JD-Core Version:    0.7.0.1
 */