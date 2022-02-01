package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String Epz;
  public int LUN;
  public String LUO;
  public String LUP;
  public String LUQ;
  public long LUR;
  public int LUS;
  public h LUT;
  public String LUU;
  public String LUV;
  public String LUW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.LUN);
      if (this.LUO != null) {
        paramVarArgs.d(2, this.LUO);
      }
      if (this.LUP != null) {
        paramVarArgs.d(3, this.LUP);
      }
      if (this.LUQ != null) {
        paramVarArgs.d(5, this.LUQ);
      }
      paramVarArgs.aO(6, this.LUR);
      if (this.Epz != null) {
        paramVarArgs.d(7, this.Epz);
      }
      paramVarArgs.aR(8, this.LUS);
      if (this.LUT != null)
      {
        paramVarArgs.ln(9, this.LUT.computeSize());
        this.LUT.writeFields(paramVarArgs);
      }
      if (this.LUU != null) {
        paramVarArgs.d(10, this.LUU);
      }
      if (this.LUV != null) {
        paramVarArgs.d(11, this.LUV);
      }
      if (this.LUW != null) {
        paramVarArgs.d(12, this.LUW);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.LUN) + 0;
      paramInt = i;
      if (this.LUO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LUO);
      }
      i = paramInt;
      if (this.LUP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LUP);
      }
      paramInt = i;
      if (this.LUQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.LUQ);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.LUR);
      paramInt = i;
      if (this.Epz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Epz);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.LUS);
      paramInt = i;
      if (this.LUT != null) {
        paramInt = i + f.a.a.a.lm(9, this.LUT.computeSize());
      }
      i = paramInt;
      if (this.LUU != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.LUU);
      }
      paramInt = i;
      if (this.LUV != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.LUV);
      }
      i = paramInt;
      if (this.LUW != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.LUW);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.LUN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.LUO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.LUP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.LUQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.LUR = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.Epz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.LUS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.LUT = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.LUU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.LUV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.LUW = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91742);
      return 0;
    }
    AppMethodBeat.o(91742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.d
 * JD-Core Version:    0.7.0.1
 */