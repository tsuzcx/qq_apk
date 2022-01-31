package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public String CLG;
  public String CLH;
  public String CLI;
  public String CLJ;
  public String CLK;
  public int CLL;
  public e CLM;
  public b CLN;
  public b CLO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57010);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CLG != null) {
        paramVarArgs.e(1, this.CLG);
      }
      if (this.CLH != null) {
        paramVarArgs.e(2, this.CLH);
      }
      if (this.CLI != null) {
        paramVarArgs.e(3, this.CLI);
      }
      if (this.CLJ != null) {
        paramVarArgs.e(4, this.CLJ);
      }
      if (this.CLK != null) {
        paramVarArgs.e(5, this.CLK);
      }
      paramVarArgs.aO(6, this.CLL);
      if (this.CLM != null)
      {
        paramVarArgs.iQ(7, this.CLM.computeSize());
        this.CLM.writeFields(paramVarArgs);
      }
      if (this.CLN != null) {
        paramVarArgs.c(8, this.CLN);
      }
      if (this.CLO != null) {
        paramVarArgs.c(9, this.CLO);
      }
      AppMethodBeat.o(57010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLG == null) {
        break label782;
      }
    }
    label782:
    for (int i = e.a.a.b.b.a.f(1, this.CLG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CLH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.CLH);
      }
      i = paramInt;
      if (this.CLI != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.CLI);
      }
      paramInt = i;
      if (this.CLJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.CLJ);
      }
      i = paramInt;
      if (this.CLK != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.CLK);
      }
      i += e.a.a.b.b.a.bl(6, this.CLL);
      paramInt = i;
      if (this.CLM != null) {
        paramInt = i + e.a.a.a.iP(7, this.CLM.computeSize());
      }
      i = paramInt;
      if (this.CLN != null) {
        i = paramInt + e.a.a.b.b.a.b(8, this.CLN);
      }
      paramInt = i;
      if (this.CLO != null) {
        paramInt = i + e.a.a.b.b.a.b(9, this.CLO);
      }
      AppMethodBeat.o(57010);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(57010);
          return -1;
        case 1: 
          localf.CLG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57010);
          return 0;
        case 2: 
          localf.CLH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57010);
          return 0;
        case 3: 
          localf.CLI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57010);
          return 0;
        case 4: 
          localf.CLJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57010);
          return 0;
        case 5: 
          localf.CLK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57010);
          return 0;
        case 6: 
          localf.CLL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(57010);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localf.CLM = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(57010);
          return 0;
        case 8: 
          localf.CLN = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(57010);
          return 0;
        }
        localf.CLO = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(57010);
        return 0;
      }
      AppMethodBeat.o(57010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.a.a.f
 * JD-Core Version:    0.7.0.1
 */