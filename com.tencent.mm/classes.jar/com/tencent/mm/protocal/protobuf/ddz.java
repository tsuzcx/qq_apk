package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddz
  extends com.tencent.mm.bw.a
{
  public int FNG;
  public ddx FNH;
  public String FNI;
  public boolean FNJ;
  public int FfT;
  public long FjJ;
  public int FjN;
  public int gLY;
  public String hkN;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hkN != null) {
        paramVarArgs.d(1, this.hkN);
      }
      paramVarArgs.aR(2, this.gLY);
      paramVarArgs.aO(3, this.FjJ);
      paramVarArgs.aR(4, this.FjN);
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      paramVarArgs.aR(6, this.FfT);
      paramVarArgs.aR(7, this.FNG);
      if (this.FNH != null)
      {
        paramVarArgs.ln(8, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      if (this.FNI != null) {
        paramVarArgs.d(9, this.FNI);
      }
      paramVarArgs.bl(10, this.FNJ);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hkN == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.hkN) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.gLY) + f.a.a.b.b.a.p(3, this.FjJ) + f.a.a.b.b.a.bx(4, this.FjN);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FfT) + f.a.a.b.b.a.bx(7, this.FNG);
      paramInt = i;
      if (this.FNH != null) {
        paramInt = i + f.a.a.a.lm(8, this.FNH.computeSize());
      }
      i = paramInt;
      if (this.FNI != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FNI);
      }
      paramInt = f.a.a.b.b.a.fK(10);
      AppMethodBeat.o(118455);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddz localddz = (ddz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localddz.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localddz.gLY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localddz.FjJ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localddz.FjN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localddz.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localddz.FfT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localddz.FNG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ddx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddz.FNH = ((ddx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localddz.FNI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118455);
          return 0;
        }
        localddz.FNJ = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddz
 * JD-Core Version:    0.7.0.1
 */