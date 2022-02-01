package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvi
  extends com.tencent.mm.bx.a
{
  public int EPM;
  public int FOh;
  public int GJv;
  public int GyM;
  public int HfH;
  public cvl HnA;
  public cvk HnB;
  public int HnC;
  public String HnD;
  public int HnE;
  public int HnF;
  public int HnG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HnD == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HfH);
      if (this.HnA != null)
      {
        paramVarArgs.lC(2, this.HnA.computeSize());
        this.HnA.writeFields(paramVarArgs);
      }
      if (this.HnB != null)
      {
        paramVarArgs.lC(3, this.HnB.computeSize());
        this.HnB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GyM);
      paramVarArgs.aS(5, this.HnC);
      if (this.HnD != null) {
        paramVarArgs.d(6, this.HnD);
      }
      paramVarArgs.aS(7, this.FOh);
      paramVarArgs.aS(8, this.HnE);
      paramVarArgs.aS(9, this.EPM);
      paramVarArgs.aS(10, this.HnF);
      paramVarArgs.aS(11, this.HnG);
      paramVarArgs.aS(12, this.GJv);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HfH) + 0;
      paramInt = i;
      if (this.HnA != null) {
        paramInt = i + f.a.a.a.lB(2, this.HnA.computeSize());
      }
      i = paramInt;
      if (this.HnB != null) {
        i = paramInt + f.a.a.a.lB(3, this.HnB.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.GyM) + f.a.a.b.b.a.bz(5, this.HnC);
      paramInt = i;
      if (this.HnD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HnD);
      }
      i = f.a.a.b.b.a.bz(7, this.FOh);
      int j = f.a.a.b.b.a.bz(8, this.HnE);
      int k = f.a.a.b.b.a.bz(9, this.EPM);
      int m = f.a.a.b.b.a.bz(10, this.HnF);
      int n = f.a.a.b.b.a.bz(11, this.HnG);
      int i1 = f.a.a.b.b.a.bz(12, this.GJv);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HnD == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvi localcvi = (cvi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localcvi.HfH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvi.HnA = ((cvl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvi.HnB = ((cvk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localcvi.GyM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localcvi.HnC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localcvi.HnD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localcvi.FOh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localcvi.HnE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localcvi.EPM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localcvi.HnF = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localcvi.HnG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152668);
        return 0;
      }
      localcvi.GJv = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvi
 * JD-Core Version:    0.7.0.1
 */