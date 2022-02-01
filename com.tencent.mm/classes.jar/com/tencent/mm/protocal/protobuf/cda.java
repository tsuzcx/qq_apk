package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cda
  extends dyy
{
  public String EyC;
  public LinkedList<cjf> TkQ;
  public String TkR;
  public int TkS;
  public LinkedList<String> TkT;
  public int TkU;
  public long TkV;
  public int TkW;
  public String TkX;
  public int fwx;
  public String tVo;
  
  public cda()
  {
    AppMethodBeat.i(91512);
    this.fwx = 0;
    this.tVo = "ok";
    this.TkQ = new LinkedList();
    this.TkT = new LinkedList();
    AppMethodBeat.o(91512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91513);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      paramVarArgs.e(4, 8, this.TkQ);
      if (this.TkR != null) {
        paramVarArgs.f(5, this.TkR);
      }
      paramVarArgs.aY(6, this.TkS);
      if (this.EyC != null) {
        paramVarArgs.f(7, this.EyC);
      }
      paramVarArgs.e(8, 1, this.TkT);
      paramVarArgs.aY(9, this.TkU);
      paramVarArgs.bm(10, this.TkV);
      paramVarArgs.aY(11, this.TkW);
      if (this.TkX != null) {
        paramVarArgs.f(12, this.TkX);
      }
      AppMethodBeat.o(91513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label982;
      }
    }
    label982:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.TkQ);
      paramInt = i;
      if (this.TkR != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TkR);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TkS);
      paramInt = i;
      if (this.EyC != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.EyC);
      }
      i = paramInt + g.a.a.a.c(8, 1, this.TkT) + g.a.a.b.b.a.bM(9, this.TkU) + g.a.a.b.b.a.p(10, this.TkV) + g.a.a.b.b.a.bM(11, this.TkW);
      paramInt = i;
      if (this.TkX != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TkX);
      }
      AppMethodBeat.o(91513);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TkQ.clear();
        this.TkT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91513);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cda localcda = (cda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91513);
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
            localcda.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 2: 
          localcda.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91513);
          return 0;
        case 3: 
          localcda.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjf)localObject2).parseFrom((byte[])localObject1);
            }
            localcda.TkQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91513);
          return 0;
        case 5: 
          localcda.TkR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 6: 
          localcda.TkS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91513);
          return 0;
        case 7: 
          localcda.EyC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91513);
          return 0;
        case 8: 
          localcda.TkT.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91513);
          return 0;
        case 9: 
          localcda.TkU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91513);
          return 0;
        case 10: 
          localcda.TkV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91513);
          return 0;
        case 11: 
          localcda.TkW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91513);
          return 0;
        }
        localcda.TkX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91513);
        return 0;
      }
      AppMethodBeat.o(91513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cda
 * JD-Core Version:    0.7.0.1
 */