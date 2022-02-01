package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String Gpk;
  public String OmA;
  public String OmB;
  public int Oms;
  public String Omt;
  public String Omu;
  public String Omv;
  public long Omw;
  public int Omx;
  public h Omy;
  public String Omz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Oms);
      if (this.Omt != null) {
        paramVarArgs.d(2, this.Omt);
      }
      if (this.Omu != null) {
        paramVarArgs.d(3, this.Omu);
      }
      if (this.Omv != null) {
        paramVarArgs.d(5, this.Omv);
      }
      paramVarArgs.aZ(6, this.Omw);
      if (this.Gpk != null) {
        paramVarArgs.d(7, this.Gpk);
      }
      paramVarArgs.aS(8, this.Omx);
      if (this.Omy != null)
      {
        paramVarArgs.lJ(9, this.Omy.computeSize());
        this.Omy.writeFields(paramVarArgs);
      }
      if (this.Omz != null) {
        paramVarArgs.d(10, this.Omz);
      }
      if (this.OmA != null) {
        paramVarArgs.d(11, this.OmA);
      }
      if (this.OmB != null) {
        paramVarArgs.d(12, this.OmB);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Oms) + 0;
      paramInt = i;
      if (this.Omt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Omt);
      }
      i = paramInt;
      if (this.Omu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Omu);
      }
      paramInt = i;
      if (this.Omv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Omv);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.Omw);
      paramInt = i;
      if (this.Gpk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gpk);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Omx);
      paramInt = i;
      if (this.Omy != null) {
        paramInt = i + f.a.a.a.lI(9, this.Omy.computeSize());
      }
      i = paramInt;
      if (this.Omz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Omz);
      }
      paramInt = i;
      if (this.OmA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.OmA);
      }
      i = paramInt;
      if (this.OmB != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.OmB);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locald.Oms = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.Omt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.Omu = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.Omv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.Omw = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.Gpk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.Omx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.Omy = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.Omz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.OmA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.OmB = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91742);
      return 0;
    }
    AppMethodBeat.o(91742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.d
 * JD-Core Version:    0.7.0.1
 */