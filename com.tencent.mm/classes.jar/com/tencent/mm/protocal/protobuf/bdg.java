package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdg
  extends cpx
{
  public int ETt;
  public int ETu;
  public se ETv;
  public xc ETw;
  public int ETx;
  public long bQR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50089);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ETt);
      paramVarArgs.aR(3, this.ETu);
      if (this.ETv != null)
      {
        paramVarArgs.ln(4, this.ETv.computeSize());
        this.ETv.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.bQR);
      if (this.ETw != null)
      {
        paramVarArgs.ln(6, this.ETw.computeSize());
        this.ETw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.ETx);
      AppMethodBeat.o(50089);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ETt) + f.a.a.b.b.a.bx(3, this.ETu);
      paramInt = i;
      if (this.ETv != null) {
        paramInt = i + f.a.a.a.lm(4, this.ETv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.bQR);
      paramInt = i;
      if (this.ETw != null) {
        paramInt = i + f.a.a.a.lm(6, this.ETw.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.ETx);
      AppMethodBeat.o(50089);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50089);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdg localbdg = (bdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50089);
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
            localbdg.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 2: 
          localbdg.ETt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(50089);
          return 0;
        case 3: 
          localbdg.ETu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(50089);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new se();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((se)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdg.ETv = ((se)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        case 5: 
          localbdg.bQR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(50089);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdg.ETw = ((xc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50089);
          return 0;
        }
        localbdg.ETx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(50089);
        return 0;
      }
      AppMethodBeat.o(50089);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdg
 * JD-Core Version:    0.7.0.1
 */