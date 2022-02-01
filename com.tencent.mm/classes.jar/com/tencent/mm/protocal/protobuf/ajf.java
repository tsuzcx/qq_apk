package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ajf
  extends ckq
{
  public aht Dkw;
  public int KJH;
  public b qKW;
  public int qpj;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168988);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.qpj);
      if (this.qKW != null) {
        paramVarArgs.c(3, this.qKW);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.Dkw != null)
      {
        paramVarArgs.kX(6, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.KJH);
      AppMethodBeat.o(168988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.qpj);
      paramInt = i;
      if (this.qKW != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.qKW);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      i += f.a.a.b.b.a.bA(5, this.scene);
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(6, this.Dkw.computeSize());
      }
      i = f.a.a.b.b.a.bA(7, this.KJH);
      AppMethodBeat.o(168988);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajf localajf = (ajf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168988);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        case 2: 
          localajf.qpj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168988);
          return 0;
        case 3: 
          localajf.qKW = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168988);
          return 0;
        case 4: 
          localajf.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168988);
          return 0;
        case 5: 
          localajf.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168988);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajf.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        }
        localajf.KJH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168988);
        return 0;
      }
      AppMethodBeat.o(168988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajf
 * JD-Core Version:    0.7.0.1
 */