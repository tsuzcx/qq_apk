package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aom
  extends erp
{
  public int IJG;
  public long ZvA;
  public String Zvy;
  public int Zvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32193);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      if (this.Zvy != null) {
        paramVarArgs.g(4, this.Zvy);
      }
      paramVarArgs.bS(5, this.IJG);
      AppMethodBeat.o(32193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label487;
      }
    }
    label487:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA);
      paramInt = i;
      if (this.Zvy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zvy);
      }
      i = i.a.a.b.b.a.cJ(5, this.IJG);
      AppMethodBeat.o(32193);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aom localaom = (aom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32193);
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
            localaom.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32193);
          return 0;
        case 2: 
          localaom.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32193);
          return 0;
        case 3: 
          localaom.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32193);
          return 0;
        case 4: 
          localaom.Zvy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32193);
          return 0;
        }
        localaom.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32193);
        return 0;
      }
      AppMethodBeat.o(32193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aom
 * JD-Core Version:    0.7.0.1
 */