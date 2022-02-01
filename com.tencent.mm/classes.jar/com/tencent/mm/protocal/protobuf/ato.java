package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ato
  extends ckq
{
  public int CtC;
  public b Dtx;
  public String extra;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CtC);
      if (this.extra != null) {
        paramVarArgs.d(3, this.extra);
      }
      if (this.Dtx != null) {
        paramVarArgs.c(4, this.Dtx);
      }
      AppMethodBeat.o(152568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CtC);
      paramInt = i;
      if (this.extra != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.extra);
      }
      i = paramInt;
      if (this.Dtx != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Dtx);
      }
      AppMethodBeat.o(152568);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ato localato = (ato)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152568);
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
            localato.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152568);
          return 0;
        case 2: 
          localato.CtC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152568);
          return 0;
        case 3: 
          localato.extra = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152568);
          return 0;
        }
        localato.Dtx = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(152568);
        return 0;
      }
      AppMethodBeat.o(152568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ato
 * JD-Core Version:    0.7.0.1
 */