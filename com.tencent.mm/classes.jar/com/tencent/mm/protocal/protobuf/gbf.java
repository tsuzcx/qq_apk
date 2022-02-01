package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gbf
  extends erp
{
  public long ZvA;
  public int Zvz;
  public int abWV;
  public LinkedList<dtl> abWW;
  public int abZu;
  public int abZv;
  public LinkedList<gbi> abZw;
  public int abZx;
  public int abZy;
  public int abZz;
  public int abna;
  
  public gbf()
  {
    AppMethodBeat.i(115905);
    this.abZw = new LinkedList();
    this.abWW = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abna);
      paramVarArgs.bS(5, this.abZu);
      paramVarArgs.bS(6, this.abZv);
      paramVarArgs.e(7, 8, this.abZw);
      paramVarArgs.bS(8, this.abZx);
      paramVarArgs.bS(9, this.abWV);
      paramVarArgs.e(10, 8, this.abWW);
      paramVarArgs.bS(11, this.abZy);
      paramVarArgs.bS(12, this.abZz);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label952;
      }
    }
    label952:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvz);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.b.b.a.cJ(4, this.abna);
      int m = i.a.a.b.b.a.cJ(5, this.abZu);
      int n = i.a.a.b.b.a.cJ(6, this.abZv);
      int i1 = i.a.a.a.c(7, 8, this.abZw);
      int i2 = i.a.a.b.b.a.cJ(8, this.abZx);
      int i3 = i.a.a.b.b.a.cJ(9, this.abWV);
      int i4 = i.a.a.a.c(10, 8, this.abWW);
      int i5 = i.a.a.b.b.a.cJ(11, this.abZy);
      int i6 = i.a.a.b.b.a.cJ(12, this.abZz);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abZw.clear();
        this.abWW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbf localgbf = (gbf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localgbf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localgbf.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localgbf.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localgbf.abna = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localgbf.abZu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localgbf.abZv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbi)localObject2).parseFrom((byte[])localObject1);
            }
            localgbf.abZw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localgbf.abZx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localgbf.abWV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtl)localObject2).parseFrom((byte[])localObject1);
            }
            localgbf.abWW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localgbf.abZy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115906);
          return 0;
        }
        localgbf.abZz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbf
 * JD-Core Version:    0.7.0.1
 */