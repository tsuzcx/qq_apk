package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmw
  extends com.tencent.mm.cd.a
{
  public fhp SXF;
  public fhm SXG;
  public fho SXH;
  public boolean SXI;
  public boolean SXJ;
  public String SXK;
  public String SXL;
  public int SXM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250077);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SXF != null)
      {
        paramVarArgs.oE(1, this.SXF.computeSize());
        this.SXF.writeFields(paramVarArgs);
      }
      if (this.SXG != null)
      {
        paramVarArgs.oE(2, this.SXG.computeSize());
        this.SXG.writeFields(paramVarArgs);
      }
      if (this.SXH != null)
      {
        paramVarArgs.oE(3, this.SXH.computeSize());
        this.SXH.writeFields(paramVarArgs);
      }
      paramVarArgs.co(4, this.SXI);
      paramVarArgs.co(5, this.SXJ);
      if (this.SXK != null) {
        paramVarArgs.f(6, this.SXK);
      }
      if (this.SXL != null) {
        paramVarArgs.f(7, this.SXL);
      }
      paramVarArgs.aY(99, this.SXM);
      AppMethodBeat.o(250077);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SXF == null) {
        break label832;
      }
    }
    label832:
    for (int i = g.a.a.a.oD(1, this.SXF.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SXG != null) {
        paramInt = i + g.a.a.a.oD(2, this.SXG.computeSize());
      }
      i = paramInt;
      if (this.SXH != null) {
        i = paramInt + g.a.a.a.oD(3, this.SXH.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.SXK != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SXK);
      }
      i = paramInt;
      if (this.SXL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SXL);
      }
      paramInt = g.a.a.b.b.a.bM(99, this.SXM);
      AppMethodBeat.o(250077);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250077);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bmw localbmw = (bmw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250077);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhp)localObject2).parseFrom((byte[])localObject1);
            }
            localbmw.SXF = ((fhp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250077);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhm)localObject2).parseFrom((byte[])localObject1);
            }
            localbmw.SXG = ((fhm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250077);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fho)localObject2).parseFrom((byte[])localObject1);
            }
            localbmw.SXH = ((fho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250077);
          return 0;
        case 4: 
          localbmw.SXI = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(250077);
          return 0;
        case 5: 
          localbmw.SXJ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(250077);
          return 0;
        case 6: 
          localbmw.SXK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250077);
          return 0;
        case 7: 
          localbmw.SXL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(250077);
          return 0;
        }
        localbmw.SXM = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(250077);
        return 0;
      }
      AppMethodBeat.o(250077);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmw
 * JD-Core Version:    0.7.0.1
 */