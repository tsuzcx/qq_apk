package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rh
  extends com.tencent.mm.bw.a
{
  public rm EjA;
  public String EjB;
  public int EjC;
  public int EjD;
  public String Ejv;
  public String Ejw;
  public String Ejx;
  public int Ejy;
  public String Ejz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ejv != null) {
        paramVarArgs.d(1, this.Ejv);
      }
      if (this.Ejw != null) {
        paramVarArgs.d(2, this.Ejw);
      }
      if (this.Ejx != null) {
        paramVarArgs.d(3, this.Ejx);
      }
      paramVarArgs.aR(4, this.Ejy);
      if (this.Ejz != null) {
        paramVarArgs.d(5, this.Ejz);
      }
      if (this.EjA != null)
      {
        paramVarArgs.ln(6, this.EjA.computeSize());
        this.EjA.writeFields(paramVarArgs);
      }
      if (this.EjB != null) {
        paramVarArgs.d(7, this.EjB);
      }
      paramVarArgs.aR(8, this.EjC);
      paramVarArgs.aR(9, this.EjD);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ejv == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.Ejv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ejw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ejw);
      }
      i = paramInt;
      if (this.Ejx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ejx);
      }
      i += f.a.a.b.b.a.bx(4, this.Ejy);
      paramInt = i;
      if (this.Ejz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ejz);
      }
      i = paramInt;
      if (this.EjA != null) {
        i = paramInt + f.a.a.a.lm(6, this.EjA.computeSize());
      }
      paramInt = i;
      if (this.EjB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EjB);
      }
      i = f.a.a.b.b.a.bx(8, this.EjC);
      int j = f.a.a.b.b.a.bx(9, this.EjD);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rh localrh = (rh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localrh.Ejv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localrh.Ejw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localrh.Ejx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localrh.Ejy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localrh.Ejz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrh.EjA = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localrh.EjB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localrh.EjC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113959);
          return 0;
        }
        localrh.EjD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */