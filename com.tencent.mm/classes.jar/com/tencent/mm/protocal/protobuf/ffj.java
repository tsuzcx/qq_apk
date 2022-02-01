package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffj
  extends erp
{
  public String IKH;
  public int YIq;
  public long abES;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125824);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.bv(3, this.abES);
      if (this.IKH != null) {
        paramVarArgs.g(4, this.IKH);
      }
      AppMethodBeat.o(125824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label432;
      }
    }
    label432:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + i.a.a.b.b.a.q(3, this.abES);
      paramInt = i;
      if (this.IKH != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKH);
      }
      AppMethodBeat.o(125824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ffj localffj = (ffj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125824);
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
            localffj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125824);
          return 0;
        case 2: 
          localffj.YIq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125824);
          return 0;
        case 3: 
          localffj.abES = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125824);
          return 0;
        }
        localffj.IKH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(125824);
        return 0;
      }
      AppMethodBeat.o(125824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffj
 * JD-Core Version:    0.7.0.1
 */