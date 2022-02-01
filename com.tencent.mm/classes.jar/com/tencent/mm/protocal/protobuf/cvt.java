package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvt
  extends com.tencent.mm.bw.a
{
  public String FGo;
  public LinkedList<cvs> FGw;
  public String qoi;
  public String qon;
  
  public cvt()
  {
    AppMethodBeat.i(122532);
    this.FGw = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qon != null) {
        paramVarArgs.d(1, this.qon);
      }
      if (this.FGo != null) {
        paramVarArgs.d(2, this.FGo);
      }
      if (this.qoi != null) {
        paramVarArgs.d(3, this.qoi);
      }
      paramVarArgs.e(4, 8, this.FGw);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qon == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.qon) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FGo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FGo);
      }
      i = paramInt;
      if (this.qoi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qoi);
      }
      paramInt = f.a.a.a.c(4, 8, this.FGw);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FGw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvt localcvt = (cvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localcvt.qon = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localcvt.FGo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localcvt.qoi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cvs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvt.FGw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvt
 * JD-Core Version:    0.7.0.1
 */