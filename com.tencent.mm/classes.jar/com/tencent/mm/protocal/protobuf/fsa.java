package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fsa
  extends erp
{
  public String IGU;
  public String YJY;
  public String Zjv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Zjv != null) {
        paramVarArgs.g(2, this.Zjv);
      }
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.YJY != null) {
        paramVarArgs.g(4, this.YJY);
      }
      AppMethodBeat.o(155472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zjv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zjv);
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGU);
      }
      paramInt = i;
      if (this.YJY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YJY);
      }
      AppMethodBeat.o(155472);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fsa localfsa = (fsa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155472);
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
            localfsa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(155472);
          return 0;
        case 2: 
          localfsa.Zjv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155472);
          return 0;
        case 3: 
          localfsa.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155472);
          return 0;
        }
        localfsa.YJY = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155472);
        return 0;
      }
      AppMethodBeat.o(155472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fsa
 * JD-Core Version:    0.7.0.1
 */