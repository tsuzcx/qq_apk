package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdt
  extends erp
{
  public String abDu;
  public long abDv;
  public String abDw;
  public int abDx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125775);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abDu != null) {
        paramVarArgs.g(2, this.abDu);
      }
      paramVarArgs.bv(3, this.abDv);
      if (this.abDw != null) {
        paramVarArgs.g(4, this.abDw);
      }
      paramVarArgs.bS(5, this.abDx);
      AppMethodBeat.o(125775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abDu);
      }
      i += i.a.a.b.b.a.q(3, this.abDv);
      paramInt = i;
      if (this.abDw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abDw);
      }
      i = i.a.a.b.b.a.cJ(5, this.abDx);
      AppMethodBeat.o(125775);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fdt localfdt = (fdt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125775);
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
            localfdt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125775);
          return 0;
        case 2: 
          localfdt.abDu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125775);
          return 0;
        case 3: 
          localfdt.abDv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125775);
          return 0;
        case 4: 
          localfdt.abDw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125775);
          return 0;
        }
        localfdt.abDx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125775);
        return 0;
      }
      AppMethodBeat.o(125775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdt
 * JD-Core Version:    0.7.0.1
 */