package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class auo
  extends erp
{
  public b ZEV;
  public LinkedList<Long> hrX;
  
  public auo()
  {
    AppMethodBeat.i(257748);
    this.hrX = new LinkedList();
    AppMethodBeat.o(257748);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257752);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEV != null) {
        paramVarArgs.d(2, this.ZEV);
      }
      paramVarArgs.e(3, 3, this.hrX);
      AppMethodBeat.o(257752);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label407;
      }
    }
    label407:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEV != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEV);
      }
      paramInt = i.a.a.a.c(3, 3, this.hrX);
      AppMethodBeat.o(257752);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hrX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257752);
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
            localauo.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257752);
          return 0;
        case 2: 
          localauo.ZEV = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(257752);
          return 0;
        }
        localauo.hrX.add(Long.valueOf(((i.a.a.a.a)localObject).ajGk.aaw()));
        AppMethodBeat.o(257752);
        return 0;
      }
      AppMethodBeat.o(257752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */