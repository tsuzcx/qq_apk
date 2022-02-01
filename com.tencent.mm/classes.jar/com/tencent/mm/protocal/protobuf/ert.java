package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ert
  extends esc
{
  public String Hgk;
  public String abdB;
  public int abdD;
  public String abdN;
  public int abvs;
  public int abvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hgk != null) {
        paramVarArgs.g(2, this.Hgk);
      }
      if (this.abdB != null) {
        paramVarArgs.g(3, this.abdB);
      }
      paramVarArgs.bS(4, this.abvs);
      paramVarArgs.bS(5, this.abvt);
      paramVarArgs.bS(6, this.abdD);
      if (this.abdN != null) {
        paramVarArgs.g(7, this.abdN);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label644;
      }
    }
    label644:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hgk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Hgk);
      }
      i = paramInt;
      if (this.abdB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdB);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.abvs) + i.a.a.b.b.a.cJ(5, this.abvt) + i.a.a.b.b.a.cJ(6, this.abdD);
      paramInt = i;
      if (this.abdN != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abdN);
      }
      AppMethodBeat.o(91672);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ert localert = (ert)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localert.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localert.Hgk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localert.abdB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localert.abvs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localert.abvt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localert.abdD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91672);
          return 0;
        }
        localert.abdN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ert
 * JD-Core Version:    0.7.0.1
 */