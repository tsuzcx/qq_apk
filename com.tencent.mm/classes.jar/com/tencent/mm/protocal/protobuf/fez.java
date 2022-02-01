package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fez
  extends dyl
{
  public double RVy;
  public double RVz;
  public int SmH;
  public int Svu;
  public long Svv;
  public LinkedList<elz> TfC;
  public long UFD;
  public eaf UFE;
  public eaf UFF;
  public int UFG;
  
  public fez()
  {
    AppMethodBeat.i(115913);
    this.TfC = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.UFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.UFD);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.SmH);
      if (this.UFE != null)
      {
        paramVarArgs.oE(5, this.UFE.computeSize());
        this.UFE.writeFields(paramVarArgs);
      }
      if (this.UFF != null)
      {
        paramVarArgs.oE(6, this.UFF.computeSize());
        this.UFF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.RVy);
      paramVarArgs.e(8, this.RVz);
      paramVarArgs.aY(9, this.Svu);
      paramVarArgs.aY(10, this.UFG);
      paramVarArgs.e(11, 8, this.TfC);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1096;
      }
    }
    label1096:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.UFD) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.SmH);
      paramInt = i;
      if (this.UFE != null) {
        paramInt = i + g.a.a.a.oD(5, this.UFE.computeSize());
      }
      i = paramInt;
      if (this.UFF != null) {
        i = paramInt + g.a.a.a.oD(6, this.UFF.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(7);
      int j = g.a.a.b.b.a.gL(8);
      int k = g.a.a.b.b.a.bM(9, this.Svu);
      int m = g.a.a.b.b.a.bM(10, this.UFG);
      int n = g.a.a.a.c(11, 8, this.TfC);
      AppMethodBeat.o(115914);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UFE == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.UFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fez localfez = (fez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfez.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localfez.UFD = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localfez.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localfez.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115914);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfez.UFE = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localfez.UFF = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localfez.RVy = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localfez.RVz = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localfez.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localfez.UFG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elz)localObject2).parseFrom((byte[])localObject1);
          }
          localfez.TfC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fez
 * JD-Core Version:    0.7.0.1
 */