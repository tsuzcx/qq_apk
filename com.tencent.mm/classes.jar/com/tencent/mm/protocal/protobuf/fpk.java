package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpk
  extends erp
{
  public String Oml;
  public String abPo;
  public String abPp;
  public String abPq;
  public String abPr;
  public int reason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.reason);
      if (this.abPo != null) {
        paramVarArgs.g(3, this.abPo);
      }
      if (this.abPp != null) {
        paramVarArgs.g(4, this.abPp);
      }
      if (this.Oml != null) {
        paramVarArgs.g(5, this.Oml);
      }
      if (this.abPq != null) {
        paramVarArgs.g(6, this.abPq);
      }
      if (this.abPr != null) {
        paramVarArgs.g(7, this.abPr);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.reason);
      paramInt = i;
      if (this.abPo != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abPo);
      }
      i = paramInt;
      if (this.abPp != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abPp);
      }
      paramInt = i;
      if (this.Oml != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Oml);
      }
      i = paramInt;
      if (this.abPq != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abPq);
      }
      paramInt = i;
      if (this.abPr != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abPr);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fpk localfpk = (fpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
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
            localfpk.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localfpk.reason = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localfpk.abPo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localfpk.abPp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localfpk.Oml = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localfpk.abPq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localfpk.abPr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpk
 * JD-Core Version:    0.7.0.1
 */