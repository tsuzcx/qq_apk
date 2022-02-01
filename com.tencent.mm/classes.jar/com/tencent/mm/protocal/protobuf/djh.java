package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djh
  extends cpx
{
  public String DUp;
  public String Etg;
  public bkk FSt;
  public int FSu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Etg != null) {
        paramVarArgs.d(2, this.Etg);
      }
      if (this.DUp != null) {
        paramVarArgs.d(3, this.DUp);
      }
      if (this.FSt != null)
      {
        paramVarArgs.ln(4, this.FSt.computeSize());
        this.FSt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FSu);
      AppMethodBeat.o(32471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label641;
      }
    }
    label641:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Etg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Etg);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUp);
      }
      paramInt = i;
      if (this.FSt != null) {
        paramInt = i + f.a.a.a.lm(4, this.FSt.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.FSu);
      AppMethodBeat.o(32471);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djh localdjh = (djh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32471);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        case 2: 
          localdjh.Etg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 3: 
          localdjh.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjh.FSt = ((bkk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32471);
          return 0;
        }
        localdjh.FSu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32471);
        return 0;
      }
      AppMethodBeat.o(32471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djh
 * JD-Core Version:    0.7.0.1
 */