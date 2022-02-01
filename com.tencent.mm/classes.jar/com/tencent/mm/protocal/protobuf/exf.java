package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exf
  extends dyy
{
  public String TGj;
  public int TcJ;
  public int TcK;
  public int TcL;
  public int TcM;
  public String TcN;
  public int TcO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TGj != null) {
        paramVarArgs.f(2, this.TGj);
      }
      if (this.TcN != null) {
        paramVarArgs.f(3, this.TcN);
      }
      paramVarArgs.aY(4, this.TcM);
      paramVarArgs.aY(5, this.TcJ);
      paramVarArgs.aY(6, this.TcK);
      paramVarArgs.aY(7, this.TcL);
      paramVarArgs.aY(8, this.TcO);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TGj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TGj);
      }
      i = paramInt;
      if (this.TcN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TcN);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.TcM);
      int j = g.a.a.b.b.a.bM(5, this.TcJ);
      int k = g.a.a.b.b.a.bM(6, this.TcK);
      int m = g.a.a.b.b.a.bM(7, this.TcL);
      int n = g.a.a.b.b.a.bM(8, this.TcO);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
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
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        exf localexf = (exf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
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
            localexf.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localexf.TGj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localexf.TcN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localexf.TcM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localexf.TcJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localexf.TcK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localexf.TcL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101834);
          return 0;
        }
        localexf.TcO = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exf
 * JD-Core Version:    0.7.0.1
 */