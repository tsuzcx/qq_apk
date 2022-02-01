package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ffe
  extends dyl
{
  public int SsF;
  public long UCJ;
  public ffd UDE;
  public ffd UFK;
  public ffd UFL;
  public ffd UFM;
  public ffd UFN;
  public int UFO;
  public LinkedList<eaf> UFP;
  public LinkedList<eaf> UFQ;
  public LinkedList<eaf> UFR;
  public int UFS;
  public LinkedList<eaf> UFT;
  public int Ucd;
  
  public ffe()
  {
    AppMethodBeat.i(115921);
    this.UFP = new LinkedList();
    this.UFQ = new LinkedList();
    this.UFR = new LinkedList();
    this.UFT = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UDE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UDE != null)
      {
        paramVarArgs.oE(2, this.UDE.computeSize());
        this.UDE.writeFields(paramVarArgs);
      }
      if (this.UFK != null)
      {
        paramVarArgs.oE(3, this.UFK.computeSize());
        this.UFK.writeFields(paramVarArgs);
      }
      if (this.UFL != null)
      {
        paramVarArgs.oE(4, this.UFL.computeSize());
        this.UFL.writeFields(paramVarArgs);
      }
      if (this.UFM != null)
      {
        paramVarArgs.oE(5, this.UFM.computeSize());
        this.UFM.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.UCJ);
      if (this.UFN != null)
      {
        paramVarArgs.oE(7, this.UFN.computeSize());
        this.UFN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.UFO);
      paramVarArgs.e(9, 8, this.UFP);
      paramVarArgs.aY(10, this.SsF);
      paramVarArgs.e(11, 8, this.UFQ);
      paramVarArgs.aY(12, this.Ucd);
      paramVarArgs.e(13, 8, this.UFR);
      paramVarArgs.aY(14, this.UFS);
      paramVarArgs.e(15, 8, this.UFT);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1722;
      }
    }
    label1722:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UDE != null) {
        paramInt = i + g.a.a.a.oD(2, this.UDE.computeSize());
      }
      i = paramInt;
      if (this.UFK != null) {
        i = paramInt + g.a.a.a.oD(3, this.UFK.computeSize());
      }
      paramInt = i;
      if (this.UFL != null) {
        paramInt = i + g.a.a.a.oD(4, this.UFL.computeSize());
      }
      i = paramInt;
      if (this.UFM != null) {
        i = paramInt + g.a.a.a.oD(5, this.UFM.computeSize());
      }
      i += g.a.a.b.b.a.p(6, this.UCJ);
      paramInt = i;
      if (this.UFN != null) {
        paramInt = i + g.a.a.a.oD(7, this.UFN.computeSize());
      }
      i = g.a.a.b.b.a.bM(8, this.UFO);
      int j = g.a.a.a.c(9, 8, this.UFP);
      int k = g.a.a.b.b.a.bM(10, this.SsF);
      int m = g.a.a.a.c(11, 8, this.UFQ);
      int n = g.a.a.b.b.a.bM(12, this.Ucd);
      int i1 = g.a.a.a.c(13, 8, this.UFR);
      int i2 = g.a.a.b.b.a.bM(14, this.UFS);
      int i3 = g.a.a.a.c(15, 8, this.UFT);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UFP.clear();
        this.UFQ.clear();
        this.UFR.clear();
        this.UFT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UDE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ffe localffe = (ffe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
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
            localffe.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localffe.UDE = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localffe.UFK = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localffe.UFL = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localffe.UFM = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localffe.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localffe.UFN = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localffe.UFO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
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
            localffe.UFP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localffe.SsF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115922);
          return 0;
        case 11: 
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
            localffe.UFQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localffe.Ucd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115922);
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
            localffe.UFR.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localffe.UFS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115922);
          return 0;
        }
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
          localffe.UFT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      AppMethodBeat.o(115922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffe
 * JD-Core Version:    0.7.0.1
 */