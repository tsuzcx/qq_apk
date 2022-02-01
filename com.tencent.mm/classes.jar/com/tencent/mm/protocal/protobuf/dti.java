package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dti
  extends com.tencent.mm.cd.a
{
  public LinkedList<Integer> TZD;
  public String TZE;
  public String appid;
  public int auth_type;
  public String gaC;
  public int status;
  
  public dti()
  {
    AppMethodBeat.i(238918);
    this.TZD = new LinkedList();
    AppMethodBeat.o(238918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(238923);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.e(2, 2, this.TZD);
      paramVarArgs.aY(3, this.auth_type);
      if (this.TZE != null) {
        paramVarArgs.f(4, this.TZE);
      }
      if (this.gaC != null) {
        paramVarArgs.f(5, this.gaC);
      }
      paramVarArgs.aY(100, this.status);
      AppMethodBeat.o(238923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label505;
      }
    }
    label505:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 2, this.TZD) + g.a.a.b.b.a.bM(3, this.auth_type);
      paramInt = i;
      if (this.TZE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TZE);
      }
      i = paramInt;
      if (this.gaC != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.gaC);
      }
      paramInt = g.a.a.b.b.a.bM(100, this.status);
      AppMethodBeat.o(238923);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TZD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(238923);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dti localdti = (dti)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(238923);
          return -1;
        case 1: 
          localdti.appid = locala.abFh.readString();
          AppMethodBeat.o(238923);
          return 0;
        case 2: 
          localdti.TZD.add(Integer.valueOf(locala.abFh.AK()));
          AppMethodBeat.o(238923);
          return 0;
        case 3: 
          localdti.auth_type = locala.abFh.AK();
          AppMethodBeat.o(238923);
          return 0;
        case 4: 
          localdti.TZE = locala.abFh.readString();
          AppMethodBeat.o(238923);
          return 0;
        case 5: 
          localdti.gaC = locala.abFh.readString();
          AppMethodBeat.o(238923);
          return 0;
        }
        localdti.status = locala.abFh.AK();
        AppMethodBeat.o(238923);
        return 0;
      }
      AppMethodBeat.o(238923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dti
 * JD-Core Version:    0.7.0.1
 */