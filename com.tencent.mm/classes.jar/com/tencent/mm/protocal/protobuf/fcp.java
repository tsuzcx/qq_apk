package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fcp
  extends dyl
{
  public eae Hnc;
  public int RLs;
  public int RLv;
  public int Sat;
  public int UCo;
  public int UCp;
  public LinkedList<eaf> UCq;
  public LinkedList<eae> UCr;
  public String UserName;
  public String UxY;
  public int UxZ;
  public int Uya;
  public int lVs;
  
  public fcp()
  {
    AppMethodBeat.i(148663);
    this.UCq = new LinkedList();
    this.UCr = new LinkedList();
    AppMethodBeat.o(148663);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148664);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.Hnc != null)
      {
        paramVarArgs.oE(3, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.Sat);
      if (this.UxY != null) {
        paramVarArgs.f(5, this.UxY);
      }
      paramVarArgs.aY(6, this.lVs);
      paramVarArgs.aY(7, this.UxZ);
      paramVarArgs.aY(8, this.RLv);
      paramVarArgs.aY(9, this.Uya);
      paramVarArgs.aY(10, this.RLs);
      paramVarArgs.aY(11, this.UCo);
      paramVarArgs.aY(12, this.UCp);
      paramVarArgs.e(13, 8, this.UCq);
      paramVarArgs.e(14, 8, this.UCr);
      AppMethodBeat.o(148664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1210;
      }
    }
    label1210:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.Hnc != null) {
        i = paramInt + g.a.a.a.oD(3, this.Hnc.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.Sat);
      paramInt = i;
      if (this.UxY != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UxY);
      }
      i = g.a.a.b.b.a.bM(6, this.lVs);
      int j = g.a.a.b.b.a.bM(7, this.UxZ);
      int k = g.a.a.b.b.a.bM(8, this.RLv);
      int m = g.a.a.b.b.a.bM(9, this.Uya);
      int n = g.a.a.b.b.a.bM(10, this.RLs);
      int i1 = g.a.a.b.b.a.bM(11, this.UCo);
      int i2 = g.a.a.b.b.a.bM(12, this.UCp);
      int i3 = g.a.a.a.c(13, 8, this.UCq);
      int i4 = g.a.a.a.c(14, 8, this.UCr);
      AppMethodBeat.o(148664);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCq.clear();
        this.UCr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148664);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcp localfcp = (fcp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148664);
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
            localfcp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 2: 
          localfcp.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfcp.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        case 4: 
          localfcp.Sat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 5: 
          localfcp.UxY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(148664);
          return 0;
        case 6: 
          localfcp.lVs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 7: 
          localfcp.UxZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 8: 
          localfcp.RLv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 9: 
          localfcp.Uya = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 10: 
          localfcp.RLs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 11: 
          localfcp.UCo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 12: 
          localfcp.UCp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(148664);
          return 0;
        case 13: 
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
            localfcp.UCq.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148664);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localfcp.UCr.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(148664);
        return 0;
      }
      AppMethodBeat.o(148664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcp
 * JD-Core Version:    0.7.0.1
 */