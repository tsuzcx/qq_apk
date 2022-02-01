package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ceq
  extends esc
{
  public int aaoD;
  public String aaoE;
  public String aaoF;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91476);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.aaoD);
      if (this.aaoE != null) {
        paramVarArgs.g(5, this.aaoE);
      }
      if (this.aaoF != null) {
        paramVarArgs.g(6, this.aaoF);
      }
      AppMethodBeat.o(91476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aaoD);
      paramInt = i;
      if (this.aaoE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaoE);
      }
      i = paramInt;
      if (this.aaoF != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaoF);
      }
      AppMethodBeat.o(91476);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ceq localceq = (ceq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91476);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localceq.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91476);
          return 0;
        case 2: 
          localceq.wuz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91476);
          return 0;
        case 3: 
          localceq.wuA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91476);
          return 0;
        case 4: 
          localceq.aaoD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91476);
          return 0;
        case 5: 
          localceq.aaoE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91476);
          return 0;
        }
        localceq.aaoF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91476);
        return 0;
      }
      AppMethodBeat.o(91476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceq
 * JD-Core Version:    0.7.0.1
 */