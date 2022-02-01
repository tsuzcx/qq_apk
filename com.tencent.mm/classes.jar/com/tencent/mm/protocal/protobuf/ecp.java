package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecp
  extends dyy
{
  public String CMD;
  public int CNg;
  public int TuP;
  public String Uhf;
  public String Uhg;
  public String Uhh;
  public String UserName;
  public String rWI;
  public int rWt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CNg);
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      if (this.Uhf != null) {
        paramVarArgs.f(4, this.Uhf);
      }
      paramVarArgs.aY(5, this.TuP);
      if (this.Uhg != null) {
        paramVarArgs.f(6, this.Uhg);
      }
      if (this.rWI != null) {
        paramVarArgs.f(7, this.rWI);
      }
      if (this.CMD != null) {
        paramVarArgs.f(8, this.CMD);
      }
      if (this.Uhh != null) {
        paramVarArgs.f(9, this.Uhh);
      }
      paramVarArgs.aY(10, this.rWt);
      AppMethodBeat.o(222542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label792;
      }
    }
    label792:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CNg);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UserName);
      }
      i = paramInt;
      if (this.Uhf != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Uhf);
      }
      i += g.a.a.b.b.a.bM(5, this.TuP);
      paramInt = i;
      if (this.Uhg != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uhg);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.rWI);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CMD);
      }
      i = paramInt;
      if (this.Uhh != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Uhh);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.rWt);
      AppMethodBeat.o(222542);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(222542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ecp localecp = (ecp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(222542);
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
            localecp.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(222542);
          return 0;
        case 2: 
          localecp.CNg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(222542);
          return 0;
        case 3: 
          localecp.UserName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        case 4: 
          localecp.Uhf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        case 5: 
          localecp.TuP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(222542);
          return 0;
        case 6: 
          localecp.Uhg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        case 7: 
          localecp.rWI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        case 8: 
          localecp.CMD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        case 9: 
          localecp.Uhh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222542);
          return 0;
        }
        localecp.rWt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(222542);
        return 0;
      }
      AppMethodBeat.o(222542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecp
 * JD-Core Version:    0.7.0.1
 */