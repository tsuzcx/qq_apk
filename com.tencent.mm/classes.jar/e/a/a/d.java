package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public String Sld;
  public int abED;
  public String abEE;
  public String abEF;
  public String abEG;
  public long abEH;
  public int abEI;
  public h abEJ;
  public String abEK;
  public String abEL;
  public String abEM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.abED);
      if (this.abEE != null) {
        paramVarArgs.f(2, this.abEE);
      }
      if (this.abEF != null) {
        paramVarArgs.f(3, this.abEF);
      }
      if (this.abEG != null) {
        paramVarArgs.f(5, this.abEG);
      }
      paramVarArgs.bm(6, this.abEH);
      if (this.Sld != null) {
        paramVarArgs.f(7, this.Sld);
      }
      paramVarArgs.aY(8, this.abEI);
      if (this.abEJ != null)
      {
        paramVarArgs.oE(9, this.abEJ.computeSize());
        this.abEJ.writeFields(paramVarArgs);
      }
      if (this.abEK != null) {
        paramVarArgs.f(10, this.abEK);
      }
      if (this.abEL != null) {
        paramVarArgs.f(11, this.abEL);
      }
      if (this.abEM != null) {
        paramVarArgs.f(12, this.abEM);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.abED) + 0;
      paramInt = i;
      if (this.abEE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.abEE);
      }
      i = paramInt;
      if (this.abEF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.abEF);
      }
      paramInt = i;
      if (this.abEG != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.abEG);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.abEH);
      paramInt = i;
      if (this.Sld != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sld);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.abEI);
      paramInt = i;
      if (this.abEJ != null) {
        paramInt = i + g.a.a.a.oD(9, this.abEJ.computeSize());
      }
      i = paramInt;
      if (this.abEK != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.abEK);
      }
      paramInt = i;
      if (this.abEL != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.abEL);
      }
      i = paramInt;
      if (this.abEM != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.abEM);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.abED = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.abEE = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.abEF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.abEG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.abEH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.Sld = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.abEI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          h localh = new h();
          if ((localObject != null) && (localObject.length > 0)) {
            localh.parseFrom((byte[])localObject);
          }
          locald.abEJ = localh;
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.abEK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.abEL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.abEM = ((g.a.a.a.a)localObject).abFh.readString();
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