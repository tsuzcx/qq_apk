package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exw
  extends dyl
{
  public int RNt;
  public String RQN;
  public LinkedList<cxr> Tyr;
  public String UserName;
  public int Uyc;
  public int Uyd;
  public LinkedList<cth> Uye;
  
  public exw()
  {
    AppMethodBeat.i(155474);
    this.Tyr = new LinkedList();
    this.Uye = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.RNt);
      if (this.RQN != null) {
        paramVarArgs.f(4, this.RQN);
      }
      paramVarArgs.aY(5, this.Uyc);
      paramVarArgs.e(6, 8, this.Tyr);
      paramVarArgs.aY(7, this.Uyd);
      paramVarArgs.e(8, 8, this.Uye);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label788;
      }
    }
    label788:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i += g.a.a.b.b.a.bM(3, this.RNt);
      paramInt = i;
      if (this.RQN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RQN);
      }
      i = g.a.a.b.b.a.bM(5, this.Uyc);
      int j = g.a.a.a.c(6, 8, this.Tyr);
      int k = g.a.a.b.b.a.bM(7, this.Uyd);
      int m = g.a.a.a.c(8, 8, this.Uye);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tyr.clear();
        this.Uye.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exw localexw = (exw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localexw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localexw.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localexw.RNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localexw.RQN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localexw.Uyc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxr)localObject2).parseFrom((byte[])localObject1);
            }
            localexw.Tyr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localexw.Uyd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cth();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cth)localObject2).parseFrom((byte[])localObject1);
          }
          localexw.Uye.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exw
 * JD-Core Version:    0.7.0.1
 */