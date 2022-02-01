package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bj
  extends com.tencent.mm.bw.a
{
  public dhz DOc;
  public String DOd = "";
  public String DOe = "";
  public String DOf = "";
  public long DOg = 0L;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DOc != null)
      {
        paramVarArgs.ln(1, this.DOc.computeSize());
        this.DOc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.flags);
      paramVarArgs.aR(3, this.state);
      if (this.DOd != null) {
        paramVarArgs.d(4, this.DOd);
      }
      if (this.DOe != null) {
        paramVarArgs.d(5, this.DOe);
      }
      if (this.DOf != null) {
        paramVarArgs.d(6, this.DOf);
      }
      paramVarArgs.aO(7, this.DOg);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DOc == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lm(1, this.DOc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.flags) + f.a.a.b.b.a.bx(3, this.state);
      paramInt = i;
      if (this.DOd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DOd);
      }
      i = paramInt;
      if (this.DOe != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DOe);
      }
      paramInt = i;
      if (this.DOf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DOf);
      }
      i = f.a.a.b.b.a.p(7, this.DOg);
      AppMethodBeat.o(122482);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbj.DOc = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbj.flags = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbj.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbj.DOd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbj.DOe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbj.DOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbj.DOg = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */