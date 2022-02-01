package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auz
  extends com.tencent.mm.bw.a
{
  public String EMV;
  public ta ENb;
  public String ENc;
  public boolean ENd;
  public int ENe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ENb != null)
      {
        paramVarArgs.ln(1, this.ENb.computeSize());
        this.ENb.writeFields(paramVarArgs);
      }
      if (this.EMV != null) {
        paramVarArgs.d(2, this.EMV);
      }
      if (this.ENc != null) {
        paramVarArgs.d(3, this.ENc);
      }
      paramVarArgs.bl(4, this.ENd);
      paramVarArgs.aR(5, this.ENe);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ENb == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.a.lm(1, this.ENb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EMV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EMV);
      }
      i = paramInt;
      if (this.ENc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ENc);
      }
      paramInt = f.a.a.b.b.a.fK(4);
      int j = f.a.a.b.b.a.bx(5, this.ENe);
      AppMethodBeat.o(114024);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auz localauz = (auz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauz.ENb = ((ta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localauz.EMV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localauz.ENc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localauz.ENd = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114024);
          return 0;
        }
        localauz.ENe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auz
 * JD-Core Version:    0.7.0.1
 */