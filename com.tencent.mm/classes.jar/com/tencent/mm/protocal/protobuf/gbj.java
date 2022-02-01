package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbj
  extends erp
{
  public long ZvA;
  public int Zvz;
  public long abWT;
  public gbp abXP;
  public String abnl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abXP == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abnl != null) {
        paramVarArgs.g(2, this.abnl);
      }
      paramVarArgs.bS(3, this.Zvz);
      paramVarArgs.bv(4, this.ZvA);
      if (this.abXP != null)
      {
        paramVarArgs.qD(5, this.abXP.computeSize());
        this.abXP.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.abWT);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abnl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abnl);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Zvz) + i.a.a.b.b.a.q(4, this.ZvA);
      paramInt = i;
      if (this.abXP != null) {
        paramInt = i + i.a.a.a.qC(5, this.abXP.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.abWT);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abXP == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbj localgbj = (gbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
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
            localgbj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localgbj.abnl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localgbj.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localgbj.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbp)localObject2).parseFrom((byte[])localObject1);
            }
            localgbj.abXP = ((gbp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localgbj.abWT = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbj
 * JD-Core Version:    0.7.0.1
 */