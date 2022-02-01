package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ced
  extends cpx
{
  public int FsF;
  public String FsH;
  public String FsI;
  public String FsJ;
  public String aTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FsF);
      if (this.aTm != null) {
        paramVarArgs.d(3, this.aTm);
      }
      if (this.FsH != null) {
        paramVarArgs.d(4, this.FsH);
      }
      if (this.FsI != null) {
        paramVarArgs.d(5, this.FsI);
      }
      if (this.FsJ != null) {
        paramVarArgs.d(6, this.FsJ);
      }
      AppMethodBeat.o(91587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FsF);
      paramInt = i;
      if (this.aTm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.aTm);
      }
      i = paramInt;
      if (this.FsH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FsH);
      }
      paramInt = i;
      if (this.FsI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FsI);
      }
      i = paramInt;
      if (this.FsJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FsJ);
      }
      AppMethodBeat.o(91587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ced localced = (ced)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91587);
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
            localced.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91587);
          return 0;
        case 2: 
          localced.FsF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91587);
          return 0;
        case 3: 
          localced.aTm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 4: 
          localced.FsH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 5: 
          localced.FsI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91587);
          return 0;
        }
        localced.FsJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91587);
        return 0;
      }
      AppMethodBeat.o(91587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ced
 * JD-Core Version:    0.7.0.1
 */