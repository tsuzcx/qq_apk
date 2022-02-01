package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbw
  extends ckq
{
  public boolean Dzu;
  public LinkedList<String> Dzv;
  public int dep;
  public String dlB;
  
  public bbw()
  {
    AppMethodBeat.i(147765);
    this.Dzv = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.bg(3, this.Dzu);
      paramVarArgs.e(4, 1, this.Dzv);
      paramVarArgs.aR(5, this.dep);
      AppMethodBeat.o(147766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      paramInt = f.a.a.b.b.a.fY(3);
      int j = f.a.a.a.c(4, 1, this.Dzv);
      int k = f.a.a.b.b.a.bA(5, this.dep);
      AppMethodBeat.o(147766);
      return i + (paramInt + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dzv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbw localbbw = (bbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147766);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147766);
          return 0;
        case 2: 
          localbbw.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147766);
          return 0;
        case 3: 
          localbbw.Dzu = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(147766);
          return 0;
        case 4: 
          localbbw.Dzv.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(147766);
          return 0;
        }
        localbbw.dep = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(147766);
        return 0;
      }
      AppMethodBeat.o(147766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbw
 * JD-Core Version:    0.7.0.1
 */