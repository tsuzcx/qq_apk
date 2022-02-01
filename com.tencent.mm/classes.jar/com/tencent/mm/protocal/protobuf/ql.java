package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ql
  extends erp
{
  public int IJG;
  public long YMI;
  public String YRs;
  public b YVf;
  public int YVh;
  public int YVi;
  public int YVj;
  public String YVk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124443);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YRs != null) {
        paramVarArgs.g(2, this.YRs);
      }
      paramVarArgs.bS(3, this.YVh);
      if (this.YVf != null) {
        paramVarArgs.d(4, this.YVf);
      }
      paramVarArgs.bS(5, this.YVi);
      paramVarArgs.bv(6, this.YMI);
      paramVarArgs.bS(7, this.YVj);
      paramVarArgs.bS(8, this.IJG);
      if (this.YVk != null) {
        paramVarArgs.g(12, this.YVk);
      }
      AppMethodBeat.o(124443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YRs);
      }
      i += i.a.a.b.b.a.cJ(3, this.YVh);
      paramInt = i;
      if (this.YVf != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YVf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YVi) + i.a.a.b.b.a.q(6, this.YMI) + i.a.a.b.b.a.cJ(7, this.YVj) + i.a.a.b.b.a.cJ(8, this.IJG);
      paramInt = i;
      if (this.YVk != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YVk);
      }
      AppMethodBeat.o(124443);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ql localql = (ql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        default: 
          AppMethodBeat.o(124443);
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
            localql.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124443);
          return 0;
        case 2: 
          localql.YRs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124443);
          return 0;
        case 3: 
          localql.YVh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124443);
          return 0;
        case 4: 
          localql.YVf = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(124443);
          return 0;
        case 5: 
          localql.YVi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124443);
          return 0;
        case 6: 
          localql.YMI = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124443);
          return 0;
        case 7: 
          localql.YVj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124443);
          return 0;
        case 8: 
          localql.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124443);
          return 0;
        }
        localql.YVk = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124443);
        return 0;
      }
      AppMethodBeat.o(124443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ql
 * JD-Core Version:    0.7.0.1
 */