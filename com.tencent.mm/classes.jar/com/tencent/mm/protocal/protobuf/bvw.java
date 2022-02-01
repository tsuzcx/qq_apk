package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvw
  extends dyy
{
  public boolean Dlq;
  public String OzR;
  public String OzS;
  public String OzT;
  public String OzU;
  public String OzV;
  public String OzW;
  public String OzX;
  public LinkedList<cji> TfD;
  public boolean fEY;
  public int fwx;
  public String tVo;
  
  public bvw()
  {
    AppMethodBeat.i(72486);
    this.fwx = 0;
    this.tVo = "ok";
    this.TfD = new LinkedList();
    AppMethodBeat.o(72486);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72487);
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
      if (this.OzR != null) {
        paramVarArgs.f(4, this.OzR);
      }
      paramVarArgs.co(6, this.fEY);
      if (this.OzS != null) {
        paramVarArgs.f(7, this.OzS);
      }
      if (this.OzT != null) {
        paramVarArgs.f(8, this.OzT);
      }
      if (this.OzU != null) {
        paramVarArgs.f(9, this.OzU);
      }
      if (this.OzV != null) {
        paramVarArgs.f(10, this.OzV);
      }
      if (this.OzW != null) {
        paramVarArgs.f(11, this.OzW);
      }
      if (this.OzX != null) {
        paramVarArgs.f(12, this.OzX);
      }
      paramVarArgs.e(13, 8, this.TfD);
      paramVarArgs.co(14, this.Dlq);
      AppMethodBeat.o(72487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1086;
      }
    }
    label1086:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.OzR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.OzR);
      }
      i += g.a.a.b.b.a.gL(6) + 1;
      paramInt = i;
      if (this.OzS != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.OzS);
      }
      i = paramInt;
      if (this.OzT != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.OzT);
      }
      paramInt = i;
      if (this.OzU != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.OzU);
      }
      i = paramInt;
      if (this.OzV != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.OzV);
      }
      paramInt = i;
      if (this.OzW != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.OzW);
      }
      i = paramInt;
      if (this.OzX != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.OzX);
      }
      paramInt = g.a.a.a.c(13, 8, this.TfD);
      int j = g.a.a.b.b.a.gL(14);
      AppMethodBeat.o(72487);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvw localbvw = (bvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(72487);
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
            localbvw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        case 2: 
          localbvw.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72487);
          return 0;
        case 3: 
          localbvw.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 4: 
          localbvw.OzR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 6: 
          localbvw.fEY = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(72487);
          return 0;
        case 7: 
          localbvw.OzS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 8: 
          localbvw.OzT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 9: 
          localbvw.OzU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 10: 
          localbvw.OzV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 11: 
          localbvw.OzW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 12: 
          localbvw.OzX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72487);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cji();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cji)localObject2).parseFrom((byte[])localObject1);
            }
            localbvw.TfD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72487);
          return 0;
        }
        localbvw.Dlq = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(72487);
        return 0;
      }
      AppMethodBeat.o(72487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvw
 * JD-Core Version:    0.7.0.1
 */