package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lc
  extends cpx
{
  public int DUY;
  public int DYd;
  public String DYe;
  public String DYf;
  public String DYg;
  public String DYh;
  public String DYi;
  public String DYj;
  public String DYk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DUY);
      paramVarArgs.aR(3, this.DYd);
      if (this.DYe != null) {
        paramVarArgs.d(4, this.DYe);
      }
      if (this.DYf != null) {
        paramVarArgs.d(5, this.DYf);
      }
      if (this.DYg != null) {
        paramVarArgs.d(6, this.DYg);
      }
      if (this.DYh != null) {
        paramVarArgs.d(7, this.DYh);
      }
      if (this.DYi != null) {
        paramVarArgs.d(8, this.DYi);
      }
      if (this.DYj != null) {
        paramVarArgs.d(9, this.DYj);
      }
      if (this.DYk != null) {
        paramVarArgs.d(10, this.DYk);
      }
      AppMethodBeat.o(155394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DUY) + f.a.a.b.b.a.bx(3, this.DYd);
      paramInt = i;
      if (this.DYe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYe);
      }
      i = paramInt;
      if (this.DYf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DYf);
      }
      paramInt = i;
      if (this.DYg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DYg);
      }
      i = paramInt;
      if (this.DYh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DYh);
      }
      paramInt = i;
      if (this.DYi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DYi);
      }
      i = paramInt;
      if (this.DYj != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DYj);
      }
      paramInt = i;
      if (this.DYk != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DYk);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lc locallc = (lc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          locallc.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          locallc.DYd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          locallc.DYe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          locallc.DYf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          locallc.DYg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          locallc.DYh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          locallc.DYi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          locallc.DYj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        locallc.DYk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lc
 * JD-Core Version:    0.7.0.1
 */