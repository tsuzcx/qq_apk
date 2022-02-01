package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class flv
  extends erp
{
  public int IJG;
  public int YFv;
  public long ZvA;
  public int Zvz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32464);
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
      paramVarArgs.bS(4, this.YFv);
      paramVarArgs.bS(5, this.IJG);
      AppMethodBeat.o(32464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label479;
      }
    }
    label479:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.b.b.a.cJ(4, this.YFv);
      int m = i.a.a.b.b.a.cJ(5, this.IJG);
      AppMethodBeat.o(32464);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        flv localflv = (flv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32464);
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
            localflv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32464);
          return 0;
        case 2: 
          localflv.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32464);
          return 0;
        case 3: 
          localflv.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(32464);
          return 0;
        case 4: 
          localflv.YFv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32464);
          return 0;
        }
        localflv.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32464);
        return 0;
      }
      AppMethodBeat.o(32464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flv
 * JD-Core Version:    0.7.0.1
 */