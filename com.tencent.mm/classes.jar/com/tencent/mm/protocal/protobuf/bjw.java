package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjw
  extends cvc
{
  public int FtC;
  public boolean GEn;
  public LinkedList<String> GEo;
  public int dnh;
  public String duW;
  
  public bjw()
  {
    AppMethodBeat.i(147765);
    this.GEo = new LinkedList();
    AppMethodBeat.o(147765);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147766);
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
      paramVarArgs.bt(3, this.GEn);
      paramVarArgs.e(4, 1, this.GEo);
      paramVarArgs.aS(5, this.dnh);
      paramVarArgs.aS(6, this.FtC);
      AppMethodBeat.o(147766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duW);
      }
      paramInt = f.a.a.b.b.a.alV(3);
      int j = f.a.a.a.c(4, 1, this.GEo);
      int k = f.a.a.b.b.a.bz(5, this.dnh);
      int m = f.a.a.b.b.a.bz(6, this.FtC);
      AppMethodBeat.o(147766);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GEo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjw localbjw = (bjw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
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
            localbjw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localbjw.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localbjw.GEn = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localbjw.GEo.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(147766);
          return 0;
        case 5: 
          localbjw.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147766);
          return 0;
        }
        localbjw.FtC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjw
 * JD-Core Version:    0.7.0.1
 */