package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class frb
  extends erp
{
  public jw Zjm;
  public String Zjn;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91720);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zjm != null)
      {
        paramVarArgs.qD(2, this.Zjm.computeSize());
        this.Zjm.writeFields(paramVarArgs);
      }
      if (this.Zjn != null) {
        paramVarArgs.g(3, this.Zjn);
      }
      paramVarArgs.bv(4, this.timestamp);
      AppMethodBeat.o(91720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zjm != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zjm.computeSize());
      }
      i = paramInt;
      if (this.Zjn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zjn);
      }
      paramInt = i.a.a.b.b.a.q(4, this.timestamp);
      AppMethodBeat.o(91720);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        frb localfrb = (frb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91720);
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
            localfrb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91720);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jw)localObject2).parseFrom((byte[])localObject1);
            }
            localfrb.Zjm = ((jw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91720);
          return 0;
        case 3: 
          localfrb.Zjn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91720);
          return 0;
        }
        localfrb.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91720);
        return 0;
      }
      AppMethodBeat.o(91720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frb
 * JD-Core Version:    0.7.0.1
 */