package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amf
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public LinkedList<pf> RVd;
  public String RVi;
  public String RVm;
  public LinkedList<String> RXF;
  public int RXG;
  public long RXN;
  public String SwE;
  public String SwF;
  public String SwG;
  public String SwH;
  public String SwI;
  
  public amf()
  {
    AppMethodBeat.i(205342);
    this.RVd = new LinkedList();
    this.RXF = new LinkedList();
    AppMethodBeat.o(205342);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205345);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SwE != null) {
        paramVarArgs.f(1, this.SwE);
      }
      if (this.SwF != null) {
        paramVarArgs.f(2, this.SwF);
      }
      paramVarArgs.bm(3, this.RXN);
      paramVarArgs.e(4, 8, this.RVd);
      paramVarArgs.aY(5, this.RIs);
      if (this.SwG != null) {
        paramVarArgs.f(6, this.SwG);
      }
      if (this.RVi != null) {
        paramVarArgs.f(7, this.RVi);
      }
      if (this.RVm != null) {
        paramVarArgs.f(8, this.RVm);
      }
      paramVarArgs.e(9, 1, this.RXF);
      paramVarArgs.aY(10, this.RXG);
      if (this.SwH != null) {
        paramVarArgs.f(11, this.SwH);
      }
      if (this.SwI != null) {
        paramVarArgs.f(12, this.SwI);
      }
      AppMethodBeat.o(205345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SwE == null) {
        break label892;
      }
    }
    label892:
    for (paramInt = g.a.a.b.b.a.g(1, this.SwE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SwF != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SwF);
      }
      i = i + g.a.a.b.b.a.p(3, this.RXN) + g.a.a.a.c(4, 8, this.RVd) + g.a.a.b.b.a.bM(5, this.RIs);
      paramInt = i;
      if (this.SwG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SwG);
      }
      i = paramInt;
      if (this.RVi != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RVi);
      }
      paramInt = i;
      if (this.RVm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RVm);
      }
      i = paramInt + g.a.a.a.c(9, 1, this.RXF) + g.a.a.b.b.a.bM(10, this.RXG);
      paramInt = i;
      if (this.SwH != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SwH);
      }
      i = paramInt;
      if (this.SwI != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SwI);
      }
      AppMethodBeat.o(205345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVd.clear();
        this.RXF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amf localamf = (amf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205345);
          return -1;
        case 1: 
          localamf.SwE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        case 2: 
          localamf.SwF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        case 3: 
          localamf.RXN = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(205345);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            pf localpf = new pf();
            if ((localObject != null) && (localObject.length > 0)) {
              localpf.parseFrom((byte[])localObject);
            }
            localamf.RVd.add(localpf);
            paramInt += 1;
          }
          AppMethodBeat.o(205345);
          return 0;
        case 5: 
          localamf.RIs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205345);
          return 0;
        case 6: 
          localamf.SwG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        case 7: 
          localamf.RVi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        case 8: 
          localamf.RVm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        case 9: 
          localamf.RXF.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(205345);
          return 0;
        case 10: 
          localamf.RXG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(205345);
          return 0;
        case 11: 
          localamf.SwH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(205345);
          return 0;
        }
        localamf.SwI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205345);
        return 0;
      }
      AppMethodBeat.o(205345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */