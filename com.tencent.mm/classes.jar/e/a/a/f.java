package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public b EgO;
  public String LUX;
  public String LUY;
  public String LUZ;
  public String LVa;
  public String LVb;
  public int LVc;
  public e LVd;
  public b LVe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LUX != null) {
        paramVarArgs.d(1, this.LUX);
      }
      if (this.LUY != null) {
        paramVarArgs.d(2, this.LUY);
      }
      if (this.LUZ != null) {
        paramVarArgs.d(3, this.LUZ);
      }
      if (this.LVa != null) {
        paramVarArgs.d(4, this.LVa);
      }
      if (this.LVb != null) {
        paramVarArgs.d(5, this.LVb);
      }
      paramVarArgs.aR(6, this.LVc);
      if (this.LVd != null)
      {
        paramVarArgs.ln(7, this.LVd.computeSize());
        this.LVd.writeFields(paramVarArgs);
      }
      if (this.LVe != null) {
        paramVarArgs.c(8, this.LVe);
      }
      if (this.EgO != null) {
        paramVarArgs.c(9, this.EgO);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LUX == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.LUX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LUY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LUY);
      }
      i = paramInt;
      if (this.LUZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LUZ);
      }
      paramInt = i;
      if (this.LVa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LVa);
      }
      i = paramInt;
      if (this.LVb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.LVb);
      }
      i += f.a.a.b.b.a.bx(6, this.LVc);
      paramInt = i;
      if (this.LVd != null) {
        paramInt = i + f.a.a.a.lm(7, this.LVd.computeSize());
      }
      i = paramInt;
      if (this.LVe != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.LVe);
      }
      paramInt = i;
      if (this.EgO != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.EgO);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localf.LUX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.LUY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.LUZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.LVa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.LVb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.LVc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.LVd = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.LVe = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.EgO = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */