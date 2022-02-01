package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ffb
  extends dyl
{
  public int SmH;
  public int Svu;
  public int Uon;
  public int Uoo;
  public int Uop;
  public int Uoq;
  public int Uor;
  public LinkedList<Integer> Uos;
  public int Uot;
  public int Uou;
  public LinkedList<Integer> Uov;
  public int Uow;
  public int Uox;
  
  public ffb()
  {
    AppMethodBeat.i(115916);
    this.Uos = new LinkedList();
    this.Uov = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.aY(3, this.Uon);
      paramVarArgs.aY(4, this.SmH);
      paramVarArgs.aY(5, this.Uoo);
      paramVarArgs.aY(6, this.Uop);
      paramVarArgs.aY(7, this.Uoq);
      paramVarArgs.aY(8, this.Uor);
      paramVarArgs.f(9, 2, this.Uos);
      paramVarArgs.aY(10, this.Uot);
      paramVarArgs.aY(11, this.Uou);
      paramVarArgs.f(12, 2, this.Uov);
      paramVarArgs.aY(13, this.Uow);
      paramVarArgs.aY(14, this.Uox);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Svu);
      int j = g.a.a.b.b.a.bM(3, this.Uon);
      int k = g.a.a.b.b.a.bM(4, this.SmH);
      int m = g.a.a.b.b.a.bM(5, this.Uoo);
      int n = g.a.a.b.b.a.bM(6, this.Uop);
      int i1 = g.a.a.b.b.a.bM(7, this.Uoq);
      int i2 = g.a.a.b.b.a.bM(8, this.Uor);
      int i3 = g.a.a.a.d(9, 2, this.Uos);
      int i4 = g.a.a.b.b.a.bM(10, this.Uot);
      int i5 = g.a.a.b.b.a.bM(11, this.Uou);
      int i6 = g.a.a.a.d(12, 2, this.Uov);
      int i7 = g.a.a.b.b.a.bM(13, this.Uow);
      int i8 = g.a.a.b.b.a.bM(14, this.Uox);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uos.clear();
        this.Uov.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ffb localffb = (ffb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localffb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localffb.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localffb.Uon = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localffb.SmH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localffb.Uoo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localffb.Uop = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localffb.Uoq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localffb.Uor = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localffb.Uos = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localffb.Uot = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localffb.Uou = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localffb.Uov = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localffb.Uow = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115917);
          return 0;
        }
        localffb.Uox = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffb
 * JD-Core Version:    0.7.0.1
 */