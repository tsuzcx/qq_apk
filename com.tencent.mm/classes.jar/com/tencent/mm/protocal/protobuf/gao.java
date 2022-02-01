package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gao
  extends esc
{
  public long ZvA;
  public int Zvz;
  public int abXY;
  public int abao;
  public int abna;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115877);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abna);
      paramVarArgs.bS(5, this.abao);
      paramVarArgs.bS(6, this.abXY);
      AppMethodBeat.o(115877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label564;
      }
    }
    label564:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.b.b.a.cJ(4, this.abna);
      int m = i.a.a.b.b.a.cJ(5, this.abao);
      int n = i.a.a.b.b.a.cJ(6, this.abXY);
      AppMethodBeat.o(115877);
      return paramInt + i + j + k + m + n;
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
          AppMethodBeat.o(115877);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gao localgao = (gao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115877);
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
            localgao.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(115877);
          return 0;
        case 2: 
          localgao.Zvz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115877);
          return 0;
        case 3: 
          localgao.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(115877);
          return 0;
        case 4: 
          localgao.abna = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115877);
          return 0;
        case 5: 
          localgao.abao = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115877);
          return 0;
        }
        localgao.abXY = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115877);
        return 0;
      }
      AppMethodBeat.o(115877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gao
 * JD-Core Version:    0.7.0.1
 */