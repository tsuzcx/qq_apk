package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yl
  extends dyl
{
  public int CPw;
  public String CRQ;
  public String CSe;
  public int Cqs;
  public int Skw;
  public LinkedList<eaf> Skx;
  public String Sky;
  public String Skz;
  public String jUi;
  
  public yl()
  {
    AppMethodBeat.i(124468);
    this.Skx = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Cqs);
      if (this.CRQ != null) {
        paramVarArgs.f(3, this.CRQ);
      }
      if (this.CSe != null) {
        paramVarArgs.f(4, this.CSe);
      }
      if (this.jUi != null) {
        paramVarArgs.f(5, this.jUi);
      }
      paramVarArgs.aY(6, this.Skw);
      paramVarArgs.e(7, 8, this.Skx);
      if (this.Sky != null) {
        paramVarArgs.f(8, this.Sky);
      }
      if (this.Skz != null) {
        paramVarArgs.f(9, this.Skz);
      }
      paramVarArgs.aY(10, this.CPw);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Cqs);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CRQ);
      }
      i = paramInt;
      if (this.CSe != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CSe);
      }
      paramInt = i;
      if (this.jUi != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.jUi);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Skw) + g.a.a.a.c(7, 8, this.Skx);
      paramInt = i;
      if (this.Sky != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Sky);
      }
      i = paramInt;
      if (this.Skz != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Skz);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.CPw);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Skx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yl localyl = (yl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
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
            localyl.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localyl.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localyl.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localyl.CSe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localyl.jUi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localyl.Skw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
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
            localyl.Skx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localyl.Sky = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localyl.Skz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localyl.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yl
 * JD-Core Version:    0.7.0.1
 */