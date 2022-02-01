package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wt
  extends dyy
{
  public String InV;
  public String SiM;
  public String SiN;
  public String SiO;
  public String Sjb;
  public int amount;
  public String fHb;
  public int fwx;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
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
      if (this.fHb != null) {
        paramVarArgs.f(4, this.fHb);
      }
      if (this.SiO != null) {
        paramVarArgs.f(5, this.SiO);
      }
      if (this.InV != null) {
        paramVarArgs.f(6, this.InV);
      }
      paramVarArgs.aY(7, this.amount);
      if (this.Sjb != null) {
        paramVarArgs.f(8, this.Sjb);
      }
      if (this.SiN != null) {
        paramVarArgs.f(9, this.SiN);
      }
      if (this.SiM != null) {
        paramVarArgs.f(10, this.SiM);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label856;
      }
    }
    label856:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.fHb != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.fHb);
      }
      paramInt = i;
      if (this.SiO != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SiO);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.InV);
      }
      i += g.a.a.b.b.a.bM(7, this.amount);
      paramInt = i;
      if (this.Sjb != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Sjb);
      }
      i = paramInt;
      if (this.SiN != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SiN);
      }
      paramInt = i;
      if (this.SiM != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SiM);
      }
      AppMethodBeat.o(72438);
      return paramInt;
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
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wt localwt = (wt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
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
            localwt.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localwt.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localwt.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localwt.fHb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localwt.SiO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localwt.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localwt.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localwt.Sjb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localwt.SiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localwt.SiM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wt
 * JD-Core Version:    0.7.0.1
 */