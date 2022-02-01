package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebw
  extends com.tencent.mm.cd.a
{
  public LinkedList<ebx> Crs;
  public String UgN;
  public int UgO;
  public String UgP;
  public String UgQ;
  public int UgR;
  public String fwr;
  public String rWI;
  
  public ebw()
  {
    AppMethodBeat.i(211977);
    this.Crs = new LinkedList();
    AppMethodBeat.o(211977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211979);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.UgN != null) {
        paramVarArgs.f(2, this.UgN);
      }
      paramVarArgs.aY(3, this.UgO);
      if (this.rWI != null) {
        paramVarArgs.f(4, this.rWI);
      }
      if (this.UgP != null) {
        paramVarArgs.f(5, this.UgP);
      }
      if (this.UgQ != null) {
        paramVarArgs.f(6, this.UgQ);
      }
      paramVarArgs.aY(7, this.UgR);
      paramVarArgs.e(8, 8, this.Crs);
      AppMethodBeat.o(211979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UgN != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UgN);
      }
      i += g.a.a.b.b.a.bM(3, this.UgO);
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWI);
      }
      i = paramInt;
      if (this.UgP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UgP);
      }
      paramInt = i;
      if (this.UgQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UgQ);
      }
      i = g.a.a.b.b.a.bM(7, this.UgR);
      int j = g.a.a.a.c(8, 8, this.Crs);
      AppMethodBeat.o(211979);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Crs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ebw localebw = (ebw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211979);
          return -1;
        case 1: 
          localebw.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 2: 
          localebw.UgN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 3: 
          localebw.UgO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(211979);
          return 0;
        case 4: 
          localebw.rWI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 5: 
          localebw.UgP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 6: 
          localebw.UgQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(211979);
          return 0;
        case 7: 
          localebw.UgR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(211979);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ebx localebx = new ebx();
          if ((localObject != null) && (localObject.length > 0)) {
            localebx.parseFrom((byte[])localObject);
          }
          localebw.Crs.add(localebx);
          paramInt += 1;
        }
        AppMethodBeat.o(211979);
        return 0;
      }
      AppMethodBeat.o(211979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebw
 * JD-Core Version:    0.7.0.1
 */