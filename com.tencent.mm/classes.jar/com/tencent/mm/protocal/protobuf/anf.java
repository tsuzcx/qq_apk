package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anf
  extends ckq
{
  public String Dop;
  public LinkedList<String> Doq;
  public String sbA;
  
  public anf()
  {
    AppMethodBeat.i(42633);
    this.Doq = new LinkedList();
    AppMethodBeat.o(42633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dop != null) {
        paramVarArgs.d(2, this.Dop);
      }
      paramVarArgs.e(3, 1, this.Doq);
      if (this.sbA != null) {
        paramVarArgs.d(4, this.sbA);
      }
      AppMethodBeat.o(42634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dop != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dop);
      }
      i += f.a.a.a.c(3, 1, this.Doq);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbA);
      }
      AppMethodBeat.o(42634);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Doq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(42634);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anf localanf = (anf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42634);
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
            localanf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42634);
          return 0;
        case 2: 
          localanf.Dop = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42634);
          return 0;
        case 3: 
          localanf.Doq.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42634);
          return 0;
        }
        localanf.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(42634);
        return 0;
      }
      AppMethodBeat.o(42634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */