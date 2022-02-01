package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyq
  extends erp
{
  public long ZnE;
  public String abWb;
  public String abWc;
  public LinkedList<fyy> abWr;
  public fyy abWs;
  public LinkedList<fys> abWt;
  
  public fyq()
  {
    AppMethodBeat.i(257632);
    this.abWt = new LinkedList();
    this.abWr = new LinkedList();
    AppMethodBeat.o(257632);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abWb != null) {
        paramVarArgs.g(2, this.abWb);
      }
      if (this.abWs != null)
      {
        paramVarArgs.qD(3, this.abWs.computeSize());
        this.abWs.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(4, this.ZnE);
      if (this.abWc != null) {
        paramVarArgs.g(5, this.abWc);
      }
      paramVarArgs.e(6, 8, this.abWt);
      paramVarArgs.e(7, 8, this.abWr);
      AppMethodBeat.o(257636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label822;
      }
    }
    label822:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abWb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abWb);
      }
      i = paramInt;
      if (this.abWs != null) {
        i = paramInt + i.a.a.a.qC(3, this.abWs.computeSize());
      }
      i += i.a.a.b.b.a.q(4, this.ZnE);
      paramInt = i;
      if (this.abWc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abWc);
      }
      i = i.a.a.a.c(6, 8, this.abWt);
      int j = i.a.a.a.c(7, 8, this.abWr);
      AppMethodBeat.o(257636);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWt.clear();
        this.abWr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fyq localfyq = (fyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257636);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfyq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257636);
          return 0;
        case 2: 
          localfyq.abWb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257636);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fyy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fyy)localObject2).parseFrom((byte[])localObject1);
            }
            localfyq.abWs = ((fyy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257636);
          return 0;
        case 4: 
          localfyq.ZnE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257636);
          return 0;
        case 5: 
          localfyq.abWc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257636);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fys();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fys)localObject2).parseFrom((byte[])localObject1);
            }
            localfyq.abWt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257636);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fyy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fyy)localObject2).parseFrom((byte[])localObject1);
          }
          localfyq.abWr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257636);
        return 0;
      }
      AppMethodBeat.o(257636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyq
 * JD-Core Version:    0.7.0.1
 */