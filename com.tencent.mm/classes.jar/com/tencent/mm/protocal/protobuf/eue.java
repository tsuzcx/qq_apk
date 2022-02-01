package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eue
  extends dyy
{
  public String IiN;
  public String IiO;
  public int IiP;
  public int Inc;
  public dwg UvI;
  public String UvJ;
  public String UvK;
  public String UvL;
  public dwg UvT;
  public LinkedList<agp> UvU;
  public String UvV;
  public String UvW;
  public String UvX;
  public String tol;
  public int tqa;
  public String tqb;
  public String zaK;
  
  public eue()
  {
    AppMethodBeat.i(72598);
    this.UvU = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.IiP);
      if (this.UvT != null)
      {
        paramVarArgs.oE(5, this.UvT.computeSize());
        this.UvT.writeFields(paramVarArgs);
      }
      if (this.UvJ != null) {
        paramVarArgs.f(6, this.UvJ);
      }
      if (this.UvK != null) {
        paramVarArgs.f(7, this.UvK);
      }
      if (this.IiN != null) {
        paramVarArgs.f(8, this.IiN);
      }
      if (this.IiO != null) {
        paramVarArgs.f(9, this.IiO);
      }
      if (this.tol != null) {
        paramVarArgs.f(10, this.tol);
      }
      if (this.zaK != null) {
        paramVarArgs.f(11, this.zaK);
      }
      paramVarArgs.aY(12, this.Inc);
      paramVarArgs.e(13, 8, this.UvU);
      if (this.UvV != null) {
        paramVarArgs.f(14, this.UvV);
      }
      if (this.UvW != null) {
        paramVarArgs.f(15, this.UvW);
      }
      if (this.UvL != null) {
        paramVarArgs.f(16, this.UvL);
      }
      if (this.UvX != null) {
        paramVarArgs.f(17, this.UvX);
      }
      if (this.UvI != null)
      {
        paramVarArgs.oE(18, this.UvI.computeSize());
        this.UvI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.IiP);
      paramInt = i;
      if (this.UvT != null) {
        paramInt = i + g.a.a.a.oD(5, this.UvT.computeSize());
      }
      i = paramInt;
      if (this.UvJ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UvJ);
      }
      paramInt = i;
      if (this.UvK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UvK);
      }
      i = paramInt;
      if (this.IiN != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.IiN);
      }
      paramInt = i;
      if (this.IiO != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.IiO);
      }
      i = paramInt;
      if (this.tol != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.tol);
      }
      paramInt = i;
      if (this.zaK != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.zaK);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Inc) + g.a.a.a.c(13, 8, this.UvU);
      paramInt = i;
      if (this.UvV != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.UvV);
      }
      i = paramInt;
      if (this.UvW != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.UvW);
      }
      paramInt = i;
      if (this.UvL != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.UvL);
      }
      i = paramInt;
      if (this.UvX != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.UvX);
      }
      paramInt = i;
      if (this.UvI != null) {
        paramInt = i + g.a.a.a.oD(18, this.UvI.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UvU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eue localeue = (eue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localeue.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localeue.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localeue.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localeue.IiP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwg)localObject2).parseFrom((byte[])localObject1);
            }
            localeue.UvT = ((dwg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localeue.UvJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localeue.UvK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localeue.IiN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localeue.IiO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localeue.tol = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localeue.zaK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localeue.Inc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new agp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((agp)localObject2).parseFrom((byte[])localObject1);
            }
            localeue.UvU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localeue.UvV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localeue.UvW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localeue.UvL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localeue.UvX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwg)localObject2).parseFrom((byte[])localObject1);
          }
          localeue.UvI = ((dwg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eue
 * JD-Core Version:    0.7.0.1
 */