package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cei
  extends cqk
{
  public String FsW;
  public int FsX;
  public long FsY;
  public int dkl;
  public String dkm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194018);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dkl);
      if (this.dkm != null) {
        paramVarArgs.d(3, this.dkm);
      }
      if (this.FsW != null) {
        paramVarArgs.d(4, this.FsW);
      }
      paramVarArgs.aR(5, this.FsX);
      paramVarArgs.aO(100, this.FsY);
      AppMethodBeat.o(194018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dkl);
      paramInt = i;
      if (this.dkm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dkm);
      }
      i = paramInt;
      if (this.FsW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FsW);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FsX);
      int j = f.a.a.b.b.a.p(100, this.FsY);
      AppMethodBeat.o(194018);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194018);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cei localcei = (cei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194018);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcei.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(194018);
          return 0;
        case 2: 
          localcei.dkl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194018);
          return 0;
        case 3: 
          localcei.dkm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194018);
          return 0;
        case 4: 
          localcei.FsW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194018);
          return 0;
        case 5: 
          localcei.FsX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(194018);
          return 0;
        }
        localcei.FsY = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(194018);
        return 0;
      }
      AppMethodBeat.o(194018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cei
 * JD-Core Version:    0.7.0.1
 */