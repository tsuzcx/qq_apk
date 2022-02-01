package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfa
  extends com.tencent.mm.cd.a
{
  public int EVJ;
  public int SGE;
  public int TMG;
  public dfb TMH;
  public int TMI;
  public int TMJ;
  public int TMK;
  public int Tij;
  public dfc Tik;
  public String app_id;
  public String mye;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mye != null) {
        paramVarArgs.f(1, this.mye);
      }
      paramVarArgs.aY(2, this.TMG);
      if (this.TMH != null)
      {
        paramVarArgs.oE(3, this.TMH.computeSize());
        this.TMH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Tij);
      if (this.Tik != null)
      {
        paramVarArgs.oE(5, this.Tik.computeSize());
        this.Tik.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.TMI);
      paramVarArgs.aY(7, this.TMJ);
      paramVarArgs.aY(8, this.EVJ);
      paramVarArgs.aY(9, this.TMK);
      if (this.app_id != null) {
        paramVarArgs.f(10, this.app_id);
      }
      paramVarArgs.aY(11, this.SGE);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mye == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = g.a.a.b.b.a.g(1, this.mye) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TMG);
      paramInt = i;
      if (this.TMH != null) {
        paramInt = i + g.a.a.a.oD(3, this.TMH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.Tij);
      paramInt = i;
      if (this.Tik != null) {
        paramInt = i + g.a.a.a.oD(5, this.Tik.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TMI) + g.a.a.b.b.a.bM(7, this.TMJ) + g.a.a.b.b.a.bM(8, this.EVJ) + g.a.a.b.b.a.bM(9, this.TMK);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.app_id);
      }
      i = g.a.a.b.b.a.bM(11, this.SGE);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfa localdfa = (dfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localdfa.mye = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localdfa.TMG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfb)localObject2).parseFrom((byte[])localObject1);
            }
            localdfa.TMH = ((dfb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localdfa.Tij = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfc)localObject2).parseFrom((byte[])localObject1);
            }
            localdfa.Tik = ((dfc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localdfa.TMI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localdfa.TMJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localdfa.EVJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localdfa.TMK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localdfa.app_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localdfa.SGE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfa
 * JD-Core Version:    0.7.0.1
 */