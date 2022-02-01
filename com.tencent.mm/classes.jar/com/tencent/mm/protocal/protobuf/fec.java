package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fec
  extends dyy
{
  public int Svu;
  public long Svv;
  public int TKv;
  public int TWl;
  public int UDN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.TWl);
      paramVarArgs.aY(5, this.TKv);
      paramVarArgs.aY(6, this.UDN);
      AppMethodBeat.o(115877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.b.b.a.bM(4, this.TWl);
      int m = g.a.a.b.b.a.bM(5, this.TKv);
      int n = g.a.a.b.b.a.bM(6, this.UDN);
      AppMethodBeat.o(115877);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fec localfec = (fec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115877);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localfec.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(115877);
          return 0;
        case 2: 
          localfec.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115877);
          return 0;
        case 3: 
          localfec.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(115877);
          return 0;
        case 4: 
          localfec.TWl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115877);
          return 0;
        case 5: 
          localfec.TKv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115877);
          return 0;
        }
        localfec.UDN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115877);
        return 0;
      }
      AppMethodBeat.o(115877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fec
 * JD-Core Version:    0.7.0.1
 */