package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cer
  extends cpx
{
  public int DLC;
  public int EhO;
  public bb EhT;
  public String Fto;
  public String Ftp;
  public b Ftq;
  public int Ftr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fto != null) {
        paramVarArgs.d(2, this.Fto);
      }
      if (this.Ftp != null) {
        paramVarArgs.d(3, this.Ftp);
      }
      if (this.Ftq != null) {
        paramVarArgs.c(4, this.Ftq);
      }
      paramVarArgs.aR(5, this.EhO);
      paramVarArgs.aR(6, this.DLC);
      paramVarArgs.aR(7, this.Ftr);
      if (this.EhT != null)
      {
        paramVarArgs.ln(8, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fto != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fto);
      }
      i = paramInt;
      if (this.Ftp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ftp);
      }
      paramInt = i;
      if (this.Ftq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Ftq);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EhO) + f.a.a.b.b.a.bx(6, this.DLC) + f.a.a.b.b.a.bx(7, this.Ftr);
      paramInt = i;
      if (this.EhT != null) {
        paramInt = i + f.a.a.a.lm(8, this.EhT.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cer localcer = (cer)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
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
            localcer.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localcer.Fto = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localcer.Ftp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localcer.Ftq = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localcer.EhO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localcer.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localcer.Ftr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcer.EhT = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cer
 * JD-Core Version:    0.7.0.1
 */