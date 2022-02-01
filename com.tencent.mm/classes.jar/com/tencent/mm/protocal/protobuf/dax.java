package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dax
  extends com.tencent.mm.cd.a
{
  public bds GaB;
  public String SMU;
  public String TIm;
  public String TIr;
  public int TIs;
  public String ozs;
  public String ugh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(228133);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIm != null) {
        paramVarArgs.f(1, this.TIm);
      }
      if (this.SMU != null) {
        paramVarArgs.f(2, this.SMU);
      }
      if (this.ozs != null) {
        paramVarArgs.f(3, this.ozs);
      }
      if (this.ugh != null) {
        paramVarArgs.f(4, this.ugh);
      }
      if (this.TIr != null) {
        paramVarArgs.f(5, this.TIr);
      }
      paramVarArgs.aY(6, this.TIs);
      if (this.GaB != null)
      {
        paramVarArgs.oE(7, this.GaB.computeSize());
        this.GaB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(228133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIm == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.b.b.a.g(1, this.TIm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SMU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SMU);
      }
      i = paramInt;
      if (this.ozs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ozs);
      }
      paramInt = i;
      if (this.ugh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ugh);
      }
      i = paramInt;
      if (this.TIr != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TIr);
      }
      i += g.a.a.b.b.a.bM(6, this.TIs);
      paramInt = i;
      if (this.GaB != null) {
        paramInt = i + g.a.a.a.oD(7, this.GaB.computeSize());
      }
      AppMethodBeat.o(228133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(228133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dax localdax = (dax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(228133);
          return -1;
        case 1: 
          localdax.TIm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228133);
          return 0;
        case 2: 
          localdax.SMU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228133);
          return 0;
        case 3: 
          localdax.ozs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228133);
          return 0;
        case 4: 
          localdax.ugh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228133);
          return 0;
        case 5: 
          localdax.TIr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228133);
          return 0;
        case 6: 
          localdax.TIs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(228133);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bds localbds = new bds();
          if ((localObject != null) && (localObject.length > 0)) {
            localbds.parseFrom((byte[])localObject);
          }
          localdax.GaB = localbds;
          paramInt += 1;
        }
        AppMethodBeat.o(228133);
        return 0;
      }
      AppMethodBeat.o(228133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dax
 * JD-Core Version:    0.7.0.1
 */