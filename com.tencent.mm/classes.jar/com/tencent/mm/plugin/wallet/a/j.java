package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.cd.a
{
  public b OwB;
  public String OwC;
  public double OwD;
  public LinkedList<f> OwE;
  public double Owl;
  public LinkedList<t> Own;
  public double Ows;
  public double Owt;
  public int Owu;
  public String Owv;
  public String Oww;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.OwE = new LinkedList();
    this.Own = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.OwC != null) {
        paramVarArgs.f(1, this.OwC);
      }
      paramVarArgs.e(2, this.OwD);
      paramVarArgs.e(3, this.Owl);
      paramVarArgs.e(4, 8, this.OwE);
      paramVarArgs.e(5, 8, this.Own);
      paramVarArgs.e(6, this.Ows);
      paramVarArgs.e(7, this.Owt);
      paramVarArgs.aY(8, this.Owu);
      if (this.Owv != null) {
        paramVarArgs.f(9, this.Owv);
      }
      if (this.Oww != null) {
        paramVarArgs.f(10, this.Oww);
      }
      if (this.OwB != null) {
        paramVarArgs.c(11, this.OwB);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OwC == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.b.b.a.g(1, this.OwC) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 8) + (g.a.a.b.b.a.gL(3) + 8) + g.a.a.a.c(4, 8, this.OwE) + g.a.a.a.c(5, 8, this.Own) + (g.a.a.b.b.a.gL(6) + 8) + (g.a.a.b.b.a.gL(7) + 8) + g.a.a.b.b.a.bM(8, this.Owu);
      paramInt = i;
      if (this.Owv != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Owv);
      }
      i = paramInt;
      if (this.Oww != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Oww);
      }
      paramInt = i;
      if (this.OwB != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.OwB);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.OwE.clear();
        this.Own.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91297);
          return -1;
        case 1: 
          localj.OwC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.OwD = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.Owl = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
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
            localj.OwE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new t();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((t)localObject2).parseFrom((byte[])localObject1);
            }
            localj.Own.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.Ows = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.Owt = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.Owu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.Owv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.Oww = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.OwB = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */