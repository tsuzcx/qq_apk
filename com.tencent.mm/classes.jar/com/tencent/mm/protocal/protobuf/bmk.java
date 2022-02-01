package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bmk
  extends dyy
{
  public String EBW;
  public String EtJ;
  public String EyY;
  public int Ezj;
  public String Ezw;
  public boolean SXl = false;
  public int fwx = 0;
  public int gbo;
  public int gbp;
  public int gbq;
  public String tVo = "ok";
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275524);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(275524);
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
      if (this.ybP != null) {
        paramVarArgs.f(4, this.ybP);
      }
      if (this.EtJ != null) {
        paramVarArgs.f(5, this.EtJ);
      }
      paramVarArgs.aY(6, this.Ezj);
      paramVarArgs.aY(7, this.gbq);
      paramVarArgs.aY(8, this.gbp);
      if (this.EyY != null) {
        paramVarArgs.f(9, this.EyY);
      }
      paramVarArgs.aY(10, this.gbo);
      if (this.Ezw != null) {
        paramVarArgs.f(11, this.Ezw);
      }
      if (this.EBW != null) {
        paramVarArgs.f(12, this.EBW);
      }
      paramVarArgs.co(13, this.SXl);
      AppMethodBeat.o(275524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label972;
      }
    }
    label972:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ybP);
      }
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.EtJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Ezj) + g.a.a.b.b.a.bM(7, this.gbq) + g.a.a.b.b.a.bM(8, this.gbp);
      paramInt = i;
      if (this.EyY != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.EyY);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.gbo);
      paramInt = i;
      if (this.Ezw != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Ezw);
      }
      i = paramInt;
      if (this.EBW != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.EBW);
      }
      paramInt = g.a.a.b.b.a.gL(13);
      AppMethodBeat.o(275524);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(275524);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmk localbmk = (bmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275524);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localbmk.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(275524);
          return 0;
        case 2: 
          localbmk.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(275524);
          return 0;
        case 3: 
          localbmk.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        case 4: 
          localbmk.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        case 5: 
          localbmk.EtJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        case 6: 
          localbmk.Ezj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(275524);
          return 0;
        case 7: 
          localbmk.gbq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(275524);
          return 0;
        case 8: 
          localbmk.gbp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(275524);
          return 0;
        case 9: 
          localbmk.EyY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        case 10: 
          localbmk.gbo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(275524);
          return 0;
        case 11: 
          localbmk.Ezw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        case 12: 
          localbmk.EBW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(275524);
          return 0;
        }
        localbmk.SXl = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(275524);
        return 0;
      }
      AppMethodBeat.o(275524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmk
 * JD-Core Version:    0.7.0.1
 */