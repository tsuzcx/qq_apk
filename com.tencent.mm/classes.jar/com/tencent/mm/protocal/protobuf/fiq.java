package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fiq
  extends esc
{
  public int aaiS;
  public String abDu;
  public int abFi;
  public long abJj;
  public int abJv;
  public LinkedList<fio> abJw;
  
  public fiq()
  {
    AppMethodBeat.i(118450);
    this.abJw = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bS(3, this.abJv);
      paramVarArgs.e(4, 8, this.abJw);
      paramVarArgs.bS(5, this.abFi);
      paramVarArgs.bv(6, this.abJj);
      paramVarArgs.bS(7, this.aaiS);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abJv);
      int j = i.a.a.a.c(4, 8, this.abJw);
      int k = i.a.a.b.b.a.cJ(5, this.abFi);
      int m = i.a.a.b.b.a.q(6, this.abJj);
      int n = i.a.a.b.b.a.cJ(7, this.aaiS);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abJw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fiq localfiq = (fiq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfiq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localfiq.abDu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localfiq.abJv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fio();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fio)localObject2).parseFrom((byte[])localObject1);
            }
            localfiq.abJw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localfiq.abFi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localfiq.abJj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(118451);
          return 0;
        }
        localfiq.aaiS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fiq
 * JD-Core Version:    0.7.0.1
 */