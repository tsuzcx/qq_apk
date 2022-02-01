package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class frh
  extends erp
{
  public String CAf;
  public String KuQ;
  public int abQU;
  public String wXY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259950);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CAf != null) {
        paramVarArgs.g(2, this.CAf);
      }
      if (this.wXY != null) {
        paramVarArgs.g(3, this.wXY);
      }
      if (this.KuQ != null) {
        paramVarArgs.g(4, this.KuQ);
      }
      paramVarArgs.bS(5, this.abQU);
      AppMethodBeat.o(259950);
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
      if (this.CAf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.CAf);
      }
      i = paramInt;
      if (this.wXY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wXY);
      }
      paramInt = i;
      if (this.KuQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.KuQ);
      }
      i = i.a.a.b.b.a.cJ(5, this.abQU);
      AppMethodBeat.o(259950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        frh localfrh = (frh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259950);
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
            localfrh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259950);
          return 0;
        case 2: 
          localfrh.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259950);
          return 0;
        case 3: 
          localfrh.wXY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259950);
          return 0;
        case 4: 
          localfrh.KuQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259950);
          return 0;
        }
        localfrh.abQU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259950);
        return 0;
      }
      AppMethodBeat.o(259950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frh
 * JD-Core Version:    0.7.0.1
 */