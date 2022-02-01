package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyd
  extends erp
{
  public long Bee;
  public String ZDe;
  public String abzC;
  public String mdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259197);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abzC != null) {
        paramVarArgs.g(2, this.abzC);
      }
      if (this.mdG != null) {
        paramVarArgs.g(3, this.mdG);
      }
      paramVarArgs.bv(4, this.Bee);
      if (this.ZDe != null) {
        paramVarArgs.g(5, this.ZDe);
      }
      AppMethodBeat.o(259197);
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
      if (this.abzC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abzC);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdG);
      }
      i += i.a.a.b.b.a.q(4, this.Bee);
      paramInt = i;
      if (this.ZDe != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZDe);
      }
      AppMethodBeat.o(259197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyd localeyd = (eyd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259197);
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
            localeyd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259197);
          return 0;
        case 2: 
          localeyd.abzC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259197);
          return 0;
        case 3: 
          localeyd.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259197);
          return 0;
        case 4: 
          localeyd.Bee = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259197);
          return 0;
        }
        localeyd.ZDe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259197);
        return 0;
      }
      AppMethodBeat.o(259197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyd
 * JD-Core Version:    0.7.0.1
 */