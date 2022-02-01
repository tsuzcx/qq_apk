package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyl
  extends dyy
{
  public int HlE;
  public long HlH;
  public String RII;
  public String RJQ;
  public String ScV;
  public int Sda;
  public int TDa;
  public int UyC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127181);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127181);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(2, this.RJQ);
      }
      paramVarArgs.aY(3, this.HlE);
      paramVarArgs.aY(4, this.TDa);
      paramVarArgs.aY(5, this.UyC);
      paramVarArgs.bm(6, this.HlH);
      if (this.ScV != null) {
        paramVarArgs.f(7, this.ScV);
      }
      if (this.RII != null) {
        paramVarArgs.f(8, this.RII);
      }
      paramVarArgs.aY(9, this.Sda);
      AppMethodBeat.o(127181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label740;
      }
    }
    label740:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RJQ);
      }
      i = i + g.a.a.b.b.a.bM(3, this.HlE) + g.a.a.b.b.a.bM(4, this.TDa) + g.a.a.b.b.a.bM(5, this.UyC) + g.a.a.b.b.a.p(6, this.HlH);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ScV);
      }
      i = paramInt;
      if (this.RII != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RII);
      }
      paramInt = g.a.a.b.b.a.bM(9, this.Sda);
      AppMethodBeat.o(127181);
      return i + paramInt;
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
          AppMethodBeat.o(127181);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127181);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eyl localeyl = (eyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127181);
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
            localeyl.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(127181);
          return 0;
        case 2: 
          localeyl.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 3: 
          localeyl.HlE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127181);
          return 0;
        case 4: 
          localeyl.TDa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127181);
          return 0;
        case 5: 
          localeyl.UyC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127181);
          return 0;
        case 6: 
          localeyl.HlH = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(127181);
          return 0;
        case 7: 
          localeyl.ScV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127181);
          return 0;
        case 8: 
          localeyl.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127181);
          return 0;
        }
        localeyl.Sda = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(127181);
        return 0;
      }
      AppMethodBeat.o(127181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyl
 * JD-Core Version:    0.7.0.1
 */