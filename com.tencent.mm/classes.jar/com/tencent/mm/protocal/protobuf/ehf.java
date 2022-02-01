package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehf
  extends dyl
{
  public eml REA;
  public String Tcj;
  public int UjE;
  public ehz UjF;
  public int fUN;
  public String jEx;
  public LinkedList<ehh> lpz;
  
  public ehf()
  {
    AppMethodBeat.i(114070);
    this.lpz = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UjE);
      paramVarArgs.e(3, 8, this.lpz);
      if (this.jEx != null) {
        paramVarArgs.f(4, this.jEx);
      }
      if (this.Tcj != null) {
        paramVarArgs.f(5, this.Tcj);
      }
      if (this.UjF != null)
      {
        paramVarArgs.oE(6, this.UjF.computeSize());
        this.UjF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.fUN);
      if (this.REA != null)
      {
        paramVarArgs.oE(8, this.REA.computeSize());
        this.REA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UjE) + g.a.a.a.c(3, 8, this.lpz);
      paramInt = i;
      if (this.jEx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jEx);
      }
      i = paramInt;
      if (this.Tcj != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Tcj);
      }
      paramInt = i;
      if (this.UjF != null) {
        paramInt = i + g.a.a.a.oD(6, this.UjF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.fUN);
      paramInt = i;
      if (this.REA != null) {
        paramInt = i + g.a.a.a.oD(8, this.REA.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehf localehf = (ehf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localehf.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localehf.UjE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehh)localObject2).parseFrom((byte[])localObject1);
            }
            localehf.lpz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localehf.jEx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localehf.Tcj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehz)localObject2).parseFrom((byte[])localObject1);
            }
            localehf.UjF = ((ehz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localehf.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114071);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eml();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eml)localObject2).parseFrom((byte[])localObject1);
          }
          localehf.REA = ((eml)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehf
 * JD-Core Version:    0.7.0.1
 */