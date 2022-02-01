package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbt
  extends erp
{
  public int ZdC;
  public gol ZdD;
  public long ZvA;
  public int Zvz;
  public long abWT;
  public String abnl;
  public gak acae;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(115925);
        throw paramVarArgs;
      }
      if (this.acae == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpLog");
        AppMethodBeat.o(115925);
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
      if (this.ZdD != null)
      {
        paramVarArgs.qD(4, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      if (this.acae != null)
      {
        paramVarArgs.qD(5, this.acae.computeSize());
        this.acae.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.ZvA);
      paramVarArgs.bS(7, this.ZdC);
      paramVarArgs.bv(8, this.abWT);
      AppMethodBeat.o(115925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label892;
      }
    }
    label892:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abnl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abnl);
      }
      i += i.a.a.b.b.a.cJ(3, this.Zvz);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZdD.computeSize());
      }
      i = paramInt;
      if (this.acae != null) {
        i = paramInt + i.a.a.a.qC(5, this.acae.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(6, this.ZvA);
      int j = i.a.a.b.b.a.cJ(7, this.ZdC);
      int k = i.a.a.b.b.a.q(8, this.abWT);
      AppMethodBeat.o(115925);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZdD == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        if (this.acae == null)
        {
          paramVarArgs = new b("Not all required fields were included: OpLog");
          AppMethodBeat.o(115925);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbt localgbt = (gbt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115925);
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
            localgbt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 2: 
          localgbt.abnl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115925);
          return 0;
        case 3: 
          localgbt.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115925);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbt.ZdD = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gak)localObject2).parseFrom((byte[])localObject1);
            }
            localgbt.acae = ((gak)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115925);
          return 0;
        case 6: 
          localgbt.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115925);
          return 0;
        case 7: 
          localgbt.ZdC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115925);
          return 0;
        }
        localgbt.abWT = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(115925);
        return 0;
      }
      AppMethodBeat.o(115925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbt
 * JD-Core Version:    0.7.0.1
 */