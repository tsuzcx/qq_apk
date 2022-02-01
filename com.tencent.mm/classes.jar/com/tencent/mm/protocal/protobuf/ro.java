package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ro
  extends com.tencent.mm.bw.a
{
  public int EjI;
  public String EjJ;
  public String EjK;
  public String EjL;
  public int EjM;
  public String EjN;
  public rm EjO;
  public String EjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EjI);
      if (this.EjJ != null) {
        paramVarArgs.d(2, this.EjJ);
      }
      if (this.EjK != null) {
        paramVarArgs.d(3, this.EjK);
      }
      if (this.EjL != null) {
        paramVarArgs.d(4, this.EjL);
      }
      paramVarArgs.aR(5, this.EjM);
      if (this.EjN != null) {
        paramVarArgs.d(6, this.EjN);
      }
      if (this.EjO != null)
      {
        paramVarArgs.ln(7, this.EjO.computeSize());
        this.EjO.writeFields(paramVarArgs);
      }
      if (this.EjP != null) {
        paramVarArgs.d(8, this.EjP);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EjI) + 0;
      paramInt = i;
      if (this.EjJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EjJ);
      }
      i = paramInt;
      if (this.EjK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EjK);
      }
      paramInt = i;
      if (this.EjL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EjL);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EjM);
      paramInt = i;
      if (this.EjN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EjN);
      }
      i = paramInt;
      if (this.EjO != null) {
        i = paramInt + f.a.a.a.lm(7, this.EjO.computeSize());
      }
      paramInt = i;
      if (this.EjP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EjP);
      }
      AppMethodBeat.o(113967);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ro localro = (ro)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localro.EjI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localro.EjJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localro.EjK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localro.EjL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localro.EjM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localro.EjN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localro.EjO = ((rm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localro.EjP = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ro
 * JD-Core Version:    0.7.0.1
 */