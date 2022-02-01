package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecc
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public String GhI;
  public ebw Ghr;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghr != null)
      {
        paramVarArgs.ln(1, this.Ghr.computeSize());
        this.Ghr.writeFields(paramVarArgs);
      }
      if (this.GhI != null) {
        paramVarArgs.d(2, this.GhI);
      }
      paramVarArgs.aR(3, this.Eae);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghr == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.Ghr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GhI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GhI);
      }
      i += f.a.a.b.b.a.bx(3, this.Eae);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ecc localecc = (ecc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153344);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ebw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localecc.Ghr = ((ebw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153344);
          return 0;
        case 2: 
          localecc.GhI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153344);
          return 0;
        case 3: 
          localecc.Eae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153344);
          return 0;
        }
        localecc.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153344);
        return 0;
      }
      AppMethodBeat.o(153344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecc
 * JD-Core Version:    0.7.0.1
 */