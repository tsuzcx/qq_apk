package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public long CLA;
  public int CLB;
  public h CLC;
  public String CLD;
  public String CLE;
  public String CLF;
  public int CLw;
  public String CLx;
  public String CLy;
  public String CLz;
  public String wKD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(141137);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.CLw);
      if (this.CLx != null) {
        paramVarArgs.e(2, this.CLx);
      }
      if (this.CLy != null) {
        paramVarArgs.e(3, this.CLy);
      }
      if (this.CLz != null) {
        paramVarArgs.e(5, this.CLz);
      }
      paramVarArgs.am(6, this.CLA);
      if (this.wKD != null) {
        paramVarArgs.e(7, this.wKD);
      }
      paramVarArgs.aO(8, this.CLB);
      if (this.CLC != null)
      {
        paramVarArgs.iQ(9, this.CLC.computeSize());
        this.CLC.writeFields(paramVarArgs);
      }
      if (this.CLD != null) {
        paramVarArgs.e(10, this.CLD);
      }
      if (this.CLE != null) {
        paramVarArgs.e(11, this.CLE);
      }
      if (this.CLF != null) {
        paramVarArgs.e(12, this.CLF);
      }
      AppMethodBeat.o(141137);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.CLw) + 0;
      paramInt = i;
      if (this.CLx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.CLx);
      }
      i = paramInt;
      if (this.CLy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.CLy);
      }
      paramInt = i;
      if (this.CLz != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.CLz);
      }
      i = paramInt + e.a.a.b.b.a.p(6, this.CLA);
      paramInt = i;
      if (this.wKD != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wKD);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.CLB);
      paramInt = i;
      if (this.CLC != null) {
        paramInt = i + e.a.a.a.iP(9, this.CLC.computeSize());
      }
      i = paramInt;
      if (this.CLD != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.CLD);
      }
      paramInt = i;
      if (this.CLE != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.CLE);
      }
      i = paramInt;
      if (this.CLF != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.CLF);
      }
      AppMethodBeat.o(141137);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(141137);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(141137);
        return -1;
      case 1: 
        locald.CLw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141137);
        return 0;
      case 2: 
        locald.CLx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      case 3: 
        locald.CLy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      case 5: 
        locald.CLz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      case 6: 
        locald.CLA = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(141137);
        return 0;
      case 7: 
        locald.wKD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      case 8: 
        locald.CLB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(141137);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.CLC = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(141137);
        return 0;
      case 10: 
        locald.CLD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      case 11: 
        locald.CLE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(141137);
        return 0;
      }
      locald.CLF = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(141137);
      return 0;
    }
    AppMethodBeat.o(141137);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.a.a.d
 * JD-Core Version:    0.7.0.1
 */