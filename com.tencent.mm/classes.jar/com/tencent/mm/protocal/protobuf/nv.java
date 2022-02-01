package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nv
  extends erp
{
  public int YLL;
  public long YPK;
  public long YQc;
  public String YQd;
  public String YQe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258487);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YQc);
      if (this.YQd != null) {
        paramVarArgs.g(4, this.YQd);
      }
      if (this.YQe != null) {
        paramVarArgs.g(5, this.YQe);
      }
      paramVarArgs.bv(18, this.YPK);
      paramVarArgs.bS(22, this.YLL);
      AppMethodBeat.o(258487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YQc);
      paramInt = i;
      if (this.YQd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YQd);
      }
      i = paramInt;
      if (this.YQe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YQe);
      }
      paramInt = i.a.a.b.b.a.q(18, this.YPK);
      int j = i.a.a.b.b.a.cJ(22, this.YLL);
      AppMethodBeat.o(258487);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        nv localnv = (nv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258487);
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
            localnv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258487);
          return 0;
        case 2: 
          localnv.YQc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258487);
          return 0;
        case 4: 
          localnv.YQd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258487);
          return 0;
        case 5: 
          localnv.YQe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258487);
          return 0;
        case 18: 
          localnv.YPK = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258487);
          return 0;
        }
        localnv.YLL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258487);
        return 0;
      }
      AppMethodBeat.o(258487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */