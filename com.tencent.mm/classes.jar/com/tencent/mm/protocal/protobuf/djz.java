package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djz
  extends cpx
{
  public String FSA;
  public String FSB;
  public String FSD;
  public String FSN;
  public int FSS;
  public String FST;
  public String FSz;
  public String desc;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FSz != null) {
        paramVarArgs.d(2, this.FSz);
      }
      if (this.FSA != null) {
        paramVarArgs.d(3, this.FSA);
      }
      if (this.FSB != null) {
        paramVarArgs.d(4, this.FSB);
      }
      paramVarArgs.aR(5, this.uiK);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      paramVarArgs.aR(7, this.FSS);
      if (this.FSD != null) {
        paramVarArgs.d(8, this.FSD);
      }
      if (this.FSN != null) {
        paramVarArgs.d(9, this.FSN);
      }
      if (this.FST != null) {
        paramVarArgs.d(10, this.FST);
      }
      AppMethodBeat.o(72607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSz);
      }
      i = paramInt;
      if (this.FSA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSA);
      }
      paramInt = i;
      if (this.FSB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FSB);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.uiK);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.FSS);
      paramInt = i;
      if (this.FSD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FSD);
      }
      i = paramInt;
      if (this.FSN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FSN);
      }
      paramInt = i;
      if (this.FST != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FST);
      }
      AppMethodBeat.o(72607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djz localdjz = (djz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72607);
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
            localdjz.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72607);
          return 0;
        case 2: 
          localdjz.FSz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 3: 
          localdjz.FSA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 4: 
          localdjz.FSB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 5: 
          localdjz.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72607);
          return 0;
        case 6: 
          localdjz.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 7: 
          localdjz.FSS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72607);
          return 0;
        case 8: 
          localdjz.FSD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        case 9: 
          localdjz.FSN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72607);
          return 0;
        }
        localdjz.FST = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72607);
        return 0;
      }
      AppMethodBeat.o(72607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djz
 * JD-Core Version:    0.7.0.1
 */