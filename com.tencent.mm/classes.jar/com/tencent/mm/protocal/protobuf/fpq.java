package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpq
  extends erp
{
  public String abPu;
  public String abPw;
  public int abvn;
  public String wsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72597);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wsM != null) {
        paramVarArgs.g(2, this.wsM);
      }
      if (this.abPu != null) {
        paramVarArgs.g(3, this.abPu);
      }
      if (this.abPw != null) {
        paramVarArgs.g(4, this.abPw);
      }
      paramVarArgs.bS(5, this.abvn);
      AppMethodBeat.o(72597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wsM);
      }
      i = paramInt;
      if (this.abPu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abPu);
      }
      paramInt = i;
      if (this.abPw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abPw);
      }
      i = i.a.a.b.b.a.cJ(5, this.abvn);
      AppMethodBeat.o(72597);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fpq localfpq = (fpq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72597);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localfpq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72597);
          return 0;
        case 2: 
          localfpq.wsM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72597);
          return 0;
        case 3: 
          localfpq.abPu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72597);
          return 0;
        case 4: 
          localfpq.abPw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72597);
          return 0;
        }
        localfpq.abvn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72597);
        return 0;
      }
      AppMethodBeat.o(72597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpq
 * JD-Core Version:    0.7.0.1
 */