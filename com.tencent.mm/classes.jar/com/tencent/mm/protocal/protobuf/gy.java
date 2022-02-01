package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gy
  extends cvc
{
  public int FtC;
  public LinkedList<String> Fzo;
  public boolean Fzp;
  public int Fzq;
  public int dnh;
  public String duW;
  
  public gy()
  {
    AppMethodBeat.i(147758);
    this.Fzo = new LinkedList();
    AppMethodBeat.o(147758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      paramVarArgs.e(3, 1, this.Fzo);
      paramVarArgs.bt(4, this.Fzp);
      paramVarArgs.aS(5, this.Fzq);
      paramVarArgs.aS(6, this.dnh);
      paramVarArgs.aS(7, this.FtC);
      AppMethodBeat.o(147759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      paramInt = f.a.a.a.c(3, 1, this.Fzo);
      int j = f.a.a.b.b.a.alV(4);
      int k = f.a.a.b.b.a.bz(5, this.Fzq);
      int m = f.a.a.b.b.a.bz(6, this.dnh);
      int n = f.a.a.b.b.a.bz(7, this.FtC);
      AppMethodBeat.o(147759);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fzo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gy localgy = (gy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147759);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147759);
          return 0;
        case 2: 
          localgy.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147759);
          return 0;
        case 3: 
          localgy.Fzo.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(147759);
          return 0;
        case 4: 
          localgy.Fzp = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(147759);
          return 0;
        case 5: 
          localgy.Fzq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147759);
          return 0;
        case 6: 
          localgy.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147759);
          return 0;
        }
        localgy.FtC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147759);
        return 0;
      }
      AppMethodBeat.o(147759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gy
 * JD-Core Version:    0.7.0.1
 */