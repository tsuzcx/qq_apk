package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctf
  extends ckq
{
  public LinkedList<Integer> Ejc;
  public int EkO;
  public String dlB;
  
  public ctf()
  {
    AppMethodBeat.i(123650);
    this.Ejc = new LinkedList();
    AppMethodBeat.o(123650);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123651);
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
      paramVarArgs.e(3, 2, this.Ejc);
      paramVarArgs.aR(4, this.EkO);
      AppMethodBeat.o(123651);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      paramInt = f.a.a.a.c(3, 2, this.Ejc);
      int j = f.a.a.b.b.a.bA(4, this.EkO);
      AppMethodBeat.o(123651);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ejc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123651);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctf localctf = (ctf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123651);
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
            localctf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123651);
          return 0;
        case 2: 
          localctf.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123651);
          return 0;
        case 3: 
          localctf.Ejc.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(123651);
          return 0;
        }
        localctf.EkO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123651);
        return 0;
      }
      AppMethodBeat.o(123651);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctf
 * JD-Core Version:    0.7.0.1
 */