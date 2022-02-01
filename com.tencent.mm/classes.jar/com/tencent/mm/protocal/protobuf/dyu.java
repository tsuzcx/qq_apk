package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyu
  extends com.tencent.mm.cd.a
{
  public int HlG;
  public String MD5;
  public int UeB;
  public int UeC;
  public LinkedList<eik> UeD;
  public com.tencent.mm.cd.b UeE;
  public String UeF;
  public String Url;
  
  public dyu()
  {
    AppMethodBeat.i(152670);
    this.UeD = new LinkedList();
    AppMethodBeat.o(152670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.UeF == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.f(1, this.MD5);
      }
      paramVarArgs.aY(2, this.UeB);
      if (this.Url != null) {
        paramVarArgs.f(3, this.Url);
      }
      paramVarArgs.aY(4, this.UeC);
      paramVarArgs.e(5, 8, this.UeD);
      if (this.UeE != null) {
        paramVarArgs.c(6, this.UeE);
      }
      if (this.UeF != null) {
        paramVarArgs.f(7, this.UeF);
      }
      paramVarArgs.aY(8, this.HlG);
      AppMethodBeat.o(152671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label796;
      }
    }
    label796:
    for (paramInt = g.a.a.b.b.a.g(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UeB);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.UeC) + g.a.a.a.c(5, 8, this.UeD);
      paramInt = i;
      if (this.UeE != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.UeE);
      }
      i = paramInt;
      if (this.UeF != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UeF);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.HlG);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UeD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.UeF == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dyu localdyu = (dyu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localdyu.MD5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localdyu.UeB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localdyu.Url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localdyu.UeC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eik localeik = new eik();
            if ((localObject != null) && (localObject.length > 0)) {
              localeik.parseFrom((byte[])localObject);
            }
            localdyu.UeD.add(localeik);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localdyu.UeE = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localdyu.UeF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localdyu.HlG = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyu
 * JD-Core Version:    0.7.0.1
 */