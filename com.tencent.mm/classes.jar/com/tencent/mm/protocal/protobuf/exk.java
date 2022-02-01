package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exk
  extends dyl
{
  public String UfZ;
  public int UoL;
  public int UxE;
  public int UxF;
  public String UxG;
  public int UxH;
  public String UxI;
  public LinkedList<emf> UxJ;
  public int UxK;
  public int UxL;
  public String fzB;
  public String fzF;
  public String lnp;
  
  public exk()
  {
    AppMethodBeat.i(116818);
    this.UxJ = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fzB != null) {
        paramVarArgs.f(2, this.fzB);
      }
      if (this.fzF != null) {
        paramVarArgs.f(3, this.fzF);
      }
      paramVarArgs.aY(4, this.UxE);
      paramVarArgs.aY(5, this.UxF);
      paramVarArgs.aY(6, this.UoL);
      if (this.UxG != null) {
        paramVarArgs.f(7, this.UxG);
      }
      if (this.UfZ != null) {
        paramVarArgs.f(8, this.UfZ);
      }
      if (this.lnp != null) {
        paramVarArgs.f(9, this.lnp);
      }
      paramVarArgs.aY(10, this.UxH);
      if (this.UxI != null) {
        paramVarArgs.f(11, this.UxI);
      }
      paramVarArgs.e(12, 8, this.UxJ);
      paramVarArgs.aY(13, this.UxK);
      paramVarArgs.aY(14, this.UxL);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fzB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fzB);
      }
      i = paramInt;
      if (this.fzF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fzF);
      }
      i = i + g.a.a.b.b.a.bM(4, this.UxE) + g.a.a.b.b.a.bM(5, this.UxF) + g.a.a.b.b.a.bM(6, this.UoL);
      paramInt = i;
      if (this.UxG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UxG);
      }
      i = paramInt;
      if (this.UfZ != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.UfZ);
      }
      paramInt = i;
      if (this.lnp != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.lnp);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.UxH);
      paramInt = i;
      if (this.UxI != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UxI);
      }
      i = g.a.a.a.c(12, 8, this.UxJ);
      int j = g.a.a.b.b.a.bM(13, this.UxK);
      int k = g.a.a.b.b.a.bM(14, this.UxL);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UxJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exk localexk = (exk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
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
            localexk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localexk.fzB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localexk.fzF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localexk.UxE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localexk.UxF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localexk.UoL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localexk.UxG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localexk.UfZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localexk.lnp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localexk.UxH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localexk.UxI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emf)localObject2).parseFrom((byte[])localObject1);
            }
            localexk.UxJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localexk.UxK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(116819);
          return 0;
        }
        localexk.UxL = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exk
 * JD-Core Version:    0.7.0.1
 */