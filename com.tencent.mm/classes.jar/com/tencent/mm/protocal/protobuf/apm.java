package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class apm
  extends erp
{
  public b ZwK;
  public int ZwL;
  public int ZwM;
  public int hId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZwK != null) {
        paramVarArgs.d(2, this.ZwK);
      }
      paramVarArgs.bS(3, this.ZwL);
      paramVarArgs.bS(4, this.hId);
      paramVarArgs.bS(5, this.ZwM);
      AppMethodBeat.o(259456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZwK != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZwK);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZwL);
      int j = i.a.a.b.b.a.cJ(4, this.hId);
      int k = i.a.a.b.b.a.cJ(5, this.ZwM);
      AppMethodBeat.o(259456);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apm localapm = (apm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259456);
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
            localapm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259456);
          return 0;
        case 2: 
          localapm.ZwK = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259456);
          return 0;
        case 3: 
          localapm.ZwL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259456);
          return 0;
        case 4: 
          localapm.hId = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259456);
          return 0;
        }
        localapm.ZwM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259456);
        return 0;
      }
      AppMethodBeat.o(259456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apm
 * JD-Core Version:    0.7.0.1
 */