package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public String Std;
  public String SvJ;
  public LinkedList<i> SvK;
  public int SvL;
  public a SvM;
  public String abEA;
  public b abEB;
  public d abEC;
  public int abEw;
  public int abEx;
  public int abEy;
  public f abEz;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.SvK = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SvK);
      paramVarArgs.aY(2, this.abEw);
      if (this.Std != null) {
        paramVarArgs.f(3, this.Std);
      }
      paramVarArgs.aY(4, this.SvL);
      if (this.SvM != null)
      {
        paramVarArgs.oE(5, this.SvM.computeSize());
        this.SvM.writeFields(paramVarArgs);
      }
      if (this.SvJ != null) {
        paramVarArgs.f(6, this.SvJ);
      }
      paramVarArgs.aY(7, this.abEx);
      paramVarArgs.aY(8, this.abEy);
      if (this.abEz != null)
      {
        paramVarArgs.oE(9, this.abEz.computeSize());
        this.abEz.writeFields(paramVarArgs);
      }
      if (this.abEA != null) {
        paramVarArgs.f(10, this.abEA);
      }
      if (this.abEB != null)
      {
        paramVarArgs.oE(11, this.abEB.computeSize());
        this.abEB.writeFields(paramVarArgs);
      }
      if (this.abEC != null)
      {
        paramVarArgs.oE(12, this.abEC.computeSize());
        this.abEC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SvK) + 0 + g.a.a.b.b.a.bM(2, this.abEw);
      paramInt = i;
      if (this.Std != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Std);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SvL);
      paramInt = i;
      if (this.SvM != null) {
        paramInt = i + g.a.a.a.oD(5, this.SvM.computeSize());
      }
      i = paramInt;
      if (this.SvJ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.SvJ);
      }
      i = i + g.a.a.b.b.a.bM(7, this.abEx) + g.a.a.b.b.a.bM(8, this.abEy);
      paramInt = i;
      if (this.abEz != null) {
        paramInt = i + g.a.a.a.oD(9, this.abEz.computeSize());
      }
      i = paramInt;
      if (this.abEA != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.abEA);
      }
      paramInt = i;
      if (this.abEB != null) {
        paramInt = i + g.a.a.a.oD(11, this.abEB.computeSize());
      }
      i = paramInt;
      if (this.abEC != null) {
        i = paramInt + g.a.a.a.oD(12, this.abEC.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SvK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91741);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new i();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((i)localObject2).parseFrom((byte[])localObject1);
          }
          localc.SvK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.abEw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.Std = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.SvL = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localc.SvM = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.SvJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.abEx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.abEy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          localc.abEz = ((f)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.abEA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          localc.abEB = ((b)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new d();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((d)localObject2).parseFrom((byte[])localObject1);
        }
        localc.abEC = ((d)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    AppMethodBeat.o(91741);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.c
 * JD-Core Version:    0.7.0.1
 */