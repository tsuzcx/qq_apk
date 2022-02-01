package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ecf
  extends esc
{
  public int VHj;
  public eci abhI;
  public ebu abhJ;
  public LinkedList<ebt> abhK;
  public int abhL;
  public LinkedList<fch> abhM;
  public int ytv;
  public String ytw;
  
  public ecf()
  {
    AppMethodBeat.i(91591);
    this.abhK = new LinkedList();
    this.abhM = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      if (this.abhI != null)
      {
        paramVarArgs.qD(4, this.abhI.computeSize());
        this.abhI.writeFields(paramVarArgs);
      }
      if (this.abhJ != null)
      {
        paramVarArgs.qD(5, this.abhJ.computeSize());
        this.abhJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.abhK);
      paramVarArgs.bS(7, this.abhL);
      paramVarArgs.e(8, 8, this.abhM);
      paramVarArgs.bS(9, this.VHj);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1040;
      }
    }
    label1040:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = paramInt;
      if (this.abhI != null) {
        i = paramInt + i.a.a.a.qC(4, this.abhI.computeSize());
      }
      paramInt = i;
      if (this.abhJ != null) {
        paramInt = i + i.a.a.a.qC(5, this.abhJ.computeSize());
      }
      i = i.a.a.a.c(6, 8, this.abhK);
      int j = i.a.a.b.b.a.cJ(7, this.abhL);
      int k = i.a.a.a.c(8, 8, this.abhM);
      int m = i.a.a.b.b.a.cJ(9, this.VHj);
      AppMethodBeat.o(91592);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abhK.clear();
        this.abhM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ecf localecf = (ecf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
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
            localecf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localecf.ytv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localecf.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eci)localObject2).parseFrom((byte[])localObject1);
            }
            localecf.abhI = ((eci)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebu)localObject2).parseFrom((byte[])localObject1);
            }
            localecf.abhJ = ((ebu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebt)localObject2).parseFrom((byte[])localObject1);
            }
            localecf.abhK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 7: 
          localecf.abhL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91592);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fch();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fch)localObject2).parseFrom((byte[])localObject1);
            }
            localecf.abhM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localecf.VHj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecf
 * JD-Core Version:    0.7.0.1
 */