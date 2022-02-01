package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class th
  extends dyy
{
  public String CRQ;
  public String CRR;
  public int CreateTime;
  public long HlH;
  public String RII;
  public String RNi;
  public String ScK;
  public String ScV;
  public int Sda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ScK != null) {
        paramVarArgs.f(3, this.ScK);
      }
      if (this.CRR != null) {
        paramVarArgs.f(4, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(5, this.CRQ);
      }
      paramVarArgs.aY(9, this.CreateTime);
      paramVarArgs.bm(10, this.HlH);
      if (this.ScV != null) {
        paramVarArgs.f(11, this.ScV);
      }
      if (this.RNi != null) {
        paramVarArgs.f(12, this.RNi);
      }
      if (this.RII != null) {
        paramVarArgs.f(13, this.RII);
      }
      paramVarArgs.aY(14, this.Sda);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label856;
      }
    }
    label856:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ScK != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ScK);
      }
      i = paramInt;
      if (this.CRR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.CRR);
      }
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.CRQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.CreateTime) + g.a.a.b.b.a.p(10, this.HlH);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ScV);
      }
      i = paramInt;
      if (this.RNi != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RNi);
      }
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RII);
      }
      i = g.a.a.b.b.a.bM(14, this.Sda);
      AppMethodBeat.o(152512);
      return paramInt + i;
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        th localth = (th)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
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
            localth.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localth.ScK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localth.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localth.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localth.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localth.HlH = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localth.ScV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localth.RNi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localth.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localth.Sda = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.th
 * JD-Core Version:    0.7.0.1
 */