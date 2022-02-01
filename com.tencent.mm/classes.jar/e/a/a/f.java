package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public b Ggu;
  public String OmC;
  public String OmD;
  public String OmE;
  public String OmF;
  public String OmG;
  public int OmH;
  public e OmI;
  public b OmJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.OmC != null) {
        paramVarArgs.d(1, this.OmC);
      }
      if (this.OmD != null) {
        paramVarArgs.d(2, this.OmD);
      }
      if (this.OmE != null) {
        paramVarArgs.d(3, this.OmE);
      }
      if (this.OmF != null) {
        paramVarArgs.d(4, this.OmF);
      }
      if (this.OmG != null) {
        paramVarArgs.d(5, this.OmG);
      }
      paramVarArgs.aS(6, this.OmH);
      if (this.OmI != null)
      {
        paramVarArgs.lJ(7, this.OmI.computeSize());
        this.OmI.writeFields(paramVarArgs);
      }
      if (this.OmJ != null) {
        paramVarArgs.c(8, this.OmJ);
      }
      if (this.Ggu != null) {
        paramVarArgs.c(9, this.Ggu);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OmC == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.OmC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OmD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.OmD);
      }
      i = paramInt;
      if (this.OmE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.OmE);
      }
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.OmF);
      }
      i = paramInt;
      if (this.OmG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.OmG);
      }
      i += f.a.a.b.b.a.bz(6, this.OmH);
      paramInt = i;
      if (this.OmI != null) {
        paramInt = i + f.a.a.a.lI(7, this.OmI.computeSize());
      }
      i = paramInt;
      if (this.OmJ != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.OmJ);
      }
      paramInt = i;
      if (this.Ggu != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.Ggu);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.OmC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.OmD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.OmE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.OmF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.OmG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.OmH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.OmI = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.OmJ = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.Ggu = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */